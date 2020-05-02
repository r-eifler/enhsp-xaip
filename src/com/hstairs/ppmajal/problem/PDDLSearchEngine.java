/*
 * Copyright (C) 2018 enrico.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package com.hstairs.ppmajal.problem;

import com.hstairs.ppmajal.expressions.NumEffect;
import com.hstairs.ppmajal.problem.EPddlProblem;
import com.hstairs.ppmajal.problem.PDDLState;
import com.hstairs.ppmajal.problem.State;
import com.hstairs.ppmajal.search.SearchEngine;
import com.hstairs.ppmajal.search.SearchNode;
import com.hstairs.ppmajal.search.SearchProblem;
import com.hstairs.ppmajal.search.SimpleSearchNode;
import com.hstairs.ppmajal.transition.ConditionalEffects;
import com.hstairs.ppmajal.transition.Transition;
import com.hstairs.ppmajal.transition.TransitionGround;
import it.unimi.dsi.fastutil.objects.Object2FloatMap;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import com.hstairs.ppmajal.search.SearchHeuristic;

/**
 * @author enrico
 */
public class PDDLSearchEngine extends SearchEngine {

    private final EPddlProblem problem;
    protected Collection<TransitionGround> reachableProcesses;
    protected Collection<TransitionGround> reachableEvents;

    public PDDLSearchEngine(SearchHeuristic h, EPddlProblem problem) {
        super(h);
        this.problem = problem;
    }
    @Override
    protected void printInfo(PrintStream out) {
            out.println("Reachable actions and processes: |A U P U E|:" + TransitionGround.totNumberOfTransitions);
    }

    public boolean validate(LinkedList<Pair<Float,Object>> userPlan, double stepSize) throws CloneNotSupportedException {
        return validate(userPlan,stepSize,null);
    }

    public boolean validate(LinkedList<Pair<Float,Object>> userPlan, double stepSize, String planTrace) throws CloneNotSupportedException {
        Float previous = 0.0F;
        State current = (PDDLState) problem.getInit();
        System.out.println("Plan under Validation: "+userPlan);
        StringBuilder planTraceString = null;
        if (planTrace != null){ planTraceString = new StringBuilder();}

        for (Pair<Float, Object> ele : userPlan) {
            final Float v = ele.getKey() - previous;
            if (v > 0) {
                final org.jgrapht.alg.util.Pair<State, Collection<TransitionGround>> stateCollectionPair = intelligentSimulation(current, problem, v, stepSize, false, planTraceString);
                if (stateCollectionPair == null) {
                    System.out.println("Constraint violated");
                    return false;
                } else {
                    current = stateCollectionPair.getFirst();
                }
            }
            previous = ele.getKey();
            TransitionGround right = (TransitionGround) ele.getRight();
            if (ele.getRight() != null && !right.getSemantics().equals(Transition.Semantics.PROCESS)) {
                current.apply(right, current.clone());
                if (planTrace != null){planTraceString.append(current.toString()).append("\n");}
            }
        }
        if (planTrace!=null) {
            try {
                BufferedWriter bf = new BufferedWriter(new FileWriter(planTrace));
                bf.append(planTraceString);
                bf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        System.out.println(current);
        return current.satisfy(problem.goals);
    }

    @Override
    public LinkedList<Pair<Float,TransitionGround>> extractPlan (SimpleSearchNode input) {

        LinkedList<Pair<Float,TransitionGround>> plan = new LinkedList<>();
        lastState = input.s;
        if (!(input instanceof SearchNode)) {
            SimpleSearchNode temp = input;
            while (temp.transition != null) {
                Double time = null;
                plan.addFirst(Pair.of(0f,(TransitionGround)temp.transition));
                temp = temp.father;
            }
            return plan;
        }

        SearchNode c = (SearchNode) input;
        if (problem.getProcessesSet().isEmpty()) {
            while ((c.transition != null || c.list_of_actions != null)) {
                Double time = null;
                if (c.father != null && c.father.s instanceof PDDLState) {
                    time = ((PDDLState) c.father.s).time;
                }
                if (c.transition != null) {//this is an action
                    if (c.transition instanceof ImmutablePair) {
                        final ImmutablePair<TransitionGround, Integer> t = (ImmutablePair<TransitionGround, Integer>) c.transition;
                        for (int i = 0; i < t.right; i++) {
                            plan.addFirst(Pair.of(time.floatValue(), t.left));
                        }
                        System.out.println("JUMP for " + t.left + ":" + t.right);
                    } else {
                        plan.addFirst(Pair.of(time.floatValue(), (TransitionGround) c.transition));
                    }
                }
                c = (SearchNode) c.father;

            }
        }else {
            float time = 0f;
            System.out.println("Extracting plan with execution delta: "+executionDelta);
            float endTime = (float) ((PDDLState)c.s).time;
            while ((c.transition != null || c.list_of_actions != null)) {
                if (c.transition != null){
                    // This is an action
                    plan.addFirst(Pair.of((float)((PDDLState)c.s).time, (TransitionGround) c.transition));
                }else{
                    TransitionGround waiting = new TransitionGround(new ArrayList<>(),"------>waiting",new ConditionalEffects(ConditionalEffects.VariableType.PROPEFFECT),new ConditionalEffects(ConditionalEffects.VariableType.NUMEFFECT),null, Transition.Semantics.PROCESS);
                    plan.addFirst(Pair.of((float)((PDDLState)c.s).time, waiting));
                }
                c = (SearchNode) c.father;
            }
//            LinkedList<Pair<Float,TransitionGround>> newPlan = new LinkedList<>();
//
//            Pair<Float,TransitionGround> waitingTransition = null;
//            for (Pair<Float, TransitionGround> ele : plan) {
//                final TransitionGround transition = ele.getRight();
//                if (transition.getSemantics() == Transition.Semantics.PROCESS){
//                    time+=ele.getKey();
//                    waitingTransition = Pair.of(time,transition);
//                }else{
//                    if (waitingTransition != null) {
//                        newPlan.add(waitingTransition);
//                    }
//                    newPlan.add(Pair.of(time,ele.getRight()));
//                    waitingTransition = null;
//                }
//            }
//            if (waitingTransition != null){
//                final Pair<Float, TransitionGround> of = Pair.of(endTime, waitingTransition.getRight());
//                newPlan.add(of);
//            }
            return plan;
        }

        return plan;
    }

    @Override
    protected void advanceTime(Object frontier, SearchNode current_node, SearchProblem generingProblem, Object2FloatMap<State> g) {

        EPddlProblem problem = (EPddlProblem)generingProblem;
        if (reachableEvents == null) {
            reachableEvents = problem.getEventsSet();
        }
        if (reachableProcesses == null) {
            reachableProcesses = problem.getProcessesSet();
        }
        final org.jgrapht.alg.util.Pair<State, Collection<TransitionGround>> stateCollectionPair = intelligentSimulation(current_node.s, problem, planningDelta, executionDelta, true);
        if (stateCollectionPair != null) {
            queueSuccessor(frontier, stateCollectionPair.getFirst(), current_node, stateCollectionPair.getSecond(), g);//this could be done in a smarter way
        }
    }
        
         protected org.jgrapht.alg.util.Pair<State, Collection<TransitionGround>> intelligentSimulation(State s, EPddlProblem problem, double horizon, double executionDelta, boolean intelligent) {
        return intelligentSimulation(s, problem, horizon, executionDelta, intelligent, null);
    }

    protected org.jgrapht.alg.util.Pair<State, Collection<TransitionGround>> intelligentSimulation(State s, EPddlProblem problem, double horizon, double executionDelta, boolean intelligent, StringBuilder traceString) {
        if (reachableEvents == null) {
            reachableEvents = problem.getEventsSet();
        }
        if (reachableProcesses == null) {
            reachableProcesses = problem.getProcessesSet();
        }

        final PDDLState next = (PDDLState) s.clone();
        if (horizon < executionDelta) {
            System.out.println("Horizon: " + horizon + " Execution Delta: " + executionDelta);
            throw new RuntimeException("Delta simulation should be higher than delta execution");
        }
        if (notDiv(horizon, executionDelta)) {
            System.out.println("Horizon: " + horizon + " Execution Delta: " + executionDelta);
            System.out.println("WARNING: Delta simulation should be a multiple of delta execution");
        }
        final int iterations = (int) Math.ceil(horizon / executionDelta);
        PDDLState previousNext = next;
        final ArrayList<TransitionGround> executedProcesses = new ArrayList<>();
        for (int i = 0; i < iterations; i++) {
            boolean atLeastOne = false;
            final ArrayList<NumEffect> numEffect = new ArrayList();
            for (final TransitionGround act : this.reachableProcesses) {
                if (act.getSemantics() == Transition.Semantics.PROCESS) {
                    TransitionGround gp = (TransitionGround) act;
                    if (gp.isApplicable(next)) {
                        atLeastOne = true;
                        for (NumEffect eff : (Collection<NumEffect>) gp.getConditionalNumericEffects().getAllEffects()) {
                            numEffect.add(eff);
                        }
                    }
                } else {
                    throw new RuntimeException("This shouldn't happen, "+act.getName()+" is not a process?");
                }
            }
            if (!atLeastOne) {
                if (i == 0) {
                    return null;
                }
                return new org.jgrapht.alg.util.Pair(previousNext, executedProcesses);
            }
            //execute
            executedProcesses.addAll(applyAllEvents(next));
            final TransitionGround waiting = new TransitionGround(numEffect);
            next.apply(waiting, next.clone());
            next.time += executionDelta;
            if (!next.satisfy(problem.globalConstraints)) {
                if (i == 0 || !intelligent) {
                    return null;
                }
                return new org.jgrapht.alg.util.Pair(previousNext, executedProcesses);
            }
            if (traceString != null) {
                traceString.append(next.toString()).append("\n");
            }
            executedProcesses.add(waiting);
            executedProcesses.addAll(applyAllEvents(next));
            if (intelligent && next.satisfy(problem.goals)) {
                return new org.jgrapht.alg.util.Pair(next, executedProcesses);
            }
            previousNext = next;
        }
        return new org.jgrapht.alg.util.Pair(previousNext, executedProcesses);
    }

    private boolean notDiv(double horizon, double executionDelta) {
        final double v = Math.IEEEremainder(horizon, executionDelta);
        return v >= Double.MIN_VALUE;
    }
    
        private ArrayList<TransitionGround> applyAllEvents(State s) {
        final ArrayList<TransitionGround> ret = new ArrayList<>();
        while (true) {
            boolean at_least_one = false;
            for (final TransitionGround ev : this.reachableEvents) {

                if (ev.isApplicable(s)) {
                    at_least_one = true;
                    s.apply(ev, s.clone());
                    ret.add(ev);
                }
            }
            if (!at_least_one) {
                return ret;
            }
        }

    }

}

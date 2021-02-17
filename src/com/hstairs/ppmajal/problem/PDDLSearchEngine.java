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
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author enrico
 */
public class PDDLSearchEngine extends SearchEngine {

    private final EPddlProblem problem;
    protected Collection<TransitionGround> reachableProcesses;
    protected Collection<TransitionGround> reachableEvents;
    
    //This is a hack!
    private HashMap<Float,TransitionGround> triggeredEvents;

    public PDDLSearchEngine(SearchHeuristic h, EPddlProblem problem) {
        super(h);
        this.problem = problem;
    }
    @Override
    protected void printInfo(PrintStream out) {
            //out.println("Reachable actions and processes: |A U P U E|:" + TransitionGround.totNumberOfTransitions);
    }

    public boolean validate(List<Pair<BigDecimal,Object>> userPlan,BigDecimal execDelta, BigDecimal stepSize) throws CloneNotSupportedException {
        return validate(userPlan, execDelta,stepSize,null);
    }

    public boolean validate(List<Pair<BigDecimal,Object>> internalPlanRepresentation,BigDecimal execDelta, BigDecimal stepSize, String planTrace) throws CloneNotSupportedException {
        BigDecimal previous = BigDecimal.ZERO;
        State current = (PDDLState) problem.getInit();
        System.out.println("Plan under Validation: "+internalPlanRepresentation);
        StringBuilder planTraceString = null;
        if (planTrace != null){ 
            planTraceString = new StringBuilder();
            planTraceString.append(current.toString()).append("\n");
        }

        Pair<BigDecimal, Object> lastEle = null;
        for (Pair<BigDecimal, Object> ele : internalPlanRepresentation) {
            TransitionGround right = (TransitionGround) ele.getRight();
            if (right.getSemantics().equals(Transition.Semantics.PROCESS)) {
                final org.jgrapht.alg.util.Pair<State, Collection<TransitionGround>> stateCollectionPair
                        = simulation(current, problem, execDelta, stepSize, false, planTraceString);
                if (stateCollectionPair == null) {
                    System.out.println("Constraint violated");
                    return false;
                } else {
                    current = stateCollectionPair.getFirst();
                }
                lastEle = ele;
            }
            previous = ele.getKey();
            if (ele.getRight() != null && !right.getSemantics().equals(Transition.Semantics.PROCESS)) {
                current.apply(right, current.clone());
                if (planTrace != null) {
                    planTraceString.append(current.toString()).append("\n");
                }
            }
        }
        if (planTrace != null) {
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
    public LinkedList<Pair<BigDecimal,TransitionGround>> extractPlan (SimpleSearchNode input) {

        LinkedList<Pair<BigDecimal,TransitionGround>> plan = new LinkedList<>();
        lastState = input.s;
        if (!(input instanceof SearchNode)) {
            SimpleSearchNode temp = input;
            while (temp.transition != null) {
                Double time = null;
                plan.addFirst(Pair.of(BigDecimal.ZERO,(TransitionGround)temp.transition));
                temp = temp.father;
            }
            return plan;
        }
        
        SearchNode c = (SearchNode) input;
        if (problem.getProcessesSet().isEmpty()) {
            while ((c.transition != null || c.list_of_actions != null)) {
                BigDecimal time = null;
                if (c.father != null && c.father.s instanceof PDDLState) {
                    time = ((PDDLState) c.father.s).time;
                }
                if (c.transition != null) {//this is an action
                    if (c.transition instanceof ImmutablePair) {
                        final ImmutablePair<TransitionGround, Integer> t = (ImmutablePair<TransitionGround, Integer>) c.transition;
                        for (int i = 0; i < t.right; i++) {
                            plan.addFirst(Pair.of(time, t.left));
                        }
                        System.out.println("JUMP for " + t.left + ":" + t.right);
                    } else {
                        plan.addFirst(Pair.of(time, (TransitionGround) c.transition));
                    }
                }
                c = (SearchNode) c.father;

            }
        }else {
            triggeredEvents = new HashMap();
            System.out.println("Extracting plan with execution delta: "+executionDelta);
            BigDecimal time = ((PDDLState)c.s).time;
            TransitionGround waiting = new TransitionGround(new ArrayList<>(),"------>waiting",new ConditionalEffects(ConditionalEffects.VariableType.PROPEFFECT),new ConditionalEffects(ConditionalEffects.VariableType.NUMEFFECT),null, Transition.Semantics.PROCESS);
            while ((c.transition != null || c.list_of_actions != null)) {
                if (c.transition != null){
                    // This is an action
                    plan.addFirst(Pair.of(((PDDLState)c.s).time, (TransitionGround) c.transition));
                }else{
                    //c is the next state actually. Be careful!!
                    ArrayList arrayList = new ArrayList(c.list_of_actions);
                    Collections.reverse(arrayList);
                    for (final Object o: arrayList ){
                        TransitionGround t = (TransitionGround)o;
                        if (t.getSemantics() == TransitionGround.Semantics.PROCESS){
                            time = time.subtract(executionDelta);
                            plan.addFirst(Pair.of(time, waiting));
                        }else{
                            plan.addFirst(Pair.of(time,t));
                        }
                    }
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

    protected org.jgrapht.alg.util.Pair<State, Collection<TransitionGround>> intelligentSimulation(State s, EPddlProblem problem, BigDecimal horizon, BigDecimal executionDelta, boolean intelligent) {
        return simulation(s, problem, horizon, executionDelta, intelligent, null);
    }


    protected org.jgrapht.alg.util.Pair<State, Collection<TransitionGround>> simulation(State s, EPddlProblem problem, BigDecimal horizon, BigDecimal executionDelta, boolean intelligent, StringBuilder traceString) {
        if (reachableEvents == null) {
            reachableEvents = problem.getEventsSet();
        }
        if (reachableProcesses == null) {
            reachableProcesses = problem.getProcessesSet();
        }
//        if (!intelligent){
//            if (Math.abs(horizon-executionDelta) < 0.0001){
//                horizon = executionDelta;
//            }
//        }
        final PDDLState next = (PDDLState) s.clone();
        if (horizon.compareTo(executionDelta) == -1) {
            System.out.println("Horizon: " + horizon + " Execution Delta: " + executionDelta);
            throw new RuntimeException("Planning Delta should be higher than delta execution");
        }
        if (horizon.remainder(executionDelta).compareTo(BigDecimal.ZERO) != 0) {
            System.out.println(horizon.remainder(executionDelta));
            System.out.println("Horizon: " + horizon + " Execution Delta: " + executionDelta);
            System.out.println("WARNING: Planning delta should be a multiple of delta execution");
        }
//        final int iterations = (int) Math.ceil(horizon / executionDelta);
        final int iterations = horizon.divideToIntegralValue(executionDelta).intValue();
        PDDLState previousNext = next;
        final ArrayList<TransitionGround> executedProcesses = new ArrayList<>();
        executedProcesses.addAll(applyAllEvents(next));
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
            final TransitionGround waiting = new TransitionGround(numEffect);
            next.apply(waiting, next.clone());
            next.time = next.time.add(executionDelta);
//            next.time += executionDelta.floatValue();
//            next.time = round2((float)next.time,4);
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

    public List<PDDLState> simulate(List<Pair<BigDecimal, TransitionGround>> timedPlan, String delta, PDDLState s, EPddlProblem problem, boolean fullStates) {
        BigDecimal previous = BigDecimal.ZERO;
        final BigDecimal deltaDecimal = new BigDecimal(delta);
        final ArrayList<PDDLState> res = new ArrayList();
        res.add(s.clone());
        int planSize = timedPlan.size();
        for (final var v: timedPlan){    
            final BigDecimal timeAction = v.getKey();
            final BigDecimal subtract = timeAction.subtract(previous);
            if (subtract.compareTo(BigDecimal.ZERO) > 0){
                if (fullStates){
                    final int intValue = subtract.divideToIntegralValue(deltaDecimal).intValue();
                    for (int i = 0; i< intValue; i++){
                        final org.jgrapht.alg.util.Pair<State, Collection<TransitionGround>> simulatedState = this.simulation(s, problem, deltaDecimal, deltaDecimal, false, null);
                        if (simulatedState == null){
                            throw new RuntimeException("Global constraints are not satisfied starting from "+s);
                        }
                        s = (PDDLState) simulatedState.getFirst();
                        res.add(s.clone());
                    }
                }else{
                    final org.jgrapht.alg.util.Pair<State, Collection<TransitionGround>> simulatedState = this.simulation(s, problem, subtract, deltaDecimal, false, null);
                    if (simulatedState == null){
                        throw new RuntimeException("Global constraints are not satisfied starting from "+s);
                    }
                    s = (PDDLState) simulatedState.getFirst();
                    res.add(s.clone());
                }
            }
            previous = timeAction;
            if (planSize > 1){
                if (v.getValue().isApplicable(s)){
                    s.apply(v.getValue(), s);
                    res.add(s.clone());
                }else{
                    throw new RuntimeException(v.getValue()+" is not applicable at time "+timeAction);
                }
            }
            planSize--;
        }
        return res;
    }

}

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
package com.hstairs.ppmajal.search;

import com.hstairs.ppmajal.heuristics.Heuristic;
import com.hstairs.ppmajal.problem.EPddlProblem;
import com.hstairs.ppmajal.problem.PDDLState;
import com.hstairs.ppmajal.problem.State;
import com.hstairs.ppmajal.transition.ConditionalEffects;
import com.hstairs.ppmajal.transition.Transition;
import com.hstairs.ppmajal.transition.TransitionGround;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

/**
 * @author enrico
 */
public class PDDLSearchEngine extends SearchEngine {

    private final EPddlProblem problem;

    public PDDLSearchEngine(Heuristic h, EPddlProblem problem) {
        super(h);
        this.problem = problem;
    }


    public boolean validate(LinkedList<Pair<Double,TransitionGround>> userPlan, double stepSize) throws CloneNotSupportedException {
        Double previous = 0.0D;
        State current = (PDDLState) problem.getInit();
        System.out.println("Plan under Validation: "+userPlan);

        for (Pair<Double, TransitionGround> ele : userPlan) {
            final double v = ele.getKey() - previous;
            if (v > 0) {
                final com.hstairs.ppmajal.extraUtils.Pair<State, Collection<TransitionGround>> stateCollectionPair = intelligentSimulation(current, problem, v, stepSize, false);
                if (stateCollectionPair == null) {
                    System.out.println("Constraint violated");
                    return false;
                } else {
                    current = stateCollectionPair.getFirst();
                }
            }
            previous = ele.getKey();
            if (ele.getRight() != null && !ele.getRight().isWaiting()) {
                current.apply(ele.getRight(), current.clone());
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
            System.out.println("Extracting plan with execution delta:"+executionDelta);
            float endTime = (float) ((PDDLState)c.s).time;
            while ((c.transition != null || c.list_of_actions != null)) {
                if (c.transition != null){
                    // This is an action
                    plan.addFirst(Pair.of((float)((PDDLState)c.s).time, (TransitionGround) c.transition));
                }else{
//                    int numberOfWaits = 0;
//                    for (int k = c.list_of_actions.size() - 1; k >= 0; k--) {
//                        final TransitionGround o = (TransitionGround) c.list_of_actions.get(k);
//                        if (o.getSemantics() == Transition.Semantics.PROCESS){
//                            numberOfWaits += 1;
//                        }
//                    }
//                    System.out.println("First (from the tail) number of waitings:"+numberOfWaits);
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


}

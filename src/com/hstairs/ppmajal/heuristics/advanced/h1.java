/*
 * Copyright (C) 2010-2017 Enrico Scala. Contact: enricos83@gmail.com.
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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hstairs.ppmajal.heuristics.advanced;

import com.google.common.collect.Sets;
import com.hstairs.ppmajal.conditions.*;
import com.hstairs.ppmajal.expressions.ExtendedAddendum;
import com.hstairs.ppmajal.expressions.ExtendedNormExpression;
import com.hstairs.ppmajal.expressions.NumEffect;
import com.hstairs.ppmajal.heuristics.Heuristic;
import com.hstairs.ppmajal.problem.EPddlProblem;
import com.hstairs.ppmajal.problem.State;
import com.hstairs.ppmajal.transition.Transition;
import com.hstairs.ppmajal.transition.TransitionGround;
import it.unimi.dsi.fastutil.ints.IntComparator;
import org.apache.commons.lang3.tuple.Pair;
import org.jgrapht.util.FibonacciHeap;
import org.jgrapht.util.FibonacciHeapNode;

import java.util.*;

import static com.google.common.collect.Sets.SetView;

/**
 * @author enrico
 */
public class h1 implements Heuristic {

    final private boolean useRedundantConstraints;
    final public boolean extractRelaxedPlan;

    final private int pseudoGoal;
    final private Condition[] preconditionFunction;
    final private Collection<Terminal>[] propEffectFunction;
    final private Collection<NumEffect>[] numericEffectFunction;
    final private int heuristicNumberOfActions;
    final private int totNumberOfTerms;
    final private EPddlProblem problem;
    private final Collection[] possibleAchievers;
    private final Collection[] conditionToAction;
    private final HashSet<Terminal> allConditions;
    private final Collection<Comparison> allComparisons;
    private final FibonacciHeapNode[] nodeOf;

    private float[] actionCost;
    private float[] actionHCost;
    private float[] conditionCost;

    private final boolean additive;
    private boolean[] closed;
    private Map<Pair<Integer,Integer>,Float> numericContribution;

    public h1(EPddlProblem problem){
        this(problem,true);
    }
    public h1(EPddlProblem problem, boolean additive) {
        this.additive = additive;
        this.problem = problem;
        this.useRedundantConstraints = false;
        extractRelaxedPlan = true;
        pseudoGoal = Transition.totNumberOfTransitions;
        heuristicNumberOfActions = Transition.totNumberOfTransitions+1;
        allComparisons = new ArrayList<>();

        preconditionFunction = new Condition[heuristicNumberOfActions];
        propEffectFunction = new Collection[heuristicNumberOfActions];
        numericEffectFunction = new Collection[heuristicNumberOfActions];

        actionCost = new float[heuristicNumberOfActions];
        Arrays.fill(actionCost,Float.MAX_VALUE);

        SetView<TransitionGround> transitions = Sets.union(Sets.union(new HashSet(problem.actions), problem.getEventsSet()),problem.getProcessesSet());
        for (TransitionGround b : transitions) {
            if (useRedundantConstraints) {
                preconditionFunction[b.getId()] = b.getPreconditions().transformEquality().introduce_red_constraints();
            }else{
                preconditionFunction[b.getId()] = b.getPreconditions().transformEquality();
            }
            propEffectFunction[b.getId()] = b.getAllAchievableLiterals();
            numericEffectFunction[b.getId()] = b.getConditionalNumericEffects().getAllEffects();
            for (NumEffect neff : numericEffectFunction[b.getId()]){
                neff.normalize();
            }
            actionCost[b.getId()] = b.getActionCost(problem.getInit(),problem.getMetric());
        }
        if (useRedundantConstraints){
            preconditionFunction[pseudoGoal] = problem.getGoals().transformEquality().introduce_red_constraints();
        }else {
            preconditionFunction[pseudoGoal] = problem.getGoals().transformEquality();
        }

        totNumberOfTerms = Terminal.getTotCounter();
        possibleAchievers = new Collection[heuristicNumberOfActions];
        conditionToAction = new Collection[totNumberOfTerms];
        allConditions = new HashSet();

        nodeOf = new FibonacciHeapNode[heuristicNumberOfActions];

        for (TransitionGround b : transitions) {
            final int i = b.getId();
            updatePreconditionFunction(i);
        }
        updatePreconditionFunction(pseudoGoal);
    }

    void updatePreconditionFunction(int i){
        final Collection<Condition> terminalConditions = preconditionFunction[i].getTerminalConditionsInArray();
        for (Condition c : terminalConditions) {
            if (c instanceof  Terminal ) {
                Terminal t = (Terminal)c;
                Collection<Integer> groundActions = conditionToAction[((Terminal) c).getId()];
                if (groundActions == null) {
                    groundActions = new HashSet<>();
                }
                groundActions.add(i);
                conditionToAction[t.getId()] = groundActions;
                allConditions.add((Terminal) c);
                if (c instanceof Comparison){
                    if (!allComparisons.contains(c)){
                        allComparisons.add((Comparison) c.normalize());
                    }
                }
            }
        }
    }


    void updateActions(final Terminal c, final FibonacciHeap p) {
        final Collection<Integer> actions = conditionToAction[c.getId()];
        if (actions != null) {
            for (final int i : actions) {
                if (!closed[i]) {
                    final float v = estimateCost(preconditionFunction[i]);
                    if (v < Float.MAX_VALUE) {
                        if (v < actionHCost[i]){
                            if (actionHCost[i] == Float.MAX_VALUE){
                                actionHCost[i] = v;
                                final FibonacciHeapNode fibonacciHeapNode = new FibonacciHeapNode(i);
                                p.insert(fibonacciHeapNode,v);
                            }else{
                                actionHCost[i] = v;
                                p.decreaseKey(nodeOf[i],v);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public float computeEstimate (State gs) {
        actionHCost = new float[heuristicNumberOfActions];
        Arrays.fill(actionHCost,Float.MAX_VALUE);
        conditionCost = new float[totNumberOfTerms];
        Arrays.fill(conditionCost,Float.MAX_VALUE);
        closed = new boolean[heuristicNumberOfActions];
        Arrays.fill(closed,false);

        FibonacciHeap h = new FibonacciHeap();

        for (Terminal c: allConditions){
            if (gs.satisfy(c)){
                conditionCost[c.getId()] = 0f;
                updateActions(c,h);
            }
        }

        while(!h.isEmpty()){
            final int actionId = (int) h.removeMin().getData();
            if (actionId == pseudoGoal){
                return actionHCost[pseudoGoal];
            }
            closed[actionId] = true;
            expand(actionId,h,gs);
        }
        return Float.MAX_VALUE;

    }

    private void expand(int actionId, FibonacciHeap p, State s) {

        Collection<Terminal> achiavable = possibleAchievers[actionId];
        if (achiavable == null){
            achiavable = new HashSet<>();
            for (final Comparison t : allComparisons){
                if (this.numericContribution(actionId, t) > 0){
                    achiavable.add(t);
                }
            }
            achiavable.addAll(propEffectFunction[actionId]);
            possibleAchievers[actionId] = achiavable;
            achiavable = new ArrayList<>(achiavable);
        }
        for (final Terminal t: achiavable){//This is for all terminal
            if (conditionCost[t.getId()]  != 0) {
                if (t instanceof Predicate || t instanceof NotCond) {//affecting a prop variable
                    if (updateIfNeeded(t,actionHCost[actionId] + actionCost[actionId])) {
                        updateActions(t, p);
                    }
                } else {//affecting a num comparison
                    final double v = this.numericContribution(actionId, (Comparison) t);
                    final float newCost = (float)(-1f*((Comparison) t).getLeft().eval(s)/v);
                    if (updateIfNeeded(t,actionHCost[actionId] + newCost)) {
                        updateActions(t, p);
                    }
                }
            }
        }

    }

    boolean updateIfNeeded(final Terminal t, final float value){
        if (conditionCost[t.getId()] > value) {
            conditionCost[t.getId()] = value;
            return true;
        }
        return false;
    }

    float estimateCost (final Condition c) {
        if (c instanceof AndCond) {
            final AndCond and = (AndCond) c;
            if (and.sons == null) {
                return 0f;
            }
            float ret = 0f;
            for (final Condition son : (Collection<Condition>) and.sons) {
                final float estimate = estimateCost(son);
                if (estimate == Float.MAX_VALUE) {
                    return Float.MAX_VALUE;
                }
                if (additive){// && !this.extractRelaxedPlan) {
                    ret += estimate;
                } else {
                    ret = (estimate > ret) ? estimate : ret;
                }
            }
            return ret;

        } else if (c instanceof OrCond) {
            final OrCond and = (OrCond) c;
            if (and.sons == null) {
                return 0f;
            }
            float ret = Float.MAX_VALUE;
            for (final Condition son : (Collection<Condition>) and.sons) {
                final float estimate = estimateCost(son);
                if (estimate != Float.MAX_VALUE) {
                    ret = (estimate < ret) ? estimate : ret;
                }
            }
            return ret;
        } else if (c instanceof Terminal) {
            final Terminal t = (Terminal) c;
            return conditionCost[t.getId()];
        } else {
            return 0f;
        }
    }



    public class GroundActionComparator implements IntComparator{
         @Override
        public int compare(int o1, int o2) {
            if (actionHCost[o1] < actionHCost[o2]){
                return -1;
            }else if (actionHCost[o1] > actionHCost[o2]){
                return 1;
            }else{
                return 0;
            }
        }
    
    }

    //Semantics: -1 don't know because comp is hard. > 0 is achiever, 0 no
    float numericContribution(int t, Comparison comp) {
        if (numericContribution == null){
            numericContribution = new HashMap<>();
        }
        Float positiveness = numericContribution.get(Pair.of(t, comp.getId()));
        if (positiveness == null) {
            positiveness = 0f;
            if (numericEffectFunction[t].isEmpty()) {
                numericContribution.put(Pair.of(t, comp.getId()),0f);
                return positiveness;
            }
            if (comp.getLeft() instanceof ExtendedNormExpression) {
                ExtendedNormExpression left = (ExtendedNormExpression) comp.getLeft();
                for (ExtendedAddendum ad : left.summations) {
                    if (ad.f != null) {
                        for (final NumEffect ne : numericEffectFunction[t]) {
                            if (!ne.getFluentAffected().equals(ad.f)) {
                                continue;
                            }
                            if (ne.getInvolvedNumericFluents().isEmpty()) {
                                ExtendedNormExpression rhs = (ExtendedNormExpression) ne.getRight();
                                if (!rhs.linear) {
                                    return -1;
                                }
                                if (ne.getOperator().equals("increase")) {
                                    positiveness += rhs.getNumber().floatValue() * ad.n.floatValue();
                                } else if (ne.getOperator().equals("decrease")) {
                                    positiveness += (-1) * rhs.getNumber().floatValue() * ad.n.floatValue();
                                } else if (ne.getOperator().equals("assign")) {
                                    numericContribution.put(Pair.of(t,comp.getId()),-1f);
                                    return -1;
                                }
                            } else {
                                numericContribution.put(Pair.of(t,comp.getId()),0f);
                                return 0;
                            }
                        }
                    }
                }
                numericContribution.put(Pair.of(t,comp.getId()),positiveness);
                return positiveness;
            } else {
                throw new RuntimeException("At the moment only normalized expressions are considered " + comp);
            }
        }
        return positiveness;
    }
}

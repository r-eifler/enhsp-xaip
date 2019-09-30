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
import com.hstairs.ppmajal.transition.ConditionalEffects;
import com.hstairs.ppmajal.transition.Transition;
import com.hstairs.ppmajal.transition.TransitionGround;
import it.unimi.dsi.fastutil.ints.IntArraySet;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
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
    final private Collection[] propEffectFunction;
    final private Collection<NumEffect>[] numericEffectFunction;
    final private int heuristicNumberOfActions;
    final private int totNumberOfTerms;
    final private EPddlProblem problem;
    final private boolean helpfulActionsComputation;
    private final IntArraySet[] possibleAchievers;
    private final IntArraySet[] conditionToAction;
    private final IntArraySet allConditions;
    private final IntArraySet allComparisons;
    private final FibonacciHeapNode[] nodeOf;
    private final boolean reachability;

    private float[] actionCost;
    private float[] actionHCost;
    private float[] conditionCost;

    private final boolean additive;
    private boolean[] closed;
    private Map<Pair<Integer,Integer>,Float> numericContribution;
    private IntArraySet[] achievers;
    private int[] establishedAchiever;
    private float[] numRepetition;
    private IntArraySet helpfulActions;
    private IntArraySet reachableTransitions;
    private Collection<TransitionGround> reachableTransitionsInstances;

    public h1(EPddlProblem problem){
        this(problem,true,false,false,false);
    }
    public h1(EPddlProblem problem, boolean additive, boolean extractRelaxedPlan, boolean helpfulActionsComputation,boolean reachability) {
        this.additive = additive;
        this.problem = problem;
        this.reachability = reachability;
        this.helpfulActionsComputation = helpfulActionsComputation;
        this.useRedundantConstraints = false;
        this.extractRelaxedPlan = extractRelaxedPlan;
        pseudoGoal = Transition.totNumberOfTransitions;
        heuristicNumberOfActions = Transition.totNumberOfTransitions+1;
        allComparisons = new IntArraySet();
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
            final IntArraySet propositional = new IntArraySet();
            for (Terminal t: b.getAllAchievableLiterals()){
                propositional.add(t.getId());
            }
            propEffectFunction[b.getId()] = propositional;
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
        possibleAchievers = new IntArraySet[heuristicNumberOfActions];
        conditionToAction = new IntArraySet[totNumberOfTerms];
        allConditions = new IntArraySet();

        nodeOf = new FibonacciHeapNode[heuristicNumberOfActions];

        for (final TransitionGround b : transitions) {
            final int i = b.getId();
            updatePreconditionFunction(i);
        }
        updatePreconditionFunction(pseudoGoal);
    }

    void updatePreconditionFunction(int i){
        final Collection<Condition> terminalConditions = preconditionFunction[i].getTerminalConditionsInArray();
        for (final Condition c : terminalConditions) {
            if (c instanceof  Terminal ) {
                Terminal t = (Terminal)c;
                IntArraySet groundActions = conditionToAction[((Terminal) c).getId()];
                if (groundActions == null) {
                    groundActions = new IntArraySet();
                }
                groundActions.add(i);
                conditionToAction[t.getId()] = groundActions;
                allConditions.add(((Terminal) c).getId());
                if (c instanceof Comparison){
                        allComparisons.add(((Comparison)c.normalize()).getId());
                }
            }
        }
    }


    void updateActions(final int c, final FibonacciHeap p) {
        final IntArraySet actions = conditionToAction[c];
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
        if (reachableTransitions== null) {
            reachableTransitions = new IntArraySet();
        }
        for (final int i: allConditions){
            if (gs.satisfy(Terminal.getTerminal(i))){
                conditionCost[i] = 0f;
                updateActions(i,h);
            }
        }

        while(!h.isEmpty()){
            final int actionId = (int) h.removeMin().getData();
            if (actionId == pseudoGoal && reachableTransitionsInstances != null){
                if (extractRelaxedPlan){
                    return relaxedPlanCost();
                }
                return actionHCost[pseudoGoal];
            }
            if (reachableTransitionsInstances == null && actionId != pseudoGoal){
                reachableTransitions.add(actionId);
            }
            closed[actionId] = true;
            if (actionId != pseudoGoal) {
                expand(actionId, h, gs);
            }
        }
        if (reachableTransitionsInstances == null) {
            getTransitions(false);
        }
        return actionHCost[pseudoGoal];

    }

    private float relaxedPlanCost() {
        final Condition goal =  preconditionFunction[pseudoGoal];

        final ObjectArrayList stack = new ObjectArrayList();
        stack.push(getActivatingConditions(goal));
        LinkedList<Pair<Integer,Float>> plan = new LinkedList();
        Collection<Integer> allGoals = new IntArraySet();
        boolean[] visited = new boolean[totNumberOfTerms];
        Arrays.fill(visited,false);
        helpfulActions = new IntArraySet();

        while (!stack.isEmpty()){
            final Pair<Collection<Integer>,Float> elements = (Pair<Collection<Integer>, Float>) stack.pop();
            allGoals.addAll(elements.getKey());
            for (final int conditionId: elements.getLeft()){
                if (!visited[conditionId]) {
                    if (conditionCost[conditionId] != 0) {
                        final int actionId = establishedAchiever[conditionId];
                        boolean inserted = false;
                        for (int i = plan.size() - 1; i >= 0; i--) {
                            if (plan.get(i).getLeft() == actionId) {
                                Pair<Integer, Float> newValue = Pair.of(actionId, Math.max(numRepetition[conditionId], plan.get(i).getRight()));
                                plan.set(i, newValue);
                                inserted = true;
                                break;
                            }
                        }
                        if (!inserted) {
                            if (helpfulActionsComputation){
                                for (int id: achievers[conditionId]){
                                    if (actionHCost[id] == 0){
                                        helpfulActions.add(id);
                                    }
                                }
                            }
                            plan.addFirst(Pair.of(actionId, numRepetition[conditionId] * actionCost[actionId]));
                            stack.push(getActivatingConditions(preconditionFunction[actionId]));
                        }
                    }
                    visited[conditionId] = true;
                }
            }
        }
        float ret = 0;
        for (Pair<Integer,Float> action : plan){
            ret+= action.getRight();
        }
        return ret;
    }

    private void expand(int actionId, FibonacciHeap p, State s) {

        IntArraySet achievableTerms = possibleAchievers[actionId];
        if (achievableTerms == null){
            achievableTerms = new IntArraySet();
            for (final int t : allComparisons){
                if (this.numericContribution(actionId, (Comparison) Terminal.getTerminal(t)) > 0){
                    achievableTerms.add(t);
                }
            }
            achievableTerms.addAll(propEffectFunction[actionId]);
            possibleAchievers[actionId] = achievableTerms;
        }
        for (final int conditionId: achievableTerms){//This is for all terminal
            if (conditionCost[conditionId]  != 0) {
                updateAchievers(conditionId,actionId);
                final Terminal t = Terminal.getTerminal(conditionId);
                boolean update = false;
                if (t instanceof Predicate || t instanceof NotCond) {//affecting a prop variable
                    if (updateIfNeeded(conditionId,actionHCost[actionId] + actionCost[actionId])) {
                        update = true;
                        updateRelPlanInfo(conditionId,actionId,1);
                    }
                } else {//affecting a num comparison
                    final double v = this.numericContribution(actionId, (Comparison) t);
                    final float rep = (float)(-1f*((Comparison) t).getLeft().eval(s)/v);
                    final float newCost = rep*actionCost[actionId];
                    if (updateIfNeeded(conditionId,actionHCost[actionId] + newCost)) {
                        update = true;
                        updateRelPlanInfo(conditionId,actionId,rep);
                    }
                }
                if (update) {
                    updateActions(conditionId, p);
                }
            }
        }

    }

    private void updateAchievers(int conditionId, int actionId) {
        if (extractRelaxedPlan) {
            if (achievers == null) {
                achievers = new IntArraySet[totNumberOfTerms];
                establishedAchiever = new int[totNumberOfTerms];
                numRepetition = new float[totNumberOfTerms];
            }
            IntArraySet achiever = achievers[conditionId];
            if (achiever == null) {
                achiever = new IntArraySet();
            }
            achiever.add(actionId);
            achievers[conditionId] = achiever;
        }
    }

    private void updateRelPlanInfo(int conditionId, int actionId, float rep) {
        if (extractRelaxedPlan) {
            establishedAchiever[conditionId] = actionId;
            numRepetition[conditionId] = rep;
        }
    }

    boolean updateIfNeeded(final int t, final float value){
        if (conditionCost[t] > value) {
            conditionCost[t] = value;
            return true;
        }
        return false;
    }

    Pair<Collection,Float> getActivatingConditions (final Condition c) {
        if (c instanceof AndCond) {
            final AndCond and = (AndCond) c;
            if (and.sons == null) {
                return Pair.of(Collections.EMPTY_LIST,0f);
            }
            IntArraySet left = new IntArraySet();
            float cost = 0f;
            for (final Condition son : (Collection<Condition>) and.sons) {
                Pair<Collection, Float> activatingConditions = getActivatingConditions(son);
                if (activatingConditions.getRight() == Float.MAX_VALUE) {
                    return null;
                }
                cost+=activatingConditions.getRight();
                left.addAll(activatingConditions.getKey());
            }
            return Pair.of(left,cost);

        } else if (c instanceof OrCond) {
            final OrCond and = (OrCond) c;
            if (and.sons == null) {
                return Pair.of(Collections.EMPTY_LIST,0f);
            }
            float ret = Float.MAX_VALUE;
            Collection left = null;
            for (final Condition son : (Collection<Condition>) and.sons) {
                final Pair<Collection, Float> estimate = getActivatingConditions(son);
                if (estimate.getRight() != Float.MAX_VALUE) {
                    if (estimate.getRight() < ret){
                        ret = estimate.getRight();
                        left = estimate.getLeft();
                    }
                }
            }
            return Pair.of(left,ret);
        } else if (c instanceof Terminal) {
            final Terminal t = (Terminal) c;
            return Pair.of(new IntArraySet(Collections.singleton(t.getId())),conditionCost[t.getId()]);
        } else {
            throw new RuntimeException("This is not supported:"+c);
        }
    }

    float estimateCost (final Condition c) {
        return this.estimateCost(c,additive);
    }

    float estimateCost (final Condition c, boolean additive) {
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

    public Collection<TransitionGround> getTransitions(final boolean helpful) {
        if (helpfulActions == null || !helpful){
            if (reachableTransitionsInstances == null){
                reachableTransitionsInstances = new LinkedHashSet<TransitionGround>();
                if (reachableTransitions == null){
                    this.computeEstimate(problem.getInit());
                }
                for (final int i: reachableTransitions){
                    reachableTransitionsInstances.add((TransitionGround) Transition.getTransition(i));
                }
                reachableTransitionsInstances = new ArrayList<>(reachableTransitionsInstances);
            }
            return reachableTransitionsInstances;
        }
        Collection<TransitionGround> actions = new ArrayList<>();
        for (final int i: helpfulActions){
            actions.add((TransitionGround) Transition.getTransition(i));
        }
        return actions;
    }
}
//
//
//    public class GroundActionComparator implements IntComparator{
//         @Override
//        public int compare(int o1, int o2) {
//            if (actionHCost[o1] < actionHCost[o2]){
//                return -1;
//            }else if (actionHCost[o1] > actionHCost[o2]){
//                return 1;
//            }else{
//                return 0;
//            }
//        }
//
//    }

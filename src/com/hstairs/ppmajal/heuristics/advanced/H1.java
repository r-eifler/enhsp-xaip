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
import it.unimi.dsi.fastutil.ints.IntArraySet;
import org.apache.commons.lang3.tuple.Pair;
import org.jgrapht.util.FibonacciHeap;
import org.jgrapht.util.FibonacciHeapNode;

import java.util.*;

import static com.google.common.collect.Sets.SetView;
import static com.hstairs.ppmajal.transition.Transition.getTransition;
import static java.lang.Math.ceil;

/**
 * @author enrico
 */
public class H1 implements Heuristic {

    final private boolean useRedundantConstraints;
    final public boolean extractRelaxedPlan;
    final public boolean maxMRP;

    final private int pseudoGoal;
    final private Condition[] preconditionFunction;
    final private Collection<Integer>[] propEffectFunction;
    final private Collection<NumEffect>[] numericEffectFunction;
    final private int heuristicNumberOfActions;
    final private int totNumberOfTerms;
    final private EPddlProblem problem;
    final private boolean helpfulActionsComputation;
    private final IntArraySet[] conditionsAchievableBy;
    private final IntArraySet[] conditionToAction;
    private final IntArraySet allConditions;
    private final IntArraySet allComparisons;
    private final FibonacciHeapNode[] nodeOf;
    private final boolean reachability;
    private final boolean conjunctionsMax;

    final private float[] actionCost;
    final private float[] actionHCost;
    final private float[] conditionCost;
    final private boolean[] closed;

    private final boolean additive;
    private final boolean[] conditionInit;
    private final boolean[] actionInit;
    private final boolean helpfulTransitions;
    private float[][] numericContribution;
    private IntArraySet[] achievers;
    private int[] establishedAchiever;
    private float[] numRepetition;
    private IntArraySet helpfulActions;
    private int[] repetitions;
    private IntArraySet reachableTransitions;
    private Collection<TransitionGround> reachableTransitionsInstances;

    final private float UNKNOWNEFFECT = Float.NEGATIVE_INFINITY;
    final private IntArraySet freePreconditionActions;
    private List<Pair<Integer, IntArraySet>> plan;
    private float[] minAchieverPreconditionCost;

    public H1(EPddlProblem problem) {
        this(problem, true, false, false, false, false, false, false, false);
    }

    public H1(EPddlProblem problem,boolean additive) {
        this(problem, additive, false, false, false, false, false, false, false);
    }
    public H1(EPddlProblem problem, boolean additive, boolean extractRelaxedPlan, boolean maxHelpfulTransitions, boolean useRedundantConstraints, boolean helpfulActionsComputation, boolean reachability
            , boolean helpfulTransitions, boolean conjunctionsMax) {

        this.additive = additive;
        this.problem = problem;
        this.reachability = reachability;
        this.helpfulActionsComputation = helpfulActionsComputation;
        this.useRedundantConstraints = useRedundantConstraints;
        this.extractRelaxedPlan = extractRelaxedPlan;
        pseudoGoal = Transition.totNumberOfTransitions;
        heuristicNumberOfActions = Transition.totNumberOfTransitions + 1;
        allComparisons = new IntArraySet();
        preconditionFunction = new Condition[heuristicNumberOfActions];
        propEffectFunction = new Collection[heuristicNumberOfActions];
        numericEffectFunction = new Collection[heuristicNumberOfActions];
        freePreconditionActions = new IntArraySet();

        actionCost = new float[heuristicNumberOfActions];
        Arrays.fill(actionCost, Float.MAX_VALUE);

        SetView<TransitionGround> transitions = Sets.union(Sets.union(new HashSet(problem.actions), new HashSet<>(problem.getEventsSet())), new HashSet(problem.getProcessesSet()));
        for (final TransitionGround b : transitions) {
            if (useRedundantConstraints) {
                preconditionFunction[b.getId()] = b.getPreconditions().transformEquality().introduce_red_constraints();
            } else {
                preconditionFunction[b.getId()] = b.getPreconditions().transformEquality();
            }
            final IntArraySet propositional = new IntArraySet();
            for (Terminal t : b.getAllAchievableLiterals()) {
                propositional.add(t.getId());
            }
            propEffectFunction[b.getId()] = propositional;
            numericEffectFunction[b.getId()] = b.getConditionalNumericEffects().getAllEffects();
            for (NumEffect neff : numericEffectFunction[b.getId()]) {
                neff.normalize();
            }
            actionCost[b.getId()] = b.getActionCost(problem.getInit(), problem.getMetric());
        }
        if (useRedundantConstraints) {
            preconditionFunction[pseudoGoal] = problem.getGoals().transformEquality().introduce_red_constraints();
        } else {
            preconditionFunction[pseudoGoal] = problem.getGoals().transformEquality();
        }

        totNumberOfTerms = Terminal.getTotCounter();
        conditionsAchievableBy = new IntArraySet[heuristicNumberOfActions];
        conditionToAction = new IntArraySet[totNumberOfTerms];
        allConditions = new IntArraySet();

        nodeOf = new FibonacciHeapNode[heuristicNumberOfActions];

        for (final TransitionGround b : transitions) {
            final int i = b.getId();
            updatePreconditionFunction(i);
        }
        updatePreconditionFunction(pseudoGoal);
        actionHCost = new float[heuristicNumberOfActions];
        conditionCost = new float[totNumberOfTerms];
        closed = new boolean[heuristicNumberOfActions];
        numericContribution = new float[heuristicNumberOfActions][totNumberOfTerms];
        for (float[] row : numericContribution) {
            Arrays.fill(row, Float.MAX_VALUE);
        }
        conditionInit = new boolean[totNumberOfTerms];
        actionInit = new boolean[heuristicNumberOfActions];
        if (extractRelaxedPlan) {
            achievers = new IntArraySet[totNumberOfTerms];
            establishedAchiever = new int[totNumberOfTerms];
            numRepetition = new float[totNumberOfTerms];
        }
        this.helpfulTransitions = helpfulTransitions;
        if (helpfulTransitions) {
            repetitions = new int[heuristicNumberOfActions];
        }
        if (!additive) {
            minAchieverPreconditionCost = new float[totNumberOfTerms];
        }

        maxMRP = maxHelpfulTransitions;
        this.conjunctionsMax = conjunctionsMax;
    }


    void updatePreconditionFunction(int i) {
        final Collection<Condition> terminalConditions = preconditionFunction[i].getTerminalConditionsInArray();
        if (terminalConditions.isEmpty()) {
            freePreconditionActions.add(i);
        }
        for (final Condition c : terminalConditions) {
            if (c instanceof Terminal) {
                Terminal t = (Terminal) c;
                IntArraySet groundActions = conditionToAction[((Terminal) c).getId()];
                if (groundActions == null) {
                    groundActions = new IntArraySet();
                }
                groundActions.add(i);
                conditionToAction[t.getId()] = groundActions;
                allConditions.add(((Terminal) c).getId());
                if (c instanceof Comparison) {
//                    System.out.println(c);
                    final Comparison normalize = (Comparison) c.normalize();
//                    System.out.println(normalize);
                    allComparisons.add(normalize.getId());
                }
            }
        }
    }

    @Override
    public float computeEstimate(State gs) {
        Arrays.fill(actionHCost, Float.MAX_VALUE);
        Arrays.fill(conditionCost, Float.MAX_VALUE);
        Arrays.fill(closed, false);
        Arrays.fill(actionInit, false);
        Arrays.fill(conditionInit, false);
        if (extractRelaxedPlan) {
            Arrays.fill(establishedAchiever, -1);
            Arrays.fill(numRepetition, Float.MAX_VALUE);

        }
        if (!additive) {
            Arrays.fill(minAchieverPreconditionCost, Float.POSITIVE_INFINITY);
        }

//        Printer.pddlPrint(problem, (PDDLState) gs);
        final FibonacciHeap h = new FibonacciHeap();
        for (final int i : allConditions) {
            if (gs.satisfy(Terminal.getTerminal(i))) {
                conditionCost[i] = 0f;
                conditionInit[i] = true;
                updateActions(i, h, true);
            }
        }
        for (final int freePreconditionAction : freePreconditionActions) {
            actionHCost[freePreconditionAction] = 0f;
            actionInit[freePreconditionAction] = true;
            addActionsInPriority(freePreconditionAction, h, 0f);
        }

        while (!h.isEmpty()) {
            final int actionId = (int) h.removeMin().getData();
            if (actionId == pseudoGoal && !reachability) {
                if (extractRelaxedPlan) {
                    return relaxedPlanCost();
                }
                return actionHCost[pseudoGoal];
            }
            if (reachability && actionId != pseudoGoal) {
                if (reachableTransitions == null) {
                    reachableTransitions = new IntArraySet();
                }
                reachableTransitions.add(actionId);
            }
            closed[actionId] = true;
            if (actionId != pseudoGoal) {
                expand(actionId, h, gs);
            }
        }
        return extractRelaxedPlan && actionHCost[pseudoGoal] != Float.MAX_VALUE ? relaxedPlanCost() : actionHCost[pseudoGoal];

    }

    void addActionsInPriority(final int i, final FibonacciHeap p, final float v) {
        final FibonacciHeapNode fibonacciHeapNode = new FibonacciHeapNode(i);
        nodeOf[i] = fibonacciHeapNode;
        p.insert(fibonacciHeapNode, v);
    }

    void updateActions(final int c, final FibonacciHeap p) {
        this.updateActions(c, p, false);
    }

    void updateActions(final int c, final FibonacciHeap p, boolean init) {
        final IntArraySet actions = conditionToAction[c];
        if (actions != null) {
            for (final int i : actions) {
                if (!closed[i]) {
                    final float v = estimateCost(preconditionFunction[i]);
                    if (init && v == 0) {
                        actionInit[i] = true;
                    }
                    if (v < Float.MAX_VALUE) {
                        if (v < actionHCost[i]) {
                            if (actionHCost[i] == Float.MAX_VALUE) {
                                actionHCost[i] = v;
                                addActionsInPriority(i, p, v);
                            } else {
                                actionHCost[i] = v;
                                p.decreaseKey(nodeOf[i], v);
                            }
                        }
                    }
                }
            }
        }
    }

    private float relaxedPlanCost() {
        final Condition goal = preconditionFunction[pseudoGoal];

        final LinkedList<Pair<Collection, Float>> stack = new LinkedList();
        stack.add(getActivatingConditions(goal));
        plan = new LinkedList();
        final boolean[] visited = new boolean[totNumberOfTerms];
        Arrays.fill(visited, false);
        helpfulActions = new IntArraySet();

        while (!stack.isEmpty()) {

            final Pair<Collection, Float> elements;
            elements = stack.pollLast();
            for (final int conditionId : (Collection<Integer>) elements.getLeft()) {
                if (!visited[conditionId]) {
                    if (!conditionInit[conditionId]) {
                        if (helpfulActionsComputation) {
                            if (getAchiever(conditionId).isEmpty()) {
                                throw new RuntimeException("Houston we have problem here. Condition \n" + Terminal.getTerminal(conditionId) + " has never been achieved");
                            }
                            for (final int id : getAchiever(conditionId)) {
                                if (actionInit[id]) {
                                    helpfulActions.add(id);
                                }
                            }
                        }
                        final int actionId = establishedAchiever[conditionId];

                        boolean inserted = false;
                        for (int i = plan.size() - 1; i >= 0; i--) {
                            if (plan.get(i).getLeft() == actionId) {
                                final IntArraySet right = plan.get(i).getRight();
                                right.add((int) ceil(numRepetition[conditionId]));
                                inserted = true;
                                break;
                            }
                        }
                        if (!inserted) {
                            final IntArraySet t = new IntArraySet();
                            t.add((int) ceil(numRepetition[conditionId]));
                            plan.add(Pair.of(actionId, t));
                            stack.push(getActivatingConditions(preconditionFunction[actionId]));
                        }
                    }
                    visited[conditionId] = true;
                }
            }
        }
        float ret = 0;
        for (final Pair<Integer, IntArraySet> action : plan) {
            int max = 0;
            for (final int rep : action.getRight()) {
                if (rep > max){
                    max = rep;
                }
            }
            ret += max * actionCost[action.getLeft()];
        }
        return ret;
    }

    private IntArraySet getAchiever(int conditionId) {
        final IntArraySet achiever = achievers[conditionId];
        if (achiever == null) {
            achievers[conditionId] = new IntArraySet();
        }
        return achievers[conditionId];
    }

    private void expand(int actionId, FibonacciHeap p, State s) {

        IntArraySet achievableTerms = conditionsAchievableBy[actionId];
        if (achievableTerms == null) {
            achievableTerms = new IntArraySet();
            for (final int t : allComparisons) {
                final float v = this.numericContribution(actionId, (Comparison) Terminal.getTerminal(t));
                if (v > 0 || v == UNKNOWNEFFECT) {
                    achievableTerms.add(t);
                    updateAchievers(t, actionId);
                }
            }
            achievableTerms.addAll(propEffectFunction[actionId]);
            for (final int o : propEffectFunction[actionId]) {
                updateAchievers(o, actionId);
            }
            conditionsAchievableBy[actionId] = achievableTerms;

        }
        for (final int conditionId : achievableTerms) {//This is for all terminal conditions
            if (!conditionInit[conditionId] && (!reachability || conditionCost[conditionId] == Float.MAX_VALUE)) {
                final Terminal t = Terminal.getTerminal(conditionId);
                boolean update = false;
                if (t instanceof Predicate || t instanceof NotCond) {//affecting a prop variable
                    if (updateIfNeeded(conditionId, actionHCost[actionId] + actionCost[actionId])) {
                        update = true;
                        updateRelPlanInfo(conditionId, actionId, 1);
                    }
                } else {//affecting a num comparison
                    final double v = this.numericContribution(actionId, (Comparison) t);
                    if (v > 0) {
                        final float rep = (float) (-1f * ((Comparison) t).getLeft().eval(s) / v);
                        final float newCost = rep * actionCost[actionId];
                        boolean localUpdate = false;
                        if (additive) {
                            localUpdate = updateIfNeeded(conditionId, actionHCost[actionId] + newCost);
                        } else {
                            if (actionHCost[actionId] < minAchieverPreconditionCost[conditionId]) {
                                minAchieverPreconditionCost[conditionId] = actionHCost[actionId];
                            }
                            localUpdate = updateIfNeeded(conditionId, minAchieverPreconditionCost[conditionId] + newCost);
                        }
                        if (localUpdate) {
                            update = true;
                            updateRelPlanInfo(conditionId, actionId, rep);
                        }
                    } else if (v == UNKNOWNEFFECT) {//this is a hard condition basically
                        float newCost = 0f;
                        if (additive) {
                            newCost = actionCost[actionId];
                        }
                        if (updateIfNeeded(conditionId, actionHCost[actionId] + newCost)) {
                            update = true;
                            updateRelPlanInfo(conditionId, actionId, 1);
                        }
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
            getAchiever(conditionId).add(actionId);
        }
    }

    private void updateRelPlanInfo(int conditionId, int actionId, float rep) {
        if (extractRelaxedPlan) {
            establishedAchiever[conditionId] = actionId;
            numRepetition[conditionId] = rep;
        }
    }

    boolean updateIfNeeded(final int t, final float value) {
        if (conditionCost[t] > value) {
            conditionCost[t] = value;
            return true;
        }
        return false;
    }

    Pair<Collection, Float> getActivatingConditions(final Condition c) {
        if (c instanceof AndCond) {
            final AndCond and = (AndCond) c;
            if (and.sons == null) {
                return Pair.of(Collections.EMPTY_LIST, 0f);
            }
            IntArraySet left = new IntArraySet();
            float cost = 0f;
            for (final Condition son : (Collection<Condition>) and.sons) {
                Pair<Collection, Float> activatingConditions = getActivatingConditions(son);
                if (activatingConditions.getRight() == Float.MAX_VALUE) {
                    throw new RuntimeException("Conditions " + son + " seems unsatisfiable in the relaxed plan extraction");
                }
                cost += activatingConditions.getRight();
                left.addAll(activatingConditions.getKey());
            }
            return Pair.of(left, cost);

        } else if (c instanceof OrCond) {
            final OrCond and = (OrCond) c;
            if (and.sons == null) {
                return Pair.of(Collections.EMPTY_LIST, 0f);
            }
            float ret = Float.MAX_VALUE;
            Collection left = null;
            for (final Condition son : (Collection<Condition>) and.sons) {
                final Pair<Collection, Float> estimate = getActivatingConditions(son);
                if (estimate.getRight() != Float.MAX_VALUE) {
                    if (estimate.getRight() < ret) {
                        ret = estimate.getRight();
                        left = estimate.getLeft();
                    }
                }
            }
            return Pair.of(left, ret);
        } else if (c instanceof Terminal) {
            final Terminal t = (Terminal) c;
            return Pair.of(new IntArraySet(Collections.singleton(t.getId())), conditionCost[t.getId()]);
        } else {
            throw new RuntimeException("This is not supported:" + c);
        }
    }

    float estimateCost(final Condition c) {
        return this.estimateCost(c, additive);
    }

    float estimateCost(final Condition c, boolean additive) {
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
                if (additive && !conjunctionsMax) {// && !this.extractRelaxedPlan) {
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


    //Semantics: UNKNOWEFFECT don't know because comp is hard. > 0 is achiever, 0 no
    float numericContribution(int t, Comparison comp) {
        if (numericEffectFunction[t].isEmpty()) {
            return 0f;
        }

        Float positiveness = numericContribution[t][comp.getId()];
        if (positiveness == Float.MAX_VALUE) {
            positiveness = 0f;
            if (numericEffectFunction[t].isEmpty()) {
                numericContribution[t][comp.getId()] = 0;
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
                                if (!rhs.linear || !rhs.isNumber() || ne.getOperator().equals("assign")) {
                                    numericContribution[t][comp.getId()] = UNKNOWNEFFECT;
                                    return UNKNOWNEFFECT;
                                }
                                if (ne.getOperator().equals("increase")) {
                                    positiveness += rhs.getNumber().floatValue() * ad.n.floatValue();
                                } else if (ne.getOperator().equals("decrease")) {
                                    positiveness += (-1) * rhs.getNumber().floatValue() * ad.n.floatValue();
                                }
                            }else{//The effect is state dependent.
                                return UNKNOWNEFFECT;
                            }
                        }
                    }
                }
                numericContribution[t][comp.getId()] = positiveness;
                return positiveness;
            } else {
                throw new RuntimeException("At the moment only normalized expressions are considered " + comp);
            }
        }
        return positiveness;
    }

    public Collection getTransitions(final boolean helpful) {
        Collection res = null;
        if (helpfulActions == null || !helpful) {
            if (reachableTransitionsInstances == null) {
                if (reachableTransitions == null) {
                    res = problem.actions;
                } else {
                    reachableTransitionsInstances = new LinkedHashSet<TransitionGround>();
                    for (final int i : reachableTransitions) {
                        reachableTransitionsInstances.add((TransitionGround) getTransition(i));
                    }
                    reachableTransitionsInstances = new ArrayList<>(reachableTransitionsInstances);
                    res = reachableTransitionsInstances;
                }
            } else {
                res = reachableTransitionsInstances;
            }
        } else {
            Collection actions = new ArrayList<>();
            for (final int i : helpfulActions) {
                actions.add((TransitionGround) getTransition(i));
            }
            res = actions;
        }
        if (helpfulTransitions) {
//            if (helpfulActionsComputation) {
//                for (Pair<TransitionGround, Integer> helpfulTransition : getHelpfulTransitions()) {
//                    res.remove(helpfulTransition.getLeft());
//                    res.add(helpfulTransition);
//                }
//            }else {
            res.addAll(getHelpfulTransitions());
//            }
        }
        return res;
    }

    @Override
    public Collection<TransitionGround> getAllTransitions() {
        if (reachableTransitionsInstances == null) {
            if (reachableTransitions == null) {
                throw new RuntimeException("The heuristics should be called at least once to be used to get the reached actions");
            }
            reachableTransitionsInstances = new LinkedHashSet<TransitionGround>();
            for (final int i : reachableTransitions) {
                reachableTransitionsInstances.add((TransitionGround) getTransition(i));
            }
            reachableTransitionsInstances = new ArrayList<>(reachableTransitionsInstances);
            return reachableTransitionsInstances;
        } else {
            return reachableTransitionsInstances;
        }
    }

    public Collection<Pair<TransitionGround, Integer>> getHelpfulTransitions() {
        if (!extractRelaxedPlan) {
            throw new RuntimeException("Helpful Transitions can only be activatated in combination with the relaxed plan extraction");
        }
        Collection<Pair<TransitionGround, Integer>> res = new ArrayList<>();
        for (Pair<Integer, IntArraySet> pair : plan) {
            if (actionInit[pair.getLeft()]) {
                final IntArraySet right = pair.getRight();
                if (maxMRP){
                    int max = 0;
                    for (int i: right){
                        if (i > max){
                            max = i;
                        }
                    }
                    if (max > 1) {
                        res.add(Pair.of((TransitionGround) getTransition(pair.getLeft()), max));
                    }
                }else{
                    int min = Integer.MAX_VALUE;
                    for (int i: right){
                        if (i < min){
                            min = i;
                        }
                    }
                    if (min > 1) {
                        res.add(Pair.of((TransitionGround) getTransition(pair.getLeft()), min));
                    }
                }
            }
        }
        return res;
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

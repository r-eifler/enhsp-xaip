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
package com.hstairs.ppmajal.pddl.heuristics.advanced;

import com.google.common.collect.Sets;
import com.hstairs.ppmajal.conditions.*;
import com.hstairs.ppmajal.expressions.ExtendedAddendum;
import com.hstairs.ppmajal.expressions.ExtendedNormExpression;
import com.hstairs.ppmajal.expressions.NumEffect;
import com.hstairs.ppmajal.expressions.NumFluent;
import com.hstairs.ppmajal.extraUtils.ArrayShifter;
import com.hstairs.ppmajal.problem.PDDLProblem;
import com.hstairs.ppmajal.problem.State;
import com.hstairs.ppmajal.transition.Transition;
import com.hstairs.ppmajal.transition.TransitionGround;
import it.unimi.dsi.fastutil.ints.IntArraySet;
import org.jgrapht.util.FibonacciHeap;
import org.jgrapht.util.FibonacciHeapNode;

import java.util.*;

import static com.hstairs.ppmajal.transition.Transition.getTransition;
import static java.lang.Math.ceil;
import org.jgrapht.alg.util.Pair;
import com.hstairs.ppmajal.search.SearchHeuristic;
import it.unimi.dsi.fastutil.ints.IntSet;

/**
 * @author enrico
 */
public class H1 implements SearchHeuristic {

    /**
     * @return the heuristicNumberOfActions
     */
    public int getHeuristicNumberOfActions() {
        return heuristicNumberOfActions;
    }

    static final boolean DEBUG = false;
    final public boolean extractRelaxedPlan;
    final public boolean maxMRP;

    final protected int pseudoGoal;
    final protected Condition[] preconditionFunction;
    final protected Collection<Integer>[] propEffectFunction;
    final protected Collection<NumEffect>[] numericEffectFunction;
    protected final int heuristicNumberOfActions;
    protected final int totNumberOfTerms;
    protected final int totNumberOfTermsRefactored;

    protected final PDDLProblem problem;
    final private boolean helpfulActionsComputation;
    final IntArraySet[] conditionsAchievableBy;
    final IntArraySet[] conditionsDeletableBy;
    final IntArraySet[] conditionToAction;
    final IntArraySet allConditions;
    private final IntArraySet allComparisons;
    private final FibonacciHeapNode[] nodeOf;
    boolean reachability;
    private final boolean conjunctionsMax;

    private final float[] actionCost;
    private final float[] actionHCost;
    private final float[] conditionCost;
    private final boolean[] closed;

    final boolean additive;
    private final boolean[] conditionInit;
    private final boolean[] actionInit;
    private final boolean helpfulTransitions;
    private final boolean hardcoreVersion;
    private final float[][] numericContributionRaw;
    private final Map<Pair<Integer, Integer>, Float> numericContribution;
    protected final ArrayShifter termsArrayShifter;
    protected final ArrayShifter actionsArrayShifter;
    protected final int totNumberOfActionsRefactored;
    IntArraySet[] allAchievers;
    final private IntArraySet[] deleters;
    protected int[] establishedAchiever;
    protected float[] numRepetition;
    private IntArraySet helpfulActions;
    IntArraySet reachableTransitions;
    private Collection<TransitionGround> reachableTransitionsInstances;

    final float UNKNOWNEFFECT = Float.NEGATIVE_INFINITY;
    final protected IntArraySet freePreconditionActions;
//    private List<Pair<Integer, IntArraySet>> plan;
    private IntArraySet plan;
    final protected IntArraySet[] repetitionsInThePlan;
    private float[] minAchieverPreconditionCost;
    protected IntArraySet allActions;

    Map<AndCond, Collection<IntArraySet>> redundantMap;
    final boolean useSmartConstraints;
    
    final int[] maxNumRepetition ;
    

    //Plan Fixing Data Structures;


    final boolean[] visited;

    
    
    public H1(PDDLProblem problem) {
        this(problem, true, false, false, "no", false, false, false, false, null);
    }


    
    public H1(PDDLProblem problem, boolean additive) {
        this(problem, additive, false, false, "no", false, false, false, false, null);
    }

    public H1(PDDLProblem problem, boolean additive, boolean extractRelaxedPlan, boolean maxHelpfulTransitions, String redConstraints, boolean helpfulActionsComputation, boolean reachability,
            boolean helpfulTransitions, boolean conjunctionsMax) {
        this(problem, additive, extractRelaxedPlan, maxHelpfulTransitions, redConstraints, helpfulActionsComputation, reachability, helpfulTransitions, conjunctionsMax, null);
    }

    public H1(PDDLProblem problem, boolean additive, boolean extractRelaxedPlan, boolean maxHelpfulTransitions, String redConstraints, boolean helpfulActionsComputation, boolean reachability,
            boolean helpfulTransitions, boolean conjunctionsMax, Map<AndCond, Collection<IntArraySet>> redundantMap) {

        long startSetup = System.currentTimeMillis();
        this.additive = additive;
        this.problem = problem;
        this.reachability = reachability;
        this.helpfulActionsComputation = helpfulActionsComputation;
        this.extractRelaxedPlan = extractRelaxedPlan;
        pseudoGoal = Transition.totNumberOfTransitions;
        heuristicNumberOfActions = Transition.totNumberOfTransitions + 1;
        allComparisons = new IntArraySet();
        preconditionFunction = new Condition[heuristicNumberOfActions];
        propEffectFunction = new Collection[heuristicNumberOfActions];
        numericEffectFunction = new Collection[heuristicNumberOfActions];
        freePreconditionActions = new IntArraySet();
        this.redundantMap = redundantMap;
        actionCost = new float[heuristicNumberOfActions];
        Arrays.fill(actionCost, Float.MAX_VALUE);

        useSmartConstraints = "smart".equals(redConstraints);

        normalizeModel(redConstraints, new LinkedHashSet(problem.actions));
        normalizeModel(redConstraints, new LinkedHashSet(problem.getEventsSet()));
        normalizeModel(redConstraints, new LinkedHashSet(problem.getProcessesSet()));
        preconditionFunction[pseudoGoal] = this.getNormalizedPrecondition(problem.getGoals(), redConstraints);

        totNumberOfTerms = Terminal.getTotCounter();
        conditionsAchievableBy = new IntArraySet[heuristicNumberOfActions];
        conditionToAction = new IntArraySet[totNumberOfTerms];
        allConditions = new IntArraySet();
        allActions = new IntArraySet();

        nodeOf = new FibonacciHeapNode[heuristicNumberOfActions];
        fillPreEffFunctions(new LinkedHashSet(problem.actions));
        fillPreEffFunctions(new LinkedHashSet(problem.getEventsSet()));
        fillPreEffFunctions(new LinkedHashSet(problem.getProcessesSet()));

        allActions.add(pseudoGoal);
        updatePreconditionFunction(pseudoGoal);

        termsArrayShifter = new ArrayShifter(getAllConditions());
        totNumberOfTermsRefactored = termsArrayShifter.getMaxTid();

        actionsArrayShifter = new ArrayShifter(allActions);
        totNumberOfActionsRefactored = actionsArrayShifter.getMaxTid();

        actionHCost = new float[heuristicNumberOfActions];
        conditionCost = new float[totNumberOfTerms];
        closed = new boolean[heuristicNumberOfActions];

        hardcoreVersion = heuristicNumberOfActions * totNumberOfTermsRefactored < 1999999999;
//        System.out.println("Heuristic Number of Actions:" + heuristicNumberOfActions);
//        System.out.println("Heuristic Number of Actions Refactored:" + totNumberOfActionsRefactored);
//        System.out.println("Tot Number of Terms:" + totNumberOfTerms);
//        System.out.println("Tot Number of Terms Refactored:" + totNumberOfTermsRefactored);

        if (hardcoreVersion) {
            numericContributionRaw = new float[totNumberOfActionsRefactored][totNumberOfTermsRefactored];
            for (final float[] row : numericContributionRaw) {
                Arrays.fill(row, Float.MAX_VALUE);
            }
            numericContribution = null;
        } else {
//            System.out.println("H1 with small memory footprint");
            numericContributionRaw = null;
            numericContribution = new HashMap<>();
        }
        //        numericContribution = new HashMap<>();

        conditionInit = new boolean[totNumberOfTerms];
        actionInit = new boolean[heuristicNumberOfActions];
        if (extractRelaxedPlan || useSmartConstraints || helpfulActionsComputation) {
            allAchievers = new IntArraySet[totNumberOfTerms];
        }
        if (useSmartConstraints) {
            deleters = new IntArraySet[totNumberOfTerms];
            conditionsDeletableBy = new IntArraySet[heuristicNumberOfActions];
        }else{
            deleters = null;
            conditionsDeletableBy = null;
        }
        if (extractRelaxedPlan || helpfulActionsComputation) {
            establishedAchiever = new int[totNumberOfTerms];
            numRepetition = new float[totNumberOfTerms];
        }
        this.helpfulTransitions = helpfulTransitions;
        if (!additive) {
            minAchieverPreconditionCost = new float[totNumberOfTerms];
        }

        maxMRP = maxHelpfulTransitions;
        this.conjunctionsMax = conjunctionsMax;
        System.out.println("H1 Setup Time (msec): " + (System.currentTimeMillis() - startSetup));


        if (extractRelaxedPlan || helpfulActionsComputation){
            maxNumRepetition = new int[heuristicNumberOfActions];
            visited = new boolean[totNumberOfTerms];
            repetitionsInThePlan = new IntArraySet[heuristicNumberOfActions];
        }else{
            visited = null;
            maxNumRepetition = null;
            repetitionsInThePlan = null;
        }

    }

    private void fillPreEffFunctions(LinkedHashSet<TransitionGround> transitions) {

        for (final TransitionGround b : transitions) {
            final int i = b.getId();
            allActions.add(b.getId());
            updatePreconditionFunction(i);
        }

    }

    private void normalizeModel(String redConstraints, Collection<TransitionGround> transitions) {
        for (final TransitionGround b : transitions) {
            preconditionFunction[b.getId()] = getNormalizedPrecondition(b.getPreconditions(), redConstraints);

            final IntArraySet propositional = new IntArraySet();
            for (Terminal t : b.getAllAchievableLiterals()) {
                propositional.add(t.getId());
            }
            propEffectFunction[b.getId()] = propositional;
            numericEffectFunction[b.getId()] = b.getConditionalNumericEffects().getAllEffects();
            for (NumEffect neff : numericEffectFunction[b.getId()]) {
                neff.normalize();
            }
            actionCost[b.getId()] = b.getActionCost(getProblem().getInit(), getProblem().getMetric(), getProblem().isSdac());
        }

    }

    void updatePreconditionFunction(int i) {
        final Collection<Condition> terminalConditions = preconditionFunction[i].getTerminalConditionsInArray();
        if (terminalConditions.isEmpty()) {
            freePreconditionActions.add(i);
        }
        for (final Condition c : terminalConditions) {
            if (c instanceof Terminal) {
                Terminal t = (Terminal) c;
                IntArraySet groundActions = getConditionToAction()[((Terminal) c).getId()];
                if (groundActions == null) {
                    groundActions = new IntArraySet();
                }
                groundActions.add(i);
                conditionToAction[t.getId()] = groundActions;
                getAllConditions().add(((Terminal) c).getId());
                if (c instanceof Comparison) {
//                    System.out.println(c);
                    final Comparison normalize = (Comparison) c.normalize();
//                    System.out.println(normalize);
                    getAllComparisons().add(normalize.getId());
                }
            }
        }
    }

    protected FibonacciHeap smallSetup(State gs) {
        Arrays.fill(getActionHCost(), Float.MAX_VALUE);
        Arrays.fill(getConditionCost(), Float.MAX_VALUE);
        Arrays.fill(getClosed(), false);
        Arrays.fill(getActionInit(), false);
        Arrays.fill(getConditionInit(), false);
        if (extractRelaxedPlan || isHelpfulActionsComputation()) {
            Arrays.fill(establishedAchiever, -1);
            Arrays.fill(numRepetition, Float.MAX_VALUE);
        }
        if (!isAdditive()) {
            Arrays.fill(minAchieverPreconditionCost, Float.POSITIVE_INFINITY);
        }

//        Printer.pddlPrint(problem, (PDDLState) gs);
        final FibonacciHeap h = new FibonacciHeap();
        for (final int i : getAllConditions()) {
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
        return h;
    }

    @Override
    public float computeEstimate(State gs) {
        final FibonacciHeap h = this.smallSetup(gs);
        while (!h.isEmpty()) {
            final int actionId = (int) h.removeMin().getData();
            if (actionId == pseudoGoal && !isReachability()) {
                break;
            }
            if (isReachability() && actionId != pseudoGoal) {
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
        
        if (getActionHCost()[pseudoGoal] == Float.MAX_VALUE ){
            return Float.MAX_VALUE;
        }
        
        if (this.extractRelaxedPlan){
            return relaxedPlanCost(gs);
        }
        
        if (this.isHelpfulActionsComputation()){//this is to be used when hadd is wanted to be used with helpful actions taken from mrp
            relaxedPlanCost(gs);
        }
//        System.exit(-1);
        return getActionHCost()[pseudoGoal];

    }

    void addActionsInPriority(final int i, final FibonacciHeap p, final float v) {
        final FibonacciHeapNode fibonacciHeapNode = new FibonacciHeapNode(i);
        nodeOf[i] = fibonacciHeapNode;
        p.insert(fibonacciHeapNode, v);
    }

    protected void updateActions(final int c, final FibonacciHeap p) {
        this.updateActions(c, p, false);
    }

    protected void updateActions(final int c, final FibonacciHeap p, boolean init) {
        final IntArraySet actions = getConditionToAction()[c];
        if (actions != null) {
            for (final int i : actions) {
                if (!getClosed()[i]) {
                    final float v = estimateCost(preconditionFunction[i], getActionHCost()[i]);
                    if (init && v == 0) {
                        actionInit[i] = true;
                    }
                    if (v < Float.MAX_VALUE) {
                        if (v < getActionHCost()[i]) {
                            if (getActionHCost()[i] == Float.MAX_VALUE) {
                                actionHCost[i] = v;
                                addActionsInPriority(i, p, v);
                            } else {
                                actionHCost[i] = v;
                                p.decreaseKey(getNodeOf()[i], v);
                            }
                        }
                    }
                }
            }
        }
    }

    protected float relaxedPlanCost(State gs) {
        final Condition goal = preconditionFunction[pseudoGoal];

        final LinkedList<Pair<Collection, Float>> stack = new LinkedList();
        stack.push(getActivatingConditions(goal));
        plan = new IntArraySet();
        Arrays.fill(visited, false);
        helpfulActions = new IntArraySet();
        Arrays.fill(maxNumRepetition, 0);
        Arrays.fill(repetitionsInThePlan, null);
        while (!stack.isEmpty()) {

            final Pair<Collection, Float> elements;
            elements = stack.pollLast();
            for (final int conditionId : (Collection<Integer>) elements.getFirst()) {
                if (!visited[conditionId]) {
                    if (!getConditionInit()[conditionId]) {
                        if (isHelpfulActionsComputation()) {
                            if (getAchievers(conditionId).isEmpty()) {
                                throw new RuntimeException("Houston we have problem here. Condition \n" + Terminal.getTerminal(conditionId) + " has never been achieved");
                            }
                            for (final int id : getAchievers(conditionId)) {
                                if (getActionInit()[id]) {
                                    helpfulActions.add(id);
                                }
                            }
                        }
                        
                        final int actionId = establishedAchiever[conditionId];
                        final int rep = (int) ceil(numRepetition[conditionId]);
                        
                        if (repetitionsInThePlan[actionId] == null){
                            repetitionsInThePlan[actionId] = new IntArraySet();
                        }
                        
                        if (maxNumRepetition[actionId] != rep){
                            repetitionsInThePlan[actionId].add(rep);
                            maxNumRepetition[actionId] = Math.max(maxNumRepetition[actionId],rep);
                        }
                        plan.add(actionId);
                        stack.push(getActivatingConditions(preconditionFunction[actionId]));
                    }
                    visited[conditionId] = true;
                }
            }
        }
        
        //This is the MRP
        float ret = 0;
        for (final int action : plan) {
            ret += maxNumRepetition[action] * getActionCost()[action];
//            System.out.println(TransitionGround.getTransition(action) + " " + maxNumRepetition[action]);
        }

//        System.exit(-1);
        return ret;
    }

    @Override
    public Collection getAllEstimates() {
        return SearchHeuristic.super.getAllEstimates(); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    public IntArraySet getAchievers(int conditionId) {
        final IntArraySet achiever = getAllAchievers()[conditionId];
        if (achiever == null) {
            getAllAchievers()[conditionId] = new IntArraySet();
        }
        return getAllAchievers()[conditionId];
    }

    private void expand(int actionId, FibonacciHeap p, State s) {

        final IntSet conditionsAchievableByAction = getConditionsAchievableById(actionId);
        for (final int conditionId : conditionsAchievableByAction) {//This is for all terminal conditions
            if (!getConditionInit()[conditionId] && (!isReachability() || getConditionCost()[conditionId] == Float.MAX_VALUE)) {
                final Terminal t = Terminal.getTerminal(conditionId);
                boolean update = false;
                if (t instanceof BoolPredicate || t instanceof NotCond) {//affecting a prop variable
                    if (updateIfNeeded(conditionId, getActionHCost()[actionId] + getActionCost()[actionId])) {
                        update = true;
                        cacheValue(getActionCost()[actionId],actionId,t);
                        updateRelPlanInfo(conditionId, actionId, 1);
                    }
                } else {//affecting a num comparison
                    final double v = this.numericContribution(actionId, (Comparison) t);
                    if (v > 0) {
                       
                        float rep = computeRepetition(t,v,s);
                        final float newCost = rep * getActionCost()[actionId];
                        boolean localUpdate = false;
                        if (isAdditive()) {
                            localUpdate = updateIfNeeded(conditionId, getActionHCost()[actionId] + newCost);
                        } else {
                            if (getActionHCost()[actionId] < minAchieverPreconditionCost[conditionId]) {
                                minAchieverPreconditionCost[conditionId] = getActionHCost()[actionId];
                            }
                            localUpdate = updateIfNeeded(conditionId, minAchieverPreconditionCost[conditionId] + newCost);
                        }
                        if (localUpdate) {
                            cacheValue(newCost,actionId,t);
                            update = true;
                            updateRelPlanInfo(conditionId, actionId, rep);
                        }
                    } else if (v == UNKNOWNEFFECT) {//this is a hard condition basically
                        float newCost = 0f;
                        if (isAdditive()) {
                            newCost = getActionCost()[actionId];
                        }
                        if (updateIfNeeded(conditionId, getActionHCost()[actionId] + newCost)) {
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

    protected void updateAchievers(int conditionId, int actionId) {
        if (extractRelaxedPlan || useSmartConstraints || isHelpfulActionsComputation() ) {
            getAchievers(conditionId).add(actionId);
        }
    }

    protected void updateRelPlanInfo(int conditionId, int actionId, float rep) {
        if (extractRelaxedPlan || isHelpfulActionsComputation()) {
            establishedAchiever[conditionId] = actionId;
            numRepetition[conditionId] = rep;
        }
    }

    protected boolean updateIfNeeded(final int t, final float value) {
        if (getConditionCost()[t] > value) {
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
            for (final var son :  and.sons) {
                Pair<Collection, Float> activatingConditions = getActivatingConditions((Condition) son);
                cost += activatingConditions.getSecond();
                left.addAll(activatingConditions.getFirst());
            }
            return Pair.of(left, cost);

        } else if (c instanceof OrCond) {
            final OrCond and = (OrCond) c;
            if (and.sons == null) {
                return Pair.of(Collections.EMPTY_LIST, 0f);
            }
            float ret = Float.MAX_VALUE;
            Collection left = null;
            for (final var son :  and.sons) {
                final Pair<Collection, Float> estimate = getActivatingConditions((Condition) son);
                if (estimate.getSecond() != Float.MAX_VALUE) {
                    if (estimate.getSecond() < ret) {
                        ret = estimate.getSecond();
                        left = estimate.getFirst();
                    }
                }
            }
            return Pair.of(left, ret);
        } else if (c instanceof Terminal) {
            final Terminal t = (Terminal) c;
            return Pair.of(new IntArraySet(Collections.singleton(t.getId())), getConditionCost()[t.getId()]);
        } else {
            throw new RuntimeException("This is not supported:" + c);
        }
    }

    
    protected float estimateCost(final Condition c) {
        return this.estimateCost(c, isAdditive());
    }
    
    protected float estimateCost(final Condition c, float previous) {
        return this.estimateCost(c, isAdditive());
    }

    private float estimateCost(final Condition c, boolean additive) {
        if (c instanceof AndCond) {
            final AndCond and = (AndCond) c;
            if (and.sons == null) {
                return 0f;
            }
            float ret = 0f;
            for (final var son : and.sons) {
                final float estimate = estimateCost((Condition) son);
                if (estimate == Float.MAX_VALUE) {
                    return Float.MAX_VALUE;
                }
                if (additive && !isConjunctionsMax()) {// && !this.extractRelaxedPlan) {
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
            for (final Object son : and.sons) {
                final float estimate = estimateCost((Condition)son);
                if (estimate != Float.MAX_VALUE) {
                    ret = (estimate < ret) ? estimate : ret;
                }
            }
            return ret;
        } else if (c instanceof Terminal) {
            final Terminal t = (Terminal) c;
            return getConditionCost()[t.getId()];
        } else {
            return 0f;
        }
    }

    void setNumericContribution(int a, int b, float value) {
        if (hardcoreVersion) {
            numericContributionRaw[actionsArrayShifter.getTID(a)][termsArrayShifter.getTID(b)] = value;
        } else {
            numericContribution.put(Pair.of(actionsArrayShifter.getTID(a), termsArrayShifter.getTID(b)), value);
        }
    }

    public Float getNumericContribution(int a, int b) {
        if (hardcoreVersion) {
            return numericContributionRaw[actionsArrayShifter.getTID(a)][termsArrayShifter.getTID(b)];
        }
        return numericContribution.getOrDefault(Pair.of(actionsArrayShifter.getTID(a), termsArrayShifter.getTID(b)), Float.MAX_VALUE);
    }

    //Semantics: UNKNOWEFFECT don't know because comp is hard. > 0 is achiever, 0 no
    float numericContribution(int t, Comparison comp) {
        
        if (numericEffectFunction[t] == null || numericEffectFunction[t].isEmpty()) {
            return 0f;
        }

//        Float positiveness = numericContribution[t][comp.getId()];
        Float positiveness = getNumericContribution(t, comp.getId());

        if (positiveness == Float.MAX_VALUE) {
            positiveness = 0f;
            if (numericEffectFunction[t].isEmpty()) {
                setNumericContribution(t, comp.getId(), 0f);
                return positiveness;
            }
            if (comp.getLeft() instanceof ExtendedNormExpression) {
                final ExtendedNormExpression left = (ExtendedNormExpression) comp.getLeft();
                for (final ExtendedAddendum ad : left.summations) {
                    if (ad.bin != null) {
                        for (final NumEffect ne : numericEffectFunction[t]) {
                            NumFluent fluentAffected = ne.getFluentAffected();
                            if (ad.bin.getInvolvedNumericFluents().contains(fluentAffected)) {
                                return UNKNOWNEFFECT;
                            }
                        }
                    }
                    if (ad.f != null) {
                        for (final NumEffect ne : numericEffectFunction[t]) {

                            if (!ne.getFluentAffected().equals(ad.f)) {
                                continue;
                            }

                            if (ne.getInvolvedNumericFluents().isEmpty()) {
                                final ExtendedNormExpression rhs = (ExtendedNormExpression) ne.getRight();
                                if (!rhs.linear || !rhs.isNumber() || ne.getOperator().equals("assign")) {
                                    setNumericContribution(t, comp.getId(), UNKNOWNEFFECT);
                                    return UNKNOWNEFFECT;
                                }
                                if (ne.getOperator().equals("increase")) {
                                    positiveness += rhs.getNumber().floatValue() * ad.n.floatValue();
                                } else if (ne.getOperator().equals("decrease")) {
                                    positiveness += (-1) * rhs.getNumber().floatValue() * ad.n.floatValue();
                                }
                            } else {//The effect is state dependent.
                                return UNKNOWNEFFECT;
                            }
                        }
                    }
                }
                setNumericContribution(t, comp.getId(), positiveness);
                return positiveness;
            } else {
                throw new RuntimeException("At the moment only normalized expressions are considered " + comp);
            }
        }
        return positiveness;
    }

    @Override
    public Object[] getTransitions(final boolean helpful) {
        Collection res = null;
        if (helpfulActions == null || !helpful) {
            if (reachableTransitionsInstances == null) {
                if (reachableTransitions == null) {
                    res = getProblem().actions;
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
            final Collection actions = new ArrayList<>();
            for (final int i : helpfulActions) {
                final TransitionGround transition = (TransitionGround) getTransition(i);
                if (transition.getSemantics() == Transition.Semantics.ACTION) {
                    actions.add(transition);
                }
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
        return res.toArray();
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
        if (!extractRelaxedPlan && !isHelpfulActionsComputation()) {
            throw new RuntimeException("Helpful Transitions can only be activatated in combination with the relaxed plan extraction");
        }
        Collection<Pair<TransitionGround, Integer>> res = new ArrayList<>();
        for (final int actionId : plan) {
            if (getActionInit()[actionId]) {
                final IntArraySet right = repetitionsInThePlan[actionId];
                if (maxMRP) {
                    int max = 0;
                    for (int i : right) {
                        if (i > max) {
                            max = i;
                        }
                    }
                    if (max > 1) {
                        res.add(Pair.of((TransitionGround) getTransition(actionId), max));
                    }
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int i : right) {
                        if (i < min) {
                            min = i;
                        }
                    }
                    if (min > 1) {
                        res.add(Pair.of((TransitionGround) getTransition(actionId), min));
                    }
                }
            }
        }
        return res;
    }

    void addToRedundantMap(AndCond cond, IntArraySet ele) {
        if (redundantMap == null) {
            redundantMap = new HashMap();
        }
        Collection<IntArraySet> get = redundantMap.get(cond);
        if (get == null) {
            get = new HashSet();
        }
        get.add(ele);
        redundantMap.put(cond, get);
    }

    public Map<AndCond, Collection<IntArraySet>> generateSmartRedundantConstraints() {
        redundantMap = new HashMap();
        for (final int tid : allActions) {
            updateSmartConstraints(preconditionFunction[tid]);
        }
        if (false) {
            Set<Map.Entry<AndCond, Collection<IntArraySet>>> entrySet = redundantMap.entrySet();
            for (var v : entrySet) {
                System.out.println(v.getKey());
                for (IntArraySet i : v.getValue()) {
                    System.out.println("Redundant Set");
                    for (int j : i) {
                        System.out.println("-----" + Comparison.getTerminal(j));
                    }
                }
            }
        }
        return redundantMap;
    }

    private void updateSmartConstraints(Condition condition) {
        if ((condition instanceof BoolPredicate) || (condition instanceof NotCond)) {
            return;
        }
        if (condition instanceof AndCond) {
            final IntArraySet comparisons = new IntArraySet();
            for (var con : ((AndCond) condition).sons) {
                if (con instanceof Comparison) {
                    comparisons.add(((Comparison) con).getId());
                } else {
                    updateSmartConstraints((Condition) con);
                }
            }
            for (int id : comparisons) {
                IntArraySet achActs = getAllAchievers()[id];
                if (achActs != null) {
                    for (int actId : achActs) {
                        IntArraySet toberedundantwith = new IntArraySet();
                        toberedundantwith.add(id);
                        IntArraySet deleter = getConditionsDeletableBy()[actId];
                        for (int id2 : comparisons) {
                            if (id != id2) {
                                if (deleter.contains(id2)) {
                                    toberedundantwith.add(id2);
                                }
                            }
                        }
                        if (toberedundantwith.size() > 1) {
                            addToRedundantMap((AndCond) condition, toberedundantwith);
                        }
                    }
                }

            }

        }
        if (condition instanceof OrCond) {
            for (var con : ((OrCond) condition).sons) {
                updateSmartConstraints((Condition) con);
            }
        }

    }

    public void addDeleter(int i, int actId) {
        if (deleters[i] == null) {
            deleters[i] = new IntArraySet();
        }
        deleters[i].add(actId);
    }

    void updateDeleters(int t, int actionId) {
        addDeleter(t, actionId);
    }

    private Condition getNormalizedPrecondition(Condition preconditions, String redConstraints) {
        switch (redConstraints) {
            case "smart":
                if (redundantMap == null || redundantMap.isEmpty()) {
                    return preconditions.transformEquality();
                }
                return addSmartRedundantConstraints(preconditions.transformEquality());
            case "brute":
                return preconditions.transformEquality().introduce_red_constraints();
            default:
                return preconditions.transformEquality();
        }
    }

    private Condition addSmartRedundantConstraints(Condition cond) {
        if (cond instanceof Terminal) {
            return cond;
        }
        if (cond instanceof OrCond) {
            Collection newOr = new HashSet();
            for (var v : ((OrCond) cond).sons) {
                newOr.add(addSmartRedundantConstraints((Condition) v));
            }
            return new OrCond(newOr);
        }
        if (cond instanceof AndCond) {
            Collection and = new HashSet();
            Collection<IntArraySet> get = redundantMap.get((AndCond) cond);
            for (var v : ((AndCond) cond).sons) {
                and.add((Condition) v);
            }
            if (get != null) {
                System.out.println("One Redundant Constraint added");
                for (var v : get) {
                    Comparison previous = null;
                    for (int i : v) {
                        if (previous != null) {
                            previous = AndCond.generateRedConstraints((Comparison) Comparison.getTerminal(i), previous);
                        } else {
                            previous = (Comparison) Comparison.getTerminal(i);
                        }

                    }
                    if (previous != null) {
                        and.add(previous);
                    }
                }
            }
            return new AndCond(and);
        } else {
            throw new RuntimeException("This was unexepected:" + cond);
        }

    }

    public Condition getGoalFormulation() {
        return preconditionFunction[pseudoGoal];
    }

    protected IntSet getConditionsAchievableById(int actionId) {
        if (getConditionsAchievableBy()[actionId] == null) {
            final IntArraySet achievableTerms = new IntArraySet();
            final IntArraySet deletableTerms = new IntArraySet();
            for (final int t : getAllComparisons()) {
                final float v = this.numericContribution(actionId, (Comparison) Terminal.getTerminal(t));
                if (v > 0 || v == UNKNOWNEFFECT) {
                    achievableTerms.add(t);
                    updateAchievers(t, actionId);
                    if (DEBUG) {
                        System.out.println("Transition: " + getTransition(actionId));
                        System.out.println("Comparison Achievable: " + Terminal.getTerminal(t));
                        System.out.println("Numeric Contribution: " + v);
                    }
                } else {
                    if (v < 0 && useSmartConstraints) {
                        if (DEBUG) {
                            System.out.print(Transition.getTransition(actionId) + " worsens");
                            System.out.println((Comparison) Terminal.getTerminal(t));
                        }
                        updateDeleters(t, actionId);
                        deletableTerms.add(t);
                    }
                }
            }
            Sets.SetView<Integer> intersection = Sets.intersection(getAllConditions(), (Set<Integer>)propEffectFunction[actionId]);
            achievableTerms.addAll(intersection);
            for (final int o : intersection) {
                updateAchievers(o, actionId);
            }
            conditionsAchievableBy[actionId] = achievableTerms;
            if (useSmartConstraints)
                conditionsDeletableBy[actionId] = deletableTerms;

        }
        return getConditionsAchievableBy()[actionId];
    }

   
        
    private String printTransition(Integer key) {
        if (key == pseudoGoal){
            return "GoalAction";
        }else{
            return TransitionGround.getTransition(key).toString();
        }

    }

    private float computeRepetition(Terminal t, double v, State s) {
        return (float) (-1f * ((Comparison) t).getLeft().eval(s) / v);
    }



    protected void cacheValue(float rep, int actionId, Terminal t) {
        
    }

    protected boolean update(Terminal t, boolean update, int actionId) {
        return update;
    }

    /**
     * @return the allAchievers
     */
    public IntArraySet[] getAllAchievers() {
        if (allAchievers == null){
            allAchievers = new IntArraySet[getTotNumberOfTerms()];
        }
        return allAchievers;
    }

    /**
     * @return the totNumberOfTerms
     */
    public int getTotNumberOfTerms() {
        return totNumberOfTerms;
    }

    /**
     * @return the totNumberOfTermsRefactored
     */
    public int getTotNumberOfTermsRefactored() {
        return totNumberOfTermsRefactored;
    }

    /**
     * @return the problem
     */
    public PDDLProblem getProblem() {
        return problem;
    }

    /**
     * @return the helpfulActionsComputation
     */
    public boolean isHelpfulActionsComputation() {
        return helpfulActionsComputation;
    }

    /**
     * @return the conditionsAchievableBy
     */
    public IntArraySet[] getConditionsAchievableBy() {
        return conditionsAchievableBy;
    }

    /**
     * @return the conditionsDeletableBy
     */
    public IntArraySet[] getConditionsDeletableBy() {
        return conditionsDeletableBy;
    }

    /**
     * @return the conditionToAction
     */
    public IntArraySet[] getConditionToAction() {
        return conditionToAction;
    }

    /**
     * @return the allConditions
     */
    public IntArraySet getAllConditions() {
        return allConditions;
    }
    
        /**
     * @return the reachableAchievers
     */
    public IntArraySet[] getReachableAchievers() {
        return allAchievers;
    }

    /**
     * @return the allComparisons
     */
    public IntArraySet getAllComparisons() {
        return allComparisons;
    }

    /**
     * @return the nodeOf
     */
    public FibonacciHeapNode[] getNodeOf() {
        return nodeOf;
    }

    /**
     * @return the reachability
     */
    public boolean isReachability() {
        return reachability;
    }

    /**
     * @return the conjunctionsMax
     */
    public boolean isConjunctionsMax() {
        return conjunctionsMax;
    }

    /**
     * @return the actionCost
     */
    public float[] getActionCost() {
        return actionCost;
    }

    /**
     * @return the actionHCost
     */
    public float[] getActionHCost() {
        return actionHCost;
    }

    /**
     * @return the conditionCost
     */
    public float[] getConditionCost() {
        return conditionCost;
    }

    /**
     * @return the closed
     */
    public boolean[] getClosed() {
        return closed;
    }

    /**
     * @return the additive
     */
    public boolean isAdditive() {
        return additive;
    }

    /**
     * @return the conditionInit
     */
    public boolean[] getConditionInit() {
        return conditionInit;
    }

    /**
     * @return the actionInit
     */
    public boolean[] getActionInit() {
        return actionInit;
    }


}

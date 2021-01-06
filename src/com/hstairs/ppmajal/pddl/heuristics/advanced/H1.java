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
import com.hstairs.ppmajal.expressions.Expression;
import com.hstairs.ppmajal.expressions.ExtendedAddendum;
import com.hstairs.ppmajal.expressions.ExtendedNormExpression;
import com.hstairs.ppmajal.expressions.NumEffect;
import com.hstairs.ppmajal.expressions.NumFluent;
import com.hstairs.ppmajal.extraUtils.ArrayShifter;
import com.hstairs.ppmajal.problem.EPddlProblem;
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
import it.unimi.dsi.fastutil.floats.FloatArrayList;
import it.unimi.dsi.fastutil.ints.IntSet;
import org.jgrapht.graph.DirectedAcyclicGraph;
import org.jgrapht.opt.graph.fastutil.FastutilFastLookupIntVertexGSS;

/**
 * @author enrico
 */
public class H1 implements SearchHeuristic {

    private static final boolean DEBUG = false;
    final public boolean extractRelaxedPlan;
    final public boolean maxMRP;

    final protected int pseudoGoal;
    final protected Condition[] preconditionFunction;
    final protected Collection<Integer>[] propEffectFunction;
    final protected Collection<NumEffect>[] numericEffectFunction;
    final protected int heuristicNumberOfActions;
    final protected int totNumberOfTerms;
    final private int totNumberOfTermsRefactored;

    final protected EPddlProblem problem;
    final private boolean helpfulActionsComputation;
    protected final IntArraySet[] conditionsAchievableBy;
    private final IntArraySet[] conditionsDeletableBy;
    protected final IntArraySet[] conditionToAction;
    protected final IntArraySet allConditions;
    private final IntArraySet allComparisons;
    private final FibonacciHeapNode[] nodeOf;
    private boolean reachability;
    private final boolean conjunctionsMax;

    final protected float[] actionCost;
    final protected float[] actionHCost;
    final protected float[] conditionCost;
    final protected boolean[] closed;

    protected final boolean additive;
    protected final boolean[] conditionInit;
    protected final boolean[] actionInit;
    private final boolean helpfulTransitions;
    private final boolean hardcoreVersion;
    private final float[][] numericContributionRaw;
    private final Map<Pair<Integer, Integer>, Float> numericContribution;
    private final ArrayShifter termsArrayShifter;
    private final ArrayShifter actionsArrayShifter;
    private final int totNumberOfActionsRefactored;
    private IntArraySet[] achievers;
    private IntArraySet[] deleters;
    private int[] establishedAchiever;
    private float[] numRepetition;
    private IntArraySet helpfulActions;
    private IntArraySet reachableTransitions;
    private Collection<TransitionGround> reachableTransitionsInstances;

    final private float UNKNOWNEFFECT = Float.NEGATIVE_INFINITY;
    final protected IntArraySet freePreconditionActions;
    private List<Pair<Integer, IntArraySet>> plan;
    private float[] minAchieverPreconditionCost;
    private IntArraySet allActions;

    Map<AndCond, Collection<IntArraySet>> redundantMap;
    private final boolean useSmartConstraints;
    
    

    //Plan Fixing Data Structures;
    final IntArraySet[] prec ;
    final int[] maxNumRepetition ;
    final int[] minNumRepetition ;
    private boolean planFixing;
    private boolean superFix = false;
    final private boolean saferVersion; 

    final boolean[] visited;
    final boolean[] visitedActions;
    private Collection<Float> estimates;

    
    
    public H1(EPddlProblem problem) {
        this(problem, true, false, false, "no", false, false, false, false, null,false,false);
    }

    public H1(EPddlProblem problem, boolean additive, boolean planFixing) {
        this(problem, additive, false, false, "no", false, false, false, false, null, planFixing,false);
    }
    
    public H1(EPddlProblem problem, boolean additive) {
        this(problem, additive, false, false, "no", false, false, false, false, null, false, false);
    }

    public H1(EPddlProblem problem, boolean additive, boolean extractRelaxedPlan, boolean maxHelpfulTransitions, String redConstraints, boolean helpfulActionsComputation, boolean reachability,
            boolean helpfulTransitions, boolean conjunctionsMax) {
        this(problem, additive, extractRelaxedPlan, maxHelpfulTransitions, redConstraints, helpfulActionsComputation, reachability, helpfulTransitions, conjunctionsMax, null,false, false);
    }

    public H1(EPddlProblem problem, boolean additive, boolean extractRelaxedPlan, boolean maxHelpfulTransitions, String redConstraints, boolean helpfulActionsComputation, boolean reachability,
            boolean helpfulTransitions, boolean conjunctionsMax, Map<AndCond, Collection<IntArraySet>> redundantMap, boolean planFixing, boolean easyPlanFixing) {

        long startSetup = System.currentTimeMillis();
        this.planFixing = planFixing;
        this.saferVersion = easyPlanFixing;
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

        termsArrayShifter = new ArrayShifter(allConditions);
        totNumberOfTermsRefactored = termsArrayShifter.getMaxTid();

        actionsArrayShifter = new ArrayShifter(allActions);
        totNumberOfActionsRefactored = actionsArrayShifter.getMaxTid();

        actionHCost = new float[heuristicNumberOfActions];
        conditionCost = new float[totNumberOfTerms];
        closed = new boolean[heuristicNumberOfActions];

        hardcoreVersion = heuristicNumberOfActions * totNumberOfTermsRefactored < 1999999999;
        System.out.println("Heuristic Number of Actions:" + heuristicNumberOfActions);
        System.out.println("Heuristic Number of Actions Refactored:" + totNumberOfActionsRefactored);
        System.out.println("Tot Number of Terms:" + totNumberOfTerms);
        System.out.println("Tot Number of Terms Refactored:" + totNumberOfTermsRefactored);

        if (hardcoreVersion) {
            numericContributionRaw = new float[totNumberOfActionsRefactored][totNumberOfTermsRefactored];
            for (final float[] row : numericContributionRaw) {
                Arrays.fill(row, Float.MAX_VALUE);
            }
            numericContribution = null;
        } else {
            System.out.println("H1 with small memory footprint");
            numericContributionRaw = null;
            numericContribution = new HashMap<>();
        }
        //        numericContribution = new HashMap<>();

        conditionInit = new boolean[totNumberOfTerms];
        actionInit = new boolean[heuristicNumberOfActions];
        if (extractRelaxedPlan || useSmartConstraints) {
            achievers = new IntArraySet[totNumberOfTerms];
        }
        if (useSmartConstraints) {
            deleters = new IntArraySet[totNumberOfTerms];
        }
        if (extractRelaxedPlan) {
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
//        System.exit(-1);

        // Optimisation. Make this dependent on whether you use smart redundant constraints or not.
        conditionsDeletableBy = new IntArraySet[heuristicNumberOfActions];
        
        if (planFixing){
            prec = new IntArraySet[heuristicNumberOfActions];
            visitedActions = new boolean[heuristicNumberOfActions];
        }else{
            prec = null;
            visitedActions = null;
        }
        if (extractRelaxedPlan){
            maxNumRepetition = new int[heuristicNumberOfActions];
            minNumRepetition = new int[heuristicNumberOfActions];
            visited = new boolean[totNumberOfTerms];
        }else{
            visited = null;
            maxNumRepetition = null;
            minNumRepetition = null;
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
            actionCost[b.getId()] = b.getActionCost(problem.getInit(), problem.getMetric(), problem.isSdac());
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

    protected FibonacciHeap smallSetup(State gs) {
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
        return h;
    }

    @Override
    public float computeEstimate(State gs) {
        estimates = new FloatArrayList();
        if (achievers == null){
            reachability = true;
        }
        final FibonacciHeap h = this.smallSetup(gs);
        while (!h.isEmpty()) {
            final int actionId = (int) h.removeMin().getData();
            if (actionId == pseudoGoal && !reachability) {
                if (extractRelaxedPlan) {
                    return relaxedPlanCost(gs);
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
        
        estimates.add(actionHCost[pseudoGoal]);
        
        return extractRelaxedPlan && actionHCost[pseudoGoal] != Float.MAX_VALUE ? relaxedPlanCost(gs) : actionHCost[pseudoGoal];

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

    private float relaxedPlanCost(State gs) {
        final Condition goal = preconditionFunction[pseudoGoal];

        final LinkedList<Pair<Collection, Float>> stack = new LinkedList();
        stack.push(getActivatingConditions(goal));
        plan = new ArrayList();
        Arrays.fill(visited, false);
        helpfulActions = new IntArraySet();
        Arrays.fill(maxNumRepetition, 0);

        while (!stack.isEmpty()) {

            final Pair<Collection, Float> elements;
            elements = stack.pollLast();
            for (final int conditionId : (Collection<Integer>) elements.getFirst()) {
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
                        final int rep = (int) ceil(numRepetition[conditionId]);
                        
                        maxNumRepetition[actionId] = Math.max(maxNumRepetition[actionId],rep);
                        boolean inserted = false;
                        for (int i = plan.size() - 1; i >= 0; i--) {
                            if (plan.get(i).getFirst() == actionId) {
                                final IntArraySet right = plan.get(i).getSecond();
                                right.add(rep);
                                inserted = true;
                                break;
                            }
                        }
                        if (!inserted) {
                            final IntArraySet t = new IntArraySet();
                            t.add(rep);
                            plan.add(Pair.of(actionId, t));
                            stack.push(getActivatingConditions(preconditionFunction[actionId]));
                        }
                    }
                    visited[conditionId] = true;
                }
            }
        }
        
        //This is the MRP
        float ret = 0;
        for (final Pair<Integer, IntArraySet> action : plan) {
            ret += maxNumRepetition[action.getFirst()] * actionCost[action.getFirst()];
        }
        estimates.add(ret);
        if (planFixing){
            final float fixPlan = fixPlan(gs, plan);
            estimates.add(fixPlan);
            return fixPlan;
        }     

        return ret;
    }

    @Override
    public Collection getAllEstimates() {
        return SearchHeuristic.super.getAllEstimates(); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    protected IntArraySet getAchiever(int conditionId) {
        final IntArraySet achiever = achievers[conditionId];
        if (achiever == null) {
            achievers[conditionId] = new IntArraySet();
        }
        return achievers[conditionId];
    }

    private void expand(int actionId, FibonacciHeap p, State s) {

        final IntSet conditionsAchievableByAction = getConditionsAchievableById(actionId);
        for (final int conditionId : conditionsAchievableByAction) {//This is for all terminal conditions
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
                       
                        float rep = computeRepetition(t,v,s);
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
        if (extractRelaxedPlan || useSmartConstraints) {
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
            for (final Condition son : (Collection<Condition>) and.sons) {
                final Pair<Collection, Float> estimate = getActivatingConditions(son);
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
            return Pair.of(new IntArraySet(Collections.singleton(t.getId())), conditionCost[t.getId()]);
        } else {
            throw new RuntimeException("This is not supported:" + c);
        }
    }

    private float estimateCost(final Condition c) {
        return this.estimateCost(c, additive);
    }

    private float estimateCost(final Condition c, boolean additive) {
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

    void setNumericContribution(int a, int b, float value) {
        if (hardcoreVersion) {
            numericContributionRaw[actionsArrayShifter.getTID(a)][termsArrayShifter.getTID(b)] = value;
        } else {
            numericContribution.put(Pair.of(actionsArrayShifter.getTID(a), termsArrayShifter.getTID(b)), value);
        }
    }

    Float getNumericContribution(int a, int b) {
        if (hardcoreVersion) {
            return numericContributionRaw[actionsArrayShifter.getTID(a)][termsArrayShifter.getTID(b)];
        }
        return numericContribution.getOrDefault(Pair.of(actionsArrayShifter.getTID(a), termsArrayShifter.getTID(b)), Float.MAX_VALUE);
    }

    //Semantics: UNKNOWEFFECT don't know because comp is hard. > 0 is achiever, 0 no
    float numericContribution(int t, Comparison comp) {
        if (numericEffectFunction[t].isEmpty()) {
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
            if (actionInit[pair.getFirst()]) {
                final IntArraySet right = pair.getSecond();
                if (maxMRP) {
                    int max = 0;
                    for (int i : right) {
                        if (i > max) {
                            max = i;
                        }
                    }
                    if (max > 1) {
                        res.add(Pair.of((TransitionGround) getTransition(pair.getFirst()), max));
                    }
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int i : right) {
                        if (i < min) {
                            min = i;
                        }
                    }
                    if (min > 1) {
                        res.add(Pair.of((TransitionGround) getTransition(pair.getFirst()), min));
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
        if ((condition instanceof Predicate) || (condition instanceof NotCond)) {
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
                IntArraySet achActs = achievers[id];
                if (achActs != null) {
                    for (int actId : achActs) {
                        IntArraySet toberedundantwith = new IntArraySet();
                        toberedundantwith.add(id);
                        IntArraySet deleter = conditionsDeletableBy[actId];
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

    private void updateDeleters(int t, int actionId) {
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
            OrCond newOr = new OrCond();
            for (var v : ((OrCond) cond).sons) {
                newOr.addConditions(addSmartRedundantConstraints((Condition) v));
            }
            return newOr;
        }
        if (cond instanceof AndCond) {
            AndCond and = new AndCond();
            Collection<IntArraySet> get = redundantMap.get((AndCond) cond);
            for (var v : ((AndCond) cond).sons) {
                and.addConditions((Condition) v);
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
                        and.addConditions(previous);
                    }
                }
            }
            return and;
        } else {
            throw new RuntimeException("This was unexepected:" + cond);
        }

    }

    public Condition getGoalFormulation() {
        return preconditionFunction[pseudoGoal];
    }

    protected IntSet getConditionsAchievableById(int actionId) {
        if (conditionsAchievableBy[actionId] == null) {
            final IntArraySet achievableTerms = new IntArraySet();
            final IntArraySet deletableTerms = new IntArraySet();
            for (final int t : allComparisons) {
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
            Sets.SetView<Integer> intersection = Sets.intersection(allConditions, (Set<Integer>)propEffectFunction[actionId]);
            achievableTerms.addAll(intersection);
            for (final int o : intersection) {
                updateAchievers(o, actionId);
            }
            conditionsAchievableBy[actionId] = achievableTerms;
            conditionsDeletableBy[actionId] = deletableTerms;

        }
        return conditionsAchievableBy[actionId];
    }

    private float fixPlan(State gs, List<Pair<Integer, IntArraySet>> plan1) {
        
        //Compute DG
        final Condition goal = preconditionFunction[pseudoGoal];

        final IntArraySet V = new IntArraySet();

        final DirectedAcyclicGraph DG = new DirectedAcyclicGraph(FastutilFastLookupIntVertexGSS.class);
//        final FastutilMapIntVertexGraph<Integer> DG = new FastutilMapIntVertexGraph<>(
//         SupplierUtil.createIntegerSupplier(), 
//         SupplierUtil.createIntegerSupplier(),
//         DefaultGraphType.dag(), true);
//        new DirectedAcyclicGraph();
        
        Arrays.fill(prec, null);
        Arrays.fill(visitedActions, false);
        Arrays.fill(maxNumRepetition, 0);
//        Arrays.fill(minNumRepetition, Integer.MAX_VALUE);
        
        final int[] repetitionToConsider = maxNumRepetition;
        
        //Construct graph;
        final LinkedList<Integer> stack = new LinkedList();
        stack.push(pseudoGoal);
        while (!stack.isEmpty()) {
            int a = stack.pollLast();
            if (!visitedActions[a]){                
                V.add(a);
                DG.addVertex(a);
                visitedActions[a] = true;
                for (final int conditionId : (Collection<Integer>)getActivatingConditions(preconditionFunction[a]).getFirst()) {
                        if (!conditionInit[conditionId]) {
                            final int b = establishedAchiever[conditionId];
                            maxNumRepetition[b] = (int) Math.max(maxNumRepetition[b],ceil(numRepetition[conditionId]));
//                            minNumRepetition[b] = (int) Math.min(minNumRepetition[b],ceil(numRepetition[conditionId]));
                            if (prec[a] == null){
                                prec[a] = new IntArraySet();
                            }
                            prec[a].add(b);
                            if (!visitedActions[b]){
                                DG.addVertex(b);
                            }
                            DG.addEdge(b,a);
                            stack.push(b);
                            
                        }
                }
            }
            
        }
        
        //Exploit Graph for mitigating the effect of the action preconditions
        Iterator topo = DG.iterator();
        
        int[] orderedActions = new int[DG.vertexSet().size()];
        int idx = 0;
        while (topo.hasNext()){
            orderedActions[idx] = (int) topo.next();
            idx++;
        }
        
        
        int extraCost =0;
        final IntArraySet[] descendants = new IntArraySet[heuristicNumberOfActions];
        Arrays.fill(descendants, null);
        
        computeDescendants(pseudoGoal, prec, descendants);
        
        for (idx = DG.vertexSet().size()-1; idx >= 0; idx--){
            int a = orderedActions[idx];
            for (final int conditionId : (Collection<Integer>)getActivatingConditions(preconditionFunction[a]).getFirst()) {
                final Terminal terminal = Terminal.getTerminal(conditionId);
                if (terminal instanceof Comparison){
                    final Comparison c = (Comparison)terminal;
                    float cum = 0;
//                        for (int j=0; j < idx ; j++){
//                            int b = orderedActions[j];
                        for (int b : descendants[a]){
//                            System.out.println(printTransition(b));
                            float numericContribution1 = numericContribution(b, c);
                            if (numericContribution1 != 0f || numericContribution1 != Float.MAX_VALUE){
                                cum += numericContribution1 * repetitionToConsider[b];
                            }
                        }
                        if (a != pseudoGoal && repetitionToConsider[a]>1){
                            float numericContribution1 = numericContribution(a, c);
                            if (numericContribution1 != 0f || numericContribution1 != Float.MAX_VALUE){
                                cum += numericContribution1*(repetitionToConsider[a]-1);
                            }
                        }
                        final Expression left = c.getLeft();
                        final double eval = left.eval(gs);
                        final float T = (float) (eval + cum);
                        if (T < 0) {
                        if (saferVersion) {
                            if (true){
                                IntArraySet achieverSet = achievers[conditionId];
                                if (achieverSet!= null && !achieverSet.isEmpty()) {
                                    int min = Integer.MAX_VALUE;
                                    int best = -1;

                                    for (var i : achieverSet) {
                                        int ceil = (int) ceil(-1f * (T / numericContribution(i, c)));
                                        if (ceil < min) {
                                            min = ceil;
                                            best = i;
                                        }
                                    }
                                    extraCost += actionCost[best];
                                }else{
                                    extraCost += 1;
                                }
                            }else{
                                extraCost += 1;
                            }
                        } else {

                                int achiever = establishedAchiever[conditionId];
                                if (achiever != -1) { //this is the case where there is an achiever already in the plan
                                    int repetition = (int) ceil(-1f * (T / numericContribution(achiever, c)));
                                    maxNumRepetition[achiever] = maxNumRepetition[achiever] + repetition;
                                } else {
                                    if (superFix) {//mmmmmmm
                                        IntArraySet achieverSet = achievers[conditionId];
                                        if (!achieverSet.isEmpty()) {
                                            int min = Integer.MAX_VALUE;
                                            int best = -1;
                                            for (var i : achieverSet) {
                                                int ceil = (int) ceil(-1f * (T / numericContribution(i, c)));
                                                if (ceil < min) {
                                                    min = ceil;
                                                    best = i;
                                                }
                                            }
                                            if (actionHCost[best] != Float.MAX_VALUE) {
                                                extraCost += actionHCost[best];
                                            } else {
                                                extraCost += 1;
                                            }
                                            extraCost += min;
                                        }
                                    }
                                }
                            }
                        
                    }
                }
            }
        }
        float estimate = 0f;
        for (int aId : V){
            estimate += maxNumRepetition[aId] *actionCost[aId];
        }
        return estimate+extraCost;
        
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


    private IntArraySet computeDescendants(int actionId, IntArraySet[] prec, IntArraySet[] descendants) {
        
        if (descendants[actionId] != null){
            return descendants[actionId];
        }
        final IntArraySet res = new IntArraySet();
        if (prec[actionId] != null) {
            for (int b : prec[actionId]) {
                res.add(b);
                res.addAll(computeDescendants(b, prec, descendants));
            }
        }
        descendants[actionId] = res;
        return res;  
        
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hstairs.ppmajal.pddl.heuristics.advanced;

import com.hstairs.ppmajal.conditions.AndCond;
import com.hstairs.ppmajal.conditions.Comparison;
import com.hstairs.ppmajal.conditions.Condition;
import com.hstairs.ppmajal.conditions.OrCond;
import com.hstairs.ppmajal.conditions.Terminal;
import com.hstairs.ppmajal.pddl.heuristics.utils.LpInterface;
import com.hstairs.ppmajal.problem.EPddlProblem;
import com.hstairs.ppmajal.problem.State;
import ilog.concert.IloException;
import ilog.concert.IloLinearNumExpr;
import ilog.concert.IloNumVar;
import ilog.concert.IloNumVarType;
import ilog.concert.IloRange;
import ilog.cplex.IloCplex;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntArraySet;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author enrico
 */
public class LM extends H1 {

    final private boolean[] reachedConditions;
    final private boolean[] reachedActions;
    final private IntOpenHashSet[] lmC;
    final private IntOpenHashSet[] lmA;
    private final String mode;
    final private LpInterface lpSolver;
    private IloCplex lp;
    private IloNumVar[] lpvar;
    private IloRange[] lpcond;
    final private  IntArraySet[] reachableAchievers;
    private IloLinearNumExpr objectiveFunction;
            

    public LM(EPddlProblem problem) {
        this(problem, "lmCount","no");
    }

    public LM(EPddlProblem problem, String mode, String redundantConstraints) {
        super(problem, true, true, false, redundantConstraints, false, false, false, false, null);
        reachedConditions = new boolean[totNumberOfTerms];
        reachedActions = new boolean[heuristicNumberOfActions];
        lmC = new IntOpenHashSet[totNumberOfTerms];
        lmA = new IntOpenHashSet[heuristicNumberOfActions];
        this.mode = mode;
        lpSolver = new LpInterface();
        reachableAchievers = new IntArraySet[totNumberOfTerms];
        
    }


    @Override
    public float computeEstimate(State s) {

        final IntArrayList q = quickReset(s);

        while (!q.isEmpty()) {
            final int a = q.popInt();
            if (a != pseudoGoal) {
                expand(a, q);
            }
        }

        if ("lmCount".equals(mode)) {
            return countMissing();
        } else if ("lp".equals(mode)) {
            return this.solveLp(s, lmA[pseudoGoal]);
        }
        return 0f;
    }

    boolean checkReached(final Condition c) {
        if (c instanceof AndCond) {
            final AndCond and = (AndCond) c;
            if (and.sons == null) {
                return true;
            }
            for (final Condition son : (Collection<Condition>) and.sons) {
                if (!checkReached(son)) {
                    return false;
                }
            }
            return true;

        } else if (c instanceof OrCond) {
            final OrCond and = (OrCond) c;
            if (and.sons == null) {
                return true;
            }
            for (final Condition son : (Collection<Condition>) and.sons) {
                if (checkReached(son)) {
                    return true;
                }
            }
            return false;
        } else if (c instanceof Terminal) {
            final Terminal t = (Terminal) c;
            return reachedConditions[t.getId()];
        } else {
            return true;
        }
    }

    private void updateActions(int i, IntArrayList q, int a) {
        final IntArraySet actions = conditionToAction[i];
        for (final int a1 : actions) {
            if (a == a1) {
                continue;
            }
            final Condition name = preconditionFunction[a1];
            if (reachedActions[a1] || checkReached(name)) {
                reachedActions[a1] = true;
                lmA[a1] = new IntOpenHashSet();
                if (name instanceof AndCond) {
                    for (final Object t : ((AndCond) name).sons) {
                        if (t instanceof Terminal) {
                            lmA[a1].addAll(lmC[((Terminal) t).getId()]);
                            if (!conditionInit[((Terminal) t).getId()]) {
                                lmA[a1].add(((Terminal) t).getId());
                            }
                        }
                    }
                } else {
                    throw new UnsupportedOperationException("Only And Condition supported");
                }
                q.add(a1);
            }
        }
    }

    private boolean updateCondition(int p, int a) {
        if (!reachedConditions[p]) {
            reachedConditions[p] = true;
            lmC[p] = new IntOpenHashSet(lmA[a]);
            return true;
        } else {
            boolean changed = false;
            final IntOpenHashSet newSet = new IntOpenHashSet();
            for (final int sg : lmC[p]) {
                if (!lmA[a].contains(sg)) {
                    changed = true;
                } else {
                    if (changed) {
                        newSet.add(sg);
                    }
                }
            }
            if (changed) {
                lmC[p] = newSet;
            }
            return changed;
        }
    }

    private void expand(int a, IntArrayList q) {
        final Collection<Integer> conditions = getConditionsAchievableById(a);
        for (final int p : conditions) {
            if (!conditionInit[p]) {
                reachableAchievers[p].add(a);
                final boolean changed = updateCondition(p, a);
                if (changed) {
                    updateActions(p, q, a);
                }
            }
        }
    }

    private void printLandmarks() {
        AndCond goal = (AndCond) problem.goals;
        System.out.println("Landmarks");
        for (int sg : lmA[pseudoGoal]) {
            System.out.println(Terminal.getTerminal(sg));
        }
    }

    private IntArrayList quickReset(State s) {
        final IntArrayList q = new IntArrayList();
        Arrays.fill(conditionInit, false);
        Arrays.fill(reachedConditions, false);
        Arrays.fill(reachedActions, false);
        
        for (final int i : allConditions) {
            reachableAchievers[i] = new IntArraySet();
            if (s.satisfy(Terminal.getTerminal(i))) {
                conditionInit[i] = true;
                reachedConditions[i] = true;
                lmC[i] = new IntOpenHashSet();
                updateActions(i, q, -1);
            }
        }
        for (final int a : freePreconditionActions) {
            q.add(a);
            lmA[a] = new IntOpenHashSet();
        }
        return q;
    }

    private int countMissing() {
        int lmCount = 0;
        for (int lm : lmA[pseudoGoal]) {
            if (!conditionInit[lm]) {
                lmCount++;
            }
        }
        return lmCount;
    }
    
    private void initLp(State s) {
        if (lp == null) {
            try {
                lpvar = new IloNumVar[heuristicNumberOfActions];
                lpcond = new IloRange[totNumberOfTerms];
                lp = new IloCplex();
                lp.setOut(null);
                objectiveFunction = lp.linearNumExpr();
                for (int p : allConditions) {
                    final Terminal terminal = Terminal.getTerminal(p);
                    final IloLinearNumExpr expr = lp.linearNumExpr();
                    for (int a : getAchiever(p)) {
                        Float numericContribution = 1f;
                        if (terminal instanceof Comparison) {
                            numericContribution = getNumericContribution(a, p);
                        }
                        if (lpvar[a] == null) {
                            lpvar[a] = lp.numVar(0.0, 0.0, IloNumVarType.Float);
                            objectiveFunction.addTerm(lpvar[a], actionCost[a]);
                        }
                        expr.addTerm(lpvar[a], numericContribution);
                    }
                    final IloRange ilo = lp.addGe(expr, 0f);
                    lpcond[p] = ilo;
                }
                lp.addMinimize(objectiveFunction);
            } catch (IloException ex) {
                Logger.getLogger(LM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private float solveLp(State s, IntOpenHashSet lms) {

        try {
            initLp(s);
            for (var i :allConditions){//Need to be reset; only lm are going to be targeted with a value
                lpcond[i].setLB(0f);
            }
            for (var lm : lms) {//by default they are not sat in the initial state
                if (!conditionInit[lm]){
                    final Terminal t = Terminal.getTerminal(lm);
                    final IloRange constraint = lpcond[lm];
                    if (t instanceof Comparison) {
                        double targetValue = -1d * ((Comparison) t).getLeft().eval(s);
                        constraint.setLB(targetValue);
                    } else {
                        constraint.setLB(1f);
                    }
                    for (var a : reachableAchievers[lm]) { //these are reachable actions achieving lm
                        lpvar[a].setUB(Float.MAX_VALUE);
                    }
                }
            }
            if (lp.solve()){
                return (float) lp.getObjValue();
            }
       
        } catch (IloException ex) {
            Logger.getLogger(LM.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Float.MAX_VALUE;
    }
}

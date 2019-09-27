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
import com.hstairs.ppmajal.expressions.NumEffect;
import com.hstairs.ppmajal.heuristics.Heuristic;
import com.hstairs.ppmajal.problem.EPddlProblem;
import com.hstairs.ppmajal.problem.State;
import com.hstairs.ppmajal.transition.Transition;
import com.hstairs.ppmajal.transition.TransitionGround;
import it.unimi.dsi.fastutil.ints.IntComparator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import static com.google.common.collect.Sets.SetView;

/**
 * @author enrico
 */
public class h1 implements Heuristic {

    final private boolean useRedundantConstraints;
    final public boolean extractRelaxedPlan;

    final private int pseudoGoal;
    final private Condition[] preconditionFunction;
    final private Collection<Condition>[] propEffectFunction;
    final private Collection<NumEffect>[] numericEffectFunction;
    final private int heuristicNumberOfActions;
    final private int totNumberOfTerms;
    final private EPddlProblem problem;
    private final Collection[] invertedAchievers;
    private final Collection[] achieve;
    private final Collection[] possibleAchievers;
    private final Collection[] invertedPossibleAchievers;
    private final Collection[] preconditionToAction;
    private final Collection[] conditionToAction;

    private float[] actionCost;
    protected float[] actionHCost;


    private final boolean additive;

    public h1(EPddlProblem problem){
        this(problem,true);
    }
    public h1(EPddlProblem problem, boolean additive) {
        this.additive = additive;
        this.problem = problem;
        this.useRedundantConstraints = false;
        extractRelaxedPlan = true;
        ArrayList<TransitionGround> internalActions = new ArrayList<>();
        pseudoGoal = Transition.totNumberOfTransitions;
        heuristicNumberOfActions = Transition.totNumberOfTransitions+1;
        preconditionFunction = new Condition[heuristicNumberOfActions];
        propEffectFunction = new Collection[heuristicNumberOfActions];
        numericEffectFunction = new Collection[heuristicNumberOfActions];

        SetView<TransitionGround> transitions = Sets.union(Sets.union(new HashSet(problem.actions), problem.getEventsSet()),problem.getProcessesSet());
        for (TransitionGround b : transitions) {
            if (useRedundantConstraints) {
                preconditionFunction[b.getId()] = b.getPreconditions().introduce_red_constraints();
            }else{
                preconditionFunction[b.getId()] = b.getPreconditions();
            }
            propEffectFunction[b.getId()] = b.getConditionalPropositionalEffects().getAllEffects();
            numericEffectFunction[b.getId()] = b.getConditionalNumericEffects().getAllEffects();
            actionCost[b.getId()] = b.getActionCost(problem.getInit(),problem.getMetric());
        }
        if (useRedundantConstraints){
            preconditionFunction[pseudoGoal] = problem.getGoals().introduce_red_constraints();
        }else {
            preconditionFunction[pseudoGoal] = problem.getGoals();
        }
        totNumberOfTerms = Predicate.predicates.values().size() + Comparison.getComparisonDataBase().values().size() + NotCond.notcondDB.values().size();

        achieve = new Collection[heuristicNumberOfActions];

        invertedAchievers = new Collection[totNumberOfTerms];
        possibleAchievers = new Collection[heuristicNumberOfActions];
        invertedPossibleAchievers = new Collection[totNumberOfTerms];
        preconditionToAction = new Collection[totNumberOfTerms];
        conditionToAction = new Collection[totNumberOfTerms];

        for (int i = 0; i < heuristicNumberOfActions; i++) {
            Collection<Condition> terminalConditions = preconditionFunction[i].getTerminalConditionsInArray();
            for (Condition c : terminalConditions) {
                if (c instanceof  Terminal ) {
                    Collection<TransitionGround> groundActions = conditionToAction[((Terminal) c).id];
                    if (groundActions == null) {
                        groundActions = new ArrayList<>();

                    }
                    conditionToAction[c.getHeuristicId()] = groundActions;
                }
            }
        }
    }

    @Override
    public float computeEstimate (State gs) {

        return Float.MAX_VALUE;
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

}

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
package com.hstairs.ppmajal.heuristics;

import com.hstairs.ppmajal.conditions.*;
import com.hstairs.ppmajal.problem.*;
import com.hstairs.ppmajal.transition.TransitionGround;

import java.util.*;


/**
 * @author enrico
 */
public abstract class Heuristic {

    protected Collection<TransitionGround> reachable;
    public boolean additive_h = true;
    public int debug = 0;
    public Collection<TransitionGround> A;
    public ComplexCondition G;
    public boolean why_not_active = false;
    protected Collection<TransitionGround> helpful_actions;
    
    
    public int numberOfReachableConditions;
    public int horizon = Integer.MAX_VALUE;
    public ComplexCondition gC;
    public boolean helpful_actions_computation = false;
    public Boolean allAchieverActions = true;
    protected Collection<Condition> conditionUniverse;
    protected int numberOfAtoms;
    protected int numberOfComplexConditions;
    protected boolean sat_test_within_cost = true;
    protected int numberOfHardConditions;
    protected HashMap<String, Integer> fromConditionStringToUniqueInteger;
    protected EPddlProblem problem ;
    protected boolean ignoreCostInHeuristic;
    protected boolean reachability;

    public Heuristic(EPddlProblem problem) {
        this.problem = problem;
        ignoreCostInHeuristic  = false;
    }
    

    public Heuristic(ComplexCondition G, Collection<TransitionGround> A, Collection<TransitionGround> P, Collection<TransitionGround> E, ComplexCondition GC, EPddlProblem problem) {
        super();
        this.G = G;
        this.A = new LinkedHashSet();
        this.A.addAll(A);
        if (P != null) {
            this.A.addAll(P);
        }
        if (E != null) {
            this.A.addAll(E);
        }
        reachable = new LinkedHashSet();
        conditionUniverse = new ArrayList();
        this.gC = GC;
        this.problem = problem;
    }

    //this initializer is mandatory for being executed before each invocation of the heuristic
    public abstract Float setup(State s_0);

    public void forceUniquenessInConditionsAndInternalActions(State s) {
        conditionUniverse = new ArrayList<>();
        int counter_conditions = 0;

        fromConditionStringToUniqueInteger = new HashMap();
        ArrayList<TransitionGround> actions_to_consider = new ArrayList(A);
        for (TransitionGround a : actions_to_consider) {

            if (a.getPreconditions() != null) {
                for (Condition condition : a.getPreconditions().getTerminalConditions()) {
                    counter_conditions = establishHeuristicConditionId(condition, counter_conditions);
                }
            }
        }
        for (TransitionGround a : actions_to_consider) {
            for (Condition condition : a.getAllEffectPredicates()) {
                counter_conditions = establishHeuristicConditionId(condition, counter_conditions);
            }
        }

        for (Condition c_1 : G.getTerminalConditions()) {
            counter_conditions = establishHeuristicConditionId(c_1, counter_conditions);
        }
        numberOfAtoms = counter_conditions;//index of the last atom
    }

    /**
     * @param s_0
     * @return
     */
    abstract public Float computeEstimate(State s_0);

   


    protected int establishHeuristicConditionId(Condition c_1, int counter) {

        if (fromConditionStringToUniqueInteger.get(c_1.toString()) == null) {
            fromConditionStringToUniqueInteger.put(c_1.toString(), counter);
            c_1.setHeuristicId(counter);
            conditionUniverse.add(c_1);
            counter++;
        } else {
            c_1.setHeuristicId(fromConditionStringToUniqueInteger.get(c_1.toString()));
        }
        return counter;

    }


    public float gValue(State s, Object transition, State next, Float previousG) {
        TransitionGround gr = (TransitionGround) transition;
        if (gr == null) {
            return previousG;
        }
        return getTransitionCost(s, gr,previousG,false);
    }
    
    protected float getTransitionCost(State s, TransitionGround gr, Float previousG, boolean ignoreCost){
        if (ignoreCost){
            return previousG + 1;
        }
        if (problem.isAction_cost_from_metric()){
            return previousG + gr.getActionCost(s,problem.getMetric());
        }else{
            return previousG + 1;
        }  
    }

    public Collection<TransitionGround> getReachableTransitions() {
        if (this.reachable == null){
            return this.A;
        }
        return this.reachable;
    }

    /**
     * @return the helpful_actions
     */
    public Collection<TransitionGround> getHelpfulActions() {
        return this.reachable;
    }

}

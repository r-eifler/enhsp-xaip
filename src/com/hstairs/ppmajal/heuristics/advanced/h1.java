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

import com.hstairs.ppmajal.conditions.*;
import com.hstairs.ppmajal.expressions.NumEffect;
import com.hstairs.ppmajal.extraUtils.Pair;
import com.hstairs.ppmajal.extraUtils.Utils;
import com.hstairs.ppmajal.heuristics.Aibr;
import com.hstairs.ppmajal.heuristics.Heuristic;
import com.hstairs.ppmajal.heuristics.utils.AchieverSet;
import com.hstairs.ppmajal.problem.GroundAction;
import com.hstairs.ppmajal.problem.GroundProcess;
import com.hstairs.ppmajal.problem.PDDLState;
import com.hstairs.ppmajal.problem.State;
import it.unimi.dsi.fastutil.objects.Object2FloatMap;
import it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap;
import it.unimi.dsi.fastutil.objects.ReferenceLinkedOpenHashSet;
import org.jgrapht.util.FibonacciHeap;
import org.jgrapht.util.FibonacciHeapNode;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.System.out;
import static java.util.Collections.nCopies;

/**
 * @author enrico
 */
public class h1 extends Heuristic {

    public boolean useRedundantConstraints = false;
    public boolean extractRelaxedPlan = false;
    public boolean conservativehmax = true;
    public boolean ibrDisabled = false;
    protected boolean reacheability_setting;
    protected LinkedHashSet<Terminal>[] achieve;
    protected LinkedHashSet<GroundAction>[] invertedAchievers;
    protected LinkedHashSet<Comparison>[] possibleAchievers;
    protected LinkedHashSet<GroundAction>[] invertedPossibleAchievers;
    protected LinkedHashSet<GroundAction>[] precondition_mapping;
    private Set<GroundAction>[] conditionToAction;
    private float[] cost;
    private float[] actionHCost;
    private GroundAction[] establishedAchiever;
    private AchieverSet[] achieversSet;
    protected GroundAction pseudoGoal;
    private Set<GroundAction>[] allAchievers;
    private Set<GroundAction> reachableActions;
    private boolean[] closed;
    private float minimumActionCost;
    private List<Pair<GroundAction, Float>> relaxedPlan;
    private float[] establishedLocalCost;
    private Object2FloatMap action_comp_number_execution;
    protected ArrayList<AndCond> extraActionPrecondition;
    private HashMap<Integer,GroundAction> extraTrigger;

    public h1 (ComplexCondition goal, Set<GroundAction> A, Set<GroundProcess> P) {
        this(goal, A, P, new LinkedHashSet());
    }

    public h1 (ComplexCondition G, Set A, Set processesSet, Set events) {
        super(G, A, processesSet, events);
    }

    public h1 (ComplexCondition goals, Set actions) {
        this(goals,actions, new LinkedHashSet(),new LinkedHashSet());
    }

    @Override
    public Float setup (State s) {

        simplify_actions((PDDLState) s);

        if (useRedundantConstraints) {
            try {
                this.add_redundant_constraints();
            } catch (Exception ex) {
                System.out.println("Putting something here");
            }
        }
        if (additive_h) {
            minimumActionCost = 0.001f;
        } else {
            minimumActionCost = 0.0f;
        }
        pseudoGoal = new GroundAction("goal");
        pseudoGoal.dummy_goal = true;
        pseudoGoal.setAction_cost(0);
        pseudoGoal.setPreconditions(G);
        A.add(pseudoGoal);
        System.out.println("Actions After AIBR-Reachability:" + A.size());
        //System.out.println("Building integer representation");
        boolean reconstruct = false;
        do {
            build_integer_representation();
            pseudoGoal.setId(total_number_of_actions);
            identify_complex_conditions(A);
            this.generateConditionToActionMap();
            try {
                reconstruct = generate_achievers();
            } catch (Exception ex) {
                System.out.println("Putting something here");
            }
        } while (reconstruct);
        reacheability_setting = true;
        extraActionPrecondition = new ArrayList<>(nCopies(total_number_of_actions + 1, null));
        Utils.dbg_print(debug - 10, "Reachability Analysis Started");
        float ret = computeEstimate(s);
        Utils.dbg_print(debug - 10, "Reachability Analysis Terminated");
//        System.out.println("Actions After Reachability:"+this.reachable);
        reacheability_setting = false;
        sat_test_within_cost = false; //don't need to recheck precondition sat for each state. It is done in the beginning for every possible condition
        out.println("Hard Conditions: " + this.complex_conditions);
        out.println("Simple Conditions: " + (this.all_conditions.size() - this.complex_conditions));
        return ret;
    }

    public void light_setup (PDDLState s) {

        pseudoGoal = new GroundAction("goal");
        pseudoGoal.dummy_goal = true;
        pseudoGoal.setAction_cost(0);
        pseudoGoal.setPreconditions(G);
        A.add(pseudoGoal);
        simplify_actions(s);
        build_integer_representation();
        identify_complex_conditions(A);

        Utils.dbg_print(debug - 10, "Complex Condition set:" + this.complex_condition_set + "\n");
        this.generateConditionToActionMap();
        try {
            generate_achievers();
        } catch (Exception ex) {
            Logger.getLogger(h1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void addTriggerCondition (Predicate dummyPredicate, GroundAction pseudoGoal) {
        getExtraTrigger().put(dummyPredicate.getHeuristicId(),pseudoGoal);
    }

    @Override
    public Float computeEstimate (State gs) {
        PDDLState s = (PDDLState) gs;

        if (s.satisfy(pseudoGoal.getPreconditions()) && extraActionPrecondition.get(pseudoGoal.getId()) == null) {
//            System.out.println("Goal satisfied??");
            return 0f;
        }
        if (this.extractRelaxedPlan || this.helpful_actions_computation) {
            establishedAchiever = new GroundAction[all_conditions.size() + 1];
            achieversSet = new AchieverSet[total_number_of_actions + 1];
            establishedLocalCost = new float[all_conditions.size() + 1];
            Arrays.fill(establishedLocalCost, Float.MAX_VALUE);
        }
        allAchievers = new ReferenceLinkedOpenHashSet[all_conditions.size() + 1];
        float estimate = Float.MAX_VALUE;
        FibonacciHeap<GroundAction> a_plus = new FibonacciHeap();//actions executable. Progressively updated
        ArrayList<FibonacciHeapNode> action_to_fib_node = new ArrayList<>(nCopies(total_number_of_actions + 1, null));//mapping between action and boolean. True if action has not been activated yet
        cost = new float[all_conditions.size() + 1];
        Arrays.fill(cost, Float.MAX_VALUE);
        actionHCost = new float[total_number_of_actions + 1];
        Arrays.fill(actionHCost, Float.MAX_VALUE);
        closed = new boolean[total_number_of_actions + 1];
        Arrays.fill(closed, false);
        action_comp_number_execution = new Object2FloatOpenHashMap();
//        ArrayList<GroundAction> actionApplicableInGs = new ArrayList<>();
        //if (!this.reacheability_setting)
//            s.setApplicableActions(actionApplicableInGs);

//        Utils.dbg_print(debugLevel - 10, "Total Number of conditions:" + all_conditions.size() + "\n");
        for (Condition c : all_conditions) {//update with a value of 0 to say that condition is sat in init state
            if (s.satisfy(c)) {
                cost[c.getHeuristicId()] = 0f;
//                Utils.dbg_print(debugLevel - 10, "Condition that is already satisfied:" + c + "\n");
//                Utils.dbg_print(debugLevel - 10, "Counter is:" + c.getCounter() + "\n");
            } else {
//                Utils.dbg_print(debugLevel - 10, "Condition that is NOT already satisfied:" + c + "\n");
//                Utils.dbg_print(debugLevel - 10, "Counter is:" + c.getCounter() + "\n");
            }

        }
        for (GroundAction gr : this.A) {//see which actions are executable at the current state
            if (this.estimateCost(gr.getPreconditions())!=Float.MAX_VALUE){
                Condition extraPrecondition = extraActionPrecondition.get(gr.getId());
                if ((extraPrecondition == null) || (this.estimateCost(extraPrecondition)!= Float.MAX_VALUE)){
                    FibonacciHeapNode node = new FibonacciHeapNode(gr);
                    action_to_fib_node.set(gr.getId(), node);
                    a_plus.insert(node, 0f);//add such an action
                    actionHCost[gr.getId()] = 0f;
                    if (this.reacheability_setting) {
                        this.reachable.add(gr);
                    }
                }
            }
        }
        reachableActions = new LinkedHashSet();
        while (!a_plus.isEmpty()) {//keep going till no action is in the list.

            final GroundAction gr = a_plus.removeMin().getData();
            //if (!conservativehmax || this.additive_h)
            closed[gr.getId()] = true;
            reachableActions.add(gr);
//            Utils.dbg_print(debugLevel - 10, "Action Evaluated:" + gr + "\n");
//            Utils.dbg_print(debugLevel - 10, "Cost:" + action_dist.get(gr.counter) + "\n");
            if (gr.dummy_goal) {
                estimate = actionHCost[gr.getId()];
                if (!this.reacheability_setting && (this.additive_h || !conservativehmax)) {
//                    System.out.println(this.additive_h);
//                    System.out.println(this.conservativehmax);
                    extract_helpful_actions_or_relaxed_plan();
                    if (estimate == 0f) {
                        return 0.1f;
                    }
                    if (this.extractRelaxedPlan) {
                        return this.extract_tot_cost(relaxedPlan);
                    }
                    return estimate;
                }
            }
            update_reachable_conditions_actions(s, gr, a_plus, action_to_fib_node);//this procedure updates
            //all the conditions that can be reached by using action gr.
            //This also changes the set a_plus whenever some new action becomes active becasue of gr
        }

//        System.out.println("Estimate: "+estimate);
        if (reacheability_setting || why_not_active) {
            if (estimate == Float.MAX_VALUE) {
                System.out.println("Goal unreachable from init state. Please revise model or instance file");
                findUnsatReasons(this.pseudoGoal);
                System.out.println("Actions Applicable till fix point:");
                for (GroundAction gr: reachableActions){
                    System.out.println(gr.toEcoString());
                }
            }
        }

        if (this.reacheability_setting) {
            A = reachable;
        }

        if (estimate == Float.MAX_VALUE) {
            return estimate;
        }

        extract_helpful_actions_or_relaxed_plan();
        if (this.extractRelaxedPlan) {
            return this.extract_tot_cost(relaxedPlan);
        }

        //System.out.println("Conservative Setting");
        return estimate;
    }


    private void update_reachable_conditions_actions (PDDLState s_0, GroundAction gr, FibonacciHeap<GroundAction> a_plus, ArrayList<FibonacciHeapNode> never_active) {
        float c_a = Math.max(gr.getActionCost(), minimumActionCost);
        for (final Condition comp : this.achieve[gr.getId()]) {//This is the set of all predicates reachable because of gr
            float current_distance = cost[comp.getHeuristicId()];
            if (current_distance != 0f) {

                float cond_dist_comp = c_a + this.actionHCost[gr.getId()];
                if (cond_dist_comp != Float.MAX_VALUE) {
                    if (this.extractRelaxedPlan || this.helpful_actions_computation) {
                        update_achiever(comp, gr);
                    }
                    if (cond_dist_comp < cost[comp.getHeuristicId()]) {//if this isn't in the init state yet
                        cost[comp.getHeuristicId()] = cond_dist_comp;//update distance. Meant only to keep track of whether condition reachead or not, and "how"
                        if (this.extractRelaxedPlan || this.helpful_actions_computation) {
                            establishedAchiever[comp.getHeuristicId()] = gr;
                            establishedLocalCost[comp.getHeuristicId()] = c_a;
                        }
                        updateReachableActions(gr, comp, a_plus, never_active);

                    }
                }
            }
        }
        for (final Condition comp : this.possibleAchievers[gr.getId()]) {
//            Utils.dbg_print(debugLevel - 10, "Condition under analysis:" + comp + "\n");
            if (!this.is_complex.get(comp.getHeuristicId())) {
                float current_distance = cost[comp.getHeuristicId()];
                if (current_distance != 0f) {
                    float rep_needed = this.action_comp_number_execution.getOrDefault(new Pair(gr.getId(), comp.getHeuristicId()), -1f);
                    if (rep_needed == -1) {
                        if (gr.infinite_constant_effect) {
                            rep_needed = 1f * c_a;
                        }
                        if (this.invertedPossibleAchievers[comp.getHeuristicId()].size() == 1 || this.integer_actions) {

                            rep_needed = gr.getNumberOfExecutionInt(s_0, (Comparison) comp) * c_a;
                        } else {
                            rep_needed = gr.getNumberOfExecution(s_0, (Comparison) comp) * c_a;
                        }
                        this.action_comp_number_execution.put(new Pair(gr.getId(), comp.getHeuristicId()), rep_needed);
                    } else {
//                        System.out.println("Cache funziona");
                    }

                    if (rep_needed != Float.MAX_VALUE) {
                        if (this.extractRelaxedPlan || this.helpful_actions_computation || !this.additive_h) {
                            update_achiever(comp, gr);
                        }
                        float new_distance = rep_needed;
                        if (this.additive_h) {
                            new_distance += this.actionHCost[gr.getId()];
                        } else {

                            //rep_needed += this.action_dist.get(gr.counter);
                            new_distance += min_over_possible_achievers(comp);
                            /*
                            This preserves admissibility.
                             */
                        }

                        if (new_distance < current_distance) {
                            cost[comp.getHeuristicId()] = new_distance;
                            if (this.extractRelaxedPlan || this.helpful_actions_computation) {
                                establishedAchiever[comp.getHeuristicId()] = gr;
                                establishedLocalCost[comp.getHeuristicId()] = rep_needed;
                            }
                            updateReachableActions(gr, comp, a_plus, never_active);
                        }

                    }

                }
            } else {
//                System.out.println("Complex condition reasoning");
                float current_distance = cost[comp.getHeuristicId()];
                if (current_distance == 0f) {
                    continue;
                }
                float new_distance = Float.MAX_VALUE;
                if (!this.additive_h || ibrDisabled) {
                    new_distance = actionHCost[gr.getId()] + c_a;//this is a very conservative measure.
                } else {
                    //This can be cached with a map, so that supporters are kept, and only the new ones are added


                    LinkedHashSet<GroundAction> invertedPossibleAchiever = this.invertedPossibleAchievers[comp.getHeuristicId()];
                    if (invertedPossibleAchiever.size() == 1){
                        //Extend here a reasoning for the case where you only have one achiever and this achiever is a constant assignment. Formalize it also would be nice
                    }


                    AndCond temp = new AndCond();
                    temp.addConditions(comp);


                    Aibr aibr_handle = new Aibr(temp, reachableActions);
                    //aibr_handle
                    aibr_handle.set(false, true);

                    aibr_handle.light_setup(s_0, this);

                    if (comp.getHeuristicId() > all_conditions.size()) {
                        System.out.println("Condition not intercepted!" + comp + "\n");
                        System.out.println("Identifier:" + comp.getHeuristicId());
                        System.exit(-1);
                    }
                    new_distance = aibr_handle.computeEstimate(s_0);
                }
                if (new_distance != Float.MAX_VALUE) {
                    //new_distance += this.action_dist.get(gr.counter);
                    if (this.extractRelaxedPlan || this.helpful_actions_computation) {
                        update_achiever(comp, gr);
                    }
                    if (new_distance < current_distance) {
                        cost[comp.getHeuristicId()] = new_distance;
                        if (this.extractRelaxedPlan || this.helpful_actions_computation) {
                            establishedAchiever[comp.getHeuristicId()] = gr;
                            establishedLocalCost[comp.getHeuristicId()] = new_distance;//this does not really work!!
                        }
                        updateReachableActions(gr, comp, a_plus, never_active);
                    }

                }
//                Utils.dbg_print(debugLevel - 10, "(Complex) Action under consideration and number of needed execution:" + gr + " " + current_distance + "\n");

            }
        }

    }

    private void updateReachableActions (GroundAction gr, Condition comp, FibonacciHeap<GroundAction> a_plus, ArrayList<FibonacciHeapNode> action_to_fib_node) {
        //this procedure shrink landmarks for condition comp using action gr
//        System.out.println(changed);
        Collection<GroundAction> set = null;
        if (comp.getHeuristicId() < conditionToAction.length) {
            set = conditionToAction[comp.getHeuristicId()];
        }
        if (this.extraTrigger != null){
            GroundAction groundAction = this.extraTrigger.get(comp.getHeuristicId());
            if (set == null) {
                set = new ArrayList<>();
            }
            if (groundAction != null){
                set.add(groundAction);
            }
        }
        if (set == null){
            throw new RuntimeException("Condition seems to be useless");
        }
        //this mapping contains action that need to be triggered becasue of condition comp
        for (final GroundAction gr2 : set) {

            if (closed[gr2.getId()]) {
                if (this.additive_h || !this.conservativehmax) {
                    continue;
                }
            }
            float c = checkConditions(gr2);

            if (c < actionHCost[gr2.getId()]) {//are conditions all reached, and is this a better path?
                actionHCost[gr2.getId()] = c;
                if (action_to_fib_node.get(gr2.getId()) == null) {
                    FibonacciHeapNode n = new FibonacciHeapNode(gr2);
                    a_plus.insert(n, c);//push in the set of actions to consider.
                    action_to_fib_node.set(gr2.getId(), n);
                } else if (closed[gr2.getId()]) {
                    a_plus.insert(action_to_fib_node.get(gr2.getId()), c);
                    closed[gr2.getId()] = false;
                } else {
                    a_plus.decreaseKey(action_to_fib_node.get(gr2.getId()), c);//push in the set of actions to consider.
                }
                //Need to understand whether is worth to do check on the list to see if action already is there.
                if (this.reacheability_setting) {
                    this.reachable.add(gr2);
                }
            }

        }
    }

    float estimateCost (Condition c) {
        if (c instanceof AndCond) {
            AndCond and = (AndCond) c;
            if (and.sons == null) {
                return 0f;
            }
            float ret = 0f;
            for (final Condition son : (Collection<Condition>) and.sons) {
                float estimate = estimateCost(son);
                if (estimate == Float.MAX_VALUE) {
                    return Float.MAX_VALUE;
                }
                if (additive_h) {
                    ret += estimate;
                } else {
                    ret = Math.max(estimate, ret);
                }
            }
            return ret;

        } else if (c instanceof OrCond) {
            OrCond and = (OrCond) c;
            if (and.sons == null) {
                return 0f;
            }
            float ret = Float.MAX_VALUE;
            for (final Condition son : (Collection<Condition>) and.sons) {
                float estimate = estimateCost(son);
                if (estimate != Float.MAX_VALUE) {
                    ret = Math.min(estimate, ret);
                }

            }
            return ret;
        } else if (c instanceof Predicate) {
            return cost[c.getHeuristicId()];
        } else if (c instanceof NotCond) {
            return cost[c.getHeuristicId()];
        } else if (c instanceof Comparison) {
            return cost[c.getHeuristicId()];
        } else {
            return 0f;
        }
    }

    AchieverSet estimateAchievers (Condition c) {
        AchieverSet s = new AchieverSet();
        if (c instanceof AndCond) {
            AndCond and = (AndCond) c;

            if (and.sons == null) {
                s.cost = 0f;
            } else {
                s.cost = 0f;
                for (Condition son : (Collection<Condition>) and.sons) {
                    AchieverSet s1 = estimateAchievers(son);
                    if (s1.cost == Float.MAX_VALUE) {
                        s.cost = Float.MAX_VALUE;
                        return s;
                    }
                    if (additive_h) {
                        s.cost += s1.cost;
                        s.actions.addAll(s1.actions);
                        s.target_cond.addAll(s1.target_cond);
                    } else {
                        s.cost = Math.max(s1.cost, s.cost);
                    }
                }
            }
        } else if (c instanceof OrCond) {
            OrCond and = (OrCond) c;
            s.cost = Float.MAX_VALUE;
            if (and.sons == null) {
                s.cost = 0f;
            } else {
                for (Condition c1 : (Collection<Condition>) and.sons) {
                    AchieverSet s1 = estimateAchievers(c1);
                    if (s1.cost != Float.MAX_VALUE) {
                        if (s.cost > s1.cost) {
                            s.actions = s1.actions;
                            s.cost = s1.cost;
                            s.target_cond.addAll(s1.target_cond);
                        }
                    }
                }
            }
        } else {
            s.cost = cost[c.getHeuristicId()];
            s.actions.add(establishedAchiever[c.getHeuristicId()]);
            s.target_cond.add(c);
        }
        return s;
    }

    private float checkConditions (GroundAction gr2) {
        Condition condition = this.extraActionPrecondition.get(gr2.getId());
        Condition input = null;
        if (condition != null){
            input = new AndCond();
            ((AndCond) input).addConditions(condition);
            ((AndCond) input).addConditions(gr2.getPreconditions());
        }else{
            input = gr2.getPreconditions();
        }
        if (extractRelaxedPlan || this.helpful_actions_computation) {
            AchieverSet s = estimateAchievers(input);
            achieversSet[gr2.getId()] = s;
            return s.cost;
        } else {
            return estimateCost(input);
        }

    }

    private void generateConditionToActionMap ( ) {
        conditionToAction = new ReferenceLinkedOpenHashSet[all_conditions.size() + 1];
        for (Condition c : all_conditions) {
            ReferenceLinkedOpenHashSet<GroundAction> set = new ReferenceLinkedOpenHashSet();
            for (GroundAction gr : A) {
                if (gr.getPreconditions().getTerminalConditions().contains(c)) {
                    set.add(gr);
                }
            }
            conditionToAction[c.getHeuristicId()] = set;
        }
    }

    private void updateConditionToAction (GroundAction gr, Condition c) {
        extraTrigger.put(c.getHeuristicId(),gr);
    }

    private void compute_helpful_actions ( ) {
        LinkedList<GroundAction> list = new LinkedList();
        helpful_actions = new LinkedHashSet();
        AchieverSet s = this.achieversSet[pseudoGoal.getId()];
        getHelpfulActions(list, s);
        while (!list.isEmpty()) {
            GroundAction gr2 = list.pollLast();
//            System.out.println(gr);
            s = this.achieversSet[gr2.getId()];
            getHelpfulActions(list, s);
        }
//        Utils.dbg_print(debugLevel, "HelpfulActions: " + helpful_actions.toString() + "\n");
    }

    private void compute_relaxed_plan ( ) {//this should be updated!

        LinkedList<Condition> list = new LinkedList();
        relaxedPlan = new ArrayList();

        helpful_actions = new ArrayList();
        AchieverSet s = this.achieversSet[pseudoGoal.getId()];
        ArrayList<Boolean> visited = new ArrayList(nCopies(this.all_conditions.size()+1,false));
        for (Condition c : s.target_cond) {
            list.add(c);
            visited.set(c.getHeuristicId(),true);
        }
        while (!list.isEmpty()) {
            Condition c = list.pollLast();
            if (this.cost[c.getHeuristicId()] != 0) {
                GroundAction gr = this.establishedAchiever[c.getHeuristicId()];
                this.update_relaxed_plan((ArrayList)relaxedPlan, gr, this.establishedLocalCost[c.getHeuristicId()]);
                if (this.is_complex.get(c.getHeuristicId()) || weak_helpful_actions_pruning) {
                    Set<GroundAction> allAchiever = this.allAchievers[c.getHeuristicId()];
                    if (allAchiever != null) {
                        for (GroundAction gr2 : allAchiever) {
                            if (this.actionHCost[gr2.getId()] == 0) {
                                this.helpful_actions.add(gr2);
                            }
                        }
                    }
                }
                if (this.actionHCost[gr.getId()] == 0) {
                    this.helpful_actions.add(gr);
                } else {
                    AchieverSet ach_set = this.achieversSet[gr.getId()];
                    if (ach_set != null) {
                        for (Condition c1 : ach_set.target_cond) {
                            if (!visited.get(c1.getHeuristicId())) {
                                list.add(c1);
                                visited.set(c1.getHeuristicId(),true);
                            }
                        }
                    }
                }
            }
        }
    }

    private void update_achiever (Condition comp, GroundAction gr) {

        Set s = allAchievers[comp.getHeuristicId()];
        if (s == null) {
            s = new ReferenceLinkedOpenHashSet();
        }
        s.add(gr);
        allAchievers[comp.getHeuristicId()] = s;
    }

    private void extract_helpful_actions_or_relaxed_plan ( ) {

        if (this.extractRelaxedPlan) {
            compute_relaxed_plan();
        } else if (this.helpful_actions_computation) {
            //System.out.println("Computing helpful actions");
            this.compute_helpful_actions();
        }

    }

    private void getHelpfulActions (LinkedList<GroundAction> list, AchieverSet s) {
        if (s != null) {
            for (Condition o : s.target_cond) {
                if (cost[o.getHeuristicId()] == 0) {
                    continue;
                }
//                if (o != null) {
                //System.out.println("Helpful actions extraction");
                if (this.is_complex.get(o.getHeuristicId()) || weak_helpful_actions_pruning) {
                    if (this.allAchievers[o.getHeuristicId()] != null) {
                        //System.out.println("Getting all the achievers as helpful actions..");
                        for (GroundAction gr : this.allAchievers[o.getHeuristicId()]) {
                            if (this.actionHCost[gr.getId()] == 0) {
                                this.helpful_actions.add(gr);
                            }
                        }
                    }
                } else {//Add helpful action if this action is an established achiever of any condition in the target condition and is applicable
                    //in the initial state
                    GroundAction gr = this.establishedAchiever[o.getHeuristicId()];
//                        if (gr==null && cond_dist[o.getCounter())!=0]{
//                            System.out.println("this is bizzare");
//                            System.out.println(o);
//                            System.exit(-1);
//                        }
//                        if (this.action_dist.get(gr.counter)==null){
//                            System.out.println("Action not classified. Very strange:"+gr);
//                            System.out.println("Counter"+gr.counter);
//                            System.out.println("Max number of actions"+this.total_number_of_actions);
//                        }
                    if (this.actionHCost[gr.getId()] == 0) {
                        this.helpful_actions.add(gr);
                    }

                }
//                }
            }
            for (GroundAction gr : s.actions) {
                if (gr != null) {
                    list.addFirst(gr);
                }
            }
        }
    }

    private void findUnsatReasons (GroundAction goal) {

        //works only for conjunction
        for (Condition c : goal.getPreconditions().getTerminalConditions()) {
            if (cost[c.getHeuristicId()] == Float.MAX_VALUE) {
                System.out.println("Unreachable in the relaxation: " + c);
            }
        }

    }

    private float min_over_possible_achievers (Condition comp) {
        Set<GroundAction> set = this.allAchievers[comp.getHeuristicId()];
        float min = Float.MAX_VALUE;
        for (GroundAction gr : set) {
            min = Math.min(actionHCost[gr.getId()], min);
            if (min == 0) {
                return 0f;
            }
        }
        return min;
    }

    private void update_relaxed_plan (List<Pair<GroundAction, Float>> plan, GroundAction g, Float cost) {

        for (int i = plan.size() - 1; i >= 0; i--) {
            Pair<GroundAction, Float> gr_pair = plan.get(i);
            //if (gr_pair.getFirst().equals(g)) {
            if (gr_pair.getFirst().getId() == g.getId()) {
                gr_pair.setSecond(Math.max(cost, gr_pair.getSecond()));
                plan.set(i, gr_pair);
                return;
            }

            if (only_mutual_exclusion_processes) {//work from here to have hff sensible to process structure!
                if (g instanceof com.hstairs.ppmajal.problem.GroundProcess || g instanceof com.hstairs.ppmajal.problem.GroundEvent) {//very very conservative
                    if (gr_pair.getFirst() instanceof com.hstairs.ppmajal.problem.GroundProcess || gr_pair.getFirst() instanceof com.hstairs.ppmajal.problem.GroundEvent) {
                        if (!gr_pair.getFirst().getPreconditions().mutual_exclusion_guaranteed(g.getPreconditions())) {
                            //Float current_cost = gr_pair.getSecond();
//                            if (cost > current_cost){
//                                gr_pair.setSecond(cost);
//                                gr_pair.setFirst(g);
//                                return;
//                            }
                            gr_pair.setSecond(Math.max(cost, gr_pair.getSecond()));
                            plan.set(i, gr_pair);
                            return;
                        }
                    }
                }
            }

        }
        plan.add(new Pair(g, cost));
    }

    private float extract_tot_cost (List<Pair<GroundAction, Float>> plan) {
        float cost = 0f;
        for (Pair<GroundAction, Float> p : plan) {
            cost += p.getSecond();
        }
        return cost;
    }

    protected boolean generate_achievers ( ) {
        achieve = new LinkedHashSet[this.total_number_of_actions + 1];
        possibleAchievers = new LinkedHashSet[this.total_number_of_actions + 1];
        this.invertedPossibleAchievers = new LinkedHashSet[this.all_conditions.size() + 1];
        invertedAchievers = new LinkedHashSet[this.all_conditions.size() + 1];
        precondition_mapping = new LinkedHashSet[this.all_conditions.size() + 1];

        //this should also include the indirect dependencies, otherwise does not work!!
        Set<GroundAction> useless_actions = new HashSet();
        for (GroundAction gr : this.A) {
            LinkedHashSet<Comparison> comparisons = new LinkedHashSet();
            LinkedHashSet<Comparison> reacheable_comparisons = new LinkedHashSet();
            LinkedHashSet<Terminal> literals = new LinkedHashSet();
            boolean at_least_one_service = false;
            for (Condition c : this.all_conditions) {

                if (precondition_mapping[c.getHeuristicId()] == null) {
                    precondition_mapping[c.getHeuristicId()] = new LinkedHashSet();
                }
                LinkedHashSet<GroundAction> action_list = new LinkedHashSet();
                if (c instanceof Comparison) {
//                    System.out.println("Condition under analysis:"+c);
//                    System.out.println("Counter is:"+c.getCounter());
                    Comparison comp = (Comparison) c;
                    if (comp.involve(gr.getNumericFluentAffected())) {
                        comparisons.add(comp);

                        if (this.is_complex.get(comp.getHeuristicId())) {
                            at_least_one_service = true;
                            reacheable_comparisons.add(comp);
                            action_list.add(gr);
                        } else if (gr.is_possible_achiever_of(comp)) {
                            at_least_one_service = true;
                            reacheable_comparisons.add(comp);
                            action_list.add(gr);
                        }
                    }
                    if (this.invertedPossibleAchievers[comp.getHeuristicId()] == null) {
                        this.invertedPossibleAchievers[comp.getHeuristicId()] = action_list;
                    } else {
                        LinkedHashSet<GroundAction> temp = this.invertedPossibleAchievers[comp.getHeuristicId()];
                        temp.addAll(action_list);
                        this.invertedPossibleAchievers[comp.getHeuristicId()] = temp;
                    }
                } else if (c instanceof Predicate) {
                    Predicate p = (Predicate) c;
                    if (gr.weakAchiever(p)) {
                        at_least_one_service = true;
                        literals.add(p);
                        action_list.add(gr);
                    }
                    if (this.invertedAchievers[p.getHeuristicId()] == null) {
                        this.invertedAchievers[p.getHeuristicId()] = action_list;
                    } else {
                        LinkedHashSet<GroundAction> temp = this.invertedAchievers[p.getHeuristicId()];
                        temp.addAll(action_list);
                        this.invertedAchievers[p.getHeuristicId()] = temp;
                    }

                } else if (c instanceof NotCond) {
                    NotCond c1 = (NotCond) c;
                    if (!c1.isTerminal()) {
                        System.out.println("Not formula has to be used as a terminal, and it is not:" + c1);
                        System.exit(-1);
                    }
                    Predicate p = (Predicate) c1.getSon();
                    if (gr.delete(p)) {
                        at_least_one_service = true;
                        literals.add(c1);
                        action_list.add(gr);
                    }
                    if (this.invertedAchievers[c1.getHeuristicId()] == null) {
                        this.invertedAchievers[c1.getHeuristicId()] = action_list;
                    } else {
                        LinkedHashSet<GroundAction> temp = this.invertedAchievers[c1.getHeuristicId()];
                        temp.addAll(action_list);
                        this.invertedAchievers[c1.getHeuristicId()] = temp;
                    }

                }

                if (gr.preconditioned_on(c)) {//build mapping from atoms to actions
                    LinkedHashSet<GroundAction> temp = this.precondition_mapping[c.getHeuristicId()];
                    temp.add(gr);
                    this.precondition_mapping[c.getHeuristicId()] = temp;

                }

            }
//            if (at_least_one_service){
            achieve[gr.getId()] = literals;
            possibleAchievers[gr.getId()] = reacheable_comparisons;
//            }else{
//                useless_actions.add(gr);
//            }
        }
//        boolean ret = !useless_actions.isEmpty();

//        A.removeAll(useless_actions);
        Utils.dbg_print(debug, "Identify complex achievers");

        for (Comparison comp : this.complex_condition_set) {
            HashSet<NumEffect> num_effects = new LinkedHashSet();
            HashMap<NumEffect, Boolean> temp_mark = new HashMap();
            HashMap<NumEffect, Boolean> per_mark = new HashMap();
            sorted_nodes = new LinkedList();
            for (GroundAction gr : A) {
                for (NumEffect nf : gr.getNumericEffectsAsCollection()) {
                    temp_mark.put(nf, false);
                    per_mark.put(nf, false);
                    num_effects.add(nf);
                }
            }
            for (NumEffect a : num_effects) {
                if ((!per_mark.get(a)) && (comp.getLeft().involve(a.getFluentAffected()))) {
                    visit(a, num_effects, temp_mark, per_mark, sorted_nodes);
                }
            }
            LinkedHashSet<GroundAction> action_list = new LinkedHashSet();
            for (GroundAction gr : A) {
                for (NumEffect neff : gr.getNumericEffectsAsCollection()) {

                    if (sorted_nodes.contains(neff)) {
                        possibleAchievers[gr.getId()].add(comp);
                        action_list.add(gr);
                    }

                }
            }
            if (this.invertedPossibleAchievers[comp.getHeuristicId()] == null) {
                this.invertedPossibleAchievers[comp.getHeuristicId()] = action_list;
            } else {
                LinkedHashSet<GroundAction> temp = this.invertedPossibleAchievers[comp.getHeuristicId()];
                temp.addAll(action_list);
                this.invertedPossibleAchievers[comp.getHeuristicId()] = temp;
            }
            if (debug == 1) {
                System.out.println("Comparison:" + comp);
                System.out.println("Achievers Set" + this.invertedPossibleAchievers[comp.getHeuristicId()]);
            }

        }
        Utils.dbg_print(debug, "Complex achievers identified");
        return false;//to fix at some point
    }


    //incremental use of the model

    protected void addAchieved (GroundAction gr, Predicate dummyPredicate) {
        LinkedHashSet<Terminal> terminals = this.achieve[gr.getId()];
        if (terminals == null){
            terminals = new LinkedHashSet<>();
        }
        terminals.add(dummyPredicate);
        this.achieve[gr.getId()] = terminals;
    }

    protected void addRequired (GroundAction action, Predicate dummyPredicate) {
        AndCond condition = this.extraActionPrecondition.get(action.getId());
        if (condition == null){
            condition = new AndCond();
        }
        condition.addConditions(dummyPredicate);
        this.extraActionPrecondition.set(action.getId(),condition);
        getExtraTrigger().put(dummyPredicate.getHeuristicId(),action);
    }

    private HashMap<Integer,GroundAction> getExtraTrigger ( ) {
        if (this.extraTrigger == null){
            this.extraTrigger = new HashMap<>();
        }
        return this.extraTrigger;
    }

    protected void addNewCondition (Predicate dummyPredicate) {
        dummyPredicate.setHeuristicId(all_conditions.size());
        all_conditions.add(dummyPredicate);
        this.is_complex.add(false);
    }
}

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
package heuristics.advanced;

import conditions.AndCond;
import heuristics.utils.achiever_set;
import conditions.Comparison;
import conditions.ComplexCondition;
import conditions.Condition;
import conditions.NotCond;
import conditions.Predicate;
import expressions.BinaryOp;
import expressions.ExtendedNormExpression;
import expressions.NumEffect;
import extraUtils.Pair;
import extraUtils.Utils;
import heuristics.Aibr;
import heuristics.Heuristic;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collection;
import static java.util.Collections.nCopies;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jgrapht.util.FibonacciHeap;
import org.jgrapht.util.FibonacciHeapNode;
import problem.PDDLGroundAction;
import problem.GroundProcess;
import problem.PDDLState;

/**
 *
 * @author enrico
 */
public class h1 extends Heuristic {

    public ArrayList<Integer> dplus;//this is the minimum number of actions needed to achieve a given condition

    private ArrayList<Set<PDDLGroundAction>> condition_to_action;

    public boolean compute_lp;
    private ArrayList<Float> cond_dist;
    private ArrayList<Float> action_dist;

    public boolean red_constraints = false;
    public boolean mip;
    private ArrayList<PDDLGroundAction> established_achiever;
    private ArrayList<achiever_set> action_achievers;
    public boolean relaxed_plan_extraction = false;
    private PDDLGroundAction goal;
    private ArrayList<LinkedHashSet<PDDLGroundAction>> all_achievers;
    private Set<PDDLGroundAction> reachable_here;
//    private Aibr aibr_handler;
    private boolean all_achievers_to_consider = false;
    private ArrayList<Boolean> closed;
    private float min_cost_action;
    public boolean conservativehmax = true;
    public boolean ibr_deactivated = false;
    private LinkedList<Pair<PDDLGroundAction, Float>> relaxed_plan;
    private ArrayList<Float> established_local_cost;
    private HashMap<Pair<Integer,Integer>,Float> action_comp_number_execution;
    private boolean risky = true;
    protected boolean reacheability_setting;
    
    
        protected HashMap<Integer, LinkedHashSet<Condition>> achieve;
    protected HashMap<Integer, LinkedHashSet<PDDLGroundAction>> achievers_inverted;
    protected HashMap<Integer, LinkedHashSet<Comparison>> interact_with;
    protected HashMap<Integer, LinkedHashSet<Comparison>> possible_achievers;
    protected HashMap<Integer, LinkedHashSet<PDDLGroundAction>> possible_achievers_inverted;
    protected HashMap<Integer, LinkedHashSet<PDDLGroundAction>> precondition_mapping;
    protected HashMap<Condition, Boolean> redundant_constraints;

    public h1(ComplexCondition goal, Set<PDDLGroundAction> A, Set<GroundProcess> P) {
        super(goal, A, P);
    }

    public h1(ComplexCondition G, Set A, Set processesSet, Set events) {
        super(G, A, processesSet, events);
    }

    @Override
    public Float setup(PDDLState s) {

        Aibr first_reachH = new Aibr(this.G, this.A);
        first_reachH.setup(s);
        first_reachH.set(true, true);
        Float ret = first_reachH.compute_estimate(s);
        if (ret == Float.MAX_VALUE) {
            System.out.println("Goal Unreachable: This is the fix point in relaxation: " + first_reachH.reacheable_state);
            return ret;
        }
        A = first_reachH.reachable;
        simplify_actions(s);

        if (red_constraints) {
            try {
                this.add_redundant_constraints();
            } catch (Exception ex) {
                System.out.println("Putting something here");
            }
        }
        if (additive_h) {
            min_cost_action = 0.001f;
        } else {
            min_cost_action = 0.0f;
        }
        goal = new PDDLGroundAction("goal");
        goal.dummy_goal = true;
        goal.setAction_cost(0);
        goal.setPreconditions(G);
        A.add(goal);
        //System.out.println("Building integer representation");
        boolean reconstruct = false;
        do {
            build_integer_representation();
            identify_complex_conditions(A);
            this.generate_link_precondition_action();
            try {
                reconstruct = generate_achievers();
            } catch (Exception ex) {
                System.out.println("Putting something here");
            }
        } while (reconstruct);
        reacheability_setting = true;
        Utils.dbg_print(debug - 10, "Reachability Analysis Started");
        ret = compute_estimate(s);
        Utils.dbg_print(debug - 10, "Reachability Analysis Terminated");
        reacheability_setting = false;
        sat_test_within_cost = false; //don't need to recheck precondition sat for each state. It is done in the beginning for every possible condition
        out.println("Hard Conditions: " + this.complex_conditions);
        out.println("Simple Conditions: " + (this.all_conditions.size() - this.complex_conditions));
        return ret;
    }
    
    public void light_setup(PDDLState s){
        
        goal = new PDDLGroundAction("goal");
        goal.dummy_goal = true;
        goal.setAction_cost(0);
        goal.setPreconditions(G);
        A.add(goal);
        simplify_actions(s);
        build_integer_representation();
        identify_complex_conditions(A);

        Utils.dbg_print(debug - 10, "Complex Condition set:" + this.complex_condition_set + "\n");
        this.generate_link_precondition_action();
        try {
            generate_achievers();
        } catch (Exception ex) {
            Logger.getLogger(h1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Float compute_estimate(PDDLState s_0) {
        
        if (s_0.satisfy(G)) {
//            System.out.println("Goal satisfied??");
            return 0f;
        }
        if (this.relaxed_plan_extraction || this.helpful_actions_computation) {
            established_achiever = new ArrayList<>(nCopies(all_conditions.size() + 1, null));
            action_achievers = new ArrayList<>(nCopies(total_number_of_actions + 1, null));
            established_local_cost = new ArrayList<>(nCopies(all_conditions.size() + 1, null));
        }
        all_achievers = new ArrayList<>(nCopies(all_conditions.size() + 1, null));

        Float estimate = Float.MAX_VALUE;
        FibonacciHeap<PDDLGroundAction> a_plus = new FibonacciHeap();//actions executable. Progressively updated
        ArrayList<FibonacciHeapNode> action_to_fib_node = new ArrayList<>(nCopies(total_number_of_actions + 1, null));//mapping between action and boolean. True if action has not been activated yet
        cond_dist = new ArrayList<>(nCopies(all_conditions.size() + 1, Float.MAX_VALUE));//keep track of conditions that have been reachead yet
        action_dist = new ArrayList<>(nCopies(total_number_of_actions + 1, Float.MAX_VALUE));//keep track of conditions that have been reachead yet        
        closed = new ArrayList<>(nCopies(total_number_of_actions + 1, false));
        action_comp_number_execution = new HashMap();
        for (PDDLGroundAction gr : this.A) {//see which actions are executable at the current state
//            gr.set_unit_cost(s_0);
            if (gr.isApplicable(s_0)) {
                FibonacciHeapNode node = new FibonacciHeapNode(gr);
                action_to_fib_node.set(gr.id, node);
                a_plus.insert(node, 0f);//add such an action
                action_dist.set(gr.id, 0f);
                if (this.reacheability_setting) {
                    this.reachable.add(gr);
                }
            }
        }

//        Utils.dbg_print(debug - 10, "Total Number of conditions:" + all_conditions.size() + "\n");
        for (Condition c : all_conditions) {//update with a value of 0 to say that condition is sat in init state
            if (c.isSatisfied(s_0)) {
                cond_dist.set(c.getHeuristicId(), 0f);
//                Utils.dbg_print(debug - 10, "Condition that is already satisfied:" + c + "\n");
//                Utils.dbg_print(debug - 10, "Counter is:" + c.getCounter() + "\n");
            } else {
//                Utils.dbg_print(debug - 10, "Condition that is NOT already satisfied:" + c + "\n");
//                Utils.dbg_print(debug - 10, "Counter is:" + c.getCounter() + "\n");
            }

        }
        reachable_here = new LinkedHashSet();
        while (!a_plus.isEmpty()) {//keep going till no action is in the list.

            PDDLGroundAction gr = a_plus.removeMin().getData();
            //if (!conservativehmax || this.additive_h)
            closed.set(gr.id, true);
            reachable_here.add(gr);
//            Utils.dbg_print(debug - 10, "Action Evaluated:" + gr + "\n");
//            Utils.dbg_print(debug - 10, "Cost:" + action_dist.get(gr.counter) + "\n");
            if (gr.dummy_goal) {
                estimate = action_dist.get(gr.id);
                if (!this.reacheability_setting && (this.additive_h || !conservativehmax)) {
//                    System.out.println(this.additive_h);
//                    System.out.println(this.conservativehmax);
                    extract_helpful_actions_or_relaxed_plan();
                    if (estimate == 0f) {
                        return 0.1f;
                    }
                    if (this.relaxed_plan_extraction) {
                        return this.extract_tot_cost(relaxed_plan);
                    }
                    return estimate;
                }
            }
            update_reachable_conditions_actions(s_0, gr, a_plus, action_to_fib_node);//this procedure updates
            //all the conditions that can be reached by using action gr. 
            //This also changes the set a_plus whenever some new action becomes active becasue of gr
        }

//        System.out.println("Estimate: "+estimate);
        if (reacheability_setting || why_not_active) {
            if (estimate == Float.MAX_VALUE) {
                System.out.println("Goal unreachable from init state. Please revise model or instance file");
                find_reasons_of_unsat(cond_dist, this.goal);
            }
        }

        if (this.reacheability_setting) {
            A = reachable;
        }

        if (estimate == Float.MAX_VALUE) {
            return estimate;
        }

        extract_helpful_actions_or_relaxed_plan();
        if (this.relaxed_plan_extraction) {
            return this.extract_tot_cost(relaxed_plan);
        }

        //System.out.println("Conservative Setting");
        return estimate;
    }

    private void update_reachable_conditions_actions(PDDLState s_0, PDDLGroundAction gr, FibonacciHeap<PDDLGroundAction> a_plus, ArrayList<FibonacciHeapNode> never_active) {
        float c_a = Math.max(gr.getAction_cost(), min_cost_action);
        for (Condition comp : this.achieve.get(gr.id)) {//This is the set of all predicates reachable because of gr
            Float current_distance = cond_dist.get(comp.getHeuristicId());
            if (current_distance != 0f) {

                Float cond_dist_comp = c_a + this.action_dist.get(gr.id);
                if (cond_dist_comp != Float.MAX_VALUE) {
                    if (this.relaxed_plan_extraction || this.helpful_actions_computation) {
                        update_achiever(comp, gr);
                    }
                    if (cond_dist_comp < cond_dist.get(comp.getHeuristicId())) {//if this isn't in the init state yet
                        cond_dist.set(comp.getHeuristicId(), cond_dist_comp);//update distance. Meant only to keep track of whether condition reachead or not, and "how"
                        if (this.relaxed_plan_extraction || this.helpful_actions_computation) {
                            established_achiever.set(comp.getHeuristicId(), gr);
                            established_local_cost.set(comp.getHeuristicId(), c_a);
                        }
                        update_reachable_actions(gr, comp, a_plus, never_active);

                    }
                }
            }
        }
        for (Condition comp : this.possible_achievers.get(gr.id)) {
//            Utils.dbg_print(debug - 10, "Condition under analysis:" + comp + "\n");
            if (!this.is_complex.get(comp.getHeuristicId())) {
                Float current_distance = cond_dist.get(comp.getHeuristicId());
                if (current_distance != 0f) {
                    Float rep_needed=this.action_comp_number_execution.get(new Pair(gr.id,comp.getHeuristicId()));
                    if (rep_needed == null){
                        if (gr.infinite_constant_effect){
                            rep_needed = 1f * c_a;
                        }
                        if (this.possible_achievers_inverted.get(comp.getHeuristicId()).size() == 1 || this.integer_actions) {

                            rep_needed = gr.getNumberOfExecutionInt(s_0, (Comparison) comp) * c_a;
                        } else {
                            rep_needed = gr.getNumberOfExecution(s_0, (Comparison) comp) * c_a;
                        }
                        this.action_comp_number_execution.put(new Pair(gr.id,comp.getHeuristicId()),rep_needed);
                    }else{
//                        System.out.println("Cache funziona");
                    }
                    
                    if (rep_needed != Float.MAX_VALUE) {
                        if (this.relaxed_plan_extraction || this.helpful_actions_computation || !this.additive_h) {
                            update_achiever(comp, gr);
                        }
                        Float new_distance = rep_needed;
                        if (this.additive_h) {
                            new_distance += this.action_dist.get(gr.id);
                        } else {

                            //rep_needed += this.action_dist.get(gr.counter);
                            new_distance += min_over_possible_achievers(comp);
                            /*
                            This preserves admissibility.  
                             */
                        }

                        if (new_distance < current_distance) {
                            cond_dist.set(comp.getHeuristicId(), new_distance);
                            if (this.relaxed_plan_extraction || this.helpful_actions_computation) {
                                established_achiever.set(comp.getHeuristicId(), gr);
                                established_local_cost.set(comp.getHeuristicId(), rep_needed);
                            }
                            update_reachable_actions(gr, comp, a_plus, never_active);
                        }

                    }

                }
            } else {
//                System.out.println("Complex condition reasoning");
                Float current_distance = cond_dist.get(comp.getHeuristicId());
                if (current_distance == 0f) {
                    continue;
                }
                Float new_distance = Float.MAX_VALUE;
                if (!this.additive_h || ibr_deactivated) {
                    new_distance = action_dist.get(gr.id) + c_a;//this is a very conservative measure.
                } else {
                    //This can be cached with a map, so that supporters are kept, and only the new ones are added
                    
                    AndCond temp = new AndCond();
                    temp.addConditions(comp);
                            
                    Aibr aibr_handle = new Aibr(temp, reachable_here);
                    //aibr_handle
                    aibr_handle.set(false, true);

                    aibr_handle.light_setup(s_0, this);

                    if (comp.getHeuristicId() > all_conditions.size()) {
                        System.out.println("Condition not intercepted!" + comp + "\n");
                        System.out.println("Identifier:" + comp.getHeuristicId());
                        System.exit(-1);
                    }
                    new_distance = aibr_handle.compute_estimate(s_0);
                }
                if (new_distance != Float.MAX_VALUE) {
                    //new_distance += this.action_dist.get(gr.counter);
                    if (this.relaxed_plan_extraction || this.helpful_actions_computation) {
                        update_achiever(comp, gr);
                    }
                    if (new_distance < current_distance) {
                        cond_dist.set(comp.getHeuristicId(), new_distance);
                        if (this.relaxed_plan_extraction || this.helpful_actions_computation) {
                            established_achiever.set(comp.getHeuristicId(), gr);
                            established_local_cost.set(comp.getHeuristicId(), new_distance);//this does not really work!!
                        }
                        update_reachable_actions(gr, comp, a_plus, never_active);
                    }

                }
//                Utils.dbg_print(debug - 10, "(Complex) Action under consideration and number of needed execution:" + gr + " " + current_distance + "\n");

            }
        }

    }


    private void update_reachable_actions(PDDLGroundAction gr, Condition comp, FibonacciHeap<PDDLGroundAction> a_plus, ArrayList<FibonacciHeapNode> action_to_fib_node) {
        //this procedure shrink landmarks for condition comp using action gr
//        System.out.println(changed);
        Set<PDDLGroundAction> set = condition_to_action.get(comp.getHeuristicId());
        //this mapping contains action that need to be triggered becasue of condition comp
        for (PDDLGroundAction gr2 : set) {
            if (closed.get(gr2.id)) {
                if (this.additive_h || !this.conservativehmax) {
                    continue;
                }
            }
            Float c = check_conditions(gr2);

            if (c < action_dist.get(gr2.id)) {//are conditions all reached, and is this a better path?
                action_dist.set(gr2.id, c);
                if (action_to_fib_node.get(gr2.id) == null) {
                    FibonacciHeapNode n = new FibonacciHeapNode(gr2);
                    a_plus.insert(n, c);//push in the set of actions to consider. 
                    action_to_fib_node.set(gr2.id, n);
                } else if (closed.get(gr2.id)) {
                    a_plus.insert(action_to_fib_node.get(gr2.id), c);
                    closed.set(gr2.id, false);
                } else {
                    a_plus.decreaseKey(action_to_fib_node.get(gr2.id), c);//push in the set of actions to consider. 
                }
                //Need to understand whether is worth to do check on the list to see if action already is there.
                if (this.reacheability_setting) {
                    this.reachable.add(gr2);
                }
            }

        }
    }

    private Float check_conditions(PDDLGroundAction gr2) {
        if (relaxed_plan_extraction || this.helpful_actions_computation) {
            achiever_set s = gr2.getPreconditions().estimate_cost(cond_dist, additive_h, established_achiever);
            action_achievers.set(gr2.id, s);
            return s.cost;
        } else {
            return gr2.getPreconditions().estimate_cost(cond_dist, additive_h);
        }

    }

    private void generate_link_precondition_action() {
        condition_to_action = new ArrayList<>(nCopies(all_conditions.size() + 1, null));
        for (Condition c : all_conditions) {
            LinkedHashSet<PDDLGroundAction> set = new LinkedHashSet();
            for (PDDLGroundAction gr : A) {
                if (gr.getPreconditions().getTerminalConditions().contains(c)) {
                    set.add(gr);
                }
            }
            condition_to_action.set(c.getHeuristicId(), set);

        }
    }

    private void compute_helpful_actions() {
        LinkedList<PDDLGroundAction> list = new LinkedList();
        helpful_actions = new LinkedHashSet();
        achiever_set s = this.action_achievers.get(goal.id);
        getHelpfulActions(list, s);
        while (!list.isEmpty()) {
            PDDLGroundAction gr2 = list.pollLast();
//            System.out.println(gr);
            s = this.action_achievers.get(gr2.id);
            getHelpfulActions(list, s);
        }
//        Utils.dbg_print(debug, "HelpfulActions: " + helpful_actions.toString() + "\n");
    }

    private void compute_relaxed_plan() {//this should be updated!

        LinkedList<Condition> list = new LinkedList();
        relaxed_plan = new LinkedList();

        helpful_actions = new LinkedHashSet();
        achiever_set s = this.action_achievers.get(goal.id);
        HashSet<Integer> visited = new HashSet();
        for (Condition c : s.target_cond) {
            list.add(c);
            visited.add(c.getHeuristicId());
        }
        while (!list.isEmpty()) {
            Condition c = list.pollLast();
            Float cost = this.cond_dist.get(c.getHeuristicId());
            if (cost != 0) {
                PDDLGroundAction gr = this.established_achiever.get(c.getHeuristicId());
                this.update_relaxed_plan(relaxed_plan, gr, this.established_local_cost.get(c.getHeuristicId()));
                if (this.is_complex.get(c.getHeuristicId()) || weak_helpful_actions_pruning) {
                    if (this.all_achievers.get(c.getHeuristicId()) != null) {
                        //System.out.println("Getting all the achievers as helpful actions..");
                        for (PDDLGroundAction gr2 : this.all_achievers.get(c.getHeuristicId())) {
                            if (this.action_dist.get(gr2.id) == 0) {
                                this.helpful_actions.add(gr2);
                            }
                        }
                    }
                }
                if (this.action_dist.get(gr.id) == 0) {
                    this.helpful_actions.add(gr);
                } else {
                    achiever_set ach_set = this.action_achievers.get(gr.id);
                    if (ach_set != null) {
                        for (Condition c1 : ach_set.target_cond) {
                            if (!visited.contains(c1.getHeuristicId())) {
                                list.add(c1);
                                visited.add(c1.getHeuristicId());
                            }
                        }
                    }
                }
            }
//            System.out.println("List:"+list);
        }

//      
    }

    private void update_achiever(Condition comp, PDDLGroundAction gr) {

        LinkedHashSet s = all_achievers.get(comp.getHeuristicId());
        if (s == null) {
            s = new LinkedHashSet();
        }
        s.add(gr);
        all_achievers.set(comp.getHeuristicId(), s);
    }

    private void extract_helpful_actions_or_relaxed_plan() {

        if (this.relaxed_plan_extraction) {
            compute_relaxed_plan();
        } else if (this.helpful_actions_computation) {
            //System.out.println("Computing helpful actions");
            this.compute_helpful_actions();
        }

    }

    private void getHelpfulActions(LinkedList<PDDLGroundAction> list, achiever_set s) {
        if (s != null) {
            for (Condition o : s.target_cond) {
                if (cond_dist.get(o.getHeuristicId()) == 0) {
                    continue;
                }
//                if (o != null) {
                //System.out.println("Helpful actions extraction");
                if (this.is_complex.get(o.getHeuristicId()) || weak_helpful_actions_pruning) {
                    if (this.all_achievers.get(o.getHeuristicId()) != null) {
                        //System.out.println("Getting all the achievers as helpful actions..");
                        for (PDDLGroundAction gr : this.all_achievers.get(o.getHeuristicId())) {
                            if (this.action_dist.get(gr.id) == 0) {
                                this.helpful_actions.add(gr);
                            }
                        }
                    }
                } else {//Add helpful action if this action is an established achiever of any condition in the target condition and is applicable
                    //in the initial state
                    PDDLGroundAction gr = this.established_achiever.get(o.getHeuristicId());
//                        if (gr==null && cond_dist.get(o.getCounter())!=0){
//                            System.out.println("this is bizzare");
//                            System.out.println(o);
//                            System.exit(-1);
//                        }
//                        if (this.action_dist.get(gr.counter)==null){
//                            System.out.println("Action not classified. Very strange:"+gr);
//                            System.out.println("Counter"+gr.counter);
//                            System.out.println("Max number of actions"+this.total_number_of_actions);
//                        }
                    if (this.action_dist.get(gr.id) == 0) {
                        this.helpful_actions.add(gr);
                    }

                }
//                }
            }
            for (PDDLGroundAction gr : s.actions) {
                if (gr != null) {
                    list.addFirst(gr);
                }
            }
        }
    }

    private void find_reasons_of_unsat(ArrayList<Float> cond_dist, PDDLGroundAction goal) {

        //works only for conjunction
        for (Condition c : goal.getPreconditions().getTerminalConditions()) {
            if (cond_dist.get(c.getHeuristicId()) == Float.MAX_VALUE) {
                System.out.println("Unreachable in the relaxation: " + c);
            }
        }

    }

    private Float min_over_possible_achievers(Condition comp) {
        Set<PDDLGroundAction> set = this.all_achievers.get(comp.getHeuristicId());
        Float min = Float.MAX_VALUE;
        for (PDDLGroundAction gr : set) {
            min = Math.min(action_dist.get(gr.id), min);
            if (min == 0) {
                return 0f;
            }
        }
        return min;
    }

    private void update_relaxed_plan(LinkedList<Pair<PDDLGroundAction, Float>> plan, PDDLGroundAction g, Float cost) {

        for (int i = plan.size() - 1; i >= 0; i--) {
            Pair<PDDLGroundAction, Float> gr_pair = plan.get(i);
//            System.out.println(g.getClass());
            if (gr_pair.getFirst().equals(g)) {
//                System.out.println("DEBUG!");
                gr_pair.setSecond(Math.max(cost, gr_pair.getSecond()));
                plan.set(i, gr_pair);
                return;
            }

            if (only_mutual_exclusion_processes) {//work from here to have hff sensible to process structure!
                if (g instanceof problem.GroundProcess || g instanceof problem.GroundEvent) {//very very conservative
                    if (gr_pair.getFirst() instanceof problem.GroundProcess || gr_pair.getFirst() instanceof problem.GroundEvent) {
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
        plan.addFirst(new Pair(g, cost));
    }

    private Float extract_tot_cost(LinkedList<Pair<PDDLGroundAction, Float>> plan) {
        Float cost = 0f;
        for (Pair<PDDLGroundAction, Float> p : plan) {
            cost += p.getSecond();
        }
        return cost;
    }

    protected void simplify_actions(PDDLState init) {
        for (PDDLGroundAction gr : (Collection<PDDLGroundAction>) this.A) {
            try {
                if (gr.getPreconditions() != null) {
                    gr.setPreconditions((ComplexCondition) gr.getPreconditions().transform_equality());
                }
                if (gr.getNumericEffects() != null && !gr.getNumericEffects().sons.isEmpty()) {
                    int number_numericEffects = gr.getNumericEffects().sons.size();
                    for (Iterator it = gr.getNumericEffects().sons.iterator(); it.hasNext();) {
                        NumEffect neff = (NumEffect) it.next();
                        if (neff.getOperator().equals("assign")) {
                            ExtendedNormExpression right = (ExtendedNormExpression) neff.getRight();
                            try {
                                if (right.isNumber() && neff.getFluentAffected().eval(init) != null && (number_numericEffects == 1 || risky)) {//constant effect
                                    //Utils.dbg_print(3,neff.toString());
//                            if (number_numericEffects == 1) {
                                    neff.setOperator("increase");
                                    neff.setRight(new BinaryOp(neff.getRight(), "-", neff.getFluentAffected(), true).normalize());
                                    neff.setPseudo_num_effect(true);
//                            }
                                }
                            } catch (Exception ex) {
                                Logger.getLogger(h1.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                    }
                }
                gr.normalize();
            } catch (Exception ex) {
                Logger.getLogger(h1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.G = (ComplexCondition) this.G.transform_equality();
        this.G.normalize();
    }
    
    
    protected boolean generate_achievers() throws Exception {
        interact_with = new HashMap();
        achieve = new HashMap();
        possible_achievers = new HashMap();
        this.possible_achievers_inverted = new HashMap();
        achievers_inverted = new HashMap();
        precondition_mapping = new HashMap();

        //this should also include the indirect dependencies, otherwise does not work!!
        Set<PDDLGroundAction> useless_actions = new HashSet();
        for (PDDLGroundAction gr : this.A) {
            LinkedHashSet<Comparison> comparisons = new LinkedHashSet();
            LinkedHashSet<Comparison> reacheable_comparisons = new LinkedHashSet();
            LinkedHashSet<Condition> literals = new LinkedHashSet();
            boolean at_least_one_service = false;
            for (Condition c : this.all_conditions) {

                if (precondition_mapping.get(c.getHeuristicId()) == null) {
                    precondition_mapping.put(c.getHeuristicId(), new LinkedHashSet());
                }
                LinkedHashSet<PDDLGroundAction> action_list = new LinkedHashSet();
                if (c instanceof Comparison) {
//                    System.out.println("Condition under analysis:"+c);
//                    System.out.println("Counter is:"+c.getCounter());
                    Comparison comp = (Comparison) c;
                    if (comp.involve(gr.getNumericFluentAffected())) {
                        comparisons.add(comp);

                        if (this.is_complex.get(comp.getHeuristicId())) {
                            at_least_one_service = true;
                            reacheable_comparisons.add(comp);
                        } else if (gr.is_possible_achiever_of(comp)) {
                            at_least_one_service = true;
                            reacheable_comparisons.add(comp);
                            action_list.add(gr);
                        }
                    }
                    if (this.possible_achievers_inverted.get(comp.getHeuristicId()) == null) {
                        this.possible_achievers_inverted.put(comp.getHeuristicId(), action_list);
                    } else {
                        LinkedHashSet<PDDLGroundAction> temp = this.possible_achievers_inverted.get(comp.getHeuristicId());
                        temp.addAll(action_list);
                        this.possible_achievers_inverted.put(comp.getHeuristicId(), temp);
                    }
                } else if (c instanceof Predicate) {
                    Predicate p = (Predicate) c;
                    if (gr.achieve(p)) {
                        at_least_one_service = true;
                        literals.add(p);
                        action_list.add(gr);
                    }
                    if (this.achievers_inverted.get(p.getHeuristicId()) == null) {
                        this.achievers_inverted.put(p.getHeuristicId(), action_list);
                    } else {
                        LinkedHashSet<PDDLGroundAction> temp = this.achievers_inverted.get(p.getHeuristicId());
                        temp.addAll(action_list);
                        this.achievers_inverted.put(p.getHeuristicId(), temp);
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
                    if (this.achievers_inverted.get(c1.getHeuristicId()) == null) {
                        this.achievers_inverted.put(c1.getHeuristicId(), action_list);
                    } else {
                        LinkedHashSet<PDDLGroundAction> temp = this.achievers_inverted.get(c1.getHeuristicId());
                        temp.addAll(action_list);
                        this.achievers_inverted.put(c1.getHeuristicId(), temp);
                    }

                }

                if (gr.preconditioned_on(c)) {//build mapping from atoms to actions
//                    System.out.println("Gr:"+ gr);
//                    try {
//                        System.in.read();
//                    } catch (IOException ex) {
//                        Logger.getLogger(Uniform_cost_search_H1.class.getName()).log(Level.SEVERE, null, ex);
//                    }

                    LinkedHashSet<PDDLGroundAction> temp = this.precondition_mapping.get(c.getHeuristicId());
                    temp.add(gr);
                    this.precondition_mapping.put(c.getHeuristicId(), temp);

                }

            }
//            if (at_least_one_service){
            achieve.put(gr.id, literals);
            interact_with.put(gr.id, comparisons);
            possible_achievers.put(gr.id, reacheable_comparisons);
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
            for (PDDLGroundAction gr : A) {
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
            LinkedHashSet<PDDLGroundAction> action_list = new LinkedHashSet();
            for (PDDLGroundAction gr : A) {
                for (NumEffect neff : gr.getNumericEffectsAsCollection()) {

                    if (sorted_nodes.contains(neff)) {
                        possible_achievers.get(gr.id).add(comp);
                        action_list.add(gr);
                    }

                }
            }
            if (this.possible_achievers_inverted.get(comp.getHeuristicId()) == null) {
                this.possible_achievers_inverted.put(comp.getHeuristicId(), action_list);
            } else {
                LinkedHashSet<PDDLGroundAction> temp = this.possible_achievers_inverted.get(comp.getHeuristicId());
                temp.addAll(action_list);
                this.possible_achievers_inverted.put(comp.getHeuristicId(), temp);
            }
            if (debug == 1) {
                System.out.println("Comparison:" + comp);
                System.out.println("Achievers Set" + this.possible_achievers_inverted.get(comp.getHeuristicId()));
            }

        }
        Utils.dbg_print(debug, "Complex achievers identified");
        return false;//to fix at some point
    }
    


}

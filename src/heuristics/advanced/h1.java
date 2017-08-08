/**
 * *******************************************************************
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 *
 ********************************************************************
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heuristics.advanced;

import heuristics.utils.achiever_set;
import heuristics.old.Uniform_cost_search_H1;
import heuristics.old.Uniform_cost_search_H1_RC;
import conditions.Comparison;
import conditions.Conditions;
import expressions.BinaryOp;
import expressions.ExtendedNormExpression;
import expressions.NumEffect;
import extraUtils.Pair;
import extraUtils.Utils;
import heuristics.Aibr;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collection;
import static java.util.Collections.nCopies;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jgrapht.util.FibonacciHeap;
import org.jgrapht.util.FibonacciHeapNode;
import problem.GroundAction;
import problem.GroundProcess;
import problem.State;

/**
 *
 * @author enrico
 */
public class h1 extends Uniform_cost_search_H1 {

    public ArrayList<Integer> dplus;//this is the minimum number of actions needed to achieve a given condition

    private ArrayList<Set<GroundAction>> condition_to_action;

    public boolean compute_lp;
    private ArrayList<Float> cond_dist;
    private ArrayList<Float> action_dist;

    public boolean red_constraints = false;
    public boolean mip;
    private ArrayList<GroundAction> established_achiever;
    private ArrayList<achiever_set> action_achievers;
    public boolean relaxed_plan_extraction = false;
    private GroundAction goal;
    private ArrayList<LinkedHashSet<GroundAction>> all_achievers;
    private Set<GroundAction> reachable_here;
//    private Aibr aibr_handler;
    private boolean all_achievers_to_consider = false;
    private ArrayList<Boolean> closed;
    private float min_cost_action;
    public boolean conservativehmax = true;
    public boolean ibr_deactivated = false;
    private LinkedList<Pair<GroundAction, Float>> relaxed_plan;
    private ArrayList<Float> established_local_cost;
    private boolean risky = true;

    public h1(Conditions goal, Set<GroundAction> A, Set<GroundProcess> P) {
        super(goal, A, P);

    }

    public h1(Conditions G, Set A, Set processesSet, Set events) {
        super(G, A, processesSet, events);
    }

    @Override
    public Float setup(State s) {

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
                Logger.getLogger(Uniform_cost_search_H1_RC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (additive_h) {
            min_cost_action = 0.001f;
        } else {
            min_cost_action = 0.0f;
        }
        goal = new GroundAction("goal");
        goal.dummy_goal = true;
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
                Logger.getLogger(Uniform_cost_search_H1.class.getName()).log(Level.SEVERE, null, ex);
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
        //Utils.dbg_print(10, this.complex_condition_set.toString());
        //System.out.println("Finished setup");
        return ret;
    }

    @Override
    public Float compute_estimate(State s_0) {
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
        FibonacciHeap<GroundAction> a_plus = new FibonacciHeap();//actions executable. Progressively updated
        ArrayList<FibonacciHeapNode> action_to_fib_node = new ArrayList<>(nCopies(total_number_of_actions + 1, null));//mapping between action and boolean. True if action has not been activated yet
        cond_dist = new ArrayList<>(nCopies(all_conditions.size() + 1, Float.MAX_VALUE));//keep track of conditions that have been reachead yet
        action_dist = new ArrayList<>(nCopies(total_number_of_actions + 1, Float.MAX_VALUE));//keep track of conditions that have been reachead yet        
        closed = new ArrayList<>(nCopies(total_number_of_actions + 1, false));
        for (GroundAction gr : this.A) {//see which actions are executable at the current state
            gr.setAction_cost(s_0);
            if (gr.isApplicable(s_0)) {
                FibonacciHeapNode node = new FibonacciHeapNode(gr);
                action_to_fib_node.set(gr.counter, node);
                a_plus.insert(node, 0f);//add such an action
                action_dist.set(gr.counter, 0f);
                if (this.reacheability_setting) {
                    this.reachable.add(gr);
                }
            }
        }

//        Utils.dbg_print(debug - 10, "Total Number of conditions:" + all_conditions.size() + "\n");
        for (Conditions c : all_conditions) {//update with a value of 0 to say that condition is sat in init state
            if (c.isSatisfied(s_0)) {
                cond_dist.set(c.getCounter(), 0f);
//                Utils.dbg_print(debug - 10, "Condition that is already satisfied:" + c + "\n");
//                Utils.dbg_print(debug - 10, "Counter is:" + c.getCounter() + "\n");
            } else {
//                Utils.dbg_print(debug - 10, "Condition that is NOT already satisfied:" + c + "\n");
//                Utils.dbg_print(debug - 10, "Counter is:" + c.getCounter() + "\n");
            }

        }
        reachable_here = new LinkedHashSet();
        while (!a_plus.isEmpty()) {//keep going till no action is in the list.

            GroundAction gr = a_plus.removeMin().getData();
            //if (!conservativehmax || this.additive_h)
            closed.set(gr.counter, true);
            reachable_here.add(gr);
//            Utils.dbg_print(debug - 10, "Action Evaluated:" + gr + "\n");
//            Utils.dbg_print(debug - 10, "Cost:" + action_dist.get(gr.counter) + "\n");
            if (gr.dummy_goal) {
                estimate = action_dist.get(gr.counter);
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

    private void update_reachable_conditions_actions(State s_0, GroundAction gr, FibonacciHeap<GroundAction> a_plus, ArrayList<FibonacciHeapNode> never_active) {
        float c_a = Math.max(gr.getAction_cost(), min_cost_action);
        for (Conditions comp : this.achieve.get(gr.counter)) {//This is the set of all predicates reachable because of gr
            Float current_distance = cond_dist.get(comp.getCounter());
            if (current_distance != 0f) {

                Float cond_dist_comp = c_a + this.action_dist.get(gr.counter);
                if (cond_dist_comp != Float.MAX_VALUE) {
                    if (this.relaxed_plan_extraction || this.helpful_actions_computation) {
                        update_achiever(comp, gr);
                    }
                    if (cond_dist_comp < cond_dist.get(comp.getCounter())) {//if this isn't in the init state yet
                        cond_dist.set(comp.getCounter(), cond_dist_comp);//update distance. Meant only to keep track of whether condition reachead or not, and "how"
                        if (this.relaxed_plan_extraction || this.helpful_actions_computation) {
                            established_achiever.set(comp.getCounter(), gr);
                            established_local_cost.set(comp.getCounter(), c_a);
                        }
                        update_reachable_actions(gr, comp, a_plus, never_active);

                    }
                }
            }
        }
        for (Conditions comp : this.possible_achievers.get(gr.counter)) {
//            Utils.dbg_print(debug - 10, "Condition under analysis:" + comp + "\n");
            if (!this.is_complex.get(comp.getCounter())) {
                Float current_distance = cond_dist.get(comp.getCounter());
                if (current_distance != 0f) {

                    Float rep_needed;

                    if (this.possible_achievers_inverted.get(comp.getCounter()).size() == 1 || this.integer_actions) {

                        rep_needed = gr.getNumberOfExecutionInt(s_0, (Comparison) comp) * c_a;
                    } else {
                        rep_needed = gr.getNumberOfExecution(s_0, (Comparison) comp) * c_a;
                    }
                    if (rep_needed != Float.MAX_VALUE) {
                        if (this.relaxed_plan_extraction || this.helpful_actions_computation || !this.additive_h) {
                            update_achiever(comp, gr);
                        }
                        Float new_distance = rep_needed;
                        if (this.additive_h) {
                            new_distance += this.action_dist.get(gr.counter);
                        } else {

                            //rep_needed += this.action_dist.get(gr.counter);
                            new_distance += min_over_possible_achievers(comp);
                            /*
                            This preserves admissibility.  
                             */
                        }

                        if (new_distance < current_distance) {
                            cond_dist.set(comp.getCounter(), new_distance);
                            if (this.relaxed_plan_extraction || this.helpful_actions_computation) {
                                established_achiever.set(comp.getCounter(), gr);
                                established_local_cost.set(comp.getCounter(), rep_needed);
                            }
                            update_reachable_actions(gr, comp, a_plus, never_active);
                        }

                    }

                }
            } else {
//                System.out.println("Complex condition reasoning");
                Float current_distance = cond_dist.get(comp.getCounter());
                if (current_distance == 0f) {
                    continue;
                }
                Float new_distance = Float.MAX_VALUE;
                if (!this.additive_h || ibr_deactivated) {
                    new_distance = action_dist.get(gr.counter) + c_a;//this is a very conservative measure.
                } else {
                    //This can be cached with a map, so that supporters are kept, and only the new ones are added
                    Aibr aibr_handle = new Aibr(comp, reachable_here);
                    //aibr_handle
                    aibr_handle.set(false, true);

                    aibr_handle.light_setup(s_0, this);

                    if (comp.getCounter() > all_conditions.size()) {
                        System.out.println("Condition not intercepted!" + comp + "\n");
                        System.out.println("Identifier:" + comp.getCounter());
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
                        cond_dist.set(comp.getCounter(), new_distance);
                        if (this.relaxed_plan_extraction || this.helpful_actions_computation) {
                            established_achiever.set(comp.getCounter(), gr);
                            established_local_cost.set(comp.getCounter(), new_distance);//this does not really work!!

                        }
                        update_reachable_actions(gr, comp, a_plus, never_active);
                    }

                }
//                Utils.dbg_print(debug - 10, "(Complex) Action under consideration and number of needed execution:" + gr + " " + current_distance + "\n");

            }
        }

    }

    private void update_reachable_actions(GroundAction gr, Conditions comp, FibonacciHeap<GroundAction> a_plus, ArrayList<FibonacciHeapNode> action_to_fib_node) {
        //this procedure shrink landmarks for condition comp using action gr
//        System.out.println(changed);
        Set<GroundAction> set = condition_to_action.get(comp.getCounter());
        //this mapping contains action that need to be triggered becasue of condition comp
        for (GroundAction gr2 : set) {
            if (closed.get(gr2.counter)) {
                if (this.additive_h || !this.conservativehmax) {
                    continue;
                }
            }
            Float c = check_conditions(gr2);

            if (c < action_dist.get(gr2.counter)) {//are conditions all reached, and is this a better path?
                action_dist.set(gr2.counter, c);
                if (action_to_fib_node.get(gr2.counter) == null) {
                    FibonacciHeapNode n = new FibonacciHeapNode(gr2);
                    a_plus.insert(n, c);//push in the set of actions to consider. 
                    action_to_fib_node.set(gr2.counter, n);
                } else if (closed.get(gr2.counter)) {
                    a_plus.insert(action_to_fib_node.get(gr2.counter), c);
                    closed.set(gr2.counter, false);
                } else {
                    a_plus.decreaseKey(action_to_fib_node.get(gr2.counter), c);//push in the set of actions to consider. 
                }
                //Need to understand whether is worth to do check on the list to see if action already is there.
                if (this.reacheability_setting) {
                    this.reachable.add(gr2);
                }
            }

        }
    }

    private Float check_conditions(GroundAction gr2) {
        if (relaxed_plan_extraction || this.helpful_actions_computation) {
            achiever_set s = gr2.getPreconditions().estimate_cost(cond_dist, additive_h, established_achiever);
            action_achievers.set(gr2.counter, s);
            return s.cost;
        } else {
            return gr2.getPreconditions().estimate_cost(cond_dist, additive_h);
        }

    }

    private void generate_link_precondition_action() {
        condition_to_action = new ArrayList<>(nCopies(all_conditions.size() + 1, null));
        for (Conditions c : all_conditions) {
            LinkedHashSet<GroundAction> set = new LinkedHashSet();
            for (GroundAction gr : A) {
                if (gr.getPreconditions().getTerminalConditions().contains(c)) {
                    set.add(gr);
                }
            }
            condition_to_action.set(c.getCounter(), set);

        }
    }

    private void compute_helpful_actions() {
        LinkedList<GroundAction> list = new LinkedList();
        helpful_actions = new LinkedHashSet();
        achiever_set s = this.action_achievers.get(goal.counter);
        getHelpfulActions(list, s);
        while (!list.isEmpty()) {
            GroundAction gr2 = list.pollLast();
//            System.out.println(gr);
            s = this.action_achievers.get(gr2.counter);
            getHelpfulActions(list, s);
        }
//        Utils.dbg_print(debug, "HelpfulActions: " + helpful_actions.toString() + "\n");
    }

    private void compute_relaxed_plan() {//this should be updated!

        LinkedList<Conditions> list = new LinkedList();
        relaxed_plan = new LinkedList();

        helpful_actions = new LinkedHashSet();
        achiever_set s = this.action_achievers.get(goal.counter);
        HashSet<Integer> visited = new HashSet();
        for (Conditions c : s.target_cond) {
            list.add(c);
            visited.add(c.getCounter());
        }
        while (!list.isEmpty()) {
            Conditions c = list.pollLast();
            Float cost = this.cond_dist.get(c.getCounter());
            if (cost != 0) {
                GroundAction gr = this.established_achiever.get(c.getCounter());
                this.update_relaxed_plan(relaxed_plan, gr, this.established_local_cost.get(c.getCounter()));
                if (this.is_complex.get(c.getCounter()) || weak_helpful_actions_pruning) {
                    if (this.all_achievers.get(c.getCounter()) != null) {
                        //System.out.println("Getting all the achievers as helpful actions..");
                        for (GroundAction gr2 : this.all_achievers.get(c.getCounter())) {
                            if (this.action_dist.get(gr2.counter) == 0) {
                                this.helpful_actions.add(gr2);
                            }
                        }
                    }
                }
                if (this.action_dist.get(gr.counter) == 0) {
                    this.helpful_actions.add(gr);
                } else {
                    achiever_set ach_set = this.action_achievers.get(gr.counter);
                    if (ach_set != null) {
                        for (Conditions c1 : ach_set.target_cond) {
                            if (!visited.contains(c1.getCounter())) {
                                list.add(c1);
                                visited.add(c1.getCounter());
                            }
                        }
                    }
                }
            }
//            System.out.println("List:"+list);
        }

//      
    }

    private void update_achiever(Conditions comp, GroundAction gr) {

        LinkedHashSet s = all_achievers.get(comp.getCounter());
        if (s == null) {
            s = new LinkedHashSet();
        }
        s.add(gr);
        all_achievers.set(comp.getCounter(), s);
    }

    private void extract_helpful_actions_or_relaxed_plan() {

        if (this.relaxed_plan_extraction) {
            compute_relaxed_plan();
        } else if (this.helpful_actions_computation) {
            //System.out.println("Computing helpful actions");
            this.compute_helpful_actions();
        }

    }

    private void getHelpfulActions(LinkedList<GroundAction> list, achiever_set s) {
        if (s != null) {
            for (Conditions o : s.target_cond) {
                if (cond_dist.get(o.getCounter()) == 0) {
                    continue;
                }
//                if (o != null) {
                //System.out.println("Helpful actions extraction");
                if (this.is_complex.get(o.getCounter()) || weak_helpful_actions_pruning) {
                    if (this.all_achievers.get(o.getCounter()) != null) {
                        //System.out.println("Getting all the achievers as helpful actions..");
                        for (GroundAction gr : this.all_achievers.get(o.getCounter())) {
                            if (this.action_dist.get(gr.counter) == 0) {
                                this.helpful_actions.add(gr);
                            }
                        }
                    }
                } else {//Add helpful action if this action is an established achiever of any condition in the target condition and is applicable
                    //in the initial state
                    GroundAction gr = this.established_achiever.get(o.getCounter());
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
                    if (this.action_dist.get(gr.counter) == 0) {
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

    private void find_reasons_of_unsat(ArrayList<Float> cond_dist, GroundAction goal) {

        //works only for conjunction
        for (Conditions c : goal.getPreconditions().getTerminalConditions()) {
            if (cond_dist.get(c.getCounter()) == Float.MAX_VALUE) {
                System.out.println("Unreachable in the relaxation: " + c);
            }
        }

    }

    private Float min_over_possible_achievers(Conditions comp) {
        Set<GroundAction> set = this.all_achievers.get(comp.getCounter());
        Float min = Float.MAX_VALUE;
        for (GroundAction gr : set) {
            min = Math.min(action_dist.get(gr.counter), min);
            if (min == 0) {
                return 0f;
            }
        }
        return min;
    }

    private void update_relaxed_plan(LinkedList<Pair<GroundAction, Float>> plan, GroundAction g, Float cost) {

        for (int i = plan.size() - 1; i >= 0; i--) {
            Pair<GroundAction, Float> gr_pair = plan.get(i);
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

    private Float extract_tot_cost(LinkedList<Pair<GroundAction, Float>> plan) {
        Float cost = 0f;
        for (Pair<GroundAction, Float> p : plan) {
            cost += p.getSecond();
        }
        return cost;
    }

    protected void simplify_actions(State init) {
        for (GroundAction gr : (Collection<GroundAction>) this.A) {
            try {
                if (gr.getPreconditions() != null) {
                    gr.setPreconditions(gr.getPreconditions().transform_equality());
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
        this.G = this.G.transform_equality();
        this.G.normalize();
    }

}

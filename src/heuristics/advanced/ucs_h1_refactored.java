/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heuristics.advanced;

import conditions.Comparison;
import conditions.Conditions;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collection;
import static java.util.Collections.nCopies;
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
public class ucs_h1_refactored extends Uniform_cost_search_H1 {

    public ArrayList<Integer> dplus;//this is the minimum number of actions needed to achieve a given condition

    private ArrayList<Set<GroundAction>> condition_to_action;

    public boolean compute_lp;
    private ArrayList<Float> cond_dist;
    private ArrayList<Float> action_dist;

    public boolean red_constraints = false;
    public boolean mip;
    private ArrayList<GroundAction> established_achiever;
    private ArrayList<achiever_set> action_achievers;
    public boolean relaxed_plan_extraction = true;
    private GroundAction goal;
    private ArrayList<LinkedHashSet<GroundAction>> all_achievers;
    public boolean only_helpful_actions = true;

    public ucs_h1_refactored(Conditions goal, Set<GroundAction> A, Set<GroundProcess> P) {
        super(goal, A, P);

    }

    @Override
    public Float setup(State s) {

        if (red_constraints) {
            try {
                this.add_redundant_constraints();
            } catch (Exception ex) {
                Logger.getLogger(Uniform_cost_search_H1_RC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        goal = new GroundAction("goal");
        goal.dummy_goal = true;
        goal.setPreconditions(G);
        A.add(goal);
        build_integer_representation();
        identify_complex_conditions(all_conditions, A);
        this.generate_link_precondition_action();
        try {
            generate_achievers();
        } catch (Exception ex) {
            Logger.getLogger(Uniform_cost_search_H1.class.getName()).log(Level.SEVERE, null, ex);
        }
        reacheability_setting = true;
        this.dbg_print("Reachability Analysis Started");
        Float ret = compute_estimate(s);
        this.dbg_print("Reachability Analysis Terminated");
        reacheability_setting = false;
        sat_test_within_cost = false; //don't need to recheck precondition sat for each state. It is done in the beginning for every possible condition
        out.println("Hard Conditions: " + this.complex_conditions);
        out.println("Simple Conditions: " + (this.all_conditions.size() - this.complex_conditions));

        //redo construction of integer to avoid spurious actions
        build_integer_representation();
        identify_complex_conditions(all_conditions, A);
        this.generate_link_precondition_action();
        try {
            generate_achievers();
        } catch (Exception ex) {
            Logger.getLogger(Uniform_cost_search_H1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    @Override
    public Float compute_estimate(State s_0) {
        if (s_0.satisfy(G)) {
            return 0f;
        }
        established_achiever = new ArrayList<>(nCopies(all_conditions.size() + 1, null));
        action_achievers = new ArrayList<>(nCopies(A.size() + 1, null));
        all_achievers = new ArrayList<>(nCopies(all_conditions.size() + 1, null));
        Float estimate = Float.MAX_VALUE;
        FibonacciHeap<GroundAction> a_plus = new FibonacciHeap();//actions executable. Progressively updated
        ArrayList<FibonacciHeapNode> action_to_fib_node = new ArrayList<>(nCopies(A.size() + 1, null));//mapping between action and boolean. True if action has not been activated yet
        cond_dist = new ArrayList<>(nCopies(all_conditions.size() + 1, Float.MAX_VALUE));//keep track of conditions that have been reachead yet
        action_dist = new ArrayList<>(nCopies(A.size() + 1, Float.MAX_VALUE));//keep track of conditions that have been reachead yet        

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

        for (Conditions c : all_conditions) {//update with a value of 0 to say that condition is sat in init state
            if (c.isSatisfied(s_0)) {
                cond_dist.set(c.getCounter(), 0f);
                this.dbg_print("Condition that is already satisfied:" + c + "\n");
                this.dbg_print("Counter is:" + c.getCounter() + "\n");
            }
        }

        while (!a_plus.isEmpty()) {//keep going till no action is in the list. Look that here actions can be re-added
            GroundAction gr = a_plus.removeMin().getData();
            this.dbg_print("Action Evaluated:" + gr + "\n");
            this.dbg_print("Cost:" + action_dist.get(gr.counter) + "\n");
            if (gr.dummy_goal) {
                estimate = action_dist.get(gr.counter);
                if (!this.reacheability_setting) {
                    extract_helpful_actions_or_relaxed_plan();
                    return estimate;
                }
            }
            update_reachable_conditions_actions(s_0, gr, a_plus, action_to_fib_node);//this procedure updates
            //all the conditions that can be reached by using action gr. 
            //This also changes the set a_plus whenever some new action becomes active becasue of gr
        }

        if (this.reacheability_setting) {
            A = reachable;
        }

        extract_helpful_actions_or_relaxed_plan();


        return estimate;
    }

    private void update_reachable_conditions_actions(State s_0, GroundAction gr, FibonacciHeap<GroundAction> a_plus, ArrayList<FibonacciHeapNode> never_active) {
        for (Conditions comp : this.achieve.get(gr.counter)) {//This is the set of all predicates reachable because of gr
            Float current_distance = cond_dist.get(comp.getCounter());
            if (current_distance != 0f) {
                Float cond_dist_comp = gr.getAction_cost() + this.action_dist.get(gr.counter);
                if (cond_dist_comp != Float.MAX_VALUE) {
                    update_achiever(comp, gr);
                    if (cond_dist_comp < cond_dist.get(comp.getCounter())) {//if this isn't in the init state yet
                        cond_dist.set(comp.getCounter(), cond_dist_comp);//update distance. Meant only to keep track of whether condition reachead or not, and "how"
                        established_achiever.set(comp.getCounter(), gr);
                        update_reachable_actions(gr, comp, a_plus, never_active);

                    }
                }
            }
        }
        for (Conditions comp : this.possible_achievers.get(gr.counter)) {
            Float current_distance = cond_dist.get(comp.getCounter());
            if (current_distance != 0f) {
                Float rep_needed;
                if (this.possible_achievers_inverted.get(comp.getCounter()).size() == 1) {
                    rep_needed = gr.getNumberOfExecutionInt(s_0, (Comparison) comp) * gr.getAction_cost();
                } else {
                    rep_needed = gr.getNumberOfExecution(s_0, (Comparison) comp) * gr.getAction_cost();
                }

                if (rep_needed != Float.MAX_VALUE) {
                    rep_needed += this.action_dist.get(gr.counter);
                    update_achiever(comp, gr);
                    if (rep_needed < current_distance) {
                        cond_dist.set(comp.getCounter(), rep_needed);
                        established_achiever.set(comp.getCounter(), gr);
                        update_reachable_actions(gr, comp, a_plus, never_active);
                    }

                }

            }
        }
    }

    private void update_reachable_actions(GroundAction gr, Conditions comp, FibonacciHeap<GroundAction> a_plus, ArrayList<FibonacciHeapNode> action_to_fib_node) {
        //this procedure shrink landmarks for condition comp using action gr
//        System.out.println(changed);
        Set<GroundAction> set = condition_to_action.get(comp.getCounter());
        //this mapping contains action that need to be triggered becasue of condition comp
        for (GroundAction gr2 : set) {
            if (gr2.counter == gr.counter) {//avoids self-loop. Thanks god I have integer mapping here.
                continue;
            }
            Float c = check_conditions(gr2);

            if (c < action_dist.get(gr2.counter)) {//are conditions all reached?
                action_dist.set(gr2.counter, c);
                if (action_to_fib_node.get(gr2.counter) == null) {
                    FibonacciHeapNode n = new FibonacciHeapNode(gr2);
                    a_plus.insert(n, c);//push in the set of actions to consider. 
                    action_to_fib_node.set(gr2.counter, n);
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
        if (relaxed_plan_extraction) {
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
        relaxed_plan_actions = new LinkedList();
        achiever_set s = this.action_achievers.get(goal.counter);
        getHelpfulActions(list,s);
        while (!list.isEmpty()) {
            GroundAction gr2 = list.pollLast();
//            System.out.println(gr);
            s = this.action_achievers.get(gr2.counter);
            getHelpfulActions(list,s);
        }
        this.dbg_print("HelpfulActions: "+relaxed_plan_actions.toString() + "\n");
    }

    private void compute_relaxed_plan() {

        LinkedList<GroundAction> list = new LinkedList();
        relaxed_plan_actions = new LinkedList();
        achiever_set s = this.action_achievers.get(goal.counter);
        if (s != null) {
            for (Object o : s.actions) {
                LinkedList level = new LinkedList();
                if (o != null) {
                    list.addFirst((GroundAction) o);
                    relaxed_plan_actions.add((GroundAction) o);
                }
//                rp.addFirst(level);
            }
        }
        while (!list.isEmpty()) {
            GroundAction gr = list.pollLast();
//            System.out.println(gr);
            s = this.action_achievers.get(gr.counter);
            if (s != null) {
                LinkedList level = new LinkedList();
                for (Object o : s.actions) {
                    if (o != null) {
                        list.addFirst((GroundAction) o);
                        relaxed_plan_actions.add((GroundAction) o);
                    }
                }
//                rp.addFirst(level);
            }
        }
        this.dbg_print("Relaxed Plan: "+relaxed_plan_actions.toString() + "\n");
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
            if (only_helpful_actions) {
                this.compute_helpful_actions();
            } else {
                compute_relaxed_plan();
            }
        }
    }

    private void getHelpfulActions(LinkedList<GroundAction>list,achiever_set s) {
       if (s != null) {
            for (Conditions o : s.target_cond) {
                if (o != null) {
                    if (this.all_achievers.get(o.getCounter())!=null){
                        for (GroundAction gr : this.all_achievers.get(o.getCounter())) {
                            if (this.action_dist.get(gr.counter) == 0) {
                                this.relaxed_plan_actions.add(gr);
                            }   
                        }
                    }
                }
            }
            for (GroundAction gr : s.actions){
                if (gr!=null){
                    list.addFirst(gr);
                }
            }
        }
    }

}

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
 */
/**
 * *******************************************************************
 * Description: Part of the PPMaJaL library
 *
 * Author: Enrico Scala 2013 Contact: enricos83@gmail.com
 *
 ********************************************************************
 */
package heuristics.advanced;

import conditions.Comparison;
import conditions.Conditions;
import conditions.Predicate;
import heuristics.Heuristic;
import static java.lang.Float.MAX_VALUE;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collection;
import static java.util.Collections.nCopies;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import static java.util.logging.Level.SEVERE;
import org.jgrapht.util.FibonacciHeap;
import org.jgrapht.util.FibonacciHeapNode;
import problem.GroundAction;
import problem.State;
import static java.util.logging.Logger.getLogger;
import static java.util.logging.Logger.getLogger;
import static java.util.logging.Logger.getLogger;
import static java.util.logging.Logger.getLogger;
import static java.util.logging.Logger.getLogger;
import static java.util.logging.Logger.getLogger;
import static java.util.logging.Logger.getLogger;
import static java.util.logging.Logger.getLogger;

/**
 *
 * @author enrico
 */
public class Uniform_cost_search_HM extends Heuristic {

    protected HashMap<Integer, LinkedHashSet<Predicate>> achieve;
    protected HashMap<Integer, LinkedHashSet<GroundAction>> achievers_inverted;
    protected HashMap<Integer, LinkedHashSet<Conditions>> interact_with;
    protected HashMap<Integer, LinkedHashSet<Comparison>> possible_achievers;
    protected HashMap<Integer, LinkedHashSet<GroundAction>> possible_achievers_inverted;
    protected HashMap<Integer, LinkedHashSet<GroundAction>> precondition_mapping;
    private boolean reacheability_setting;
    private boolean all_paths = false;
    protected ArrayList<Integer> dist;
    private lp_interface lp_interface;
    public boolean cplex = false;

    public Uniform_cost_search_HM(Conditions G, Set<GroundAction> A) {
        super(G, A);
    }

    /**
     *
     * @param goals
     * @param actions
     * @param processesSet
     */
    public Uniform_cost_search_HM(Conditions G, Set A, Set processesSet) {
        super(G, A, processesSet);
        lp_interface = new lp_interface();
        lp_interface.additive_h = this.additive_h;

    }

    public Uniform_cost_search_HM(Conditions G, Set<GroundAction> A, Set processesSet, Conditions GC) {
        super(G, A, processesSet, GC);
        lp_interface = new lp_interface();
    }

    @Override
    public Float setup(State s) {
        try {
            //this.add_redundant_constraints();
        } catch (Exception ex) {
            getLogger(Uniform_cost_search_HM.class.getName()).log(SEVERE, null, ex);
        }
        this.cond_action = new HashMap();
        build_integer_representation();
        //identify_complex_conditions(all_conditions, A);
        generate_achievers();
        lp_interface.additive_h = this.additive_h;

        lp_interface.initialize(A, s, all_conditions, gC);
        reacheability_setting = true;
        this.dbg_print("Reachability Analysis Started");
        Float ret = compute_estimate(s);
        this.dbg_print("Reachability Analysis Terminated");
        reacheability_setting = false;
        sat_test_within_cost = false; //don't need to recheck precondition sat for each state. It is done in the beginning for every possible condition
        out.println("Hard Conditions: " + this.hard_conditions);
        out.println("Simple Conditions: " + (this.all_conditions.size() - this.hard_conditions));
        return ret;
    }

    @Override
    public void build_integer_representation() {
        int counter2 = 0;

        int counter_actions = 0;
        ArrayList<GroundAction> actions_to_consider = new ArrayList(A);
        for (GroundAction a : actions_to_consider) {
            a.counter = counter_actions++;
            
            if (a.getPreconditions() != null) {
                if (a.getPreconditions() != null && a.getPreconditions().sons != null) {
                    a.getPreconditions().setCounter(counter2++);
                    all_conditions.add(a.getPreconditions());
                    this.cond_action.put(a.getPreconditions().getCounter(), a);

                }
            }
        }

        G.setCounter(counter2++);
        all_conditions.add(G);
        this.gC.setCounter(counter2);
        //System.out.println(conditions);;

    }

    @Override
    public Float compute_estimate(State s) {
        //PriorityQueue<ConditionsNode> q = new PriorityQueue();
        if (s.satisfy(G)) {
            return 0f;
        }
        FibonacciHeap<Conditions> q = new FibonacciHeap();
        lp_interface.update_all_conditions(s, all_conditions);
        
        relaxed_plan_actions = new LinkedHashSet();
        //setting up the initial values
        ArrayList<Boolean> closed = new ArrayList<>(nCopies(all_conditions.size() + 1, false));
        ArrayList<Float> distance = new ArrayList<>(nCopies(all_conditions.size() + 1, MAX_VALUE));
        ArrayList<Boolean> open_list = new ArrayList<>(nCopies(all_conditions.size() + 1, false));
        HashMap<Integer, FibonacciHeapNode> cond_to_entry = new HashMap();
        for (Conditions c : all_conditions) {
            if (s.satisfy(c)) {
                FibonacciHeapNode node = new FibonacciHeapNode(c);
                q.insert(node, 0);
                cond_to_entry.put(c.getCounter(), node);
                distance.set(c.getCounter(), 0f);
                open_list.set(c.getCounter(), true);
                closed.set(c.getCounter(), true);
            }
        }
        reacheable_conditions = 0;
        final_achiever = new HashMap();

        ArrayList<Boolean> active_actions = new ArrayList<>(nCopies(A.size() + 1, false));
//        for (GroundAction gr: temp_a){
//            if (gr.isApplicable(s))
//                //active_actions.add(gr);
//        }
        Collection<Conditions> temp_conditions = null;
//        System.out.println(all_conditions.size());
        while (!q.isEmpty()) {
            //if (!first) {
//            System.out.println(++iteration);
            Float first = null;
            temp_conditions = new LinkedHashSet();
//            System.out.println("New Iteration");
            while (!q.isEmpty()) {//take all the elements with equal distance from the initial state

                if (this.greedy && !this.reacheability_setting) {
                    if (distance.get(G.getCounter()) != Float.MAX_VALUE) {
                        return distance.get(G.getCounter());
                    }
                }

                Conditions cn = q.removeMin().getData();
                if (distance.get(cn.getCounter()) == Float.MAX_VALUE) {
                    System.out.println("Anomaly!!!");//This shouldn't happen as only reachable conditions are put in the list
                    break;
                }
                if (first == null) {
                    first = distance.get(cn.getCounter());
                } else if (first < distance.get(cn.getCounter())) {//put back and stop
                    distance.set(cn.getCounter(), distance.get(cn.getCounter()));
                    open_list.set(cn.getCounter(), true);
                    FibonacciHeapNode node = new FibonacciHeapNode(cn);
                    q.insert(node, distance.get(cn.getCounter()));
                    cond_to_entry.put(cn.getCounter(), node);
                    first = null;
                    break;//exot from this inner loop and compute cost for new conditons that can be achieved
                    //looking at the active actions activated by this step.
                }

                closed.set(cn.getCounter(), true);//this is the best cost so far; no need to reopen this fact again

                if (cn.getCounter() == G.getCounter() && !this.reacheability_setting) {
                    if (distance.get(cn.getCounter()) == Float.MAX_VALUE) {
                        System.out.println("Anomaly");

                    }
                    return Math.max(distance.get(cn.getCounter()), 1f);
                }
                GroundAction gr = this.cond_action.get(cn.getCounter());
                if (gr != null) {
                    active_actions.set(gr.counter, Boolean.TRUE);
                    if (this.reacheability_setting) {
                        this.reachable.add(gr);
                    }
                    temp_conditions.addAll(interact_with.get(gr.counter));

                }

            }

            for (Conditions cond : temp_conditions) {
                if (!closed.get(cond.getCounter())) {
                    Float current_cost = null;
                    if (cplex) {
                        //current_cost = lp_interface.compute_current_cost_via_lp_cplex(active_actions, s, cond, distance,this.gC);
                    } else {
                        current_cost = lp_interface.update_cost(s,active_actions, cond, distance);
                    }
                    n_lp_invocations = lp_interface.n_invocations;
                    if (current_cost != Float.MAX_VALUE) {
                        update_cost_if_necessary(open_list, distance, cond, q, cond_to_entry, current_cost);
                    }
                }

            }
        }

        //System.out.println("Current Estimate to the goal:"+this.compute_float_cost(s, G, dist));
//        System.out.println(distance.get(G.getCounter()));
//        System.exit(-1);
//        if (distance.get(G.getCounter())==Float.MAX_VALUE){
////            System.out.println("Dead-End in:"+s.pddlPrint());
//        }
        return Math.max(distance.get(G.getCounter()), 1f);
    }

    private void generate_achievers() {
        interact_with = new HashMap();
        //this should also include the indirect dependencies, otherwise does not work!!
        for (GroundAction gr : this.A) {
            interact_with.put(gr.counter, new LinkedHashSet());
            for (Conditions c : this.all_conditions) {
                if (gr.getPreconditions().getCounter() != c.getCounter()) {
                    if (c.is_affected_by(gr)) {
                        interact_with.get(gr.counter).add(c);

                    }
                }

            }
        }
    }

    private void update_cost_if_necessary(ArrayList<Boolean> open_list, ArrayList<Float> dist, Conditions p, FibonacciHeap<Conditions> q, HashMap<Integer, FibonacciHeapNode> cond_to_entry, Float current_cost) {
        if (current_cost == Float.MAX_VALUE) {
            return;
        }
        if (open_list.get(p.getCounter())) {
            if (dist.get(p.getCounter()) > current_cost) {
                q.decreaseKey(cond_to_entry.get(p.getCounter()), current_cost);
                dist.set(p.getCounter(), current_cost);
            }
        } else {
            dist.set(p.getCounter(), current_cost);
            open_list.set(p.getCounter(), true);
            FibonacciHeapNode node = new FibonacciHeapNode(p);
            q.insert(node, current_cost);
            cond_to_entry.put(p.getCounter(), node);
            reacheable_conditions++;
        }
    }

}

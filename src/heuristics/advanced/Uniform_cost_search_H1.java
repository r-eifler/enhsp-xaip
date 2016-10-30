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
import expressions.NumEffect;
import heuristics.Heuristic;
import static java.lang.Float.MAX_VALUE;
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
public class Uniform_cost_search_H1 extends Heuristic {

    protected HashMap<Integer, LinkedHashSet<Predicate>> achieve;
    protected HashMap<Integer, LinkedHashSet<GroundAction>> achievers_inverted;
    protected HashMap<Integer, LinkedHashSet<Comparison>> interact_with;
    protected HashMap<Integer, LinkedHashSet<Comparison>> possible_achievers;
    protected HashMap<Integer, LinkedHashSet<GroundAction>> possible_achievers_inverted;
    protected HashMap<Integer, LinkedHashSet<GroundAction>> precondition_mapping;
    private boolean reacheability_setting;
    private boolean all_paths = false;
    protected ArrayList<Integer> dist;

    public Uniform_cost_search_H1(Conditions G, Set<GroundAction> A) {
        super(G, A);
    }

    /**
     *
     * @param goals
     * @param actions
     * @param processesSet
     */
    public Uniform_cost_search_H1(Conditions G, Set A, Set processesSet) {
        super(G, A, processesSet);
    }

    @Override
    public Float setup(State s) {

        
        build_integer_representation();
        identify_complex_conditions(all_conditions, A);
        generate_achievers();
        reacheability_setting = true;
        this.dbg_print("Reachability Analysis Started");
        Float ret = compute_estimate(s);
        this.dbg_print("Reachability Analysis Terminated");
        reacheability_setting = false;
        sat_test_within_cost = false; //don't need to recheck precondition sat for each state. It is done in the beginning for every possible condition
        out.println("Hard Conditions: " + this.complex_conditions);
        out.println("Simple Conditions: " + (this.all_conditions.size() - this.complex_conditions));
        return ret;
    }

    @Override
    public Float compute_estimate(State s) {
        //PriorityQueue<ConditionsNode> q = new PriorityQueue();
        FibonacciHeap<Conditions> q = new FibonacciHeap();

        relaxed_plan_actions = new LinkedHashSet();
        //setting up the initial values
        ArrayList<Boolean> closed = new ArrayList<>(nCopies(all_conditions.size() + 1, false));
        ArrayList<Float> dist = new ArrayList<>(nCopies(all_conditions.size() + 1, MAX_VALUE));
        ArrayList<Boolean> open_list = new ArrayList<>(nCopies(all_conditions.size() + 1, false));
        HashMap<Integer, FibonacciHeapNode> cond_to_entry = new HashMap();
        for (Conditions c : all_conditions) {
            if (s.satisfy(c)) {
                FibonacciHeapNode node = new FibonacciHeapNode(c);
                q.insert(node, 0);
                cond_to_entry.put(c.getCounter(), node);
                dist.set(c.getCounter(), 0f);
                open_list.set(c.getCounter(), true);
                closed.set(c.getCounter(), true);
            }
        }
        reacheable_conditions = 0;
        LinkedHashSet<GroundAction> temp_a;
        if (reacheability_setting) {
            temp_a = new LinkedHashSet(A);
        } else {
            temp_a = new LinkedHashSet(this.reachable);
        }
        final_achiever = new HashMap();

        HashMap<GroundAction, Float> action_to_cost = new HashMap();
        ArrayList<GroundAction> actions_for_complex_condition = new ArrayList();
        boolean first = true;
        Integer iteration=0;
        while (!q.isEmpty() || first) {
            if (!first) {
                Conditions cn = q.removeMin().getData();
                closed.set(cn.getCounter(), true);
            }
            if (!all_paths) {
                Float goal_dist = this.check_goal_conditions(s, G, dist, closed);
                if (goal_dist != MAX_VALUE && !reacheability_setting) {
                    return goal_dist;
                }
            }

            this.dbg_print("Round"+iteration++);
            //trigger actions
//            Iterator<GroundAction> it = this.precondition_mapping.get(cn.getCounter()).iterator();
            first = false;
            Iterator<GroundAction> it = temp_a.iterator();

//            System.out.println("DEBUG: Actions investigated:"+this.precondition_mapping.get(cn.getCounter())+"\n starting from:"+cn);
            while (it.hasNext()) {//this can be made more efficient, of course, keeping track of the relantioship between
                //the condition just extracted and the action depending on it
                GroundAction gr = it.next();
                Float action_precondition_cost = this.compute_precondition_cost(s, dist, gr, closed);
                
                if (action_precondition_cost != MAX_VALUE) {
                    if (reacheability_setting) {
                        this.reachable.add(gr);
                        gr.setAction_cost(s);
                    }
                    action_to_cost.put(gr, action_precondition_cost);
                    //if (!gr.has_state_dependent_effects())
                    it.remove();//this can be removed since we are already looking for the closest/cheapest preconditions set
                    actions_for_complex_condition.add(gr);

                    //for (GroundAction gr : edges) {//this can be optimized a lot
                    Collection<Predicate> predicates = this.achieve.get(gr.counter);
                    Collection<Comparison> comparisons = this.possible_achievers.get(gr.counter);
                    for (Predicate p : predicates) {
                        if (closed.get(p.getCounter())) {
                            continue;
                        }
                        Float current_cost = action_to_cost.get(gr) + gr.getAction_cost();
                        update_cost_if_necessary(open_list, dist, (Conditions) p, q, cond_to_entry, current_cost);

                    }
                    for (Comparison comp : comparisons) {
                        if (closed.get(comp.getCounter())) {
                            continue;
                        }
                        if (!this.is_complex.get(comp)) {
                            Float number_of_execution = null;
                            boolean super_simple_numeric_condition = (this.possible_achievers_inverted.get(comp.getCounter()).size()<=1);
                            if ((this.additive_h && integer_actions) || super_simple_numeric_condition)
                                number_of_execution = gr.getNumberOfExecutionInt(s, comp);
                            else
                                number_of_execution = gr.getNumberOfExecution(s, comp);
                            if (number_of_execution == Float.MAX_VALUE) {
                                continue;
                            }
                            Float action_cost = action_to_cost.get(gr);
                            if (!this.additive_h) {
                                Collection<GroundAction> all_achiever = this.possible_achievers_inverted.get(comp.getCounter());
                                //System.out.println(comp);
                                //System.out.println(all_achiever.size());
                                Float minimum = action_cost;
                                for (GroundAction ach : all_achiever) {
                                    if (action_to_cost.get(ach) != null) {
                                        Float ach_cost = action_to_cost.get(ach);
                                        if (ach_cost < minimum) {
                                            minimum = ach_cost;
                                        }
                                    }
                                }
                                action_cost = minimum;
                            }
                            //action_cost = 0;

                            Float current_cost = action_cost + number_of_execution * gr.getAction_cost();
//                        System.out.println(current_cost);
                            update_cost_if_necessary(open_list, dist, comp, q, cond_to_entry, current_cost);

                        } else {
                            this.dbg_print("interval based relaxation starting\n");
                            try {
                                Float current_cost = this.interval_based_relaxation_actions_with_cost(s, comp, actions_for_complex_condition, action_to_cost);
                                update_cost_if_necessary(open_list, dist, comp, q, cond_to_entry, current_cost);
                            } catch (CloneNotSupportedException ex) {
                                getLogger(Uniform_cost_search_H1.class.getName()).log(SEVERE, null, ex);
                            } 
//                            catch (IOException ex) {
//                                Logger.getLogger(Uniform_cost_search_H1.class.getName()).log(Level.SEVERE, null, ex);
//                            }
                            this.dbg_print("interval based relaxation finished\n");


                        }
                    }
                }
            }

        }

        //System.out.println("Current Estimate to the goal:"+this.compute_float_cost(s, G, dist));
        return this.check_goal_conditions(s, G, dist, closed);
    }

    private void generate_achievers() {
        interact_with = new HashMap();
        achieve = new HashMap();
        possible_achievers = new HashMap();
        this.possible_achievers_inverted = new HashMap();
        achievers_inverted = new HashMap();
        precondition_mapping = new HashMap();

        //this should also include the indirect dependencies, otherwise does not work!!
        for (GroundAction gr : this.A) {
            LinkedHashSet<Comparison> comparisons = new LinkedHashSet();
            LinkedHashSet<Comparison> reacheable_comparisons = new LinkedHashSet();
            LinkedHashSet<Predicate> predicates = new LinkedHashSet();
            for (Conditions c : this.all_conditions) {
                if (precondition_mapping.get(c.getCounter()) == null) {
                    precondition_mapping.put(c.getCounter(), new LinkedHashSet());
                }
                LinkedHashSet<GroundAction> action_list = new LinkedHashSet();
                if (c instanceof Comparison) {
                    Comparison comp = (Comparison) c;
                    if (comp.involve(gr.getNumericFluentAffected())) {
                        comparisons.add(comp);
                        if (gr.is_possible_achiever_of(comp)) {
                            reacheable_comparisons.add(comp);
                            action_list.add(gr);
                        }
                        if (this.is_complex.get(comp)) {
                            reacheable_comparisons.add(comp);
                        }
                    }
                    if (this.possible_achievers_inverted.get(comp.getCounter()) == null) {
                        this.possible_achievers_inverted.put(comp.getCounter(), action_list);
                    } else {
                        LinkedHashSet<GroundAction> temp = this.possible_achievers_inverted.get(comp.getCounter());
                        temp.addAll(action_list);
                        this.possible_achievers_inverted.put(comp.getCounter(), temp);
                    }
                } else if (c instanceof Predicate) {
                    Predicate p = (Predicate) c;
                    if (gr.achieve(p)) {
                        predicates.add(p);
                    }
                    if (this.achievers_inverted.get(p.getCounter()) == null) {
                        this.achievers_inverted.put(p.getCounter(), action_list);
                    } else {
                        LinkedHashSet<GroundAction> temp = this.achievers_inverted.get(p.getCounter());
                        temp.addAll(action_list);
                        this.achievers_inverted.put(p.getCounter(), temp);
                    }

                }
                if (gr.preconditioned_on(c)) {//build mapping from atoms to actions
//                    System.out.println("Gr:"+ gr);
//                    try {
//                        System.in.read();
//                    } catch (IOException ex) {
//                        Logger.getLogger(Uniform_cost_search_H1.class.getName()).log(Level.SEVERE, null, ex);
//                    }

                    LinkedHashSet<GroundAction> temp = this.precondition_mapping.get(c.getCounter());
                    temp.add(gr);
                    this.precondition_mapping.put(c.getCounter(), temp);

                }

            }
            achieve.put(gr.counter, predicates);
            interact_with.put(gr.counter, comparisons);
            possible_achievers.put(gr.counter, reacheable_comparisons);
        }
        
        this.dbg_print("Identify complex achievers");

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
                if ((!per_mark.get(a)) && (comp.getLeft().involve(a.getFluentAffected())))
                    visit(a, num_effects, temp_mark, per_mark, sorted_nodes);
            }
            for (GroundAction gr : A) {
                for (NumEffect neff : gr.getNumericEffectsAsCollection()) {
                    if (sorted_nodes.contains(neff)) {
                        possible_achievers.get(gr.counter).add(comp);
                    }

                }
            }

        }
        this.dbg_print("Complex achievers identified");

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

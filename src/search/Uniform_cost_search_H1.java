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
package search;

import conditions.Comparison;
import conditions.Conditions;
import conditions.Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jgrapht.util.FibonacciHeap;
import org.jgrapht.util.FibonacciHeapNode;
import problem.GroundAction;
import problem.State;
import search.HomeMadeFibonacciHeap.Entry;

/**
 *
 * @author enrico
 */
public class Uniform_cost_search_H1 extends Bellman_Ford_H1 {

    protected HashMap<GroundAction, LinkedHashSet<Predicate>> achieve;
    protected HashMap<GroundAction, LinkedHashSet<Comparison>> interact_with;
    protected HashMap<GroundAction, LinkedHashSet<Comparison>> possible_achievers;
    protected HashMap<Comparison, LinkedHashSet<GroundAction>> possible_achievers_inverted;
    private boolean reacheability_setting;

    public Uniform_cost_search_H1(Conditions G, Set<GroundAction> A) {
        super(G, A);
    }

    @Override
    public int setup(State s) {
        try {
            //this.add_redundant_constraints();
        } catch (Exception ex) {
            Logger.getLogger(Uniform_cost_search_H1.class.getName()).log(Level.SEVERE, null, ex);
        }
        build_integer_representation();
        identify_complex_conditions(all_conditions, A);
        generate_achievers();
        reacheability_setting = true;
        int ret = compute_estimate(s);
        reacheability_setting = false;
        sat_test_within_cost = false; //don't need to recheck precondition sat for each state. It is done in the beginning for every possible condition
        return ret;
    }

    @Override
    public int compute_estimate(State s) {
        //PriorityQueue<ConditionsNode> q = new PriorityQueue();
        FibonacciHeap<Conditions> q = new FibonacciHeap();
 
        ArrayList<Boolean> closed = new ArrayList<Boolean>(Collections.nCopies(all_conditions.size() + 1, false));
        ArrayList<Integer> dist = new ArrayList<Integer>(Collections.nCopies(all_conditions.size() + 1, Integer.MAX_VALUE));
        ArrayList<Boolean> open_list = new ArrayList<Boolean>(Collections.nCopies(all_conditions.size() + 1, false));
        HashMap<Integer,FibonacciHeapNode> cond_to_entry = new HashMap();
        for (Conditions c : all_conditions) {
            if (s.satisfy(c)) {
                FibonacciHeapNode node = new FibonacciHeapNode(c);
                q.insert(node, 0);
                cond_to_entry.put(c.getCounter(), node);
                dist.set(c.getCounter(), 0);
                open_list.set(c.getCounter(), true);
                closed.set(c.getCounter(),true);
             }
        }
        LinkedHashSet<GroundAction> temp_a;
        if (reacheability_setting) {
            temp_a = new LinkedHashSet(A);
        } else {
            temp_a = new LinkedHashSet(this.reachable);
        }

        Collection<GroundAction> achievers_of_complex_conditions = new LinkedHashSet();
        HashMap<GroundAction, Integer> action_to_cost = new HashMap();
        Collection<Comparison> temp_complex_conditions = new LinkedHashSet();
        while (!q.isEmpty()) {
            Conditions cn = q.removeMin().getData();

            int goal_dist = this.check_goal_conditions(s, G, dist);
            if (goal_dist != Integer.MAX_VALUE && !reacheability_setting) {
                return (int) goal_dist;
            }
            //trigger actions
            Iterator<GroundAction> it = temp_a.iterator();
            LinkedHashSet<GroundAction> edges = new LinkedHashSet();
            while (it.hasNext()) {
                GroundAction gr = it.next();
                int action_cost = this.compute_precondition_cost(s, dist, gr);
                if (action_cost != Integer.MAX_VALUE) {
                    edges.add(gr);
                    if (reacheability_setting) {
                        this.reachable.add(gr);
                    }
                    action_to_cost.put(gr, action_cost);
                    it.remove();
                }
            }
            //update_reacheable_conditions

            for (GroundAction gr : edges) {
                Collection<Predicate> predicates = this.achieve.get(gr);
                Collection<Comparison> comparisons = this.possible_achievers.get(gr);
                for (Predicate p : predicates) {
                    int current_cost = action_to_cost.get(gr) + 1;
                    if (closed.get(p.getCounter()))  {
                        continue;
                    }
                    
                    if (open_list.get(p.getCounter())) {
                        if (dist.get(p.getCounter()) > current_cost) {
                            q.decreaseKey(cond_to_entry.get(p.getCounter()), current_cost);
                            dist.set(p.getCounter(), current_cost);
                        }
                    } else {
                        dist.set(p.getCounter(), current_cost);
                        open_list.set(p.getCounter(),true);
                        FibonacciHeapNode node = new FibonacciHeapNode(p);
                        q.insert(node, current_cost);
                        cond_to_entry.put(p.getCounter(), node);
                        
                    }
                }
                for (Comparison comp : comparisons) {
                    if (closed.get(comp.getCounter())) {
                        continue;
                    }
                    if (!this.is_complex.get(comp)) {
                        int number_of_execution = gr.getNumberOfExecution(s, comp);
                        int action_cost = action_to_cost.get(gr);
                        if (!this.additive_h){
                            Collection<GroundAction> all_achiever = this.possible_achievers_inverted.get(comp);
                            //System.out.println(comp);
                            //System.out.println(all_achiever.size());
                            int minimum = action_cost;
                            for (GroundAction ach: all_achiever){ 
                               if (action_to_cost.get(ach)!=null){
                                   int ach_cost = action_to_cost.get(ach);
                                   if (ach_cost<minimum){
                                       minimum = ach_cost;
                                   }
                               }
                            }
                            action_cost=minimum;
                        }
                        //action_cost = 0;
                        
                        int current_cost = action_cost + number_of_execution;
                        if (open_list.get(comp.getCounter())) {
                            if (dist.get(comp.getCounter()) > current_cost) {
                                q.decreaseKey(cond_to_entry.get(comp.getCounter()), current_cost);
                                dist.set(comp.getCounter(), current_cost);
                            }
                        } else {
                            dist.set(comp.getCounter(), current_cost);
                            open_list.set(comp.getCounter(),true);
                            FibonacciHeapNode node = new FibonacciHeapNode(comp);
                            q.insert(node, current_cost);
                            cond_to_entry.put(comp.getCounter(),node);
                        }
                    } else {
                        temp_complex_conditions.add(comp);
                        achievers_of_complex_conditions.add(gr);
                    }
                }
            }

            Iterator<Comparison> it2 = temp_complex_conditions.iterator();
            while (it2.hasNext()) {
                Comparison comp = it2.next();
                if (closed.get(comp.getCounter())) {
                    it2.remove();
                    continue;
                }
                int current_cost = this.interval_based_relaxation_actions_with_cost(s, comp, achievers_of_complex_conditions, action_to_cost);
                if (current_cost != Integer.MAX_VALUE) {
                    if (open_list.get(comp.getCounter())) {
                        if (dist.get(comp.getCounter()) > current_cost) {

                            q.decreaseKey(cond_to_entry.get(comp.getCounter()), current_cost);
                            dist.set(comp.getCounter(), current_cost);
                        }
                    } else {
                            dist.set(comp.getCounter(), current_cost);
                            open_list.set(comp.getCounter(),true);
                            FibonacciHeapNode node = new FibonacciHeapNode(comp);
                            q.insert(node, current_cost);
                            cond_to_entry.put(comp.getCounter(),node);
                    }
                }
            }

            closed.set(cn.getCounter(), true);

        }

        //System.out.println("Current Estimate to the goal:"+this.compute_float_cost(s, G, dist));
        return this.check_goal_conditions(s, G, dist);
    }

    private void generate_achievers() {
        interact_with = new HashMap();
        achieve = new HashMap();
        possible_achievers = new HashMap();
        this.possible_achievers_inverted = new HashMap();
        
        for (GroundAction gr : this.A) {
            LinkedHashSet<Comparison> comparisons = new LinkedHashSet();
            LinkedHashSet<Comparison> reacheable_comparisons = new LinkedHashSet();
            LinkedHashSet<Predicate> predicates = new LinkedHashSet();
            for (Conditions c : this.all_conditions) {
                LinkedHashSet<GroundAction> achievable_via = new LinkedHashSet();
                if (c instanceof Comparison) {
                    Comparison comp = (Comparison) c;
                    if (comp.involve(gr.getNumericFluentAffected())) {
                        comparisons.add(comp);
                        if (gr.is_possible_achiever_of(comp)) {
                            reacheable_comparisons.add(comp);
                            achievable_via.add(gr);
                        }
                        if (this.is_complex.get(comp)) {
                            reacheable_comparisons.add(comp);
                        }
                    }
                    if (this.possible_achievers_inverted.get(comp)==null){
                        this.possible_achievers_inverted.put(comp, achievable_via);
                    }else{
                        LinkedHashSet<GroundAction> temp= this.possible_achievers_inverted.get(comp);
                        temp.addAll(achievable_via);
                        this.possible_achievers_inverted.put(comp, temp);
                    }
                } else if (c instanceof Predicate) {
                    Predicate p = (Predicate) c;
                    if (gr.achieve(p)) {
                        predicates.add(p);
                    }

                }

            }
            achieve.put(gr, predicates);
            interact_with.put(gr, comparisons);
            possible_achievers.put(gr, reacheable_comparisons);
        }
    }

    private boolean delete_if_worse_present(PriorityQueue<ConditionsNode> q, Conditions con, float current_cost) {
        Iterator<ConditionsNode> it = q.iterator();
        while (it.hasNext()) {
            ConditionsNode c = (ConditionsNode) it.next();
            if (c.c.equals(con)) {
                if (c.cost < current_cost) {
                    return false;
                } else {
                    it.remove();
                    return true;
                }
            }
        }
        return true;
    }

    private static class ConditionsNode implements Comparable {

        Conditions c;
        int cost;

        public ConditionsNode(Conditions c1, int cost1) {
            c = c1;
            cost = cost1;
        }

        @Override
        public int compareTo(Object o) {
            ConditionsNode to_compare_with = (ConditionsNode) o;
            return (this.cost < to_compare_with.cost ? -1 : this.cost == to_compare_with.cost ? 0 : 1);
        }
    }

}

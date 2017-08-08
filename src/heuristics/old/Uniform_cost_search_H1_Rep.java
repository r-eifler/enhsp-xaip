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
package heuristics.old;

import conditions.Comparison;
import conditions.Conditions;
import conditions.Predicate;
import expressions.BinaryOp;
import expressions.PDDLNumber;
import extraUtils.Pair;
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

/**
 *
 * @author enrico
 */
public class Uniform_cost_search_H1_Rep extends Uniform_cost_search_H1 {

    protected HashMap<GroundAction, LinkedHashSet<Predicate>> achieve;
    protected HashMap<GroundAction, LinkedHashSet<Comparison>> interact_with;
    protected HashMap<GroundAction, LinkedHashSet<Comparison>> possible_achievers;
    protected boolean reacheability_setting;
    protected HashMap<GroundAction, Boolean> limited_rep_action;
    protected HashMap<GroundAction, LinkedHashSet<Comparison>> temporary_achievers;
    private boolean super_greedy = false;

    public Uniform_cost_search_H1_Rep(Conditions G, Set<GroundAction> A) {
        super(G, A);
    }

    @Override
    public Float setup(State s) {
        try {
            //this.add_redundant_constraints();
        } catch (Exception ex) {
            Logger.getLogger(Uniform_cost_search_H1_Rep.class.getName()).log(Level.SEVERE, null, ex);
        }
        build_integer_representation();
        identify_complex_conditions(A);
        generate_self_precondition_delete_sets();
        generate_achievers();
        reacheability_setting = true;
        Float ret = compute_estimate(s);
        reacheability_setting = false;
        //limited_rep_action = new HashMap();
        return ret;
    }

    private void generate_repetition_constraints(State s_0, Collection<GroundAction> A1, Collection<Conditions> conditions_set) {

        rep_costs = new HashMap();
        limited_rep_action = new HashMap();
        LinkedHashSet<Conditions> new_conditions_set = new LinkedHashSet();
        for (GroundAction gr : A1) {
            limited_rep_action.put(gr, false);
            LinkedHashSet pairs_to_add = new LinkedHashSet();
            if (gr.getPreconditions() == null || gr.getPreconditions().sons.isEmpty()) {
                continue;
            }
            for (Conditions c : (Collection<Conditions>) gr.getPreconditions().sons) {

                if (c instanceof Comparison) {
                    //System.out.println("redundant_constraints:"+redundant_constraints);
                    Comparison comp = (Comparison) c;

                    if (is_complex.get(c.getCounter())) {
                        continue;
                    }
                    float b = comp.eval_affected(s_0, gr);
                    float a = comp.eval_not_affected(s_0, gr);
                    Integer u_b;
                    if (b < 0) {//action has negative effects on its precondition
                        limited_rep_action.put(gr, true);
                        float float_temp = -a / b;
//                        if (float_temp < 0)
//                            u_b = (int)Math.floor(-a / b);
//                        else
                        if (float_temp < 0) {
                            u_b = (int) Math.floor(-a / b);
                        } else {
                            u_b = (int) Math.ceil(-a / b);
                        }

                        if ((comp.getComparator().equals("<") || comp.getComparator().equals(">"))) {
                            if (u_b == float_temp) {
                                u_b--;
                            }
                            //a-=0.001;
                        }

                        //u_b = Math.max(0, u_b);
                        Pair<Comparison, Comparison> comparisons = new Pair();
                        {
                            Comparison new_comp = new Comparison(comp.getComparator() + "=");
                            BinaryOp op = new BinaryOp(comp.getLeft().clone(), "+", new PDDLNumber(b - a), true);
                            new_comp.setLeft(op);
                            new_comp.setRight(new PDDLNumber(0));
                            new_comp.normalize();

                            new_comp.setCounter(conditions_set.size() + 1);
                            new_condition.put(new_comp, true);
                            this.is_complex.set(new_comp.getCounter(), false);
                            //this.index_of_last_static_atom++;s
                            if (!conditions_set.add(new_comp)) {
                                for (Conditions c3 : conditions_set) {
                                    if (c3 instanceof Comparison) {
                                        Comparison temp = (Comparison) c3;
                                        if (temp.equals(new_comp)) {
                                            new_comp.setCounter(temp.getCounter());
                                        } else {

                                        }
                                    }
                                }
                            } else {
                                new_conditions_set.add(new_comp);
                                //this.num_achiever.put(new Pair(gr,new_comp), false);

                            }

                            comparisons.setFirst(new_comp);
                        }

                        Pair<Pair<Comparison, Comparison>, Integer> to_add = new Pair(comparisons, u_b);
                        pairs_to_add.add(to_add);

                    }
                }
            }
            rep_costs.put(gr, pairs_to_add);
        }
        if (this.reacheability_setting) {
            this.update_achievers(new_conditions_set, A);
        } else {
            this.update_achievers(new_conditions_set, this.reachable);
        }
    }

    @Override
    public Float compute_estimate(State s) {
        FibonacciHeap<Conditions> q = new FibonacciHeap();

        LinkedHashSet<GroundAction> temp_a;
        if (reacheability_setting) {
            temp_a = new LinkedHashSet(A);
        } else {
            temp_a = new LinkedHashSet(this.reachable);
        }

        Collection<Conditions> temp_conditions = new LinkedHashSet(all_conditions);

        this.generate_repetition_constraints(s, temp_a, temp_conditions);

        ArrayList<Boolean> closed = new ArrayList<Boolean>(Collections.nCopies(temp_conditions.size() + 1, false));
        ArrayList<Float> dist = new ArrayList<Float>(Collections.nCopies(temp_conditions.size() + 1, Float.MAX_VALUE));
        ArrayList<Boolean> open_list = new ArrayList<Boolean>(Collections.nCopies(temp_conditions.size() + 1, false));
        HashMap<Integer, FibonacciHeapNode> cond_to_entry = new HashMap();
        for (Conditions c : temp_conditions) {
            if (c.isSatisfied(s)) {
                FibonacciHeapNode node = new FibonacciHeapNode(c);
                q.insert(node, 0);
                cond_to_entry.put(c.getCounter(), node);
                dist.set(c.getCounter(), 0f);
                open_list.set(c.getCounter(), true);
                closed.set(c.getCounter(), true);
            }
        }

        Collection<GroundAction> achievers_of_complex_conditions = new LinkedHashSet();
        HashMap<GroundAction, Float> action_to_cost = new HashMap();
        Collection<Comparison> temp_complex_conditions = new LinkedHashSet();
        while (!q.isEmpty()) {
            Conditions cn = q.removeMin().getData();
            //d/ist.set(cn.c.getCounter(), cn.cost);
            closed.set(cn.getCounter(), true);

            Float goal_dist = this.check_goal_conditions(s, G, dist, closed);
            if (goal_dist != Float.MAX_VALUE && !reacheability_setting) {
                return goal_dist;
            }
            //trigger actions
            Iterator<GroundAction> it = temp_a.iterator();
            LinkedHashSet<GroundAction> edges = new LinkedHashSet();
            while (it.hasNext()) {
                GroundAction gr = it.next();
                Float action_cost = this.compute_precondition_cost(s, dist, gr, closed);
                if (action_cost != Float.MAX_VALUE) {
                    edges.add(gr);
                    if (reacheability_setting) {
                        this.reachable.add(gr);
                    }
                    action_to_cost.put(gr, action_cost);
                    if (!this.limited_rep_action.get(gr)) {
                        it.remove();
                    }
                }
            }
            //update_reacheable_conditions

            for (GroundAction gr : edges) {
                Collection<Predicate> predicates = this.achieve.get(gr);
                Collection<Comparison> comparisons = this.possible_achievers.get(gr);
                for (Predicate p : predicates) {
                    Float current_cost = action_to_cost.get(gr) + 1f;
                    if (closed.get(p.getCounter())) {
                        continue;
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
                    }
                }
                Collection<Comparison> temp = new LinkedHashSet(comparisons);
                temp.addAll(this.temporary_achievers.get(gr));
                for (Comparison comp : temp) {
                    if (closed.get(comp.getCounter()) || dist.get(comp.getCounter()) == 0) {
                        continue;
                    }
                    if (!this.is_complex.get(comp.getCounter())) {
                        boolean applicable = true;
                        Float number_of_execution = gr.getNumberOfExecution(s, comp);
                        Float additional_cost = 0f;
                        if (this.limited_rep_action.get(gr)) {
                            additional_cost = compute_additional_cost(number_of_execution, gr, dist);
                            if (additional_cost == Float.MAX_VALUE) {
                                applicable = false;
                            } else {
                                number_of_execution += additional_cost;
                            }

                        }
                        if (applicable) {
                            Float action_cost = action_to_cost.get(gr);
                            Float current_cost = action_cost + number_of_execution;
                            if (open_list.get(comp.getCounter())) {
                                if (dist.get(comp.getCounter()) > current_cost) {

                                    q.decreaseKey(cond_to_entry.get(comp.getCounter()), current_cost);
                                    dist.set(comp.getCounter(), current_cost);
                                }
                            } else {
                                dist.set(comp.getCounter(), current_cost);
                                open_list.set(comp.getCounter(), true);
                                FibonacciHeapNode node = new FibonacciHeapNode(comp);
                                q.insert(node, current_cost);
                                cond_to_entry.put(comp.getCounter(), node);
                            }
                        }
                    } else {
                        temp_complex_conditions.add(comp);
                        achievers_of_complex_conditions.add(gr);
                    }
                }
            }

            Iterator<Comparison> it2 = temp_complex_conditions.iterator();
            while (it2.hasNext()) {
                try {
                    Comparison comp = it2.next();
                    if (closed.get(comp.getCounter())) {
                        it2.remove();
                        continue;
                    }
                    Float current_cost = this.interval_based_relaxation_actions_with_cost(s, comp, achievers_of_complex_conditions, action_to_cost);
                    if (current_cost != Float.MAX_VALUE) {
                        if (open_list.get(comp.getCounter())) {
                            if (dist.get(comp.getCounter()) > current_cost) {

                                q.decreaseKey(cond_to_entry.get(comp.getCounter()), current_cost);
                                dist.set(comp.getCounter(), current_cost);
                            }
                        } else {
                            dist.set(comp.getCounter(), current_cost);
                            open_list.set(comp.getCounter(), true);
                            FibonacciHeapNode node = new FibonacciHeapNode(comp);
                            q.insert(node, current_cost);
                            cond_to_entry.put(comp.getCounter(), node);
                        }
                    }
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Uniform_cost_search_H1_Rep.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        //System.out.println("Current Estimate to the goal:"+this.compute_float_cost(s, G, dist));
        return this.check_goal_conditions(s, G, dist, closed);
    }

    protected boolean generate_achievers() {
        interact_with = new HashMap();
        achieve = new HashMap();
        possible_achievers = new HashMap();
        for (GroundAction gr : this.A) {
            LinkedHashSet<Comparison> comparisons = new LinkedHashSet();
            LinkedHashSet<Comparison> reacheable_comparisons = new LinkedHashSet();
            LinkedHashSet<Predicate> predicates = new LinkedHashSet();
            for (Conditions c : this.all_conditions) {
                if (c instanceof Comparison) {
                    Comparison comp = (Comparison) c;
                    if (comp.involve(gr.getNumericFluentAffected())) {
                        comparisons.add(comp);
                        try {
                            if (gr.is_possible_achiever_of(comp)) {
                                reacheable_comparisons.add(comp);
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(Uniform_cost_search_H1_Rep.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (this.is_complex.get(comp.getCounter())) {
                            reacheable_comparisons.add(comp);
                        }
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
        return false;
    }

    private void update_achievers(Collection<Conditions> conds, Collection<GroundAction> actions) {

        temporary_achievers = new HashMap();
        for (GroundAction gr : actions) {
            LinkedHashSet<Comparison> reacheable_comparisons = new LinkedHashSet();
            for (Conditions c : conds) {
                if (c instanceof Comparison) {
                    Comparison comp = (Comparison) c;
                    if (comp.involve(gr.getNumericFluentAffected())) {
                        try {
                            if (gr.is_possible_achiever_of(comp)) {
                                reacheable_comparisons.add(comp);
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(Uniform_cost_search_H1_Rep.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }

            temporary_achievers.put(gr, reacheable_comparisons);
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

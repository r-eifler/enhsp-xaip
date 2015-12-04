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

import conditions.AndCond;
import conditions.Comparison;
import conditions.Conditions;
import conditions.Predicate;
import expressions.ExtendedNormExpression;
import expressions.NumEffect;
import expressions.NumFluent;
import extraUtils.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;
import problem.GroundAction;
import problem.RelState;
import problem.State;
//import gurobi.*;

/**
 *
 * @author enrico
 */
public class Bellman_Ford_H1 extends Heuristics {

    private boolean greedy;
    protected boolean full_regression = false;
    protected HashMap<Conditions, Boolean> redundant_constraints;
    protected HashMap<Pair<GroundAction, Comparison>, Boolean> num_achiever;

    protected HashMap<Pair<Conditions,GroundAction>,Boolean> achvs;


    public Bellman_Ford_H1(Conditions G, Set<GroundAction> A) {
        super(G, A);
        this.G = G;
        this.A = (LinkedHashSet<GroundAction>) A;
        complex_conditions = 0;
        
        //System.out.println(this.orderings);
        //build_integer_representation();
    }

    @Override
    public int setup(State s_0) {
        this.build_integer_representation();
        this.identify_complex_conditions(all_conditions, A);

        int d = reacheability(s_0);
        generate_self_precondition_delete_sets();
        generate_numeric_achievers(s_0);
        this.generate_achievers();
        //System.out.println(achvs);
        System.out.println("Achievers generated");
        System.out.println("Easy Conditions: " + (this.all_conditions.size() - complex_conditions));
        System.out.println("Hard Conditions: " + complex_conditions);
        setGreedy(false);
        return d;
    }

    @Override
    public int compute_estimate(State s_0) {
        if (s_0.satisfy(G)) {
            return 0;
        }
        ArrayList<Integer> h = new ArrayList<Integer>(Collections.nCopies(all_conditions.size() + 1, Integer.MAX_VALUE));
        this.init_h(h, all_conditions, s_0);
        Collection<GroundAction> A_temp = new LinkedHashSet(this.reachable);
        Collection<HeuristicSearchNode> pool = new LinkedHashSet();
        this.init_pool(pool, A_temp, s_0, h);
        boolean update;
        do {
            update = this.update_conditions_values(pool, s_0, all_conditions, h);
            if (update) {
                this.update_pool(pool, A_temp, s_0, h);
            }
        } while (update);
        return this.check_goal_conditions(s_0, G, h);

    }

    public int reacheability(State s_0) {
        if (s_0.satisfy(G)) {
            return 0;
        }
        ArrayList<Integer> h = new ArrayList<Integer>(Collections.nCopies(all_conditions.size() + 1, Integer.MAX_VALUE));

        this.init_h(h, all_conditions, s_0);
        update_pool(this.reachable, A, s_0, h);
        boolean update;
        do {
            update = this.update_h(this.reachable, all_conditions, h, s_0);
            if (update) {
                update_pool(this.reachable, A, s_0, h);
            }

        } while (update);
        return this.check_goal_conditions(s_0, G, h);

    }

    protected boolean update_conditions_values(Collection<HeuristicSearchNode> pool, State s_0, Collection<Conditions> all_conditions, ArrayList<Integer> h) {
        boolean update = false;
        for (Conditions c : this.all_conditions) {
            if (h.get(c.getCounter()) != 0) {
                if (c instanceof Predicate) {
                    for (HeuristicSearchNode gr : pool) {
                        
                        if (this.achvs.get(new Pair(c,gr.action)) == false)
                            continue;
                        if (gr.action.achieve((Predicate) c)) {
                            if (update_value(h, c, gr.action_cost_to_get_here + 1)) {
                                update = true;
                            }
                        }
                    }
                } else if (c instanceof Comparison) {

                    if (!this.is_complex.get(c)) {
                        for (HeuristicSearchNode gr : pool) {
                            if (this.achvs.get(new Pair(c,gr.action))== false)
                                continue;
                            int number_of_repetition = gr.action.getNumberOfExecution(s_0, (Comparison) c);
                            if (number_of_repetition != Integer.MAX_VALUE) {
                                if (this.full_regression) {
                                    if (update_value(h, c, gr.action_cost_to_get_here * number_of_repetition + number_of_repetition)) {
                                        update = true;
                                    }
                                } else {
                                    if (update_value(h, c, gr.action_cost_to_get_here + number_of_repetition)) {
                                        update = true;
                                    }
                                }
                            }
                        }
                    } else {
                        int cost = interval_based_relaxation(s_0, c, pool);
                        if (cost != Integer.MAX_VALUE) {
                            if (update_value(h, c, cost)) {
                                update = true;
                            }
                        }
                    }
                }

            }
        }
        return update;
    }

    /**
     * @return the greedy
     */
    public boolean isGreedy() {
        return greedy;
    }

    /**
     * @param greedy the greedy to set
     */
    public void setGreedy(boolean greedy) {
        this.greedy = greedy;
    }

    protected void add_redundant_constraints() throws Exception {
        redundant_constraints = new HashMap();

        for (GroundAction a : A) {
            if (a.getPreconditions() != null) {
                compute_redundant_constraint((Set<Conditions>) a.getPreconditions().sons);
            }
            //System.out.println(a.toPDDL());
        }

        compute_redundant_constraint((Set<Conditions>) G.sons);
    }

    protected void compute_redundant_constraint(Set<Conditions> set) throws Exception {
        LinkedHashSet temp = new LinkedHashSet();
        ArrayList<Conditions> set_as_array = new ArrayList(set);
        int counter = 0;
        for (int i = 0; i < set_as_array.size(); i++) {
            for (int j = i + 1; j < set_as_array.size(); j++) {
                Conditions c_1 = set_as_array.get(i);
                Conditions c_2 = set_as_array.get(j);
                if ((c_1 instanceof Comparison) && (c_2 instanceof Comparison)) {
                    counter++;
                    Comparison a1 = (Comparison) c_1;
                    Comparison a2 = (Comparison) c_2;
                    ExtendedNormExpression lhs_a1 = (ExtendedNormExpression) a1.getLeft();
                    ExtendedNormExpression lhs_a2 = (ExtendedNormExpression) a2.getLeft();
                    ExtendedNormExpression expr = lhs_a1.sum_copy(lhs_a2);
                    String new_comparator = ">=";
                    if (a1.getComparator().equals(">") && a2.getComparator().equals(">")) {
                        new_comparator = ">";
                    }
                    Comparison newC = new Comparison(new_comparator);
                    newC.setLeft(expr);
                    newC.setRight(new ExtendedNormExpression(new Float(0.0)));
                    newC.normalize();

                    ExtendedNormExpression tempLeft = (ExtendedNormExpression) newC.getLeft();

                    if (tempLeft.summations.size() < 2) {
                        continue;
                    }
                    redundant_constraints.put(newC, true);
                    temp.add(newC);
                }
            }
        }
//        System.out.println("New conditions now:"+counter);
//        System.out.println("Set before:"+set.size());
        set.addAll(temp);
//        System.out.println("Set after:"+set.size());
    }


    private void generate_numeric_achievers(State s_0) {
        this.num_achiever = new HashMap();
        for (Conditions c : this.all_conditions) {
            for (GroundAction gr : this.reachable) {
                if (c instanceof Comparison) {
                    Comparison comp = (Comparison) c;
                    if (comp.eval_affected(s_0, gr) >= 0) {
                        this.num_achiever.put(new Pair(gr, comp), true);
                    } else {
                        this.num_achiever.put(new Pair(gr, comp), false);
                    }

                }
            }
        }
    }

    private void generate_achievers() {

        achvs = new HashMap();

        for (Conditions c : this.all_conditions) {
            for (GroundAction gr : this.A) {
                achvs.put(new Pair(c,gr), false);
                if (c instanceof Comparison) {
                    Comparison comp = (Comparison) c;
                    if (comp.involve(gr.getNumericFluentAffected())) {
                        if (gr.is_possible_achiever_of(comp)) {
                            achvs.put(new Pair(c,gr), true);
                        }
                        if (this.is_complex.get(comp)) {
                            achvs.put(new Pair(c,gr), true);
                        }
                    }
                } else if (c instanceof Predicate) {
                    Predicate p = (Predicate) c;
                    if (gr.achieve(p)) {
                        achvs.put(new Pair(c,gr), true);
                    }

                }
            }

        }
    }

}

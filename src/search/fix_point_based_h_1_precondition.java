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
import expressions.BinaryOp;
import expressions.NormExpression;
import expressions.NumEffect;
import expressions.NumFluent;
import expressions.PDDLNumber;
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
import java.util.Set;
import problem.GroundAction;
import problem.RelState;
import problem.State;
//import gurobi.*;

/**
 *
 * @author enrico
 */
public class fix_point_based_h_1_precondition extends fix_point_based_h1 {

    protected HashMap<GroundAction, LinkedHashSet<Pair<Comparison, Integer>>> rep_costs;
    protected HashMap<Conditions, Conditions> generator;

    public fix_point_based_h_1_precondition(Conditions G, Set<GroundAction> A) throws Exception {
        super(G, A);
        this.G = G;
        this.A = (LinkedHashSet<GroundAction>) A;

    }
 
    @Override
    public int compute_estimate(State s_0) {
        //System.out.println("fix point based heuristic");
        this.achievers = new HashMap();
        if (s_0.satisfy(G)) {
            return 0;
        }
        Collection<GroundAction> A_temp = new LinkedHashSet(this.reachable);;

        LinkedHashSet<Conditions> all_conditions_temp = new LinkedHashSet(all_conditions);

        generate_repetition_constraints(s_0, A_temp, (LinkedHashSet) all_conditions_temp);
        ArrayList<Integer> h = new ArrayList<Integer>(Collections.nCopies(all_conditions_temp.size() + 1, Integer.MAX_VALUE));

        init_h(h, all_conditions_temp, s_0);

        Collection<HeuristicSearchNode> pool = new LinkedHashSet();
        init_pool(pool, A_temp, s_0, h);
        boolean update;
        do {
            update = this.update_conditions_values(pool, s_0, all_conditions_temp, h);
            if (update) {
                this.update_pool(pool, A_temp, s_0, h);
            }
        } while (update);
        return this.check_goal_conditions(s_0, G, h);

    }

    @Override
    protected boolean update_conditions_values(Collection<HeuristicSearchNode> pool, State s_0, Collection<Conditions> conds, ArrayList<Integer> h) {
        boolean update = false;
        for (Conditions c : conds) {
            if (h.get(c.getCounter()) != 0) {
                if (c instanceof Predicate) {
                    for (HeuristicSearchNode gr : pool) {
                        if (gr.action.achieve((Predicate) c)) {
                            if (update_value(h, c, gr.action_cost_to_get_here + 1)) {
                                update = true;
                            }
                        }
                    }
                } else if (c instanceof Comparison) {
                    if (this.is_complex.get(c) == null) {
                        for (HeuristicSearchNode gr : pool) {
//                            Pair<GroundAction,Comparison> p1 = new Pair(gr.action,(Comparison)c);
//                            if (this.interact_with.get(p1) == false){
//                                continue;
//                            }

                            int number_of_repetition;

                            //if (c.getCounter()> this.index_of_last_static_atom){//this is not a static comparison
                            //    number_of_repetition  = gr.action.getNumberOfExecutionWithoutCache(s_0, (Comparison)c);
                            //}else{
                            number_of_repetition = gr.action.getNumberOfExecution(s_0, (Comparison) c);
                            //}

//                            if (number_of_repetition > 10 && number_of_repetition != Integer.MAX_VALUE){
//                                System.out.println("Action:"+gr.action);
//                            }
                            float additional_cost = 0;
                            if (number_of_repetition != Integer.MAX_VALUE) {
                                boolean possible_achiever = true;
                                if (this.rep_costs.get(gr.action) != null) {
                                    LinkedHashSet<Pair<Comparison, Integer>> ret = this.rep_costs.get(gr.action);
                                    for (Pair<Comparison, Integer> p : ret) {
                                        int rpc = h.get(p.getFirst().getCounter());
                                        //System.out.println("Counter here:"+p.getFirst().getCounter());
                                        if (number_of_repetition > p.getSecond()) {
                                            if (rpc == Integer.MAX_VALUE) {
                                                possible_achiever = false;
                                                break;
                                            } else {
                                                Comparison ancestor_comp = (Comparison) this.generator.get(p.getFirst());
                                                //System.out.println(generator);
                                                int pc = h.get(ancestor_comp.getCounter());
                                                additional_cost += (number_of_repetition - p.getSecond() - 1) * rpc - pc;
                                            }
                                        }
                                    }
                                }
                                if (!possible_achiever) {
                                    continue;
                                }
                                if (this.full_regression) {
                                    //System.out.println("Full regression activated");
                                    if (update_value(h, c, number_of_repetition * gr.action_cost_to_get_here + number_of_repetition)) {
                                        update = true;
                                    }
                                } else {
                                    if (update_value(h, c, number_of_repetition + gr.action_cost_to_get_here + (int) additional_cost)) {
//                                        System.out.println("")
                                        update = true;
                                    }
                                }
                            }
                        }
                    } else {
                        int cost = accumulated_value_reacheability(s_0, c, pool);
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

    private void generate_repetition_constraints(State s_0, Collection<GroundAction> A1, LinkedHashSet<Conditions> conditions_set) {

        rep_costs = new HashMap();
        generator = new HashMap();
        //LinkedHashSet<Conditions> new_conditions_set = new LinkedHashSet();
        for (GroundAction gr : A1) {
            LinkedHashSet pairs_to_add = new LinkedHashSet();
            if (gr.getPreconditions() == null || gr.getPreconditions().sons.isEmpty()) {
                continue;
            }
            for (Conditions c : (Collection<Conditions>) gr.getPreconditions().sons) {
                if (c instanceof Comparison) {
                    Comparison comp = (Comparison) c;
                    float b = comp.eval_affected(s_0, gr);
                    float a = comp.eval_not_affected(s_0, gr);
                    Integer u_b;
                    if (b < 0) {//action has negative effects

                        float float_temp = -a/b;
//                        if (float_temp < 0)
//                            u_b = (int)Math.floor(-a / b);
//                        else
                        u_b = (int)Math.ceil(-a / b);

                        if ((comp.getComparator().equals("<") || comp.getComparator().equals(">")) ) {
                            u_b--;
                        }

                                
                        //u_b = Math.max(0, u_b);
                        Comparison new_comp = new Comparison(comp.getComparator());
                        BinaryOp op = new BinaryOp(comp.getLeft().clone(), "+", new PDDLNumber((float)(u_b+1) * b), true);
                        new_comp.setLeft(op);
                        new_comp.setRight(new PDDLNumber(0));
                        new_comp.normalize();

                        new_comp.setCounter(conditions_set.size() + 1);
                        //this.index_of_last_static_atom++;

                        if (!conditions_set.add(new_comp)) {
                            for (Conditions c3 : conditions_set) {
                                if (c3 instanceof Comparison) {
                                    Comparison temp = (Comparison) c3;
                                    if (temp.equals(new_comp)) {
                                        new_comp.setCounter(temp.getCounter());
                                    }
                                }
                            }
                        } else {

                        }
                        this.generator.put(new_comp, comp);
                        Pair<Comparison, Integer> to_add = new Pair(new_comp, u_b);
                        pairs_to_add.add(to_add);

                    }
                }
            }
            rep_costs.put(gr, pairs_to_add);
        }
    }

}

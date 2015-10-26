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
public class fix_point_based_h1 extends Heuristics {

    private HashMap<Conditions, LinkedHashSet<GroundAction>> poss_contributors;
    private boolean greedy;
    protected boolean full_regression = false;

    public fix_point_based_h1(Conditions G, Set<GroundAction> A) {
        super(G, A);
        this.G = G;
        this.A = (LinkedHashSet<GroundAction>) A;
        //System.out.println(this.orderings);
        //build_integer_representation();
    }

    @Override
    public int setup(State s_0) {
        this.build_integer_representation();
        this.identify_complex_conditions(all_conditions, A);

        int d = reacheability(s_0);

        System.out.println("Easy Conditions: " + (this.all_conditions.size() - is_complex.keySet().size()));
        System.out.println("Hard Conditions: " + is_complex.keySet().size());
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
                        if (gr.action.achieve((Predicate) c)) {
                            if (update_value(h, c, gr.action_cost_to_get_here + 1)) {
                                update = true;
                            }
                        }
                    }
                } else if (c instanceof Comparison) {
                    if (this.is_complex.get(c) == null) {
                        for (HeuristicSearchNode gr : pool) {
                            int number_of_repetition = gr.action.getNumberOfExecution(s_0, (Comparison) c);
                            if (number_of_repetition != Integer.MAX_VALUE) {
                                if (this.full_regression){
                                    if (update_value(h, c, gr.action_cost_to_get_here*number_of_repetition + number_of_repetition)) {
                                        update = true;
                                    }
                                }else{
                                    if (update_value(h, c, gr.action_cost_to_get_here + number_of_repetition)) {
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

    protected void identify_complex_conditions(Collection<Conditions> conds, Collection<GroundAction> A) {
        //For each condition, identify whether there is at least an action whose effects are not simple. This condition
        // will be considered complex in that checking its satisfaction is hard
        is_complex = new HashMap();
        for (Conditions c : conds) {
            if (c instanceof Comparison) {
                Comparison comp = (Comparison) c;
                for (GroundAction gr : A) {
                    if (gr.getNumericEffects() != null) {
                        AndCond effects = (AndCond) gr.getNumericEffects();
                        for (NumEffect ne : (Collection<NumEffect>) effects.sons) {
                            if (comp.getInvolvedFluents().contains(ne.getFluentAffected())) {
                                if (!ne.fluentsInvolved().isEmpty()) {
                                    is_complex.put(comp, true);
                                    //System.out.println("Complex condition:"+comp);
                                }
                            }

                        }
                    }
                }
            }
        }
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



    

 

}

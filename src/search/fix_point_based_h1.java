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
import gurobi.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author enrico
 */
public class fix_point_based_h1 extends Heuristics {

    private Integer counter;
    private HashMap<Conditions, LinkedHashSet<GroundAction>> poss_contributors;
    private HashMap<Conditions, Boolean> is_complex;
    private boolean greedy;

    public fix_point_based_h1(Conditions G, Set<GroundAction> A) {
        super(G, A);
        this.G = G;
        this.A = (LinkedHashSet<GroundAction>) A;
        //build_integer_representation();
    }

    public void setup(State s_0) {
        this.build_integer_representation();//for each proposition and comparison there is a unique integer representation
        influenced_by = computeInflueced_by();
        influence_graph = create_influence_graph();
        this.compute_relevant_actions(s_0);
        A = this.reachable;
        is_complex = identify_complex_conditions();
        System.out.println("Easy Conditions: " + (this.all_conditions.size() - is_complex.keySet().size()));
        System.out.println("Hard Conditions: " + is_complex.keySet().size());
        setGreedy(false);
    }

    @Override
    public int compute_estimate(State s_0) {
        //System.out.println("fix point based heuristic");
        this.achievers = new HashMap();
        if (s_0.satisfy(G)) {
            return 0;
        }
        LinkedHashSet<GroundAction> A1 = new LinkedHashSet();
        A1.addAll(this.reachable);
        ArrayList<Integer> h = new ArrayList<Integer>(Collections.nCopies(number_of_actual_atoms, Integer.MAX_VALUE));
        init_h(h, this.all_conditions, s_0);
        HashSet<HeuristicSearchNode> pool = new HashSet();
        init_pool(pool, A1, s_0);
        boolean update;
        do {
            update = update_conditions_values(pool, s_0, this.all_conditions, h);
            if (update) {
                update_pool(pool, A1, s_0, h);
                if (isGreedy()){
                    int distance_to_goal = this.check_goal_conditions(s_0, G, h);
                    if (distance_to_goal != Integer.MAX_VALUE) {
                        return distance_to_goal;
                    }
                }
            }

        } while (update);

        if (!isGreedy()){
                return this.check_goal_conditions(s_0, G, h);
        }
        
        return Integer.MAX_VALUE;
    }

    protected int check_goal_conditions(State s_0, Conditions G, ArrayList<Integer> h) {
        int cost = 0;
        for (Conditions g : (LinkedHashSet<Conditions>) G.sons) {
            int temp = h.get(g.getCounter());
            if (temp != Integer.MAX_VALUE || s_0.satisfy(g)) {
                if (s_0.satisfy(g)) {
                    h.set(g.getCounter(), 0);
                } else {
                    if (additive_h) {
                        cost += temp;
                    } else {
                        cost = Math.max(cost, temp);
                    }
                }
            } else {
                return Integer.MAX_VALUE;
            }
        }
        return cost;
    }

    protected int compute_precondition_cost(State s_0, ArrayList<Integer> h, GroundAction gr) {

        int cost = 0;
        if (gr.getPreconditions() != null && gr.getPreconditions().sons != null) {
            for (Conditions t : (LinkedHashSet<Conditions>) gr.getPreconditions().sons) {
                int temp = h.get(t.getCounter());
                if (temp != Integer.MAX_VALUE) {
                    if (additive_h) {
                        cost += temp;
                    } else {
                        cost = Math.max(cost, temp);
                    }
                } else if (s_0.satisfy(t)) {
                    h.set(t.getCounter(), 0);
                    if (additive_h) {
                        cost += 0;
                    } else {
                        cost = Math.max(cost, 0);
                    }
                } else {
                    return Integer.MAX_VALUE;
                }

            }
        }
        return cost;
    }

    private void init_h(ArrayList<Integer> h, Collection<Conditions> all_conditions, State s_0) {
        for (Conditions c_1 : this.all_conditions) {
            if (c_1.isSatisfied(s_0)) {
                h.set(c_1.getCounter(), 0);
            }
            if (debug >= 2) {
                System.out.println("Condition counter mapping:" + c_1 + " ," + c_1.getCounter());
            }
        }
    }
//

    private void init_pool(HashSet pool, LinkedHashSet<GroundAction> A1, State s_0) {
        counter = 0;
        Iterator it = A1.iterator();
        while (it.hasNext()) {
            GroundAction gr = (GroundAction) it.next();
            if (gr.isApplicable(s_0)) {
                gr.setAction_cost(s_0);
                pool.add(new HeuristicSearchNode(gr, null, 0, 0));
                //frontier.add(new HeuristicSearchNode(gr, null, 1, 0));
                it.remove();
            }
        }
    }

    private boolean update_value(ArrayList<Integer> h, Conditions c, int cost) {
        if (h.get(c.getCounter()) != null && h.get(c.getCounter()) <= cost) {
            return false;
        }
        h.set(c.getCounter(), cost);
        return true;
    }

    private void update_pool(HashSet<HeuristicSearchNode> pool, LinkedHashSet<GroundAction> A1, State s_0, ArrayList<Integer> h) {
        //update action precondition
        for (HeuristicSearchNode gr : pool) {
            gr.action_cost_to_get_here = compute_precondition_cost(s_0, h, gr.action);
        }
        Iterator it = A1.iterator();
        while (it.hasNext()) {
            GroundAction gr = (GroundAction) it.next();
            int cost = compute_precondition_cost(s_0, h, gr);
            if (cost != Integer.MAX_VALUE) {
                gr.setAction_cost(s_0);
                pool.add(new HeuristicSearchNode(gr, null, cost, 0));
                it.remove();
            }
        }
    }

    private boolean update_conditions_values(HashSet<HeuristicSearchNode> pool, State s_0, Collection<Conditions> all_conditions, ArrayList<Integer> h) {
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
                                if (update_value(h, c, gr.action_cost_to_get_here+number_of_repetition)) {
                                    update = true;
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

    private HashMap<Conditions, Boolean> identify_complex_conditions() {
        //For each condition, identify whether there is at least an action whose effects are not simple. This condition
        // will be considered complex in that checking its satisfaction is hard
        HashMap<Conditions, Boolean> ret = new HashMap();
        for (Conditions c : this.all_conditions) {
            if (c instanceof Comparison) {
                Comparison comp = (Comparison) c;
                for (GroundAction gr : this.A) {
                    //Checking whether there exists an action having a variable in its rhs should be enough to capture the dependency on another action
                    //this assumes that variables have been simplified in the first place (removal of variables which were actually costant for the problem at hand)
                    if (gr.getNumericEffects() != null) {
                        AndCond effects = (AndCond) gr.getNumericEffects();
                        for (NumEffect ne : (Collection<NumEffect>) effects.sons) {
                            if (comp.getInvolvedFluents().contains(ne.getFluentAffected())) {
                                if (!ne.fluentsInvolved().isEmpty()) {
                                    ret.put(comp, true);
                                    //System.out.println("Complex condition:"+comp);
                                }
                            }

                        }
                    }
                }
            }
        }

        return ret;
    }

    private LinkedList sort_actions_pool_according_to_cost(HashSet<HeuristicSearchNode> pool) {
        LinkedList temp = new LinkedList(pool);
        Collections.sort(temp, new Comparator<HeuristicSearchNode>() {
            @Override
            public int compare(HeuristicSearchNode o1, HeuristicSearchNode o2) {
                //order according to the dependency of the actions, otherwise use lexicographic ordering
                return (o2.action.depends_on(o1.action) ? -1 : (o1.action.depends_on(o2.action) ? 1 : o1.action.getName().compareTo(o2.action.getName())));
            }
        });
        return temp;
    }

    private int accumulated_value_reacheability(State s_0, Conditions c, HashSet<HeuristicSearchNode> pool) {
        RelState rel_state = s_0.relaxState();
        LinkedList ordered_actions = sort_actions_pool_according_to_cost(pool);
        int cost = 0;
        float current_distance = rel_state.satisfaction_distance((Comparison) c);
        //this terminates correctly whenever the numeric dependency graph is acyclic
        while (true) {
            boolean stop = true;
            for (Object action : ordered_actions) {
                HeuristicSearchNode gr = (HeuristicSearchNode) action;
                rel_state = gr.action.apply(rel_state);
                float new_dist = rel_state.satisfaction_distance((Comparison) c);
                if (current_distance > new_dist) {
                    cost += gr.action_cost_to_get_here + 1;
                    current_distance = new_dist;
                    stop = false;
                }
                if (rel_state.satisfy((Comparison) c)) {
                    return cost;
                }
            }
            if (stop) {
                return Integer.MAX_VALUE;
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

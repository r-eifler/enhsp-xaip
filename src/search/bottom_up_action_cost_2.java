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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import problem.GroundAction;
import problem.State;

/**
 *
 * @author enrico
 */
public class bottom_up_action_cost_2 extends Heuristics {

    private HashMap<GroundAction, HashSet<Conditions>> impr_conditions = new HashMap();
    private Integer counter;

    public bottom_up_action_cost_2(Conditions G, Set<GroundAction> A) {
        super(G, A);
        this.G = G;
        this.A = (LinkedHashSet<GroundAction>) A;
        //build_integer_representation();
    }

    @Override
    public int compute_estimate(State s_0) {
        this.achievers = new HashMap();
        if (s_0.satisfy(G)) {
            return 0;
        }
        LinkedHashSet<GroundAction> A1 = new LinkedHashSet();
        A1.addAll(this.reachable);
        ArrayList<Integer> h = new ArrayList<Integer>(Collections.nCopies(index_of_last_static_atom, Integer.MAX_VALUE));
        PriorityQueue<HeuristicSearchNode> frontier = new PriorityQueue();
        init_h(h, this.all_conditions, s_0);
        init_frontier(frontier, A1, s_0);
        while (check_goal_conditions(s_0, G, h) == Integer.MAX_VALUE) {
            if (frontier.isEmpty()) {
               return Integer.MAX_VALUE;
            }
            HeuristicSearchNode node = frontier.poll();
            update_prop_h(node, h); //updating the distance to the propositional atoms
            update_num_h_and_add_pseudo_numeric_action(frontier, node, h, s_0); //updating the distance to the numeric conditions
            update_frontier(frontier, A1, h, s_0); //updating the frontier according to the action that can now be executed
        }
        return check_goal_conditions(s_0, G, h);
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

    protected void update_frontier(Collection frontier, LinkedHashSet<GroundAction> A1, ArrayList<Integer> h, State s_0) {
        Iterator it = A1.iterator();
        while (it.hasNext()) {
            GroundAction gr = (GroundAction) it.next();
            int cost = 0;
            cost = this.compute_precondition_cost(s_0, h, gr);
            if (cost != Integer.MAX_VALUE) {
                this.reachable.add(gr);
                gr.setAction_cost(s_0);
                if (!frontier.add(new HeuristicSearchNode(gr, null, cost, 0))) {
                    System.out.println("Adding an already existing element");
                }
                it.remove();
            }
        }
            
    }

    protected int compute_precondition_cost(State s_0, ArrayList<Integer> h, GroundAction gr) {

        int cost = 0;
        if (gr.getPreconditions()!= null && gr.getPreconditions().sons != null){
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

    protected boolean update_prop_h(HeuristicSearchNode node, ArrayList<Integer> h) {
        boolean new_condition = false;

        if (node.action.getAddList() == null) {
            return new_condition;
        }
        for (Conditions eff : (LinkedHashSet<Conditions>) node.action.getAddList().sons) {
            //System.out.println("Instantiating..:"+eff.getCounter());
            int temp = h.get(eff.getCounter());
            if (temp > (node.action_cost_to_get_here + 1)) {
                h.set(eff.getCounter(), node.action_cost_to_get_here + 1);
                //h.put(eff, node.action_cost_to_get_here);
                new_condition = true;
            }
        }
        return new_condition;
    }

    private void init_frontier(Queue frontier, LinkedHashSet<GroundAction> A1, State s_0) {
        counter = 0;
        Iterator it = A1.iterator();
        while (it.hasNext()) {
            GroundAction gr = (GroundAction) it.next();
            if (gr.isApplicable(s_0)) {
                gr.setAction_cost(s_0);
                frontier.add(new HeuristicSearchNode(gr, null, 0, 0));
                //frontier.add(new HeuristicSearchNode(gr, null, 1, 0));
                it.remove();
            }
        }
    }

    private void update_num_h_and_add_pseudo_numeric_action(Queue frontier, HeuristicSearchNode node, ArrayList<Integer> h, State s_0) {

        GroundAction gr = node.action;
        if (gr.achievedComparisons != null) {
            for (Conditions c_1 : gr.achievedComparisons) {
                update_cost(c_1, h, node.action_cost_to_get_here);
            }
        }
        if (this.influenced_by.get(node.action) == null) {
            return;
        }

        for (Conditions c_1 : influenced_by.get(gr)) {
            if (h.get(c_1.getCounter()) != null && h.get(c_1.getCounter()) == 0) {
                continue;
            }
            int cost_via_action = compute_estimated_cost(node, this.max_depth, s_0, c_1);
            int cost_via_indirect_effects = compute_indirect_effects_cost(s_0, h, node);
            if (this.debug >= 1) {
                System.out.println("State:" + s_0.pddlPrint());
                System.out.println("D(" + gr.toEcoString() + "," + c_1 + "):" + cost_via_action);
                System.out.println("D1(" + gr.toEcoString() + "," + c_1 + "):" + cost_via_indirect_effects);
                System.out.println("h: " + h);
            }
            int minimum = Math.min(cost_via_action, cost_via_indirect_effects);
            if (minimum != Integer.MAX_VALUE) {
                counter++;
                GroundAction gr_new = new GroundAction(counter.toString());
                //gr_new.setName(c_1.pddlPrint(false));
                gr_new.addAchievedComparison(c_1);
                gr.setAction_cost(s_0);

                frontier.add(new HeuristicSearchNode(gr_new, null, (int) (minimum), 0));
//                frontier.add(new HeuristicSearchNode(gr_new,null, (int) (cost_c_1+node.action_cost_to_get_here),0));                
                //it.remove();//greedy version
            }
            if (this.debug >= 2) {
                try {
                    System.in.read();
                } catch (IOException ex) {
                    Logger.getLogger(bottom_up_action_cost_2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    private void update_cost(Conditions c_1, ArrayList<Integer> h, int cost_c_1) {
        int temp = h.get(c_1.getCounter());
        if (temp > cost_c_1) {
            h.set(c_1.getCounter(), cost_c_1);
        }
    }

    private int compute_estimated_cost(HeuristicSearchNode node, int max_depth, State s_0, Conditions c_1) {

        int ret =  node.action.getNumberOfExecution(s_0, (Comparison) c_1);
        if (ret == Integer.MAX_VALUE)
            return ret;
        return ret + node.action_cost_to_get_here;
        
        
    }



    private int compute_indirect_effects_cost(State s_0, ArrayList<Integer> h, HeuristicSearchNode node) {
        if (this.influence_graph.get(node.action) == null) {
            return Integer.MAX_VALUE;
        }
        if (this.influence_graph.get(node.action).isEmpty()) {
            return Integer.MAX_VALUE;
        }
        int minimum = Integer.MAX_VALUE;
        for (GroundAction gr : this.influence_graph.get(node.action)) {
            int temp = this.compute_precondition_cost(s_0, h, gr);
            if (temp < minimum) {
                minimum = temp;
            }
        }
        if (minimum == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        
        //else return the cost of achieving that action+the cost of executing the action under analysis and plus 2 which is the number
        //of times for executing those two actions
        return minimum+node.action_cost_to_get_here+2;
    }

}

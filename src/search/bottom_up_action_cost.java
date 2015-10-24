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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
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
public class bottom_up_action_cost extends Heuristics {

    public final Conditions G;
    public final LinkedHashSet<GroundAction> A;
    private HashMap<GroundAction, HashSet<Conditions>> impr_conditions = new HashMap();
    private Integer counter;

    public bottom_up_action_cost(Conditions G, Set<GroundAction> A) {
        super(G, A);
        this.G = G;
        this.A = (LinkedHashSet<GroundAction>) A;
    }

    public Map<Conditions, Integer> init_hash_map(LinkedHashSet<GroundAction> A,State s_0){
//        Map<Conditions, Integer> h = new HashMap((int) (A.size()*4/.75+1));
        Map<Conditions, Integer> h = new HashMap();
        for (GroundAction gr : A) {
            for (Conditions t : (LinkedHashSet<Conditions>) gr.getPreconditions().sons) {
                if (s_0.satisfy(t)){
                    h.put(t,0);
                }else
                    h.put(t,Integer.MAX_VALUE);
            }
        }
        return h;
        
    }
    
    /**
     *
     * @param s_0
     * @return
     * @throws Exception
     */
    @Override
    public int compute_estimate(State s_0){
        
        if (s_0.satisfy(G)) {
            return 0;
        }
        LinkedHashSet<GroundAction> A1 = new LinkedHashSet();

        A1.addAll(A);
        
        //ArrayList<Integer> h = new HashMap();
//        int[] h;
//        h = new int[index_of_last_static_atom];
//        for (int i=0;i<this.index_of_last_static_atom;i++){
//            h[i] = Integer.MAX_VALUE;
//        }
      
        Map<Conditions, Integer> h = new HashMap();

        PriorityQueue<HeuristicSearchNode> frontier = new PriorityQueue();

        init_frontier(frontier, A1, s_0, h);
        while (!frontier.isEmpty()) {
            int current = check_goal_conditions(s_0, G, h);
            if (current != Integer.MAX_VALUE) {
                return current;
            }
            HeuristicSearchNode node = frontier.poll();
            update_prop_h(node, h);
            try {
                update_num_h_and_add_pseudo_numeric_action(frontier, node, h,s_0);
            } catch (Exception ex) {
                Logger.getLogger(bottom_up_action_cost.class.getName()).log(Level.SEVERE, null, ex);
            }
            update_frontier(frontier, A1, h,s_0);
        }
        return Integer.MAX_VALUE;
    }
    

    
    @Override
    protected void update_frontier(Collection frontier, LinkedHashSet<GroundAction> A1, Map<Conditions, Integer> h, State s_0) {
        Iterator it = A1.iterator();
        while (it.hasNext()) {
            GroundAction gr = (GroundAction) it.next();
            int cost = 0;
            cost = this.compute_precondition_cost(s_0, h, gr);
            if (cost != Integer.MAX_VALUE) {
                this.reachable.add(gr);
                gr.setAction_cost(s_0);
                cost += (int)gr.getAction_cost();
                if (!frontier.add(new HeuristicSearchNode(gr, null, cost, 0))){
                    System.out.println("Adding an already existing element");
                }
                //if (this.influenced_by.get(gr).isEmpty())
                it.remove();
            }
        }
    }
    
    @Override
    protected boolean update_prop_h(HeuristicSearchNode node,Map<Conditions, Integer> h) {
        boolean new_condition = false;
        if (node.action.getAddList() == null)
            return new_condition;
        for (Conditions eff : (LinkedHashSet<Conditions>) node.action.getAddList().sons) {
            if (h.get(eff) == null || h.get(eff) > (node.action_cost_to_get_here)) {
                h.put(eff, node.action_cost_to_get_here);
                new_condition = true;
            }
        }
        return new_condition;
    }

    private void init_frontier(Queue frontier, LinkedHashSet<GroundAction> A1, State s_0, Map<Conditions, Integer> h) {
        counter=0;
        Iterator it = A1.iterator();
        while (it.hasNext()) {
            GroundAction gr = (GroundAction) it.next();
            if (gr.isApplicable(s_0)) {
                gr.setAction_cost(s_0);
                frontier.add(new HeuristicSearchNode(gr, null, (int)gr.getAction_cost(), 0));
                it.remove();
            }
        }
    }



    private void update_num_h_and_add_pseudo_numeric_action(Queue frontier, HeuristicSearchNode node, Map<Conditions, Integer> h, State s_0) throws Exception {

        GroundAction gr = node.action;
        if (gr.achievedComparisons != null){
            for (Conditions c_1: gr.achievedComparisons){
                update_cost(c_1,h,node.action_cost_to_get_here);
            }
        }
        if (this.influenced_by.get(gr) == null) {
            return;
        }
        for (Conditions c_1 : influenced_by.get(gr)) {
            int cost_c_1 = compute_estimated_cost(node,this.max_depth,s_0,c_1);
            if (cost_c_1!= Integer.MAX_VALUE && cost_c_1 != -1){
                counter++;
                GroundAction gr_new = new GroundAction(counter.toString());
                //gr_new.setName(c_1.pddlPrint(false));
                gr_new.addAchievedComparison(c_1);
                gr.setAction_cost(s_0);
                //System.out.println(gr.getAction_cost());
                frontier.add(new HeuristicSearchNode(gr_new,null, (int) (cost_c_1*gr.getAction_cost()+node.action_cost_to_get_here),0));
                //it.remove();//greedy version
            }else if (cost_c_1 == -1){//meaning that it can be improved but not now (not used for this version)
            }else if (cost_c_1 == Integer.MAX_VALUE){
                //it.remove();
            }
        }
    }
    


    private void update_cost(Conditions c_1, Map<Conditions, Integer> h, int cost_c_1) {
        if (h.get(c_1)==null || h.get(c_1)>cost_c_1){
            h.put(c_1,cost_c_1);
        }
    }


    private int compute_estimated_cost(HeuristicSearchNode node, int max_depth, State s_0, Conditions c_1) throws Exception {
        
        return node.action.getNumberOfExecution(s_0,(Comparison)c_1);
    }


}


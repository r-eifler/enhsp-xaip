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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
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
public class fix_point_based_h1 extends Heuristics {

    private Integer counter;
    private HashMap<Conditions,LinkedHashSet<GroundAction>> poss_contributors;

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
        //poss_contributors = create_poss_contributors();
        //this.build_integer_representation();//this could reduce the number of predicate/comparison but it has been considered useless overhead
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
        do{
            update = false;
            update = update_conditions_values(pool,s_0,this.all_conditions,h);
            if (update){
                update_pool(pool,A1,s_0,h);
                int distance_to_goal = this.check_goal_conditions(s_0, G, h);
                if (distance_to_goal != Integer.MAX_VALUE)
                    return distance_to_goal;
            }
          
        }while(update);

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
                    Logger.getLogger(fix_point_based_h1.class.getName()).log(Level.SEVERE, null, ex);
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
        if (h.get(c.getCounter()) != null && h.get(c.getCounter())<= cost)
            return false;
        h.set(c.getCounter(),cost);
        return true;
    }

    private void update_pool(HashSet<HeuristicSearchNode> pool, LinkedHashSet<GroundAction> A1, State s_0, ArrayList<Integer> h) {
                    //update action precondition
        for (HeuristicSearchNode gr : pool){
                gr.action_cost_to_get_here = compute_precondition_cost(s_0,h,gr.action);
        }
        Iterator it = A1.iterator();
        while (it.hasNext()){
            GroundAction gr = (GroundAction)it.next();
            int cost = compute_precondition_cost(s_0,h,gr);
            if (cost != Integer.MAX_VALUE){
                gr.setAction_cost(s_0);
                pool.add(new HeuristicSearchNode(gr, null, cost, 0));
                it.remove();
            }
        }
    }

    private boolean update_conditions_values(HashSet<HeuristicSearchNode> pool, State s_0, Collection<Conditions> all_conditions, ArrayList<Integer> h) {
        boolean update = false;    
        for (Conditions c: this.all_conditions){
                if (c instanceof Predicate){
                    for (HeuristicSearchNode gr : pool){
                        if (gr.action.achieve((Predicate)c)){
                            if (update_value(h,c,gr.action_cost_to_get_here+1))
                                update = true;
                        }
                    }
                }else if (c instanceof Comparison){
                    for (HeuristicSearchNode gr : pool){
                        int number_of_repetition = gr.action.getNumberOfExecution(s_0,(Comparison)c);
                        if (number_of_repetition != Integer.MAX_VALUE){
                            if (update_value(h,c,gr.action_cost_to_get_here+number_of_repetition))
                                update = true;
                        }
                    }
                }
                
            }
        return update;
    }

    private HashMap<Conditions, LinkedHashSet<GroundAction>> create_poss_contributors() {
        HashMap<Conditions, LinkedHashSet<GroundAction>> ret = new HashMap();
        
        for (Conditions c: this.all_conditions){
            if (c instanceof Predicate){
                for (GroundAction gr: this.A){
                    if (gr.achieve((Predicate)c)){
                        add_achiever((Predicate)c,gr,ret);
                    }
                }
            }else if (c instanceof Comparison){
                for (GroundAction gr: this.A){
                    Comparison comp = (Comparison)c;
                    if (comp.involve(gr.getNumericFluentAffected())){
                        add_numeric_contributors(comp,gr,ret);
                    }
                }
            }
        }
        return ret;
    }

    private void add_achiever(Predicate predicate, GroundAction gr, HashMap<Conditions, LinkedHashSet<GroundAction>> ret) {
        if (ret.get(predicate)==null){
            LinkedHashSet set = new LinkedHashSet();
            set.add(gr);
            ret.put(predicate, set);
        }else{
            LinkedHashSet set = ret.get(predicate);
            set.add(gr);
            ret.put(predicate,set);
        }
    }

    private void add_numeric_contributors(Comparison comp, GroundAction gr, HashMap<Conditions, LinkedHashSet<GroundAction>> ret) {
        
        if (ret.get(comp)==null){
            LinkedHashSet set = new LinkedHashSet();
            set.add(gr);
            ret.put(comp, set);
        }else{
            LinkedHashSet set = ret.get(comp);
            set.add(gr);
            ret.put(comp,set);
        }
        
        HashMap visited = new HashMap();
        Queue<GroundAction> queue = new LinkedList();
        queue.add(gr);
        while(!queue.isEmpty()){
            GroundAction temp = queue.remove();
            visited.put(temp, true);
            for (GroundAction ele:this.A){
                if (visited.get(ele) != null){
                    if (temp.is_influenced_by(ele)){
                        Set s = ret.get(comp);
                        s.add(ele);
                        ret.put(comp, (LinkedHashSet<GroundAction>) s);
                        queue.add(ele);
                    }
                    visited.put(ele, true);
                }
            }
        }
    }

}

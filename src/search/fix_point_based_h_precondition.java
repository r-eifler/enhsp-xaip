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
public class fix_point_based_h_precondition extends fix_point_based_h1 {

    private Integer counter;
    private HashMap<Conditions, LinkedHashSet<GroundAction>> poss_contributors;
    private HashMap<Conditions, Boolean> is_complex;
    private boolean greedy;
    private boolean full_regression = false;
    protected HashMap<GroundAction,LinkedHashSet<Pair<Comparison,Integer>>> rep_costs;
    private boolean explanation_activated=false;
    private HashMap<Pair<GroundAction,Comparison>,Boolean> interact_with;
    private int number_of_conditions_at_this_step;

    public fix_point_based_h_precondition(Conditions G, Set<GroundAction> A) {
        super(G, A);
        this.G = G;
        this.A = (LinkedHashSet<GroundAction>) A;
        //System.out.println(this.orderings);
        //build_integer_representation();
    }

    @Override
    public void setup(State s_0) {

        this.build_integer_representation();//for each proposition and comparison there is a unique integer representation
        influenced_by = computeInflueced_by();
        influence_graph = create_influence_graph();
        this.compute_relevant_actions(s_0);
        A = this.reachable;
        is_complex = identify_complex_conditions();
        //interact_with = new HashMap();
        //generate_update_interactions(A,this.all_conditions);
//        if (!is_complex.keySet().isEmpty())
//            cyclic_task = this.compute_transitive_closure(A);
//        else
//            cyclic_task = false;
//        System.out.println("Acyclity test:"+cyclic_task);

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
        
        int previous_number_of_atoms = index_of_last_static_atom;
        LinkedHashSet<Conditions> all_conditions_temp = new LinkedHashSet(all_conditions);
        generate_repetition_precondition_reset_interaction_value(s_0,A1, (LinkedHashSet) all_conditions_temp);
        number_of_conditions_at_this_step = all_conditions_temp.size();
//        int i=0;
//        for (Conditions c : all_conditions_temp){
//            System.out.println("Condition: "+c+" Counter:"+c.getCounter());
//        }
//        for (GroundAction gr: A1){
//            LinkedHashSet<Pair<Comparison,Integer>> pset = this.rep_costs.get(gr);
//            for (Pair<Comparison,Integer> p : pset){
//                System.out.println("GroundAction of Reference:"+ gr.getName());
//                System.out.println("Condition: "+p.getFirst()+" Counter:"+p.getFirst().getCounter()+" Max Number of times: "+p.getSecond());
//            }
//            
//        }
//        System.exit(-1);
        ArrayList<Integer> h = new ArrayList<Integer>(Collections.nCopies(all_conditions_temp.size()+1, Integer.MAX_VALUE));
        
        init_h(h, all_conditions_temp, s_0);
        Collection<HeuristicSearchNode> pool = new LinkedHashSet();
        init_pool(pool, A1, s_0);
        boolean update;
        do {
            update = update_conditions_values(pool, s_0, all_conditions_temp, h);
            if (update) {
                update_pool(pool, A1, s_0, h);
                if (isGreedy()){
                    int distance_to_goal = this.check_goal_conditions(s_0, G, h);
                    if (distance_to_goal != Integer.MAX_VALUE) {
                        index_of_last_static_atom = previous_number_of_atoms;
                        return distance_to_goal;
                    }
                }
            }

        } while (update);

        index_of_last_static_atom = previous_number_of_atoms;
        
        if (explanation_activated){
            for (Conditions c: all_conditions_temp){
                if (h.get(c.getCounter())==Integer.MAX_VALUE){
                    System.out.println("Condition not reacheable!:"+c+ "(number:"+c.getCounter()+")");
                }
            }
        }
        
        if (!isGreedy()){
                return this.check_goal_conditions(s_0, G, h);
        }
        
        return Integer.MAX_VALUE;
    }
    
    
    public int reacheability(State s_0) {
        //System.out.println("fix point based heuristic");
        this.achievers = new HashMap();
        if (s_0.satisfy(G)) {
            return 0;
        }
        LinkedHashSet<GroundAction> A1 = new LinkedHashSet();
        A1.addAll(this.A);
        ArrayList<Integer> h = new ArrayList<Integer>(Collections.nCopies(index_of_last_static_atom, Integer.MAX_VALUE));
        init_h(h, this.all_conditions, s_0);
        HashSet<HeuristicSearchNode> pool = new HashSet();
        init_pool_reacheability(pool, A1, s_0);
        boolean update;
        do {
            update = update_conditions_values(pool, s_0, this.all_conditions, h);
            if (update) {
                update_pool_reacheability(pool, A1, s_0, h);
            }

        } while (update);
        return this.check_goal_conditions(s_0, G, h);
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

    protected void init_h(ArrayList<Integer> h, Collection<Conditions> conds, State s_0) {
        for (Conditions c_1 : conds) {
            if (c_1.isSatisfied(s_0)) {
                h.set(c_1.getCounter(), 0);
            }
            if (debug >= 2) {
                System.out.println("Condition counter mapping:" + c_1 + " ," + c_1.getCounter());
            }
        }
    }
//

    protected void init_pool(HashSet pool, Collection<GroundAction> A1, State s_0) {
        counter = 0;
        Iterator it = A1.iterator();
        while (it.hasNext()) {
            GroundAction gr = (GroundAction) it.next();
            if (gr.isApplicable(s_0)) {
                gr.setAction_cost(s_0);
                //gr.interact_with = new HashMap();
                reset_interact_with_new_conditions(gr);
                pool.add(new HeuristicSearchNode(gr, null, 0, 0));
                //frontier.add(new HeuristicSearchNode(gr, null, 1, 0));
                it.remove();
                
            }
        }
    }

    protected boolean update_value(ArrayList<Integer> h, Conditions c, int cost) {
        if (h.get(c.getCounter()) != null && h.get(c.getCounter()) <= cost) {
            return false;
        }
        h.set(c.getCounter(), cost);
        return true;
    }

    protected void update_pool(Collection<HeuristicSearchNode> pool, LinkedHashSet<GroundAction> A1, State s_0, ArrayList<Integer> h) {
        //update action precondition
        for (HeuristicSearchNode gr : pool) {
            gr.action_cost_to_get_here = compute_precondition_cost(s_0, h, gr.action);
        }
        Iterator it = A1.iterator();
        while (it.hasNext()) {
            GroundAction gr = (GroundAction) it.next();
            int cost = compute_precondition_cost(s_0, h, gr);
            if (cost != Integer.MAX_VALUE) {
                //gr.interact_with = new HashMap();
                gr.setAction_cost(s_0);
                reset_interact_with_new_conditions(gr);

                pool.add(new HeuristicSearchNode(gr, null, cost, 0));
                it.remove();
            }
        }
    }

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
                                if (this.rep_costs.get(gr.action)!= null){
                                    LinkedHashSet<Pair<Comparison,Integer>> ret = this.rep_costs.get(gr.action);
                                    for (Pair<Comparison,Integer> p :ret){
                                        int rpc = h.get(p.getFirst().getCounter());
                                        //System.out.println("Counter here:"+p.getFirst().getCounter());
                                        if (number_of_repetition > p.getSecond()){
                                            if (h.get(p.getFirst().getCounter())== Integer.MAX_VALUE){
                                                possible_achiever = false;
                                                break;
                                            }else{
                                                additional_cost += Math.max(0,number_of_repetition - p.getSecond()-1)*h.get(p.getFirst().getCounter());
                                            }
                                        }
                                            
                                    }
                                }
                                if (!possible_achiever)
                                    continue;
                                if (this.full_regression){
                                    //System.out.println("Full regression activated");
                                    if (update_value(h, c, number_of_repetition*gr.action_cost_to_get_here+number_of_repetition)) {
                                        update = true;
                                    }                                
                                }else{
                                    if (update_value(h, c, number_of_repetition+gr.action_cost_to_get_here+(int)additional_cost)) {
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

    protected HashMap<Conditions, Boolean> identify_complex_conditions() {
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


    protected int accumulated_value_reacheability(State s_0, Conditions c, Collection<HeuristicSearchNode> pool) {
        RelState rel_state = s_0.relaxState();
        //LinkedList ordered_actions = sort_actions_pool_according_to_cost(pool);
        int cost = 0;
        float current_distance = rel_state.satisfaction_distance((Comparison) c);
        //this terminates correctly whenever the numeric dependency graph is acyclic
        
        LinkedList q = new LinkedList();

        while (true) {
            boolean stop = true;
            q = order_according_to_dependencies(pool,c);
            while (!q.isEmpty()) {
                HeuristicSearchNode gr = (HeuristicSearchNode) q.pollFirst();
                rel_state = gr.action.apply(rel_state);
                float new_dist = rel_state.satisfaction_distance((Comparison) c);
                cost += gr.action_cost_to_get_here + 1;
                if (current_distance > new_dist) {
                    //cost += gr.action_cost_to_get_here + 1;
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

    protected LinkedList sort_actions_pool_according_to_cost(HashSet<HeuristicSearchNode> pool) {
        LinkedList temp = new LinkedList(pool);
        
        if (cyclic_task)
            return temp;
        
        for (HeuristicSearchNode o: pool){
            o.orderings = this.orderings;
        }
       
        Collections.sort(temp, new Comparator<HeuristicSearchNode>() {
            @Override
            public int compare(HeuristicSearchNode o1, HeuristicSearchNode o2) {
                if (o1.action.equals(o2.action))
                    return 0;
                
                if (o1.orderings.contains(new Pair(o1.action,o2.action))){
                    //System.out.println("found");
                    return -1;
                }else
                    return 1; 
            }
        });
        return temp;
    }

    private void update_pool_reacheability(HashSet<HeuristicSearchNode> pool, LinkedHashSet<GroundAction> A1, State s_0, ArrayList<Integer> h) {
        Iterator it = A1.iterator();
        while (it.hasNext()) {
            GroundAction gr = (GroundAction) it.next();
            int cost = compute_precondition_cost(s_0, h, gr);
            if (cost != Integer.MAX_VALUE) {
                gr.setAction_cost(s_0);
                pool.add(new HeuristicSearchNode(gr, null, cost, 0));
                it.remove();
                this.reachable.add(gr);
            }
        }
    }

    private void init_pool_reacheability(HashSet<HeuristicSearchNode> pool, LinkedHashSet<GroundAction> A1, State s_0) {
        counter = 0;
        Iterator it = A1.iterator();
        while (it.hasNext()) {
            GroundAction gr = (GroundAction) it.next();
            if (gr.isApplicable(s_0)) {
                gr.setAction_cost(s_0);
                pool.add(new HeuristicSearchNode(gr, null, 0, 0));
                //frontier.add(new HeuristicSearchNode(gr, null, 1, 0));
                it.remove();
                this.reachable.add(gr);
            }
        }
    }

    

    private LinkedList order_according_to_dependencies(Collection<HeuristicSearchNode> pool, Conditions c) {
        Comparison comp = (Comparison)c;
        LinkedList<HeuristicSearchNode> pq = new LinkedList();
        LinkedList<HeuristicSearchNode> ret = new LinkedList();
        for (HeuristicSearchNode node:pool){
            for (NumFluent nf :comp.getInvolvedFluents()){
                if (node.action.influence(nf)){
                    pq.add(node);
                    //ret.addLast(node);
                }
            }
        }
        
        HashMap<HeuristicSearchNode,Boolean> visited = new HashMap();
        
        while(!pq.isEmpty()){
            HeuristicSearchNode gr = pq.poll();
            ret.addFirst(gr);
            visited.put(gr, true);
            for (HeuristicSearchNode node : pool){
                HeuristicSearchNode gr2 = node;
                if (visited.get(gr2)== null && gr.action.depends_on(gr2.action) && !gr.action.equals(gr2.action)){
                    pq.addLast(gr2);
                }
            }
        }
        
        
        return ret;
        
    }

    private void generate_repetition_precondition_reset_interaction_value(State s_0, LinkedHashSet<GroundAction> A1,LinkedHashSet<Conditions> conditions_set) {
        
        rep_costs = new HashMap();
        //LinkedHashSet<Conditions> new_conditions_set = new LinkedHashSet();
        for (GroundAction gr : A1){
            LinkedHashSet pairs_to_add = new LinkedHashSet();
            if (gr.getPreconditions() == null || gr.getPreconditions().sons.isEmpty())
                continue;
            for (Conditions c : (Collection<Conditions>)gr.getPreconditions().sons){
                if (c instanceof Comparison){
                    Comparison comp = (Comparison)c;
                    float b = comp.eval_affected(s_0,gr);
                    float a = comp.eval_not_affected(s_0, gr);
                    Integer u_b = Integer.MAX_VALUE;
                    if (b < 0){//action has negative effects
                        u_b = (int)Math.ceil(-a/b);
                        Comparison new_comp = new Comparison(comp.getComparator());
                        BinaryOp op = new BinaryOp(comp.getLeft().clone(),"+",new PDDLNumber((u_b+1)*b),true);
                        new_comp.setLeft(op);
                        new_comp.setRight(new PDDLNumber(0));
                        new_comp.normalize();
                        
                        new_comp.setCounter(conditions_set.size()+1);
                        //this.index_of_last_static_atom++;
                        
                        if (!conditions_set.add(new_comp)){
                            for (Conditions c3 : conditions_set){
                                if (c3 instanceof Comparison){
                                    Comparison temp = (Comparison)c3;
                                    if (temp.equals(new_comp)){
                                        new_comp.setCounter(temp.getCounter());
                                    }
                                }
                            }
                        }else{
                            //new_conditions_set.add(new_comp);
                        }
                        Pair<Comparison,Integer> to_add = new Pair(new_comp,u_b);
                        pairs_to_add.add(to_add);
                    }
                }
            }
            
            
            
            rep_costs.put(gr, pairs_to_add);       
        }
        
        //this.generate_update_interactions(A1, new_conditions_set);
        //return rep_costs;
    }

    private void generate_update_interactions(LinkedHashSet<GroundAction> A, Collection<Conditions> all_conditions) {
        for (GroundAction gr: A){
            
            for (Conditions c: all_conditions){
                if (c instanceof Comparison){
                    Comparison comp = (Comparison)c;
                    if (comp.involve(gr.getNumericFluentAffected())){
                        Pair<GroundAction,Comparison> p = new Pair(gr,comp);
                        this.interact_with.put(p, true);
                    }else{
                        Pair<GroundAction,Comparison> p = new Pair(gr,comp);
                        this.interact_with.put(p, false);
                    }
                }
            }
        }
        
    }

    private void reset_interact_with_new_conditions(GroundAction gr) {
        for (int i = this.index_of_last_static_atom + 1; i <= number_of_conditions_at_this_step; i++) {
            gr.interact_with.put(i, null);
        }
    }
 

}

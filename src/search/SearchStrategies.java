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

import computation.NumericPlanningGraph;
import conditions.Conditions;
import conditions.Predicate;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import problem.GroundAction;
import problem.PddlProblem;
import problem.PddlSCProblem;
import problem.State;

/**
 *
 * @author enrico
 */
public class SearchStrategies {
    private int hw=4;
    public static int priority_queue_size;
    private boolean checking_visited=true;
    private Heuristics heuristic;
    private int gw;
    
    public void setup_heuristic(Heuristics input){
        this.heuristic = input;
        setGw(0);
        setHw(1);
        
    }
    
    public LinkedList enforced_hill_climbing(PddlProblem problem) throws Exception{
        long start_global =System.currentTimeMillis();
        LinkedHashSet rel_actions =  new LinkedHashSet(problem.getActions());
        
        heuristic.setup(problem.getInit());

        State current = problem.getInit();
        LinkedList plan = new LinkedList();
        //a = new LinkedHashSet(np.compute_relevant_actions(problem.getInit(), problem.getActions()));
        //System.out.println("Goals:"+problem.getGoals());
        rel_actions = heuristic.reachable;
        System.out.println("All Actions:"+rel_actions.size());

        while (!current.satisfy(problem.getGoals())){
            SearchNode succ = breadth_first_search(current,problem.getGoals(),rel_actions,heuristic);
            if (succ == null){
                System.out.println("No plan exists with EHC");
                return null;
            }
            current = succ.s;
            LinkedList temp = new LinkedList();
            while (succ.father!=null){
                temp.addFirst(succ.action);
                succ = succ.father;
            }
            plan.addAll(temp);
            //System.out.println(plan);
        }
        overall_search_time = System.currentTimeMillis()-start_global;
        return plan;
        
    }
    
    public static int nodes_expanded = 0;
    public SearchNode breadth_first_search(State current, Conditions goals, HashSet actions, Heuristics heuristic) throws Exception {
        HashMap<State,Boolean> visited = new HashMap();
        //System.out.println("Visited size:"+visited.size());
        Deque<SearchNode> frontier = new LinkedList();
        boolean strong_relaxation = false;
        //int current_value = Heuristics.h1_recursion_memoization(current, goals,  actions, new HashMap(), 0, false,null,predAchievers);
        int current_value = heuristic.compute_estimate(current);
        System.out.println("Current Distance:"+current_value);
        SearchNode init = new SearchNode(current,null,null,0,current_value);
        frontier.add(init);
        
        while (!frontier.isEmpty()){
            SearchNode node = frontier.pop();
            nodes_expanded++;
            visited.put(node.s, true);
            for (GroundAction act: (LinkedHashSet<GroundAction>)actions){
                if (act.isApplicable(node.s)){
                    State temp = act.apply(node.s.clone());
                    //act.normalize();
                    if (visited.get(temp) == null){
                        long start = System.currentTimeMillis();
                        int d = heuristic.compute_estimate(temp);
                        heuristic_time+=System.currentTimeMillis()-start;
                        if (d!=Integer.MAX_VALUE && d <= current_value){
                            SearchNode new_node = new SearchNode(temp,act,node,1,d);
                            frontier.addLast(new_node);
                            if (d<current_value){
                                nodes_expanded++;
                                //System.out.println("Expanded:"+nodes_expanded);
                                return new_node;
                            }
                        }
                    }
                }
            }  
        }
        return null;
        
    }
    
    public static long heuristic_time;
    public static long overall_search_time;
    
    public LinkedList wa_star(PddlProblem problem) throws Exception{
        boolean helpful_actions = true;
        
        long start_global =System.currentTimeMillis();
        PriorityQueue<SearchNode> pw = new PriorityQueue();
        State current = (State)problem.getInit();
        //problem.generateActions();
 
        LinkedHashSet rel_actions = new LinkedHashSet(problem.getActions());
        //LinkedHashSet a = new LinkedHashSet(np.compute_relevant_actions(problem.getInit().clone(), problem.getActions()));
        System.out.println("After Reacheability Actions:"+rel_actions.size());

        heuristic.setup(current);
        
        int current_value = heuristic.compute_estimate(current)*getHw();
        
        //int current_value = Heuristics.h1_recursion_memoization(current, problem.getGoals(),  problem.getActions(), new HashMap(), 0, false,null,null)*hw;
        System.out.println("H(s_0,G)=:"+current_value);
        if (current_value == Integer.MAX_VALUE)
            return null;
        SearchNode init = new SearchNode((State)problem.getInit().clone(),null,null,0,current_value);
        pw.add(init);
        HashMap<State,Boolean> visited = new HashMap();
        HashMap<State,Float> cost = new HashMap();
        heuristic_time = 0;
        while (!pw.isEmpty()){
            SearchNode current_node = pw.poll();
            nodes_expanded++;
            priority_queue_size = pw.size();
            //System.out.println("Current Distance:"+current_node.action_cost_to_get_here);
            //System.out.println("Current Cost:"+current_node.action_cost_to_get_here);
            if (current_value > current_node.goal_distance){
                System.out.println("Current Distance:"+current_node.goal_distance);
                current_value = current_node.goal_distance;
            }
            //if (current_node.action!= null)
                //System.out.println("Action:"+current_node.action);
            if (current_node.s.satisfy(problem.getGoals())){
                overall_search_time = System.currentTimeMillis()-start_global;
                return extract_plan(current_node);
            }
            visited.put(current_node.s, Boolean.TRUE);
            for (GroundAction act: (LinkedHashSet<GroundAction>)problem.getActions()){
                if (act.isApplicable(current_node.s)){
                    State temp = act.apply(current_node.s.clone());
                    cost.put(temp,current_node.action_cost_to_get_here+1);

                    //act.normalize();
                    if (visited.get(temp) == null || (visited.get(temp)==true) && (cost.get(temp)>current_node.action_cost_to_get_here)){
                        if (visited.get(temp)!=null){
                            System.out.println("Node re-opening");
                        }
                        long start = System.currentTimeMillis();
                        int d = heuristic.compute_estimate(temp);
                        heuristic_time+=System.currentTimeMillis()-start;
                        //System.out.print(d+" ");
                        if (d!=Integer.MAX_VALUE && ( !helpful_actions ||d <= current_value ) ){
//                        if (d!=Integer.MAX_VALUE && ( d <= current_value ) ){

                            act.setAction_cost(temp);
                            SearchNode new_node = new SearchNode(temp,act,current_node,current_node.action_cost_to_get_here+(int)act.getAction_cost(),d*getHw());
                            //SearchNode new_node = new SearchNode(temp,act,current_node,1,d*hw);
                            pw.add(new_node);
//                            if (new_node.s.satisfy(problem.getGoals()))
//                              return extract_plan(new_node);
                        }
                    }
                }
            }
        }    
        
        return null;
    }
    
    public LinkedList greedy_best_first_search(PddlProblem problem) throws Exception{
        long start_global =System.currentTimeMillis();
        
        //Frontier
        PriorityQueue<SearchNode> frontier = new PriorityQueue();
        State current = (State)problem.getInit();
        heuristic.setup(current);
        System.out.println("|A| (After Relevance Analysis):"+heuristic.reachable.size());
//        rel_actions = (LinkedHashSet) heuristic.compute_relevant_actions(current, problem.getGoals(), rel_actions);
        //heuristic.build_integer_representation(rel_actions, problem.getGoals());
        System.out.println("Computing H1...");
        long start = System.currentTimeMillis();
        int current_value = heuristic.compute_estimate(current);
        
        System.out.println("Initial h1 cost:"+ (System.currentTimeMillis()-start));
        System.out.println("H(s_0,G)=:"+current_value);

        if (current_value == Integer.MAX_VALUE){
            overall_search_time = System.currentTimeMillis()-start_global;
            return null;
        }
        SearchNode init = new SearchNode((State)problem.getInit(),null,null,0,current_value);
        frontier.add(init);
        HashMap<State,Boolean> visited = new HashMap();
//        HashMap<State,Integer> cost = new HashMap();
        heuristic_time = 0;
        while (!frontier.isEmpty()){
            SearchNode current_node = frontier.poll();
            priority_queue_size = frontier.size();
            if (current_value > current_node.goal_distance){
                System.out.println("Current Distance:"+current_node.goal_distance);
                current_value = current_node.goal_distance;
            }
            if (current_node.s.satisfy(problem.getGoals())){
                overall_search_time = System.currentTimeMillis()-start_global;
                return extract_plan(current_node);
            }
            nodes_expanded++;
            if (checking_visited)
                visited.put(current_node.s, Boolean.TRUE);
            for (GroundAction act: heuristic.reachable){
                if (act.isApplicable(current_node.s)){
                    State temp = act.apply(current_node.s.clone());
                    //if (!checking_visited || visited.get(temp) == null){
                    if (visited.get(temp) == null){
                        start = System.currentTimeMillis();
                        int d = heuristic.compute_estimate(temp);
                        heuristic_time+=System.currentTimeMillis()-start;
                        //System.out.print("Exploration:"+d);
                        if (d!=Integer.MAX_VALUE){
                            SearchNode new_node = new SearchNode(temp,act,current_node,(current_node.action_cost_to_get_here+act.getAction_cost())*getGw(),d*getHw());
                            frontier.add(new_node);      
                        }
                    }
                }
            }
        }    
        
        return null;
    }
    
    
   
    
    private static HashMap getAchievers(NumericPlanningGraph np, LinkedHashSet a){
            
            HashMap predAchievers = new HashMap();
        HashMap predDeleters = new HashMap();
        
        for (Object o : np.getFixPoint().getPropositions()) {

            HashSet achievers = new HashSet();
            HashSet deleters = new HashSet();
            for (Object o1 : a) {
                GroundAction gr = (GroundAction) o1;

                if (gr.achieve((Predicate) o)) {
                    achievers.add(gr);
                }
                if (gr.delete((Predicate) o)) {
                    deleters.add(gr);
                }

            }
            predAchievers.put((Predicate) o, achievers);
            predDeleters.put((Predicate) o, deleters);
            //System.out.println(predAchievers.get(o).size());
            //System.out.println(predDeleters.get(o).size());
            
        }
        return predAchievers;
    }
    
    private static LinkedList extract_plan(SearchNode c) {
        LinkedList plan = new LinkedList();
        while(c.action!=null){
            plan.addFirst(c.action);
            c = c.father;
        }
        return plan;
    }

    /**
     * @return the gw
     */
    public int getGw() {
        return gw;
    }

    /**
     * @param gw the gw to set
     */
    public void setGw(int gw) {
        this.gw = gw;
    }

    /**
     * @return the hw
     */
    public int getHw() {
        return hw;
    }

    /**
     * @param hw the hw to set
     */
    public void setHw(int hw) {
        this.hw = hw;
    }
    
}

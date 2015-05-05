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
import problem.PddlSCProblem;
import problem.State;

/**
 *
 * @author enrico
 */
public class SearchStrategies {
    private static int w=4;
    public static int priority_queue_size;
    
    public static LinkedList enforced_hill_climbing(PddlSCProblem problem) throws Exception{
        long start_global =System.currentTimeMillis();

        problem.generateActions();
        NumericPlanningGraph np = new NumericPlanningGraph(); 
        np.goal = problem.getGoals();
        LinkedHashSet a =  new LinkedHashSet(problem.getActions());
        State current = problem.getInit();
        LinkedList plan = new LinkedList();
        a = new LinkedHashSet(np.reacheability(problem.getInit(), problem.getActions()));
        HashMap predAchievers = getAchievers(np,a);
        //System.out.println("Goals:"+problem.getGoals());
        System.out.println("All Actions:"+a.size());
        Heuristics.computeH1(current, problem.getGoals(),  a, new HashMap(), 0, false,null,predAchievers);
        //a = new LinkedHashSet(np.reacheability(problem.getInit(), problem.getActions()));
        //System.out.println("After Reacheability Actions:"+a.size());
        while (!current.satisfy(problem.getGoals())){
            SearchNode succ = breadth_first_search(current,problem.getGoals(),a,predAchievers);
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
    private static SearchNode breadth_first_search(State current, Conditions goals, HashSet actions, HashMap predAchievers) throws Exception {
        HashMap<State,Boolean> visited = new HashMap();
        //System.out.println("Visited size:"+visited.size());
        Deque<SearchNode> frontier = new LinkedList();
        
        int current_value = Heuristics.computeH1(current, goals,  actions, new HashMap(), 0, false,null,predAchievers);
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
                        int d = Heuristics.computeH1(temp, goals,  actions, new HashMap(), 0, false,null,predAchievers);
                        heuristic_time+=System.currentTimeMillis()-start;
                        if (d!=Integer.MAX_VALUE && d <= current_value){
                            SearchNode new_node = new SearchNode(temp,act,node,1,d);
                            frontier.addLast(new_node);
                            if (d<current_value){
                                nodes_expanded++;
                                System.out.println("Expanded:"+nodes_expanded);
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
    
    public static LinkedList wa_star(PddlSCProblem problem,int weight) throws Exception{
        w = weight;
        long start_global =System.currentTimeMillis();
        PriorityQueue<SearchNode> pw = new PriorityQueue();
        State current = (State)problem.getInit();
        problem.generateActions();
        int current_value = Heuristics.computeH1(current, problem.getGoals(),  problem.getActions(), new HashMap(), 0, false,null,null)*w;
        System.out.println("H(s_0,G)=:"+current_value);
        if (current_value == Integer.MAX_VALUE)
            return null;
        SearchNode init = new SearchNode((State)problem.getInit().clone(),null,null,0,current_value);
        pw.add(init);
        HashMap<State,Boolean> visited = new HashMap();
        HashMap<State,Integer> cost = new HashMap();
        heuristic_time = 0;
        while (!pw.isEmpty()){
            SearchNode current_node = pw.poll();
            nodes_expanded++;
            priority_queue_size = pw.size();
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
                    if (visited.get(temp) == null || (visited.get(temp)==true) && (cost.get(temp)>current_node.action_cost_to_get_here+1)){
                        if (visited.get(temp)!=null){
                            System.out.println("Node re-opening");
                        }
                        long start = System.currentTimeMillis();
                        int d = Heuristics.computeH1(temp, problem.getGoals(),  problem.getActions(), new HashMap(), 0, false,null,null);
                        heuristic_time+=System.currentTimeMillis()-start;
                        //System.out.print(d+" ");
                        if (d!=Integer.MAX_VALUE){
                            SearchNode new_node = new SearchNode(temp,act,current_node,current_node.action_cost_to_get_here+1,d*w);
                            //SearchNode new_node = new SearchNode(temp,act,current_node,1,d*w);
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
    
    public static LinkedList greedy_best_first_search(PddlSCProblem problem) throws Exception{
        long start_global =System.currentTimeMillis();
        PriorityQueue<SearchNode> pw = new PriorityQueue();
        State current = (State)problem.getInit();
        problem.generateActions();
        NumericPlanningGraph np = new NumericPlanningGraph();
        np.goal = problem.getGoals();
        LinkedHashSet a = new LinkedHashSet(problem.getActions());
        a = new LinkedHashSet(np.reacheability(problem.getInit().clone(), problem.getActions()));
        System.out.println("After Reacheability Actions:"+a.size());
//        for (Object o: a){
//            System.out.println(o);
//        }
        HashMap predAchievers = getAchievers(np,a);

        int current_value = Heuristics.computeH1(current, problem.getGoals(),  a, new HashMap(), 0, false,null,predAchievers);
        System.out.println("H(s_0,G)=:"+current_value);

        if (current_value == -1)
            return null;
        
        
        SearchNode init = new SearchNode((State)problem.getInit().clone(),null,null,0,current_value);
        pw.add(init);
        HashMap<State,Boolean> visited = new HashMap();
        HashMap<State,Integer> cost = new HashMap();
        heuristic_time = 0;
        while (!pw.isEmpty()){
            SearchNode current_node = pw.poll();
            priority_queue_size = pw.size();
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
            nodes_expanded++;
            visited.put(current_node.s, Boolean.TRUE);
            for (GroundAction act: (LinkedHashSet<GroundAction>)problem.getActions()){
                if (act.isApplicable(current_node.s)){
                    State temp = act.apply(current_node.s.clone());
                    cost.put(temp,current_node.action_cost_to_get_here+1);

                    //act.normalize();
                    if (visited.get(temp) == null){// || (visited.get(temp)==true) && (cost.get(temp)>current_node.action_cost_to_get_here+1)){
                        long start = System.currentTimeMillis();
                        int d = Heuristics.computeH1(temp, problem.getGoals(),  a, new HashMap(), 0, false,null,predAchievers);
                        heuristic_time+=System.currentTimeMillis()-start;
                        //System.out.print(d+" ");
                        if (d!=Integer.MAX_VALUE){
                            SearchNode new_node = new SearchNode(temp,act,current_node,0,d);
                            //SearchNode new_node = new SearchNode(temp,act,current_node,1,d*w);
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
    
}

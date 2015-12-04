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
import conditions.AndCond;
import conditions.Conditions;
import conditions.Predicate;
import expressions.NumEffect;
import expressions.NumFluent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import problem.EPddlProblem;
import problem.GroundAction;
import problem.GroundProcess;
import problem.PddlProblem;
import problem.State;

/**
 *
 * @author enrico
 */
public class SearchStrategies {

    private int hw = 4;
    public static int priority_queue_size;
    private boolean checking_visited = true;
    private Heuristics heuristic;
    private boolean decreasing_heuristic_pruning;
    private int gw;
    public static int states_evaluated;
    private boolean interactive_search_debug = false;
    public boolean json_rep_saving = false;
    public SearchNode search_space_handle;
    private boolean high_verbosity=false;
    public boolean preferred_operators_active = false;
    public boolean processes = true;
    public float delta;

    public void setup_heuristic(Heuristics input) {
        this.setHeuristic(input);
        setGw(0);
        setHw(1);
        setDecreasing_heuristic_pruning(false);
    }

    public LinkedList enforced_hill_climbing(PddlProblem problem) throws Exception {
        long start_global = System.currentTimeMillis();
        LinkedHashSet rel_actions;

        getHeuristic().setup(problem.getInit());
        getHeuristic().preferred_operators = this.preferred_operators_active;

        State current = problem.getInit();

        LinkedList plan = new LinkedList();
        //a = new LinkedHashSet(np.compute_relevant_actions(problem.getInit(), problem.getActions()));
        //System.out.println("Goals:"+problem.getGoals());
        rel_actions = getHeuristic().reachable;
        System.out.println("All Actions:" + rel_actions.size());
        states_evaluated=0;
        while (!current.satisfy(problem.getGoals())) {
            SearchNode succ = breadth_first_search(current, problem.getGoals(), rel_actions, getHeuristic());
            if (succ == null) {
                System.out.println("No plan exists with EHC");
                return null;
            }
            //System.out.println("");
            current = succ.s;
            LinkedList temp = new LinkedList();
            while (succ.father != null) {
                temp.addFirst(succ.action);
                succ = succ.father;  
            }
            plan.addAll(temp);
            //System.out.println(plan);
        }
        overall_search_time = System.currentTimeMillis() - start_global;
        return plan;

    }

    public static int nodes_expanded = 0;

    public SearchNode breadth_first_search(State current, Conditions goals, HashSet actions, Heuristics heuristic) throws Exception {
        HashMap<State, Boolean> visited = new HashMap();
        //System.out.println("Visited size:"+visited.size());
        PriorityQueue<SearchNode> frontier = new PriorityQueue();
        boolean strong_relaxation = false;
        //int current_value = Heuristics.h1_recursion_memoization(current, goals,  actions, new HashMap(), 0, false,null,predAchievers);
        int current_value = heuristic.compute_estimate(current);
        
        LinkedHashSet<GroundAction> branching_actions;
        if (this.preferred_operators_active){
            branching_actions = heuristic.relaxed_plan_actions;
        }else{
            branching_actions = (LinkedHashSet<GroundAction>) actions;
        }
        
        setStates_evaluated(getStates_evaluated() + 1);

        SearchNode init = new SearchNode(current, null, null, 0, current_value);
        frontier.add(init);
                        

        while (!frontier.isEmpty()) {
            SearchNode node = frontier.poll();
            nodes_expanded++;
            visited.put(node.s, true);
            for (GroundAction act : (LinkedHashSet<GroundAction>) branching_actions) {
                if (act.isApplicable(node.s)) {
                    State temp = act.apply(node.s.clone());
                    //act.normalize();
                    if (visited.get(temp) == null) {
                        long start = System.currentTimeMillis();
                        int d = heuristic.compute_estimate(temp);
                        heuristic_time += System.currentTimeMillis() - start;
                        //System.out.println("try");
                        setStates_evaluated(getStates_evaluated() + 1);
                        if (d != Integer.MAX_VALUE){// && d <= current_value) {
                            SearchNode new_node = new SearchNode(temp, act, node, node.action_cost_to_get_here+1, 0);
                            frontier.add(new_node);
                            if (d < current_value) {
                                nodes_expanded++;

                                System.out.println("Distance:"+d);
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

    public LinkedList wa_star(PddlProblem problem) throws Exception {

        long start_global = System.currentTimeMillis();
        PriorityQueue<SearchNode> frontier = new PriorityQueue();
        State current = (State) problem.getInit();
        //problem.generateActions();

        LinkedHashSet rel_actions = new LinkedHashSet(problem.getActions());
        //LinkedHashSet a = new LinkedHashSet(np.compute_relevant_actions(problem.getInit().clone(), problem.getActions()));
        System.out.println("After Reacheability Actions:" + rel_actions.size());

        getHeuristic().setup(current);
        System.out.println("After Reacheability Actions:" + getHeuristic().reachable.size());
        int current_value = getHeuristic().compute_estimate(current) * getHw();

        //int current_value = Heuristics.h1_recursion_memoization(current, problem.getGoals(),  problem.getActions(), new HashMap(), 0, false,null,null)*hw;
        System.out.println("H(s_0,G)=:" + current_value);
        if (current_value == Integer.MAX_VALUE) {
            return null;
        }
        SearchNode init = new SearchNode((State) problem.getInit().clone(), null, null, 0, current_value, this.json_rep_saving);
        if (json_rep_saving) {
            search_space_handle = init;
        }
        frontier.add(init);
        HashMap<State, Boolean> visited = new HashMap();
        HashMap<State, Float> cost = new HashMap();
        heuristic_time = 0;
        while (!frontier.isEmpty()) {
            SearchNode current_node = frontier.poll();
            if (json_rep_saving) {
                current_node.set_visited(nodes_expanded);
            }

            nodes_expanded++;
            priority_queue_size = frontier.size();
            //System.out.println("Current Distance:"+current_node.action_cost_to_get_here);
            //System.out.println("Current Cost:"+current_node.action_cost_to_get_here);
            if (current_value > current_node.goal_distance) {
                System.out.println("Current Distance:" + current_node.goal_distance);
                current_value = current_node.goal_distance;
            }
//            if (current_node.action!= null)
//                System.out.println("Action:"+current_node.action);
            if (current_node.s.satisfy(problem.getGoals())) {
                overall_search_time = System.currentTimeMillis() - start_global;
                return extract_plan(current_node);
            }

            visited.put(current_node.s, Boolean.TRUE);
            for (GroundAction act : getHeuristic().reachable) {
                if (act.isApplicable(current_node.s)) {
                    State temp = act.apply(current_node.s.clone());
                    //act.normalize();
                    boolean to_visit = true;
                    if (visited.get(temp) != null) {
                        if (cost.get(temp) != null) {
                            if (!(cost.get(temp) > current_node.action_cost_to_get_here + 1)) {
                                to_visit = false;
                            }
                        }
                    }

                    if (to_visit) {
                        cost.put(temp, current_node.action_cost_to_get_here + 1);
                        setStates_evaluated(getStates_evaluated() + 1);

                        long start = System.currentTimeMillis();
                        int d = getHeuristic().compute_estimate(temp);
                        heuristic_time += System.currentTimeMillis() - start;
                        //System.out.print(d+" ");
                        if (d != Integer.MAX_VALUE && (!this.isDecreasing_heuristic_pruning() || d <= current_value)) {
//                        if (d!=Integer.MAX_VALUE && ( d <= current_value ) ){
                            act.setAction_cost(temp);
                            SearchNode new_node = new SearchNode(temp, act, current_node, current_node.action_cost_to_get_here + (int) act.getAction_cost(), d * getHw(), this.json_rep_saving);
                            //SearchNode new_node = new SearchNode(temp,act,current_node,1,d*hw);
                            if (json_rep_saving) {
                                current_node.add_descendant(new_node);
                            }
                            frontier.add(new_node);
//                            if (new_node.s.satisfy(problem.getGoals()))
//                              return extract_plan(new_node);
                        }
                    }
                }
            }
        }

        return null;
    }

    public LinkedList blindSearch(EPddlProblem problem) throws Exception {

        long start_global = System.currentTimeMillis();
        PriorityQueue<SearchNode> frontier = new PriorityQueue();
        State current = (State) problem.getInit();
        //problem.generateActions();

        LinkedHashSet rel_actions = new LinkedHashSet(problem.getActions());
        //LinkedHashSet a = new LinkedHashSet(np.compute_relevant_actions(problem.getInit().clone(), problem.getActions()));
        

        getHeuristic().setup(current);
        System.out.println("After Reacheability Actions:" + getHeuristic().reachable.size());
        int current_value = 0;
        SearchNode init = new SearchNode((State) problem.getInit().clone(), null, null, 0, current_value, this.json_rep_saving);
        if (json_rep_saving) {
            search_space_handle = init;
        }
        frontier.add(init);
        HashMap<State, Boolean> visited = new HashMap();
        HashMap<State, Float> cost = new HashMap();
        heuristic_time = 0;
        while (!frontier.isEmpty()) {
            SearchNode current_node = frontier.poll();
            if (json_rep_saving) {
                current_node.set_visited(nodes_expanded);
            }

            nodes_expanded++;
            priority_queue_size = frontier.size();
            //System.out.println("Current Distance:"+current_node.action_cost_to_get_here);
            //System.out.println("Current Cost:"+current_node.action_cost_to_get_here);
            if (current_value > current_node.goal_distance) {
                System.out.println("Current Distance:" + current_node.goal_distance);
                current_value = current_node.goal_distance;
            }
//            if (current_node.action!= null)
//                System.out.println("Action:"+current_node.action);
            if (current_node.s.satisfy(problem.getGoals())) {
                overall_search_time = System.currentTimeMillis() - start_global;
                return extract_plan(current_node);
            }

            visited.put(current_node.s, Boolean.TRUE);
            if (processes){
                advance_time(getHeuristic(),frontier,current_node,problem);
            }
            for (GroundAction act : getHeuristic().reachable) {
                if (act instanceof GroundProcess)
                    continue;
                if (act.isApplicable(current_node.s)) {
                    State temp = act.apply(current_node.s.clone());
                    //act.normalize();
                    boolean to_visit = true;
                    if (visited.get(temp) != null) {
                        if (cost.get(temp) != null) {
                            if (!(cost.get(temp) > current_node.action_cost_to_get_here + 1)) {
                                to_visit = false;
                            }
                        }
                    }

                    if (to_visit) {
                        cost.put(temp, current_node.action_cost_to_get_here + 1);
                        setStates_evaluated(getStates_evaluated() + 1);

                        //System.out.print(d+" ");
//                        if (d!=Integer.MAX_VALUE && ( d <= current_value ) ){
                            act.setAction_cost(temp);
                            SearchNode new_node = new SearchNode(temp, act, current_node, current_node.action_cost_to_get_here + (int) act.getAction_cost(), 0, this.json_rep_saving);
                            //SearchNode new_node = new SearchNode(temp,act,current_node,1,d*hw);
                            if (json_rep_saving) {
                                current_node.add_descendant(new_node);
                            }
                            frontier.add(new_node);
//                            if (new_node.s.satisfy(problem.getGoals()))
//                              return extract_plan(new_node);
                        
                    }
                }
            }
        }

        return null;
    }

    public LinkedList greedy_best_first_search(EPddlProblem problem) throws Exception {
        long start_global = System.currentTimeMillis();

        //Frontier
        PriorityQueue<SearchNode> frontier = new PriorityQueue();
        State current = (State) problem.getInit();
        getHeuristic().setup(current);
        System.out.println("|A| (After Relevance Analysis):" + getHeuristic().reachable.size());
        
//        rel_actions = (LinkedHashSet) heuristic.compute_relevant_actions(current, problem.getGoals(), rel_actions);
        //heuristic.build_integer_representation(rel_actions, problem.getGoals());
        System.out.println("Computing H1...");
        long start = System.currentTimeMillis();
        int current_value = getHeuristic().compute_estimate(current);
        setStates_evaluated(0);
        System.out.println("Initial h1 cost:" + (System.currentTimeMillis() - start));
        System.out.println("H(s_0,G)=:" + current_value);

        if (current_value == Integer.MAX_VALUE) {
            overall_search_time = System.currentTimeMillis() - start_global;
            return null;
        }
        SearchNode init = new SearchNode((State) problem.getInit(), null, null, 0, current_value, json_rep_saving);
        if (json_rep_saving) {
            search_space_handle = init;
        }
        frontier.add(init);
        
        HashMap<State, Boolean> visited = new HashMap();
//        HashMap<State,Integer> cost = new HashMap();
        heuristic_time = 0;
        int time = 0;
        while (!frontier.isEmpty()) {
            SearchNode current_node = frontier.poll();
            if (json_rep_saving) {
                current_node.set_visited(nodes_expanded);
            }

            nodes_expanded++;
            priority_queue_size = frontier.size();
            if (current_node.action != null && interactive_search_debug) {
                System.out.println("Action:" + current_node.action);
                System.out.println("Current Distance:" + current_node.goal_distance);
                System.out.println("Current Frontier:");
//                for (SearchNode sn : frontier) {
//                    System.out.println("Node:" + sn.action + " Distance to Goal:" + sn.goal_distance);
//                }
                System.in.read();
            }
            if (current_value > current_node.goal_distance) {
                System.out.println("Current Distance:" + current_node.goal_distance);
                current_value = current_node.goal_distance;
            }
            if (current_node.s.satisfy(problem.getGoals())) {
                overall_search_time = System.currentTimeMillis() - start_global;
                return extract_plan(current_node);
            }

            if (nodes_expanded % 10000 == 0) {
                System.out.println("Stats so far. Expanded nodes:" + nodes_expanded + " States Evaluated:" + this.getStates_evaluated());
            }
            if (checking_visited) {
                visited.put(current_node.s, Boolean.TRUE);
            }
            if (processes){
                advance_time(getHeuristic(),frontier,current_node,problem);
            }
            for (GroundAction act : getHeuristic().reachable) {
                if (act instanceof GroundProcess)
                    continue;
                if (act.isApplicable(current_node.s)) {                   
                    State temp = act.apply(current_node.s.clone());
                    //if (!checking_visited || visited.get(temp) == null){
                    if (visited.get(temp) == null && temp.satisfy(problem.globalConstraints)) {
                        setStates_evaluated(getStates_evaluated() + 1);
                        start = System.currentTimeMillis();
                        int d = getHeuristic().compute_estimate(temp);
                        heuristic_time += System.currentTimeMillis() - start;
                        //System.out.print("Reacheable Conditions:"+reacheable_conditions);
                        act.setAction_cost(temp);
                        if (d != Integer.MAX_VALUE && (!this.isDecreasing_heuristic_pruning() || d <= current_value)) {
                            SearchNode new_node = new SearchNode(temp, act, current_node, (current_node.action_cost_to_get_here + (int) act.getAction_cost())*this.getGw() , d * getHw(), json_rep_saving);
                            frontier.add(new_node);
                            //frontier.add(new_node);  //this can be substituted by looking whether the element was already present. In that case its weight has to be updated
                            if (json_rep_saving) {
                                current_node.add_descendant(new_node);
                            }

                        }
                    }
                }
            }
        }

        return null;
    }

    private static HashMap getAchievers(NumericPlanningGraph np, LinkedHashSet a) {

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
        while (c.action != null) {
            c.action.time = c.s.functionValue(new NumFluent("time_elapsed")).getNumber();
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

    /**
     * @return the decreasing_heuristic_pruning
     */
    public boolean isDecreasing_heuristic_pruning() {
        return decreasing_heuristic_pruning;
    }

    /**
     * @param decreasing_heuristic_pruning the decreasing_heuristic_pruning to
     * set
     */
    public void setDecreasing_heuristic_pruning(boolean decreasing_heuristic_pruning) {
        this.decreasing_heuristic_pruning = decreasing_heuristic_pruning;
    }

    /**
     * @return the heuristic
     */
    public Heuristics getHeuristic() {
        return heuristic;
    }

    /**
     * @param heuristic the heuristic to set
     */
    public void setHeuristic(Heuristics heuristic) {
        this.heuristic = heuristic;
    }

    /**
     * @return the states_evaluated
     */
    public int getStates_evaluated() {
        return states_evaluated;
    }

    /**
     * @param states_evaluated the states_evaluated to set
     */
    public void setStates_evaluated(int states_evaluated) {
        this.states_evaluated = states_evaluated;
    }

    private void advance_time(Heuristics heuristic, PriorityQueue<SearchNode> frontier, SearchNode current_node,EPddlProblem problem) throws Exception {
        try {
            GroundProcess waiting = new GroundProcess("waiting");
            waiting.setNumericEffects(new AndCond());
            waiting.setPreconditions(new AndCond());
            waiting.add_time_effects(delta);
            for (GroundAction act: getHeuristic().reachable){
                
                if (act instanceof GroundProcess){
                    GroundProcess gp = (GroundProcess)act;
                    
                    if (gp.isActive(current_node.s)){
                        AndCond precondition = (AndCond)waiting.getPreconditions();
                        precondition.addConditions(gp.getPreconditions());
                        for (NumEffect eff: gp.getNumericEffectsAsCollection()){
                            waiting.add_numeric_effect(eff);
                        }
                        waiting.setPreconditions(precondition);
                    }
                }
            }
            
            
            State temp = waiting.apply(current_node.s.clone());
            if (temp.satisfy(problem.globalConstraints)) {
                setStates_evaluated(getStates_evaluated() + 1);
                long start = System.currentTimeMillis();
                int d = 0;
                if (this.getHw()!=0)
                        d = getHeuristic().compute_estimate(temp);
                heuristic_time += System.currentTimeMillis() - start;
                //System.out.print("Reacheable Conditions:"+reacheable_conditions);
                if (d != Integer.MAX_VALUE) {
                    waiting.setAction_cost(temp);
                    SearchNode new_node = new SearchNode(temp, waiting, current_node, (current_node.action_cost_to_get_here + (int) waiting.getAction_cost())*0, d * getHw(), this.json_rep_saving);

                    frontier.add(new_node);
                    //frontier.add(new_node);  //this can be substituted by looking whether the element was already present. In that case its weight has to be updated
                    if (json_rep_saving) {
                        current_node.add_descendant(new_node);
                    }
                    
                }
            }
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(SearchStrategies.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
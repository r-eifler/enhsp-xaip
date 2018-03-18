/* 
 * Copyright (C) 2010-2017 Enrico Scala. Contact: enricos83@gmail.com.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package search;

import com.carrotsearch.hppc.ObjectFloatHashMap;
import heuristics.Heuristic;
import conditions.AndCond;
import conditions.Condition;
import expressions.NumEffect;
import it.unimi.dsi.fastutil.objects.ObjectHeapPriorityQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import problem.EPddlProblem;
import problem.GroundAction;
import problem.GroundEvent;
import problem.GroundProcess;
import problem.PDDLState;
import problem.State;

/**
 *
 * @author enrico
 */
public class SearchStrategies {

    private float hw = 4;
    public int priority_queue_size;
    private Heuristic heuristic;
    private boolean decreasing_heuristic_pruning = false;
    private float gw;
    public int states_evaluated;
    public boolean json_rep_saving = false;
    public SearchNode search_space_handle;
    public boolean preferred_operators_active = false;
    public boolean processes = false;
    public float delta;
    public long depth_limit = Long.MAX_VALUE;
    public int num_dead_end_detected;
    public int number_duplicates;

    public boolean breakties_on_larger_g = false;
    public boolean breakties_on_smaller_g = false;

    public boolean bfs = true;
    static public int node_reopened;
    public boolean cost_optimal;
    public Condition goal;
    ObjectFloatHashMap<State> g = new ObjectFloatHashMap();

    private boolean optimality = true;
    private Collection<GroundProcess> reachable_processes;
    private Collection<GroundEvent> reachable_events;
    private Collection<GroundAction> reachable_actions;

    public float delta_max;
    public int constraints_violations;
    public boolean helpful_actions_pruning;
    public int debug;
    public boolean json_eco_rep_saving;
    public float current_g;
    public boolean forgetting_ehc = false;
    private float G_DEFAULT = -1;

    private void set_reachable_actions(EPddlProblem problem) {

        reachable_actions = new LinkedHashSet();

        Set<GroundAction> to_consider;
        if (helpful_actions_pruning) {
            System.out.println("Only Helpful Actions");
            to_consider = new HashSet(getHeuristic().helpful_actions);
        } else {
            System.out.println("Take all reachable actions");
            to_consider = getHeuristic().reachable;
        }
        for (GroundAction gr : to_consider) {
            Iterator<GroundAction> it = problem.getActions().iterator();
            while (it.hasNext()) {
                GroundAction gr2 = it.next();
                if (gr.equals(gr2)) {
                    reachable_actions.add(gr2);
                }
            }
        }
    }

    private void set_reachable_processes_events(EPddlProblem problem) {
        reachable_processes = new LinkedHashSet();
        reachable_events = new LinkedHashSet();

        Set<GroundAction> to_consider;
//        if (only_relaxed_plan_actions)
//            to_consider = getHeuristic().relaxed_plan_actions;
//        else
        to_consider = getHeuristic().reachable;

        for (GroundAction gr3 : to_consider) {
            if (!(gr3 instanceof GroundProcess)) {
                continue;
            }
            GroundProcess gr = (GroundProcess) gr3;
            Iterator<GroundProcess> it = problem.processesSet.iterator();
            while (it.hasNext()) {
                GroundProcess gr2 = it.next();
                if (gr.equals(gr2)) {
                    reachable_processes.add(gr2);
                }
            }
        }
        for (GroundAction gr3 : to_consider) {
            if (!(gr3 instanceof GroundEvent)) {
                continue;
            }
            GroundEvent gr = (GroundEvent) gr3;
            Iterator<GroundEvent> it = problem.eventsSet.iterator();
            while (it.hasNext()) {
                GroundEvent gr2 = it.next();
                if (gr.equals(gr2)) {
                    reachable_events.add(gr2);
                }
            }
        }
    }

    private void setup_reachable_actions_processes(EPddlProblem problem) {
        set_reachable_actions(problem);
        set_reachable_processes_events(problem);
        System.out.println("Actions used at init:" + reachable_actions.size());
    }

    /*
    Very Important and Experimental. In this case the successor is a list of waiting action. This is needed so as to retrieve it afterwards
     */
    private boolean queue_successor(Object frontier, State successor_state, SearchNode current_node, Object action_s, float prev_cost, float succ_g) {

        if (prev_cost == this.G_DEFAULT || succ_g < prev_cost) {
//            System.out.println(prev_cost);
//            System.out.println(succ_g);
            setStates_evaluated(getStates_evaluated() + 1);
            long start = System.currentTimeMillis();
            Float d = getHeuristic().compute_estimate(successor_state);
            heuristic_time += System.currentTimeMillis() - start;
            if (d != Float.MAX_VALUE && (d + succ_g) < this.depth_limit) {
                SearchNode new_node = null;
                if (action_s instanceof Collection) {
                    new_node = new SearchNode(successor_state, (ArrayList<GroundAction>) action_s, current_node, succ_g, d, this.json_rep_saving, this.gw, this.hw);
                } else {
                    GroundAction gr = (GroundAction) action_s;
                    new_node = new SearchNode(successor_state, gr, current_node, succ_g, d, this.json_rep_saving, this.gw, this.hw);
                }
                if (this.helpful_actions_pruning) {
                    new_node.relaxed_plan_from_heuristic = getHeuristic().helpful_actions;
                }
                if (json_rep_saving) {
                    current_node.add_descendant(new_node);
                }
                add_frontier(frontier, new_node);
                g.put(successor_state, succ_g);
                return true;
            } else {
                num_dead_end_detected++;
                return false;
            }
        } else {
            number_duplicates++;
            return false;
        }
    }

    private boolean queue_successor(Object frontier, State successor_state, SearchNode current_node, Object action_s) {
        float succ_g = current_node.g_n + 1;
        float prev_cost = g.getOrDefault(successor_state,this.G_DEFAULT);
//        System.out.println("G:"+g.keySet());
//        System.out.println("Current State:"+successor_state);
//        System.out.println("Cost: "+prev_cost);
        //The node is put in the priority queue whenever one of the following holds
        //if prev_cost == null, then I have never seen this state before
        // if the new cost is better (which can happen in case of inconsistent heuristics or new state evaluation from some other paths
        return this.queue_successor(frontier, successor_state, current_node, action_s, prev_cost, succ_g);
    }

    private ArrayList<GroundEvent> apply_events(State s, float delta1) throws CloneNotSupportedException {
        ArrayList<GroundEvent> ret = new ArrayList();
        while (true) {
            boolean at_least_one = false;
            for (GroundEvent ev : this.reachable_events) {

                if (ev.isApplicable(s)) {
                    at_least_one = true;
                    s.apply(ev);
                    GroundEvent ev1 = (GroundEvent) ev.clone();
                    ev1.time = delta1;
                    ret.add(ev1);

                }
            }
            if (!at_least_one) {
                return ret;
            }
        }

    }

    private void add_frontier(Object frontier, SearchNode new_node) {

        //frontier.
//        frontier.re
        if (frontier instanceof Queue)
            ((Queue)frontier).add(new_node);
        else if (frontier instanceof ObjectHeapPriorityQueue){
            
            ((ObjectHeapPriorityQueue)frontier).enqueue(new_node);
        }

    }

    public List a_star(EPddlProblem problem) throws Exception {
        this.gw = 1f;
        this.hw = 1f;
        return this.wa_star(problem);
    }

    public class FrontierOrder implements Comparator<SearchNode> {

        Heuristic h;

        public FrontierOrder(Heuristic h) {
            super();
            this.h = h;
        }

        public FrontierOrder() {
            super();
            this.h = null;
        }

        @Override
        public int compare(SearchNode o1, SearchNode o2) {
            final SearchNode other = (SearchNode) o2;
            final SearchNode a = o1;
            if (a.f == other.f) {
                if (breakties_on_larger_g) {
//                System.out.println(this.g_n);
                    if (a.g_n < other.g_n)//goal is farer
                    {
                        return +1;
                    } else if (a.g_n > other.g_n) //goal is closer
                    {
                        return -1;
                    } else {
                        return 0;
                    }
                } else if (breakties_on_smaller_g) {
                    if (a.g_n < other.g_n)//goal is farer
                    {
                        return -1;
                    } else if (a.g_n > other.g_n) //goal is closer
                    {
                        return +1;
                    } else {
                        return 0;
                    }
                } else {
                    return 0;
                }
            }
            if (bfs) {
                if (a.f <= other.f) {
                    return -1;
                } else {
                    return 1;
                }
            } else//dfs
            {
                if (a.f <= other.f) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }

    }

    public void setup_heuristic(Heuristic input) {
        this.setHeuristic(input);
        set_w_g(0);
        set_w_h(1);
        //horizon = Float.MAX_VALUE;
        setDecreasing_heuristic_pruning(false);
    }

    public LinkedList enforced_hill_climbing(EPddlProblem problem) throws Exception {
        long start_global = System.currentTimeMillis();

        getHeuristic().setup(problem.getInit());
        setup_reachable_actions_processes(problem);
        setStates_evaluated(getStates_evaluated() + 1);

        State current = problem.getInit();

        LinkedList plan = new LinkedList();
        //a = new LinkedHashSet(np.compute_relevant_actions(problem.getInit(), problem.getActions()));
        //System.out.println("Goals:"+problem.getGoals());
//        rel_actions = getHeuristic().reachable;
        states_evaluated = 0;
        HashMap<State, Boolean> visited = new HashMap();

        while (true) {
            Boolean b = problem.goalSatisfied(current);

            if (b == null) {
                return null;
            }
            if (b) {
                break;
            }

            SearchNode succ = breadth_first_search(current, (EPddlProblem) problem, visited);

            if (succ == null) {
                System.out.println("No plan exists with EHC");
                return null;
            }

            current = succ.s;
//            System.out.println(current);

            if (this.helpful_actions_pruning) {
                reachable_actions = new LinkedHashSet(succ.relaxed_plan_from_heuristic);
            }
            plan.addAll(extract_plan(succ));
            //System.out.println(plan);
            if (forgetting_ehc) {
                visited = new HashMap();
            }
        }
        overall_search_time = System.currentTimeMillis() - start_global;
        return plan;

    }

    public static int nodes_expanded = 0;

    public SearchNode breadth_first_search(State current, EPddlProblem problem, HashMap<State, Boolean> visited) throws Exception {
        //System.out.println("Visited size:"+visited.size());

        Queue<SearchNode> frontier = new LinkedList();
        Float current_value = heuristic.compute_estimate(current);

        SearchNode init = new SearchNode(current, null, null, 0, current_value);
        frontier.add(init);
        if (this.helpful_actions_pruning) {
            init.relaxed_plan_from_heuristic = getHeuristic().helpful_actions;
        }
//        System.out.println(init.relaxed_plan_from_heuristic);
        System.out.println("h(n):" + current_value + " ");
        float current_gn = 0;
        while (!frontier.isEmpty()) {
            SearchNode node = frontier.poll();
            nodes_expanded++;
            if (node.g_n > current_gn) {
                System.out.println(" " + node.g_n);
                current_gn = node.g_n;

            }
            if (this.helpful_actions_pruning) {
                reachable_actions = node.relaxed_plan_from_heuristic;
            }

            if (processes) {
                //System.out.println("Enforced Hill Climbing not supporting autonomous processes yet");
                advance_time(frontier, node, (EPddlProblem) problem);
                //System.exit(-1);
            }
            for (GroundAction act : reachable_actions) {
                if ((act instanceof GroundProcess) || (act instanceof GroundEvent)) {
                    continue;
                }
                if (act.isApplicable(node.s)) {
                    State temp = (State) node.s.clone();
                    temp.apply(act);
//                    System.out.println("Depth:"+node.g_n);
                    //act.normalize();
                    if (!temp.satisfy(problem.globalConstraints)) {
                        continue;
                    }
                    if (visited.get(temp) == null) {
                        visited.put(node.s, true);
                        Float newG = heuristic.gValue(node.s, act, temp, node.g_n);
                        if (newG == null) {
                            continue;
                        }
                        long start = System.currentTimeMillis();
                        Float d = heuristic.compute_estimate(temp);
                        heuristic_time += System.currentTimeMillis() - start;
                        //System.out.println("try");
                        setStates_evaluated(getStates_evaluated() + 1);
                        if (d != Float.MAX_VALUE) {// && d <= current_value) {

                            SearchNode new_node = new SearchNode(temp, act, node, newG, 0);
                            frontier.add(new_node);
                            if (this.helpful_actions_pruning) {
                                new_node.relaxed_plan_from_heuristic = heuristic.helpful_actions;
                            }
                            if (d < current_value) {
                                nodes_expanded++;
                                System.out.println("h(n):" + d);
                                return new_node;
                            }
                        } else {
                            num_dead_end_detected++;
                        }
                    }
                }
            }
        }
        return null;

    }

    public static long heuristic_time;
    public static long overall_search_time;

    /**
     * The method implements weighted-A*-like search algorithms systematically.
     *
     * Solve the problem by using weighted-A* or A* or Uniform Cost Search (UCS)
     * depending on the evaluation function f the frontier is prioritized by,
     * where f = wg * g(n) + wh * h(n) wg = 1, wh = 0, UCS, wg = 1, wh = 1, A*,
     * wg = 1, wh > 1, weighted-A*. The weights wg and wh should be set by
     * SearchStrategies.set_w_g() and SearchStrategies.set_w_h() before the
     * method is called. Heuristics function should also be setup.
     *
     * @param problem the problem to be solved.
     * @return null if the problem is unsolvable, a linked list of the plan
     * otherwise.
     * @throws Exception
     */
    public LinkedList wa_star(EPddlProblem problem) throws Exception {
        num_dead_end_detected = 0;

        long start_global = System.currentTimeMillis();
        ObjectHeapPriorityQueue<SearchNode> frontier = new ObjectHeapPriorityQueue(new FrontierOrder());
        if (!problem.getInit().satisfy(problem.globalConstraints)) {
            System.out.println("Initial State is not valid");
            return null;
        }
        constraints_violations = 0;
        if (getHeuristic().setup(problem.getInit()) == Float.MAX_VALUE) {
            System.out.println("h(n = s_0)=inf");
            return null;
        }
        System.out.println("Reachable actions and processes: |A U P U E|:" + getHeuristic().reachable.size());

        Float current_value = getHeuristic().compute_estimate(problem.getInit());
        setup_reachable_actions_processes(problem);//this maps actions in the heuristic with the action in the execution model

        getHeuristic().why_not_active = true;

        System.out.println("h(n = s_0)=" + current_value);//debugging information

        getHeuristic().why_not_active = false;

        SearchNode init = new SearchNode((State) problem.getInit().clone(), 0, current_value, this.json_rep_saving, this.gw, this.hw);
        if (this.helpful_actions_pruning) {
            System.out.println("Selection actions from the helpful actions list");
            init.relaxed_plan_from_heuristic = getHeuristic().helpful_actions;
        }

        if (json_rep_saving) {
            search_space_handle = init;//this needs to have an handle on the initial state for saving it into a json file
        }

        if (current_value == Float.MAX_VALUE) {//this shouldn't happen here.
            num_dead_end_detected++;
            return null;
        }

        frontier.enqueue(init);
        heuristic_time = 0;
        number_duplicates = 0;
        node_reopened = 0;
        current_g = 0f;
        g.put(problem.getInit(), 0f);//The initial state is at 0 distance, of course.
        float bestf = 0;
        nodes_expanded = 0;
        this.setStates_evaluated(0);
        while (!frontier.isEmpty()) {
            final SearchNode current_node = frontier.dequeue();

            if (current_node.g_n >= depth_limit) {
                overall_search_time = System.currentTimeMillis() - start_global;
                continue;
            }
            if (json_rep_saving) {
                current_node.set_visited(nodes_expanded);
            }

            final float previous_g = g.get(current_node.s);
            final float g_node = current_node.g_n;

            if (g_node == previous_g) {
                if (optimality && (bestf < current_node.g_n + current_node.h_n)) {//this is the debug for when the planner is run in optimality modality
                    bestf = current_node.g_n + current_node.h_n;
                    System.out.println("f(n) = " + bestf + " (Expanded Nodes: " + nodes_expanded
                            + ", Evaluated States: " + states_evaluated + ", Time: " + (float) ((System.currentTimeMillis() - start_global)) / 1000.0 + ")");

                }
                if (!optimality && current_value > current_node.h_n) {
                    System.out.println(" g(n)= " + current_node.g_n + " h(n)=" + current_node.h_n);
                    current_value = current_node.h_n;
                    current_g = current_node.g_n;
                }

                if (debug == 20 && nodes_expanded % 5000 == 0) {
                    System.out.println("Expanded Nodes / sec:" + (new Float(nodes_expanded) * 1000.0 / ((System.currentTimeMillis() - start_global))));
                }

                priority_queue_size = frontier.size();
                final Boolean res = problem.goalSatisfied(current_node.s);
                if (res == null) {//this means it is a dead-end
                    num_dead_end_detected++;
                    continue;
                }
                nodes_expanded++;
                if (res) {
                    overall_search_time = System.currentTimeMillis() - start_global;
                    current_g = current_node.g_n;
                    return extract_plan(current_node);
                }

                //if we have a pddl+ problem, we also branch on waiting.
                if (processes) {
                    advance_time(frontier, current_node, problem);
                }

                //In case we use helpful actions pruning. This is highly experimental, though it seems to work pretty well...
                if (this.helpful_actions_pruning) {
                    reachable_actions = current_node.relaxed_plan_from_heuristic;
                }

                for (final GroundAction act : reachable_actions) {
                    if ((act instanceof GroundProcess) || (act instanceof GroundEvent)) {
                        continue;
                    }
                    if (act.isApplicable(current_node.s)) {
                        final State successor_state = current_node.s.clone();
                        successor_state.apply(act);
//                        act.set_unit_cost(successor_state);
//                        System.out.println(act);

                        //skip this if violates global constraints
                        if (!successor_state.satisfy(problem.globalConstraints)) {
                            continue;
                        }
                        final Float succ_g = this.heuristic.gValue(current_node.s, act, successor_state, current_node.g_n);
                        if (succ_g == null) {
                            this.num_dead_end_detected++;
                            continue;
                        }
                        final float prev_cost = g.getOrDefault(successor_state,G_DEFAULT);
                        this.queue_successor(frontier, successor_state, current_node, act, prev_cost, succ_g);

                    }
                }
            }
        }

        return null;
    }

    /**
     * This function implements UCS as for Felner's paper SOCS 2011. It can also
     * be used in a depth first search manner (going towards the highest f nodes
     * first, if search strategy is called with the bfs = false option.
     *
     * @param problem. This is an EpddlProblem containing all the necessary
     * information
     * @return A sequence of actions
     * @throws Exception Throws generic expression for now.
     */
    public LinkedList blindSearch(EPddlProblem problem) throws Exception {

        System.out.println("Blind Search");
        long start_global = System.currentTimeMillis();
        PriorityQueue<SearchNode> frontier = new PriorityQueue(new FrontierOrder());
        State current = (State) problem.getInit();
        //problem.generateActions();
        //LinkedHashSet a = new LinkedHashSet(np.compute_relevant_actions(problem.getInit().clone(), problem.getActions()));

        getHeuristic().setup(current);
        System.out.println("After Reacheability Actions:" + getHeuristic().reachable.size());
        Float current_value = 0f;
        SearchNode init = new SearchNode((State) problem.getInit().clone(), 0, current_value, this.json_rep_saving, this.gw, this.hw);
        if (json_rep_saving) {
            search_space_handle = init;
        }
        frontier.add(init);
        HashMap<State, Boolean> closed = new HashMap();
        HashMap<State, Float> cost = new HashMap();
        cost.put(problem.getInit(), 0f);
        heuristic_time = 0;
        while (!frontier.isEmpty()) {
            SearchNode current_node = frontier.poll();
            if (json_rep_saving) {
                current_node.set_visited(nodes_expanded);
            }

            nodes_expanded++;
            priority_queue_size = frontier.size();
            //System.out.println("Current Distance:"+current_node.g_n);
            //System.out.println("Current Cost:"+current_node.g_n);
            if (current_value > current_node.h_n) {
                System.out.println("Current Distance:" + current_node.h_n);

                current_value = current_node.h_n;
            }
//            if (current_node.action!= null)
//                System.out.println("Action:"+current_node.action);
            if (current_node.s.satisfy(problem.getGoals())) {
                overall_search_time = System.currentTimeMillis() - start_global;
                return extract_plan(current_node);
            }

            if (current_node.g_n >= depth_limit) {
                overall_search_time = System.currentTimeMillis() - start_global;
                continue;
            }

            if (processes) {
                advance_time(frontier, current_node, problem);
            }

            for (GroundAction act : getHeuristic().reachable) {
                if (act instanceof GroundProcess) {
                } else if (act.isApplicable(current_node.s)) {
                    State temp = current_node.s.clone();
                    temp.apply(act);
                    //act.normalize();
                    if (!temp.satisfy(problem.globalConstraints)) {
                        continue;
                    }

                    if (closed.get(temp) != null) {
                        if (cost.get(temp) != null) {
                            if (!(cost.get(temp) >= current_node.g_n + act.getActionCost(current_node.s))) {
                                continue;
                            }
                        }
                    }

                    closed.put(current_node.s, Boolean.TRUE);
                    cost.put(temp, current_node.g_n + act.getActionCost(current_node.s));
                    setStates_evaluated(getStates_evaluated() + 1);

//                    act.set_unit_cost(temp);
                    SearchNode new_node = new SearchNode(temp, act, current_node, current_node.g_n + act.getActionCost(current_node.s), 0, this.json_rep_saving, this.gw, 0);
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

        return null;
    }

    public LinkedList greedy_best_first_search(EPddlProblem problem) throws Exception {
        this.optimality = false;
        //this.gw = (float) 0.0;//this is the actual GBFS setting. Otherwise is not gbfs
        return this.wa_star(problem);
    }

    private LinkedList extract_plan(SearchNode c) {
        LinkedList plan = new LinkedList();
        while (c.action != null || c.list_of_actions != null) {
            try {
                Double time = null;
                if (c.father.s instanceof PDDLState) {
                    time = ((PDDLState) c.father.s).time;
                }
                if (c.action != null) {//this is an action
                    GroundAction gr = (GroundAction) c.action.clone();
                    if (time != null) {
                        gr.time = time.floatValue();
                    } else {
                        gr.time = 0f;
                    }
                    plan.addFirst(gr);
                } else {//this is a process or an event
                    for (int k = c.list_of_actions.size() - 1; k >= 0; k--) {
                        GroundAction w = c.list_of_actions.get(k);
                        if (w instanceof GroundProcess) {
                            w.setName("--------->waiting");
                            w.time = c.list_of_actions.get(k).time;
                            plan.addFirst(w);
                        } else {
                            //w.setName("--------->waiting");
                            w.time = c.list_of_actions.get(k).time;
                            plan.addFirst(w);
                        }
                    }
                }
                c = c.father;
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(SearchStrategies.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return plan;
    }

    /**
     * @return the gw
     */
    public float getGw() {
        return gw;
    }

    /**
     * @param gw the gw to set
     */
    public void set_w_g(float gw) {
        this.gw = gw;
    }

    /**
     * @return the hw
     */
    public float getHw() {
        return hw;
    }

    /**
     * @param hw the hw to set
     */
    public void set_w_h(float hw) {
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
    public Heuristic getHeuristic() {
        return heuristic;
    }

    /**
     * @param heuristic the heuristic to set
     */
    public void setHeuristic(Heuristic heuristic) {
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

    private void advance_time(Object frontier, SearchNode current_node, EPddlProblem problem) throws Exception {
        try {
            float i = 0.00000f;
            State temp = current_node.s.clone();
            ArrayList<GroundAction> waiting_list = new ArrayList();
            boolean at_least_one = false;
            while (i < delta_max) {
                State temp_temp = temp.clone();
                waiting_list.addAll(apply_events(temp_temp, i));
                i += delta;

                GroundProcess waiting = new GroundProcess("waiting");
                waiting.setNumericEffects(new AndCond());
                waiting.setPreconditions(new AndCond());
                waiting.addDelta(delta);
                waiting.time = delta;//this is the waiting time associated with this step
                for (GroundAction act : this.reachable_processes) {
                    if (act instanceof GroundProcess) {
                        GroundProcess gp = (GroundProcess) act;
                        if (gp.isActive(temp_temp)) {
                            //System.out.println(gp.toEcoString());
                            AndCond precondition = (AndCond) waiting.getPreconditions();
                            precondition.addConditions(gp.getPreconditions());
                            for (NumEffect eff : gp.getNumericEffectsAsCollection()) {
                                waiting.add_numeric_effect(eff);
                            }
                            waiting.setPreconditions(precondition);
                        }
                    }
                }
                waiting_list.add(waiting);

                temp_temp.apply(waiting);
                waiting_list.addAll(apply_events(temp_temp, i));

                //the next has to be written better!!!! Spend a bit of time on that!
                boolean valid = temp_temp.satisfy(problem.globalConstraints);//zero crossing?!?!?
                if (!valid) {
                    constraints_violations++;
                } else {
                    at_least_one = true;
                    if (temp_temp.satisfy(problem.getGoals())) {//very very easy zero crossing for opportunities. This should include also action preconditions
                        queue_successor(frontier, temp_temp, current_node, waiting_list);
                        if (debug == 111) {
                            System.out.println("Debug: goal while waiting!!");
                        }
                    }
                }
                if (!valid || i >= delta_max) {
                    if (i >= delta_max && valid) {
                        temp = temp_temp;
                    } else {
//                        System.out.println("smaller jump here?");
//                        System.out.println("Waiting at this time for:"+i);
                    }
                    if (at_least_one) {
                        queue_successor(frontier, temp, current_node, waiting_list);//this could be done in a smarter way
                    }
                    break;
                } else {
                    temp = temp_temp;
                }
            }
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(SearchStrategies.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

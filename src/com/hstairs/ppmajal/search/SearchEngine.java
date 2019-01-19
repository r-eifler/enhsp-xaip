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
package com.hstairs.ppmajal.search;

import com.hstairs.ppmajal.conditions.AndCond;
import com.hstairs.ppmajal.expressions.NumEffect;
import com.hstairs.ppmajal.extraUtils.Pair;
import com.hstairs.ppmajal.heuristics.Heuristic;
import com.hstairs.ppmajal.problem.*;
import it.unimi.dsi.fastutil.objects.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author enrico
 */
public class SearchEngine {

    //definition
    final private float G_DEFAULT = Float.NaN;
    public int deadEndsDetected;
    public int duplicatesNumber;
    //debug
    public boolean saveSearchTreeAsJson;
    public SearchNode searchSpaceHandle;
    public int debugLevel;
    //configuration
    public long depthLimit;
    public boolean bfsTieBreaking;
    public boolean helpfulActionsPruning;
    public boolean forgettingEhc;
    public TieBreaking tbRule;
    //externalise internal state of things
    public float currentG;
    public boolean processes = false;
    public float executionDelta;
    public float planningDelta;
    public int constraintsViolations;
    protected State lastState;
    //stats
    private int nodesReopened;
    private int nodesExpanded;
    private long heuristicCpuTime;
    private long overallSearchTime;
    private int priorityQueueSize;
    private int numberOfEvaluatedStates;
    private float hw;
    private Heuristic heuristic;
    private float gw;
    private boolean optimality;
    private long beginningTime;
    //dealing with continuous processes
    private Collection<GroundProcess> reachableProcesses;
    private Collection<GroundEvent> reachableEvents;
    private boolean incremental;
    private long previousTime;
    private int causalDeadEnds;
    private Object2FloatMap<State> idaStar;


    public SearchEngine ( ) {
        setNodesExpanded(0);
        setNodesReopened(0);
        setNumberOfEvaluatedStates(0);
        duplicatesNumber = 0;
        hw = 1;
        gw = 1;
        saveSearchTreeAsJson = false;
        depthLimit = Long.MAX_VALUE;
        bfsTieBreaking = true;
        optimality = true;
        forgettingEhc = false;
        bfsTieBreaking = true;
    }

    private Object getMap (Explorator explorator) {
        Object visited = null;
        if (explorator.equals(Explorator.BRFS)) {
            visited = new Object2BooleanLinkedOpenHashMap();
        } else {
            visited = new Object2FloatLinkedOpenHashMap();
        }
        return visited;
    }

    private void printExpandedNodesInfo ( ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setReachableActions (EPddlProblem problem) {
        Set to_consider;
        if (helpfulActionsPruning) {
            System.out.println("Only Helpful Actions");
            to_consider = new HashSet<>(getHeuristic().helpful_actions);
        } else {
            System.out.println("Take all reachable actions");
            to_consider = getHeuristic().reachable;
        }
        problem.setReachableActions(to_consider);
    }

    private void setReachableProcessesEvents (EPddlProblem problem) {
        reachableProcesses = new LinkedHashSet<>();
        reachableEvents = new LinkedHashSet<>();

        Set<GroundAction> reachableTransitions;
//        if (only_relaxed_plan_actions)
//            to_consider = getHeuristic().relaxed_plan_actions;
//        else
        reachableTransitions = getHeuristic().reachable;

        for (GroundAction gr3 : reachableTransitions) {
            if (!(gr3 instanceof GroundProcess)) {
                continue;
            }
            GroundProcess gr = (GroundProcess) gr3;
            Iterator<GroundProcess> it = problem.getProcessesSet().iterator();
            while (it.hasNext()) {
                GroundProcess gr2 = it.next();
                if (gr.equalsNoId(gr2)) {
                    reachableProcesses.add(gr2);
                }
            }
        }
        for (GroundAction gr3 : reachableTransitions) {
            if (!(gr3 instanceof GroundEvent)) {
                continue;
            }
            GroundEvent gr = (GroundEvent) gr3;
            Iterator<GroundEvent> it = problem.getEventsSet().iterator();
            while (it.hasNext()) {
                GroundEvent gr2 = it.next();
                if (gr.equalsNoId(gr2)) {
                    this.reachableEvents.add(gr2);
                }
            }
        }
    }

    private void setupReachableActionsProcesses (EPddlProblem problem) {
        setReachableActions(problem);
        setReachableProcessesEvents(problem);
        System.out.println("Actions used at init:" + problem.getReachableActions().size());
    }

    /*
    Very Important and Experimental. In this case the successor is a list of waiting action. This is needed so as to retrieve it afterwards
     */
    private SearchNode queueSuccessor (Object frontier, State successorState, SearchNode current_node, Object action_s, float prev_cost, float succ_g, Object2FloatMap<State> g, boolean treeSearch) {


        if (Objects.equals(prev_cost, this.G_DEFAULT) || succ_g < prev_cost) {
            setEvaluatedStates(getEvaluatedStates() + 1);
            long start = System.currentTimeMillis();
            Float d = getHeuristic().computeEstimate(successorState);
            setHeuristicCpuTime(getHeuristicCpuTime() + System.currentTimeMillis() - start);
            if (d != Float.MAX_VALUE && (d + succ_g) < this.depthLimit) {
                SearchNode node = null;
                if (action_s instanceof ArrayList) {
                    node = new SearchNode(successorState, (ArrayList) action_s, current_node, succ_g, d, this.saveSearchTreeAsJson, this.gw, this.hw);
                } else {
                    node = new SearchNode(successorState, action_s, current_node, succ_g, d, this.saveSearchTreeAsJson, this.gw, this.hw);
                }
                if (this.helpfulActionsPruning) {
                    node.relaxed_plan_from_heuristic = getHeuristic().helpful_actions;
                }
                if (saveSearchTreeAsJson) {
                    current_node.add_descendant(node);
                }
                add_frontier(frontier, node);
                setGValue(successorState, g, succ_g, treeSearch);
                return node;
            } else {
                deadEndsDetected++;
                return null;
            }
        } else {
            duplicatesNumber++;
            return null;
        }
    }

    private void setGValue (State successorState, Object2FloatMap<State> g, float succ_g, boolean treeSearch) {
        if (!treeSearch) {
            g.put(successorState.getRepresentative(), succ_g);
        }
    }

    private SearchNode queue_successor (Object frontier, State successor_state, SearchNode current_node, Object action_s, Object2FloatMap<State> g) {
        return queue_successor(frontier, successor_state, current_node, action_s, g, false);
    }

    private SearchNode queue_successor (Object frontier, State successor_state, SearchNode current_node, Object action_s, Object2FloatMap<State> g, boolean treeSearch) {
        float succ_g = current_node.gValue + 1;
        float prev_cost = getPreviousCost(g, successor_state, treeSearch);
//        System.out.println("G:"+g.keySet());
//        System.out.println("Current State:"+successor_state);
//        System.out.println("Cost: "+prev_cost);
        //The node is put in the priority queue whenever one of the following holds
        //if prev_cost == null, then I have never seen this state before
        // if the new cost is better (which can happen in case of inconsistent heuristics or new state evaluation from some other paths
        return this.queueSuccessor(frontier, successor_state, current_node, action_s, prev_cost, succ_g, g, treeSearch);
    }

    private ArrayList<GroundEvent> apply_events (State s, float delta1) throws CloneNotSupportedException {
        ArrayList<GroundEvent> ret = new ArrayList<>();
        while (true) {
            boolean at_least_one = false;
            for (GroundEvent ev : this.reachableEvents) {

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

    private void add_frontier (Object frontier, SearchNode new_node) {

        //frontier.
//        frontier.re
        if (frontier instanceof Queue) {
            ((Queue) frontier).add(new_node);
        } else if (frontier instanceof ObjectHeapPriorityQueue) {

            ((ObjectHeapPriorityQueue) frontier).enqueue(new_node);
        }

    }

    public List<GroundAction> a_star (EPddlProblem problem) throws Exception {
        this.gw = 1f;
        this.hw = 1f;
        return this.WAStar(problem);
    }

    public void setupHeuristic (Heuristic input) {
        this.setHeuristic(input);
    }

    public LinkedList<GroundAction> enforced_hill_climbing (EPddlProblem problem) throws Exception {
        return this.enforced_hill_climbing(problem, Explorator.BRFS);
    }

    public LinkedList<GroundAction> enforced_hill_climbing (EPddlProblem problem, Explorator explorator) throws Exception {
        long start_global = System.currentTimeMillis();

        getHeuristic().setup(problem.getInit());
        setupReachableActionsProcesses(problem);
        setEvaluatedStates(getEvaluatedStates() + 1);

        State current = problem.getInit();

        LinkedList<GroundAction> plan = new LinkedList<>();
        //a = new LinkedHashSet(np.compute_relevant_actions(problem.getInit(), problem.getActions()));
        //System.out.println("Goals:"+problem.getGoals());
//        rel_actions = getHeuristic().reachable;
        setNumberOfEvaluatedStates(0);
        Object visited = null;
        visited = getMap(explorator);
        incremental = true;
        currentG = 0;

        while (true) {
            Boolean b = problem.goalSatisfied(current);

            if (b == null) {
                return null;
            }
            if (b) {
                break;
            }

            SearchNode succ;
            if (explorator.equals(Explorator.BRFS)) {
                succ = breadth_first_search(current, problem, (Object2BooleanMap<State>) visited);
            } else {

                succ = WAStar(problem, current, true, (Object2FloatMap<State>) visited, false);
            }

            if (succ == null) {
                System.out.println("No plan exists with EHC");
//                System.out.println("Prefix Explored: " + plan);
//                System.out.println("Dead End State: " + current);
                return null;
            }

            current = succ.s;
            currentG = succ.gValue;
//            System.out.println(current);

            if (this.helpfulActionsPruning) {
                problem.setReachableActions(new LinkedHashSet<>(succ.relaxed_plan_from_heuristic));
            }
            plan.addAll(extractPlan(succ));
            //System.out.println(plan);
            if (forgettingEhc) {
                visited = getMap(explorator);
            }
        }
        setOverallSearchTime(System.currentTimeMillis() - start_global);
        return plan;

    }

    public SearchNode breadth_first_search (State current, EPddlProblem problem, Object2BooleanMap<State> visited) throws Exception {
        //System.out.println("Visited size:"+visited.size());

        Queue<SearchNode> frontier = new LinkedList<>();
        Float current_value = heuristic.computeEstimate(current);

        SearchNode init = new SearchNode(current, null, null, 0, current_value);
        frontier.add(init);
        if (this.helpfulActionsPruning) {
            init.relaxed_plan_from_heuristic = getHeuristic().helpful_actions;
        }
//        System.out.println(init.relaxed_plan_from_heuristic);
        System.out.println("h(n):" + current_value + " ");
        float current_gn = 0;
        while (!frontier.isEmpty()) {
            SearchNode node = frontier.poll();
            setNodesExpanded(getNodesExpanded() + 1);
            if (node.gValue > current_gn) {
                System.out.println(" " + node.gValue);
                current_gn = node.gValue;

            }
            if (this.helpfulActionsPruning) {
                problem.setReachableActions(new LinkedHashSet<>(node.relaxed_plan_from_heuristic));
            }


            visited.put(node.s, true);
            for (Iterator<Pair<State, Object>> it = problem.getSuccessors(node.s); it.hasNext(); ) {
                final Pair<State, Object> next = it.next();
                final Object act = next.getSecond();
                State temp = next.getFirst();
//                    System.out.println("Depth:"+node.gValue);
                //act.normalize();
                if (!temp.satisfy(problem.globalConstraints)) {
                    continue;
                }
                boolean visitedTemp = visited.getOrDefault(temp, false);
                if (!visitedTemp) {
                    visited.put(temp, true);
                    Float newG = heuristic.gValue(node.s, act, temp, node.gValue);
                    if (newG == null) {
                        continue;
                    }
                    long start = System.currentTimeMillis();
                    Float d = heuristic.computeEstimate(temp);
                    setHeuristicCpuTime(getHeuristicCpuTime() + System.currentTimeMillis() - start);
                    //System.out.println("try");
                    setEvaluatedStates(getEvaluatedStates() + 1);
                    if (d != Float.MAX_VALUE) {// && d <= current_value) {

                        SearchNode new_node = new SearchNode(temp, act, node, newG, 0);
                        frontier.add(new_node);
                        if (this.helpfulActionsPruning) {
                            new_node.relaxed_plan_from_heuristic = heuristic.helpful_actions;
                        }
                        if (problem.milestoneReached(d, current_value, temp)) {
//                            if (d < current_value && problem.isSafeState(temp)) {
                            setNodesExpanded(getNodesExpanded() + 1);
                            System.out.println("h(n):" + d);
                            return new_node;
                        }
                    } else {
//                            System.out.println("Dead End");
                        deadEndsDetected++;
                    }
                }

            }
        }
        return null;

    }

    /**
     * The method implements weighted-A*-like search algorithms systematically.
     * <p>
     * Solve the problem by using weighted-A* or A* or Uniform Cost Search (UCS)
     * depending on the evaluation function f the frontier is prioritized by,
     * where f = wg * g(n) + wh * h(n) wg = 1, wh = 0, UCS, wg = 1, wh = 1, A*,
     * wg = 1, wh > 1, weighted-A*. The weights wg and wh should be set by
     * SearchStrategies.setWG() and SearchStrategies.setWH() before the
     * method is called. Heuristics function should also be setup.
     *
     * @param problem     the problem to be solved.
     * @param extCurrent  start from this current state if given as input
     * @param exitOnBestH exit on best h value found (in expansion)
     * @param treeSearch
     * @return null if the problem is unsolvable, a linked list of the plan
     * otherwise.
     * @throws Exception
     */
    public SearchNode WAStar (EPddlProblem problem, State extCurrent, boolean exitOnBestH, Object2FloatMap<State> gMap, boolean treeSearch) throws Exception {

        State initState = null;
        if (extCurrent == null) {
            initState = problem.getInit();
        } else {
            initState = extCurrent;
        }

        if (this.tbRule == null) {
            tbRule = TieBreaking.ARBITRARY;
        }
        final ObjectHeapPriorityQueue<SearchNode> frontier = new ObjectHeapPriorityQueue<>(new TieBreaker(this.tbRule));
        if (!initState.satisfy(problem.globalConstraints)) {
            System.out.println("Initial State is not valid");
            return null;
        }
//        Float hAtInit = getHeuristic().computeEstimate(initState);
        long start_global = System.currentTimeMillis();
        if (!incremental) {
            deadEndsDetected = 0;
            constraintsViolations = 0;
            if (getHeuristic().setup(initState) == Float.MAX_VALUE) {
                System.out.println("h(n = s_0)=inf");
                return null;
            }
            System.out.println("Reachable actions and processes: |A U P U E|:" + getHeuristic().reachable.size());
            setupReachableActionsProcesses(problem);//this maps actions in the heuristic with the action in the execution model
            setHeuristicCpuTime(0);
            duplicatesNumber = 0;
            setNodesReopened(0);
            currentG = 0f;
        }

        Float hAtInit = getHeuristic().computeEstimate(initState);

        getHeuristic().why_not_active = true;

        System.out.println("h(n = s_0)=" + hAtInit);//debugging information

        getHeuristic().why_not_active = false;

        SearchNode init = new SearchNode(initState.clone(), 0, hAtInit, this.saveSearchTreeAsJson, this.gw, this.hw);
        if (this.helpfulActionsPruning) {
            System.out.println("Selection actions from the helpful actions list");
            init.relaxed_plan_from_heuristic = getHeuristic().helpful_actions;
        }

        if (saveSearchTreeAsJson) {
            searchSpaceHandle = init;//this needs to have an handle on the initial state for saving it into a json file
        }

        if (hAtInit == Float.MAX_VALUE) {//this shouldn't happen here.
            deadEndsDetected++;
            return null;
        }

        frontier.enqueue(init);
        gMap.put(initState, 0f);//The initial state is at 0 distance, of course.
        float bestf = 0;
        setNodesExpanded(0);
        this.setEvaluatedStates(0);
        long previous = 0;
        while (!frontier.isEmpty()) {
            final SearchNode currentNode = frontier.dequeue();

            if (currentNode.gValue >= depthLimit) {
                setOverallSearchTime(System.currentTimeMillis() - start_global);
                continue;
            }
            if (saveSearchTreeAsJson) {
                currentNode.set_visited(getNodesExpanded());
            }

            final float previousG = getPreviousCost(gMap, currentNode.s, treeSearch);
            final float g_node = currentNode.gValue;

            if (g_node == previousG || treeSearch) {
                long fromTheBeginning = (System.currentTimeMillis() - start_global);
                if (fromTheBeginning >= previous + 10000) {
                    System.out.println("-------------Time: " + fromTheBeginning / 1000 + "s ; Expanded Nodes: " + getNodesExpanded() + "; Evaluated States: " + getNumberOfEvaluatedStates());
                    previous = fromTheBeginning;
                }
                if (optimality && (bestf < currentNode.gValue + currentNode.h_n)) {//this is the debugLevel for when the planner is run in optimality modality
                    bestf = currentNode.gValue + currentNode.h_n;
                    System.out.println("f(n) = " + bestf + " (Expanded Nodes: " + getNodesExpanded()
                            + ", Evaluated States: " + getNumberOfEvaluatedStates() + ", Time: " + (float) ((System.currentTimeMillis() - start_global)) / 1000.0 + ")");

                }
                if (!optimality && hAtInit > currentNode.h_n) {
                    System.out.println(" g(n)= " + currentNode.gValue + " h(n)=" + currentNode.h_n);
                    hAtInit = currentNode.h_n;
                    currentG = currentNode.gValue;
                }

                if (debugLevel == 20 && getNodesExpanded() % 5000 == 0) {
                    System.out.println("Expanded Nodes / sec:" + (new Float(getNodesExpanded()) * 1000.0 / ((System.currentTimeMillis() - start_global))));
                }

                setPriorityQueueSize(frontier.size());
                final Boolean res = problem.goalSatisfied(currentNode.s);
                if (res == null) {//this means it is a dead-end
                    deadEndsDetected++;
                    continue;
                }
                if (exitOnBestH && problem.milestoneReached(currentNode.h_n, hAtInit, currentNode.s)) {
                    System.out.println("***************Best H: " + currentNode.h_n);
                    return currentNode;
                }
                setNodesExpanded(getNodesExpanded() + 1);
                if (res) {
                    setOverallSearchTime(System.currentTimeMillis() - start_global);
                    currentG = currentNode.gValue;
                    return currentNode;
                }

                //if we have a pddl+ problem, we also branch on waiting.
                if (processes) {
                    advance_time(frontier, currentNode, problem, gMap);
                }

                //In case we use helpful actions pruning. This is highly experimental, though it seems to work pretty well...
                if (this.helpfulActionsPruning) {
                    problem.setReachableActions(currentNode.relaxed_plan_from_heuristic);
                }

                for (Iterator<Pair<State, Object>> it = problem.getSuccessors(currentNode.s); it.hasNext(); ) {
                    final Pair<State, Object> next = it.next();
                    final State successorState = next.getFirst();
                    final Object act = next.getSecond();
                    //skip this if violates global constraints
                    final float successorG = heuristic.gValue(currentNode.s, act, successorState, currentNode.gValue);
                    if (Objects.equals(successorG, this.G_DEFAULT)) {
                        this.deadEndsDetected++;
                        continue;
                    }
                    final float previousCost = getPreviousCost(gMap, successorState, treeSearch);
                    this.queueSuccessor(frontier, successorState, currentNode, act, previousCost, successorG, gMap, treeSearch);

                }
            }
        }

        return null;
    }

    private float getPreviousCost (Object2FloatMap<State> gMap, State successorState, boolean treeSearch) {
        if (treeSearch) {
            return G_DEFAULT;
        }
        return gMap.getOrDefault(successorState.getRepresentative(), G_DEFAULT);
    }

    public State getLastState ( ) {
        return this.lastState;
    }

    public LinkedList<GroundAction> WAStar (EPddlProblem problem) throws Exception {
        return WAStar(problem, false);
    }

    public LinkedList<GroundAction> WAStar (EPddlProblem problem, boolean treeSearch) throws Exception {
        SearchNode end = this.WAStar(problem, null, false, new Object2FloatLinkedOpenHashMap<State>(), treeSearch);
        if (end != null) {
            return this.extractPlan(end);
        } else {
            return null;
        }
    }

    /**
     * This function implements UCS as for Felner's paper SOCS 2011. It can also
     * be used in a depth first search manner (going towards the highest f nodes
     * first, if search strategy is called with the bfsTieBreaking = false option.
     *
     * @return A sequence of actions
     * @throws Exception Throws generic expression for now.
     */
    public LinkedList<GroundAction> blindSearch (EPddlProblem problem) throws Exception {

        System.out.println("Blind Search");
        if (this.tbRule == null) {
            tbRule = TieBreaking.ARBITRARY;
        }

        long start_global = System.currentTimeMillis();
        PriorityQueue<SearchNode> frontier = new PriorityQueue<>(new TieBreaker(this.tbRule, bfsTieBreaking));
        State current = problem.getInit();
        //problem.generateActions();
        //LinkedHashSet a = new LinkedHashSet(np.compute_relevant_actions(problem.getInit().clone(), problem.getActions()));

        getHeuristic().setup(current);
        System.out.println("After Reacheability Actions:" + getHeuristic().reachable.size());
        Float current_value = 0f;
        SearchNode init = new SearchNode(problem.getInit().clone(), 0, current_value, this.saveSearchTreeAsJson, this.gw, this.hw);
        if (saveSearchTreeAsJson) {
            searchSpaceHandle = init;
        }
        frontier.add(init);
        HashMap<State, Boolean> closed = new HashMap<>();
        HashMap<State, Float> cost = new HashMap<>();
        cost.put(problem.getInit(), 0f);
        setHeuristicCpuTime(0);
        while (!frontier.isEmpty()) {
            SearchNode current_node = frontier.poll();
            if (saveSearchTreeAsJson) {
                current_node.set_visited(getNodesExpanded());
            }

            setNodesExpanded(getNodesExpanded() + 1);
            setPriorityQueueSize(frontier.size());
            //System.out.println("Current Distance:"+current_node.gValue);
            //System.out.println("Current Cost:"+current_node.gValue);
            if (current_value > current_node.h_n) {
                System.out.println("Current Distance:" + current_node.h_n);

                current_value = current_node.h_n;
            }
//            if (current_node.action!= null)
//                System.out.println("Action:"+current_node.action);
            if (current_node.s.satisfy(problem.getGoals())) {
                setOverallSearchTime(System.currentTimeMillis() - start_global);
                return extractPlan(current_node);
            }

            if (current_node.gValue >= depthLimit) {
                setOverallSearchTime(System.currentTimeMillis() - start_global);
                continue;
            }

            if (processes) {
                advance_time(frontier, current_node, problem, null);
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
                            if (!(cost.get(temp) >= current_node.gValue + act.getActionCost(current_node.s))) {
                                continue;
                            }
                        }
                    }

                    closed.put(current_node.s, Boolean.TRUE);
                    cost.put(temp, current_node.gValue + act.getActionCost(current_node.s));
                    setEvaluatedStates(getEvaluatedStates() + 1);

//                    act.set_unit_cost(temp);
                    SearchNode new_node = new SearchNode(temp, act, current_node, current_node.gValue + act.getActionCost(current_node.s), 0, this.saveSearchTreeAsJson, this.gw, 0);
                    //SearchNode new_node = new SearchNode(temp,act,current_node,1,d*hw);
                    if (saveSearchTreeAsJson) {
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

    public LinkedList<GroundAction> greedy_best_first_search (EPddlProblem problem) throws Exception {
        this.optimality = false;
        //this.gw = (float) 0.0;//this is the actual GBFS setting. Otherwise is not gbfs
        return this.WAStar(problem);
    }

    public LinkedList extractPlan (SimpleSearchNode c) {
        LinkedList plan = new LinkedList<>();
        lastState = c.s;
        while (c.transition != null) {
            if (c.transition != null) {//this is an action
                plan.addFirst(c.transition);
            }
            c = c.father;
        }
        return plan;
    }

    /**
     * @return the gw
     */
    public float getGw ( ) {
        return gw;
    }

    /**
     * @param gw the gw to set
     */
    public void setWG (float gw) {
        this.gw = gw;
    }

    /**
     * @return the hw
     */
    public float getHw ( ) {
        return hw;
    }

    /**
     * @param hw the hw to set
     */
    public void setWH (float hw) {
        this.hw = hw;
    }


    /**
     * @return the heuristic
     */
    public Heuristic getHeuristic ( ) {
        return heuristic;
    }

    /**
     * @param heuristic the heuristic to set
     */
    public void setHeuristic (Heuristic heuristic) {
        this.heuristic = heuristic;
    }

    /**
     * @return the states_evaluated
     */
    public int getEvaluatedStates ( ) {
        return getNumberOfEvaluatedStates();
    }

    /**
     * @param states_evaluated the states_evaluated to set
     */
    public void setEvaluatedStates (int states_evaluated) {
        this.setNumberOfEvaluatedStates(states_evaluated);
    }

    private void advance_time (Object frontier, SearchNode current_node, EPddlProblem problem, Object2FloatMap<State> g) {
        try {
            float i = 0.00000f;
            State temp = current_node.s.clone();
            ArrayList<GroundAction> waiting_list = new ArrayList<>();
            boolean at_least_one = false;
            while (i < planningDelta) {
                State temp_temp = temp.clone();
                waiting_list.addAll(apply_events(temp_temp, i));
                i += executionDelta;

                GroundProcess waiting = new GroundProcess("waiting", -1);
                waiting.setNumericEffects(new AndCond());
                waiting.setPreconditions(new AndCond());
                //waiting.add_time_effects(((PDDLState)temp).time, executionDelta);
                waiting.addDelta(executionDelta);
                for (GroundAction act : this.reachableProcesses) {
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
                    constraintsViolations++;
                } else {
                    at_least_one = true;
                    if (temp_temp.satisfy(problem.getGoals())) {//very very easy zero crossing for opportunities. This should include also action preconditions
                        queue_successor(frontier, temp_temp, current_node, waiting_list, g);
                        if (debugLevel == 111) {
                            System.out.println("Debug: goal while waiting!!");
                        }
                    }
                }
                if (!valid || i >= planningDelta) {
                    if (i >= planningDelta && valid) {
                        temp = temp_temp;
                    } else {
//                        System.out.println("smaller jump here?");
//                        System.out.println("Waiting at this time for:"+i);
                    }
                    if (at_least_one) {
                        queue_successor(frontier, temp, current_node, waiting_list, g);//this could be done in a smarter way
                    }
                    break;
                } else {
                    temp = temp_temp;
                }
            }
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(SearchEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public LinkedList idastar (EPddlProblem problem, boolean checkAlongPrefix) throws Exception {
        return idastar(problem, checkAlongPrefix, false, false);
    }

    public LinkedList idastar (EPddlProblem problem, boolean checkAlongPrefix, boolean showExpansion, boolean idaStarWithMemory) throws Exception {
        State initState = problem.getInit();


        beginningTime = System.currentTimeMillis();
        previousTime = beginningTime;
        if (!initState.satisfy(problem.globalConstraints)) {
            System.out.println("Initial State is not valid");
            return null;
        }
        deadEndsDetected = 0;
        constraintsViolations = 0;
        if (getHeuristic().setup(initState) == Float.MAX_VALUE) {
            System.out.println("h(n = s_0)=inf");
            return null;
        }
        System.out.println("Reachable actions and processes: |A U P U E|:" + getHeuristic().reachable.size());
        setupReachableActionsProcesses(problem);//this maps actions in the heuristic with the action in the execution model
        setHeuristicCpuTime(0);
        setNodesReopened(0);
        setNodesExpanded(0);
        this.setEvaluatedStates(0);

        Float hAtInit = getHeuristic().computeEstimate(initState);
        System.out.println("h(n = s_0)=" + hAtInit);//debugging information

        if (hAtInit == Float.MAX_VALUE) {//this shouldn't happen here.
            deadEndsDetected++;
            return null;
        }

        if (idaStarWithMemory) {
            idaStar = new Object2FloatOpenHashMap<>();
        }

        float bound = hAtInit * this.hw;
        long startSearch = System.currentTimeMillis();
        Pair<IdaStarSearchNode, Float> res = null;
        for (; ; ) {
            res = boundedDepthFirstSearch(problem, bound, false, checkAlongPrefix, showExpansion, idaStarWithMemory);
            if (res == null || res.getFirst() != null) {
                break;
            }
            bound = res.getSecond();
        }
        setOverallSearchTime((System.currentTimeMillis() - startSearch));
        if (res != null) {
            return this.extractPlan(res.getFirst());
        }
        return null;

    }


    public LinkedList dfsbnb (EPddlProblem problem) throws Exception {
        State initState = problem.getInit();
        beginningTime = System.currentTimeMillis();
        previousTime = beginningTime;
        if (!initState.satisfy(problem.globalConstraints)) {
            System.out.println("Initial State is not valid");
            return null;
        }
        deadEndsDetected = 0;
        constraintsViolations = 0;
        if (getHeuristic().setup(initState) == Float.MAX_VALUE) {
            System.out.println("h(n = s_0)=inf");
            return null;
        }
        System.out.println("Reachable actions and processes: |A U P U E|:" + getHeuristic().reachable.size());
        setupReachableActionsProcesses(problem);//this maps actions in the heuristic with the action in the execution model
        setHeuristicCpuTime(0);
        setNodesReopened(0);
        setNodesExpanded(0);
        this.setEvaluatedStates(0);

        long startSearch = System.currentTimeMillis();


        final Pair<IdaStarSearchNode, Float> res = boundedDepthFirstSearch(problem, depthLimit, true, true);
        setOverallSearchTime((System.currentTimeMillis() - startSearch));
        if (res != null) {
            return this.extractPlan(res.getFirst());
        }
        return null;

    }

    private boolean onThePath (State successorState, SimpleSearchNode father) {
        while (father != null) {
            if (father.s.equals(successorState)) {
                return true;
            }
            father = father.father;
        }
        return false;
    }


    private Pair<IdaStarSearchNode, Float> boundedDepthFirstSearch (EPddlProblem problem, float bound, boolean anytime, boolean checkAlongPrefix) {
        return boundedDepthFirstSearch(problem, bound, anytime, checkAlongPrefix, false, false);
    }

    private Pair<IdaStarSearchNode, Float> boundedDepthFirstSearch (EPddlProblem problem, float bound, boolean anytime, boolean checkAlongPrefix, boolean showExpansion, boolean idastarWithMemory) {
        final Stack<IdaStarSearchNode> frontier = new Stack();

        IdaStarSearchNode init = new IdaStarSearchNode(problem.getInit().clone(), null, null, 0);
        causalDeadEnds = 0;
        frontier.push(init);
        float newBound = Float.POSITIVE_INFINITY;
        System.out.println("f(n): " + bound + "(Expanded Nodes: " + getNodesExpanded() + ")");
        System.out.println("-------------------(Dead-Ends: " + deadEndsDetected + ")");
        IdaStarSearchNode bestSol = null;
        while (!frontier.isEmpty()) {
            final IdaStarSearchNode node = frontier.pop();
            long now = System.currentTimeMillis();
            if ((now - previousTime) > 10000) {
                System.out.println("-------------Time: " + (now - this.beginningTime) / 1000 + "s ; Expanded Nodes: " + getNodesExpanded());
                System.out.println("-------------------(Dead-Ends: " + deadEndsDetected + ")");
                this.previousTime = now;
            }
            final float g;
            if (node.transition != null) {
                g = heuristic.gValue(node.father.s, node.transition, node.s, node.gValue);
            } else {
                g = 0;
            }
            node.gValue = g;
            if (showExpansion) {
                System.out.println("Expansion:" + node.transition);
            }
//            System.out.println("------------");
            long start = System.currentTimeMillis();
            Float h = null;
            if (idastarWithMemory) {
                h = idaStar.get(node.s.getRepresentative());
            }
            if (h == null) {
                h = heuristic.computeEstimate(node.s);
            }

            setHeuristicCpuTime(getHeuristicCpuTime() + (System.currentTimeMillis() - start));
            setNodesExpanded(getNodesExpanded() + 1);
            if (Objects.equals(g, this.G_DEFAULT) || h == null || h == Float.MAX_VALUE || h == this.G_DEFAULT) {
                this.deadEndsDetected++;
                if (idastarWithMemory) {
                    updateTable((IdaStarSearchNode) node, h);
                }
            } else {
                float f = g + h * this.hw;
                if ((f > bound && !anytime) || (f >= bound && anytime)) {
                    if (!anytime && idastarWithMemory) {
                        updateTable((IdaStarSearchNode) node, h);
                    }
                    if (f < newBound && !anytime) {
                        if (problem.goalSatisfied(node.s) != null) {
                            newBound = f;
                        }
                    }
                } else {
                    final Boolean goalSatisfied = problem.goalSatisfied(node.s);
                    if (goalSatisfied != null) {
                        if (goalSatisfied) {
                            if (anytime) {
                                bound = g;
                                System.out.println("Found solution of cost:" + bound);
                                bestSol = node;
                            } else {
                                return new Pair(node, newBound);
                            }
                        } else {
                            if (this.helpfulActionsPruning) {
                                problem.setReachableActions(heuristic.helpful_actions);
                            }
                            boolean atLeastOne = false;

                            for (final Iterator<Pair<State, Object>> it = problem.getSuccessors(node.s); it.hasNext(); ) {
                                final Pair<State, Object> next = it.next();
                                boolean push = true;
                                if (checkAlongPrefix) {
                                    push = !onThePath(next.getFirst(), node.father);
                                }
                                if (push) {
                                    node.numberOfSons++;
                                    atLeastOne = true;
                                    frontier.push(new IdaStarSearchNode(next.getFirst(), next.getSecond(), node, g));
                                }
                            }
                            if (!atLeastOne) {
                                if (idastarWithMemory) {
                                    updateTable((IdaStarSearchNode) node, h);
                                }
                                causalDeadEnds++;
                            }
                        }
                    } else {
                        if (idastarWithMemory) {
                            updateTable((IdaStarSearchNode) node, null);
                        }
                        this.deadEndsDetected++;
                    }
                }
            }
        }
        if ((newBound == Float.POSITIVE_INFINITY && !anytime) || (bestSol == null && anytime)) {
            return null;
        }
        return new Pair(bestSol, newBound);

    }

    private void updateTable (IdaStarSearchNode s, Float h) {
        IdaStarSearchNode temp = s;
        Float bound = null;
        while (temp.father != null) {
            if (bound == null) {
                if (h == null || temp.gValue == this.G_DEFAULT || h == this.G_DEFAULT || h == Float.MAX_VALUE) {
                    bound = Float.MAX_VALUE;
                } else {
                    bound = h;
                }
            }

            IdaStarSearchNode father = (IdaStarSearchNode) temp.father;
            if (bound != Float.MAX_VALUE) {
                bound += temp.gValue - father.gValue;
            }
            father.numberOfSons = father.numberOfSons - 1;
            float previousBound = father.minSoFar;
            if (bound >= previousBound) {
                bound = previousBound; //keep the minimum
            } else {
                father.minSoFar = bound;
            }
            if (father.numberOfSons == 0) {
                idaStar.put(father.s.getRepresentative(), bound);
                temp = (IdaStarSearchNode) father;
            } else {
                break;
            }
        }
    }

    public int getNodesReopened ( ) {
        return nodesReopened;
    }

    public void setNodesReopened (int nodesReopened) {
        this.nodesReopened = nodesReopened;
    }

    public int getNodesExpanded ( ) {
        return nodesExpanded;
    }

    public void setNodesExpanded (int nodesExpanded) {
        this.nodesExpanded = nodesExpanded;
    }

    public long getHeuristicCpuTime ( ) {
        return heuristicCpuTime;
    }

    public void setHeuristicCpuTime (long heuristicCpuTime) {
        this.heuristicCpuTime = heuristicCpuTime;
    }

    public long getOverallSearchTime ( ) {
        return overallSearchTime;
    }

    public void setOverallSearchTime (long overallSearchTime) {
        this.overallSearchTime = overallSearchTime;
    }

    public int getNumberOfEvaluatedStates ( ) {
        return numberOfEvaluatedStates;
    }

    public void setNumberOfEvaluatedStates (int numberOfEvaluatedStates) {
        this.numberOfEvaluatedStates = numberOfEvaluatedStates;
    }

    public int getPriorityQueueSize ( ) {
        return priorityQueueSize;
    }

    public void setPriorityQueueSize (int priorityQueueSize) {
        this.priorityQueueSize = priorityQueueSize;
    }

    public int getCausalDeadEnds ( ) {
        return causalDeadEnds;
    }

    public enum TieBreaking {
        LOWERG,
        HIGHERG,
        ARBITRARY
    }


    public enum Explorator {
        WASTAR, BRFS
    }

    public class TieBreaker implements Comparator<SearchNode> {

        final SearchEngine.TieBreaking tb;
        public boolean bfs;

        public TieBreaker (SearchEngine.TieBreaking tb) {
            super();
            this.tb = tb;
            bfs = true;
        }

        public TieBreaker (SearchEngine.TieBreaking tieBreaking, boolean b) {
            this(tieBreaking);
            bfs = b;
        }

        @Override
        public int compare (SearchNode o1, SearchNode o2) {
            final SearchNode other = o2;
            final SearchNode a = o1;
            if (a.f == other.f) {
                switch (tb) {
                    case HIGHERG:
                        //                System.out.println(this.gValue);
                        if (a.gValue < other.gValue)//goal is farer
                        {
                            return +1;
                        } else if (a.gValue > other.gValue) //goal is closer
                        {
                            return -1;
                        } else {
                            return 0;
                        }
                    case LOWERG:
                        if (a.gValue < other.gValue)//goal is farer
                        {
                            return -1;
                        } else if (a.gValue > other.gValue) //goal is closer
                        {
                            return +1;
                        } else {
                            return 0;
                        }
                    case ARBITRARY:
                        return 0;
                    default:
                        throw new RuntimeException("This shouldn't happen. Wrong tie breaking");
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
}

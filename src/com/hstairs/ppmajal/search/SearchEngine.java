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

import java.util.ArrayList;
import com.hstairs.ppmajal.expressions.NumEffect;
import com.hstairs.ppmajal.extraUtils.Pair;
import com.hstairs.ppmajal.heuristics.Heuristic;
import com.hstairs.ppmajal.problem.EPddlProblem;
import com.hstairs.ppmajal.problem.PDDLState;
import com.hstairs.ppmajal.problem.PddlProblem;
import com.hstairs.ppmajal.problem.State;
import com.hstairs.ppmajal.transition.ConditionalEffects;
import com.hstairs.ppmajal.transition.Transition;
import com.hstairs.ppmajal.transition.TransitionGround;
import it.unimi.dsi.fastutil.objects.*;

import java.io.PrintStream;
import java.util.*;
import java.util.concurrent.TimeoutException;

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
    public float depthLimit;
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
    final private Heuristic heuristic;
    private float gw;
    private boolean optimality;
    private long beginningTime;
    //dealing with continuous change
    private Collection<TransitionGround> reachableProcesses;
    private Collection<TransitionGround> reachableEvents;
    private boolean incremental;
    private long previousTime;
    private int causalDeadEnds;
    private Object2FloatMap<State> idaStar;
    private PrintStream out;
    
    public SearchEngine(Heuristic h) {
        this(System.out,h);
    }
    
    public SearchEngine(PrintStream out, Heuristic h) {
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
        this.out = out;
        heuristic= h;
    }

    private Object getMap(Explorator explorator) {
        Object visited = null;
        if (explorator.equals(Explorator.BRFS)) {
            visited = new Object2BooleanLinkedOpenHashMap();
        } else {
            visited = new Object2FloatLinkedOpenHashMap();
        }
        return visited;
    }


    /*
    Very Important and Experimental. In this case the successor is a list of waiting action. This is needed so as to retrieve it afterwards
     */
    private SearchNode queueSuccessor(Object frontier, State successorState, SearchNode current_node, Object action_s, float prev_cost, float succ_g, Object2FloatMap<State> g, boolean treeSearch) {

        if (Objects.equals(prev_cost, this.G_DEFAULT) || succ_g < prev_cost) {
            setEvaluatedStates(getEvaluatedStates() + 1);
            long start = System.currentTimeMillis();
            Float d = getHeuristic().computeEstimate(successorState);
            setHeuristicCpuTime(getHeuristicCpuTime() + System.currentTimeMillis() - start);
            if (d != Float.MAX_VALUE) {// && (d + succ_g) < this.depthLimit) {
                SearchNode node = null;
                if (action_s instanceof ArrayList) {
                    node = new SearchNode(successorState, (ArrayList) action_s, current_node, succ_g, d, this.saveSearchTreeAsJson, this.gw, this.hw);
                } else {
                    node = new SearchNode(successorState, action_s, current_node, succ_g, d, this.saveSearchTreeAsJson, this.gw, this.hw);
                }
                if (this.helpfulActionsPruning) {
                    node.helpfulActions = getHeuristic().getTransitions(helpfulActionsPruning);
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

    private void setGValue(State successorState, Object2FloatMap<State> g, float succ_g, boolean treeSearch) {
        if (!treeSearch) {
            g.put(successorState.getRepresentative(), succ_g);
        }
    }

    private SearchNode queue_successor(Object frontier, State successor_state, SearchNode current_node, Object action_s, Object2FloatMap<State> g) {
        return queue_successor(frontier, successor_state, current_node, action_s, g, false);
    }

    private SearchNode queue_successor(Object frontier, State successor_state, SearchNode current_node, Object action_s, Object2FloatMap<State> g, boolean treeSearch) {
        float succ_g = current_node.gValue + 1;
        float prev_cost = getPreviousCost(g, successor_state, treeSearch);
        //The node is put in the priority queue whenever one of the following holds
        //if prev_cost == null, then I have never seen this state before
        // if the new cost is better (which can happen in case of inconsistent heuristics or new state evaluation from some other paths
        return this.queueSuccessor(frontier, successor_state, current_node, action_s, prev_cost, succ_g, g, treeSearch);
    }

    private ArrayList<TransitionGround> applyAllEvents(State s) {
        ArrayList<TransitionGround> ret = new ArrayList<>();
        while (true) {
            boolean at_least_one = false;
            for (TransitionGround ev : this.reachableEvents) {

                if (ev.isApplicable(s)) {
                    at_least_one = true;
                    s.apply(ev,s.clone());
                    ret.add(ev);
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
        if (frontier instanceof Queue) {
            ((Queue) frontier).add(new_node);
        } else if (frontier instanceof ObjectHeapPriorityQueue) {
            ((ObjectHeapPriorityQueue) frontier).enqueue(new_node);
        }

    }

    public LinkedList<org.apache.commons.lang3.tuple.Pair<Float,TransitionGround>> a_star(EPddlProblem problem) throws Exception {
        this.gw = 1f;
        this.hw = 1f;
        return this.WAStar(problem);
    }



    public LinkedList<TransitionGround> enforced_hill_climbing(EPddlProblem problem) throws Exception {
        return this.enforced_hill_climbing(problem, Explorator.BRFS);
    }

    public LinkedList<TransitionGround> enforced_hill_climbing(EPddlProblem problem, Explorator explorator) throws Exception {
        long start_global = System.currentTimeMillis();
        setEvaluatedStates(getEvaluatedStates() + 1);

        State current = problem.getInit();

        LinkedList<TransitionGround> plan = new LinkedList<>();
//        rel_actions = getHeuristic().reachable;
        setNumberOfEvaluatedStates(0);
        Object visited = null;
        visited = getMap(explorator);
        incremental = true;
        currentG = 0;

        while (true) {
            final Boolean b = problem.goalSatisfied(current);

            if (b == null) {
                return null;
            }
            if (b) {
                break;
            }

            final SearchNode succ;
            System.gc();
            if (explorator.equals(Explorator.BRFS)) {
                succ = breadth_first_search(current, problem, (Object2BooleanMap<State>) visited);
            } else {

                succ = WAStar(problem, current, true, (Object2FloatMap<State>) visited, false, Long.MAX_VALUE);
            }

            if (succ == null) {
                out.println("No plan exists with EHC");

                return null;
            }

            current = succ.s;
            currentG = succ.gValue;

            plan.addAll(extractPlan(succ));
            if (forgettingEhc) {
                visited = getMap(explorator);
            }
        }
        setOverallSearchTime(System.currentTimeMillis() - start_global);
        return plan;

    }

    public SearchNode breadth_first_search(State current, EPddlProblem problem, Object2BooleanMap<State> visited) throws Exception {
        //out.println("Visited size:"+visited.size());

        Queue<SearchNode> frontier = new LinkedList<>();
        Float current_value = heuristic.computeEstimate(current);

        SearchNode init = new SearchNode(current, null, null, 0, current_value);
        frontier.add(init);
        if (this.helpfulActionsPruning) {
            throw new UnsupportedOperationException();
//            init.helpfulActions = getHeuristic().getHelpfulActions();
        }
//        out.println(init.relaxed_plan_from_heuristic);
        out.println("h(n):" + current_value + " ");
        float current_gn = 0;
        while (!frontier.isEmpty()) {
            SearchNode node = frontier.poll();
            setNodesExpanded(getNodesExpanded() + 1);
            if (node.gValue > current_gn) {
                out.println(" " + node.gValue);
                current_gn = node.gValue;

            }

            visited.put(node.s, true);
            for (Iterator<Pair<State, Object>> it = problem.getSuccessors(node.s,getActionsToSearch(node,problem)); it.hasNext();) {
                final Pair<State, Object> next = it.next();
                final Object act = next.getSecond();
                State temp = next.getFirst();
//                    out.println("Depth:"+node.gValue);
                //act.normalize();
                if (!temp.satisfy(problem.globalConstraints)) {
                    continue;
                }
                boolean visitedTemp = visited.getOrDefault(temp, false);
                if (!visitedTemp) {
                    visited.put(temp, true);
                    Float newG = problem.gValue(node.s, act, temp, node.gValue, problem.getMetric());
                    if (newG == null) {
                        continue;
                    }
                    long start = System.currentTimeMillis();
                    Float d = heuristic.computeEstimate(temp);
                    setHeuristicCpuTime(getHeuristicCpuTime() + System.currentTimeMillis() - start);
                    //out.println("try");
                    setEvaluatedStates(getEvaluatedStates() + 1);
                    if (d != Float.MAX_VALUE) {// && d <= current_value) {

                        SearchNode new_node = new SearchNode(temp, act, node, newG, 0);
                        frontier.add(new_node);
                        if (this.helpfulActionsPruning) {
                            throw new UnsupportedOperationException();
//                            new_node.helpfulActions = heuristic.getHelpfulActions();
                        }
                        if (problem.milestoneReached(d, current_value, temp)) {
//                            if (d < current_value && problem.isSafeState(temp)) {
                            setNodesExpanded(getNodesExpanded() + 1);
                            out.println("h(n):" + d);
                            return new_node;
                        }
                    } else {
//                            out.println("Dead End");
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
     * SearchStrategies.setWG() and SearchStrategies.setWH() before the method
     * is called. Heuristics function should also be setup.
     *
     * @param problem the problem to be solved.
     * @param extCurrent start from this current state if given as input
     * @param exitOnBestH exit on best h value found (in expansion)
     * @param treeSearch
     * @return null if the problem is unsolvable, a linked list of the plan
     * otherwise.
     * @throws Exception
     */
    public SearchNode WAStar(EPddlProblem problem, State extCurrent, boolean exitOnBestH, Object2FloatMap<State> gMap, boolean treeSearch, long timeout) throws Exception {

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
            out.println("Initial State is not valid");
            return null;
        }
//        Float hAtInit = getHeuristic().computeEstimate(initState);
        long start_global = System.currentTimeMillis();
        Float hAtInit = getHeuristic().computeEstimate(initState);
        if (incremental) {
            throw new UnsupportedOperationException();
        }else{
            deadEndsDetected = 0;
            constraintsViolations = 0;
//            if (getHeuristic().setup(initState) == Float.MAX_VALUE) {
//                out.println("h(n = s_0)=inf");
//                return null;
//            }
            out.println("Reachable actions and processes: |A U P U E|:" + getHeuristic().getTransitions(problem).size());
//            setupReachableActionsProcesses(problem);//this maps actions in the heuristic with the action in the execution model
            setHeuristicCpuTime(0);
            duplicatesNumber = 0;
            setNodesReopened(0);
            currentG = 0f;
        }



//        getHeuristic().why_not_active = true;

        out.println("h(n = s_0)=" + hAtInit);//debugging information

//        getHeuristic().why_not_active = false;

        SearchNode init = new SearchNode(initState.clone(), 0, hAtInit, this.saveSearchTreeAsJson, this.gw, this.hw);
        if (this.helpfulActionsPruning) {
            init.helpfulActions = getHeuristic().getTransitions(helpfulActionsPruning);
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
                if (fromTheBeginning >= timeout){
                    throw new TimeoutException("Timeout has been reached: bailing out");
                }
                if (fromTheBeginning >= previous + 10000) {
                    final float speed = getNodesExpanded()/(fromTheBeginning / 1000);
                    out.println("-------------Time: " + fromTheBeginning / 1000 +
                            "s ; Expanded Nodes: " + getNodesExpanded() + " (Avg-Speed "+speed+" n/s); Evaluated States: " + getNumberOfEvaluatedStates());
                    previous = fromTheBeginning;

                }
                if (optimality && (bestf < currentNode.gValue + currentNode.h_n)) {//this is the debugLevel for when the planner is run in optimality modality
                    bestf = currentNode.gValue + currentNode.h_n;
                    out.println("f(n) = " + bestf + " (Expanded Nodes: " + getNodesExpanded()
                            + ", Evaluated States: " + getNumberOfEvaluatedStates() + ", Time: " + (float) ((System.currentTimeMillis() - start_global)) / 1000.0 + ")");

                }
                if (!optimality && hAtInit > currentNode.h_n) {
                    out.println(" g(n)= " + currentNode.gValue + " h(n)=" + currentNode.h_n);
                    hAtInit = currentNode.h_n;
                    currentG = currentNode.gValue;
                }

                if (debugLevel == 20 && getNodesExpanded() % 5000 == 0) {
                    out.println("Expanded Nodes / sec:" + (new Float(getNodesExpanded()) * 1000.0 / ((System.currentTimeMillis() - start_global))));
                }

                setPriorityQueueSize(frontier.size());
                final Boolean res = problem.goalSatisfied(currentNode.s);
                if (res == null) {//this means it is a dead-end
                    deadEndsDetected++;
                    continue;
                }
                if (exitOnBestH && problem.milestoneReached(currentNode.h_n, hAtInit, currentNode.s)) {
                    out.println("***************Best H: " + currentNode.h_n);
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
                    advanceTime(frontier, currentNode, problem, gMap);
                }

                //In case we use helpful actions pruning. This is highly experimental, though it seems to work pretty well...


                for (Iterator<Pair<State, Object>> it = problem.getSuccessors(currentNode.s,getActionsToSearch(currentNode,problem)); it.hasNext();) {
                    final Pair<State, Object> next = it.next();
                    final State successorState = next.getFirst();
                    final Object act = next.getSecond();
                    //skip this if violates global constraints
                    final float successorG = problem.gValue(currentNode.s, act, successorState, currentNode.gValue,problem.getMetric());
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

    private float getPreviousCost(Object2FloatMap<State> gMap, State successorState, boolean treeSearch) {
        if (treeSearch) {
            return G_DEFAULT;
        }
        return gMap.getOrDefault(successorState.getRepresentative(), G_DEFAULT);
    }

    public State getLastState() {
        return this.lastState;
    }

    public LinkedList<org.apache.commons.lang3.tuple.Pair<Float,TransitionGround>> WAStar(EPddlProblem problem) throws Exception {
        return WAStar(problem, false, Long.MAX_VALUE);
    }
    public LinkedList<org.apache.commons.lang3.tuple.Pair<Float,TransitionGround>> WAStar(EPddlProblem problem, long timeout) throws Exception {
        return WAStar(problem, false, timeout);
    }

    public LinkedList<org.apache.commons.lang3.tuple.Pair<Float,TransitionGround>> WAStar(EPddlProblem problem, boolean treeSearch, long timeout) throws Exception {
        SearchNode end = this.WAStar(problem, null, false, new Object2FloatLinkedOpenHashMap<State>(), treeSearch, timeout);
        if (end != null) {
            return this.extractPlan(end);
        } else {
            return null;
        }
    }



    public LinkedList<org.apache.commons.lang3.tuple.Pair<Float,TransitionGround>> greedy_best_first_search(EPddlProblem problem) throws Exception{
        this.optimality = false;
        return this.greedy_best_first_search(problem,Long.MAX_VALUE);
    }

    public LinkedList<org.apache.commons.lang3.tuple.Pair<Float,TransitionGround>> greedy_best_first_search(EPddlProblem problem,boolean optimality) throws Exception {
        this.optimality = optimality;
        return this.WAStar(problem);
    }


        public LinkedList<org.apache.commons.lang3.tuple.Pair<Float,TransitionGround>> greedy_best_first_search(EPddlProblem problem, long timeout) throws Exception {
        this.optimality = false;
        //this.gw = (float) 0.0;//this is the actual GBFS setting. Otherwise is not gbfs
        return this.WAStar(problem,timeout);
    }

    public LinkedList extractPlan(SimpleSearchNode c) {
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
    public float getGw() {
        return gw;
    }

    /**
     * @param gw the gw to set
     */
    public void setWG(float gw) {
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
    public void setWH(float hw) {
        this.hw = hw;
    }

    /**
     * @return the heuristic
     */
    public Heuristic getHeuristic() {
        return heuristic;
    }



    /**
     * @return the states_evaluated
     */
    public int getEvaluatedStates() {
        return getNumberOfEvaluatedStates();
    }

    /**
     * @param states_evaluated the states_evaluated to set
     */
    public void setEvaluatedStates(int states_evaluated) {
        this.setNumberOfEvaluatedStates(states_evaluated);
    }

    public boolean simulate(State s, EPddlProblem problem, double stepSize, double horizon) throws CloneNotSupportedException {
        if (reachableEvents == null){
            reachableEvents = problem.getEventsSet();
        }
        if (reachableProcesses == null){
            reachableProcesses = problem.getProcessesSet();
        }
        float i = 0.00000f;
        State temp = s;
        ArrayList<TransitionGround> waiting_list = new ArrayList<>();
        boolean at_least_one = false;
        while (i < horizon) {
            waiting_list.addAll(applyAllEvents(temp));
            i += stepSize;
            boolean atLeastOne = false;
            ConditionalEffects<NumEffect> numEffect = new ConditionalEffects(ConditionalEffects.VariableType.NUMEFFECT);
            for (TransitionGround act : this.reachableProcesses) {
                if (act.getSemantics() == Transition.Semantics.PROCESS) {
                    TransitionGround gp = (TransitionGround) act;
                    if (gp.isApplicable(temp)) {
                        atLeastOne = true;
                        for (NumEffect eff : (Collection<NumEffect>) gp.getConditionalNumericEffects().getAllEffects()) {
                            numEffect.add(eff);
                        }
                    }
                } else {
                    throw new RuntimeException("This shouldn't happen");
                }
            }
            if (!atLeastOne)
                return true;

            final TransitionGround waiting = new TransitionGround(new ArrayList<>(), "waiting", new ConditionalEffects(ConditionalEffects.VariableType
                    .PROPEFFECT), numEffect, null, Transition.Semantics.PROCESS);
            waiting_list.add(waiting);
            temp.apply(waiting, temp.clone());
            boolean valid = temp.satisfy(problem.globalConstraints);//zero crossing?!?!?
            if (!valid) {
                return false;
            }
        }
        return true;
    }



    protected Pair<State,Collection<TransitionGround>> intelligentSimulation(State s, EPddlProblem problem, double horizon, double executionDelta, boolean intelligent) {
        if (reachableEvents == null){
            reachableEvents = problem.getEventsSet();
        }
        if (reachableProcesses == null){
            reachableProcesses = problem.getProcessesSet();
        }

        final PDDLState next = (PDDLState)s.clone();
        if (horizon < executionDelta){
            System.out.println("Horizon: "+horizon+" Execution Delta: "+executionDelta);
            throw new RuntimeException("Delta simulation should be higher than delta execution");
        }
        if (notDiv(horizon,executionDelta)){
            System.out.println("Horizon: "+horizon+" Execution Delta: "+executionDelta);
            System.out.println("WARNING: Delta simulation should be a multiple of delta execution");
        }
        final int iterations = (int) Math.ceil(horizon/executionDelta);
        PDDLState previousNext = next;
        ArrayList<TransitionGround> executedProcesses = new ArrayList<>();
        for (int i = 0; i < iterations; i++) {
            boolean atLeastOne = false;
            ConditionalEffects<NumEffect> numEffect = new ConditionalEffects(ConditionalEffects.VariableType.NUMEFFECT);
            for (TransitionGround act : this.reachableProcesses) {
                if (act.getSemantics() == Transition.Semantics.PROCESS) {
                    TransitionGround gp = (TransitionGround) act;
                    if (gp.isApplicable(next)) {
                        atLeastOne = true;
                        for (NumEffect eff : (Collection<NumEffect>) gp.getConditionalNumericEffects().getAllEffects()) {
                            numEffect.add(eff);
                        }
                    }
                } else {
                    throw new RuntimeException("This shouldn't happen");
                }
            }
            if (!atLeastOne){
                if (i==0){
                    return null;
                }
                return new Pair(previousNext,executedProcesses);
            }
            //execute
            executedProcesses.addAll(applyAllEvents(next));
            final TransitionGround waiting = new TransitionGround(new ArrayList<>(),"waiting",new ConditionalEffects(ConditionalEffects.VariableType
                    .PROPEFFECT),numEffect,null, Transition.Semantics.PROCESS);

            next.apply(waiting,next.clone());
            next.time += executionDelta;

            if (!next.satisfy(problem.globalConstraints)){
                if (i==0 || !intelligent){
                    return null;
                }
                return new Pair(previousNext,executedProcesses);
            }
            executedProcesses.add(waiting);
            executedProcesses.addAll(applyAllEvents(next));
            if (intelligent && next.satisfy(problem.goals)){
                return new Pair(next,executedProcesses);
            }
            previousNext = next;
        }
        return new Pair(previousNext,executedProcesses);
    }

    private boolean notDiv(double horizon, double executionDelta) {
        final double v = Math.IEEEremainder(horizon, executionDelta);
        return v >= Double.MIN_VALUE;
    }


    private void advanceTime(Object frontier, SearchNode current_node, EPddlProblem problem, Object2FloatMap<State> g) {

        if (reachableEvents == null){
            reachableEvents = problem.getEventsSet();
        }
        if (reachableProcesses == null){
            reachableProcesses = problem.getProcessesSet();
        }
        final Pair<State, Collection<TransitionGround>> stateCollectionPair = intelligentSimulation(current_node.s, problem, planningDelta, executionDelta,true);
        if (stateCollectionPair != null) {
            queue_successor(frontier, stateCollectionPair.getFirst(), current_node, stateCollectionPair.getSecond(), g);//this could be done in a smarter way
        }
    }

      public LinkedList<TransitionGround> idastar(EPddlProblem problem, boolean checkAlongPrefix, boolean showExpansion, boolean idaStarWithMemory) throws Exception {
        return idastar(problem, checkAlongPrefix, showExpansion, idaStarWithMemory, Long.MAX_VALUE);
    }
    public LinkedList<TransitionGround> idastar(EPddlProblem problem, boolean checkAlongPrefix) throws Exception {
        return idastar(problem, checkAlongPrefix, false, false, Long.MAX_VALUE);
    }
    public LinkedList<TransitionGround> idastar(EPddlProblem problem, boolean checkAlongPrefix, long timeout) throws Exception {
        return idastar(problem, checkAlongPrefix, false, false, timeout);
    }

    public LinkedList<TransitionGround> idastar(EPddlProblem problem, boolean checkAlongPrefix, boolean showExpansion, boolean idaStarWithMemory, long timeout) throws Exception {
        State initState = problem.getInit();

        beginningTime = System.currentTimeMillis();
        previousTime = beginningTime;
        if (!initState.satisfy(problem.globalConstraints)) {
            out.println("Initial State is not valid");
            return null;
        }
        deadEndsDetected = 0;
        constraintsViolations = 0;
        out.println("Reachable actions and processes: |A U P U E|:" + TransitionGround.totNumberOfTransitions);
//        setupReachableActionsProcesses(problem);//this maps actions in the heuristic with the action in the execution model
        setHeuristicCpuTime(0);
        setNodesReopened(0);
        setNodesExpanded(0);
        this.setEvaluatedStates(0);

        Float hAtInit = getHeuristic().computeEstimate(initState);
        out.println("h(n = s_0)=" + hAtInit);//debugging information

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
        for (;;) {
            res = boundedDepthFirstSearch(problem, bound, false, checkAlongPrefix, showExpansion, idaStarWithMemory,timeout);
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
    
        public LinkedList<TransitionGround> dfsbnb(EPddlProblem problem) throws Exception {
            return this.dfsbnb(problem, false);
        }

    

    public LinkedList<TransitionGround> dfsbnb(EPddlProblem problem, boolean memory) throws Exception {
        State initState = problem.getInit();
        beginningTime = System.currentTimeMillis();
        previousTime = beginningTime;
        if (!initState.satisfy(problem.globalConstraints)) {
            out.println("Initial State is not valid");
            return null;
        }
        deadEndsDetected = 0;
        constraintsViolations = 0;
        out.println("Reachable actions and processes: |A U P U E|:" + TransitionGround.totNumberOfTransitions);
//        setupReachableActionsProcesses(problem);//this maps actions in the heuristic with the action in the execution model
        setHeuristicCpuTime(0);
        setNodesReopened(0);
        setNodesExpanded(0);
        this.setEvaluatedStates(0);
        if (memory) {
            idaStar = new Object2FloatOpenHashMap<>();
        }

        long startSearch = System.currentTimeMillis();

        final Pair<IdaStarSearchNode, Float> res = boundedDepthFirstSearch(problem, depthLimit, true, true,memory);
        setOverallSearchTime((System.currentTimeMillis() - startSearch));
        if (res != null) {
            return this.extractPlan(res.getFirst());
        }
        return null;

    }

    private boolean onThePath(State successorState, SimpleSearchNode father) {
        while (father != null) {
            if (father.s.equals(successorState)) {
                return true;
            }
            father = father.father;
        }
        return false;
    }

    private Pair<IdaStarSearchNode, Float> boundedDepthFirstSearch(EPddlProblem problem, float bound, boolean anytime, boolean checkAlongPrefix,boolean memory) throws TimeoutException {
        return boundedDepthFirstSearch(problem, bound, anytime, checkAlongPrefix, false, memory, Long.MAX_VALUE);
    }

    private Pair<IdaStarSearchNode, Float> boundedDepthFirstSearch(EPddlProblem problem, float bound, boolean anytime, boolean checkAlongPrefix, boolean showExpansion, boolean idastarWithMemory,long timeout) throws TimeoutException {
        final Stack<IdaStarSearchNode> frontier = new Stack();

        IdaStarSearchNode init = new IdaStarSearchNode(problem.getInit().clone(), null, null, 0);
        causalDeadEnds = 0;
        frontier.push(init);
        float newBound = Float.POSITIVE_INFINITY;
        out.println("f(n): " + bound + "(Expanded Nodes: " + getNodesExpanded() + ")");
        out.println("-------------------(Dead-Ends: " + deadEndsDetected + ")");
        IdaStarSearchNode bestSol = null;
        while (!frontier.isEmpty()) {
            final IdaStarSearchNode node = frontier.pop();
            long now = System.currentTimeMillis();
            if (now - this.beginningTime > timeout){
                throw new TimeoutException("");
            }
            if ((now - previousTime) > 10000) {
                out.println("-------------Time: " + (now - this.beginningTime) / 1000 + "s ; Expanded Nodes: " + getNodesExpanded());
                out.println("-------------------(Dead-Ends: " + deadEndsDetected + ")");
                this.previousTime = now;
            }
            final float g;
            if (node.transition != null) {
                g = problem.gValue(node.father.s, node.transition, node.s, node.gValue,problem.getMetric());
            } else {
                g = 0;
            }
            node.gValue = g;
            if (showExpansion) {
                out.println("Expansion:" + node.transition);
            }
//            out.println("------------");
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
                                out.println("Found solution of cost:" + bound);
                                bestSol = node;
                            } else {
                                return new Pair(node, newBound);
                            }
                        } else {

                            boolean atLeastOne = false;

                            for (final Iterator<Pair<State, Object>> it = problem.getSuccessors(node.s,getActionsToSearch(null,problem)); it.hasNext();) {
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

    Collection<TransitionGround> getActionsToSearch(SearchNode currentNode, PddlProblem problem){
        if (helpfulActionsPruning && currentNode != null){
            return currentNode.helpfulActions;
        }
        return heuristic.getTransitions(false);
    }

    private void updateTable(IdaStarSearchNode s, Float h) {
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

    public int getNodesReopened() {
        return nodesReopened;
    }

    public void setNodesReopened(int nodesReopened) {
        this.nodesReopened = nodesReopened;
    }

    public int getNodesExpanded() {
        return nodesExpanded;
    }

    public void setNodesExpanded(int nodesExpanded) {
        this.nodesExpanded = nodesExpanded;
    }

    public long getHeuristicCpuTime() {
        return heuristicCpuTime;
    }

    public void setHeuristicCpuTime(long heuristicCpuTime) {
        this.heuristicCpuTime = heuristicCpuTime;
    }

    public long getOverallSearchTime() {
        return overallSearchTime;
    }

    public void setOverallSearchTime(long overallSearchTime) {
        this.overallSearchTime = overallSearchTime;
    }

    public int getNumberOfEvaluatedStates() {
        return numberOfEvaluatedStates;
    }

    public void setNumberOfEvaluatedStates(int numberOfEvaluatedStates) {
        this.numberOfEvaluatedStates = numberOfEvaluatedStates;
    }

    public int getPriorityQueueSize() {
        return priorityQueueSize;
    }

    public void setPriorityQueueSize(int priorityQueueSize) {
        this.priorityQueueSize = priorityQueueSize;
    }

    public int getCausalDeadEnds() {
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

        public TieBreaker(SearchEngine.TieBreaking tb) {
            super();
            this.tb = tb;
            bfs = true;
        }

        public TieBreaker(SearchEngine.TieBreaking tieBreaking, boolean b) {
            this(tieBreaking);
            bfs = b;
        }

        @Override
        public int compare(SearchNode o1, SearchNode o2) {
            final SearchNode other = o2;
            final SearchNode a = o1;
            if (a.f == other.f) {
                switch (tb) {
                    case HIGHERG:
                        //                out.println(this.gValue);
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

package com.hstairs.ppmajal.search;

import com.hstairs.ppmajal.problem.State;
import it.unimi.dsi.fastutil.objects.Object2FloatMap;
import it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectHeapPriorityQueue;
import org.jgrapht.alg.util.Pair;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;

public class LazyWAStar extends WAStar{


    public LazyWAStar(boolean saveSearchSpace) {
        super(1, false, true, new TieBreaker(SearchEngine.TieBreaking.ARBITRARY), saveSearchSpace);
    }

    @Override
    public SimpleSearchNode search(SearchProblem problem, SearchHeuristic h, PrintStream out) {
        zeroCounters();
        final State initState = problem.getInit();

        final ObjectHeapPriorityQueue<SearchNode> frontier =
                new ObjectHeapPriorityQueue<>(tieBreaker);
        if (!problem.satisfyGlobalConstraints(initState)) {
            out.println("Initial State is not valid");
            return null;
        }
        long timeAtStart = System.currentTimeMillis();
        hAtInit = h.computeEstimate(initState);
        heuristicTime += System.currentTimeMillis() - timeAtStart;
        if (hAtInit == Float.MAX_VALUE) {
            deadEndsDetected++;
            return null;
        }else{
            nodesEvaluated++;
        }
        SearchNode init = new SearchNode(initState.clone(),
                0,hw*hAtInit,hAtInit, saveSearchSpace);
        if (this.helpfulActionsPruning) {
            init.helpfulActions = h.getTransitions(helpfulActionsPruning);
        }

        super.initHandle(init); //This is to inspect the search space if needed

        frontier.enqueue(init);

        Object2FloatMap<State> gValue = new Object2FloatOpenHashMap<>();
        gValue.put(initState, 0f);//The initial state is at 0 distance, of course.
        float bestf = 0;
        previous = 0;
        while (!frontier.isEmpty()) {
            final SearchNode currentNode = frontier.dequeue();
            if (currentNode.gValue == getPreviousCost(gValue, currentNode.s)){
                nodesExpanded++;
                long fromTheBeginning = (System.currentTimeMillis() - timeAtStart);
                final Boolean res = problem.goalSatisfied(currentNode.s);
                if (res == null) {//this means it is a dead-end
                    deadEndsDetected++;
                    continue;
                }else if (res) {
                    totalTime = (System.currentTimeMillis() - timeAtStart);
                    return currentNode;
                }
                final long start = System.currentTimeMillis();
                final float hValue = h.computeEstimate(currentNode.s);
                heuristicTime += System.currentTimeMillis() - start;
                bestf = printInfoDuringSearch(timeAtStart,out,bestf,fromTheBeginning,
                        nodesExpanded,nodesEvaluated,frontier,currentNode);
                for (final Iterator<Pair<State, Object>> it = problem.getSuccessors(currentNode.s,
                        getActionsToSearch(currentNode, problem, h)); it.hasNext();) {
                    final Pair<State, Object> next = it.next();
                    final State successorState = next.getFirst();
                    final Object act = next.getSecond();
                    final float successorG = problem.gValue(currentNode.s, act, successorState, currentNode.gValue);
                    if (Objects.equals(successorG, this.G_DEFAULT)) {
                        deadEndsDetected++;
                        continue;
                    }
                    switch (this.queueSuccessor(frontier, successorState, currentNode, act,
                            getPreviousCost(gValue, successorState), successorG, gValue, h, hw)) {
                        case inserted -> nodesEvaluated++;
                        case deadend -> deadEndsDetected++;
                        case duplicated -> duplicatedDetected++;
                    }
                }
            }
        }
        return null;
    }
    protected retCode queueSuccessor(Object frontier, State successorState,
                                     SearchNode current_node, Object actionsBefore,
                                     float prev_cost, float gSuccessor, Object2FloatMap<State> g, SearchHeuristic h,
                                     float hw) {
        if (Objects.equals(prev_cost, this.G_DEFAULT) || gSuccessor < prev_cost) {
            final long start = System.currentTimeMillis();
            final float hValue = h.computeEstimate(successorState);
            heuristicTime += System.currentTimeMillis() - start;
            if (hValue != Float.MAX_VALUE) {// && (d + succ_g) < this.depthLimit) {
                final SearchNode node = !optimality ?
                        new SearchNode(successorState, actionsBefore,
                                current_node, gSuccessor, hValue * hw, hValue, saveSearchSpace)
                        : new SearchNode(successorState, actionsBefore,
                        current_node, gSuccessor, hValue * hw + gSuccessor, hValue, saveSearchSpace);
                if (this.helpfulActionsPruning) {
                    node.helpfulActions = h.getTransitions(helpfulActionsPruning);
                }
                if (saveSearchSpace) {
                    current_node.add_descendant(node);
                }
                addInFrontier(frontier, node);
                g.put(successorState.getRepresentative(), gSuccessor);
                return retCode.inserted;
            } else {
                return retCode.deadend;
            }
        }
        return retCode.duplicated;
    }

}

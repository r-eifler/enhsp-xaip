package com.hstairs.ppmajal.search;

import com.hstairs.ppmajal.problem.State;

import java.io.PrintStream;
import java.util.LinkedList;

public abstract class SearchEngineClass {
    protected final float G_DEFAULT = Float.NaN;
    protected int deadEndsDetected;
    protected int nodesExpanded;
    protected int nodesEvaluated;
    protected int duplicatedDetected;
    //Timing information
    protected long totalTime;
    protected long heuristicTime;
    State lastState;
    final boolean helpfulActionsPruning;
    private SearchNode searchSpaceHandle;

    protected SearchEngineClass(boolean helpfulActionsPruning) {
        this.helpfulActionsPruning = helpfulActionsPruning;
    }
    public abstract SearchStats getStats();

    protected void zeroCounters() {
        deadEndsDetected = 0;
        nodesExpanded = 0;
        nodesEvaluated = 0;
        duplicatedDetected = 0;
        heuristicTime = 0;
    }

    public void initHandle(SearchNode init){
            searchSpaceHandle = init;//this needs to have an handle on the initial state for saving it into a json file

    }

    public abstract SimpleSearchNode search(SearchProblem p, SearchHeuristic h, PrintStream out);
    public LinkedList extractDecisions(SimpleSearchNode c) {
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
    Object[] getActionsToSearch(SimpleSearchNode currentNode, SearchProblem problem, SearchHeuristic h) {
        if (helpfulActionsPruning && currentNode != null) {
            return ((SearchNode)currentNode).helpfulActions;
        }
        return h.getTransitions(false);
    }

    public SearchNode getSearchSpaceHandle() {
        return searchSpaceHandle;
    }

    public record SearchStats(int nodesExpanded, int nodesEvaluated, int deadEnds, int duplicates, long searchTime, long heuristicTime) {
    }
}

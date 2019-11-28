package com.hstairs.ppmajal.heuristics.advanced;

import com.google.common.collect.Sets;
import com.hstairs.ppmajal.heuristics.Heuristic;
import com.hstairs.ppmajal.problem.EPddlProblem;
import com.hstairs.ppmajal.problem.State;
import com.hstairs.ppmajal.transition.TransitionGround;

import java.util.Collection;

public class Aibr implements Heuristic {
    private final EPddlProblem problem;

    public Aibr(EPddlProblem problem){
        this.problem = problem;
        Sets.SetView<TransitionGround> transitions = getTransitions(problem);


    }



    @Override
    public float computeEstimate(State s) {
        return 0;
    }

    @Override
    public Collection getTransitions(boolean helpful) {
        return null;
    }
}

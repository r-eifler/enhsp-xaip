/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hstairs.ppmajal.pddl.heuristics.advanced;

import com.hstairs.ppmajal.pddl.heuristics.BlindHeuristic;
import com.hstairs.ppmajal.problem.PDDLProblem;
import com.hstairs.ppmajal.problem.State;
/**
 *
 * @author enrico
 */
public class NNHeuristic extends BlindHeuristic{
    public NNHeuristic(PDDLProblem problem){
        super(problem);
    }

    public float computeEstimate(State gs) {
        return 0;

    }

  

    
    
}

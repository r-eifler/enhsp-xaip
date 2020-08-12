/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hstairs.ppmajal.pddl.heuristics.advanced;

import com.hstairs.ppmajal.problem.EPddlProblem;
import com.hstairs.ppmajal.problem.State;
import com.hstairs.ppmajal.transition.TransitionGround;
import java.util.Collection;

/**
 *
 * @author enrico
 */
public class LM extends H1{

    public LM(EPddlProblem problem){
        super(problem);
        
    }
    @Override
    public float computeEstimate(State s) {
        
        //Start necessary data structures
        
        //This is where the loop for getting landmarks starts
        
        //Here we should call the LP Solver
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection getTransitions(boolean onlyHelpful) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<TransitionGround> getAllTransitions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

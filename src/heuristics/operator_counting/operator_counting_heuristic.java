/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heuristics.operator_counting;

import conditions.Conditions;
import heuristics.Heuristic;
import java.util.Set;
import problem.GroundAction;
import problem.State;

/**
 *
 * @author enrico
 */
public class operator_counting_heuristic extends Heuristic {

    //this is meant to build the very basic data structures
    public operator_counting_heuristic(Conditions goal, Set<GroundAction> actions){
        super(goal,actions);
    }
    @Override
    public Float setup(State s_0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Float compute_estimate(State s_0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

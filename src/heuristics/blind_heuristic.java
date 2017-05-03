/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heuristics;

import conditions.Conditions;
import java.util.Set;
import problem.GroundAction;
import problem.GroundProcess;
import problem.State;

/**
 *
 * @author enrico
 */
public class blind_heuristic extends Aibr{

    public blind_heuristic(Conditions G, Set<GroundAction> A, Set<GroundProcess> P) {
        super(G, A, P);
    }
    
    public blind_heuristic(Conditions G, Set<GroundAction> A) {
        super(G, A);
    }



    @Override
    public Float compute_estimate(State s_0) {
        if (reachability){
            
            return super.compute_estimate(s_0);
            
        }
        if (s_0.satisfy(this.G))
                return 0f;
        else
            return 1f;
    }
    
}

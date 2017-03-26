/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heuristics.advanced;

import conditions.Conditions;
import java.util.LinkedHashSet;
import java.util.Set;
import problem.GroundAction;

/**
 *
 * @author dxli
 */
public class Absh extends Uniform_cost_search_H1_RC{
    
    public Absh(Conditions G, Set<GroundAction> A) {
        super(G, A);
        
        add_supportes(A);
    }

    private void add_supportes(Set<GroundAction> A) {
        System.out.println("\n\nDEBUG: #Actions, no supporters: "+A.size());
        this.A.addAll(generate_supporters(A));
        System.out.println("DEBUG: #Actions, with supporters: " + A.size() +"\n\n");
    }
    
    public LinkedHashSet<GroundAction> generate_supporters(Set<GroundAction> A){
        LinkedHashSet<GroundAction> actions_plus_action_for_supporters = new LinkedHashSet();
        
        return actions_plus_action_for_supporters;
    }
}

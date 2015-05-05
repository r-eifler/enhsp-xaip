/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package planning;

import computation.NumericPlanningGraph;
import conditions.Conditions;
import java.util.ArrayList;
import java.util.HashSet;
import plan.SimplePlan;
import problem.GroundAction;
import problem.State;

/**
 *
 * @author enrico
 */
public class BaselineForwardSearchPlanner {
    
    public SimplePlan plan(HashSet<GroundAction> actions, State init, Conditions goal ) throws CloneNotSupportedException{
        
        
        
        
        NumericPlanningGraph npg = new NumericPlanningGraph();
        ArrayList relaxedPlan = npg.computeRelaxedPlan(init, goal, actions);
        
        if (relaxedPlan != null){
            System.out.println("lunghezza piano prevista:"+relaxedPlan.size());
        }
        
        

        
        
        return null;
    }
    
}

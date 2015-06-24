/**
 * *******************************************************************
 * Description: Part of the PPMaJaL library
 *
 * Author: Enrico Scala 2013 Contact: enricos83@gmail.com
 *
 ********************************************************************
 */
package search;

import conditions.Comparison;
import conditions.Conditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import problem.GroundAction;
import problem.State;

/**
 *
 * @author enrico
 */
public class bottom_up_unit_cost extends Heuristics {

    public bottom_up_unit_cost(Conditions G, Set<GroundAction> A) {
        super(G, A);
    }


    
    public int compute_estimate(State s_0){
        //An accuracy parameter constraining the number of indirect dependencies.
        //strong_relaxation = true;
        this.achievers = new HashMap();

        HashMap<GroundAction, HashSet<Conditions>> impr_conditions = new HashMap();
        Map<Conditions, Integer> h = new HashMap();
        HashMap<Conditions, Boolean> already_added = new HashMap();
        LinkedHashSet<GroundAction> A1 = new LinkedHashSet();
        A1.addAll(A);
        //assuming it is an and condition
        
        int ret = Integer.MAX_VALUE;
        reachable = new LinkedHashSet();
        int counterActions = 0;
        while (true) {
            try {
                //this is for cost unit planning
                ret = this.check_goal_conditions(s_0, G, h);
                if (ret != Integer.MAX_VALUE) {
                    break;
                }
                if (A1.isEmpty()) {
                    break;
                }
                ArrayList<HeuristicSearchNode> q = new ArrayList();
                //for every action whose preconditions are evaluated,
                this.update_frontier(q, A1, h, s_0);
                
                if (q.isEmpty()) {
                    break;
                }
                
                HashSet<Comparison> toAdd = new HashSet();
                internal_update = false;
                boolean new_conditions_detected = this.update_prop_numeric_h(q, impr_conditions, already_added, s_0, A1, h, toAdd,true);
                //update the improvable condition
                impr_conditions = update_improvable(s_0, (HashSet<GroundAction>) A, A1, toAdd, impr_conditions, h, max_depth,true);
                if (!new_conditions_detected && !this.internal_update){
                    break;
                }
            } catch (Exception ex) {
                Logger.getLogger(bottom_up_unit_cost.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

        //System.out.println(ret);
        return ret;
    }



    

    
}
    
    

package heuristics.advanced;

import conditions.Comparison;
import conditions.Conditions;
import expressions.ExtendedNormExpression;
import org.w3c.dom.ls.LSException;
import problem.GroundAction;
import problem.State;

import java.util.*;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Created by Da An on 5/12/16.
 */
public class landmark_factory_RC extends landmarks_factory {

    //public LinkedHashSet<Comparison> redundant_constrains;

    public landmark_factory_RC(Conditions goal, Set<GroundAction> A) {

        super(goal, A);
        try {
            this.add_redundant_constrains(G.sons);
        } catch (Exception e) {
            Logger.getLogger(landmark_factory_RC.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            this.add_redundant_constrains(G.sons);
        } catch (Exception e) {
            Logger.getLogger(landmark_factory_RC.class.getName()).log(Level.SEVERE, null, e);
        }
        /*
        try {
            this.add_redundant_constrains(G.sons);
        } catch (Exception e) {
            Logger.getLogger(landmark_factory_RC.class.getName()).log(Level.SEVERE, null, e);
        }
        */

        //System.out.println("G.son: ");
        //System.out.println(G.sons.toString());
        //System.out.println("All conditoin: ");
        //System.out.println(all_conditions.toString());

    }



}

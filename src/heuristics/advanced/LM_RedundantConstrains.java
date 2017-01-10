package heuristics.advanced;

import conditions.Comparison;
import conditions.Conditions;
import expressions.ExtendedNormExpression;
import org.w3c.dom.ls.LSException;
import problem.GroundAction;
import problem.State;
import sun.tools.tree.GreaterExpression;

import java.util.*;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Created by Da An on 5/12/16.
 */
public class landmark_factory_RC extends UniformCostSearch_LM {

    //public LinkedHashSet<Comparison> redundant_constrains;

    public landmark_factory_RC(Conditions goal, Set<GroundAction> A) {

        super(goal, A);
        for (GroundAction a: A) {
            try {
                add_redundant_constrains(a.getPreconditions().sons);
            } catch (Exception e) {
                Logger.getLogger(landmark_factory_RC.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        try {
            add_redundant_constrains(G.sons);
        } catch (Exception e) {
            Logger.getLogger(landmark_factory_RC.class.getName()).log(Level.SEVERE, null, e);
        }

    }



}

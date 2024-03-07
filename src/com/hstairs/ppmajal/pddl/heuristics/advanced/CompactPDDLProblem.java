
package com.hstairs.ppmajal.pddl.heuristics.advanced;

import com.hstairs.ppmajal.conditions.Condition;
import com.hstairs.ppmajal.expressions.NumEffect;
import com.hstairs.ppmajal.transition.Transition;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author enrico
 */
public record CompactPDDLProblem(Condition[] preconditionFunction,
                                 Collection<Integer>[] propEffectFunction,
                                 Collection<NumEffect>[] numericEffectFunction,
                                 float[] actionCost, int numActions, int goal, ArrayList<Integer> goals, Collection<Integer>[] tr2CpTrMap, int[] cpTr2TrMap){

    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();
        for (int i=0; i< preconditionFunction.length; i++){
            ret.append("Transition: ").append(Transition.getTransition(cpTr2TrMap[i])).append("\n");
            ret.append("Precondition in the model:").append(preconditionFunction[i]).append("\n");
            ret.append("Effect in the model:").append(propEffectFunction[i]).append("\n");
            ret.append("Cost:").append(actionCost[i]).append("\n");
        }
        return ret.toString();
    }
    
}





/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package hstairs.ppmajal.pddl.heuristics.advanced;

import com.hstairs.ppmajal.conditions.Condition;
import com.hstairs.ppmajal.expressions.NumEffect;
import java.util.Collection;

/**
 *
 * @author enrico
 */
public record CompactPDDLProblem(Condition[] preconditionFunction,
                             Collection<Integer>[] propEffectFunction,
                             Collection<NumEffect>[] numericEffectFunction, 
                             float[] actionCost,int numActions,int goal){
}


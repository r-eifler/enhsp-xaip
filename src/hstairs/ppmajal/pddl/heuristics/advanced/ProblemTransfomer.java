/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hstairs.ppmajal.pddl.heuristics.advanced;

import com.hstairs.ppmajal.conditions.AndCond;
import com.hstairs.ppmajal.conditions.Comparison;
import com.hstairs.ppmajal.conditions.Condition;
import com.hstairs.ppmajal.conditions.OrCond;
import com.hstairs.ppmajal.conditions.Terminal;
import com.hstairs.ppmajal.expressions.NumEffect;
import com.hstairs.ppmajal.problem.PDDLProblem;
import com.hstairs.ppmajal.transition.Transition;
import com.hstairs.ppmajal.transition.TransitionGround;
import it.unimi.dsi.fastutil.ints.IntArraySet;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import org.apache.commons.lang3.tuple.Pair;

/**
 *
 * @author enrico
 */
public class ProblemTransfomer {
        private static Condition[] preconditionFunction;
        private static Collection<Integer>[] propEffectFunction;
        private static  Collection<NumEffect>[] numericEffectFunction;
        private static float[] actionCost;
        private static PDDLProblem p;
        private static Map<AndCond, Collection<IntArraySet>> redundantMap;
    
    public static Pair<CompactPDDLProblem,int[]> generateCompactProblem(PDDLProblem problem, String redConstraints){
        int nTransitions = Transition.totNumberOfTransitions+1;
        int pseudoGoal = nTransitions-1;
        p = problem;
        preconditionFunction = new Condition[nTransitions];
        propEffectFunction = new Collection[nTransitions];
        numericEffectFunction = new Collection[nTransitions];
        actionCost = new float[nTransitions];
        Arrays.fill(actionCost, Float.MAX_VALUE);
        preconditionFunction[pseudoGoal] = normalizeAndTighthenCondition(p.getGoals(), redConstraints);
        int[] actionMApping = new int[nTransitions];
        normalizeModel(redConstraints, new LinkedHashSet(p.actions));
        normalizeModel(redConstraints, new LinkedHashSet(p.getEventsSet()));
        normalizeModel(redConstraints, new LinkedHashSet(p.getProcessesSet()));
        return Pair.of(new CompactPDDLProblem(preconditionFunction,propEffectFunction,numericEffectFunction,actionCost,nTransitions,pseudoGoal),actionMApping);
    }
    
    private static void normalizeModel(String redConstraints, Collection<TransitionGround> transitions) {
        for (final TransitionGround b : transitions) {
            preconditionFunction[b.getId()] = normalizeAndTighthenCondition(b.getPreconditions(), redConstraints);

            final IntArraySet propositional = new IntArraySet();
            for (Terminal t : b.getAllAchievableLiterals()) {
                propositional.add(t.getId());
            }
            propEffectFunction[b.getId()] = propositional;
            numericEffectFunction[b.getId()] = b.getConditionalNumericEffects().getAllEffects();
            for (final NumEffect neff : numericEffectFunction[b.getId()]) {
                neff.normalize();
            }
            actionCost[b.getId()] = b.getActionCost(p.getInit(), p.getMetric(), p.isSdac());
            //TODO Add management for conditional effects
        }

    }
    
    private static Condition normalizeAndTighthenCondition(Condition preconditions, String redConstraints) {
        switch (redConstraints) {
            case "smart":
                if (redundantMap == null || redundantMap.isEmpty()) {
                    return preconditions.transformEquality();
                }
                return addSmartRedundantConstraints(preconditions.transformEquality());
            case "brute":
                return preconditions.transformEquality().introduce_red_constraints();
            default:
                return preconditions.transformEquality();
        }
    }
    private static Condition addSmartRedundantConstraints(Condition cond) {
        if (cond instanceof Terminal) {
            return cond;
        }
        if (cond instanceof OrCond) {
            Collection newOr = new HashSet();
            for (var v : ((OrCond) cond).sons) {
                newOr.add(addSmartRedundantConstraints((Condition) v));
            }
            return new OrCond(newOr);
        }
        if (cond instanceof AndCond) {
            Collection and = new HashSet();
            Collection<IntArraySet> get = redundantMap.get((AndCond) cond);
            for (var v : ((AndCond) cond).sons) {
                and.add((Condition) v);
            }
            if (get != null) {
                System.out.println("One Redundant Constraint added");
                for (var v : get) {
                    Comparison previous = null;
                    for (int i : v) {
                        if (previous != null) {
                            previous = AndCond.generateRedConstraints((Comparison) Comparison.getTerminal(i), previous);
                        } else {
                            previous = (Comparison) Comparison.getTerminal(i);
                        }

                    }
                    if (previous != null) {
                        and.add(previous);
                    }
                }
            }
            return new AndCond(and);
        } else {
            throw new RuntimeException("This was unexepected:" + cond);
        }

    }

}

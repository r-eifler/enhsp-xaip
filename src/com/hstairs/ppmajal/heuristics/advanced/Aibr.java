package com.hstairs.ppmajal.heuristics.advanced;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;
import com.google.common.collect.Sets;
import com.hstairs.ppmajal.conditions.Comparison;
import com.hstairs.ppmajal.conditions.Condition;
import com.hstairs.ppmajal.conditions.Terminal;
import com.hstairs.ppmajal.expressions.BinaryOp;
import com.hstairs.ppmajal.expressions.Expression;
import com.hstairs.ppmajal.expressions.NumEffect;
import com.hstairs.ppmajal.expressions.PDDLNumber;
import com.hstairs.ppmajal.heuristics.Heuristic;
import com.hstairs.ppmajal.problem.EPddlProblem;
import com.hstairs.ppmajal.problem.PDDLState;
import com.hstairs.ppmajal.problem.RelState;
import com.hstairs.ppmajal.problem.State;
import com.hstairs.ppmajal.transition.Transition;
import com.hstairs.ppmajal.transition.TransitionGround;
import it.unimi.dsi.fastutil.ints.*;
import it.unimi.dsi.fastutil.objects.ReferenceLinkedOpenHashSet;
import org.antlr.runtime.misc.IntArray;
import org.antlr.v4.runtime.atn.EpsilonTransition;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.function.Consumer;

import static com.google.common.collect.Range.*;

public class Aibr implements Heuristic {
    private final EPddlProblem problem;
    private final int numberOfSupporters;
    private final boolean reachability;
    private Condition[] preconditionFunction;
    private Collection<Integer>[] propEffectFunction;
    private Collection<NumEffect>[] numericEffectFunction;

    //The following are built around supporters
    private Int2ObjectMap<String> names = new Int2ObjectArrayMap();
    final Int2ObjectMap<Collection<Terminal>> propEffectMap = new Int2ObjectArrayMap();
    final Int2ObjectMap<Condition> preconditionFunctionMap = new Int2ObjectArrayMap<>();
    final Int2ObjectMap<Condition> asymptoticPreconditionFunctionMap = new Int2ObjectArrayMap<>();
    final Int2ObjectMap<NumEffect> numEffectMap = new Int2ObjectArrayMap<>();


    IdentityHashMap<Condition, TransitionGround> pre2transition = new IdentityHashMap<>();

    Collection<TransitionGround> reachableTransitions = null;

    public Aibr(EPddlProblem problem){
        this(problem,false);
    }
    public Aibr(EPddlProblem problem, boolean reachability){
        this.problem = problem;
        Sets.SetView<TransitionGround> transitions = getTransitions(problem);
        int id;
        for (TransitionGround tr : transitions){
            pre2transition.put(tr.getPreconditions(),tr);
            generatePropositionalAction(tr);
            generateNumericSupporters(tr);
        }
        numberOfSupporters = preconditionFunctionMap.keySet().size();
        this.reachability = reachability;
    }


    void generatePropositionalAction(TransitionGround tr){
        propEffectMap.put(preconditionFunctionMap.keySet().size(),tr.getAllAchievableLiterals());
        names.put(preconditionFunctionMap.keySet().size(),tr.getName()+"-Propositional");
        preconditionFunctionMap.put(preconditionFunctionMap.keySet().size(),tr.getPreconditions());
    }
    void generateNumericSupporters(TransitionGround tr){
        for (NumEffect effect : tr.getAllNumericEffects()) {
            effect.additive_relaxation = true;
            if ("assign".equals(effect.getOperator()) && effect.getRight().getInvolvedNumericFluents().isEmpty()) {
                        NumEffect assign = new NumEffect("assign");
                        assign.setFluentAffected(effect.getFluentAffected());
                        assign.setRight(effect.getRight());
                        numEffectMap.put(preconditionFunctionMap.keySet().size(), assign);
                        preconditionFunctionMap.put(preconditionFunctionMap.keySet().size(),tr.getPreconditions());
            }else{
                generateInfSupporter(effect,preconditionFunctionMap.keySet().size(),"+");
                names.put(preconditionFunctionMap.keySet().size(),tr.getName().concat("PlusInf"));
                preconditionFunctionMap.put(preconditionFunctionMap.keySet().size(),tr.getPreconditions());

                generateInfSupporter(effect,preconditionFunctionMap.keySet().size(),"-");
                names.put(preconditionFunctionMap.keySet().size(),tr.getName().concat("MinusInf"));
                preconditionFunctionMap.put(preconditionFunctionMap.keySet().size(),tr.getPreconditions());
            }

        }

    }

    private void generateInfSupporter(NumEffect effect, int idx, String s) {
        String disequality = "";
        Float asymptote = Float.MAX_VALUE;
        if ("+".equals(s)){
            switch (effect.getOperator()) {
                case "increase":
                    disequality = ">";
                    break;
                case "decrease":
                    disequality = "<";
                    break;
                case "assign":
                    disequality = ">";
                    break;
            }
        }else{
            asymptote = -Float.MAX_VALUE;
            switch (effect.getOperator()) {
                case "increase":
                    disequality = ">";
                    break;
                case "decrease":
                    disequality = "<";
                    break;
                case "assign":
                    disequality = ">";
                    break;
            }
        }
        generateSupporter(effect,idx,disequality,asymptote);
    }

    private void generateSupporter(NumEffect effect, int idx, String inequality, Float asymptote) {

        final Comparison indirectPrecondition;
        final Expression left;
        if (effect.getOperator().equals("assign")) {
            left = new BinaryOp(effect.getRight(), "-", effect.getFluentAffected(), true);
        } else {
            left = effect.getRight();
        }
        indirectPrecondition = (Comparison) Comparison.createComparison(inequality, left, new PDDLNumber(0),false).normalize();
        asymptoticPreconditionFunctionMap.put(idx,indirectPrecondition);
        NumEffect eff = new NumEffect("assign");
        eff.setFluentAffected(effect.getFluentAffected());
        eff.setRight(new PDDLNumber(asymptote));
        numEffectMap.put(idx,eff);

    }

    @Override
    public float computeEstimate(State s0) {

        PDDLState s = (PDDLState)s0;
        final RelState relState = s.relaxState();
        final IntArraySet supporters = new IntArraySet(ContiguousSet.create(closedOpen(0, numberOfSupporters), DiscreteDomain.integers()));
        final IntArraySet reacheableActions = new IntArraySet();
        boolean goalReached = false;
        boolean exit = false;

        while (!supporters.isEmpty()){
            final IntIterator iterator = supporters.iterator();
            final IntArraySet propAppliers = new IntArraySet();
            final IntArraySet numAppliers = new IntArraySet();
//            System.out.println(supporters.size());
            while (iterator.hasNext()) {
                int current = iterator.nextInt();
//                System.out.println("Supporters set:"+supporters.size());
                final Condition condition = preconditionFunctionMap.get(current);
                if (relState.satisfy(condition)){
                    //Prop effect
                    reacheableActions.add(pre2transition.get(condition).getId());
                    final Collection<Terminal> terminals = propEffectMap.get(current);
                    if (terminals != null && !terminals.isEmpty()) {
                        iterator.remove();
                        propAppliers.add(current);
                    }else{
                        final NumEffect numEffect = numEffectMap.get(current);
                        if (numEffect != null){
                            final Condition condition2 = asymptoticPreconditionFunctionMap.get(current);
                            if (condition2 == null || relState.satisfy(condition2)) {
                                iterator.remove();
                                numAppliers.add(current);
                            }
                        }
                    }
                }
            }
            if (numAppliers.isEmpty() && propAppliers.isEmpty() && !goalReached) {
                return Float.MAX_VALUE;
            }
            for (int current: propAppliers) {
                final Collection<Terminal> terminals = propEffectMap.get(current);
                relState.apply(terminals,relState.clone());
            }
            for (int current: numAppliers) {
                final NumEffect effect = numEffectMap.get(current);
                relState.apply(effect,relState.clone());
            }
            if (relState.satisfy(problem.goals)){
                goalReached = true;
                if (reachableTransitions != null){
                    break;
                }else{
                    if (numAppliers.isEmpty() && propAppliers.isEmpty()){
                         break;
                    }
                }
            }

        }
        if (reachableTransitions==null){
            reachableTransitions = new ArrayList<>();
            for (Integer reacheableAction : reacheableActions) {
                reachableTransitions.add((TransitionGround) Transition.getTransition(reacheableAction));
            }
        }
//        System.out.println("Computation done");
        if (goalReached){
            return fixPointComputation(reacheableActions,s.relaxState());
        }
        return Float.MAX_VALUE;
    }

    private float fixPointComputation(IntArraySet reachable, RelState s) {
        boolean fix_point = true;
        int counter = 0;
        int horizon = Integer.MAX_VALUE;
        while (counter <= horizon) {
            for (final int gr : reachable) {
                final TransitionGround transition = (TransitionGround) Transition.getTransition(gr);
                if (s.satisfy(transition.getPreconditions())) {
                    s.apply(transition, s.clone());
                    counter++;
                    if (s.satisfy(problem.getGoals())) {
                        return counter;
                    }
                }
            }
        }
        return Float.MAX_VALUE;
    }

    @Override
    public Collection getTransitions(boolean helpful) {
        return reachableTransitions;
    }
}

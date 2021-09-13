package com.hstairs.ppmajal.pddl.heuristics.advanced;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.hstairs.ppmajal.conditions.Comparison;
import com.hstairs.ppmajal.conditions.Condition;
import com.hstairs.ppmajal.conditions.Terminal;
import com.hstairs.ppmajal.expressions.BinaryOp;
import com.hstairs.ppmajal.expressions.Expression;
import com.hstairs.ppmajal.expressions.NumEffect;
import com.hstairs.ppmajal.expressions.PDDLNumber;
import com.hstairs.ppmajal.problem.PDDLProblem;
import com.hstairs.ppmajal.problem.PDDLState;
import com.hstairs.ppmajal.problem.RelState;
import com.hstairs.ppmajal.problem.State;
import com.hstairs.ppmajal.transition.Transition;
import com.hstairs.ppmajal.transition.TransitionGround;
import it.unimi.dsi.fastutil.ints.*;

import java.util.*;

import static com.google.common.collect.Range.closedOpen;
import java.io.PrintStream;
import com.hstairs.ppmajal.search.SearchHeuristic;

public class Aibr implements SearchHeuristic {

    private final PDDLProblem problem;
    private final int numberOfSupporters;
    private final boolean reachability;
    private final int[] supporter2transition;
    private final Collection<Terminal>[] supporter2propeffect;
    private final NumEffect[] supporter2numeffect;
    private final Condition[] supporter2aymptoticeffects;
    private final PrintStream out;
    //The following are built around supporters
    private final Int2ObjectMap<String> names = new Int2ObjectArrayMap();
    Collection<TransitionGround> reachableTransitions = null;
    private boolean DEBUG = false;

    public Aibr(PDDLProblem problem) {
        this(problem, false);
    }

    public Aibr(PDDLProblem problem, boolean reachability) {
        final Int2ObjectMap<Collection<Terminal>> propEffectMap = new Int2ObjectArrayMap();
        final Int2IntArrayMap supporter2transitionMap = new Int2IntArrayMap();
        final Int2ObjectMap<Condition> asymptoticPreconditionFunctionMap = new Int2ObjectArrayMap<>();
        final Int2ObjectMap<NumEffect> numEffectMap = new Int2ObjectArrayMap<>();
        out = problem.out;
        this.problem = problem;
        for (final TransitionGround tr : problem.getTransitions()) {           
            generateNumericSupporters(tr, supporter2transitionMap, asymptoticPreconditionFunctionMap, numEffectMap);
            generatePropositionalAction(tr, supporter2transitionMap, propEffectMap);
        }
        numberOfSupporters = supporter2transitionMap.keySet().size();
        //This maps action to their precondition
        supporter2transition = new int[numberOfSupporters];
       
        supporter2transitionMap.forEach((integer, integer1) -> supporter2transition[integer] = integer1);

        supporter2propeffect = new Collection[numberOfSupporters];
        propEffectMap.forEach((integer, terminals) -> supporter2propeffect[integer] = terminals);
        supporter2aymptoticeffects = new Condition[numberOfSupporters];
        asymptoticPreconditionFunctionMap.forEach((integer, condition) -> supporter2aymptoticeffects[integer] = condition);
        supporter2numeffect = new NumEffect[numberOfSupporters];
        numEffectMap.forEach((integer, numEffect) -> supporter2numeffect[integer] = numEffect);

        if (true) {
            for (int i = 0; i < numberOfSupporters; i++) {
                Collection<Terminal> propEffects = supporter2propeffect[i];
                NumEffect numEffect = supporter2numeffect[i];
                if (propEffects != null && numEffect != null) {
                    throw new RuntimeException("Bug in the function");
                } else {
//                    Condition precondition = preconditionFunction[i];
//                    System.out.println("Supporter: " + pre2transition.get(precondition).getName());
//                    System.out.println("Precondition: " + precondition);
//                    System.out.println("propEffects: " + propEffects);
//                    System.out.println("numEffects: " + numEffect);

                }
            }
        }

        this.reachability = reachability;
//
//        out.println("AIBR :: Number of Supporters = " + numberOfSupporters);

    }

    void generatePropositionalAction(TransitionGround tr, Int2IntArrayMap supporter2transitionMap, Int2ObjectMap<Collection<Terminal>> propEffectMap) {
        Collection<Terminal> allAchievableLiterals = tr.getAllAchievableLiterals();
        if (!allAchievableLiterals.isEmpty()) {
            propEffectMap.put(supporter2transitionMap.keySet().size(), allAchievableLiterals);
            names.put(supporter2transitionMap.keySet().size(), tr.getName() + "-Propositional");
            supporter2transitionMap.put(supporter2transitionMap.keySet().size(), tr.getId());
        }
    }

    boolean generateNumericSupporters(TransitionGround tr, Int2IntArrayMap supporter2transitionMap, Int2ObjectMap<Condition> asymptoticPreconditionFunctionMap, Int2ObjectMap<NumEffect> numEffectMap) {
        for (NumEffect effect : tr.getAllNumericEffects()) {
            if (effect == null) {
                return false;
            }
        }
        for (NumEffect effect : tr.getAllNumericEffects()) {
            
            //TO FIX. The assignment to an undefined value is not tried!!
            
            effect.additive_relaxation = true;
            if ("assign".equals(effect.getOperator()) && effect.getRight().getInvolvedNumericFluents().isEmpty()) {
                NumEffect assign = new NumEffect("assign");
                assign.setFluentAffected(effect.getFluentAffected());
                assign.setRight(effect.getRight());
                names.put(supporter2transitionMap.keySet().size(), tr.getName() + "-assign");
                numEffectMap.put(supporter2transitionMap.keySet().size(), assign);
                supporter2transitionMap.put(supporter2transitionMap.keySet().size(), tr.getId());
            } else {
                final boolean empty = effect.getRight().getInvolvedNumericFluents().isEmpty();
                if (empty) {
                    final double right = effect.getRight().eval(problem.getInit());
                    if (right > 0 && effect.getOperator().equals("increase")
                            || right < 0 && effect.getOperator().equals("decrease")) {
                        generateInfSupporter(effect, supporter2transitionMap, supporter2transitionMap.keySet().size(), "+", asymptoticPreconditionFunctionMap, numEffectMap, tr);
                    } else {
                        generateInfSupporter(effect, supporter2transitionMap, supporter2transitionMap.keySet().size(), "-", asymptoticPreconditionFunctionMap, numEffectMap, tr);
                    }
                } else {
                    generateInfSupporter(effect, supporter2transitionMap, supporter2transitionMap.keySet().size(), "+", asymptoticPreconditionFunctionMap, numEffectMap, tr);
                    generateInfSupporter(effect, supporter2transitionMap, supporter2transitionMap.keySet().size(), "-", asymptoticPreconditionFunctionMap, numEffectMap, tr);
                }
            }
        }
        return false;
    }

    private void generateInfSupporter(NumEffect effect, Int2IntArrayMap supporter2transitionMap, int idx, String s, Int2ObjectMap<Condition> asymptoticPreconditionFunctionMap, Int2ObjectMap<NumEffect> numEffectMap, TransitionGround tr) {
        String disequality = "";
        Float asymptote = Float.MAX_VALUE;
        if ("+".equals(s)) {
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
        } else {
            asymptote = -Float.MAX_VALUE;
            switch (effect.getOperator()) {
                case "increase":
                    disequality = "<";
                    break;
                case "decrease":
                    disequality = ">";
                    break;
                case "assign":
                    disequality = "<";
                    break;
            }
        }
        generateSupporter(effect, idx, disequality, asymptote, asymptoticPreconditionFunctionMap, numEffectMap);
        names.put(idx, tr.getName().concat(s + "Inf"));
        supporter2transitionMap.put(idx, tr.getId());
    }

    private void generateSupporter(NumEffect effect, int idx, String inequality, Float asymptote, Int2ObjectMap<Condition> asymptoticPreconditionFunctionMap, Int2ObjectMap<NumEffect> numEffectMap) {

        final Comparison indirectPrecondition;
        final Expression left;
        if (effect.getOperator().equals("assign")) {
            left = new BinaryOp(effect.getRight(), "-", effect.getFluentAffected(), true);
        } else {
            left = effect.getRight();
        }
        indirectPrecondition = (Comparison) Comparison.comparison(inequality, left, new PDDLNumber(0), false).normalize();
        asymptoticPreconditionFunctionMap.put(idx, indirectPrecondition);
        NumEffect eff = new NumEffect("assign");
        eff.setFluentAffected(effect.getFluentAffected());
        eff.setRight(new PDDLNumber(asymptote));
        numEffectMap.put(idx, eff);
    }

    @Override
    public float computeEstimate(State s0) {
        final PDDLState s = (PDDLState) s0;
        final RelState relState = s.relaxState();
        final IntArraySet supporters = new IntArraySet(ContiguousSet.create(closedOpen(0, numberOfSupporters), DiscreteDomain.integers()));
        final IntArrayList reachableActionsThisStage = new IntArrayList();
        boolean goalReached = false;
        if (DEBUG) {
            System.out.println("Supporters");
            for (int ele = 0; ele < numberOfSupporters; ele++) {
                System.out.println(names.get(ele));
            }
        }
        final BitSet conditionSatisfied = new BitSet();
        final BitSet actionInserted = new BitSet();
        while (!supporters.isEmpty()) {
            final IntIterator iterator = supporters.iterator();
            final IntArrayList propAppliers = new IntArrayList();
            final IntArrayList numAppliers = new IntArrayList();
            while (iterator.hasNext()) {
                int current = iterator.nextInt();
                if (DEBUG) {
                    System.out.println(relState);
                }
                final TransitionGround tr = (TransitionGround) Transition.getTransition(supporter2transition[current]);
                final boolean b = conditionSatisfied.get(current);
                if (b || relState.satisfy(tr.getPreconditions())) {
                    if (!b){
                        conditionSatisfied.set(current,true);
                    }
                    final int id = tr.getId();
                    if (!actionInserted.get(id)) {
                        if (DEBUG) {
                            System.out.println(names.get(current));
                        }
                        reachableActionsThisStage.add(id);
                        actionInserted.set(id, true);
                    }
                    //Prop effect
                    final Collection<Terminal> terminals = supporter2propeffect[current];
                    if (terminals != null && !terminals.isEmpty()) {
                        iterator.remove();
                        propAppliers.add(current);
                    } else {
                        final NumEffect numEffect = supporter2numeffect[current];
                        if (numEffect != null) {
                            final Condition condition2 = supporter2aymptoticeffects[current];
                            if (condition2 == null || relState.satisfy(condition2)) {
                                iterator.remove();
                                numAppliers.add(current);
                            }
                        }
                    }
                }
            }
            if (DEBUG) {
                System.out.println(relState);
            }

            if (relState.satisfy(problem.getGoals())) {
                goalReached = true;
                if (DEBUG){
                    System.out.println("Goal is reached");
                }
                if (reachableTransitions != null) {
                    break;
                } else {
                    if (numAppliers.isEmpty() && propAppliers.isEmpty()) {
                        break;
                    }
                }
            }
            if (numAppliers.isEmpty() && propAppliers.isEmpty() && !goalReached) {
                if (DEBUG) {
                   System.out.println("UNSAT");
                }
                return Float.MAX_VALUE;
            }
            for (final int current : propAppliers) {
                final Collection<Terminal> terminals = supporter2propeffect[current];
                relState.apply(terminals, relState.clone());
            }
            for (final int current : numAppliers) {
                final NumEffect effect = supporter2numeffect[current];
                relState.apply(effect, relState.clone());
            }
        }

        
        if (reachableTransitions == null) {
            reachableTransitions = new LinkedHashSet<>();
            for (final int reacheableAction : reachableActionsThisStage) {
                reachableTransitions.add((TransitionGround) Transition.getTransition(reacheableAction));
            }
            reachableTransitions = new ArrayList<>(reachableTransitions);
            if (reachability) {
                return 0;
            }

        }
        if (DEBUG){
            System.err.println("Computing actual estimate using the following transitions:"+reachableTransitions);
        }
        if (goalReached) {
            return fixPointComputation(reachableTransitions, s.relaxState());
        }
        return Float.MAX_VALUE;
    }

    private float fixPointComputation(Collection<TransitionGround> reachable, RelState s) {
        int counter = 0;
        int horizon = Integer.MAX_VALUE;
        BitSet applicable = new BitSet();
        while (counter <= horizon) {
            if (s.satisfy(problem.getGoals())) {
                return counter;
            }
            for (var transition : reachable) {
                final boolean b = applicable.get(transition.getId());
                if (b || s.satisfy(transition.getPreconditions())) {
                    if (!b) {
                        applicable.set(transition.getId(), true);
                    }
                    s.apply(transition, (RelState) s.clone());
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
    public Collection<TransitionGround> getAllTransitions() {
        if (reachableTransitions == null) {
            throw new RuntimeException("Helpful Transitions can only be activatated in combination with the relaxed plan extraction");
        }
        return reachableTransitions;
    }

    @Override
    public Object[] getTransitions(boolean helpful) {
        return problem.actions.toArray();
    }
}

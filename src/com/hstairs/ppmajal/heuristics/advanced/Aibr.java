package com.hstairs.ppmajal.heuristics.advanced;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
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

import java.util.*;

import static com.google.common.collect.Range.closedOpen;
import java.io.PrintStream;

public class Aibr implements Heuristic {
    private final EPddlProblem problem;
    private final int numberOfSupporters;
    private final boolean reachability;
    private final Condition[] transition2precondition;
    private final Collection<Terminal>[] transition2propeffect;
    private final NumEffect[] transition2numeffect;
    private final Condition[] transition2asymptoticprecondition;
    private final PrintStream out;
    //The following are built around supporters
    private Int2ObjectMap<String> names = new Int2ObjectArrayMap();
    IdentityHashMap<Condition, Collection< TransitionGround>> pre2transition = new IdentityHashMap<>();
    Collection<TransitionGround> reachableTransitions = null;
    private boolean DEBUG = false;

    public Aibr(EPddlProblem problem){
        this(problem,false);
    }
    public Aibr(EPddlProblem problem, boolean reachability){
        final Int2ObjectMap<Collection<Terminal>> propEffectMap = new Int2ObjectArrayMap();
        final Int2ObjectMap<Condition> preconditionFunctionMap = new Int2ObjectArrayMap<>();
        final Int2ObjectMap<Condition> asymptoticPreconditionFunctionMap = new Int2ObjectArrayMap<>();
        final Int2ObjectMap<NumEffect> numEffectMap = new Int2ObjectArrayMap<>();
        out = problem.out;
        this.problem = problem;
        for (final TransitionGround tr : getTransitions(problem)) {
            Collection<TransitionGround> get = pre2transition.get(tr.getPreconditions());
            if (get != null){
                get.add(tr);
                System.out.println("It does happen!!!");
            }else{
                pre2transition.put(tr.getPreconditions(), Arrays.asList(tr));
            }
            final boolean numericInconsistence = generateNumericSupporters(tr, preconditionFunctionMap, asymptoticPreconditionFunctionMap, numEffectMap);
            generatePropositionalAction(tr, preconditionFunctionMap, propEffectMap);
        }
        numberOfSupporters = preconditionFunctionMap.keySet().size();
        //This maps action to their precondition
        transition2precondition = new Condition[numberOfSupporters];
        preconditionFunctionMap.forEach((integer, condition) -> transition2precondition[integer]=condition);
        transition2propeffect = new Collection[numberOfSupporters];
        propEffectMap.forEach((integer, terminals) -> transition2propeffect[integer]=terminals);
        transition2asymptoticprecondition = new Condition[numberOfSupporters];
        asymptoticPreconditionFunctionMap.forEach((integer, condition) -> transition2asymptoticprecondition[integer]=condition);
        transition2numeffect = new NumEffect[numberOfSupporters];
        numEffectMap.forEach((integer, numEffect) -> transition2numeffect[integer]=numEffect);

        if (true){
            for (int i=0; i<numberOfSupporters;i++){
                Collection<Terminal> propEffects = transition2propeffect[i];
                NumEffect numEffect = transition2numeffect[i];
                if (propEffects != null && numEffect != null){
                    throw new RuntimeException("Bug in the function");
                }else{
//                    Condition precondition = preconditionFunction[i];
//                    System.out.println("Supporter: " + pre2transition.get(precondition).getName());
//                    System.out.println("Precondition: " + precondition);
//                    System.out.println("propEffects: " + propEffects);
//                    System.out.println("numEffects: " + numEffect);

                }     
            }
        }
        
        this.reachability = reachability;

        out.println("AIBR :: Number of Supporters = "+numberOfSupporters);
        
    }


    void generatePropositionalAction(TransitionGround tr, Int2ObjectMap<Condition> preconditionFunctionMap, Int2ObjectMap<Collection<Terminal>> propEffectMap){
        Collection<Terminal> allAchievableLiterals = tr.getAllAchievableLiterals();
        if (!allAchievableLiterals.isEmpty()) {
            propEffectMap.put(preconditionFunctionMap.keySet().size(), allAchievableLiterals);
            names.put(preconditionFunctionMap.keySet().size(), tr.getName() + "-Propositional");
            preconditionFunctionMap.put(preconditionFunctionMap.keySet().size(), tr.getPreconditions());
        }
    }
    boolean generateNumericSupporters(TransitionGround tr, Int2ObjectMap<Condition> preconditionFunctionMap, Int2ObjectMap<Condition> asymptoticPreconditionFunctionMap, Int2ObjectMap<NumEffect> numEffectMap){
//        for (NumEffect effect : tr.getAllNumericEffects()) {
//            if (effect == null) {
//                return false;
//            }
//        }
        for (NumEffect effect : tr.getAllNumericEffects()) {
            effect.additive_relaxation = true;
            if ("assign".equals(effect.getOperator()) && effect.getRight().getInvolvedNumericFluents().isEmpty()) {
                        NumEffect assign = new NumEffect("assign");
                        assign.setFluentAffected(effect.getFluentAffected());
                        assign.setRight(effect.getRight());
                        names.put(preconditionFunctionMap.keySet().size(),tr.getName()+"-assign");
                        numEffectMap.put(preconditionFunctionMap.keySet().size(), assign);
                        preconditionFunctionMap.put(preconditionFunctionMap.keySet().size(),tr.getPreconditions());
            }else{
                final boolean empty = effect.getRight().getInvolvedNumericFluents().isEmpty();
                if (empty ){ 
                    final double right = effect.getRight().eval(problem.getInit());
                    if (right > 0 && effect.getOperator().equals("increase") ||
                        right < 0 && effect.getOperator().equals("decrease")){
                        generateInfSupporter(effect, preconditionFunctionMap, preconditionFunctionMap.keySet().size(), "+", asymptoticPreconditionFunctionMap, numEffectMap, tr);
                    }else{
                        generateInfSupporter(effect, preconditionFunctionMap, preconditionFunctionMap.keySet().size(), "-", asymptoticPreconditionFunctionMap, numEffectMap, tr);
                    }
                }else {
                    generateInfSupporter(effect, preconditionFunctionMap, preconditionFunctionMap.keySet().size(), "+", asymptoticPreconditionFunctionMap, numEffectMap, tr);
                    generateInfSupporter(effect, preconditionFunctionMap, preconditionFunctionMap.keySet().size(), "-", asymptoticPreconditionFunctionMap, numEffectMap, tr);
                }
            }
        }
        return false;
    }

    private void generateInfSupporter(NumEffect effect, Int2ObjectMap<Condition> preconditionFunctionMap, int idx, String s, Int2ObjectMap<Condition> asymptoticPreconditionFunctionMap, Int2ObjectMap<NumEffect> numEffectMap, TransitionGround tr) {
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
        generateSupporter(effect,idx,disequality,asymptote,asymptoticPreconditionFunctionMap,numEffectMap);
        names.put(idx,tr.getName().concat(s+"Inf"));
        preconditionFunctionMap.put(idx,tr.getPreconditions());
    }

    private void generateSupporter(NumEffect effect, int idx, String inequality, Float asymptote, Int2ObjectMap<Condition> asymptoticPreconditionFunctionMap, Int2ObjectMap<NumEffect> numEffectMap) {

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
        final PDDLState s = (PDDLState)s0;
        final RelState relState = s.relaxState();
        final IntArraySet supporters = new IntArraySet(ContiguousSet.create(closedOpen(0, numberOfSupporters), DiscreteDomain.integers()));
        final IntArrayList reachableActionsThisStage = new IntArrayList();
        boolean goalReached = false;
        if (DEBUG){
            System.out.println("Supporters");
            for (int ele=0; ele < numberOfSupporters; ele++){
                System.out.println(names.get(ele));
            }
        }
        final BitSet conditionSatisfied = new BitSet();
        final BitSet actionInserted = new BitSet();
        while (!supporters.isEmpty()){
            final IntIterator iterator = supporters.iterator();
            final IntArrayList propAppliers = new IntArrayList();
            final IntArrayList numAppliers = new IntArrayList();
//            out.println(supporters.size());
            while (iterator.hasNext()) {
                int current = iterator.nextInt();
                if (DEBUG) {System.out.println(relState);}
//                out.println("Supporters set:"+supporters.size());
                final Condition condition = transition2precondition[current];
                final boolean b = conditionSatisfied.get(current);
                if (b || relState.satisfy(condition)){
                    if (!b){
                        conditionSatisfied.set(current,true);
                    }
                    final Collection<TransitionGround> get = pre2transition.get(condition);
                    for (final TransitionGround g: get){
                        final int id = g.getId();
                        if (!actionInserted.get(id)){
                            if (DEBUG){System.out.println(names.get(current));}
                            reachableActionsThisStage.add(id);
                            actionInserted.set(id,true);
                        }
                        
                    }
                    //Prop effect
                    final Collection<Terminal> terminals = transition2propeffect[current];
                    if (terminals != null && !terminals.isEmpty()) {
                        iterator.remove();
                        propAppliers.add(current);
                    }else{
                        final NumEffect numEffect = transition2numeffect[current];
                        if (numEffect != null){
                            final Condition condition2 = transition2asymptoticprecondition[current];
                            if (condition2 == null || relState.satisfy(condition2)) {
                                iterator.remove();
                                numAppliers.add(current);
                            }
                        }
                    }
                }
            }
            if (DEBUG)
                System.out.println(relState);
            
            if (numAppliers.isEmpty() && propAppliers.isEmpty() && !goalReached) {
                return Float.MAX_VALUE;
            }
            for (final int current: propAppliers) {
                final Collection<Terminal> terminals = transition2propeffect[current];
                relState.apply(terminals,relState.clone());
            }
            for (final int current: numAppliers) {
                final NumEffect effect = transition2numeffect[current];
                
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
            reachableTransitions = new LinkedHashSet<>();
            for (final int reacheableAction : reachableActionsThisStage) {
                reachableTransitions.add((TransitionGround) Transition.getTransition(reacheableAction));
            }
            reachableTransitions = new ArrayList<>(reachableTransitions);
            if (reachability){
                return 0;
            }

        }
        if (goalReached){
            return fixPointComputation(reachableTransitions,s.relaxState());
        }
        return Float.MAX_VALUE;
    }

    private float fixPointComputation(Collection<TransitionGround> reachable, RelState s) {
        int counter = 0;
        int horizon = Integer.MAX_VALUE;
        BitSet applicable = new BitSet();
        while (counter <= horizon) {                    
            for (var transition: reachable) {
                final boolean b = applicable.get(transition.getId());
                if (s.satisfy(transition.getPreconditions())){
                    if (!b){
                        applicable.set(transition.getId(),true);
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
        if (reachableTransitions == null){
            throw new RuntimeException("Helpful Transitions can only be activatated in combination with the relaxed plan extraction");
        }
        return reachableTransitions;
    }

    @Override
    public Collection getTransitions(boolean helpful) {
        return problem.actions;
    }
}

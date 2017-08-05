/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heuristics.advanced;

import conditions.AndCond;
import conditions.Comparison;
import conditions.Conditions;
import expressions.Expression;
import expressions.ExtendedNormExpression;
import expressions.Interval;
import expressions.NumEffect;
import expressions.PDDLNumber;
import heuristics.Aibr;
import heuristics.Heuristic;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import problem.GroundAction;
import problem.GroundProcess;
import problem.RelState;
import problem.State;

/**
 *
 * @author dxli
 */
public class Habs extends Heuristic {

    private static final Integer TYPE_UCSH1 = 1;
    private static final Boolean UPDATE_SUPPORTERS = false;
    private static final Boolean UPDATE_PARTITONMAP = false;
    private static final Boolean UPDATE_COST = false;

    private final Set<GroundProcess> processSet;

    private Integer numOfPartitions = 2;
    private Boolean settingUp = true;

    private HashMap<GroundAction, HashMap<Expression, HashMap<Interval, GroundAction>>> partitionMap = new HashMap();

    private h1 habs;

    public Habs(Conditions G, Set<GroundAction> A, Set<GroundProcess> P) {
        super(G, A, P);

        this.supporters = new LinkedHashSet<>();
        this.processSet = P;
    }

    @Override
    public Float setup(State s) {
        // reachablity analysis by AIBR
        Float ret = aibrReachabilityAnalysis(s);
        if (ret == Float.MAX_VALUE) {
            return ret;
        }

        // decomposition step
        buildPartitions(A, G, s);
        
        // subactioning step
        generate_supporters(s);
        
        // estimation for initial state
        setup_habs(s);
        ret = habs.compute_estimate(s);
        settingUp = false;
        
        return ret;
    }

    private Float aibrReachabilityAnalysis(State s) {
        // reachability analysis on original problem using AIBR.
        Aibr first_reachH = new Aibr(this.G, this.A);
        first_reachH.setup(s);
        first_reachH.set(true, true);
        Float ret = first_reachH.compute_estimate(s);
        A = first_reachH.reachable;
        reachable = first_reachH.reachable;

        return ret;
    }

    private void buildPartitions(Set<GroundAction> A, Conditions G, State s) {
        RelState rs = getRelaxedGoal(A, G, s);

        HashMap<Expression, HashMap<Interval, GroundAction>> tempMap;

        for (GroundAction gr : reachable) {
            Boolean has_linear_effect = false;

            if (gr.getNumericEffects() != null && !gr.getNumericEffects().sons.isEmpty()) {
                if (!partitionMap.containsKey(gr)) {
                    tempMap = new HashMap<>();
                } else {
                    tempMap = partitionMap.get(gr);
                }

                for (NumEffect effect : (Collection<NumEffect>) gr.getNumericEffects().sons) {
                    if (effect.getFluentAffected().getName().equals("total-cost")) {
                        continue;
                    }
                    
                    Expression rhs = effect.getRight();
                    if (!rhs.rhsFluents().isEmpty()) {
                        has_linear_effect = true;

                        HashMap<Interval, GroundAction> partForEffect = new HashMap<>();
                        addPartitions(partForEffect, effect, rs);
                        tempMap.put(rhs, partForEffect);
                    }
                }
                if (has_linear_effect) {
                    partitionMap.put(gr, tempMap);
                }
            }
        }
    }

    private RelState getRelaxedGoal(Set<GroundAction> A, Conditions G, State s) {
        Aibr aibr_handle = new Aibr(G, A);
        //aibr_handle
        aibr_handle.setup(s);
        return aibr_handle.get_reachable_state(s, s.relaxState());
    }

    private void addPartitions(HashMap<Interval, GroundAction> partForEffect, NumEffect effect, RelState rs) {
        Interval rhsInterval = effect.getRight().eval(rs);
        Float inf, sup;

        inf = rhsInterval.getInf().getNumber();
        sup = rhsInterval.getSup().getNumber();

        if (inf * sup >= 0) {
            // the reachable values contain negative or positive numbers only
            addPartitionForSinglePolarInterval(sup, inf, partForEffect);
        } else {
            // the reachable values contain both negative and positive numbers
            addPartitionForDualPolarsInterval(sup, inf, partForEffect);
        }
    }

    private LinkedList<Interval> addPartitionForSinglePolarInterval(Float sup, Float inf, HashMap<Interval, GroundAction> partForEffect) {
        Float strip;
        Interval temp;
        LinkedList<Interval> ret = new LinkedList<>();
        
        strip = (sup - inf) / numOfPartitions;
        for (int i = 0; i < numOfPartitions; i++) {
            
            temp = new Interval();
            temp.setInf(new PDDLNumber(inf + strip * i));
            temp.setSup(new PDDLNumber(inf + strip * (i + 1)));

            partForEffect.put(temp, null);

            ret.add(temp);
        }

        return ret;
    }

    private LinkedList<Interval> addPartitionForDualPolarsInterval(Float sup, Float inf, HashMap<Interval, GroundAction> partForEffect) {

        Interval temp;
        LinkedList<Interval> ret = new LinkedList<>();
        // TODO having 1 interval risks of unsolvability (e.g. counter). Is there any other way to do this? 
        Double numOfPartitionForEachPolarity = Math.ceil(numOfPartitions.doubleValue() / 2.0);
//        System.out.println(numOfPartitionForEachPolarity);
//        Double numOfPatitionForEachPolarity = 2.0;

        Float strip_neg = ((Double) (-inf / numOfPartitionForEachPolarity)).floatValue();
        Float strip_pos = ((Double) (sup / numOfPartitionForEachPolarity)).floatValue();

        for (int i = 0; i < numOfPartitionForEachPolarity; i++) {
            temp = new Interval();
            temp.setInf(new PDDLNumber(inf + strip_neg * i));
            temp.setSup(new PDDLNumber(inf + strip_neg * (i + 1)));

            partForEffect.put(temp, null);
            ret.add(temp);
        }

        for (int i = 0; i < numOfPartitionForEachPolarity; i++) {
            temp = new Interval();
            temp.setInf(new PDDLNumber(strip_pos * i));
            temp.setSup(new PDDLNumber(strip_pos * (i + 1)));

            partForEffect.put(temp, null);
            ret.add(temp);
        }

        return ret;
    }

    /**
     * Setup habs without reachability analysis.
     *
     * @param s
     */
    public void setup_habs(State s) {
        habs = (h1) habsFactory(TYPE_UCSH1, G, (Set<GroundAction>) this.supporters, processSet);
        habs.light_setup(s);
    }

    private static Heuristic habsFactory(Integer heuristicType, Conditions G, Set<GroundAction> A, Set<GroundProcess> P) {
        switch (heuristicType) {
            case (1): {
                return new h1(G, A, P);
            }
            default:
                return null;
        }
    }

    /**
     * <p>
     * Add supporters for each single effect of each action. Also build the
     * mapping from supporters to actions.
     *
     * <p>
     * This mapping is important because reachability analysis is done by
     * adaptive_ucs_h1, thus Habs needs this mapping to know what are the
     * reachable actions for the original problem.
     */
    private void generate_supporters(State s) {
        NumEffect effectOnCost = null;

        System.out.println("Generating supporters.");

        ArrayList<NumEffect> allConstantEffects = new ArrayList();

        for (GroundAction gr : reachable) {
            for (NumEffect effect : (Collection<NumEffect>) gr.getNumericEffects().sons) {
                if (effect.getFluentAffected().getName().equals("total-cost")) {
                    effectOnCost = (NumEffect) effect.clone();
                }
            }

            allConstantEffects.clear();
            if (gr.getNumericEffects() != null && !gr.getNumericEffects().sons.isEmpty()) {
                for (NumEffect effect : (Collection<NumEffect>) gr.getNumericEffects().sons) {
                    if (effect.getFluentAffected().getName().equals("total-cost")) {
                        continue;
                    }
                    // this is assuming linear effects at the moment.
                    if (!effect.getRight().rhsFluents().isEmpty()) {
                        // generate supporters for actions with linear numeric effects
                        generate_linear_supporter(s, effect, gr.toFileCompliant() + effect.getFluentAffected(), gr, effectOnCost);
                    } else {
                        allConstantEffects.add(effect);
                    }
                }
                // generate supporters for actions with constant effects
                if (!allConstantEffects.isEmpty()) {
                    generate_constant_supporter(allConstantEffects, gr.toFileCompliant(), gr, effectOnCost);
                }
            }

            // add propositional actions
            if ((gr.getAddList() != null && !gr.getAddList().sons.isEmpty()) || (gr.getDelList() != null && !gr.getDelList().sons.isEmpty())) {
                generate_propositional_action(gr.toFileCompliant() + " prop", gr.getPreconditions(), gr);
            }
        }

        System.out.println("Generating supporters finished.");
        System.out.println("|Sup + goal|: " + supporters.size());
    }

    /**
     * <p>
     * For each effect we have a set of supporters on each partition. For each
     * partition, there are 3 possible supporters. Which supporter to take is
     * "state-dependent":
     * <br> &nbsp &nbsp 1. if rhs &le lo, constant eff = lo;
     * <br> &nbsp &nbsp 2. if lo &le rhs &le hi, constant eff = rhs;
     * <br> &nbsp &nbsp 3. if hi &le rhs, constant eff = hi.
     *
     * @param effect linear effect to generate supporters for.
     * @param name a string used to distinguish between supporters for effects.
     * @param gr the grounded action.
     */
    private void generate_linear_supporter(State s, NumEffect effect, String name, GroundAction gr, NumEffect effectOnCost) {
        // partitioning
        HashMap<Interval, GroundAction> intervals = partitionMap.get(gr).get(effect.getRight());

        for (Interval interval : intervals.keySet()) {
            
            Float inf = interval.getInf().getNumber();
            Float sup = interval.getSup().getNumber();
            Expression constantIncrement;

            // three possible effects
            Float eval = (float) effect.getRight().eval(s).getNumber();
            String operator = effect.getOperator();
//            if (eval < inf) {
//                constantIncrement = new ExtendedNormExpression(inf);
//            } else if (eval <= sup) {
//                constantIncrement = new ExtendedNormExpression((inf + sup) / 2);
//            } else {
//                constantIncrement = new ExtendedNormExpression(sup);
//            }
            
            constantIncrement = new ExtendedNormExpression((inf + sup) / 2);
            GroundAction supporter = new GroundAction(name + " (" + inf.toString() + ',' + sup.toString() + ") " + " for " + effect.getFluentAffected().toString());

            // set up effect
            NumEffect supEff = new NumEffect(operator);
            supEff.setFluentAffected(effect.getFluentAffected());
            supEff.setRight(constantIncrement);

            // set effects for supporters
            supporter.getNumericEffects().sons.add(supEff);
            if (effectOnCost != null) {
                supporter.getNumericEffects().sons.add(effectOnCost);
            }

            // setup preconditions. Preconditions = (indirect_preconditions) U pre(gr)
            Comparison indirect_precondition_gt = new Comparison(">");
            Comparison indirect_precondition_lt = new Comparison("<=");

            indirect_precondition_gt.setRight(new PDDLNumber(inf));
            indirect_precondition_lt.setRight(new PDDLNumber(sup));
            indirect_precondition_gt.setLeft(effect.getRight());
            indirect_precondition_lt.setLeft(effect.getRight());

            indirect_precondition_gt.normalize();
            indirect_precondition_lt.normalize();

            // set pre-conditions for supporters
            supporter.getPreconditions().sons.add(indirect_precondition_lt);
            supporter.getPreconditions().sons.add(indirect_precondition_gt);
            supporter.setPreconditions(supporter.getPreconditions().and(gr.getPreconditions()));

            // add new supporter
            supporters.add(supporter);
            partitionMap.get(gr).get(effect.getRight()).put(interval, supporter);
        }
    }

    /**
     * <p>
     * Add supporters for constant numeric effect. Keep the right-hand side as
     * it is.
     *
     * @param effect constant effect to generate supporters for.
     * @param name a string to distinguish between effects.
     * @param gr the grounded action.
     */
    private void generate_constant_supporter(ArrayList<NumEffect> allConstantEffects, String name, GroundAction gr, NumEffect effectOnCost) {
        GroundAction sup = new GroundAction(name + " constant ");

        // add preconditions
        sup.setPreconditions(gr.getPreconditions());

        // add effect
        for (NumEffect effect : allConstantEffects) {
            sup.getNumericEffects().sons.add(effect);
        }

        if (effectOnCost != null) {
            sup.getNumericEffects().sons.add(effectOnCost);
        }

        supporters.add(sup);
    }

    private void generate_propositional_action(String name, Conditions cond, GroundAction gr) {
        GroundAction sup = new GroundAction(name);
        sup.setPreconditions(cond);
        sup.setAddList(gr.getAddList());
        sup.setDelList(gr.getDelList());

        supporters.add(sup);
    }

    @Override
    public Float compute_estimate(State s) {
//        if (!settingUp) {
//            if (UPDATE_PARTITONMAP) {
//                updatePartitionMap(s);
//                updateSupporters(s);
//            } else if (UPDATE_SUPPORTERS) {
//                updateSupporters(s);
//            }
//        }
        
        if (UPDATE_COST){
            updateActionCosts(s);
        }
        
        Float ret = habs.compute_estimate(s);
        
//        System.out.println(ret);
        
//        System.exit(0);
        
//        for(GroundAction gr : habs.A){
//            System.out.println("Supporter: " + gr.counter + " " + gr.toString());
////            System.out.println();
//        }
        
//        for(Map.Entry<Integer, LinkedHashSet<Comparison>> a : habs.possible_achievers.entrySet()){
//            System.out.print("Action: " + a.getKey() + " achieves: ");
//            for (Conditions c : a.getValue()){
//                System.out.print(c.getCounter() + ",");
//            }
//            System.out.println("");
//        }
        
//        System.out.println(habs.possible_achievers);
//        for(Conditions c:habs.all_conditions){
//            System.out.println("Condition: " + c.getCounter() + " " + c.toString());
//        }
//        if (ret == 0){
//            for (GroundAction gr:habs.A){
//                System.out.println(gr.toPDDL() + "\n\n");
//            }
//            for (GroundAction gr : partitionMap.keySet()){
//                for (Expression rhs : partitionMap.get(gr).keySet()){
//                    System.out.println(rhs);
//                    System.out.println(partitionMap.get(gr).get(rhs));
//                    System.out.println("\n");
//                }
//            }
////            System.exit(0);
//        }
        
        return ret;
    }
    
 
    private void updateActionCosts(State s) {
        for (GroundAction gr : habs.A) {
            gr.clearActionCost();
            gr.setAction_cost(s);
        }
    }
    
//
//    private void updatePartitionMap(State s) {
//
//        for (GroundAction gr : partitionMap.keySet()) {
//            HashMap<Expression, HashMap<Interval, GroundAction>> supMap = partitionMap.get(gr);
//
//            for (Expression rhs : supMap.keySet()) {
//                HashMap<Interval, GroundAction> intervalMap = supMap.get(rhs);
//                Float tempInf, tempSup;
//                Float inf = Float.MAX_VALUE;
//                Float sup = -Float.MAX_VALUE;
//
//                for (Interval interval : intervalMap.keySet()) {
//                    tempInf = interval.getInf().getNumber();
//                    tempSup = interval.getSup().getNumber();
//
//                    if (tempInf < inf) {
//                        inf = tempInf;
//                    }
//
//                    if (tempSup > sup) {
//                        sup = tempSup;
//                    }
//                }
//
//                Float rhsEval = rhs.eval(s).getNumber();
//                if (rhsEval < inf || rhsEval > sup) {
//
//                    // update reachable interval
//                    if (rhsEval < inf) {
//                        inf = rhsEval;
//                        
//                    } else {
//                        sup = rhsEval;
//                    }
//
//                    // get updated partition as a list
//                    LinkedList<Interval> tempIntervalList;
//                    if (inf * sup >= 0) {
//                        tempIntervalList = addPartitionForSinglePolarInterval(sup, inf, new HashMap<>());
//                    } else {
//                        tempIntervalList = addPartitionForDualPolarsInterval(sup, inf, new HashMap<>());
//                    }
//
//                    int i = 0;
//                    for (Interval interval : intervalMap.keySet()) {
//                        Interval newInterval = tempIntervalList.get(i);
//                        GroundAction tempSupporter = intervalMap.get(interval);
//                        
//                        interval.setInf(new PDDLNumber(newInterval.getInf().getNumber()));
//                        interval.setSup(new PDDLNumber(newInterval.getSup().getNumber()));
//                        
//                        Iterator it = tempSupporter.getPreconditions().sons.iterator();
//                        LinkedList<Object> sons = new LinkedList<>();
//                        while(it.hasNext()){
//                            sons.add(it.next());
//                        }
//                        tempSupporter.getPreconditions().sons.clear();
//                        
//                        for (Object cond : sons){
//                            if (cond instanceof AndCond){
//                                tempSupporter.getPreconditions().sons.add(cond);
//                            } else {
//                                Comparison c = (Comparison) cond;
//                                
//                                if (c.getComparator().equals(">")){
//                                    c.setRight(newInterval.getInf());
//                                    tempSupporter.getPreconditions().sons.add(c);
//                                } else {
//                                    // "<=" is normalized, so it's hard to directly change the right side, instead just add a new one.
//                                    Comparison indirect_precondition_lt = new Comparison("<=");
//                                    indirect_precondition_lt.setLeft(rhs);
//                                    indirect_precondition_lt.setRight(newInterval.getSup());
//                                    indirect_precondition_lt.normalize();
//                                    
//                                    // IMPORTANT! Otherwise will NOT work!!
//                                    indirect_precondition_lt.setCounter(c.getCounter());
//                                    tempSupporter.getPreconditions().sons.add(indirect_precondition_lt);
//                                }
//                            }
//                        }
//                        
//                        i++;
//                    }
//                }
//            }
//        }
//    }
    
//
//    private void updateSupporters(State s) {
//        for (GroundAction gr: partitionMap.keySet()) {
//            HashMap<Expression, HashMap<Interval, GroundAction>> actionMap = partitionMap.get(gr);
//            
//            for (Expression rhs : actionMap.keySet()) {
//                HashMap<Interval, GroundAction> intervalsMap = actionMap.get(rhs);
//                for (Interval interval : intervalsMap.keySet()) {
//
//                    Float inf = interval.getInf().getNumber();
//                    Float sup = interval.getSup().getNumber();
//                    
//                    Expression constantIncrement;
//
//                    // three possible effects
//                    Float eval = (float) rhs.eval(s).getNumber();
//                    if (eval < inf) {
//                        constantIncrement = new ExtendedNormExpression(inf);
//                    } else if (eval < sup) {
//                        constantIncrement = new ExtendedNormExpression((inf+sup)/2);
//                    } else {
//                        constantIncrement = new ExtendedNormExpression(sup);
//                    }
//                    
//                    GroundAction tempSup = intervalsMap.get(interval);
//                    // Safe to assume the first effect is the one we want, sons is a LinkedHashMap
//                    NumEffect tempEff = (NumEffect) tempSup.getNumericEffects().sons.iterator().next();
//                    tempEff.setRight(constantIncrement);
//                }
//            }
//        }
//    }

    // only for debugging
    public static void logging(String content) {
        String FILENAME = "/home/dxli/workspace/NetBeansProjects/expressive-numeric-heuristic-search-planner-enhsp-planner/abs_experiments/log.txt";

        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(FILENAME, true);
            bw = new BufferedWriter(fw);
            bw.write(content);

        } catch (IOException ex) {
            Logger.getLogger(Habs.class.getName()).log(Level.FINEST, null, ex);
        } finally {
            try {

                if (bw != null) {
                    bw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

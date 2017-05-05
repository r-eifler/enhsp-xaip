/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heuristics.advanced;

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
public class Habs extends Heuristic{
    private static final Integer TYPE_UCSH1 = 1;
    private static final Boolean UPDATE_SUPPORTERS = true;
    
    private Integer numOfPartitions = 2;
    private Boolean settingUp = true;
    
    private Set<GroundProcess> processSet;
    private HashMap<GroundAction, HashMap<Expression, LinkedList<Interval>>> partitionMap = new HashMap();
    private LinkedList<HashMap<Expression, HashMap<Interval, GroundAction>>> linearSupporters = new LinkedList<>();

    private h1 habs;
    
    public Habs(Conditions G, Set<GroundAction> A, Set<GroundProcess> P) {
        super(G, A, P);
        
        this.supporters = new LinkedHashSet<>();
        this.processSet = P;
    }
    
    @Override
    public Float setup(State s){
        // reachablity analysis by AIBR
        Float ret = aibrReachabilityAnalysis(s);        
        if (ret == Float.MAX_VALUE)
            return ret;
        
        // set action cost
        for (GroundAction gr: A){
            gr.setAction_cost(s);
        }
        
        // partitioning
        buildPartitions(A, G, s);
        
        // estimation for initial state
        setup_habs(s);
        ret = habs.compute_estimate(s);
        settingUp = false;
        
        return ret;
    }
    
    private Float aibrReachabilityAnalysis(State s){
        // reachability analysis on original problem using AIBR.
        Aibr first_reachH = new Aibr(this.G,this.A);
        first_reachH.setup(s);
        first_reachH.set(true, true);
        Float ret = first_reachH.compute_estimate(s);
        A = first_reachH.reachable;
        reachable = first_reachH.reachable;
        
        return ret;
    }
    
    private void buildPartitions(Set<GroundAction> A, Conditions G, State s) {
        RelState rs = getRelaxedGoal(A, G, s);
        
        Interval rhsInterval, temp;
        Float inf;
        Float sup;
        Float diff;
        Float strip;
        HashMap<Expression, LinkedList<Interval>> tempMap;
        
        for (GroundAction gr : reachable) {
            if (gr.getNumericEffects() != null && !gr.getNumericEffects().sons.isEmpty()) {
                if (!partitionMap.containsKey(gr)){
                    tempMap = new HashMap<>();
                } else {
                    tempMap = partitionMap.get(gr);
                }
                
                for (NumEffect effect : (Collection<NumEffect>) gr.getNumericEffects().sons) {        
                    Expression rhs = effect.getRight();
                    
                    if (!rhs.rhsFluents().isEmpty()) {
                        LinkedList<Interval> partForEffect = new LinkedList<>();
                        
                        rhsInterval = effect.getRight().eval(rs);
                        inf = rhsInterval.getInf().getNumber();
                        sup = rhsInterval.getSup().getNumber();
                        diff = sup - inf;
                        strip = diff / numOfPartitions;
                        
                            
                        for(int i=0;i<numOfPartitions;i++){
                           temp = new Interval();
                           temp.setInf(new PDDLNumber(inf + strip * i));
                           temp.setSup(new PDDLNumber(inf + strip * (i+1)));

                           partForEffect.add(temp);
                        }
                        
                        tempMap.put(rhs, partForEffect);
                    }
                }
                
                partitionMap.put(gr, tempMap);
            }
        }
    }
    
    private RelState getRelaxedGoal(Set<GroundAction> A, Conditions G, State s){
        Aibr aibr_handle = new Aibr(G, A);
        //aibr_handle
        aibr_handle.setup(s);
        return aibr_handle.get_reachable_state(s, s.relaxState());
    }
        
    /**
     * Setup habs without reachability analysis.
     * 
     * @param s 
     */
    public void setup_habs(State s){
        generate_supporters(s);
        
        habs = (h1) habsFactory(TYPE_UCSH1, G, (Set<GroundAction>) this.supporters, processSet);
        habs.light_setup(s);
    }
    
    private static Heuristic habsFactory(Integer heuristicType, Conditions G, Set<GroundAction> A, Set<GroundProcess> P){
        switch (heuristicType){
            case (1): {
                return new h1(G, A, P);
            }
            default :
                return null;
        }
    }
    
    /**
     * <p>Add supporters for each single effect of each action. Also
     * build the mapping from supporters to actions. 
     * 
     * <p>This mapping is important because reachability analysis is done by 
     * adaptive_ucs_h1, thus Habs needs this mapping to know what are the 
     * reachable actions for the original problem.
     */
    private void generate_supporters(State s){
        System.out.println("Generating supporters.");
        
        ArrayList<NumEffect> allConstantEffects = new ArrayList();
        
        for (GroundAction gr : reachable) {
            allConstantEffects.clear();
            if (gr.getNumericEffects() != null && !gr.getNumericEffects().sons.isEmpty()) {
                linearSupporters.add(new HashMap<>());
                
                for (NumEffect effect : (Collection<NumEffect>) gr.getNumericEffects().sons) {
                    if (effect.getFluentAffected().getName().equals("total-cost")){
                      // action costs are set in each call for compute_estimate()
                        continue;
                    }
                    if (!effect.getRight().rhsFluents().isEmpty()) {
                      // generate supporters for actions with linear numeric effects
                      generate_linear_supporter(s, effect, gr.toFileCompliant() + effect.getFluentAffected(), gr);    
                    } else {
                        allConstantEffects.add(effect);
                    }
                }
                // generate supporters for actions with constant effects
                if (!allConstantEffects.isEmpty()){
                    generate_constant_supporter(allConstantEffects, gr.toFileCompliant(), gr);    
                }
            }
            
            // add propositional actions
            if ((gr.getAddList() != null && !gr.getAddList().sons.isEmpty()) || (gr.getDelList() != null && !gr.getDelList().sons.isEmpty())) {
                 generate_propositional_action(gr.toFileCompliant() + "prop", gr.getPreconditions(), gr);
            }
        }
        
        System.out.println("Generating supporters finished.");
        System.out.println("|Sup + goal|: " + supporters.size());
        
    }
    
    /**
     * <p>For each effect we have a set of supporters on each partition. For each 
     * partition, there are 3 possible supporters. Which supporter to take is 
     * "state-dependent":
     *      <br> &nbsp &nbsp 1. if rhs &le lo, constant eff = lo;
     *      <br> &nbsp &nbsp 2. if lo &le rhs &le hi, constant eff = rhs;
     *      <br> &nbsp &nbsp 3. if hi &le rhs, constant eff = hi.
     * 
     * @param effect linear effect to generate supporters for.
     * @param name a string used to distinguish between supporters for effects.
     * @param gr the grounded action. 
     */
    private void generate_linear_supporter(State s, NumEffect effect, String name, GroundAction gr) {
        // for an action, each atomic numeric effect has a unique right-hand affected
        linearSupporters.get(linearSupporters.size()-1).put(effect.getRight(), new HashMap<>());

        // partitioning
        LinkedList<Interval> intervals = partitionMap.get(gr).get(effect.getRight());
        
        for(Interval interval : intervals){

            Float inf = interval.getInf().getNumber();
            Float sup = interval.getSup().getNumber();
            Expression constantIncrement;

            // three possible effects
            Float eval = (float) effect.getRight().eval(s).getNumber();
            String operator = effect.getOperator();
            if (eval < inf){
                constantIncrement = new ExtendedNormExpression(inf);
            } else if (eval < sup){
                constantIncrement = new ExtendedNormExpression(eval);
            } else {
                constantIncrement = new ExtendedNormExpression(sup);
            }
                                    
            GroundAction supporter = new GroundAction(name + " (" + inf.toString() + ',' + sup.toString() + ") " + " for " + effect.getFluentAffected().toString());

            // set up effect
            NumEffect supEff = new NumEffect(operator);
            supEff.setFluentAffected(effect.getFluentAffected());
            supEff.setRight(constantIncrement);

            // set effects for supporters
            supporter.getNumericEffects().sons.add(supEff);

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
            
            // set action cost to supporter
            supporter.setAction_cost(gr.getAction_cost());
            
            // add new supporter
            supporters.add(supporter);
            linearSupporters.get(linearSupporters.size()-1).get(effect.getRight()).put(interval, supporter);
        }
    }

    /**
     * <p> Add supporters for constant numeric effect. Keep the
     * right-hand side as it is.
     * 
     * @param effect constant effect to generate supporters for.
     * @param name a string to distinguish between effects.
     * @param gr the grounded action.
     */
    private void generate_constant_supporter(ArrayList<NumEffect> allConstantEffects, String name, GroundAction gr) {     
        GroundAction sup = new GroundAction(name + " constant ");
        
        // add preconditions
        sup.setPreconditions(gr.getPreconditions());
        
        for (NumEffect effect : allConstantEffects){
            // add effect
            sup.getNumericEffects().sons.add(effect);
        }

        // set action cost to supporter
        sup.setAction_cost(gr.getAction_cost());
        supporters.add(sup);
    }
    
    private void generate_propositional_action(String name, Conditions cond, GroundAction gr) {
        GroundAction sup = new GroundAction(name);
        sup.setPreconditions(cond);
        sup.setAddList(gr.getAddList());
        sup.setDelList(gr.getDelList());
        
        sup.setAction_cost(gr.getAction_cost());
        supporters.add(sup);
    }

    @Override
    public Float compute_estimate(State s) {
        if (UPDATE_SUPPORTERS && !settingUp){ 
            updateSupporters(s);
        }
        
        updateActionCosts(s);
        Float ret = habs.compute_estimate(s);      
        
        return ret;
    }
    
    private void updateActionCosts(State s){    
        for (GroundAction gr : habs.A){
            gr.setAction_cost(s);
        }    
    }
    
    private void updateSupporters(State s) {
        for(Integer action_counter = 0; action_counter < linearSupporters.size(); action_counter ++ ){
            HashMap<Expression, HashMap<Interval, GroundAction>> effectsMap = linearSupporters.get(action_counter);
                   
            for (Expression rhs : effectsMap.keySet()){
                HashMap<Interval, GroundAction> intervalsMap = effectsMap.get(rhs);
                
                for (Interval interval: intervalsMap.keySet()){
                    
                    Float inf = interval.getInf().getNumber();
                    Float sup = interval.getSup().getNumber();
                    Expression constantIncrement;
                    
                    // three possible effects
                    Float eval = (float) rhs.eval(s).getNumber();
                    if (eval < inf){
                        constantIncrement = new ExtendedNormExpression(inf);
                    } else if (eval < sup){
                        constantIncrement = new ExtendedNormExpression(eval);
                    } else {
                        constantIncrement = new ExtendedNormExpression(sup);
                    }
                    
                    GroundAction tempSup = intervalsMap.get(interval);
                    // one supporter has only one effect
                    NumEffect tempEff = (NumEffect) tempSup.getNumericEffects().sons.iterator().next();
                    tempEff.setRight(constantIncrement);
                }
            }
        }
    }
    
    public void setNumOfPartitions(Integer numOfPartitions) {
        this.numOfPartitions = numOfPartitions;
    }
    
    // only for debugging
    public static void logging(String content){
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

            if (bw != null)
                    bw.close();

            if (fw != null)
                    fw.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

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
    
    private Integer numOfPartitions = 2;

    private Boolean setting_up = true;
    private Set<GroundProcess> processSet;
    private HashMap<GroundAction, HashMap<Expression, LinkedList<Interval>>> partitionMap = new HashMap();
    
    private ucs_h1_refactored abs_h;
    
    public Habs(Conditions G, Set<GroundAction> A, Set<GroundProcess> P) {
        super(G, A, P);
        
        this.supporters = new LinkedHashSet<>();
        this.processSet = P;
    }
    
    @Override
    public Float setup(State s){
        build_integer_representation();
        
        // reachability analysis on original problem
        Aibr first_reachH = new Aibr(this.G,this.A);
        first_reachH.setup(s);
        first_reachH.set(true, true);
        Float ret = first_reachH.compute_estimate(s);
        if (ret == Float.MAX_VALUE)
            return ret;
        A = first_reachH.reachable;
        reachable = first_reachH.reachable;
        
        // partitioning
        buildPartitions(A, G, s);
        
        // estimation for initial state
        setup_habs(s);
        ret = abs_h.compute_estimate(s);
        
        for (GroundAction gr : abs_h.A){
            Habs.logging(gr.toPDDL() + "\n\n");
        }
    
        
        setting_up = false;
        return ret;
    }
    
    /**
     * Setup habs without reachability analysis.
     * 
     * @param s 
     */
    public void setup_habs(State s){
        this.supporters.clear();
        
//        long start_setting_up = System.currentTimeMillis();
                
        generate_supporters(s);
        
//        System.out.println("generating supporters takes " + (System.currentTimeMillis() - start_setting_up));
        
//        Habs.logging(s.toString());
//        for (GroundAction gr : this.supporters){
//            Habs.logging(gr.toPDDL() + "\n\n");
//        }
        
        abs_h = (ucs_h1_refactored) habsFactory(TYPE_UCSH1, G, (Set<GroundAction>) this.supporters, processSet);
        
        long start_light_up = System.currentTimeMillis();
        abs_h.light_setup(s);        
//        System.out.println("light set up takes " + (System.currentTimeMillis() - start_light_up));
     
    }
    
    private static Heuristic habsFactory(Integer heuristicType, Conditions G, Set<GroundAction> A, Set<GroundProcess> P){
        switch (heuristicType){
            case (1): {
                return new ucs_h1_refactored(G, A, P);
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
        
        if (setting_up){
            System.out.println("Generating supporters.");
        }
        
        for (GroundAction gr : reachable) {
            if (gr.getNumericEffects() != null && !gr.getNumericEffects().sons.isEmpty()) {
                for (NumEffect effect : (Collection<NumEffect>) gr.getNumericEffects().sons) {
                    if (gr.getNumericEffects() != null && !effect.getRight().rhsFluents().isEmpty()) {
                      // generate supporters for actions with linear numeric effects
                      generate_linear_supporter(s, effect, gr.toFileCompliant() + effect.getFluentAffected(), gr);    
                    } else if (effect.getRight().rhsFluents().isEmpty()) {
                      // generate supporters for actions with constant effects
                      generate_constant_supporter(effect, gr.toFileCompliant(), gr);
                    }
                }
            }
            
            // add propositional actions
            if ((gr.getAddList() != null && !gr.getAddList().sons.isEmpty()) || (gr.getDelList() != null && !gr.getDelList().sons.isEmpty())) {
                 generate_propositional_action(gr.toFileCompliant() + "prop", gr.getPreconditions(), gr);
            }
        }
        
        if (setting_up){
            System.out.println("Generating supporters finished.");
            System.out.println("|Sup + goal|: " + supporters.size());
        }
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
        // partitioning
        LinkedList<Interval> intervals = partitionMap.get(gr).get(effect.getRight());
        
        for(Interval interval : intervals){
            
            Float inf = interval.getInf().getNumber();
            Float sup = interval.getSup().getNumber();
            Expression constantIncrement;
            
            // three possible effects
            Float eval = (float) effect.getRight().eval(s).getNumber();
            
            if (eval < inf){
                constantIncrement = new ExtendedNormExpression(inf);
            } else if (eval <= sup){
                constantIncrement = effect.getRight();
            } else {
                constantIncrement = new ExtendedNormExpression(sup);
            }
                                    
            GroundAction supporter = new GroundAction(name + " (" + inf.toString() + ',' + sup.toString() + ") " + constantIncrement.toString() + " for " + effect.getFluentAffected().toString());

            // set up effect
            NumEffect supEff = new NumEffect(effect.getOperator());
            supEff.setFluentAffected(effect.getFluentAffected());
            supEff.setRight(constantIncrement);

            // set effects for supporters
            supporter.getNumericEffects().sons.add(supEff);

            // setup preconditions. Preconditions = (indirect_preconditions) U pre(gr)
            Comparison indirect_precondition_gt = new Comparison(">");
            Comparison indirect_precondition_lt = new Comparison("<=");
            indirect_precondition_gt.setLeft(effect.getRight());
            indirect_precondition_gt.setRight(new PDDLNumber(inf));
            indirect_precondition_lt.setLeft(effect.getRight());
            indirect_precondition_lt.setRight(new PDDLNumber(sup));

            // set pre-conditions for supporters
            supporter.getPreconditions().sons.add(indirect_precondition_lt);
            supporter.getPreconditions().sons.add(indirect_precondition_gt);
            supporter.setPreconditions(supporter.getPreconditions().and(gr.getPreconditions()));

            // add new supporter
            supporters.add(supporter);
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
    private void generate_constant_supporter(NumEffect effect, String name, GroundAction gr) {     
        GroundAction sup = new GroundAction(name + ' ' + effect.getRight().toString() + " for " + effect.getFluentAffected().toString());
        
        // setup effect
        NumEffect supEff = new NumEffect(effect.getOperator());
        supEff.setFluentAffected(effect.getFluentAffected());
        supEff.setRight(effect.getRight());
       
        // add effect
        sup.getNumericEffects().sons.add(supEff);
        
        // add preconditions
        sup.setPreconditions(gr.getPreconditions());
        
        supporters.add(sup);
    }
    
    private void generate_propositional_action(String name, Conditions cond, GroundAction gr) {
        GroundAction ret = new GroundAction(name);
        ret.setPreconditions(cond);
        ret.setAddList(gr.getAddList());
        ret.setDelList(gr.getDelList());

        supporters.add(ret);
    }

    private void buildPartitions(Set<GroundAction> A, Conditions G, State s) {
        Aibr aibr_handle = new Aibr(G, A);
        //aibr_handle
        aibr_handle.setup(s);
        RelState rs = aibr_handle.get_reachable_state(s, s.relaxState());
        
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
                        if (Math.abs(Math.abs(inf) - Math.abs(sup)) < 1e-6){
                            partForEffect.add(rhsInterval);
                        } else {
                            diff = sup - inf;
                            strip = diff / numOfPartitions;
                            
                            for(int i=0;i<numOfPartitions;i++){
                               temp = new Interval();
                               temp.setInf(new PDDLNumber(inf + strip * i));
                               temp.setSup(new PDDLNumber(inf+ strip*(i+1)));
                               
                               partForEffect.add(temp);
                            }
                        }
                                                    
                        temp = new Interval();
                        temp.setInf(new PDDLNumber(-Float.MAX_VALUE));
                        temp.setSup(new PDDLNumber(inf));

                        partForEffect.add(temp);

                        temp = new Interval();
                        temp.setInf(new PDDLNumber(sup));
                        temp.setSup(new PDDLNumber(Float.MAX_VALUE));
                        
                        partForEffect.add(temp);
                            
                        tempMap.put(rhs, partForEffect);
                    }
                }
                partitionMap.put(gr, tempMap);
            }
        }
        
        Habs.logging(rs.toString() + "\n\n");
    }
    
    @Override
    public Float compute_estimate(State s) {
        if (!setting_up){ setup_habs(s);}
        
        long start_comp_estimate = System.currentTimeMillis();
        Float ret = abs_h.compute_estimate(s);      
//        System.out.println("compute estimate takes " + (System.currentTimeMillis() - start_comp_estimate));
     
        return ret;
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

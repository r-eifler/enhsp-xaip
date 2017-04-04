/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heuristics.advanced;

import conditions.Comparison;
import conditions.Conditions;
import expressions.ExtendedNormExpression;
import expressions.NumEffect;
import expressions.PDDLNumber;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import problem.GroundAction;
import problem.GroundProcess;
import problem.State;

/**
 *
 * @author dxli
 */
public class Absh extends ucs_h1_refactored{
    private ucs_h1_refactored ucs_h1;
    
    public Absh(Conditions G, Set<GroundAction> A, Set<GroundProcess> P) {
        super(G, A, P);
        this.supporters = new LinkedHashSet();
        
        generate_supporters();
        ucs_h1 = new ucs_h1_refactored(G, (Set<GroundAction>) this.supporters, P);
        ucs_h1.additive_h = true;
        ucs_h1.red_constraints = true;
    }
    
    @Override
    public Float setup(State s){
        // reachability analysis on the abstracted problem
        Float ret = ucs_h1.setup(s);
        if (ret == Float.MAX_VALUE){  return ret; }
        
        // TODO: How to set up reachable actions initially??
        this.reachable = A;
        
        return ret;
    }
    
    private void generate_supporters(){
        System.out.println("Generating supporters.");
        
        for (GroundAction gr : A) {
            if (gr.getNumericEffects() != null && !gr.getNumericEffects().sons.isEmpty()) {
                for (NumEffect effect : (Collection<NumEffect>) gr.getNumericEffects().sons) {
                    if (!effect.getOperator().equals("assign") || !effect.getRight().rhsFluents().isEmpty()) {
                      generate_abstract_supporter(effect, gr.toFileCompliant() + effect.getFluentAffected(), gr.getPreconditions(), gr);    
                    }
                }
            }
        }
        
        System.out.println("Generating supporters finished.");
        System.out.println("|Sup|: " + this.supporters.size());
    }

    private void generate_abstract_supporter(NumEffect effect, String name, Conditions preconditions, GroundAction gr) {
        LinkedHashMap<ArrayList<Float>, Float> precondtions_to_increment;
        precondtions_to_increment = partition(effect, preconditions, gr);
        
        for(Map.Entry<ArrayList<Float>, Float> entry : precondtions_to_increment.entrySet()){
            ArrayList<Float> bounds = entry.getKey();
            Float lower_bound = bounds.get(0);
            Float upper_bound = bounds.get(1);
            Float increment = entry.getValue();
            
            GroundAction ret = new GroundAction(name + '-' + increment);
            
            // setup effect
            NumEffect abs_eff = new NumEffect(effect.getOperator());
            abs_eff.setFluentAffected(effect.getFluentAffected());
            abs_eff.setRight(new ExtendedNormExpression(increment));
            
            // set effects for supporters
            ret.getNumericEffects().sons.add(abs_eff);
            
            // setup preconditions. Preconditions = (indirect_preconditions) U pre(gr)
            Comparison indirect_precondition_gt = new Comparison(">=");
            Comparison indirect_precondition_lt = new Comparison("<");
            indirect_precondition_gt.setLeft(effect.getRight());
            indirect_precondition_gt.setRight(new PDDLNumber(lower_bound));
            indirect_precondition_lt.setLeft(effect.getRight());
            indirect_precondition_lt.setRight(new PDDLNumber(upper_bound));
            
            // set pre-conditions for supporters
            ret.getPreconditions().sons.add(indirect_precondition_lt);
            ret.getPreconditions().sons.add(indirect_precondition_gt);
            ret.setPreconditions(ret.getPreconditions().and(preconditions));
            
            // add new supporter
            this.supporters.add(ret);
           
//            System.out.println(ret.toPDDL() + "\n");
        }
    }

    private LinkedHashMap<ArrayList<Float>, Float> partition(NumEffect effect, Conditions preconditions, GroundAction gr) {
        LinkedHashMap<ArrayList<Float>, Float> ret = new LinkedHashMap();
        
        ArrayList<Float> b1 = new ArrayList<>(Arrays.asList(0f,2f));
        ArrayList<Float> b2 = new ArrayList<>(Arrays.asList(2f,8f));
        
        
//        ArrayList<Float> b1 = new ArrayList<>(Arrays.asList(0f,2f));
//        ArrayList<Float> b2 = new ArrayList<>(Arrays.asList(2f,4f));
        
        ret.put(b1, 1f);
        ret.put(b2, 3f);
        
        return ret;
    }
    
    @Override
    public Float compute_estimate(State s) {
        return ucs_h1.compute_estimate(s);
    }
}

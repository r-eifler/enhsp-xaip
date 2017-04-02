/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heuristics.advanced;

import conditions.Comparison;
import conditions.Conditions;
import expressions.BinaryOp;
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

/**
 *
 * @author dxli
 */
public class Absh extends ucs_h1_refactored{
    
    public Absh(Conditions G, Set<GroundAction> A, Set<GroundProcess> P) {
        super(G, A, P);
        this.supporters = new LinkedHashSet();
        
        add_supportes(A);
    }

    private void add_supportes(Set<GroundAction> A) {
        System.out.println("Generating supporters.");
        generate_supporters();
//        if(this.supporters != null){ this.A = (LinkedHashSet <GroundAction>)this.supporters;}

        if(this.supporters != null){ this.A.addAll(this.supporters);}
        System.out.println("Generating supporters finished.");
        System.out.println("|A U Sup|: " + this.A.size() +"\n\n");
    }
    
    private void generate_supporters(){
        for (GroundAction gr : A) {
            if (gr.getNumericEffects() != null && !gr.getNumericEffects().sons.isEmpty()) {
                for (NumEffect effect : (Collection<NumEffect>) gr.getNumericEffects().sons) {
                    if (!effect.getOperator().equals("assign") && !effect.getRight().rhsFluents().isEmpty()) {
                      generate_abstract_supporter(effect, gr.toFileCompliant() + effect.getFluentAffected(), gr.getPreconditions(), gr);    
                    }
                }
            }
        }
    }

    private void generate_abstract_supporter(NumEffect effect, String name, Conditions preconditions, GroundAction gr) {
        LinkedHashMap<ArrayList<Float>, Float> precondtions_to_increment;
        precondtions_to_increment = partition(effect, preconditions, gr);
        
        for(Map.Entry<ArrayList<Float>, Float> entry : precondtions_to_increment.entrySet()){
            ArrayList<Float> bounds = entry.getKey();
            Float lower_bound = bounds.get(0);
            Float upper_bound = bounds.get(1);
            Float increment = entry.getValue();
            
            GroundAction ret = new GroundAction(name + increment.intValue());
            
            // setup effect
            NumEffect abs_eff = new NumEffect(effect.getOperator());
            abs_eff.setFluentAffected(effect.getFluentAffected());
            // new BinaryOp(effect.getRight(), "-", effect.getFluentAffected(), true));
            abs_eff.setRight(new ExtendedNormExpression(
                                new BinaryOp(new PDDLNumber(increment),
                                            effect.getOperator(),
                                            effect.getFluentAffected(),
                                            true)
            ));
            
            // setup preconditions. Preconditions = (indirect_preconditions) U pre(gr)
            Comparison indirect_precondition_gt = new Comparison(">=");
            Comparison indirect_precondition_lt = new Comparison("<");
            indirect_precondition_gt.setLeft(effect.getRight());
            indirect_precondition_gt.setRight(new PDDLNumber(lower_bound));
            indirect_precondition_lt.setLeft(effect.getRight());
            indirect_precondition_lt.setRight(new PDDLNumber(upper_bound));
            
            // set pre-conditions and effects for the supporter
            ret.getPreconditions().sons.add(indirect_precondition_lt);
            ret.getPreconditions().sons.add(indirect_precondition_gt);
            ret.setPreconditions(ret.getPreconditions().and(preconditions));
            ret.getNumericEffects().sons.add(abs_eff);
            
            // add new supporter
            this.supporters.add(ret);
            
            
        }
    }

    private LinkedHashMap<ArrayList<Float>, Float> partition(NumEffect effect, Conditions preconditions, GroundAction gr) {
        LinkedHashMap<ArrayList<Float>, Float> ret = new LinkedHashMap();
        
//        ArrayList<Float> b1 = new ArrayList<>(Arrays.asList(0f,3f));
//        ArrayList<Float> b2 = new ArrayList<>(Arrays.asList(3f,6f));
//        ArrayList<Float> b3 = new ArrayList<>(Arrays.asList(6f,10f));
        
        
        ArrayList<Float> b1 = new ArrayList<>(Arrays.asList(0f,5f));
        ArrayList<Float> b2 = new ArrayList<>(Arrays.asList(5f,10f));
        
        ret.put(b1, 2f);
        ret.put(b2, 6f);
//        ret.put(b3, 6f);
        
        return ret;
    }
}

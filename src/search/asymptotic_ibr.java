/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import conditions.AndCond;
import conditions.Comparison;
import conditions.Conditions;
import expressions.BinaryOp;
import expressions.NumEffect;
import expressions.PDDLNumber;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import problem.GroundAction;
import problem.RelState;
import problem.State;

/**
 *
 * @author enrico
 */
public class asymptotic_ibr extends Heuristics{

    public Collection<GroundAction> supporters;
    boolean reacheability;
    private boolean conservative = false;
    public asymptotic_ibr(Conditions G, Set<GroundAction> actions) {
        super(G,actions);
        generate_supporters(A);
    }
    public asymptotic_ibr(Conditions G, Set<GroundAction> actions, Set<GroundAction> processes) {
        super(G,actions,processes);
        generate_supporters(A);
    }

    @Override
    public int setup(State s_0){
        reacheability = true;
        int ret = compute_estimate(s_0);
        reacheability = false;
        return ret;
    }
    
    @Override
    int compute_estimate(State s) {
        RelState rs = s.relaxState();
        Collection<GroundAction> temp_supporters = new LinkedHashSet(supporters);//making a copy of the supporters so as not to delete the source
        int supporters_counter = 0;
        while (!rs.satisfy(G) || reacheability){//until  the goal is not satisfied || the procedure has been called in reacheability setting
            Collection<GroundAction> S = temp_supporters.stream().filter(p -> p.isApplicable(rs)).collect(Collectors.toSet());//lambda function, Take the applicable action
            if (S.isEmpty()){//if there are no applicable action then finish!
                if (!rs.satisfy(G))
                    return Integer.MAX_VALUE;
                else{
                    break;
                }
            }
            temp_supporters.removeIf(p -> p.isApplicable(rs));//Remove the action just taken
            S.stream().forEach((GroundAction a) -> a.apply(rs));
            supporters_counter+=S.size();
//            if (supporters_counter >=horizon){
////                System.out.println("Something wrong is happening");
//                return Integer.MAX_VALUE;
//            }
//            System.out.println("Internal Iteration: "+supporters_counter);
        }
        
        if (reacheability)
            this.reachable = new LinkedHashSet(A.stream().filter(p -> p.isApplicable(rs)).collect(Collectors.toList()));
        
        if (conservative){
            return supporters_counter;
        }
        
        RelState rs2 = s.relaxState();
        int counter = 0;
        while (counter<=horizon){
            boolean fix_point = true;
            for (GroundAction gr: this.reachable){
                    if (gr.isApplicable(rs2)){
                        gr.apply_with_generalized_interval_based_relaxation(rs2);
                        counter++;
                        fix_point=false;
                        if (rs2.satisfy(G))
                            return counter;
                    }
//                    System.out.println("Reacheability Iteration: "+counter);
            }
            if (fix_point){
                System.out.println("Anomaly!");
                //return Integer.MAX_VALUE;
            }
        }
        return counter;
    }

    private void generate_supporters(Set<GroundAction> actions) {
        supporters = new LinkedHashSet();
        for (GroundAction gr : actions) {
            if (gr.getNumericEffects() != null && !gr.getNumericEffects().sons.isEmpty()) {
                for (NumEffect effect : (Collection<NumEffect>) gr.getNumericEffects().sons) {
                    if (effect.getOperator().equals("assign") && effect.getRight().fluentsInvolved().isEmpty()) {
                        supporters.add(generate_constant_supporter(effect,gr.toFileCompliant()+effect.getFluentAffected(),(AndCond)gr.getPreconditions()));
                    } else  {
                        supporters.add(generate_plus_inf_supporter(effect,gr.toFileCompliant()+effect.getFluentAffected(),(AndCond)gr.getPreconditions()));
                        supporters.add(generate_minus_inf_supporter(effect,gr.toFileCompliant()+effect.getFluentAffected(),(AndCond)gr.getPreconditions()));
                    }
                }
            }
            if (gr.getAddList() != null && !gr.getAddList().sons.isEmpty()){

                supporters.add(generate_propositional_action(gr.getAddList(),gr.toFileCompliant()+"prop",(AndCond)gr.getPreconditions()));
                
            }

        }
  
    }
    
    
    private GroundAction generate_constant_supporter(NumEffect effect,String name,AndCond precondition) {
        GroundAction ret = new GroundAction(name+"constantassign");
        NumEffect assign = new NumEffect("assign");
        assign.setFluentAffected(effect.getFluentAffected());
        assign.setRight(effect.getRight());
        ret.getNumericEffects().sons.add(assign);
        if (precondition!=null && !precondition.sons.isEmpty())
            ret.getPreconditions().sons.addAll(precondition.sons);
        return ret;
    }

    private GroundAction generate_plus_inf_supporter(NumEffect effect,String name,AndCond precondition) {
        String disequality = "";
        Float asymptote = Float.MAX_VALUE;
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
        return generate_supporter(effect, disequality, asymptote,name+"plusinf",precondition);
    }

    private GroundAction generate_supporter(NumEffect effect, String disequality, Float asymptote,String name,AndCond precondition) {
        GroundAction ret = new GroundAction(name);
        Comparison indirect_precondition = new Comparison(disequality);
        if (effect.getOperator().equals("assign")){
            indirect_precondition.setLeft(new BinaryOp(effect.getRight(),"-",effect.getFluentAffected(),true));
        }else{
            indirect_precondition.setLeft(effect.getRight());
        }
        indirect_precondition.setRight(new PDDLNumber(0));
        ret.getPreconditions().sons.add(indirect_precondition);
        NumEffect eff = new NumEffect("assign");
        eff.setFluentAffected(effect.getFluentAffected());
        eff.setRight(new PDDLNumber(asymptote));
        ret.getNumericEffects().sons.add(eff);
        if (precondition!=null && !precondition.sons.isEmpty())
            ret.getPreconditions().sons.addAll(precondition.sons);
        return ret;
    }

    private GroundAction generate_minus_inf_supporter(NumEffect effect,String name,AndCond precondition) {
        String disequality = "";
        Float asymptote = -Float.MAX_VALUE;
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
        return generate_supporter(effect, disequality, asymptote,name+"minusinf",precondition);
    }

    private GroundAction generate_propositional_action(Conditions addList, String name, AndCond andCond) {
        GroundAction ret = new GroundAction(name);
        ret.setPreconditions(andCond);
        ret.setAddList(addList);
        return ret;
    }
    
}

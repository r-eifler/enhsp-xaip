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
import expressions.NumEffect;
import expressions.PDDLNumber;
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
import net.sourceforge.interval.ia_math.RealInterval;
import problem.GroundAction;
import problem.GroundProcess;
import problem.State;

/**
 *
 * @author dxli
 */
public class Habs extends Heuristic{
    
    private HashMap<GroundAction, GroundAction> supporter_to_action = new HashMap<>();
    private LinkedList<HashMap<Expression, HashMap<RealInterval, ArrayList<GroundAction>>>> linearSupporters = new LinkedList<>();
    private LinkedHashSet other_supporters = new LinkedHashSet(); // this includes supporters for propositional effect, assignment, and constant numeric effects.
    
    private final Adaptive_Ucs_h1 adaptive_ucs_h1;
    
    public Habs(Conditions G, Set<GroundAction> A, Set<GroundProcess> P) {
        super(G, A, P);
        supporters = new LinkedHashSet<>();
        
        generate_supporters();
        supporters.addAll(other_supporters);
//        System.out.println("|prop A|: " + propositional_actions.size());
        
        adaptive_ucs_h1 = new Adaptive_Ucs_h1(G, (Set<GroundAction>) this.supporters, P);
        adaptive_ucs_h1.additive_h = true;
        adaptive_ucs_h1.setLinearSupporters(linearSupporters);
        adaptive_ucs_h1.setOtherSupporters(other_supporters);
    }
    
    @Override
    public Float setup(State s){
        // reachability analysis on the abstracted problem
        Float ret = adaptive_ucs_h1.setup(s);
        if (ret == Float.MAX_VALUE){  return ret; }
        
        // find reachable actions in the original problem
        LinkedHashSet<GroundAction> reachable_supporters = adaptive_ucs_h1.reachable;
        for(GroundAction sup : reachable_supporters){
            GroundAction gr = supporter_to_action.get(sup);
            if (!reachable.contains(gr) && gr != null){
                reachable.add(gr);
            }
        }
        
        return ret;
    }
    
    private void generate_supporters(){
        build_integer_representation();
        
        System.out.println("Generating supporters.");
        
        for (GroundAction gr : A) {
            linearSupporters.add(new HashMap<>());
            
            if (gr.getNumericEffects() != null && !gr.getNumericEffects().sons.isEmpty()) {
//                System.out.println(gr.getNumericEffects());
                for (NumEffect effect : (Collection<NumEffect>) gr.getNumericEffects().sons) {
                    if (!effect.getOperator().equals("assign") && !effect.getRight().rhsFluents().isEmpty()) {
                      // generate supporters for actions with linear numeric effects
                      generate_linear_supporter(effect, gr.toFileCompliant() + effect.getFluentAffected(), gr.getPreconditions(), gr);    
                    } else if (effect.getRight().rhsFluents().isEmpty()) {
                      // generate supporters for actions with constant effect
                      generate_constant_supporter(effect, gr.toFileCompliant(), gr.getPreconditions(), gr);
                    } else {
                      // TODO what are supporters for assignment?
                        other_supporters.add(gr);
                        supporter_to_action.put(gr, gr);
                    }
                }
            } else {
                other_supporters.add(gr);
                supporter_to_action.put(gr, gr);
            }
        }
        
        System.out.println("Generating supporters finished.");
        System.out.println("|Sup|: " + supporters.size());
    }

    private void generate_linear_supporter(NumEffect effect, String name, Conditions preconditions, GroundAction gr) {
        // for an action, each numeric effect has a unique fluent affected
        linearSupporters.get(linearSupporters.size()-1).put(effect.getRight(), new HashMap<>());
        
        // partitioning
        ArrayList<RealInterval> realIntervals = partition(preconditions, gr);
        
        for(RealInterval realInterval : realIntervals){
            linearSupporters.get(linearSupporters.size()-1).get(effect.getRight()).put(realInterval, new ArrayList<>());
            
            Float lo = (float) realInterval.lo();
            Float hi = (float) realInterval.hi();
            
            // which supporter to use is dependent on the current state.
            ArrayList<Expression> supporter_effects = new ArrayList<>();
            supporter_effects.add(new ExtendedNormExpression(lo));
            supporter_effects.add(new ExtendedNormExpression(hi));
            supporter_effects.add(effect.getRight());
            
            for (Expression sup_effect : supporter_effects){
                                    
                GroundAction sup = new GroundAction(name + " (" + lo.toString() + ',' + hi.toString() + ") " + sup_effect.toString());

                // setup effect
                NumEffect abs_eff = new NumEffect(effect.getOperator());
                abs_eff.setFluentAffected(effect.getFluentAffected());
                abs_eff.setRight(sup_effect);

                // set effects for supporters
                sup.getNumericEffects().sons.add(abs_eff);

                // setup preconditions. Preconditions = (indirect_preconditions) U pre(gr)
                Comparison indirect_precondition_gt = new Comparison(">=");
                Comparison indirect_precondition_lt = new Comparison("<=");
                indirect_precondition_gt.setLeft(effect.getRight());
                indirect_precondition_gt.setRight(new PDDLNumber(lo));
                indirect_precondition_lt.setLeft(effect.getRight());
                indirect_precondition_lt.setRight(new PDDLNumber(hi));

                // set pre-conditions for supporters
                sup.getPreconditions().sons.add(indirect_precondition_lt);
                sup.getPreconditions().sons.add(indirect_precondition_gt);
                if (!preconditions.sons.isEmpty()){
                    sup.setPreconditions(sup.getPreconditions().and(preconditions));
                }

                // add new supporter
                supporters.add(sup);
                supporter_to_action.put(sup, gr);
                linearSupporters.get(linearSupporters.size()-1).get(effect.getRight()).get(realInterval).add(sup);
            }
        }
    }

    private void generate_constant_supporter(NumEffect effect, String name, Conditions preconditions, GroundAction gr) {     
        GroundAction sup = new GroundAction(name + ' ' + effect.getFluentAffected().getName());
        
        // setup effect
        NumEffect abs_eff = new NumEffect(effect.getOperator());
        abs_eff.setFluentAffected(effect.getFluentAffected());
        abs_eff.setRight(effect.getRight());
       
        // add effect
        sup.getNumericEffects().sons.add(abs_eff);
        
        // add preconditions
        if(!preconditions.sons.isEmpty()){
            sup.setPreconditions(preconditions);
        }
        
        supporters.add(sup);
        supporter_to_action.put(sup, gr);
        other_supporters.add(sup);
   }

    private ArrayList<RealInterval> partition(Conditions preconditions, GroundAction gr) {
        ArrayList<RealInterval> ret = new ArrayList<>();
        
        RealInterval realInterval1 = new RealInterval(1f,2f);
        RealInterval realInterval2 = new RealInterval(2f,3f);
        RealInterval realInterval3 = new RealInterval(3f,8f);
        
        ret.add(realInterval1);
        ret.add(realInterval2);
        ret.add(realInterval3);
        
        return ret;
    }
    
    @Override
    public Float compute_estimate(State s) {
        return adaptive_ucs_h1.compute_estimate(s);
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

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
import heuristics.Aibr;
import heuristics.Heuristic;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
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
    
    private Boolean setting_up = true;
    private final HashMap<GroundAction, GroundAction> supporter_to_action;
    private Set<GroundProcess> processSet;
    
    private ucs_h1_refactored abs_h;
    
    public Habs(Conditions G, Set<GroundAction> A, Set<GroundProcess> P) {
        super(G, A, P);
        
        this.supporters = new LinkedHashSet<>();
        this.supporter_to_action = new HashMap<>();
        this.processSet = P;
    }
    
    @Override
    public Float setup(State s){
        // reachability analysis on original problem
        Aibr first_reachH = new Aibr(this.G,this.A);
        first_reachH.setup(s);
        first_reachH.set(true, true);
        Float ret = first_reachH.compute_estimate(s);
        if (ret == Float.MAX_VALUE)
            return ret;
        A = first_reachH.reachable;
        reachable = first_reachH.reachable;
        
        // estimation for initial state
        light_setup(s);
        ret = abs_h.compute_estimate(s);
        
        for (GroundAction gr : abs_h.A){
            Habs.logging(gr.toPDDL() + "\n\n");
        }
        
        setting_up = false;
        return ret;
    }
    
    /**
     * Setup without reachability analysis.
     * 
     * @param s 
     */
    public void light_setup(State s){
        this.supporters.clear();
        this.supporter_to_action.clear();

        generate_supporters(s);
        abs_h = new ucs_h1_refactored(G, (Set<GroundAction>) this.supporters, this.processSet);
        abs_h.light_setup(s);
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
                    if (!effect.getRight().rhsFluents().isEmpty()) {
                      // generate supporters for actions with linear numeric effects
                      generate_linear_supporter(s, effect, gr.toFileCompliant() + effect.getFluentAffected(), gr);    
                    } else if (effect.getRight().rhsFluents().isEmpty()) {
                      // generate supporters for actions with constant effects
                      generate_constant_supporter(effect, gr.toFileCompliant(), gr);
                    } else {
                        supporters.add(gr);
                        supporter_to_action.put(gr, gr);
                    }
                }
            } else {
                supporters.add(gr);
                supporter_to_action.put(gr, gr);
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
        ArrayList<RealInterval> realIntervals = partition(gr.getPreconditions(), gr);
        
        for(RealInterval realInterval : realIntervals){
            
            Float lo = (float) realInterval.lo();
            Float hi = (float) realInterval.hi();
            Expression constantIncrement;
            
            // three possible effects
            Float eval = (float) effect.getRight().eval(s).getNumber();
            if (eval < lo){
                constantIncrement = new ExtendedNormExpression(lo);
            } else if (eval <= hi){
                constantIncrement = effect.getRight();
            } else {
                constantIncrement = new ExtendedNormExpression(hi);
            }
                                    
            GroundAction sup = new GroundAction(name + " (" + lo.toString() + ',' + hi.toString() + ") " + constantIncrement.toString() + " for " + effect.getFluentAffected().toString());

            // set up effect
            NumEffect supEff = new NumEffect(effect.getOperator());
            supEff.setFluentAffected(effect.getFluentAffected());
            supEff.setRight(constantIncrement);

            // set effects for supporters
            sup.getNumericEffects().sons.add(supEff);

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
            sup.setPreconditions(sup.getPreconditions().and(gr.getPreconditions()));

            // add new supporter
            supporters.add(sup);
            supporter_to_action.put(sup, gr);
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
        supporter_to_action.put(sup, gr);
   }

    private ArrayList<RealInterval> partition(Conditions preconditions, GroundAction gr) {
        ArrayList<RealInterval> ret = new ArrayList<>();
        
        RealInterval realInterval1 = new RealInterval(0f, 500f);
        
        ret.add(realInterval1);
        
        return ret;
    }
    
    @Override
    public Float compute_estimate(State s) {
        if (!setting_up){ light_setup(s);}
        
//        Habs.logging(s.toString() + "\n\n");
//        for(GroundAction gr : abs_h.A){
//            Habs.logging(gr.toPDDL() + "\n\n");
//        }
//        Habs.logging("===================");
        
        return abs_h.compute_estimate(s);
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

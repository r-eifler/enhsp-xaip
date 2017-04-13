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
    
    private final HashMap<GroundAction, GroundAction> supporter_to_action;
    private final LinkedList<HashMap<Expression, HashMap<RealInterval, ArrayList<GroundAction>>>> linearSupporters;
    // this includes supporters for propositional effect, assignment, and constant numeric effects.
    private final LinkedHashSet otherSupporters; 
    
    private final Adaptive_Ucs_h1 adaptive_ucs_h1;
    
    public Habs(Conditions G, Set<GroundAction> A, Set<GroundProcess> P) {
        super(G, A, P);
        
        this.supporters = new LinkedHashSet<>();
        this.otherSupporters = new LinkedHashSet();
        this.linearSupporters = new LinkedList<>();
        this.supporter_to_action = new HashMap<>();
        
        this.generate_supporters();
        this.supporters.addAll(this.otherSupporters);
        
        adaptive_ucs_h1 = new Adaptive_Ucs_h1(G, (Set<GroundAction>) this.supporters, P);
        adaptive_ucs_h1.additive_h = true;
        adaptive_ucs_h1.setLinearSupporters(linearSupporters);
        adaptive_ucs_h1.setOtherSupporters(otherSupporters);
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
    
    /**
     * <p>Add supporters for each single effect of each action. Also
     * build the mapping from supporters to actions. 
     * 
     * <p>This mapping is important because reachability analysis is done by 
     * adaptive_ucs_h1, thus Habs needs this mapping to know what are the 
     * reachable actions for the original problem.
     */
    private void generate_supporters(){
        build_integer_representation();
        
        System.out.println("Generating supporters.");
        
        for (GroundAction gr : A) {
            
            if (gr.getNumericEffects() != null && !gr.getNumericEffects().sons.isEmpty()) {
                linearSupporters.add(new HashMap<>());
                for (NumEffect effect : (Collection<NumEffect>) gr.getNumericEffects().sons) {
                    if (!effect.getOperator().equals("assign") && !effect.getRight().rhsFluents().isEmpty()) {
                      // generate supporters for actions with linear numeric effects
                      generate_linear_supporter(effect, gr.toFileCompliant() + effect.getFluentAffected(), gr);    
                    } else if (effect.getRight().rhsFluents().isEmpty()) {
                      // generate supporters for actions with constant effects
                      generate_constant_supporter(effect, gr.toFileCompliant(), gr);
                    } else if (effect.getOperator().equals("assign")) {
                      // generate supporters for assignment effects
                    
                    } else {
                        otherSupporters.add(gr);
                        supporter_to_action.put(gr, gr);
                    }
                }
            } else {
                otherSupporters.add(gr);
                supporter_to_action.put(gr, gr);
            }
        }
        
        System.out.println("Generating supporters finished.");
        System.out.println("|Sup + goal|: " + supporters.size());
    }
    
    /**
     * <p>Add supporters for linear effects. The data structure to store
     * linear supporters is a LinkedList of hashMaps from Expression to
     * hashMaps of RealInterval to ArrayList.
     * 
     * <p>Each element in the LinkedList corresponding to all the possible
     * supporters of an action. That's to say the size of the list equals
     * to |A|.
     * 
     * <p>The first nested hashMap is keyed by the right-hand side of each effect,
     * an Expression instance. This key will be later evaluated to decide which
     * supporter to take. 
     * 
     * <p>For each effect we have a set of supporters on each partition. For each 
     * partition, there are 3 possible supporters. Which supporter to take is 
     * "state-dependent":
     *      <br> &nbsp &nbsp 1. if rhs &le lo, constant eff = lo;
     *      <br> &nbsp &nbsp 2. if lo &le rhs &le hi, constant eff = rhs;
     *      <br> &nbsp &nbsp 3. if hi &le rhs, constant eff = hi;
     * These are put in the ArrayList, keyed by RealInterval [lo, hi].
     * 
     * @param effect linear effect to generate supporters for.
     * @param name a string used to distinguish between supporters for effects.
     * @param gr the grounded action. 
     */
    private void generate_linear_supporter(NumEffect effect, String name, GroundAction gr) {
        // for an action, each atomic numeric effect has a unique right-hand affected
        linearSupporters.get(linearSupporters.size()-1).put(effect.getRight(), new HashMap<>());
        
        // partitioning
        ArrayList<RealInterval> realIntervals = partition(gr.getPreconditions(), gr);
        
        for(RealInterval realInterval : realIntervals){
            linearSupporters.get(linearSupporters.size()-1).get(effect.getRight()).put(realInterval, new ArrayList<>());
            
            Float lo = (float) realInterval.lo();
            Float hi = (float) realInterval.hi();
            
            // all three possible effects
            ArrayList<Expression> constantIncrements = new ArrayList<>();
            constantIncrements.add(new ExtendedNormExpression(lo));
            constantIncrements.add(new ExtendedNormExpression(hi));
            constantIncrements.add(effect.getRight());
            
            for (Expression constantInc : constantIncrements){
                                    
                GroundAction sup = new GroundAction(name + " (" + lo.toString() + ',' + hi.toString() + ") " + constantInc.toString() + " for " + effect.getFluentAffected().toString());

                // set up effect
                NumEffect supEff = new NumEffect(effect.getOperator());
                supEff.setFluentAffected(effect.getFluentAffected());
                supEff.setRight(constantInc);

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
                linearSupporters.get(linearSupporters.size()-1).get(effect.getRight()).get(realInterval).add(sup);
            }
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
        otherSupporters.add(sup);
   }

    private ArrayList<RealInterval> partition(Conditions preconditions, GroundAction gr) {
        ArrayList<RealInterval> ret = new ArrayList<>();
        
        RealInterval realInterval1 = new RealInterval(0f, 2f);
        RealInterval realInterval2 = new RealInterval(2f,5f);
        RealInterval realInterval3 = new RealInterval(5f,12f);
        
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

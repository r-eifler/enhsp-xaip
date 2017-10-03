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
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import problem.GroundAction;
import problem.GroundProcess;
import problem.RelState;
import problem.State;
import problem.Metric;

/**
 *
 * @author dxli
 */
public class habs_max extends Heuristic {

    private static final Integer TYPE_UCSH1 = 1;
    private static final Boolean cost_sensitive = false; // this is really "metric-sensitive".
    public Metric metric = null;
  
    private final Set<GroundProcess> processSet;
    private h1 habs;

    public habs_max(Conditions G, Set<GroundAction> A, Set<GroundProcess> P) {
        super(G, A, P);

        this.supporters = new LinkedHashSet<>();
        this.processSet = P;
    }

    public void setMetric(Metric metric) {
        this.metric = metric;
    }
  
    @Override
    public Float setup(State s) {
        
        // reachablity analysis by AIBR
        Float ret = aibrReachabilityAnalysis(s);
        if (ret == Float.MAX_VALUE) {
            return ret;
        }
        
        // abstraction step
        generate_subactions(s);
        
        // estimation for initial state
        setup_habs(s);
        
        // admissible setting
        habs.additive_h = false;
//        // @see h1.java, line 304
//        habs.infinite_constant_effect = true;
        
        ret = habs.compute_estimate(s);
        
        System.out.println("h(s_0): " + ret);
        System.exit(0);
        
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
    
        
    /**
     * <p>
     * 
     * <p>
     */
    private void generate_subactions(State s_0) {
        RelState rs = getRelaxedGoal(A, G, processSet, s_0);
        NumEffect effectOnCost = null;

        System.out.println("Generating subactions.");
        
        // a holder for constant numeric effects
        ArrayList<NumEffect> allConstantEffects = new ArrayList();

        for (GroundAction gr : reachable) {
            allConstantEffects.clear();
            
            if (gr.getNumericEffects() != null && !gr.getNumericEffects().sons.isEmpty()) {
                for (NumEffect effect : (Collection<NumEffect>) gr.getNumericEffects().sons) {
                    if (effect.getFluentAffected().getName().equals("total-cost")) {
                        effectOnCost = (NumEffect) effect.clone();
                        continue;
                    }
                    
                    ExtendedNormExpression rhs = (ExtendedNormExpression) effect.getRight();
                    // this is assuming no non-linear effects at the moment.
                    if (!rhs.rhsFluents().isEmpty() && rhs.linear) {
                        addinfiniteSubactions(gr.toFileCompliant() + effect.getFluentAffected(), gr, effect, effectOnCost, rs, s_0);
                    } else { // constant numeric effects
                        allConstantEffects.add(effect);
                    }
                }
            }
            
            // aggregate constant numeric effects and propositional effects into one "constant subaction".
            if (!allConstantEffects.isEmpty() 
                    || (gr.getAddList() != null && !gr.getAddList().sons.isEmpty()) 
                    || (gr.getDelList() != null && !gr.getDelList().sons.isEmpty())) {
                addConstantSubaction(gr.toFileCompliant() + " const", gr, allConstantEffects, effectOnCost, s_0);
            }
        }

        System.out.println("Generating subactions finished.");
        System.out.println("|Sup + goal|: " + supporters.size());
    }

    private RelState getRelaxedGoal(Set<GroundAction> A, Conditions G, Set<GroundProcess> P, State s) {
        Aibr aibr_handle = new Aibr(G, A, P);
        //aibr_handle
        aibr_handle.setup(s);
        return aibr_handle.get_reachable_state(s, s.relaxState());
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
     */
    private void addinfiniteSubactions(String name, GroundAction gr, NumEffect effect, NumEffect effectOnCost, RelState rs, State s_0) {
        Expression repSample;
        String subactionName;
        Float domain_inf = Float.MAX_VALUE;
        Float domain_sup = - Float.MAX_VALUE;
        
        // add plus infinity subdomain
        repSample = new ExtendedNormExpression(Float.MAX_VALUE);
        subactionName = name + " (" + domain_sup.toString() + ",+inf) " + " for " + effect.getFluentAffected().toString();
        GroundAction subaction = generatePiecewiseSubaction(subactionName, 
                repSample,  
                0f,
                Float.MAX_VALUE,
                effect, 
                effectOnCost, 
                gr,
                s_0);
        subaction.infinite_constant_effect = true;
        supporters.add(subaction);
        
        // add minus infinity subdomain
        repSample = new ExtendedNormExpression(-Float.MAX_VALUE);
        subactionName = name + " (-inf," + domain_inf.toString() + ") " + " for " + effect.getFluentAffected().toString();
        subaction = generatePiecewiseSubaction(subactionName, 
                repSample, 
                -Float.MAX_VALUE,
                0f, 
                effect,
                effectOnCost, 
                gr,
                s_0);
        subaction.infinite_constant_effect = true;
        supporters.add(subaction);
        
    }
    
    private GroundAction generatePiecewiseSubaction(String subactionName, Expression repSample, Float inf, Float sup, NumEffect effect, NumEffect effectOnCost, GroundAction gr, State s_0) {    
        GroundAction subaction = new GroundAction(subactionName);

        // set up effect
        NumEffect supEff = new NumEffect(effect.getOperator());
        supEff.setFluentAffected(effect.getFluentAffected());
        supEff.setRight(repSample);

        // set effects for subactions
        subaction.getNumericEffects().sons.add(supEff);
        
        if (cost_sensitive && effectOnCost != null) {
            subaction.getNumericEffects().sons.add(effectOnCost);
            subaction.setAction_cost(s_0, this.metric);
        } else {
        // if not metric sensitive, set uniform action cost
            subaction.setAction_cost(1);
        }

        // setup preconditions. Preconditions = (indirect_preconditions) U pre(gr)
        Comparison indirect_precondition_gt;
        Comparison indirect_precondition_lt;
        
        if (inf < 0){
            indirect_precondition_gt = new Comparison(">=");
            indirect_precondition_lt = new Comparison("<");
        } else {
            indirect_precondition_gt = new Comparison(">");
            indirect_precondition_lt = new Comparison("<=");
        }
        
        indirect_precondition_gt.setRight(new PDDLNumber(inf));
        indirect_precondition_lt.setRight(new PDDLNumber(sup));
        indirect_precondition_gt.setLeft(effect.getRight());
        indirect_precondition_lt.setLeft(effect.getRight());

        indirect_precondition_gt.normalize();
        indirect_precondition_lt.normalize();

        // set pre-conditions for subactions
        subaction.getPreconditions().sons.add(indirect_precondition_lt);
        subaction.getPreconditions().sons.add(indirect_precondition_gt);
        subaction.setPreconditions(subaction.getPreconditions().and(gr.getPreconditions()));
        
        return subaction;
    }

    /**
     * <p>
     *
     * @param effect constant effect to generate supporters for.
     * @param name a string to distinguish between effects.
     * @param gr the grounded action.
     */
    private void addConstantSubaction(String name, GroundAction gr, ArrayList<NumEffect> allConstantEffects, NumEffect effectOnCost, State s_0) {
        GroundAction sup = new GroundAction(name);

        // add preconditions
        sup.setPreconditions(gr.getPreconditions());

        // add constant numeric effect
        for (NumEffect effect : allConstantEffects) {
            sup.getNumericEffects().sons.add(effect);
        }
        
        // add propositional effects
        sup.setAddList(gr.getAddList());
        sup.setDelList(gr.getDelList());
        
        // add effect on metric
        if (cost_sensitive && effectOnCost != null) {
            sup.getNumericEffects().sons.add(effectOnCost);
            sup.setAction_cost(s_0, metric);
        } else {
        // if not metric sensitive, set uniform action cost
            sup.setAction_cost(1);
        }
        
        supporters.add(sup);
    }

    @Override
    public Float compute_estimate(State s) {
        Float ret = habs.compute_estimate(s);
        
        return ret;
    }
    
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
            Logger.getLogger(habs_add.class.getName()).log(Level.FINEST, null, ex);
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

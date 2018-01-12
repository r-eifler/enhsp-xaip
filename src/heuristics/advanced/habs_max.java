/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heuristics.advanced;

import conditions.Comparison;
import conditions.ComplexCondition;
import expressions.Expression;
import expressions.ExtendedNormExpression;
import expressions.NumEffect;
import expressions.PDDLNumber;
import heuristics.Aibr;
import heuristics.Heuristic;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import problem.PDDLGroundAction;
import problem.GroundProcess;
import problem.RelState;
import problem.PDDLState;
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

    public habs_max(ComplexCondition G, Set<PDDLGroundAction> A, Set<GroundProcess> P) {
        super(G, A, P);

        this.supporters = new LinkedHashSet<>();
        this.processSet = P;
    }

    public void setMetric(Metric metric) {
        this.metric = metric;
    }
  
    @Override
    public Float setup(PDDLState s) {
        
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
        
        ret = habs.compute_estimate(s);
        
        return ret;
    }

    private Float aibrReachabilityAnalysis(PDDLState s) {
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
    private void generate_subactions(PDDLState s_0) {
        RelState rs = getRelaxedGoal(A, G, processSet, s_0);
        NumEffect effectOnCost = null;

        System.out.println("Generating subactions.");
        
        // a holder for constant numeric effects
        ArrayList<NumEffect> allConstantEffects = new ArrayList();

        for (PDDLGroundAction gr : reachable) {
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

    private RelState getRelaxedGoal(Set<PDDLGroundAction> A, ComplexCondition G, Set<GroundProcess> P, PDDLState s) {
        Aibr aibr_handle = new Aibr(G, A, P);
        //aibr_handle
        aibr_handle.setup(s);
        // dxli: TODO: correct this
        return aibr_handle.get_relaxed_reachable_states(s, s.relaxState()).get(0);
    }

    /**
     * Setup habs without reachability analysis.
     *
     * @param s
     */
    public void setup_habs(PDDLState s) {
        habs = (h1) habsFactory(TYPE_UCSH1, G, (Set<PDDLGroundAction>) this.supporters, processSet);
        habs.light_setup(s);
    }

    private static Heuristic habsFactory(Integer heuristicType, ComplexCondition G, Set<PDDLGroundAction> A, Set<GroundProcess> P) {
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
    private void addinfiniteSubactions(String name, PDDLGroundAction gr, NumEffect effect, NumEffect effectOnCost, RelState rs, PDDLState s_0) {
        Expression repSample;
        String subactionName;
        Float domain_inf = - Float.MAX_VALUE;
        Float domain_sup = Float.MAX_VALUE;
        
        // add plus infinity subdomain
        repSample = new ExtendedNormExpression(Float.MAX_VALUE);
        subactionName = name + " (0," + domain_sup.toString() + ") for " + effect.getFluentAffected().toString();
        PDDLGroundAction subaction = generatePiecewiseSubaction(subactionName, 
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
        subactionName = name + " (" + domain_inf.toString() + ",0) " + " for " + effect.getFluentAffected().toString();
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
    
    private PDDLGroundAction generatePiecewiseSubaction(String subactionName, Expression repSample, Float inf, Float sup, NumEffect effect, NumEffect effectOnCost, PDDLGroundAction gr, PDDLState s_0) {    
        PDDLGroundAction subaction = new PDDLGroundAction(subactionName);

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
     * <p>
     */
    private void addConstantSubaction(String name, PDDLGroundAction gr, ArrayList<NumEffect> allConstantEffects, NumEffect effectOnCost, PDDLState s_0) {
        PDDLGroundAction sup = new PDDLGroundAction(name);

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
    public Float compute_estimate(PDDLState s) {
        Float ret = habs.compute_estimate(s);
        return ret;
    }
}

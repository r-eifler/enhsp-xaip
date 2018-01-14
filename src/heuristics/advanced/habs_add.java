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
import expressions.Interval;
import expressions.NumEffect;
import expressions.PDDLNumber;
import heuristics.Aibr; 
import heuristics.Heuristic;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import problem.PDDLGroundAction;
import problem.GroundProcess;

import problem.RelState;
import problem.PDDLState;
import problem.Metric;

/**
 *
 * @author dxli
 */
public class habs_add extends Heuristic {

    private static final Integer heuristic_type = 1; // may use heuristics other than h1.
    private static final Boolean cost_sensitive = false; // this is really "metric-sensitive".
    public Metric metric = null;
    private static final Float epsilon = 0.1f;
    
    private final Integer numOfSubdomains;
    private h1 habs;

    public habs_add(ComplexCondition G, Set<PDDLGroundAction> A, Integer k) {
        super(G, A);
        
        this.numOfSubdomains = k;
        this.supporters = new LinkedHashSet<>();
    }

    public void setMetric(Metric metric) {
        this.metric = metric;
    }
  
    @Override
    public Float setup(PDDLState s) {
        // reachablity analysis by AIBR
        Float ret = aibrReachabilityAnalysis(s);
        if (ret == Float.MAX_VALUE) {
            // not reachable!
            return ret;
        }
        
        try {
            // abstraction step
            // TODO: check this!!!
            generate_subactions(s);
            System.out.println("|Subactions| = " + this.supporters.size());
//            for (PDDLGroundAction gr : this.supporters){
//                System.out.println(gr.toPDDL() + "\n\n");
//            }
//            System.exit(0);
        } catch (Exception ex) {
            // non-linear effects not supported
            Logger.getLogger(habs_add.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // estimation for initial state
        setup_habs(s);
        
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
     * Generates subactions, and adds them to this.supporters.
     * 
     * @param s_0 the initial state. Currently only statically generate subactions before
     * the search started. In the future, may understand how to do this online.
     * @return null
     * @throws Exception does not support non-linear effect right now.
     * <p>
     */

    private void generate_subactions(PDDLState s_0) throws Exception {
        ArrayList<RelState> relaxedStates = getRelaxedGoal(A, G, s_0);
        RelState rsReachability = getReachabilityRelaxedState(A, G, s_0);
        NumEffect effectOnCost = null;

        System.out.println("Generating subactions.");
        
        // a holder for constant numeric effects
        ArrayList<NumEffect> allConstantEffects = new ArrayList();

        for (PDDLGroundAction gr : reachable) {
            allConstantEffects.clear();
            
            if (gr.getNumericEffects() != null && !gr.getNumericEffects().sons.isEmpty()) {
                for (NumEffect effect : (Collection<NumEffect>) gr.getNumericEffects().sons) {
                    if (effect.getFluentAffected().getName().equals("total-cost") && cost_sensitive) {
                        effectOnCost = (NumEffect) effect.clone();
                        continue;
                    }
                    
                    ExtendedNormExpression rhs = (ExtendedNormExpression) effect.getRight();
                    // this is assuming no non-linear effects at the moment.
                    if (!rhs.rhsFluents().isEmpty() && rhs.linear) {
                        addPiecewiseSubactions(gr.toFileCompliant() + " " + effect.getFluentAffected(), gr, effect, effectOnCost, relaxedStates, rsReachability, s_0);
                    } else if (!rhs.linear){
                        throw new Exception("Non-linear effects not supported!");
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
    }


    private ArrayList<RelState> getRelaxedGoal(Set<PDDLGroundAction> A, ComplexCondition G, PDDLState s) {
        Aibr aibr_handle = new Aibr(G, A);
        //aibr_handle
        aibr_handle.setup(s);
        return aibr_handle.get_relaxed_reachable_states(s, s.relaxState());
    }
    

    private RelState getReachabilityRelaxedState(LinkedHashSet<PDDLGroundAction> A, ComplexCondition G, PDDLState s_0) {
        Aibr aibr_handle = new Aibr(G, A);
        aibr_handle.setup(s_0);
        return aibr_handle.get_relaxed_goal_in_reachability(s_0);
    }

    /**
     * Setup habs without reachability analysis.
     *
     * @param s
     */

    public void setup_habs(PDDLState s) {

        System.out.println("setting up...");

        habs = (h1) habsFactory(heuristic_type, G, (Set<PDDLGroundAction>) this.supporters);
        habs.light_setup(s);
        System.out.println("setup completed!");
    }

    private static Heuristic habsFactory(Integer heuristicType, ComplexCondition G, Set<PDDLGroundAction> A) {

        switch (heuristicType) {
            case (1): {
                return new h1(G, A, new LinkedHashSet<>()); // does not support process yet
            }
            default:
                return null;
        }
    }

    /**
     * <p>
     * Generates piecewise subactions for NON-CONSTANT LINEAR effects, and adds subactions 
     * to this.supporters.
     * 
     * @param name a sting used for naming the subaction, is the concatenation of action name and effect lhs name.
     * @param gr the action
     * @param effect the effect to be decomposed
     * @param effectOnCost the effect on metric
     * @param rs relaxed goal state from AIBR
     * @param s0 initial state in the original problem, used for setting metric.
     * @return null
     * @throws Exception does not support non-linear effect right now.
     * <p>
     */

    private void addPiecewiseSubactions(String name, PDDLGroundAction gr, NumEffect effect, NumEffect effectOnCost, ArrayList<RelState> relaxedStates, RelState rsReachability, PDDLState s_0) {
        // decomposition
        ArrayList<Interval> iis = decomposeRhs(effect, relaxedStates, rsReachability);
        
        Expression repSample;
        String subactionName;

        for (Interval subdomain : iis) {
            Float inf = subdomain.getInf().getNumber();
            Float sup = subdomain.getSup().getNumber();
      
            repSample = conservativeSampling(inf, sup);
            
//            repSample = midSampling(inf, sup);

            subactionName = name + " (" + inf.toString() + ',' + sup.toString() + ") ";// + effect.getFluentAffected().toString();
            PDDLGroundAction subaction = generatePiecewiseSubaction(subactionName, 
                    repSample, 
                    inf, 
                    sup, 
                    effect, 
                    effectOnCost, 
                    gr,
                    s_0);

            supporters.add(subaction);
        }
    }
    
    
    private Expression conservativeSampling(Float inf, Float sup) {
        Expression repSample;
        if (Math.abs(inf) < 1e-5){ // inf = 0
            repSample = new ExtendedNormExpression(epsilon);
//                repSample = new ExtendedNormExpression((inf + sup)/2);
        } else if (inf > 0) {
            repSample = new ExtendedNormExpression(inf);
        } else { // inf < 0
            if (Math.abs(sup) < 1e-5){ // sup = 0
              repSample = new ExtendedNormExpression(-epsilon);
//                   repSample = new ExtendedNormExpression((inf + sup)/2);
            } else {
              repSample = new ExtendedNormExpression(sup);
            }
        }
        return repSample;
    }
//    
//    private Expression midSampling(Float inf, Float sup){
//        Expression repSample;
//        
//        if (Math.abs(inf) < 1e-5){ // inf = 0
//            if (Math.abs(sup - Float.MAX_VALUE) < 1e-5){ // sup = +infty
//                repSample = new ExtendedNormExpression(epsilon);
//            } else { // sup > 0, but finite
//                repSample = new ExtendedNormExpression((inf+sup)/2);                    
//            }
//        } else if (inf > 0) {
//            if (Math.abs(sup - Float.MAX_VALUE) < 1e-5){ // sup = +infty
//                repSample = new ExtendedNormExpression(inf);
//            } else { // sup > 0, but finite
//                repSample = new ExtendedNormExpression((inf+sup)/2);
//            }
//        } else { // inf < 0
//            if ((Math.abs(inf) + Float.MAX_VALUE) < 1e-5){ // inf = -infty
//                if (Math.abs(sup) < 1e-5){ // sup = 0
//                    repSample = new ExtendedNormExpression(-epsilon);
//                } else { // sup < 0, but finite
//                    repSample = new ExtendedNormExpression(sup);
//                }
//            } else { // inf < 0, but finite
//                repSample = new ExtendedNormExpression((inf+sup)/2);
//            }
//        }
//
//        return repSample;
//    }
//    
//    
    private ArrayList<Interval> decomposeRhs(NumEffect effect, ArrayList<RelState> relaxedStates, RelState rsReach) {
//        System.out.println("effect: " + effect);

        // ====== now generating increment interval sequence (IIS) ======
        ArrayList<Interval> iis = getIis(effect, relaxedStates);
        Float initialVal = effect.getRight().eval(relaxedStates.get(0)).getInf().getNumber();
        
//        System.out.println("iis: " + iis);

        // ====== now start merging IIS into subdomains ======
        ArrayList <Interval> ret = new ArrayList<>();
        Interval temp = new Interval();
        
        if (iis.size() > 0 && numOfSubdomains > 0){
            PDDLNumber l = iis.get(0).getInf();
            Integer groupSize = (int) Math.ceil(iis.size() / (float) numOfSubdomains);
            
            for (int i=0; i < iis.size(); i++){
                if (iis.get(i).getInf().getNumber() * iis.get(i).getSup().getNumber() < 0){
                    temp.setInf(l);
                    temp.setSup(new PDDLNumber(0));
                    ret.add(temp.clone());

                    if (i % groupSize == 0 || i == iis.size()-1){
                        temp.setInf(new PDDLNumber(0));
                        temp.setSup(iis.get(i).getSup());
                        ret.add(temp.clone());
                        l = iis.get(i).getSup();
                    } else {
                        l = new PDDLNumber(0);
                    }
                    continue;
                }

                if (i % groupSize == 0 || i == iis.size() - 1){
                    temp.setInf(l);
                    temp.setSup(iis.get(i).getSup());
                    ret.add(temp.clone());
                    l = iis.get(i).getSup();
                }   
            }
        }
        
        // ====== now add infinite intervals to ensure safness ======
        ret = addFiniteIntervals(initialVal, effect, rsReach, iis, ret);
//        System.out.println("decomposed into: " + ret + "\n\n");
        return ret;
    }
    
   private ArrayList <Interval> getIis(NumEffect effect, ArrayList<RelState> relaxedStates){
        ArrayList<Interval> iis = new ArrayList(); // increment interval sequence (IIS) 
        
//        System.out.println("relaxed states: " + relaxedStates.toString());
        
        Interval prevRhsInterval = null;
        for (RelState rs : relaxedStates){
            Interval currentRhsInterval = effect.getRight().eval(rs); 
            if (prevRhsInterval == null) {
                prevRhsInterval = currentRhsInterval.clone();
            } else {
                if (currentRhsInterval.getInf().getNumber() - prevRhsInterval.getInf().getNumber() < 0){
                    Interval incrementInterval = new Interval();
                    incrementInterval.setInf(currentRhsInterval.getInf());
                    incrementInterval.setSup(prevRhsInterval.getInf());
                    iis.add(incrementInterval);    
                }
                    
                if (currentRhsInterval.getSup().getNumber() - prevRhsInterval.getSup().getNumber() > 0){
                    Interval incrementInterval = new Interval();
                    incrementInterval.setInf(prevRhsInterval.getSup());
                    incrementInterval.setSup(currentRhsInterval.getSup());
                    iis.add(incrementInterval);
                }
                    prevRhsInterval = currentRhsInterval.clone();
            }   
        }
        
        Collections.sort(iis, new SortByInf());
        
//        System.out.println("iis: " + iis.toString());
        return iis;
    }
   
   private ArrayList <Interval> addFiniteIntervals(Float initialVal, NumEffect effect, RelState rsReach, ArrayList<Interval> iis, ArrayList<Interval> ret){   
       Interval temp = new Interval();
       
       if (effect.getRight().eval(rsReach).getInf().getNumber() + Float.MAX_VALUE < 1e-5){
            temp.setInf(new PDDLNumber(-Float.MAX_VALUE));
            
            Float supToSet;
            if (iis.size() > 0){
                supToSet = iis.get(0).getInf().getNumber();
            } else {
                supToSet = initialVal;
            }
            
            if (supToSet <= 0){
                temp.setSup(new PDDLNumber(supToSet));            
                ret.add(temp.clone());
            } else {
                 // iis.get(0).getInf().getNumber() > 0, now (-infty, inf) crosses 0, again!
                    // add (-infty, 0) and (0, n), instead.
                temp.setSup(new PDDLNumber(0));            
                ret.add(temp.clone());
                temp.setInf(new PDDLNumber(0));
                temp.setSup(new PDDLNumber(supToSet));
                ret.add(temp.clone());
            }            
        }
//        
        // rhs(e).eval() = +infty
        if (effect.getRight().eval(rsReach).getSup().getNumber() - Float.MAX_VALUE < 1e-5){
            temp.setSup(new PDDLNumber(Float.MAX_VALUE));
            
            Float infToSet;
            if (iis.size() > 0){
                infToSet = iis.get(iis.size()-1).getSup().getNumber();
            } else {
                infToSet = initialVal;
            }
            
            if (infToSet >= 0){
                temp.setInf(new PDDLNumber(infToSet));            
                ret.add(temp.clone());
            } else {
                temp.setInf(new PDDLNumber(0));            
                ret.add(temp.clone());
                temp.setSup(new PDDLNumber(0));
                temp.setInf(new PDDLNumber(infToSet));
                ret.add(temp.clone());
            } 
        } 
        
        return ret;
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


    public Float compute_estimate(PDDLState s) {
//        System.out.println("start compute_estimate()...");

        Float ret = habs.compute_estimate(s);
//        System.out.println("h = " + ret);
        return ret;
    }

    private static class SortByInf implements Comparator{

        public int compare(Object o1, Object o2) {
            Interval a = (Interval) o1;
            Interval b = (Interval) o2;
            
            if (a.getInf().getNumber() > b.getInf().getNumber()){
                return 1;
            } else if (a.getInf().getNumber() < b.getInf().getNumber()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

}


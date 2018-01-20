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
import extraUtils.Pair;
import heuristics.Aibr;
import heuristics.Heuristic;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import problem.GroundEvent;
import problem.GroundProcess;
import problem.PDDLGroundAction;

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
    private h1 h1_handle;

    private final Integer k;
    private h1 habs;
    public boolean onlineRepresentatives;
    private HashMap<Pair<Comparison, Comparison>, Pair<NumEffect, NumEffect>> subactionsMap;
    private HashMap<Comparison, Float> comparisonBound;
    public boolean midPointSampling;

    public habs_add(ComplexCondition G, Set<PDDLGroundAction> A, Integer k) {
        super(G, A);

        this.k = k;
        this.supporters = new LinkedHashSet<>();
    }
    
    public habs_add(ComplexCondition G, Set<PDDLGroundAction> A, Set<GroundProcess> P, Set<GroundEvent> E, Integer k) {
        super(G, A, P, E);

        this.k = k;
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
        if (onlineRepresentatives) {
            subactionsMap = new HashMap();
            comparisonBound = new HashMap();
        }
        h1_handle = new h1(G, A, new LinkedHashSet<>());
        h1_handle.simplify_actions(s);

        try {
            // abstraction step
            generate_subactions(s);
            System.out.println("|Subactions| = " + this.supporters.size());
            if (debug > 100) {
                for (PDDLGroundAction gr : this.supporters) {
                    System.out.println(gr.toPDDL() + "\n\n");
                }
            }
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
     * @param s_0 the initial state. Currently only statically generate
     * subactions before the search started. In the future, may understand how
     * to do this online.
     * @return null
     * @throws Exception does not support non-linear effect right now.
     * <p>
     */
    private void generate_subactions(PDDLState s_0) throws Exception {

        ArrayList<RelState> relaxedStates = getRelaxedGoal(h1_handle.A, h1_handle.G, s_0);
        RelState rsReachability = getReachabilityRelaxedState(h1_handle.A, h1_handle.G, s_0);
        NumEffect effectOnCost = null;

        System.out.println("Generating subactions.");

        // a holder for constant numeric effects
        ArrayList<NumEffect> allConstantEffects = new ArrayList();

        for (PDDLGroundAction gr : h1_handle.A) {
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
                    } else if (!rhs.linear) {
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
//        System.exit(0);
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

    private Heuristic habsFactory(Integer heuristicType, ComplexCondition G, Set<PDDLGroundAction> A) {

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
     * Generates piecewise subactions for NON-CONSTANT LINEAR effects, and adds
     * subactions to this.supporters.
     *
     * @param name a sting used for naming the subaction, is the concatenation
     * of action name and effect lhs name.
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

        if (debug > 101){
            System.out.println(iis);
        }
        Expression repSample;
        String subactionName;

        for (Interval subdomain : iis) {
            Float inf = subdomain.getInf().getNumber();
            Float sup = subdomain.getSup().getNumber();

            if (!midPointSampling) {
                repSample = this.lowerBoundSampling(inf, sup);
            } else {
                repSample = this.midSampling(inf, sup);
            }
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

    private Expression lowerBoundSampling(Float inf, Float sup) {
        Expression repSample;
        if (Math.abs(inf) == 0) { // inf = 0
            repSample = new ExtendedNormExpression(epsilon);
//                repSample = new ExtendedNormExpression((inf + sup)/2);
        } else if (inf > 0) {
            repSample = new ExtendedNormExpression(inf);
        } else // inf < 0
        if (Math.abs(sup) == 0) { // sup = 0
            repSample = new ExtendedNormExpression(-epsilon);
//                   repSample = new ExtendedNormExpression((inf + sup)/2);
        } else {
            repSample = new ExtendedNormExpression(sup);
        }
        return repSample;
    }
//    

    private Expression midSampling(Float inf, Float sup) {
        Expression repSample;
        
//        System.out.println("inf: " + inf);
//        System.out.println("sup: " + sup);
        
        if (Math.abs(inf) < 1e-5) { // inf = 0
            if (sup == Float.MAX_VALUE) { // sup = +infty
                repSample = new ExtendedNormExpression(epsilon);
            } else { // sup > 0, but finite
                repSample = new ExtendedNormExpression((inf + sup) / 2.0f);
            }
        } else if (inf > 0) {
            if (sup == Float.MAX_VALUE) { // sup = +infty
                repSample = new ExtendedNormExpression(inf);
            } else { // sup > 0, but finite
                repSample = new ExtendedNormExpression((inf + sup) / 2.0f);
            }
        } else // inf < 0
        if (inf == -Float.MAX_VALUE) { // inf = -infty
            if (Math.abs(sup) < 1e-5) { // sup = 0
                repSample = new ExtendedNormExpression(-epsilon);
            } else { // sup < 0, but finite
                repSample = new ExtendedNormExpression(sup);
            }
        } else { // inf < 0, but finite
            repSample = new ExtendedNormExpression((inf + sup) / 2.0f);
        }
        
//        System.out.println("rep is: " + repSample + "\n\n");
        return repSample;
    }
//    
//    

    private ArrayList<Interval> decomposeRhs(NumEffect effect, ArrayList<RelState> relaxedStates, RelState rsReach) {
//        System.out.println("effect: " + effect);

        // ====== now generating increment interval sequence (IIS) ======
        ArrayList<Interval> iis = getIis(effect, relaxedStates);

        // ====== now add infinite intervals to IIS to ensure safness ======
        addInfiniteIntervals(iis, effect, rsReach, relaxedStates.get(relaxedStates.size() - 1));

        Collections.sort(iis, new SortByInf());
//        System.out.println("iis: " + iis);
//        System.exit(0);

        // ====== now start merging IIS into subdomains ======
        ArrayList<Interval> ret = mergeIis(iis);

//        System.out.println("decomposed into: " + ret + "\n\n");
        return ret;
    }

    private ArrayList<Interval> mergeIis(ArrayList<Interval> iis) {
        // ===== separate positive from negative intervals =====
        ArrayList<Interval> posIis = new ArrayList<>();
        ArrayList<Interval> negIis = new ArrayList<>();

//        System.out.println("inf: " + iis.get(0).getInf().getNumber());
        if (iis.get(0).getInf().getNumber().compareTo(-0f) >= 0) {
            posIis = iis;
        } else if (iis.get(iis.size() - 1).getSup().getNumber().compareTo(-0f) <= 0) {
            negIis = iis;
        } else {
            ArrayList<Interval> dest = negIis;
            for (Interval elem : iis) {
                if (elem.getInf().getNumber().compareTo(-0f) >= 0) {
                    dest = posIis;
                }
                dest.add(elem);
            }
        }

        // ====== prepare to merge ======
        int P = posIis.size();
        int N = negIis.size();
        int PS = (int) Math.floor(Math.max(P, k) / k);
        int NS = (int) Math.floor(Math.max(N, k) / k);

        // ====== now start merging ======
        ArrayList<Interval> ret = new ArrayList<>();
        merge(negIis, NS, ret);
        merge(posIis, PS, ret);

//        System.out.println("negIis: " + negIis);
//        System.out.println("posIis: " + posIis);
//        System.out.println(ret);
//        System.exit(0);
        return ret;
    }

    private void merge(ArrayList<Interval> iis, int size, ArrayList<Interval> ret) {
        Interval temp = new Interval();
        PDDLNumber l;

        if (iis.size() > 0) {
            l = iis.get(0).getInf();

            int i;
            int j = (Math.min(this.k, iis.size()) - 1) * size;
            for (i = 0; i < j; i++) {
                if (i == j - 1 || (i + 1) % size == 0) {
                    temp.setInf(l);
                    temp.setSup(iis.get(i).getSup());
                    l = iis.get(i).getSup();
                    ret.add(temp.clone());
//                    System.out.println("add: " + temp);
                }
            }

//            System.out.println("j: " + j);
//            System.out.println("size: " + size);
            if (i != iis.size()) {
                temp.setInf(l);
                temp.setSup(iis.get(iis.size() - 1).getSup());
                ret.add(temp.clone());
            }
        }
    }

    private ArrayList<Interval> getIis(NumEffect effect, ArrayList<RelState> relaxedStates) {
        ArrayList<Interval> iis = new ArrayList(); // increment interval sequence (IIS) 

//        System.out.println("relaxed states: " + relaxedStates.toString());
        Interval prevRhsInterval = null;
        for (RelState rs : relaxedStates) {
            Interval currentRhsInterval = effect.getRight().eval(rs);
            if (prevRhsInterval == null) {
                prevRhsInterval = currentRhsInterval.clone();
            } else {
                if (currentRhsInterval.getInf().getNumber().compareTo(prevRhsInterval.getInf().getNumber()) < 0) {
                    addIis(iis, currentRhsInterval.getInf(), prevRhsInterval.getInf());
                }
                if (currentRhsInterval.getSup().getNumber().compareTo(prevRhsInterval.getSup().getNumber()) > 0) {
                    addIis(iis, prevRhsInterval.getSup(), currentRhsInterval.getSup());
                }
                prevRhsInterval = currentRhsInterval.clone();
            }
        }

//        System.out.println("iis: " + iis.toString());
        return iis;
    }

    private void addIis(ArrayList<Interval> iis, PDDLNumber inf, PDDLNumber sup) {
        Interval incrementInterval = new Interval();
        // inf * sup < 0, the interval crosses 0
        if (inf.getNumber() * sup.getNumber() < 0) {
            // add (inf, 0)
            incrementInterval.setInf(inf);
            incrementInterval.setSup(new PDDLNumber(0));
            iis.add(incrementInterval.clone());
            // add (0, sup)
            incrementInterval.setInf(new PDDLNumber(0));
            incrementInterval.setSup(sup);
            iis.add(incrementInterval.clone());
        } else {
            // not crossing 0, just add (inf, sup)
            incrementInterval.setInf(inf);
            incrementInterval.setSup(sup);
            iis.add(incrementInterval.clone());
        }
    }

    private void addInfiniteIntervals(ArrayList<Interval> iis, NumEffect effect, RelState rsReach, RelState rsCounting) {

        Interval temp = new Interval();

        // rhs(e).eval().getInf() = -infty
        if (effect.getRight().eval(rsReach).getInf().getNumber().compareTo(Float.NEGATIVE_INFINITY)
                * effect.getRight().eval(rsReach).getInf().getNumber().compareTo(-Float.MAX_VALUE) == 0) {
            temp.setInf(new PDDLNumber(-Float.MAX_VALUE));

            PDDLNumber supToSet = effect.getRight().eval(rsCounting).getInf();

            if (supToSet.getNumber() <= 0) {
                temp.setSup(supToSet);
                iis.add(temp.clone());
            } else {
                // now (-infty, inf) crosses 0, again!
                // add (-infty, 0) and (0, n), instead.
                temp.setSup(new PDDLNumber(0));
                iis.add(temp.clone());
                temp.setInf(new PDDLNumber(0));
                temp.setSup(supToSet);
                iis.add(temp.clone());
            }
        }
//        
        // rhs(e).eval().getSup() = +infty
        if (effect.getRight().eval(rsReach).getSup().getNumber().compareTo(Float.POSITIVE_INFINITY)
                * effect.getRight().eval(rsReach).getSup().getNumber().compareTo(Float.MAX_VALUE) == 0) {
            temp.setSup(new PDDLNumber(Float.MAX_VALUE));

            PDDLNumber infToSet = effect.getRight().eval(rsCounting).getSup();
            if (infToSet.getNumber() >= 0) {
                temp.setInf(infToSet);
                iis.add(temp.clone());
            } else {
                temp.setInf(new PDDLNumber(0));
                iis.add(temp.clone());
                temp.setSup(new PDDLNumber(0));
                temp.setInf(infToSet);
                iis.add(temp.clone());
            }
        }
//           System.out.println(iis);
//           System.exit(0);
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

        if (Math.abs(inf) == 0) {
            indirect_precondition_gt = new Comparison(">");
            indirect_precondition_lt = new Comparison("<=");
        } else if (Math.abs(sup) == 0){
            indirect_precondition_gt = new Comparison(">=");
            indirect_precondition_lt = new Comparison("<");
        } else {
            indirect_precondition_gt = new Comparison(">=");
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

        if (onlineRepresentatives) {
            //the following is just a speculative data structure to speed up the update of the sample in the subactions
            Pair<Comparison, Comparison> preconditions = new Pair();
            preconditions.setFirst(indirect_precondition_gt);
            this.comparisonBound.put(indirect_precondition_gt, inf);
            preconditions.setSecond(indirect_precondition_lt);
            this.comparisonBound.put(indirect_precondition_lt, sup);
            Pair<NumEffect, NumEffect> effects = new Pair();
            effects.setFirst(effect);
            effects.setSecond(supEff);
            this.subactionsMap.put(preconditions, effects);
//            throw new UnsupportedOperationException("This needs to be implemented");
        }

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

        if (debug > 10){
            System.out.println("State: " + s);
            System.out.println("Before updating subactions are: ");
            for (PDDLGroundAction gr : this.supporters){
                System.out.println(gr.toPDDL() + "\n");
            }
            System.out.println("===================\n\n");
        }
        
        if (onlineRepresentatives) {
            updateRepresentatives(s);
        }

        if (debug > 10){
            System.out.println("After updating subactions are: ");
            for (PDDLGroundAction gr : this.supporters){
                System.out.println(gr.toPDDL() + "\n");
            }
            System.out.println("finish compute_estimate()!\n===================\n\n\n\n");
        }

        Float ret = habs.compute_estimate(s);
        return ret;
    }

    private void updateRepresentatives(PDDLState s) {
        for (Entry<Pair<Comparison, Comparison>, Pair<NumEffect, NumEffect>> e : this.subactionsMap.entrySet()) {
            NumEffect original = e.getValue().getFirst();
            NumEffect sampled = e.getValue().getSecond();
            PDDLNumber rhsEval = original.getRight().eval(s);

//            throw new UnsupportedOperationException("This needs to be implemented");
            // I think from here you can start the reasoning by cases and update the sampled numeffect
            // I started doing something but I failed as I am not sure how to interpret the representation of the constraint
            // In particular it is not clear to me when the strict >0 comes to play. It is in fact
            // necessary that such a thing is done to enforce intervals containing zero (e.g., (0,something]).

            PDDLNumber lb = new PDDLNumber(this.comparisonBound.get(e.getKey().getFirst()));
            if (lb.getNumber() == 0f){
                lb.setNumber(epsilon);
            }
            if (rhsEval.getNumber() == 0f){
                rhsEval.setNumber(epsilon);
            }
            PDDLNumber ub = new PDDLNumber(this.comparisonBound.get(e.getKey().getSecond()));
            if (ub.getNumber() == 0f){
                ub.setNumber(-epsilon);
            }
            
            if (debug > 15){
                System.out.println("eval is: " + rhsEval.normalize());
                System.out.println("gt: " + this.comparisonBound.get(e.getKey().getFirst()));
                System.out.println("lt: " + this.comparisonBound.get(e.getKey().getSecond()));
            }
            
            if (s.satisfy(e.getKey().getFirst()) && s.satisfy(e.getKey().getSecond())) {
                sampled.setRight(rhsEval.normalize());
                if (debug > 15)
                    System.out.println("update to eval, becomes " + e.getValue().getSecond().getRight());
            } else if (s.satisfy(e.getKey().getFirst())) {
                sampled.setRight(ub .normalize());
                if (debug > 15)
                    System.out.println("update to ub, becomes " + e.getValue().getSecond().getRight());
            } else if (s.satisfy(e.getKey().getSecond())) {
                sampled.setRight(lb.normalize());
                if (debug > 15)
                    System.out.println("update to lb, becomes " + e.getValue().getSecond().getRight());
            } else {
                throw new RuntimeException("Something very wrong just happened");
            }
            
        }
    }

    private static class SortByInf implements Comparator {

        public int compare(Object o1, Object o2) {
            Interval a = (Interval) o1;
            Interval b = (Interval) o2;

            if (a.getInf().getNumber() > b.getInf().getNumber()) {
                return 1;
            } else if (a.getInf().getNumber() < b.getInf().getNumber()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

}

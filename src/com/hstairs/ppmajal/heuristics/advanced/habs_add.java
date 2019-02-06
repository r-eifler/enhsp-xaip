/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hstairs.ppmajal.heuristics.advanced;

import com.hstairs.ppmajal.conditions.Comparison;
import com.hstairs.ppmajal.expressions.*;
import com.hstairs.ppmajal.extraUtils.Pair;
import com.hstairs.ppmajal.heuristics.Aibr;
import com.hstairs.ppmajal.heuristics.Heuristic;
import com.hstairs.ppmajal.problem.*;

import java.util.*;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author dxli
 */
public class habs_add extends Heuristic {

    private static final Boolean cost_sensitive = false; // this is really "metric-sensitive".
    private static final Double epsilon = 0.1d;
    private final Integer k;
    protected final EPddlProblem problem;
    public Metric metric = null;
    public boolean onlineRepresentatives;
    public boolean midPointSampling;
    public boolean planExtraction = false;
    private h1 habs;
    private Aibr aibr_handle;
    private HashMap<Pair<Comparison, Comparison>, Pair<NumEffect, NumEffect>> subactionsMap;
    private HashMap<Comparison, Float> comparisonBound;
    private boolean risky = false;
    private HashMap<GroundAction, GroundAction> subactionOf;
    protected EPddlProblem subProblem;
    private Collection<GroundAction> subProblemActions ;



    public habs_add (EPddlProblem problem, Integer k) {
        super(problem.goals,problem.actions,problem.getProcessesSet(),problem.getEventsSet());
        this.problem = problem;
        this.k = k;
        subProblem = new EPddlProblem();
        subProblemActions = subProblem.actions;
        subProblem.goals = problem.getGoals();
    }


    public void setMetric (Metric metric) {
        this.metric = metric;
    }

    /* Setup step for habs_add heuristic. Returns the heuristic for the initial
    state (if goal is reachable); otherwise, returns infinity.
    
    We do the following in the setup:
    (1). Run AIBR reachability analysis step. Returns inf if not reachable.
    (2). Generate subactions by running AIBR operator counting procedure.
         The subactions are addded to this.supporters.
    (3). Instatiate a h1 heuristic using original goal set G and subaction set
         this.supporters.
    (4). Return initial heuristic estimate by calling the above h1 instance.
    */
    @Override
    public Float setup (State gs) {
        PDDLState s = (PDDLState) gs;

        this.aibr_handle = new Aibr(problem);
        this.aibr_handle.setup(s);
        this.aibr_handle.set(true, true);
        // (1). Run AIBR reachability analysis step. Returns inf if not reachable.
        Float ret = aibrReachabilityAnalysis(s);
        if (ret == Float.MAX_VALUE) {
            // not reachable!
            return ret;
        }

        if (onlineRepresentatives) {
            subactionsMap = new HashMap();
            comparisonBound = new HashMap();
        }

        simplify_actions(s);
        if (this.helpful_actions_computation) {
            this.subactionOf = new HashMap();
            this.helpful_actions = new HashSet();
        }
        try {
            // (2). Generate subactions by running AIBR operator counting procedure.
            //      The subactions are addded to this.supporters.
            generate_subactions(s);
            System.out.println("|Subactions| = " + subProblemActions.size());
            if (debug > 100) {
                for (GroundAction gr : subProblemActions) {
                    System.out.println(gr.toPDDL() + "\n\n");
                }
            }
//            System.exit(0);
        } catch (Exception ex) {
            // non-linear effects not supported
            Logger.getLogger(habs_add.class.getName()).log(Level.SEVERE, null, ex);
        }

        // (3). Instatiate a h1 heuristic using original goal set G and subaction set
        //      this.supporters.
        setup_habs(s);
        habs.extractRelaxedPlan = this.planExtraction;
        habs.helpful_actions_computation = this.helpful_actions_computation;

        // (4). Return initial heuristic estimate by calling the above h1 instance.
        ret = habs.computeEstimate(s);
        return ret;
    }

    private Float aibrReachabilityAnalysis (PDDLState s) {
        // reachability analysis on original problem using AIBR.
        Float ret = this.aibr_handle.computeEstimate(s);
        A = this.aibr_handle.getReachableTransitions();
        reachable = this.aibr_handle.getReachableTransitions();

        return ret;
    }

    /**
     * <p>
     * Generates subactions, and adds them to this.supporters.
     *
     * @param s_0 the initial state. Currently only statically generate
     *            subactions before the search started. In the future, may understand how
     *            to do this online.
     * @return null
     * @throws Exception does not support non-linear effect right now.
     *                   <p>
     */
    private void generate_subactions (PDDLState s_0) throws Exception {

        ArrayList<RelState> relaxedStates = getRelaxedGoal(s_0);
        RelState rsReachability = getReachabilityRelaxedState(s_0);
        // add AIBR reachability analysis relaxed states into the list
        relaxedStates.add(rsReachability);

        NumEffect effectOnCost = null;

        System.out.println("Generating subactions.");

        // a holder for constant numeric effects
        ArrayList<NumEffect> allConstantEffects = new ArrayList();

        for (GroundAction gr : A) {
            allConstantEffects.clear();

            if (gr.getNumericEffects() != null && !gr.getNumericEffects().sons.isEmpty()) {
                for (NumEffect effect : (Collection<NumEffect>) gr.getNumericEffects().sons) {
                    if (effect.getFluentAffected().getName().equals("total-cost") && cost_sensitive) {
                        effectOnCost = (NumEffect) effect.clone();
                        continue;
                    }

                    ExtendedNormExpression rhs = (ExtendedNormExpression) effect.getRight();
                    // this is assuming no non-linear effects at the moment.
                    if (((!rhs.getInvolvedNumericFluents().isEmpty() || effect.getOperator().equalsIgnoreCase("assign")) && rhs.linear)) {
                        NumEffect temp;
                        if (effect.getOperator().equalsIgnoreCase("assign")) {//This is additive transformation\
                            temp = new NumEffect("increase");
                            temp.setFluentAffected(effect.getFluentAffected());
                            temp.setRight(new BinaryOp(effect.getRight(), "-", effect.getFluentAffected(), true).normalize());
                        } else {
                            temp = effect;
                        }
                        addPiecewiseSubactions(gr.toFileCompliant() + " " + temp.getFluentAffected(), gr, temp, effectOnCost, relaxedStates, s_0);


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

    private ArrayList<RelState> getRelaxedGoal (PDDLState s) {
        return aibr_handle.get_relaxed_reachable_states(s, s.relaxState());
    }

    private RelState getReachabilityRelaxedState (PDDLState s_0) {
        return aibr_handle.get_relaxed_goal_in_reachability(s_0);
    }

    /**
     * Setup habs without reachability analysis.
     *
     * @param s
     */
    public void setup_habs (PDDLState s) {

        System.out.println("setting up...");

        habs = new h1(subProblem);
        habs.light_setup(s);
        System.out.println("setup completed!");
    }

    /**
     * <p>
     * Generates piecewise subactions for NON-CONSTANT LINEAR effects, and adds
     * subactions to this.supporters.
     *
     * @param name         a srting used for naming the subaction, is the concatenation
     *                     of action name and effect lhs name.
     * @param gr           the action
     * @param effect       the effect to be decomposed
     * @param effectOnCost the effect on metric
     * @return null
     * @throws Exception does not support non-linear effect right now.
     *                   <p>
     */
    private void addPiecewiseSubactions (String name, GroundAction gr, NumEffect effect, NumEffect effectOnCost, ArrayList<RelState> relaxedStates, PDDLState s_0) {
        // decomposition
        ArrayList<Interval> iis = decomposeRhs(effect, relaxedStates);

        if (debug > 101) {
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
            GroundAction subaction = generatePiecewiseSubaction(subactionName,
                    repSample,
                    inf,
                    sup,
                    effect,
                    effectOnCost,
                    gr,
                    s_0);

            if (this.helpful_actions_computation) {
                if (this.subactionOf.get(subaction) == null) {
                    this.subactionOf.put(subaction, gr);
                }
            }

            this.subProblemActions.add(subaction);
        }
    }

    private Expression lowerBoundSampling (Float inf, Float sup) {
        Expression repSample;
        if (Math.abs(inf) == 0) { // inf = 0
            repSample = new ExtendedNormExpression(epsilon);
//                repSample = new ExtendedNormExpression((inf + sup)/2);
        } else if (inf > 0) {
            repSample = new ExtendedNormExpression(inf.doubleValue());
        } else // inf < 0
            if (Math.abs(sup) == 0) { // sup = 0
                repSample = new ExtendedNormExpression(-epsilon);
//                   repSample = new ExtendedNormExpression((inf + sup)/2);
            } else {
                repSample = new ExtendedNormExpression(sup.doubleValue());
            }
        return repSample;
    }
//    

    private Expression midSampling (Float inf, Float sup) {
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
                repSample = new ExtendedNormExpression(inf.doubleValue());
            } else { // sup > 0, but finite
                repSample = new ExtendedNormExpression((inf + sup) / 2.0f);
            }
        } else // inf < 0
            if (inf == -Float.MAX_VALUE) { // inf = -infty
                if (Math.abs(sup) < 1e-5) { // sup = 0
                    repSample = new ExtendedNormExpression(-epsilon.floatValue());
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

    private ArrayList<Interval> decomposeRhs (NumEffect effect, ArrayList<RelState> relaxedStates) {
        // ====== now generating increment interval sequence (IIS) ======
        ArrayList<Interval> iis = getIis(effect, relaxedStates);

        // Reachability information from AIBR analysis has been added to relaxedStates already,
        // therefore we don't need to add infinite intervals anymore.
//        addInfiniteIntervals(iis, effect, rsReach, relaxedStates.get(relaxedStates.size() - 1));

        Collections.sort(iis, new SortByInf());

        // ====== now start merging IIS into subdomains ======
        ArrayList<Interval> ret = mergeIis(iis);

        return ret;
    }

    private ArrayList<Interval> mergeIis (ArrayList<Interval> iis) {
        // ===== separate positive from negative intervals =====
        ArrayList<Interval> posIis = new ArrayList<>();
        ArrayList<Interval> negIis = new ArrayList<>();

        if (iis.isEmpty()) {
            return new ArrayList<>();
        }

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

        return ret;
    }

    private void merge (ArrayList<Interval> iis, int size, ArrayList<Interval> ret) {
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
                }
            }

            if (i != iis.size()) {
                temp.setInf(l);
                temp.setSup(iis.get(iis.size() - 1).getSup());
                ret.add(temp.clone());
            }
        }
    }

    private ArrayList<Interval> getIis (NumEffect effect, ArrayList<RelState> relaxedStates) {
        ArrayList<Interval> iis = new ArrayList(); // increment interval sequence (IIS) 

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

        return iis;
    }

    private void addIis (ArrayList<Interval> iis, PDDLNumber inf, PDDLNumber sup) {
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

    private GroundAction generatePiecewiseSubaction (String subactionName, Expression repSample, Float inf, Float sup, NumEffect effect, NumEffect effectOnCost, GroundAction gr, PDDLState s_0) {
        GroundAction subaction = new GroundAction(subactionName,subProblem.getFreshActionId());

        // set up effect
        NumEffect supEff = new NumEffect(effect.getOperator());
        supEff.setFluentAffected(effect.getFluentAffected());
        supEff.setRight(repSample);

        // set effects for subactions
        subaction.getNumericEffects().sons.add(supEff);

        if (cost_sensitive && effectOnCost != null) {
            subaction.getNumericEffects().sons.add(effectOnCost);
            subaction.setActionCost(s_0, this.metric);
        } else {
            // if not metric sensitive, set uniform action cost
            subaction.setActionCost(1);
        }

        // setup preconditions. Preconditions = (indirect_preconditions) U pre(gr)
        Comparison indirect_precondition_gt;
        Comparison indirect_precondition_lt;

        if (inf < 0) {
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
     * @param name   a string to distinguish between effects.
     * @param gr     the grounded action.
     */
    private void addConstantSubaction (String name, GroundAction gr, ArrayList<NumEffect> allConstantEffects, NumEffect effectOnCost, PDDLState s_0) {
        GroundAction sup = new GroundAction(name,subProblem.getFreshActionId());

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
            sup.setActionCost(s_0, metric);
        } else {
            // if not metric sensitive, set uniform action cost
            sup.setActionCost(1);
        }

        subProblemActions.add(sup);
    }

    @Override
    public Float computeEstimate (State gs) {
        PDDLState s = (PDDLState) gs;
//        System.out.println("start computeEstimate()...");

        if (debug > 10) {
            System.out.println("State: " + s);
            System.out.println("Before updating subactions are: ");
            for (GroundAction gr : this.subProblemActions) {
                System.out.println(gr.toPDDL() + "\n");
            }
            System.out.println("===================\n\n");
        }

        if (onlineRepresentatives) {
            updateRepresentatives(s);
        }

        if (debug > 10) {
            System.out.println("After updating subactions are: ");
            for (GroundAction gr : this.subProblemActions) {
                System.out.println(gr.toPDDL() + "\n");
            }
            System.out.println("finish computeEstimate()!\n===================\n\n\n\n");
        }

        Float ret = habs.computeEstimate(s);
        if (this.helpful_actions_computation) {
            this.helpful_actions = new HashSet();
            for (GroundAction gr : habs.getHelpfulActions()) {
                GroundAction subaction = this.subactionOf.get(gr);
                if (subaction != null)
                    this.getHelpfulActions().add(this.subactionOf.get(gr));
                else
                    this.getHelpfulActions().add(gr);
            }
        }
        return ret;
    }

    private void updateRepresentatives (PDDLState s) {
        for (Entry<Pair<Comparison, Comparison>, Pair<NumEffect, NumEffect>> e : this.subactionsMap.entrySet()) {
            NumEffect original = e.getValue().getFirst();
            NumEffect sampled = e.getValue().getSecond();
            Double rhsEval = original.getRight().eval(s);

//            throw new UnsupportedOperationException("This needs to be implemented");
            PDDLNumber lb = new PDDLNumber(this.comparisonBound.get(e.getKey().getFirst()));
            if (lb.getNumber() == 0f) {
                lb.setNumber(epsilon.floatValue());
            }
            if (rhsEval == 0d) {
                rhsEval = epsilon;
            }
            PDDLNumber ub = new PDDLNumber(this.comparisonBound.get(e.getKey().getSecond()));
            if (ub.getNumber() == 0f) {
                ub.setNumber(-epsilon.floatValue());
            }

            if (debug > 15) {
                System.out.println("eval is: " + (new PDDLNumber(rhsEval)).normalize());
                System.out.println("gt: " + this.comparisonBound.get(e.getKey().getFirst()));
                System.out.println("lt: " + this.comparisonBound.get(e.getKey().getSecond()));
            }

            if (s.satisfy(e.getKey().getFirst()) && s.satisfy(e.getKey().getSecond())) {
                sampled.setRight((new PDDLNumber(rhsEval)).normalize());
                if (debug > 15) {
                    System.out.println("update to eval, becomes " + e.getValue().getSecond().getRight());
                }
            } else if (s.satisfy(e.getKey().getFirst())) {
                sampled.setRight(ub.normalize());
                if (debug > 15) {
                    System.out.println("update to ub, becomes " + e.getValue().getSecond().getRight());
                }
            } else if (s.satisfy(e.getKey().getSecond())) {
                sampled.setRight(lb.normalize());
                if (debug > 15) {
                    System.out.println("update to lb, becomes " + e.getValue().getSecond().getRight());
                }
            } else {
                throw new RuntimeException("Something very wrong just happened");
            }

        }
    }

    /*
        A comparator for intervals.
    
        Interval a < b if inf(a) < inf(b).
        Interval a > b if inf(a) > inf(b).
    */
    private static class SortByInf implements Comparator {

        public int compare (Object o1, Object o2) {
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

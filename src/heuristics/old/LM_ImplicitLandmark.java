package heuristics.old;

import conditions.Comparison;
import conditions.Conditions;
import conditions.Predicate;
import ilog.concert.IloException;
import ilog.concert.IloLinearNumExpr;
import ilog.concert.IloNumVar;
import ilog.concert.IloNumVarType;
import ilog.cplex.IloCplex;
import problem.GroundAction;
import problem.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by dennisan on 10/1/17.
 */
public class LM_ImplicitLandmark extends UniformCostSearch_LM {

    public LM_ImplicitLandmark(Conditions goal, Set<GroundAction> A) {super(goal, A);}


    @Override
    public Float compute_estimate(State s) {

        if (this.G.isSatisfied(s)) {
            return (float) 0;
        }

        this.init_data_structure(s);

        boolean needActivation;

        while (!reachableActions.isEmpty()) {
            needActivation = false;
            GroundAction gr = reachableActions.remove();
            for (Conditions c : conditionsToConsider) {
                if (gr.getPreconditions().sons.contains(c)) {
                    continue; //Assume no action can achieve its precondition
                }
                if (c instanceof Predicate) {
                    Predicate p = (Predicate) c;
                    if (gr.achieve(p)) {
                        if (!conditionReachable.get(c.getCounter())) {
                            //if not reachable before, need to consider some new action;
                            conditionReachable.put(c.getCounter(), true);
                            needActivation = true;
                        }
                        //Mark this action as this condition's possible achiever.
                        possible_achievers.get(c.getCounter()).add(new repetition_landmark(gr, 1));
                    }
                    continue;
                }

                if (c instanceof Comparison) {
                    Comparison cmp = (Comparison) c;
                    Float repetition_needed = gr.getNumberOfExecution(s, cmp);
                    if (repetition_needed != Float.MAX_VALUE) {
                        if (!conditionReachable.get(c.getCounter())) {
                            conditionReachable.put(c.getCounter(), true);
                            needActivation = true;
                        }
                        possible_achievers.get(c.getCounter()).add(new repetition_landmark(gr, (float) Math.ceil(repetition_needed)));
                    }

                }
            }
            if (needActivation) {
                Iterator<GroundAction> itr = actionNotApplicableYet.iterator();
                while (itr.hasNext()) {
                    GroundAction g = itr.next();
                    boolean reachable = true;
                    if (g.getPreconditions() != null && !g.getPreconditions().sons.isEmpty()) {
                        for (Conditions c : (Collection<Conditions>) g.getPreconditions().sons) {
                            if (!conditionReachable.get(c.getCounter())) {
                                //still not reachable
                                reachable = false;
                                break;
                            }
                        }
                        if (reachable) {
                            reachableActions.add(g);
                            reachable_at_this_stage.add(g);
                            itr.remove();
                        }
                    }
                }
            }
        }


        findGoalLandmark(G, s);

        //If found such landmark in this problem, it will print on the screen
        for (Conditions c1: (Collection<Conditions>) this.G.sons) {
            //findImplicitLandmarks(c1);
            if (findImplicitLandmarks(c1)) {
                System.out.println("Implicit Landmarks found");
            }
        }

        float estimate = 0;
        if (compute_lp) {
            n_lp_invocations++;
            try {
                IloCplex lp = new IloCplex();
                lp.setOut(null);

                IloLinearNumExpr objective = lp.linearNumExpr();
                for (Conditions c : goalLandmark) {
                    IloLinearNumExpr expr = lp.linearNumExpr();
                    for (repetition_landmark dlm : this.possible_achievers.get(c.getCounter())) {
                        IloNumVar action;
                        dlm.gr.setAction_cost(s);
                        Float action_cost = dlm.gr.getAction_cost();
                        if (action_cost.isNaN()) {
                            continue;
                        }
                        if (action_to_variable.get(dlm.gr.counter) != null) {
                            action = action_to_variable.get(dlm.gr.counter);
                        } else {
                            action = lp.numVar(0.0, Float.MAX_VALUE, IloNumVarType.Float);
                            action_to_variable.put(dlm.gr.counter, action);
                            objective.addTerm(action, action_cost);
                        }
                        expr.addTerm(action, 1.0 / dlm.repetition);
                    }
                    lp.addGe(expr, 1);
                }
                lp.addMinimize(objective);

                if (lp.solve()) {

                    if (lp.getStatus() == IloCplex.Status.Optimal) {
                        estimate = (float) lp.getObjValue();
                    } else {
                        estimate = Float.MAX_VALUE;
                    }
                } else {
                    estimate = Float.MAX_VALUE;
                }
                lp.end();

            } catch (IloException ex) {
                Logger.getLogger(landmarks_factory.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Landmark Heuristic has to compute LP to remain optimal, please set the compute_lp = true");
            estimate = Integer.MAX_VALUE;
        }
        return estimate;
    }


    //For now I use return type as Boolean to found out whether a domain contains such landmarks, it can change to void
    protected boolean findImplicitLandmarks(Conditions c) {
        boolean found = false;
        ArrayList<Conditions> preconditions = new ArrayList<>();

        for (repetition_landmark rp : this.possible_achievers.get(c.getCounter())) {
            if ((rp.gr.getPreconditions() != null ) && (rp.gr.getPreconditions().sons != null)) {
                preconditions.addAll(rp.gr.getPreconditions().sons);
            }
        }

        for (int i=0; i<preconditions.size(); i++) {
            boolean isLandmark = true;
            Conditions c1  = preconditions.get(i);

            if (c1 instanceof Predicate) {continue;}

            for (int j=0; j<preconditions.size(); j++) {

                if (i==j) {continue;}

                Conditions c2 = preconditions.get(j);

                if (c2 instanceof Predicate) {continue;}

                Comparison a1 = (Comparison) c1;
                Comparison a2 = (Comparison) c2;

                if (!a2.dominate(a1) ) {
                    isLandmark = false;
                    break;
                }
            }
            if (isLandmark) {
                conditionLandmark.get(c.getCounter()).add(c1);
                found = true;

            }
        }
        return found;
    }
}

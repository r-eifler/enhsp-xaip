package heuristics.advanced;

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

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Da An on 8/12/16.
 */
public class landmark_factory_DC extends landmarks_factory {

    public landmark_factory_DC(Conditions goal, Set<GroundAction> A) {
        super(goal, A);
    }

    @Override
    public Float compute_estimate(State s_0) {
        if (this.G.isSatisfied(s_0))
            return (float)0;
        this.init_data_structures(s_0);
        HashMap<Integer, IloNumVar> action_to_variable = new HashMap();
        boolean update;
        Set<GroundAction> actions_to_consider = new LinkedHashSet();
        actions_to_consider.addAll(reachable);
        possible_achievers = new HashMap();
        do {
            update = false;
            for (Conditions c : all_conditions) {

                int l = condition_level.get(c.getCounter());
                int old_dplus = dplus.get(c.getCounter());
                Set<GroundAction> ach_of_conditions = new LinkedHashSet();
                Set<repetition_landmark> ach_of_conditions_with_repetition = new LinkedHashSet();

                if (c instanceof Predicate) {
                    Predicate p = (Predicate) c;
                    reacheable_at_this_stage.stream().filter((gr) -> (gr.achieve(p))).map((gr) -> {
                        dplus.put(c.getCounter(), Math.min(1, dplus.get(c.getCounter())));
                        condition_level.put(p.getCounter(), Math.min(action_level.get(gr.counter) + 1, condition_level.get(p.getCounter())));
                        return gr;
                    }).forEach((gr) -> {
                        ach_of_conditions.add(gr);
                        ach_of_conditions_with_repetition.add(new repetition_landmark(gr, 1));
                    });
                } else if (c instanceof Comparison) {
                    Comparison cmp = (Comparison) c;
                    reacheable_at_this_stage.stream().forEach((gr) -> {
                        Float repetition_needed = gr.getNumberOfExecution(s_0, cmp);
                        if (repetition_needed != Float.MAX_VALUE) {
                            dplus.put(c.getCounter(), Math.min(repetition_needed.intValue(), dplus.get(c.getCounter())));
                            condition_level.put(cmp.getCounter(), Math.min((action_level.get(gr.counter) + 1), condition_level.get(cmp.getCounter())));
                            ach_of_conditions.add(gr);
                            ach_of_conditions_with_repetition.add(new repetition_landmark(gr, (float) Math.ceil(repetition_needed)));

                        }
                    });
                }
                update_poss_achievers(c, ach_of_conditions_with_repetition);
                if (update_landmarks(c, ach_of_conditions) || l != condition_level.get(c.getCounter()) || dplus.get(c.getCounter()) != old_dplus) {
                    update = true;
                }
            }

            if (update) {
                Iterator<GroundAction> it = actions_to_consider.iterator();
                while (it.hasNext()) {
                    GroundAction gr = it.next();
                    if (gr.getPreconditions() != null && !gr.getPreconditions().sons.isEmpty()) {
                        int max = Integer.MIN_VALUE;
                        boolean activated = true;
                        Set<Conditions> candidate = new LinkedHashSet();
                        for (Conditions c : (Collection<Conditions>) gr.getPreconditions().sons) {
                            if (condition_level.get(c.getCounter()) != Integer.MAX_VALUE) {
                                max = Math.max(max, condition_level.get(c.getCounter()));
                                candidate.addAll(landmark_of.get(c.getCounter()));
                            } else {
                                activated = false;
                                break;
                            }
                        }
                        if (activated) {
                            action_level.put(gr.counter, max);
                            reacheable_at_this_stage.add(gr);
                            landmark_of_action.put(gr.counter, candidate);
                            it.remove();
                        }

                    }
                }
            }

        } while (update);

        for (Conditions c1: (Collection<Conditions>) this.G.sons) {
            if (findImplicitLandmarks(c1)) {
                System.out.println("Implicit Landmarks found");
            }
        }

        Set<Conditions> goal_landmark = new LinkedHashSet();
        for (Conditions c : (Collection<Conditions>) this.G.sons) {
            if (condition_level.get(c.getCounter()) == Integer.MAX_VALUE) {
                return Float.MAX_VALUE;
            }
            goal_landmark.addAll(landmark_of.get(c.getCounter()));
        }

        findDominateConstrains(goal_landmark);


        float estimate = 0;
        if (compute_lp) {
            try {
                IloCplex lp = new IloCplex();
                lp.setOut(null);

                IloLinearNumExpr objective = lp.linearNumExpr();
                for (Conditions c : goal_landmark) {
                    if (!c.isSatisfied(s_0)) {
                        IloLinearNumExpr expr = lp.linearNumExpr();


                        for (repetition_landmark dlm : this.possible_achievers.get(c.getCounter())) {
                            IloNumVar action;
                            dlm.gr.setAction_cost(s_0);
                            Float action_cost = dlm.gr.getAction_cost();
                            if (action_cost.isNaN()) {
                                continue;
                            }
                            if (action_to_variable.get(dlm.gr.counter) != null) {
                                action = action_to_variable.get(dlm.gr.counter);
                            } else {
                                action = (IloNumVar) lp.numVar(0.0, Float.MAX_VALUE, IloNumVarType.Float);
                                action_to_variable.put(dlm.gr.counter, action);
                                objective.addTerm(action, action_cost);
                            }
                            expr.addTerm(action, 1.0 / dlm.repetition);
                        }
                        lp.addGe(expr, 1);
                    }
                }
                lp.addMinimize(objective);

                if (lp.solve()) {
                    if (lp.getStatus() == IloCplex.Status.Optimal) {
                        estimate = (float)lp.getObjValue();
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
            for (Conditions c : goal_landmark) {//these are the landmarks for the planning task
//                System.out.println("Debug: Poss_achiever(" + c + ":)" + this.possible_achievers.get(c.getCounter()));

                estimate += dplus.get(c.getCounter());
            }
        }


        return estimate;
    }

    private void findDominateConstrains(Set<Conditions> set) {
        boolean found = false;  //Test Purpose;
        ArrayList<Conditions> setAsArray = new ArrayList(set);

        for (int i = 0; i< setAsArray.size(); i++) {
            Conditions c1 = setAsArray.get(i);
            if (c1 instanceof Predicate) {
                continue;
            }
            for (int j = i+1; j< setAsArray.size(); j++) {
                Conditions c2 = setAsArray.get(j);
                if (c2 instanceof Predicate) {
                    continue;
                }
                Comparison a1 = (Comparison) c1;
                Comparison a2 = (Comparison) c2;
                if (a1.equals(c2)) {
                    //same constrains, do something
                    set.remove(c2);
                    found = true;
                    continue;
                }
                if (a1.isDominantConstrainOf(a2)) {
                    //do something;
                    set.remove(c2);
                    found = true;
                    continue;
                }
                if (a2.isDominantConstrainOf(a1)) {
                    //do something;
                    set.remove(c1);
                    found = true;
                }
            }
        }
        //return found;
    }



    private boolean findImplicitLandmarks(Conditions c) {
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
//                if (a1.isDominantConstrainOf(a2)) {
//                    landmark_of.get(c.getCounter()).add(c2);
//                    found = true;
//                    continue;
//                }
                if (!a2.isDominantConstrainOf(a1) ) {
                    isLandmark = false;
                    break;
                }
            }
            if (isLandmark) {
                landmark_of.get(c.getCounter()).add(c1);
                found = true;
            }
        }
        return found;
    }


}

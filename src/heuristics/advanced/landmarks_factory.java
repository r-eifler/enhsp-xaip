/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heuristics.advanced;

import conditions.Comparison;
import conditions.Conditions;
import conditions.Predicate;
import expressions.ExtendedNormExpression;
import expressions.NumFluent;
import heuristics.Heuristic;
import ilog.concert.IloException;
import ilog.concert.IloLinearNumExpr;
import ilog.concert.IloNumVar;
import ilog.concert.IloNumVarType;
import ilog.cplex.IloCplex;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import problem.GroundAction;
import problem.State;

/**
 *
 * @author enrico
 */
public class landmarks_factory extends Heuristic {

    public HashMap<Integer, Set<Conditions>> landmark_of;
    public HashMap<Integer, Set<Conditions>> landmark_of_action;

    public HashMap<Integer, Integer> condition_level;
    public HashMap<Integer, Integer> action_level;
    public HashMap<Integer, Integer> dplus; //this is the minimum number of actions needed to achieve a given condition
    private LinkedHashSet<GroundAction> reacheable_at_this_stage;

    public HashMap<Integer, Set<repetition_landmark>> possible_achievers;
    public boolean compute_lp;

    //protected LinkedHashSet<Comparison> redundant_constrains;

    public landmarks_factory(Conditions goal, Set<GroundAction> A) {
        super(goal, A);
        this.build_integer_representation();
    }

    public void init_data_structures(State s_0) {
        landmark_of = new HashMap();
        landmark_of_action = new HashMap();
        condition_level = new HashMap();
        action_level = new HashMap();
        dplus = new HashMap();
        reacheable_at_this_stage = new LinkedHashSet();

        all_conditions.stream().forEach((c) -> {
            Set<Conditions> lms = new LinkedHashSet();
            lms.add(c);//add itself
            landmark_of.put(c.getCounter(), lms);
        });
        all_conditions.stream().forEach((c) -> {
            if (c.isSatisfied(s_0)) {
                condition_level.put(c.getCounter(), 0);
                dplus.put(c.getCounter(), 0);
            } else {
                condition_level.put(c.getCounter(), Integer.MAX_VALUE);
                dplus.put(c.getCounter(), Integer.MAX_VALUE);
            }
        });
        reachable.stream().forEach((GroundAction gr) -> {
            if (gr.isApplicable(s_0)) {
                action_level.put(gr.counter, 0);
                landmarks_factory.this.reacheable_at_this_stage.add(gr);
                if (gr.getPreconditions() != null && !gr.getPreconditions().sons.isEmpty()) {
                    Set<Conditions> lms = new LinkedHashSet();
                    for (Conditions c : (Collection<Conditions>) gr.getPreconditions().sons) {
                        lms.add(c);
                    }
                    landmark_of_action.put(gr.counter, lms);
                } else {
                    landmark_of_action.put(gr.counter, new LinkedHashSet<>());
                }
            } else {
                action_level.put(gr.counter, Integer.MAX_VALUE);
                landmark_of_action.put(gr.counter, new LinkedHashSet<>());
            }
        });
    }

    @Override
    public Float setup(State s_0) {
        //generate basic structures for landmarks

        reachable.addAll(A);
        Float ret = compute_estimate(s_0);  //reachability analysis
        reachable = new LinkedHashSet();
        reachable.addAll(reacheable_at_this_stage);
        return ret;
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

                int l = condition_level.get(c.getCounter());    //didn't use later
                int old_dplus = dplus.get(c.getCounter());      //didn't use later
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
                            ach_of_conditions_with_repetition.add(new repetition_landmark(gr, repetition_needed.intValue()));

                        }
                    });
                }
                update_poss_achievers(c, ach_of_conditions_with_repetition);
                if (update_landmarks(c, ach_of_conditions)){// || l != condition_level.get(c.getCounter()) || dplus.get(c.getCounter()) != old_dplus) {
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

        Set<Conditions> goal_landmark = new LinkedHashSet();
        for (Conditions c : (Collection<Conditions>) this.G.sons) {
            if (condition_level.get(c.getCounter()) == Integer.MAX_VALUE) {
                return Float.MAX_VALUE;
            }
            goal_landmark.addAll(landmark_of.get(c.getCounter()));
        }

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

    private boolean update_landmarks(Conditions c, Set<GroundAction> achievers) {
        if (achievers.isEmpty()) {
            return false;
        }
        Set<Conditions> previous = this.landmark_of.get(c.getCounter());

        Set<Conditions> intersection = null;
        for (GroundAction gr : achievers) {
            if (intersection == null) {
                intersection = new LinkedHashSet();
                intersection.addAll(landmark_of_action.get(gr.counter));
            } else {
                Set<Conditions> new_set = landmark_of_action.get(gr.counter);
                intersection.retainAll(new_set);
            }
        }
        intersection.add(c);

        if (previous == null || !previous.equals(intersection)) {
            this.landmark_of.put(c.getCounter(), intersection);
            return true;
        } else {
            return false;
        }
    }

    private void update_poss_achievers(Conditions c, Set<repetition_landmark> ach_of_conditions) {
        if (this.possible_achievers.get(c.getCounter()) == null) {
            this.possible_achievers.put(c.getCounter(), new LinkedHashSet());
        }
        this.possible_achievers.get(c.getCounter()).addAll(ach_of_conditions);
    }

    public class repetition_landmark extends Object {

        public GroundAction gr;
        public float repetition;

        public repetition_landmark(GroundAction gr_input, float repetition_input) {
            super();
            this.gr = gr_input;
            this.repetition = repetition_input;
        }

        @Override
        public String toString() {
            return "(" + gr.toEcoString() + " " + repetition + ")";
        }

        @Override
        public boolean equals(Object b) {
            if (b instanceof repetition_landmark) {
                repetition_landmark b_rep = (repetition_landmark) b;
                return b_rep.gr.counter == gr.counter;
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 89 * hash + Objects.hashCode(this.gr.counter);
            return hash;
        }
    }


    protected void add_redundant_constrains(LinkedHashSet set) throws Exception {
        ArrayList<Conditions> set_as_array = new ArrayList(set);
        //System.out.println("set:");
        //System.out.println(set_as_array.toString());

        int counter = all_conditions.size();

        for (int i=0; i<set_as_array.size(); i++) {
            for (int j=i+1; j<set_as_array.size();j++) {
                Conditions c1 = set_as_array.get(i);
                Conditions c2 = set_as_array.get(j);
                //System.out.println("c1: "+c1);
                //System.out.println("c2:" +c2);
                /*
                System.out.println("C1: "+c1);
                if (c1 instanceof  Comparison) {

                    System.out.println(((Comparison) c1).getComparator().toString());
                }

                if (c1 instanceof Comparison) {
                    System.out.println(c1);
                }
                */
                if ((c1 instanceof Comparison) && (c2 instanceof Comparison)) {
                    //if (i<j) {
                    Comparison a1 = (Comparison)c1;
                    Comparison a2 = (Comparison)c2;
                    //System.out.println("a1: " + a1);
                    //System.out.println("a2: " + a2);
                    //if (suitable_to_combine(a1, a2)){
                    ExtendedNormExpression lhs_a1 = (ExtendedNormExpression) a1.getLeft();
                    ExtendedNormExpression lhs_a2 = (ExtendedNormExpression) a2.getLeft();
                    if (suitable_to_combine(lhs_a1, lhs_a2)){
                        ExtendedNormExpression expr = lhs_a1.sum(lhs_a2);
                        String new_comparator = ">=";
                        if (a1.getComparator().equals(">") && a2.getComparator().equals(">")) {
                            new_comparator = ">";
                        }
                        Comparison cnew = new Comparison(new_comparator);
                        counter += 1;
                        cnew.setLeft(expr);
                        cnew.setRight(new ExtendedNormExpression(new Float(0.0)));
                        cnew.normalize();
                        cnew.setCounter(counter);
                        //System.out.println("cnew: "+cnew);
                            ///ExtendedNormExpression temp  (ExtendedNormExpression) cnew.getLeft();
                        if (expr.summations.size()<2) {
                            //System.out.println("inIF");
                            continue;
                        }
                        //System.out.println("reach here");
                        set.add(cnew);
                        all_conditions.add(cnew);
                    }
                    //System.out.println("reach here");
                    //}
                }
            }
        }
        //set.addAll(redundant_constrains);
        //System.out.println(redundant_constrains);
    }

    private boolean suitable_to_combine(ExtendedNormExpression e1, ExtendedNormExpression e2) {
        Set e1_fluent = e1.fluentsInvolved();
        Set e2_fluent = e2.fluentsInvolved();

        for (Object f1 : e1_fluent) {
            for (Object f2: e2_fluent) {
                if (f1.equals(f2)){
                    return true;
                }
            }
        }
        return false;
    }
}

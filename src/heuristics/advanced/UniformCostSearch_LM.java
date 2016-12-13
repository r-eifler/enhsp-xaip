package heuristics.advanced;

import conditions.Comparison;
import conditions.Conditions;
import conditions.Predicate;
import heuristics.Heuristic;
import ilog.concert.IloException;
import ilog.concert.IloLinearNumExpr;
import ilog.concert.IloNumVar;
import ilog.concert.IloNumVarType;
import ilog.cplex.IloCplex;
import org.jgrapht.util.FibonacciHeap;
import org.jgrapht.util.FibonacciHeapNode;
import problem.GroundAction;
import problem.State;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Da An on 10/12/16.
 */

public class UniformCostSearch_LM extends Heuristic {

    public HashMap<Integer, Set<Conditions>> landmark_of;
    public HashMap<Integer, Set<Conditions>> landmark_of_action;
    public HashMap<Integer, Integer> condition_level;
    public HashMap<Integer, Integer> action_level;
    public HashMap<Integer, Integer> dplus; //this is the minimum number of actions needed to achieve a given condition
    public FibonacciHeap<GroundAction> pq;
    public HashMap<Integer, Set<repetition_landmark>> possible_achievers;
    private HashMap<Integer, FibonacciHeapNode<GroundAction>> actionAsFibNode;
    protected LinkedHashSet<GroundAction> reachable_at_this_stage;


    private HashMap<Integer, Set<GroundAction>> ach_of_conditions;
    private HashMap<Integer, repetition_landmark> ach_of_conditions_with_repetition;

    public boolean compute_lp;

    public UniformCostSearch_LM(Conditions G, Set<GroundAction> A) {
        super(G, A);
        this.build_integer_representation();
    }

    @Override
    public Float setup(State s_0) {
        reachable.addAll(A);
        Float ret = compute_estimate(s_0);
        reachable = new LinkedHashSet();
        reachable.addAll(reachable_at_this_stage);
        return ret;
    }


    @Override
    public Float compute_estimate(State s) {
        if (this.G.isSatisfied(s)) {
            return (float)0;
        }
        HashMap<Integer, IloNumVar> action_to_variable = new HashMap();
        this.init_data_structure(s);

        boolean needActivation;
        while (!pq.isEmpty()) {
            needActivation = false;
            GroundAction gr = pq.removeMin().getData();
            if (action_level.get(gr.counter) != Integer.MAX_VALUE) {
                for (Conditions c : all_conditions) {
                    if (gr.getPreconditions().sons.contains(c)) {
                        continue;
                    }
                    int originalLevel = condition_level.get(c.getCounter());
                    if (c instanceof Predicate) {
                        Predicate p = (Predicate) c;
                        if (gr.achieve(p)) {
                            dplus.put(c.getCounter(), Math.min(1, dplus.get(c.getCounter())));
                            int newLevel = Math.min(action_level.get(gr.counter) +1, condition_level.get(p.getCounter()));
                            if (newLevel != originalLevel) {
                                //needActivation = true;
                                condition_level.put(p.getCounter(), newLevel);
                                if (originalLevel == Integer.MAX_VALUE) {
                                    needActivation = true;
                                }
                            }

                            update_landmark(c, gr);
                            update_poss_achiever(c, new repetition_landmark(gr, 1));
                            //ach_of_conditions.put(c.getCounter(), gr);
                            //ach_of_conditions_with_repetition.put(c.getCounter(), new UniformCostSearch_LM.repetition_landmark(gr, 1));
                        }
                        continue;
                    }
                    if (c instanceof Comparison) {
                        Comparison cmp = (Comparison) c;
                        Float repetition_needed = gr.getNumberOfExecution(s, cmp);
                        if (repetition_needed != Float.MAX_VALUE) {
                            dplus.put(c.getCounter(), Math.min(repetition_needed.intValue(), dplus.get(c.getCounter())));
                            int newLevel = Math.min(action_level.get(gr.counter) +1, condition_level.get(cmp.getCounter()));
                            if (newLevel != originalLevel) {
                                //needActivation = true;
                                condition_level.put(cmp.getCounter(), newLevel);
                                if (originalLevel == Integer.MAX_VALUE) {
                                    needActivation = true;
                                }
                            }
                            update_landmark(c, gr);
                            update_poss_achiever(c, new repetition_landmark(gr, (float) Math.ceil(repetition_needed)));
                            //ach_of_conditions.put(c.getCounter(), gr);
                            //ach_of_conditions_with_repetition.put(c.getCounter(), new UniformCostSearch_LM.repetition_landmark(gr, (float) Math.ceil(repetition_needed)));
                        }
                    }

                }
                if (needActivation) {
                    for (GroundAction g : A) {
                        if (action_level.get(g.counter) != Integer.MAX_VALUE) {
                            //already reachable, skip;
                            continue;
                        }
                        //not reachable yet
                        boolean reachable = true;
                        int max = Integer.MIN_VALUE;
                        if (g.getPreconditions() != null && !g.getPreconditions().sons.isEmpty()) {
                            Set<Conditions> candidate = new LinkedHashSet();
                            for (Conditions c : (Collection<Conditions>)g.getPreconditions().sons) {
                                if (condition_level.get(c.getCounter()) == Integer.MAX_VALUE) {
                                    //still not reachable
                                    reachable = false;
                                    break;
                                } else {
                                    max = Math.max(max, condition_level.get(c.getCounter()));
                                    candidate.addAll(landmark_of.get(c.getCounter()));
                                }
                            }
                            if (reachable) {
                                action_level.put(g.counter, max);
                                landmark_of_action.put(g.counter, candidate);
                                reachable_at_this_stage.add(g);
                                try {
                                    pq.decreaseKey(actionAsFibNode.get(g.counter), max);
                                } catch (Exception e) {
                                    Logger.getLogger(UniformCostSearch_LM.class.getName()).log(Level.SEVERE, null, e);
                                }
                            }
                        }
                    }
                }
            } else {
                return Float.MAX_VALUE;
            }
        }

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
                    if (!c.isSatisfied(s)) {
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

    private void init_data_structure (State s) {
        landmark_of = new HashMap();
        landmark_of_action = new HashMap();
        condition_level = new HashMap();
        action_level = new HashMap();
        dplus = new HashMap();
        pq = new FibonacciHeap();
        ach_of_conditions = new HashMap<>();
        ach_of_conditions_with_repetition = new HashMap<>();
        possible_achievers = new HashMap<>();
        actionAsFibNode = new HashMap<>();
        reachable_at_this_stage = new LinkedHashSet<>();



        all_conditions.forEach((c) -> {
            Set<Conditions> lms = new LinkedHashSet();
            lms.add(c);//add itself
            landmark_of.put(c.getCounter(), lms);
            possible_achievers.put(c.getCounter(), new HashSet<>());
        });
        all_conditions.forEach((c) -> {
            if (c.isSatisfied(s)) {
                condition_level.put(c.getCounter(), 0);
                dplus.put(c.getCounter(), 0);

            } else {
                condition_level.put(c.getCounter(), Integer.MAX_VALUE);
                dplus.put(c.getCounter(), Integer.MAX_VALUE);
            }
        });
        reachable.forEach((GroundAction gr) -> {
            if (gr.isApplicable(s)) {
                action_level.put(gr.counter, 0);
                FibonacciHeapNode<GroundAction> n = new FibonacciHeapNode<>(gr);
                pq.insert(n, 0);
                actionAsFibNode.put(gr.counter, n);
                reachable_at_this_stage.add(gr);
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
                FibonacciHeapNode<GroundAction> n = new FibonacciHeapNode<>(gr);
                pq.insert(n, Integer.MAX_VALUE);
                actionAsFibNode.put(gr.counter, n);
            }
        });


    }

    private void update_landmark(Conditions c, GroundAction achiever) {
        Set<Conditions> intersection = landmark_of.get(c.getCounter());
        //intersection.remove(c);
        //Set<Conditions> intersection = null;
        if (intersection.size()-1 == 0) {
            intersection.addAll(landmark_of_action.get(achiever.counter));
        } else {
            intersection.retainAll(landmark_of_action.get(achiever.counter));
        }
        //intersection.retainAll(landmark_of_action.get(achiever.counter));
        intersection.add(c);
        this.landmark_of.put(c.getCounter(), intersection);
    }

    private void update_poss_achiever(Conditions c, repetition_landmark rl) {
        possible_achievers.get(c.getCounter()).add(rl);
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
            if (b instanceof landmarks_factory.repetition_landmark) {
                landmarks_factory.repetition_landmark b_rep = (landmarks_factory.repetition_landmark) b;
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

}

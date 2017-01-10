package heuristics.advanced;

import conditions.Comparison;
import conditions.Conditions;
import conditions.Predicate;
import expressions.ExtendedNormExpression;
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
import java.util.concurrent.locks.Condition;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by Da An on 10/12/16.
 */

public class UniformCostSearch_LM extends Heuristic {

    public HashMap<Integer, Set<repetition_landmark>> possible_achievers;
    protected LinkedHashSet<GroundAction> reachable_at_this_stage;
    protected HashMap<Integer, IloNumVar> action_to_variable;
    protected Set<Conditions> goalLandmark;
    public boolean compute_lp;
    protected Set<Conditions> conditionsToConsider;
    protected HashMap<Integer, Set<Conditions>> conditionLandmark;
    protected HashMap<Integer, Set<Conditions>> actionLandmark;
    protected Set<GroundAction> actionNotApplicableYet;
    protected HashMap<Integer, Boolean> conditionLandmarkFound;

    //Anti-Cycle System
    protected Set<Conditions> visitedCondition;

    //New Queue Approach
    protected Queue<GroundAction> reachableActions;
    protected HashMap<Integer, Boolean> conditionReachable;

    public UniformCostSearch_LM(Conditions G, Set<GroundAction> A) {
        super(G, A);
        this.build_integer_representation();
    }


    @Override
    public Float setup(State s) {
        reachable.addAll(A);
        Float ret = compute_estimate(s);
        reachable.addAll(reachable_at_this_stage);
        return ret;
    }



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


    protected void findGoalLandmark(Conditions goal, State s) {
        for (Conditions c: (Collection<Conditions>) goal.sons) {
            goalLandmark.addAll(findConditionLandmark(c));
        }
    }

    protected Set<Conditions> findConditionLandmark(Conditions c) {
        if (conditionLandmarkFound.get(c.getCounter())) {
            //Already find the landmark for this condition, no need to do it again
            return conditionLandmark.get(c.getCounter());
        }

        //Start: Anti-Cycle System
        if (visitedCondition.contains(c)) {
            //this condition has been visited but not has landmarks found, then it must be a cycle
            conditionLandmark.get(c.getCounter()).add(c);
            conditionLandmarkFound.put(c.getCounter(), true);
            return conditionLandmark.get(c.getCounter());
        }
        visitedCondition.add(c); // this condition is now visited;
        //End: Anti-Cycle System

        Set<repetition_landmark> possibleAchievers = possible_achievers.get(c.getCounter());

        for (repetition_landmark rl: possibleAchievers) {
            GroundAction achiever = rl.gr;
            Set<Conditions> landmarks = findActionLandmark(achiever);
            conditionLandmark.get(c.getCounter()).retainAll(landmarks); //Keylar's Method
        }
        conditionLandmark.get(c.getCounter()).add(c);// Add itself
        conditionLandmarkFound.put(c.getCounter(), true); // Prevent doing redundant computation
        return conditionLandmark.get(c.getCounter());
    }

    protected Set<Conditions> findActionLandmark(GroundAction a) {
        if (actionLandmark.get(a.counter).size() != 0) {
            //Already find the landmark for this action, no need to do it again
            return actionLandmark.get(a.counter);
        }

        Set<Conditions> preconditions = a.getPreconditions().sons;
        Set<Conditions> union = new HashSet<>();

        if (preconditions.size() == 0) {
            return union;
        }

        for (Conditions precondition : preconditions) {
            Set<Conditions> landmarks = findConditionLandmark(precondition);
            if (landmarks.size() == 0) {
                continue;
            } // potential redundant
            union.addAll(landmarks);
        }
        actionLandmark.get(a.counter).addAll(union); // Add landmark for this action into the map
        return union;
    }



    protected void init_data_structure(State s) {

        possible_achievers = new HashMap<>();
        action_to_variable = new HashMap<>();
        goalLandmark = new HashSet<>();
        conditionsToConsider = new HashSet<>();
        conditionLandmark = new HashMap<>();
        actionLandmark = new HashMap<>();
        actionNotApplicableYet = new HashSet<>();
        conditionLandmarkFound = new HashMap<>();
        reachable_at_this_stage = new LinkedHashSet<>();

        //Anti-Cycle System
        visitedCondition = new HashSet<>();

        //New Approach
        reachableActions = new LinkedList<>();
        conditionReachable = new HashMap<>();



        all_conditions.forEach((c) -> {
            conditionLandmark.put(c.getCounter(), new HashSet<>());
            possible_achievers.put(c.getCounter(), new HashSet<>());
            if (c.isSatisfied(s)) {
                conditionLandmarkFound.put(c.getCounter(), true);
                conditionReachable.put(c.getCounter(), true);
            } else {
                conditionsToConsider.add(c); // Only consider condition that is not satisfied yet, ie, non-initial condition
                conditionReachable.put(c.getCounter(), false);
            }
        });

        //this is the Keyler approach to intersection, set landmark set for all condition with all non-initial conditions
        for (Conditions c : conditionsToConsider) {
            conditionLandmarkFound.put(c.getCounter(), false);
            conditionLandmark.get(c.getCounter()).addAll(conditionsToConsider);
        }


        A.forEach((GroundAction gr) -> {
            actionLandmark.put(gr.counter, new HashSet<>());
            if (gr.isApplicable(s)) {
                reachableActions.add(gr);
                reachable_at_this_stage.add(gr);
            } else {
                actionNotApplicableYet.add(gr);
            }
        });
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
    
    protected void add_redundant_constrains(LinkedHashSet set) throws Exception {
        ArrayList<Conditions> set_as_array = new ArrayList(set);

        int counter = all_conditions.size();
        ArrayList<Conditions> allConditionArray = new ArrayList<>(all_conditions);
        Set<ExtendedNormExpression> exprSet = new HashSet<>();

        for (int i=0; i<set_as_array.size(); i++) {
            for (int j=i+1; j<set_as_array.size();j++) {
                Conditions c1 = set_as_array.get(i);
                Conditions c2 = set_as_array.get(j);

                if ((c1 instanceof Comparison) && (c2 instanceof Comparison)) {
                    //if (i<j) {
                    Comparison a1 = (Comparison)c1;
                    Comparison a2 = (Comparison)c2;
                    ExtendedNormExpression lhs_a1 = (ExtendedNormExpression) a1.getLeft();
                    ExtendedNormExpression lhs_a2 = (ExtendedNormExpression) a2.getLeft();
                    exprSet.add(lhs_a1);
                    exprSet.add(lhs_a2);
                    ExtendedNormExpression expr = lhs_a1.sum(lhs_a2);
                    if (expr.summations.size() < 2) {
                        continue;
                    }

                    if (exprSet.contains(expr)) {
                        //already in the set
                        continue;
                    } else {
                        exprSet.add(expr);
                    }
                    String new_comparator = ">=";
                    if (a1.getComparator().equals(">") && a2.getComparator().equals(">")) {
                        new_comparator = ">";
                    }
                    Comparison cnew = new Comparison(new_comparator);
                    cnew.setLeft(expr);
                    cnew.setRight(new ExtendedNormExpression(new Float(0.0)));
                    cnew.normalize();


                    if (allConditionArray.contains(cnew)) {
                        cnew.setCounter(allConditionArray.get(allConditionArray.indexOf(cnew)).getCounter());
                        set.add(cnew);
                    } else {
                        counter += 1;
                        cnew.setCounter(counter);
                        set.add(cnew);
                        all_conditions.add(cnew);
                    }
                }
            }
        }
    }

}

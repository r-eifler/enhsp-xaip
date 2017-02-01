/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heuristics.advanced;

import conditions.Comparison;
import conditions.Conditions;
import conditions.Predicate;
import ilog.concert.IloException;
import ilog.concert.IloLinearNumExpr;
import ilog.concert.IloNumVar;
import ilog.concert.IloNumVarType;
import ilog.cplex.IloCplex;
import static java.lang.Float.MAX_VALUE;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collection;
import static java.util.Collections.nCopies;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import problem.GroundAction;
import problem.State;

/**
 *
 * @author enrico
 */
public class landmarks_factory_refactored extends Uniform_cost_search_H1 {

    public HashMap<Integer, Set<Conditions>> landmark_of;
    public HashMap<Integer, Set<Conditions>> landmark_of_action;

    public HashMap<Integer, Integer> condition_level;
    public HashMap<Integer, Integer> action_level;
    public HashMap<Integer, Integer> dplus;//this is the minimum number of actions needed to achieve a given condition
    private LinkedHashSet<GroundAction> reachable_at_this_stage;

    public HashMap<Integer, Set<repetition_landmark>> possible_achievers_2;
    public boolean compute_lp;

    public landmarks_factory_refactored(Conditions goal, Set<GroundAction> A) {
        super(goal, A);
        
        this.build_integer_representation();
    }

    public void init_data_structures(State s_0) {
        landmark_of = new HashMap();
        landmark_of_action = new HashMap();
        condition_level = new HashMap();
        action_level = new HashMap();
        dplus = new HashMap();
        reachable_at_this_stage = new LinkedHashSet();

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
                this.reachable_at_this_stage.add(gr);
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
    public Float setup(State s) {
        build_integer_representation();
        identify_complex_conditions(all_conditions, A);
        try {
            generate_achievers();
        } catch (Exception ex) {
            Logger.getLogger(Uniform_cost_search_H1.class.getName()).log(Level.SEVERE, null, ex);
        }
        reacheability_setting = true;
        this.dbg_print("Reachability Analysis Started");
        Float ret = compute_estimate(s);
        this.dbg_print("Reachability Analysis Terminated");
        reacheability_setting = false;
        sat_test_within_cost = false; //don't need to recheck precondition sat for each state. It is done in the beginning for every possible condition
        out.println("Hard Conditions: " + this.complex_conditions);
        out.println("Simple Conditions: " + (this.all_conditions.size() - this.complex_conditions));
        return ret;
    }

    @Override
    public Float compute_estimate(State s_0) {
        Set<GroundAction> a_plus = new LinkedHashSet();
        HashMap<Integer,Set<Conditions>> lm = new HashMap();
        HashMap<Integer,Boolean> never_active = new HashMap();
        HashMap<Integer, IloNumVar> action_to_variable = new HashMap();

        for (GroundAction gr: this.A){
            if (gr.isApplicable(s_0)){
                a_plus.add(gr);
                never_active.put(gr.counter, false);
            }else
                never_active.put(gr.counter, true);
        }
        ArrayList<Float> dist = new ArrayList<>(nCopies(all_conditions.size() + 1, MAX_VALUE));
        for (Conditions c: all_conditions){
            if (c.isSatisfied(s_0))
                dist.set(c.getCounter(), 0f);
            lm.put(c.getCounter(), null);
            possible_achievers_2.put(c.getCounter(), new LinkedHashSet());
        }
        
        Iterator<GroundAction> it = a_plus.iterator();
        while (it.hasNext()){
            GroundAction gr = it.next();
            update_actions_conditions(s_0,gr,a_plus,never_active,lm);
            it.remove();
        }

        
        Set<Conditions> goal_landmark = new LinkedHashSet();
        for (Conditions c : (Collection<Conditions>) this.G.sons) {
            if (dist.get(c.getCounter()) == Float.MAX_VALUE) {
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

                    
                        for (repetition_landmark dlm : this.possible_achievers_2.get(c.getCounter())) {
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
                    }else{
                        estimate = Float.MAX_VALUE;
                    }                
                }else{
                    estimate = Float.MAX_VALUE;

                }
                lp.end();

            } catch (IloException ex) {
                Logger.getLogger(landmarks_factory_refactored.class.getName()).log(Level.SEVERE, null, ex);
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



    private boolean update_lm(Conditions p, GroundAction gr, HashMap<Integer, Set<Conditions>> lm) {

        Set<Conditions> previous = lm.get(p.getCounter());
        
        if (previous == null){
            previous = new LinkedHashSet();
            previous.addAll((Set<Conditions>)gr.getPreconditions().sons);
            return true;
        }else{
            int previous_size = previous.size();
            previous.retainAll((Set<Conditions>)gr.getPreconditions().sons);
            if (previous_size != previous.size())
                return true;
        }
        return false;
            
    }

    private void update_actions_conditions(State s_0, GroundAction gr, Set<GroundAction> a_plus, HashMap<Integer, Boolean> never_active, HashMap<Integer, Set<Conditions>> lm) {
        for (Conditions comp: this.achieve.get(gr.counter)){
            boolean changed;
            if (dist.get(comp.getCounter())!= 0f){
                changed = update_lm(comp,gr,lm);
                Set<GroundAction> set = this.achievers_inverted.get(comp.getCounter());
                for (GroundAction gr2: set){
                    if (never_active.get(gr2.counter) || changed){
                        a_plus.add(gr2);
                        never_active.put(gr2.counter,false);
                    }
                }
                Set<repetition_landmark> set2 = possible_achievers_2.get(comp.getCounter());
                repetition_landmark dlm = new repetition_landmark(gr, 1);
                set2.add(dlm);
                possible_achievers_2.put(comp.getCounter(),set2);
            }
        }
        for (Conditions comp: this.possible_achievers.get(gr.counter)){
            Float rep_needed = gr.getNumberOfExecution(s_0, (Comparison) comp);
            if (gr.getNumberOfExecution(s_0, (Comparison) comp) != Float.MAX_VALUE){
                boolean changed;
                if (dist.get(comp.getCounter())!= 0f){
                    changed = update_lm(comp,gr,lm);
                    Set<GroundAction> set = this.achievers_inverted.get(comp.getCounter());
                    for (GroundAction gr2: set){
                        if (never_active.get(gr2.counter) || changed){
                            a_plus.add(gr2);
                            never_active.put(gr2.counter,false);
                        }
                    }
                Set<repetition_landmark> set2 = possible_achievers_2.get(comp.getCounter());
                repetition_landmark dlm = new repetition_landmark(gr, rep_needed.intValue());
                set2.add(dlm);
                possible_achievers_2.put(comp.getCounter(),set2);
                }
            }
        }
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
}

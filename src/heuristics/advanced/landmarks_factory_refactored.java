/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heuristics.advanced;

import conditions.Comparison;
import conditions.Conditions;
import conditions.Predicate;
import expressions.PDDLNumber;
import ilog.concert.IloException;
import ilog.concert.IloLinearNumExpr;
import ilog.concert.IloNumVar;
import ilog.concert.IloNumVarType;
import ilog.cplex.IloCplex;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collection;
import static java.util.Collections.nCopies;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import problem.GroundAction;
import problem.GroundProcess;
import problem.State;

/**
 *
 * @author enrico
 */
public class landmarks_factory_refactored extends Uniform_cost_search_H1 {

    public ArrayList<Integer> dplus;//this is the minimum number of actions needed to achieve a given condition

    private ArrayList<Set<GroundAction>> condition_to_action;

    public ArrayList<Set<repetition_landmark>> reachable_poss_achievers;
    public boolean compute_lp;
    private ArrayList<Float> dist_float;
    public boolean red_constraints = false;
    public boolean smart_intersection = false;
    private ArrayList<Float> target_value;
    public boolean mip;

    public landmarks_factory_refactored(Conditions goal, Set<GroundAction> A,Set<GroundProcess> P) {
        super(goal, A, P);

    }

    @Override
    public Float setup(State s) {
        if (red_constraints) {
            try {
                this.add_redundant_constraints();
            } catch (Exception ex) {
                Logger.getLogger(Uniform_cost_search_H1_RC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        build_integer_representation();
        identify_complex_conditions(all_conditions, A);
        this.generate_link_precondition_action();
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

        //redo construction of integer to avoid spurious actions
        build_integer_representation();
        identify_complex_conditions(all_conditions, A);
        this.generate_link_precondition_action();
        try {
            generate_achievers();
        } catch (Exception ex) {
            Logger.getLogger(Uniform_cost_search_H1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    @Override
    public Float compute_estimate(State s_0) {
        if (s_0.satisfy(G))
            return 0f;
        LinkedList<GroundAction> a_plus = new LinkedList();//actions executable. Progressively updated
        ArrayList<Set<Conditions>> lm = new ArrayList<>(nCopies(all_conditions.size() + 1, null));//mapping between condition and landmarks
        ArrayList<Boolean> never_active = new ArrayList<>(nCopies(A.size() + 1, true));//mapping between action and boolean. True if action has not been activated yet
        HashMap<GroundAction, IloNumVar> action_to_variable = new HashMap();//mapping between action representation and integer variable in cplex
        reachable_poss_achievers = new ArrayList<>(nCopies(all_conditions.size() + 1, null));
        for (GroundAction gr : this.A) {//see which actions are executable at the current state
            if (gr.isApplicable(s_0)) {
                a_plus.add(gr);//add such an action
                never_active.set(gr.counter, false);
                if (this.reacheability_setting) {
                    this.reachable.add(gr);
                }
            }
        }
        dist_float = new ArrayList<>(nCopies(all_conditions.size() + 1, Float.MAX_VALUE));//keep track of conditions that have been reachead yet
        target_value = new ArrayList<>(nCopies(all_conditions.size() + 1, 0f));//keep track of conditions that have been reachead yet

        for (Conditions c : all_conditions) {//update with a value of 0 to say that condition is sat in init state
            if (c.isSatisfied(s_0)) {
                dist_float.set(c.getCounter(), 0f);
                this.dbg_print("Condition that is already satisfied:"+c+"\n");
                this.dbg_print("Counter is:"+c.getCounter()+"\n");

            }else{
                if (c instanceof Predicate){
                    target_value.set(c.getCounter(), 1f);
                }else{
                    Comparison comp = (Comparison)c;
                    if (debug>0)
                        if (comp.getComparator().equals("<")||comp.getComparator().equals("<=") ||comp.getComparator().equals("=")){
                            System.out.println("Expressions not normalized!!!");
                            System.exit(-1);
                        }
                    PDDLNumber number = comp.getLeft().eval(s_0);
                    if (number == null){
                        target_value.set(c.getCounter(), null);
                    }else{
                        Float t = comp.getLeft().eval(s_0).getNumber();
                        target_value.set(c.getCounter(), -1*t);
                        if (debug>0){
                            System.out.println("Condition:"+c);
                            System.out.println("Target Value:"+t);
                            System.out.println("Neg Target Value:"+(-t));
                        }
                    }

                }
                
            }
            lm.set(c.getCounter(), null);//this condition has no landmark yet. This structure is updated on the way
            reachable_poss_achievers.set(c.getCounter(), new LinkedHashSet());//this is a mapping between condition and its possible (reachable) achievers
        }

        while (!a_plus.isEmpty()) {//keep going till no action is in the list. Look that here actions can be re-added
            GroundAction gr = a_plus.poll();
            update_actions_conditions(s_0, gr, a_plus, never_active, lm);//this procedure updates
            //all the conditions that can be reached by using action gr. 
            //This also changes the set a_plus whenever some new action becomes active becasue of gr
        }

        if (this.reacheability_setting) {
            A = reachable;
        }
        
        int not_trivial_landmarks = 0;
        Set<Conditions> goal_landmark = new LinkedHashSet();
        for (Conditions c : (Collection<Conditions>) this.G.sons) {
            Float distance = dist_float.get(c.getCounter());
            if (distance == Float.MAX_VALUE) {
                Boolean outcome = this.is_complex.get(c);
                if (outcome == null)
                    continue;
                if (outcome == false){
                    return Float.MAX_VALUE;
                }
            }else{
                if (distance != 0f) {
                    this.dbg_print("Landmark found!"+c+"\n");

                    goal_landmark.addAll(lm.get(c.getCounter()));
                    not_trivial_landmarks+=lm.get(c.getCounter()).size();
                    //this.dbg_print("Counter is:"+c.getCounter()+"\n");
                    goal_landmark.add(c);//this has not been added before. Should be a slight optimisation for the intersection problem
                    this.dbg_print(print_ordering(lm,c));
                }
            }
        }
        if (this.reacheability_setting) {
            System.out.println("Landmarks:" + goal_landmark.size());

            System.out.println("Not Trivial Landmarks:" + not_trivial_landmarks);

        }


        float estimate = 0;
        if (compute_lp) {
            try {
                IloCplex lp = new IloCplex();
                if (debug==0)
                   lp.setOut(null);

                IloLinearNumExpr objective = lp.linearNumExpr();
                for (Conditions c : goal_landmark) {
                    if (dist_float.get(c.getCounter())!=0) {
                        if (debug>0)
                            System.out.println("Condition under analysis: "+c);
                        IloLinearNumExpr expr = lp.linearNumExpr();

                        for (repetition_landmark dlm : this.reachable_poss_achievers.get(c.getCounter())) {
                            IloNumVar action;
                            dlm.gr.setAction_cost(s_0);
                            Float action_cost = dlm.gr.getAction_cost();
                            if (action_cost.isNaN()) {
                                continue;
                            }
                            if (action_to_variable.get(dlm.gr) != null) {
                                action = action_to_variable.get(dlm.gr);
                            } else {
                                if (mip){
                                    action = (IloNumVar) lp.numVar(0.0, Integer.MAX_VALUE, IloNumVarType.Int);
                                }else
                                    action = (IloNumVar) lp.numVar(0.0, Float.MAX_VALUE, IloNumVarType.Float);
                                action_to_variable.put(dlm.gr, action);
                                objective.addTerm(action, action_cost);
                            }
                            expr.addTerm(action, dlm.contribution);
                            if (debug>0){
                                System.out.println("Action Considered: "+dlm.toString());
                                System.out.println("Expression generated: "+expr.toString());
                            }
                        }
                        if (debug>0)
                            System.out.println("Target Value:"+this.target_value.get(c.getCounter()));
                        
                        lp.addGe(expr, this.target_value.get(c.getCounter()));
                    }
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
                Logger.getLogger(landmarks_factory_refactored.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            for (Conditions c : goal_landmark) {//these are the landmarks for the planning task
//                System.out.println("Debug: Poss_achiever(" + c + ":)" + this.possible_achievers.get(c.getCounter()));

                estimate += dplus.get(c.getCounter());
            }

        }
        if (debug>10 && (estimate==0.0f)){
            System.out.println("Discrepancy between value heuristic and satisfability condition:"+estimate);
            System.out.println("state:"+s_0);
            System.out.println("goal:"+G);
            System.out.println("IS satisfied?"+s_0.satisfy(G));
            System.exit(-1);
        }
        return estimate;
    }

    private boolean update_lm(Conditions p, GroundAction gr, ArrayList<Set<Conditions>> lm) {

        Set<Conditions> previous = lm.get(p.getCounter());

        if (previous == null) {
            if (debug >10){
                System.out.println("First LM for:"+p);
            }
            previous = new LinkedHashSet();
            for (Conditions c : (Set<Conditions>) gr.getPreconditions().sons) {
                if (this.dist_float.get(c.getCounter()) != 0f) {
                    previous.addAll(lm.get(c.getCounter()));
                    previous.add(c);
                }
            }
            //previous.add(p);//adding itself This is now done at the end, so as to minimise number of intersection operation
            lm.set(p.getCounter(), previous);
            return true;
        } else {
            if (debug >10){
                System.out.println("Revise LM for:"+p);
            }
//            if (p.toString().contains("poured")){
//                System.out.println("Condition:"+p);
//            }

            int previous_size = previous.size();
            Set<Conditions> temp = new LinkedHashSet();
            for (Conditions c : (Set<Conditions>) gr.getPreconditions().sons) {
                if (this.dist_float.get(c.getCounter()) != 0f) {
                    temp.addAll(lm.get(c.getCounter()));
                    temp.add(c);//the lm as implemented in this code does not contain itself
                }
            }
            if (smart_intersection){

                previous = metric_sensitive_intersection(previous,temp);
//                previous.retainAll(temp);

            }
            else{
                if (debug >10){
                    System.out.println("Previous"+previous);
                }
                previous.retainAll(temp);
                if (debug >10){
                    System.out.println("after"+previous);
                }            
            }
            
            //previous.add(p);//adding itself again (the intersection may have removed this...see above for reasons
            lm.set(p.getCounter(), previous);
            if (previous_size != previous.size()) {
                return true;
            }
        }
        return false;

    }

    private void update_actions_conditions(State s_0, GroundAction gr, LinkedList<GroundAction> a_plus, ArrayList<Boolean> never_active, ArrayList<Set<Conditions>> lm) {
        for (Conditions comp : this.achieve.get(gr.counter)) {//This is the set of all predicates reachable because of gr
            Float rep_needed = 1f;
            if (dist_float.get(comp.getCounter()) != 0f) {//if this isn't in the init state yet
                dist_float.set(comp.getCounter(), rep_needed);//update distance. Meant only to keep track of whether condition reachead or not, and "how"
                update_action_condition(gr, comp, lm, rep_needed, never_active, a_plus);
                //for this specific condition check implications of having it reached.
            }
        }
        for (Conditions comp : this.possible_achievers.get(gr.counter)) {
            if (dist_float.get(comp.getCounter()) != 0f){
                Float contribution = gr.getContribution(s_0, (Comparison) comp);
                if (contribution != Float.MAX_VALUE) {
                    dist_float.set(comp.getCounter(), contribution);
                    update_action_condition(gr, comp, lm, contribution, never_active, a_plus);
                }
            }
        }
    }

    private void update_action_condition(GroundAction gr, Conditions comp, ArrayList<Set<Conditions>> lm, Float contribution, ArrayList<Boolean> never_active, LinkedList<GroundAction> a_plus) {
        boolean changed = update_lm(comp, gr, lm);//update set of landmarks for this condition.
        //this procedure shrink landmarks for condition comp using action gr
//        System.out.println(changed);
        Set<GroundAction> set = condition_to_action.get(comp.getCounter());
        //this mapping contains action that need to be triggered becasue of condition comp
        for (GroundAction gr2 : set) {
            if (gr2.counter == gr.counter) {//avoids self-loop. Thanks god I have integer mapping here.
                continue;
            }

//            System.out.println(never_active);
//            if (!A.contains(gr2))
//                continue;
            if (never_active.get(gr2.counter)) {//if this action has never been used before..
                if (check_conditions(gr2)) {//are conditions all reached?
                    a_plus.push(gr2);//push in the set of actions to consider. 
                    //Need to understand whether is worth to do check on the list to see if action already is there.
                    never_active.set(gr2.counter, false);//now is not never active anymore (just pushed in the a_plus)_
                    if (this.reacheability_setting) {
                        this.reachable.add(gr2);
                    }
                }
            } else if (changed) {//if the lm of the condition has changed,
                //we need to reconsider all the possible paths using this condition. Meaning all the possible actions
//                if (!a_plus.contains(gr2)) {
                a_plus.push(gr2);//see above for the eventual checking
//                }
            }
        }
        //update set of possible achiever for the condition with new action.
        Set<repetition_landmark> set2 = reachable_poss_achievers.get(comp.getCounter());
        repetition_landmark dlm = new repetition_landmark(gr, contribution);
        set2.add(dlm);
        reachable_poss_achievers.set(comp.getCounter(), set2);
    }

    private boolean check_conditions(GroundAction gr2) {

        for (Conditions c : (Collection<Conditions>) gr2.getPreconditions().sons) {
            if (dist_float.get(c.getCounter()) == Float.MAX_VALUE) {
                return false;
            }
        }
        return true;
    }

    private void generate_link_precondition_action() {
        condition_to_action = new ArrayList<>(nCopies(all_conditions.size() + 1, null));
        for (Conditions c : all_conditions) {
            LinkedHashSet<GroundAction> set = new LinkedHashSet();
            for (GroundAction gr : A) {
                if (gr.getPreconditions().sons.contains(c)) {
                    set.add(gr);
                }
            }
            condition_to_action.set(c.getCounter(), set);

        }
    }
    //TO-DO do the sensitive intersection to the metric
    private Set<Conditions> metric_sensitive_intersection(Set<Conditions> previous, Set<Conditions> temp) {
        Set<Conditions> newset = new LinkedHashSet();
        if (debug>0){
            System.out.println("Previous:"+previous);
            System.out.println("Intersecting with:"+temp);
        }
        for (Conditions c: temp){
            if (c instanceof Predicate){
                if (previous.contains(c))
                    newset.add(c);
            }else if (c instanceof Comparison){
                for (Conditions c1: previous){
                    if (c1 instanceof Comparison){
                        Comparison comp_c = (Comparison)c;
                        Comparison comp_c1 = (Comparison)c1;
                        if (comp_c.dominate(comp_c1)){
                            newset.add(comp_c1);
                        }else if (comp_c1.dominate(comp_c))
                            newset.add(comp_c);
                    }
                    
                }
            }
        }
        if (debug>0){
            System.out.println("after:"+newset);
        }
        return newset;
    }

    private String print_ordering(ArrayList<Set<Conditions>> lm, Conditions c) {
        
        if (lm.get(c.getCounter())== null||lm.get(c.getCounter()).isEmpty()){
            return "("+c.toString()+","+c.getCounter()+")";
        }else{
            String temp = "";
            for (Conditions c1: lm.get(c.getCounter())){
                temp += "("+c.toString()+","+c.getCounter()+")"+"<-"+print_ordering(lm,c1)+"\n";
            }
            return temp;
        }
                
    }

    public class repetition_landmark extends Object {

        public GroundAction gr;
        public float contribution;

        public repetition_landmark(GroundAction gr_input, float repetition_input) {
            super();
            this.gr = gr_input;
            this.contribution = repetition_input;
        }

        @Override
        public String toString() {
            return "(" + gr.toEcoString() + " " + contribution + ")";
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
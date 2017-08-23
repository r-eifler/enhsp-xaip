/**
 * *******************************************************************
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 *
 ********************************************************************
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heuristics.advanced;

import heuristics.old.Uniform_cost_search_H1;
import heuristics.old.Uniform_cost_search_H1_RC;
import conditions.Comparison;
import conditions.Conditions;
import conditions.NotCond;
import conditions.Predicate;
import expressions.PDDLNumber;
import extraUtils.Utils;
import heuristics.Aibr;
import ilog.concert.IloException;
import ilog.concert.IloLinearNumExpr;
import ilog.concert.IloLinearNumExprIterator;
import ilog.concert.IloNumVar;
import ilog.concert.IloNumVarType;
import ilog.concert.IloRange;
import ilog.cplex.IloCplex;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collection;
import static java.util.Collections.nCopies;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import problem.GroundAction;
import problem.GroundEvent;
import problem.GroundProcess;
import problem.State;

/**
 *
 * @author enrico
 */
public class hlm_refactored extends h1 {

    public ArrayList<Integer> dplus;//this is the minimum number of actions needed to achieve a given condition

    private ArrayList<Set<GroundAction>> condition_to_action;

//    public ArrayList<Set<repetition_landmark>> reachable_poss_achievers;
    public boolean lp_cost_partinioning;
    private ArrayList<Float> cond_dist;
    public boolean red_constraints = false;
    public boolean smart_intersection = false;
    public boolean mip;
//    private IloCplex lp;
    private IloCplex lp_global;
    private IloLinearNumExpr objective_function;
    private ArrayList<IloNumVar> action_to_variable;
    private ArrayList<IloRange> condition_to_cplex_constraint;
    private ArrayList<Set<GroundAction>> reach_achievers;
    private HashMap<Integer, Boolean> has_state_dependent_achievers;
    private boolean needs_checking_state_dependent_constraints;
    public boolean debug_landmarks_counting = false;

    public hlm_refactored(Conditions goal, Set<GroundAction> A, Set<GroundProcess> P) {
        super(goal, A, P);

    }

    public hlm_refactored(Conditions goal, Set<GroundAction> A, Set<GroundProcess> P, Set<GroundEvent> E) {
        super(goal, A, P, E);

    }

    @Override
    public Float setup(State s) {
        Aibr first_reachH = new Aibr(this.G, this.A);
        first_reachH.setup(s);
        first_reachH.set(true, true);
        Float ret2 = first_reachH.compute_estimate(s);
        if (ret2 == Float.MAX_VALUE) {
            return ret2;
        }
        A = first_reachH.reachable;
        needs_checking_state_dependent_constraints = false;
        this.simplify_actions(s);
        if (red_constraints) {
            try {
                this.add_redundant_constraints();
            } catch (Exception ex) {
                Logger.getLogger(Uniform_cost_search_H1_RC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        boolean reconstruct = false;
        do {
            build_integer_representation();
            identify_complex_conditions(A);
            this.generate_link_precondition_action();
            try {
                reconstruct = generate_achievers();
            } catch (Exception ex) {
                Logger.getLogger(Uniform_cost_search_H1.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (reconstruct);

        if (smart_intersection) {
            smart_intersection = check_if_smark_intersection_needed();
        }
        System.out.println("Smart Metric Intersection: " + smart_intersection);
        init_lp(s);
        reacheability_setting = true;
        Utils.dbg_print(debug, "Reachability Analysis Started");
        Float ret = compute_estimate(s);
        Utils.dbg_print(debug, "Reachability Analysis Terminated");
        reacheability_setting = false;
        sat_test_within_cost = false; //don't need to recheck precondition sat for each state. It is done in the beginning for every possible condition
        out.println("Hard Conditions: " + this.complex_conditions);
        out.println("Simple Conditions: " + (this.all_conditions.size() - this.complex_conditions));

//        redo construction of integer to avoid spurious actions
//        build_integer_representation();
//        identify_complex_conditions( A);
//        this.generate_link_precondition_action();
//        try {
//            generate_achievers();
//        } catch (Exception ex) {
//            Logger.getLogger(Uniform_cost_search_H1.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return ret;
    }

    @Override
    public Float compute_estimate(State s_0) {
        if (s_0.satisfy(G)) {
            return 0f;
        }
        Stack<GroundAction> a_plus = new Stack();//actions executable. Progressively updated
        ArrayList<Set<Conditions>> lm = new ArrayList<>(nCopies(all_conditions.size() + 1, null));//mapping between condition and landmarks
        ArrayList<Boolean> never_active = new ArrayList<>(nCopies(total_number_of_actions + 1, true));//mapping between action and boolean. True if action has not been activated yet
        // HashMap<GroundAction, IloNumVar> action_to_variable = new HashMap();//mapping between action representation and integer variable in cplex
        reach_achievers = new ArrayList<>(nCopies(all_conditions.size() + 1, null));

        cond_dist = new ArrayList<>(nCopies(all_conditions.size() + 1, Float.MAX_VALUE));//keep track of conditions that have been reachead yet
        ArrayList<Float> target_value = new ArrayList<>(nCopies(all_conditions.size() + 1, 0f));//keep track of conditions that have been reachead yet
        try {
            for (Conditions c : all_conditions) {//update with a value of 0 to say that condition is sat in init state
                IloRange ilo = condition_to_cplex_constraint.get(c.getCounter());
                //Initially, all the conditions are assumed achieved. I am going to change only the ones that really need to be satisfied
                if (ilo != null) {
                    ilo.setLB(0f);
                }
                //System.out.println(c);
                if (c.isSatisfied(s_0)) {
                    cond_dist.set(c.getCounter(), 0f);
                } else if (c instanceof Predicate) {
                    target_value.set(c.getCounter(), 1f);
                } else if (c instanceof NotCond) {
                    target_value.set(c.getCounter(), 1f);
                } else {
                    Comparison comp = (Comparison) c;
                    PDDLNumber number = comp.getLeft().eval(s_0);
                    if (number == null) {
                    } else {
                        Float t = comp.getLeft().eval(s_0).getNumber();
                        target_value.set(c.getCounter(), -t);
                    }

                }
                lm.set(c.getCounter(), null);//this condition has no landmark yet. This structure is updated on the way
                //reachable_poss_achievers.set(c.getCounter(), new LinkedHashSet());//this is a mapping between condition and its possible (reachable) achievers
            }
            //Iterator it = this.A.iterator();
            for (GroundAction gr : this.A) {//see which actions are executable in the current state
                IloNumVar var = this.action_to_variable.get(gr.counter);
                if (var == null) {
                    never_active.set(gr.counter, null);
                    //System.out.println("Useless Action detected");
                    continue;
                }
                var.setUB(0f); //Initially no action is useful;
                if (this.check_conditions(gr)) {
                    a_plus.add(gr);//add such an action
                    never_active.set(gr.counter, false);
                    if (this.reacheability_setting) {
                        this.reachable.add(gr);
                    }
                }
            }
            while (!a_plus.isEmpty()) {//keep going till no action is in the list. Look that here actions can be re-added
                GroundAction gr = a_plus.pop();
                if (never_active.get(gr.counter) == null) {
                    continue;
                }
                update_actions_conditions(s_0, gr, a_plus, never_active, lm);//this procedure updates
                //all the conditions that can be reached by using action gr. 
                //This also changes the set a_plus whenever some new action becomes active becasue of gr
            }

            if (this.reacheability_setting) {
                A = reachable;
            }

            int goal_not_true_in_init = 0;
            Set<Conditions> goal_landmark = new LinkedHashSet();
            for (Conditions c : (Collection<Conditions>) this.G.sons) {
                Float distance = cond_dist.get(c.getCounter());
                if (distance == Float.MAX_VALUE) {
                    return Float.MAX_VALUE;
                } else if (distance != 0f) {
                    goal_not_true_in_init++;
                    goal_landmark.addAll(lm.get(c.getCounter()));
                    goal_landmark.add(c);//this has not been added before. Should be a slight optimisation for the intersection problem
                }
            }
            if (this.reacheability_setting) {
                System.out.println("Landmarks:" + goal_landmark.size());
                System.out.println("Not Trivial Landmarks:" + (goal_landmark.size() - goal_not_true_in_init));

            }

            if (lp_cost_partinioning) {
                int lm_considered = 0;
                for (Conditions c : goal_landmark) {
                    if (cond_dist.get(c.getCounter()) != 0f) {
                        lm_considered++;
                        //                        System.out.println("DEBUG: condition:"+c);
                        IloRange ilo = condition_to_cplex_constraint.get(c.getCounter());
                        if (ilo == null) {
                            return Float.MAX_VALUE;
                        }
                        ilo.setLB(target_value.get(c.getCounter()));
                        Set<GroundAction> set = reach_achievers.get(c.getCounter());
                        boolean revise_terms = false;

                        //the following ask whether the condition depends on some action whose positiveness of the effects depend on the current state
                        //this happens for the special case of pseudo increase effects that are simulating the assignment operation
                        if (this.needs_checking_state_dependent_constraints) {
                            //                            System.out.println("DEBUG: There is need to check...");
                            if (this.has_state_dependent_achievers.get(c.getCounter())) {
                                //                                System.out.println("this one is one of them...");
                                revise_terms = true;
                            }
                        }
                        for (GroundAction gr : set) {
                            free_variable_modify_contribution_if_needed(s_0, c, revise_terms, gr);

                        }
                    }
                }
//                System.out.println("LM to Satisfy:"+lm_considered);
                if (this.debug_landmarks_counting) {
                    System.exit(-1);
                }
                if (debug == 5) {
                    System.out.println(lp_global);
                }
                if (this.lp_global.solve()) {
//                        System.out.println(lp_global);
                    return (float) this.lp_global.getObjValue();

                } else {
                    return Float.MAX_VALUE;
                }

            } else {
                float estimate = 0f;
                for (Conditions c : goal_landmark) {//these are the landmarks for the planning task
                    estimate += dplus.get(c.getCounter());
                }
                return estimate;

            }
        } catch (IloException ex) {
            Logger.getLogger(hlm_refactored.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Float.MAX_VALUE;
    }

    private boolean update_lm(Conditions p, GroundAction gr, ArrayList<Set<Conditions>> lm) {

        Set<Conditions> previous = lm.get(p.getCounter());

        if (previous == null) {
            if (debug > 10) {
                System.out.println("First LM for:" + p);
            }
            previous = new LinkedHashSet();
            for (Conditions c : (Set<Conditions>) gr.getPreconditions().sons) {
                if (this.cond_dist.get(c.getCounter()) != 0f) {
                    previous.addAll(lm.get(c.getCounter()));
                    previous.add(c);
                }
            }
            //experimental
//            previous.add(p);//adding itself This is now done at the end, so as to minimise number of intersection operation
            lm.set(p.getCounter(), previous);
            return true;
        } else {
            if (debug > 10) {
                System.out.println("Revise LM for:" + p);
            }
//            if (p.toString().contains("poured")){
//                System.out.println("Condition:"+p);
//            }

            int previous_size = previous.size();
            if (previous_size == 0) {
                return false;
            }

            if (smart_intersection) {
                Set<Conditions> temp = new LinkedHashSet();
                for (Conditions c : (Set<Conditions>) gr.getPreconditions().sons) {
                    if (this.cond_dist.get(c.getCounter()) != 0f) {
                        temp.addAll(lm.get(c.getCounter()));
                        temp.add(c);//the lm as implemented in this code does not contain itself
                    }
                }

                previous = metric_sensitive_intersection(previous, temp);
//                previous.retainAll(temp);

            } else {
                if (debug > 10) {
                    System.out.println("Previous" + previous);
                }
                Iterator<Conditions> it = previous.iterator();
                while (it.hasNext()) {
                    boolean found = false;
                    Conditions prev = (Conditions) it.next();
                    for (Conditions c : (Set<Conditions>) gr.getPreconditions().sons) {
                        if (this.cond_dist.get(c.getCounter()) != 0f) {
                            if (prev.getCounter() == c.getCounter()) {
                                found = true;
                                break;
                            }
                            for (Conditions c1 : lm.get(c.getCounter())) {
                                if (prev.getCounter() == c1.getCounter()) {
                                    found = true;
                                    break;
                                }
                            }
                            if (found) {
                                break;
                            }
                        }
                    }
                    if (!found) {
                        it.remove();
                    }
                }

                if (debug > 10) {
                    System.out.println("after" + previous);
                }
            }
            //experimental
//            previous.add(p);//adding itself again (the intersection may have removed this...see above for reasons
            lm.set(p.getCounter(), previous);
            if (previous_size != previous.size()) {
                return true;
            }
        }
        return false;

    }

    private void update_actions_conditions(State s_0, GroundAction gr, Stack<GroundAction> a_plus, ArrayList<Boolean> never_active, ArrayList<Set<Conditions>> lm) {
        for (Conditions comp : this.achieve.get(gr.counter)) {//This is the set of all predicates reachable because of gr
            // Float rep_needed = 1f;
            if (cond_dist.get(comp.getCounter()) != 0f) {//if this isn't in the init state yet
//                if (lm.get(comp.getCounter())!= null && lm.get(comp.getCounter()).isEmpty()){
////                    System.out.println("happen!");
//                    continue;
//                }
                cond_dist.set(comp.getCounter(), 1f);//update distance. Meant only to keep track of whether condition reachead or not, and "how"
                update_action_condition(gr, comp, lm, never_active, a_plus);
                //for this specific condition check implications of having it reached.
            }
        }
        for (Conditions comp : this.possible_achievers.get(gr.counter)) {
            if (cond_dist.get(comp.getCounter()) != 0f) {
//                if (lm.get(comp.getCounter())!= null && lm.get(comp.getCounter()).isEmpty()){
//                    continue;
//                }
                Float contribution = gr.getContribution(s_0, (Comparison) comp);
                if (contribution != Float.MAX_VALUE) {
                    cond_dist.set(comp.getCounter(), 1f);
                    update_action_condition(gr, comp, lm, never_active, a_plus);
                }
            }
        }
    }

    private void update_action_condition(GroundAction gr, Conditions comp, ArrayList<Set<Conditions>> lm, ArrayList<Boolean> never_active, Stack<GroundAction> a_plus) {
        boolean changed = update_lm(comp, gr, lm);//update set of landmarks for this condition.
        //this procedure shrink landmarks for condition comp using action gr
//        System.out.println(changed);
        Set<GroundAction> set = condition_to_action.get(comp.getCounter());
        //this mapping contains action that need to be triggered becasue of condition comp
        for (GroundAction gr2 : set) {
            if (gr2.counter == gr.counter) {//avoids self-loop. Thanks god I have integer mapping here.
                continue;
            }
            if (never_active.get(gr2.counter) == null)//this is for useless actions
            {
                continue;
            }

//            System.out.println(never_active);
//            if (!A.contains(gr2))
//                continue;
            if (never_active.get(gr2.counter)) {//if this action has never been used before..
                if (check_conditions(gr2)) {//are conditions all reached?
//                    if (!a_plus.contains(gr2))
                    a_plus.push(gr2);//push in the set of actions to consider. 
                    //Need to understand whether is worth to do check on the list to see if action already is there.
                    never_active.set(gr2.counter, false);//now is not never active anymore (just pushed in the a_plus)_
                    if (this.reacheability_setting) {
                        this.reachable.add(gr2);
                    }
                }
            } else if (changed) {//if the lm of the condition has changed,
                //we need to reconsider all the possible paths using this condition. Meaning all the possible actions
//                if (!a_plus.contains(gr2)) 
//                  if (!a_plus.contains(gr2))
                a_plus.push(gr2);//see above for the eventual checking
//                }
            }
        }
        Set<GroundAction> set2 = this.reach_achievers.get(comp.getCounter());
        if (set2 == null) {
            set2 = new HashSet();
        }
        set2.add(gr);
        this.reach_achievers.set(comp.getCounter(), set2);

    }

    private boolean check_conditions(GroundAction gr2) {

        for (Conditions c : (Collection<Conditions>) gr2.getPreconditions().sons) {
            if (cond_dist.get(c.getCounter()) == Float.MAX_VALUE) {
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
        if (debug > 0) {
            System.out.println("Previous:" + previous);
            System.out.println("Intersecting with:" + temp);
        }
        for (Conditions c : temp) {
            if (c instanceof Predicate) {
                if (previous.contains(c)) {
                    newset.add(c);
                }
            } else if (c instanceof Comparison) {
                for (Conditions c1 : previous) {
                    if (c1 instanceof Comparison) {
                        Comparison comp_c = (Comparison) c;
                        Comparison comp_c1 = (Comparison) c1;
                        if (comp_c.dominate(comp_c1)) {
                            newset.add(comp_c1);
                        } else if (comp_c1.dominate(comp_c)) {
                            newset.add(comp_c);
                        }
                    }

                }
            }
        }
        if (debug > 0) {
            System.out.println("after:" + newset);
        }
        return newset;
    }

    private String print_ordering(ArrayList<Set<Conditions>> lm, Conditions c) {

        if (lm.get(c.getCounter()) == null || lm.get(c.getCounter()).isEmpty()) {
            return "(" + c.toString() + "," + c.getCounter() + ")";
        } else {
            String temp = "";
            for (Conditions c1 : lm.get(c.getCounter())) {
                temp += "(" + c.toString() + "," + c.getCounter() + ")" + "<-" + print_ordering(lm, c1) + "\n";
            }
            return temp;
        }

    }

    private void init_lp(State s_0) {
        try {
            lp_global = new IloCplex();
            lp_global.setOut(null);
            objective_function = lp_global.linearNumExpr();
            action_to_variable = new ArrayList<>(nCopies(total_number_of_actions + 1, null));
            condition_to_cplex_constraint = new ArrayList<>(nCopies(all_conditions.size() + 1, null));
            has_state_dependent_achievers = new HashMap();
            for (Conditions c : all_conditions) {
                has_state_dependent_achievers.put(c.getCounter(), false);
//                System.out.println("Condition under analysis" + c);
                IloLinearNumExpr expr = lp_global.linearNumExpr();;
                Set<GroundAction> set = null;
                if (c instanceof Predicate) {
                    set = this.achievers_inverted.get(c.getCounter());
                } else if (c instanceof Comparison) {
                    set = this.possible_achievers_inverted.get(c.getCounter());
                }
                if (set != null) {
//                    System.out.println("Possible achievers...");
                    for (GroundAction gr : set) {

                        IloNumVar action;
//                        gr.set_unit_cost(s_0);
                        Float action_cost = gr.getAction_cost();
                        if (action_cost.isNaN()) {
//                            System.out.println("Action: " + gr);
                            continue;
                        }
                        if (action_to_variable.get(gr.counter) != null) {
                            action = action_to_variable.get(gr.counter);
                        } else {
                            if (mip) {
                                action = (IloNumVar) lp_global.numVar(0.0, Integer.MAX_VALUE, IloNumVarType.Int);
                            } else {
                                action = (IloNumVar) lp_global.numVar(0.0, 0.0, IloNumVarType.Float);
                            }
                            action_to_variable.set(gr.counter, action);
                            objective_function.addTerm(action, action_cost);
                        }
//                        System.out.println("Condition under evaluation:" + c);

                        //Conservative: if at least one effect is pseudo numeric effect, the
                        //constraint has to be built on the fly: if this condition becomes a lm
                        if (gr.has_pseudo_numeric_effect_on(c)) {
                            has_state_dependent_achievers.put(c.getCounter(), true);
                            needs_checking_state_dependent_constraints = true;
                        }
                        expr.addTerm(action, gr.getStaticContribution(s_0, c));
//                        System.out.println("ACtion Contribution:" + gr.getContribution(s_0, c));
                    }
                }
                float trg_value = 0f;
                if (c.isSatisfied(s_0)) {

                } else if (c instanceof Predicate) {
                    trg_value = 1f;
                } else if (c instanceof NotCond) {//assumption that only propositional predicates can be negated 
                    trg_value = 1f;
                } else {
                    Comparison comp = (Comparison) c;
                    PDDLNumber number = comp.getLeft().eval(s_0);
                    if (number == null) {
                        System.out.println("Condition that cannot be evaluated are not supported:" + c);
                        System.exit(-1);
                    } else {
                        Float t = comp.getLeft().eval(s_0).getNumber();
                        trg_value = -1 * t;
                    }

                }
                if (set != null) {
                    IloRange ilo = lp_global.addGe(expr, trg_value);
                    if (ilo == null) {
                        System.out.println("something seriously wrong");
                    }
                    //System.out.println(c + " " + " Mapped into " + ilo);
                    condition_to_cplex_constraint.set(c.getCounter(), ilo);
                }
            }
            lp_global.addMinimize(objective_function);
//            System.out.println(lp_global);
        } catch (IloException ex) {
            Logger.getLogger(hlm_refactored.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void free_variable_modify_contribution_if_needed(State s_0, Conditions c, boolean revise_terms, GroundAction gr) throws IloException {

        IloNumVar action_var = this.action_to_variable.get(gr.counter);
        action_var.setUB(Float.MAX_VALUE);//add only useful actions
        if (revise_terms) {
            IloRange ilo2 = condition_to_cplex_constraint.get(c.getCounter());
            IloLinearNumExpr expr = (IloLinearNumExpr) ilo2.getExpr();
            IloLinearNumExprIterator it = expr.linearIterator();
            while (it.hasNext()) {
                IloNumVar var = it.nextNumVar();
                if (var.equals(action_var)) {
                    it.setValue(gr.getContribution(s_0, (Comparison) c));
                }
            }
            ilo2.setExpr(expr);
        }
    }

    private boolean check_if_smark_intersection_needed() {
        for (int i = 0; i < all_conditions.toArray().length; i++) {
            for (int j = i + 1; j < all_conditions.toArray().length; j++) {
                Conditions c1 = (Conditions) all_conditions.toArray()[i];
                Conditions c2 = (Conditions) all_conditions.toArray()[j];
                if ((c1 instanceof Comparison) && (c2 instanceof Comparison)) {
                    Comparison comp_c1 = (Comparison) c1;
                    Comparison comp_c2 = (Comparison) c2;
                    if (comp_c1.getInvolvedFluents().equals(comp_c2.getInvolvedFluents())) {
//                        System.out.println(comp_c1+" "+comp_c2);
                        return true;
                    }
                }
            }

        }
        return false;
    }

}

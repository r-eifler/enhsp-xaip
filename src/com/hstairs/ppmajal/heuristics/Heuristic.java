/*
 * Copyright (C) 2010-2017 Enrico Scala. Contact: enricos83@gmail.com.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package com.hstairs.ppmajal.heuristics;

import com.hstairs.ppmajal.conditions.*;
import com.hstairs.ppmajal.expressions.ExtendedNormExpression;
import com.hstairs.ppmajal.expressions.Interval;
import com.hstairs.ppmajal.expressions.NumEffect;
import com.hstairs.ppmajal.expressions.PDDLNumber;
import com.hstairs.ppmajal.extraUtils.Pair;
import com.hstairs.ppmajal.heuristics.advanced.h1;
import com.hstairs.ppmajal.heuristics.utils.HeuristicSearchNode;
import com.hstairs.ppmajal.problem.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.Collections.nCopies;

/**
 * @author enrico
 */
public abstract class Heuristic {

    public LinkedHashSet<GroundAction> reachable;
    public boolean additive_h = true;
    public int max_depth;
    public int debug = 0;
    public LinkedHashSet<Predicate> reacheable_predicates;
    public HashMap<Condition, GroundAction> achievers;
    public HashMap<Comparison, Comparison> add_achievers;
    public LinkedHashSet<GroundAction> A;
    public ComplexCondition G;
    public boolean why_not_active = false;
    public Collection<GroundAction> helpful_actions;
    public HashMap<Integer, GroundAction> final_achiever;
    public boolean preferred_operators;
    public int reacheable_conditions;
    public int horizon = Integer.MAX_VALUE;
    private Collection<GroundAction> supporters;
    public RelState reacheable_state;
    public int n_lp_invocations;
    public boolean integer_variables;
    public boolean greedy = false;
    public ComplexCondition gC;
    public boolean integer_actions = false;
    public boolean helpful_actions_computation = false;
    public Boolean weak_helpful_actions_pruning = true;
    public boolean only_mutual_exclusion_processes = false;
    protected LinkedList<NumEffect> sorted_nodes;
    protected HashMap<GroundAction, HashSet<GroundAction>> influence_graph;
    protected Collection<Condition> all_conditions;
    protected int index_of_last_static_atom;
    protected ArrayList<Boolean> is_complex;
    protected HashMap<Condition, Boolean> new_condition;
    protected int complex_conditions;
    protected HashMap<GroundAction, HashSet<Predicate>> precondition_deleted;
    protected boolean sat_test_within_cost = true;
    protected HashMap<GroundAction, LinkedHashSet<Pair<Pair<Comparison, Comparison>, Integer>>> rep_costs;
    protected LinkedHashSet<GroundAction> temp_preferred_operators_ibr;
    protected int hard_conditions;
    protected Collection<Comparison> complex_condition_set;
    protected boolean check_mutex = false;
    protected HashMap<String, Integer> integer_ref;
    HashMap<NumEffect, GroundAction> num_eff_action;
    private boolean cost_oriented_ibr = false;
    private HashMap redundant_constraints;
    private boolean risky = false;


    public Heuristic (Set<GroundAction> A) {
        this(null, A, Collections.emptySet(), Collections.emptySet(), null);
    }

    public Heuristic (ComplexCondition G, Collection<GroundAction> A) {
        this(G, new LinkedHashSet(A), Collections.emptySet(), Collections.emptySet(), null);
    }


    public Heuristic (ComplexCondition G, Set<GroundAction> A) {
        this(G, A, Collections.emptySet(), Collections.emptySet(), null);
    }

    public Heuristic (ComplexCondition G, Set<GroundAction> A, Set<GroundProcess> P) {
        this(G, A, P, Collections.emptySet(), null);
    }

    public Heuristic (ComplexCondition G, Collection<GroundAction> A, Collection<GroundProcess> P, Collection<GroundEvent> E) {
        this(G, A, P, E, null);
    }

    public Heuristic (ComplexCondition G, Collection<GroundAction> A, Collection<GroundProcess> P, ComplexCondition GC) {
        this(G, A, P, Collections.emptySet(), GC);
    }

    public Heuristic (ComplexCondition G, Collection<GroundAction> A, Collection<GroundProcess> P, Collection<GroundEvent> E, ComplexCondition GC) {
        super();
        achievers = new HashMap();
        add_achievers = new HashMap();
        this.G = G;
        this.A = new LinkedHashSet();
        this.A.addAll(A);
        this.A.addAll(P);
        this.A.addAll(E);

        reacheable_predicates = new LinkedHashSet();
        reachable = new LinkedHashSet();
        max_depth = 10;
        all_conditions = new ArrayList();
        //build_integer_representation(A,G);
        this.gC = GC;
    }

    //this initializer is mandatory for being executed before each invocation of the heuristic
    public abstract Float setup (State s_0);

    public void build_integer_representation ( ) {
        all_conditions = new ArrayList<>();
        int counter_conditions = 0;

        integer_ref = new HashMap();
        ArrayList<GroundAction> actions_to_consider = new ArrayList(A);
        if (this.supporters != null) {
            actions_to_consider.addAll(this.supporters);
        }
        for (GroundAction a : actions_to_consider) {

            if (a.getPreconditions() != null) {
                for (Condition c_1 : a.getPreconditions().getTerminalConditions()) {
                    counter_conditions = update_index_conditions(c_1, counter_conditions);
                }
            }
        }
        for (GroundAction a : actions_to_consider) {
            if (a.getAddList() != null && a.getAddList().sons != null) {
                for (Condition c_1 : (Set<Condition>) a.getAddList().sons) {
                    counter_conditions = update_index_conditions(c_1, counter_conditions);
                }
            }
        }

        for (Condition c_1 : G.getTerminalConditions()) {
            counter_conditions = update_index_conditions(c_1, counter_conditions);
        }
        index_of_last_static_atom = counter_conditions;//index of the last atom
    }


    /**
     * @param s_0
     * @return
     */
    abstract public Float computeEstimate (State s_0);

    protected Float compute_precondition_cost (PDDLState s_0, ArrayList<Float> h, GroundAction gr, ArrayList<Boolean> closed) {
        return this.compute_cost(s_0, h, gr.getPreconditions(), closed);
    }

    protected Float compute_cost (PDDLState s_0, ArrayList<Float> h, Condition input_cond, ArrayList<Boolean> closed) {
        Float cost = 0f;

        ComplexCondition con = (ComplexCondition) input_cond;

        for (Condition t : (Collection<Condition>) con.sons) {
            if (closed != null && !closed.get(t.getHeuristicId()) && !greedy) {
                return Float.MAX_VALUE;
            }
            Float temp = h.get(t.getHeuristicId());
            if (temp != Float.MAX_VALUE) {
                if (additive_h) {
                    //System.out.println("Cost:"+);
                    cost += temp;
                    //System.out.println("Cost:"+cost);
                } else {
                    cost = Math.max(cost, temp);
                }
            } else {
                return Float.MAX_VALUE;
            }
        }
        return cost;
    }

    protected Float check_goal_conditions (PDDLState s_0, Condition G, ArrayList<Float> h, ArrayList<Boolean> closed) {
        return this.compute_cost(s_0, h, G, closed);
    }

    protected boolean update_prop_h (HeuristicSearchNode node, Map<Condition, Integer> h) {
        boolean new_condition = false;
        if (node.action.getAddList() == null) {
            return new_condition;
        }
        for (Condition eff : (Collection<Condition>) node.action.getAddList().sons) {
            if (h.get(eff) == null || h.get(eff) > (node.action_cost_to_get_here)) {
                h.put(eff, node.action_cost_to_get_here);
                this.achievers.put(eff, node.action);
                new_condition = true;
            }
        }
        return new_condition;
    }


    public boolean visit (NumEffect nf, Collection<NumEffect> col, HashMap<NumEffect, Boolean> temp_mark, HashMap<NumEffect, Boolean> per_mark, LinkedList<NumEffect> list) {

        if (temp_mark.get(nf)) {
            return true;
        }
        if (per_mark.get(nf)) {
            return false;
        }
        temp_mark.put(nf, true);
        boolean cyclic = false;
        for (NumEffect b : col) {
            if (!b.equals(nf)) {
                if (nf.getRight().involve(b.getFluentAffected())) {
                    //list.addLast(nf);
                    if (visit(b, col, temp_mark, per_mark, list)) {
                        per_mark.put(nf, true);
                        temp_mark.put(nf, false);
                        list.addLast(nf);
                        return true;//don't bother here; the task is cyclic anyway, though keep this numeric effect and try to reach the goal afterwards
                        //cyclic = true;
                    }
                }
            }
        }
        per_mark.put(nf, true);
        temp_mark.put(nf, false);
        list.addLast(nf);
        return cyclic;
    }

    private Boolean compute_enclosure (Collection<GroundAction> pool, RelState rel_state, Comparison c) {
        Boolean ret = null;
        boolean cyclic = false;

        HashSet<NumEffect> num_effects = new LinkedHashSet();
        HashMap<NumEffect, Boolean> temp_mark = new HashMap();
        HashMap<NumEffect, Boolean> per_mark = new HashMap();
        num_eff_action = new HashMap();
        for (GroundAction gr : pool) {
            for (NumEffect nf : gr.getNumericEffectsAsCollection()) {
                num_eff_action.put(nf, gr);
                temp_mark.put(nf, false);
                per_mark.put(nf, false);
                num_effects.add(nf);
            }
        }
        //Tarjan Algorithm 
//        System.out.println("start transitive_closure");

        sorted_nodes = new LinkedList();
        for (NumEffect a : num_effects) {
            if (!per_mark.get(a)) {
                if (c.getLeft().involve(a.getFluentAffected())) {
                    if (visit(a, num_effects, temp_mark, per_mark, sorted_nodes)) {
                        cyclic = true;
                    }
                }
            }
        }

        //Reacheability step following closure of numeric relations
        RelState temp = rel_state.clone();
        for (NumEffect nf : sorted_nodes) {
            //System.out.println(nf.getRhs());
            Interval res = nf.getRight().eval(temp);
            switch (nf.getOperator()) {
                case "increase":
                    if (res.can_be_negative()) {
                        temp.setFunctionInfValue(nf.getFluentAffected(), new PDDLNumber(-Float.MAX_VALUE));
                    }
                    if (res.can_be_positive()) {
                        temp.setFunctionSupValue(nf.getFluentAffected(), new PDDLNumber(Float.MAX_VALUE));
                    }
                    break;
                case "decrease":
                    if (res.can_be_negative()) {
                        temp.setFunctionSupValue(nf.getFluentAffected(), new PDDLNumber(Float.MAX_VALUE));
                    }
                    if (res.can_be_positive()) {
                        temp.setFunctionInfValue(nf.getFluentAffected(), new PDDLNumber(-Float.MAX_VALUE));
                    }
                    break;
                case "assign":
                    temp.update_values(nf.apply(temp));
                    break;
            }
        }

        if (sorted_nodes.isEmpty() && cyclic) {
            sorted_nodes = new LinkedList(num_eff_action.keySet());
        }

//        if (cyclic){
//            sorted_nodes.addAll(num_effects);
//        }
        boolean try_anyway = c.can_be_true(temp);

        if (!try_anyway && cyclic) {
            return null;
        }

//        System.out.println("transitive_closure");
        return try_anyway;

    }


    protected void identify_complex_conditions (Collection<GroundAction> A) {
        //For each condition, identify whether there is at least an action whose effects are not simple. This condition
        // will be considered complex in that checking its satisfaction is hard
        is_complex = new ArrayList<>(nCopies(all_conditions.size() + 1, false));

        new_condition = new HashMap();
        complex_condition_set = new LinkedHashSet();
        for (Condition c : all_conditions) {
//            System.out.println("This is condition number:"+c.getCounter());
            if (c instanceof Comparison) {
                Comparison comp = (Comparison) c;
                new_condition.put(comp, false);
                is_complex.set(comp.getHeuristicId(), false);
                if (!comp.isLinear()) {
                    is_complex.set(comp.getHeuristicId(), true);
                    complex_condition_set.add((Comparison) c);
                }
                for (GroundAction gr : A) {
                    if (gr.getNumericEffects() != null) {
                        AndCond effects = gr.getNumericEffects();
                        for (NumEffect ne : (Collection<NumEffect>) effects.sons) {
                            if (comp.getInvolvedFluents().contains(ne.getFluentAffected())) {

                                if ((!ne.getInvolvedNumericFluents().isEmpty() && !ne.isPseudo_num_effect()) || ne.getOperator().equals("assign")) {
                                    is_complex.set(comp.getHeuristicId(), true);
                                    complex_condition_set.add((Comparison) c);
                                    //System.out.println("Complex condition:"+comp);
                                }
                            }
                        }
                    }
                }
                if (is_complex.get(comp.getHeuristicId())) {
                    complex_conditions++;
                }
            }
        }
    }


    protected int update_index_conditions (Condition c_1, int counter) {

        if (integer_ref.get(c_1.toString()) == null) {
            integer_ref.put(c_1.toString(), counter);
            c_1.setHeuristicId(counter);
            all_conditions.add(c_1);
            counter++;
        } else {
            c_1.setHeuristicId(integer_ref.get(c_1.toString()));
        }
        return counter;

    }

    protected void add_redundant_constraints ( ) throws Exception {
        redundant_constraints = new HashMap();

        for (GroundAction a : A) {
            if (a.getPreconditions() != null) {
                compute_redundant_constraint((Set<ComplexCondition>) a.getPreconditions().sons);
            }
            //System.out.println(a.toPDDL());
        }

        compute_redundant_constraint((Set<ComplexCondition>) G.sons);
    }

    protected void compute_redundant_constraint (Set<ComplexCondition> set) throws Exception {
        LinkedHashSet temp = new LinkedHashSet();
        ArrayList<Condition> set_as_array = new ArrayList(set);
        int counter = 0;
        for (int i = 0; i < set_as_array.size(); i++) {
            for (int j = i + 1; j < set_as_array.size(); j++) {
                Condition c_1 = set_as_array.get(i);
                Condition c_2 = set_as_array.get(j);
                if ((c_1 instanceof Comparison) && (c_2 instanceof Comparison)) {
                    counter++;
                    Comparison a1 = (Comparison) c_1;
                    Comparison a2 = (Comparison) c_2;
                    ExtendedNormExpression lhs_a1 = (ExtendedNormExpression) a1.getLeft();
                    ExtendedNormExpression lhs_a2 = (ExtendedNormExpression) a2.getLeft();
                    ExtendedNormExpression expr = lhs_a1.sum(lhs_a2);
                    String new_comparator = ">=";
                    if (a1.getComparator().equals(">") && a2.getComparator().equals(">")) {
                        new_comparator = ">";
                    }
                    Comparison newC = new Comparison(new_comparator);
                    newC.setLeft(expr);
                    newC.setRight(new ExtendedNormExpression(0d));
                    newC.normalize();

                    ExtendedNormExpression tempLeft = (ExtendedNormExpression) newC.getLeft();

                    if (tempLeft.summations.size() < 2) {
                        continue;
                    }
                    redundant_constraints.put(newC, true);
                    temp.add(newC);
                }
            }
        }
//        System.out.println("New conditions now:"+counter);
//        System.out.println("Set before:"+set.size());
        set.addAll(temp);
//        System.out.println("Set after:"+set.size());
    }

    protected void simplify_actions (State init) {
        for (GroundAction gr : this.A) {
            try {
                if (gr.getNumericEffects() != null && !gr.getNumericEffects().sons.isEmpty()) {
                    int number_numericEffects = gr.getNumericEffects().sons.size();
                    for (Iterator it = gr.getNumericEffects().sons.iterator(); it.hasNext(); ) {
                        NumEffect neff = (NumEffect) it.next();
                        if (neff.getOperator().equals("assign")) {
                            ExtendedNormExpression right = (ExtendedNormExpression) neff.getRight();
                            try {

                                //The following has been disabled as it is not clear whether particular assignments can indeed be treated
                                //as pseudo increase effects which aren't state dependent.
//                                if (true) {
//
//                                } else {
//                                    if (right.isNumber() && neff.getFluentAffected().eval(init) != null && (number_numericEffects == 1 || risky)) {
//                                        //constant effect
//                                        //Utils.dbg_print(3,neff.toString());
//                                        //                            if (number_numericEffects == 1) {
//                                        System.out.println(neff);
//                                        neff.setOperator("increase");
//                                        neff.setRhs(new BinaryOp(neff.getRhs(), "-", neff.getFluentAffected(), true).normalize());
//                                        neff.setPseudo_num_effect(true);
//                                        //                            }
//                                    }
////                                }
                            } catch (Exception ex) {
                                Logger.getLogger(h1.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                gr.normalize();
            } catch (Exception ex) {
                Logger.getLogger(h1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.G.normalize();
    }

    public float gValue (State s, Object transition, State next, Float previousG) {
        GroundAction gr = (GroundAction) transition;
        if (gr == null)
            return previousG;
        return previousG + gr.getActionCost(s);
    }

}

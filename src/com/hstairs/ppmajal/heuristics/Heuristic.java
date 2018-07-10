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
import com.hstairs.ppmajal.expressions.*;
import com.hstairs.ppmajal.extraUtils.Pair;
import com.hstairs.ppmajal.extraUtils.Utils;
import com.hstairs.ppmajal.heuristics.advanced.h1;
import com.hstairs.ppmajal.heuristics.utils.HeuristicSearchNode;
import com.hstairs.ppmajal.problem.*;
import org.ojalgo.optimisation.Expression;
import org.ojalgo.optimisation.ExpressionsBasedModel;
import org.ojalgo.optimisation.Optimisation;
import org.ojalgo.optimisation.Variable;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.Collections.nCopies;

/**
 *
 * @author enrico
 */
public abstract class Heuristic {

    static public LinkedHashSet usefulActions = new LinkedHashSet();
    protected LinkedList<NumEffect> sorted_nodes;
    public LinkedHashSet<GroundAction> reachable;
    public boolean additive_h = true;
    protected HashMap<GroundAction, HashSet<GroundAction>> influence_graph;
    public int max_depth;
    public int debug = 0;
    protected boolean internal_update;
    public LinkedHashSet<Predicate> reacheable_predicates;

    protected Collection<Condition> all_conditions;
    HashMap<GroundAction, HashSet<Condition>> influenced_by;
    HashMap<GroundAction, GroundAction> depends_on;

    public HashMap<Condition, GroundAction> achievers;
    public HashMap<Comparison, Comparison> add_achievers;
    protected int index_of_last_static_atom;
    public LinkedHashSet<GroundAction> A;
    public ComplexCondition G;
    private Set<NumFluent> def_num_fluents;
    protected LinkedHashSet orderings;
    protected boolean cyclic_task;

    public boolean why_not_active = false;
    protected ArrayList<Boolean> is_complex;
    protected HashMap<Condition, Boolean> new_condition;
    protected int complex_conditions;
    protected HashMap<GroundAction, HashSet<Predicate>> precondition_deleted;
    protected boolean sat_test_within_cost = true;
    protected HashMap<GroundAction, LinkedHashSet<Pair<Pair<Comparison, Comparison>, Integer>>> rep_costs;

    public Set<GroundAction> helpful_actions;
    public HashMap<Integer, GroundAction> final_achiever;
    public boolean preferred_operators;
    protected LinkedHashSet<GroundAction> temp_preferred_operators_ibr;
    public int reacheable_conditions;
    private boolean no_plan_extraction = true;
    public int horizon = Integer.MAX_VALUE;
    protected int hard_conditions;
    HashMap<NumEffect, GroundAction> num_eff_action;
    public Collection<GroundAction> supporters;
    public RelState reacheable_state;
    protected Collection<Comparison> complex_condition_set;
    protected boolean check_mutex = false;
    public int n_lp_invocations;
    public boolean integer_variables;
    public boolean greedy = false;
    public ComplexCondition gC;
    public boolean integer_actions = false;
    private boolean cost_oriented_ibr = false;
    protected HashMap<Condition, Integer> integer_ref;
    public boolean helpful_actions_computation = false;
    protected int total_number_of_actions;
    public Boolean weak_helpful_actions_pruning = true;
    public boolean only_mutual_exclusion_processes = false;

    private HashMap redundant_constraints;
    private boolean risky = false;

    public Heuristic() {

    }

    public Heuristic(Set<GroundAction> A) {
        this.A = (LinkedHashSet<GroundAction>) A;

    }

    public Heuristic(ComplexCondition G, Set<GroundAction> A) {
        super();
        achievers = new HashMap();
        add_achievers = new HashMap();
        this.G = G;
        this.A = new LinkedHashSet();
        this.A.addAll(A);
        reacheable_predicates = new LinkedHashSet();
        reachable = new LinkedHashSet();
        max_depth = 10;
        all_conditions = new ArrayList();
        def_num_fluents = new LinkedHashSet();
        //build_integer_representation(A,G);
    }

    public Heuristic(ComplexCondition G, Set<GroundAction> A, Set<GroundProcess> P) {
        super();
        achievers = new HashMap();
        add_achievers = new HashMap();
        this.G = G;
        this.A = new LinkedHashSet();
        this.A.addAll(A);
        this.A.addAll(P);
        reacheable_predicates = new LinkedHashSet();
        reachable = new LinkedHashSet();
        max_depth = 10;
        all_conditions = new ArrayList();
        def_num_fluents = new LinkedHashSet();
        //build_integer_representation(A,G);
    }

    public Heuristic(ComplexCondition G, Set<GroundAction> A, Set<GroundProcess> P, Set<GroundEvent> E) {
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
        def_num_fluents = new LinkedHashSet();
        //build_integer_representation(A,G);
    }

    public Heuristic(ComplexCondition G, Set<GroundAction> A, Set<GroundAction> P, ComplexCondition GC) {
        super();
        achievers = new HashMap();
        add_achievers = new HashMap();
        this.G = G;
        this.A = new LinkedHashSet();
        this.A.addAll(A);
        this.A.addAll(P);
        reacheable_predicates = new LinkedHashSet();
        reachable = new LinkedHashSet();
        max_depth = 10;
        all_conditions = new ArrayList();
        def_num_fluents = new LinkedHashSet();
        //build_integer_representation(A,G);
        this.gC = GC;
    }

    //this initializer is mandatory for being executed before each invocation of the heuristic
    public abstract Float setup(State s_0);

//        this.build_integer_representation();//for each proposition and comparison there is a unique integer representation
//        influenced_by = computeInflueced_by();
//        influence_graph = create_influence_graph();
//        try {
//            this.compute_relevant_actions(s_0);
//        } catch (Exception ex) {
//            Logger.getLogger(Heuristics.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        A = this.reachable;
//        return 0f;
//        //this.build_integer_representation();//this could reduce the number of predicate/comparison but it has been considered useless overhead
    public void build_integer_representation() {
        all_conditions = new LinkedHashSet();
        int counter_conditions = 0;

        integer_ref = new HashMap();
        total_number_of_actions = 0;
        ArrayList<GroundAction> actions_to_consider = new ArrayList(A);
        if (this.supporters != null) {
            actions_to_consider.addAll(this.supporters);
        }
        for (GroundAction a : actions_to_consider) {
            a.id = total_number_of_actions++;
            if (a.getPreconditions() != null) {
                for (Condition c_1 : a.getPreconditions().getTerminalConditions()) {
                    Utils.dbg_print(debug, "Condition added to the set:" + c_1 + "\n");
                    counter_conditions = update_index_conditions(c_1, counter_conditions);
                    //Utils.dbg_print(debug, "Identifier:" + c_1.getCounter() + "\n");
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

//        LinkedHashSet temp = new LinkedHashSet();
        for (Condition c_1 : G.getTerminalConditions()) {
            //Utils.dbg_print(debug, "Condition added to the set:" + c_1 + "\n");
            counter_conditions = update_index_conditions(c_1, counter_conditions);
            //Utils.dbg_print(debug, "Identifier:" + c_1.getCounter() + "\n");

//            temp.add(c_1);
        }
//        System.out.println("Conditions found:"+all_conditions.size());
//        System.out.println("Last condition counter:"+counter_conditions);
        index_of_last_static_atom = counter_conditions;//index of the last atom

    }
    
    

    /**
     *
     * @param s_0
     * @return
     */
    abstract public Float compute_estimate(State s_0);

    protected Float compute_precondition_cost(PDDLState s_0, ArrayList<Float> h, GroundAction gr, ArrayList<Boolean> closed) {
        return this.compute_cost(s_0, h, gr.getPreconditions(), closed);
    }

    protected Float compute_cost(PDDLState s_0, ArrayList<Float> h, Condition input_cond, ArrayList<Boolean> closed) {
        Float cost = 0f;

        ComplexCondition con = (ComplexCondition) input_cond;

        for (Condition t : (LinkedHashSet<Condition>) con.sons) {
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

    protected Float check_goal_conditions(PDDLState s_0, Condition G, ArrayList<Float> h, ArrayList<Boolean> closed) {
        return this.compute_cost(s_0, h, G, closed);
    }

    protected boolean update_prop_h(HeuristicSearchNode node, Map<Condition, Integer> h) {
        boolean new_condition = false;
        if (node.action.getAddList() == null) {
            return new_condition;
        }
        for (Condition eff : (LinkedHashSet<Condition>) node.action.getAddList().sons) {
            if (h.get(eff) == null || h.get(eff) > (node.action_cost_to_get_here)) {
                h.put(eff, node.action_cost_to_get_here);
                this.achievers.put(eff, node.action);
                new_condition = true;
            }
        }
        return new_condition;
    }

    protected int compute_precondition_cost(PDDLState s_0, Map<Condition, Integer> h, GroundAction gr) {

        int cost = 0;
        if (gr.getPreconditions() != null) {
            for (Condition t : (LinkedHashSet<Condition>) gr.getPreconditions().sons) {
                Integer temp = h.get(t);
                if (temp != null && temp != Float.MAX_VALUE) {
                    if (additive_h) {
                        cost += temp;
                    } else {
                        cost = Math.max(cost, temp);
                    }
                } else if (s_0.satisfy(t)) {
                    h.put(t, 0);
                    if (additive_h) {
                        cost += 0;
                    } else {
                        cost = Math.max(cost, 0);
                    }

                } else {
                    return Integer.MAX_VALUE;
                }

            }
        }
        return cost;
    }

    protected int compute_precondition_cost(PDDLState s_0, ArrayList<Integer> h, GroundAction gr) {
        return this.compute_cost(s_0, h, gr.getPreconditions());
    }

    protected int compute_cost(PDDLState s_0, ArrayList<Integer> h, ComplexCondition con) {
        int cost = 0;

        if (con == null) {
            return 0;
        }

        for (Condition t : (LinkedHashSet<Condition>) con.sons) {
            int temp = h.get(t.getHeuristicId());
            if (temp != Float.MAX_VALUE) {
                if (additive_h) {
                    cost += temp;
                } else {
                    cost = Math.max(cost, temp);
                }
            } else {
                return Integer.MAX_VALUE;
            }
        }
        return cost;
    }

//    protected float interval_based_relaxation_actions(PDDLState s_0, Conditions c, Collection<GroundAction> pool,HashMap<GroundAction,Float> action_to_cost) {
//        RelState rel_state = s_0.relaxState();
//        //LinkedList ordered_actions = sort_actions_pool_according_to_cost(pool);
//        float cost = 0;
//        float current_distance = rel_state.satisfaction_distance((Comparison) c);
//        //this terminates correctly whenever the numeric dependency graph is acyclic
//        LinkedList<GroundAction> q = new LinkedList();
//        while (true) {
//            boolean stop = true;
//            q = order_according_to_dependencies(pool, c);
//            while (!q.isEmpty()) {
//                GroundAction gr = q.pollFirst();
//                rel_state = gr.apply(rel_state);
//                float new_dist = rel_state.satisfaction_distance((Comparison) c);
//                //cost += gr.action_cost_to_get_here + 1;
//                if (current_distance >= new_dist) {
//                    cost += action_to_cost.get(gr) + 1;
//                    current_distance = new_dist;
//                    stop = false;
//                }
//                if (rel_state.satisfy((Comparison) c)) {
//                    return cost;
//                }
//            }
//            if (stop) {
//                return Float.POSITIVE_INFINITY;
//            }
//        }
//    }
    public boolean visit(NumEffect nf, Collection<NumEffect> col, HashMap<NumEffect, Boolean> temp_mark, HashMap<NumEffect, Boolean> per_mark, LinkedList<NumEffect> list) {

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

    private Boolean compute_enclosure(Collection<GroundAction> pool, RelState rel_state, Comparison c) {
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
            //System.out.println(nf.getRight());
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

    protected Float interval_based_relaxation_actions_with_cost(PDDLState s_0, Condition c, Collection<GroundAction> pool, HashMap<GroundAction, Float> action_to_cost) {
        RelState rel_state = s_0.relaxState();
//        System.out.println(rel_state);
        //LinkedList ordered_actions = sort_actions_pool_according_to_cost(pool);
        float cost = 0f;
//        float current_distance = rel_state.satisfaction_distance((Comparison) c);
        //this terminates correctly whenever the numeric dependency graph is acyclic. If it is cyclic it terminates with null
        Boolean proven_reachable = null;
            proven_reachable = compute_enclosure(pool, rel_state.clone(), (Comparison) c);

        if (proven_reachable != null && proven_reachable == false) {
            return Float.MAX_VALUE;
        }

        HashMap<NumEffect, Boolean> visited = new HashMap();
        int iteration = 0;
        if (proven_reachable == null) {
            proven_reachable = false;
        }
        Utils.dbg_print(debug, "Starting the reacheability analysis. Is it Reachable? :" + proven_reachable);
        //the bound here is only to capture really unlikely instances. Should be domain independent though
        while (iteration < 100 || proven_reachable) {
            LinkedList<NumEffect> q = new LinkedList(this.sorted_nodes);
//            if (q.isEmpty())
//                break;
            while (!q.isEmpty()) {
                NumEffect a = q.pollFirst();
                rel_state.update_values(a.apply(rel_state));
                if (visited.get(a) == null) {
                    cost += action_to_cost.get(this.num_eff_action.get(a));//precondition
                }
                if (this.cost_oriented_ibr) {
                    cost += this.num_eff_action.get(a).getActionCost();//cost of the action
                } else {
                    cost++;//this is the unit cost case
                }
                visited.put(a, true);
                if (c.can_be_true(rel_state)) {
                    return cost;
                }
            }
            iteration++;
        }
        return cost;
    }

//        
//        LinkedList initial = order_according_to_dependencies_actions(pool, c, action_to_cost);
//        Collection<NumFluent> interesting_fluents = c.getInvolvedFluents();
//        HashMap<Integer, Boolean> visited = new HashMap();
//        for (int i=0;i<initial.size();i++){
//            visited.put(i,false);
//        }
//        int iteration=0;
//        temp_preferred_operators_ibr = new LinkedHashSet();
//        while (true) {
//            boolean stop = true;
//            LinkedList q = new LinkedList(initial);
//            int i=0;
//            RelState rel_state_before = null;
//            try {
//                rel_state_before = rel_state.clone();
//            } catch (CloneNotSupportedException ex) {
//                Logger.getLogger(Heuristics.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            while (!q.isEmpty()) {        
//                
//                GroundAction gr = (GroundAction) q.pollFirst();
//                
//                
//                rel_state = gr.apply(rel_state);
//                int n = gr.internal_dependencies_length();
//                
//                for (int k=0;k<n;k++){
//                    //System.out.println(gr.getName()+ " has internal dependency, where max lenght is:"+n);
//                    cost++;
//                    rel_state = gr.apply(rel_state);
//                    
//                }
//                if (visited.get(i) == false) {
//                    cost++;
//                    if (action_to_cost.get(gr) != null){
//                        cost += action_to_cost.get(gr);
//                    }
//                    temp_preferred_operators_ibr.add(gr);
//                }
//                //cost++;
//                if (any_change(rel_state_before,rel_state,interesting_fluents)) {
//                    stop = false;
//                }
//                visited.put(i, true);
//
//                if (rel_state.satisfy((Comparison) c)) {
//                    return cost;
//                }
//                
//                if (iteration>100000 && reacheable==null){
//                    //System.out.println("Cut-off");
//                    return cost;
//                }
//            }
//            iteration++;
//            if (stop) {
//                return Float.MAX_VALUE;
//            }
//        }
    protected void init_pool(Collection pool, Collection<GroundAction> A1, PDDLState s_0, ArrayList<Float> h) {

        Iterator it = A1.iterator();
        while (it.hasNext()) {
            GroundAction gr = (GroundAction) it.next();
            if (this.compute_precondition_cost(s_0, h, gr, null) != Float.MAX_VALUE) {
//                gr.set_unit_cost(s_0);
                pool.add(new HeuristicSearchNode(gr, null, 0, 0));
                it.remove();
                this.reachable.add(gr);
            }
        }
    }

    protected void update_pool(Collection<GroundAction> pool, Collection<GroundAction> A1, PDDLState s_0, ArrayList<Float> h) {
        //update action precondition

        for (GroundAction gr : A1) {
            if (gr.getPreconditions() == null || gr.getPreconditions().sons.isEmpty() || h.get(gr.getPreconditions().getHeuristicId()) != Float.MAX_VALUE) {
                pool.add(gr);
                this.reachable.add(gr);
                //it.remove();
            }
        }
    }

    protected void identify_complex_conditions(Collection<GroundAction> A) {
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

                                if ((!ne.rhsFluents().isEmpty() && !ne.isPseudo_num_effect()) ) {
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

    protected void generate_self_precondition_delete_sets() {
        precondition_deleted = new HashMap();
        for (GroundAction gr : this.A) {
            HashSet precondition = new HashSet();
            if (gr.getPreconditions() == null || gr.getPreconditions().sons == null) {
                continue;
            }
            for (Condition c : (Collection<Condition>) gr.getPreconditions().sons) {
                if (c instanceof Predicate) {
                    if (gr.delete((Predicate) c)) {
                        precondition.add(c);
                        break;
                    }
                }
            }
            precondition_deleted.put(gr, precondition);
        }
    }

    protected Float compute_additional_cost(Float number_of_repetition, GroundAction gr, ArrayList<Float> h) {
        Float additional_cost = 0f;
        if (this.rep_costs.get(gr) != null && number_of_repetition > 1) {
            LinkedHashSet<Pair<Pair<Comparison, Comparison>, Integer>> ret = this.rep_costs.get(gr);
            for (Pair<Pair<Comparison, Comparison>, Integer> p : ret) {
                Float rpc = h.get(p.getFirst().getFirst().getHeuristicId());
                //System.out.println("Counter here:"+p.getFirst().getCounter());
                if (number_of_repetition > p.getSecond()) {
                    if (rpc == Float.MAX_VALUE) {
                        return Float.MAX_VALUE;
                    } else {
                        additional_cost += (number_of_repetition - p.getSecond() - 1) * (rpc);
                        //additional_cost = Math.max((number_of_repetition - p.getSecond() - 1) * (rpc),additional_cost);
                    }
                }
            }
        }
        if (number_of_repetition > 1) {
            //add precondition cost violation
            for (Predicate p_del : precondition_deleted.get(gr)) {
                if (h.get(p_del.getHeuristicId()) == Float.MAX_VALUE) {
                    return Float.MAX_VALUE;
                }
                additional_cost += h.get(p_del.getHeuristicId()) * (number_of_repetition - 1);

                //additional_cost = Math.max(h.get(p_del.getCounter()) * (number_of_repetition - 1),additional_cost);
            }
        }
        return additional_cost;
    }

    protected float compute_current_cost_via_lp(Collection<GroundAction> pool, PDDLState s_0, ComplexCondition c, ArrayList<Float> h) {

        n_lp_invocations = n_lp_invocations + 1;
//        System.out.println(invocation);
        if (c == null || c.sons == null || c.sons.isEmpty()) {
            return 0.0F;
        }
        Float minimum_precondition_cost;

//         BasicLogger.debug();
//        BasicLogger.debug("Test for "+c.pddlPrint(false));
//        BasicLogger.debug(OjAlgoUtils.getTitle());
//        BasicLogger.debug(OjAlgoUtils.getDate());
//        BasicLogger.debug();
        final ExpressionsBasedModel tmpModel = new ExpressionsBasedModel();

        Collection<Predicate> pred_to_satisfy = new LinkedHashSet();
        Collection<Float> minimi = new LinkedHashSet();
        HashMap<Integer, Variable> action_to_variable = new HashMap();

        Collection<Condition> conditions_to_evaluate = new LinkedHashSet();
        conditions_to_evaluate.addAll(c.sons);
        if (gC != null) {
//            System.out.println("considering Global Constraints:"+gC.sons);
            conditions_to_evaluate.addAll(gC.sons);
        }
        for (Condition cond : conditions_to_evaluate) {
            Float local_minimum = Float.MAX_VALUE;

            if (cond instanceof Comparison) {
                Comparison comp = (Comparison) cond;
                ExtendedNormExpression left = (ExtendedNormExpression) comp.getLeft();
                boolean at_least_one = false;
                Double num = comp.getLeft().eval(s_0);
                Expression condition = null;
                switch (comp.getComparator()) {
                    case ">":
                        condition = tmpModel.addExpression(cond.toString()).upper(num);
                        break;
                    case ">=":
                        condition = tmpModel.addExpression(cond.toString()).upper(num);
                        break;
                    case "<":
                        condition = tmpModel.addExpression(cond.toString()).lower(num);
                        break;
                    case "<=":
                        condition = tmpModel.addExpression(cond.toString()).lower(num);
                        break;
                    case "=":
                        condition = tmpModel.addExpression(cond.toString()).upper(num).lower(num);
                        break;
                }
                for (ExtendedAddendum ad : left.summations) {
                    if (ad.f != null) {
                        for (GroundAction gr : pool) {
                            boolean condition_investigated = false;

//                                                        System.out.println(gr);
                            if (gr.getNumericFluentAffected().contains(ad.f)) {
                                for (NumEffect neff : gr.getNumericEffectsAsCollection()) {
                                    if (!neff.getFluentAffected().equals(ad.f)) {
                                        continue;
                                    }
                                    //                                    System.out.println(neff);
//                                    gr.set_unit_cost(s_0);
                                    Float cost_action = gr.getActionCost();
                                    if (cost_action.isNaN()) {
                                        continue;
                                    }

                                    final Variable action;
                                    if (action_to_variable.get(gr.id) != null) {
                                        action = action_to_variable.get(gr.id);
                                        if (integer_variables) {
                                            action.integer(true);
                                        }
                                    } else {
                                        action = Variable.make(gr.toEcoString()).lower(0).weight(cost_action);
                                        tmpModel.addVariable(action);
                                        action_to_variable.put(gr.id, action);
                                    }

//                                    Float cost_of_prec = h.get(gr.getPreconditions().getCounter()) * 10.0F;
                                    //opt.Add(ctx.mkImplies(ctx.mkGt(var, ctx.mkInt(0)), ctx.mkEq(prec_cost, ctx.mkReal(cost_of_prec.intValue(), 10))));
                                    //opt.Add(ctx.mkImplies(ctx.mkEq(var, ctx.mkInt(0)), ctx.mkEq(prec_cost, ctx.mkReal(0))));
                                    Double right = null;
                                    switch (neff.getOperator()) {
                                        case "increase":
                                            right = neff.getRight().eval(s_0) * ad.n;
                                            right = condition.get(action).floatValue() - right;
                                            condition = condition.set(action, right);
                                            break;
                                        case "decrease":
                                            right = neff.getRight().eval(s_0) * ad.n;
                                            right = condition.get(action).floatValue() + right;
                                            condition = condition.set(action, right);
                                            break;
                                        case "assign":
                                            //this is an assign
//                                            right = neff.getRight().eval(s_0).getNumber() * ad.n.getNumber();
//                                            right = condition.get(action).floatValue() - right;
//                                            condition = condition.set(action, right - ad.f.eval(s_0).getNumber());
//                                            action.upper(1);
                                            System.out.println("Assign not supported");
                                            break;
                                    }

//                                    local_minimum = Math.min(local_minimum, h.get(gr.getPreconditions().getCounter()));
//                                    System.out.println("Action"+gr+" Cost:"+h.get(gr.getPreconditions().getCounter()));
//                                    System.out.println("Condition " +c);
                                    if ((comp.getComparator().contains(">") && right < 0)
                                            || (comp.getComparator().contains("<") && right > 0)) {
                                        at_least_one = true;
                                        local_minimum = Math.min(local_minimum, h.get(gr.getPreconditions().getHeuristicId()));
                                        //this is the only action that can be used. 
                                    }
//                                    if (local_minimum == Float.MAX_VALUE){
//                                        System.out.println("Problem with:"+gr);
//                                    }
                                }
                            }
                        }
                    }
                }
                if (!at_least_one && !cond.isSatisfied(s_0)) {
                    return Float.MAX_VALUE;
                }
//                if (!cond.isSatisfied(s_0)) {
//                    minimi.add(local_minimum); 
//                }
                minimi.add(local_minimum);

//                System.out.println(condition);
            } else if (cond instanceof Predicate) {
                pred_to_satisfy.add((Predicate) cond);
                if (!cond.isSatisfied(s_0)) {
                    boolean at_least_one = false;
                    Predicate p = (Predicate) cond;
                    Expression condition = tmpModel.addExpression(cond.toString()).lower(1);

                    for (GroundAction gr : pool) {
                        if (gr.achieve(p)) {
//                            gr.set_unit_cost(s_0);
                            Float cost_action = gr.getActionCost();
                            if (cost_action.isNaN()) {
                                continue;
                            }
                            at_least_one = true;
                            final Variable action;
                            if (action_to_variable.get(gr.id) != null) {
                                action = action_to_variable.get(gr.id);
                            } else {
                                action = Variable.make(gr.toEcoString()).lower(0).weight(cost_action);
                                tmpModel.addVariable(action);
                                action_to_variable.put(gr.id, action);
                                if (integer_variables) {
                                    action.integer(true);
                                }
                            }

                            //ArithExpr prec_cost = ctx.mkRealConst(gr.toString() + "pre_cost");
                            //action_used.add(prec_cost);
//                        Float cost_of_prec = h.get(gr.getPreconditions().getCounter()) * 10.0F;
                            local_minimum = Math.min(local_minimum, h.get(gr.getPreconditions().getHeuristicId()));
                            //opt.Add(ctx.mkImplies(ctx.mkGt(var, ctx.mkInt(0)), ctx.mkEq(prec_cost, ctx.mkReal(cost_of_prec.intValue(), 10))));
                            //opt.Add(ctx.mkImplies(ctx.mkEq(var, ctx.mkInt(0)), ctx.mkEq(prec_cost, ctx.mkReal(0))));
                            condition = condition.set(action, 1);
                            if (local_minimum == Float.MAX_VALUE) {//should not be true: debugging
                                System.out.println("Problem with:" + gr);
                            }
                        }
                    }
                    if (!at_least_one) {
                        return Float.MAX_VALUE;
                    }
                    minimi.add(local_minimum);
                }

            } else {

            }

        }

        Optimisation.Result tmpResult = tmpModel.minimise();

        if (tmpResult.getState().isFeasible()) {
            minimum_precondition_cost = 0f;

            if (this.additive_h) {
                for (Float local_min : minimi) {
                    minimum_precondition_cost += local_min;
                }
            } else {
                for (Float local_min : minimi) {
                    minimum_precondition_cost = Math.min(local_min, minimum_precondition_cost);
                }
            }
//            System.out.println("Condition under evaluation:"+c);
//            System.out.println("Action owning it:"+this.cond_action.get(c.getCounter()));
//            //if (c.getCounter() == G.getCounter()){
//                BasicLogger.debug();
//               BasicLogger.debug(tmpResult);
//                           BasicLogger.debug(tmpModel);
//
//               BasicLogger.debug();
//               System.out.println("Minimum Precondition Costs:"+minimum_precondition_cost);
//            //}
//
////            if (minimum_precondition_cost == Float.MAX_VALUE){
////                System.out.println("Error in using some of the action..");
////            }
//               System.out.println("Result returned:"+(float) (tmpResult.getValue() + minimum_precondition_cost));
            return (float) (tmpResult.getValue() + minimum_precondition_cost);
//            return (float) (tmpResult.getValue() + minimum_precondition_cost);

        } else {
            //            System.out.println(opt.toString());
            return Float.MAX_VALUE;
        }
        //        System.out.println(opt.Check());
    }

    protected int update_index_conditions(Condition c_1, int counter) {

        if (integer_ref.get(c_1) == null) {
//            System.out.println("This happens then");

            integer_ref.put(c_1, counter);
            c_1.setHeuristicId(counter);
            all_conditions.add(c_1);
            counter++;
        } else if (integer_ref.get(c_1) == null) {
//            System.out.println("bug in java");

            integer_ref.put(c_1, counter);
            c_1.setHeuristicId(counter);
            all_conditions.add(c_1);
            counter++;
        } else {
            c_1.setHeuristicId(integer_ref.get(c_1));
        }
        return counter;

    }

    protected void add_redundant_constraints() throws Exception {
        redundant_constraints = new HashMap();

        for (GroundAction a : A) {
            if (a.getPreconditions() != null) {
                compute_redundant_constraint((Set<ComplexCondition>) a.getPreconditions().sons);
            }
            //System.out.println(a.toPDDL());
        }

        compute_redundant_constraint((Set<ComplexCondition>) G.sons);
    }

    protected void compute_redundant_constraint(Set<ComplexCondition> set) throws Exception {
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

    protected void simplify_actions(PDDLState init) {
        for (GroundAction gr : this.A) {
            try {
                if (gr.getPreconditions() != null) {
                    gr.setPreconditions((ComplexCondition) gr.getPreconditions().transform_equality());
                }
                if (gr.getNumericEffects() != null && !gr.getNumericEffects().sons.isEmpty()) {
                    int number_numericEffects = gr.getNumericEffects().sons.size();
                    for (Iterator it = gr.getNumericEffects().sons.iterator(); it.hasNext();) {
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
//                                        neff.setRight(new BinaryOp(neff.getRight(), "-", neff.getFluentAffected(), true).normalize());
//                                        neff.setPseudo_num_effect(true);
//                                        //                            }
//                                    }
//                                }
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
        this.G = (ComplexCondition) this.G.transform_equality();
        this.G.normalize();
    }

    public float gValue(State s, Object transition, State next, Float previousG){
        GroundAction gr = (GroundAction)transition;
        if (gr == null)
            return previousG;
        return previousG + gr.getActionCost(s);
    }
    
}
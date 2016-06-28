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
/**
 * *******************************************************************
 * Description: Part of the PPMaJaL library
 *
 * Author: Enrico Scala 2013 Contact: enricos83@gmail.com
 *
 ********************************************************************
 */
package search;

import com.microsoft.z3.ArithExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.IntNum;
import com.microsoft.z3.Optimize;
import com.microsoft.z3.RatNum;
import com.microsoft.z3.RealExpr;
import com.microsoft.z3.Status;
import conditions.AndCond;
import conditions.Comparison;
import conditions.Conditions;
import conditions.Predicate;
import expressions.ExtendedAddendum;
import expressions.ExtendedNormExpression;
import expressions.NumEffect;
import expressions.NumFluent;
import expressions.PDDLNumber;
import expressions.Interval;
import extraUtils.Pair;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ojalgo.OjAlgoUtils;
import org.ojalgo.netio.BasicLogger;
import org.ojalgo.optimisation.Expression;
import org.ojalgo.optimisation.ExpressionsBasedModel;
import org.ojalgo.optimisation.Optimisation;
import problem.GroundAction;
import problem.RelState;
import problem.State;
import org.ojalgo.optimisation.Variable;

/**
 *
 * @author enrico
 */
public abstract class Heuristics {

    static public LinkedHashSet usefulActions = new LinkedHashSet();
    protected LinkedList<NumEffect> sorted_nodes;
    public LinkedHashSet<GroundAction> reachable;
    public boolean additive_h = true;
    protected HashMap<GroundAction, HashSet<GroundAction>> influence_graph;
    public int max_depth;
    int debug = 0;
    protected boolean internal_update;
    public LinkedHashSet<Predicate> reacheable_predicates;

    Collection<Conditions> all_conditions;
    HashMap<GroundAction, HashSet<Conditions>> influenced_by;
    HashMap<GroundAction, GroundAction> depends_on;

    public HashMap<Conditions, GroundAction> achievers;
    public HashMap<Comparison, Comparison> add_achievers;
    protected int index_of_last_static_atom;
    public LinkedHashSet<GroundAction> A;
    public Conditions G;
    private Set<NumFluent> def_num_fluents;
    protected LinkedHashSet orderings;
    protected boolean cyclic_task;
    protected HashMap<Conditions, Boolean> is_complex;
    protected HashMap<Conditions, Boolean> new_condition;
    protected int complex_conditions;
    protected HashMap<GroundAction, HashSet<Predicate>> precondition_deleted;
    protected boolean sat_test_within_cost = true;
    protected HashMap<GroundAction, LinkedHashSet<Pair<Pair<Comparison, Comparison>, Integer>>> rep_costs;

    public LinkedHashSet<GroundAction> relaxed_plan_actions;
    public HashMap<Integer, GroundAction> final_achiever;
    protected boolean preferred_operators;
    protected LinkedHashSet<GroundAction> temp_preferred_operators_ibr;
    public int reacheable_conditions;
    private boolean no_plan_extraction = true;
    public int horizon = 100000;
    protected int hard_conditions;
    HashMap<NumEffect, GroundAction> num_eff_action;
    public Collection<GroundAction> supporters;
    public RelState reacheable_state;
    protected Collection<Comparison> complex_condition_set;
    protected boolean check_mutex = false;
    private int invocation;
    public boolean integer_variables;
    public boolean greedy;
    Conditions gC;
    protected HashMap<Integer, GroundAction> cond_action;

    public Heuristics(Conditions G, Set<GroundAction> A) {
        super();
        achievers = new HashMap();
        add_achievers = new HashMap();
        this.G = G;
        this.A = new LinkedHashSet();
        this.A.addAll(A);
        reacheable_predicates = new LinkedHashSet();
        reachable = new LinkedHashSet();
        max_depth = 10;
        all_conditions = new LinkedHashSet();
        def_num_fluents = new LinkedHashSet();
        //build_integer_representation(A,G);
    }

    public Heuristics(Conditions G, Set<GroundAction> A, Set<GroundAction> P) {
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
        all_conditions = new LinkedHashSet();
        def_num_fluents = new LinkedHashSet();
        //build_integer_representation(A,G);
    }
    
    public Heuristics(Conditions G, Set<GroundAction> A, Set<GroundAction> P,Conditions GC) {
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
        all_conditions = new LinkedHashSet();
        def_num_fluents = new LinkedHashSet();
        //build_integer_representation(A,G);
        this.gC = GC;
    }

    //this initializer is mandatory for being executed before each invocation of the heuristic
    public abstract Float setup(State s_0) ;

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
        int counter2 = 0;

        int counter_actions = 0;
        ArrayList conditions = new ArrayList();
        ArrayList<GroundAction> actions_to_consider = new ArrayList(A);
        if (this.supporters != null) {
            actions_to_consider.addAll(this.supporters);
        }
        for (GroundAction a : actions_to_consider) {
            a.counter = counter_actions++;
            LinkedHashSet temp = new LinkedHashSet();
            if (a.getPreconditions() != null) {

                if (a.getPreconditions() != null && a.getPreconditions().sons != null) {
                    for (Conditions c_1 : (Set<Conditions>) a.getPreconditions().sons) {
                        int index = conditions.indexOf(c_1);
                        if (index != -1) {
                            c_1 = (Conditions) conditions.get(index);
                        } else {
                            counter2++;
                            c_1.setCounter(counter2);
                            //System.out.println(c_1+"->"+counter2);
                            conditions.add(c_1);
                        }
                        temp.add(c_1);
                    }
                    a.getPreconditions().sons = temp;
                }
            }
        }
//        System.out.println("Repetions:"+repetition);
//        System.out.println("Number of conditions given by the action:"+(repetition+counter2));

        //System.out.println("Now action effects:");
        for (GroundAction a : actions_to_consider) {
            LinkedHashSet temp = new LinkedHashSet();

            if (a.getAddList() != null && a.getAddList().sons != null) {
                for (Conditions c_1 : (Set<Conditions>) a.getAddList().sons) {
                    int index = conditions.indexOf(c_1);
                    if (index != -1) {
                        c_1 = (Conditions) conditions.get(index);
                        //System.out.println(c_1+"->"+c_1.getCounter());
                    } else {
                        counter2++;
                        c_1.setCounter(counter2);
                        //System.out.println(c_1+"->"+counter);
                        conditions.add(c_1);
                    }
                    temp.add(c_1);

                }
                a.getAddList().sons = temp;
            }

        }

        LinkedHashSet temp = new LinkedHashSet();

        for (Conditions c_1 : (Set<Conditions>) G.sons) {
            int index = conditions.indexOf(c_1);
            if (index != -1) {
                c_1 = (Conditions) conditions.get(index);
            } else {
                counter2++;
                c_1.setCounter(counter2);
//                    System.out.println(c_1+"->"+counter);
                conditions.add(c_1);
            }
            temp.add(c_1);
        }
        G.sons = temp;
        //System.out.println(conditions);
        index_of_last_static_atom = counter2;//index of the last atom
        this.all_conditions.addAll(conditions);

    }

    abstract Float compute_estimate(State s_0);

    protected Float compute_precondition_cost(State s_0, ArrayList<Float> h, GroundAction gr, ArrayList<Boolean> closed) {
        return this.compute_cost(s_0, h, gr.getPreconditions(), closed);
    }

    protected Float compute_cost(State s_0, ArrayList<Float> h, Conditions con, ArrayList<Boolean> closed) {
        Float cost = 0f;

        if (con == null || con.sons == null) {
            return 0f;
        }

        for (Conditions t : (LinkedHashSet<Conditions>) con.sons) {
            if (closed != null && !closed.get(t.getCounter())) {
                return Float.MAX_VALUE;
            }
            Float temp = h.get(t.getCounter());
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

    protected Float check_goal_conditions(State s_0, Conditions G, ArrayList<Float> h, ArrayList<Boolean> closed) {
        return this.compute_cost(s_0, h, G, closed);
    }










    protected boolean update_prop_h(HeuristicSearchNode node, Map<Conditions, Integer> h) {
        boolean new_condition = false;
        if (node.action.getAddList() == null) {
            return new_condition;
        }
        for (Conditions eff : (LinkedHashSet<Conditions>) node.action.getAddList().sons) {
            if (h.get(eff) == null || h.get(eff) > (node.action_cost_to_get_here)) {
                h.put(eff, node.action_cost_to_get_here);
                this.achievers.put(eff, node.action);
                new_condition = true;
            }
        }
        return new_condition;
    }

    protected int compute_precondition_cost(State s_0, Map<Conditions, Integer> h, GroundAction gr) {

        int cost = 0;
        if (gr.getPreconditions() != null) {
            for (Conditions t : (LinkedHashSet<Conditions>) gr.getPreconditions().sons) {
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








    protected int compute_precondition_cost(State s_0, ArrayList<Integer> h, GroundAction gr) {
        return this.compute_cost(s_0, h, gr.getPreconditions());
    }

    protected int compute_cost(State s_0, ArrayList<Integer> h, Conditions con) {
        int cost = 0;

        if (con == null) {
            return 0;
        }

        for (Conditions t : (LinkedHashSet<Conditions>) con.sons) {
            int temp = h.get(t.getCounter());
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





//    protected float interval_based_relaxation_actions(State s_0, Conditions c, Collection<GroundAction> pool,HashMap<GroundAction,Float> action_to_cost) {
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
                    if (visit(b, col, temp_mark, per_mark, list)) {
                        return true;
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

    private Boolean compute_enclosure(Collection<GroundAction> pool, RelState rel_state, Comparison c) throws CloneNotSupportedException {
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
                    nf.apply(temp);
                    break;
            }
        }

//        if (cyclic){
//            sorted_nodes.addAll(num_effects);
//        }
        boolean try_anyway = c.isSatisfied(temp);
        if (!try_anyway && cyclic) {
            return null;
        }

//        System.out.println("transitive_closure");
        return try_anyway;

    }

    protected Float interval_based_relaxation_actions_with_cost(State s_0, Conditions c, Collection<GroundAction> pool, HashMap<GroundAction, Float> action_to_cost) throws CloneNotSupportedException {
        RelState rel_state = s_0.relaxState();
//        System.out.println(rel_state);
        //LinkedList ordered_actions = sort_actions_pool_according_to_cost(pool);
        float cost = 0f;
//        float current_distance = rel_state.satisfaction_distance((Comparison) c);
        //this terminates correctly whenever the numeric dependency graph is acyclic. If it is cyclic it terminates with null
        Boolean reacheable = null;
        this.dbg_print("compoute enclosure");
        try {
            reacheable = compute_enclosure(pool, rel_state, (Comparison) c);
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Heuristics.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (reacheable != null && reacheable == false) {
            return Float.MAX_VALUE;
        }
        this.dbg_print("compoute enclosure finished");


        HashMap<NumEffect, Boolean> visited = new HashMap();
        Integer iteration = 0;
        while (iteration < horizon) {
            LinkedList<NumEffect> q = new LinkedList(this.sorted_nodes);
//s
            while (!q.isEmpty()) {
                NumEffect a = q.pollFirst();
                a.apply(rel_state);
                cost += this.num_eff_action.get(a).getAction_cost();
                if (visited.get(a) == null) {
                    cost += action_to_cost.get(this.num_eff_action.get(a));
                }
                visited.put(a, true);
                if (c.isSatisfied(rel_state)) {
                    return cost;
                }
            }
            this.dbg_print(iteration.toString()+'\n');

            iteration++;


        }
//        System.out.println("Cost:"+cost+"Iteration:"+iteration);
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
    protected void init_pool(Collection pool, Collection<GroundAction> A1, State s_0, ArrayList<Float> h) {

        Iterator it = A1.iterator();
        while (it.hasNext()) {
            GroundAction gr = (GroundAction) it.next();
            if (this.compute_precondition_cost(s_0, h, gr, null) != Float.MAX_VALUE) {
                gr.setAction_cost(s_0);
                pool.add(new HeuristicSearchNode(gr, null, 0, 0));
                it.remove();
                this.reachable.add(gr);
            }
        }
    }





    protected void update_pool(Collection<GroundAction> pool, Collection<GroundAction> A1, State s_0, ArrayList<Float> h) {
        //update action precondition

        for (GroundAction gr : A1) {
            if (gr.getPreconditions() == null || gr.getPreconditions().sons.isEmpty() || h.get(gr.getPreconditions().getCounter()) != Float.MAX_VALUE) {
                pool.add(gr);
                this.reachable.add(gr);
                //it.remove();
            }
        }
    }


    protected void identify_complex_conditions(Collection<Conditions> conds, Collection<GroundAction> A) {
        //For each condition, identify whether there is at least an action whose effects are not simple. This condition
        // will be considered complex in that checking its satisfaction is hard
        is_complex = new HashMap();
        new_condition = new HashMap();
        complex_condition_set = new LinkedHashSet();
        for (Conditions c : conds) {
            if (c instanceof Comparison) {
                Comparison comp = (Comparison) c;
                new_condition.put(comp, false);
                is_complex.put(comp, false);
                for (GroundAction gr : A) {
                    if (gr.getNumericEffects() != null) {
                        AndCond effects = (AndCond) gr.getNumericEffects();
                        for (NumEffect ne : (Collection<NumEffect>) effects.sons) {
                            if (comp.getInvolvedFluents().contains(ne.getFluentAffected())) {
                                if (!ne.fluentsInvolved().isEmpty()) {
                                    is_complex.put(comp, true);
                                    complex_conditions++;
                                    complex_condition_set.add((Comparison) c);
                                    //System.out.println("Complex condition:"+comp);
                                }
                            }
                        }
                    }
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
            for (Conditions c : (Collection<Conditions>) gr.getPreconditions().sons) {
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
                Float rpc = h.get(p.getFirst().getFirst().getCounter());
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
                if (h.get(p_del.getCounter()) == Float.MAX_VALUE) {
                    return Float.MAX_VALUE;
                }
                additional_cost += h.get(p_del.getCounter()) * (number_of_repetition - 1);

                //additional_cost = Math.max(h.get(p_del.getCounter()) * (number_of_repetition - 1),additional_cost);
            }
        }
        return additional_cost;
    }





    protected void dbg_print(String string) {
        if (debug > 0) {
            System.out.print(string);
        }
    }

    protected float compute_current_cost_via_smt(Collection<GroundAction> pool, State s_0, Conditions c, ArrayList<Float> h) {

        invocation = invocation + 1;
//        System.out.println(invocation);
        if (c == null || c.sons == null || c.sons.isEmpty()) {
            return 0.0F;
        }
        Float minimum_precondition_cost;
        Context ctx = new Context();

        Optimize opt = ctx.mkOptimize();
        Collection<ArithExpr> action_used = new LinkedHashSet();
        Collection<Predicate> pred_to_satisfy = new LinkedHashSet();
        Collection<Float> minimi = new LinkedHashSet();
        for (Conditions cond : (Collection<Conditions>) c.sons) {
            Float local_minimum = Float.MAX_VALUE;

            if (cond instanceof Comparison) {
                Comparison comp = (Comparison) cond;
                ExtendedNormExpression left = (ExtendedNormExpression) comp.getLeft();
                ArithExpr expr = ctx.mkAdd(ctx.mkReal(0));
                boolean at_least_one = false;
                for (ExtendedAddendum ad : left.summations) {
                    if (ad.f != null) {

                        Float num = s_0.functionValue(ad.f).getNumber() * 10.0F * ad.n.getNumber();
                        expr = ctx.mkAdd(expr, ctx.mkReal(num.intValue(), 10));
                        for (GroundAction gr : pool) {
                            //                            System.out.println(gr);
                            if (gr.getNumericFluentAffected().get(ad.f) != null && gr.getNumericFluentAffected().get(ad.f).equals(Boolean.TRUE)) {
                                for (NumEffect neff : gr.getNumericEffectsAsCollection()) {
                                    if (!neff.getFluentAffected().equals(ad.f)) {
                                        continue;
                                    }
                                    //                                    System.out.println(neff);

                                    gr.setAction_cost(s_0);
                                    Float cost_action = gr.getAction_cost() * 10.0F;
                                    if (cost_action.isNaN()) {
                                        continue;
                                    }
                                    ArithExpr var = ctx.mkRealConst(gr.toString());
                                    //ArithExpr prec_cost = ctx.mkRealConst(gr.toString() + "pre_cost");
                                    ArithExpr action_plus_cost = ctx.mkMul(var, ctx.mkReal(cost_action.intValue(), 10));
                                    //                                    System.out.println(action_plus_cost);
                                    action_used.add(action_plus_cost);
                                    //action_used.add(prec_cost);
                                    opt.Add(ctx.mkGe(var, ctx.mkReal(0)));
//                                    Float cost_of_prec = h.get(gr.getPreconditions().getCounter()) * 10.0F;
                                    //opt.Add(ctx.mkImplies(ctx.mkGt(var, ctx.mkInt(0)), ctx.mkEq(prec_cost, ctx.mkReal(cost_of_prec.intValue(), 10))));
                                    //opt.Add(ctx.mkImplies(ctx.mkEq(var, ctx.mkInt(0)), ctx.mkEq(prec_cost, ctx.mkReal(0))));
                                    Float right = null;
                                    if (neff.getOperator().equals("increase")) {
                                        right = neff.getRight().eval(s_0).getNumber() * 10.0F * ad.n.getNumber();
                                        expr = ctx.mkAdd(expr, ctx.mkMul(var, ctx.mkReal(right.intValue(), 10)));
                                    } else if (neff.getOperator().equals("decrease")) {
                                        right = neff.getRight().eval(s_0).getNumber() * 10.0F * ad.n.getNumber();
                                        expr = ctx.mkSub(expr, ctx.mkMul(var, ctx.mkReal(right.intValue(), 10)));
                                    } else {
                                        System.out.println("not supported yet");
                                        System.exit(-1);
                                    }
//                                                                        at_least_one = true;
//                                    at_least_one = true;

                                    if ((comp.getComparator().contains(">") && neff.getOperator().equals("increase") && right > 0)
                                            || (comp.getComparator().contains("<") && neff.getOperator().equals("decrease") && right > 0)
                                            || (comp.getComparator().contains(">") && neff.getOperator().equals("decrease") && right < 0)
                                            || (comp.getComparator().contains("<") && neff.getOperator().equals("increase") && right < 0)) {
                                        at_least_one = true;

                                    }
                                    local_minimum = Math.min(local_minimum, h.get(gr.getPreconditions().getCounter()));
                                }
                            }
                        }
                    } else {
                        Float num = ad.n.getNumber() * 10.0F;
                        expr = ctx.mkAdd(expr, ctx.mkReal(num.intValue(), 10));
                    }
                }
                if (!at_least_one && !cond.isSatisfied(s_0)) {
                    return Float.MAX_VALUE;
                }
                if (cond.isSatisfied(s_0)) {
                    local_minimum = 0f;
//                   
                }
                switch (comp.getComparator()) {
                    case ">":
                        opt.Add(ctx.mkGt(expr, ctx.mkReal(0)));
                        break;
                    case ">=":
                        opt.Add(ctx.mkGe(expr, ctx.mkReal(0)));
                        break;
                    case "<":
                        opt.Add(ctx.mkLt(expr, ctx.mkReal(0)));
                        break;
                    case "<=":
                        opt.Add(ctx.mkLe(expr, ctx.mkReal(0)));
                        break;
                    case "=":
                        opt.Add(ctx.mkEq(expr, ctx.mkReal(0)));
                        break;
                }

            } else if (cond instanceof Predicate) {
                pred_to_satisfy.add((Predicate) cond);
                if (!cond.isSatisfied(s_0)) {
                    boolean at_least_one = false;
                    Predicate p = (Predicate) cond;
                    ArithExpr expr = ctx.mkAdd(ctx.mkReal(0));
                    for (GroundAction gr : pool) {
                        if (gr.achieve(p)) {
                            gr.setAction_cost(s_0);
                            Float cost_action = gr.getAction_cost() * 10.0F;
                            if (cost_action.isNaN()) {
                                continue;
                            }
                            at_least_one = true;
                            ArithExpr var = ctx.mkRealConst(gr.toString());
                            expr = ctx.mkAdd(expr, var);
                            ArithExpr action_plus_cost = ctx.mkMul(var, ctx.mkReal(cost_action.intValue(), 10));
                            action_used.add(action_plus_cost);
                            //ArithExpr prec_cost = ctx.mkRealConst(gr.toString() + "pre_cost");
                            //action_used.add(prec_cost);
//                        Float cost_of_prec = h.get(gr.getPreconditions().getCounter()) * 10.0F;
                            local_minimum = Math.min(local_minimum, h.get(gr.getPreconditions().getCounter()));
                            opt.Add(ctx.mkGe(var, ctx.mkReal(0)));
                            //opt.Add(ctx.mkImplies(ctx.mkGt(var, ctx.mkInt(0)), ctx.mkEq(prec_cost, ctx.mkReal(cost_of_prec.intValue(), 10))));
                            //opt.Add(ctx.mkImplies(ctx.mkEq(var, ctx.mkInt(0)), ctx.mkEq(prec_cost, ctx.mkReal(0))));
                        }
                    }
                    if (!at_least_one) {
                        return Float.MAX_VALUE;
                    }
                    opt.Add(ctx.mkGe(expr, ctx.mkReal(1)));
                } else {
                    continue;
                }
            } else {

            }
            minimi.add(local_minimum);
        }

        if (check_mutex) {
            ArithExpr expr = ctx.mkAdd(ctx.mkReal(0));
            int i = 0;
            for (Predicate p : pred_to_satisfy) {
                if (p.isSatisfied(s_0)) {
                    continue;
                }
                i++;
                //expr = ctx.mkAdd(expr,ctx.mkRealConst(p.toString()));
                for (GroundAction gr : pool) {
                    if (gr.achieve(p)) {
                        ArithExpr var = ctx.mkRealConst(gr.toString() + "prop");
                        opt.Add(ctx.mkGe(var, ctx.mkReal(0)));
                        expr = ctx.mkAdd(expr, var);
                    } else if (gr.delete(p)) {
                        ArithExpr var = ctx.mkRealConst(gr.toString() + "prop");
                        opt.Add(ctx.mkGe(var, ctx.mkReal(0)));
                        expr = ctx.mkSub(expr, var);
                    }
                }
            }
            opt.Add(ctx.mkGe(expr, ctx.mkReal(i)));
        }

        ArithExpr[] to_add = from_set_to_arithm_expr_array(action_used);
        ArithExpr temp = ctx.mkAdd(ctx.mkReal(0));
        if (to_add.length != 0) {
            temp = ctx.mkAdd(to_add);
        }
        Optimize.Handle mx = opt.MkMinimize(temp);

        if (opt.Check() == Status.SATISFIABLE) {
            minimum_precondition_cost = 0f;
            for (Float local_min : minimi) {
                minimum_precondition_cost = Math.max(local_min, minimum_precondition_cost);
            }

            ArithExpr ret = mx.getValue();
            if (ret instanceof IntNum) {
                return Float.parseFloat(ret.toString()) + minimum_precondition_cost;
            } else if (ret instanceof RatNum) {
                RatNum rat = (RatNum) ret;
                return (float) rat.getNumerator().getInt() / (float) rat.getDenominator().getInt() + minimum_precondition_cost;
            } else if (ret instanceof RealExpr) {
                RealExpr real_expr = (RealExpr) ret;
                System.out.println(real_expr.getClass());
                return 0;
            }
            System.out.println("Value not recognized");
            if (mx.getValue().toString().equals("epsilon")) {
                System.out.println("Numeric instability");
                System.exit(-1);
                return 0;
            }
            return Float.MAX_VALUE;
        } else {
            //            System.out.println(opt.toString());
            return Float.MAX_VALUE;
        }
        //        System.out.println(opt.Check());
    }

    protected float compute_current_cost_via_lp(Collection<GroundAction> pool, State s_0, Conditions c, ArrayList<Float> h) {

        invocation = invocation + 1;
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

        Collection<ArithExpr> action_used = new LinkedHashSet();
        Collection<Predicate> pred_to_satisfy = new LinkedHashSet();
        Collection<Float> minimi = new LinkedHashSet();
        HashMap<Integer, Variable> action_to_variable = new HashMap();
        
        Collection<Conditions> conditions_to_evaluate = new LinkedHashSet();
        conditions_to_evaluate.addAll(c.sons);
        if (gC != null){ 
//            System.out.println("considering Global Constraints:"+gC.sons);
            conditions_to_evaluate.addAll(gC.sons);
        }
        for (Conditions cond : conditions_to_evaluate) {
            Float local_minimum = Float.MAX_VALUE;

            if (cond instanceof Comparison) {
                Comparison comp = (Comparison) cond;
                ExtendedNormExpression left = (ExtendedNormExpression) comp.getLeft();
                boolean at_least_one = false;
                Float num = comp.getLeft().eval(s_0).getNumber();
                Expression condition = null;
                switch (comp.getComparator()) {
                    case ">":
                        condition = tmpModel.addExpression(((Comparison) cond).toString()).upper(num);
                        break;
                    case ">=":
                        condition = tmpModel.addExpression(((Comparison) cond).toString()).upper(num);
                        break;
                    case "<":
                        condition = tmpModel.addExpression(((Comparison) cond).toString()).lower(num);
                        break;
                    case "<=":
                        condition = tmpModel.addExpression(((Comparison) cond).toString()).lower(num);
                        break;
                    case "=":
                        condition = tmpModel.addExpression(((Comparison) cond).toString()).upper(num).lower(num);
                        break;
                }
                for (ExtendedAddendum ad : left.summations) {
                    if (ad.f != null) {
                        for (GroundAction gr : pool) {
                            boolean condition_investigated = false;

//                                                        System.out.println(gr);
                            if (gr.getNumericFluentAffected().get(ad.f) != null && gr.getNumericFluentAffected().get(ad.f).equals(Boolean.TRUE)) {
                                for (NumEffect neff : gr.getNumericEffectsAsCollection()) {
                                    if (!neff.getFluentAffected().equals(ad.f)) {
                                        continue;
                                    }
                                    //                                    System.out.println(neff);
                                    gr.setAction_cost(s_0);
                                    Float cost_action = gr.getAction_cost();
                                    if (cost_action.isNaN()) {
                                        continue;
                                    }

                                    final Variable action;
                                    if (action_to_variable.get(gr.counter) != null) {
                                        action = action_to_variable.get(gr.counter);
                                        if (integer_variables) {
                                            action.integer(true);
                                        }
                                    } else {
                                        action = Variable.make(gr.toEcoString()).lower(0).weight(cost_action);
                                        tmpModel.addVariable(action);
                                        action_to_variable.put(gr.counter, action);
                                    }

//                                    Float cost_of_prec = h.get(gr.getPreconditions().getCounter()) * 10.0F;
                                    //opt.Add(ctx.mkImplies(ctx.mkGt(var, ctx.mkInt(0)), ctx.mkEq(prec_cost, ctx.mkReal(cost_of_prec.intValue(), 10))));
                                    //opt.Add(ctx.mkImplies(ctx.mkEq(var, ctx.mkInt(0)), ctx.mkEq(prec_cost, ctx.mkReal(0))));
                                    Float right = null;
                                    switch (neff.getOperator()) {
                                        case "increase":
                                            right = neff.getRight().eval(s_0).getNumber() * ad.n.getNumber();
                                            right = condition.get(action).floatValue() - right;
                                            condition = condition.set(action, right);
                                            break;
                                        case "decrease":
                                            right = neff.getRight().eval(s_0).getNumber() * ad.n.getNumber();
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
                                        local_minimum = Math.min(local_minimum, h.get(gr.getPreconditions().getCounter()));
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
                    Expression condition = tmpModel.addExpression(((Predicate) cond).toString()).lower(1);

                    for (GroundAction gr : pool) {
                        if (gr.achieve(p)) {
                            gr.setAction_cost(s_0);
                            Float cost_action = gr.getAction_cost();
                            if (cost_action.isNaN()) {
                                continue;
                            }
                            at_least_one = true;
                            final Variable action;
                            if (action_to_variable.get(gr.counter) != null) {
                                action = action_to_variable.get(gr.counter);
                            } else {
                                action = Variable.make(gr.toEcoString()).lower(0).weight(cost_action);
                                tmpModel.addVariable(action);
                                action_to_variable.put(gr.counter, action);
                                if (integer_variables) {
                                    action.integer(true);
                                }
                            }

                            //ArithExpr prec_cost = ctx.mkRealConst(gr.toString() + "pre_cost");
                            //action_used.add(prec_cost);
//                        Float cost_of_prec = h.get(gr.getPreconditions().getCounter()) * 10.0F;
                            local_minimum = Math.min(local_minimum, h.get(gr.getPreconditions().getCounter()));
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

    protected ArithExpr[] from_set_to_arithm_expr_array(Collection<ArithExpr> action_used) {
        ArithExpr[] to_add = new ArithExpr[action_used.size()];
        Iterator<ArithExpr> it = action_used.iterator();
        int i = 0;
        while (it.hasNext()) {
            to_add[i] = it.next();
            it.remove();
            i++;
        }
        return to_add;
    }

}

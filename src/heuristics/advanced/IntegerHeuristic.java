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
package heuristics.advanced;

import heuristics.HeuristicSearchNode;
import conditions.AndCond;
import conditions.Comparison;
import conditions.Conditions;
import conditions.Predicate;
import expressions.NumEffect;
import expressions.NumFluent;
import expressions.PDDLNumber;
import expressions.Interval;
import extraUtils.Pair;
import heuristics.Heuristics;
import heuristics.Heuristics;
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
import problem.GroundAction;
import problem.RelState;
import problem.State;

/**
 *
 * @author enrico
 */
public abstract class IntegerHeuristic {

    static public LinkedHashSet usefulActions = new LinkedHashSet();
    private LinkedList<NumEffect> sorted_nodes;
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
    public int horizon = 1000000;

    public IntegerHeuristic(Conditions G, Set<GroundAction> A) {
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

    public IntegerHeuristic(Conditions G, Set<GroundAction> A, Set<GroundAction> P) {
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

    //this initializer is mandatory for being executed before each invocation of the heuristic
    public int setup(State s_0) {

        this.build_integer_representation();//for each proposition and comparison there is a unique integer representation
        influenced_by = computeInflueced_by();
        influence_graph = create_influence_graph();
        this.compute_relevant_actions(s_0);
        A = this.reachable;
        return 0;
        //this.build_integer_representation();//this could reduce the number of predicate/comparison but it has been considered useless overhead
    }

    public void build_integer_representation() {
        int counter2 = 0;
        ArrayList conditions = new ArrayList();
        int repetition = 0;
        for (GroundAction a : A) {
            LinkedHashSet temp = new LinkedHashSet();
            if (a.getPreconditions() != null) {
                for (Conditions c_1 : (Set<Conditions>) a.getPreconditions().sons) {
                    int index = conditions.indexOf(c_1);
                    if (index != -1) {
                        repetition++;
                        c_1 = (Conditions) conditions.get(index);
                    } else {
                        counter2++;
                        c_1.setCounter(counter2);
//                        System.out.println(c_1.toString());
                        //System.out.println(c_1+"->"+counter2);
                        conditions.add(c_1);
                    }
                    temp.add(c_1);
                }
                a.getPreconditions().sons = temp;
            }
        }
//        System.out.println("Repetions:"+repetition);
//        System.out.println("Number of conditions given by the action:"+(repetition+counter2));

        //System.out.println("Now action effects:");
        for (GroundAction a : A) {
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

    abstract int compute_estimate(State s_0);

    public void compute_relevant_actions(State s_0) {
        HashMap<GroundAction, HashSet<Conditions>> impr_conditions = new HashMap();
        HashMap<Conditions, Integer> h = new HashMap();
        HashMap<Conditions, Boolean> already_added = new HashMap();
        LinkedHashSet<GroundAction> A1 = new LinkedHashSet();
        A1.addAll(A);
        //assuming it is an and condition
        int ret = Integer.MAX_VALUE;
        //System.out.println("Starting Relevance Analysis....");
        long start = System.currentTimeMillis();

        for (Conditions c_1 : this.all_conditions) {
            if (c_1.isSatisfied(s_0)) {
                h.put(c_1, 0);
            }
        }

        while (true) {
            try {
                //this is for cost unit planning
                if (A1.isEmpty()) {
                    break;
                }
                ArrayList<HeuristicSearchNode> q = new ArrayList();
                this.update_frontier(q, A1, h, s_0);
                if (q.isEmpty()) {
                    break;
                }
                //for every action whose preconditions are evaluated,
                HashSet<Comparison> toAdd = new HashSet();
                internal_update = false;
                boolean new_conditions_detected = this.update_prop_numeric_h(q, impr_conditions, already_added, s_0, A1, h, toAdd, false);
                //update the improvable condition
                impr_conditions = update_improvable(s_0, (HashSet<GroundAction>) A, A1, toAdd, impr_conditions, h, max_depth, false);
                if (!new_conditions_detected && !this.internal_update) {
                    //System.out.println("Fix point");
                    break;
                }
            } catch (Exception ex) {
                Logger.getLogger(Heuristics.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        update_reacheable_predicates(h, s_0);
        update_definable_fluents();
        //System.out.println("Finished Relevance Analysis; Cpu-Time:" + (System.currentTimeMillis() - start));
        return;
    }

    protected void update_reacheable_predicates(HashMap<Conditions, Integer> h, State s_0) {
        for (Conditions c : h.keySet()) {
            if (c instanceof Predicate) {
                this.reacheable_predicates.add((Predicate) c);
            }
        }
        for (Object c : s_0.getPropositions()) {
            if (c instanceof Predicate) {
                this.reacheable_predicates.add((Predicate) c);
            }
        }

    }

    public Pair<HashMap<Conditions, Integer>, HashMap<GroundAction, HashSet<Conditions>>> computeAchieveds(State s_0, Conditions G, Set<GroundAction> A) throws Exception {
        long start = System.currentTimeMillis();
        HashSet<Conditions> all_conditions = computeConditionsSet(A, G);

        HashMap<Conditions, Integer> h = new HashMap();
        HashMap<GroundAction, HashSet<Conditions>> achieveds = new HashMap();
        for (Conditions c_1 : all_conditions) {
            c_1.normalize();
            if (s_0.satisfy(c_1)) {
                h.put(c_1, 0);
            } else {
                h.put(c_1, Integer.MAX_VALUE);
                if (c_1 instanceof Comparison) {
                    Comparison comp = (Comparison) c_1;
                    //System.out.println("c:"+c_1);
                    //HashSet<GroundAction> achievers = new HashSet();

                    boolean atLeastOne = false;
                    for (GroundAction act : A) {
                        if (act.improve(s_0, comp)) {
                            //System.out.println("comp:"+c_1);
                            //System.out.println("Action supposed to improve:"+act);
                            if (achieveds.get(act) == null) {
                                HashSet singleton = new HashSet();
                                singleton.add(c_1);
                                achieveds.put(act, singleton);
                            } else {
                                HashSet previous_comp = achieveds.get(act);
                                previous_comp.add(c_1);
                                achieveds.put(act, previous_comp);
                            }
                            //rel_com.push(act.regressComparison((Comparison) c_1.clone()));
                            atLeastOne = true;
                        }
                    }
                    if (!atLeastOne) {
                        //System.out.println("No action for:" + c_1);
                    }
                }
            }
        }
        //System.out.println("Computing the conditions set:"+(System.currentTimeMillis()-start));

        return new Pair(h, achieveds);
    }

    public HashSet<Conditions> computeConditionsSet(Set<GroundAction> A, Conditions G) {
        HashSet<Conditions> ret = new HashSet();

        for (GroundAction a : A) {
            //adding all the conditions of the action (Assuming it is an and condition)
            for (Conditions c_1 : (Set<Conditions>) a.getPreconditions().sons) {
                if (c_1 instanceof Comparison) {
                    ret.add((Comparison) c_1);
                    //System.out.println("Considered Constraint:"+c_1);
                }
            }

        }
        for (Conditions c_1 : (Set<Conditions>) G.sons) {
            if (c_1 instanceof Comparison) {
                ret.add((Comparison) c_1);
                //System.out.println("Constraint in the goal:" + c_1);
            }
        }
        return ret;
    }

    protected HashMap<GroundAction, HashSet<Conditions>> computeInflueced_by() {
        HashMap<GroundAction, HashSet<Conditions>> ret = new HashMap();

        if (debug >= 1) {
            System.out.println("all conditions:" + all_conditions);
        }

        for (Conditions c_1 : all_conditions) {
            if (c_1 instanceof Comparison) {
                Comparison comp = (Comparison) c_1;
                comp.normalize();
                for (GroundAction act : A) {
                    if (act.mayInfluence(comp)) {
                        if (ret.get(act) == null) {
                            HashSet singleton = new HashSet();
                            singleton.add(c_1);
                            ret.put(act, singleton);
                        } else {
                            HashSet previous_comp = ret.get(act);
                            previous_comp.add(c_1);
                            ret.put(act, previous_comp);
                        }
                    }
                }
            }
        }
        if (debug >= 1) {
            System.out.println("Influence by graph:" + ret);
        }
        return ret;
    }

    protected HashMap<GroundAction, HashSet<Conditions>> update_improvable(State s_0, HashSet<GroundAction> A, HashSet<GroundAction> A1, HashSet<Comparison> toAdd, HashMap<GroundAction, HashSet<Conditions>> improvable, Map<Conditions, Integer> h, int k, boolean to_post) throws Exception {
        for (GroundAction gr : A) {
            for (Comparison c_1 : toAdd) {
                Pair<Boolean, Integer> t = gr.improve_k(s_0, c_1, k, this.influence_graph, null);
                if (t.getFirst() || (t.getSecond() > 0 && !t.getFirst())) {
                    if (!to_post) {
                        h.put(c_1, 0);
                        internal_update = true;
                        continue;
                    }
                    //ret.add(c_1);
                    //System.out.println("c_1"+c_1);
                    if (improvable.get(gr) == null) {
                        HashSet<Conditions> new_achieveds = new HashSet();
                        new_achieveds.add(c_1);
                        improvable.put(gr, new_achieveds);
                    } else {
                        HashSet<Conditions> previous = improvable.get(gr);
                        previous.add(c_1);
                        improvable.put(gr, previous);
                    }
                    //System.out.println("Action added");
                    A1.add(gr);
                }

            }
        }

        return improvable;
    }

    private void print_achievers(Conditions G) {

        ArrayDeque<Conditions> q = new ArrayDeque();

        for (Conditions c : (LinkedHashSet<Conditions>) G.sons) {
            q.addLast(c);
        }

        while (q.size() > 0) {
            Conditions t = q.poll();
            if (achievers.get(t) != null) {
                GroundAction gr = (GroundAction) achievers.get(t);
                System.out.println(gr);
                if (gr.getPreconditions() != null) {
                    for (Object o : gr.getPreconditions().sons) {
                        System.out.println("      " + o);
                        Conditions c = (Conditions) o;
                        if (achievers.get(o) != null) {
                            System.out.println("      " + achievers.get(o));
                        }
                        q.addLast(c);
                    }
                }

            }

        }
    }

    protected HashMap<GroundAction, HashSet<GroundAction>> create_influence_graph() {
        if (this.influence_graph != null) {
            return this.influence_graph;
        }
        HashMap<GroundAction, HashSet<GroundAction>> ret = new HashMap();

        for (GroundAction a : A) {
            for (GroundAction b : A) {
                if (!a.equals(b)) {
                    if (b.is_complexly_influenced_by(a)) {
                        if (ret.get(b) == null) {
                            HashSet toadd = new HashSet();
                            toadd.add(a);
                            ret.put(b, toadd);
                        } else {
                            ret.get(b).add(a);
                        }
                    }
                }
            }
        }
        if (debug >= 2) {
            System.out.println(ret);
        }
        return ret;
    }

    protected int check_goal_conditions(State s_0, Conditions G, Map<Conditions, Integer> h) {
        int cost = 0;
        for (Conditions g : (LinkedHashSet<Conditions>) G.sons) {
            if ((h.get(g) != null && h.get(g) != Integer.MAX_VALUE) || s_0.satisfy(g)) {
                if (s_0.satisfy(g)) {
                    h.put(g, 0);
                } else {
                    if (additive_h) {
                        cost += h.get(g);
                    } else {
                        cost = Math.max(cost, h.get(g));
                    }
                }
            } else {
                return Integer.MAX_VALUE;
            }
        }
        return cost;
    }

    protected void update_frontier(Collection frontier, LinkedHashSet<GroundAction> A1, Map<Conditions, Integer> h, State s_0) {
        Iterator it = A1.iterator();
        while (it.hasNext()) {
            GroundAction gr = (GroundAction) it.next();
            int cost = 0;
            cost = compute_precondition_cost(s_0, h, gr);
            if (cost != Integer.MAX_VALUE) {
                this.reachable.add(gr);
                // System.out.println("Adding:"+gr);
                frontier.add(new HeuristicSearchNode(gr, null, cost + 1, 0));
                it.remove();
            }
        }
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
                if (temp != null && temp != Integer.MAX_VALUE) {
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

    public boolean update_prop_numeric_h(Collection<HeuristicSearchNode> q, HashMap<GroundAction, HashSet<Conditions>> impr_conditions, HashMap<Conditions, Boolean> already_added, State s_0, LinkedHashSet<GroundAction> A1, Map<Conditions, Integer> h, HashSet<Comparison> toAdd, boolean to_post) throws Exception {
        boolean new_relevant_condition = false;
        for (HeuristicSearchNode node : q) {
            GroundAction gr = node.action;
//            System.out.println("Processing Action: "+gr.toEcoString());
            if (this.update_prop_h(node, h)) {
                new_relevant_condition = true;
            }
            //this computes the comparison achievable by this action. The idea is to perform this in a lazy fashion, just when the action is applicable
            // For future calls the improvable set will be ready without computation
            if (impr_conditions.get(gr) == null) {
                impr_conditions.put(gr, computeImprovable(node, s_0, influenced_by, max_depth, h, to_post));
            }
            // now take all the comparisons that can be achieved (at some point) by gr
            HashSet comparisons = impr_conditions.get(gr);
            if (comparisons != null && !comparisons.isEmpty()) {
                //HashSet toAdd = new HashSet(); //this set stores the regressed constraints that can be achieved by this action (whenever they are not achieved right now)
                Iterator it2 = comparisons.iterator();
                while (it2.hasNext()) {
                    Comparison c_1 = (Comparison) it2.next();
                    Comparison regr = gr.regressComparison((Comparison) c_1.clone());
//                    System.out.println("Processing Condition: "+regr);
                    regr.normalize();
//                    System.out.println("After Normalization: "+regr);
                    if (regr.isSatisfied(s_0)) {
                        h.put(regr, 0);
                        new_relevant_condition = true;
                    } else {
                        if (!regr.isUnsatisfiable()) {
                            new_relevant_condition = true;
                            if (already_added.get(regr) == null) {
                                toAdd.add(regr);
                                already_added.put(regr, Boolean.TRUE);
                            }
                        } else {
                            it2.remove();//the regression is unsatifiable using this operator!
                            continue;
                        }
                    }
                    if ((h.get(regr) != null && h.get(regr) != Integer.MAX_VALUE)) {
                        int cost_for_this_condition;
                        cost_for_this_condition = h.get(regr) + node.action_cost_to_get_here;

                        if (h.get(c_1) == null || h.get(c_1) > (cost_for_this_condition)) {
                            new_relevant_condition = true;
                            achievers.put(c_1, gr);
                            add_achievers.put(c_1, regr);
                            h.put(c_1, cost_for_this_condition);
                        }
                        it2.remove();
                    }
                }

                if (!impr_conditions.get(gr).isEmpty()) {
                    A1.add(gr);
                }
            }
        }
        return new_relevant_condition;
    }

    protected HashSet<Conditions> computeImprovable(HeuristicSearchNode node, State s_0, HashMap<GroundAction, HashSet<Conditions>> influenced_by, int k, Map<Conditions, Integer> h, boolean to_post) throws Exception {
        HashSet<Conditions> ret = new HashSet();
        if (influenced_by.get(node.action) == null) {
            return ret;
        }
        for (Conditions c_1 : influenced_by.get(node.action)) {
            Comparison comp = (Comparison) c_1;
            if (c_1.isSatisfied(s_0)) {
                this.internal_update = true;
                h.put(c_1, 0);
                this.achievers.put(c_1, node.action);
                continue;
            }
            Pair<Boolean, Integer> t = node.action.improve_k(s_0, comp, k, this.influence_graph, null);
            if (t.getFirst()) {
                if (!to_post) {
                    h.put(c_1, 0);
                    this.achievers.put(c_1, node.action);
                    this.internal_update = true;
                    continue;
                }
                ret.add(comp);
            } else if (!(t.getSecond() == 0)) {
                if (!to_post) {
                    h.put(c_1, 0);
                    this.achievers.put(c_1, node.action);
                    this.internal_update = true;
                    continue;
                }
                if (h.get(c_1) != null) {
                    if (h.get(c_1) > t.getSecond()) {
                        h.put(c_1, t.getSecond() + node.action_cost_to_get_here);
                        this.achievers.put(c_1, node.action);
                        this.internal_update = true;
                    }
                } else {
                    h.put(c_1, t.getSecond() + node.action_cost_to_get_here);
                    this.achievers.put(c_1, node.action);
                    this.internal_update = true;
                }
            }

        }

        return ret;
    }

    protected void update_definable_fluents() {

        for (GroundAction gr : this.reachable) {
            //action precondition
            if (gr.getPreconditions() != null) {
                getDef_num_fluents().addAll(gr.getPreconditions().getInvolvedFluents());
            }
            //action effects
            if (gr.getNumericEffects() != null) {
                getDef_num_fluents().addAll(gr.getNumericEffects().getInvolvedFluents());
            }
        }
    }

    /**
     * @return the def_num_fluents
     */
    public Set<NumFluent> getDef_num_fluents() {
        return def_num_fluents;
    }

    /**
     * @param def_num_fluents the def_num_fluents to set
     */
    public void setDef_num_fluents(Set<NumFluent> def_num_fluents) {
        this.def_num_fluents = def_num_fluents;
    }

    public HashMap<GroundAction, Boolean> get_rel_num_actions() {
        HashMap<GroundAction, Boolean> ret = new HashMap();
        for (GroundAction gr : this.reachable) {
            if (this.influenced_by.get(gr) != null && this.influenced_by.get(gr).size() > 0) {
                ret.put(gr, Boolean.TRUE);
            } else {
                ret.put(gr, Boolean.FALSE);
            }
        }

        return ret;
    }

    public boolean compute_transitive_closure(Collection<GroundAction> set) {
        ArrayList<GroundAction> set_as_array = new ArrayList(set);
        orderings = new LinkedHashSet();
        boolean ret = false;
        for (int i = 0; i < set_as_array.size(); i++) {
            for (int j = 0; j < set_as_array.size(); j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < set_as_array.size(); k++) {
                    if (k != j) {
                        if (set_as_array.get(j).depends_on(set_as_array.get(i))) {
                            Pair element = new Pair(set_as_array.get(i), set_as_array.get(j));
                            orderings.add(element);
                            if (set_as_array.get(k).depends_on(set_as_array.get(j))) {
                                if (k == i) {
                                    ret = true;
                                    //System.exit(-1);
                                }
                                Pair element2 = new Pair(set_as_array.get(i), set_as_array.get(k));
                                orderings.add(element2);
                            }
                        }
                        if (set_as_array.get(i).depends_on(set_as_array.get(j))) {
                            Pair element = new Pair(set_as_array.get(j), set_as_array.get(i));
                            orderings.add(element);
                            if (set_as_array.get(j).depends_on(set_as_array.get(k))) {
                                if (k == i) {
                                    ret = true;
                                    //System.exit(-1);
                                }

                                Pair element2 = new Pair(set_as_array.get(k), set_as_array.get(i));
                                orderings.add(element2);
                            }
                        }

                    }
                }

            }
        }
        return ret;
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
            if (temp != Integer.MAX_VALUE) {
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

    protected void init_h(ArrayList<Integer> h, Collection<Conditions> all_conditions, State s_0) {
        for (Conditions c_1 : all_conditions) {
            if (c_1.isSatisfied(s_0)) {
                h.set(c_1.getCounter(), 0);
            }
            if (debug >= 2) {
                System.out.println("Condition counter mapping:" + c_1 + " ," + c_1.getCounter());
            }
        }
    }
    //

    protected int check_goal_conditions(State s_0, Conditions G, ArrayList<Integer> h) {
        return this.compute_cost(s_0, h, G);
    }

    protected boolean update_value(ArrayList<Integer> h, Conditions c, int cost) {
        if (h.get(c.getCounter()) != null && h.get(c.getCounter()) <= cost) {
            return false;
        }
        h.set(c.getCounter(), cost);
        return true;
    }

    protected int interval_based_relaxation(State s_0, Conditions c, Collection<HeuristicSearchNode> pool) {
        RelState rel_state = s_0.relaxState();
        //LinkedList ordered_actions = sort_actions_pool_according_to_cost(pool);
        int cost = 0;
        float current_distance = rel_state.satisfaction_distance((Comparison) c);
        //this terminates correctly whenever the numeric dependency graph is acyclic
        LinkedList q = new LinkedList();
        while (true) {
            boolean stop = true;
            q = order_according_to_dependencies(pool, c);
            while (!q.isEmpty()) {
                HeuristicSearchNode gr = (HeuristicSearchNode) q.pollFirst();
                rel_state = gr.action.apply(rel_state);
                float new_dist = rel_state.satisfaction_distance((Comparison) c);
                //cost += gr.action_cost_to_get_here + 1;

                if (current_distance >= new_dist) {
                    cost += gr.action_cost_to_get_here + 1;
                    current_distance = new_dist;
                    stop = false;
                }
                if (rel_state.satisfy((Comparison) c)) {
                    return cost;
                }
            }
            if (stop) {
                return Integer.MAX_VALUE;
            }
        }
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
    protected int interval_based_relaxation_actions(State s_0, Conditions c, Collection<GroundAction> pool) {
        RelState rel_state = s_0.relaxState();
        //LinkedList ordered_actions = sort_actions_pool_according_to_cost(pool);
        int cost = 0;
        float current_distance = rel_state.satisfaction_distance((Comparison) c);
        //this terminates correctly whenever the numeric dependency graph is acyclic
        while (true) {
            boolean stop = true;
            LinkedList q = order_according_to_dependencies_actions(pool, c, null);
            while (!q.isEmpty()) {
                GroundAction gr = (GroundAction) q.pollFirst();
                rel_state = gr.apply(rel_state);
                float new_dist = rel_state.satisfaction_distance((Comparison) c);
                cost += 1;
                if (current_distance > new_dist) {
                    //cost += gr.action_cost_to_get_here + 1;
                    current_distance = new_dist;
                    stop = false;
                }
                if (rel_state.satisfy((Comparison) c)) {
                    return cost;
                }
            }
            if (stop) {
                return Integer.MAX_VALUE;
            }
        }
    }

    protected int interval_based_relaxation_actions_with_cost(State s_0, Conditions c, Collection<GroundAction> pool, HashMap<GroundAction, Integer> action_to_cost) throws CloneNotSupportedException {
        RelState rel_state = s_0.relaxState();
//        System.out.println(rel_state);
        //LinkedList ordered_actions = sort_actions_pool_according_to_cost(pool);
        int cost = 0;
//        float current_distance = rel_state.satisfaction_distance((Comparison) c);
        //this terminates correctly whenever the numeric dependency graph is acyclic
        Boolean reacheable = null;
        reacheable = compute_enclosure(pool, rel_state, (Comparison) c);
        if (reacheable != null && reacheable == false) {
            return Integer.MAX_VALUE;
        }
        HashMap<NumEffect, GroundAction> effects_to_actions = new HashMap();
        for (GroundAction gr : pool) {
            for (NumEffect nf : gr.getNumericEffectsAsCollection()) {
                effects_to_actions.put(nf, gr);
            }
            if (action_to_cost.get(gr) == null) {
                action_to_cost.put(gr, 0);
            }
        }

        Collection<NumFluent> interesting_fluents = c.getInvolvedFluents();
        int iteration = 0;
        ArrayList<HashSet<GroundAction>> relaxed_plan = new ArrayList();
//        System.out.println("h start");
        while (true) {
            LinkedList<NumEffect> q = new LinkedList(this.sorted_nodes);
            RelState rel_state_before = rel_state.clone();
            boolean stop = true;
            HashSet<GroundAction> action_for_phase = new LinkedHashSet();
            while (!q.isEmpty()) {
                NumEffect a = q.pollFirst();
                if (effects_to_actions.get(a) != null) {
                    GroundAction gr = effects_to_actions.get(a);
                    action_for_phase.add(gr);
                }
                a.apply(rel_state);
                if (a.internal_cycle()) {
                    a.apply(rel_state);
                    action_for_phase.add(effects_to_actions.get(a));
                }
//                float temp = rel_state.satisfaction_distance((Comparison) c);
//                while (temp < current_distance){
//                    current_distance = temp;
//                    a.apply(rel_state);
//                    action_for_phase.add(effects_to_actions.get(a));
//                    temp = rel_state.satisfaction_distance((Comparison) c);
//                }
                
                if (rel_state.satisfy((Comparison) c)) {
//                    System.out.println("Caccamo");
                    relaxed_plan.add(action_for_phase);
                    //int ret = compute_plan_cost(relaxed_plan, action_to_cost, s_0,(Comparison)c);
                    int ret = this.compute_plan_cost(relaxed_plan, action_to_cost);
                    if (ret == Integer.MAX_VALUE){
                        System.out.println("Something went wrong");
                    }
                    return ret;
                }
                if (any_change(rel_state_before, rel_state, interesting_fluents)) {
                    stop = false;
                }
                if (iteration > horizon) {
                    //System.out.println("Cut-off");
//                    System.out.println("Caccamo2");
//                    return 0;
                    return horizon;
//                    relaxed_plan.add(action_for_phase);
//                    return compute_plan_cost(relaxed_plan, action_to_cost, s_0,(Comparison)c);
                }
//                System.out.println(iteration);
            }
            iteration++;

            relaxed_plan.add(action_for_phase);
            if (stop) {
                System.out.println("STOPPP!");
                return Integer.MAX_VALUE;
            }
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
//                return Integer.MAX_VALUE;
//            }
//        }
    }

    protected void init_pool(Collection pool, Collection<GroundAction> A1, State s_0, ArrayList<Integer> h) {

        Iterator it = A1.iterator();
        while (it.hasNext()) {
            GroundAction gr = (GroundAction) it.next();
            if (this.compute_precondition_cost(s_0, h, gr) != Integer.MAX_VALUE) {
                gr.setAction_cost(s_0);
                pool.add(new HeuristicSearchNode(gr, null, 0, 0));
                it.remove();
            }
        }
    }

    protected LinkedList order_according_to_dependencies_actions(Collection<GroundAction> pool, Conditions c, HashMap<GroundAction, Integer> action_to_cost) {
        Comparison comp = (Comparison) c;
        LinkedList<GroundAction> pq = new LinkedList();
        LinkedList<GroundAction> ret = new LinkedList();
        for (GroundAction gr : pool) {
            for (NumFluent nf : comp.getInvolvedFluents()) {
                if (gr.influence(nf)) {
                    pq.add(gr);
                    //ret.addLast(node);
                }
            }
        }
        HashMap<GroundAction, Boolean> visited = new HashMap();
        while (!pq.isEmpty()) {
            GroundAction gr = pq.poll();
            ret.addFirst(gr);
            visited.put(gr, true);
            for (GroundAction node : pool) {
                GroundAction gr2 = node;
                if (action_to_cost != null && false) {
                    if (visited.get(gr2) == null && gr.depends_on(gr2) && !gr.equals(gr2) && action_to_cost.get(gr2) <= action_to_cost.get(gr)) {
                        pq.addLast(gr2);
                    }
                } else {
                    if (visited.get(gr2) == null && gr.depends_on(gr2) && !gr.equals(gr2)) {
                        pq.addLast(gr2);
                    }
                }
            }
        }
        return ret;
    }

    protected LinkedList sort_actions_pool_according_to_cost(HashSet<HeuristicSearchNode> pool) {
        LinkedList temp = new LinkedList(pool);
        if (cyclic_task) {
            return temp;
        }
        for (HeuristicSearchNode o : pool) {
            o.orderings = this.orderings;
        }
        Collections.sort(temp, new Comparator<HeuristicSearchNode>() {
            @Override
            public int compare(HeuristicSearchNode o1, HeuristicSearchNode o2) {
                if (o1.action.equals(o2.action)) {
                    return 0;
                }
                if (o1.orderings.contains(new Pair(o1.action, o2.action))) {
                    //System.out.println("found");
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        return temp;
    }

    protected boolean update_h(LinkedHashSet<GroundAction> pool, Collection<Conditions> conds, ArrayList<Integer> h, State s_0) {
        boolean update = false;
        for (Conditions c : conds) {
            if (h.get(c.getCounter()) != 0) {
                if (c instanceof Predicate) {
                    for (GroundAction gr : pool) {
                        if (gr.achieve((Predicate) c)) {
                            if (update_value(h, c, 1)) {
                                update = true;
                            }
                        }
                    }
                } else if (c instanceof Comparison) {
                    if (!this.is_complex.get(c)) {
                        for (GroundAction gr : pool) {
                            if (gr.getNumberOfExecution(s_0, (Comparison) c) != Integer.MAX_VALUE) {
                                if (update_value(h, c, 1)) {
                                    update = true;
                                }
                            }
                        }
                    } else {
                        if (interval_based_relaxation_actions(s_0, c, pool) != Integer.MAX_VALUE) {
                            if (update_value(h, c, 1)) {
                                update = true;
                            }
                        }
                    }
                }
            }
        }
        return update;
    }

    protected void update_pool(Collection<GroundAction> pool, LinkedHashSet<GroundAction> A, State s_0, ArrayList<Integer> h) {
        for (GroundAction gr : A) {
            if (this.compute_precondition_cost(s_0, h, gr) != Integer.MAX_VALUE) {
                pool.add(gr);
            }
        }
    }

    protected LinkedList order_according_to_dependencies(Collection<HeuristicSearchNode> pool, Conditions c) {
        Comparison comp = (Comparison) c;
        LinkedList<HeuristicSearchNode> pq = new LinkedList();
        LinkedList<HeuristicSearchNode> ret = new LinkedList();
        for (HeuristicSearchNode node : pool) {
            for (NumFluent nf : comp.getInvolvedFluents()) {
                if (node.action.influence(nf)) {
                    pq.add(node);
                    //ret.addLast(node);
                }
            }
        }
        HashMap<HeuristicSearchNode, Boolean> visited = new HashMap();
        while (!pq.isEmpty()) {
            HeuristicSearchNode gr = pq.poll();
            ret.addFirst(gr);
            visited.put(gr, true);
            for (HeuristicSearchNode node : pool) {
                HeuristicSearchNode gr2 = node;
                if (visited.get(gr2) == null && gr.action.depends_on(gr2.action) && !gr.action.equals(gr2.action)) {
                    pq.addLast(gr2);
                }
            }
        }
        return ret;
    }

    protected void update_pool(Collection<HeuristicSearchNode> pool, Collection<GroundAction> A1, State s_0, ArrayList<Integer> h) {
        //update action precondition
        for (HeuristicSearchNode gr : pool) {
            gr.action_cost_to_get_here = compute_precondition_cost(s_0, h, gr.action);
        }
        Iterator it = A1.iterator();
        while (it.hasNext()) {
            GroundAction gr = (GroundAction) it.next();
            int cost = compute_precondition_cost(s_0, h, gr);
            if (cost != Integer.MAX_VALUE) {
                gr.setAction_cost(s_0);
                pool.add(new HeuristicSearchNode(gr, null, cost, 0));
                it.remove();
            }
        }
    }

    protected void update_pool_reacheability(HashSet<HeuristicSearchNode> pool, LinkedHashSet<GroundAction> A1, State s_0, ArrayList<Integer> h) {
        Iterator it = A1.iterator();
        while (it.hasNext()) {
            GroundAction gr = (GroundAction) it.next();
            int cost = compute_precondition_cost(s_0, h, gr);
            if (cost != Integer.MAX_VALUE) {
                gr.setAction_cost(s_0);
                pool.add(new HeuristicSearchNode(gr, null, cost, 0));
                it.remove();
                this.reachable.add(gr);
            }
        }
    }

    protected void identify_complex_conditions(Collection<Conditions> conds, Collection<GroundAction> A) {
        //For each condition, identify whether there is at least an action whose effects are not simple. This condition
        // will be considered complex in that checking its satisfaction is hard
        is_complex = new HashMap();
        new_condition = new HashMap();
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

    protected int compute_additional_cost(int number_of_repetition, GroundAction gr, ArrayList<Integer> h) {
        int additional_cost = 0;
        if (this.rep_costs.get(gr) != null && number_of_repetition > 1) {
            LinkedHashSet<Pair<Pair<Comparison, Comparison>, Integer>> ret = this.rep_costs.get(gr);
            for (Pair<Pair<Comparison, Comparison>, Integer> p : ret) {
                int rpc = h.get(p.getFirst().getFirst().getCounter());
                //System.out.println("Counter here:"+p.getFirst().getCounter());
                if (number_of_repetition > p.getSecond()) {
                    if (rpc == Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
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
                if (h.get(p_del.getCounter()) == Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                additional_cost += h.get(p_del.getCounter()) * (number_of_repetition - 1);

                //additional_cost = Math.max(h.get(p_del.getCounter()) * (number_of_repetition - 1),additional_cost);
            }
        }
        return additional_cost;
    }

    private boolean any_change(RelState rel_state_before, RelState rel_state, Collection<NumFluent> interesting_fluents) {

        for (NumFluent nf : interesting_fluents) {
            if ((rel_state.functionInfValue(nf) != rel_state_before.functionInfValue(nf))
                    || (rel_state.functionSupValue(nf) != rel_state_before.functionSupValue(nf))) {
                return true;
            }

        }
        return false;

    }

    private Boolean compute_enclosure(Collection<GroundAction> pool, RelState rel_state, Comparison c) throws CloneNotSupportedException {
        Boolean ret = null;
        boolean cyclic = false;

        HashSet<NumEffect> num_effects = new LinkedHashSet();
        HashMap<NumEffect, Boolean> temp_mark = new HashMap();
        HashMap<NumEffect, Boolean> per_mark = new HashMap();
        for (GroundAction gr : pool) {
            for (NumEffect nf : gr.getNumericEffectsAsCollection()) {
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

//
//  Tarjan Algorithm    
//    L← Empty list that will contain the sorted nodes
//while there are unmarked nodes do
//    select an unmarked node n
//    visit(n) 
//function visit(node n)
//    if n has a temporary mark then stop (not a DAG)
//    if n is not marked (i.e. has not been visited yet) then
//        mark n temporarily
//        for each node m with an edge from n to m do
//            visit(m)
//        mark n permanently
//        unmark n temporarily
//        add n to head of L
    private int compute_plan_cost(ArrayList<HashSet<GroundAction>> relaxed_plan, HashMap<GroundAction, Integer> action_to_cost) {
        int cost = 0;
        HashMap<GroundAction, Boolean> already_considered = new HashMap();

//        while(true){
        for (HashSet<GroundAction> action_for_phase : relaxed_plan) {
            for (GroundAction gr : action_for_phase) {
//                if (already_considered.get(gr) == null) {
//                    already_considered.put(gr, true);
//                    cost += action_to_cost.get(gr) + 1;
//                }
                cost += action_to_cost.get(gr) + 1;
                //cost++;
            }
        }
//        }
        return cost;
    }

    private int compute_plan_cost(ArrayList<HashSet<GroundAction>> relaxed_plan, HashMap<GroundAction, Integer> action_to_cost, State s_0,Comparison goal) {
        try {
            int cost = 0;
            RelState rel_state = s_0.relaxState();
            ArrayList<GroundAction> plan = new ArrayList();
            for (HashSet<GroundAction> action_for_phase : relaxed_plan) {
                for (GroundAction gr : action_for_phase) {
                    plan.add(gr);
                }
            }
            ArrayList<Boolean> removed = new ArrayList<Boolean>(Collections.nCopies(plan.size(), false));
            int min = execute(plan, rel_state, removed,action_to_cost,goal,-1);
            if (no_plan_extraction)
                return min;
            while (true) {
                int to_remove = -1;
                for (int i = 0; i < plan.size(); i++) {
                    int temp = execute(plan, rel_state, removed,action_to_cost,goal,i);
                    if (temp < min){
                        min = temp;
                        to_remove = i;
//                        System.out.println(min);
                    }
                }
                if (to_remove != -1){
                    removed.set(to_remove, true);
                }else{
                    return min;
                }
                
            }
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(IntegerHeuristic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    private int execute(ArrayList<GroundAction> plan, RelState rel_state, ArrayList<Boolean> removed,HashMap<GroundAction, Integer> action_to_cost,Comparison goal,int cand) throws CloneNotSupportedException {
        int cost = 0;
        RelState temp = rel_state.clone();
//        System.out.println(rel_state);
        for (int i = 0; i < plan.size(); i++) {
            
//            if (removed.get(i) == false && i != cand) {
                temp = plan.get(i).apply(temp);
                cost+=action_to_cost.get(plan.get(i));
                cost++;
//                System.out.println("Applying:"+plan.get(i));
//            }

        }
//        System.out.println(rel_state);
//        System.out.println(goal);
        if (!temp.satisfy(goal)){
            //System.out.println("Unsatisfiable?!?!?!");
            return Integer.MAX_VALUE;
            
        }else{
            //System.out.println("OKKKK");
        }
        
        return cost;
    }

}

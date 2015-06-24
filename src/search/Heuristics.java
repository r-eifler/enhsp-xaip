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

import conditions.Comparison;
import conditions.Conditions;
import conditions.Predicate;
import expressions.NumFluent;
import extraUtils.Pair;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import problem.GroundAction;
import problem.State;

/**
 *
 * @author enrico
 */
public abstract class Heuristics {

    static public LinkedHashSet usefulActions = new LinkedHashSet();

    public LinkedHashSet<GroundAction> reachable;
    boolean additive_h = true;
    protected HashMap<GroundAction, HashSet<GroundAction>> influence_graph;
    public int max_depth;
    private int debug = 1;
    protected boolean internal_update;
    public LinkedHashSet<Predicate> reacheable_predicates;

    Collection<Conditions> all_conditions;
    HashMap<GroundAction, HashSet<Conditions>> influenced_by;

    public HashMap<Conditions, GroundAction> achievers;
    public HashMap<Comparison, Comparison> add_achievers;
    protected int number_of_actual_atoms;
    public LinkedHashSet<GroundAction> A;
    public Conditions G;
    private Set<NumFluent> def_num_fluents;

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

    public void setup(State s_0) {

        this.build_integer_representation();//for each proposition and comparison there is a unique integer representation
        influenced_by = computeInflueced_by();
        influence_graph = create_influence_graph();
        this.compute_relevant_actions(s_0);
        A = this.reachable;
        //this.build_integer_representation();//this could reduce the number of predicate/comparison but it has been considered useless overhead
    }

    public void build_integer_representation() {
        int counter2 = 0;
        ArrayList conditions = new ArrayList();
        for (GroundAction a : A) {

            LinkedHashSet temp = new LinkedHashSet();
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

        //System.out.println("Now action effects:");
        for (GroundAction a : A) {
            LinkedHashSet temp = new LinkedHashSet();

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
        number_of_actual_atoms = counter2 + 1;
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
        System.out.println("Starting Relevance Analysis....");
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
                Logger.getLogger(bottom_up_unit_cost.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        update_reacheable_predicates(h, s_0);
        update_definable_fluents();
        System.out.println("Finished Relevance Analysis; Cpu-Time:" + (System.currentTimeMillis() - start));
        return;
    }

    private void update_reacheable_predicates(HashMap<Conditions, Integer> h, State s_0) {
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

    private HashMap<GroundAction, HashSet<Conditions>> computeInflueced_by() {
        HashMap<GroundAction, HashSet<Conditions>> ret = new HashMap();

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

    private HashMap<GroundAction, HashSet<GroundAction>> create_influence_graph() {
        if (this.influence_graph != null) {
            return this.influence_graph;
        }
        HashMap<GroundAction, HashSet<GroundAction>> ret = new HashMap();

        for (GroundAction a : A) {
            for (GroundAction b : A) {
                if (!a.equals(b)) {
                    if (b.is_influenced_by(a)) {
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

    private void update_definable_fluents() {

        for (GroundAction gr : this.reachable) {
            //action precondition
            getDef_num_fluents().addAll(gr.getPreconditions().getInvolvedFluents());
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

}

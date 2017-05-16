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

import conditions.AndCond;
import conditions.Comparison;
import conditions.Conditions;
import conditions.Predicate;
import expressions.NumFluent;
import extraUtils.Utils;
import heuristics.Aibr;
import heuristics.Heuristic;
import heuristics.utils.LpInterface;
import heuristics.utils.cplex_interface;
import heuristics.utils.ojalgo_interface;
import ilog.concert.IloException;
import static java.lang.Float.MAX_VALUE;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collection;
import static java.util.Collections.nCopies;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jgrapht.util.FibonacciHeap;
import org.jgrapht.util.FibonacciHeapNode;
import problem.GroundAction;
import problem.State;

/**
 *
 * @author enrico
 */
public class quasi_hm extends Heuristic {

    protected HashMap<Integer, ArrayList<Conditions>> poss_achiever;
    private boolean reacheability_setting;
    protected ArrayList<Integer> dist;
    private boolean cplex = true;
    public HashMap<Integer, LpInterface> lps;
    private HashMap<Integer, Collection<GroundAction>> cond_to_actions;

    public quasi_hm(Conditions G, Set<GroundAction> A) {
        super(G, A);
    }

    /**
     *
     * @param goals
     * @param actions
     * @param processesSet
     */
    public quasi_hm(Conditions G, Set A, Set processesSet) {
        super(G, A, processesSet);

    }

    public quasi_hm(Conditions G, Set<GroundAction> A, Set processesSet, Conditions GC) {
        super(G, A, processesSet, GC);
    }

    @Override
    public Float setup(State s) {

        Aibr first_reachH = new Aibr(this.G, this.A);
        first_reachH.setup(s);
        first_reachH.set(true, true);
        Float ret = first_reachH.compute_estimate(s);
        if (ret == Float.MAX_VALUE) {
            return ret;
        }
        A = first_reachH.reachable;
        this.cond_to_actions = new HashMap();
        build_integer_representation();
        //identify_complex_conditions(all_conditions, A);
        generate_achievers(s);
        try {
            this.generate_linear_programs(A, s);
        } catch (IloException ex) {
            Logger.getLogger(quasi_hm.class.getName()).log(Level.SEVERE, null, ex);
        }
        reacheability_setting = true;
        Utils.dbg_print(debug, "Reachability Analysis Started");
        Float ret2 = compute_estimate(s);
        Utils.dbg_print(debug, "Reachability Analysis Terminated");
        reacheability_setting = false;
        sat_test_within_cost = false; //don't need to recheck precondition sat for each state. It is done in the beginning for every possible condition
        out.println("Hard Conditions: " + this.hard_conditions);
        out.println("Simple Conditions: " + (this.all_conditions.size() - this.hard_conditions));
        return ret2;
    }

    @Override
    public void build_integer_representation() {
        int counter2 = 0;
        all_conditions = new LinkedHashSet();
        int counter_actions = 0;
        G.setCounter(counter2++);
        all_conditions.add(G);
        this.integer_ref = new HashMap();
        ArrayList<GroundAction> actions_to_consider = new ArrayList(A);
        for (GroundAction a : actions_to_consider) {
            a.counter = counter_actions++;
//            if (a.getPreconditions() != null) {
            if (a.getPreconditions() != null && a.getPreconditions().sons != null && !a.getPreconditions().sons.isEmpty()) {
                counter2 = this.update_index_conditions(a.getPreconditions(), counter2);
                update_mapping(a.getPreconditions(), a);
            } else {//this creates a fake precondition for the action. It is needed to trigger the very first set of actions that can be applied
                a.setPreconditions(new AndCond());
                counter2 = this.update_index_conditions(a.getPreconditions(), counter2);
                update_mapping(a.getPreconditions(), a);
            }
//            }
        }

        this.gC.setCounter(counter2);
        //System.out.println(conditions);;

    }

    @Override
    public Float compute_estimate(State s) {
        //PriorityQueue<ConditionsNode> q = new PriorityQueue();
        if (s.satisfy(G)) {
            return 0f;
        }
        FibonacciHeap<Conditions> q = new FibonacciHeap();
//        if (this.reacheability_setting)
//            generate_lp(A,s);
//        else
//            generate_lp(this.reachable,s);
//        relaxed_plan_actions = new LinkedHashSet();
        //setting up the initial values
        ArrayList<Boolean> closed = new ArrayList<>(nCopies(all_conditions.size() + 1, false));
        ArrayList<Float> distance = new ArrayList<>(nCopies(all_conditions.size() + 1, MAX_VALUE));
        ArrayList<Boolean> open_list = new ArrayList<>(nCopies(all_conditions.size() + 1, false));
        HashMap<Integer, FibonacciHeapNode> cond_to_entry = new HashMap();
        for (Conditions c : all_conditions) {
            if (s.satisfy(c)) {
                FibonacciHeapNode node = new FibonacciHeapNode(c);
                q.insert(node, 0);
                cond_to_entry.put(c.getCounter(), node);
                distance.set(c.getCounter(), 0f);
                open_list.set(c.getCounter(), true);
                closed.set(c.getCounter(), true);
            } else {
                //lps.get(c.getCounter()).initialize(A, s);

                lps.get(c.getCounter()).update_conditions_bound_plus_reset_variables(s);

            }
        }

        reacheable_conditions = 0;
        final_achiever = new HashMap();

        ArrayList<Boolean> active_actions = new ArrayList<>(nCopies(A.size() + 1, false));
//        for (GroundAction gr: temp_a){
//            if (gr.isApplicable(s))
//                //active_actions.add(gr);
//        }
        Collection<Conditions> temp_conditions = null;
//        System.out.println(all_conditions.size());
        temp_conditions = new ArrayList();
        while (!q.isEmpty()) {
            //if (!first) {
//            System.out.println(++iteration);
            Float first = null;

//            System.out.println("New Iteration");
            while (!q.isEmpty()) {//take all the elements with equal distance from the initial state

                if (this.additive_h && !this.reacheability_setting) {
                    if (distance.get(G.getCounter()) != Float.MAX_VALUE) {
                        return distance.get(G.getCounter());
                    }
                }

                Conditions cn = q.removeMin().getData();
                if (distance.get(cn.getCounter()) == Float.MAX_VALUE) {
                    System.out.println("Anomaly!!!");//This shouldn't happen as only reachable conditions are put in the list
                    break;
                }
                if (first == null) {
                    first = distance.get(cn.getCounter());
                } else if (first < distance.get(cn.getCounter())) {//put back and stop
                    distance.set(cn.getCounter(), distance.get(cn.getCounter()));
                    open_list.set(cn.getCounter(), true);
                    FibonacciHeapNode node = new FibonacciHeapNode(cn);
                    q.insert(node, distance.get(cn.getCounter()));
                    cond_to_entry.put(cn.getCounter(), node);
                    first = null;

                    break;//exit from this inner loop and compute cost for new conditons that can be achieved
                    //looking at the active actions activated by this step.
                }

                closed.set(cn.getCounter(), true);//this is the best cost so far; no need to reopen this condition again

                if (cn.getCounter() == G.getCounter() && !this.reacheability_setting) {
                    if (distance.get(cn.getCounter()) == Float.MAX_VALUE) {
                        System.out.println("Anomaly");

                    }
                    return Math.max(distance.get(cn.getCounter()), 1f);
                }
                Collection<GroundAction> actions = this.cond_to_actions.get(cn.getCounter());
//                System.out.println("Action activated:"+gr);
                if (actions != null) {
                    for (GroundAction gr : actions) {
                        if (gr != null) {
                            //System.out.println("Action identified as reachable:"+gr);
                            active_actions.set(gr.counter, Boolean.TRUE);
                            if (this.reacheability_setting) {
                                this.reachable.add(gr);
                            }
                            temp_conditions.addAll(poss_achiever.get(gr.counter));

                        }
                    }
                }

            }

            for (Conditions cond : temp_conditions) {
//                System.out.println("Condition checking:"+cond);
//                System.out.println("Action that is connected:"+this.cond_action.get(cond.getCounter()));
                if (!closed.get(cond.getCounter())) {
//                    System.out.println("Condition under analysis:"+cond);
                    
                    Float current_cost = null;
                    current_cost = lps.get(cond.getCounter()).update_cost(s, active_actions, distance);
                    n_lp_invocations++;
                    if (current_cost != Float.MAX_VALUE) {
                        if (this.greedy && cond.getCounter() == G.getCounter() && !this.reacheability_setting) {
                            //System.out.println("Eary Exit");
                            return Math.max(current_cost, 1f);
                        }
                        update_cost_if_necessary(open_list, distance, cond, q, cond_to_entry, current_cost);
                    }
                } else {

                }

            }
        }

        //System.out.println("Current Estimate to the goal:"+this.compute_float_cost(s, G, dist));
//        System.out.println(distance.get(G.getCounter()));
//        System.exit(-1);
//        if (distance.get(G.getCounter())==Float.MAX_VALUE){
////            System.out.println("Dead-End in:"+s.pddlPrint());
//        }
//        System.out.println("Reachable actions:"+this.reachable);
        return Math.max(distance.get(G.getCounter()), 1f);
    }

    private void generate_achievers(State s_0) {
        poss_achiever = new HashMap();
        //this should also include the indirect dependencies, otherwise does not work!!
        for (GroundAction gr : this.A) {
            poss_achiever.put(gr.counter, new ArrayList());
            for (Conditions c : this.all_conditions) {
                if (gr.getPreconditions().getCounter() != c.getCounter()) {
                    for (Conditions c_in : (Collection<Conditions>) c.sons) {
                        if (c_in instanceof Comparison) {
                            for (NumFluent nf : gr.getNumericFluentAffected().keySet()) {
                                if (c_in.getInvolvedFluents().contains(nf)) {
                                    poss_achiever.get(gr.counter).add(c);
                                    break;
                                }
                            }
//                            if (gr.getNumberOfExecution(s_0, (Comparison) c_in)!= Float.MAX_VALUE) {
//                                poss_achiever.get(gr.counter).add(c);
//                                break;
//                            }
                        } else if (c_in instanceof Predicate) {
                            if (gr.achieve((Predicate) c_in)) {
                                poss_achiever.get(gr.counter).add(c);
                                break;
                            }
                        }
                    }
                }

            }
        }
    }

    private void update_cost_if_necessary(ArrayList<Boolean> open_list, ArrayList<Float> dist, Conditions p, FibonacciHeap<Conditions> q, HashMap<Integer, FibonacciHeapNode> cond_to_entry, Float current_cost) {
        if (current_cost == Float.MAX_VALUE) {
            return;
        }
        if (open_list.get(p.getCounter())) {
            if (dist.get(p.getCounter()) > current_cost) {
                q.decreaseKey(cond_to_entry.get(p.getCounter()), current_cost);
                dist.set(p.getCounter(), current_cost);
            }
        } else {
            dist.set(p.getCounter(), current_cost);
            open_list.set(p.getCounter(), true);
            FibonacciHeapNode node = new FibonacciHeapNode(p);
            q.insert(node, current_cost);
            cond_to_entry.put(p.getCounter(), node);
            reacheable_conditions++;
        }
    }

    private void generate_linear_programs(Collection<GroundAction> actions, State s_0) throws IloException {
        lps = new HashMap();
        for (Conditions c : all_conditions) {
            LpInterface lp = null;
            if (cplex) {
//                System.out.println("DEBUG: Using CPLEX");
                lp = new cplex_interface(c, this.gC);
            } else {
//                System.out.println("DEBUG: Using OJALGO");

                lp = new ojalgo_interface(c, this.gC);
            }
            lp.additive_h = this.additive_h;
            lp.initialize(actions, s_0);
            lps.put(c.getCounter(), lp);
        }
    }

    private void update_mapping(Conditions preconditions, GroundAction a) {
        if (this.cond_to_actions.get(preconditions.getCounter()) == null) {
            LinkedHashSet actions = new LinkedHashSet();
            actions.add(a);
            this.cond_to_actions.put(preconditions.getCounter(), actions);
        } else {
            Collection actions = this.cond_to_actions.get(preconditions.getCounter());
            actions.add(a);
            this.cond_to_actions.put(preconditions.getCounter(), actions);

        }
    }

}
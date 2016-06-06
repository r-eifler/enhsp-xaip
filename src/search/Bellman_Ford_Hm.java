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

import com.microsoft.z3.Optimize;
import com.microsoft.z3.*;

import conditions.Comparison;
import conditions.Conditions;
import conditions.Predicate;
import expressions.ExtendedAddendum;
import expressions.ExtendedNormExpression;
import expressions.NumEffect;
import extraUtils.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import problem.GroundAction;
import problem.State;
//import gurobi.*;

/**
 *
 * @author enrico
 */
public class Bellman_Ford_Hm extends Heuristics {

    private boolean greedy;
    protected boolean full_regression = false;
    protected HashMap<Conditions, Boolean> redundant_constraints;
    protected HashMap<Pair<GroundAction, Comparison>, Boolean> num_achiever;

    protected HashMap<Pair<Conditions, GroundAction>, Boolean> achvs;
    private Conditions G;
    private LinkedHashSet<GroundAction> A;
    private int complex_conditions;
    private LinkedHashSet<Conditions> all_conditions;
    private boolean reachability;

    public Bellman_Ford_Hm(Conditions G, Set<GroundAction> A) {
        super(G, A);
        greedy = false;
        this.G = G;
        this.A = (LinkedHashSet<GroundAction>) A;
        complex_conditions = 0;

        //System.out.println(this.orderings);
        //build_integer_representation();
    }
    
    public Bellman_Ford_Hm(Conditions G, Set<GroundAction> A,Set processesSet, Conditions GC) {
        super(G, A,processesSet,GC);
        greedy = false;
        this.G = G;
        this.A = (LinkedHashSet<GroundAction>) A;
        complex_conditions = 0;

        //System.out.println(this.orderings);
        //build_integer_representation();
    }

    @Override
    public Float setup(State s_0) {
        all_conditions = new LinkedHashSet();
        this.build_integer_representation();

        //System.out.println(achvs);
        System.out.println("Achievers generated");
        System.out.println("Easy Conditions: " + (this.all_conditions.size() - complex_conditions));
        System.out.println("Hard Conditions: " + complex_conditions);
        reachability = true;
        Float first_est =compute_estimate(s_0);
        reachability = false;
        A = this.reachable;
        all_conditions = new LinkedHashSet();
        this.build_integer_representation();
        return first_est;
    }
    
    protected void init_h(ArrayList<Float> h,  State s_0) {
        for (Conditions c_1 : all_conditions) {
            if (c_1.isSatisfied(s_0)) {
//                System.out.println(c_1);
                h.set(c_1.getCounter(), 0f);
            }else{
//                System.out.println("No:"+c_1);
            }
            if (debug >= 2) {
                System.out.println("Condition counter mapping:" + c_1 + " ," + c_1.getCounter());
            }
        }
    }

    @Override
    public Float compute_estimate(State s_0) {
        if (s_0.satisfy(G)) {
            return 0f;
        }
        ArrayList<Float> h = new ArrayList<>(Collections.nCopies(all_conditions.size() + 1, Float.MAX_VALUE));
        this.init_h(h, s_0);
        Collection<GroundAction> A_temp = new LinkedHashSet(A);
        Collection<GroundAction> pool = new LinkedHashSet();
        init_actions(pool, A_temp, s_0, h);
        boolean update;
        int iteration = 0;
        do {
            iteration++;
            update = this.update_conditions_values(pool, s_0, all_conditions, h);
            if (update) {
                this.update_pool(pool, A_temp, s_0, h);
            }
            System.out.println(iteration);
        } while (update);
        return h.get(G.getCounter());

    }

    protected boolean update_conditions_values(Collection<GroundAction> pool, State s_0, Collection<Conditions> all_conditions, ArrayList<Float> h) {
        boolean update = false;
        for (Conditions c : this.all_conditions) {
            if (h.get(c.getCounter()) != 0f ) {
                float current = compute_current_cost2(pool, s_0, c, h);
//                if (current == 0)
                    //System.out.println("Anomaly:"+c);
//                System.out.println("Updating!");
                if (current < h.get(c.getCounter())) {
                    h.set(c.getCounter(), current);
                    update = true;
                }
            }else{
                
            }
        }
        return update;
    }

    @Override
    protected void update_pool(Collection<GroundAction> pool, Collection<GroundAction> A1, State s_0, ArrayList<Float> h) {
        //update action precondition
        
        for (GroundAction gr : A1) {         
            if (gr.getPreconditions()==null || gr.getPreconditions().sons.isEmpty() || h.get(gr.getPreconditions().getCounter())!=Float.MAX_VALUE){
                pool.add(gr);
                if (this.reachability) this.reachable.add(gr);
                //it.remove();
            }
        }
    }
    
    
    @Override
    public void build_integer_representation() {
        int counter2 = 0;

        int counter_actions = 0;
        ArrayList conditions = new ArrayList();
        ArrayList<GroundAction> actions_to_consider = new ArrayList(A);
        for (GroundAction a : actions_to_consider) {
            if (a.getPreconditions() != null) {

                if (a.getPreconditions() != null && a.getPreconditions().sons != null) {
                    a.getPreconditions().setCounter(counter2++);
                    all_conditions.add(a.getPreconditions());
                }
            }
        }

        G.setCounter(counter2);
        all_conditions.add(G);
        //System.out.println(conditions);;

    }


    private void init_actions(Collection<GroundAction> pool, Collection<GroundAction> A_temp, State s_0, ArrayList<Float> h) {
        A_temp.stream().filter((gr) -> (h.get(gr.getPreconditions().getCounter()) != Float.MAX_VALUE)).forEach((gr) -> {
            pool.add(gr);
            if (reachability) this.reachable.add(gr);
        });
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heuristics.utils;

import conditions.AndCond;
import conditions.Conditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import problem.GroundAction;
import problem.State;

/**
 *
 * @author enrico
 */
public abstract class LpInterface {

    public int n_invocations;
    public boolean integer_variables;
    public boolean additive_h;
    public Conditions gc;
    public Conditions c;

    //this is for set of conditions
    public LpInterface(Set<Conditions> cond, Conditions global_constraint) {
        super();
        AndCond c = new AndCond();
        c.sons.addAll(cond);
    }

    public LpInterface(Conditions cond, Conditions global_constraint) {
        super();
        c = cond;
        gc = global_constraint;
    }

    public abstract void initialize(Collection<GroundAction> actions, State s_0);

    public abstract void update_conditions_bound_plus_reset_variables(State s_0);

    protected abstract void update_local_global_conditions(State s_0);

    public abstract float update_cost(State s_0, ArrayList<Boolean> active_actions, ArrayList<Float> h);

    protected abstract void init_condition(Collection<GroundAction> pool, State s_0);

    protected abstract void update_condition(State s_0, Conditions temp);

}

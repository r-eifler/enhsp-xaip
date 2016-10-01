/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heuristics.advanced;

import conditions.Comparison;
import conditions.Conditions;
import conditions.Predicate;
import expressions.ExtendedAddendum;
import expressions.ExtendedNormExpression;
import expressions.NumEffect;
import expressions.PDDLNumber;
import java.util.ArrayList;
import java.util.Collection;
import static java.util.Collections.nCopies;
import java.util.HashMap;
import java.util.LinkedHashSet;
import org.ojalgo.optimisation.Expression;
import org.ojalgo.optimisation.ExpressionsBasedModel;
import org.ojalgo.optimisation.Optimisation;
import org.ojalgo.optimisation.Variable;
import problem.GroundAction;
import problem.State;

/**
 *
 * @author enrico
 */
public class lp_interface {

    public int n_invocations;
    public boolean integer_variables;
    public boolean additive_h;
    private boolean no_further_reasoning = true;
    public HashMap<Integer, Collection<GroundAction>> affectors_of;
    public HashMap<Integer, ExpressionsBasedModel> cond_lp_formulation;
    public HashMap<Conditions,Collection<GroundAction>> pos_affectors_of;
    public Conditions gc;
    public HashMap<Integer, Variable> action_to_variable;
    public HashMap<Integer,HashMap<Integer,Integer>> cond_to_lp_variables;
    public ArrayList<Boolean> first_time;

    public lp_interface() {
        super();
        n_invocations = 0;
        integer_variables = false;
        additive_h = false;
        this.affectors_of = new HashMap();
        pos_affectors_of = new HashMap();
    }

    public void initialize(Collection<GroundAction> actions, State s_0, Collection<Conditions> all_conds, Conditions global_constraint) {
        gc = global_constraint;
        this.cond_lp_formulation = new HashMap();
        cond_to_lp_variables  = new HashMap();
        first_time = new ArrayList<>(nCopies(all_conds.size() + 1, true));
        for (Conditions c : all_conds) {
            //first_time.set(c.getCounter(),true);
            this.cond_lp_formulation.put(c.getCounter(), this.init_condition(actions, s_0, c, gc));
        }
        
    }

    public boolean update_all_conditions(State s_0, Collection<Conditions> conds) {
        boolean ret = true;
        for (Conditions c : conds) {
            ret = ret && this.update_eval_condition(s_0, c);
        }
        return ret;
        //this.update_eval_condition(s_0, gc);
    }

    private boolean update_eval_condition(State s_0, Conditions c) {

        ExpressionsBasedModel lp = this.cond_lp_formulation.get(c.getCounter());
        boolean ret = update_condition(s_0,lp,c);
        
        if (this.gc != null){
            ret = ret && update_condition(s_0,lp,gc);
        }

        return ret;
    }

    public float update_cost(State s_0,ArrayList<Boolean> active_actions, Conditions c, ArrayList<Float> h) {

        ExpressionsBasedModel lp = this.cond_lp_formulation.get(c.getCounter());
        HashMap<Integer,Integer> action_to_var = this.cond_to_lp_variables.get(c.getCounter());
        Collection<GroundAction> affectors = this.affectors_of.get(c.getCounter());
        for (GroundAction gr : affectors) {
            if (active_actions.get(gr.counter)) {
                Variable v = lp.getVariable(action_to_var.get(gr.counter));
                v.upper(Integer.MAX_VALUE).lower(0); 
//                System.out.println("DEBUG:"+lp.indexOf(v));
//                Variable v1 = lp.getVariable(lp.indexOf(v));
//                v1.upper(Integer.MAX_VALUE);
            }
        }
        
        Float precondition_contribution = Float.MAX_VALUE;
        if (this.additive_h)
            precondition_contribution = 0f;
        for (Conditions c_0 : (Collection<Conditions>) c.sons) {
                Float local_min = Float.MAX_VALUE;
                if (s_0.satisfy(c_0)){
                    if (!this.additive_h){
                        precondition_contribution = 0f;
                        break;
                    }
                    local_min = 0f;
                }else{
                    for (GroundAction gr: this.pos_affectors_of.get(c_0)){
                        local_min = Math.min(h.get(gr.getPreconditions().getCounter()),local_min);
                    }
                }
                if (this.additive_h)
                    precondition_contribution+=local_min;
                else
                    precondition_contribution = Math.min(precondition_contribution,local_min);
        }
        //this.
        n_invocations++;
        
        
        
        Optimisation.Result tmpResult = lp.minimise();
//        if (first_time.get(c.getCounter())){
//            tmpResult = lp.minimise();
//            first_time.set(c.getCounter(), false);
//        }else
//            tmpResult = lp.solve(lp.getVariableValues());
        if (tmpResult.getState().isFeasible()) {
            return (float)tmpResult.getValue()+precondition_contribution;            
//            return ret;
        }

        return Float.MAX_VALUE;
    }

    protected ExpressionsBasedModel init_condition(Collection<GroundAction> pool, State s_0, Conditions c, Conditions gC) {

        final ExpressionsBasedModel lp = new ExpressionsBasedModel();

        
        action_to_variable = new HashMap();
        cond_to_lp_variables.put(c.getCounter(),new HashMap());
        Collection<Conditions> conditions_to_evaluate = new LinkedHashSet();
        conditions_to_evaluate.addAll(c.sons);
        if (gC != null) {
//            System.out.println("considering Global Constraints:"+gC.sons);
            conditions_to_evaluate.addAll(gC.sons);
        }
        this.affectors_of.put(c.getCounter(), new LinkedHashSet());

        for (Conditions cond : conditions_to_evaluate) {
            Expression condition = null;
            condition = lp.addExpression(cond.toString());
            pos_affectors_of.put(cond,new LinkedHashSet());
            if (cond instanceof Comparison) {
                Comparison comp = (Comparison) cond;
//                Float eval = comp.getLeft().eval(s_0).getNumber();
//
//                if (comp.getComparator().equals(">") || comp.getComparator().equals(">=")) {
//                    condition.lower(-eval);
//                } else {
//                    condition.lower(eval);
//                }
                ExtendedNormExpression left = (ExtendedNormExpression) comp.getLeft();
                for (ExtendedAddendum ad : left.summations) {
                    if (ad.f != null) {
                        for (GroundAction gr : pool) {
//                                                        System.out.println(gr);

                            if (gr.getNumericFluentAffected().get(ad.f) != null && gr.getNumericFluentAffected().get(ad.f).equals(Boolean.TRUE)) {
                                for (NumEffect neff : gr.getNumericEffectsAsCollection()) {
                                    if (!neff.getFluentAffected().equals(ad.f)) {
                                        continue;
                                    }
                                    //                                    System.out.println(neff);
                                    
                                    gr.setAction_cost(s_0);
                                    Float action_cost = gr.getAction_cost();
                                    if (action_cost.isNaN()) {
                                        continue;
                                    }
                                    affectors_of.get(c.getCounter()).add(gr);//add the actions to the affectors list

                                    final Variable action;
                                    if (action_to_variable.get(gr.counter) != null) {
                                        action = action_to_variable.get(gr.counter);
                                        if (integer_variables) {
                                            action.integer(true);
                                        }
                                    } else {
                                        action = Variable.make(gr.toEcoString()).lower(0).upper(0).weight(action_cost);
                                        this.cond_to_lp_variables.get(c.getCounter()).put(gr.counter, lp.countVariables());              
                                        lp.addVariable(action);
                                        action_to_variable.put(gr.counter, action);
                                    }

//                                    Float cost_of_prec = h.get(gr.getPreconditions().getCounter()) * 10.0F;
                                    //opt.Add(ctx.mkImplies(ctx.mkGt(var, ctx.mkInt(0)), ctx.mkEq(prec_cost, ctx.mkReal(cost_of_prec.intValue(), 10))));
                                    //opt.Add(ctx.mkImplies(ctx.mkEq(var, ctx.mkInt(0)), ctx.mkEq(prec_cost, ctx.mkReal(0))));
                                    Float right = null;
                                    switch (neff.getOperator()) {
                                        case "increase":
                                            right = neff.getRight().eval(s_0).getNumber() * ad.n.getNumber();
                                            right = condition.get(action).floatValue() + right;
                                            condition = condition.set(action, right);

//                                            System.out.println("DEBUG:"+condition);
                                            break;
                                        case "decrease":
                                            right = neff.getRight().eval(s_0).getNumber() * ad.n.getNumber();
                                            right = condition.get(action).floatValue() - right;
                                            condition = condition.set(action, right);

                                            break;
                                        case "assign":
                                            continue;
                                    }
//                                    System.out.println("DEBUG:"+condition+" right:"+right);

                                }
                            }
                            if  (gr.getNumberOfExecution(s_0, comp)!= Float.MAX_VALUE){
                               pos_affectors_of.get(comp).add(gr);
                            }
                        }
                    }
                }

//                System.out.println(condition);
            } else if (cond instanceof Predicate) {
                if (!cond.isSatisfied(s_0)) {
                    condition.lower(1);
                    Predicate p = (Predicate) cond;
                    for (GroundAction gr : pool) {
                        if (gr.achieve(p)) {
                            pos_affectors_of.get(cond).add(gr);
                            affectors_of.get(c.getCounter()).add(gr);//add the actions to the affectors list
                            gr.setAction_cost(s_0);
                            Float action_cost = gr.getAction_cost();
                            if (action_cost.isNaN()) {
                                continue;
                            }
                            final Variable action;
                            if (action_to_variable.get(gr.counter) != null) {
                                action = action_to_variable.get(gr.counter);
                            } else {
                                action = Variable.make(gr.toEcoString()).lower(0).upper(0).weight(action_cost);
                                this.cond_to_lp_variables.get(c.getCounter()).put(gr.counter, lp.countVariables());
                                lp.addVariable(action);
                                action_to_variable.put(gr.counter, action);
                                if (integer_variables) {
                                    action.integer(true);
                                }
                            }
                            condition.set(action, 1);
                        }
                    }
                }
            }

        }

        lp.setMinimisation();
//        System.out.println("DEBUG: Condition: " + c + " LP Created:" + lp + " LP Obj function:" + lp.getObjectiveExpression());
        return lp;

    }

    private boolean update_condition(State s_0, ExpressionsBasedModel lp, Conditions c) {
        for (Conditions c_0 : (Collection<Conditions>) c.sons) {
            Expression lp_cond = lp.getExpression(c_0.toString());
            if (c_0 instanceof Comparison) {
                Comparison comp = (Comparison) c_0;
                PDDLNumber eval = comp.getLeft().eval(s_0);
                //if (eval== null)
                    //return false;
//                System.out.println("DEBUG: expression before:" + lp.getExpression(lp_cond.getName()));
                if (comp.getComparator().equals(">") || comp.getComparator().equals(">=")) {
                    lp_cond.lower(-eval.getNumber());
                } else {
                    lp_cond.lower(eval.getNumber());
                }
//                System.out.println("DEBUG: expression after:" + lp.getExpression(lp_cond.getName()));

            }
        }
        return true;

              

    }

}

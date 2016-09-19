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
import java.util.ArrayList;
import java.util.Collection;
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

    public lp_interface() {
        super();
        n_invocations = 0;
        integer_variables = false;
        additive_h = false;
    }

    protected float compute_current_cost_via_lp(Collection<GroundAction> pool, State s_0, Conditions c, ArrayList<Float> h, Conditions gC) {

        n_invocations = n_invocations + 1;
//        System.out.println(invocation);
        if (c == null || c.sons == null || c.sons.isEmpty()) {
            return 0.0F;
        }

        float smallest_achiever_cost = Float.MAX_VALUE;
        final ExpressionsBasedModel tmpModel = new ExpressionsBasedModel();
//        ExpressionsBasedModel.addIntegration(oSlverCPLEX.INTEGRATION);

        Collection<Float> minimi = new LinkedHashSet();
        HashMap<Integer, Variable> action_to_variable = new HashMap();
        
        HashMap<Integer,Float> condition_to_minimum_precondition_cost = new HashMap();

        Collection<Conditions> conditions_to_evaluate = new LinkedHashSet();
        conditions_to_evaluate.addAll(c.sons);
        if (gC != null) {
//            System.out.println("considering Global Constraints:"+gC.sons);
            conditions_to_evaluate.addAll(gC.sons);
        }
        for (Conditions cond : conditions_to_evaluate) {
            Float local_minimum = Float.MAX_VALUE;
            condition_to_minimum_precondition_cost.put(cond.getCounter(),Float.MAX_VALUE);
            if (!cond.isSatisfied(s_0)) {
                condition_to_minimum_precondition_cost.put(cond.getCounter(),Float.MAX_VALUE);
            }else{
                condition_to_minimum_precondition_cost.put(cond.getCounter(),0f);
            }
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

                                    final Variable action;
                                    if (action_to_variable.get(gr.counter) != null) {
                                        action = action_to_variable.get(gr.counter);
                                        if (integer_variables) {
                                            action.integer(true);
                                        }
                                    } else {
                                        action = Variable.make(gr.toEcoString()).lower(0).weight(action_cost);
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
                                            at_least_one = true;
                                            local_minimum = Math.min(local_minimum, h.get(gr.getPreconditions().getCounter()+1));
                                            //this is an assign
//                                            right = neff.getRight().eval(s_0).getNumber() * ad.n.getNumber();
//                                            right = condition.get(action).floatValue() - right;
//                                            condition = condition.set(action, right - ad.f.eval(s_0).getNumber());
//                                            action.upper(1);
//                                            System.out.println("Assign not supported");
                                            continue;
//                                            break;
                                    }

//                                    local_minimum = Math.min(local_minimum, h.get(gr.getPreconditions().getCounter()));
//                                    System.out.println("Action"+gr+" Cost:"+h.get(gr.getPreconditions().getCounter()));
//                                    System.out.println("Condition " +c);
                                    if ((comp.getComparator().contains(">") && right < 0)
                                            || (comp.getComparator().contains("<") && right > 0)) {
                                        at_least_one = true;
                                        local_minimum = Math.min(local_minimum, h.get(gr.getPreconditions().getCounter()));
                                        smallest_achiever_cost = Math.min(smallest_achiever_cost, action_cost * gr.getNumberOfExecutionInt(s_0, comp));
                                        //this is the only action that can be used.
                                        Float min_so_far = condition_to_minimum_precondition_cost.get(comp.getCounter());
                                        condition_to_minimum_precondition_cost.put(comp.getCounter(),Math.min(min_so_far, h.get(gr.getPreconditions().getCounter())));
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
                if (at_least_one && !cond.isSatisfied(s_0)) {
                    minimi.add(local_minimum);
                }

//                System.out.println(condition);
            } else if (cond instanceof Predicate) {
                if (!cond.isSatisfied(s_0)) {
                    boolean at_least_one = false;
                    Predicate p = (Predicate) cond;
                    Expression condition = tmpModel.addExpression(((Predicate) cond).toString()).lower(1);

                    for (GroundAction gr : pool) {
                        if (gr.achieve(p)) {
                            gr.setAction_cost(s_0);
                            Float action_cost = gr.getAction_cost();
                            if (action_cost.isNaN()) {
                                continue;
                            }
                            at_least_one = true;
                            final Variable action;
                            if (action_to_variable.get(gr.counter) != null) {
                                action = action_to_variable.get(gr.counter);
                            } else {
                                action = Variable.make(gr.toEcoString()).lower(0).weight(action_cost);
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
                            smallest_achiever_cost = Math.min(smallest_achiever_cost, action_cost);
                            if (local_minimum == Float.MAX_VALUE) {//should never be true: debugging
                                System.out.println("Problem with:" + gr);
                            }
                            Float min_so_far = condition_to_minimum_precondition_cost.get(cond.getCounter());

                            condition_to_minimum_precondition_cost.put(cond.getCounter(),Math.min(min_so_far, h.get(gr.getPreconditions().getCounter())));

                        }
                    }
                    if (!at_least_one) {
                        return Float.MAX_VALUE;
                    }
                    if (!cond.isSatisfied(s_0)) {
                        minimi.add(local_minimum);
                    }
                }

            } else {
                
            }

        }

        Optimisation.Result tmpResult = tmpModel.minimise();

        if (tmpResult.getState().isFeasible()) {

            float objective = (float) tmpResult.getValue();
//            System.out.println("DEBUG: Current Objective");
            if (this.additive_h) {
//                System.out.println("Additive version");
                for (Float local_min : minimi) {
                    objective+= local_min;
                }

//                for (Integer index_cond : condition_to_minimum_precondition_cost.keySet()) {
//                    objective += condition_to_minimum_precondition_cost.get(index_cond);//very additive
//                    
//                    //max_over_precondition_costs = Math.max(local_min, minimum_precondition_cost);// less additive but still inadmissible..  
//                }
            } else {
                Float minimum_precondition_cost = Float.MAX_VALUE;

                if (no_further_reasoning) {
                    for (Float local_min : minimi) {
                        minimum_precondition_cost = Math.min(local_min, minimum_precondition_cost);
                    }
                    return (objective + minimum_precondition_cost);
                }
                Float max_over_precondition_costs = 0f;
                for (Float local_min : minimi) {
                    minimum_precondition_cost = Math.min(local_min, minimum_precondition_cost);
                    max_over_precondition_costs = Math.max(local_min, minimum_precondition_cost);
                }
                if (minimi.isEmpty()) {
                    minimum_precondition_cost = 0f;
                }

                objective = Math.max(objective + minimum_precondition_cost, max_over_precondition_costs + smallest_achiever_cost);
            }
//            System.out.println("Condition under evaluation:"+c);local_minimum
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
            return objective;
//            return (float) (tmpResult.getValue() + minimum_precondition_cost);

        } else {
            //            System.out.println(opt.toString());
            return Float.MAX_VALUE;
        }
        //        System.out.println(opt.Check());
    }

//    protected float compute_current_cost_via_lp_cplex(Collection<GroundAction> pool, State s_0, Conditions c, ArrayList<Float> h, Conditions gC) {
//        invocation = invocation + 1;
//
//        try {
//            if (c == null || c.sons == null || c.sons.isEmpty()) {
//                return 0.0F;
//            }
//
//            IloCplex cplex = new IloCplex();
//            cplex.setOut(null);
//
//            IloNumVar[][] var = new IloNumVar[1][];
//            IloRange[][] rng = new IloRange[1][];
//
//            Collection<Conditions> conditions_to_evaluate = new LinkedHashSet();
//            conditions_to_evaluate.addAll(c.sons);
//            HashMap<Integer, IloNumVar> action_to_variable = new HashMap();
//
//            if (gC != null) {
////            System.out.println("considering Global Constraints:"+gC.sons);
//                conditions_to_evaluate.addAll(gC.sons);
//            }
//            IloNumExpr obj = cplex.numExpr();
//            for (Conditions cond : conditions_to_evaluate) {
//                if (cond instanceof Comparison) {
//                    Comparison comp = (Comparison) cond;
//                    ExtendedNormExpression left = (ExtendedNormExpression) comp.getLeft();
//                    boolean at_least_one = false;
//                    Float num = comp.getLeft().eval(s_0).getNumber();
//                    IloNumExpr condition = cplex.numExpr();
//
//                    for (ExtendedAddendum ad : left.summations) {
//                        if (ad.f != null) {
//                            for (GroundAction gr : pool) {
//                                if (gr.getNumericFluentAffected().get(ad.f) != null && gr.getNumericFluentAffected().get(ad.f).equals(Boolean.TRUE)) {
//                                    for (NumEffect neff : gr.getNumericEffectsAsCollection()) {
//                                        if (!neff.getFluentAffected().equals(ad.f)) {
//                                            continue;
//                                        }
//                                        //                                    System.out.println(neff);
//                                        gr.setAction_cost(s_0);
//                                        Float cost_action = gr.getAction_cost();
//                                        if (cost_action.isNaN()) {
//                                            continue;
//                                        }
//                                        cplex.numVar(0, Float.MAX_VALUE);
//
//                                        IloNumVar action;
//                                        if (action_to_variable.get(gr.counter) != null) {
//                                            action = action_to_variable.get(gr.counter);
//                                        } else {
//                                            action = cplex.numVar(0, Float.MAX_VALUE);
//                                            action_to_variable.put(gr.counter, action);
//                                            obj = cplex.sum(obj, action);
//
//                                        }
////                                        System.out.println("ACtion under consideration"+gr.toPDDL());
////                                        System.out.println("Action:"+action);
////                                        System.out.println("Obj before:"+obj);
////                                        System.out.println("Obj after:"+obj);
//
////                                    Float cost_of_prec = h.get(gr.getPreconditions().getCounter()) * 10.0F;
////opt.Add(ctx.mkImplies(ctx.mkGt(var, ctx.mkInt(0)), ctx.mkEq(prec_cost, ctx.mkReal(cost_of_prec.intValue(), 10))));
////opt.Add(ctx.mkImplies(ctx.mkEq(var, ctx.mkInt(0)), ctx.mkEq(prec_cost, ctx.mkReal(0))));
//                                        Float right = null;
//
//                                        switch (neff.getOperator()) {
//                                            case "increase":
//                                                right = neff.getRight().eval(s_0).getNumber() * ad.n.getNumber();
//                                                condition = cplex.sum(condition, cplex.prod(right, action));
//                                                break;
//                                            case "decrease":
//                                                right = neff.getRight().eval(s_0).getNumber() * ad.n.getNumber();
//                                                condition = cplex.sum(condition, cplex.prod(-right, action));
//                                                break;
//                                            case "assign":
//                                                //this is an assign
////                                            right = neff.getRight().eval(s_0).getNumber() * ad.n.getNumber();
////                                            right = condition.get(action).floatValue() - right;
////                                            condition = condition.set(action, right - ad.f.eval(s_0).getNumber());
////                                            action.upper(1);
//                                                System.out.println("Assign not supported");
//                                                break;
//                                        }
//                                    if ((comp.getComparator().contains(">") && right > 0)
//                                            || (comp.getComparator().contains("<") && right < 0)) {
//                                        at_least_one = true;
//                                        //this is the only action that can be used.
//                                    }
//                                    
//
//                                        
//
////                                    local_minimum = Math.min(local_minimum, h.get(gr.getPreconditions().getCounter()));
////                                    System.out.println("Action"+gr+" Cost:"+h.get(gr.getPreconditions().getCounter()));
////                                    System.out.println("Condition " +c);
////                                    if (local_minimum == Float.MAX_VALUE){
////                                        System.out.println("Problem with:"+gr);
////                                    }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                    if (!at_least_one && !cond.isSatisfied(s_0)) {
//                        return Float.MAX_VALUE;
//                    }
//                    switch (comp.getComparator()) {
//                        case ">":
//
//                            cplex.addGe(cplex.sum(condition, num), 0);
//                            break;
//                        case ">=":
//                            cplex.addGe(cplex.sum(condition, num), 0);
//                            break;
//                        case "<":
//                            cplex.addLe(cplex.sum(condition, num), 0);
//                            break;
//                        case "<=":
//                            cplex.addLe(cplex.sum(condition, num), 0);
//                            break;
//                        case "=":
//                            cplex.addEq(cplex.sum(condition, num), 0);
//                            break;
//                    }
////                if (!cond.isSatisfied(s_0)) {
////                    minimi.add(local_minimum);
////                }
//
////                System.out.println(condition);
//                } else if (cond instanceof Predicate) {
//                }
//            }
//
//            cplex.addMinimize(obj);
////            System.out.println(cplex.getObjective().toString());
////            System.out.println(obj);
//
////            cplex.exportModel("mipex1.lp");
////            System.out.println(cplex);
//            if (cplex.solve()) {
////                System.out.println("Objective:"+cplex.getObjValue());
//                float ret = (float) cplex.getObjValue();
//                cplex.end();
//                return ret;
//            } else {
//                cplex.end();
//                //            System.out.println(opt.toString());
//                return Float.MAX_VALUE;
//            }
//        } catch (IloException ex) {
//            Logger.getLogger(lp_interface.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return Float.MAX_VALUE;
//    }
}

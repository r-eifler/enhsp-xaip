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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
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
    private boolean check_mutex = false;

    public Bellman_Ford_Hm(Conditions G, Set<GroundAction> A) {
        super(G, A);
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
        return compute_estimate(s_0);
    }

    @Override
    public Float compute_estimate(State s_0) {
        if (s_0.satisfy(G)) {
            return 0f;
        }
        ArrayList<Float> h = new ArrayList<>(Collections.nCopies(all_conditions.size() + 1, Float.MAX_VALUE));
        this.init_h(h, all_conditions, s_0);
        Collection<GroundAction> A_temp = new LinkedHashSet(A);
        Collection<GroundAction> pool = new LinkedHashSet();
        init_actions(pool, A_temp, s_0, h);
        boolean update;
        do {
            update = this.update_conditions_values(pool, s_0, all_conditions, h);
            if (update) {
                this.update_pool(pool, A_temp, s_0, h);
            }
//            if (greedy && h.get(G.getCounter()) != Float.MAX_VALUE) {
//                break;
//            }
        } while (update);
        return h.get(G.getCounter());

    }

    protected boolean update_conditions_values(Collection<GroundAction> pool, State s_0, Collection<Conditions> all_conditions, ArrayList<Float> h) {
        boolean update = false;
        for (Conditions c : this.all_conditions) {
            if (h.get(c.getCounter()) != 0f) {
                float current = compute_current_cost(pool, s_0, c, h);
                if (current < h.get(c.getCounter())) {
                    h.set(c.getCounter(), current);
                    update = true;
                }
            }
        }
        return update;
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

    private float compute_current_cost(Collection<GroundAction> pool, State s_0, Conditions c, ArrayList<Float> h) {

        if (c == null || c.sons == null || c.sons.isEmpty()) {
            return 0f;
        }

//        HashMap<String, String> cfg = new HashMap<String, String>();
//        cfg.put("model", "false");
        Context ctx = new Context();

        Optimize opt = ctx.mkOptimize();

        Collection<ArithExpr> action_used = new LinkedHashSet();
        Collection<ArithExpr> achiever_prop = new LinkedHashSet();
        Collection<Predicate> pred_to_satisfy = new LinkedHashSet();
        for (Conditions cond : (Collection<Conditions>) c.sons) {
            if (cond.isSatisfied(s_0)) {
                continue;
            }
            if (cond instanceof Comparison) {

                Comparison comp = (Comparison) cond;
                ExtendedNormExpression left = (ExtendedNormExpression) comp.getLeft();
                ArithExpr expr = ctx.mkAdd(ctx.mkReal(0));
                boolean at_least_one = false;
                for (ExtendedAddendum ad : left.summations) {
                    if (ad.f != null) {
//                        Float num = s_0.functionValue(ad.f).getNumber() * 10f;
//                        Float coeff = ad.n.getNumber()*10f;
//                        
                        Float num = s_0.functionValue(ad.f).getNumber() * 10f * ad.n.getNumber();
                        //ArithExpr fluent = ctx.mkRealConst(ad.f.toString());
                        //opt.Add(ctx.mkEq(fluent, ctx.mkReal(num.intValue(), 10)));
                        expr = ctx.mkAdd(expr, ctx.mkReal(num.intValue(), 10));
                        //expr = ctx.mkAdd(expr,  ctx.mkMul(fluent,ctx.mkReal(coeff.intValue(), 10)));
//                        System.out.println("Condition:"+cond);
                        for (GroundAction gr : pool) {
//                            System.out.println(gr);
                            if (gr.getNumericFluentAffected().get(ad.f) != null && gr.getNumericFluentAffected().get(ad.f).equals(Boolean.TRUE)) {
                                
                                for (NumEffect neff : gr.getNumericEffectsAsCollection()) {
                                    if (!neff.getFluentAffected().equals(ad.f))
                                        continue;
//                                    System.out.println(neff);
                                    at_least_one = true;
                                    ArithExpr var = ctx.mkRealConst(gr.toString());
                                    ArithExpr prec_cost = ctx.mkRealConst(gr.toString() + "pre_cost");
                                    gr.setAction_cost(s_0);
                                    Float cost_action = gr.getAction_cost() * 10f;
                                    ArithExpr action_plus_cost = ctx.mkMul(var, ctx.mkReal(cost_action.intValue(), 10));
//                                    System.out.println(action_plus_cost);
                                    action_used.add(action_plus_cost);
                                    action_used.add(prec_cost);
                                    opt.Add(ctx.mkGe(var, ctx.mkInt(0)));
                                    Float cost_of_prec = h.get(gr.getPreconditions().getCounter()) * 10f;
                                    opt.Add(ctx.mkImplies(ctx.mkGt(var, ctx.mkInt(0)), ctx.mkEq(prec_cost, ctx.mkReal(cost_of_prec.intValue(), 10))));
                                    opt.Add(ctx.mkImplies(ctx.mkEq(var, ctx.mkInt(0)), ctx.mkEq(prec_cost, ctx.mkReal(0))));
                                    if (neff.getOperator().equals("increase")) {
                                        Float right = neff.getRight().eval(s_0).getNumber() * 10f * ad.n.getNumber();
                                        expr = ctx.mkAdd(expr, ctx.mkMul(var, ctx.mkReal(right.intValue(), 10)));
                                    } else if (neff.getOperator().equals("decrease")) {
                                        Float right = neff.getRight().eval(s_0).getNumber() * 10f * ad.n.getNumber();
                                        expr = ctx.mkSub(expr, ctx.mkMul(var, ctx.mkReal(right.intValue(), 10)));
                                    } else {
                                        System.out.println("not supported yet");
                                        System.exit(-1);
                                    }
                                    
                                }
                            }
                        }
                    } else {
                        Float num = ad.n.getNumber() * 10f;
                        expr = ctx.mkAdd(expr, ctx.mkReal(num.intValue(), 10));
                    }
                }
                if (!at_least_one) {
//                    System.out.println("Comparison:"+cond+"cannot be satisfied");
                    return Float.MAX_VALUE;
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
//                System.out.println("Predicates?");

                boolean at_least_one = false;
                Predicate p = (Predicate) cond;
                ArithExpr expr = ctx.mkAdd(ctx.mkReal(0));
                for (GroundAction gr : pool) {
                    if (gr.achieve(p)) {
                        at_least_one = true;
                        ArithExpr var = ctx.mkRealConst(gr.toString());
                        expr = ctx.mkAdd(expr, var);

                        gr.setAction_cost(s_0);
                        Float cost_action = gr.getAction_cost() * 10f;
                        ArithExpr action_plus_cost = ctx.mkMul(var, ctx.mkReal(cost_action.intValue(), 10));
                        achiever_prop.add(action_plus_cost);
                        ArithExpr prec_cost = ctx.mkRealConst(gr.toString() + "pre_cost");
                        Float cost_of_prec = h.get(gr.getPreconditions().getCounter()) * 10f;
                        achiever_prop.add(prec_cost);
                        opt.Add(ctx.mkGe(var, ctx.mkInt(0)));

                        opt.Add(ctx.mkImplies(ctx.mkGt(var, ctx.mkInt(0)), ctx.mkEq(prec_cost, ctx.mkReal(cost_of_prec.intValue(), 10))));
                        opt.Add(ctx.mkImplies(ctx.mkEq(var, ctx.mkInt(0)), ctx.mkEq(prec_cost, ctx.mkReal(0))));
                    } else if (gr.delete(p)) {
                        //Ar//ithExpr var = ctx.mkRealConst(gr.toString());
                        //opt.Add(ctx.mkEq(var, ctx.mkReal(0)));
                    }

                }
                if (!at_least_one) {
//                    System.out.println("Comparison:"+cond+"cannot be satisfied");
                    return Float.MAX_VALUE;
                }
                opt.Add(ctx.mkGe(expr, ctx.mkInt(1)));
            }
        }

        if (check_mutex){
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
        ArithExpr[] to_add2 = from_set_to_arithm_expr_array(achiever_prop);
        ArithExpr temp = ctx.mkAdd(ctx.mkReal(0));
        if (to_add.length != 0) {
            temp = ctx.mkAdd(to_add);
        }
        for (int j = 0; j < to_add2.length; j++) {
            temp = ctx.mkAdd(temp, to_add2[j]);
        }

//        System.out.println(opt.getModel());
        Optimize.Handle mx = opt.MkMinimize(temp);
        System.out.println(opt.toString());
//        RealExpr ret = (RealExpr)mx.getValue();

        if (opt.Check() == Status.SATISFIABLE) {
//            System.out.println(mx.getValue());
//            System.out.println(opt.getModel());
            ArithExpr ret = mx.getValue();
            if (ret instanceof IntNum) {
                return Float.parseFloat(ret.toString());
            } else if (ret instanceof RatNum) {
                RatNum rat = (RatNum) ret;
                return ((float) rat.getNumerator().getInt() / (float) rat.getDenominator().getInt());
            } else if (ret instanceof RealExpr) {
                RealExpr real_expr = (RealExpr) ret;
                return 0;
            }
            System.out.println("Value not recognized");

            if (mx.getValue().toString().equals("epsilon")) {
                return 0;
            }
            return Float.MAX_VALUE;

        } else {
//            System.out.println(opt.toString());
            return Float.MAX_VALUE;
        }
//        System.out.println(opt.Check());
    }

    private void init_actions(Collection<GroundAction> pool, Collection<GroundAction> A_temp, State s_0, ArrayList<Float> h) {
        A_temp.stream().filter((gr) -> (h.get(gr.getPreconditions().getCounter()) != Float.MAX_VALUE)).forEach((gr) -> {
            pool.add(gr);
        });
    }

    private ArithExpr[] from_set_to_arithm_expr_array(Collection<ArithExpr> action_used) {
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

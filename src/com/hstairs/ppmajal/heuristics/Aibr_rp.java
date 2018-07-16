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
import com.hstairs.ppmajal.expressions.BinaryOp;
import com.hstairs.ppmajal.expressions.NumEffect;
import com.hstairs.ppmajal.expressions.PDDLNumber;
import com.hstairs.ppmajal.extraUtils.Utils;
import com.hstairs.ppmajal.problem.*;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.nCopies;

/**
 * @author enrico
 */
public class Aibr_rp extends Heuristic {

    public boolean conservative = false;
    public boolean extract_plan = false;
    public boolean layers_counter;
    protected ArrayList<Integer> dist;
    boolean reachability;
    private boolean counting_layers = true;
    private boolean greedy_relaxed_plan = false;
    private boolean reversing = false;
    private HashMap<GroundAction, GroundAction> supp_to_action;
    private HashMap<Condition, Integer> cond_level;
    private HashMap<GroundAction, Integer> supporter_level;
    private HashMap<Integer, LinkedHashSet<GroundAction>> supporters_exec_at_time_index;
    private HashMap<Integer, LinkedHashSet<Condition>> conditions_sat_at_time_index;
    private HashMap<Integer, GroundAction> supp_to_actions;
    private boolean cost_oriented = true;

    public Aibr_rp (ComplexCondition G, Set<GroundAction> actions) {
        super(G, actions);
        Utils.dbg_print(debug, "Generate Supporters\n");
        generate_supporters(A);
    }

    public Aibr_rp (ComplexCondition G, Set<GroundAction> actions, Set<GroundProcess> processes) {
        super(G, actions, processes);
        Utils.dbg_print(debug, "Generate Supporters\n");
        generate_supporters(A);
        Utils.dbg_print(debug, "Supporters Generated\n");

        //this.build_integer_representation();
    }

    public void set (boolean counting_layers_active, boolean greedy_relaxed_plan_active) {
        this.counting_layers = counting_layers_active;
        this.greedy_relaxed_plan = greedy_relaxed_plan_active;
    }

    @Override
    public Float setup (State s_0) {
        reachability = true;

        Utils.dbg_print(debug, "Computing Internal Data Structure\n");
        this.build_integer_representation();
        Utils.dbg_print(debug, "Computing Reachable Actions\n");
        Float ret = computeEstimate(s_0);
        reachability = false;
        return ret;
    }

    @Override
    public Float computeEstimate (State gs) {
        PDDLState s = (PDDLState) gs;
        RelState rs = s.relaxState();
        Collection<GroundAction> temp_supporters = new LinkedHashSet(supporters);//making a copy of the supporters so as not to delete the source
        int supporters_counter = 0;
        //dist = new HashMap();
//        if (extract_plan){
        dist = new ArrayList<>(nCopies(index_of_last_static_atom + 1, Integer.MAX_VALUE));
        this.supporters_exec_at_time_index = new HashMap();

        this.cond_level = new HashMap();
        this.supporter_level = new HashMap();
        this.conditions_sat_at_time_index = new HashMap();
//        }
        //System.out.println("Supporter to action:"+this.supp_to_action);
        int i = 0;
        boolean exit = false;
        while (!exit) {//until  the goal is not satisfied || the procedure has been called in reacheability setting
//            Collection<GroundAction> S = temp_supporters.stream().filter(p -> p.isApplicable(rs)).collect(Collectors.toSet());//lambda function, Take the applicable action
            this.conditions_sat_at_time_index.put(i, new LinkedHashSet());
            if (check_goal_condition(G, i, rs) && !reachability) {
                break;
            }
            LinkedHashSet<GroundAction> S = get_applicable_supporters(temp_supporters, rs, i);

            if (S.isEmpty()) {//if there are no applicable actions then finish!
                if (!rs.satisfy(G)) {
                    if (reachability) {
                        reacheable_state = rs.clone();
                        this.reachable = new LinkedHashSet(A.stream().filter(p -> p.isApplicable(rs)).collect(Collectors.toList()));
                    }
//                    get_applicable_supporters(temp_supporters, rs, i);
                    return Float.MAX_VALUE;
                } else {
                    reacheable_state = rs.clone();
                    //this.reachable = new LinkedHashSet(A.stream().filter(p -> p.isApplicable(rs)).collect(Collectors.toList()));
                    break;
                }
            }
            this.supporters_exec_at_time_index.put(i, S);

            if (reachability || extract_plan) {
//            if (true){
                S.stream().forEach((GroundAction a) -> a.apply(rs));
                supporters_counter += S.size();
            } else {
                for (GroundAction gr : S) {
                    supporters_counter += S.size();
                    gr.apply(rs);
                    if (check_goal_condition(G, i, rs)) {
                        exit = true;
                        break;
                    }
                }
            }

            i++;
        }
        Utils.dbg_print(debug, "Rechability finished");

        if (reachability) {
            //reacheable_state = rs.clone();
            this.reachable = new LinkedHashSet(A.stream().filter(p -> p.isApplicable(rs)).collect(Collectors.toList()));
            this.supporters = new LinkedHashSet(supporters.stream().filter(p -> p.isApplicable(rs)).collect(Collectors.toList()));
            return (float) i;
        }
        if (layers_counter) {
            return (float) i;
        }
        if (conservative) {
            return (float) supporters_counter;
        }
        if (supporters_counter == 0) {
            return 0f;
        }

        RelState rs2 = s.relaxState();
        if (!extract_plan) {
            return fix_point_computation(s, rs2);
        } else {
            return extract_plan(rs2, i, s);
        }

    }

    private void generate_supporters (Set<GroundAction> actions) {
        this.supp_to_action = new HashMap();

        supporters = new LinkedHashSet();
        Collection<GroundAction> actions_plus_action_for_supporters = new LinkedHashSet();
        for (GroundAction gr : actions) {
            if (gr.cond_effects != null) {
                actions_plus_action_for_supporters.addAll(generate_actions_for_cond_effects(gr.getName(), gr.cond_effects));
            }
        }
        //System.out.println(actions_plus_action_for_supporters);
        actions_plus_action_for_supporters.addAll(actions);
        for (GroundAction gr : actions_plus_action_for_supporters) {
            if (gr.getNumericEffects() != null && !gr.getNumericEffects().sons.isEmpty()) {
                for (NumEffect effect : (Collection<NumEffect>) gr.getNumericEffects().sons) {
                    effect.additive_relaxation = true;
                    if (effect.getOperator().equals("assign") && effect.getRight().rhsFluents().isEmpty()) {
                        supporters.add(generate_constant_supporter(effect, gr.toFileCompliant() + effect.getFluentAffected(), (AndCond) gr.getPreconditions(), gr));
                    } else {
                        supporters.add(generate_plus_inf_supporter(effect, gr.toFileCompliant() + effect.getFluentAffected(), (AndCond) gr.getPreconditions(), gr));
                        supporters.add(generate_minus_inf_supporter(effect, gr.toFileCompliant() + effect.getFluentAffected(), (AndCond) gr.getPreconditions(), gr));
                    }
                }
            }
            if ((gr.getAddList() != null && !gr.getAddList().sons.isEmpty()) || (gr.getDelList() != null && !gr.getDelList().sons.isEmpty())) {
                supporters.add(generate_propositional_action(gr.toFileCompliant() + "prop", (AndCond) gr.getPreconditions(), gr));
            }

        }

    }

    private GroundAction generate_constant_supporter (NumEffect effect, String name, AndCond precondition, GroundAction gr) {
        GroundAction ret = new GroundAction(name + "constantassign");
        NumEffect assign = new NumEffect("assign");
        assign.setFluentAffected(effect.getFluentAffected());
        assign.setRight(effect.getRight());
        ret.getNumericEffects().sons.add(assign);
        if (precondition != null && !precondition.sons.isEmpty()) {
            ret.getPreconditions().sons.addAll(precondition.sons);
        }
        this.supp_to_action.put(ret, gr);
        return ret;
    }

    private GroundAction generate_plus_inf_supporter (NumEffect effect, String name, AndCond precondition, GroundAction gr) {
        String disequality = "";
        Float asymptote = Float.MAX_VALUE;
        switch (effect.getOperator()) {
            case "increase":
                disequality = ">";
                break;
            case "decrease":
                disequality = "<";
                break;
            case "assign":
                disequality = ">";
                break;
        }
        return generate_supporter(effect, disequality, asymptote, name + "plusinf", precondition, gr);
    }

    private GroundAction generate_supporter (NumEffect effect, String inequality, Float asymptote, String name, AndCond precondition, GroundAction gr) {
        GroundAction ret = new GroundAction(name);
        Comparison indirect_precondition = new Comparison(inequality);
        if (effect.getOperator().equals("assign")) {
            indirect_precondition.setLeft(new BinaryOp(effect.getRight(), "-", effect.getFluentAffected(), true));
        } else {
            indirect_precondition.setLeft(effect.getRight());
        }
        indirect_precondition.setRight(new PDDLNumber(0));
        ret.getPreconditions().sons.add(indirect_precondition);
        NumEffect eff = new NumEffect("assign");
        eff.setFluentAffected(effect.getFluentAffected());
        eff.setRight(new PDDLNumber(asymptote));
        ret.getNumericEffects().sons.add(eff);
        if (precondition != null && !precondition.sons.isEmpty()) {
            ret.getPreconditions().sons.addAll(precondition.sons);
        }
        this.supp_to_action.put(ret, gr);
        return ret;
    }

    private GroundAction generate_minus_inf_supporter (NumEffect effect, String name, AndCond precondition, GroundAction gr) {
        String disequality = "";
        Float asymptote = -Float.MAX_VALUE;
        switch (effect.getOperator()) {
            case "increase":
                disequality = "<";
                break;
            case "decrease":
                disequality = ">";
                break;
            case "assign":
                disequality = "<";
                break;

        }
        return generate_supporter(effect, disequality, asymptote, name + "minusinf", precondition, gr);
    }

    private GroundAction generate_propositional_action (String name, AndCond andCond, GroundAction gr) {
        GroundAction ret = new GroundAction(name);
        ret.setPreconditions(andCond);
        ret.setAddList(gr.getAddList());
        ret.setDelList(gr.getDelList());
        this.supp_to_action.put(ret, gr);

        return ret;
    }

    private Float fix_point_computation (PDDLState s, RelState rs2) {
        Float counter = 0f;
        Float layer_counter = 0f;
        while (counter <= horizon) {
            boolean fix_point = true;
            layer_counter++;
            for (GroundAction gr : this.reachable) {
                if (gr.isApplicable(rs2)) {
                    gr.apply_with_generalized_interval_based_relaxation(rs2);

                    //counter++;//=
                    if (cost_oriented) {
//                        gr.set_unit_cost(s);
                        counter += gr.getActionCost();
                    } else {
                        counter++;
                    }
                    fix_point = false;
                    if (rs2.satisfy(G) && greedy_relaxed_plan) {
                        if (counting_layers) {
                            return layer_counter;
                        } else {
                            return counter;
                        }
                    }
                }
                //                    System.out.println("Reacheability Iteration: "+counter);
            }
            if (!greedy_relaxed_plan) {
                if (rs2.satisfy(G)) {
                    if (counting_layers) {
                        return layer_counter;
                    } else {
                        return counter;
                    }
                }
            }

            if (fix_point) {
                System.out.println("Anomaly!");
                //return Integer.MAX_VALUE;
            }
        }

        return counter;
    }

    //The following is to weak as it only reason qualitatively! Needs to define concept of regression in the interval case.
    private Float extract_plan (RelState rs2, int i, PDDLState s) {
        HashMap<Integer, LinkedHashSet<GroundAction>> to_add = new HashMap();

        for (int t = 0; t <= i; t++) {
            to_add.put(t, new LinkedHashSet());
            this.conditions_sat_at_time_index.put(t, new LinkedHashSet());
        }

        for (Condition c : G.getTerminalConditions()) {
            Utils.dbg_print(debug, "[" + dist.get(c.getHeuristicId()) + "]Goal atom:" + c + "\n");
            this.conditions_sat_at_time_index.get(dist.get(c.getHeuristicId())).add(c);
        }

        HashMap<Integer, LinkedHashSet<GroundAction>> index_to_actual_actions = new HashMap();
        int k = i;

        Utils.dbg_print(debug, "Layer(goals):" + i);
        while (k > 0) {
            LinkedHashSet<Condition> g_new = new LinkedHashSet();
            Utils.dbg_print(debug, "\nLayer " + k + ":");

            for (Condition g : this.conditions_sat_at_time_index.get(k)) {
                //System.out.println("Open goals:"+g);
                GroundAction candidate = null;
                Utils.dbg_print(debug, "Condition under analysis:" + g);
                for (GroundAction gr : this.supporters_exec_at_time_index.get(k - 1)) {
                    Utils.dbg_print(debug, "Trying this action:" + gr);
                    if (achiever(gr, rs2, g)) {
                        if (gr.getPreconditions() != null) {
                            for (Condition c : gr.getPreconditions().getTerminalConditions()) {
                                //System.out.println("Precondition level:"+dist.get(c));
//                                Utils.dbg_print(debug,"instances of"+c.getClass());
                                Utils.dbg_print(debug, "Candidate implications:[" + this.dist.get(c.getHeuristicId()) + "]" + c);
                                this.conditions_sat_at_time_index.get(this.dist.get(c.getHeuristicId())).add(c);
                            }

                        }
                        Utils.dbg_print(debug, "Candidate found:" + gr);
                        candidate = gr;
                        break;
                    }
                }
                if (candidate == null) {

                    //case in which multiple actions need
                    RelState temp = rs2.clone();

                    int t = k - 1;
                    while (t >= 0) {
                        for (GroundAction gr : this.supporters_exec_at_time_index.get(t)) {
                            gr.apply(temp);
                            if (gr.getPreconditions() != null) {
                                for (Condition c : gr.getPreconditions().getTerminalConditions()) {
                                    //System.out.println("Precondition level:"+dist.get(c));
                                    this.conditions_sat_at_time_index.get(this.dist.get(c.getHeuristicId())).add(c);
                                }
                            }
                            to_add.get(k - 1).add(this.supp_to_action.get(gr));
                            if (temp.satisfy(g)) {
                                t = -1;
                                break;
                            }
                        }
                        t--;

                    }
                    Utils.dbg_print(debug, " " + g.toString() + " ,Supporter (already in action) set:" + to_add.get(t));
                } else {
                    //System.out.println("Supporter to action:"+ this.supp_to_action.get(candidate));
                    to_add.get(k - 1).add(this.supp_to_action.get(candidate));
                    //GroundAction actual_gr = this.supp_to_action.get(candidate);
                    //relaxed_plan.addAll(count(rs2,actual_gr,g));
                    Utils.dbg_print(debug, " " + g.toString() + " ,Supporter:" + candidate + "\n        ");

                }
            }
            //index_to_actual_actions.put(i,to_add);
            k--;
        }
        Utils.dbg_print(debug, "\nAction under analysis:" + to_add);
        Float counter = 0f;
        while (k < i) {
            Utils.dbg_print(debug, "\nGoing all the way up to the goal:" + k);
            boolean go_ahead = true;
            for (Condition c : this.conditions_sat_at_time_index.get(k + 1)) {
                if (!c.can_be_true(rs2)) {
                    go_ahead = false;
                }
            }
            if (!go_ahead) {
                if (to_add.get(k).isEmpty()) {
                    System.out.println("This shouldn't happen...Check in the plan extraction method");
                    System.exit(-1);
                }
                for (GroundAction gr : to_add.get(k)) {

                    for (Condition c : this.conditions_sat_at_time_index.get(k + 1)) {
                        if (!c.can_be_true(rs2)) {
                            go_ahead = false;
                        }
                    }
                    if (go_ahead) {
                        k++;
                    } else {
                        rs2 = gr.apply_with_generalized_interval_based_relaxation(rs2);
                        if (cost_oriented) {
//                            gr.set_unit_cost(s);
                            counter += gr.getActionCost();
                        } else {
                            counter++;
                        }
                    }
                    if (counter > horizon) {
                        return counter;
                    }
                    if (k == i) {
                        break;
                    }
                    //System.out.println("Applying:"+gr);
                    //}             
                }
            } else {
                k++;
            }

        }

        return counter;

    }

    private LinkedHashSet<GroundAction> get_applicable_supporters (Collection<GroundAction> temp_supporters, RelState rs, int i) {
        LinkedHashSet<GroundAction> ret = new LinkedHashSet();
        Iterator<GroundAction> it = temp_supporters.iterator();
        while (it.hasNext()) {
            GroundAction gr = it.next();
            boolean add_action = true;
            if (gr.getPreconditions().getTerminalConditions() != null) {
                for (Condition c : gr.getPreconditions().getTerminalConditions()) {
                    if (c.can_be_true(rs)) {
                        if (this.dist.get(c.getHeuristicId()) == Integer.MAX_VALUE) {
                            this.dist.set(c.getHeuristicId(), i);
                            this.conditions_sat_at_time_index.get(i).add(c);
                        }
                    } else {
                        add_action = false;
                    }
                }
            }
            if (add_action) {
                ret.add(gr);
//                this.reachable.add();
                it.remove();
            }
        }
        return ret;

    }

    private boolean check_goal_condition (Condition G, int i, RelState rs) {
        boolean goal_satisfied = true;
        for (Condition c : G.getTerminalConditions()) {
            if (c.can_be_true(rs)) {
                if (this.dist.get(c.getHeuristicId()) == Integer.MAX_VALUE) {
                    this.dist.set(c.getHeuristicId(), i);
                    this.conditions_sat_at_time_index.get(i).add(c);
                }
            } else {
                goal_satisfied = false;
            }
        }
        return goal_satisfied;
    }

    private boolean achiever (GroundAction gr, RelState rs2, Condition g) {
        RelState temp = rs2.clone();
        return gr.apply(temp).satisfy(g);

    }

    private Collection<? extends GroundAction> generate_actions_for_cond_effects (String name, ComplexCondition cond_effects) {
        Set ret = new LinkedHashSet();
        Integer counter = 0;
        for (Object o : cond_effects.sons) {
            if (o instanceof ConditionalEffect) {
                ConditionalEffect cond = (ConditionalEffect) o;
                GroundAction a = new GroundAction(name + counter);
                a.getPreconditions().sons.add(cond.activation_condition);
                a.create_effects_by_cases(cond.effect);
                ret.add(a);
                counter++;
            }
        }
        return ret;

    }

}

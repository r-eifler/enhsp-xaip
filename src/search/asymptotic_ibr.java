/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import conditions.AndCond;
import conditions.Comparison;
import conditions.Conditions;
import expressions.BinaryOp;
import expressions.NumEffect;
import expressions.PDDLNumber;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;
import problem.GroundAction;
import problem.RelState;
import problem.State;

/**
 *
 * @author enrico
 */
public class asymptotic_ibr extends Heuristics {

    public Collection<GroundAction> supporters;
    boolean reacheability;
    private boolean conservative = false;
    private boolean counting_layers = true;
    private boolean greedy_relaxed_plan = false;
    public boolean extract_plan = false;
    private boolean reversing = false;

    public asymptotic_ibr(Conditions G, Set<GroundAction> actions) {
        super(G, actions);
        generate_supporters(A);
    }

    public asymptotic_ibr(Conditions G, Set<GroundAction> actions, Set<GroundAction> processes) {
        super(G, actions, processes);
        generate_supporters(A);
    }

    public void set(boolean counting_layers_active, boolean greedy_relaxed_plan_active) {
        this.counting_layers = counting_layers_active;
        this.greedy_relaxed_plan = greedy_relaxed_plan_active;
    }

    @Override
    public Float setup(State s_0) {
        reacheability = true;
        Float ret = compute_estimate(s_0);
        reacheability = false;
        return ret;
    }

    @Override
    Float compute_estimate(State s) {
        RelState rs = s.relaxState();
        Collection<GroundAction> temp_supporters = new LinkedHashSet(supporters);//making a copy of the supporters so as not to delete the source
        int supporters_counter = 0;
        while (!rs.satisfy(G) || reacheability) {//until  the goal is not satisfied || the procedure has been called in reacheability setting
            Collection<GroundAction> S = temp_supporters.stream().filter(p -> p.isApplicable(rs)).collect(Collectors.toSet());//lambda function, Take the applicable action
            if (S.isEmpty()) {//if there are no applicable action then finish!
                if (!rs.satisfy(G)) {
                    return Float.MAX_VALUE;
                } else {
                    break;
                }
            }
            temp_supporters.removeIf(p -> p.isApplicable(rs));//Remove the action just taken
            S.stream().forEach((GroundAction a) -> a.apply(rs));
            supporters_counter += S.size();
//            if (supporters_counter >=horizon){
////                System.out.println("Something wrong is happening");
//                return Integer.MAX_VALUE;
//            }
//            System.out.println("Internal Iteration: "+supporters_counter);
        }

        if (reacheability) {
            this.reachable = new LinkedHashSet(A.stream().filter(p -> p.isApplicable(rs)).collect(Collectors.toList()));
            
            //@TODO THIS IS FOR REVERSING
            if (reversing){
                LinkedList<GroundAction> temp = new LinkedList(this.reachable);
                Iterator<GroundAction> itr = temp.descendingIterator();
                LinkedHashSet<GroundAction> temp2 = new LinkedHashSet();
                while(itr.hasNext()) {
                    GroundAction item = itr.next();
                    temp2.add(item);
                    // do something
                }
                this.reachable = temp2;
            }
            //
        }

        if (conservative) {
            return (float)supporters_counter;
        }
        if (supporters_counter == 0) {
            return 0f;
        }

        RelState rs2 = s.relaxState();
        if (!extract_plan) {
            return fix_point_computation(rs2);
        } else {
            return extract_plan(rs2);
        }

    }

    private void generate_supporters(Set<GroundAction> actions) {
        supporters = new LinkedHashSet();
        for (GroundAction gr : actions) {
            if (gr.getNumericEffects() != null && !gr.getNumericEffects().sons.isEmpty()) {
                for (NumEffect effect : (Collection<NumEffect>) gr.getNumericEffects().sons) {
                    if (effect.getOperator().equals("assign") && effect.getRight().fluentsInvolved().isEmpty()) {
                        supporters.add(generate_constant_supporter(effect, gr.toFileCompliant() + effect.getFluentAffected(), (AndCond) gr.getPreconditions()));
                    } else {
                        supporters.add(generate_plus_inf_supporter(effect, gr.toFileCompliant() + effect.getFluentAffected(), (AndCond) gr.getPreconditions()));
                        supporters.add(generate_minus_inf_supporter(effect, gr.toFileCompliant() + effect.getFluentAffected(), (AndCond) gr.getPreconditions()));
                    }
                }
            }
            if (gr.getAddList() != null && !gr.getAddList().sons.isEmpty()) {

                supporters.add(generate_propositional_action(gr.getAddList(), gr.toFileCompliant() + "prop", (AndCond) gr.getPreconditions()));

            }

        }

    }

    private GroundAction generate_constant_supporter(NumEffect effect, String name, AndCond precondition) {
        GroundAction ret = new GroundAction(name + "constantassign");
        NumEffect assign = new NumEffect("assign");
        assign.setFluentAffected(effect.getFluentAffected());
        assign.setRight(effect.getRight());
        ret.getNumericEffects().sons.add(assign);
        if (precondition != null && !precondition.sons.isEmpty()) {
            ret.getPreconditions().sons.addAll(precondition.sons);
        }
        return ret;
    }

    private GroundAction generate_plus_inf_supporter(NumEffect effect, String name, AndCond precondition) {
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
        return generate_supporter(effect, disequality, asymptote, name + "plusinf", precondition);
    }

    private GroundAction generate_supporter(NumEffect effect, String disequality, Float asymptote, String name, AndCond precondition) {
        GroundAction ret = new GroundAction(name);
        Comparison indirect_precondition = new Comparison(disequality);
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
        return ret;
    }

    private GroundAction generate_minus_inf_supporter(NumEffect effect, String name, AndCond precondition) {
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
        return generate_supporter(effect, disequality, asymptote, name + "minusinf", precondition);
    }

    private GroundAction generate_propositional_action(Conditions addList, String name, AndCond andCond) {
        GroundAction ret = new GroundAction(name);
        ret.setPreconditions(andCond);
        ret.setAddList(addList);
        return ret;
    }

    private Float fix_point_computation(RelState rs2) {
        Float counter = 0f;
        Float layer_counter = 0f;
        while (counter <= horizon) {
            boolean fix_point = true;
            layer_counter++;
            for (GroundAction gr : this.reachable) {
                if (gr.isApplicable(rs2)) {
                    gr.apply_with_generalized_interval_based_relaxation(rs2);
                    counter++;//=gr.getAction_cost();
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
    private Float extract_plan(RelState rs2) {
        Float counter = 0f;
        Deque<Deque<GroundAction>> action_layers = new ArrayDeque();
        Deque<RelState> state_layers = new ArrayDeque();
        int layers_counter = 0;
        RelState current = rs2.clone();
        while (counter <= horizon) {
            Deque<GroundAction> actions_in_the_layer = new ArrayDeque();
            //System.out.println("Forward: Level:" + layers_counter++);
            for (GroundAction gr : this.reachable) {
                if (gr.isApplicable(current)) {
                    actions_in_the_layer.add(gr);
                }
            }
            state_layers.add(current.clone());
            for (GroundAction gr : actions_in_the_layer) {
                current = gr.apply_with_generalized_interval_based_relaxation(current);
                if (current.satisfy(G)) {
                    action_layers.add(actions_in_the_layer);
                    //state_layers.add(current.clone());
                    Conditions temp = G;
                    while (!state_layers.isEmpty()) {
                        RelState previous = state_layers.pollLast();
                        //System.out.println("Backward: Level:" + layers_counter--);

                        //if (action_layers.isEmpty()) {
                            //System.out.println("Shouldn't happen");
                        //    return counter;
                        //}
                        Deque<GroundAction> candidates = action_layers.pollLast();
                        AndCond new_cond = new AndCond();
                        while (!temp.isSatisfied(previous)) {
                            GroundAction selected = candidates.pollFirst();
                            selected.apply_with_generalized_interval_based_relaxation(previous);
                            counter++;
                            new_cond.sons.addAll(selected.getPreconditions().sons);
                        }
                        temp = new_cond;
                    }
                    return counter;

                }
            }
            //                    System.out.println("Reacheability Iteration: "+counter);
            action_layers.add(actions_in_the_layer);

        }

        return counter;

    }

}

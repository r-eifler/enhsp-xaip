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
import static java.lang.Float.MAX_VALUE;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import static java.util.Collections.nCopies;
import java.util.Deque;
import java.util.HashMap;
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
public class asymptotic_ibr_relaxed_plan extends Heuristics {

    public Collection<GroundAction> supporters;
    boolean reacheability;
    private boolean conservative = false;
    private boolean counting_layers = true;
    private boolean greedy_relaxed_plan = false;
    public boolean extract_plan = false;
    private boolean reversing = false;
    private HashMap<GroundAction, GroundAction> supp_to_action;
    private HashMap<Conditions, Integer> cond_level;
    private HashMap<GroundAction, Integer> supporter_level;
    private ArrayList<Float> dist;
    private HashMap<Integer,LinkedHashSet<GroundAction>> index_to_supporters;

    public asymptotic_ibr_relaxed_plan(Conditions G, Set<GroundAction> actions) {
        super(G, actions);
        generate_supporters(A);
    }

    public asymptotic_ibr_relaxed_plan(Conditions G, Set<GroundAction> actions, Set<GroundAction> processes) {
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
        this.build_integer_representation();
        reacheability = false;
        return ret;
    }

    @Override
    Float compute_estimate(State s) {
        RelState rs = s.relaxState();
        Collection<GroundAction> temp_supporters = new LinkedHashSet(supporters);//making a copy of the supporters so as not to delete the source
        int supporters_counter = 0;
        dist = new ArrayList<>(nCopies(all_conditions.size() + 1, MAX_VALUE));
            this.index_to_supporters = new HashMap();

            this.cond_level = new HashMap();
            this.supporter_level = new HashMap();

        System.out.println("Supporter to action:"+this.supp_to_action);
        int i = 0;
        while (true) {//until  the goal is not satisfied || the procedure has been called in reacheability setting
//            Collection<GroundAction> S = temp_supporters.stream().filter(p -> p.isApplicable(rs)).collect(Collectors.toSet());//lambda function, Take the applicable action
            if (check_goal_condition(G, i, rs) && !reacheability) {
                break;
            }
            LinkedHashSet<GroundAction> S = get_applicable_supporters(temp_supporters, rs, i);

            if (S.isEmpty()) {//if there are no applicable actions then finish!
                if (!rs.satisfy(G)) {
                    return Float.MAX_VALUE;
                } else {
                    break;
                }
            }
            this.index_to_supporters.put(i, (LinkedHashSet<GroundAction>) S);

            S.stream().forEach((GroundAction a) -> a.apply(rs));
            supporters_counter += S.size();
//            if (supporters_counter >=horizon){
////                System.out.println("Something wrong is happening");
//                return Integer.MAX_VALUE;
//            }
//            System.out.println("Internal Iteration: "+supporters_counter);
            i++;
        }

        if (reacheability) {
            this.reachable = new LinkedHashSet(A.stream().filter(p -> p.isApplicable(rs)).collect(Collectors.toList()));
        }

        if (conservative) {
            return (float) supporters_counter;
        }
        if (supporters_counter == 0) {
            return 0f;
        }

        RelState rs2 = s.relaxState();
        if (!extract_plan) {
            return fix_point_computation(rs2);
        } else {
            return extract_plan(rs2,i);
        }

    }

    private void generate_supporters(Set<GroundAction> actions) {
        this.supp_to_action = new HashMap();

        supporters = new LinkedHashSet();
        for (GroundAction gr : actions) {
            if (gr.getNumericEffects() != null && !gr.getNumericEffects().sons.isEmpty()) {
                for (NumEffect effect : (Collection<NumEffect>) gr.getNumericEffects().sons) {
                    if (effect.getOperator().equals("assign") && effect.getRight().fluentsInvolved().isEmpty()) {
                        supporters.add(generate_constant_supporter(effect, gr.toFileCompliant() + effect.getFluentAffected(), (AndCond) gr.getPreconditions(), gr));
                    } else {
                        supporters.add(generate_plus_inf_supporter(effect, gr.toFileCompliant() + effect.getFluentAffected(), (AndCond) gr.getPreconditions(), gr));
                        supporters.add(generate_minus_inf_supporter(effect, gr.toFileCompliant() + effect.getFluentAffected(), (AndCond) gr.getPreconditions(), gr));
                    }
                }
            }
            if (gr.getAddList() != null && !gr.getAddList().sons.isEmpty()) {

                supporters.add(generate_propositional_action(gr.getAddList(), gr.toFileCompliant() + "prop", (AndCond) gr.getPreconditions(), gr));

            }

        }

    }

    private GroundAction generate_constant_supporter(NumEffect effect, String name, AndCond precondition, GroundAction gr) {
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

    private GroundAction generate_plus_inf_supporter(NumEffect effect, String name, AndCond precondition, GroundAction gr) {
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

    private GroundAction generate_supporter(NumEffect effect, String disequality, Float asymptote, String name, AndCond precondition, GroundAction gr) {
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
        this.supp_to_action.put(ret, gr);
        return ret;
    }

    private GroundAction generate_minus_inf_supporter(NumEffect effect, String name, AndCond precondition, GroundAction gr) {
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

    private GroundAction generate_propositional_action(Conditions addList, String name, AndCond andCond, GroundAction gr) {
        GroundAction ret = new GroundAction(name);
        ret.setPreconditions(andCond);
        ret.setAddList(addList);
        this.supp_to_action.put(ret, gr);

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
    private Float extract_plan(RelState rs2, int i) {
        ArrayList<GroundAction> relaxed_plan = new ArrayList();
        LinkedHashSet<Conditions> g1 = new LinkedHashSet();
        
        for(Conditions c: (Collection<Conditions>)G.sons){
            if (dist.get(c.getCounter())==i)
                g1.add(c);
        }
        HashMap<Integer,LinkedHashSet<GroundAction>> index_to_actual_actions = new HashMap();
        int k = i;
        LinkedHashSet<GroundAction> to_add = new LinkedHashSet();

        System.out.println("i:"+i);
        while (k>0){
            LinkedHashSet<Conditions> g_new = new LinkedHashSet();
            for(Conditions g: g1){
                System.out.println("Open goals:"+g);
                GroundAction candidate = null;
                System.out.println("Debug: Checking for"+g);
                for(GroundAction gr :this.index_to_supporters.get(i-1)){
                    System.out.println("Debug: Trying action"+gr);
                    if (achiever(gr,rs2,g)){
                        if (gr.getPreconditions()!=null){
                            for (Conditions c: (Collection<Conditions>)gr.getPreconditions().sons){
                                if (this.dist.get(c.getCounter())==(i-1)){
                                    g_new.add(c);
                                }
                            }
                            
                        }
                        
                        System.out.println("Debug: Good!");
                        candidate = gr;
                        break;
                    }
                }
                if (candidate == null){
                    System.out.println("Something wrong happened");
                    System.exit(-1);
                }
                System.out.println("Supporter to action:"+ this.supp_to_action.get(candidate));
                to_add.add(this.supp_to_action.get(candidate));
                //GroundAction actual_gr = this.supp_to_action.get(candidate);
                //relaxed_plan.addAll(count(rs2,actual_gr,g));
            }
            index_to_actual_actions.put(i,to_add);

            g1 = g_new;
            k--;
        }
        System.out.println("Action under analysis:"+to_add);
        while(!G.isSatisfied(rs2)){
            for (GroundAction gr: to_add){
                System.out.println("analysing:"+gr);

                if (gr.isApplicable(rs2)){
                    rs2 = gr.apply(rs2);
                    k++;
                    System.out.println("Applying:"+gr);
                }
            }
        }
        
        return (float)k;

    }

    private LinkedHashSet<GroundAction> get_applicable_supporters(Collection<GroundAction> temp_supporters, RelState rs, int i) {
        LinkedHashSet<GroundAction> ret = new LinkedHashSet();
        Iterator<GroundAction> it = temp_supporters.iterator();
        while (it.hasNext()) {
            GroundAction gr = it.next();
            if (gr.getPreconditions().sons == null) {
                continue;
            }
            boolean add_action = true;
            for (Conditions c : (Collection<Conditions>) gr.getPreconditions().sons) {
                if (c.isSatisfied(rs)) {
                    if (this.dist.get(c.getCounter()) == Float.MAX_VALUE) {
                        this.dist.set(c.getCounter(), (float) i);
                    }
                } else {
                    add_action = false;
                }
            }
            if (add_action) {
                ret.add(gr);
                it.remove();
            }
        }
        return ret;

    }

    private boolean check_goal_condition(Conditions G, int i, RelState rs) {
        boolean goal_satisfied = true;
        for (Conditions c : (Collection<Conditions>) G.sons) {
            if (c.isSatisfied(rs)) {
                if (this.dist.get(c.getCounter()) == Float.MAX_VALUE) {
                    this.dist.set(c.getCounter(), (float) i);
                }
            } else {
                goal_satisfied = false;
            }
        }
        return goal_satisfied;
    }

    private boolean achiever(GroundAction gr, RelState rs2, Conditions g) {
        RelState temp = rs2.clone();
        if (gr.apply(temp).satisfy(g))
            return true;
        return false;
        
    }

    private ArrayList<GroundAction> count(RelState rs2, GroundAction actual_gr, Conditions g) {
        RelState temp = rs2.clone();
        ArrayList<GroundAction> ret = new ArrayList();
        while(true){
           ret.add(actual_gr);
           if (actual_gr.apply(temp).satisfy(g))
               return ret;
        }
    }

}

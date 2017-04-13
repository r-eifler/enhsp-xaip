/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heuristics.advanced;

import conditions.Conditions;
import expressions.Expression;
import expressions.ExtendedNormExpression;
import expressions.NumEffect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import net.sourceforge.interval.ia_math.RealInterval;
import org.jgrapht.util.FibonacciHeap;
import org.jgrapht.util.FibonacciHeapNode;
import problem.GroundAction;
import problem.GroundProcess;
import problem.State;

/**
 *
 * @author dxli
 */
public class Adaptive_Ucs_h1 extends ucs_h1_refactored{
    private final Integer LOW = 0;
    private final Integer HIGH = 1;
    private final Integer EXACT_VALUE = 2;
    
    private List<HashMap<Expression, HashMap<RealInterval, ArrayList<GroundAction>>>> linearSupporters;
    private LinkedHashSet otherSupporters = new LinkedHashSet();
    private LinkedHashSet<GroundAction> stateDependentSupporters;
    private GroundAction goal_action;
    private LinkedHashSet<Integer> supportersCandidates = new LinkedHashSet<>();
    private Boolean setting_up = true;
    
    public Adaptive_Ucs_h1(Conditions goal, Set<GroundAction> A, Set<GroundProcess> P) {
        super(goal, A, P);
        
        goal_action = new GroundAction("goal");
        goal_action.dummy_goal = true;
        goal_action.setPreconditions(G);
        A.add(goal_action);
        
        stateDependentSupporters = new LinkedHashSet<>();
    }

    public void setLinearSupporters(List<HashMap<Expression, HashMap<RealInterval, ArrayList<GroundAction>>>> supportersTable) {
        this.linearSupporters = supportersTable;
    }
    
    public void setOtherSupporters(LinkedHashSet otherSupporters) {
        this.otherSupporters = otherSupporters;
    }
    
    @Override
    public Float compute_estimate(State s){
        addStateDependentSupporters(s);
        if (setting_up){             
            for(GroundAction gr: A){
                if (gr.dummy_goal) {
                    goal_action.counter = gr.counter;
                    break;
                }
            }
            setting_up = false;
        }
        
        A = stateDependentSupporters;
        A.add(goal_action);
        
        setSupportersCandidates(A);      
        return super.compute_estimate(s);
    }
    
    @Override
    public Float setup(State s){
        Float ret = super.setup(s);
        
        for(GroundAction gr: A){
            Habs.logging(gr.toPDDL() + "\n\n");
        }
        
        return ret;
    }

    private void setSupportersCandidates(LinkedHashSet<GroundAction> actions) {
        supportersCandidates.clear();
        
        for (GroundAction gr: actions){
            supportersCandidates.add(gr.counter);
        }
    }
    
    /**
     * Add supporters depends on the current state.
     * 
     * @param s current state 
     * 
     */
    private void addStateDependentSupporters(State s){
        stateDependentSupporters.clear();
        
        Iterator action_iterator = linearSupporters.iterator();
        Iterator <Entry<Expression, HashMap<RealInterval, ArrayList<GroundAction>>>> expr_iterator;
        Iterator <Entry<RealInterval, ArrayList<GroundAction>>> interval_iterator;
        
        HashMap<Expression, HashMap<RealInterval, ArrayList<GroundAction>>> nextActionMap;
        ArrayList<GroundAction> possible_supporters;
        Entry<Expression, HashMap<RealInterval, ArrayList<GroundAction>>> exprEntry;
        Entry<RealInterval, ArrayList<GroundAction>> intervalEntry;
        
        // time complexity: O(|A|*|FluentEffected_avg|*|Intervals_avg|)
        while (action_iterator.hasNext()){
            nextActionMap = (HashMap<Expression, HashMap<RealInterval, ArrayList<GroundAction>>>) action_iterator.next(); 
            expr_iterator = nextActionMap.entrySet().iterator();
                    
            while (expr_iterator.hasNext()){
                exprEntry = expr_iterator.next();
                interval_iterator = exprEntry.getValue().entrySet().iterator();

                Float eval = exprEntry.getKey().eval(s).getNumber();
                while (interval_iterator.hasNext()){
                    intervalEntry = interval_iterator.next();
                    possible_supporters = intervalEntry.getValue();
                    
                    // any linear increase/decrease effect will have 3 supporters (lo, hi, exact_value)
                    Float lo = (float) intervalEntry.getKey().lo();
                    Float hi = (float) intervalEntry.getKey().hi();

                    if (eval < lo){
                        stateDependentSupporters.add(possible_supporters.get(LOW));
                    } else if (eval <= hi) {
                        GroundAction temp_supporter = possible_supporters.get(EXACT_VALUE);
                        NumEffect temp_num_eff =  (NumEffect) temp_supporter.getNumericEffects().sons.iterator().next();
                        temp_num_eff.setRight(new ExtendedNormExpression(temp_num_eff.getRight().eval(s).getNumber()));
                        temp_supporter.getNumericEffects().sons.clear();
                        temp_supporter.getNumericEffects().sons.add(temp_num_eff);

                        stateDependentSupporters.add(temp_supporter);
                    } else {
                        stateDependentSupporters.add(possible_supporters.get(HIGH));
                    }    
                } 
            }
        }
        // propositional effects, constant and assignment effects
        stateDependentSupporters.addAll(otherSupporters);       
    }
    
    @Override    
    public void update_reachable_actions(GroundAction gr, Conditions comp, FibonacciHeap<GroundAction> a_plus, ArrayList<FibonacciHeapNode> action_to_fib_node) {
        //this procedure shrink landmarks for condition comp using action gr
//        System.out.println(changed);
        Set<GroundAction> set = condition_to_action.get(comp.getCounter());
        //this mapping contains action that need to be triggered becasue of condition comp
        for (GroundAction gr2 : set) {
            if (!supportersCandidates.contains(gr2.counter)){
                continue;
            }
            
            if (closed.get(gr2.counter)) {
                continue;
            }
            Float c = check_conditions(gr2);

            if (c < action_dist.get(gr2.counter)) {//are conditions all reached, and is this a better path?
                action_dist.set(gr2.counter, c);
                if (action_to_fib_node.get(gr2.counter) == null) {
                    FibonacciHeapNode n = new FibonacciHeapNode(gr2);
                    
//                    Habs.logging("new action due to executions found : ");
//                    Habs.logging(gr.toPDDL() + "\n\n");
                    
                    a_plus.insert(n, c);//push in the set of actions to consider. 
                    action_to_fib_node.set(gr2.counter, n);
                } else {
                    a_plus.decreaseKey(action_to_fib_node.get(gr2.counter), c);//push in the set of actions to consider. 
                }
                //Need to understand whether is worth to do check on the list to see if action already is there.
                if (this.reacheability_setting) {
                    this.reachable.add(gr2);
                }
            }

        }
    }
}
    

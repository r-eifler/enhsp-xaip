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
    
    private boolean setting_up = true;
    
    private List<HashMap<Expression, HashMap<RealInterval, ArrayList<GroundAction>>>> linearSupporters;
    private LinkedHashSet otherSupporters = new LinkedHashSet();
    private LinkedHashSet<GroundAction> stateDependentSupporters;

    
    public Adaptive_Ucs_h1(Conditions goal, Set<GroundAction> A, Set<GroundProcess> P) {
        super(goal, A, P);
        stateDependentSupporters = new LinkedHashSet<>();
    }

    public void setLinearSupporters(List<HashMap<Expression, HashMap<RealInterval, ArrayList<GroundAction>>>> supportersTable) {
        this.linearSupporters = supportersTable;
    }
    
    public void setOtherSupporters(LinkedHashSet otherSupporters) {
        this.otherSupporters = otherSupporters;
    }
    
    @Override
    public Float setup(State s){
        addStateDependentSupporters(s);
        A = stateDependentSupporters;
        
        return super.setup(s);
    }
    
    @Override
    public Float compute_estimate(State s){
        if (setting_up){
            setting_up = false;
        } else {
            addStateDependentSupporters(s);
        }
        
        this.A = stateDependentSupporters;
        return super.compute_estimate(s);
    }
    
    private void addStateDependentSupporters(State s){
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

                    // System.out.println(exprMap.getKey() + " = " + eval);
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
        // propositional effect
        stateDependentSupporters.addAll(otherSupporters);       
    }    
}
    

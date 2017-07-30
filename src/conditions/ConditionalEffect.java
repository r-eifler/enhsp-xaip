
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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conditions;

import domain.Variable;
import expressions.NumEffect;
import expressions.NumFluent;
import heuristics.utils.achiever_set;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import problem.GroundAction;
import problem.RelState;
import problem.State;

/**
 *
 * @author enrico
 */
public class ConditionalEffect extends Conditions implements PostCondition{
    public Conditions activation_condition;
    public PostCondition effect;

    
    public ConditionalEffect(){
        super();
        
    }
    public ConditionalEffect(Conditions lhs, PostCondition rhs){
        super();

        this.activation_condition = lhs;
        effect = rhs;
        
    }
    
    public Conditions clone(){
        return new ConditionalEffect(activation_condition.clone(), (PostCondition) effect.clone());
    }
    
    public String toString(){
        return "(when "+this.activation_condition.pddlPrint(true)+" "+this.effect.pddlPrint(true)+")";
    }


    public ConditionalEffect weakEval(State s, HashMap invF) {
        this.activation_condition.weakEval(s, invF);
        if (this.effect instanceof Conditions){
            Conditions con = (Conditions)this.effect;
            con.weakEval(s, invF);
        }else if (this.effect instanceof ConditionalEffect){
            ConditionalEffect sub = (ConditionalEffect)this.effect;
            sub.weakEval(s, invF);
        }else if (this.effect instanceof NumEffect){
            NumEffect ne = (NumEffect)this.effect;
            ne.weakEval(s, invF);
        }
        return this;
    }

    public ConditionalEffect ground(Map<Variable,PDDLObject> substitution) {
        ConditionalEffect ret = new ConditionalEffect();
        ret.activation_condition = this.activation_condition.ground(substitution);
        
        if (this.effect instanceof Conditions){
            Conditions con = (Conditions)this.effect;
            ret.effect = (PostCondition) con.ground(substitution);
        }else if (this.effect instanceof ConditionalEffect){
            ConditionalEffect sub = (ConditionalEffect)this.effect;
            ret.effect = sub.ground(substitution);
        }else if (this.effect instanceof NumEffect){
            NumEffect ne = (NumEffect)this.effect;
            ret.effect = (NumEffect)ne.ground(substitution);
        }
        ret.grounded = true;
        return ret;    
    }

    @Override
    public Conditions ground(Map substitution, int c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eval(State s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toSmtVariableString(int k, GroundAction gr, String var) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isSatisfied(State s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeVar(Map substitution) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean can_be_true(RelState aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void normalize() {
        this.activation_condition.normalize();
        if (this.effect instanceof Conditions){
            Conditions con = (Conditions)this.effect;
            con.normalize();
        }else if (this.effect instanceof ConditionalEffect){
            ConditionalEffect sub = (ConditionalEffect)this.effect;
            sub.normalize();
        }else if (this.effect instanceof NumEffect){
            NumEffect ne = (NumEffect)this.effect;
            ne.setRight(ne.getRight().normalize());
        }
    }

    @Override
    public Conditions unGround(Map asbstractionOf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isUngroundVersionOf(Conditions conditions) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toSmtVariableString(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<NumFluent> getInvolvedFluents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conditions transform_equality() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean is_affected_by(GroundAction gr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conditions regress(GroundAction gr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String pddlPrintWithExtraObject() {
        return "(when "+this.activation_condition.pddlPrintWithExtraObject()+" "+this.effect.pddlPrintWithExtraObject()+")";
    }

    @Override
    public boolean can_be_false(RelState aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conditions achieve(Predicate p) {
        Conditions c = this.effect.achieve(p);
        if (c==null)
            return null;
        if (c.isValid()){
            return this.activation_condition;
        }
        if (c.isUnsatisfiable())
            return c;
        AndCond and = new AndCond();
        and.addConditions(this.activation_condition);
        and.addConditions(c);
        return and;

    }

    @Override
    public Conditions delete(Predicate p) {
        Conditions c = this.effect.delete(p);
        if (c==null)
            return null;
        if (c.isValid()){
            return this.activation_condition;
        }
        if (c.isUnsatisfiable())
            return c;
        AndCond and = new AndCond();
        and.addConditions(this.activation_condition);
        and.addConditions(c);
        return and;
    }

    @Override
    public int hashCode() {
        final int condHash = activation_condition.hashCode();
        final int effHash = effect.hashCode();
        final int result = (condHash * effHash) + condHash;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null) {
            return false;
        }
        
        if (!(obj instanceof ConditionalEffect)) {
            return false;
        }
        
        final ConditionalEffect other = (ConditionalEffect)obj;
        
        if (!this.activation_condition.equals(other.activation_condition)) {
            return false;
        }
        
        if (!this.effect.equals(other.effect)) {
            return false;
        }
        
        return true;
    }

    @Override
    public HashMap<Object, Object> apply(RelState s) {
        final HashMap<Object,Object> ret = new HashMap<>();
        apply(s, ret);
        return ret;
    }
    
    @Override
    public HashMap<Object,Object> apply(State s) {
        final HashMap<Object,Object> ret = new HashMap<>();
        apply(s, ret);
        return ret;
    }

    @Override
    public void apply(State s, Map modifications) {
        if (s.satisfy(activation_condition)){
            effect.apply(s,modifications);
        }
    }

    @Override
    public void apply(RelState s, Map modifications) {
        if (s.satisfy(activation_condition)){
            effect.apply(s,modifications);
        }
    }
    
    @Override
    public void pddlPrint(boolean typeInformation, StringBuilder bui){
        bui.append("(when ");
        activation_condition.pddlPrint(typeInformation, bui);
        bui.append(" ");
        effect.pddlPrint(typeInformation, bui);
        bui.append(")");
    }

    @Override
    public void storeInvolvedVariables(Collection<Variable> vars) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Conditions> getTerminalConditions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Float estimate_cost(ArrayList<Float> cond_dist, boolean additive_h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conditions and(Conditions precondition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public achiever_set estimate_cost(ArrayList<Float> cond_dist, boolean additive_h, ArrayList<GroundAction> established_achiever) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conditions push_not_to_terminals() {
        this.activation_condition = this.activation_condition.push_not_to_terminals();
        return this;
                //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isSatisfied(RelState rs, ArrayList<Integer> dist, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conditions introduce_red_constraints() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Set<NumFluent> affectedNumericFluents() {
        return this.effect.affectedNumericFluents();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conditions;

import domain.Variable;
import expressions.NumEffect;
import expressions.NumFluent;
import java.util.ArrayList;
import java.util.HashMap;
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
    @Override
    public HashMap<Object,Object> apply(State s) {
        if (s.satisfy(activation_condition)){
            return effect.apply(s);
        }else{
            return new HashMap();
        }
        
    }
    
    public Conditions clone(){
        return new ConditionalEffect(activation_condition.clone(), (PostCondition) effect.clone());
    }
    
    public String toString(){
        return "(when "+this.activation_condition.pddlPrint(true)+" "+this.effect.pddlPrint(true)+")";
    }
    
    public String pddlPrint(boolean typeInformation){
        return "(when "+this.activation_condition.pddlPrint(false)+" "+this.effect.pddlPrint(false)+")";
    }

    @Override
    public HashMap<Object, Object> apply(RelState s) {
        if (s.satisfy(activation_condition)){
            return effect.apply(s);
        }else{
            return new HashMap();
        }
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

    public ConditionalEffect ground(Map substitution) {
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
    public ArrayList<Variable> getInvolvedVariables() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

}

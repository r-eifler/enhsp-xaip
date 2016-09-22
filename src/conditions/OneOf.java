/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conditions;

import expressions.NumFluent;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import problem.GroundAction;
import problem.RelState;
import problem.State;

/**
 *
 * @author enrico
 */
public class OneOf extends Conditions{

    
    public OneOf(){
        super();
        this.sons = new LinkedHashSet();
    }
    @Override
    public Conditions weakEval(State s, HashMap invF) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conditions regress(GroundAction gr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conditions ground(Map substitution) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public String pddlPrint(boolean typeInformation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String pddlPrintWithExtraObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conditions clone() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isSatisfied(RelState aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void normalize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public String toSmtVariableString(int i) {//does not work
        String ret = "";
        Collection<Predicate> to_sum = new LinkedHashSet();
        if (this.sons != null) {
            if (this.sons.size() > 1) {
                ret += "(and (or ";
            }
            for (Object o : this.sons) {
                if (o instanceof Predicate) {
                    Predicate p = (Predicate) o;
                    ret += " " + p.toSmtVariableString(i);
                    to_sum.add(p);
                } 
            }
            if (this.sons.size() > 1) {
                String inner_sum = "(= (+ ";
                for (Predicate p: to_sum){
                    inner_sum += " (to_int (" + p.toSmtVariableString(i)+"))";
                    //inner_sum += " " + p.toSmtVariableString(i);

                }
                inner_sum +=") 1)";
                ret += ") "+inner_sum+")";
            }
        }
        return ret;
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
    
}

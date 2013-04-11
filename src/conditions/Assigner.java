/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conditions;

import expressions.NumFluent;
import expressions.PDDLNumber;
import java.util.Map;
import problem.State;

/**
 *
 * @author enrico
 */
public class Assigner extends Conditions{
    private String operator; //it must be equal to =
    private NumFluent one;
    private PDDLNumber two;
    public Assigner(String operator){
        super();
        this.operator = operator;
    }
    public String toString(){
    
        return "(" +getOperator()+" "+ getOne() + " " + getTwo() +")";
    }

    /**
     * @return the operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     * @param operator the operator to set
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * @return the one
     */
    public NumFluent getOne() {
        return one;
    }

    /**
     * @param one the one to set
     */
    public void setOne(NumFluent one) {
        this.one = one;
    }

    /**
     * @return the two
     */
    public PDDLNumber getTwo() {
        return two;
    }

    /**
     * @param two the two to set
     */
    public void setTwo(PDDLNumber two) {
        this.two = two;
    }

    @Override
    public Conditions ground(Map substitution) {
        Assigner ret = new Assigner(operator);
        ret.one = (NumFluent)one.ground(substitution);
        ret.grounded = true;
        return ret;
    }

    @Override
    public boolean eval(State s) {
        if (s.functionValue(one).getNumber().equals(two.getNumber()))
            return true;
        else
            return false;
    }

    @Override
    public boolean isSatisfied(State s) {
        if (s.functionValue(one).getNumber().equals(two.getNumber()))
            return true;
        else
            return false;
    }

    @Override
    public void changeVar(Map substitution) {
        
        this.one.changeVar(substitution);
    }

    @Override
    public String pddlPrint() {
         return "( = (" + getOne() + " ) " + getTwo() +")";
         
         
    }

    @Override
    public Conditions clone() {
        Assigner ret = new Assigner(operator);
        ret.one = (NumFluent)this.one.clone();
        ret.grounded = this.grounded;
        ret.two = new PDDLNumber(this.two.getNumber());
        return ret;
    }
    
}

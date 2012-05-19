/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conditions;

import expressions.Function;
import expressions.Number;
import java.util.Map;
import problem.State;

/**
 *
 * @author enrico
 */
public class Assign extends Conditions{
    private String operator; //it must be equal to =
    private Function one;
    private Number two;
    public Assign(String operator){
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
    public Function getOne() {
        return one;
    }

    /**
     * @param one the one to set
     */
    public void setOne(Function one) {
        this.one = one;
    }

    /**
     * @return the two
     */
    public Number getTwo() {
        return two;
    }

    /**
     * @param two the two to set
     */
    public void setTwo(Number two) {
        this.two = two;
    }

    @Override
    public Conditions ground(Map substitution) {
        Assign ret = new Assign(operator);
        ret.one = (Function)one.ground(substitution);
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
    
}

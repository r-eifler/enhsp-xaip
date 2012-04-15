/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conditions;

import expressions.Function;
import expressions.Number;

/**
 *
 * @author enrico
 */
public class Assign extends Predicate{
    private String operator; //it must be equal to =
    private Function one;
    private Number two;
    public Assign(String operator){
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
    
}

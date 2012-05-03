/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expressions;

import java.util.Map;


/**
 *
 * @author enrico
 */
public class BinaryOp extends Expression{
    private String operator;
    private Expression one;
    private Expression two;
    
    
    
    public String toString(){
        return getOperator() +" "+ getOne() + " " + getTwo();  
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
    public Expression getOne() {
        return one;
    }

    /**
     * @param one the one to set
     */
    public void setOne(Expression one) {
        this.one = one;
    }

    /**
     * @return the two
     */
    public Expression getTwo() {
        return two;
    }

    /**
     * @param two the two to set
     */
    public void setTwo(Expression two) {
        this.two = two;
    }

    @Override
    public Expression ground(Map substitution) {
        BinaryOp ret = new BinaryOp();
        
        ret.one = one.ground(substitution);
        ret.two = two.ground(substitution);
        
        ret.grounded = true;
        
        return ret;
    }
}

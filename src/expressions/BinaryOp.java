/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expressions;

import java.util.Map;
import problem.State;


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

    @Override
    public Number eval(State s) {
        Number ret_val =null;
        Number first = this.one.eval(s);
        Number second = this.two.eval(s);
        if (this.getOperator().equals("+")){
            ret_val = new Number(new Float(first.getNumber()) + new Float(second.getNumber()));
        }else if (this.getOperator().equals("-")){
            ret_val = new Number(new Float(first.getNumber()) - new Float(second.getNumber()));
        }else if (this.getOperator().equals("*")){
            ret_val = new Number(new Float(first.getNumber()) * new Float(second.getNumber()));
        }else if (this.getOperator().equals("/")){
            //System.out.println("divisione: " + new Float(first.getNumber()) / new Float(second.getNumber()));
            ret_val = new Number(new Float(first.getNumber()) / new Float(second.getNumber()));
        }else if (this.getOperator().equals("min")){
            //System.out.println("min: " + Math.min(first.getNumber(), second.getNumber()));
            ret_val = new Number(new Float(Math.min(first.getNumber(), second.getNumber())));
        }else{
            System.out.println(this.operator + " not supported");
        }
        return ret_val;
    }
    
    @Override
    public NormExpression normalize(){
        NormExpression ret = new NormExpression();
        
        NormExpression left = this.getOne().normalize();
        NormExpression right = this.getTwo().normalize();
        
        
        if (this.getOperator().equals("+")){
            ret = left.sum(right);
        
        }else if (this.getOperator().equals("-")){
            ret = left.minus(right);
        }else if (this.getOperator().equals("*")){
            ret = left.mult(right);

        }else if (this.getOperator().equals("/")){
            ret = left.div(right);

        }else
            System.out.println(this.operator + " not supported");
        
       
        return ret;
    
    }
}

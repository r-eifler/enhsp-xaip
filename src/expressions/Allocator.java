/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expressions;

import expressions.Expression;
import expressions.Function;
import expressions.Number;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import problem.State;

/**
 *
 * @author enrico
 */
public class Allocator extends Expression {
    private String operator;
    private Function one;
    private Expression two;
    public Allocator(String operator){
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
        Allocator ret = new Allocator(this.operator);
        ret.one = (Function)this.one.ground(substitution);
        ret.two = this.two.ground(substitution);
        ret.grounded=true;
        return ret;
    }

    @Override
    public Number eval(State s) {
        Number first = this.one.eval(s);
        Number second = this.two.eval(s);
        if (this.getOperator().equals("increase")){
            return new Number(new Float(first.getNumber()) + new Float(second.getNumber()));
        }else if (this.getOperator().equals("decrease")){
            return new Number(new Float(first.getNumber()) - new Float(second.getNumber()));
        }else if (this.getOperator().equals("assign")){
            return new Number(new Float(second.getNumber()));
        }else{
            System.out.println(this.getOperator() + " does not supported");
        }
        return null;

    }

    
    public void apply(State s) {
        Number after = null;
       if (this.operator.equals("increase")){
           Number current = s.functionValue(one);
           Number eval = this.getTwo().eval(s);
           after = new Number (current.getNumber() + eval.getNumber());
       }else if (this.operator.equals("decrease")){
           Number current = s.functionValue(one);
           Number eval = this.getTwo().eval(s);
           after = new Number (current.getNumber() - eval.getNumber());
       }else if (this.operator.equals("increase")){
           Number eval = this.getTwo().eval(s);
            after = eval;
       }
        if (after != null)
            s.setFunctionValue(one,after);
        
        return ;

    }

    public State applyAndCreateNew(State s) throws CloneNotSupportedException {
        Number after = null;
       if (this.operator.equals("increase")){
           Number current = s.functionValue(one);
           Number eval = this.getTwo().eval(s);
           after = new Number (current.getNumber() + eval.getNumber());
       }else if (this.operator.equals("decrease")){
           Number current = s.functionValue(one);
           Number eval = this.getTwo().eval(s);
           after = new Number (current.getNumber() - eval.getNumber());
       }else if (this.operator.equals("assign")){
           Number eval = this.getTwo().eval(s);
            after = eval;
       }
        State ret = s.clone();

        if (after != null)
            ret.setFunctionValue(one,after);

        return ret;

    }

    @Override
    public NormExpression normalize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}

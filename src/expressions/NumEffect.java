/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expressions;

import expressions.Expression;
import expressions.NumFluent;
import expressions.PDDLNumber;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import problem.State;

/**
 *
 * @author enrico
 */
public class NumEffect extends Expression {
    private String operator;
    private NumFluent one;
    private Expression two;
    public NumEffect(String operator){
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
        NumEffect ret = new NumEffect(this.operator);
        ret.one = (NumFluent)this.one.ground(substitution);
        ret.two = this.two.ground(substitution);
        ret.grounded=true;
        return ret;
    }

    @Override
    public PDDLNumber eval(State s) {
        PDDLNumber first = this.one.eval(s);
        PDDLNumber second = this.two.eval(s);
        if (this.getOperator().equals("increase")){
            return new PDDLNumber(new Float(first.getNumber()) + new Float(second.getNumber()));
        }else if (this.getOperator().equals("decrease")){
            return new PDDLNumber(new Float(first.getNumber()) - new Float(second.getNumber()));
        }else if (this.getOperator().equals("assign")){
            return new PDDLNumber(new Float(second.getNumber()));
        }else{
            System.out.println(this.getOperator() + " does not supported");
        }
        return null;

    }

    
    public void apply(State s) {
        PDDLNumber after = null;
       if (this.operator.equals("increase")){
           PDDLNumber current = s.functionValue(one);
           PDDLNumber eval = this.getTwo().eval(s);
           after = new PDDLNumber (current.getNumber() + eval.getNumber());
       }else if (this.operator.equals("decrease")){
           PDDLNumber current = s.functionValue(one);
           PDDLNumber eval = this.getTwo().eval(s);
           after = new PDDLNumber (current.getNumber() - eval.getNumber());
       }else if (this.operator.equals("increase")){
           PDDLNumber eval = this.getTwo().eval(s);
            after = eval;
       }
        if (after != null)
            s.setFunctionValue(one,after);
        
        return ;

    }

    public State applyAndCreateNew(State s) throws CloneNotSupportedException {
        PDDLNumber after = null;
       if (this.operator.equals("increase")){
           PDDLNumber current = s.functionValue(one);
           PDDLNumber eval = this.getTwo().eval(s);
           after = new PDDLNumber (current.getNumber() + eval.getNumber());
       }else if (this.operator.equals("decrease")){
           PDDLNumber current = s.functionValue(one);
           PDDLNumber eval = this.getTwo().eval(s);
           after = new PDDLNumber (current.getNumber() - eval.getNumber());
       }else if (this.operator.equals("assign")){
           PDDLNumber eval = this.getTwo().eval(s);
            after = eval;
       }
        State ret = s.clone();

        if (after != null)
            ret.setFunctionValue(one,after);

        return ret;

    }

    //@Override
    public NormExpression normalize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void changeVar(Map substitution) {
         this.one.changeVar(substitution);    
         this.two.changeVar(substitution);
    }

    @Override
    public String pddlPrint() {
        return "(" +getOperator()+" "+ getOne().pddlPrint() + " " + getTwo().pddlPrint() +")";

    }

    
}

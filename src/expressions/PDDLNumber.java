/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expressions;

import java.util.HashMap;
import java.util.Map;
import problem.State;

/**
 *
 * @author enrico
 */
public class PDDLNumber extends Expression
{
    private Float number;
    public PDDLNumber(Float n){
        grounded=true;
        number = n;

    }

    public PDDLNumber(int number) {

        grounded = true;
        this.number = new Float(number);

    }
    public String toString(){
    
        return " "+ getNumber() + " ";
    }

    @Override
    public Expression ground(Map substitution) {
        return new PDDLNumber(getNumber());
    }

    /**
     * @return the number
     */
    public Float getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(Float number) {
        this.number = number;
    }

    @Override
    public PDDLNumber eval(State s) {
            return this;
    }

    @Override
    public NormExpression normalize() {
        Addendum a = new Addendum();
        a.n = this;
        a.f = null;
        NormExpression ret = new NormExpression();
        ret.summations.add(a);
        return ret;

    }

    @Override
    public void changeVar(Map substitution) {
        //throw new UnsupportedOperationException("Not supported yet.");
        
    }

    @Override
    public String pddlPrint() {
        return " "+ getNumber() + " ";
    }

    @Override
    public Expression weakEval(State s, HashMap invF) {
        return this;
    }
}

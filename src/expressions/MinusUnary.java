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
public class MinusUnary extends Expression {
    Expression one;

    public MinusUnary() {
        super();
    }

    
    public MinusUnary(Expression expr) {
        super();
        one = expr;
    }

    @Override
    public Expression ground(Map substitution) {
        MinusUnary ret = new MinusUnary();
        
        ret.one = one.ground(substitution);
        ret.grounded=true;
        return ret;
    }

    @Override
    public PDDLNumber eval(State s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public NormExpression normalize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void changeVar(Map substitution) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String pddlPrint() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Expression weakEval(State s, HashMap invF) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Expression clone() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

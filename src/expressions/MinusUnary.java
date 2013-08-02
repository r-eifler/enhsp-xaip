/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expressions;

import conditions.Conditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import problem.RelState;
import problem.State;

/**
 *
 * @author enrico
 */
public class MinusUnary extends Expression {

    Expression element;

    public MinusUnary() {
        super();
    }

    public MinusUnary(Expression expr) {
        super();
        element = expr;
    }

    @Override
    public Expression ground(Map substitution) {
        MinusUnary ret = new MinusUnary();

        ret.element = element.ground(substitution);
        ret.grounded = true;
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

    @Override
    public PDDLNumbers eval(RelState s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean involve(ArrayList<NumFluent> arrayList) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Expression subst(Conditions numeric) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

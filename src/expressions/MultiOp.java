/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expressions;

import conditions.Conditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import problem.RelState;
import problem.State;

/**
 *
 * @author enrico
 */
//only for summations
public class MultiOp extends Expression {

    private String operator;
    private List expr;

    public MultiOp(String operator, List expr) {
        super();
        this.operator = operator;
        this.expr = expr;

        InitList();
    }

    public MultiOp(String operator) {
        super();
        this.operator = operator;
        InitList();
    }

    public MultiOp() {
        super();
        InitList();
    }

    private void InitList() {
        expr = new ArrayList();
    }

    public void addExpression(Object e) {

        expr.add(e);

    }

    @Override
    public String toString() {

        String ret = this.operator;
//        for(Object o: expr){
//            ret += " " + expr;
//        }


        return ret + expr;
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
     * @return the expr
     */
    public List getExpr() {
        return expr;
    }

    /**
     * @param expr the expr to set
     */
    public void setExpr(List expr) {
        this.expr = expr;
    }

    @Override
    public Expression ground(Map substitution) {
        MultiOp ret = new MultiOp();
        for (Object o : expr) {
            Expression e = (Expression) o;
            ret.addExpression(e.ground(substitution));
        }
        ret.grounded = true;
        return ret;
    }

    @Override
    public PDDLNumber eval(State s) {
        PDDLNumber ret_val = new PDDLNumber(0);

        for (Object o : this.expr) {
            Expression e = (Expression) o;
            if (this.getOperator().equals("+")) {
                ret_val = new PDDLNumber(new Float(e.eval(s).getNumber()) + ret_val.getNumber());
            } else {
                System.out.println(this.operator + " not supported");
            }
        }
        return ret_val;
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

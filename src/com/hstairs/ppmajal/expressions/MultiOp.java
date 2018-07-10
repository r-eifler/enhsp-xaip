/* 
 * Copyright (C) 2010-2017 Enrico Scala. Contact: enricos83@gmail.com.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package com.hstairs.ppmajal.expressions;

import com.hstairs.ppmajal.problem.State;
import com.hstairs.ppmajal.problem.EPddlProblem;
import com.hstairs.ppmajal.problem.PDDLObjects;
import com.hstairs.ppmajal.problem.RelState;
import com.hstairs.ppmajal.problem.PddlProblem;
import com.hstairs.ppmajal.conditions.Condition;
import com.hstairs.ppmajal.conditions.PDDLObject;
import com.hstairs.ppmajal.domain.Variable;
import java.util.*;

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
    public Expression ground(Map<Variable, PDDLObject> substitution, PDDLObjects po) {
        MultiOp ret = new MultiOp();
        for (Object o : expr) { // TODO: If all objects are expressions, there should be a cast to Expression
            Expression e = (Expression) o;
            ret.addExpression(e.ground(substitution, po));
        }
        ret.grounded = true;
        return ret;
    }

    @Override
    public Expression unGround(Map substitution) {
        MultiOp ret = new MultiOp();
        for (Object o : expr) {
            Expression e = (Expression) o;
            ret.addExpression(e.unGround(substitution));
        }
        ret.grounded = false;
        return ret;
    }

    @Override
    public Double eval(State s) {
        Double ret_val = 0d;

        for (Object o : this.expr) {
            Expression e = (Expression) o;
            if (this.getOperator().equals("+")) {
                ret_val = e.eval(s) + ret_val;
            } else {
                System.out.println(this.operator + " not supported");
            }
        }
        return ret_val;
    }

    @Override
    public ExtendedNormExpression normalize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void changeVar(Map<Variable, PDDLObject> substitution) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Expression weakEval(PddlProblem s, HashMap invF) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Expression clone() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Interval eval(RelState s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean involve(Collection<NumFluent> arrayList) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Expression subst(Condition numeric) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set rhsFluents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isUngroundVersionOf(Expression expr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Expression susbtFluentsWithTheirInvariants(int j) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Expression susbtFluentsWithTheirInvariants(HashMap<Object, Boolean> invariantFluent, int j) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toSmtVariableString(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean involve(NumFluent a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pddlPrint(boolean typeInformation, StringBuilder bui) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Expression unifyVariablesReferences(EPddlProblem p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
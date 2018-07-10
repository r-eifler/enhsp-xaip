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
import com.hstairs.ppmajal.problem.PDDLObjects;
import com.hstairs.ppmajal.problem.EPddlProblem;
import com.hstairs.ppmajal.problem.RelState;
import com.hstairs.ppmajal.problem.PddlProblem;
import com.hstairs.ppmajal.conditions.Condition;
import com.hstairs.ppmajal.conditions.PDDLObject;
import com.hstairs.ppmajal.domain.Variable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author enrico
 */
public class ComplexFunction extends BinaryOp {

    private Expression arg;

    public ComplexFunction() {
        super();
    }

        @Override
    public Expression unifyVariablesReferences(EPddlProblem p) {
        super.unifyVariablesReferences(p);
        this.arg = this.arg.unifyVariablesReferences(p);  
        return this;
    }
    
    @Override
    public Expression ground(Map<Variable, PDDLObject> substitution, PDDLObjects po) {
        ComplexFunction ret = new ComplexFunction();

        ret.operator = this.operator;
        ret.setArg(getArg().ground(substitution, po));

        ret.grounded = true;

        return ret;

    }

    @Override
    public Expression unGround(Map substitution) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double eval(State s) {
        Double arg_val = getArg().eval(s);
        switch (this.operator) {
            case "abs":
                arg_val = Math.abs(arg_val);
                break;
            default:
                System.out.println("Eval error in: " + this);
                System.exit(-1);
        }
        return arg_val;
    }

    @Override
    public ExtendedNormExpression normalize() {
        this.setArg(getArg().normalize());
        return new ExtendedNormExpression(this);
    }

    @Override
    public void changeVar(Map<Variable, PDDLObject> substitution) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Expression weakEval(PddlProblem s, HashMap invF) {
        ComplexFunction ret = new ComplexFunction();

        ret.operator = this.operator;
        arg.freeVarSemantic = freeVarSemantic;
        ret.setArg(getArg().weakEval(s, invF));

        if (ret.getArg() == null) {
            return null;
        }
        if (ret.getArg() instanceof PDDLNumber) {
            PDDLNumber n = (PDDLNumber) ret.getArg();
            Float arg = n.getNumber();
            return new PDDLNumber(Math.abs(arg));
        }

        return ret;
    }

    @Override
    public Expression clone() {
        ComplexFunction ret = new ComplexFunction();
        ret.operator = operator;
        ret.setArg(getArg().clone());
        return ret;
    }

    @Override
    public Interval eval(RelState s) {
        Interval ret = null;
        Interval arg = this.getArg().eval(s);

        switch (this.operator) {
            case "abs":
                ret = arg.abs();
                break;
            default:
                System.out.println("Eval error in: " + this);
                System.exit(-1);
        }
        return ret;
    }

    @Override
    public boolean involve(Collection<NumFluent> arrayList) {
        return getArg().involve(arrayList);
    }

    @Override
    public Expression subst(Condition numeric) {
        ComplexFunction ret = (ComplexFunction) this.clone();
        ret.setArg(getArg().subst(numeric));
        return ret;

    }

    @Override
    public Set rhsFluents() {
        return this.getArg().rhsFluents();
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
        return getArg().involve(a);
    }

    /**
     * @return the arg
     */
    public Expression getArg() {
        return arg;
    }

    /**
     * @param arg the arg to set
     */
    public void setArg(Expression arg) {
        this.arg = arg;
    }

    @Override
    public void pddlPrint(boolean typeInformation, StringBuilder bui) {
        bui.append("(");
        bui.append(operator);
        bui.append("(");
        bui.append(getArg());
        bui.append("))");
    }
}
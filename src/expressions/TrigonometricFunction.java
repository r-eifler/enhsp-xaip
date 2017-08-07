
/**
 * *******************************************************************
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 *
 ********************************************************************
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expressions;

import conditions.Conditions;
import conditions.PDDLObject;
import domain.Variable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import problem.PDDLObjects;
import problem.RelState;
import problem.State;

/**
 *
 * @author enrico
 */
public class TrigonometricFunction extends BinaryOp {

    private Expression arg;

    public TrigonometricFunction() {
        super();
    }

    @Override
    public Expression ground(Map<Variable,PDDLObject> substitution,PDDLObjects po) {
        TrigonometricFunction ret = new TrigonometricFunction();

        ret.operator = this.operator;
        ret.setArg(getArg().ground(substitution,po));

        ret.grounded = true;

        return ret;

    }

    @Override
    public Expression unGround(Map substitution) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PDDLNumber eval(State s) {
        double arg_val = getArg().eval(s).getNumber();
        switch (this.operator) {
            case "sin":
                arg_val = Math.sin(arg_val);
                break;
            case "cos":
                arg_val = Math.cos(arg_val);
                break;
            default:
                System.out.println("Eval error in: " + this);
                System.exit(-1);
        }
        return new PDDLNumber(new Float(arg_val));
    }

    @Override
    public ExtendedNormExpression normalize() {
        this.setArg(getArg().normalize());
        return new ExtendedNormExpression(this);
    }

    @Override
    public void changeVar(Map<Variable,PDDLObject> substitution) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Expression weakEval(State s, HashMap invF) {
        TrigonometricFunction ret = new TrigonometricFunction();

        ret.operator = this.operator;
        arg.freeVarSemantic = freeVarSemantic;
        ret.setArg(getArg().weakEval(s, invF));

        if (ret.getArg() == null) {
            return null;
        }

        return ret;
    }

    @Override
    public Expression clone() {
        TrigonometricFunction ret = new TrigonometricFunction();
        ret.operator = operator;
        ret.setArg(getArg().clone());
        return ret;
    }

    @Override
    public Interval eval(RelState s) {
        Interval ret = null;
        Interval arg = this.getArg().eval(s);
        
        switch (this.operator) {
            case "sin":
                ret = arg.sin();
                break;
            case "cos":
                ret = arg.cos();
                break;
            default:
                System.out.println("Eval error in: " + this);
                System.exit(-1);
        }
        return ret;
    }

    @Override
    public boolean involve(HashMap<NumFluent, Boolean> input) {
        return getArg().involve(input);
    }

    @Override
    public Expression subst(Conditions numeric) {
        TrigonometricFunction ret = (TrigonometricFunction) this.clone();
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expressions;

import conditions.Conditions;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import problem.RelState;
import problem.State;

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
    public Expression ground(Map substitution) {
        ComplexFunction ret = new ComplexFunction();

        ret.operator = this.operator;
        ret.setArg(getArg().ground(substitution));

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
            case "abs":
                arg_val = Math.abs(arg_val);
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
    public void changeVar(Map substitution) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String pddlPrint(boolean typeInformation) {
        return "(" + this.operator + "(" + this.getArg() + "))";
    }

    @Override
    public Expression weakEval(State s, HashMap invF) {
        ComplexFunction ret = new ComplexFunction();

        ret.operator = this.operator;
        arg.freeVarSemantic = freeVarSemantic;
        ret.setArg(getArg().weakEval(s, invF));

        
        
        if (ret.getArg() == null) {
            return null;
        }
        if (ret.getArg() instanceof PDDLNumber){
            PDDLNumber n = (PDDLNumber)ret.getArg();
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
    public boolean involve(HashMap<NumFluent, Boolean> input) {
        return getArg().involve(input);
    }

    @Override
    public Expression subst(Conditions numeric) {
        ComplexFunction ret = (ComplexFunction) this.clone();
        ret.setArg(getArg().subst(numeric));
        return ret;

    }

    @Override
    public Set fluentsInvolved() {
        return this.getArg().fluentsInvolved();
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

}

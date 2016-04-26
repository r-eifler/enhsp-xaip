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
/**
 * *******************************************************************
 * Description: Part of the PPMaJaL library
 *
 * Author: Enrico Scala 2013 Contact: enricos83@gmail.com
 *
 ********************************************************************
 */
package expressions;

import conditions.Conditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import problem.RelState;
import problem.State;

/**
 *
 * @author enrico
 */
public class BinaryOp extends Expression {

    private String operator;
    private Expression left;
    private Expression right;

    public BinaryOp() {
        super();

    }

    public BinaryOp(Expression one, String string, Expression two, boolean grounded) {
        this.operator = string;
        this.left = one;
        this.right = two;
        this.grounded = grounded;

    }

    public String toString() {
        return "(" + getOperator() + " (" + getOne() + " " + getRight() + "))";
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
    public Expression getOne() {
        return left;
    }

    /**
     * @param one the one to set
     */
    public void setOne(Expression one) {
        this.left = one;
    }

    /**
     * @return the right element of the binary operation
     */
    public Expression getRight() {
        return right;
    }

    /**
     * @param right the two to set
     */
    public void setRight(Expression right) {
        this.right = right;
    }

    @Override
    public Expression ground(Map substitution) {
        BinaryOp ret = new BinaryOp();

        ret.operator = this.operator;
        ret.left = left.ground(substitution);
        ret.right = right.ground(substitution);

        ret.grounded = true;

        return ret;
    }

    @Override
    public PDDLNumber eval(State s) {
        PDDLNumber ret_val = null;
        PDDLNumber first = this.left.eval(s);
        PDDLNumber second = this.right.eval(s);
        if ((first == null) || (second == null)) {
            return null;//negation by failure.
        }
        switch (this.getOperator()) {
            case "+":
                ret_val = new PDDLNumber(first.getNumber() + second.getNumber());
                break;
            case "-":
                ret_val = new PDDLNumber(first.getNumber() - second.getNumber());
                break;
            case "*":
                ret_val = new PDDLNumber(first.getNumber() * second.getNumber());
                break;
            case "/":
                //System.out.println("divisione: " + new Float(first.getNumber()) / new Float(second.getNumber()));
                ret_val = new PDDLNumber(first.getNumber() / second.getNumber());
                break;
            case "min":
                //System.out.println("min: " + Math.min(first.getNumber(), second.getNumber()));
                ret_val = new PDDLNumber(Math.min(first.getNumber(), second.getNumber()));
                break;
            case "^":
                //System.out.println("min: " + Math.min(first.getNumber(), second.getNumber()));
                ret_val = new PDDLNumber((float) Math.pow(first.getNumber(), second.getNumber()));
                break;
            default:
                System.out.println(this.operator + " not supported");
                break;
        }
        return ret_val;
    }

    @Override
    public ExtendedNormExpression normalize() {
        ExtendedNormExpression ret = new ExtendedNormExpression();
        this.setOne(this.getOne().normalize());
        this.setRight(this.getRight().normalize());
        
        
        
        ExtendedNormExpression l = (ExtendedNormExpression)this.getOne();
        ExtendedNormExpression r = (ExtendedNormExpression)this.getRight();

        try {
            if ((!l.isNumber() && (this.getOperator().equals("^"))) || (!l.isNumber() && !r.isNumber() && (this.getOperator().equals("*") || this.getOperator().equals("/")))) {
                BinaryOp bin = new BinaryOp();
                bin.setOperator(this.getOperator());
                bin.setOne(l);
                bin.setRight(r);
                
                 ret = new ExtendedNormExpression(bin);
                ret.linear = false;
                //System.out.println("Addendum:"+ret);
            } else {
                try {
                    switch (this.getOperator()) {
                        case "+":
                            ret = l.sum(r);
                            break;
                        case "-":
                            ret = l.minus(r);
                            break;
                        case "*":
                            //            System.out.println("DEBUG: left:"+left+" right:"+right);
                            ret = l.mult(r);
                            break;
                        case "/":
                            ret = l.div(r);
                            break;
                        case "^":
                            ret = l.pow(r);
                            break;
                        default:
                            System.out.println(this.operator + " not supported");
                            break;
                    }

                } catch (Exception ex) {
                    Logger.getLogger(ExtendedNormExpression.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(BinaryOp.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(this);
//        System.out.println("Left: "+l);
//        System.out.println("Right: "+r);
//        System.out.println("Result: "+ ret);
//        
        return ret;

    }

    @Override
    public void changeVar(Map substitution) {
        this.left.changeVar(substitution);
        this.right.changeVar(substitution);

    }

    @Override
    public String pddlPrint(boolean typeInformation) {

        return "(" + getOperator() + " " + getOne().pddlPrint(typeInformation) + " " + getRight().pddlPrint(typeInformation) + ")";

    }

    @Override
    public Expression weakEval(State s, HashMap invF) {
        BinaryOp ret = new BinaryOp();

        ret.operator = this.operator;
        left.freeVarSemantic = freeVarSemantic;
        right.freeVarSemantic = freeVarSemantic;
        ret.left = left.weakEval(s, invF);
        ret.right = right.weakEval(s, invF);

        if (ret.left == null || ret.right == null) {
            return null;
        }

        return ret;

    }

    @Override
    public Expression clone() {
        BinaryOp ret = new BinaryOp();

        ret.operator = this.operator;
        ret.left = left.clone();
        ret.right = right.clone();

        ret.grounded = this.grounded;

        return ret;
    }

    @Override
    public Interval eval(RelState s) {
        Interval ret_val = null;
        Interval first = this.left.eval(s);
        Interval second = this.right.eval(s);

//        System.out.println(this);
        if ((first == null) || (second == null) || first.is_not_a_number || second.is_not_a_number) {
            return null;
        }
        if ((first.inf == null) || (first.sup == null) || (second.inf == null) || (second.sup == null)) {
            return null;//negation by failure.
        }
        if (this.getOperator().equals("+")) {
            ret_val = first.sum(second);
//            ret_val.inf = new PDDLNumber(new Float(first.inf.getNumber()) + new Float(second.inf.getNumber()));
//            ret_val.sup = new PDDLNumber(new Float(first.sup.getNumber()) + new Float(second.sup.getNumber()));
        } else if (this.getOperator().equals("-")) {
            ret_val = first.subtract(second);
//            ret_val.inf = new PDDLNumber(new Float(first.inf.getNumber()) - new Float(second.sup.getNumber()));
//            ret_val.sup = new PDDLNumber(new Float(first.sup.getNumber()) - new Float(second.inf.getNumber()));
        } else if (this.getOperator().equals("*")) {
            ret_val = first.mult(second);
//            Float ac = new Float(first.inf.getNumber()) * new Float(second.inf.getNumber());
//            Float ad = new Float(first.inf.getNumber()) * new Float(second.sup.getNumber());
//            Float bc = new Float(first.sup.getNumber()) * new Float(second.inf.getNumber());
//            Float bd = new Float(first.sup.getNumber()) * new Float(second.sup.getNumber());
//            ret_val.inf = new PDDLNumber(Math.min(ac, Math.min(ad, Math.min(bc,bd))));
//            ret_val.sup = new PDDLNumber(Math.max(ac, Math.max(ad, Math.max(bc,bd))));
        } else if (this.getOperator().equals("/")) {
            ret_val = first.div(second);
//            Float ac = new Float(first.inf.getNumber()) / new Float(second.inf.getNumber());
//            Float ad = new Float(first.inf.getNumber()) / new Float(second.sup.getNumber());
//            Float bc = new Float(first.sup.getNumber()) / new Float(second.inf.getNumber());
//            Float bd = new Float(first.sup.getNumber()) / new Float(second.sup.getNumber());
//            ret_val.inf = new PDDLNumber(Math.min(ac, Math.min(ad, Math.min(bc,bd))));
//            ret_val.sup = new PDDLNumber(Math.max(ac, Math.max(ad, Math.max(bc,bd))));
            //System.out.println("divisione: " + new Float(first.getNumber()) / new Float(second.getNumber()));
//            ret_val = new PDDLNumber(new Float(first.getNumber()) / new Float(second.getNumber()));
        } else if (this.getOperator().equals("^")){
            ret_val = first.pow(second);

        }
        return ret_val;
    }

    @Override
    public boolean involve(HashMap<NumFluent, Boolean> arrayList) {
        if (this.left.involve(arrayList)) {
            return true;
        } else {
            return this.right.involve(arrayList);
        }
    }

    @Override
    public Expression subst(Conditions numeric) {
        BinaryOp ret = (BinaryOp) this.clone();
        ret.left = ret.left.subst(numeric);
        ret.right = ret.right.subst(numeric);
        return ret;
    }

    @Override
    public Set fluentsInvolved() {
        Set ret = new HashSet();
        ret.addAll(this.left.fluentsInvolved());
        ret.addAll(this.right.fluentsInvolved());
        return ret;
    }

    @Override
    public Expression unGround(Map substitution) {
        BinaryOp ret = new BinaryOp();

        ret.operator = this.operator;
        ret.left = left.unGround(substitution);
        ret.right = right.unGround(substitution);

        ret.grounded = false;

        return ret;
    }

    @Override
    public boolean isUngroundVersionOf(Expression expr) {
        if (expr instanceof BinaryOp) {
            BinaryOp bin = (BinaryOp) expr;
            if (bin.getOperator().equals(this.getOperator())) {
                if (this.getOne().isUngroundVersionOf(bin.getOne()) && this.getRight().isUngroundVersionOf(bin.getRight())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Expression susbtFluentsWithTheirInvariants(int j) {
        this.left = this.left.susbtFluentsWithTheirInvariants(j);
        this.right = this.right.susbtFluentsWithTheirInvariants(++j);
        return this;

    }

    @Override
    public Expression susbtFluentsWithTheirInvariants(HashMap<Object, Boolean> invariantFluent, int j) {
        this.left = this.left.susbtFluentsWithTheirInvariants(invariantFluent, j);
        this.right = this.right.susbtFluentsWithTheirInvariants(invariantFluent, ++j);
        return this;
    }

    @Override
    public String toSmtVariableString(int i) {
        return "(" + this.operator + " " + this.getOne().toSmtVariableString(i) + " " + this.getRight().toSmtVariableString(i) + ")";
    }

    @Override
    public boolean involve(NumFluent a) {
        if (this.left.involve(a)) {
            return true;
        } else {
            return this.right.involve(a);
        }
    }
}

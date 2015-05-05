/*********************************************************************
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 * 
 *********************************************************************/

/*********************************************************************
 * Description: Part of the PPMaJaL library
 *             
 * Author: Enrico Scala 2013
 * Contact: enricos83@gmail.com
 *
 *********************************************************************/ 

package expressions;

import conditions.Conditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import problem.RelState;
import problem.State;

/**
 *
 * @author Enrico Scala
 */
public class NumEffect extends Expression {

    private String operator;
    private NumFluent fluentAffected;
    private Expression right;

    /**
     *
     * @param operator
     */
    public NumEffect(String operator) {
        super();
        this.operator = operator;
    }

    /**
     *
     * @return
     */
    public String toString() {

        return "(" + getOperator() + " " + getFluentAffected() + " " + getRight() + ")";
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
     * @return the fluentAffected
     */
    public NumFluent getFluentAffected() {
        return fluentAffected;
    }

    /**
     * @param fluentAffected the fluentAffected to set
     */
    public void setFluentAffected(NumFluent fluentAffected) {
        this.fluentAffected = fluentAffected;
    }

    /**
     * @return the right element of the operation
     */
    public Expression getRight() {
        return right;
    }

    /**
     * @param right the right element of the operation to set
     */
    public void setRight(Expression right) {
        this.right = right;
    }

    /**
     *
     * @param substitution a substitution for variables. It is a mapping of object to variable
     * @return a new Grounded NumEffect object
     */
    @Override
    public Expression ground(Map substitution) {
        NumEffect ret = new NumEffect(this.operator);
        ret.fluentAffected = (NumFluent) this.fluentAffected.ground(substitution);
        ret.right = this.right.ground(substitution);
        ret.grounded = true;
        return ret;
    }
    
    @Override
    public Expression unGround(Map substitution) {
        NumEffect ret = new NumEffect(this.operator);
        ret.fluentAffected = (NumFluent) this.fluentAffected.unGround(substitution);
        ret.right = this.right.unGround(substitution);
        ret.grounded = false;
        return ret;
    }
    

    /**
     *
     * @param state the state in which the expression is to be evaluated
     * @return a PDDLNumber or Null in case the operation is not supported
     */
    @Override
    public PDDLNumber eval(State state) {
        PDDLNumber first = this.fluentAffected.eval(state);
        PDDLNumber second = this.right.eval(state);
        if (this.getOperator().equals("increase")) {
            return new PDDLNumber(new Float(first.getNumber()) + new Float(second.getNumber()));
        } else if (this.getOperator().equals("decrease")) {
            return new PDDLNumber(new Float(first.getNumber()) - new Float(second.getNumber()));
        } else if (this.getOperator().equals("assign")) {
            return new PDDLNumber(new Float(second.getNumber()));
        } else {
            System.out.println(this.getOperator() + " does not supported");
        }
        return null;

    }

    /**
     *
     * @param state the state in which the effect are applied
     */
    public void apply(State state) {


        PDDLNumber after = null;
        if (this.operator.equals("increase")) {
            PDDLNumber current = state.functionValue(fluentAffected);
            PDDLNumber eval = this.getRight().eval(state);
            after = new PDDLNumber(current.getNumber() + eval.getNumber());
        } else if (this.operator.equals("decrease")) {
            PDDLNumber current = state.functionValue(fluentAffected);
            PDDLNumber eval = this.getRight().eval(state);
            after = new PDDLNumber(current.getNumber() - eval.getNumber());
        } else if (this.operator.equals("assign")) {
            PDDLNumber eval = this.getRight().eval(state);
            after = eval;
        }
        if (after != null) {
            state.setFunctionValue(fluentAffected, after);
        }

        return;

    }

    /**
     *
     * @param s
     * @return
     * @throws CloneNotSupportedException
     */
    public State applyAndCreateNew(State s) throws CloneNotSupportedException {
        PDDLNumber after = null;
        if (this.operator.equals("increase")) {
            PDDLNumber current = s.functionValue(fluentAffected);
            PDDLNumber eval = this.getRight().eval(s);
            after = new PDDLNumber(current.getNumber() + eval.getNumber());
        } else if (this.operator.equals("decrease")) {
            PDDLNumber current = s.functionValue(fluentAffected);
            PDDLNumber eval = this.getRight().eval(s);
            after = new PDDLNumber(current.getNumber() - eval.getNumber());
        } else if (this.operator.equals("assign")) {
            PDDLNumber eval = this.getRight().eval(s);
            after = eval;
        }
        State ret = s.clone();

        if (after != null) {
            ret.setFunctionValue(fluentAffected, after);
        }

        return ret;

    }

    //@Override
    /**
     *
     * @return
     */
    public NormExpression normalize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     * @param substitution
     */
    @Override
    public void changeVar(Map substitution) {
        this.fluentAffected.changeVar(substitution);
        this.right.changeVar(substitution);
    }

    /**
     *
     * @return
     */
    @Override
    public String pddlPrint(boolean typeInformation) {
        return "(" + getOperator() + " " + getFluentAffected().pddlPrint(typeInformation) + " " + getRight().pddlPrint(typeInformation) + ")";

    }

    /**
     *
     * @param s
     * @param invF
     * @return
     */
    @Override
    public Expression weakEval(State s, HashMap invF) {
        NumEffect ret = new NumEffect(this.operator);
        ret.fluentAffected = (NumFluent) this.fluentAffected.weakEval(s, invF);
        ret.right = this.right.weakEval(s, invF);
        return ret;
    }

    /**
     *
     * @return
     */
    @Override
    public Expression clone() {
        NumEffect ret = new NumEffect(this.operator);
        ret.fluentAffected = (NumFluent) this.fluentAffected.clone();
        ret.right = this.right.clone();
        ret.grounded = this.grounded;
        return ret;
    }

    /**
     *
     * @param s
     * @return
     */
    @Override
    public PDDLNumbers eval(RelState s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     * @param s
     */
    public void apply(RelState s) {

        PDDLNumbers after = null;
        PDDLNumbers current = s.functionValues(fluentAffected);
        PDDLNumbers eval = this.getRight().eval(s);

        if (this.operator.equals("increase")) {
            after.inf.setNumber(Math.min(current.sum(eval).inf.getNumber(), current.inf.getNumber()));
            after.sup.setNumber(Math.max(current.sum(eval).sup.getNumber(), current.sup.getNumber()));

        } else if (this.operator.equals("decrease")) {
            after.inf.setNumber(Math.min(current.subtract(eval).inf.getNumber(), current.inf.getNumber()));
            after.sup.setNumber(Math.max(current.subtract(eval).sup.getNumber(), current.sup.getNumber()));

        } else if (this.operator.equals("assign")) {
            after.inf.setNumber(Math.min(eval.inf.getNumber(), current.inf.getNumber()));
            after.sup.setNumber(Math.max(eval.sup.getNumber(), current.sup.getNumber()));
        }

        if (after != null) {
            s.setFunctionValues(fluentAffected, after);
        }

        return;

    }

    /**
     *
     * @param arrayList
     * @return
     */
    @Override
    public boolean involve(ArrayList<NumFluent> arrayList) {
        return this.getRight().involve(arrayList);
    }

    /**
     *
     * @param numeric
     * @return
     */
    @Override
    public Expression subst(Conditions numeric) {

        //NumEffect ret = (NumEffect)this.clone();

        NumEffect ret = (NumEffect) this.clone();
        ret.right = ret.right.subst(numeric);

        if (numeric == null) {
            return ret;
        }
        if (numeric.sons.isEmpty()) {
            return ret;
        }

        if (ret.getOperator().equals("assign")) {
            return ret;
        }
        for (Object o : numeric.sons) {
            NumEffect ef = (NumEffect) o;
            if (ef.fluentAffected.equals(ret.fluentAffected)) {


                if (ef.getOperator().equals("assign")) {
                    ret.setRight(new BinaryOp(ret.right, "-", new BinaryOp(ef.right, "-", ret.fluentAffected, true), true));
                } else if (ef.getOperator().equals(ret.getOperator())) {
                    ret.setRight(new BinaryOp(ret.right, "+", ef.right, true));
                } else {
                    ret.setRight(new BinaryOp(ret.right, "-", ef.right, true));
                }


            }
        }

        return ret;
    }

    @Override
    public Set fluentsInvolved() {
        return this.right.fluentsInvolved();
    }
}

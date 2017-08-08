/**
 * *******************************************************************
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
 ********************************************************************
 */
/**
 * *******************************************************************
 * Description: Part of the PPMaJaL library
 *
 * Author: Enrico Scala 2013
 * Contact: enricos83@gmail.com
 *
 ********************************************************************
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
public abstract class Expression extends Object {

    public boolean grounded;
    protected boolean freeVarSemantic = false;

    public Expression() {
        grounded = false;
    }

    /**
     * Substitutes the variables in this expression with the PDDLObjects
     * associated to each variable in the specified table. The returned
     * expression is therefore grounded. This method may fail if there is no
     * substitution for some variable.
     *
     * @param substitution the map that indicates what object should replace the
     * specified variable.
     * @return a copy of this expression where each variable is replaced to the
     * object according to the specified mapping.
     */
    public abstract Expression ground(Map<Variable, PDDLObject> substitution, PDDLObjects po);

    public abstract Expression unGround(Map substitution);

    public abstract PDDLNumber eval(State s);

    //public abstract State apply(State s);
    public abstract ExtendedNormExpression normalize();

    public abstract void changeVar(Map<Variable, PDDLObject> substitution);

    public abstract Expression weakEval(State s, HashMap invF);

    @Override
    public abstract Expression clone();

    public abstract Interval eval(RelState s);

    public abstract boolean involve(HashMap<NumFluent, Boolean> arrayList);

    public abstract Expression subst(Conditions numeric);

    public abstract Set<NumFluent> rhsFluents();

    public abstract boolean isUngroundVersionOf(Expression expr);

    public abstract Expression susbtFluentsWithTheirInvariants(int j);

    public abstract Expression susbtFluentsWithTheirInvariants(HashMap<Object, Boolean> invariantFluent, int j);

    public abstract String toSmtVariableString(int i);

    /**
     * @return the freeVarSemantic
     */
    public boolean isFreeVarSemantic() {
        return freeVarSemantic;
    }

    /**
     * @param freeVarSemantic the freeVarSemantic to set
     */
    public void setFreeVarSemantic(boolean freeVarSemantic) {
        this.freeVarSemantic = freeVarSemantic;
    }

    public abstract boolean involve(NumFluent a);

    /**
     * Returns a string representation of this expression in PDDL format.
     *
     * @param typeInformation <tt>true</tt>
     * if the type of the object should be printed as well.
     * @return a string representation in PDDL format of this condition.
     */
    public final String pddlPrint(boolean typeInformation) {
        final StringBuilder bui = new StringBuilder();
        pddlPrint(typeInformation, bui);
        return bui.toString();
    }

    /**
     * Prints this expression in PDDL format in the specified string builder.
     *
     * @param typeInformation <tt>true</tt>
     * if the type of the object should be printed as well.
     * @param bui the string builder where this condition is printed.
     */
    public abstract void pddlPrint(boolean typeInformation, StringBuilder bui);
}

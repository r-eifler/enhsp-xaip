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

package conditions;

import expressions.NumFluent;
import expressions.PDDLNumber;
import java.util.HashSet;
import java.util.Map;
import problem.RelState;
import problem.State;

/**
 *
 * @author Enrico Scala
 */
public class NumFluentAssigner extends Conditions {

    private String operator; //it must be equal to =
    private NumFluent nFluent;
    private PDDLNumber nFluentValue;
    private PDDLNumber nFlunetValueUpperBound;//only for relaxed state. In case such value is not null it represents the upper bound of the domain of the fluent whereas nFluentValue represents the lower bound
    public HashSet son;

    public NumFluentAssigner(String operator) {
        super();
        this.operator = operator;
        this.nFlunetValueUpperBound = null;
    }

    public String toString() {

        if (this.nFlunetValueUpperBound == null) {
            return "(" + getOperator() + " " + getNFluent() + " " + getTwo() + ")";
        } else {
            return "(" + getOperator() + " " + getNFluent() + " (" + getTwo() + "," + this.getNFlunetValueUpperBound() + "))";
        }
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
     * @return the nFluent
     */
    public NumFluent getNFluent() {
        return nFluent;
    }

    /**
     * @param nFluent the nFluent to set
     */
    public void setNFluent(NumFluent nFluent) {
        this.nFluent = nFluent;
    }

    /**
     * @return the nFluentValue
     */
    public PDDLNumber getTwo() {
        return nFluentValue;
    }

    /**
     * @param nFluentValue the nFluentValue to set
     */
    public void setTwo(PDDLNumber two) {
        this.nFluentValue = two;
    }

    @Override
    public Conditions ground(Map substitution) {
        NumFluentAssigner ret = new NumFluentAssigner(operator);
        ret.nFluent = (NumFluent) nFluent.ground(substitution);
        ret.grounded = true;
        return ret;
    }

    @Override
    public boolean eval(State s) {
        if (s.functionValue(nFluent).getNumber().equals(nFluentValue.getNumber())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isSatisfied(State s) {
        if (s.functionValue(nFluent).getNumber().equals(nFluentValue.getNumber())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isSatisfied(RelState s) {
        if (s.functionSupValue(nFluent).getNumber() >= s.functionInfValue(nFluent).getNumber()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void changeVar(Map substitution) {

        this.nFluent.changeVar(substitution);
    }

    @Override
    public String pddlPrint(boolean typeInformation) {
        return "( = (" + getNFluent() + " ) " + getTwo() + ")";


    }

    @Override
    public Conditions clone() {
        NumFluentAssigner ret = new NumFluentAssigner(operator);
        ret.nFluent = (NumFluent) this.nFluent.clone();
        ret.grounded = this.grounded;
        ret.nFluentValue = new PDDLNumber(this.nFluentValue.getNumber());
        return ret;
    }

    /**
     * @return the nFlunetValueUpperBound
     */
    public PDDLNumber getNFlunetValueUpperBound() {
        return nFlunetValueUpperBound;
    }

    /**
     * @param nFlunetValueUpperBound the nFlunetValueUpperBound to set
     */
    public void setNFlunetValueUpperBound(PDDLNumber nFlunetValueUpperBound) {
        this.nFlunetValueUpperBound = nFlunetValueUpperBound;
    }

    @Override
    public void normalize() {
        return;
    }



}

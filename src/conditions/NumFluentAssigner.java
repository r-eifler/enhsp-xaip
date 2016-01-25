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
import expressions.PDDLNumbers;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import problem.GroundAction;
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
    
    public NumFluentAssigner(String fluent,float value) {
        super();
        this.operator = "=";
        this.nFlunetValueUpperBound = null;
        nFluent = new NumFluent(fluent);
        
        this.setTwo(new PDDLNumber(value));
    }
    
    public NumFluentAssigner(NumFluent fluent,float value) {
        super();
        this.operator = "=";
        this.nFlunetValueUpperBound = null;
        nFluent = fluent;
        
        this.setTwo(new PDDLNumber(value));
    }
    public NumFluentAssigner(NumFluent fluent,PDDLNumbers poss_values) {
        super();
        this.operator = "=";
        this.nFlunetValueUpperBound = null;
        nFluent = fluent;
        this.nFluentValue = poss_values.inf;
        this.nFlunetValueUpperBound = poss_values.sup;
        
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
    public Conditions ground(Map substitution, int c) {
        Conditions ret = this.ground(substitution);
        ret.setCounter(c);
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

    @Override
    public Conditions unGround(Map asbstractionOf) {
        NumFluentAssigner ret = new NumFluentAssigner(operator);
        ret.nFluent = (NumFluent) nFluent.unGround(asbstractionOf);
        ret.grounded = false;
        return ret;
    }    

    @Override
    public boolean isUngroundVersionOf(Conditions conditions) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toSmtVariableString(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<NumFluent> getInvolvedFluents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NumFluentAssigner other = (NumFluentAssigner) obj;
        if (this.nFluent != other.nFluent && (this.nFluent == null || !this.nFluent.equals(other.nFluent))) {
            return false;
        }
        if (this.nFluentValue != other.nFluentValue && (this.nFluentValue == null || !this.nFluentValue.equals(other.nFluentValue))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.nFluent != null ? this.nFluent.hashCode() : 0);
        hash = 97 * hash + (this.nFluentValue != null ? this.nFluentValue.hashCode() : 0);
        return hash;
    }

    @Override
    public Conditions weakEval(State s, HashMap invF) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toSmtVariableString(int k, GroundAction gr, String var) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conditions transform_equality() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}

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
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import problem.RelState;
import problem.State;

/**
 *
 * @author enrico
 */
public class PDDLNumber extends Expression {

    private Float number;

    public PDDLNumber() {
        super();
        grounded = true;
    }
    public PDDLNumber(Float n) {
        grounded = true;
        number = n;

    }
    public PDDLNumber(float number) {

        grounded = true;
        this.number = number;

    }
    public PDDLNumber(int number) {

        grounded = true;
        this.number = new Float(number);

    }

    @Override
    public String toString() {

        return " " + String.format("%.2f",this.getNumber()) + " ";
    }

    @Override
    public Expression ground(Map substitution) {
        return new PDDLNumber(getNumber());
    }
    
    @Override
    public Expression unGround(Map substitution) {
        return new PDDLNumber(getNumber());
    }

    /**
     * @return the number
     */
    public Float getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(Float number) {
        this.number = number;
    }

    @Override
    public PDDLNumber eval(State s) {
        return this;
    }

    @Override
    public ExtendedNormExpression normalize() {
        ExtendedAddendum a = new ExtendedAddendum();
        a.n = this;
        a.f = null;
        ExtendedNormExpression ret = new ExtendedNormExpression();
        ret.summations.add(a);
        return ret;

    }

    @Override
    public void changeVar(Map substitution) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String pddlPrint(boolean typeInformation) {
        //return String.
        return toString();
//        return " " + String.format("%.2f",this.getNumber()) + " ";
    }

    @Override
    public Expression weakEval(State s, HashMap invF) {
        return this;
    }

    @Override
    public Expression clone() {
        //return new PDDLNumber(this.getNumber());
        return this;
    }

    @Override
    public Interval eval(RelState s) {
        return new Interval(this.getNumber());
    }

    @Override
    public boolean involve(HashMap<NumFluent,Boolean> arrayList) {
        return false;
    }

    @Override
    public Expression subst(Conditions numeric) {
        return this;
    }

    @Override
    public Set fluentsInvolved() {
        return new HashSet(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isUngroundVersionOf(Expression expr) {
        if (expr instanceof PDDLNumber){
            PDDLNumber num = (PDDLNumber)expr;
            if (this.getNumber().equals(num.getNumber()))
                return true;
        }
        return false;
    }

    @Override
    public Expression susbtFluentsWithTheirInvariants(int j) {
        return this;
    }

    @Override
    public Expression susbtFluentsWithTheirInvariants(HashMap<Object, Boolean> invariantFluent, int j) {
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.number != null ? this.number.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PDDLNumber other = (PDDLNumber) obj;
        if (this.number != other.number && (this.number == null || !this.number.equals(other.number))) {
            return false;
        }
        return true;
    }

    @Override
    public String toSmtVariableString(int i) {
//        System.out.println("Variable sign:");
        if (this.getNumber() < 0f){
//            System.out.println("negative");
            return "(- " + String.format("%.4f",this.getNumber()*-1f) + ") ";
        }else
            return " " + String.format("%.4f",this.getNumber()).replace("-", "") + " ";

    }

    @Override
    public boolean involve(NumFluent a) {
        return false;
    }

    public boolean less(int i) {
        return this.number<i;
    }

    public boolean greater(int i) {
        return this.number>i;
    }
}

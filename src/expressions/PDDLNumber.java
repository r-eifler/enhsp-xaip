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
import problem.RelState;
import problem.State;

/**
 *
 * @author enrico
 */
public class PDDLNumber extends Expression {

    private Float number;

    public PDDLNumber(Float n) {
        grounded = true;
        number = n;

    }

    public PDDLNumber(int number) {

        grounded = true;
        this.number = new Float(number);

    }

    public String toString() {

        return " " + getNumber() + " ";
    }

    @Override
    public Expression ground(Map substitution) {
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
    public NormExpression normalize() {
        Addendum a = new Addendum();
        a.n = this;
        a.f = null;
        NormExpression ret = new NormExpression();
        ret.summations.add(a);
        return ret;

    }

    @Override
    public void changeVar(Map substitution) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String pddlPrint(boolean typeInformation) {
        return " " + getNumber() + " ";
    }

    @Override
    public Expression weakEval(State s, HashMap invF) {
        return this;
    }

    @Override
    public Expression clone() {
        return new PDDLNumber(this.getNumber());
    }

    @Override
    public PDDLNumbers eval(RelState s) {
        return new PDDLNumbers(this.getNumber());
    }

    @Override
    public boolean involve(ArrayList<NumFluent> arrayList) {
        return false;
    }

    @Override
    public Expression subst(Conditions numeric) {
        return this;
    }
}

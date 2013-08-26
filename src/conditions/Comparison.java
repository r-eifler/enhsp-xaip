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

import expressions.Expression;
import expressions.NormExpression;
import expressions.NumFluent;
import java.util.Map;
import problem.State;
import expressions.PDDLNumber;
import expressions.PDDLNumbers;
import java.util.ArrayList;
import problem.RelState;

/**
 *
 * @author enrico
 */
public class Comparison extends Conditions {

    private String comparator;
    private Expression left;
    private Expression right;

    public Comparison(String bin_comp_) {
        super();
        comparator = bin_comp_;
    }

    @Override
    public String toString() {

        return "(" + getFirst() + " " + getBin_comp() + " " + getTwo() + ")";

    }

    @Override
    public String pddlPrint() {
        return "(" + getBin_comp() + " " + getFirst().pddlPrint() + " " + getTwo().pddlPrint() + ")";
    }

    /**
     * @return the bin_comp
     */
    public String getBin_comp() {
        return comparator;
    }

    /**
     * @param bin_comp the bin_comp to set
     */
    public void setBin_comp(String bin_comp) {
        this.comparator = bin_comp;
    }

    /**
     * @return the one
     */
    public Expression getFirst() {
        return left;
    }

    /**
     * @param one the one to set
     */
    public void setFirst(Expression one) {
        this.left = one;
    }

    /**
     * @return the two
     */
    public Expression getTwo() {
        return right;
    }

    /**
     * @param two the two to set
     */
    public void setTwo(Expression two) {
        this.right = two;
    }

    @Override
    public Conditions ground(Map substitution) {
        Comparison ret = new Comparison(comparator);

        ret.left = left.ground(substitution);
        ret.right = right.ground(substitution);
        ret.grounded = true;
        return ret;
    }

    @Override
    public boolean eval(State s) {
        PDDLNumber first = left.eval(s);
        PDDLNumber second = right.eval(s);
        if ((first == null) || (second == null)) {
            return false;//negation by failure.
        }
        if (this.getBin_comp().equals("<")) {
            return first.getNumber() < second.getNumber();
        } else if (this.getBin_comp().equals("<=")) {
            return first.getNumber() <= second.getNumber();
        } else if (this.getBin_comp().equals(">")) {
            return first.getNumber() > second.getNumber();
        } else if (this.getBin_comp().equals(">=")) {
            return first.getNumber() >= second.getNumber();
        } else if (this.getBin_comp().equals("=")) {
            return first.getNumber() == second.getNumber();
        } else {
            System.out.println(this.getBin_comp() + "  does not supported");
        }

        return false;
    }

    @Override
    public boolean isSatisfied(State s) {
        PDDLNumber first = left.eval(s);
        PDDLNumber second = right.eval(s);
        if ((first == null) || (second == null)) {
            return false;//negation by failure.
        }
        if (this.getBin_comp().equals("<")) {
            return first.getNumber() < second.getNumber();
        } else if (this.getBin_comp().equals("<=")) {
            return first.getNumber() <= second.getNumber();
        } else if (this.getBin_comp().equals(">")) {
            return first.getNumber() > second.getNumber();
        } else if (this.getBin_comp().equals(">=")) {
            return first.getNumber() >= second.getNumber();
        } else if (this.getBin_comp().equals("=")) {
            return first.getNumber().equals(second.getNumber());
        } else {
            System.out.println(this.getBin_comp() + "  is not supported");
        }

        return false;
    }

    @Override
    public boolean isSatisfied(RelState s) {

        PDDLNumbers first = left.eval(s);
        PDDLNumbers second = right.eval(s);
        if ((first == null) || (second == null)) {
            return false;
        }
        if ((first.inf == null) || (first.sup == null) || (second.inf == null) || (second.sup == null)) {
            return false;//negation by failure.
        }
        if (this.getBin_comp().equals("<")) {
            return first.inf.getNumber() < second.sup.getNumber();
        } else if (this.getBin_comp().equals("<=")) {
            return first.inf.getNumber() <= second.sup.getNumber();
        } else if (this.getBin_comp().equals(">")) {
            return first.sup.getNumber() > second.inf.getNumber();
        } else if (this.getBin_comp().equals(">=")) {
            return first.sup.getNumber() >= second.inf.getNumber();
        } else if (this.getBin_comp().equals("=")) {
//            float ret = Math.max(first.inf.getNumber()-second.sup.getNumber(), second.inf.getNumber()-first.sup.getNumber());
//            if (ret>=0)
//                return false;
//            else
//                return true;
//            
            if (!((first.inf.getNumber() > second.sup.getNumber()) || (second.inf.getNumber() > first.sup.getNumber()))) {
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println(this.getBin_comp() + "  is not supported");
        }

        return false;
    }

    public Float satisfactionDistance(RelState s) {
        Float ret = new Float(0);

        PDDLNumbers first = left.eval(s);
        PDDLNumbers second = right.eval(s);
        if ((first == null) || (second == null)) {
            return Float.MAX_VALUE;
        }
        if ((first.inf == null) || (first.sup == null) || (second.inf == null) || (second.sup == null)) {
            return Float.MAX_VALUE;//negation by failure.
        }
        if (this.getBin_comp().equals("<")) {
            Float t = second.sup.getNumber() - first.inf.getNumber();
            return (t - 0.00001f) * -1;

        } else if (this.getBin_comp().equals("<=")) {
            Float t = second.sup.getNumber() - first.inf.getNumber();
            return t * -1;
        } else if (this.getBin_comp().equals(">")) {
            Float t = first.sup.getNumber() - second.inf.getNumber();
            return (t - 0.00001f) * -1;
        } else if (this.getBin_comp().equals(">=")) {
            Float t = first.sup.getNumber() - second.inf.getNumber();
            return t * (-1);
        } else if (this.getBin_comp().equals("=")) {
            ret = Math.max(first.inf.getNumber() - second.sup.getNumber(), second.inf.getNumber() - first.sup.getNumber());
            return (ret + 0.00001f) * -1;

        } else {
            System.out.println(this.getBin_comp() + "  is not supported");
        }

        return ret;
    }

    @Override
    public void changeVar(Map substitution) {

        this.left.changeVar(substitution);
        this.right.changeVar(substitution);

    }

    public Comparison normalizeAndCopy() {
        Comparison ret = new Comparison(this.comparator);
        //System.out.println("Instanceof left: "+left.getClass());
        ret.setFirst(this.left.normalize());
        ret.setTwo(this.right.normalize());
        
        //System.out.println("Instanceof left: "+ret.left.getClass());
        
        NormExpression leftExpr = (NormExpression)ret.left;
        NormExpression rightExpr = (NormExpression)ret.right;
        if (leftExpr.isNumber() && rightExpr.isNumber()){
                PDDLNumber first;
                first = leftExpr.getNumber();
                PDDLNumber second = rightExpr.getNumber();
                if (this.getBin_comp().equals("<")) {
                    if ( (first.getNumber() < second.getNumber()))
                        return null;
                } else if (this.getBin_comp().equals("<=")) {
                    if ( (first.getNumber() <= second.getNumber()))
                        return null;
                } else if (this.getBin_comp().equals(">")) {
                    if ( (first.getNumber() > second.getNumber()))
                        return null;
                } else if (this.getBin_comp().equals(">=")) {
                    if ( (first.getNumber() >= second.getNumber()))
                        return null;
                } else if (this.getBin_comp().equals("=")) {
                    if ( (first.getNumber() == second.getNumber()))
                        return null;
                }
                

                System.out.println(this.toString() + " will be never be satisfied");
            
        }
        
        return ret;
    }

    @Override
    public Conditions clone() {
        Comparison ret = new Comparison(this.comparator);
        ret.grounded = this.grounded;
        ret.left = this.left.clone();
        ret.right = this.right.clone();

        return ret;
    }

    public boolean involve(ArrayList<NumFluent> arrayList) {
        if (this.left.involve(arrayList)) {
            return true;
        } else {
            return this.right.involve(arrayList);
        }
    }

    @Override
    public void normalize() {
        //Comparison ret = new Comparison(this.comparator);
        //System.out.println("Instanceof left: "+left.getClass());
       setFirst(this.left.normalize());
       setTwo(this.right.normalize());
      
        
    }
}

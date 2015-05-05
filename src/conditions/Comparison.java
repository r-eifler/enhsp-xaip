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
package conditions;

import expressions.Addendum;
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
    private boolean unsatisfiable = false;
    private boolean normalized;
    public Comparison fatherFromRegression = null;
    public Float maxDist;

    public Comparison(String bin_comp_) {
        super();
        comparator = bin_comp_;
        normalized = false;
        fatherFromRegression = null;
        maxDist = null;
    }

    @Override
    public String toString() {

        return "(" + getLeft() + " " + getComparator() + " " + getRight() + ")";

    }

    @Override
    public String pddlPrint(boolean typeInformation) {
        return "(" + getComparator() + " " + getLeft().pddlPrint(typeInformation) + " " + getRight().pddlPrint(typeInformation) + ")";
    }

    /**
     * @return the bin_comp
     */
    public String getComparator() {
        return comparator;
    }

    /**
     * @param bin_comp the bin_comp to set
     */
    public void setComparator(String bin_comp) {
        this.comparator = bin_comp;
    }

    /**
     * @return the one
     */
    public Expression getLeft() {
        return left;
    }

    /**
     * @param one the one to set
     */
    public void setLeft(Expression one) {
        this.left = one;
    }

    /**
     * @return the two
     */
    public Expression getRight() {
        return right;
    }

    /**
     * @param two the two to set
     */
    public void setRight(Expression two) {
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
        if (this.getComparator().equals("<")) {
            return first.getNumber() < second.getNumber();
        } else if (this.getComparator().equals("<=")) {
            return first.getNumber() <= second.getNumber();
        } else if (this.getComparator().equals(">")) {
            return first.getNumber() > second.getNumber();
        } else if (this.getComparator().equals(">=")) {
            return first.getNumber() >= second.getNumber();
        } else if (this.getComparator().equals("=")) {
            return first.getNumber() == second.getNumber();
        } else {
            System.out.println(this.getComparator() + "  does not supported");
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
        if (this.getComparator().equals("<")) {
            return first.getNumber() < second.getNumber();
        } else if (this.getComparator().equals("<=")) {
            return first.getNumber() <= second.getNumber();
        } else if (this.getComparator().equals(">")) {
            return first.getNumber() > second.getNumber();
        } else if (this.getComparator().equals(">=")) {
            return first.getNumber() >= second.getNumber();
        } else if (this.getComparator().equals("=")) {
            return first.getNumber().equals(second.getNumber());
        } else {
            System.out.println(this.getComparator() + "  is not supported");
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
        if (this.getComparator().equals("<")) {
            return first.inf.getNumber() < second.sup.getNumber();
        } else if (this.getComparator().equals("<=")) {
            return first.inf.getNumber() <= second.sup.getNumber();
        } else if (this.getComparator().equals(">")) {
            return first.sup.getNumber() > second.inf.getNumber();
        } else if (this.getComparator().equals(">=")) {
            return first.sup.getNumber() >= second.inf.getNumber();
        } else if (this.getComparator().equals("=")) {
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
            System.out.println(this.getComparator() + "  is not supported");
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
        if (this.getComparator().equals("<")) {
            Float t = second.sup.getNumber() - first.inf.getNumber();
            return (t - 0.00001f) * -1;

        } else if (this.getComparator().equals("<=")) {
            Float t = second.sup.getNumber() - first.inf.getNumber();
            return t * -1;
        } else if (this.getComparator().equals(">")) {
            Float t = first.sup.getNumber() - second.inf.getNumber();
            return (t - 0.00001f) * -1;
        } else if (this.getComparator().equals(">=")) {
            Float t = first.sup.getNumber() - second.inf.getNumber();
            return t * (-1);
        } else if (this.getComparator().equals("=")) {
            ret = Math.max(first.inf.getNumber() - second.sup.getNumber(), second.inf.getNumber() - first.sup.getNumber());
            return (ret + 0.00001f) * -1;

        } else {
            System.out.println(this.getComparator() + "  is not supported");
        }

        return ret;
    }

    @Override
    public void changeVar(Map substitution) {

        this.left.changeVar(substitution);
        this.right.changeVar(substitution);

    }

    public Comparison normalizeAndCopy() throws Exception {
        Comparison ret = new Comparison(this.comparator);

        //System.out.println("Instanceof left: "+left.getClass());

        this.setLeft(this.left.normalize());
        this.setRight(this.right.normalize());
        

        //System.out.println("Instanceof left: "+ret.left.getClass());
        NormExpression leftExpr = (NormExpression) this.left;
        //System.out.println(leftExpr);
        NormExpression rightExpr = (NormExpression) this.right;
        if (leftExpr.isNumber() && rightExpr.isNumber()) {
            PDDLNumber first;
            first = leftExpr.getNumber();
            PDDLNumber second = rightExpr.getNumber();
            if (this.getComparator().equals("<")) {
                if ((first.getNumber() < second.getNumber())) {
                    return null;
                }
            } else if (this.getComparator().equals("<=")) {
                if ((first.getNumber() <= second.getNumber())) {
                    return null;
                }
            } else if (this.getComparator().equals(">")) {
                if ((first.getNumber() > second.getNumber())) {
                    return null;
                }
            } else if (this.getComparator().equals(">=")) {
                if ((first.getNumber() >= second.getNumber())) {
                    return null;
                }
            } else if (this.getComparator().equals("=")) {
                Float res = new Float(Math.abs(first.getNumber() - second.getNumber()));
                if (res < 0.00000000000000000000000000000000001) {
                    return null;
                }
            }
            System.out.println(this.toString() + " will be never be satisfied");

            setUnsatisfiable(true);
            throw new Exception();

        } else {
            leftExpr.minus(rightExpr);
            this.right = new NormExpression(new Float(0));
        }

        this.normalized = true;
        normalized = true;

        return this;
    }

    @Override
    public Conditions clone() {
        Comparison ret = new Comparison(this.comparator);
        ret.grounded = this.grounded;
        ret.left = this.left.clone();
        ret.right = this.right.clone();
        if (this.maxDist != null)
            ret.maxDist = this.maxDist;
        if (this.fatherFromRegression != null)
            ret.fatherFromRegression = this.fatherFromRegression;

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
        System.out.println("Normalizzazione senza copia!!!");
        setLeft(this.left.normalize());
        setRight(this.right.normalize());

//       NormExpression lexp = (NormExpression)this.left;
//       NormExpression rexp = (NormExpression)this.right;
//       lexp = lexp.minus(rexp);
//       this.right = new NormExpression(new Float(0.0));
        normalized = true;

    }

    public Float satisfactionDistance(State s) {
        Float ret = new Float(0);

        PDDLNumber left = this.left.eval(s);
        PDDLNumber right = this.right.eval(s);
        if ((left == null) || (right == null)) {
            return Float.MAX_VALUE;
        }
        if (this.getComparator().equals("<")) {
            Float t = right.getNumber() - left.getNumber();
            return (t - 0.00001f) * -1;

        } else if (this.getComparator().equals("<=")) {
            Float t = right.getNumber() - left.getNumber();
            return t * -1;
        } else if (this.getComparator().equals(">")) {
            Float t = left.getNumber() - right.getNumber();
            return (t - 0.00001f) * -1;
        } else if (this.getComparator().equals(">=")) {
            Float t = left.getNumber() - right.getNumber();
            return t * (-1);
        } else if (this.getComparator().equals("=")) {
            ret = Math.max(left.getNumber() - right.getNumber(), right.getNumber() - left.getNumber());
            return (ret + 0.00001f) * -1;

        } else {
            System.out.println(this.getComparator() + "  is not supported");
        }

        return ret;
    }

    /**
     * @return the unsatisfiable
     */
    public boolean isUnsatisfiable() {
        return unsatisfiable;
    }

    /**
     * @param unsatisfiable the unsatisfiable to set
     */
    public void setUnsatisfiable(boolean unsatisfiable) {
        this.unsatisfiable = unsatisfiable;
    }

    /**
     * @return the normalized
     */
    public boolean isNormalized() {
        return normalized;
    }

    /**
     * @param normalized the normalized to set
     */
    public void setNormalized(boolean normalized) {
        this.normalized = normalized;
    }

    public Float getDistance(State init, RelState rel_state) {

        Float ret = new Float(0);
        if (!init.satisfy(this)) {

            if ((this.getRight() instanceof NormExpression) && (this.getLeft() instanceof NormExpression)) {
                NormExpression lExpr = (NormExpression) this.getLeft();
                Float num = new Float(0.0);
                //Float den = new Float(0.0);
                for (Addendum a : lExpr.summations) {
                    if (a.f == null) {
                        num += a.n.getNumber();
                    } else {
                        PDDLNumber evaluation = (PDDLNumber) a.f.eval(init);
                        //System.out.println("Evaluation of " + a.f +" "+evaluation);
                        num += a.n.getNumber() * evaluation.getNumber();
                        //System.out.println("Coefficient: " + a.n );
                        //System.out.println(num);
                        //den += new Float(Math.pow(a.n.getNumber(),2));
                    }
                }
                //System.out.println("Comparison under process: " + comp);
                //System.out.println("Num: " + num +" Den: "+den);
                //System.out.println("Dist: " +  new Float(1.0)/ ( new Float(Math.abs(num))/(new Float(Math.pow(den,0.5)))));

                /*Contribution of each comparison*/
                //Float dist = Math.max((float) 1.0, Math.abs(num));
                Float dist = Math.abs(num);

                if (rel_state == null) {
                    num = new Float(1);
                } else {
                    for (Addendum a : lExpr.summations) {
                        if (a.f == null) {
                            num += a.n.getNumber();
                        } else {
                            num += Math.max(a.n.getNumber() * rel_state.functionInfValue(a.f).getNumber(), a.n.getNumber() * rel_state.functionSupValue(a.f).getNumber());
                        }
                    }
                }

                Float maxDist = Math.abs(num);
                ret = (dist / maxDist);
            } else {
                System.out.println("Comparison must be normalized for computing the euclidean distance");
                System.exit(-1);
            }
        }

        //System.out.println("D("+this+")="+ret);
        return ret;

    }

    public void computeMaxDist(RelState numericFleuntsBoundaries) {

        if ((this.getRight() instanceof NormExpression) && (this.getLeft() instanceof NormExpression)) {
            NormExpression lExpr = (NormExpression) this.getLeft();

            Float num = new Float(0.0);

            for (Addendum a : lExpr.summations) {
                if (a.f == null) {
                    num += Math.abs(a.n.getNumber());
                } else {
                    num += Math.max(Math.abs(a.n.getNumber() * numericFleuntsBoundaries.functionInfValue(a.f).getNumber()), Math.abs(a.n.getNumber() * numericFleuntsBoundaries.functionSupValue(a.f).getNumber()));
                }
            }
            this.maxDist = num;
        } else {
            System.out.println("Errore!!!");
            System.exit(-1);
        }

    }

    @Override
    public Conditions unGround(Map asbstractionOf) {
 
        Comparison ret = new Comparison(comparator);

        ret.left = left.unGround(asbstractionOf);
        ret.right = right.unGround(asbstractionOf);
        ret.grounded = false;
        return ret;
    }
    
    

}

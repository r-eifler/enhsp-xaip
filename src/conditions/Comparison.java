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
import expressions.NumEffect;
import expressions.NumFluent;
import java.util.Map;
import problem.State;
import expressions.PDDLNumber;
import expressions.PDDLNumbers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import problem.GroundAction;
import problem.RelState;

/**
 *
 * @author enrico
 */
public class Comparison extends Conditions {

    private Integer hash_code;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comparison other = (Comparison) obj;
        //System.out.println("Testing equality");
        if (!other.normalized || !this.normalized) {
            return false;
        }
        if ((this.comparator == null) ? (other.comparator != null) : !this.comparator.equals(other.comparator)) {
            return false;
        }
        if (this.left != other.left && (this.left == null || !this.left.equals(other.left))) {
            return false;
        }
        if (this.right != other.right && (this.right == null || !this.right.equals(other.right))) {
            return false;
        }
        NormExpression left_expr = (NormExpression) left;
        NormExpression left_expr2 = (NormExpression) other.left;
        if (!left_expr.equals(left_expr2)) {
            return false;
        }
        //System.out.println("Equal Comparison:"+other+this);
        return true;
    }

    @Override
    public int hashCode() {
//        if (hash_code==null){
        int hash = 7;
        hash = 67 * hash + (this.comparator != null ? this.comparator.hashCode() : 0);
        hash = 67 * hash + (this.left != null ? this.left.hashCode() : 0);
        hash = 67 * hash + (this.right != null ? this.right.hashCode() : 0);
        return hash;
        //hash = 67 * hash + (this.normalized ? 1 : 0);
//        hash_code = hash;
//        }
//        return hash_code;
    }

    private String comparator;
    private Expression left;
    private Expression right;
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
        return "(" + getComparator() + " (" + getLeft() + ") ( " + getRight() + "))";

        //return "(" + getLeft() + " " + getComparator() + " " + getRight() + ")";
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
    public Conditions ground(Map substitution, int c) {
        Conditions ret = this.ground(substitution);
        ret.setCounter(c);
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

    @Deprecated //actually this function does not copy anything
    public Comparison normalizeAndCopy() throws Exception {

        if (normalized) {
            return this;
        }
//        System.out.println("Instanceof left: "+left);
//        System.out.println("Instanceof Right: "+right);
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
            //throw new Exception();

        } else {
            //System.out.println("DEBUG");
            if (this.comparator.equals("<") || this.comparator.equals("<=") || this.comparator.equals("=")) {
                setLeft(rightExpr.minus(leftExpr));
                setRight(new NormExpression(new Float(0.0)));

            } else {
                setLeft(leftExpr.minus(rightExpr));
                setRight(new NormExpression(new Float(0.0)));
            }

            if (!this.comparator.equals("=")) {
                if (this.comparator.contains("=")) {
                    this.comparator = ">=";
                } else {
                    this.comparator = ">";
                }
            }
        }

        setNormalized(true);

        return this;
    }

    @Override
    public Conditions clone() {
        Comparison ret = new Comparison(this.comparator);
        ret.grounded = this.grounded;
        ret.left = this.left.clone();
        ret.right = this.right.clone();
        ret.normalized = this.normalized;
        if (this.maxDist != null) {
            ret.maxDist = this.maxDist;
        }
        if (this.fatherFromRegression != null) {
            ret.fatherFromRegression = this.fatherFromRegression;
        }

        return ret;
    }

    public boolean involve(HashMap<NumFluent, Boolean> arrayList) {
        if (this.left.involve(arrayList)) {
            return true;
        } else {
            return this.right.involve(arrayList);
        }
    }

    @Override
    public void normalize() {

        //Comparison ret = new Comparison(this.comparator);
        //System.out.println("Normalizzazione senza copia!!!");
        if (normalized) {
            //System.out.println("Already Normalized:"+this);
            return;
        }
        //System.out.println(this);
        setLeft(this.left.normalize());
        setRight(this.right.normalize());
        NormExpression left = (NormExpression) this.left;
        NormExpression right = (NormExpression) this.right;
        try {
            if (left.isNumber() && right.isNumber()) {
                PDDLNumber first;
                first = left.getNumber();
                PDDLNumber second = right.getNumber();
                if (this.getComparator().equals("<")) {
                    if ((first.getNumber() < second.getNumber())) {
                        return;
                    }
                } else if (this.getComparator().equals("<=")) {
                    if ((first.getNumber() <= second.getNumber())) {
                        return;
                    }
                } else if (this.getComparator().equals(">")) {
                    if ((first.getNumber() > second.getNumber())) {
                        return;
                    }
                } else if (this.getComparator().equals(">=")) {
                    if ((first.getNumber() >= second.getNumber())) {
                        return;
                    }
                } else if (this.getComparator().equals("=")) {
                    Float res = Math.abs(first.getNumber() - second.getNumber());
                    if (res < Float.MIN_VALUE) {
                        return;
                    }
                }
                //System.out.println(this.toString() + " will be never be satisfied");
                
                setUnsatisfiable(true);
            }
        } catch (Exception ex) {
            System.out.println("Expression malformed:"+this);
            Logger.getLogger(Comparison.class.getName()).log(Level.SEVERE, null, ex);
        }

        if ("<".equals(this.comparator) || "<=".equals(this.comparator) || "=".equals(this.comparator)) {
            setLeft(right.minus(left));
            setRight(new NormExpression(new Float(0.0)));
        } else {
            setLeft(left.minus(right));
            setRight(new NormExpression((float) 0.0));

        }

        if (!this.comparator.equals("=")) {
            if (this.comparator.contains("=")) {
                this.comparator = ">=";
            } else {
                this.comparator = ">";
            }
        }
        //System.out.println(this);

//       NormExpression lexp = (NormExpression)this.left;
//       NormExpression rexp = (NormExpression)this.right;
//       lexp = lexp.minus(rexp);
//       this.right = new NormExpression(new Float(0.0));
        setNormalized(true);

    }

    @Deprecated
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

    public boolean isDirectlyOrIndirectlyAffected(HashMap<NumFluent, HashSet<NumFluent>> dependsOn, GroundAction get) {

        if (!get.mayInfluence(this)) {
            //System.out.println("Action does not affect");
            return false;
        }

        //If the action affects one of the fluent the comparison depends on, then the comparison can be prevented
        if (!get.influence(dependsOn)) {
            //System.out.println("Ordering for indirect influence");
            return false;
        }
        return true;

    }

    public boolean couldBePrevented(HashMap<NumFluent, HashSet<NumFluent>> dependsOn, GroundAction get) {

        if (!get.mayInfluence(this)) {
            //System.out.println("Action does not affect");
            return false;
        }

        //If the action affects one of the fluent the comparison depends on, then the comparison can be prevented
        if (get.influence(dependsOn)) {
            //System.out.println("Ordering for indirect influence");
            return true;
        }
        //todo add the == case
        //if the action does not threaten the dependant fluents, then let see if it is a proper threat for c.
        Comparison c = (Comparison) get.regress((Comparison) this.clone());

        if ((this.getRight() instanceof NormExpression) && (this.getLeft() instanceof NormExpression)) {
            NormExpression lExpr = (NormExpression) this.getLeft();
            NormExpression lExprNew = (NormExpression) c.getLeft();
//            System.out.println(lExpr);
//            System.out.println(lExprNew);
//            System.out.println(this.getRight());

            NormExpression toTest = lExprNew.minus((NormExpression) lExpr.clone());
            Float total = (float) 0.0;
            for (Addendum add : toTest.summations) {
                if (add.f != null) {
                    return true;
                } else {
                    total += add.n.getNumber();
                }
            }
            if (this.getComparator().equals(">=")) {
                if (total >= 0) {
                    return false;
                }

            } else if (this.getComparator().equals(">")) {
                if (total > 0) {
                    return false;
                }
            } else if (this.getComparator().equals("<=")) {
                if (total <= 0) {
                    return false;
                }
            } else if (this.getComparator().equals("<")) {
                if (total < 0) {

//                    System.out.println("Conservative deordering");
//                    System.out.println(get);
//                    System.out.println("Before:"+lExpr);
//                    System.out.println("Regressed:"+lExprNew);
//                    System.out.println("After: "+toTest);
//                    System.out.println(total);
                    return false;
                }
            } else if (this.getComparator().equals("=")) {
                if (total == 0) {

                    return false;
                }
            }
        } else {
            System.out.println("Non valutata");

        }
        //System.out.println("Acion may prevent...");
        return true;

    }

    public boolean couldBePrevented(HashMap<NumFluent, HashSet<NumFluent>> computeFluentDependencePlanDependant) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isUngroundVersionOf(Conditions c) {
        if (c instanceof Comparison) {
            Comparison comp = (Comparison) c;
            if (comp.getComparator().equals(this.getComparator())) {

                if (this.getLeft().isUngroundVersionOf(comp.getLeft()) && this.getRight().isUngroundVersionOf(comp.getRight())) {
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<NumFluent> susbtFluentsWithTheirInvariants(int j) {

        this.left = this.left.susbtFluentsWithTheirInvariants(j);
        this.right = this.right.susbtFluentsWithTheirInvariants(++j);
        ArrayList ret = new ArrayList();
        ret.addAll(this.left.fluentsInvolved());
        ret.addAll(this.right.fluentsInvolved());
        return ret;
    }

    public ArrayList<NumFluent> susbtFluentsWithTheirInvariants(HashMap<Object, Boolean> invariantFluent, int j) {

        this.left = this.left.susbtFluentsWithTheirInvariants(invariantFluent, j);
        this.right = this.right.susbtFluentsWithTheirInvariants(invariantFluent, ++j);
        ArrayList ret = new ArrayList();
        ret.addAll(this.left.fluentsInvolved());
        ret.addAll(this.right.fluentsInvolved());
        return ret;
    }

    @Override
    public String toSmtVariableString(int i) {
        return "(" + this.comparator + " " + this.getLeft().toSmtVariableString(i) + " " + this.getRight().toSmtVariableString(i) + ")";
    }

    public String toSmtVariableString(int k, GroundAction gr, String var) {
        NormExpression norm = (NormExpression) this.getLeft();
        String ret_val = "";

        HashMap<NumFluent, NumEffect> affector = new HashMap();
        for (NumEffect neff : (Collection<NumEffect>) gr.getNumericEffects().sons) {
            if (this.getInvolvedFluents().contains(neff.getFluentAffected())) {
                affector.put(neff.getFluentAffected(), neff);
            }
        }
        {
            //System.out.println(summations);
            Addendum ad = (Addendum) norm.summations.get(0);
            if (ad.f == null) {

                ret_val = " " + ad.n.pddlPrint(false) + " ";
            } else {
                NumEffect neff = (NumEffect) affector.get(ad.f);
                if (neff != null) {
                    if (neff.operator.equals("increase")) {
                        ret_val = "(+ " + ad.f.toSmtVariableString(k) + " (* " + var + " " + neff.getRight().toSmtVariableString(k) + " ))";
                    } else if (neff.operator.equals("decrease")) {
                        ret_val = "(- " + ad.f.toSmtVariableString(k) + " (* " + var + " " + neff.getRight().toSmtVariableString(k) + " ))";
                    } else if (neff.operator.equals("assign")) {
                        ret_val = "(* " + var + " " + neff.getRight().toSmtVariableString(k) + " )";
                    }
                }else
                    ret_val = ad.f.toSmtVariableString(k);

                ret_val = "(* " + ret_val + " " + ad.n.pddlPrint(false) + ")";
            }
        }
        {
            for (int i = 1; i < norm.summations.size(); i++) {
                Addendum ad = (Addendum) norm.summations.get(i);
                if (ad.f == null) {
                    ret_val = "(+ " + ret_val + " " + ad.n.pddlPrint(false) + " )";
                } else {
                    NumEffect neff = (NumEffect) affector.get(ad.f);
                    String temp=null;
                    if (neff != null) {
                        if (neff.operator.equals("increase")) {
                            temp = "(+ " + ad.f.toSmtVariableString(k) + " (* " + var + " " + neff.getRight().toSmtVariableString(k) + " ))";
                        } else if (neff.operator.equals("decrease")) {
                            temp = "(- " + ad.f.toSmtVariableString(k) + " (* " + var + " " + neff.getRight().toSmtVariableString(k) + " ))";
                        } else if (neff.operator.equals("assign")) {
                            temp = "(* " + var + " " + neff.getRight().toSmtVariableString(k) + " )";
                        } else{
                            System.out.println("Operation "+neff.operator+" not supported");
                            System.exit(-1);
                        }
                    }else
                        temp = ad.f.toSmtVariableString(k);
                    ret_val = "(+ " + ret_val + " " + "(* " + temp + " " + ad.n.pddlPrint(false) + "))";

//                    ret_val += "(* " + temp + " " + ad.n.pddlPrint(false) + ")";
                }
            }
        }

        return "( " + this.comparator + " " + ret_val + " " + this.getRight().toSmtVariableString(k) + " )";
    }

    @Override
    public Set<NumFluent> getInvolvedFluents() {
        Set<NumFluent> ret = new HashSet();

        ret.addAll(this.getLeft().fluentsInvolved());
        ret.addAll(this.getRight().fluentsInvolved());
        //System.out.println("Here we are:"+this);
        return ret;
    }

    @Override
    public Conditions weakEval(State s, HashMap invF) {
        Comparison comp = this;
        Expression lValue = comp.getLeft();
        Expression rValue = comp.getRight();
//                    System.out.println("before" + lValue + rValue);
//                    System.out.println("lvalueClass:" + lValue.getClass());
        lValue.setFreeVarSemantic(this.freeVarSemantic);
        rValue.setFreeVarSemantic(this.freeVarSemantic);
        lValue = lValue.weakEval(s, invF);
        rValue = rValue.weakEval(s, invF);
        if (lValue == null || rValue == null) {
            return null;
        }
        comp.setLeft(lValue);
        comp.setRight(rValue);
        return comp;
    }

    public float eval_not_affected(State s_0, GroundAction aThis) {
        if (!this.normalized) {
            System.err.println("At the moment support just for normalized comparison");
            System.exit(-1);
        }
        NormExpression exp = (NormExpression) this.getLeft();
        return exp.eval_not_affected(s_0, aThis);
    }

    public float eval_affected(State s_0, GroundAction aThis) {
        if (!this.normalized) {
            System.err.println("At the moment support just for normalized comparison");
            System.exit(-1);
        }
        NormExpression exp = (NormExpression) this.getLeft();
        return exp.eval_affected(s_0, aThis);
    }
}

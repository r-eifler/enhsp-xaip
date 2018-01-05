/* 
 * Copyright (C) 2010-2017 Enrico Scala. Contact: enricos83@gmail.com.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package conditions;

import PDDLDomain.Variable;
import expressions.ExtendedAddendum;
import expressions.Expression;
import expressions.ExtendedNormExpression;
import expressions.NumEffect;
import expressions.NumFluent;

import java.util.Map;
import PDDLProblem.PDDLState;
import expressions.PDDLNumber;
import expressions.Interval;
import heuristics.utils.achiever_set;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import PDDLProblem.EPddlProblem;
import PDDLProblem.PDDLGroundAction;
import PDDLProblem.PDDLObjects;
import PDDLProblem.RelState;

/**
 *
 * @author enrico
 */
public class Comparison extends Terminal {

    private Integer hash_code;
    private String string_representation;
    private boolean linear;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comparison other = (Comparison) obj;

        other.normalize();
        this.normalize();

        //System.out.println("Testing equality");
//        if (!other.normalized || !this.normalized) {
//            return false;
//        }
        if ((this.comparator == null) ? (other.comparator != null) : !this.comparator.equals(other.comparator)) {
            return false;
        }
        if (this.left != other.left && (this.left == null || !this.left.equals(other.left))) {
            return false;
        }
        if (this.right != other.right && (this.right == null || !this.right.equals(other.right))) {
            return false;
        }

        ExtendedNormExpression left_expr = (ExtendedNormExpression) left;
        ExtendedNormExpression left_expr2 = (ExtendedNormExpression) other.left;

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
    public boolean normalized;
    public Comparison fatherFromRegression = null;
    public Float maxDist;

    public Comparison(String bin_comp_) {
        super();
        comparator = bin_comp_;
        normalized = false;
        fatherFromRegression = null;
        maxDist = null;
        linear = true;
    }

    @Override
    public String toString() {

        if (string_representation == null) {
            string_representation = "(" + getComparator() + " (" + getLeft() + ") ( " + getRight() + "))";
        }

        return string_representation;

        //return "(" + getLeft() + " " + getComparator() + " " + getRight() + ")";
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
    public Condition ground(Map<Variable, PDDLObject> substitution, PDDLObjects po) {
        Comparison ret = new Comparison(comparator);

        ret.left = left.ground(substitution, po);
        ret.right = right.ground(substitution, po);
        ret.grounded = true;
        return ret;
    }

    @Override
    public Condition ground(Map substitution, int c) {
        Condition ret = this.ground(substitution, null);
        ret.setCounter(c);
        return ret;
    }

    public boolean eval_to_null(PDDLState s) {
        PDDLNumber first = left.eval(s);
        PDDLNumber second = right.eval(s);
        if ((first == null) || (second == null)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean eval(PDDLState s) {
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
    public boolean isSatisfied(PDDLState s) {
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
    public boolean can_be_true(RelState s) {

        Interval first = left.eval(s);
        Interval second = right.eval(s);

        if ((first == null) || (second == null) || first.is_not_a_number || second.is_not_a_number) {
            return false;
        }
        if ((first.getInf() == null) || (first.getSup() == null) || (second.getInf() == null) || (second.getSup() == null)) {
            return false;//negation by failure.
        }
        if (this.getComparator().equals("<")) {
            return first.getInf().getNumber() < second.getSup().getNumber();
        } else if (this.getComparator().equals("<=")) {
            return first.getInf().getNumber() <= second.getSup().getNumber();
        } else if (this.getComparator().equals(">")) {
            return first.getSup().getNumber() > second.getInf().getNumber();
        } else if (this.getComparator().equals(">=")) {
            return first.getSup().getNumber() >= second.getInf().getNumber();
        } else if (this.getComparator().equals("=")) {
//            float ret = Math.max(first.getInf().getNumber()-second.getSup().getNumber(), second.getInf().getNumber()-first.getSup().getNumber());
//            if (ret>=0)
//                return false;
//            else
//                return true;
//            
            if (!((first.getInf().getNumber() > second.getSup().getNumber()) || (second.getInf().getNumber() > first.getSup().getNumber()))) {
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

        Interval first = left.eval(s);
        Interval second = right.eval(s);
        if ((first == null) || (second == null)) {
            return Float.MAX_VALUE;
        }
        if ((first.getInf() == null) || (first.getSup() == null) || (second.getInf() == null) || (second.getSup() == null)) {
            return Float.MAX_VALUE;//negation by failure.
        }
        if (this.getComparator().equals("<")) {
            Float t = second.getSup().getNumber() - first.getInf().getNumber();
            return (t - 0.00001f) * -1;

        } else if (this.getComparator().equals("<=")) {
            Float t = second.getSup().getNumber() - first.getInf().getNumber();
            return t * -1;
        } else if (this.getComparator().equals(">")) {
            Float t = first.getSup().getNumber() - second.getInf().getNumber();
            return (t - 0.00001f) * -1;
        } else if (this.getComparator().equals(">=")) {
            Float t = first.getSup().getNumber() - second.getInf().getNumber();
            return t * (-1);
        } else if (this.getComparator().equals("=")) {
            ret = Math.max(first.getInf().getNumber() - second.getSup().getNumber(), second.getInf().getNumber() - first.getSup().getNumber());
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
        ExtendedNormExpression leftExpr = (ExtendedNormExpression) this.left;
        //System.out.println(leftExpr);
        ExtendedNormExpression rightExpr = (ExtendedNormExpression) this.right;
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
            //System.out.println(this.toString() + " will be never be satisfied");

            setUnsatisfiable(true);
            //throw new Exception();

        } else {
            //System.out.println("DEBUG");
            if (this.comparator.equals("<") || this.comparator.equals("<=") || this.comparator.equals("=")) {
                setLeft(rightExpr.minus(leftExpr));
                setRight(new ExtendedNormExpression(new Float(0.0)));

            } else {
                setLeft(leftExpr.minus(rightExpr));
                setRight(new ExtendedNormExpression(new Float(0.0)));
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
    public Condition clone() {
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
        ExtendedNormExpression l = (ExtendedNormExpression) this.left;
        ExtendedNormExpression r = (ExtendedNormExpression) this.right;
        if (!l.linear || !r.linear) {
            this.setLinear(false);
        }
        //System.out.println(l);
        try {
            if (l.isNumber() && r.isNumber()) {
                PDDLNumber first;
                first = l.getNumber();
                PDDLNumber second = r.getNumber();
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
            System.out.println("Expression malformed:" + this);
            Logger.getLogger(Comparison.class.getName()).log(Level.SEVERE, null, ex);
        }

        if ("<".equals(this.comparator) || "<=".equals(this.comparator) || "=".equals(this.comparator)) {
            try {
                setLeft(r.minus(l));
                setRight(new ExtendedNormExpression(new Float(0.0)));
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Comparison.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                setLeft(l.minus(r));
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Comparison.class.getName()).log(Level.SEVERE, null, ex);
            }
            setRight(new ExtendedNormExpression((float) 0.0));

        }

        if (!this.comparator.equals("=")) {
            if (this.comparator.contains("=")) {
                this.comparator = ">=";
            } else {
                this.comparator = ">";
            }
        }
        //System.out.println(this);

//       ExtendedNormExpression lexp = (ExtendedNormExpression)this.left;
//       ExtendedNormExpression rexp = (ExtendedNormExpression)this.right;
//       lexp = lexp.minus(rexp);
//       this.right = new ExtendedNormExpression(new Float(0.0));
        setNormalized(true);

    }

    @Deprecated
    public Float satisfactionDistance(PDDLState s) {
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

    public Float getDistance(PDDLState init, RelState rel_state) {

        Float ret = new Float(0);
        if (!init.satisfy(this)) {

            if ((this.getRight() instanceof ExtendedNormExpression) && (this.getLeft() instanceof ExtendedNormExpression)) {
                ExtendedNormExpression lExpr = (ExtendedNormExpression) this.getLeft();
                Float num = new Float(0.0);
                //Float den = new Float(0.0);
                for (ExtendedAddendum a : lExpr.summations) {
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
                    for (ExtendedAddendum a : lExpr.summations) {
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

        if ((this.getRight() instanceof ExtendedNormExpression) && (this.getLeft() instanceof ExtendedNormExpression)) {
            ExtendedNormExpression lExpr = (ExtendedNormExpression) this.getLeft();

            Float num = new Float(0.0);

            for (ExtendedAddendum a : lExpr.summations) {
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
    public Condition unGround(Map asbstractionOf) {

        Comparison ret = new Comparison(comparator);

        ret.left = left.unGround(asbstractionOf);
        ret.right = right.unGround(asbstractionOf);
        ret.grounded = false;
        return ret;
    }

    public boolean isDirectlyOrIndirectlyAffected(HashMap<NumFluent, HashSet<NumFluent>> dependsOn, PDDLGroundAction get) {

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

    public boolean couldBePrevented(HashMap<NumFluent, HashSet<NumFluent>> dependsOn, PDDLGroundAction get) throws CloneNotSupportedException {

//        if (!get.mayInfluence(this)) {
//            //System.out.println("Action does not affect");
//            return false;
//        }
        //If the action affects one of the fluent the comparison depends on, then the comparison can be prevented
        if (get.influence(dependsOn)) {
            //System.out.println("Ordering for indirect influence");
            return true;
        }
        //todo add the == case
        //if the action does not threaten the dependant fluents, then let see if it is a proper threat for c.
        Comparison c = (Comparison) get.regress((Comparison) this.clone());

        if ((this.getRight() instanceof ExtendedNormExpression) && (this.getLeft() instanceof ExtendedNormExpression)) {
            ExtendedNormExpression lExpr = (ExtendedNormExpression) this.getLeft();
            ExtendedNormExpression lExprNew = (ExtendedNormExpression) c.getLeft();
//            System.out.println(lExpr);
//            System.out.println(lExprNew);
//            System.out.println(this.getRight());

            ExtendedNormExpression toTest = lExprNew.minus((ExtendedNormExpression) lExpr.clone());
            Float total = (float) 0.0;
            for (ExtendedAddendum add : toTest.summations) {
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
    public boolean isUngroundVersionOf(Condition c) {
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
        ret.addAll(this.left.rhsFluents());
        ret.addAll(this.right.rhsFluents());
        return ret;
    }

    public ArrayList<NumFluent> susbtFluentsWithTheirInvariants(HashMap<Object, Boolean> invariantFluent, int j) {

        this.left = this.left.susbtFluentsWithTheirInvariants(invariantFluent, j);
        this.right = this.right.susbtFluentsWithTheirInvariants(invariantFluent, ++j);
        ArrayList ret = new ArrayList();
        ret.addAll(this.left.rhsFluents());
        ret.addAll(this.right.rhsFluents());
        return ret;
    }

    @Override
    public String toSmtVariableString(int i) {
        return "(" + this.comparator + " " + this.getLeft().toSmtVariableString(i) + " " + this.getRight().toSmtVariableString(i) + ")";
    }

    @Override
    public String toSmtVariableString(int k, PDDLGroundAction gr, String var) {
        if (!gr.mayInfluence(this)) {
            return " true ";
        }
        ExtendedNormExpression norm = (ExtendedNormExpression) this.getLeft();
        String ret_val = "";

        HashMap<NumFluent, NumEffect> affector = new HashMap();
        for (NumEffect neff : (Collection<NumEffect>) gr.getNumericEffects().sons) {
            if (this.getInvolvedFluents().contains(neff.getFluentAffected())) {
                affector.put(neff.getFluentAffected(), neff);
            }
        }
        {
            //System.out.println(summations);
            ExtendedAddendum ad = (ExtendedAddendum) norm.summations.get(0);
            if (ad.bin != null) {
                System.out.println("repetition cannot be activated for actions having non-linear constraints");
                System.exit(-1);
            }
            if (ad.f == null) {
                ret_val = " " + ad.n.toSmtVariableString(k) + " ";
            } else {
                NumEffect neff = (NumEffect) affector.get(ad.f);
                if (neff != null) {
                    ret_val = neff.to_smtlib_with_repetition_for_the_right_part(k, var);
                } else {
                    ret_val = ad.f.toSmtVariableString(k);
                }

                ret_val = "(* " + ret_val + " " + ad.n.toSmtVariableString(k) + ")";
            }
        }
        {
            for (int i = 1; i < norm.summations.size(); i++) {
                ExtendedAddendum ad = (ExtendedAddendum) norm.summations.get(i);
                if (ad.f == null) {
                    ret_val = "(+ " + ret_val + " " + ad.n.toSmtVariableString(i) + " )";
                } else {
                    NumEffect neff = (NumEffect) affector.get(ad.f);
                    String temp = null;
                    if (neff != null) {
                        temp = neff.to_smtlib_with_repetition_for_the_right_part(k, var);
                    } else {
                        temp = ad.f.toSmtVariableString(k);
                    }
                    ret_val = "(+ " + ret_val + " " + "(* " + temp + " " + ad.n.toSmtVariableString(i) + "))";

//                    ret_val += "(* " + temp + " " + ad.n.pddlPrint(false) + ")";
                }
            }
        }

        return "( " + this.comparator + " " + ret_val + " " + this.getRight().toSmtVariableString(k) + " )";
    }

    @Override
    public Set<NumFluent> getInvolvedFluents() {
        Set<NumFluent> ret = new HashSet();

        ret.addAll(this.getLeft().rhsFluents());
        ret.addAll(this.getRight().rhsFluents());
        //System.out.println("Here we are:"+this);
        return ret;
    }

    @Override
    public Condition weakEval(PDDLState s, HashMap invF) {
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
            this.setUnsatisfiable(true);
            this.setValid(false);
            return this;
        }

        comp.setLeft(lValue);
        comp.setRight(rValue);

        return comp;
    }

    public float eval_not_affected(PDDLState s_0, PDDLGroundAction aThis) {
        if (!this.normalized) {
            System.err.println("At the moment support just for normalized comparisons");
            System.exit(-1);
        }
        ExtendedNormExpression exp = (ExtendedNormExpression) this.getLeft();
        return exp.eval_not_affected(s_0, aThis);
    }

    public float eval_affected(PDDLState s_0, PDDLGroundAction aThis) {
        if (!this.normalized) {
            System.err.println("At the moment support just for normalized comparisons");
            System.exit(-1);
        }
        ExtendedNormExpression exp = (ExtendedNormExpression) this.getLeft();
        return exp.eval_affected(s_0, aThis);
    }

    public boolean is_evaluable(PDDLState tempInit) {
        Collection<NumFluent> set = this.getInvolvedFluents();
        for (NumFluent f : set) {
            if (tempInit.functionValue(f) == null) {
                return false;
            }
        }
        return true;
    }

    public String regress_repeatedely(PDDLGroundAction action, int number_of_repetition, PDDLState s_0) {
        float a1;
        float b;

        if (!this.involve(action.getNumericFluentAffected())) {
            return this.getLeft().eval(s_0) + this.comparator + this.getRight().eval(s_0);
        }

        a1 = this.eval_not_affected(s_0, action);
        b = this.eval_affected(s_0, action);
        Float lhs = (b * number_of_repetition + a1);

        return lhs.toString() + ">=" + 0;

    }

    @Override
    public Condition transform_equality() {
        AndCond ret = new AndCond();
        Comparison comp = (Comparison) this;
        if (comp.getComparator().equals("=")) {
            Comparison dual = (Comparison) comp.clone();
            ExtendedNormExpression right = (ExtendedNormExpression) dual.getRight();
            ExtendedNormExpression left = (ExtendedNormExpression) dual.getLeft();

            try {
                dual.setLeft(right.minus(left));
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Comparison.class.getName()).log(Level.SEVERE, null, ex);
            }
            dual.setRight(new PDDLNumber(0));
            dual.setComparator(">=");
            dual.normalize();
            comp.setComparator(">=");
            comp.normalize();
            ret.addConditions(dual);
            ret.addConditions(comp);
        } else {
            return this;
        }
        return ret;
    }

    @Override
    public boolean is_affected_by(PDDLGroundAction gr) {
        if (this.getLeft().involve(gr.getNumericFluentAffected()) || this.getRight().involve(gr.getNumericFluentAffected())) {
            return true;
        }
        return false;
    }

    @Override
    public Condition regress(PDDLGroundAction gr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String pddlPrintWithExtraObject() {
        return "(" + getComparator() + " " + getLeft().pddlPrint(false) + " " + getRight().pddlPrint(false) + ")";
    }

    @Override
    public boolean can_be_false(RelState s) {

        Interval first = left.eval(s);
        Interval second = right.eval(s);

        if ((first == null) || (second == null) || first.is_not_a_number || second.is_not_a_number) {
            return true;
        }
        if ((first.getInf() == null) || (first.getSup() == null) || (second.getInf() == null) || (second.getSup() == null)) {
            return true;//negation by failure.
        }
        if (this.getComparator().equals("<")) {
            return first.getSup().getNumber() >= second.getInf().getNumber();
        } else if (this.getComparator().equals("<=")) {
            return first.getSup().getNumber() > second.getInf().getNumber();
        } else if (this.getComparator().equals(">")) {
            return first.getInf().getNumber() <= second.getSup().getNumber();
        } else if (this.getComparator().equals(">=")) {
            return first.getInf().getNumber() < second.getSup().getNumber();
        } else if (this.getComparator().equals("=")) {
            return (first.getSup().getNumber() > second.getInf().getNumber() || (first.getInf().getNumber() < second.getSup().getNumber()));
        } else {
            System.out.println(this.getComparator() + "  is not supported");
        }

        return false;
    }

//<<<<<<< HEAD
    @Override
    public void pddlPrint(boolean typeInformation, StringBuilder bui) {
        bui.append("(").append(getComparator()).append(" ");
        getLeft().pddlPrint(typeInformation, bui);
        bui.append(" ");
        getRight().pddlPrint(typeInformation, bui);
        bui.append(")");
    }

//=======
    //This function computes a domination analysis between the source (a) comparison and the objective one (b).
    //If the satisfaction of a implies the satisfaction of b, then b is dominated by a.
    public boolean dominate(Comparison other) {
        ExtendedNormExpression e1 = (ExtendedNormExpression) this.getLeft();
        ExtendedNormExpression e2 = (ExtendedNormExpression) other.getLeft();

        ArrayList<ExtendedAddendum> sumC1 = e1.summations;
        ArrayList<ExtendedAddendum> sumC2 = e2.summations;

        int sizeOfSumC1 = sumC1.size();
        int sizeOfSumC2 = sumC2.size();

        if (Math.abs(sizeOfSumC1 - sizeOfSumC2) >= 2) {
            return false;
        }

        if (sizeOfSumC1 > sizeOfSumC2) {
            for (ExtendedAddendum ead1 : sumC1) {

                if (ead1.f != null) {
                    if (!sumC2.contains(ead1)) {
                        return false;
                    }
                } else if (ead1.n.getNumber() > 0) {
                    return false;
                }
            }
            return true;

        } else if (sumC1.size() < sumC2.size()) {
            for (ExtendedAddendum ead2 : sumC2) {
                if (ead2.f != null) {
                    if (!sumC1.contains(ead2)) {
                        return false;
                    }
                } else if (ead2.n.getNumber() > 0) {
                    return false;
                }
            }
            return true;

        } else {
            //they have same size
            for (ExtendedAddendum ead1 : sumC1) {
                if (ead1.f != null) {
                    if (!sumC2.contains(ead1)) {
                        return false;
                    }
                } else {
                    float constC1 = ead1.n.getNumber();
                    for (ExtendedAddendum ead2 : sumC2) {
                        if (ead2.f == null) {
                            if (constC1 > ead2.n.getNumber()) {
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }

    }

//>>>>>>> daan
    /**
     * @return the linear
     */
    public boolean isLinear() {
        return linear;
    }

    /**
     * @param linear the linear to set
     */
    public void setLinear(boolean linear) {
        this.linear = linear;
        return;
    }

    @Override
    public void storeInvolvedVariables(Collection<Variable> vars) {
        for (NumFluent nf : this.getInvolvedFluents()) {
            for (final Object o : nf.getTerms()) {
                final Variable var = (Variable) o;
                vars.add(var);
            }
        }

    }

    @Override
    public Set<Condition> getTerminalConditions() {
        Set ret = new LinkedHashSet();
        ret.add(this);
        return ret;
    }

    @Override
    public Float estimate_cost(ArrayList<Float> cond_dist, boolean additive_h) {
        return cond_dist.get(this.getCounter());
    }

    @Override
    public ComplexCondition and(Condition precondition) {
        AndCond and = new AndCond();
        and.addConditions(precondition);
        and.addConditions(this);
        return and;
    }

    @Override
    public achiever_set estimate_cost(ArrayList<Float> cond_dist, boolean additive_h, ArrayList<PDDLGroundAction> established_achiever) {
        achiever_set s = new achiever_set();
        s.cost = cond_dist.get(this.getCounter());
        s.actions.add(established_achiever.get(this.getCounter()));
        s.target_cond.add(this);
        return s;

    }

    @Override
    public Condition push_not_to_terminals() {
        return this;
    }

    Condition invertOperator() {
        if (this.getComparator().equals("=")) {
            OrCond a = new OrCond();
            Comparison c1 = (Comparison) this.clone();
            Comparison c2 = (Comparison) this.clone();
            c1.setComparator("<");
            c2.setComparator(">");
            a.addConditions(c2);
            a.addConditions(c1);
            return a;
        } else {
            Comparison c1 = (Comparison) this.clone();
            switch (this.getComparator()) {
                case "<":
                    c1.setComparator(">=");
                    break;
                case "<=":
                    c1.setComparator(">");
                    break;
                case ">=":
                    c1.setComparator("<");
                    break;
                case ">":
                    c1.setComparator("<=");
                    break;
            }
            return c1;
        }
    }

    @Override
    public void extendTerms(Variable v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Predicate> getInvolvedPredicates() {
        return new HashSet();
    }

    @Override
    public Condition unifyVariablesReferences(EPddlProblem p) {
        this.left = this.getLeft().unifyVariablesReferences(p);
        this.right = this.getRight().unifyVariablesReferences(p);
        return this;
    }
    
    


}

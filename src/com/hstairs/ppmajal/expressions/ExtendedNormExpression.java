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
package com.hstairs.ppmajal.expressions;

import com.hstairs.ppmajal.problem.PDDLState;
import com.hstairs.ppmajal.problem.State;
import com.hstairs.ppmajal.problem.EPddlProblem;
import com.hstairs.ppmajal.problem.PDDLObjects;
import com.hstairs.ppmajal.problem.RelState;
import com.hstairs.ppmajal.problem.PddlProblem;
import com.hstairs.ppmajal.problem.GroundAction;
import com.hstairs.ppmajal.conditions.ComplexCondition;
import com.hstairs.ppmajal.conditions.Condition;
import com.hstairs.ppmajal.conditions.PDDLObject;
import com.hstairs.ppmajal.domain.Variable;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Enrico Scala
 */
public class ExtendedNormExpression extends Expression {

    public ArrayList<ExtendedAddendum> summations;
    public boolean linear;

    public ExtendedNormExpression() {
        this.summations = new ArrayList();
        linear = true;
    }

    public ExtendedNormExpression(Double ele) {
        this.summations = new ArrayList();
        ExtendedAddendum a = new ExtendedAddendum();
        a.n = ele;
        this.summations.add(a);
        linear = true;

    }
    
    public ExtendedNormExpression(Float ele) {
        this.summations = new ArrayList();
        ExtendedAddendum a = new ExtendedAddendum();
        a.n = ele.doubleValue();
        this.summations.add(a);
        linear = true;

    }

    public ExtendedNormExpression(BinaryOp bin) {
        this.summations = new ArrayList();
        ExtendedAddendum a = new ExtendedAddendum(bin);
        this.summations.add(a);

        linear = true;
    }
    

    @Override
    public boolean equals(Object obj) {
        //System.out.println("Testing");
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ExtendedNormExpression other = (ExtendedNormExpression) obj;

        //if (other == obj)
        //    return true;
//        if (other.summations != this.summations)
//            return false;
        if (other.summations.size() != this.summations.size()) {
            return false;//maybe a little bit strong but if the normalization is well done it should work
        }
        Float scale = null;

        for (int i = 0; i < this.summations.size(); i++) {
            ExtendedAddendum ad = this.summations.get(i);
            ExtendedAddendum ad1 = other.summations.get(i);
            //System.out.println("Comparing:"+ad+ad1);
            if (!ad.equals(ad1)) {//It's very strong, but easy. Could be improved
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (this.summations != null ? this.summations.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        String ret = "(+ ";

        for (Object o : this.summations) {
            ExtendedAddendum a = (ExtendedAddendum) o;
//            if (a.f != null) {
//                if (first){
//                    ret = ret.concat(a.n + "x" + a.f );
//                    first = false;
//                }else
//                    ret = ret.concat(" + " + a.n + "x" + a.f );
//            } else {
//                if (first){
//                    ret = ret.concat(a.n.toString());
//                    first = false;
//                }else
//                    ret = ret.concat("+" + a.n);
//            }
            if (!a.linear) {
                ret = ret.concat(a.bin.toString());
            } else if (a.f != null) {
                ret = ret.concat("(* " + a.n + " (" + a.f +"))");
            } else {
                ret = ret.concat(a.n.toString());
            }
        }
        ret = ret.concat(")");
        return ret;
    }

    //TO BE FIXed!!!!
    public ExtendedNormExpression sum(ExtendedNormExpression right) throws Exception {

        ExtendedNormExpression result = new ExtendedNormExpression();

        ArrayList<ExtendedAddendum> copy_of_this = new ArrayList(this.summations);
        ArrayList<ExtendedAddendum> copy_of_right = new ArrayList(right.summations);
        HashMap<ExtendedAddendum, Boolean> already_added = new HashMap();
        for (ExtendedAddendum a : copy_of_this) {
            if (!a.linear) {
                result.summations.add((ExtendedAddendum) a.clone());
            } else {
                ExtendedAddendum ele_to_add = new ExtendedAddendum();
                boolean add = true;
                for (ExtendedAddendum b : copy_of_right) {
                    if (b.linear && b.bin == null) {
                        if ((b.f == null) && (a.f == null)) {
                            ele_to_add.n = a.n + b.n;
                            if (ele_to_add.n == 0.0) {
                                add = false;
                            }
                            already_added.put(b, true);
                            break;
                        } else if (b.f != null && a.f != null) {
                            if (b.f.equals(a.f)) {
                                ele_to_add.n = a.n+ b.n;
                                ele_to_add.f = (NumFluent) a.f.clone();
                                if (ele_to_add.n == 0.0) {
                                    add = false;
                                }
                                already_added.put(b, true);
                                break;
                            }
                        }
                    }
                }
                if (ele_to_add.n == null) {
                    ele_to_add = (ExtendedAddendum) a.clone();
                }
                if (add) {
                    result.summations.add(ele_to_add);
                }
            }

        }
        for (ExtendedAddendum b : copy_of_right) {
            if (already_added.get(b) == null) {
                result.summations.add((ExtendedAddendum) b.clone());
            }
        }
        if (result.summations.isEmpty()) {
            return new ExtendedNormExpression(0d);
        }

        return result;
    }

    //TO BE FIXed!!!!
    public ExtendedNormExpression minus(ExtendedNormExpression right) throws CloneNotSupportedException {

        ExtendedNormExpression result = new ExtendedNormExpression();

        ArrayList<ExtendedAddendum> copy_of_this = new ArrayList(this.summations);
        ArrayList<ExtendedAddendum> copy_of_right = new ArrayList(right.summations);
        HashMap<ExtendedAddendum, Boolean> already_added = new HashMap();
        for (ExtendedAddendum a : copy_of_this) {
            if (!a.linear) {
                result.summations.add((ExtendedAddendum) a.clone());
            } else {
                ExtendedAddendum ele_to_add = new ExtendedAddendum();
                boolean add = true;
                for (ExtendedAddendum b : copy_of_right) {
                    if (b.linear && b.bin == null) {
                        if ((b.f == null) && (a.f == null)) {
                            ele_to_add.n = a.n - b.n;
                            if (ele_to_add.n == 0.0) {
                                add = false;
                            }
                            already_added.put(b, true);
                            break;
                        } else if (b.f != null && a.f != null) {
                            if (b.f.equals(a.f)) {
                                ele_to_add.n = a.n - b.n;
                                ele_to_add.f = (NumFluent) a.f.clone();
                                if (ele_to_add.n == 0.0) {
                                    add = false;
                                }
                                already_added.put(b, true);
                                break;
                            }
                        }
                    }
                }
                if (ele_to_add.n == null) {
                    ele_to_add = (ExtendedAddendum) a.clone();
                }
                if (add) {
                    result.summations.add(ele_to_add);
                }
            }

        }
        copy_of_right.stream().filter((b) -> (already_added.get(b) == null)).forEach((b) -> {
            if (b.linear && b.bin == null) {
                ExtendedAddendum ele = new ExtendedAddendum();
                ele.n = -1f * b.n;
                if (b.f != null) {
                    ele.f = b.f;
                }
                result.summations.add(ele);
            } else {
                BinaryOp bin = new BinaryOp();
                bin.setRight(new PDDLNumber(-1));
                bin.setOperator("*");
                bin.setOne(b.bin.clone());
                ExtendedAddendum ele = new ExtendedAddendum();
                ele.linear = false;
                ele.bin = bin;
                result.summations.add(ele);
            }
        });
        if (result.summations.isEmpty()) {
            return new ExtendedNormExpression(0d);
        }

        return result;
    }

    ExtendedNormExpression mult(ExtendedNormExpression right) {

        ExtendedNormExpression result = new ExtendedNormExpression();
        for (ExtendedAddendum a : this.summations) {
            for (ExtendedAddendum b : right.summations) {

                ExtendedAddendum ele_to_add = new ExtendedAddendum();
//                System.out.println("a: "+a);
//                System.out.println("b: "+b);
                boolean adding = true;
                if (a.linear && a.f == null && b.linear && b.f == null) {

                    ele_to_add.n = a.n * b.n;
                    if (ele_to_add.n == 0.0) {
                        adding = false;
                    }
                } else if (a.linear && b.linear && b.f == null) {
                    ele_to_add.n = a.n * b.n;
                    ele_to_add.f = (NumFluent) a.f.clone();
                    if (ele_to_add.n == 0.0) {
                        adding = false;
                    }
                } else if (a.linear && a.f == null && b.linear) {
                    ele_to_add.n = a.n* b.n;
                    ele_to_add.f = (NumFluent) b.f.clone();

                    if (ele_to_add.n == 0.0) {
                        adding = false;
                    }
                } else if (a.linear && a.f != null && b.linear && b.f != null) {
                    ele_to_add.bin = new BinaryOp(new PDDLNumber(a.n * b.n), "*", new BinaryOp(a.f, "*", b.f, true), true);
                    ele_to_add.linear = false;
                } else if (!a.linear && b.linear && b.f == null) {
                    ele_to_add.bin = new BinaryOp(a.bin.clone(), "*", new PDDLNumber(b.n), true);
                    ele_to_add.linear = false;
                } else if (!a.linear && b.linear && b.f != null) {
                    ele_to_add.bin = new BinaryOp(a.bin.clone(), "*", new BinaryOp(new PDDLNumber(b.n), "*", b.f, true), true);
                    ele_to_add.linear = false;
                } else if (a.linear && a.f == null && !b.linear) {
                    ele_to_add.bin = new BinaryOp(b.bin.clone(), "*", new PDDLNumber(a.n), true);
                    ele_to_add.linear = false;
                } else if (a.linear && a.f != null && !b.linear) {
                    ele_to_add.bin = new BinaryOp(new BinaryOp(new PDDLNumber(a.n), "*", a.f, true), "*", b.bin.clone(), true);
                    ele_to_add.linear = false;
                } else if (!a.linear && !b.linear) {
                    ele_to_add.bin = new BinaryOp(a.bin.clone(), "*", b.bin.clone(), true);
                    ele_to_add.linear = false;
                }
                //System.out.println(ele_to_add);
                if (adding) {
                    result.summations.add(ele_to_add);
                    if (!ele_to_add.linear) {
                        result.linear = false;
                    }
                }

            }
        }
        return result;
    }

    ExtendedNormExpression div(ExtendedNormExpression right) {

        ExtendedNormExpression result = new ExtendedNormExpression();
        for (ExtendedAddendum a : this.summations) {
            for (ExtendedAddendum b : right.summations) {

                ExtendedAddendum ele_to_add = new ExtendedAddendum();
                boolean adding = true;
                if ((a.linear && a.f == null && b.linear && b.f == null)) {
                    ele_to_add.n = a.n / b.n;
                    if (ele_to_add.n == 0.0) {
                        adding = false;
                    }

                } else if (a.linear && b.linear && b.f == null) {
                    ele_to_add.n = a.n/ b.n;
                    ele_to_add.f = (NumFluent) a.f.clone();
                    if (ele_to_add.n == 0.0) {
                        adding = false;
                    }
                } else if (a.linear && a.f == null && b.linear && b.f != null) {
                    ele_to_add.bin = new BinaryOp(new PDDLNumber(a.n), "/", new BinaryOp(new PDDLNumber(b.n), "*", b.f, true), true);
                    ele_to_add.linear = false;

                } else if (a.linear && a.f != null && b.linear && b.f != null) {
                    ele_to_add.bin = new BinaryOp(new PDDLNumber(a.n / b.n), "*", new BinaryOp(a.f, "/", b.f, true), true);
                    ele_to_add.linear = false;
                } else if (!a.linear && b.linear && b.f == null) {
                    ele_to_add.bin = new BinaryOp(a.bin.clone(), "/", new PDDLNumber(b.n), true);
                    ele_to_add.linear = false;
                } else if (!a.linear && b.linear && b.f != null) {
                    ele_to_add.bin = new BinaryOp(a.bin.clone(), "/", new BinaryOp(new PDDLNumber(b.n), "*", b.f, true), true);
                    ele_to_add.linear = false;
                } else if (a.linear && a.f == null && !b.linear) {
                    ele_to_add.bin = new BinaryOp(new PDDLNumber(a.n), "/", b.bin.clone(), true);
                    ele_to_add.linear = false;
                } else if (a.linear && a.f != null && !b.linear) {
                    ele_to_add.linear = false;
                    ele_to_add.bin = new BinaryOp(new BinaryOp(new PDDLNumber(a.n), "*", a.f, true), "/", b.bin.clone(), true);
                } else if (!a.linear && !b.linear) {
                    ele_to_add.linear = false;
                    ele_to_add.bin = new BinaryOp(a.bin.clone(), "/", b.bin.clone(), true);
                }
                if (adding) {
                    result.summations.add(ele_to_add);
                }

            }
        }
        return result;
    }

    @Override
    public Expression ground(Map<Variable, PDDLObject> substitution, PDDLObjects po) {
        ExtendedNormExpression ret = new ExtendedNormExpression();
        for (Object o : this.summations) {
            ExtendedAddendum a = (ExtendedAddendum) o;
            ExtendedAddendum newA = new ExtendedAddendum();
//            System.out.println(substitution);
//            System.out.println(a);
            if (a.f != null) {
                newA.f = a.f.ground(substitution, po);
            }
            newA.n = a.n;
            ret.summations.add(newA);
        }
        return ret;
    }

    @Override
    public Expression unGround(Map substitution) {
        ExtendedNormExpression ret = new ExtendedNormExpression();
        for (Object o : this.summations) {
            ExtendedAddendum a = (ExtendedAddendum) o;
            ExtendedAddendum newA = new ExtendedAddendum();
            newA.f = (NumFluent) a.f.unGround(substitution);
            newA.n = a.n;
            ret.summations.add(newA);
        }
        ret.grounded = false;
        return ret;
    }

    @Override
    public Double eval(State s) {
        //PDDLNumber ret = new PDDLNumber(0);
        double ret = 0d;
        for (final Object o : this.summations) {
            final ExtendedAddendum a = (ExtendedAddendum) o;
            if (!a.linear) {
//                System.out.println(a.bin);
//                Float temp =  a.bin.eval(s).getNumber();
                ret += a.bin.eval(s);
            } else if (a.f != null) {
                double n = ((PDDLState)s).fluentValue(a.f);

                if (n == Double.NaN) {
                    return null;
                }
                ret += n * a.n;
            } else {
                ret += a.n;
            }
        }
        return ret;
    }

    /**
     *
     * @param problem
     * @param invFluents
     * @return
     */
    @Override
    public ExtendedNormExpression weakEval(PddlProblem problem, HashMap invFluents) {
        ExtendedNormExpression ret = new ExtendedNormExpression();
         Double c = 0d;
        for (ExtendedAddendum a : this.summations) {
            if (a.f != null) {
//                System.out.println(a.f);
//                //System.out.println(invFluents);
//                if (invFluents.get(a.f)==null){
//                    System.out.println("Fluent not present in inv. a.f:"+a.f+"invFluents:"+invFluents);
//                }

                if (invFluents.get(a.f) == null || (Boolean) invFluents.get(a.f)) {
                    if (problem.getNumFluentInitialValue(a.f).getNumber().isNaN()) {
                        return null;
                    }
                    c += problem.getNumFluentInitialValue(a.f).getNumber() * a.n;
                } else {
//                    
                    a.f = problem.getNumFluent(a.f);
                    ret.summations.add(a);
                }
            } else {
//                System.out.println("BAaaaaa... c:"+c+"a:"+a);
                c = c + a.n;
            }
        }
        ret.summations.add(new ExtendedAddendum(null, c));

        return ret;
    }

    @Override
    public ExtendedNormExpression normalize() {
        //System.out.println("Expression normalized by default");
        return this;
    }

    @Override
    public void changeVar(Map<Variable, PDDLObject> substitution) {
        for (Object o : this.summations) {

            ExtendedAddendum a = (ExtendedAddendum) o;
            a.f.changeVar(substitution);

        }
    }

    @Override
    public ExtendedNormExpression subst(Condition input) {
        if (!(input instanceof ComplexCondition))
            return this;
        
        ComplexCondition numeric = (ComplexCondition)input;

        ExtendedNormExpression result = new ExtendedNormExpression();
        result = (ExtendedNormExpression) this.clone();
        ArrayList toAdd = new ArrayList();
        ArrayList toRemove = new ArrayList();
        Iterator it = summations.iterator();
        try {
            while (it.hasNext()) {
                ExtendedAddendum ad = (ExtendedAddendum) it.next();
                if (ad.f != null) {
                    for (Object o1 : numeric.sons) {
                        NumEffect ef = (NumEffect) o1;
                        NumEffect eff = (NumEffect) ef.clone();
                        //eff.setRight(eff.getRight().normalize());
//                    System.out.println(" "+eff.getOne().getName()+ " "+ ad.f.getName() + ": " + eff.getOne().equals(ad.f));
                        if (eff.getFluentAffected().equals(ad.f)) {
                            if ((eff.getOperator().equals("increase"))) {
                                ExtendedNormExpression res = new ExtendedNormExpression();
                                res = res.sum((ExtendedNormExpression) eff.getRight());
                                res.mult(ad.n);
                                toAdd.add(res);
                            } else if (eff.getOperator().equals("decrease")) {
                                ExtendedNormExpression res = new ExtendedNormExpression();
                                res = res.sum((ExtendedNormExpression) eff.getRight());
                                res.mult(ad.n);
                                toRemove.add(res);
                            } else if (eff.getOperator().equals("assign")) {
                                ExtendedNormExpression res = new ExtendedNormExpression();
                                res = res.sum((ExtendedNormExpression) eff.getRight());
                                res.mult(ad.n);
                                toAdd.add(res);
                                it.remove();
                            }

                        }
                    }
                }
            }

            for (Object o : toAdd) {
                result = result.sum((ExtendedNormExpression) o);
            }
            for (Object o : toRemove) {
                result = result.minus((ExtendedNormExpression) o);
            }
        } catch (Exception ex) {
            System.out.println("Problem in substitution:" + numeric + this);
            Logger.getLogger(ExtendedNormExpression.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        }
        return result;
    }

    public void mult(PDDLNumber n) {
        for (Object o : summations) {
            ExtendedAddendum ad = (ExtendedAddendum) o;
            if (ad.linear) {
                ad.n = ad.n * n.getNumber();
            } else {
                ad.bin = new BinaryOp(ad.bin, "*", n, true);
            }
        }
    }
    
    public void mult(Double n) {
        for (Object o : summations) {
            ExtendedAddendum ad = (ExtendedAddendum) o;
            if (ad.linear) {
                ad.n = ad.n * n;
            } else {
                ad.bin = new BinaryOp(ad.bin, "*", new PDDLNumber(n), true);
            }
        }
    }
    

    @Override
    public Expression clone() {
        ExtendedNormExpression ret = new ExtendedNormExpression();

        ret.summations = new ArrayList();

        for (ExtendedAddendum ad : this.summations) {
                ret.summations.add((ExtendedAddendum) ad.clone());
        }

        ret.grounded = this.grounded;

        return ret;
    }

    @Override
    public Interval eval(RelState s) {
        Interval ret = new Interval(0f);
        for (Object o : this.summations) {
            ExtendedAddendum a = (ExtendedAddendum) o;

            if (!a.linear) {
                Interval temp = a.bin.eval(s);
                if (temp == null || temp.is_not_a_number) {
                    return new Interval(Float.NaN);
                }
                ret = ret.sum(temp);
            } else if (a.f != null) {
                Interval temp = s.functionValues(a.f);
                if (temp.is_not_a_number) {
                    return new Interval(Float.NaN);
                }
                //System.out.println(temp);

                temp = temp.mult(a.n.floatValue());
                ret = ret.sum(temp);
                //ret.inf = new PDDLNumber(ret.inf.getNumber() + s.functionInfValue(a.f).getNumber() * a.n.getNumber());
                //ret.sup = new PDDLNumber(ret.sup.getNumber() + s.functionSupValue(a.f).getNumber() * a.n.getNumber());
            } else {
                ret = ret.sum(a.n.floatValue());
            }
        }
        return ret;
    }

    @Override
    public boolean involve(Collection<NumFluent> map) {

        for (Object o : this.summations) {
            ExtendedAddendum a = (ExtendedAddendum) o;

            if (!a.linear) {
                if (a.bin.involve(map)) {
                    return true;
                }
            } else if (a.f != null) {
                if (map.contains(a.f)) {
                    return true;
                }
            }

        }
        return false;
    }

    @Override
    public boolean involve(NumFluent nf) {

        for (Object o : this.summations) {
            ExtendedAddendum a = (ExtendedAddendum) o;

            if (!a.linear) {
                if (a.bin.involve(nf)) {
                    return true;
                }
            } else if (a.f != null) {
                if (a.f.equals(nf)) {
                    return true;
                }
            }

        }
        return false;
    }

    public boolean isNumber() {
        //System.out.println(this);
        for (Object o : summations) {
            ExtendedAddendum ad = (ExtendedAddendum) o;
            if (!ad.linear) {
                return false;
            }
            if (ad.f != null) {
                return false;
            }
        }
        return true;
    }

    public Double getNumber() throws Exception {
        if (this.isNumber()) {
            Double temp = 0d;
            for (Object o : summations) {
                ExtendedAddendum ad = (ExtendedAddendum) o;
                temp = ad.n + temp;
            }
            return temp;

        } else {
            System.out.println(this.toString() + "  is not a single number");
            return null;
        }

    }

    @Override
    public Set rhsFluents() {
        Set ret = new HashSet();
        for (Object o : this.summations) {
            ExtendedAddendum a = (ExtendedAddendum) o;
            if (!a.linear) {
                ret.addAll(a.bin.rhsFluents());
            } else if (a.f != null) {
                ret.add(a.f);
            }
        }
        return ret;
    }

    @Override
    public boolean isUngroundVersionOf(Expression expr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Expression susbtFluentsWithTheirInvariants(int j) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Expression susbtFluentsWithTheirInvariants(HashMap<Object, Boolean> invariantFluent, int j) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toSmtVariableString(int j) {
        String ret_val = "";

        {
            //System.out.println(summations);
            ExtendedAddendum ad = summations.get(0);
            if (ad.bin == null) {
                if (ad.f == null) {

                    ret_val = " " + ad.n + " ";
                } else {
                    ret_val = "(* " + ad.f.toSmtVariableString(j) + " " + ad.n + ")";
                }
            } else {
//                System.out.println(ad);
//                System.out.println(ad.bin);
                ret_val = ad.bin.toSmtVariableString(j);
            }
        }
        {
            for (int i = 1; i < summations.size(); i++) {
                ExtendedAddendum ad = summations.get(i);
                if (ad.bin == null) {

                    if (ad.f == null) {
                        ret_val = "(+ " + ret_val + " " + ad.n + " )";
                    } else {
                        ret_val = "(+ " + ret_val + " " + "(* " + ad.f.toSmtVariableString(j) + " " + ad.n + "))";
                    }
                } else {
                    ret_val = "(+ " + ret_val + " " + ad.bin.toSmtVariableString(j) + ")";

                }
            }
        }
        return ret_val;
    }

    public float eval_not_affected(PDDLState s_0, GroundAction action) {//this applies only to linear expression. In the other cases the behavior is undefined
        float current = 0;
        for (ExtendedAddendum ad : this.summations) {
            if (ad.f == null) {
                current += ad.n;
            } else if (!action.getNumericFluentAffected().contains(ad.f)) {
                current += ad.n * ad.f.eval(s_0);
            } else if (action.getCoefficientAffected(ad.f) != null) {
                //float e = aThis.getValueOfRightExpApartFromAffected(ad.f, s_0);

                Double num = ad.f.eval(s_0);
                if (num == null) {
                    return Float.NaN;
                }
                current += ad.n * action.getCoefficientAffected(ad.f) * num;
            }
        }
        return current;
    }

    public Double getCoefficient(NumFluent fluentAffected) {
        for (ExtendedAddendum ad : this.summations) {
            if (ad.f != null && ad.f.equals(fluentAffected)) {
                return ad.n;
            }
        }
        return 0d;
    }

    public float eval_affected(PDDLState s_0, GroundAction aThis) {//this applies only to linear expression. In the other cases the behavior is undefined
        float current = 0;
        for (ExtendedAddendum ad : this.summations) {
            if (ad.f != null) {
                if (aThis.getNumericFluentAffected().contains(ad.f)) {
                    current += ad.n* aThis.getValueOfRightExpApartFromAffected(ad.f, s_0);
                }
            }
        }
        return current;
    }

    public float eval_apart_from_f(NumFluent f, PDDLState s) {//this applies only to linear expression. In the other cases the behavior is undefined
        float ret = 0;
        for (Object o : this.summations) {
            ExtendedAddendum a = (ExtendedAddendum) o;
            if (a.f != null) {
                if (s.fluentValue(a.f) == Double.NaN) {
                    System.out.println("Value not found!!! Grave Error");
                    System.exit(-1);
                }
                if (!a.f.equals(f)) {
                    ret += s.fluentValue(a.f) * a.n;
                }
            } else {

                ret += a.n;
            }
        }
        return ret;
    }

    ExtendedNormExpression pow(ExtendedNormExpression r) throws Exception {
        ExtendedNormExpression res = null;
        if (this.isNumber() && r.isNumber()) {
            Double a = this.getNumber();
            Double b = r.getNumber();
            res = new ExtendedNormExpression(Math.pow(a, b));
        } else {
            System.out.println("Not supported to-the-power operation");
            System.exit(-1);
        }
        return res;
    }

    @Override
    public void pddlPrint(boolean typeInformation, StringBuilder bui) {
        // TODO: Implement it more efficiently.  
        // Substrings are added before or after ret_value, so it should be possible 
        // to store two lists of strings and rebuild everything.  
        String ret_val = "";

        {
            //System.out.println(summations);
            ExtendedAddendum ad = summations.get(0);
            if (!ad.linear) {
                ret_val = ad.bin.toString();
            } else if (ad.f == null) {
                ret_val = " " + ad.n + " ";
            } else {
                ret_val = "(* " + ad.f.pddlPrint(typeInformation) + " " + ad.n + ")";
            }
        }
        {
            for (int i = 1; i < summations.size(); i++) {
                ExtendedAddendum ad = summations.get(i);
                if (!ad.linear) {
                    ret_val = ad.bin.toString();
                } else if (ad.f == null) {
                    ret_val = "(+ " + ret_val + " " + ad.n + " )";
                } else {
                    ret_val = "(+ " + ret_val + " " + "(* " + ad.f.pddlPrint(typeInformation) + " " + ad.n + "))";
                }
            }
        }

        bui.append(ret_val);
    }

    @Override
    public Expression unifyVariablesReferences(EPddlProblem p) {
       
        for (int i = 0 ; i<this.summations.size() ; i++){
            ExtendedAddendum a = this.summations.get(i);
            if (a.f != null){
                a.f = (NumFluent) a.f.unifyVariablesReferences(p);
            }
            this.summations.set(i, a);
        }
        return this; 

    }

}
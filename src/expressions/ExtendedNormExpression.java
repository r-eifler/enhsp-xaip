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
package expressions;

import conditions.Conditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import problem.GroundAction;
import problem.RelState;
import problem.State;

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

    public ExtendedNormExpression(Float ele) {
        this.summations = new ArrayList();
        ExtendedAddendum a = new ExtendedAddendum();
        a.n = new PDDLNumber(ele);
        this.summations.add(a);
        linear = true;

    }
    public ExtendedNormExpression(BinaryOp bin) {
        this.summations = new ArrayList();
        ExtendedAddendum a = new ExtendedAddendum(bin);
        this.summations.add(a);
        linear = false;
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
        if (other.summations.size() != this.summations.size()) {
            return false;//maybe a little bit strong but if the normalization is well done it should work
        }
        Float scale = null;

        for (int i = 0; i < this.summations.size(); i++) {
            ExtendedAddendum ad = this.summations.get(i);
            ExtendedAddendum ad1 = other.summations.get(i);
            //System.out.println("Comparing:"+ad+ad1);
            if (!ad.equals(ad1)) {
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
        String ret = "";
        boolean first = true;
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
            if (!a.linear){
                ret = ret.concat(a.bin.toString());
            }else{

                if (a.f != null) {
                    ret = ret.concat("+" + a.n + "x" + a.f);
                } else {
                    ret = ret.concat("+" + a.n);
                }
            }
        }
        ret = ret.concat("");
        return ret;
    }

    public ExtendedNormExpression sum(ExtendedNormExpression right) throws Exception {

//        System.out.println("before sum: (this)"+this+" (right)"+right);
        if (!right.linear || !this.linear){
            this.summations.addAll(right.summations);
            this.linear = false;
            return this;
        }
            
        
        Iterator it2 = this.summations.iterator();
        while (it2.hasNext()){
            ExtendedAddendum a = (ExtendedAddendum) it2.next();
            Iterator it = right.summations.iterator();
            while (it.hasNext()) {
                ExtendedAddendum a1 = (ExtendedAddendum) it.next();
                if ((a1.f == null) && (a.f == null)) {
                    a.n = new PDDLNumber(a.n.getNumber() + a1.n.getNumber());
                    it.remove();
                } else if (a1.f != null && a.f != null) {
                    if (a1.f.equals(a.f)) {
                        a.n = new PDDLNumber(a.n.getNumber() + a1.n.getNumber());
                        if (a.n.getNumber() == 0.0) {
                            a.f = null;
                            it2.remove();
                        }
                        it.remove();
                    }
                }
            }
        }
        
        for (ExtendedAddendum o1 : right.summations) {
            this.summations.add(o1);
        }
        
//        Iterator it = this.summations.iterator();
//            while (it.hasNext()) {
//            
//            }
            
        
        
//                for (ExtendedAddendum o1 : right.summations) {
//            ExtendedAddendum a = (ExtendedAddendum) o1;
//            for (ExtendedAddendum a1 : this.summations) {
//                if ((a1.f == null) && (a.f == null)) {
//                    a1.n = new PDDLNumber(a.n.getNumber() + a1.n.getNumber());
//                    //it.remove();
//                }
//            }
//        }
//        System.out.println(Iterator it = right.summations.iterator();
        return this;
    }

    public ExtendedNormExpression minus(ExtendedNormExpression right) {
        //System.out.println("Sto facendo un meno!!");

        

        for (Object o : summations) {
            ExtendedAddendum a = (ExtendedAddendum) o;
            Iterator it = right.summations.iterator();
            if (!a.linear)
                break;
            while (it.hasNext()) {
                ExtendedAddendum a1 = (ExtendedAddendum) it.next();
                if (!a1.linear)
                    continue;
                if ((a1.f == null) && (a.f == null)) {
                    a.n = new PDDLNumber(a.n.getNumber() - a1.n.getNumber());
                    it.remove();
                } else if (a1.f != null && a.f != null) {
                    if (a1.f.equals(a.f)) {
                        a.n = new PDDLNumber(a.n.getNumber() - a1.n.getNumber());
                        if (a.n.getNumber() == 0.0) {
                            a.f = null;
                        }
                        it.remove();
                    }
                }
            }
        }
        for (ExtendedAddendum o1 : right.summations) {
            ExtendedAddendum a1 = (ExtendedAddendum) o1;
            if (!a1.linear){
                BinaryOp t = new BinaryOp();
                t.setOperator("*");
                t.setOne(a1.bin);
                t.setRight(new PDDLNumber(-1));
                a1.bin = t;
                this.linear = false;
            }else{
                a1.n = new PDDLNumber(a1.n.getNumber() * (-1));
            }
            this.summations.add(o1);
        }
        return this;
    }

    ExtendedNormExpression mult(ExtendedNormExpression right) {
        
        if (!right.linear || !this.linear){
            //System.out.println("Error!");
            this.linear = false;
            BinaryOp bin = new BinaryOp();
            bin.setOperator("*");
            bin.setOne(right);
            bin.setRight(this);
            ExtendedNormExpression ret = new ExtendedNormExpression(bin);
            
            return ret;
        }      
        ArrayList<ExtendedAddendum> ret = new ArrayList();
        for (Object o : this.summations) {
            ExtendedAddendum a = (ExtendedAddendum) o;
            for (ExtendedAddendum a1 : right.summations) {
//                System.out.println("DEBUG: (a.f)"+a.f+ "(a.f1)"+a1.f);
                if ((a.f == null || a1.f == null)) {
                    ExtendedAddendum t = new ExtendedAddendum();
                    t.n = new PDDLNumber(a.n.getNumber() * a1.n.getNumber());
                    if (a.f == null) {
                        t.f = a1.f;
                    } else {
                        t.f = a.f;
                    }
                    ret.add(t);
                } else {
                    System.out.println("Expression to multiply: " + this + " with: " + right);
                    System.out.println("Error: only linear expression are supported");
                    System.exit(-1);
                }
            }
        }
        this.summations = ret;
        return this;
    }

    ExtendedNormExpression div(ExtendedNormExpression right) {
        
        
        if (!right.linear || !this.linear){
            this.linear = false;
            BinaryOp bin = new BinaryOp();
            bin.setOperator("/");
            bin.setOne(right);
            bin.setRight(this);
            ExtendedNormExpression ret = new ExtendedNormExpression(bin);
            
            return ret;
        }      
        
        if (right.summations.size() > 1) {
            ExtendedAddendum a = (ExtendedAddendum) right.summations.get(0);
            if (a.f != null) {
                System.out.println("Denominator cannot be a non constant term");
            } else {
                System.out.println("Summations at denominator cannot be more than one element");
            }
            System.exit(-1);
        } else {
            ExtendedAddendum a1 = (ExtendedAddendum) right.summations.get(0);
            for (Object o : this.summations) {
                ExtendedAddendum a = (ExtendedAddendum) o;
                a.n = new PDDLNumber(a.n.getNumber() / a1.n.getNumber());
            }
        }
        return this;
    }

    @Override
    public Expression ground(Map substitution) {
        ExtendedNormExpression ret = new ExtendedNormExpression();
        for (Object o : this.summations) {
            ExtendedAddendum a = (ExtendedAddendum) o;
            ExtendedAddendum newA = new ExtendedAddendum();
//            System.out.println(substitution);
//            System.out.println(a);
            if (a.f != null)
                newA.f = (NumFluent) a.f.ground(substitution);
            newA.n = new PDDLNumber(a.n.getNumber());
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
            newA.n = new PDDLNumber(a.n.getNumber());
            ret.summations.add(newA);
        }
        ret.grounded = false;
        return ret;
    }

    @Override
    public PDDLNumber eval(State s) {
        PDDLNumber ret = new PDDLNumber(0);
        for (Object o : this.summations) {
            ExtendedAddendum a = (ExtendedAddendum) o;
            if (!a.linear){
                //System.out.println(a.bin);
                ret = new PDDLNumber(a.bin.eval(s).getNumber()+ret.getNumber());
            }else{
                if (a.f != null) {
                    if (s.functionValue(a.f) == null) {
                        return null;
                    }
                    ret = new PDDLNumber(ret.getNumber() + s.functionValue(a.f).getNumber() * a.n.getNumber());
                } else {
                    ret = new PDDLNumber(ret.getNumber() + a.n.getNumber());
                }
            }
        }
        return ret;
    }

    /**
     *
     * @param s
     * @param invFluents
     * @return
     */
    @Override
    public ExtendedNormExpression weakEval(State s, HashMap invFluents) {
        ExtendedNormExpression ret = new ExtendedNormExpression();
        PDDLNumber c = new PDDLNumber(0);
        for (ExtendedAddendum a : this.summations) {
            if (a.f != null) {
//                System.out.println(a.f);
//                //System.out.println(invFluents);
//                if (invFluents.get(a.f)==null){
//                    System.out.println("Fluent not present in inv. a.f:"+a.f+"invFluents:"+invFluents);
//                }
                if (invFluents.get(a.f)!= null && (Boolean) invFluents.get(a.f)) {
                    c = new PDDLNumber(c.getNumber() + a.f.eval(s).getNumber() * a.n.getNumber());
                } else {
                    ret.summations.add(a);
                }
            } else {
                c = new PDDLNumber(c.getNumber() + a.n.getNumber());
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
    public void changeVar(Map substitution) {
        for (Object o : this.summations) {

            ExtendedAddendum a = (ExtendedAddendum) o;
            a.f.changeVar(substitution);

        }
    }

    @Override
    public String pddlPrint(boolean typeInformation) {
        String ret_val = "";

        {
            //System.out.println(summations);
            ExtendedAddendum ad = (ExtendedAddendum) summations.get(0);
            if (ad.f == null) {

                ret_val = " " + ad.n.pddlPrint(typeInformation) + " ";
            } else {
                ret_val = "(* " + ad.f.pddlPrint(typeInformation) + " " + ad.n.pddlPrint(typeInformation) + ")";
            }
        }
        {
            for (int i = 1; i < summations.size(); i++) {
                ExtendedAddendum ad = (ExtendedAddendum) summations.get(i);

                if (ad.f == null) {
                    ret_val = "(+ " + ret_val + " " + ad.n.pddlPrint(typeInformation) + " )";
                } else {
                    ret_val = "(+ " + ret_val + " " + "(* " + ad.f.pddlPrint(typeInformation) + " " + ad.n.pddlPrint(typeInformation) + "))";
                }
            }
        }
        return ret_val;
    }

    @Override
    public ExtendedNormExpression subst(Conditions numeric) {
        if (numeric == null || numeric.sons == null || numeric.sons.size() == 0) {
            return this;
        }

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
                                res.sum((ExtendedNormExpression) eff.getRight());
                                res.mult(ad.n);
                                toAdd.add(res);
                            } else if (eff.getOperator().equals("decrease")) {
                                ExtendedNormExpression res = new ExtendedNormExpression();
                                res.sum((ExtendedNormExpression) eff.getRight());
                                res.mult(ad.n);
                                toRemove.add(res);
                            } else if (eff.getOperator().equals("assign")) {
                                ExtendedNormExpression res = new ExtendedNormExpression();
                                res.sum((ExtendedNormExpression) eff.getRight());
                                res.mult(ad.n);
                                toAdd.add(res);
                                it.remove();
                            }

                        }
                    }
                }
            }

            for (Object o : toAdd) {
                this.sum((ExtendedNormExpression) o);
            }
            for (Object o : toRemove) {
                this.minus((ExtendedNormExpression) o);
            }
        } catch (Exception ex) {
            System.out.println("Problem in substitution:"+numeric+this);
            Logger.getLogger(ExtendedNormExpression.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        }
        return this;
    }

//    public ExtendedNormExpression subst(Conditions numeric, String var) {
//        ArrayList toAdd = new ArrayList();
//        ArrayList toRemove = new ArrayList();
//        Iterator it = summations.iterator();
//        try{
//        while (it.hasNext()) {
//            ExtendedAddendum ad = (ExtendedAddendum) it.next();
//            if (ad.f != null) {
//                //System.out.println(numeric);
//                if (numeric != null) {
//                    for (Object o1 : numeric.sons) {
//                        NumEffect ef = (NumEffect) o1;
//                        NumEffect eff = (NumEffect) ef.clone();
//                        //eff.setRight(eff.getRight().normalize());
////                    System.out.println(" "+eff.getOne().getName()+ " "+ ad.f.getName() + ": " + eff.getOne().equals(ad.f));
//                        if (eff.getFluentAffected().equals(ad.f)) {
//                            if ((eff.getOperator().equals("increase"))) {
//                                ExtendedNormExpression res = new ExtendedNormExpression();
//                                res.sum((ExtendedNormExpression) eff.getRight());
//                                res.mult(ad.n);
//                                toAdd.add(res);
//                            } else if (eff.getOperator().equals("decrease")) {
//                                ExtendedNormExpression res = new ExtendedNormExpression();
//                                //System.out.println(eff);
//                                //eff.setRight(eff.getRight().normalize());
//                                res.sum((ExtendedNormExpression) eff.getRight());
//                                res.mult(ad.n);
//                                toRemove.add(res);
//                            } else if (eff.getOperator().equals("assign")) {
//                                ExtendedNormExpression res = new ExtendedNormExpression();
//                                res.sum((ExtendedNormExpression) eff.getRight());
//                                res.mult(ad.n);
//                                toAdd.add(res);
//                                it.remove();
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        for (Object o : toAdd) {
//            this.sum((ExtendedNormExpression) o);
//        }
//        for (Object o : toRemove) {
//            this.minus((ExtendedNormExpression) o);
//        }
//                                            } catch (Exception ex) {
//                                Logger.getLogger(ExtendedNormExpression.class.getName()).log(Level.SEVERE, null, ex);
//                            }
//        return this;
//    }

    public void mult(PDDLNumber n) {
        for (Object o : summations) {
            ExtendedAddendum ad = (ExtendedAddendum) o;
            ad.n = new PDDLNumber(ad.n.getNumber() * n.getNumber());
        }
    }

    @Override
    public Expression clone() {
        ExtendedNormExpression ret = new ExtendedNormExpression();

        ret.summations = new ArrayList();

        for (ExtendedAddendum ad : this.summations) {
            try {
                ret.summations.add((ExtendedAddendum) ad.clone());
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(ExtendedNormExpression.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        ret.grounded = this.grounded;

        return ret;
    }

    @Override
    public PDDLNumbers eval(RelState s) {
        PDDLNumbers ret = new PDDLNumbers(0);
        for (Object o : this.summations) {
            ExtendedAddendum a = (ExtendedAddendum) o;

            if (!a.linear){
                ret = ret.sum(a.bin.eval(s));
            }else{
                if (a.f != null) {
                    PDDLNumbers temp = s.functionValues(a.f);
                    //System.out.println(temp);
                    temp = temp.mult(a.n.getNumber());
                    ret = ret.sum(temp);
                    //ret.inf = new PDDLNumber(ret.inf.getNumber() + s.functionInfValue(a.f).getNumber() * a.n.getNumber());
                    //ret.sup = new PDDLNumber(ret.sup.getNumber() + s.functionSupValue(a.f).getNumber() * a.n.getNumber());
                } else {
                    ret = ret.sum(a.n.getNumber());
                }
            }
        }
        return ret;
    }

    @Override
    public boolean involve(HashMap<NumFluent, Boolean> map) {

        for (Object o : this.summations) {
            ExtendedAddendum a = (ExtendedAddendum) o;
            
            if (!a.linear){
                if (a.bin.involve(map))
                    return true;
            }else{
                if (a.f != null) {
                    if (map.get(a.f) != null) {
                        return true;
                    }
                }
            }
            
        }
        return false;
    }
    
    public boolean involve(NumFluent nf) {

        for (Object o : this.summations) {
            ExtendedAddendum a = (ExtendedAddendum) o;
            
            if (!a.linear){
                if (a.bin.involve(nf))
                    return true;
            }else{
                if (a.f != null) {
                    if (a.f.equals(nf)) {
                        return true;
                    }
                }
            }
            
        }
        return false;
    }

    public boolean isNumber() throws Exception {
        int counter = 0;
        //System.out.println(this);
        for (Object o : summations) {
            ExtendedAddendum ad = (ExtendedAddendum) o;
            if (!ad.linear)
                return false;
            if (ad.f != null) {
                return false;
            }
            counter++;
        }
        return true;
    }

    public PDDLNumber getNumber() throws Exception {
        if (this.isNumber()) {
            PDDLNumber temp = new PDDLNumber(0);
            for (Object o : summations) {
                ExtendedAddendum ad = (ExtendedAddendum) o;
                temp = new PDDLNumber(ad.n.getNumber() + temp.getNumber());
            }
            return temp;

        } else {
            System.out.println(this.toString() + "  is not a single number");
            return null;
        }

    }

    @Override
    public Set fluentsInvolved() {
        Set ret = new HashSet();
        for (Object o : this.summations) {
            ExtendedAddendum a = (ExtendedAddendum) o;
            if (!a.linear){
                ret.addAll(a.bin.fluentsInvolved());
            }else{
                if (a.f != null) {
                    ret.add(a.f);
                }
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
            ExtendedAddendum ad = (ExtendedAddendum) summations.get(0);
            if (ad.f == null) {

                ret_val = " " + ad.n.pddlPrint(false) + " ";
            } else {
                ret_val = "(* " + ad.f.toSmtVariableString(j) + " " + ad.n.pddlPrint(false) + ")";
            }
        }
        {
            for (int i = 1; i < summations.size(); i++) {
                ExtendedAddendum ad = (ExtendedAddendum) summations.get(i);

                if (ad.f == null) {
                    ret_val = "(+ " + ret_val + " " + ad.n.pddlPrint(false) + " )";
                } else {
                    ret_val = "(+ " + ret_val + " " + "(* " + ad.f.toSmtVariableString(j) + " " + ad.n.pddlPrint(false) + "))";
                }
            }
        }
        return ret_val;
    }

    public float eval_not_affected(State s_0, GroundAction aThis) {
        float current = 0;
        for (ExtendedAddendum ad : this.summations) {
            if (ad.f == null) {
                current += ad.n.getNumber();
            } else if (aThis.getNumericFluentAffected().get(ad.f) == null) {
                current += ad.n.getNumber() * ad.f.eval(s_0).getNumber();
            } else if (aThis.getCoefficientAffected(ad.f) != null) {
                //float e = aThis.getValueOfRightExpApartFromAffected(ad.f, s_0);
                current += ad.n.getNumber() * aThis.getCoefficientAffected(ad.f) * ad.f.eval(s_0).getNumber();
            }
        }
        return current;
    }

    public Float getCoefficient(NumFluent fluentAffected) {
        for (ExtendedAddendum ad : this.summations) {
            if (ad.f != null && ad.f.equals(fluentAffected)) {
                return ad.n.getNumber();
            }
        }
        return new Float(0);
    }

    public float eval_affected(State s_0, GroundAction aThis) {
        float current = 0;
        for (ExtendedAddendum ad : this.summations) {
            if (ad.f != null) {
                if (aThis.getNumericFluentAffected().get(ad.f) != null) {
                    current += ad.n.getNumber() * aThis.getValueOfRightExpApartFromAffected(ad.f, s_0);
                }
            }
        }
        return current;
    }

    public float eval_apart_from_f(NumFluent f, State s) {
        float ret = 0;
        for (Object o : this.summations) {
            ExtendedAddendum a = (ExtendedAddendum) o;
            if (a.f != null) {
                if (s.functionValue(a.f) == null) {
                    System.out.println("Value not found!!! Grave Error");
                    System.exit(-1);
                }
                if (!a.f.equals(f)) {
                    ret += s.functionValue(a.f).getNumber() * a.n.getNumber();
                }
            } else {

                ret += a.n.getNumber();
            }
        }
        return ret;
    }

    public ExtendedNormExpression sum_copy(ExtendedNormExpression right) {
        ExtendedNormExpression ret = (ExtendedNormExpression)this.clone();
        ExtendedNormExpression temp = (ExtendedNormExpression)right.clone();
        Iterator it2 = ret.summations.iterator();
        while (it2.hasNext()){
            ExtendedAddendum a = (ExtendedAddendum) it2.next();
            Iterator it = temp.summations.iterator();
            while (it.hasNext()) {
                ExtendedAddendum a1 = (ExtendedAddendum) it.next();
                if ((a1.f == null) && (a.f == null)) {
                    a.n = new PDDLNumber(a.n.getNumber() + a1.n.getNumber());
                    it.remove();
                    break;
                } else if (a1.f != null && a.f != null) {
                    if (a1.f.equals(a.f)) {
                        a.n = new PDDLNumber(a.n.getNumber() + a1.n.getNumber());
                        if (a.n.getNumber() == 0.0) {
                            a.f = null;
                            it2.remove();
                        }
                        it.remove();
                        break;
                    }
                    
                }
            }
        }
        
        for (ExtendedAddendum o1 : temp.summations) {
            ret.summations.add(o1);
        }
        return ret;
    }
}

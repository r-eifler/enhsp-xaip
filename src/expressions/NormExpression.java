/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expressions;

import conditions.Conditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import problem.RelState;
import problem.State;

/**
 *
 * @author Enrico Scala
 */
public class NormExpression extends Expression {

    public ArrayList summations;

    public NormExpression() {
        this.summations = new ArrayList();
    }
   
    

    @Override
    public String toString() {
        String ret = "";
        boolean first = true;
        for (Object o : this.summations) {
            Addendum a = (Addendum) o;
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

            if (a.f != null) {
                ret = ret.concat("+" + a.n + "x" + a.f);
            } else {
                ret = ret.concat("+" + a.n);
            }
        }
        ret = ret.concat("");
        return ret;
    }

    public NormExpression sum(NormExpression right) {

        for (Object o : summations) {
            Addendum a = (Addendum) o;
            Iterator it = right.summations.iterator();
            while (it.hasNext()) {
                Addendum a1 = (Addendum) it.next();
                if ((a1.f == null) && (a.f == null)) {
                    a.n = new PDDLNumber(a.n.getNumber() + a1.n.getNumber());
                    it.remove();
                } else if (a1.f != null && a.f != null) {
                    if (a1.f.equals(a.f)) {
                        a.n = new PDDLNumber(a.n.getNumber() + a1.n.getNumber());
                        if (a.n.getNumber() == 0.0) {
                            a.f = null;
                        }
                        it.remove();
                    }
                }
            }
        }
        for (Object o1 : right.summations) {
            this.summations.add(o1);
        }
        return this;
    }

    public NormExpression minus(NormExpression right) {

        for (Object o : summations) {
            Addendum a = (Addendum) o;
            Iterator it = right.summations.iterator();
            while (it.hasNext()) {
                Addendum a1 = (Addendum) it.next();
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
        for (Object o1 : right.summations) {
            Addendum a1 = (Addendum) o1;
            a1.n = new PDDLNumber(a1.n.getNumber() * (-1));
            this.summations.add(o1);
        }
        return this;
    }

    NormExpression mult(NormExpression right) {
        //System.out.println(summations);
        //System.out.println(right.summations);
        for (Object o : this.summations) {
            Addendum a = (Addendum) o;
            Iterator it = right.summations.iterator();
            while (it.hasNext()) {
                Addendum a1 = (Addendum) it.next();
//                if ((a.f ==null)&& (a1.f==null)){
//                    a.n = new PDDLNumber(a.n.getNumber() * a1.n.getNumber());
//                    it.remove();
//                    System.out.println("Molt tra due numeri:" +a.n);
//                }else           
                if (!(a.f != null && a1.f != null)) {
                    a.n = new PDDLNumber(a.n.getNumber() * a1.n.getNumber());
                    if (a.f == null) {
                        a.f = a1.f;
                    }
                } else {
                    System.out.println("Error: only linear expression are supported");
                }
            }
        }

        return this;
    }

    NormExpression div(NormExpression right) {
        if (right.summations.size() > 1) {
            Addendum a = (Addendum) right.summations.get(0);
            if (a.f != null) {
                System.out.println("Denominator cannot be a non constant term");
            } else {
                System.out.println("Summations at denominator cannot be more than one element");
            }
            System.exit(-1);
        } else {
            Addendum a1 = (Addendum) right.summations.get(0);
            for (Object o : this.summations) {
                Addendum a = (Addendum) o;
                a.n = new PDDLNumber(a.n.getNumber() / a1.n.getNumber());
            }
        }
        return this;
    }

    @Override
    public Expression ground(Map substitution) {
        NormExpression ret = new NormExpression();
        for (Object o : this.summations) {
            Addendum a = (Addendum) o;
            Addendum newA = new Addendum();
            newA.f = (NumFluent) a.f.ground(substitution);
            newA.n = new PDDLNumber(a.n.getNumber());
            ret.summations.add(newA);
        }
        return ret;
    }

    @Override
    public PDDLNumber eval(State s) {
        PDDLNumber ret = new PDDLNumber(0);
        for (Object o : this.summations) {
            Addendum a = (Addendum) o;
            if (a.f != null) {
                ret = new PDDLNumber(ret.getNumber() + s.functionValue(a.f).getNumber() * a.n.getNumber());
            } else {
                ret = new PDDLNumber(ret.getNumber() + a.n.getNumber());
            }
        }
        return ret;
    }

    public NormExpression weakEval(State s, HashMap invFluents) {
        NormExpression ret = new NormExpression();
        PDDLNumber c = new PDDLNumber(0);
        Iterator it = this.summations.iterator();
        boolean zero = true;
        while (it.hasNext()) {
            Addendum a = (Addendum) it.next();
            if (a.f != null) {
                if ((Boolean) invFluents.get(a.f)) {
                    zero = false;
                    c = new PDDLNumber(c.getNumber() + a.f.eval(s).getNumber() * a.n.getNumber());
                } else {
                    ret.summations.add(a);
                }
            }
        }
        boolean trovato = false;
        Iterator it2 = this.summations.iterator();
        while (it2.hasNext()) {
            Addendum a = (Addendum) it2.next();
            if (a.f == null) {
                //System.out.println("TROVATO");
                ret.summations.add(new Addendum(null, new PDDLNumber(a.n.getNumber() + c.getNumber())));
                trovato = true;
                break;
            }

        }
        if ((!trovato) && (!zero)) {
            ret.summations.add(new Addendum(null, c));
        }

        return ret;
    }

    @Override
    public NormExpression normalize() {
        //System.out.println("Expression normalized by default");
        return this;
    }

    @Override
    public void changeVar(Map substitution) {
        for (Object o : this.summations) {

            Addendum a = (Addendum) o;
            a.f.changeVar(substitution);

        }
    }

    @Override
    public String pddlPrint() {
        String ret_val = "";

        {
            //System.out.println(summations);
            Addendum ad = (Addendum) summations.get(0);
            if (ad.f == null) {

                ret_val = " " + ad.n.pddlPrint() + " ";
            } else {
                ret_val = "(* " + ad.f.pddlPrint() + " " + ad.n.pddlPrint() + ")";
            }
        }
        {
            for (int i = 1; i < summations.size(); i++) {
                Addendum ad = (Addendum) summations.get(i);

                if (ad.f == null) {
                    ret_val = "(+ " + ret_val + " " + ad.n.pddlPrint() + " )";
                } else {
                    ret_val = "(+ " + ret_val + " " + "(* " + ad.f.pddlPrint() + " " + ad.n.pddlPrint() + "))";
                }
            }
        }
        return ret_val;
    }

    @Override
    public NormExpression subst(Conditions numeric) {
        ArrayList toAdd = new ArrayList();
        ArrayList toRemove = new ArrayList();
        Iterator it = summations.iterator();
        while (it.hasNext()) {
            Addendum ad = (Addendum) it.next();
            if (ad.f != null) {
                for (Object o1 : numeric.sons) {
                    NumEffect ef = (NumEffect) o1;
                    NumEffect eff = (NumEffect) ef.clone();
//                    System.out.println(" "+eff.getOne().getName()+ " "+ ad.f.getName() + ": " + eff.getOne().equals(ad.f));
                    if (eff.getFluentAffected().equals(ad.f)) {
                        if ((eff.getOperator().equals("increase"))) {
                            NormExpression res = new NormExpression();
                            res.sum((NormExpression) eff.getRight());
                            res.mult(ad.n);
                            toAdd.add(res);
                        } else if (eff.getOperator().equals("decrease")) {
                            NormExpression res = new NormExpression();
                            res.sum((NormExpression) eff.getRight());
                            res.mult(ad.n);
                            toRemove.add(res);
                        } else if (eff.getOperator().equals("assign")) {
                            NormExpression res = new NormExpression();
                            res.sum((NormExpression) eff.getRight());
                            res.mult(ad.n);
                            toAdd.add(res);
                            it.remove();
                        }
                    }
                }
            }
        }

        for (Object o : toAdd) {
            this.sum((NormExpression) o);
        }
        for (Object o : toRemove) {
            this.minus((NormExpression) o);
        }
        return this;
    }

    private void mult(PDDLNumber n) {
        for (Object o : summations) {
            Addendum ad = (Addendum) o;
            ad.n = new PDDLNumber(ad.n.getNumber() * n.getNumber());
        }
    }

    @Override
    public Expression clone() {
        NormExpression ret = new NormExpression();

        ret.summations = new ArrayList();

        Iterator it = this.summations.iterator();

        while (it.hasNext()) {
            Addendum ad = (Addendum) it.next();
            try {
                ret.summations.add(ad.clone());
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(NormExpression.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        ret.grounded = this.grounded;


        return ret;
    }

    @Override
    public PDDLNumbers eval(RelState s) {
        PDDLNumbers ret = new PDDLNumbers(0);
        for (Object o : this.summations) {
            Addendum a = (Addendum) o;

            if (a.f != null) {
                PDDLNumbers temp = s.functionValues(a.f);
                temp = temp.mult(a.n.getNumber());
                ret = ret.sum(temp);
//                ret.inf = new PDDLNumber(ret.inf.getNumber() + s.functionInfValue(a.f).getNumber() * a.n.getNumber());
//                ret.sup = new PDDLNumber(ret.sup.getNumber() + s.functionSupValue(a.f).getNumber() * a.n.getNumber());
            } else {
                ret = ret.sum(a.n.getNumber());
            }
        }
        return ret;
    }

    @Override
    public boolean involve(ArrayList<NumFluent> arrayList) {
        for (NumFluent f : arrayList) {
            for (Object o : this.summations) {
                Addendum a = (Addendum) o;
                if (a.f != null) {
                    if (a.f.equals(f)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isNumber() {
        int counter =0;
        for (Object o: summations){
            Addendum ad = (Addendum)o;
            if (ad.f != null)
                return false;
            counter++;
        }
        if (counter >1)
            System.err.println("Something is gone wrong: ");
        
        return true;
    }

    public PDDLNumber getNumber() {
        if (this.isNumber()){
           PDDLNumber temp = new PDDLNumber(0);
           for (Object o: summations){
                Addendum ad = (Addendum)o;
                temp = new PDDLNumber(ad.n.getNumber() + temp.getNumber());
            }
            return temp;
            
        }else{
            System.out.println(this.toString() + "  is not a single number");
            return null;
        }
            
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expressions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import problem.State;

/**
 *
 * @author enrico
 */
public class NormExpression extends Expression {

    public ArrayList summations;

    public NormExpression() {
        this.summations = new ArrayList();
    }

    @Override
    public String toString() {
        String ret = "";
        boolean first  = true;
        for (Object o : this.summations) {
            Addend a = (Addend) o;
            if (a.f != null) {
                if (first){
                    ret = ret.concat(a.n + "x" + a.f );
                    first = false;
                }else
                    ret = ret.concat(" + " + a.n + "x" + a.f );
            } else {
                if (first){
                    ret = ret.concat(a.n.toString());
                    first = false;
                }else
                    ret = ret.concat("+" + a.n);
            }
        }
        ret = ret.concat("");
        return ret;
    }

    NormExpression sum(NormExpression right) {

        for (Object o : summations) {
            Addend a = (Addend) o;
            Iterator it = right.summations.iterator();
            while (it.hasNext()) {
                Addend a1 = (Addend) it.next();
                if ((a1.f == null) && (a.f == null)) {
                    a.n = new PDDLNumber(a.n.getNumber() + a1.n.getNumber());
                    it.remove();
                } else if (a1.f != null && a.f != null) {
                    if (a1.f.equals(a.f)) {
                        a.n = new PDDLNumber(a.n.getNumber() + a1.n.getNumber());
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

    NormExpression minus(NormExpression right) {
        for (Object o : summations) {
            Addend a = (Addend) o;
            Iterator it = right.summations.iterator();
            while (it.hasNext()) {
                Addend a1 = (Addend) it.next();
                if ((a1.f == null) && (a.f == null)) {
                    a.n = new PDDLNumber(a.n.getNumber() - a1.n.getNumber());
                    it.remove();
                } else if (a1.f != null && a.f != null) {
                    if (a1.f.equals(a.f)) {
                        a.n = new PDDLNumber(a.n.getNumber() - a1.n.getNumber());
                        it.remove();
                    }
                }
            }
        }
        for (Object o1 : right.summations) {
            Addend a1 = (Addend) o1;
            a1.n = new PDDLNumber(a1.n.getNumber() * (-1));
            this.summations.add(o1);
        }
        return this;
    }

    NormExpression mult(NormExpression right) {
        for (Object o : summations) {
            Addend a = (Addend) o;
            Iterator it = right.summations.iterator();
            while (it.hasNext()) {
                Addend a1 = (Addend) it.next();
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
            Addend a = (Addend) right.summations.get(0);
            if (a.f != null) {
                System.out.println("Denominator cannot be a non constant term");
            } else {
                System.out.println("Summations at denominator cannot be more than one element");
            }
            System.exit(-1);
        } else {
            Addend a1 = (Addend) right.summations.get(0);
            for (Object o : this.summations) {
                Addend a = (Addend) o;
                a.n = new PDDLNumber(a.n.getNumber() / a1.n.getNumber());
            }
        }
        return this;
    }

    @Override
    public Expression ground(Map substitution) {
        NormExpression ret = new NormExpression();
        for (Object o : this.summations) {
            Addend a = (Addend) o;
            Addend newA = new Addend();
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
            Addend a = (Addend) o;
            if (a.f != null){
                ret = new PDDLNumber(ret.getNumber() + s.functionValue(a.f).getNumber() * a.n.getNumber());
            }else
                ret = new PDDLNumber(ret.getNumber() + a.n.getNumber());
        }
        return ret;
    }

    @Override
    public NormExpression normalize() {
        System.out.println("Expression normalized by default");
        return this;
    }

    @Override
    public void changeVar(Map substitution) {
        for (Object o : this.summations) {
            
            Addend a = (Addend) o;
            a.f.changeVar(substitution);
            
        }
    }
}

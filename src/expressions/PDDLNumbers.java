/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expressions;

/**
 *
 * @author Enrico Scala
 */
public class PDDLNumbers {

    public PDDLNumber inf;
    public PDDLNumber sup;

    public PDDLNumbers() {
        super();
    }

    PDDLNumbers(float i) {
        inf = new PDDLNumber(i);
        sup = new PDDLNumber(i);
    }

    public PDDLNumbers sum(PDDLNumbers b) {
        PDDLNumbers ret_val = new PDDLNumbers();

        ret_val.inf = new PDDLNumber(new Float(inf.getNumber()) + new Float(b.inf.getNumber()));
        ret_val.sup = new PDDLNumber(new Float(sup.getNumber()) + new Float(b.sup.getNumber()));

        return ret_val;
    }

    public PDDLNumbers subtract(PDDLNumbers b) {
        PDDLNumbers ret_val = new PDDLNumbers();
        ret_val.inf = new PDDLNumber(new Float(inf.getNumber()) - new Float(b.sup.getNumber()));
        ret_val.sup = new PDDLNumber(new Float(sup.getNumber()) - new Float(b.inf.getNumber()));

        return ret_val;
    }

    public PDDLNumbers mult(Float a) {
        PDDLNumbers ret_val = new PDDLNumbers();

        if (a < 0) {
            ret_val.inf = new PDDLNumber(sup.getNumber() * a);
            ret_val.sup = new PDDLNumber(inf.getNumber() * a);

        } else {
            ret_val.inf = new PDDLNumber(inf.getNumber() * a);
            ret_val.sup = new PDDLNumber(sup.getNumber() * a);
        }

        return ret_val;
    }

    public PDDLNumbers mult(PDDLNumbers b) {
        PDDLNumbers ret_val = new PDDLNumbers();
        //System.out.println("Moltiplicazione: " + this.inf +" * "+b.inf);
        Float ac = inf.getNumber() * b.inf.getNumber();
        Float ad = inf.getNumber() * b.sup.getNumber();
        Float bc = sup.getNumber() * b.inf.getNumber();
        Float bd = sup.getNumber() * b.sup.getNumber();
        ret_val.inf = new PDDLNumber(Math.min(ac, Math.min(ad, Math.min(bc, bd))));
        ret_val.sup = new PDDLNumber(Math.max(ac, Math.max(ad, Math.max(bc, bd))));
        return ret_val;

    }

    public PDDLNumbers div(PDDLNumbers b) {
        PDDLNumbers ret_val = new PDDLNumbers();
        Float ac = new Float(inf.getNumber()) / new Float(b.inf.getNumber());
        Float ad = new Float(inf.getNumber()) / new Float(b.sup.getNumber());
        Float bc = new Float(sup.getNumber()) / new Float(b.inf.getNumber());
        Float bd = new Float(sup.getNumber()) / new Float(b.sup.getNumber());
        ret_val.inf = new PDDLNumber(Math.min(ac, Math.min(ad, Math.min(bc, bd))));
        ret_val.sup = new PDDLNumber(Math.max(ac, Math.max(ad, Math.max(bc, bd))));

        return ret_val;
    }

    public PDDLNumbers clone() {
        PDDLNumbers ret_val = new PDDLNumbers();

        ret_val.inf = new PDDLNumber(this.inf.getNumber());
        ret_val.sup = new PDDLNumber(this.sup.getNumber());
        return ret_val;

    }

    public PDDLNumbers sum(Float number) {
        PDDLNumbers ret_val = new PDDLNumbers();
        ret_val.inf = new PDDLNumber(this.inf.getNumber() + number);
        ret_val.sup = new PDDLNumber(this.sup.getNumber() + number);
        return ret_val;
    }
}

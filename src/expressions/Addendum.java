/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expressions;

/**
 *
 * @author enrico
 */
public class Addendum {

    public PDDLNumber n;
    public NumFluent f;

    public Addendum() {
    }

    public Addendum(NumFluent f, PDDLNumber n) {

        this.f = f;
        this.n = n;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Addendum ret = new Addendum();
        if (this.f != null) {
            ret.f = (NumFluent) this.f.clone();
        } else {
            ret.f = null;
        }
        ret.n = (PDDLNumber) this.n.clone();
        return ret;
    }
}

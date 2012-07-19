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

    public Addendum(){
    
    }
    public Addendum(NumFluent f, PDDLNumber n){
    
        this.f = f;
        this.n = n;
    }
}

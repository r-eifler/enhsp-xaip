/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expressions;

import java.util.Map;

/**
 *
 * @author enrico
 */
public abstract class Expression extends Object {
    public boolean grounded;
    public Expression(){
        grounded=false;
    }
    public abstract Expression ground(Map substitution);

}

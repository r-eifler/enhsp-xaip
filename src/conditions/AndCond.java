/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conditions;

import java.util.Set;

/**
 *
 * @author enrico
 */
public class AndCond extends Conditions {
    
    public AndCond(){
        super();
    }
    public void addConditions(Conditions c){
        
        son.add(c);

        
    }
    public String toString(){
        String ret_val="And(";
        for (Object o: son){
            ret_val = ret_val.concat(o.toString());
        }
        ret_val = ret_val.concat(")");
        return ret_val;
    }
}

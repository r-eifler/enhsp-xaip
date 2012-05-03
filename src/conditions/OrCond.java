/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conditions;

import java.util.Map;

/**
 *
 * @author enrico
 */
public class OrCond extends Conditions {
    public OrCond(){
        super();
    }
    public void addConditions(Conditions c){
        son.add(c);
    }
    public String toString(){
        String ret_val="Or(";
        for (Object o: son){
            ret_val = ret_val.concat(o.toString());
        }
        ret_val = ret_val.concat(")");

        return ret_val;
    }
    
    @Override
    public Conditions ground(Map substitution) {
        OrCond ret = new OrCond();
        
        for (Object o: son){
            Conditions el = (Conditions)o;
            ret.son.add(el.ground(substitution));
        }
        ret.grounded = true;
        return ret;
    }
}

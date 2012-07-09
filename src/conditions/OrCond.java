/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conditions;

import java.util.Map;
import problem.State;

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

    @Override
    public boolean eval(State s) {
        
        for (Object o: son){
            Conditions c = (Conditions)o;
            if (c.eval(s))
                return true;
        }

        return false;
    }

    @Override
    public boolean isSatisfied(State s) {
        for (Object o: son){
            Conditions c = (Conditions)o;
            if (c.eval(s))
                return true;
        }

        return false;
    }

    @Override
    public void changeVar(Map substitution) {
        
        for (Object o: son){
            Conditions el = (Conditions)o;
            el.changeVar(substitution);
        }
    }
}

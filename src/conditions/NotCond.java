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
public class NotCond extends Conditions{
    public NotCond(){
        super();
    }
    public void addConditions(Conditions c){
        son.add(c);
    }
    public String toString(){
        String ret_val="Not(";
        for (Object o: son){
            ret_val = ret_val.concat(o.toString());
        }
        ret_val = ret_val.concat(")");

        return ret_val;
    }
    
    @Override
    public Conditions ground(Map substitution) {
        NotCond ret = new NotCond();
        
        for (Object o: son){
            Conditions el = (Conditions)o;
            ret.son.add(el.ground(substitution));
        }
        ret.grounded = true;
        return ret;
    }


    //ECCO LA CLOSED WORLD ASSUMPTION---->>>>E ORA!?
    //Assumiamo che non lo stato le cose che non ci sono sono considerate negate. Questo prevede che la lettura dello stato iniziale ELIMINI tutte le cose negative.....
    @Override
    public boolean eval(State s) {
        for(Object o :this.son){
            Conditions c = (Conditions)o;
            return !c.eval(s);
        }
        return false;
    }
}

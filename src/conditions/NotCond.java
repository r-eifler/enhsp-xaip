/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conditions;

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
}

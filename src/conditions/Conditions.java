/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conditions;

import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author enrico
 */
public abstract class Conditions extends Object{
    public HashSet son;
    public boolean grounded ;
    public Conditions(){
        son = new HashSet();
        grounded = false;
        
    }
    //public abstract void addConditions(Conditions o);
    public abstract Conditions ground(Map substitution);
}

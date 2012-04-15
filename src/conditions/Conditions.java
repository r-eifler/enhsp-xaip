/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conditions;

import java.util.HashSet;

/**
 *
 * @author enrico
 */
public abstract class Conditions extends Object{
    public HashSet son;
    public Conditions(){
        son = new HashSet();
    }
    //public abstract void addConditions(Conditions o);
    
}

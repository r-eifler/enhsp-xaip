/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import conditions.PDDLObject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author enrico
 */
public class ActionParametersAsTerms extends ArrayList{

    public PDDLObject containsTerm(PDDLObject o){
        Integer ret_val=-1;
        Iterator it = this.iterator();
        while (it.hasNext()){
            PDDLObject t = (PDDLObject)it.next();
            if (t.getName() == null ? o.getName() == null : t.getName().equalsIgnoreCase(o.getName())){
                return t;
            }
        }
        return null;
    }
    
}

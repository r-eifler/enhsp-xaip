/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package problem;

import conditions.Term;

import domain.Type;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author enrico
 */
public class ProblemObjects extends HashSet{


    public boolean validate(Term t){

        for (Object el: this){
            
            Term elP = (Term)el;
            if (elP.getName() == null ? t.getName() == null : elP.getName().equalsIgnoreCase(t.getName()));
                    return true;
        }
        return false;
    }

    public Type getTermType(Term t){
        for (Object el: this){

            Term elP = (Term)el;
            if (elP.getName() == null ? t.getName() == null : elP.getName().equalsIgnoreCase(t.getName()))
                    return elP.getType();
        }
        return null;
    }
    public Term containsTerm(Term t){
        for (Object el: this){

            Term elP = (Term)el;
            if (elP.getName() == null ? t.getName() == null : elP.getName().equalsIgnoreCase(t.getName()))
                    return elP;
        }
        return null;
    }
    
    
    public String toString(){
        String ret_val="";
        for (Object el: this){
            Term elemento= (Term) el;
            ret_val += " " + elemento.toString() + " ";
        }

        return ret_val;
    }
}

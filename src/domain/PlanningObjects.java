/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import conditions.Term;

import java.util.HashMap;

/**
 *
 * @author enrico
 */
class PlanningObjects extends HashMap{


    public boolean validate(Term t){

        for (Object el: this.values()){
            
            Term elP = (Term)el;
            if (elP.getName() == null ? t.getName() == null : elP.getName().equals(t.getName()));
                    return true;
        }
        return false;
    }

    public Type getTermType(Term t){
        for (Object el: this.values()){

            Term elP = (Term)el;
            if (elP.getName() == null ? t.getName() == null : elP.getName().equals(t.getName()))
                    return elP.getType();
        }
        return null;
    }
    public Term containsTerm(Term t){
        for (Object el: this.values()){

            Term elP = (Term)el;
            if (elP.getName() == null ? t.getName() == null : elP.getName().equals(t.getName()))
                    return elP;
        }
        return null;
    }
    
    
    public String toString(){
        String ret_val="";
        for (int i=0;i<this.size();i++){
            Term elemento= (Term) this.get(i);
            ret_val += " " + elemento.toString() + " ";
        }

        return ret_val;
    }
}

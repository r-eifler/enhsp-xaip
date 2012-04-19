/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import conditions.Predicate;
import conditions.Term;

import java.util.HashSet;

/**
 *
 * @author enrico
 */
class PredicateSet extends HashSet{

    public boolean validate(Predicate p){

        for (Object el: this){
            Predicate elP = (Predicate)el;
            if (elP.getPredicateName() == null ? p.getPredicateName() == null : elP.getPredicateName().equalsIgnoreCase(p.getPredicateName()))
                if(elP.getVariables().size() == p.getVariables().size())
                    return true;
        }
        return false;
    }

    public boolean validateInst(Predicate p){

        for (Object el: this){
            Predicate elP = (Predicate)el;
            if (elP.getPredicateName() == null ? p.getPredicateName() == null : elP.getPredicateName().equalsIgnoreCase(p.getPredicateName())){
                if (elP.getVariables().size() == p.getTerms().size()){
                    int i=0;
                    for (Object o:elP.getVariables()){
                        Variable v = (Variable)o;
                        Term t = (Term)p.getTerms().get(i);
                        if (!(v.getType().equals(t.getType())))
                            return false;
                        i++;
                    }
                    return true;
                }else
                    return false;
            }
            
        }
        return false;
    }

}

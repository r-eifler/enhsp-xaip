/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import conditions.Predicate;
import conditions.PDDLObject;

import java.util.HashSet;

/**
 *
 * @author enrico
 */
class PredicateSet extends HashSet {

    public boolean validate(Predicate p) {

        for (Object el : this) {
            Predicate elP = (Predicate) el;
            if (elP.getPredicateName() == null ? p.getPredicateName() == null : elP.getPredicateName().equalsIgnoreCase(p.getPredicateName())) {
                if (elP.getTerms().size() == p.getTerms().size()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean validateInst(Predicate p) {

        for (Object el : this) {
            Predicate elP = (Predicate) el;
            if (elP.getPredicateName() == null ? p.getPredicateName() == null : elP.getPredicateName().equalsIgnoreCase(p.getPredicateName())) {
                if (elP.getTerms().size() == p.getTerms().size()) {
                    int i = 0;
                    boolean found = true;
                    for (Object o : elP.getTerms()) {
                        Variable v = (Variable) o;
                        PDDLObject t = (PDDLObject) p.getTerms().get(i);
                        if (!(v.getType().equals(t.getType())) && !(t.getType().isAncestorOf(v.getType()))) {
                            found = false;

                            System.out.println("relazione non valida: " + v.getType() + t.getType());
                            System.out.println((v.getType().isAncestorOf(t.getType())));
                        }
                        i++;
                        if (!found) {
                            break;
                        }
                    }
                    if (found == true) {
                        return true;
                    }
                }
            }

        }
        return false;
    }
}

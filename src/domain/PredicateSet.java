/**
 * *******************************************************************
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 *
 ********************************************************************
 */
/**
 * *******************************************************************
 * Description: Part of the PPMaJaL library
 *
 * Author: Enrico Scala 2013 Contact: enricos83@gmail.com
 *
 ********************************************************************
 */
package domain;

import conditions.Predicate;
import conditions.PDDLObject;

import java.util.HashSet;

/**
 *
 * @author enrico
 */
public class PredicateSet extends HashSet<Predicate> {

    public boolean validate(Predicate p) {

        for (Object el : this) {
            Predicate elP = (Predicate) el;
            if (elP.getPredicateName() == null ? p.getPredicateName() == null : elP.getPredicateName().equalsIgnoreCase(p.getPredicateName())) {
                if (elP.getTerms().size() == p.getTerms().size()) {//this is not sufficient. Works just for predicates with different names
                    return true;
                }
            }
        }
        return false;
    }
    
    public Predicate findAssociated(Predicate p) {

        for (Object el : this) {
            Predicate elP = (Predicate) el;
            if (elP.getPredicateName() == null ? p.getPredicateName() == null : elP.getPredicateName().equalsIgnoreCase(p.getPredicateName())) {
                if (elP.getTerms().size() == p.getTerms().size()) {//this is not sufficient. Works just for predicates with different names
//                    for (Object o: elP.getTerms())
                        for (int i=0;i<p.getTerms().size();i++){
                            Variable v = (Variable)elP.getTerms().get(i);
                            Variable v1 = (Variable)p.getTerms().get(i);
                             if (!(v.getType().equals(v1.getType())) && !(v.getType().isAncestorOf(v1.getType()))) {
                                System.out.println(v1+" is neither a valid instance nor a valid subtype for "+v1);
                                return null;
                            }
                        }
                            
                    return elP;
                }
            }
        }
        return null;
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

    public String pddlPrint(boolean typeInformation) {
        String ret="";
        for (Object el : this) {
            Predicate elP = (Predicate) el;
            ret += elP.pddlPrint(typeInformation);
         }
        return ret+")";
    }
    
    public String pddlPrintWithExtraObject(boolean typeInformation) {
        String ret="";
        for (Object el : this) {
            Predicate elP = (Predicate) el;
            if (typeInformation)
                ret += elP.pddlPrintWithTypedExtraObject();
            else
                ret += elP.pddlPrintWithExtraObject();
         }
        return ret+")";
    }

    public void addIfNecessary(Predicate p) {
        boolean found = false;
        String name ="";
        for (Object el : this) {
            Predicate elP = (Predicate) el;
            if (elP.getPredicateName() == null ? p.getPredicateName() == null : elP.getPredicateName().equalsIgnoreCase(p.getPredicateName())) {
                if (elP.getTerms().size() == p.getTerms().size()) {//this is not sufficient. Works just for predicates with different names
                    found = true;
//                    for (Object o: elP.getTerms())
                        for (int i=0;i<p.getTerms().size();i++){
                            Variable v = (Variable)elP.getTerms().get(i);
                            Variable v1 = (Variable)p.getTerms().get(i);
                             if (!(v.getType().equals(v1.getType())) && !(v.getType().isAncestorOf(v1.getType()))) {
                                System.out.println(v1+" is neither a valid instance nor a valid subtype for "+v);
                                if (!(v1.getType().equals(v.getType())) && !(v1.getType().isAncestorOf(v.getType()))) {
                                    System.out.println(v+" is neither a valid instance nor a valid subtype for "+v1);
                                    found = false;
                                }else{
                                    found = true;
                                    v.setType(v1.getType());
                                }
                                      
                             }else{
                                 found=true;
                                 break;
                             }
                                 
                        }
     
                    
                }
            }
        }
        if (!found)
            this.add(p);

         
    }
}

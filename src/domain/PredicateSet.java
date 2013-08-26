/*********************************************************************
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 * 
 *********************************************************************/

/*********************************************************************
 * Description: Part of the PPMaJaL library
 *             
 * Author: Enrico Scala 2013
 * Contact: enricos83@gmail.com
 *
 *********************************************************************/ 

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

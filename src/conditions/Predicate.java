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

package conditions;

import domain.Variable;
import expressions.NumFluent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import problem.RelState;
import problem.State;

/**
 *
 * @author enrico
 */
public class Predicate extends Conditions {

    private String predicateName;
    //private ArrayList variables;
    private ArrayList terms;
    private boolean grounded;
    public HashSet son;

    /**
     * @return the predicateName
     */
    public Predicate() {
        super();
        //variables = new ArrayList();
        terms = new ArrayList();
    }

    public Predicate(boolean g) {

        super();
        grounded = g;
        //variables = new ArrayList();
        terms = new ArrayList();

    }

    public String getPredicateName() {
        return predicateName;
    }

//    //return a grounded copy of the Predicate
//    public Predicate ground(ArrayList terms_) {
//
//        Predicate ret_val = new Predicate(true);
//        ret_val.setPredicateName(predicateName);
//        int i = 0;
//        if (terms_.size() != getVariables().size()) {
//            return null;
//        }
//        for (Object o : terms_) {
//            PDDLObject t = (PDDLObject) o;
//            Variable v = (Variable) getVariables().get(i);
//            if (!t.getType().equals(v.getType())) {
//                return null;
//            }
//        }
//        ret_val.setTerms(terms_);
//        return ret_val;
//    }
    /**
     * @param predicateName the predicateName to set
     */
    public void setPredicateName(String predicateName) {
        this.predicateName = predicateName;
    }

    /**
     * @param adding a variable term to the predicate
     */
    public void addVariable(Variable v) {
        if (isGrounded()) {
            System.out.println("Predicate grounded; no variable is possible");
        } else {
            getTerms().add(v);
        }
    }

    public void addObject(PDDLObject t) {
        if (!isGrounded()) {
            System.out.println("Predicate not grounded; no term is possible");
        } else {
            getTerms().add(t);
        }
    }

    @Override
    public String toString() {
        String ret_val = "(" + this.predicateName + " ";

        ret_val = ret_val.concat(getTerms().toString());

        ret_val = ret_val.concat(") ");
        return ret_val;
    }

    /**
     * @return the terms
     */
    public ArrayList getTerms() {
        return terms;
    }

    /**
     * @param terms the terms to set
     */
    public void setTerms(ArrayList terms) {
        this.terms = terms;
    }

    /**
     * @return the grounded
     */
    public boolean isGrounded() {
        return grounded;
    }

    /**
     * @param grounded the grounded to set
     */
    public void setGrounded(boolean grounded) {
        this.grounded = grounded;
    }

    @Override
    public Conditions ground(Map substitution) {
        Predicate ret = new Predicate(true);
        ret.setPredicateName(predicateName);

        for (Object o : terms) {
            if (o instanceof Variable) {
                PDDLObject t = (PDDLObject) substitution.get(o);
                if (t == null) {
                    System.out.println("Error in substitution  for " + o);
                    System.exit(-1);
                } else {
                    ret.terms.add(t);
                }
            }
        }
        return ret;
    }

    @Override
    public boolean eval(State s) {
        return s.containProposition(this);
    }

    @Override
    public boolean isSatisfied(State s) {

        return s.containProposition(this);
    }

    @Override
    public boolean isSatisfied(RelState s) {

        return s.containProposition(this);
    }

    @Override
    public boolean equals(Object obj) {
        Predicate objF = (Predicate) obj;


        if (objF.getPredicateName().equalsIgnoreCase(this.getPredicateName())) {
            if (objF.terms.size() == this.terms.size()) {
                for (int i = 0; i < objF.terms.size(); i++) {
                    if (!(objF.terms.get(i).equals(this.terms.get(i)))) {
                        return false;
                    }
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.predicateName != null ? this.predicateName.hashCode() : 0);
        hash = 79 * hash + (this.terms != null ? this.terms.hashCode() : 0);
        return hash;
    }

    public State apply(State s) {
        if (!s.containProposition(this)) {
            s.addProposition(this);
        }
        return s;
    }

    public State remove(State s){
        s.removeProposition(this);

        return s;
    }

    @Override
    public void changeVar(Map substitution) {
        ArrayList newVar = new ArrayList();

        for (Object o : terms) {
            if (o instanceof Variable) {
                Variable v = (Variable) substitution.get(o);
                if (v == null) {
                    System.out.println("Not Found Variable" + o);
                    System.exit(-1);
                }
                newVar.add(v);
            } else {
                newVar.add(o);
            }
        }
        terms = newVar;
    }

    @Override
    public String pddlPrint() {
        String ret = "";
        ret = ret.concat("  (" + this.getPredicateName());
        for (Object o1 : this.getTerms()) {
            PDDLObject obj = (PDDLObject) o1;
            ret = ret.concat(" " + obj.getName());
        }
        ret = ret.concat(")");
        return ret;
    }

    @Override
    public Conditions clone() {
//        Predicate ret_val = new Predicate();
//        ret_val.setPredicateName(predicateName);
//        ret_val.grounded = this.grounded;
//        if (grounded)
//            ret_val.terms = (ArrayList)this.terms.clone();
//        else
//            ret_val.variables = (ArrayList)this.variables.clone();
//        
//        return ret_val;
        return this;
    }

    public RelState apply(RelState s) {

        if (!s.containProposition(this)) {
            s.addProposition(this);
        }
        return s;
    }

    RelState remove(RelState s) {
        s.removeProposition(this);

        return s;
    }

    @Override
    public void normalize() {
        return;
    }
}

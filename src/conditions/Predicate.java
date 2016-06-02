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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import problem.GroundAction;
import problem.RelState;
import problem.State;

/**
 *
 * @author enrico
 */
public class  Predicate extends Conditions {

    private String predicateName;
    //private ArrayList variables;
    private ArrayList terms;
    private boolean grounded;
    public HashSet son;
    public Integer hash_code;

    /**
     * @return the predicateName
     */
    public Predicate() {
        super();
        //variables = new ArrayList();
        terms = new ArrayList();
    }
    
    public Predicate(String name) {
        super();
        //variables = new ArrayList();
        this.predicateName = name;
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
        ret.grounded = true;

        //System.out.println(this);
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
    public Conditions ground(Map substitution, int c) {
        Conditions ret = this.ground(substitution);
        ret.setCounter(c);
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

//    /**
//     *
//     * @param obj
//     * @return
//     */
//    @Override
//    public boolean equals(Object obj) {
//        Predicate objF = (Predicate) obj;
//        if (objF.getPredicateName().equalsIgnoreCase(this.getPredicateName())) {
//            if (objF.terms.size() == this.terms.size()) {
//                for (int i = 0; i < objF.terms.size(); i++) {
//                    if (!(objF.terms.get(i).equals(this.terms.get(i)))) {
//                        return false;
//                    }
//                }
//            } else {
//                return false;
//            }
//        } else {
//            return false;
//        }
//        return true;
//    }

    @Override
    public int hashCode() {
        if (this.hash_code == null){
            int hash = 7;
            hash = 79 * hash + (this.predicateName != null ? this.predicateName.hashCode() : 0);
            hash = 79 * hash + (this.terms != null ? this.terms.hashCode() : 0);
            this.hash_code = hash;
        }
        
        return this.hash_code;
    }

//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 97 * hash + (this.terms != null ? this.terms.hashCode() : 0);
//        return hash;
//    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Predicate other = (Predicate) obj;
        if ((this.predicateName == null) ? (other.predicateName != null) : !this.predicateName.equals(other.predicateName)) {
            return false;
        }
        if (this.terms != other.terms && (this.terms == null || !this.terms.equals(other.terms))) {
            return false;
        }
        if (this.hash_code != other.hash_code && (this.hash_code == null || !this.hash_code.equals(other.hash_code))) {
            return false;
        }
        return true;
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
    public String pddlPrint(boolean typeInformation) {
        String ret = "";
        ret = ret.concat("  (" + this.getPredicateName());
        for (Object o1 : this.getTerms()) {
            if (o1 instanceof PDDLObject){
                PDDLObject obj = (PDDLObject) o1;
                ret = ret.concat(" " + obj.getName());
            }else{
                Variable obj = (Variable) o1;
                if (typeInformation)
                    ret = ret.concat(" " + obj.getName()+obj.getType());
                else
                    ret = ret.concat(" " + obj.getName());
                
            }
            
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
    
    @Override
    public Conditions unGround(Map substitution) {
        Predicate ret = new Predicate(true);
        ret.setPredicateName(predicateName);

        //System.out.println(this);
        for (Object o : this.getTerms()) {
            if (o instanceof PDDLObject) {
                PDDLObject obj = (PDDLObject)o;
                Variable t = (Variable) substitution.get(obj.getName());
                
                if (t == null) {
                    System.out.println("Error in substitution  for " + o);
                    System.exit(-1);
                } else {
                    ret.terms.add(t);
                }
            }
        }
        this.grounded = false;
        return ret;
    }

    @Override
    public boolean isUngroundVersionOf(Conditions con) {
        if (con instanceof Predicate){
            Predicate p = (Predicate)con;
            if (this.getPredicateName().equals(p.getPredicateName())){
                if (this.getTerms().size() == p.getTerms().size()){
                    for (int i=0; i< this.getTerms().size();i++){
                        Variable v = (Variable)this.getTerms().get(i);
                        PDDLObject obj = (PDDLObject)p.getTerms().get(i);
                        //System.out.print("Matching Types between: "+ v.getType() + obj.getType());
                        if (!v.getType().equals(obj.getType())){
                            if (!v.getType().isAncestorOf(obj.getType())){
                                //System.out.println("Sottotipo di:"+obj.getType().getSubTypeOf());
                                //System.out.println(" FAILURE!!");
                                return false;
                            }
                        }
                    }
                    return true;
                }
    
            }
                
        }
        return false;
    }


    @Override
    public String toSmtVariableString(int i) {
                String ret = "";
        ret = ret.concat(this.getPredicateName());
        for (Object o1 : this.getTerms()) {
            if (o1 instanceof PDDLObject){
                PDDLObject obj = (PDDLObject) o1;
                ret = ret.concat(" " + obj.getName());
            }else{
                Variable obj = (Variable) o1;
                ret = ret.concat(" " + obj.getName());
                
            }
            
        }
        ret+="-"+i;
        //ret = ret.concat(")");
        return ret.replaceAll("\\s+","");
    }

    @Override
    public Set<NumFluent> getInvolvedFluents() {
        return null;
    }

    @Override
    public Conditions weakEval(State s, HashMap invF) {
        return this;
    }

    @Override
    public String toSmtVariableString(int k, GroundAction gr, String var) {
        return " true ";
    }

    @Override
    public Conditions transform_equality() {
        return this;
    }

    @Override
    public boolean is_affected_by(GroundAction gr){
        return gr.achieve(this) || gr.delete(this);
    }

  
    
}

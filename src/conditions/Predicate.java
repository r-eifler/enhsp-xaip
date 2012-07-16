/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conditions;

import domain.Variable;

import java.util.ArrayList;
import java.util.Map;
import problem.State;

/**
 *
 * @author enrico
 */
public class Predicate extends Conditions {

    private String predicateName;
    private ArrayList variables;
    private ArrayList terms;
    private boolean grounded;

    /**
     * @return the predicateName
     */
    public Predicate() {
        super();
        variables = new ArrayList();
    }

    public Predicate(boolean g) {
        grounded = g;
        if (grounded) {
            terms = new ArrayList();
        } else {
            variables = new ArrayList();
        }
    }

    public String getPredicateName() {
        return predicateName;
    }

    //return a grounded copy of the Predicate
    public Predicate ground(ArrayList terms_) {

        Predicate ret_val = new Predicate(true);
        ret_val.setPredicateName(predicateName);
        int i = 0;
        if (terms_.size() != getVariables().size()) {
            return null;
        }
        for (Object o : terms_) {
            PDDLObject t = (PDDLObject) o;
            Variable v = (Variable) getVariables().get(i);
            if (!t.getType().equals(v.getType())) {
                return null;
            }
        }
        ret_val.setTerms(terms_);
        return ret_val;
    }

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
            getVariables().add(v);
        }
    }

    public void addTerm(PDDLObject t) {
        if (!isGrounded()) {
            System.out.println("Predicate not grounded; no term is possible");
        } else {
            getTerms().add(t);
        }
    }

    @Override
    public String toString() {
        String ret_val = "(" + this.predicateName + " ";


        if (isGrounded()) {
            for (Object o : getTerms()) {

                ret_val = ret_val.concat(o.toString());
            }
        } else {
            ret_val = ret_val.concat(getVariables().toString());

        }
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
     * @return the variables
     */
    public ArrayList getVariables() {
        return variables;
    }

    /**
     * @param variables the variables to set
     */
    public void setVariables(ArrayList variables) {
        this.variables = variables;
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

        for (Object o : variables) {

            PDDLObject t = (PDDLObject) substitution.get(o);
            if (t == null) {
                System.out.println("Error in substitution  for " + o);
                System.exit(-1);
            } else {
                ret.terms.add(t);
            }
        }
        return ret;
    }

    @Override
    public boolean eval(State s) {
        return s.containProposition(this);
    }

    @Override //to be refined!!
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean isSatisfied(State s) {
        
        return s.containProposition(this);
    }

    @Override
    public boolean equals(Object obj) {
        Predicate p = (Predicate) obj;
        if (!p.getPredicateName().equalsIgnoreCase(this.predicateName)) {
            return false;
        }
        if (this.grounded) {
            if (!(p.getTerms().equals(this.getTerms()))) {
                return false;
            }
        } else {
            if (!(p.getVariables().equals(this.variables))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.predicateName != null ? this.predicateName.hashCode() : 0);
        hash = 59 * hash + (this.variables != null ? this.variables.hashCode() : 0);
        hash = 59 * hash + (this.terms != null ? this.terms.hashCode() : 0);
        hash = 59 * hash + (this.grounded ? 1 : 0);
        return hash;
    }

    public State apply(State s) {
        if (!s.containProposition(this)) {
            s.addProposition(this);
        }
        return s;
    }

    public State remove(State s) {
        s.removeProposition(this);

        return s;
    }

    @Override
    public void changeVar(Map substitution) {
        ArrayList newVar = new ArrayList();

        for (Object o : variables) {
            Variable v = (Variable) substitution.get(o);
            if (v == null) {
                System.out.println("Not Found Variable" + o);
                System.exit(-1);
            }
            newVar.add(substitution.get(o));
        }
        variables = newVar;
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
}

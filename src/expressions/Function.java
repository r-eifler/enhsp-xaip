/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expressions;

import conditions.Term;

import domain.Variable;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author enrico
 */
public class Function extends Expression {
    String name;
    ArrayList variables;
    private ArrayList terms;

    public Function(String name) {
        super();
        this.name = name;
        variables = new ArrayList();
        terms = new ArrayList(); 
    }

    public void addVariable(Variable variable) {
        variables.add(variable);
    }
    @Override
    public String toString(){
        if (!grounded)
            return " "+ name + " " + variables;
        else
            return " "+ name + " " + terms;
    }

    @Override
    public Expression ground(Map substitution) {
        Function ret = new Function(name);
       
        for (Object o: variables){
            ret.addTerms((Term)substitution.get(o));
        }
        ret.grounded=true;
        return ret;
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
    public void addTerms(Term el){
        terms.add(el);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expressions;

import conditions.Term;

import domain.Variable;
import java.util.ArrayList;
import java.util.Map;
import problem.State;

/**
 *
 * @author enrico
 */
public class Function extends Expression {
    private String name;
    ArrayList variables;
    private ArrayList terms;

    @Override
    public boolean equals(Object obj) {
        boolean equal =false;
        Function objF = (Function)obj;
        
        if (grounded){
            if (objF.terms.size() == this.terms.size()){
                for (int i=0; i < objF.terms.size();i++){
                    if (!(objF.terms.get(i).equals(this.terms.get(i))))
                            return false;
                }
            }else
                return false;
        }else{
            if (objF.variables.size() == this.variables.size()){
                for (int i=0; i < objF.variables.size();i++){
                    if (!(objF.variables.get(i).equals(this.variables.get(i))))
                            return false;
                }
            }else
                return false;
        
        }
        if (!(this.name.equals(objF.name)))    
            return false;
        
        return true;
    }

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
            return " "+ getName() + " " + variables;
        else
            return " "+ getName() + " " + terms;
    }

    @Override
    public Expression ground(Map substitution) {
        Function ret = new Function(getName());
       
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

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Number eval(State s) {
     
        return s.functionValue(this);
    }
}

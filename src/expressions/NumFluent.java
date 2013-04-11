/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expressions;

import conditions.PDDLObject;

import domain.Variable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import problem.State;

/**
 *
 * @author enrico
 */
public class NumFluent extends Expression {
    private String name;
    ArrayList variables;
    private ArrayList terms;

    @Override
    public boolean equals(Object obj) {
        boolean equal =false;
        NumFluent objF = (NumFluent)obj;
        
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 53 * hash + (this.variables != null ? this.variables.hashCode() : 0);
        hash = 53 * hash + (this.terms != null ? this.terms.hashCode() : 0);
        return hash;
    }

    public NumFluent(String name) {
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
        NumFluent ret = new NumFluent(getName());
       
        for (Object o: variables){
            PDDLObject t = (PDDLObject)substitution.get(o);
            if (t == null){
                System.out.println("Substitution Failed for " +o.toString());
                System.exit(-1);
            }else{
               ret.addTerms(t); 
            }
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
    public void addTerms(PDDLObject el){
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
    public PDDLNumber eval(State s) {
     
        return s.functionValue(this);
    }

    @Override
    public NormExpression normalize() {
        Addendum a = new Addendum();
        a.n = new PDDLNumber(1);
        a.f = this;
        NormExpression ret = new NormExpression();
        ret.summations.add(a);
        return ret;

    }

    @Override
    public void changeVar(Map substitution) {
        ArrayList newVar = new ArrayList();
        
        for (Object o : variables) {
            newVar.add(substitution.get(o));
        }
        variables = newVar;
    }

    @Override
    public String pddlPrint() {
        String ret = "";
        ret = ret.concat(" (" + this.name);
        for (Object o1 : this.getTerms()) {
            PDDLObject obj = (PDDLObject) o1;
            ret = ret.concat(" " + obj.getName());
        }
        ret = ret.concat(")");
        return ret;
    
    }

    @Override
    public Expression weakEval(State s, HashMap invF) {
       
        if ((Boolean)invF.get(this)){
            return s.functionValue(this);
        }else{
            return this;
        }
    }

    @Override
    public Expression clone() {
//        NumFluent ret = new NumFluent(this.name);
//        ret.terms = (ArrayList)this.terms.clone();
//        ret.variables = (ArrayList)this.variables.clone();
//        ret.grounded = this.grounded;
//        return ret;
          return this;
    }
}

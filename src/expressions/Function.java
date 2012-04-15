/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expressions;

import conditions.Term;

import java.util.ArrayList;

/**
 *
 * @author enrico
 */
public class Function extends Expression {
    String name;
    ArrayList terms;

    public Function(String name) {
        this.name = name;
        terms = new ArrayList();
    }

    public void addTerm(Term term) {
        terms.add(term);
    }
    public String toString(){
    
        return " "+ name + " " + terms;
    }
    
}

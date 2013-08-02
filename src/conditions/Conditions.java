/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conditions;

import java.util.HashSet;
import java.util.Map;
import problem.RelState;
import problem.State;

/**
 *
 * @author enrico
 */
public abstract class Conditions extends Object {

    public boolean grounded;
    public HashSet sons; //used by formula conditions as AndCond and OrCond. Each son is another condition involved in the formula

    public Conditions() {
        //son = new HashSet();
        grounded = false;
    }
    //public abstract void addConditions(Conditions o);

    public abstract Conditions ground(Map substitution);

    public abstract boolean eval(State s);

    public abstract boolean isSatisfied(State s);

    public abstract void changeVar(Map substitution);

    public abstract String pddlPrint();

    public abstract Conditions clone();

    public abstract boolean isSatisfied(RelState aThis);
    
    public abstract void normalize();


}

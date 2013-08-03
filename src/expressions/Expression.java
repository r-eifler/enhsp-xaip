/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expressions;

import conditions.Conditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import problem.RelState;
import problem.State;

/**
 *
 * @author enrico
 */
public abstract class Expression extends Object {

    public boolean grounded;

    public Expression() {
        grounded = false;
    }

    public abstract Expression ground(Map substitution);

    public abstract PDDLNumber eval(State s);

    //public abstract State apply(State s);
    public abstract NormExpression normalize();

    public abstract void changeVar(Map substitution);

    public abstract String pddlPrint();

    public abstract Expression weakEval(State s, HashMap invF);
    public abstract Expression clone();



    public abstract PDDLNumbers eval(RelState s);

    public abstract boolean involve(ArrayList<NumFluent> arrayList);

    public abstract Expression subst(Conditions numeric);
}

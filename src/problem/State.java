/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package problem;

import conditions.Assign;
import conditions.Predicate;
import expressions.Function;
import expressions.Number;
import java.util.HashSet;

/**
 *
 * @author enrico
 */
public class State extends Object {
    HashSet propositions;
    HashSet numericFs;
    HashSet timedLiterals;

    public State() {
        super();
        propositions = new HashSet();
        numericFs = new HashSet();
        timedLiterals = new HashSet();
    }

    @Override
    public String toString() {
        return "State{" + "propositions=" + propositions + "numericFs=" + numericFs + "timedLiterals=" + timedLiterals + '}';
    }

    @Override
    public State clone() throws CloneNotSupportedException {
        State ret_val = new State();

        ret_val.numericFs = (HashSet)this.numericFs.clone();
        ret_val.propositions = (HashSet)this.propositions.clone();
        ret_val.timedLiterals = (HashSet)this.timedLiterals.clone();

        return ret_val;
    }

    public Iterable<Object> getNumericFluents() {
        return numericFs;
    }

    public Number functionValue(Function f) {
        for (Object o: numericFs){
            if (o instanceof Assign){
                Assign a = (Assign)o;
                if (a.getOne().equals(f)){
                    return a.getTwo().eval(this);
                }
            }
        }
        return null;
    }

    void addProposition(Predicate buildInstPredicate) {
        propositions.add(buildInstPredicate);
    }

    void addNumericFluent(Assign a) {
        numericFs.add(a);
    }

    void addTimedLiteral(Predicate buildInstPredicate) {
        timedLiterals.add(buildInstPredicate);
    }

    public Iterable<Object> getPropositions() {
        return this.propositions;
    }

    public boolean containProposition(Predicate aThis) {
        return this.propositions.contains(aThis);
    }



    public void setFunctionValue(Function f, Number after) {
      for (Object o: numericFs){
                if (o instanceof Assign){
                Assign a = (Assign)o;
                if (a.getOne().equals(f)){
                    a.setTwo(after);
                }
            }
        }
        return;
    }

}

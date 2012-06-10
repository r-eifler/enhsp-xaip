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
import java.util.Iterator;

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

        for (Object o : this.numericFs) {
            Assign ele = (Assign) o;
            Assign newA = new Assign("=");
            newA.setOne(ele.getOne());
            Number newN = new Number(ele.getTwo().getNumber());
            newA.setTwo(newN);
            ret_val.addNumericFluent(newA);
        }

//        for (Object o: this.propositions){
//            Predicate ele = (Predicate)o;
//            ret_val.addProposition((Predicate) ele.clone());
//        }
        ret_val.propositions = (HashSet) this.propositions.clone();

        ret_val.timedLiterals = (HashSet) this.timedLiterals.clone();

        return ret_val;
    }

    public Iterable<Object> getNumericFluents() {
        return numericFs;
    }

    public Number functionValue(Function f) {
        for (Object o : numericFs) {
            if (o instanceof Assign) {
                Assign a = (Assign) o;
                if (a.getOne().equals(f)) {
                    return a.getTwo().eval(this);
                }
            }
        }
        return null;
    }

    public void addProposition(Predicate buildInstPredicate) {
        propositions.add(buildInstPredicate);
    }

    public void addNumericFluent(Assign a) {


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
        for (Object o : numericFs) {
            if (o instanceof Assign) {
                Assign a = (Assign) o;
                if (a.getOne().equals(f)) {
                    a.setTwo(after);
                }
            }
        }
        return;
    }

    public void removeProposition(Predicate aThis) {
        for (Iterator i = propositions.iterator(); i.hasNext();) {
            Predicate p = (Predicate) i.next();
            if (p.equals(aThis)) {
                i.remove();
                return;
            }
        }
        System.out.println(aThis + "non trovato");
    }
}

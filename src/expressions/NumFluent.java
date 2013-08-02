/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expressions;

import conditions.Conditions;
import conditions.PDDLObject;
import domain.Variable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import problem.RelState;
import problem.State;

/**
 *
 * @author Enrico Scala
 */
public class NumFluent extends Expression {

    private String name;
    private ArrayList terms;

    @Override
    public boolean equals(Object obj) {
        NumFluent objF = (NumFluent) obj;

        if (objF.getName().equalsIgnoreCase(this.getName())) {
            if (objF.terms.size() == this.terms.size()) {
                for (int i = 0; i < objF.terms.size(); i++) {
                    if (!(objF.terms.get(i).equals(this.terms.get(i)))) {
                        return false;
                    }
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 53 * hash + (this.terms != null ? this.terms.hashCode() : 0);
        return hash;
    }

    public NumFluent(String name) {
        super();
        this.name = name;
        //variables = new ArrayList();
        terms = new ArrayList();
    }

    public void addVariable(Variable variable) {
        terms.add(variable);
    }

    @Override
    public String toString() {
        return " " + getName() + " " + terms;
    }

    @Override
    public Expression ground(Map substitution) {
        NumFluent ret = new NumFluent(getName());

        for (Object o : terms) {
            if (o instanceof Variable) {
                PDDLObject t = (PDDLObject) substitution.get(o);
                if (t == null) {
                    System.out.println("Substitution Failed for " + o.toString());
                    System.exit(-1);
                } else {
                    ret.addTerms(t);
                }
            } else {
                ret.addTerms((PDDLObject) o);
            }
        }
        ret.grounded = true;
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

    public void addTerms(PDDLObject el) {
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
    public PDDLNumbers eval(RelState s) {
        PDDLNumbers ret = new PDDLNumbers();
        ret.inf = s.functionInfValue(this);
        ret.sup = s.functionSupValue(this);
        if (ret.inf == null) {
            return null;
        }
        return ret;
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

        if ((Boolean) invF.get(this)) {
            return s.functionValue(this);
        } else {
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

    @Override
    public boolean involve(ArrayList<NumFluent> arrayList) {
        for (NumFluent f : arrayList) {
            if (f.equals(this)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Expression subst(Conditions numeric) {

        if (numeric == null) {
            return this;
        }
        if (numeric.sons.isEmpty()) {
            return this;
        }

        for (Object o : numeric.sons) {
            if (o instanceof NumEffect) {

                NumEffect as = (NumEffect) o;

                if (as.getFluentAffected().equals(this)) {
                    if (as.getOperator().equals("increase")) {
                        BinaryOp bin = new BinaryOp();
                        bin.setOperator("+");
                        bin.setOne(this);
                        bin.setRight(as.getRight());
                        return bin;
                    } else if (as.getOperator().equals("decrease")) {
                        BinaryOp bin = new BinaryOp();
                        bin.setOperator("-");
                        bin.setOne(this);
                        bin.setRight(as.getRight());
                        return bin;
                    } else if (as.getOperator().equals("assign")) {
                        return as.getRight();

                    } else {
                        System.err.println("Operation is not supported ( " + as.getOperator() + ")");
                    }
                }

            }

        }
        return this;
    }
}

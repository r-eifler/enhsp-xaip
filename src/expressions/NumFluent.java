/* 
 * Copyright (C) 2010-2017 Enrico Scala. Contact: enricos83@gmail.com.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package expressions;

import conditions.ComplexCondition;
import conditions.Condition;
import conditions.PDDLObject;
import domain.ActionParameter;
import domain.Variable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import problem.EPddlProblem;
import problem.PDDLObjects;
import problem.RelState;
import problem.State;
import problem.PddlProblem;

/**
 *
 * @author Enrico Scala
 */
public class NumFluent extends Expression {

    private String name;
    private ArrayList<ActionParameter> terms;
    private String beforeReformulation;
    private Boolean has_to_be_tracked;
    private String terms_as_string;
    Integer hash_code;
    public int index;
    public Integer id;
    private Integer actual_hash;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.terms);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        
        
        final NumFluent other = (NumFluent) obj;
        

        
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.terms, other.terms)) {
            return false;
        }
        return true;
    }

    

//    @Override
//    public int hashCode() {
//        int hash = 7;
//        //hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);
//        //hash = 53 * hash + (this.terms != null ? this.terms.hashCode() : 0);
//        return hash;
//    }
    public NumFluent(String name) {
        super();
        this.name = name;
        //variables = new ArrayList();
        terms = new ArrayList<>();

        this.beforeReformulation = null;
    }

    public void addVariable(Variable variable) {
        terms.add(variable);
    }

    @Override
    public String toString() {
        String ret = "";
        ret += "(" + this.name;
        for (Object o1 : this.getTerms()) {
            if (o1 instanceof PDDLObject) {
                PDDLObject obj = (PDDLObject) o1;
                ret = ret.concat(" " + obj.getName());
            } else {
                Variable obj = (Variable) o1;
                ret = ret.concat(" " + obj.getName() + obj.getType());

            }

        }
        ret = ret.concat(")");
        return ret;
    }

    @Override
    public NumFluent ground(Map<Variable, PDDLObject> substitution, PDDLObjects po) {
        NumFluent ret = new NumFluent(getName());
        ret.index = this.index;
        for (final ActionParameter param : terms) {
            ret.addTerms(param.ground(substitution));
        }
        ret.grounded = true;
        terms_as_string = this.terms.toString();
        return ret;
    }

    @Override
    public Expression unGround(Map substitution) {
        NumFluent ret = new NumFluent(getName());
        ret.index = this.index;
        for (Object o : terms) {
            if (o instanceof PDDLObject) {
                PDDLObject obj = (PDDLObject) o;
                Variable t = (Variable) substitution.get(obj.getName());
                if (t == null) {
                    System.out.println("Substitution Failed for " + o.toString());
                    System.exit(-1);
                } else {
                    ret.addVariable(t);
                }
            } else {
                ret.addVariable((Variable) o);
            }
        }
        ret.grounded = false;
        return ret;
    }

    /**
     * @return the terms
     */
    public ArrayList<ActionParameter> getTerms() {
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

//    public void setName(String name) {
//        this.name = name;
//    }
    @Override
    public PDDLNumber eval(State s) {
        if (s == null) {
            System.out.println("stato nullo!!");
        }
        return s.fluentValue(this);
    }

    @Override
    public Interval eval(RelState s) {
        Interval ret = new Interval();
        ret.setInf(s.functionInfValue(this));
        ret.setSup(s.functionSupValue(this));
        if (ret.getInf() == null) {
            ret.is_not_a_number = true;

            return ret;
        }

        return ret;
    }

    @Override
    public ExtendedNormExpression normalize() {
        ExtendedAddendum a = new ExtendedAddendum();
        a.n = new PDDLNumber(1);
        a.f = this;
        ExtendedNormExpression ret = new ExtendedNormExpression();
        ret.summations.add(a);
        return ret;

    }

    @Override
    public void changeVar(Map<Variable, PDDLObject> substitution) {
        final ArrayList<ActionParameter> newVar = new ArrayList();

        for (final ActionParameter o : terms) {
            final PDDLObject sub = o.ground(substitution);
            newVar.add(sub);
        }

        terms = newVar;
    }

    @Override
    public Expression weakEval(PddlProblem problem, HashMap invF) {

        if (this.name.equals("#t")) {
            //return this;
            return problem.getNumFluentInitialValue(this);
        }

        if ((invF.get(this) == null)) {//this means that the fluent cannot be in principle assigned
            PDDLNumber o = problem.getNumFluentInitialValue(this);
            if (o == null && this.freeVarSemantic) {
                return this;
            }
            return problem.getNumFluentInitialValue(this);
        }else{
            if (!(Boolean) invF.get(this)) {
                return this;
            }else{
                return  problem.getNumFluentInitialValue(this);
            }
        }
    }

    @Override
    public Expression clone() {
        return this;
    }

    @Override
    public boolean involve(HashMap<NumFluent, Boolean> map) {
        return map.get(this) != null;
    }

    @Override
    public boolean involve(NumFluent nf) {
        return nf.equals(this);
    }

    @Override
    public Expression subst(Condition input) {

        if (input == null) {
            return this;
        }
        if (!(input instanceof ComplexCondition))
            return this;
        
        ComplexCondition numeric = (ComplexCondition)input;

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

    @Override
    public Set rhsFluents() {
        Set ret = new HashSet();
        ret.add(this);
        return ret;
    }

    @Override
    public boolean isUngroundVersionOf(Expression expr) {
        if (expr instanceof NumFluent) {
            NumFluent nf = (NumFluent) expr;
            if (this.getName().equals(nf.getName())) {
                if (this.getTerms().size() == nf.getTerms().size()) {
                    for (int i = 0; i < this.getTerms().size(); i++) {
                        Variable v = (Variable) this.getTerms().get(i);
                        PDDLObject obj = (PDDLObject) nf.getTerms().get(i);
                        if (!v.getType().equals(obj.getType())) {
                            if (!v.getType().isAncestorOf(obj.getType())) {
                                return false;
                            }
                        }

                    }
                    return true;
                }

            }

        }

        return false;
    }

    @Override
    public Expression susbtFluentsWithTheirInvariants(int j) {
        NumFluent ret = new NumFluent(this.name + j);
        ret.index = this.index;
        ret.setTerms(terms);
        ret.grounded = false;
        return ret;
    }

    @Override
    public Expression susbtFluentsWithTheirInvariants(HashMap<Object, Boolean> invariantFluent, int j) {

        if (invariantFluent.get(this) != null) {
            NumFluent ret = new NumFluent(this.name + j);
            ret.index = this.index;
            ret.setTerms(terms);
            ret.grounded = false;
            ret.setBeforeReformulation(this.pddlPrint(true));
            return ret;
        } else {
            this.setBeforeReformulation("same");
            return this;
        }
    }

    /**
     * @return the beforeReformulation
     */
    public String getBeforeReformulation() {
        return beforeReformulation;
    }

    /**
     * @param beforeReformulation the beforeReformulation to set
     */
    public void setBeforeReformulation(String beforeReformulation) {
        this.beforeReformulation = beforeReformulation;
    }

    @Override
    public String toSmtVariableString(int i) {
        String ret = "";
        ret = ret.concat(this.getName());
        for (Object o1 : this.getTerms()) {
            if (o1 instanceof PDDLObject) {
                PDDLObject obj = (PDDLObject) o1;
                ret = ret.concat(" " + obj.getName());
            } else {
                Variable obj = (Variable) o1;
                ret = ret.concat(" " + obj.getName());

            }

        }
        ret += "-" + i;
        //ret = ret.concat(")");
        return ret.replaceAll("\\s+", "");
    }

    public boolean has_to_be_tracked() {
        if (has_to_be_tracked == null) {
            if (this.getName().equals("total-cost")) {
                setHas_to_be_tracked(Boolean.FALSE);
            } else {
                setHas_to_be_tracked(Boolean.TRUE);
            }
        }
        return has_to_be_tracked;
    }

    @Override
    public void pddlPrint(boolean typeInformation, StringBuilder bui) {
        bui.append("  (");
        bui.append(this.name);
        for (Object o1 : this.getTerms()) {
            if (o1 instanceof PDDLObject) {
                PDDLObject obj = (PDDLObject) o1;
                bui.append(" ");
                bui.append(obj.getName());
            } else {
                Variable obj = (Variable) o1;
                bui.append(" ");
                bui.append(obj.getName());
                if (typeInformation) {
                    bui.append(obj.getType());
                }
            }
        }
        bui.append(")");
    }

    private String getTermsAsString() {
        if (terms_as_string == null) {
            terms_as_string = this.terms.toString(); //To change body of generated methods, choose Tools | Templates.
        }
        return terms_as_string;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param has_to_be_tracked the has_to_be_tracked to set
     */
    public void setHas_to_be_tracked(Boolean has_to_be_tracked) {
        this.has_to_be_tracked = has_to_be_tracked;
    }

    @Override
    public Expression unifyVariablesReferences(EPddlProblem problem) {
        NumFluent nf = problem.getNumfluentReference(this.toString());
        if (nf == null){
            problem.setNumFluentReference(this);
            return this;
        }
        return nf;

    }
}

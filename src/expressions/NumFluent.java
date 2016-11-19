/**
 * *******************************************************************
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 *
 ********************************************************************
 */
/**
 * *******************************************************************
 * Description: Part of the PPMaJaL library
 *
 * Author: Enrico Scala 2013 Contact: enricos83@gmail.com
 *
 ********************************************************************
 */
package expressions;

import conditions.Conditions;
import conditions.PDDLObject;
import domain.Variable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import problem.RelState;
import problem.State;

/**
 *
 * @author Enrico Scala
 */
public class NumFluent extends Expression {

    final private String name;
    private ArrayList terms;
    private String beforeReformulation;
    private Boolean has_to_be_tracked;

    @Override
    public boolean equals(Object obj) {
        NumFluent objF = (NumFluent) obj;

        if (objF.getName().equalsIgnoreCase(this.getName())) {
            if (objF.terms.size() == this.terms.size()) {
                for (int i = 0; i < objF.terms.size(); i++) {
                    if (objF.terms.get(i) instanceof PDDLObject) {
                        PDDLObject ogg = (PDDLObject) objF.terms.get(i);
                        PDDLObject ogg2 = (PDDLObject) this.terms.get(i);
                        if (!(ogg.equals(ogg2))) {
                            return false;
                        }
                    } else if (objF.terms.get(i) instanceof Variable) {
                        Variable ogg = (Variable) objF.terms.get(i);
                        Variable ogg2 = (Variable) this.terms.get(i);
                        if (!(ogg.equals(ogg2))) {
                            return false;
                        }
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

    @Override
    public Expression unGround(Map substitution) {
        NumFluent ret = new NumFluent(getName());

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
//    public void setName(String name) {
//        this.name = name;
//    }

    @Override
    public PDDLNumber eval(State s) {
        if (s == null) {
            System.out.println("stato nullo!!");
        }
        return s.functionValue(this);
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
    public String pddlPrint(boolean typeInformation) {
        String ret = "";
        ret += "  (" + this.name;
        for (Object o1 : this.getTerms()) {
            if (o1 instanceof PDDLObject) {
                PDDLObject obj = (PDDLObject) o1;
                ret = ret.concat(" " + obj.getName());
            } else {
                Variable obj = (Variable) o1;
                if (typeInformation) {
                    ret = ret.concat(" " + obj.getName() + obj.getType());
                } else {
                    ret = ret.concat(" " + obj.getName());
                }

            }
        }
        ret = ret.concat(")");
        return ret;

    }

    @Override
    public Expression weakEval(State s, HashMap invF) {
        
        if (this.name.equals("#t")){
            //return this;
            return s.functionValue(this);
        }
        
        if ((invF.get(this) == null) ){//this means that the fluent can be in principle assigned
            return s.functionValue(this);
        }
        if (invF.get(this)!= null){
            if ((Boolean)invF.get(this)){
                if (invF.get(this.getName()) == null)
                    return s.functionValue(this);
                if ((Boolean)invF.get(this.getName()))
                    return s.functionValue(this);
                else
                    return this;
            }else
                return this;
        }
        if (invF.get(this.getName())!= null){
            if ((Boolean)invF.get(this.getName()))
               return s.functionValue(this);
            else
               return this;
        }
        return this;
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
    public boolean involve(HashMap<NumFluent,Boolean> map) {
        return map.get(this)!=null;
    }
    
    @Override
    public boolean involve(NumFluent nf) {
        return nf.equals(this);
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

    @Override
    public Set fluentsInvolved() {
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
        ret.setTerms(terms);
        ret.grounded = false;
        return ret;
    }

    @Override
    public Expression susbtFluentsWithTheirInvariants(HashMap<Object, Boolean> invariantFluent, int j) {
        
        
 
       
        if (invariantFluent.get(this) != null) {
            NumFluent ret = new NumFluent(this.name + j);
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
            if (o1 instanceof PDDLObject){
                PDDLObject obj = (PDDLObject) o1;
                ret = ret.concat(" " + obj.getName());
            }else{
                Variable obj = (Variable) o1;
                ret = ret.concat(" " + obj.getName());
                
            }
            
        }
        ret+="-"+i;
        //ret = ret.concat(")");
        return ret.replaceAll("\\s+","");
    }

    public boolean has_to_be_tracked() {
        if (has_to_be_tracked == null){
            if (this.getName().equals("total-cost"))
                has_to_be_tracked = Boolean.FALSE;
            else
                has_to_be_tracked = Boolean.TRUE;
        }
        return has_to_be_tracked;
    }
}

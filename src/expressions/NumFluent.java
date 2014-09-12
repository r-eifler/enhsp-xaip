/*********************************************************************
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 * 
 *********************************************************************/

/*********************************************************************
 * Description: Part of the PPMaJaL library
 *             
 * Author: Enrico Scala 2013
 * Contact: enricos83@gmail.com
 *
 *********************************************************************/ 

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
                    PDDLObject ogg = (PDDLObject)objF.terms.get(i);
                    PDDLObject ogg2 = (PDDLObject)this.terms.get(i);
                    if (!(ogg.equals(ogg2))) {
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
        String ret = "";
        ret +="  (" + this.name;
        for (Object o1 : this.getTerms()) {
            if (o1 instanceof PDDLObject){
                PDDLObject obj = (PDDLObject) o1;
                ret = ret.concat(" " + obj.getName());
            }else{
                Variable obj = (Variable) o1;
                ret = ret.concat(" " + obj.getName()+obj.getType());
                
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
    public String pddlPrint(boolean typeInformation) {
        String ret = "";
        ret +="  (" + this.name;
        for (Object o1 : this.getTerms()) {
            if (o1 instanceof PDDLObject){
                PDDLObject obj = (PDDLObject) o1;
                ret = ret.concat(" " + obj.getName());
            }else{
                Variable obj = (Variable) o1;
                if (typeInformation)
                    ret = ret.concat(" " + obj.getName()+obj.getType());
                else
                    ret = ret.concat(" " + obj.getName());
            
            }  
        }
        ret = ret.concat(")");
        return ret;

    }

    @Override
    public Expression weakEval(State s, HashMap invF) {

        if (invF.get(this)==null)
            return null;
        if ((Boolean) invF.get(this)) {
            //s.functionValue(this)
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

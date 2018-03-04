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
package conditions;

import domain.Variable;
import expressions.NumFluent;
import heuristics.utils.AchieverSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import problem.EPddlProblem;
import problem.GroundAction;
import problem.PDDLObjects;
import problem.RelState;
import problem.PDDLState;
import problem.PddlProblem;

/**
 *
 * @author enrico
 */
public class Predicate extends Terminal implements PostCondition {

    private String predicateName;
    private ArrayList terms; // seems to be a list of variables and/or PDDLObjects
    public HashSet son;
    public Integer hash_code;
    public Integer id;

    @Override
    public String pddlPrintWithExtraObject() {
        String ret = "";
        ret = ret.concat("  (" + this.getPredicateName());
        for (Object o1 : this.getTerms()) {
            if (o1 instanceof PDDLObject) {
                PDDLObject obj = (PDDLObject) o1;
                ret = ret.concat(" " + obj.getName());
            } else {
                Variable obj = (Variable) o1;
                ret = ret.concat(" " + obj.getName());

            }

        }
        ret = ret.concat(" ?interpr)");
        return ret;
    }

    public String pddlPrintWithTypedExtraObject() {
        String ret = "";
        ret = ret.concat("  (" + this.getPredicateName());
        for (Object o1 : this.getTerms()) {
            if (o1 == null) {
                System.out.println("There is some problem here with predicate:" + this);
            }
            if (o1 instanceof PDDLObject) {
                PDDLObject obj = (PDDLObject) o1;
                ret = ret.concat(" " + obj.getName());
            } else {
                Variable obj = (Variable) o1;
//                System.out.println("DEBUG: obj"+obj+"In the context:"+this);
                ret = ret.concat(" " + obj.getName() + obj.getType());

            }

        }
        ret = ret.concat(" ?x)");
        return ret;
    }

    @Override
    public boolean can_be_false(RelState s) {
        if (this.isValid())
            return false;
        if (this.isUnsatisfiable())
            return true;
        
        Integer i = s.possBollValues.get(this.id);
        return (i == null) || (i == 0) || (i == 2);
    }

    @Override
    public Condition achieve(Predicate p) {
        if (this.equals(p)) {
            return new Predicate(Predicate.true_false.TRUE);
        }
        return null;
    }

    @Override
    public Condition delete(Predicate p) {
        return null;
    }

    @Override
    public Set<Condition> getTerminalConditions() {
        Set ret = new LinkedHashSet();
        ret.add(this);
        return ret;
    }

    @Override
    public Float estimate_cost(ArrayList<Float> cond_dist, boolean additive_h) {
        return cond_dist.get(this.getHeuristicId());
    }

    @Override
    public Set<NumFluent> affectedNumericFluents() {
        return new HashSet();
    }

    @Override
    public void extendTerms(Variable v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Predicate> getInvolvedPredicates() {
        LinkedHashSet ret = new LinkedHashSet();
        ret.add(this);
        return ret;
    }

    @Override
    public Condition unifyVariablesReferences(EPddlProblem p) {
        Predicate p1 = p.getPredicateReference(this.toString());
        if (p1 == null){
            p.setPredicateReference(this);
            return this;
        }
        return p1;
    }

    public enum true_false {
        TRUE, FALSE
    };

    public Predicate() {
        super();
        //variables = new ArrayList();
        terms = new ArrayList();
    }

    public Predicate(true_false input) {
        super();
        //variables = new ArrayList();
        if (input == true_false.TRUE) {
            this.setValid(true);
            this.predicateName = "TRUE";
        } else {
            this.setUnsatisfiable(true);
            this.predicateName = "FALSE";
        }
        terms = new ArrayList();

    }

    public Predicate(String name) {
        super();
        //variables = new ArrayList();
        this.predicateName = name;
        terms = new ArrayList();

    }

    public Predicate(boolean g) {

        super();
        grounded = g;
        //variables = new ArrayList();
        terms = new ArrayList();

    }

    public String getPredicateName() {
        return predicateName;
    }

//    //return a grounded copy of the Predicate
//    public Predicate ground(ArrayList terms_) {
//
//        Predicate ret_val = new Predicate(true);
//        ret_val.setPredicateName(predicateName);
//        int i = 0;
//        if (terms_.size() != getVariables().size()) {
//            return null;
//        }
//        for (Object o : terms_) {
//            PDDLObject t = (PDDLObject) o;
//            Variable v = (Variable) getVariables().get(i);
//            if (!t.getType().equals(v.getType())) {
//                return null;
//            }
//        }
//        ret_val.setTerms(terms_);
//        return ret_val;
//    }
    /**
     * @param predicateName the predicateName to set
     */
    public void setPredicateName(String predicateName) {
        this.predicateName = predicateName;
    }

    /**
     * Adding a variable term to the predicate
     *
     * @param v the variable to add.
     */
    public void addVariable(Variable v) {
////        if (isGrounded()) {
////            System.out.println("Predicate grounded; no variable is possible");
//        } else {
        getTerms().add(v);
//        }
    }

    public void addObject(PDDLObject t) {
//        if (!isGrounded()) {
//            System.out.println("Predicate not grounded; no term is possible");
//        } else {
        getTerms().add(t);
//        }
    }

    @Override
    public String toString() {
        String ret_val = "(" + this.predicateName + " ";

        ret_val = ret_val.concat(getTerms().toString());

        ret_val = ret_val.concat(") ");
        return ret_val;
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

    /**
     * @return the grounded
     */
    public boolean isGrounded() {
        return grounded;
    }

    /**
     * @param grounded the grounded to set
     */
    public void setGrounded(boolean grounded) {
        this.grounded = grounded;
    }

    @Override
    public Condition ground(Map<Variable, PDDLObject> substitution, PDDLObjects po) {
        Predicate ret = new Predicate(true);
        ret.setPredicateName(predicateName);
        ret.grounded = true;

        //System.out.println(this);
        for (Object o : terms) {
            if (o instanceof Variable) {
                final Variable v = (Variable) o;
                PDDLObject t = substitution.get(v);
                if (t == null) {
                    System.out.println("Error in substitution  for " + o);
                    System.exit(-1);
                } else {
                    ret.terms.add(t);
                }
            } else {
                ret.terms.add(o);
            }
        }
        return ret;
    }

    @Override
    public Condition ground(Map substitution, int c) {
        Condition ret = this.ground(substitution, null);
        ret.setHeuristicId(c);
        return ret;
    }

    @Override
    public boolean eval(PDDLState s) {
        return s.holds(this);
    }

    @Override
    public boolean isSatisfied(PDDLState s) {
        if (isValid()) {
            return true;
        }
        if (isUnsatisfiable()) {
            return false;
        }
        return s.holds(this);
    }

    @Override
    public boolean can_be_true(RelState s) {
        if (this.isValid())
            return true;
        if (this.isUnsatisfiable())
            return false;
        Integer i = s.possBollValues.get(this.id);
        if (i == null) {
            return false;
        }
        if (i>=1)
            return true;
        return false;           
        //return (i == 1) || (i == 2);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.predicateName);
        hash = 29 * hash + Objects.hashCode(this.terms);
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
        final Predicate other = (Predicate) obj;
        if (!Objects.equals(this.predicateName, other.predicateName)) {
            return false;
        }
        if (!Objects.equals(this.terms, other.terms)) {
            return false;
        }
        return true;
    }



//    /**
//     *
//     * @param obj
//     * @return
//     */
//    @Override
//    public boolean equals(Object obj) {
//        Predicate objF = (Predicate) obj;
//        if (objF.getPredicateName().equalsIgnoreCase(this.getPredicateName())) {
//            if (objF.terms.size() == this.terms.size()) {
//                for (int i = 0; i < objF.terms.size(); i++) {
//                    if (!(objF.terms.get(i).equals(this.terms.get(i)))) {
//                        return false;
//                    }
//                }
//            } else {
//                return false;
//            }
//        } else {
//            return false;
//        }
//        return true;
//    }
   

    public PDDLState remove(PDDLState s) {
        s.setPropFluent(this,false);
        return s;
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
    public Condition clone() {
        return this;
    }

    public RelState make_positive(RelState s) {
        s.makePositive(this);
        return s;
    }

    RelState make_negative(RelState s) {
        s.makeNegative(this);
        return s;
    }

    @Override
    public void normalize() {
        return;
    }

    @Override
    public Condition unGround(Map substitution) {
        Predicate ret = new Predicate(true);
        ret.setPredicateName(predicateName);

        //System.out.println(this);
        for (Object o : this.getTerms()) {
            if (o instanceof PDDLObject) {
                PDDLObject obj = (PDDLObject) o;
                Variable t = (Variable) substitution.get(obj.getName());

                if (t == null) {
                    System.out.println("Error in substitution  for " + o);
                    System.exit(-1);
                } else {
                    ret.terms.add(t);
                }
            }
        }
        this.grounded = false;
        return ret;
    }

    @Override
    public boolean isUngroundVersionOf(Condition con) {
        if (con instanceof Predicate) {
            Predicate p = (Predicate) con;
            if (this.getPredicateName().equals(p.getPredicateName())) {
                if (this.getTerms().size() == p.getTerms().size()) {
                    for (int i = 0; i < this.getTerms().size(); i++) {
                        Variable v = (Variable) this.getTerms().get(i);
                        PDDLObject obj = (PDDLObject) p.getTerms().get(i);
                        //System.out.print("Matching Types between: "+ v.getType() + obj.getType());
                        if (!v.getType().equals(obj.getType())) {
                            if (!v.getType().isAncestorOf(obj.getType())) {
                                //System.out.println("Sottotipo di:"+obj.getType().getSubTypeOf());
                                //System.out.println(" FAILURE!!");
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
    public String toSmtVariableString(int i) {

        if (this.isValid()) {
            return "true";
        }
        if (this.isUnsatisfiable()) {
            return "false";
        }

        String ret = "";
        ret = ret.concat(this.getPredicateName());
        for (Object o1 : this.getTerms()) {
            if (o1 instanceof PDDLObject) {
                PDDLObject obj = (PDDLObject) o1;
                ret = ret.concat("" + obj.getName());
            } else {
                Variable obj = (Variable) o1;
                ret = ret.concat("" + obj.getName());

            }

        }
        ret += "-" + i;
        //ret = ret.concat(")");
//        System.out.println(ret);
//        System.out.println(ret.replaceAll("\\s+",""));
        return ret;
//        return ret.replaceAll("\\s+","");
    }

    @Override
    public Set<NumFluent> getInvolvedFluents() {
        return new HashSet();
    }

    @Override
    public Condition weakEval(PddlProblem problem, HashMap invF) {
        //if it is a static predicate (not invariant) and is satisfied in the init state,
        //then remove it in the upper level since it is valid for any state

        if (invF.get(this) == null) {//this means it is a static predicate
            if (problem.getInitBoolFluentValue(this)) {
                this.setValid(true);
                this.setUnsatisfiable(false);
            } else {
                this.setValid(false);
                this.setUnsatisfiable(true);
            }
            return this;
        } else {//this is meant to couple all the predicates in a unique representation
            return problem.getPredicate(this);
        }
    }

    @Override
    public String toSmtVariableString(int k, GroundAction gr, String var) {
        return " true ";
    }

    @Override
    public Condition transform_equality() {
        return this;
    }

    @Override
    public boolean is_affected_by(GroundAction gr) {
        return gr.achieve(this) || gr.delete(this);
    }

    @Override
    public Condition regress(GroundAction gr) {

        OrCond achievers = gr.getAdders(this);
        OrCond deleters = gr.getDels(this);
        OrCond or = new OrCond();
        AndCond effect_reasons = new AndCond();
        AndCond frame_axiom = new AndCond();
        NotCond no_del = new NotCond(deleters);

        effect_reasons.addConditions(achievers);
        effect_reasons.addConditions(no_del);
        frame_axiom.addConditions(no_del);
        frame_axiom.addConditions(this);
        or.addConditions(effect_reasons);
        or.addConditions(frame_axiom);
        return or;
    }

    public Condition regress_old(GroundAction gr) {
        PostCondition achiever = gr.getAdder(this);
        PostCondition destroyer = gr.getDeleter(this);
        if (destroyer != null && destroyer instanceof Predicate) {
            Condition con = new NotCond(null); // Maybe put a dummy here?
            con.setUnsatisfiable(true);
            return con;
        }
        if (destroyer == null) {
            if (achiever == null) {
                return this;
            }
            if (achiever instanceof Predicate) {
                AndCond cond = new AndCond();
                cond.setValid(true);
                return cond;
            }
            if (achiever instanceof ConditionalEffect) {
                ConditionalEffect c_eff = (ConditionalEffect) achiever;
                OrCond cond = new OrCond();
                cond.addConditions(c_eff.activation_condition);
                cond.addConditions(this);
                return cond;
            }
        } else {//destroyer is ConditionalEffect
            ConditionalEffect c_eff = (ConditionalEffect) destroyer;
            if (achiever == null) {
                NotCond not = new NotCond(c_eff.activation_condition);
                AndCond cond = new AndCond();
                cond.addConditions(this);
                cond.addConditions(not);
                return cond;
            }
            if (achiever instanceof Predicate) {
//                NotCond not = new NotCond(c_eff.activation_condition); // TODO: Verify whether ``not'' should be used?
                AndCond cond = new AndCond();
                cond.addConditions(this);
                return cond;
            }
            //achiever is a ConditionalEffect
            ConditionalEffect c_eff_ach = (ConditionalEffect) achiever;
            OrCond ret = new OrCond();
            NotCond not = new NotCond(c_eff.activation_condition);
            AndCond cond = new AndCond();
            cond.addConditions(this);
            cond.addConditions(not);
            ret.addConditions(cond);
            ret.addConditions(c_eff_ach.activation_condition);
            return ret;
        }
        return null;

    }

    @Override
    public HashMap apply(PDDLState s) {
        HashMap ret = new HashMap();
        apply(s, ret);
        return ret;
    }

    @Override
    public HashMap<Object, Object> apply(RelState s) {
        HashMap ret = new HashMap();
        apply(s, ret);
        return ret;
    }

    @Override
    public void apply(PDDLState s, Map modifications) {
        modifications.put(this, Boolean.TRUE);
    }

    @Override
    public void apply(RelState s, Map modifications) {
        Integer inter = s.possBollValues.get(this.id);
        if (inter == null || inter == 0) {
            modifications.put(this, 2);
        }
    }

    @Override
    public void pddlPrint(boolean typeInformation, StringBuilder bui) {
        bui.append(" (");
        bui.append(getPredicateName());
        for (Object o1 : this.getTerms()) {
            if (o1 instanceof PDDLObject) {
                PDDLObject obj = (PDDLObject) o1;
                bui.append(" ");
                bui.append(obj.getName()); // TODO: Why not obj.pddlPrint(typeInformation,bui) ? 
            } else {
                Variable obj = (Variable) o1;
                bui.append(" ");
                bui.append(obj.getName());
                if (typeInformation) {
                    bui.append(obj.getType()); // No space?
                }
            }
        }
        bui.append(")");
    }

    @Override
    public void storeInvolvedVariables(Collection<Variable> vars) {
        vars.addAll(this.terms);
    }

    @Override
    public ComplexCondition and(Condition precondition) {
        AndCond and = new AndCond();
        and.addConditions(precondition);
        and.addConditions(this);
        return and;
    }

    @Override
    public AchieverSet estimate_cost(ArrayList<Float> cond_dist, boolean additive_h, ArrayList<GroundAction> established_achiever) {
        AchieverSet s = new AchieverSet();
        s.cost = cond_dist.get(this.getHeuristicId());
        s.actions.add(established_achiever.get(this.getHeuristicId()));
        s.target_cond.add(this);
        return s;

    }

    @Override
    public Condition push_not_to_terminals() {
        return this;
    }

}

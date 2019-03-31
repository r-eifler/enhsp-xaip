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
package com.hstairs.ppmajal.conditions;

import com.hstairs.ppmajal.domain.ParametersAsTerms;
import com.hstairs.ppmajal.domain.SchemaParameters;
import com.hstairs.ppmajal.domain.Variable;
import com.hstairs.ppmajal.expressions.NumEffect;
import com.hstairs.ppmajal.expressions.NumFluent;
import com.hstairs.ppmajal.heuristics.utils.AchieverSet;
import com.hstairs.ppmajal.problem.*;
import com.hstairs.ppmajal.propositionalFactory.Grounder;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author enrico
 */
public class ForAll extends ComplexCondition implements PostCondition {

    public SchemaParameters parameters;

    public ForAll ( ) {
        this.parameters = new SchemaParameters();
    }

    @Override
    public boolean equals (Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof ForAll)) {
            return false;
        }

        final ForAll other = (ForAll) obj;
        return other.sons.equals(this.sons) && this.parameters.equals(other.parameters);
    }

    @Override
    public int hashCode ( ) {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.parameters);
        hash = 83 * hash + Objects.hashCode(this.sons);
        return hash;
    }

    @Override
    public Condition regress (GroundAction gr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Condition ground (Map substitution, int c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString ( ) {
        return this.parameters + " " + this.sons.toString();
    }

    @Override
    public boolean eval (State s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toSmtVariableString (int k, GroundAction gr, String var) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isSatisfied (State s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public void changeVar (Map substitution) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public String pddlPrintWithExtraObject ( ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Condition clone ( ) {
        ForAll res = new ForAll();
        res.parameters = this.parameters;
        res.sons = this.sons.clone();
        return res;
    }

    @Override
    public boolean can_be_true (RelState aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean can_be_false (RelState aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Condition normalize ( ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Condition unGround (Map asbstractionOf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isUngroundVersionOf (Condition conditions) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toSmtVariableString (int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<NumFluent> getInvolvedFluents ( ) {
        Set<NumFluent> ret = new HashSet();
        if (this.sons != null) {
            for (Object o : this.sons) {
                if (o instanceof NumFluent) {
                    ret.add((NumFluent) o);
                } else if (o instanceof Condition) {
                    Condition c = (Condition) o;
                    if (c.getInvolvedFluents() != null) {
                        ret.addAll(c.getInvolvedFluents());
                    }
                } else if (o instanceof NumEffect) {
                    NumEffect c = (NumEffect) o;
                    if (c.getInvolvedFluents() != null) {
                        ret.addAll(c.getInvolvedFluents());
                    }
                } else {
                    System.out.println("Error in getting involved fluents");
                }
            }
        }

        return ret;
    }

    @Override
    public ComplexCondition transformEquality ( ) {

        ForAll res = new ForAll();
        res.parameters = parameters;
        HashSet<Condition> temp = new HashSet<>();
        for (Condition cond : (Collection<Condition>) sons) {
            temp.add(cond.transformEquality());
        }
        sons.addAll(temp);
        res.sons = sons;
        return res;
    }

    @Override
    public boolean is_affected_by (GroundAction gr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void storeInvolvedVariables (Collection<Variable> vars) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pddlPrint (boolean typeInformation, StringBuilder bui) {
        bui.append("(forall ");

        this.parameters.pddlPrint(true, bui);
        if (sons.size() > 1)
            bui.append("(and ");
        for (Object o : sons) {
            if (o instanceof Condition) {
                Condition c = (Condition) o;
                c.pddlPrint(typeInformation, bui);
//            } else if (o instanceof Comparison) { // ??? a Comparison is already a Conditions
//                Comparison comp = (Comparison) o;
//                ret_val = ret_val.concat(comp.pddlPrint(typeInformation));
            } else {
                System.out.println("Error in pddlPrint: " + this);
                System.exit(-1);
            }
        }
        if (sons.size() > 1)
            bui.append(")");
        bui.append(")");
    }

    @Override
    public Set<Condition> getTerminalConditions ( ) {
        Set<Condition> res = new LinkedHashSet();
        if (this.sons != null) {
            for (Object o : this.sons) {
                if (o instanceof Condition) {
                    Condition c = (Condition) o;
                    res.addAll(c.getTerminalConditions());
                }else {
                    System.out.println("Error in getting involved fluents");
                }
            }
        }
        return res;
    }

    @Override
    public Float estimate_cost (ArrayList<Float> cond_dist, boolean additive_h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ComplexCondition and (Condition precondition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AchieverSet estimate_cost (ArrayList<Float> cond_dist, boolean additive_h, ArrayList<GroundAction> established_achiever) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Condition push_not_to_terminals ( ) {
        if (this.sons == null) {
            return this;
        }
        ForAll res = new ForAll();
        res.parameters = this.parameters;
        for (Condition c : (Collection<Condition>) this.sons) {
            Condition c1 = c.push_not_to_terminals();
            if (c1 instanceof AndCond) {
                res.sons.addAll(((AndCond) c1).sons);
            } else {
                res.addConditions(c1);
            }
        }
        return res;
    }

    @Override
    public boolean isSatisfied (RelState rs, ArrayList<Integer> dist, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Condition introduce_red_constraints ( ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addParameter (Variable variable) {
        this.getParameters().add(variable);
    }

    /**
     * @return the parameters
     */
    public SchemaParameters getParameters ( ) {
        return parameters;
    }

    /**
     * @param parameters the parameters to set
     */
    public void setParameters (SchemaParameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public Condition ground (Map<Variable, PDDLObject> substitution, PDDLObjects objects) {


        if (objects == null) {//this is the case where I don't want to ground really
            ForAll res = new ForAll();
            res.parameters = this.parameters;
            for (Condition c : (Collection<Condition>) this.sons) {
                res.addConditions(c.ground(substitution, objects));
            }
            return res;
        }


        try {
            Grounder g = new Grounder();
            Set<ParametersAsTerms> combo = g.Substitutions(this.parameters, objects);
            AndCond and = new AndCond();
            for (ParametersAsTerms ele : combo) {
                Map sub = g.obtain_sub_from_instance(parameters, ele);
                sub.putAll(substitution);
//                 System.out.println(this);
//                Condition son = (Condition) this.sons.iterator().next();
//                and.addConditions(son.ground(sub, objects));
                for (Condition c : (Collection<Condition>) this.sons) {
                    and.addConditions(c.ground(sub, objects));
                }
            }

            return and;

        } catch (Exception ex) {
            Logger.getLogger(ForAll.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public Condition weakEval (PddlProblem s, HashMap invF) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void apply (State s, Map modifications) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void apply (RelState s, Map modifications) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<Object, Object> apply (PDDLState s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<Object, Object> apply (RelState s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Condition achieve (Predicate p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Condition delete (Predicate p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<NumFluent> affectedNumericFluents ( ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void extendTerms (Variable v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

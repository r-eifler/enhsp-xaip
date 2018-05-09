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

import domain.ActionParameter;
import domain.Type;
import domain.Variable;
import expressions.NumFluent;
import heuristics.utils.AchieverSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import problem.EPddlProblem;
import problem.GroundAction;
import problem.PDDLObjects;
import problem.RelState;
import problem.PddlProblem;
import problem.State;

/**
 *
 * @author enrico
 */
public class PDDLObject extends Terminal implements ActionParameter {

    private String name;
    private Type type;

    public PDDLObject(String name) {
        grounded = true;
        this.name = name;
    }

    public PDDLObject(String n, Type atype) {
        grounded = true;

        name = n;
        type = atype;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof PDDLObject) {
            PDDLObject o1 = (PDDLObject) o;
            return (o1.getName() == null ? this.getName() == null : o1.getName().equalsIgnoreCase(this.getName()));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.name != null ? this.name.hashCode() : 0);
        //hash = 29 * hash + (this.type != null ? this.type.hashCode() : 0);
        return hash;
    }

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        String ret_val = null;

        ret_val = getName() + " " + type;

        return ret_val;
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
    public PDDLObject ground(Map<Variable, PDDLObject> substitution, PDDLObjects po) {
        return new PDDLObject(name, type); // TODO: Why not return this?
    }

    @Override
    public Condition ground(Map substitution, int c) {
        Condition ret = this.ground(substitution, null);
        ret.setHeuristicId(c);
        return ret;
    }

    @Override
    public boolean eval(State s) {
        return true;
    }

    @Override
    public boolean isSatisfied(State s) {
        return true;
    }

    @Override
    public boolean can_be_true(RelState s) {
        return true;
    }

    @Override
    public void changeVar(Map substitution) {
        return;
    }

    @Override
    public Condition clone() {
//        PDDLObject ret = new PDDLObject(name,this.getType());
//        ret.grounded = this.grounded;
//        return ret;
        return this;
    }

    @Override
    public void normalize() {
        return;
    }

    @Override
    public Condition unGround(Map asbstractionOf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isUngroundVersionOf(Condition conditions) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toSmtVariableString(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<NumFluent> getInvolvedFluents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Condition weakEval(PddlProblem s, HashMap invF) {
        return this;
    }

    @Override
    public String toSmtVariableString(int k, GroundAction gr, String var) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Condition transform_equality() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean is_affected_by(GroundAction gr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Condition regress(GroundAction gr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String pddlPrintWithExtraObject() {
        return this.getName();
    }

    @Override
    public boolean can_be_false(RelState aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pddlPrint(boolean typeInformation, StringBuilder bui) {
        bui.append(getName());
        if (typeInformation) {
            bui.append(" ").append(getType());
        }
    }

    @Override
    public void storeInvolvedVariables(Collection<Variable> vars) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Condition> getTerminalConditions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Float estimate_cost(ArrayList<Float> cond_dist, boolean additive_h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ComplexCondition and(Condition precondition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AchieverSet estimate_cost(ArrayList<Float> cond_dist, boolean additive_h, ArrayList<GroundAction> established_achiever) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Condition push_not_to_terminals() {
        return this;
    }

    @Override
    public PDDLObject ground(Map<Variable, PDDLObject> substitution) {
        return new PDDLObject(name, type); // TODO: Why not return this?
    }

    @Override
    public void extendTerms(Variable v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Predicate> getInvolvedPredicates() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Condition unifyVariablesReferences(EPddlProblem p) {
        return this;
    }

}

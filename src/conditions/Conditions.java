/**
 * *******************************************************************
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
 ********************************************************************
 */
/**
 * *******************************************************************
 * Description: Part of the PPMaJaL library
 *
 * Author: Enrico Scala 2013
 * Contact: enricos83@gmail.com
 *
 ********************************************************************
 */
package conditions;

import domain.Variable;
import expressions.NumFluent;
import heuristics.utils.achiever_set;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import problem.GroundAction;
import problem.PDDLObjects;
import problem.RelState;
import problem.State;

/**
 *
 * @author enrico
 */
public abstract class Conditions extends Object {

    public boolean grounded;
    public LinkedHashSet sons; //used by formula conditions as AndCond and OrCond. Each son is another condition involved in the formula
    // TODO: Make a ConditionsWithSons class that sits between AndCond/OrCond/OneOf and Conditions
    protected boolean freeVarSemantic = false;
    private boolean unsatisfiable = false;
    private boolean valid = false;
    private int counter;

    public Conditions() {
        //son = new HashSet();
        grounded = false;
        unsatisfiable = false;
    }

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object obj);

    public abstract Conditions weakEval(State s, HashMap invF);
    //public abstract void addConditions(Conditions o);

    /*
        The following regression operation operates under the following assumptions:
            1) Action do not have conflicting effects. 
                a) Conditional effects will never conflict
                b) Add and Delete List will never conflict
            2) Any literals (positive or negative) caused by an action 
               takes part just in one of the conditional effects of the action.
               Add and Del list can be seen as conditional effects with empty
               activation conditions.
    
     */
    public abstract Conditions regress(GroundAction gr);

    /**
     * Substitutes the variables in this conditions with the PDDLObjects
     * associated to each variable in the specified table. The returned object
     * is therefore grounded. This method may fail if there is no substitution
     * for some variable.
     *
     * @param substitution the map that indicates what object should replace the
     * specified variable.
     * @param objects These are the objects of the problem
     * @return a copy of this conditions where each variable is replaced to the
     * object according to the specified mapping.
     */
    public abstract Conditions ground(Map<Variable, PDDLObject> substitution, PDDLObjects objects);

    public abstract Conditions ground(Map substitution, int c);

    public abstract boolean eval(State s);

    public abstract String toSmtVariableString(int k, GroundAction gr, String var);

    public abstract boolean isSatisfied(State s);

    public abstract void changeVar(Map substitution);

    public abstract String pddlPrintWithExtraObject();

    @Override
    public abstract Conditions clone();

    public abstract boolean can_be_true(RelState aThis);

    public abstract boolean can_be_false(RelState aThis);

    public abstract void normalize();

    public abstract Conditions unGround(Map asbstractionOf);

    public abstract boolean isUngroundVersionOf(Conditions conditions);

    public abstract String toSmtVariableString(int i);//just for and condition

    public abstract Set<NumFluent> getInvolvedFluents();

    /**
     * @return the freeVarSemantic
     */
    public boolean isFreeVarSemantic() {
        return freeVarSemantic;
    }

    /**
     * @param freeVarSemantic the freeVarSemantic to set
     */
    public void setFreeVarSemantic(boolean freeVarSemantic) {
        this.freeVarSemantic = freeVarSemantic;
    }

    /**
     * @return the unsatisfiable
     */
    public boolean isUnsatisfiable() {
        return unsatisfiable;
    }

    /**
     * @param unsatisfiable the unsatisfiable to set
     */
    public void setUnsatisfiable(boolean unsatisfiable) {
        this.unsatisfiable = unsatisfiable;
    }

    /**
     * @return the counter
     */
    public int getCounter() {
        return counter;
    }

    /**
     * @param counter the counter to set
     */
    public void setCounter(int counter) {
//        System.out.println(this+ "Setting counter to"+counter);
        this.counter = counter;
    }

    /**
     * @return the valid
     */
    public boolean isValid() {
        return valid;
    }

    /**
     * @param valid the valid to set
     */
    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public abstract Conditions transform_equality();

    public abstract boolean is_affected_by(GroundAction gr);

    public Collection<Predicate> getInvolvedPredicates() {
        Collection ret = new LinkedHashSet();
        if (this instanceof Predicate) {
            ret.add(this);
            return ret;
        } else if (this instanceof NotCond) {
            NotCond temp = (NotCond) this;
            if (temp.getSon() == null) {
                return ret;
            }
            Conditions temp2 = (Conditions) temp.getSon();
            ret.addAll(temp2.getInvolvedPredicates());
            return ret;
        }
        //from here it can only be an AndCond or a Or. Other cases are not considered
        if (this.sons != null) {
            for (Conditions c : (Collection<Conditions>) this.sons) {
                ret.addAll(c.getInvolvedPredicates());
            }
        }
        return ret;
    }

    /**
     * Returns the list of variables involved in this conditions.
     *
     * @return the list of variables in this conditions.
     */
    public final ArrayList<Variable> getInvolvedVariables() {
        // TODO: not sure whether the result should be a list or a set.
        final ArrayList<Variable> result = new ArrayList<>();
        storeInvolvedVariables(result);
        return result;
    }

    /**
     * Stores in the specified collection the list of variables involved in this
     * conditions.
     *
     * @param vars the list where the variables involved in this condition are
     * to be stored.
     */
    public abstract void storeInvolvedVariables(Collection<Variable> vars);

    /**
     * Returns a string representation of this condition in PDDL format.
     *
     * @param typeInformation <tt>true</tt>
     * if the type of the object should be printed as well.
     * @return a string representation in PDDL format of this condition.
     */
    public final String pddlPrint(boolean typeInformation) {
        final StringBuilder bui = new StringBuilder();
        pddlPrint(typeInformation, bui);
        return bui.toString();
    }

    /**
     * Prints this condition in PDDL format in the specified string builder.
     *
     * @param typeInformation <tt>true</tt>
     * if the type of the object should be printed as well.
     * @param bui the string builder where this condition is printed.
     */
    public abstract void pddlPrint(boolean typeInformation, StringBuilder bui);

    public abstract Set<Conditions> getTerminalConditions();

    public abstract Float estimate_cost(ArrayList<Float> cond_dist, boolean additive_h);

    public abstract Conditions and(Conditions precondition);

    public abstract achiever_set estimate_cost(ArrayList<Float> cond_dist, boolean additive_h, ArrayList<GroundAction> established_achiever);

    public abstract Conditions push_not_to_terminals();

    public boolean isSatisfied(RelState rs) {
        return rs.satisfy(this);
    }

    public abstract boolean isSatisfied(RelState rs, ArrayList<Integer> dist, int i);

//    public abstract Conditionss unify_num_fluent(State init);
    public abstract Conditions introduce_red_constraints();

    public boolean mutual_exclusion_guaranteed(Conditions preconditions) {
        if (preconditions instanceof AndCond && this instanceof AndCond) {
            AndCond a = (AndCond) preconditions;
            AndCond b = (AndCond) this;
            ArrayList<Conditions> c1 = new ArrayList(a.getTerminalConditions());
            ArrayList<Conditions> c2 = new ArrayList(b.getTerminalConditions());
            for (int i = 0; i < c1.size(); i++) {
                for (int j = i + 1; j < c2.size(); j++) {
                    Conditions a_1 = c1.get(i);
                    Conditions a_2 = c2.get(j);
                    if (a_1 instanceof NotCond && a_2 instanceof Predicate) {
                        NotCond nc = (NotCond) a_1;
                        if (nc.getSon().equals(a_2)) {
                            return true;
                        }
                    } else if (a_2 instanceof NotCond && a_1 instanceof Predicate) {
                        NotCond nc = (NotCond) a_2;
                        if (nc.getSon().equals(a_1)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void addConditions(Conditions c) {
        sons.add(c);
    }

}

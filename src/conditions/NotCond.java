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

import conditions.Predicate.true_false;
import domain.Variable;
import expressions.NumFluent;
import heuristics.utils.achiever_set;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import problem.GroundAction;
import problem.PDDLObjects;
import problem.RelState;
import problem.State;

/**
 *
 * @author enrico
 */
public class NotCond extends Terminal implements PostCondition {
    
    /**
     * The condition that is negated in this condition.  
     */
    private final Conditions son;

    public NotCond(Conditions son) {
        super();
        this.son = son;
    }
    
    public Conditions getSon(){
        return son;
    }
    
    @Override
    public String toString() {
        String ret_val = "Not(";
        
        ret_val = ret_val.concat(son.toString());
        
        ret_val = ret_val.concat(")");
        
        return ret_val;
    }
    
    @Override
    public Conditions ground(Map<Variable,PDDLObject> substitution,PDDLObjects po) {
        final Conditions groundedSon = son.ground(substitution,po);
        NotCond ret = new NotCond(groundedSon);
        ret.grounded = true;
        return ret;
    }
    
    @Override
    public Conditions ground(Map substitution, int c) {
        Conditions ret = this.ground(substitution,null);
        ret.setCounter(c);
        return ret;
    }

    //ECCO LA CLOSED WORLD ASSUMPTION---->>>>E ORA!?
    //Assumiamo che non lo stato le cose che non ci sono sono considerate negate. Questo prevede che la lettura dello stato iniziale ELIMINI tutte le cose negative.....
    @Override
    public boolean eval(State s) {
        
        return !son.eval(s);
        
    }
    
    @Override
    public boolean isSatisfied(State s) {
        
        return !son.isSatisfied(s);
        
    }
    
    @Override
    public boolean can_be_true(RelState s) {
        
        return son.can_be_false(s);
        
    }
    
    @Override
    public void normalize() {
        if (son instanceof Comparison) {
            Comparison comp = (Comparison) son;
            try {
                comp.normalize();
            } catch (Exception ex) {
                Logger.getLogger(NotCond.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Conditions c = (Conditions) son;
            c.normalize();
        }
        
    }
    
    @Override
    public void changeVar(Map substitution) {
        son.changeVar(substitution);
    }
    
    @Override
    public Conditions clone() {
        final Conditions clonedSon = this.son.clone();
        NotCond ret = new NotCond(clonedSon);
        ret.grounded = this.grounded;
        return ret;
    }
    
    @Override
    public boolean isUngroundVersionOf(Conditions con) {
        if (con instanceof NotCond) {
            NotCond nc = (NotCond) con;
            Conditions c1 = (Conditions) this.son;
            Conditions c2 = (Conditions) nc.son;
            if (c1.isUngroundVersionOf(c2)) {
                return true;
            }
            
        }
        return false;
    }
    
    @Override
    public Conditions unGround(Map substitution) {
        final Conditions ungroundSon = son.unGround(substitution);
        NotCond ret = new NotCond(ungroundSon);
        ret.grounded = false;
        return ret;
    }
    
    @Override
    public String toSmtVariableString(int i) {
        return "(not " + son.toSmtVariableString(i) + ")";
    }
    
    @Override
    public Set<NumFluent> getInvolvedFluents() {
        Set<NumFluent> ret = new HashSet();
        
        if (son instanceof Conditions) {
            Conditions c = (Conditions) son;
            if (c.getInvolvedFluents() != null) {
                ret.addAll(c.getInvolvedFluents());
            }
        } else {
            System.out.println("Error in getting involved fluents");
        }
        
        return ret;
    }
    
    @Override
    public Conditions weakEval(State s, HashMap invF) {
        Map<Conditions, Boolean> toRemove = new HashMap();
        
        Conditions el = (Conditions) son;
        el.setFreeVarSemantic(freeVarSemantic);
        el = el.weakEval(s, invF);
        if (el == null) {
            this.setValid(true);
            this.setUnsatisfiable(false);
        } else if (el.isValid()) {
            this.setUnsatisfiable(true);
            this.setValid(false);
        } else if (el.isUnsatisfiable()) {
            this.setValid(true);
            this.setUnsatisfiable(false);
            
        }
        
        return this;
    }
    
    @Override
    public String toSmtVariableString(int i, GroundAction gr, String var) {
        return "(not " + son.toSmtVariableString(i, gr, var) + ")";
    }
    
    @Override
    public Conditions transform_equality() {
        if (this.son == null) {
            return this;
        }
        final Conditions transformedSon = son.transform_equality();
        NotCond ret = new NotCond(transformedSon);
        //System.out.println(ret);
        return ret;
    }
    
    @Override
    public boolean is_affected_by(GroundAction gr) {
        
        if (son.is_affected_by(gr)) {
            return true;
        }
        
        return false;
    }
    
    @Override
    public Conditions regress(GroundAction gr) {
        
        Conditions temp = son.regress(gr);
        if (temp.isValid()) {
//            NotCond ret = new NotCond();
//            ret.setUnsatisfiable(true);
            return new Predicate(true_false.FALSE);
        }
        if (temp.isUnsatisfiable()) {
            return new Predicate(true_false.TRUE);
        }
        NotCond not = new NotCond(temp);
        
        return not;
    }
    
    @Override
    public String pddlPrintWithExtraObject() {
        String ret_val = "(not ";
            if (son instanceof Conditions) {
                Conditions c = (Conditions) son;
                ret_val = ret_val.concat(c.pddlPrintWithExtraObject());
            } else {
                System.out.println("Error in pddlPrint:" + this);
                System.exit(-1);
            }
        ret_val = ret_val.concat(")");
        return ret_val;
    }
    
    @Override
    public boolean can_be_false(RelState s) {
        return son.can_be_true(s);
    }
    
    @Override
    public Conditions achieve(Predicate p) {
        return null;
    }
    
    @Override
    public Conditions delete(Predicate p) {
        if (son.equals(p)) {
            return new Predicate(Predicate.true_false.TRUE);
        }
        return null;
    }
    
    @Override
    public int hashCode() {
        if (son == null) { // sometimes happen when the negation is trivially unsatisfiable
            return 1;
        }
        
        final int sonHash = son.hashCode();
        final int result = sonHash + 11;
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null) {
            return false;
        }
        
        if (!(obj instanceof NotCond)) {
            return false;
        }
        
        final NotCond other = (NotCond) obj;
        
        if (!this.son.equals(other.son)) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public HashMap apply(State s) {
        HashMap ret = new HashMap();
        apply(s,ret);
        return ret;
    }
    
    @Override
    public HashMap apply(RelState s) {
        HashMap ret = new HashMap();
        apply(s, ret);
        return ret;
        
    }
    
    @Override
    public void apply(State s, Map modifications) {
        if (son instanceof Predicate) {
            Predicate p = (Predicate) son;
            modifications.put(p, Boolean.FALSE);
        } else {
            sonHasIncorrectType();
        }
    }
    
    @Override
    public void apply(RelState s, Map modifications) {
        if (son instanceof Predicate) {
            Predicate p = (Predicate) son;
            if (s.poss_interpretation.get(p) != null) {
                if (s.poss_interpretation.get(p) == 1) {
                    modifications.put(p, 2);
                }
            }
            
        } else {
            sonHasIncorrectType();
        }
    }
    
    private void sonHasIncorrectType() {
        System.out.println("Not " + son + " is not valid. Please revise your action model");
        System.exit(-1);
    }
    
    @Override
    public void pddlPrint(boolean typeInformation, StringBuilder bui) {
        bui.append("(not ");
        son.pddlPrint(typeInformation,bui);
        bui.append(")");
    }
    
    @Override
    public void storeInvolvedVariables(Collection<Variable> vars) {
        for (NumFluent nf : this.getInvolvedFluents()) {
            for (final Object o: nf.getTerms()) {
                final Variable var = (Variable)o;
                vars.add(var);
            }
        }
        for (Predicate p : this.getInvolvedPredicates()) {
            for (final Object o: p.getTerms()) {
                final Variable var = (Variable)o;
                vars.add(var);
            }
        }
    }

    @Override
    public Set<Conditions> getTerminalConditions() {
        if (!this.isTerminal()){
            System.out.println("This should be a terminal!"+this);
            System.exit(-1);
        }
        LinkedHashSet ret = new LinkedHashSet();
        ret.add(this);
        return ret;
    }

    @Override
    public Float estimate_cost(ArrayList<Float> cond_dist, boolean additive_h) {
        return cond_dist.get(this.getCounter());
    }
    @Override
    public Conditions and(Conditions precondition) {
        AndCond and = new AndCond();
        and.addConditions(precondition);
        and.addConditions(this);
        return and;
    }

    @Override
    public achiever_set estimate_cost(ArrayList<Float> cond_dist, boolean additive_h, ArrayList<GroundAction> established_achiever) {
        achiever_set s = new achiever_set();
        s.cost = cond_dist.get(this.getCounter());
        s.actions.add(established_achiever.get(this.getCounter()));
        s.target_cond.add(this);
        return s;
    }
    
    @Override
    public Conditions push_not_to_terminals() {
        if (son instanceof Predicate)
            return this;
        else if (son instanceof Comparison){
            Comparison c1 = (Comparison)son;
            Conditions c2 = c1.invertOperator();
            return c2;
        }
        else if (son instanceof AndCond){
            AndCond and = (AndCond)son;
            OrCond or = and.push_negation_demorgan();
            Conditions c=or.push_not_to_terminals();
            return c;
        }
        else if (son instanceof OrCond){
            OrCond or = (OrCond)son;
            AndCond and = or.push_negation_demorgan();
            Conditions c=and.push_not_to_terminals();
            return c;
        }else if (son instanceof PDDLObjectsEquality){
            return this;
        }
        else if (son instanceof NotCond){
            NotCond nc = (NotCond)son;
//            System.out.println("Pushing of the not:"+nc.son.push_not_to_terminals());
            return nc.son.push_not_to_terminals();
        }else{
            System.out.println("Condition "+son.getClass()+" not supported");
            System.exit(-1);
        }
        return null;
    }

    public boolean isTerminal() {
        if (this.son instanceof Predicate)
            return true;
        return false;
    }

    @Override
    public Set<NumFluent> affectedNumericFluents() {
        return new HashSet();
    }


    
    
}

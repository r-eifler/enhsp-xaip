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
package conditions;

import domain.Variable;
import expressions.NumEffect;
import expressions.Expression;
import expressions.NumFluent;
import heuristics.advanced.achiever_set;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import problem.GroundAction;
import problem.RelState;
import problem.State;

/**
 *
 * @author Enrico Scala
 */
public class AndCond extends Conditions implements PostCondition {

    private boolean specialAndForExpression;

    /**
     * Standard Constructor for the AndCond.
     */
    public AndCond() {
        super();
        sons = new LinkedHashSet();
    }

    /**
     *
     * @param c a condition to be added
     */
    public void addConditions(Conditions c) {
        sons.add(c);

    }

    /**
     *
     * @return a string representation of the and tree
     */
    @Override
    public String toString() {
        String ret_val = "And(";
        for (Object o : sons) {
            ret_val = ret_val.concat(o.toString());
        }
        ret_val = ret_val.concat(")");
        return ret_val;
    }

    @Override
    public Conditions ground(Map<Variable,PDDLObject> substitution) {
        AndCond ret = new AndCond();

        //System.out.println(this.toString());
        for (Object o : sons) {
            final Object groundedO;
            if (o instanceof NumEffect) {
                NumEffect el = (NumEffect) o;
                groundedO = el.ground(substitution);

            } else {
                Conditions el = (Conditions) o;
                //System.out.println(el);
                groundedO = el.ground(substitution);
            }
            ret.sons.add(groundedO);
        }
        
        ret.grounded = true;
        return ret;
    }

    /**
     *
     * @param s
     * @return
     */
    @Override
    public boolean eval(State s) {
        for (Object o : this.sons) {
            if (o instanceof Conditions) {
                Conditions c = (Conditions) o;
                if (!c.eval(s)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @return the specialAndForExpression
     */
    public boolean isSpecialAndForExpression() {
        return specialAndForExpression;
    }

    /**
     * @param specialAndForExpression the specialAndForExpression to set
     */
    public void setSpecialAndForExpression(boolean specialAndForExpression) {
        this.specialAndForExpression = specialAndForExpression;
    }

    /**
     *
     * @param e when used with numeric effect
     */
    public void addExpression(Expression e) {
        this.sons.add(e);
    }

    /**
     *
     * @param s
     * @return
     */
    @Override
    public boolean isSatisfied(State s) {
        for (Object o : this.sons) {
            if (o instanceof Conditions) {
                Conditions c = (Conditions) o;
                if (!c.isSatisfied(s)) {
                    //System.out.println(c.toString() + " is not satisfied in " + s);
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *
     * @param s
     * @return
     */
    @Override
    public boolean can_be_true(RelState s) {
        for (Object o : this.sons) {
            if (o instanceof Conditions) {
                Conditions c = (Conditions) o;
                if (!c.can_be_true(s)) {
                    //System.out.println(c.pddlPrint() + " is not satisfied in " + s);
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *
     * @param substitution
     */
    @Override
    public void changeVar(Map substitution) {
        for (Object o : sons) {
            if (o instanceof NumEffect) {
                NumEffect el = (NumEffect) o;
                el.changeVar(substitution);
            } else {
                Conditions el = (Conditions) o;
                el.changeVar(substitution);
            }
        }

    }
    
    public String pddlPrintWithExtraObject() {
        String ret_val = "(and ";
        for (Object o : sons) {
            if (o instanceof Conditions) {
                Conditions c = (Conditions) o;
                ret_val = ret_val.concat(c.pddlPrintWithExtraObject());
            } else if (o instanceof Comparison) {
                Comparison comp = (Comparison) o;
                ret_val = ret_val.concat(comp.pddlPrintWithExtraObject());
            } else {
                System.out.println("Error in pddlPrint:" + this);
                System.exit(-1);
            }
        }
        ret_val = ret_val.concat(")");
        return ret_val;
    }

    /**
     *
     * @return
     */
    @Override
    public Conditions clone() {
        AndCond ret = new AndCond();
        ret.grounded = this.grounded;
        //ret.sons = (HashSet)this.sons.clone();
        ret.sons = new LinkedHashSet();

        for (Object o : this.sons) {
            if (o instanceof AndCond) {
                AndCond a = (AndCond) o;
                ret.sons.add(a.clone());
            } else if (o instanceof NotCond) {
                NotCond a = (NotCond) o;
                ret.sons.add(a.clone());
            } else if (o instanceof OrCond) {
                OrCond a = (OrCond) o;
                ret.sons.add(a.clone());
            } else if (o instanceof Predicate) {
                Predicate a = (Predicate) o;
                ret.sons.add(a.clone());
            } else if (o instanceof Comparison) {
                Comparison a = (Comparison) o;
                ret.sons.add(a.clone());
            } else if (o instanceof NumFluentValue) {
                NumFluentValue a = (NumFluentValue) o;
                ret.sons.add(a.clone());
            } else if (o instanceof NumEffect) {
                NumEffect a = (NumEffect) o;
                ret.sons.add(a.clone());
            }else if (o instanceof ConditionalEffect) {
                ConditionalEffect a = (ConditionalEffect) o;
                ret.sons.add(a.clone());
            }
        }

        ret.specialAndForExpression = this.specialAndForExpression;
        return ret;

    }



    /**
     *
     * @param s
     * @return
     */
    public Conditions whatisnotSatisfied(RelState s) {
        for (Object o : this.sons) {
            if (o instanceof Conditions) {
                Conditions c = (Conditions) o;
                if (!c.can_be_true(s)) {
                    //System.out.println(c.pddlPrint() + " is not satisfied in " + s);
                    return c;
                }
            }
        }
        return null;
    }

    /**
     *
     * @param delList
     */
    public void subtractElements(AndCond delList) {
        if (delList == null) {
            return;
        }
        Iterator it2 = delList.sons.iterator();
        while (it2.hasNext()) {
            NotCond nc = (NotCond) it2.next();
            Iterator it = this.sons.iterator();
            while (it.hasNext()) {
                //NotCond nc = (NotCond)it.next();
                //System.out.println("Confronto : " + o.getClass());
                if (it.next().equals(nc.getSon())) {
                    it.remove();
                }
            }
        }
    }

    /**
     *
     * @param addList
     */
    public void subtractNegation(AndCond addList) {
        if (addList == null) {
            return;
        }
        Iterator it2 = addList.sons.iterator();
        while (it2.hasNext()) {
            Object o = it2.next();
            Iterator it = this.sons.iterator();

            while (it.hasNext()) {
                NotCond nc = (NotCond) it.next();
                //System.out.println("Confronto : " + o.getClass());
                if (o.equals(nc.getSon())) {
                    it.remove();
                }
            }
        }
    }

    /**
     *
     */
    @Override
    public void normalize() {

        Iterator it = sons.iterator();
        Collection<AndCond> to_add = new LinkedHashSet();
        while (it.hasNext()) {
            Object o = it.next();
            if (o instanceof Comparison) {
                Comparison comp = (Comparison) o;
                try {
                    //comp = comp.normalizeAndCopy();
                    comp.normalize();

                } catch (Exception ex) {
                    Logger.getLogger(AndCond.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (comp == null) {

                    it.remove();
                } else {
                    if (comp.isUnsatisfiable()) {
                        this.setUnsatisfiable(true);
                    }
                }
            } else if (o instanceof AndCond) {
                AndCond temp = (AndCond) o;
                temp.normalize();
                to_add.add(temp);
                it.remove();
            } else if (o instanceof NotCond) {
                NotCond temp = (NotCond) o;
                temp.normalize();
            } else if (o instanceof OrCond) {
                OrCond temp = (OrCond) o;
                temp.normalize();
            }
        }
        to_add.stream().forEach((ele) -> {
            this.sons.addAll(ele.sons);
        });

    }

    public State transformInStateIfPossible() {
        State ret = new State();
        for (Object o : this.sons) {
            if (o instanceof Predicate) {
                ret.addProposition((Predicate) o);
            } else {
                System.out.println("This AndCond cannot be transformed into a State");
                return null;
            }
        }
        return ret;
    }

    @Override
    public Conditions unGround(Map substitution) {
        AndCond ret = new AndCond();

        for (Object o : sons) {

            if (o instanceof NumEffect) {
                NumEffect el = (NumEffect) o;
                ret.sons.add(el.unGround(substitution));

            } else {
                Conditions el = (Conditions) o;
                //System.out.println(el);
                ret.sons.add(el.unGround(substitution));
            }
        }
        ret.grounded = false;
        return ret;
    }

    public Conditions requireAnInstanceOf(Conditions con) {

        for (Object o : this.sons) {
            //System.out.println("testing "+con+" with"+o);
            if (con.isUngroundVersionOf((Conditions) o)) {
                //System.out.println("ok");
                return (Conditions) o;
            }
        }
        return null;

    }

    public Predicate requireAnInstanceOfAndWhichis(Conditions con) {

        for (Object o : this.sons) {
            //System.out.println("testing "+con+" with"+o);
            if (con.isUngroundVersionOf((Conditions) o)) {
                //System.out.println("ok");
                return (Predicate) o;
            }
        }
        return null;

    }

    @Override
    public boolean isUngroundVersionOf(Conditions con) {
        if (con instanceof AndCond) {
            AndCond ac = (AndCond) con;
            Object[] sonsThis = this.sons.toArray();
            Object[] sonsCon = con.sons.toArray();
            if (sonsThis.length == sonsCon.length) {
                for (int i = 0; i < sonsThis.length; i++) {
                    boolean trovato = false;
                    for (int j = 0; j < sonsThis.length; j++) {
                        if (sonsThis[i].getClass() == sonsCon[j].getClass()) {
                            if (sonsThis[i] instanceof Comparison) {
                                Comparison fromThis = (Comparison) sonsThis[i];
                                Comparison fromCon = (Comparison) sonsCon[j];
                                if (fromThis.isUngroundVersionOf(fromCon)) {
                                    trovato = true;
                                    break;
                                }
                            } else if (sonsThis[i] instanceof Predicate) {
                                Predicate fromThis = (Predicate) sonsThis[i];
                                Predicate fromCon = (Predicate) sonsCon[j];
                                if (fromThis.isUngroundVersionOf(fromCon)) {
                                    trovato = true;
                                    break;
                                }
                            }
                        }
                    }
                    if (!trovato) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public String toSmtVariableString(int i) {

        String ret = "";
        if (this.sons != null) {
            if (this.sons.size() > 1) {
                ret += "(and";
            }

            for (Object o : this.sons) {
                if (o instanceof Predicate) {
                    Predicate p = (Predicate) o;
                    ret += " " + p.toSmtVariableString(i);
                } else if (o instanceof NotCond) {
                    NotCond nc = (NotCond) o;
                    ret += " " + nc.toSmtVariableString(i);
                } else if (o instanceof Conditions) {
                    Conditions c = (Conditions) o;
                    if (c.toSmtVariableString(i) != null) {
                        ret += c.toSmtVariableString(i);
                    }

                } else if (o instanceof NumEffect) {
                    NumEffect neff = (NumEffect) o;
                    ret += neff.toSmtVariableString(i);
                }
            }
            if (this.sons.size() > 1) {
                ret += ")";
            }
        }
        return ret;
    }

    @Override
    public Set<NumFluent> getInvolvedFluents() {
        Set<NumFluent> ret = new HashSet();
        if (this.sons != null) {
            for (Object o : this.sons) {
                if (o instanceof NumFluent) {
                    ret.add((NumFluent) o);
                } else {
                    if (o instanceof Conditions) {
                        Conditions c = (Conditions) o;
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
        }

        return ret;

    }

    @Override
    public Conditions weakEval(State s, HashMap invF) {
        Map<Conditions, Boolean> toRemove = new HashMap();
        if (this.sons != null) {
            Iterator it = this.sons.iterator();
            while (it.hasNext()){
                Object o2 = it.next();

                if (o2 instanceof Conditions) {
                    Conditions c = (Conditions) o2;
                    c.setFreeVarSemantic(this.freeVarSemantic);
                    c = c.weakEval(s, invF);
                    if (c == null) {
                        return null;
                    }
                    if (c.isValid()) {
                        it.remove();
                    }else if (c.isUnsatisfiable()) {
                        this.setUnsatisfiable(true);
                    }

                } else if (o2 instanceof NumEffect) {
                    NumEffect ne = (NumEffect) o2;
                    ne.setFreeVarSemantic(freeVarSemantic);
//                    System.out.println(ne);
                    ne = (NumEffect) ne.weakEval(s, invF);
                    if (ne == null) {
                        return null;
                    }
                } else {
//                    System.out.println(o2);
                    System.out.println("Unsupported operation for :" + o2.getClass());
                }
            }
//            Iterator it = this.sons.iterator();
//            while (it.hasNext()) {
//                if (toRemove.get(it.next()) != null) {
//                    it.remove();
//                }
//            }
        }
        return this;
    }

    @Override
    public Conditions ground(Map substitution, int c) {
        Conditions ret = this.ground(substitution);
        ret.setCounter(c);
        return ret;
    }

    @Override
    public String toSmtVariableString(int i, GroundAction gr, String var) {
        String ret = "";
        if (this.sons != null) {
            if (this.sons.size() > 1) {
                ret += "(and";
            }

            for (Object o : this.sons) {
                if (o instanceof Predicate) {
                    Predicate p = (Predicate) o;
                    ret += " " + p.toSmtVariableString(i, gr, var);
                } else if (o instanceof NotCond) {
                    NotCond nc = (NotCond) o;
                    ret += " " + nc.toSmtVariableString(i, gr, var);
                } else if (o instanceof Conditions) {
                    Conditions c = (Conditions) o;
                    if (c.toSmtVariableString(i, gr, var) != null) {
                        ret += c.toSmtVariableString(i, gr, var);
                    }

                } else {
                    throw new UnsupportedOperationException("Num effect not supported for repetition.." + this);
                }
            }
            if (this.sons.size() > 1) {
                ret += ")";
            }
        }
        return ret;

    }

    @Override
    public Conditions transform_equality() {
        if (this.sons == null)
            return this;
        AndCond ret = new AndCond();
        for (Conditions c1 : (Collection<Conditions>) this.sons) {
            Conditions res = c1.transform_equality();
            if (res instanceof AndCond)
                ret.sons.addAll(res.sons);
            else
                ret.addConditions(res);
            
        }
        return ret;
    }

    @Override
    public boolean is_affected_by(GroundAction gr) {
        
        if (this.sons!= null && !this.sons.isEmpty()){
            
            for (Conditions c:(Collection<Conditions>) this.sons){
                if (c.is_affected_by(gr))
                    return true;
            }
            
        }
        
        return false;
    }

    @Override
    public Conditions regress(GroundAction gr) {
        AndCond con = new AndCond();
        for (Object o : this.sons) {
            if (o instanceof Conditions) {
                Conditions t = (Conditions) o;
                Conditions temp = t.regress(gr);
//                System.out.println(temp);
                if (!temp.isValid()){//needs to be satisfied
                    if (temp.isUnsatisfiable()){
                        return new Predicate(Predicate.true_false.FALSE);
                    }else{
                        if (temp instanceof AndCond)
                            con.sons.addAll(((AndCond) temp).sons);
                        else
                            con.sons.add(temp);
                    }
                }//else do not add the condition at all
//                System.out.println("DEBUG: Condition before regression"+t);
//                System.out.println("DEBUG: Condition after regression"+temp);

            } else {
                System.out.println("AndCond: Condition " + o + " cannot be regressed");
                System.exit(-1);
            }
        }
//        System.out.println(this);

        if (con.sons.isEmpty()){
//            System.out.println("Always valid");
            return new Predicate(Predicate.true_false.TRUE);
        }
        return con;   
    }

    @Override
    public boolean can_be_false(RelState s) {
        for (Object o : this.sons) {
            if (o instanceof Conditions) {
                Conditions c = (Conditions) o;
                if (c.can_be_false(s)) {
                    //System.out.println(c.pddlPrint() + " is not satisfied in " + s);
                    return true;
                }
            }
        }
        return false;    
    }

    @Override
    public Conditions achieve(Predicate p) {
        for (Conditions p1: (Collection<Conditions>)this.sons ){
            if (p1 instanceof Predicate)
                if (p1.equals(p))
                    return new Predicate(Predicate.true_false.TRUE);
        }
        return null;

    }

    @Override
    public Conditions delete(Predicate p) {
        for (Conditions p1: (Collection<Conditions>)this.sons ){
            if (p1 instanceof NotCond){
                NotCond nc = (NotCond)p1;
                Predicate p2 = (Predicate)nc.getSon();
                if (p2.equals(p))
                    return new Predicate(Predicate.true_false.TRUE);
            }
        }
        return null;    
    }

    @Override 
    public int hashCode() {
        final int sonHash = sons.hashCode();
        final int result = sonHash + 7;
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
        
        if (!(obj instanceof AndCond)) {
            return false;
        }
        
        final AndCond other = (AndCond)obj;
        
        if (!this.sons.equals(other.sons)) {
            return false;
        }
        
        return true;
    }

    @Override
    public HashMap apply(State s) {
        HashMap ret = new HashMap();
        apply(s, ret);
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
        for (Object o : this.sons) {
//            if ((o instanceof AndCond) 
//                    || (o instanceof Predicate)
//                    || (o instanceof NotCond)
//                    || (o instanceof NumEffect)
//                    || (o instanceof ConditionalEffect)
//                    ) {
            if (o instanceof PostCondition) {
                final PostCondition pc = (PostCondition)o;
                pc.apply(s, modifications);
            } else {
                sonHasIncorrectType(o);
            }
        }
    }

    @Override
    public void apply(RelState s, Map modifications) {
        for (Object o : this.sons) {
//            if ((o instanceof AndCond) 
//                    || (o instanceof Predicate)
//                    || (o instanceof NotCond)
//                    || (o instanceof NumEffect)
//                    || (o instanceof ConditionalEffect)
//                    ) {
            if (o instanceof PostCondition) {
                final PostCondition pc = (PostCondition)o;
                pc.apply(s, modifications);
            } else {
                sonHasIncorrectType(o);
            }
        }
    }
    
    private void sonHasIncorrectType(Object son) {
        System.out.println("Effect " + son + " is not valid. Its class is" 
                + son.getClass() + ".  Please revise your action model.");
        System.exit(-1);
    }
    
    @Override
    public void pddlPrint(boolean typeInformation, StringBuilder bui) {
        bui.append("(and ");
        for (Object o : sons) {
            if (o instanceof Conditions) {
                Conditions c = (Conditions) o;
                c.pddlPrint(typeInformation,bui);
//            } else if (o instanceof Comparison) { // ??? a Comparison is already a Conditions
//                Comparison comp = (Comparison) o;
//                ret_val = ret_val.concat(comp.pddlPrint(typeInformation));
            } else {
                System.out.println("Error in pddlPrint: " + this);
                System.exit(-1);
            }
        }
        bui.append(")");
    }

    @Override
    public void storeInvolvedVariables(Collection<Variable> vars) {
        if (this.sons != null) {
            for (Object o : this.sons) {
                if (o instanceof Conditions) {
                    Conditions c = (Conditions) o;
                    c.storeInvolvedVariables(vars);
                } else if (o instanceof NumEffect) {
                    NumEffect c = (NumEffect) o;
                    if (c.getInvolvedVariables() != null) {
                        c.storeInvolvedVariables(vars);
                    }
                } else {
                    System.out.println("Error in getting involved variables");
                }
            }

        }
    }

    @Override
    public Set<Conditions> getTerminalConditions() {
        LinkedHashSet ret = new LinkedHashSet();
        if (this.sons==null)
            return new LinkedHashSet();
        for (Conditions c: (Collection<Conditions>)this.sons){
            ret.addAll(c.getTerminalConditions());
        }
        return ret;
    }

    @Override
    public Float estimate_cost(ArrayList<Float> cond_dist, boolean additive_h) {
        if (this.sons == null)
            return 0f;
        Float ret = 0f;
        for (Conditions c: (Collection<Conditions>)this.sons){
            if (c.estimate_cost(cond_dist,additive_h)==Float.MAX_VALUE)
                    return Float.MAX_VALUE;
            if (additive_h)
                ret+=c.estimate_cost(cond_dist,additive_h);
            else
                ret = Math.max(c.estimate_cost(cond_dist,additive_h),ret);
        }
        return ret;
    }
    


    @Override
    public Conditions and(Conditions precondition) {
        AndCond and = new AndCond();
        and.addConditions(precondition);
        and.sons.addAll(this.sons);
        return and;
    }

    @Override
    public achiever_set estimate_cost(ArrayList<Float> cond_dist, boolean additive_h, ArrayList<GroundAction> established_achiever) {
        achiever_set s = new achiever_set();
        if (this.sons == null){
            s.cost=0f;
        }else{
             s.cost=0f;
            for (Conditions c: (Collection<Conditions>)this.sons){
                achiever_set s1=c.estimate_cost(cond_dist,additive_h,established_achiever);
                if (s1.cost==Float.MAX_VALUE){
                        s.cost = Float.MAX_VALUE;
                        return s;
                }
                if (additive_h){
                    s.cost+=s1.cost;
                    s.actions.addAll(s1.actions);
                    s.target_cond.addAll(s1.target_cond);
                }else{
                    s.cost = Math.max(s1.cost, s.cost);
                }
            }
        }
        return s;
    }

    @Override
    public Conditions push_not_to_terminals() {
        if (this.sons==null)
            return this;
        AndCond res = new AndCond();
        for (Conditions c: (Collection<Conditions>)this.sons){
            Conditions c1 = c.push_not_to_terminals();
            res.addConditions(c1);
        }
        return res;
    }

    OrCond push_negation_demorgan() {
        OrCond res = new OrCond();
        for (Conditions c:(Collection<Conditions>) this.sons){
            NotCond nc = new NotCond(c);
            res.addConditions(nc);
        }
        return res;
    }
}

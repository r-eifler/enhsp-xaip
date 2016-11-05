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

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AndCond other = (AndCond) obj;

//        System.out.println("ANDCOND: equal function not implemented yet");
//        System.exit(-1);
        return false;
    }

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

    /**
     *
     * @param the sigma relating the the variable involved with concrete
     * pddlobject
     * @return
     */
    @Override
    public Conditions ground(Map substitution) {
        AndCond ret = new AndCond();

        //System.out.println(this.toString());
        for (Object o : sons) {
            if (o instanceof NumEffect) {
                NumEffect el = (NumEffect) o;
                ret.sons.add(el.ground(substitution));

            } else {
                Conditions el = (Conditions) o;
                //System.out.println(el);
                ret.sons.add(el.ground(substitution));
            }
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
     * @param s
     * @return
     */
    public HashMap apply(State s) {

        HashMap ret = new HashMap();
        for (Object o : this.sons) {
            if (o instanceof AndCond) {
                AndCond t = (AndCond) o;
                ret.putAll(t.apply(s));
            } else if (o instanceof Predicate) {
                Predicate p = (Predicate) o;
                ret.putAll(p.apply(s));
            } else if (o instanceof NotCond) {
                NotCond n = (NotCond) o;
                ret.putAll(n.apply(s));
            } else if (o instanceof NumEffect) {
                NumEffect n = (NumEffect) o;
                ret.putAll(n.apply(s));
            } else if (o instanceof ConditionalEffect){
                ConditionalEffect ce = (ConditionalEffect)o;
                ret.putAll(ce.apply(s));
            }else {
                System.out.println("Effect " + o + " is not valid. Its class is"+o.getClass()+" Please revise your action model");
                System.exit(-1);
            }
        }
        return ret;

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

    /**
     *
     * @return
     */
    @Override
    public String pddlPrint(boolean typeInformation) {
        String ret_val = "(and ";
        for (Object o : sons) {
            if (o instanceof Conditions) {
                Conditions c = (Conditions) o;
                ret_val = ret_val.concat(c.pddlPrint(typeInformation));
            } else if (o instanceof Comparison) {
                Comparison comp = (Comparison) o;
                ret_val = ret_val.concat(comp.pddlPrint(typeInformation));
            } else {
                System.out.println("Error in pddlPrint:" + this);
                System.exit(-1);
            }
        }
        ret_val = ret_val.concat(")");
        return ret_val;
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
    public HashMap apply(RelState s) {
        HashMap ret = new HashMap();
        for (Object o : this.sons) {
            if (o instanceof AndCond) {
                AndCond t = (AndCond) o;
                ret.putAll(t.apply(s));
            } else if (o instanceof Predicate) {
                Predicate p = (Predicate) o;
                ret.putAll(p.apply(s));
            } else if (o instanceof NotCond) {
                NotCond n = (NotCond) o;
                ret.putAll(n.apply(s));
            } else if (o instanceof NumEffect) {
                NumEffect n = (NumEffect) o;
                ret.putAll(n.apply(s));
            } else if (o instanceof ConditionalEffect) {
                ConditionalEffect cf = (ConditionalEffect) o;
                ret.putAll(cf.apply(s));
            } else {
                System.out.println("AndCond: Effect " + o + " is not valid. Class is:"+o.getClass()+" Please revise your action model");
                System.exit(-1);
            }
        }
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
                if (it.next().equals(nc.son.iterator().next())) {
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
                if (o.equals(nc.son.iterator().next())) {
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
    public ArrayList<Variable> getInvolvedVariables() {
        ArrayList<Variable> ret = new ArrayList();
        if (this.sons != null) {
            for (Object o : this.sons) {
                    if (o instanceof Conditions) {
                        Conditions c = (Conditions) o;
                        if (c.getInvolvedVariables() != null) {
                            ret.addAll(c.getInvolvedVariables());
                        }
                    } else if (o instanceof NumEffect) {
                        NumEffect c = (NumEffect) o;
                        if (c.getInvolvedVariables() != null) {
                            ret.addAll(c.getInvolvedVariables());
                        }
                    } else {
                        System.out.println("Error in getting involved variables");
                    }
                }
            
        }

        return ret;    
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



}

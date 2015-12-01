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

package conditions;

import expressions.NumFluent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import problem.GroundAction;
import problem.RelState;
import problem.State;

/**
 *
 * @author enrico
 */
public class NotCond extends Conditions {

    public HashSet son;

    public NotCond() {
        super();
        son = new HashSet();
    }

    public void addConditions(Conditions c) {
        son.add(c);
    }

    public String toString() {
        String ret_val = "Not(";
        for (Object o : son) {
            ret_val = ret_val.concat(o.toString());
        }
        ret_val = ret_val.concat(")");

        return ret_val;
    }

    @Override
    public Conditions ground(Map substitution) {
        NotCond ret = new NotCond();

        for (Object o : son) {
            Conditions el = (Conditions) o;
            ret.son.add(el.ground(substitution));
        }
        ret.grounded = true;
        return ret;
    }
    
    @Override
    public Conditions ground(Map substitution, int c) {
        Conditions ret = this.ground(substitution);
        ret.setCounter(c);
        return ret;
    }

    //ECCO LA CLOSED WORLD ASSUMPTION---->>>>E ORA!?
    //Assumiamo che non lo stato le cose che non ci sono sono considerate negate. Questo prevede che la lettura dello stato iniziale ELIMINI tutte le cose negative.....
    @Override
    public boolean eval(State s) {
        for (Object o : this.son) {
            Conditions c = (Conditions) o;
            return !c.eval(s);
        }
        return false;
    }

    @Override
    public boolean isSatisfied(State s) {
        for (Object o : this.son) {
            Conditions c = (Conditions) o;
            return !c.isSatisfied(s);
        }
        return false;
    }

    @Override
    public boolean isSatisfied(RelState s) {
        return true;
//        for (Object o : this.son) {
//            Conditions c = (Conditions) o;
//            return !c.isSatisfied(s);
//        }
//        return false;
    }

    public State apply(State s) {
        State ret = s;
        for (Object o : this.son) {
            if (o instanceof AndCond) {
                AndCond t = (AndCond) o;
                ret = t.remove(s);
            } else if (o instanceof Predicate) {
                Predicate p = (Predicate) o;
                ret = p.remove(s);
            } else if (o instanceof NotCond) {
                NotCond n = (NotCond) o;
                ret = n.apply(s);
            } else {
                System.out.println("Effect " + this + " is not valid. Please revise your action model");
                System.exit(-1);
            }
        }
        return ret;

    }

    @Override
    public void normalize() {        
       
        Iterator it = son.iterator();
        while(it.hasNext()){
            Object o = it.next();
            if (o instanceof Comparison){
                Comparison comp = (Comparison)o;
                try {
                    comp.normalize();
                } catch (Exception ex) {
                    Logger.getLogger(NotCond.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (comp==null) {
                    it.remove();
                }
            }else{
                Conditions c = (Conditions)o;
                c.normalize();
            }
        }
        
    }
    
    @Override
    public void changeVar(Map substitution) {

        for (Object o : son) {
            Conditions el = (Conditions) o;
            el.changeVar(substitution);
        }
    }

    public String pddlPrint(boolean typeInformation) {
        String ret_val = "(not ";
        for (Object o : son) {
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

    @Override
    public Conditions clone() {
        NotCond ret = new NotCond();

//        ret.sons = new HashSet();
        ret.son = (HashSet) this.son.clone();
//        for(Object o: this.sons){
//            if (o instanceof AndCond){
//                AndCond a = (AndCond)o;
//                ret.sons.add(a.clone());
//            }else if(o instanceof NotCond){
//                NotCond a = (NotCond)o;
//                ret.sons.add(a.clone());
//            }else if(o instanceof OrCond){
//                OrCond a = (OrCond)o;
//                ret.sons.add(a.clone());
//            }else if(o instanceof Predicate){
//                Predicate a = (Predicate)o;
//                ret.sons.add(a.clone());            
//            }else if(o instanceof Comparison){
//                Comparison a = (Comparison)o;
//                ret.sons.add(a.clone());            
//            }else if(o instanceof Assigner){
//                Assigner a = (Assigner)o;
//                ret.sons.add(a.clone());            
//            }
//        }
        ret.grounded = this.grounded;
        return ret;
    }

    RelState apply(RelState s) {
        RelState ret = s;
        for (Object o : this.son) {
            if (o instanceof AndCond) {
                AndCond t = (AndCond) o;
                ret = t.remove(s);
            } else if (o instanceof Predicate) {
                Predicate p = (Predicate) o;
                ret = p.remove(s);
            } else if (o instanceof NotCond) {
                NotCond n = (NotCond) o;
                ret = n.apply(s);
            } else {
                System.out.println("Effect " + this + " is not valid. Please revise your action model");
                System.exit(-1);
            }
        }
        return ret;

    }

    @Override
    public boolean isUngroundVersionOf(Conditions con) {
        if (con instanceof NotCond){
            NotCond nc = (NotCond)con;
            Conditions c1 = (Conditions)this.son.toArray()[0]; 
            Conditions c2 = (Conditions)nc.son.toArray()[0]; 
            if (c1.isUngroundVersionOf(c2))
                return true;
            
        }
        return false;
    }
    @Override
    public Conditions unGround(Map substitution) {
        NotCond ret = new NotCond();

        for (Object o : son) {
            Conditions el = (Conditions) o;
            ret.son.add(el.unGround(substitution));
        }
        ret.grounded = false;
        return ret;
    }

    @Override
    public String toSmtVariableString(int i) {
        Conditions p = (Conditions)this.son.iterator().next();
        return "(not "+p.toSmtVariableString(i)+")";
    }

    @Override
    public Set<NumFluent> getInvolvedFluents() {
        Set<NumFluent> ret = new HashSet();
        
        if (this.son != null){
            for (Object o: this.son){
                if (o instanceof NumFluent){
                    ret.add((NumFluent)o);
                }else{
                    if (o instanceof Conditions){
                        Conditions c = (Conditions)o;
                        if (c.getInvolvedFluents() != null)
                            ret.addAll(c.getInvolvedFluents());
                    }else{
                        System.out.println("Error in getting involved fluents");
                    }
                }
            }
        }
            
        return ret;
    }

    @Override
    public Conditions weakEval(State s, HashMap invF) {
        Map<Conditions,Boolean> toRemove = new HashMap();
        for (Object o : son) {
            Conditions el = (Conditions) o;
            el.setFreeVarSemantic(freeVarSemantic);
            el = el.weakEval(s, invF);   
            if (el.isValid()){
                this.isUnsatisfiable();
            }else if (el.isUnsatisfiable()){
                this.setValid(true);
            }
        }
        
        
        return this;
    }

    @Override
    public String toSmtVariableString(int i, GroundAction gr, String var) {
        Conditions p = (Conditions)this.son.iterator().next();
        return "(not "+p.toSmtVariableString(i,gr,var)+")";
    }




}

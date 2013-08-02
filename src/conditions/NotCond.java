/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conditions;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
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
        for (Object o : this.son) {
            Conditions c = (Conditions) o;
            return !c.isSatisfied(s);
        }
        return false;
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
        Iterator it = sons.iterator();
        while(it.hasNext()){
            Object o = it.next();
            if (o instanceof Comparison){
                Comparison comp = (Comparison)o;
                comp = comp.normalizeAndCopy();
                if (comp==null) {
                    it.remove();
                }
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

    public String pddlPrint() {
        String ret_val = "(not ";
        for (Object o : son) {
            if (o instanceof Conditions) {
                Conditions c = (Conditions) o;
                ret_val = ret_val.concat(c.pddlPrint());
            } else if (o instanceof Comparison) {
                Comparison comp = (Comparison) o;
                ret_val = ret_val.concat(comp.pddlPrint());
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
}

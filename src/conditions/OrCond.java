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
public class OrCond extends Conditions {

    public HashSet son;

    public OrCond() {
        super();
        son = new HashSet();
    }

    public void addConditions(Conditions c) {
        son.add(c);
    }

    public String toString() {
        String ret_val = "Or(";
        for (Object o : son) {
            ret_val = ret_val.concat(o.toString());
        }
        ret_val = ret_val.concat(")");

        return ret_val;
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
    public Conditions ground(Map substitution) {
        OrCond ret = new OrCond();

        for (Object o : son) {
            Conditions el = (Conditions) o;
            ret.son.add(el.ground(substitution));
        }
        ret.grounded = true;
        return ret;
    }

    @Override
    public boolean eval(State s) {

        for (Object o : son) {
            Conditions c = (Conditions) o;
            if (c.eval(s)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isSatisfied(State s) {
        for (Object o : son) {
            Conditions c = (Conditions) o;
            if (c.eval(s)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isSatisfied(RelState s) {
        for (Object o : son) {
            Conditions c = (Conditions) o;
            if (c.isSatisfied(s)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void changeVar(Map substitution) {

        for (Object o : son) {
            Conditions el = (Conditions) o;
            el.changeVar(substitution);
        }
    }

    public String pddlPrint() {
        String ret_val = "(or ";
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
        OrCond ret = new OrCond();

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
}

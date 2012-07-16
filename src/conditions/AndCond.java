/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conditions;

import expressions.NumEffect;
import expressions.Expression;
import java.util.Map;
import problem.State;


/**
 *
 * @author enrico
 */
public class AndCond extends Conditions {
    
    private boolean specialAndForExpression;

    public AndCond(){
        super();
    }
    public void addConditions(Conditions c){        
        son.add(c);

    }
    public String toString(){
        String ret_val="And(";
        for (Object o: son){
            ret_val = ret_val.concat(o.toString());
        }
        ret_val = ret_val.concat(")");
        return ret_val;
    }

    @Override
    public Conditions ground(Map substitution) {
        AndCond ret = new AndCond();
        
        for (Object o: son){
            
            if (o instanceof NumEffect){
                NumEffect el = (NumEffect)o;
                ret.son.add(el.ground(substitution));
                
            }else{
                Conditions el = (Conditions)o;
                ret.son.add(el.ground(substitution));
            }
        }
        ret.grounded = true;
        return ret;
    }
    
    
    

    @Override
    public boolean eval(State s) {
        for (Object o : this.son){
            if (o instanceof Conditions){
                Conditions c = (Conditions)o;
                if (!c.eval(s))
                    return false;
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

    public void addExpression(Expression e) {
        this.son.add(e);
    }

    @Override
    public boolean isSatisfied(State s) {
        for (Object o : this.son){
            if (o instanceof Conditions){
                Conditions c = (Conditions)o;
                if (!c.isSatisfied(s)){
                    System.out.println(c + " is not satisfied in " + s);
                    return false;
                }
            }
        }
        return true;
    }
    
    public State apply(State s){
        State ret = s;
        for (Object o : this.son){
            if (o instanceof AndCond){
                AndCond t = (AndCond)o;
                ret  = t.apply(s);
            }else if(o instanceof Predicate){
                Predicate p = (Predicate)o;
                ret = p.apply(s);
            }else if(o instanceof NotCond){
                NotCond n = (NotCond)o;
                ret = n.apply(s);
            }else if(o instanceof NumEffect){
                NumEffect n = (NumEffect)o;
                n.apply(s);
            }else{
                System.out.println("Effect "+this+" is not valid. Please revise your action model");
                System.exit(-1);
            }
        }
        return ret;

    }
    
    public State remove(State s) {
        State ret = s;
        for (Object o : this.son){
           if (o instanceof AndCond){
                AndCond t = (AndCond)o;
                ret  = t.remove(s);
            }else if(o instanceof Predicate){
                Predicate p = (Predicate)o;
                ret = p.remove(s);
            }else if(o instanceof NotCond){
                NotCond n = (NotCond)o;
                ret = n.apply(s);
            }  
        }
        return s;
    }

    @Override
    public void changeVar(Map substitution) {
        for (Object o: son){
            if (o instanceof NumEffect){
                NumEffect el = (NumEffect)o;
                el.changeVar(substitution);
                
            }else{
                Conditions el = (Conditions)o;
                el.changeVar(substitution);
            }
        }

    }

    @Override
    public String pddlPrint() {
        String ret_val="(and ";
        for (Object o: son){
            if (o instanceof Conditions){
                Conditions c = (Conditions)o;
                ret_val = ret_val.concat(c.pddlPrint());
            }else if (o instanceof Comparison){
                Comparison comp = (Comparison)o;
                ret_val = ret_val.concat(comp.pddlPrint());
            }else{
                System.out.println("Error in pddlPrint:" + this);
                System.exit(-1);
            }
        }
        ret_val = ret_val.concat(")");
        return ret_val;
    }
}

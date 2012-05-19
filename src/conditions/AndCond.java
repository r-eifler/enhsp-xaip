/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conditions;

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
            Conditions el = (Conditions)o;
            ret.son.add(el.ground(substitution));
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
}

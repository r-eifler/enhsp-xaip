/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expressions;

import java.util.Map;
import problem.State;

/**
 *
 * @author enrico
 */
public class Number extends Expression
{
    private Float number;
    public Number(Float n){
        grounded=true;
        number = n;

    }
    public String toString(){
    
        return " "+ getNumber() + " ";
    }

    @Override
    public Expression ground(Map substitution) {
        return new Number(getNumber());
    }

    /**
     * @return the number
     */
    public Float getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(Float number) {
        this.number = number;
    }

    @Override
    public Number eval(State s) {
            return this;
    }
}

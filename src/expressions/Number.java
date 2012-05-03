/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expressions;

import java.util.Map;

/**
 *
 * @author enrico
 */
public class Number extends Expression
{
    Float number;
    public Number(Float n){
        grounded=true;
        number = n;

    }
    public String toString(){
    
        return " "+ number + " ";
    }

    @Override
    public Expression ground(Map substitution) {
        return new Number(number);
    }
}

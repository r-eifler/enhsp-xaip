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
public class MinusUnary extends Expression {
    Expression one;

    public MinusUnary() {
        super();
    }

    
    public MinusUnary(Expression expr) {
        super();
        one = expr;
    }

    @Override
    public Expression ground(Map substitution) {
        MinusUnary ret = new MinusUnary();
        
        ret.one = one.ground(substitution);
        ret.grounded=true;
        return ret;
    }
}

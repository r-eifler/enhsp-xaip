/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expressions;

/**
 *
 * @author enrico
 */
public class MinusUnary extends Expression {
    Expression one;

    public MinusUnary(Expression expr) {
        one = expr;
    }
}

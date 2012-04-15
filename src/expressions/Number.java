/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expressions;

/**
 *
 * @author enrico
 */
public class Number extends Expression
{
    Float number;
    public Number(Float n){
        number = n;

    }
    public String toString(){
    
        return " "+ number + " ";
    }
}

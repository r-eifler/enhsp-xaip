/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author enrico
 */
public class MultiOp extends Expression{
    private String operator;
    private List expr;

    public MultiOp(String operator, List expr) {
        super();
        this.operator = operator;
        this.expr = expr;
       
        InitList();
    }

    public MultiOp(String operator) {
        super();
        this.operator = operator;
        InitList();
    }

    public MultiOp() {
        super();
        InitList();
    }
    
    private void InitList(){
        expr = new ArrayList();
    }
    
    public void addExpression(Object e){
    
        expr.add(e);
    
    }
    @Override
    public String toString(){

        String ret = this.operator;
//        for(Object o: expr){
//            ret += " " + expr;
//        }
        
        
        return ret + expr;
    }

    /**
     * @return the operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     * @param operator the operator to set
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * @return the expr
     */
    public List getExpr() {
        return expr;
    }

    /**
     * @param expr the expr to set
     */
    public void setExpr(List expr) {
        this.expr = expr;
    }

    @Override
    public Expression ground(Map substitution) {
        MultiOp ret = new MultiOp();
        for (Object o: expr){
            Expression e = (Expression)o;
            ret.addExpression(e.ground(substitution));
        }
        ret.grounded=true;
        return ret;
    }

   
}

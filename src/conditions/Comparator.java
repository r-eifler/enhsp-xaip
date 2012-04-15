/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conditions;

import expressions.Expression;


/**
 *
 * @author enrico
 */
public class Comparator extends Conditions{
    private String bin_comp;
    private Expression one;
    private Expression two;


    public Comparator(String bin_comp_){
        bin_comp = bin_comp_;
    }
    public String toString(){
    
        return "(" +getBin_comp() +" "+ getFirst() + " " + getTwo() +")";
    
    
    }

    /**
     * @return the bin_comp
     */
    public String getBin_comp() {
        return bin_comp;
    }

    /**
     * @param bin_comp the bin_comp to set
     */
    public void setBin_comp(String bin_comp) {
        this.bin_comp = bin_comp;
    }

    /**
     * @return the one
     */
    public Expression getFirst() {
        return one;
    }

    /**
     * @param one the one to set
     */
    public void setFirst(Expression one) {
        this.one = one;
    }

    /**
     * @return the two
     */
    public Expression getTwo() {
        return two;
    }

    /**
     * @param two the two to set
     */
    public void setTwo(Expression two) {
        this.two = two;
    }
}

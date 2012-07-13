/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conditions;

import expressions.Expression;
import java.util.Map;
import problem.State;
import expressions.PDDLNumber;


/**
 *
 * @author enrico
 */
public class Comparison extends Conditions{
    private String bin_comp;
    private Expression one;
    private Expression two;


    public Comparison(String bin_comp_){
        super();
        bin_comp = bin_comp_;
    }
    
    @Override
    public String toString(){
    
        return "(" +getBin_comp() +" "+ getFirst() + " " + getTwo() +")";
    
    }
    @Override
    public String pddlPrint() {
        return "(" +getBin_comp() +" "+ getFirst().pddlPrint() + " " + getTwo().pddlPrint() +")";
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

    @Override
    public Conditions ground(Map substitution) {
        Comparison ret = new Comparison(bin_comp);
        
       ret.one = one.ground(substitution);
       ret.two = two.ground(substitution);
       ret.grounded=true;
       return ret;
    }

    @Override
    public boolean eval(State s) {
        PDDLNumber first = one.eval(s);
        PDDLNumber second = two.eval(s);

        if (this.getBin_comp().equals("<")){
            return first.getNumber() < second.getNumber();
        }else if (this.getBin_comp().equals("<=")){
            return first.getNumber() <= second.getNumber();
        }else if (this.getBin_comp().equals(">")){
            return first.getNumber() > second.getNumber();
        }else if (this.getBin_comp().equals(">=")){
            return first.getNumber() >= second.getNumber();
        }else if (this.getBin_comp().equals("=")){
            return first.getNumber() == second.getNumber();
        }else{
            System.out.println(this.getBin_comp() + "  does not supported");
        }

        return false;
    }

    @Override
    public boolean isSatisfied(State s) {
        PDDLNumber first = one.eval(s);
        PDDLNumber second = two.eval(s);

        if (this.getBin_comp().equals("<")){
            return first.getNumber() < second.getNumber();
        }else if (this.getBin_comp().equals("<=")){
            return first.getNumber() <= second.getNumber();
        }else if (this.getBin_comp().equals(">")){
            return first.getNumber() > second.getNumber();
        }else if (this.getBin_comp().equals(">=")){
            return first.getNumber() >= second.getNumber();
        }else if (this.getBin_comp().equals("=")){
            return first.getNumber() == second.getNumber();
        }else{
            System.out.println(this.getBin_comp() + "  is not supported");
        }

        return false;
    }

    @Override
    public void changeVar(Map substitution) {
        
       this.one.changeVar(substitution);
       this.two.changeVar(substitution);
       
    }
    
    public Comparison normalize(){
        Comparison ret = new Comparison(this.bin_comp);
        ret.setFirst(this.one.normalize());
        ret.setTwo(this.two.normalize());
        return ret;
    }


}

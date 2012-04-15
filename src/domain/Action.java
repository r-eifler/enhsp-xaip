/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import conditions.Conditions;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 *
 * @author enrico
 */
public class Action extends Object{
    private String name;
    private ActionParameters parameters;
    private Conditions preconditions;
    private Conditions addList;
    private Conditions delList;
    private Conditions numeric;
    private boolean ground;
    private HashMap substitution;

    public Action() {

        parameters = new ActionParameters();
        ground=false;
    }
    /**
     * @return the name
     */

    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
//
//    public Action ground(ArrayList terms){
//        
//        
//        substitution = new HashMap();
//        
//        
//    }
    /**
     * @return the parameters
     */
    public ActionParameters getParameters() {
        return parameters;
    }


    /**
     * @param parameters the parameters to set
     */
    public void setParameters(ActionParameters parameters) {
        this.parameters = parameters;
    }
    public void addParameter(Variable o){
        
        parameters.add(o);
        
    }

    /**
     * @return the preconditions
     */
    public Conditions getPreconditions() {
        return preconditions;
    }

    /**
     * @param preconditions the preconditions to set
     */
    public void setPreconditions(Conditions preconditions) {
        this.preconditions = preconditions;
    }

    /**
     * @return the addList
     */
    public Conditions getAddList() {
        return addList;
    }

    /**
     * @param addList the addList to set
     */
    public void setAddList(Conditions addList) {
        this.addList = addList;
    }

    /**
     * @return the delList
     */
    public Conditions getDelList() {
        return delList;
    }

    /**
     * @param delList the delList to set
     */
    public void setDelList(Conditions delList) {
        this.delList = delList;
    }
    public String toString(){

        String parametri = "";
        for(Object o : parameters){
            parametri = parametri.concat(o.toString()).concat(" ");
        }
        return "\n\nAction Name:" + this.name + " Parameters: " + parametri +"\nPre: " + this.preconditions +  "\nEffetti positivi: "+ this.getAddList() + "\nEffetti negativi: " + this.getDelList() +"\nNumeric Effects:  " + this.getNumeric();

    }

    /**
     * @return the numeric
     */
    public Conditions getNumeric() {
        return numeric;
    }

    /**
     * @param numeric the numeric to set
     */
    public void setNumeric(Conditions numeric) {
        this.numeric = numeric;
    }



}

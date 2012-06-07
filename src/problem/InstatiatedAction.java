package problem;

import conditions.AndCond;
import conditions.Conditions;

import domain.ActionParametersAsTerms;
import domain.GenericActionType;

public class InstatiatedAction extends GenericActionType {
    protected ActionParametersAsTerms parameters;


    public InstatiatedAction(String name) {
        this.name = name;
    }
 
    
    @Override
    public String toString(){
        String parametri = "";
        for(Object o : getParameters()){
            parametri = parametri.concat(o.toString()).concat(" ");
        }
        return "\n\nAction Name:" + this.name + " Parameters: " + parametri +"\nPre: " + this.preconditions +  "\nEffetti positivi: "+ this.getAddList() + "\nEffetti negativi: " + this.getDelList() +"\nNumeric Effects:  " + this.getNumeric();

    }
    public String toEcoString(){
        String parametri = "";
        for(Object o : getParameters()){
            parametri = parametri.concat(o.toString()).concat(" ");
        }
        return "\n\nAction Name:" + this.name + " Parameters: " + parametri ;

    }


    /**
     * @return the parameters
     */
    public ActionParametersAsTerms getParameters() {
        return parameters;
    }

    /**
     * @param parameters the parameters to set
     */
    public void setParameters(ActionParametersAsTerms parameters) {
        this.parameters = parameters;
    }
    
    public State apply(State s){
        State ret = s;
        AndCond add = (AndCond)addList;
        ret = add.apply(s);
        AndCond del = (AndCond)delList;
        ret = del.apply(s);
        AndCond num = (AndCond)this.getNumeric();
        ret = num.apply(s);       
        return ret;
    }
    
}

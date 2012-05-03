package problem;

import conditions.Conditions;

import domain.ActionParametersAsTerms;
import domain.GenericActionType;

public class InstatiatedAction extends GenericActionType {
    private String name;
    private ActionParametersAsTerms parameters;
    private Conditions preconditions;
    private Conditions addList;
    private Conditions delList;
    private Conditions numeric;

    public InstatiatedAction(String name) {
        this.name = name;
    }
    
    
    @Override
    public void setAddList(Conditions addList) {
    }

    @Override
    public void setDelList(Conditions delList) {
        this.delList = delList;
    }

    @Override
    public Conditions getAddList() {
        return this.delList;
    }

    @Override
    public void setName(String name) {
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setNumeric(Conditions numeric) {
    }

    @Override
    public Conditions getNumeric() {
        return null;
    }

    @Override
    public Conditions getPreconditions() {
        return null;
    }

    @Override
    public void setPreconditions(Conditions preconditions) {
    }

    @Override
    public Conditions getDelList() {
        return null;
    }
    public String toString(){
        return "";
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
}

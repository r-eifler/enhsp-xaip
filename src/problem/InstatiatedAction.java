package problem;

import conditions.Conditions;

import domain.GenericActionType;

public class InstatiatedAction extends GenericActionType {
    private Conditions preconditions;
    private Conditions addList;
    private Conditions delList;
    private Conditions numeric;
    
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
}

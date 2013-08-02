package domain;

import conditions.Conditions;

import expressions.Expression;

public abstract class GenericActionType extends Object {

    protected String name;
    protected Conditions addList;
    protected Conditions delList;
    protected Conditions numericEffects;
    protected Conditions preconditions;

    /**
     * @return the addList
     */
    public Conditions getAddList() {
        return addList;
    }

    /**
     * @return the delList
     */
    public Conditions getDelList() {
        return delList;
    }

    public String getName() {
        return name;
    }

    /**
     * @return the numericEffects
     */
    public Conditions getNumericEffects() {
        return numericEffects;
    }

    /**
     * @return the preconditions
     */
    public Conditions getPreconditions() {
        return preconditions;
    }

    /**
     * @param addList the addList to set
     */
    public void setAddList(Conditions addList) {
        this.addList = addList;
    }

    /**
     * @param delList the delList to set
     */
    public void setDelList(Conditions delList) {
        this.delList = delList;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param numericEffects the numericEffects to set
     */
    public void setNumericEffects(Conditions numericEffects) {
        this.numericEffects = numericEffects;
    }

    /**
     * @param preconditions the preconditions to set
     */
    public void setPreconditions(Conditions preconditions) {
        this.preconditions = preconditions;
    }

    public abstract String toString();
}

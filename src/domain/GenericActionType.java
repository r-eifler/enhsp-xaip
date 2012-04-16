package domain;

import conditions.Conditions;

public abstract class GenericActionType extends Object {
    /**
     * @param addList the addList to set
     */
    public abstract void setAddList(Conditions addList);

    /**
     * @param delList the delList to set
     */
    public abstract void setDelList(Conditions delList);

    /**
     * @return the addList
     */
    public abstract Conditions getAddList();

    /**
     * @param name the name to set
     */
    public abstract void setName(String name);

    /**
     * @return the name
     */

    public abstract String getName();

    /**
     * @param numeric the numeric to set
     */
    public abstract void setNumeric(Conditions numeric);

    /**
     * @return the numeric
     */
    public abstract Conditions getNumeric();

    public abstract String toString();

    /**
     * @return the preconditions
     */
    public abstract Conditions getPreconditions();

    /**
     * @param preconditions the preconditions to set
     */
    public abstract void setPreconditions(Conditions preconditions);

    /**
     * @return the delList
     */
    public abstract Conditions getDelList();
    protected String name;
}

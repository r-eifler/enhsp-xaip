/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author enrico
 */
public class Variable extends Object {

    private String Name;
    private Type type;

    public Variable(String Name, Type type) {
        this.Name = Name;
        this.type = type;
    }

    public Variable(String text) {
        Name = text;

    }

    @Override
    public String toString() {

        return getName();

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.getName() != null ? this.getName().hashCode() : 0);
        hash = 97 * hash + (this.getType() != null ? this.getType().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Variable) {
            Variable o1 = (Variable) o;
            if ((o1.getName() == null ? this.getName() == null : o1.getName().equalsIgnoreCase(this.getName()))) {
                if (o1.getType() == this.getType()) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return false;


    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Type type) {
        this.type = type;
    }
}

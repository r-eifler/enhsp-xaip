/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conditions;

import domain.Type;
import domain.Variable;

/**
 *
 * @author enrico
 */
public class Term extends Conditions {
    private String name;
    private Type type;
    public Term(String n){
        name = n;
    }
    public Term(String n, Type atype){
        name = n;
        type = atype;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.getName() != null ? this.getName().hashCode() : 0);
        return hash;
    }
    @Override
    public boolean equals(Object o){
        if (o instanceof Variable){
            Variable o1 = (Variable)o;
            if ((o1.getName() == null ? this.getName() == null : o1.getName().equals(this.getName())))
                    return true;
                else
                    return false;
        }
        return false;
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
    public String toString(){
        String ret_val=null;

        ret_val = getName() + " " + type;

        return ret_val;
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
}

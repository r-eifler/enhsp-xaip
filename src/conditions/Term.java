/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conditions;

import domain.Type;
import domain.Variable;
import java.util.Map;
import problem.State;

/**
 *
 * @author enrico
 */
public class Term extends Conditions {
    private String name;
    private Type type;
    public Term(String n){
        grounded=true;
        name = n;
    }
    public Term(String n, Type atype){
        grounded=true;

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
        if (o instanceof Term){
            Term o1 = (Term)o;
            if ((o1.getName() == null ? this.getName() == null : o1.getName().equalsIgnoreCase(this.getName())))
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

    @Override
    public Term ground(Map substitution) {
        return new Term(name,type);
    }

    @Override
    public boolean eval(State s) {
        return true;
    }

    @Override
    public boolean isSatisfied(State s) {
        return true;
    }

    @Override
    public void changeVar(Map substitution) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

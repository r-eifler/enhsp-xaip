/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conditions;

import domain.Type;
import java.util.HashSet;
import java.util.Map;
import problem.RelState;
import problem.State;

/**
 *
 * @author enrico
 */
public class PDDLObject extends Conditions {

    private String name;
    private Type type;
    public HashSet son;

    public PDDLObject(String n) {
        grounded = true;
        name = n;
    }

    public PDDLObject(String n, Type atype) {
        grounded = true;

        name = n;
        type = atype;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof PDDLObject) {
            PDDLObject o1 = (PDDLObject) o;
            if ((o1.getName() == null ? this.getName() == null : o1.getName().equalsIgnoreCase(this.getName()))) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 29 * hash + (this.type != null ? this.type.hashCode() : 0);
        return hash;
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

    public String toString() {
        String ret_val = null;

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
    public PDDLObject ground(Map substitution) {
        return new PDDLObject(name, type);
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
    public boolean isSatisfied(RelState s) {
        return true;
    }

    @Override
    public void changeVar(Map substitution) {
        return;
    }

    @Override
    public String pddlPrint() {

        return this.getName() + " " + this.getType();
    }

    @Override
    public Conditions clone() {
//        PDDLObject ret = new PDDLObject(name,this.getType());
//        ret.grounded = this.grounded;
//        return ret;
        return this;
    }

    @Override
    public void normalize() {
        return;
    }

    @Override
    public Conditions clone() {
//        PDDLObject ret = new PDDLObject(name,this.getType());
//        ret.grounded = this.grounded;
//        return ret;
        return this;
    }
}

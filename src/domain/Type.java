/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

/**
 *
 * @author enrico
 */
public class Type extends Object{
    private String name;

    public Type(String text) {
        setName(text);
    }
    @Override
    public boolean equals(Object other){
        if (other instanceof Type){
            Type a = (Type)other;
            if (a.getName() == null ? this.getName() == null : a.getName().equals(this.getName()))
                return true;
            else
                return false;
        }
            return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + (this.getName() != null ? this.getName().hashCode() : 0);
        return hash;
    }
    public String toString(){
        return " " + getName() + " ";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

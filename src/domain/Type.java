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
    String name;

    Type(String text) {
        name = text;
    }
    @Override
    public boolean equals(Object other){
        if (other instanceof Type){
            Type a = (Type)other;
            if (a.name == null ? this.name == null : a.name.equals(this.name))
                return true;
            else
                return false;
        }
            return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }
    public String toString(){
        return " "+name+" ";
    }

}

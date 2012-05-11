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
    private Type subTypeOf;

    public Type(String text) {
        setName(text);
        if (!(text.equals("object"))){
            subTypeOf = new Type("object");
        }
        else{
            subTypeOf = null;
            
        }
    }
    public Type(String text, Type fatherType) {
        setName(text);
        subTypeOf = fatherType;
    }
    public boolean isObject(){
        if (name.equals("object"))
            return true;
        else
            return false;
    }
    public boolean isAncestorOf(Type anc){
        if (this.subTypeOf == null)
            return false;
        if (this.subTypeOf.equals(anc))
            return true;
        else{
            return subTypeOf.isAncestorOf(anc);
        }
    }
    @Override
    public boolean equals(Object other){
        if (other instanceof Type){
            Type a = (Type)other;
            if (a.getName() == null ? this.getName() == null : a.getName().equalsIgnoreCase(this.getName()))
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

    /**
     * @return the subTypeOf
     */
    public Type getSubTypeOf() {
        return subTypeOf;
    }

    /**
     * @param subTypeOf the subTypeOf to set
     */
    public void setSubTypeOf(Type subTypeOf) {
        this.subTypeOf = subTypeOf;
    }
}

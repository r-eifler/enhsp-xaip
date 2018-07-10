/* 
 * Copyright (C) 2010-2017 Enrico Scala. Contact: enricos83@gmail.com.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package com.hstairs.ppmajal.domain;

/**
 *
 * @author enrico
 */
public class Type extends Object {

    private String name;
    private Type subTypeOf;

    public Type(String text) {
        setName(text);
        if (!(text.equals("object"))) {
            subTypeOf = new Type("object");
        } else {
            subTypeOf = null;

        }
    }

    public Type(String text, Type fatherType) {
        setName(text);
        subTypeOf = fatherType;
    }

    public boolean isObject() {
        return name.equals("object");
    }

    public boolean isAncestorOf(Type anc) {
        if (anc.subTypeOf == null) {
            //System.out.println("NULL");
            return false;
        }
        if (anc.subTypeOf.equals(this)) {
            //System.out.println("UGUALE!!");
            return true;
        } else {
            return this.isAncestorOf(anc.subTypeOf);
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Type) {
            Type a = (Type) other;
            return a.getName() == null ? this.getName() == null : a.getName().equalsIgnoreCase(this.getName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + (this.getName() != null ? this.getName().hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return " - " + getName() + " ";
    }

    public String pddlString() {
        if (this.getSubTypeOf() != null) {
            return this.getName() + " - " + this.getSubTypeOf().getName() + " ";
        } else {
            return this.getName() + " - object ";
        }
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

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
package domain;

import conditions.PDDLObject;

import java.util.Map;

/**
 *
 * @author enrico
 */
public class Variable implements ActionParameter {

    private String Name;
    private Type type;

    public Variable(String Name, Type type) {
        super();
        this.Name = Name;
        this.type = type;
    }

    public Variable(String text) {
        super();
        Name = text;

    }

    public Variable() {
        super();
    }

    @Override
    public PDDLObject ground(Map<Variable, PDDLObject> substitution) {
        final PDDLObject o = substitution.get(this);

        if (o == null) {
            System.out.println("Substitution Failed for " + o.toString());
            System.exit(-1);
        }

        return o;
    }

    @Override
    public String toString() {

        return this.getName() + " " + this.getType();

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
                return o1.getType() == this.getType();
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

    public String pddlPrint() {

        return this.getName() + " " + this.getType();
    }

    public String pddlPrint(boolean typeInformation) {
        if (typeInformation) {
            return this.getName() + " " + this.getType();
        } else {
            return this.getName();
        }
    }

    public void pddlPrint(boolean typeInformation, StringBuilder bui) {
        bui.append(this.getName());
        if (typeInformation) {
            bui.append(" ").append(this.getType());
        }
    }
}

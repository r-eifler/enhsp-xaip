/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problem;

import conditions.PDDLObject;

import domain.Type;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author enrico
 */
public class PDDLObjects extends HashSet {

    public boolean validate(PDDLObject t) {

        for (Object el : this) {

            PDDLObject elP = (PDDLObject) el;
            if (elP.getName() == null ? t.getName() == null : elP.getName().equalsIgnoreCase(t.getName()));
            return true;
        }
        return false;
    }

    public Type getTermType(PDDLObject t) {
        for (Object el : this) {

            PDDLObject elP = (PDDLObject) el;
            if (elP.getName() == null ? t.getName() == null : elP.getName().equalsIgnoreCase(t.getName())) {
                return elP.getType();
            }
        }
        return null;
    }

    public PDDLObject containsTerm(PDDLObject t) {
        for (Object el : this) {

            PDDLObject elP = (PDDLObject) el;
            if (elP.getName() == null ? t.getName() == null : elP.getName().equalsIgnoreCase(t.getName())) {
                return elP;
            }
        }
        return null;
    }

    public String toString() {
        String ret_val = "";
        for (Object el : this) {
            PDDLObject elemento = (PDDLObject) el;
            ret_val += " " + elemento.toString() + " ";
        }

        return ret_val;
    }

    public String pddlPrint() {
        String ret = "(:objects \n";
        for (Object o : this) {
            PDDLObject obj = (PDDLObject) o;

            ret = ret + "   " + obj.pddlPrint() + "\n";
        }

        return ret + ")\n";
    }
}

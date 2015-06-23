
/*********************************************************************
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 * 
 *********************************************************************/

/*********************************************************************
 * Description: Part of the PPMaJaL library
 *             
 * Author: Enrico Scala 2013
 * Contact: enricos83@gmail.com
 *
 *********************************************************************/ 

package problem;

import conditions.PDDLObject;

import domain.Type;

import java.util.LinkedHashSet;

/**
 *
 * @author enrico
 */
public class PDDLObjects extends LinkedHashSet {

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

            ret = ret + "   " + obj.pddlPrint(true) + "\n";
        }

        return ret + ")\n";
    }
    
}

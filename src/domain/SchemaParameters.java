/**
 * *******************************************************************
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
 ********************************************************************
 */
/**
 * *******************************************************************
 * Description: Part of the PPMaJaL library
 *
 * Author: Enrico Scala 2013
 * Contact: enricos83@gmail.com
 *
 ********************************************************************
 */
package domain;

import conditions.PDDLObject;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author enrico
 */
public class SchemaParameters extends ArrayList {

    public Variable containsVariable(Variable o) {
        Iterator it = this.iterator();
        while (it.hasNext()) {
            Variable v = (Variable) it.next();
            if (v.getName() == null ? o.getName() == null : v.getName().equalsIgnoreCase(o.getName())) {
                return v;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String ret = "(";
        for (Object o : this) {
            Variable v = (Variable) o;
            //System.out.println(v.getName());
            ret += v.pddlPrint();

        }
        return ret + ")";

    }

    void mergeParameters(SchemaParameters a) {
        int counter = 0;
        for (Object o : a) {
            Variable obj = (Variable) o;
            boolean found = false;
            for (Object o1 : this) {
                Variable obj2 = (Variable) o1;
                if (obj2.getType().equals(obj.getType())) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                Variable obj3 = new Variable();
                obj3.setName(obj.getName() + counter);
                obj3.setType(obj.getType());
                //obj.setName(obj.getName()+counter);
                this.add(obj3);
                counter++;
            }

        }

    }

}

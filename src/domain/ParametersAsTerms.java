/**
 * *******************************************************************
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 *
 ********************************************************************
 */
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
public class ParametersAsTerms extends ArrayList {

    public PDDLObject containsTerm(PDDLObject o) {
        Integer ret_val = -1;
        Iterator it = this.iterator();
        while (it.hasNext()) {
            PDDLObject t = (PDDLObject) it.next();
            if (t.getName() == null ? o.getName() == null : t.getName().equalsIgnoreCase(o.getName())) {
                return t;
            }
        }
        return null;
    }

    public void addALLNewObjects(ParametersAsTerms a) {
        for (Object o : a) {
            PDDLObject obj = (PDDLObject) o;
            if (this.containsTerm(obj) == null) {
                this.add(obj);
            }
        }

    }

    public String pddlPrint() {
        String ret = "";

        for (Object o : this) {
            PDDLObject t = (PDDLObject) o;
            ret += t.pddlPrint(true);
        }

        return ret;
    }

}

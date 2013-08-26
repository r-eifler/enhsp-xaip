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
package domain;

import conditions.Conditions;

import expressions.Expression;

public abstract class GenericActionType extends Object {

    protected String name;
    protected Conditions addList;
    protected Conditions delList;
    protected Conditions numericEffects;
    protected Conditions preconditions;

    /**
     * @return the addList
     */
    public Conditions getAddList() {
        return addList;
    }

    /**
     * @return the delList
     */
    public Conditions getDelList() {
        return delList;
    }

    public String getName() {
        return name;
    }

    /**
     * @return the numericEffects
     */
    public Conditions getNumericEffects() {
        return numericEffects;
    }

    /**
     * @return the preconditions
     */
    public Conditions getPreconditions() {
        return preconditions;
    }

    /**
     * @param addList the addList to set
     */
    public void setAddList(Conditions addList) {
        this.addList = addList;
    }

    /**
     * @param delList the delList to set
     */
    public void setDelList(Conditions delList) {
        this.delList = delList;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param numericEffects the numericEffects to set
     */
    public void setNumericEffects(Conditions numericEffects) {
        this.numericEffects = numericEffects;
    }

    /**
     * @param preconditions the preconditions to set
     */
    public void setPreconditions(Conditions preconditions) {
        this.preconditions = preconditions;
    }

    public abstract String toString();
}

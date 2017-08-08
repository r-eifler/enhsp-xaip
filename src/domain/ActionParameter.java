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
package domain;

import conditions.PDDLObject;
import java.util.Map;

/**
 * An <b>action parameter</b> is either a variable (when the action is not
 * grounded) or a PDDL Object (i.e., a constant, when the action is grounded).
 *
 * @author Alban Grastien
 */
public interface ActionParameter {

    /**
     * Grounds this action parameter according to the specified map. Any
     * occurrence of a variable is replaced with the corresponding PDDL object
     * (fails if the variable does not appear in the map). PDDL objects are
     * unchanged.
     *
     * @param substitution the map that indicates what the variables should be
     * replaced with.
     * @return the grounding of this action parameter.
     */
    public PDDLObject ground(Map<Variable, PDDLObject> substitution);

}

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
 * Description: Part of the PPMaJaL library
 *
 * Author: Enrico Scala 2013 Contact: enricos83@gmail.com
 *
 ********************************************************************
 */
package search;

import conditions.Conditions;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import problem.GroundAction;

/**
 *
 * @author enrico
 */
public class Uniform_cost_search_H1_5 extends Uniform_cost_search_H1{

    public Uniform_cost_search_H1_5(Conditions G, Set<GroundAction> A) {
        super(G, A);
        try {
            this.add_redundant_constraints();
        } catch (Exception ex) {
            Logger.getLogger(Uniform_cost_search_H1_5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Uniform_cost_search_H1_5(Conditions goals, Set actions, HashSet processesSet) {
        super(goals, actions,processesSet);
        try {
            this.add_redundant_constraints();
        } catch (Exception ex) {
            Logger.getLogger(Uniform_cost_search_H1_5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
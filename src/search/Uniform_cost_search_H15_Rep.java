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

import conditions.Comparison;
import conditions.Conditions;
import conditions.Predicate;
import expressions.BinaryOp;
import expressions.PDDLNumber;
import extraUtils.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import problem.GroundAction;
import problem.State;

/**
 *
 * @author enrico
 */
public class Uniform_cost_search_H15_Rep extends Uniform_cost_search_H1_Rep {



    public Uniform_cost_search_H15_Rep(Conditions G, Set<GroundAction> A) {
        super(G, A);
        try {
            this.add_redundant_constraints();
        } catch (Exception ex) {
            Logger.getLogger(Uniform_cost_search_H1_5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    


}

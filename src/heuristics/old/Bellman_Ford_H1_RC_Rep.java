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
package heuristics.old;

import conditions.Conditions;
import java.util.LinkedHashSet;
import java.util.Set;
import problem.GroundAction;
//import gurobi.*;

/**
 *
 * @author enrico
 */
public class Bellman_Ford_H1_RC_Rep extends Bellman_Ford_H1_Rep {
   
    
    public Bellman_Ford_H1_RC_Rep(Conditions G, Set<GroundAction> A) throws Exception {
        super(G, A);
        this.G = G;
        this.A = (LinkedHashSet<GroundAction>) A;
        add_redundant_constraints();
        //System.out.println(this.orderings);
        //build_integer_representation();
        
    }
}
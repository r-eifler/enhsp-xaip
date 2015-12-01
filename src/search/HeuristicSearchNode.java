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

import java.util.Set;
import problem.GroundAction;

/**
 *
 * @author enrico
 */
class HeuristicSearchNode implements Comparable{

    public GroundAction action;
    public int goal_distance;
    public HeuristicSearchNode father;
    public int action_cost_to_get_here;
    public Set orderings;
    
    public HeuristicSearchNode(GroundAction action,HeuristicSearchNode father,int action_cost_to_get_here,int goal_distance){

        this.action = action;
        this.goal_distance = goal_distance;
        this.father = father;
        this.action_cost_to_get_here= action_cost_to_get_here;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HeuristicSearchNode other = (HeuristicSearchNode) obj;
        
        if (!this.action.equals(other.action) || this.action_cost_to_get_here != other.action_cost_to_get_here ) {
            return false;
        }
        return true;
    }
//
//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 89 * hash + (this.action != null ? this.action.hashCode() : 0);
//        return hash;
//    }


    @Override
    public int compareTo(Object o) {
        final HeuristicSearchNode other = (HeuristicSearchNode) o;
        if ((this.action_cost_to_get_here) == (other.action_cost_to_get_here))
            return 0;
        if ((this.action_cost_to_get_here) < (other.action_cost_to_get_here))
            return -1;
        else
            return +1;
    }
}

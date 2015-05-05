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

import java.util.Comparator;
import problem.GroundAction;
import problem.State;

/**
 *
 * @author enrico
 */
public class SearchNode implements Comparable{
    public State s;
    public GroundAction action;
    public int goal_distance;
    public SearchNode father;
    public int action_cost_to_get_here;
    public SearchNode(State s1, GroundAction action,SearchNode father,int action_cost_to_get_here,int goal_distance){
        s = s1;
        this.action = action;
        this.goal_distance = goal_distance;
        this.father = father;
        this.action_cost_to_get_here= action_cost_to_get_here;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SearchNode other = (SearchNode) obj;
        
        if (!this.s.equals(other.s)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Object o) {
        final SearchNode other = (SearchNode) o;
        if ((this.goal_distance+this.action_cost_to_get_here) == (other.goal_distance+other.action_cost_to_get_here))
            return 0;
        if ((this.goal_distance+this.action_cost_to_get_here) < (other.goal_distance+other.action_cost_to_get_here))
            return -1;
        else
            return +1;
    }
    
    
}

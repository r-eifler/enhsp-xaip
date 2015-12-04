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

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import problem.GroundAction;
import problem.State;

/**
 *
 * @author enrico
 */
public class SearchNode implements Comparable {

    public State s;
    public GroundAction action;
    public int goal_distance;
    public SearchNode father;
    public float action_cost_to_get_here;
    public JSONObject json_rep;
    public int reacheable_condition;
    private boolean break_ties_on_reacheable_conditions;

    public SearchNode(State s1, GroundAction action, SearchNode father, float action_cost_to_get_here, int goal_distance) {
        s = s1;
        this.action = action;
        this.goal_distance = goal_distance;
        this.father = father;
        this.action_cost_to_get_here = action_cost_to_get_here;
        json_rep = null;
        reacheable_condition = 0;
    }

    public SearchNode(State s1, GroundAction action, SearchNode father, float action_cost_to_get_here, int goal_distance, boolean saving_json) {
        s = s1;
        this.action = action;
        this.goal_distance = goal_distance;
        this.father = father;
        this.action_cost_to_get_here = action_cost_to_get_here;
        reacheable_condition = 0;

        if (saving_json) {
            json_rep = new JSONObject();
            if (action == null) {
                json_rep.put("action", "init_state");
            } else {
                json_rep.put("action", action.toEcoString());
            }
            json_rep.put("distance", goal_distance);
            json_rep.put("action_cost_to_get_here", action_cost_to_get_here);
            if (father == null) {
                json_rep.put("ancestor", "init_state");
            } else {
                json_rep.put("ancestor", father.json_rep.get("visited_step"));
            }
            json_rep.put("visited", false);
            json_rep.put("visit_step", -1);
            json_rep.put("descendants", new JSONArray());
        } else {
            json_rep = null;
        }

    }

    public SearchNode(State s1, GroundAction action, SearchNode father, float action_cost_to_get_here, int goal_distance, boolean saving_json, int reacheable_conditions) {
        s = s1;
        this.action = action;
        this.goal_distance = goal_distance;
        this.father = father;
        this.action_cost_to_get_here = action_cost_to_get_here;
        this.reacheable_condition = reacheable_condition;
        if (saving_json) {
            json_rep = new JSONObject();
            if (action == null) {
                json_rep.put("action", "init_state");
            } else {
                json_rep.put("action", action.toEcoString());
            }
            json_rep.put("distance", goal_distance);
            json_rep.put("action_cost_to_get_here", action_cost_to_get_here);
            if (father == null) {
                json_rep.put("ancestor", "init_state");
            } else {
                json_rep.put("ancestor", father.json_rep.get("visited_step"));
            }
            json_rep.put("visited", false);
            json_rep.put("visit_step", -1);
            json_rep.put("descendants", new JSONArray());
        } else {
            json_rep = null;
        }

    }

    public void add_descendant(SearchNode desc) {
        JSONArray descendants = (JSONArray) json_rep.get("descendants");
        descendants.add(desc.json_rep);
    }

    public void set_visited(int visit_step) {
        json_rep.put("visited", true);
        json_rep.put("visit_step", visit_step);
    }

    public void print_json(String file_name) {
        FileWriter file = null;
        try {
            file = new FileWriter(file_name);
            //System.out.println(this.json_rep.toJSONString());
            file.write(this.json_rep.toJSONString());
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(SearchNode.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Successfully Copied JSON Object to File...");
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
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (this.s != null ? this.s.hashCode() : 0);
        hash = 29 * hash + (this.action != null ? this.action.hashCode() : 0);
        hash = 29 * hash + this.goal_distance;
        hash = 29 * hash + (this.father != null ? this.father.hashCode() : 0);
        hash = 29 * hash + (int) this.action_cost_to_get_here;
        return hash;
    }

//    @Override
//    public int hashCode() {
//        int hash = 5;
//        hash = 43 * hash + (this.s != null ? this.s.hashCode() : 0);
//        hash = 43 * hash + (this.action != null ? this.action.hashCode() : 0);
//        hash = 43 * hash + this.goal_distance;
//        hash = 43 * hash + (this.father != null ? this.father.hashCode() : 0);
//        hash = 43 * hash + this.action_cost_to_get_here;
//        return hash;
//    }
    @Override
    public int compareTo(Object o) {
        final SearchNode other = (SearchNode) o;
        if ((this.goal_distance + this.action_cost_to_get_here) == (other.goal_distance + other.action_cost_to_get_here)) {
            if (this.reacheable_condition < other.reacheable_condition) {
                System.out.println("then It can happen!");
                return +1;
            } else if (this.reacheable_condition > other.reacheable_condition) {
                System.out.println("then It can happen!");
                return -1;
            } else {
                return 0;
            }
        }
        if ((this.goal_distance + this.action_cost_to_get_here) < (other.goal_distance + other.action_cost_to_get_here)) {
            return -1;
        } else {
            return +1;
        }
    }

}
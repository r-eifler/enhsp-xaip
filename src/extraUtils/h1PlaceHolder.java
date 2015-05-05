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
package extraUtils;

import conditions.AndCond;
import conditions.Comparison;
import conditions.Conditions;
import conditions.Predicate;
import java.util.HashMap;
import java.util.Set;
import problem.GroundAction;
import problem.State;

/**
 *
 * @author enrico
 */
public class h1PlaceHolder {
    static HashMap<Conditions, Integer> h1 = new HashMap();//lookup table for memoization
    public static void reset(){
        h1 = new HashMap();
    }
    public static int computeH1(State init, Conditions c, Set<GroundAction> a, HashMap visited, int level,boolean maxHeuristic) throws Exception {
        //System.out.println(c);
        if (c == null)//shouldn't happen
        {
            return 0;
        }
        c.normalize();//this simplifies the distance, and the reasoning in general
        if (h1.get(c) != null) {//this captures only comparison. Should be done something more efficient reasoning on complex condition..
            //System.out.println("Debug: come back immediately");
            return h1.get(c);
        }
        if (init.satisfy(c)) {
            return 0;
        } else {
            if (c instanceof Comparison) {
                int min = Integer.MAX_VALUE;
                //the following checks loops. If there is a loop this means that there is a better solution so stop keep going from here
                if (visited.get(c) != null) {
                    if ((Boolean) visited.get(c) == true) {
//                        System.out.println(visited);
//                        System.out.println(c);
                        //System.out.println("Loop Detected for numeric constraints");
                        return min;
                    }
                }
                boolean noActions = false;//checks if there is at least an action that may be useful to achieve the comparison
                for (GroundAction act : a) {

                    if (act.improve(init, (Comparison) c)) {//The action contributes in satisfying the constraint
//                        System.out.println(c);
//                        System.out.println(act+" Seems to be good");
                        noActions = false;
                        //newC is the set of conditions to satisfy for having c achieved through action act
                        Conditions newC = act.regressNew(c.clone());

                        visited.put(c, true);//check for loop
                        //subcost is the cost for satisfying the arising conditions
                        int subcost = computeH1(init, newC, a, visited, level + 1,maxHeuristic);
                        //if the is no way of satysfying the arising conditions, stop and process the next action (if any)
//                        System.out.println("The cost is :"+subcost);
                        if (subcost == Integer.MAX_VALUE) {//the problem is unsolvable using this action
                            continue;
                        } else {//add the cost of the action to the path to satisfy its condition
                            subcost += 1;
                        }
                        if (subcost < min) {//take the action minimizing this cost
                            min = subcost;
                        }
                    }
                }
                
                //System.out.println(c);
                if (noActions) {
                    h1.put(c, min);//memoization of the computed solutions
                    return Integer.MAX_VALUE;
                }
//                    System.out.println("Cut-off");//this should be modified to take into account indirect effects
//                    min = 2;//This is a little bit stronger and too optimistic. It basically consider that there should be at least a chain of two actions to make that constraint satisfied
//                }
                h1.put(c, min);//memoization of the computed solution
                return min;
            } else if (c instanceof Predicate) {
                Predicate p = (Predicate) c;
                int min = Integer.MAX_VALUE;
                if (!(visited.get(c) == null || (Boolean)visited.get(c) == false)) {
                    return min;
                }
                for (GroundAction act : a) {
                    if (act.achieve(p)) {//for the propositional case it suffices to look at the add list
                        visited.put(c, true);
                        int temp = computeH1(init, act.getPreconditions(), a, visited, level + 1,maxHeuristic);
                        if (temp == Integer.MAX_VALUE) {
                            continue;
                        } else {
                            temp += 1;
                        }
                        if (temp < min) {
                            min = temp;
                        }
                    }
                }
                h1.put(p, min);
                return min;
            } else if (c instanceof AndCond) {
                int max = Integer.MIN_VALUE;//max heuristic
                //max = 0; //sum
                //System.out.println(c);

                if (maxHeuristic) {
                    //System.out.println("Evaluating the Max!");
                    for (Object o : c.sons) {
                        Conditions c1 = (Conditions) o;
                        int temp = computeH1(init, c1, a, visited, level + 1,maxHeuristic);
                        //System.out.println("The cost for "+c1+" is "+temp);
                        if (temp > max) {
                            max = temp;
                        }
                    }
                } else {
                    //System.out.println("Evaluating the Sum!");
                    max = 0;
                    for (Object o : c.sons) {
                        Conditions c1 = (Conditions) o;
                        int temp = computeH1(init, c1, a, visited, level + 1,maxHeuristic);
                        if (temp == Integer.MAX_VALUE) {
                            return Integer.MAX_VALUE;
                        }
                        max += temp;
                    }
                }
                h1.put(c, max);
                return max;
            } else {
                System.out.println("Operation not supported");
                System.exit(-1);
            }
            return Integer.MAX_VALUE;

        }
    }
}

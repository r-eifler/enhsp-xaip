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

import conditions.AndCond;
import conditions.Comparison;
import conditions.Conditions;
import conditions.Predicate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import problem.GroundAction;
import problem.State;

/**
 *
 * @author enrico
 */
public class Heuristics {
    
    static public LinkedHashSet usefulActions = new LinkedHashSet();;
    
    public static int computeH1(State init, Conditions c, Set<GroundAction> a, HashMap visited, int level,boolean maxHeuristic, HashMap<Conditions, Integer> h1,HashMap achievers) throws Exception {
        //System.out.println(c);
        if (h1==null){
            h1 = new HashMap();
        }
        if (c == null)//shouldn't happen
        {
            System.out.println("Some errors");
            return 0;
        }
        c.normalize();//this simplifies the distance, and the reasoning in general
        if (init.satisfy(c)) {
            return 0;
        }
        if (h1.get(c) != null) {//this captures only comparison. Should be done something more efficient reasoning on complex condition..
            //System.out.println("Memoization");
            return h1.get(c);
        } else {
            if (c instanceof Comparison) {
                int min = Integer.MAX_VALUE;
                //the following checks loops. If there is a loop this means that there is a better solution so stop keep going from here
                if (visited.get(c) != null) {
                    if ((Boolean) visited.get(c) == true) {
                        return Integer.MAX_VALUE;
                    }
                }
                boolean noActions = true;//checks if there is at least an action that may be useful to achieve the comparison
                GroundAction best = null;
                HashMap visitUpdated = null;

                for (GroundAction act : a) {
                    if (act.improve(init, (Comparison) c)) {//The action contributes in satisfying the constraint
//                        System.out.println(c);
//                        System.out.println(act+" Seems to be good");
                        noActions = false;
                        //newC is the set of conditions to satisfy for having c achieved through action act
                        Conditions newC = act.regressNew(c.clone());
                        visited.put(c, true);//check for loop
                        //subcost is the cost for satisfying the arising conditions
                        HashMap visitToExplore = new HashMap();
                        visitToExplore.putAll(visited);  
                        int temp = computeH1(init, newC, a, visitToExplore, level + 1,maxHeuristic,h1,achievers);
                        //if the is no way of satysfying the arising conditions, stop and process the next action (if any)
//                        System.out.println("The cost is :"+subcost);
                        if (temp != Integer.MAX_VALUE) {
                            temp += 1;
                            if (temp < min) {
                               min = temp;
                               best = act;
                            }
                        }
                    }
                }
                if (best!=null){
                    usefulActions.add(best);
                    visited = visitUpdated;

                }else{
                    if (noActions){
                       h1.put(c, Integer.MAX_VALUE); 
                    }
                    h1.put(c, Integer.MAX_VALUE); 
                    return Integer.MAX_VALUE;
                }
                h1.put(c, min);//memoization of the computed solution
                return min;
            } else if (c instanceof Predicate) {
                Predicate p = (Predicate) c;
                int min = Integer.MAX_VALUE;
                if (visited.get(c) != null && (Boolean)visited.get(c)==true) {
                    //h1.put(c, Integer.MAX_VALUE);
                    return Integer.MAX_VALUE;
                }
                boolean noActions = true;//checks if there is at least an action that may be useful to achieve the comparison
                GroundAction best = null;
                HashMap visitUpdated = null;
                HashSet ach = (HashSet)achievers.get(p);
                
                for (Object t : ach) {//for optimizing put just the achievers
                    GroundAction act = (GroundAction)t;
                    //if (act.achieve(p)) {//for the propositional case it suffices to look at the add list
                        visited.put(c, true);  
                        HashMap visitToExplore = new HashMap();
                        visitToExplore.putAll(visited);                               
                        int temp = computeH1(init, act.getPreconditions(), a, visitToExplore, level + 1,maxHeuristic,h1,achievers);
                        if (temp != Integer.MAX_VALUE ) {
                            temp += 1;
                            if (temp < min) {
                               min = temp;
                               best = act;
                            }
                        }
                        noActions=false;
                    //}
                }
                
                if (best!=null){
                    usefulActions.add(best);
                    visited = visitUpdated;
                }else{
                    if (noActions)
                        h1.put(c, Integer.MAX_VALUE);
                    //h1.put(c, Integer.MAX_VALUE); 

                    return Integer.MAX_VALUE;
                }
                h1.put(c, min);
                return min;
            } else if (c instanceof AndCond) {
                int max = Integer.MIN_VALUE;//max heuristic
                //max = 0; //sum
                //System.out.println(c);
                if (maxHeuristic) {
                    //System.out.println("Evaluating the Max!");
                    for (Object o : c.sons) {
                        Conditions c1 = (Conditions) o;
                        HashMap visitToExplore = new HashMap();
                        visitToExplore.putAll(visited);   
 
                        int temp = computeH1(init, c1, a, visited, level + 1,maxHeuristic,h1,achievers);
                        //System.out.println("The cost for "+c1+" is "+temp);
                        if (temp == Integer.MAX_VALUE) {
                            return Integer.MAX_VALUE;
                        }
                        if (temp > max) {
                            max = temp;
                        }
                    }
                } else {
                    //System.out.println("Evaluating the Sum!");
                    max = 0;
                    for (Object o : c.sons) {
                        Conditions c1 = (Conditions) o;
                        HashMap visitToExplore = new HashMap();
                        visitToExplore.putAll(visited);  
                        //System.out.println("Why?"+visited.get(c1));
                        int temp = computeH1(init, c1, a, visited, level + 1,maxHeuristic,h1,achievers);
                        if (temp == Integer.MAX_VALUE) {
                            if (level == 0){
                                ///System.out.println("the following cannot be made true:"+c1);
                                //System.out.println("Why?"+visited.get(c1));
                                //System.out.println("Why?"+h1.get(c1));
                            }
                            return Integer.MAX_VALUE;
                        }
                        max += temp;
                    }
                }
                //h1.put(c, max);
                return max;
            } else {
                System.out.println("Condition not supported");
                System.exit(-1);
            }
            return Integer.MAX_VALUE;

        }
    }
    
    
    
}

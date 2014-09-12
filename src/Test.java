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

import computation.NumericKernel;
import computation.NumericPlanningGraph;
import conditions.AndCond;
import conditions.Conditions;
import conditions.Predicate;
import domain.PddlDomain;
import java.util.Map;
import java.util.Set;
import plan.SimplePlan;
import problem.PddlProblem;

public class Test {

    /**
     * @param args Call the program by passing domain and problem pddl files
     * @throws Exception Nothing
     */
    public static void main(String[] args) throws Exception {


        //Controlling the input files
        if (args.length < 2) {
            System.out.println("Usage: ... domain problem [optionally] problem resaved");
            System.exit(-1);
        }

        {
            PddlDomain domain = new PddlDomain();
            PddlProblem problem = new PddlProblem();
            NumericKernel nk = new NumericKernel();
            
           
            domain.parseDomain(args[0]);
            problem.parseProblem(args[1]);
            domain.validate(problem);
            System.out.println("Domain and Problem Parsed");
            problem.generateActions();
            System.out.println("Actions Number:" + problem.getActions().size());
            SimplePlan p = new SimplePlan(domain,problem,true);
            
            NumericPlanningGraph ngr = new NumericPlanningGraph();
            
            Map<Predicate,Set<Predicate>> LM =ngr.findLandmarks(problem.getInit(), (AndCond)problem.getGoals(), problem.getActions());
            
            for (Object o: problem.getGoals().sons){
                if (o instanceof Predicate){
                    Predicate g = (Predicate)o;
                    //System.out.println(g);
                    System.out.println("LM("+g+"): "+ LM.get(g));
                    System.out.println("FA("+g+"): "+ ngr.firstAchiever.get(g));
                    
                }
                
                
            }
            
            
            
            
            findJustification(problem.getGoals(),LM);

                
            
            
            //finding justification:
            
            
            //int i = Integer.parseInt(args[1]);

        }
    }

    private static void findJustification(Conditions goals, Map<Predicate, Set<Predicate>> LM) {
        
        
    }
}

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
import conditions.AndCond;
import domain.PddlDomain;
import plan.SimplePlan;
import planners.metricFFWrapper;
import problem.PddlProblem;
import problem.State;

public class Test {

    /**
     * @param args Call the program by passing domain and problem pddl files
     * @throws Exception Nothing
     */
    public static void main(String[] args) throws Exception {


        //Controlling the input files
        if (args.length < 2) {
            System.out.println("Usage: ... domain problem plan");
            System.exit(-1);
        }

        {
            PddlDomain a = new PddlDomain();
            PddlProblem p = new PddlProblem();

            String domainFile = "zenonumeric.pddl";
            
            
            a.parseDomain(domainFile);
            //int i = Integer.parseInt(args[1]);
            for (int i = 1; i < 10; i++) {
                String problemFile = "p" + Integer.toString(i) ;
                p.parseProblem(problemFile);
                //a.prettyPrint();
                //p.prettyPrint();
                metricFFWrapper ff = new metricFFWrapper();

                SimplePlan sp = new SimplePlan(a, p);



                //sp.parseSolution(ff.plan("zenonumeric.pddl", "p" + Integer.toString(i)));
                sp.parseSolution(ff.plan(domainFile, problemFile));
                
                NumericKernel nk = new NumericKernel();
                nk.construct(sp, p.getGoals());
                
                System.out.println("Check Numeric Kernel:"+ p.getInit().satisfy((AndCond)nk.get(0)));
            }
        }
    }
}


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
import computation.DomainEnhancer;
import computation.NumericKernel;
import domain.ActionSchema;
import domain.PddlDomain;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import plan.SimplePlan;
import problem.GroundAction;

public class Test {

    /**
     * @param args Call the program by passing domain and problem pddl files
     * @throws Exception Nothing
     */
    public static void main(String[] args) throws Exception {

        //Controlling the input files
        if (args.length < 2) {
            System.out.println("Usage: ... domain plan1 plan2 ...");
            System.exit(-1);
        }

        {
            PddlDomain domain = new PddlDomain();
            NumericKernel nk = new NumericKernel();
            domain.parseDomain(args[0]);
            //problem.parseProblem(args[1]);
            //domain.validate(problem);
            //System.out.println("Domain and Problem Parsed");

            //GroundAction a = null;
            
            DomainEnhancer dnh = new DomainEnhancer();
            List l = new ArrayList();
            for (int planIndex = 1; planIndex < args.length; planIndex++) {
                SimplePlan sp = new SimplePlan(domain);
                sp.parseSolutionWithoutProblem(args[planIndex]);
                GroundAction macro = new GroundAction();
                for (GroundAction gr : sp) {
                    macro = macro.buildMacroInProgression(gr, domain);
                    //System.out.println("Macro:"+ macro);

                    
                }
                ActionSchema aU = macro.unGround();
                l.add(aU);
            }
            
            
            int counter = 0;
            for (Object o: l){
                ActionSchema gr = (ActionSchema)o;
                
                try {
                    BufferedWriter w = new BufferedWriter(new FileWriter("macro"+counter, false));
                    w.write(gr.toString());
                    w.close();
                } catch (IOException ex) {
                //Logger.getLogger(this.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(gr.toString());
                counter++;
            }
            
            //System.out.println(l);
            
//            
            dnh.addMacroOperators2(domain, l, null);
//            
            //System.out.println("Enhanced Domain is:" + dnh.getDomainEnhancedFileName());

//            domain.parseDomain(args[0]);
//            problem.parseProblem(args[1]);
//            domain.validate(problem);
//            System.out.println("Domain and Problem Parsed");
//            problem.generateActions();
//            System.out.println("Actions Number:" + problem.getActions().size());
//            SimplePlan p = new SimplePlan(domain,problem,true);
//            
//            NumericPlanningGraph ngr = new NumericPlanningGraph();
//            
//            System.out.println(ngr.computeRelaxedPlan(problem.getInit(), problem.getGoals(), problem.getActions()).size());            
//            Map<Predicate,Set<Predicate>> LM =ngr.findLandmarks(problem.getInit(), (AndCond)problem.getGoals(), problem.getActions());
//            
//            for (Object o: problem.getGoals().sons){
//                if (o instanceof Predicate){
//                    Predicate g = (Predicate)o;
//                    //System.out.println(g);
//                    System.out.println("LM("+g+"): "+ LM.get(g));
//                    System.out.println("FA("+g+"): "+ ngr.firstAchiever.get(g));
//                    
//                }
//                
//                
//            }
//            
//            
//            
//            
//            findJustification(problem.getGoals(),LM);
            //finding justification:
            //int i = Integer.parseInt(args[1]);
        }
    }

}


import conditions.AndCond;
import conditions.Conditions;
import conditions.Predicate;
import domain.ActionSchema;
import domain.PddlDomain;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.antlr.runtime.RecognitionException;
import plan.SimplePlan;
import planners.metricFFWrapper;
import problem.GroundAction;
import problem.PddlProblem;

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
/**
 *
 * @author enrico
 */
public class printLastState {

    private static String domainFile;
    private static String problemFile;
    private static String planFile;
    private static HashMap<ActionSchema, Set<Conditions>> action_to_entaglement_by_init;
    private static HashMap<ActionSchema, Set<Conditions>> action_to_entaglement_by_goal;

    public static void parseInput(String[] args) {

        domainFile = args[0];
        problemFile = args[1];
        if (args.length > 2) {
            planFile = args[2];
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, RecognitionException, antlr.RecognitionException, Exception {

        parseInput(args);

        PddlDomain dom = new PddlDomain();
        dom.parseDomain(domainFile);

        PddlProblem prob = new PddlProblem();
        prob.setDomain(dom);
        prob.parseProblem(problemFile);
        dom.validate(prob);
        //System.out.println(dom.getActionsSchema());
        metricFFWrapper p = new metricFFWrapper();
        p.setTimeout(100000);
        SimplePlan sp = new SimplePlan(dom, prob, true);
        
        if (planFile == null){
            sp.parseSolution(p.plan(domainFile, problemFile));
            sp.savePlan(problemFile+".sol");

        }else{
            sp.parseSolution(planFile);
        }
        
        sp.printLastPredictedState(0, prob.getInit().clone());
        System.out.println(sp.execute(prob.getInit()).satisfy(prob.getGoals()));
   
        //System.out.println(action_to_entaglement_by_init);

    }

}

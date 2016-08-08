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

package adaptation;

import antlr.RecognitionException;
import some_computatitional_tool.DomainEnhancer;
import some_computatitional_tool.NumericKernel;
import some_computatitional_tool.NumericPlanningGraph;
import conditions.Conditions;
import domain.PddlDomain;
import extraUtils.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jgrapht.alg.BiconnectivityInspector;
import org.jgrapht.alg.TransitiveClosure;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.AsUndirectedGraph;
import plan.SimplePlan;
import wrapped_planners.metricFFWrapper;
import wrapped_planners.planningTool;
import problem.GroundAction;
import problem.PDDLObjects;
import problem.PddlProblem;
import problem.RelState;
import problem.State;

/**
 *
 * @author enrico
 */
public class PlanAdapter {

    //wrapper for external planning tool
    protected planningTool planner;
    
    //statistics informations
    private long kernelConstructionTime;
    protected int plannerTime;
    private long adaptationTime;
    private long heuristicComputationTime;
    protected long macroActionsConstructionTime;
    
    //if true, use kernel heuristic repair instead of greedy repair. See AIXIA 2013, Enrico Scala article
    private boolean kernelHeuristicRepair;
    
    //The solution container
    protected SimplePlan solution;
    //public boolean debuggingMacrioActionConstructionBench;
    
    //number of macro actions exploited for performing the repair
    private int employedMacros;
    
    //upper bound on the number of primitives to use
    private int max_primitives;
    
    //reacheable States
    private RelState poss_state;
    private int connectedComponentsNumber;
    private int uselessActionPruning;

    /**
     * Get the value of employedMacros
     *
     * @return the value of employedMacros
     */
    public int getEmployedMacros() {
        return employedMacros;
    }

    /**
     * Set the value of employedMacros
     *
     * @param employedMacros new value of employedMacros
     */
    public void setEmployedMacros(int employedMacros) {
        this.employedMacros = employedMacros;
    }


    /**
     * Get the value of solution
     *
     * @return the value of solution
     */
    public SimplePlan getSolution() {
        return solution;
    }

    /**
     * Set the value of solution
     *
     * @param solution new value of solution
     */
    public void setSolution(SimplePlan solution) {
        this.solution = solution;
    }

    /**
     * Get the value of macroActionsConstructionTime
     *
     * @return the value of macroActionsConstructionTime
     */
    public long getMacroActionsConstructionTime() {
        return macroActionsConstructionTime;
    }

    /**
     * Set the value of macroActionsConstructionTime
     *
     * @param macroActionsConstructionTime new value of
 macroActionsConstructionTime
     */
    public void setMacroActionsConstructionTime(long macroActionsConstructionTime) {
        this.macroActionsConstructionTime = macroActionsConstructionTime;
    }

    /**
     * Constructor for the plan adapter. 
     * @param planner: the planner used as black box for performing specific local repair tasks
     */
    public PlanAdapter(planningTool planner) {
        this.planner = planner;
        solution = null;
        planner.setTimeout(100000);
        uselessActionPruning = 0;
    }

    /**
     * Adapt the plan by using the Greedy Repair Strategy
     * @param domain The PDDL domain of reference
     * @param problem The problem the plan bust be adapted to
     * @param input_plan The plan from which the repair process is started
     * @return the plan repaired or null in case of no solution (for any reasons...the motivation is due to the planning tool)
     * @throws FileNotFoundException
     * @throws Exception
     */
    public SimplePlan adaptViaFirstKernel_GreedyRepair(PddlDomain domain, PddlProblem problem, SimplePlan input_plan) throws FileNotFoundException, Exception {
        this.kernelHeuristicRepair = false;
        return this.adaptKernelBasedMethod(domain, problem, input_plan);
    }

    private SimplePlan adaptKernelBasedMethod(PddlDomain dom, PddlProblem prob, SimplePlan sp) throws FileNotFoundException, Exception {

        try {
            //Kernel Construction; mandatory for both strategies
            NumericKernel nk = new NumericKernel();
            /**/            long start = System.currentTimeMillis();
            nk.construct(sp, prob.getGoals());
            /**/            setKernelConstructionTime(System.currentTimeMillis() - start);

            //Selecting the best kernel!
            int i = 0;
            if (kernelHeuristicRepair) {
                start = System.currentTimeMillis();
                i = this.findBestKernel(prob, nk, 0);
                this.setHeuristicComputationTime(System.currentTimeMillis() - start);
            }

            //Temporary Problem to emulate a new goal in a PDDL problem description
            PddlProblem tempProblem = new PddlProblem();
            tempProblem.parseProblem(prob.getPddlFilRef());
            tempProblem.setGoals((Conditions) nk.get(i));
            tempProblem.saveProblem("temp.pddl");

            //Computing the patch toward the kernel by means of a general purpose planner
            SimplePlan sp2 = new SimplePlan(dom, tempProblem);
            String solutionString = planner.plan(dom.getPddlFilRef(), "temp.pddl");
            
            //delete the temporary problem...a kind of garbage collector
            new File("temp.pddl").delete();
            if (solutionString == null) {
                return null;
            }
            
            //parse the solution patch and after delete it
            sp2.parseSolution(solutionString);
            new File(solutionString).delete();
            
            setPlannerTime(planner.getPlannerTime());
            if (kernelHeuristicRepair) {
                setAdaptationTime(this.plannerTime + this.kernelConstructionTime + this.heuristicComputationTime);
            } else {
                setAdaptationTime(this.plannerTime + this.kernelConstructionTime);
            }

            //concatenation with the previous solution
            //in case of greedyrepair, the index i=0
            sp2.addAll(sp.subList(i, sp.size()));
            
            //storing the solution "permanently" within this object
            solution = sp2;
            return sp2;

        } catch (IOException ex) {
            Logger.getLogger(PlanAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RecognitionException ex) {
            Logger.getLogger(PlanAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (org.antlr.runtime.RecognitionException ex) {
            Logger.getLogger(PlanAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(PlanAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //function to evaluate which is the best kernel. This function exploits a variant of numeric kernel heuristic to support multiple conditions
    private int findBestKernel(PddlProblem problem, NumericKernel kerns, int i) throws CloneNotSupportedException {
        
        
        NumericPlanningGraph gr;
        int closer = i;
        int closerDistance = Integer.MAX_VALUE;

        gr = new NumericPlanningGraph();
        //compute a relaxed plan for each kernel starting from the init. Then the function gets a map (order2) 
        //between kernel and the distance given by the size of such plans.
        Map order2 = gr.computeRelaxedPlans(problem.getInit(), kerns, problem.getActions(), i);
        //System.out.println(order2);
        for (Object o : order2.keySet()) {
            int candidate = (Integer) o;
            int distance = (Integer) order2.get(o);
            if (distance < closerDistance) {
                closer = candidate;
                closerDistance = distance;
            }
            if (distance <= 1) {
                break;
            }
        }
        setHeuristicComputationTime(gr.getCpu_time());
        return closer;
    }

    /**
     * Adapt the plan by using the Heuristic Kernel Repair Strategy
     * @param domain The PDDL domain of reference
     * @param problem The problem the plan bust be adapted to
     * @param input_plan The plan from which the repair process is started
     * @return the plan repaired or null in case of no solution (for any reasons...the motivation is due to the planning tool)
     * @throws FileNotFoundException
     * @throws Exception
     */
    public SimplePlan adaptViaBestKernel_HeuristicKernelRepair(PddlDomain domain, PddlProblem problem, SimplePlan input_plan) throws FileNotFoundException, Exception {

        this.kernelHeuristicRepair = true;
        return this.adaptKernelBasedMethod(domain, problem, input_plan);
    }

    /**
     * Adapt the plan by using Macro Action Repair; the input plan is considered as a single macro action
     * @param domain The PDDL domain of reference
     * @param problem The problem the plan bust be adapted to
     * @param input_plan The plan from which the repair process is started
     * @return the plan repaired or null in case of no solution (for any reasons...the motivation is due to the planning tool)
     * @throws FileNotFoundException
     * @throws Exception
     */
    public SimplePlan adaptViaMacroAction(PddlDomain domain, PddlProblem problem, SimplePlan input_plan) {
        try {
            //Preprocessing. Computing the enhanced domain by adding the previous plan as macro action
            /**/            long start = System.currentTimeMillis();
            DomainEnhancer dEnh = new DomainEnhancer();
            GroundAction macro = input_plan.generateMacro(0, input_plan.size() - 1);
            //System.out.println("Dist(macro,problem):"+macro.computeDistance(prob));
            
            //the model of the action is simplified according to the domain and the problem at hand
            macro.simplifyModel(domain, problem);
            
            //the domain is reformulated by adding the plan as macro action; this yelds the enhanced domain representation
            dEnh.addMacroOperator(domain, macro);
            /**/            macroActionsConstructionTime = System.currentTimeMillis() - start;

            //planning using the enhanced domain
            PddlDomain temp = new PddlDomain(dEnh.getDomainEnhancedFileName());
            SimplePlan temp_new_plan = new SimplePlan(temp, problem, false);
            String solutionString = planner.plan(temp.getPddlFilRef(), problem.getPddlFilRef());
            if (solutionString == null) {
                return null;
            }
            temp_new_plan.parseSolution(solutionString);
            
            new File(solutionString).delete();
            //new File(dEnh.getDomainEnhancedFileName()).delete();

            //in case the planning was successfull, rebuild the solution by decomposing the macro-operator
            SimplePlan new_plan = new SimplePlan(domain, problem);
            for (GroundAction gr : (ArrayList<GroundAction>) temp_new_plan) {
                if (gr.getName().equalsIgnoreCase(macro.getName())) {
                    //System.out.println("#primitives: " + macro.getPrimitives().size());
                    for (GroundAction primitive_action : (ArrayList<GroundAction>) macro.getPrimitives()) {
                        new_plan.add(primitive_action);
                    }
                    setEmployedMacros(1);
                } else {
                    new_plan.add(gr);
                }
            }
            setPlannerTime(planner.getPlannerTime());
            this.setAdaptationTime(plannerTime + macroActionsConstructionTime);
            solution = new_plan;

            return new_plan;
        } catch (Exception ex) {
            Logger.getLogger(PlanAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Get the value of planner
     *
     * @return the value of planner
     */
    public planningTool getPlanner() {
        return planner;
    }

    /**
     * Set the value of planner
     *
     * @param planner new value of planner
     */
    public void setPlanner(planningTool planner) {
        this.planner = planner;
    }

    /**
     * @return the kernelConstructionTime
     */
    public long getKernelConstructionTime() {
        return kernelConstructionTime;
    }

    /**
     * @param kernelConstructionTime the kernelConstructionTime to set
     */
    public void setKernelConstructionTime(long kernelConstructionTime) {
        this.kernelConstructionTime = kernelConstructionTime;
    }

    /**
     * @return the plannerTime
     */
    public int getPlannerTime() {
        return plannerTime;
    }

    /**
     * @param plannerTime the plannerTime to set
     */
    public void setPlannerTime(int plannerTime) {
        this.plannerTime = plannerTime;
    }

    /**
     * @return the adaptationTime
     */
    public long getAdaptationTime() {
        return adaptationTime;
    }

    /**
     * @param adaptationTime the adaptationTime to set
     */
    public void setAdaptationTime(long adaptationTime) {
        this.adaptationTime = adaptationTime;
    }

    /**
     * @return the heuristicComputationTime
     */
    public long getHeuristicComputationTime() {
        return heuristicComputationTime;
    }

    /**
     * @param heuristicComputationTime the heuristicComputationTime to set
     */
    public void setHeuristicComputationTime(long heuristicComputationTime) {
        this.heuristicComputationTime = heuristicComputationTime;
    }

    /**
     *Get the outcome of the plan adaption task
     * @return the outcome of the plan-adaptation process; one of "success", "failure" and "timeout"
     */
    public String getOutcome() {
        if (!this.getPlanner().isFailed() && ! this.getPlanner().isTimeoutFail()) {
            return "success";
        } else if (this.getPlanner().isTimeoutFail()) {
            return "timeout";
        } else {
            return "failure";
        }
    }

    /**
     * Adapt the plan by using the LPG-ADAPT subsystem.
     * @param domain
     * @param problem
     * @param input_plan
     * @return the repaired input_plan or null in case of failure (or timeout)
     * @throws Exception
     */
    public SimplePlan adaptViaLPG(PddlDomain domain, PddlProblem problem, SimplePlan input_plan) throws Exception {

        try {

            
            input_plan.savePlan("plan.sol");
            String solutionString = planner.adapt(domain.getPddlFilRef(), problem.getPddlFilRef(), "plan.sol");
            if (solutionString == null) {
                return null;
            }
            SimplePlan new_plan = new SimplePlan(domain, problem);
            new_plan.parseSolution(solutionString);
            new File(solutionString).delete();
            new File("plan.sol").delete();

            this.setAdaptationTime(planner.getPlannerTime());
            this.setSolution(new_plan);
            return new_plan;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PlanAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Replanning from scratch
     * @param domain
     * @param problem
     * @return a new plan in case of success
     * @throws Exception
     */
    public SimplePlan replan(PddlDomain domain, PddlProblem problem) throws Exception {
        try {
            SimplePlan new_plan = new SimplePlan(domain, problem);
            planningTool replanner = this.planner;

            String solutionString = replanner.plan(domain.getPddlFilRef(), problem.getPddlFilRef());
            if (solutionString == null) {
                return null;
            }
            new_plan.parseSolution(solutionString);
            new File(solutionString).delete();

            this.setAdaptationTime(replanner.getPlannerTime());
            this.setSolution(new_plan);
            return new_plan;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PlanAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Adapt the plan by using macro actions, but only suffixes
     * @param domain The PDDL domain of reference
     * @param problem The problem the plan bust be adapted to
     * @param input_plan The plan from which the repair process is started
     * @return the plan repaired or null in case of no solution (for any reasons...the motivation is due to the planning tool)
     * @throws FileNotFoundException
     * @throws Exception
     */
    @Deprecated
    public SimplePlan adaptViaMacroActionsSuffixes(PddlDomain domain, PddlProblem problem, SimplePlan input_plan) {
        try {
            //Preprocessing. Computing the enhanced domain by adding the previous plan as macro action
            /**/            long start = System.currentTimeMillis();
            DomainEnhancer dEnh = new DomainEnhancer();
            ArrayList macros = new ArrayList();
            GroundAction macro = null;
            float bestDist = Float.MAX_VALUE;
            for (int i = 1; i <= input_plan.size(); i++) {
                macro = input_plan.generateMacro(0, i - 1);
                //System.out.println("Dist(macro,problem):"+macro.computeDistance(prob));
                macro.simplifyModel(domain, problem);
                float dist = macro.computeDistance(problem);
                if (bestDist > dist) {
                    bestDist = dist;
                }
                macros.add(macro);
            }
            Iterator it = macros.iterator();
            while (it.hasNext()) {
                GroundAction gr = (GroundAction) it.next();
                if (gr.computeDistance(problem) > bestDist * 1.50) {
                    it.remove();
                }
            }


            System.out.println("Macro Actions: " + macros.size());
            dEnh.addMacroActions(domain, macros);
            /**/            macroActionsConstructionTime = System.currentTimeMillis() - start;

            //planning using the enhanced domain
            PddlDomain temp = new PddlDomain(dEnh.getDomainEnhancedFileName());
            SimplePlan sp1 = new SimplePlan(temp, problem, false);
            String solutionString = planner.plan(temp.getPddlFilRef(), problem.getPddlFilRef());
            if (solutionString == null) {
                return null;
            }
            sp1.parseSolution(solutionString);
            new File(solutionString).delete();
            //new File(dEnh.getDomainEnhancedFileName()).delete();

            //in case the planning was successfull, rebuild the solution by decomposing the macro-operator
            SimplePlan sp2 = new SimplePlan(domain, problem);
            for (GroundAction gr : (ArrayList<GroundAction>) sp1) {
                if (gr.getName().equalsIgnoreCase(macro.getName())) {
                    System.out.println("#primitives: " + macro.getPrimitives().size());
                    for (GroundAction gr1 : (ArrayList<GroundAction>) macro.getPrimitives()) {
                        sp2.add(gr1);

                    }
                } else {
                    sp2.add(gr);
                }
            }
            setPlannerTime(planner.getPlannerTime());
            this.setAdaptationTime(plannerTime + macroActionsConstructionTime);

            solution = sp2;

            return sp2;
        } catch (Exception ex) {
            Logger.getLogger(PlanAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    

    /**
     * Adapt the plan by using Macro Actions but only prefixes
     * @param domain The PDDL domain of reference
     * @param problem The problem the plan bust be adapted to
     * @param input_plan The plan from which the repair process is started
     * @return the plan repaired or null in case of no solution (for any reasons...the motivation is due to the planning tool)
     * @throws FileNotFoundException
     * @throws Exception
     */
    @Deprecated
    public SimplePlan adaptViaMacroActionPrefixes(PddlDomain domain, PddlProblem problem, SimplePlan input_plan) {
        try {
            //Preprocessing. Computing the enhanced domain by adding the previous plan as macro action
            /**/            long start = System.currentTimeMillis();
            DomainEnhancer dEnh = new DomainEnhancer();
            ArrayList macros = new ArrayList();
            GroundAction macro = null;
            float bestDist = Float.MAX_VALUE;
            for (int i = 1; i <= input_plan.size(); i++) {
                macro = input_plan.generateMacro(0, i - 1);
                //System.out.println("Dist(macro,problem):"+macro.computeDistance(prob));
                macro.simplifyModel(domain, problem);
                float dist = macro.computeDistance(problem);
                if (bestDist > dist) {
                    bestDist = dist;
                }
                macros.add(macro);
            }
            Iterator it = macros.iterator();
            while (it.hasNext()) {
                GroundAction gr = (GroundAction) it.next();
                if (gr.computeDistance(problem) > bestDist * 1.20) {
                    it.remove();
                }
            }


            System.out.println("Macro Actions: " + macros.size());
            dEnh.addMacroActions(domain, macros);
            /**/            macroActionsConstructionTime = System.currentTimeMillis() - start;

            //planning using the enhanced domain
            PddlDomain temp = new PddlDomain(dEnh.getDomainEnhancedFileName());
            SimplePlan sp1 = new SimplePlan(temp, problem, false);
            String solutionString = planner.plan(temp.getPddlFilRef(), problem.getPddlFilRef());
            if (solutionString == null) {
                return null;
            }
            sp1.parseSolution(solutionString);
            new File(solutionString).delete();
            //new File(dEnh.getDomainEnhancedFileName()).delete();

            //in case the planning was successfull, rebuild the solution by decomposing the macro-operator
            SimplePlan sp2 = sp1;
            setPlannerTime(planner.getPlannerTime());
            this.setAdaptationTime(plannerTime + macroActionsConstructionTime);

            solution = sp2;

            return sp2;
        } catch (Exception ex) {
            Logger.getLogger(PlanAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
        /**
     * Adapt the plan by using Macro Actions with prefixes and suffixes (maximum number of elements of these two set is given by maximumNumberOfMacroActions)
     * @param domain The PDDL domain of reference
     * @param problem The problem the plan bust be adapted to
     * @param input_plan The plan from which the repair process is started
     * @param maximumNumberOfMacroActions
     * @return the plan repaired or null in case of no solution (for any reasons...the motivation is due to the planning tool)
     */
    public SimplePlan adaptViaSufPrefMacroActions(PddlDomain domain, PddlProblem problem, SimplePlan input_plan, int maximumNumberOfMacroActions) {
        try {
            //Preprocessing. Computing the enhanced domain by adding the previous plan as macro action
            /**/            long start = System.currentTimeMillis();
            DomainEnhancer dEnh = new DomainEnhancer();
            Set macros = input_plan.generateMacrosSuffandPref();
            System.out.println("Macro Actions: " + macros.size());
            
            //make an arbitrary order among objects in macros
            ArrayList macrosList = new ArrayList(macros);
            Map m = dEnh.addMacroActions(domain, macrosList.subList(0, maximumNumberOfMacroActions));
            
            /**/            macroActionsConstructionTime = System.currentTimeMillis() - start;
            //debugging breakpoint

            
            //planning using the enhanced domain
            //PddlDomain temp = new PddlDomain(dEnh.getDomainEnhancedFileName());
            SimplePlan new_plan = new SimplePlan(new PddlDomain(dEnh.getDomainEnhancedFileName()), problem, false);
            String solutionString = planner.plan(dEnh.getDomainEnhancedFileName(), problem.getPddlFilRef());
            if (solutionString == null) {
                return null;
            }
            new_plan.parseSolutionWithMacro(solutionString, m);
            new File(solutionString).delete();

            setPlannerTime(planner.getPlannerTime());
            this.setAdaptationTime(plannerTime + macroActionsConstructionTime);
            solution = new_plan;
            return new_plan;
        } catch (Exception ex) {
            Logger.getLogger(PlanAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     *Old Function: do not use this
     * @param domain
     * @param problem
     * @param new_plan
     * @param tolerance
     * @return
     * @deprecated
     */
    @Deprecated
    public SimplePlan adaptViaInternalMacroActions(PddlDomain domain, PddlProblem problem, SimplePlan new_plan, float tolerance) {
        try {
            //Preprocessing. Computing the enhanced domain by adding the previous plan as macro action
            /**/            long start = System.currentTimeMillis();
            DomainEnhancer dEnh = new DomainEnhancer();
            Set macros = new_plan.generateInfissMacros();
            //System.out.println("Macro Actions: "+ macros.size());
            long start4 = System.currentTimeMillis();
            ArrayList macroList = new ArrayList(macros);
            //System.out.println(macroList.subList(0, 10));
            Map m = dEnh.addMacroActions(domain, macroList.subList(0, 10));
            System.out.println("time for adding in the file:" + (System.currentTimeMillis() - start4));

            /**/            macroActionsConstructionTime = System.currentTimeMillis() - start;

            //planning using the enhanced domain
            PddlDomain temp = new PddlDomain(dEnh.getDomainEnhancedFileName());
            SimplePlan sp1 = new SimplePlan(temp, problem, false);
            String solutionString = planner.plan(dEnh.getDomainEnhancedFileName(), problem.getPddlFilRef());
            if (solutionString == null) {
                return null;
            }
            sp1.parseSolutionWithMacro(solutionString, m);
            new File(solutionString).delete();

            setPlannerTime(planner.getPlannerTime());
            this.setAdaptationTime(plannerTime + macroActionsConstructionTime);
            solution = sp1;
            return sp1;
        } catch (Exception ex) {
            Logger.getLogger(PlanAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //@Deprecated
    public SimplePlan adaptViaPrefixSuffix(PddlDomain dom, PddlProblem prob, SimplePlan sp, int maxMacros, boolean consideringNumericInformationInDistance) {
        try {
            //Preprocessing. Computing the enhanced domain by adding the previous plan as macro action
            /**/long start = System.currentTimeMillis();
            DomainEnhancer dEnh = new DomainEnhancer();
            Set macros = sp.generateMacrosSuffPref(maxMacros,consideringNumericInformationInDistance);
            //System.out.println("Macro Actions: "+ macros.size());
            maxMacros = Math.min(maxMacros, macros.size());
            long start4 = System.currentTimeMillis();
            ArrayList macroList = new ArrayList(macros);
            //System.out.println(macroList.subList(0, 10));
//            for (GroundAction gr:macros){
//                System.out.println("dist("+gr.getName()+"):"+gr.getDistance());
//            }
            Map macroToPrimitives = dEnh.addMacroActions(dom, macroList.subList(0, maxMacros), sp);
            macroActionsConstructionTime = System.currentTimeMillis() - start;
            System.out.println("time for adding in the file:" + (System.currentTimeMillis() - start4));

            /**/            macroActionsConstructionTime = System.currentTimeMillis() - start;
            System.out.println("MacroConstruction Time:" + getMacroActionsConstructionTime());


            //planning using the enhanced domain
            SimplePlan sp1 = new SimplePlan(dom, prob, false);
            String solutionString = planner.plan(dEnh.getDomainEnhancedFileName(), prob.getPddlFilRef());
            if (solutionString == null) {
                return null;
            }
            sp1.parseSolutionWithMacro(solutionString, macroToPrimitives);
            setEmployedMacros(sp1.getEmployedMacro());
            //new File(solutionString).delete();

            setPlannerTime(planner.getPlannerTime());
            solution = sp1;
            return sp1;
        } catch (Exception ex) {
            Logger.getLogger(PlanAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Deprecated
    public SimplePlan adaptViaAllMacros(PddlDomain dom, PddlProblem prob, SimplePlan sp, int maxMacros, int maxLength) {
        try {
            //Preprocessing. Computing the enhanced domain by adding the previous plan as macro action
            /**/            long start = System.currentTimeMillis();
            DomainEnhancer dEnh = new DomainEnhancer();
            Set<GroundAction> macros = sp.generateEverySubMacros(maxMacros, maxLength);
            //System.out.println("Macro Actions: "+ macros.size());

            long start4 = System.currentTimeMillis();
            ArrayList macroList = new ArrayList(macros);
            //System.out.println(macroList.subList(0, 10));
//            for (GroundAction gr:macros){
//                System.out.println("dist("+gr.getName()+"):"+gr.getDistance());
//            }
            Map m = dEnh.addMacroActions(dom, macroList.subList(0, maxMacros));
            System.out.println("time for adding in the file:" + (System.currentTimeMillis() - start4));

            /**/            macroActionsConstructionTime = System.currentTimeMillis() - start;
            System.out.println("MacroConstruction Time:" + getMacroActionsConstructionTime());


            //planning using the enhanced domain
            PddlDomain temp = new PddlDomain(dEnh.getDomainEnhancedFileName());
            SimplePlan sp1 = new SimplePlan(temp, prob, false);
            String solutionString = planner.plan(dEnh.getDomainEnhancedFileName(), prob.getPddlFilRef());
            if (solutionString == null) {
                return null;
            }
            sp1.parseSolutionWithMacro(solutionString, m);
            new File(solutionString).delete();

            setPlannerTime(planner.getPlannerTime());
            this.setAdaptationTime(plannerTime + macroActionsConstructionTime);
            solution = sp1;
            return sp1;
        } catch (Exception ex) {
            Logger.getLogger(PlanAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public SimplePlan adaptViaMixedStrategy(PddlDomain dom, PddlProblem prob, SimplePlan sp, int maxMacros, int maxLength) {
        try {
            //Preprocessing. Computing the enhanced domain by adding the previous plan as macro action
            /**/            long start = System.currentTimeMillis();
            DomainEnhancer dEnh = new DomainEnhancer();
            Set<GroundAction> macros = sp.generateEverySubMacros(maxMacros, maxLength);
            Set<GroundAction> macros2 = sp.generateMacrosSuffPrefInfiss(maxLength + 1);
            //System.out.println("Macro Actions: "+ macros.size());

            long start4 = System.currentTimeMillis();
            ArrayList macroList = new ArrayList(macros);
            ArrayList macroList2 = new ArrayList(macros2);
            //System.out.println(macroList.subList(0, 10));
//            for (GroundAction gr:macros){
//                System.out.println("dist("+gr.getName()+"):"+gr.getDistance());
//            }
            List toADD = macroList.subList(0, maxMacros / 2);
            toADD.addAll(macroList2.subList(0, maxMacros / 2));
            Map m = dEnh.addMacroActions(dom, toADD);
            System.out.println("time for adding in the file:" + (System.currentTimeMillis() - start4));

            /**/            macroActionsConstructionTime = System.currentTimeMillis() - start;
            System.out.println("MacroConstruction Time:" + getMacroActionsConstructionTime());


            //planning using the enhanced domain
            PddlDomain temp = new PddlDomain(dEnh.getDomainEnhancedFileName());
            SimplePlan sp1 = new SimplePlan(temp, prob, false);
            String solutionString = planner.plan(dEnh.getDomainEnhancedFileName(), prob.getPddlFilRef());
            if (solutionString == null) {
                return null;
            }
            sp1.parseSolutionWithMacro(solutionString, m);
            new File(solutionString).delete();

            setPlannerTime(planner.getPlannerTime());
            this.setAdaptationTime(plannerTime + macroActionsConstructionTime);
            solution = sp1;
            return sp1;
        } catch (Exception ex) {
            Logger.getLogger(PlanAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Adaping the plan by building macro actions from the causal links structure of the starting plan
     * @param domain The Pddl domain of reference
     * @param problem The new Pddl Problem the plan has to be adapted to
     * @param input_plan the starting initial plan (hopefully) similar to a solution for problem
     * @param maxMacros The maximum number of macros to take into account
     * @param shortActions If selected, compute only actions of small dimension
     * @return the new adapted plan
     * @throws CloneNotSupportedException
     * @throws Exception
     */
    public SimplePlan adaptViaCausalLinkMacroActions(PddlDomain domain, PddlProblem problem, SimplePlan input_plan, int maxMacros, boolean shortActions) throws CloneNotSupportedException, Exception {
        ArrayList macros = new ArrayList();
        ArrayList<Integer> splittingPoints = new ArrayList();
       /**/            
        
        long beforeMacrogeneration = System.currentTimeMillis();
        int j = 0;
        State current = problem.getInit().clone();
        for (GroundAction gr : input_plan) {
            if (!gr.isApplicable(current)) {
                splittingPoints.add(j);
            } else{
                if (gr.threatGoalConditions(problem.getGoals(), input_plan,j,current)){
                   splittingPoints.add(j); 
                }
            }
            current = gr.apply(current);
            j++;
        }
        splittingPoints.add(0,0);
        j=0;
        splittingPoints.add(input_plan.size());
        //System.out.println("Index of: states that do not satisfy action precondition, state in which the action application threats the goal condition:" + splittingPoints);
        if (shortActions){
            
            int n = splittingPoints.size();
            int z = 1;
            while (z<n){
                if ((splittingPoints.get(z) - splittingPoints.get(z-1)) > getMax_primitives() ){
                    int x = (splittingPoints.get(z) - splittingPoints.get(z-1))/getMax_primitives();
                    for (int t = 0; t<x; t++){
                        splittingPoints.add(z+t,splittingPoints.get(z+t-1)+getMax_primitives());
                        //z++;
                    }
                }
                z++;
                n = splittingPoints.size();
            }
        }

        //System.out.println("Index of: states that do not satisfy action precondition, state in which the action application threats the goal condition:" + splittingPoints);
        for (Integer i : splittingPoints) {
            GroundAction macro = input_plan.generateMacro(j, i-1);
            j = i;
            if (macro != null){
                macros.add(macro);
            }
        }
        //System.out.println("Number of macros"+macros.size());
        //long beforeAddingFile = System.currentTimeMillis();
        DomainEnhancer dEnh = new DomainEnhancer();

        Map m = dEnh.addMacroActions(domain, macros,input_plan);
        //System.out.println("time for adding in the file:" + (System.currentTimeMillis() - beforeAddingFile));

        /**/macroActionsConstructionTime = System.currentTimeMillis() - beforeMacrogeneration;
        //System.out.println("MacroConstruction Time:" + getMacroActionsConstructionTime());

        //planning using the enhanced domain
        //PddlDomain temp = new PddlDomain(dEnh.getDomainEnhancedFileName());
        SimplePlan new_plan = new SimplePlan(domain, problem, false);
        String solutionString = null;
        if (planner instanceof metricFFWrapper){
            solutionString = planner.plan(dEnh.getDomainEnhancedFileName(), problem.getPddlFilRef());
        }else{
            PDDLObjects temp  = (PDDLObjects)problem.getObjects().clone();
            problem.removeObjects(dEnh.getConstantsFound());
            problem.saveProblem("temp");
            solutionString = planner.plan(dEnh.getDomainEnhancedFileName(), "temp");
            problem.setObjects(temp);
            Utils.deleteFile("temp");
        }
        
        
        if (solutionString == null) {
            return null;
        }
        
        
        
        
        new_plan.parseSolutionWithMacro(solutionString, m);
        this.setEmployedMacros(new_plan.getEmployedMacro());
        new File(solutionString).delete();

        setPlannerTime(planner.getPlannerTime());
        this.setAdaptationTime(plannerTime + macroActionsConstructionTime);
        solution = new_plan;
        return new_plan;

    }

    /**Get the maximum number of actions a macro action consists of
     * @return the max_primitives
     */
    public int getMax_primitives() {
        return max_primitives;
    }

    /**Set the maximum number of actions a macro action consists of
     * @param max_primitives the max_primitives to set
     */
    public void setMax_primitives(int max_primitives) {
        this.max_primitives = max_primitives;
    }

    /**
     * @return the poss_state
     */
    public RelState getPoss_state() {
        return poss_state;
    }

    /**
     * @param poss_state the poss_state to set
     */
    public void setPoss_state(RelState poss_state) {
        this.poss_state = poss_state;
    }

    public SimplePlan adaptViaPop(SimplePlan plan, PddlProblem prob, PddlDomain domain,boolean endlessActionPruning,
                                  boolean biconnectivity,boolean missingServicesCut,boolean goalachievingCut,boolean goalthreatCut) throws Exception {
        
        
        System.out.println("Deordering..");
        //HashMap achieveGoal = new HashMap();
        long beforeMacrogeneration = System.currentTimeMillis();
        DirectedAcyclicGraph po = plan.deorder(prob.getInit(), prob.getGoals(),goalachievingCut);
        //System.out.println(po);
        if (endlessActionPruning)
            removeUselessActions(po,plan.size()-1);   
        //System.out.println(po);
        //System.out.println(plan.toStringWithIndex());
        po = plan.removeInitGoal(po);        
        DomainEnhancer dEnh = new DomainEnhancer();
        List c = null;
        c =plan.generateMacrosFromPop(po,plan.getGoalAchiever(),missingServicesCut,biconnectivity,goalthreatCut);

        this.setConnectedComponentsNumber(plan.getConnectedSetBuilder().connectedSets().size());
        //System.out.println(c);
        List macros = new ArrayList();
        macros.addAll(pruneSmallMacros(c,1000000));
        
        Map m = dEnh.addMacroActions(domain,macros,plan);
        
        //System.out.println("time for adding in the file:" + (System.currentTimeMillis() - beforeAddingFile));

        /**/macroActionsConstructionTime = System.currentTimeMillis() - beforeMacrogeneration;
        //System.out.println("MacroConstruction Time:" + getMacroActionsConstructionTime());

        //planning using the enhanced domain
        //PddlDomain temp = new PddlDomain(dEnh.getDomainEnhancedFileName());
        
        SimplePlan new_plan = new SimplePlan(domain, prob, false);
        
        
        //PddlProblem temp = new PddlProblem();
 
        String solutionString = null;
        if (planner instanceof metricFFWrapper){
            solutionString = planner.plan(dEnh.getDomainEnhancedFileName(), prob.getPddlFilRef());
        }else{
            PDDLObjects temp  = (PDDLObjects)prob.getObjects().clone();
            prob.removeObjects(dEnh.getConstantsFound());
            prob.saveProblem("temp");
            solutionString = planner.plan(dEnh.getDomainEnhancedFileName(), "temp");
            prob.setObjects(temp);
            Utils.deleteFile("temp");
        }
        
        if (solutionString == null) {
            return null;
        }
        new_plan.parseSolutionWithMacro(solutionString, m);
        this.setEmployedMacros(new_plan.getEmployedMacro());
        new File(solutionString).delete();

        setPlannerTime(planner.getPlannerTime());
        this.setAdaptationTime(plannerTime + macroActionsConstructionTime);
        solution = new_plan;
        return new_plan;
    }



    public int adaptViaPopDEBUG(SimplePlan plan, PddlProblem prob, PddlDomain domain, boolean goalPruning, boolean biconnectivity) throws Exception {
        
        long beforeMacrogeneration = System.currentTimeMillis();

        System.out.println("Deordering..");
        //HashMap achieveGoal = new HashMap();
        DirectedAcyclicGraph po = plan.deorder(prob.getInit(), prob.getGoals(),false);

        if (goalPruning)
            this.removeUselessActions(po,plan.size()-1);
        
        System.out.println(plan.getGoalAchiever());
      
        po = plan.removeInitGoal(po);
        BiconnectivityInspector bI = new BiconnectivityInspector(new AsUndirectedGraph(po));
        //System.out.println("Number of BiconnectedComponents: "+bI.getCutpoints());
        
        //System.out.println("Number of macros"+macros.size());
        //long beforeAddingFile = System.currentTimeMillis();
        DomainEnhancer dEnh = new DomainEnhancer();
        List c = null;

            c =plan.generateMacrosFromPop(po,plan.getGoalAchiever(),true,biconnectivity,false);
    
        setConnectedComponentsNumber(plan.getConnectedSetBuilder().connectedSets().size());
        
        return 0;
    }

    /**
     * @return the connectedComponentsNumber
     */
    public int getConnectedComponentsNumber() {
        return connectedComponentsNumber;
    }

    /**
     * @param connectedComponentsNumber the connectedComponentsNumber to set
     */
    public void setConnectedComponentsNumber(int connectedComponentsNumber) {
        this.connectedComponentsNumber = connectedComponentsNumber;
    }

    public DirectedAcyclicGraph removeUselessActions(DirectedAcyclicGraph po,int goalIndex) {
        int counter = 0;
        DirectedAcyclicGraph po1 = (DirectedAcyclicGraph)po.clone();
        TransitiveClosure.INSTANCE.closeSimpleDirectedGraph(po1);
        
        Set s = new HashSet();
        for (int v=1;v<goalIndex;v++){
            if (!po1.containsEdge(v, goalIndex)){
                System.out.println(v);
                counter++;
                s.add(v);
            }
        }
        System.out.println(s);
        for (Object v: s)
            po.removeVertex(v);
        
        System.out.println("actins belonging to endless path:"+counter);
        
        setUselessActionPruning(counter);
        
        return po;
        
    }

    /**
     * @return the uselessActionPruning
     */
    public int getUselessActionPruning() {
        return uselessActionPruning;
    }

    /**
     * @param uselessActionPruning the uselessActionPruning to set
     */
    public void setUselessActionPruning(int uselessActionPruning) {
        this.uselessActionPruning = uselessActionPruning;
    }

    protected TreeSet pruneSmallMacros(List c, int i) {
        
        TreeSet<GroundAction> ret = new TreeSet(new GroundActionComparator());
        ret.addAll(c);
        
        while(ret.size()>i)
            ret.pollFirst();
        return ret;
        
    }

    public void adaptViaBlockDeordering(SimplePlan sp, PddlProblem problem, PddlDomain domain, String planFile) {
        
        //Block deordering invocation
           
        //Build Macro Action
        
        //Write domain extended
        
        //Planning with off-the shelf planner on the extended domain representation
        
        
        
    }





    public class GroundActionComparator implements Comparator<GroundAction> {
    @Override
    public int compare(GroundAction x, GroundAction y) {
        if (x.getPrimitives().size()<=y.getPrimitives().size())
            return -1;
        if (x.getPrimitives().size()==y.getPrimitives().size())
            return 0;
        return 1;  // do your comparison
    }
    }

    

}

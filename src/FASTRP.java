/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import adaptation.AdapterViaBlockDeordering;
import adaptation.PlanAdapter;
import domain.PddlDomain;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.antlr.runtime.RecognitionException;
import plan.SimplePlan;
import planners.ColinClpWrapper;
import planners.ProbeWrapper;
import planners.lpgWrapper;
import planners.metricFF21Wrapper;
import planners.metricFFWrapper;
import planners.planningTool;
import problem.PddlProblem;

/**
 *
 * @author enrico
 */
public class FASTRP {

    private static String domainFile;
    private static String problemFile;
    private static String adaptStrategy;
    private static String planFile;
    private static long preprocessingTime;
    private static int planLength;
    private static String solutionComputedFile = null;
    private static boolean validity = true;
    private static int plansDistance;
    private static String planner;
    private static String timeout;
    private static String plannerOption;
    private static String temporaryGeneration;
    private static String saveResultingPlan;
    private static String trainsBenchmark;

    /**
     * @param args the command line arguments
     */
    /**
     *
     * @param args the command line arguments
     */
    public static void parseInput(String[] args) {
        //Eseguibile -o domain -f problem -s solution -r tipo-repair 
        String usage = "usage:\n executable-name(java -jar...) "
                + "\n-o domain -f problem "
                + "\n-s plan (in case of repair modality)"
                + "\n-r (to activate the repair modality)"
                + "\n          GR (GreedyRepair AIXIA13) | HKR (HeuristicKernelRepair AIXIA13) | RES-MAC (MacroAction ICAPS14) | POP-BASED (Deordering Macro Actions IJCAI15)"
                + "\n-S solutionFile (to store the found solution plan); This option can be selected in case the repair is activated"
                + "\n-R (re)planner used (Metric-ff default; colin-clp can be also selected)";
        if (args.length < 4) {
            System.err.println("Number of parameters is low (" + args.length + ")");
            System.err.println(usage);
            System.exit(-1);
        } else {
            domainFile = searchParameterValue(args, "-o");
            problemFile = searchParameterValue(args, "-f");
            adaptStrategy = searchParameterValue(args, "-r");
//            plannerID = searchParameterValue(args, "-p");
//            replannerID = searchParameterValue(args, "-rep");
            planFile = searchParameterValue(args, "-s");
            solutionComputedFile = searchParameterValue(args, "-S");
            planner = searchParameterValue(args, "-R");
            timeout = searchParameterValue(args, "-T");
            trainsBenchmark = searchParameterValue(args, "-Trains");
            if (timeout == null) {
                timeout = "100000";
            }
            //saveResultingPlan = searchParameterValue(args, "-sp");
            plannerOption = searchParameterValue(args, "-Popt");
            temporaryGeneration = searchParameterValue(args, "-Tgen"); // se specificato genera i vincoli. Questa funzionalita' riguarda un particolare utilizzo del software per la generazione di problemi. Tale sistema e' stato utilizzato per la fase sperimentale di ICTAI-14
            if (plannerOption == null) {
                plannerOption = "";
            }
//            localreplannerID = searchParameterValue(args, "-lrep");
//            lpgFlag = searchParameterValue(args,"-lpgOption");
            //String temp[] = { "A", "B", "C", "D", "E" };

            Set set = new HashSet(Arrays.asList(new String[]{"GR","BLOCK-DEORDERING", "HKR", "MAC0", "LPGADJ", "SPMA", "SPMABounds", "SPMABoundsNo", "MAC2", "MAC3", "MAC4", "REPLAN", "MAC2bis", "RES-MAC", "RES-MAC-SA", "LPGADJ-S", "POP-BASED"}));
            if (domainFile == null || problemFile == null || (!set.contains(adaptStrategy) && adaptStrategy != null)) {
                System.err.println(usage);
                System.exit(-1);
            }

        }
    }

    public static void main(String[] args) throws RecognitionException, IOException, antlr.RecognitionException, CloneNotSupportedException, Exception {
        //Controlling the input files

        parseInput(args);
        PddlDomain domain = new PddlDomain(domainFile);
        System.out.println("Domain Parsed");
        PddlProblem problem = new PddlProblem(problemFile,domain.getConstants());
        System.out.println("Problem Parsed");
        domain.validate(problem);
        
        
        System.out.println("Validation Problem Domain finished");

        //setting the planner to be used
        planningTool p = null;
        if (planner != null) {
            if ("probe".equals(planner)) {
                p = new ProbeWrapper();
            } else if ("ff".equalsIgnoreCase(planner)) {
                p = new metricFFWrapper();

                InputStream url = FASTRP.class.getResourceAsStream("");
                System.out.println(url);
            } else if ("colin-clp".equalsIgnoreCase(planner)) {
                p = new ColinClpWrapper();
            } else if ("ff21".equalsIgnoreCase(planner)) {
                p = new metricFF21Wrapper();
            } else if ("ff21opt".equalsIgnoreCase(planner)) {
                p = new metricFF21Wrapper();
                p.setOption2("-s 3 -w 1");
            } else if ("ff21superopt".equalsIgnoreCase(planner)) {
                p = new metricFF21Wrapper();
                p.setOption2("-s 3 -w 0");
            }
            if (problem.getFunctions().isEmpty() && p instanceof ProbeWrapper) {
                System.out.println("Probe does not support Numeric Fluents");
            }
        } else {
            p = new metricFFWrapper();
            planner = "ff";
        }

        //the first modality is just planning
        if (adaptStrategy == null) {
            p.setOption1(plannerOption);
            System.out.println("Planning Modality");
            System.out.println("Domain: " + domainFile + " ,Problem: " + problemFile + " ,Replanner: " + planner + " , Timeout: " + timeout);
            p.setDomainFile(domainFile);
            p.setProblemFile(problemFile);
            p.setTimeout(Integer.parseInt(timeout));
            //System.out.println(p.outputPlanning);
            SimplePlan sp = new SimplePlan(domain, problem, false);
            p.plan();
            String tt = "";
            String oc = "";
            String wt = "";
            String outcome = "";
            String objFun = "";
            if (p.isPlannerError()) {
                System.out.println("Planner Crashed");
                outcome = "crash";
            } else if (p.isFailed()) {
                System.out.println("No Solution");
                outcome = "no-sol";
            } else if (p.isTimeoutFail()) {
                System.out.println("Timeout");
                outcome = "timeout";
            } else {
                sp.parseSolution(p.storedSolutionPath);
                System.out.println(sp);
                outcome = checkSolution(problem, sp) ? "VALID-SOLUTION" : "INVALID-SOLUTION";
                objFun = sp.getValueObjectiveFunction(problem).toString();
            }
            String res = "Streategy: " + adaptStrategy + " ,Domain: " + domainFile + " ,Problem: " + problemFile + " ,Plan: " + planFile + " ,Outcome:" + outcome + " ,PlanLength:" + sp.size()
                    + " ,Tot-Time: " + p.getPlannerTime() + " ,Planner: " + planner + " ,ObjectiveFunction: " + objFun;
            if (trainsBenchmark != null) {
                res += " ,Travelling_Time: " + tt + " ,waiting_time: " + wt + " ,overall_cost: " + oc + "\n";
            } else {

            }
            System.out.println();
            if (solutionComputedFile != null) {
                sp.savePlan(solutionComputedFile);
            }
            System.out.println(res);
            
            
        } else {//this is the plan repair/ plan adaptation modality
            System.out.println("Adaptation for Domain: " + domainFile + " ,Problem: " + problemFile + " ,Plan: " + planFile + ", Strategy:" + adaptStrategy);
            
            //structure to capture the computed plan
            SimplePlan sp = new SimplePlan(domain, problem, true);
           
            sp.parseSolution(planFile);
            
            //the plan adapter is the tool to use to perform the actual repair
            PlanAdapter pa = new PlanAdapter(p);
            if (adaptStrategy.equalsIgnoreCase("GR")) {
                pa.adaptViaFirstKernel_GreedyRepair(domain, problem, sp);
                preprocessingTime = pa.getKernelConstructionTime();
            } else if (adaptStrategy.equalsIgnoreCase("HKR")) {
                pa.adaptViaBestKernel_HeuristicKernelRepair(domain, problem, sp);
                preprocessingTime = pa.getKernelConstructionTime() + pa.getHeuristicComputationTime();
            } else if (adaptStrategy.equalsIgnoreCase("MAC0")) {
//                 domain.validate(problem);
//                 problem.generateActions();
                pa.adaptViaMacroAction(domain, problem, sp);
                preprocessingTime = pa.getMacroActionsConstructionTime();
            } else if (adaptStrategy.equalsIgnoreCase("LPGADJ")) {
                planningTool replanner = new lpgWrapper();
                replanner.setTimeout(100000);
                replanner.setOption1("-quality" + " -timesteps");
                pa.setPlanner(replanner);
                pa.adaptViaLPG(domain, problem, sp);
                preprocessingTime = 0;
            } else if (adaptStrategy.equalsIgnoreCase("LPGADJ-S")) {
                planningTool replanner = new lpgWrapper();
                replanner.setTimeout(100000);
                replanner.setOption1("-speed" + " -timesteps -seed 1234");
                pa.setPlanner(replanner);
                pa.adaptViaLPG(domain, problem, sp);
                preprocessingTime = 0;
            } else if (adaptStrategy.equalsIgnoreCase("REPLAN")) {
                pa.getPlanner().setTimeout(100000);
                pa.replan(domain, problem);
                preprocessingTime = 0;
            } //To do: Removing the numeric contribution in the distance between the current solution and the problem
            else if (adaptStrategy.equalsIgnoreCase("SPMA")) {
//                 domain.validate(problem);
//                 problem.generateActions();
                System.out.println("Experimental!!");
                pa.adaptViaPrefixSuffix(domain, problem, sp, 10, false);
                preprocessingTime = pa.getMacroActionsConstructionTime();
                pa.setAdaptationTime(pa.getPlannerTime() + preprocessingTime);
            } else if (adaptStrategy.equalsIgnoreCase("RES-MAC")) {
//                 domain.validate(problem);
//                 problem.generateActions();
                System.out.println("Experimental!!");
                pa.getPlanner().setTimeout(100000);
//                 pa.adaptViaMixedStrategy(domain, problem, sp,sp.size()/domain.getActionsSchema().size(),domain.getActionsSchema().size());
                pa.adaptViaCausalLinkMacroActions(domain, problem, sp, 10, false);
                //System.exit(-1);
                preprocessingTime = pa.getMacroActionsConstructionTime();
            } else if (adaptStrategy.equalsIgnoreCase("POP-BASED")) {
//                 domain.validate(problem);
//                 problem.generateActions();
                System.out.println("Experimental!!");

                pa.getPlanner().setTimeout(100000);
//                 pa.adaptViaMixedStrategy(domain, problem, sp,sp.size()/domain.getActionsSchema().size(),domain.getActionsSchema().size());

                pa.adaptViaPop(sp, problem, domain, false, false, true, false, true);
                //System.exit(-1);
                preprocessingTime = pa.getMacroActionsConstructionTime();
            }   else if (adaptStrategy.equalsIgnoreCase("BLOCK-DEORDERING")) {
//                 domain.validate(problem);
//                 problem.generateActions();
                System.out.println("Block Deordering based Plan Repair!!");
                
                AdapterViaBlockDeordering temp = new AdapterViaBlockDeordering(pa.getPlanner());
                temp.getPlanner().setTimeout(Integer.parseInt(timeout));
//                 pa.adaptViaMixedStrategy(domain, problem, sp,sp.size()/domain.getActionsSchema().size(),domain.getActionsSchema().size());
                temp.adaptViaBlockDeordering(planFile, problem, domain,sp);
                pa = temp;
                //System.exit(-1);
                preprocessingTime = pa.getMacroActionsConstructionTime();
            }
            planLength = (pa.getSolution() == null) ? -1 : pa.getSolution().size();
            plansDistance = (pa.getSolution() == null) ? -1 : pa.getSolution().distance(sp);
            if (pa.getSolution() != null) {
                System.out.println(pa.getSolution());
                if (!pa.getSolution().execute(problem.getInit()).satisfy(problem.getGoals())) {
                    validity = false;
                    System.err.println("Serious error. The plan is not valid!");
                    plansDistance = -1;
                }
                if (solutionComputedFile != null) {
                    pa.getSolution().savePlan(solutionComputedFile);
                }
            }
            Float value_obj =null;
            if (pa.getSolution()!=null)
                value_obj = pa.getSolution().getValueObjectiveFunction(problem);
            String outcome = validity ? pa.getOutcome().toString() : "INVALID-SOLUTION";
            String res = "Strategy: " + adaptStrategy + " ,Domain: " + domainFile + " ,Problem: " + problemFile + " ,Plan: " + planFile + " ,Outcome:" + outcome + " ,PlanLength:" + planLength
                        + " ,Tot-Time: " + pa.getAdaptationTime() + " ,PreprocTime: " + preprocessingTime +" ,obj_value: " + value_obj + " ,PlansDistance: " + plansDistance + " ,Planner: " + planner + " , #macros: " + pa.getEmployedMacros() + " , #CCs: " + pa.getConnectedComponentsNumber() + " , #actionPruned: " + pa.getUselessActionPruning() + "\n";

            String fileName = "statistics.csv";
            if (adaptStrategy.equalsIgnoreCase("DEBUG")) {
                fileName = "statisticsDEBUG.csv";
            }
            BufferedWriter f = new BufferedWriter(new FileWriter(fileName, true));
            f.write(res);
            f.close();

            System.out.println(res);

        }
        //System.out.println("Ultima Versione!");

    }

    private static String searchParameterValue(String[] args, String par) {

        //System.out.println("Searching option " + par);
        for (int i = 0; i < args.length - 1; i++) {
            if (args[i].equals(par)) {
                return args[++i];
            }
        }

        return null;
    }

    private static boolean checkSolution(PddlProblem problem, SimplePlan sp) throws CloneNotSupportedException {
        if (sp != null) {
            //System.out.println(pa.getSolution());
            if (!sp.execute(problem.getInit()).satisfy(problem.getGoals())) {
                //validity = false;
                System.err.println("Serious error. The plan is not valid!");
                //plansDistance = -1;
            } else {
                return true;
            }

        }
        return false;
    }

}

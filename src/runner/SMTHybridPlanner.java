/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package runner;

import SMTPlanning.SMTBasedPlanning;
import antlr.RecognitionException;
import domain.PddlDomain;
import extraUtils.Utils;
import java.io.IOException;
import java.util.LinkedHashSet;
//import org.antlr.runtime.RecognitionException;
import plan.SimplePlan;

import problem.EPddlProblem;
import problem.State;

/**
 *
 * @author enrico
 */
public class SMTHybridPlanner {

    private static String domainFile;
    private static String problemFile;
    private static String maxPlanLength;
    private static String minPlanLength;
    private static String stepSemantic;
    private static String implicitGoals;
    private static boolean sum_heuristic;
    private static boolean h1_heuristic;
    private static String sec_theory;
    private static boolean repetition_encoding;
    private static String search_strategy;

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
                + "\n-kMin min-plan-length (optional, default 0)"
                + "\n-kMax maxn-plan-length (optional, default 100)"
                + "\n-sem semantic (optional, default 1-step sequential semantic) [select 1 for sequential and n for parallel semantic]";
        if (args.length < 4) {
            System.err.println("Number of parameters is low (" + args.length + ")");
            System.err.println(usage);
            System.exit(-1);
        } else {
            domainFile = searchParameterValue(args, "-o");
            problemFile = searchParameterValue(args, "-f");
            minPlanLength = searchParameterValue(args, "-kMin");
            maxPlanLength = searchParameterValue(args, "-kMax");
            stepSemantic = searchParameterValue(args, "-sem");
            sum_heuristic = Utils.searchParameter(args, "-sum");
            h1_heuristic = Utils.searchParameter(args, "-h1");
            sec_theory = Utils.searchParameterValue(args, "-T");
            repetition_encoding = Utils.searchParameter(args, "-r");
            search_strategy = Utils.searchParameterValue(args, "-s");

            if (minPlanLength == null) {
                minPlanLength = "0";
            }
            if (maxPlanLength == null) {
                maxPlanLength = "1000";
            }
            if (sec_theory == null) {
                sec_theory = "Real";
            }
            if (domainFile == null || problemFile == null) {
                System.err.println(usage);
                System.exit(-1);
            }

        }
    }

    public static void main(String[] args) throws RecognitionException, IOException, antlr.RecognitionException, CloneNotSupportedException, Exception {
        //Controlling the input files

        parseInput(args);
        PddlDomain domain = new PddlDomain(domainFile);
        //domain.prettyPrint();
        EPddlProblem problem = new EPddlProblem(problemFile, domain.getConstants());

        domain.validate(problem);
        System.out.println("Domain and Problem Parsed");

        State InitCopy = problem.getInit().clone();
        //System.out.println(domain.getActionsSchema());

        SMTBasedPlanning smtplanner = new SMTBasedPlanning(domain, problem);
        smtplanner.setSemantic(stepSemantic);
        smtplanner.setComputeH1(h1_heuristic);
        smtplanner.setSec_theory(sec_theory);
        smtplanner.set_repetition_encoding(repetition_encoding);

        // the following override the previous setting
        //4 possible option
        //0 : sem 1, 1: sem 1 -r, 2: sem N, 3: sem N -r
        parse_search_strategy(smtplanner, search_strategy);


        smtplanner.init();
        SimplePlan sp = smtplanner.solve(Integer.parseInt(minPlanLength), Integer.parseInt(maxPlanLength));
        smtplanner.printOutcome();
        if (sp != null) {
            System.out.println("Plan size: " + sp.size());
            System.out.println("Cost: " + sp.getValueObjectiveFunction(problem));
            System.out.println("Plan: " + sp);
            System.out.println("Number of different action used:" + smtplanner.actionsFound.size());
            
            System.out.println("(just for the pddl2.1 semantic ) Plan is valid:" + sp.execute(InitCopy, problem.globalConstraints).satisfy(problem.getGoals()));
        }

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

    private static void parse_search_strategy(SMTBasedPlanning smtplanner, String search_strategy) {

        if (search_strategy == null) {
            return;
        }
        if (search_strategy.equals("0")) {
            smtplanner.setSemantic("1");
            smtplanner.set_repetition_encoding(false);
        } else if (search_strategy.equals("1")) {
            smtplanner.setSemantic("1");
            smtplanner.set_repetition_encoding(true);
        } else if (search_strategy.equals("2")) {
            smtplanner.setSemantic("N");
            smtplanner.set_repetition_encoding(false);
        } else if (search_strategy.equals("3")) {
            smtplanner.setSemantic("N");
            smtplanner.set_repetition_encoding(true);
        } else if (search_strategy.equals("4")) {
            smtplanner.setSemantic("e");
            smtplanner.set_repetition_encoding(true);
        } else if (search_strategy.equals("5")) {
            smtplanner.setSemantic("0");
            smtplanner.set_repetition_encoding(false);
        } else if (search_strategy.equals("6")) {
            smtplanner.setSemantic("0");
            smtplanner.set_repetition_encoding(true);
        }

        System.out.println("Configuration selected is: SEM:" + smtplanner.getSemantic() + " Repetition:" + smtplanner.isRepetition_encoding());

    }

}

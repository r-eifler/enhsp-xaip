/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import conditions.NumFluentAssigner;
import domain.PddlDomain;
import extraUtils.Utils;
import java.util.LinkedList;
import plan.SimplePlan;
import problem.EPddlProblem;
import problem.State;
import search.SearchStrategies;
import heuristics.advanced.Uniform_cost_search_H1;
import heuristics.advanced.Uniform_cost_search_H1_RC;
import heuristics.advanced.asymptotic_ibr;
import heuristics.Aibr;
import heuristics.advanced.Uniform_cost_search_HM;
import heuristics.operator_counting.operator_counting_heuristic;

/**
 *
 * @author enrico
 */
public class NHSP {

    private static String domainFile;
    private static String problemFile;
    private static String strategy;
    private static String w_h;
    private static String config;
    private static String w_g;
    private static int debug_level = 0;
    private static boolean dec_heuristic = false;
    private static boolean saving_json = false;
    private static String delta_t;
    private static String horizon;
    private static float resolution_execution;
    private static boolean save_plan;
    private static boolean print_trace;
    private static String break_ties;

    /**
     * @param args the command line arguments
     */
    public static void parseInput(String[] args) {
        //Eseguibile -o domain -f problem -s solution -r tipo-repair 
        String usage = "usage:\n executable-name(java -jar...) "
                + "\n-o domain -f problem "
                + "\n-s <hc (Hill Climbing), wa_star (h_w = 4), gbfs (GreedyBestFirstSearch, g_w = 0), bfs (A* without node reopening), brfs, dfs"
                + "\n-delta <real> (specify the delta used to approximate the passage of time)"
                + "\n-exec_res <real> (specify the precision in the simulation of the plan, euler method)"
                + "\n-gw <integer> (weight for the g; this overrides default search setting)"
                + "\n-hw <integer> (weight for the h); this overrides default search setting)"
                + "\n-c <integer> select configuration (mainly for the heuristic). 0 means additive version as for IJCAI paper, 11 means extended IBR+IJCAI paper"
                + "\n-horizon <integer> (depth of the search tree)"
                + "\n-sjr (activate search tree saving in jason file)"
                + "\n-sp (save plan)"
                + "\n-break_ties larger_g, smaller_g (default: Arbitrary)"
                + "\n-print_trace (print trace of the plan)"
                + "\n-adm (Admissible setting; default no)";

        if (args.length < 4) {
            System.err.println("Number of parameters is lower than expected (" + args.length + ")");
            System.err.println(usage);
            System.exit(-1);
        } else {
            domainFile = Utils.searchParameterValue(args, "-o");
            problemFile = Utils.searchParameterValue(args, "-f");
            strategy = Utils.searchParameterValue(args, "-s");
            w_h = Utils.searchParameterValue(args, "-hw");//weight for h-value
            w_g = Utils.searchParameterValue(args, "-gw");//weight for g-value
            delta_t = Utils.searchParameterValue(args, "-delta");
            horizon = Utils.searchParameterValue(args, "-horizon");
            config = Utils.searchParameterValue(args, "-h");
            dec_heuristic = Utils.searchParameter(args, "-dec"); //only decreasing values of heuristic
            saving_json = Utils.searchParameter(args, "-sjr"); //Save the search tree in a jason file
            save_plan = Utils.searchParameter(args, "-sp"); //Save the plan
            print_trace = Utils.searchParameter(args, "-print_trace"); //print_trace
            break_ties = Utils.searchParameterValue(args, "-break_ties"); //print_trace
            String res_validation = Utils.searchParameterValue(args, "-exec_res"); //Resolution for the validation
            if (res_validation != null) {
                resolution_execution = Float.parseFloat(res_validation);
            } else {
                resolution_execution = 1f;
            }
            if (delta_t == null) {
                delta_t = "1";
            }

            if (domainFile == null || problemFile == null) {
                System.err.println(usage);
                System.exit(-1);
            }

        }
    }

    public static void main(String[] args) throws Exception {

        parseInput(args);
        PddlDomain domain = new PddlDomain(domainFile);
        System.out.println("Domain Parsed");
        final EPddlProblem problem = new EPddlProblem(problemFile, domain.getConstants());
        final EPddlProblem validation_problem = new EPddlProblem(problemFile, domain.getConstants());

        System.out.println("Problem parsed");

        domain.validate(problem);
        System.out.println("Light Validation Complete");
        SimplePlan sp = new SimplePlan(domain, validation_problem);  //placeholder for the plan to be found
        final SearchStrategies searchStrategies = new SearchStrategies(); //manager of the search strategies
        if (debug_level > 1) {
            domain.prettyPrint();
            problem.prettyPrint();
        }
        //The following add a handler for storing the search tree in a jason file, if specified.
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                if (saving_json) {
                    searchStrategies.search_space_handle.print_json(problem.getPddlFileReference() + ".sp_log");
                }
            }
        });
        LinkedList raw_plan = null;//raw list of actions returned by the search strategies
        if (!domain.getProcessesSchema().isEmpty()) {
            problem.getInit().addNumericFluent(new NumFluentAssigner("#t", Float.parseFloat(delta_t)));

            System.out.println("Delta:" + Float.parseFloat(delta_t));
            problem.getInit().addNumericFluent(new NumFluentAssigner("time_elapsed", 0));
            searchStrategies.delta = Float.parseFloat(delta_t);
            searchStrategies.processes = true;
        }
        System.out.println("Grounding..");

        problem.generateActionsAndProcesses();
        problem.generateConstraints();

        problem.normalize_conditions();

        System.out.println("Grounding and Simplification finished");
        System.out.println("|A|:" + problem.getActions().size());
        System.out.println("|P|:" + problem.processesSet.size());

        if (config == null || config.equals("0")) {
            config = "0";
            searchStrategies.setup_heuristic(new Uniform_cost_search_H1(problem.getGoals(), problem.getActions(), problem.processesSet));
            Uniform_cost_search_H1 h = (Uniform_cost_search_H1) searchStrategies.getHeuristic();
            searchStrategies.set_w_g(1);
            searchStrategies.set_w_h(1);
//            h.greedy = true;
            h.additive_h = true;
        } else if (config.equals("1")) {//satisficing planning setting as for IJCAI-16 paper
            searchStrategies.setup_heuristic(new Uniform_cost_search_H1(problem.getGoals(), problem.getActions(), problem.processesSet));
            Uniform_cost_search_H1 h = (Uniform_cost_search_H1) searchStrategies.getHeuristic();
            h.additive_h = true;
        } else if (config.equals("3")) {//optimal planning setting.. hmax as for the IJCAI-16 paper
            searchStrategies.setup_heuristic(new Uniform_cost_search_H1_RC(problem.getGoals(), problem.getActions()));
            Uniform_cost_search_H1_RC h = (Uniform_cost_search_H1_RC) searchStrategies.getHeuristic();
            h.additive_h = false;
            searchStrategies.set_w_h(1f);
            searchStrategies.set_w_g(1f);
        } else if (config.equals("112")) {//Pure AIBR as for ECAI-16 paper. this you can plan with processes too...
            searchStrategies.setup_heuristic(new asymptotic_ibr(problem.getGoals(), problem.getActions(), problem.processesSet));
            asymptotic_ibr h = (asymptotic_ibr) searchStrategies.getHeuristic();
            h.set(false, true);
            searchStrategies.set_w_g(1);
            searchStrategies.set_w_h(1);
        } else if (config.equals("20")) {//AIBR with Plan Extraction (not published) as 112 but with plan extraction.
            System.out.println("20");
            searchStrategies.setup_heuristic(new Aibr(problem.getGoals(), problem.getActions(), problem.processesSet));
            Aibr h = (Aibr) searchStrategies.getHeuristic();
            h.set(false, true);
            h.extract_plan = true;
            searchStrategies.set_w_g(1);
            searchStrategies.set_w_h(1);
        } else if (config.equals("exp_gc")) {//Experimental Setting. using hm-like formulation. Not published!
            searchStrategies.setup_heuristic(new Uniform_cost_search_HM(problem.getGoals(), problem.getActions(), problem.processesSet, problem.globalConstraints));
            Uniform_cost_search_HM h = (Uniform_cost_search_HM) searchStrategies.getHeuristic();
            //h.additive_h = true;
            h.additive_h = false;
            h.integer_variables = false;
            h.greedy = false;
            searchStrategies.set_w_h(1);
        } else if (config.equals("op_counting")) {//This is for operator counting heuristics
            searchStrategies.setup_heuristic(new operator_counting_heuristic(problem.getGoals(), problem.getActions()));
            searchStrategies.set_w_h(1);
        } else {
            System.out.println("Configuration Setting is not valid");
            System.exit(-1);
        }
        searchStrategies.setDecreasing_heuristic_pruning(dec_heuristic);
        searchStrategies.json_rep_saving = saving_json;

//        if (horizon != null){
//            searchStrategies.getHeuristic().horizon = Integer.parseInt(horizon);
//        }
        if (break_ties != null) {
            if (break_ties.equals("smaller_g")) {
                searchStrategies.breakties_on_larger_g = false;
                searchStrategies.breakties_on_smaller_g = true;
            } else if (break_ties.equals("larger_g")) {
                searchStrategies.breakties_on_larger_g = true;
            } else if (break_ties.equals("arbitrary")) {
                searchStrategies.breakties_on_larger_g = false;
                searchStrategies.breakties_on_smaller_g = false;
            } else {
                System.out.println("Wrong setting for break-ties. Arbitrary tie breaking");
            }
        } else {
            searchStrategies.breakties_on_larger_g = false;
            searchStrategies.breakties_on_smaller_g = false;

        }

        if (w_h != null) {
            searchStrategies.set_w_h(Float.parseFloat(w_h));
            System.out.println("w_h set to be " + w_h);
        }
        if (w_g != null) {
            searchStrategies.set_w_g(Float.parseFloat(w_g));
            System.out.println("g_h set to be " + w_g);
        }

        if (horizon != null) {
            searchStrategies.horizon = Integer.parseInt(horizon);
            System.out.println("Setting horizon to:" + horizon);
        } else {
            searchStrategies.horizon = Integer.MAX_VALUE;
        }
//        if (admissible != null){
//            searchStrategies.getHeuristic().additive_h = false;
//        }

        if ("hc".equals(strategy)) {
            raw_plan = searchStrategies.enforced_hill_climbing(problem);
        } else if ("bfs".equals(strategy) || strategy == null) {
            searchStrategies.preferred_operators_active = false;
            if (w_g == null) {
                searchStrategies.set_w_g(1);
            }
            if (w_h == null) {
                searchStrategies.set_w_h(1);
            }
            raw_plan = searchStrategies.greedy_best_first_search(problem);
        } else if ("wa_star".equals(strategy)) {
            if (w_g == null) {
                searchStrategies.set_w_g(1);
            }
            if (w_h == null) {
                searchStrategies.set_w_h(1);
            }
            raw_plan = searchStrategies.wa_star(problem);
        } else if ("gbfs".equals(strategy)) {
            if (w_g == null) {
                searchStrategies.set_w_g(0);
            }
            if (w_h == null) {
                searchStrategies.set_w_h(1);
            }
            raw_plan = searchStrategies.greedy_best_first_search(problem);
        } else if ("dfs".equals(strategy)) {
            config = "brfs";
            searchStrategies.set_w_h(0);
            searchStrategies.set_w_g(1);
            searchStrategies.bfs = false;
            raw_plan = searchStrategies.blindSearch(problem);
        } else if ("brfs".equals(strategy)) {
            config = "brfs";
            searchStrategies.set_w_h(0);
            searchStrategies.set_w_g(1);
            searchStrategies.bfs = true;
            raw_plan = searchStrategies.blindSearch(problem);
        } else {
            System.out.println("Strategy is not correct");
            System.exit(-1);
        }
        if (raw_plan != null) {
            System.out.println("Problem Solved");
            if (problem.processesSet.isEmpty()) {
                sp.addAll(raw_plan);
                sp.print_trace = print_trace;

                System.out.println("(Pddl2.1 semantic) Plan is valid:" + sp.execute(problem.getInit(), problem.globalConstraints).satisfy(problem.getGoals()));
                System.out.println(sp);
                System.out.println("Plan-Length:" + sp.size());
            } else {
                sp.build_pddl_plus_plan(raw_plan, Float.parseFloat(delta_t), 0.0000001f);
                sp.print_trace = print_trace;
                State last_state = sp.execute(problem.getInit(), problem.globalConstraints, problem.processesSet, searchStrategies.delta, resolution_execution);
                System.out.println("(Pddl+ semantic) Plan is valid:" + last_state.satisfy(problem.getGoals()));
                System.out.println(sp);
                System.out.println("Plan-Length:" + sp.size());
                if (save_plan) {
                    sp.savePlan(problem.getPddlFileReference() + "_c_" + config + "_gw_" + w_g + "_hw_" + w_g + "_delta_" + delta_t + ".plan", true);
                }
                if (problem.getMetric() != null && problem.getMetric().getMetExpr() != null) {
                    System.out.println("Metric-Value:" + problem.getMetric().getMetExpr().eval(last_state));
                }
            }
        } else {
            System.out.println("Problem Unsolvable");
        }
        System.out.println("Heuristic Time:" + SearchStrategies.heuristic_time);
        System.out.println("Planning Time:" + SearchStrategies.overall_search_time);
        System.out.println("Expanded Nodes:" + SearchStrategies.nodes_expanded);
        System.out.println("States Evaluated:" + SearchStrategies.states_evaluated);
        System.out.println("Total Cost:" + sp.cost);

        System.out.println("Priority Queue Size:" + SearchStrategies.priority_queue_size);
        System.out.println("Number of Dead-Ends detected:" + SearchStrategies.num_dead_end_detected);
        System.out.println("Number of duplicates detected:" + SearchStrategies.number_duplicates);
        System.out.println("Number of Nodes re-opened:" + SearchStrategies.node_reopened);

        if (saving_json) {
            searchStrategies.search_space_handle.print_json(problem.getPddlFileReference() + ".sp_log");
        }

    }

}

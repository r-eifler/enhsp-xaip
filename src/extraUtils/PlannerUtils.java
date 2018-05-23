package extraUtils;

import domain.PddlDomain;
import heuristics.Aibr;
import heuristics.advanced.h1;
import heuristics.blindHeuristic;
import problem.EPddlProblem;
import search.SearchEngine;

import java.util.LinkedList;

/*
 * Copyright (C) 2018 enrico.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
/**
 *
 * @author enrico
 */
public class PlannerUtils {

    public int getPlanSize(String domainFileName, String problemFileName, String heuristic) throws Exception {
        final PddlDomain domain = new PddlDomain(domainFileName);
        final EPddlProblem problem = new EPddlProblem(problemFileName, domain.getConstants(), domain.getTypes());
        domain.prettyPrint();
        domain.validate(problem);

        final SearchEngine searchStrategies = new SearchEngine(); //manager of the search strategies

        //set deltas in case is a pddl+ problem
        if (!domain.getProcessesSchema().isEmpty() || !domain.eventsSchema.isEmpty()) {
            //this is when you have processes
            problem.setDeltaTimeVariable("1");
            searchStrategies.delta = Float.parseFloat("1");
            searchStrategies.processes = true;
            searchStrategies.delta_max = Float.parseFloat("1");
        } else {//this is when you have processes
        }
        problem.grounding_action_processes_constraints();
        problem.simplifyAndSetupInit();

        //set heuristic
        if (heuristic.equals("aibr")) {
            searchStrategies.setup_heuristic(new Aibr(problem.getGoals(), problem.getActions(), problem.processesSet, problem.eventsSet));
            Aibr h = (Aibr) searchStrategies.getHeuristic();
            h.set(false, true);
        }
        if (heuristic.equals("hadd")) {
            searchStrategies.setup_heuristic(new h1(problem.getGoals(), problem.getActions(), problem.processesSet, problem.eventsSet));
            h1 h = (h1) searchStrategies.getHeuristic();
            h.useRedundantConstraints = false;
            h.additive_h = true;
        } else {
            searchStrategies.setup_heuristic(new blindHeuristic(problem.getGoals(), problem.getActions(), problem.processesSet, problem.eventsSet));
        }

        searchStrategies.set_w_g(1);
        searchStrategies.set_w_h(1);
        LinkedList raw_plan = searchStrategies.wa_star(problem);
        //System.out.println(raw_plan.size());
        return raw_plan.size();
    }

    public int heuristicEstimate(String domainFileName, String problemFileName, String heuristic) throws Exception {
        final PddlDomain domain = new PddlDomain(domainFileName);
        final EPddlProblem problem = new EPddlProblem(problemFileName, domain.getConstants(), domain.getTypes());
        domain.prettyPrint();
        domain.validate(problem);

        final SearchEngine searchStrategies = new SearchEngine(); //manager of the search strategies

        //set deltas in case is a pddl+ problem
        if (!domain.getProcessesSchema().isEmpty() || !domain.eventsSchema.isEmpty()) {
            //this is when you have processes
            problem.setDeltaTimeVariable("1");
            searchStrategies.delta = Float.parseFloat("1");
            searchStrategies.processes = true;
            searchStrategies.delta_max = Float.parseFloat("1");
        } else {//this is when you have processes
        }
        problem.grounding_action_processes_constraints();
        problem.simplifyAndSetupInit();

        //set heuristic
        searchStrategies.setup_heuristic(new h1(problem.getGoals(), problem.getActions(), problem.processesSet, problem.eventsSet));
        h1 h = (h1) searchStrategies.getHeuristic();
        h.useRedundantConstraints = false;
        h.additive_h = true;

        searchStrategies.getHeuristic().setup(problem.init);
        long start = System.nanoTime();
        Float hs0 = searchStrategies.getHeuristic().compute_estimate(problem.init);
        long totaltime = System.nanoTime()-start;
        System.out.println("hs0:" + hs0 +  " in " + (float)totaltime/1000000000.0 +"s" );
        
        //System.out.println(raw_plan.size());
        return hs0.intValue();
    }
}

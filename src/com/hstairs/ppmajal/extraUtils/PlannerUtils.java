package com.hstairs.ppmajal.extraUtils;

import com.hstairs.ppmajal.domain.PddlDomain;
import com.hstairs.ppmajal.heuristics.Aibr;
import com.hstairs.ppmajal.heuristics.advanced.h1;
import com.hstairs.ppmajal.heuristics.blindHeuristic;
import com.hstairs.ppmajal.problem.EPddlProblem;
import com.hstairs.ppmajal.problem.GroundAction;
import com.hstairs.ppmajal.search.PDDLSearchEngine;
import com.hstairs.ppmajal.search.SearchEngine;

import java.util.Collection;
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
 * @author enrico
 */
public class PlannerUtils {


    public int getPlanSize (String domainFileName, String problemFileName, String heuristic) throws Exception {
        return this.getPlanSize(domainFileName, problemFileName, heuristic, 1, 1);
    }

    public int getPlanSize (String domainFileName, String problemFileName, String heuristic, int wg, int wh) throws Exception {
        final PddlDomain domain = new PddlDomain(domainFileName);
        final EPddlProblem problem = new EPddlProblem(problemFileName, domain.getConstants(), domain.getTypes());
        domain.prettyPrint();
        domain.validate(problem);

        final PDDLSearchEngine searchStrategies = new PDDLSearchEngine(); //manager of the search strategies

        //set deltas in case is a pddl+ problem
        if (!domain.getProcessesSchema().isEmpty() || !domain.eventsSchema.isEmpty()) {
            //this is when you have processes
            problem.setDeltaTimeVariable("1");
            searchStrategies.executionDelta = Float.parseFloat("1");
            searchStrategies.processes = true;
            searchStrategies.planningDelta = Float.parseFloat("1");
        } else {//this is when you have processes
        }
        problem.groundingActionProcessesConstraints();
        problem.simplifyAndSetupInit();

        //set heuristic
        if (heuristic.equals("aibr")) {
            searchStrategies.setupHeuristic(new Aibr(problem));
            Aibr h = (Aibr) searchStrategies.getHeuristic();
            h.set(false, true);
        }
        if (heuristic.equals("hadd")) {
            searchStrategies.setupHeuristic(new h1(problem));
            h1 h = (h1) searchStrategies.getHeuristic();
            h.useRedundantConstraints = false;
            h.additive_h = true;
        }
        if (heuristic.equals("hmax")) {
            searchStrategies.setupHeuristic(new h1(problem));
            h1 h = (h1) searchStrategies.getHeuristic();
            h.useRedundantConstraints = false;
            h.additive_h = false;
        } else {
            searchStrategies.setupHeuristic(new blindHeuristic(problem));
        }

        searchStrategies.setWG(wg);
        searchStrategies.setWH(wh);
        LinkedList raw_plan = searchStrategies.WAStar(problem);
        System.out.println("Nodes Expanded:" + searchStrategies.getNodesExpanded());
        //System.out.println(raw_plan.size());
        if (raw_plan == null)
            return -1;
        return raw_plan.size();
    }

    public int heuristicEstimate (String domainFileName, String problemFileName, String heuristic) throws Exception {
        final PddlDomain domain = new PddlDomain(domainFileName);
        final EPddlProblem problem = new EPddlProblem(problemFileName, domain.getConstants(), domain.getTypes());
        domain.prettyPrint();
        domain.validate(problem);

        final SearchEngine searchStrategies = new SearchEngine(); //manager of the search strategies

        //set deltas in case is a pddl+ problem
        if (!domain.getProcessesSchema().isEmpty() || !domain.eventsSchema.isEmpty()) {
            //this is when you have processes
            problem.setDeltaTimeVariable("1");
            searchStrategies.executionDelta = Float.parseFloat("1");
            searchStrategies.processes = true;
            searchStrategies.planningDelta = Float.parseFloat("1");
        } else {//this is when you have processes
        }
        problem.groundingActionProcessesConstraints();
        problem.simplifyAndSetupInit();

        //set heuristic
        searchStrategies.setupHeuristic(new h1(problem));
        h1 h = (h1) searchStrategies.getHeuristic();
        h.useRedundantConstraints = false;
        h.additive_h = true;

        searchStrategies.getHeuristic().setup(problem.init);
        long start = System.nanoTime();
        Float hs0 = searchStrategies.getHeuristic().computeEstimate(problem.init);
        long totaltime = System.nanoTime() - start;
        System.out.println("hs0:" + hs0 + " in " + (float) totaltime / 1000000000.0 + "s");

        //System.out.println(raw_plan.size());
        return hs0.intValue();
    }

    public int computeNumberOfRelevantActions (String domainFileName, String problemFileName) throws Exception {
        final PddlDomain domain = new PddlDomain(domainFileName);
        final EPddlProblem problem = new EPddlProblem(problemFileName, domain.getConstants(), domain.getTypes());
        domain.prettyPrint();
        domain.validate(problem);
        problem.groundingActionProcessesConstraints();
        problem.simplifyAndSetupInit();
        Collection<GroundAction> reachableActions = problem.getReachableActions();
        return reachableActions.size();

    }
}

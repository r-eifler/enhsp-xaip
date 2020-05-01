package com.hstairs.ppmajal.extraUtils;

import com.hstairs.ppmajal.domain.PddlDomain;
import com.hstairs.ppmajal.heuristics.Heuristic;
import com.hstairs.ppmajal.heuristics.advanced.Aibr;
import com.hstairs.ppmajal.heuristics.advanced.H1;
import com.hstairs.ppmajal.heuristics.BlindHeuristic;
import com.hstairs.ppmajal.problem.EPddlProblem;
import com.hstairs.ppmajal.search.PDDLSearchEngine;
import com.hstairs.ppmajal.transition.TransitionGround;
import org.apache.commons.lang3.tuple.Pair;

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
    PddlDomain d;
    EPddlProblem p;
    Heuristic h;


    private void setup(String domainFileName, String problemFileName, String heuristic) throws Exception {
        d = new PddlDomain(domainFileName);
        p = new EPddlProblem(problemFileName, d.constants, d.types, d);
        d.substituteEqualityConditions();
        if (!d.getProcessesSchema().isEmpty()) {
            p.setDeltaTimeVariable("1");
        }
        p.groundingSimplication(true);
        h = null;

        switch (heuristic) {
            case "blind":
                h = new BlindHeuristic(p);
                break;
            case "aibr":
                h = new Aibr(p);
                break;
            case "hadd":
                h = new H1(p,true);
                break;
            case "hmax":
                h = new H1(p,false);
                break;
            case "hrmax":
                h = new H1(p,false,false,false,true,false,false,false,false);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + heuristic);
        }
    }
    public int getPlanSize (String domainFileName, String problemFileName, String heuristic) throws Exception {
        return this.getPlanSize(domainFileName, problemFileName, heuristic, 1, 1, Integer.MAX_VALUE);
    }

    public int getPlanSize(String domainFileName, String problemFileName, String heuristic, int wg, int wh, int depthBound) throws Exception {
        setup(domainFileName,problemFileName,heuristic);
        PDDLSearchEngine search = new PDDLSearchEngine(h, p);
        if (!p.getProcessesSet().isEmpty()){
            search.planningDelta = 1.0f;
            search.processes = true;
            search.executionDelta = 1.0f;
        }
        final LinkedList<Pair<Float, Object>> pairs = search.WAStar(p);
        return pairs.size();
    }

    public int heuristicEstimate (String domainFileName, String problemFileName, String heuristic) throws Exception {
        setup(domainFileName,problemFileName,heuristic);
        final float v = h.computeEstimate(p.getInit());
        return (int)v;
    }

}

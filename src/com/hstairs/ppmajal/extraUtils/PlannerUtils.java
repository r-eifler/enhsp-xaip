package com.hstairs.ppmajal.extraUtils;

import com.hstairs.ppmajal.domain.PddlDomain;
import com.hstairs.ppmajal.problem.EPddlProblem;
import com.hstairs.ppmajal.transition.TransitionGround;

import java.util.Collection;

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
        return this.getPlanSize(domainFileName, problemFileName, heuristic, 1, 1, Integer.MAX_VALUE);
    }

    public int getPlanSize (String domainFileName, String problemFileName, String heuristic, int wg, int wh, int depthBound) throws Exception {
      throw new UnsupportedOperationException();
    }

    public int heuristicEstimate (String domainFileName, String problemFileName, String heuristic) throws Exception {
        throw new UnsupportedOperationException();

    }

    public int computeNumberOfRelevantActions (String domainFileName, String problemFileName) throws Exception {
        final PddlDomain domain = new PddlDomain(domainFileName);
        final EPddlProblem problem = new EPddlProblem(problemFileName, domain.getConstants(), domain.getTypes(),domain);
        domain.prettyPrint();
        problem.groundingActionProcessesConstraints();
        problem.simplifyAndSetupInit();
        Collection<TransitionGround> reachableActions = problem.getReachableActions();
        return reachableActions.size();

    }
}

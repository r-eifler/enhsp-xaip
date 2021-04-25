/*
 * Copyright (C) 2010-2017 Enrico Scala. Contact: enricos83@gmail.com.
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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hstairs.ppmajal.pddl.heuristics;

import com.hstairs.ppmajal.conditions.Condition;
import com.hstairs.ppmajal.problem.EPddlProblem;
import com.hstairs.ppmajal.problem.State;
import com.hstairs.ppmajal.transition.TransitionGround;

import java.util.Collection;
import com.hstairs.ppmajal.search.SearchHeuristic;

/**
 * @author enrico
 */
public class BlindHeuristic implements SearchHeuristic {

    final Condition goal;
    final private EPddlProblem problem;
    final Object[] staticActions;
    public BlindHeuristic(EPddlProblem problem){
        this.problem = problem;
        goal = problem.getGoals();
        staticActions = problem.actions.toArray();
    }

    @Override
    public float computeEstimate (State s_0) {
        if (s_0.satisfy(goal))
            return 0;
        return 1;
    }

    @Override
    public Object[] getTransitions(boolean helpful) {
        return staticActions;
    }   

    @Override
    public Collection<TransitionGround> getAllTransitions() {
        return problem.getTransitions();
    }

}

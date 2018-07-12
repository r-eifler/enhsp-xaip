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
package com.hstairs.ppmajal.heuristics;

import com.hstairs.ppmajal.conditions.ComplexCondition;
import com.hstairs.ppmajal.problem.GroundAction;
import com.hstairs.ppmajal.problem.GroundEvent;
import com.hstairs.ppmajal.problem.GroundProcess;
import com.hstairs.ppmajal.problem.State;

import java.util.Set;

/**
 * @author enrico
 */
public class blindHeuristic extends Aibr {

    public blindHeuristic (ComplexCondition G, Set<GroundAction> A, Set<GroundProcess> P) {
        super(G, A, P);
    }

    public blindHeuristic (ComplexCondition G, Set<GroundAction> A) {
        super(G, A);
    }

    public blindHeuristic (ComplexCondition goals, Set actions, Set<GroundProcess> processesSet, Set<GroundEvent> eventsSet) {
        super(goals, actions, processesSet, eventsSet);

    }

    @Override
    public Float compute_estimate (State s_0) {
//        if (reachability) {
//
//            return super.compute_estimate(s_0);
//
//        }
        this.reachable = A;
        if (s_0.satisfy(this.G)) {
            return 0f;
        } else {
            return 1f;
        }
    }

}

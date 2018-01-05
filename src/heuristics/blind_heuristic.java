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
package heuristics;

import conditions.ComplexCondition;
import conditions.Condition;
import java.util.HashSet;
import java.util.Set;
import PDDLProblem.PDDLGroundAction;
import PDDLProblem.GroundEvent;
import PDDLProblem.GroundProcess;
import PDDLProblem.PDDLState;

/**
 *
 * @author enrico
 */
public class blind_heuristic extends Aibr {

    public blind_heuristic(ComplexCondition G, Set<PDDLGroundAction> A, Set<GroundProcess> P) {
        super(G, A, P);
    }

    public blind_heuristic(ComplexCondition G, Set<PDDLGroundAction> A) {
        super(G, A);
    }

    public blind_heuristic(ComplexCondition goals, Set actions, Set<GroundProcess> processesSet, Set<GroundEvent> eventsSet) {
        super(goals, actions, processesSet, eventsSet);

    }

    @Override
    public Float compute_estimate(PDDLState s_0) {
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

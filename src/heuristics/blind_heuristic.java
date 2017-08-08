/**
 * *******************************************************************
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 *
 ********************************************************************
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heuristics;

import conditions.Conditions;
import java.util.HashSet;
import java.util.Set;
import problem.GroundAction;
import problem.GroundEvent;
import problem.GroundProcess;
import problem.State;

/**
 *
 * @author enrico
 */
public class blind_heuristic extends Aibr {

    public blind_heuristic(Conditions G, Set<GroundAction> A, Set<GroundProcess> P) {
        super(G, A, P);
    }

    public blind_heuristic(Conditions G, Set<GroundAction> A) {
        super(G, A);
    }

    public blind_heuristic(Conditions goals, Set actions, Set<GroundProcess> processesSet, Set<GroundEvent> eventsSet) {
        super(goals, actions, processesSet, eventsSet);

    }

    @Override
    public Float compute_estimate(State s_0) {
        if (reachability) {

            return super.compute_estimate(s_0);

        }
        if (s_0.satisfy(this.G)) {
            return 0f;
        } else {
            return 1f;
        }
    }

}

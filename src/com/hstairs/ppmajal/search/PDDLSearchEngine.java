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
package com.hstairs.ppmajal.search;

import com.hstairs.ppmajal.heuristics.Heuristic;
import com.hstairs.ppmajal.problem.PDDLState;
import com.hstairs.ppmajal.transition.Transition;
import com.hstairs.ppmajal.transition.TransitionGround;
import org.apache.commons.lang3.tuple.Pair;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author enrico
 */
public class PDDLSearchEngine extends SearchEngine {

    public PDDLSearchEngine(Heuristic h) {
        super(h);
    }

    @Override
    public LinkedList<Pair<Float,TransitionGround>> extractPlan (SimpleSearchNode input) {

        LinkedList<Pair<Float,TransitionGround>> plan = new LinkedList<>();
        lastState = input.s;
        if (!(input instanceof SearchNode)) {
            SimpleSearchNode temp = input;
            while (temp.transition != null) {
                Double time = null;

                plan.addFirst(Pair.of(0f,(TransitionGround)temp.transition));
                temp = temp.father;
            }
            return plan;
        }

        SearchNode c = (SearchNode) input;
        while ((c.transition != null || c.list_of_actions != null)) {
            Double time = null;
            if (c.father != null && c.father.s instanceof PDDLState) {
                time = ((PDDLState) c.father.s).time;
            }
            if (c.transition != null) {//this is an action
                plan.addFirst(Pair.of(time.floatValue(),(TransitionGround)c.transition));
            } else {//this is a process or an event
                for (int k = c.list_of_actions.size() - 1; k >= 0; k--) {
                    TransitionGround w = (TransitionGround) c.list_of_actions.get(k);
                    if (w.getSemantics() == Transition.Semantics.PROCESS) {
                        //w.setName("--------->waiting");
                        plan.addFirst(Pair.of(0f,w));
                    } else {
                        plan.addFirst(Pair.of(0f,w));
                    }
                }
            }
            c = (SearchNode) c.father;

        }

        return plan;
    }


}

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

import com.hstairs.ppmajal.problem.GroundAction;
import com.hstairs.ppmajal.problem.GroundProcess;
import com.hstairs.ppmajal.problem.PDDLState;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author enrico
 */
public class PDDLSearchEngine extends SearchEngine {

    @Override
    public LinkedList<GroundAction> extractPlan (SearchNode c) {
        LinkedList<GroundAction> plan = new LinkedList<>();
        lastState = c.s;
        while (c.transition != null || c.list_of_actions != null) {
            Double time = null;
            if (c.father.s instanceof PDDLState) {
                time = ((PDDLState) c.father.s).time;
            }
            if (c.transition != null) {//this is an action
                GroundAction gr = null;
                try {
                    gr = (GroundAction) ((GroundAction) c.transition).clone();
                    if (time != null) {
                        gr.time = time.floatValue();
                    } else {
                        gr.time = 0f;
                    }

                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(PDDLSearchEngine.class.getName()).log(Level.SEVERE, null, ex);
                }

                plan.addFirst(gr);
            } else {//this is a process or an event
                for (int k = c.list_of_actions.size() - 1; k >= 0; k--) {
                    GroundAction w = (GroundAction) c.list_of_actions.get(k);
                    if (w instanceof GroundProcess) {
                        w.setName("--------->waiting");
                        plan.addFirst(w);
                    } else {
                        //w.setName("--------->waiting");
//                            ((GroundEvent) w).time = new Float(time);
                        plan.addFirst(w);
                    }
                }
            }
            c = c.father;

        }

        return plan;
    }

}

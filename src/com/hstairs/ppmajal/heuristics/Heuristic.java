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
package com.hstairs.ppmajal.heuristics;

import com.hstairs.ppmajal.conditions.*;
import com.hstairs.ppmajal.problem.*;
import com.hstairs.ppmajal.transition.Transition;
import com.hstairs.ppmajal.transition.TransitionGround;

import java.util.*;


/**
 * @author enrico
 */
public interface Heuristic {

    float computeEstimate(State s);

    default Float gValue(State s, Object act, State temp, float gValue, Metric m) {
        TransitionGround gr = (TransitionGround) act;
        if (gr == null) {
            return gValue;
        }
        return getTransitionCost(s, gr,gValue,false,m);
    }
    default float getTransitionCost(State s, TransitionGround gr, Float previousG, boolean ignoreCost, Metric m){
        if (ignoreCost){
            return previousG + 1;
        }
        if (m != null){
            return previousG + gr.getActionCost(s,m);
        }else{
            return previousG + 1;
        }
    }

    Collection<TransitionGround> getTransitions(final boolean helpful);
}

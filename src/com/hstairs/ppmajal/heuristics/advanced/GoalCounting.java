/*
 * Copyright (C) 2019 enrico.
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
package com.hstairs.ppmajal.heuristics.advanced;

import com.hstairs.ppmajal.conditions.AndCond;
import com.hstairs.ppmajal.conditions.Condition;
import com.hstairs.ppmajal.heuristics.Aibr;
import com.hstairs.ppmajal.problem.EPddlProblem;
import com.hstairs.ppmajal.problem.State;
import java.util.Collection;

/**
 *
 * @author enrico
 */
public class GoalCounting extends Aibr{

    public GoalCounting(EPddlProblem problem) {
        super(problem);
    }


    @Override
    public Float computeEstimate(State s_0) {
        if (reachability){
            return super.computeEstimate(s_0);
        }
        int counter = 0;
        if (this.G instanceof AndCond){
            for (Condition c: (Collection<Condition>)G.sons){
                if (!c.isSatisfied(s_0)){
                    counter++;
                }
            }
        }
        return (float)counter;
        
    }
    
}

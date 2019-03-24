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
import com.hstairs.ppmajal.conditions.OrCond;
import com.hstairs.ppmajal.conditions.Terminal;
import com.hstairs.ppmajal.heuristics.Aibr;
import com.hstairs.ppmajal.problem.EPddlProblem;
import com.hstairs.ppmajal.problem.State;
import java.util.Collection;
import java.util.Stack;

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
        return (float)computeCost(G,s_0);
        
    }
    
    
    private int computeCost(Condition c, State s){
        if (c instanceof Terminal){
            return c.isSatisfied(s) ? 0 : 1;
        }else if (c instanceof AndCond){
            int counter = 0;
            for (final Condition cSon : (Collection<Condition>)((AndCond)c).sons){
                counter+=computeCost(cSon,s);
            }
            return counter;
        }else if (c instanceof OrCond){
            int subcost = 0;
            for (final Condition cSon : (Collection<Condition>)((OrCond)c).sons){
                subcost = computeCost(cSon,s);
                if (subcost == 0){
                    return 0;
                }
            }
            return subcost;
        }else{
            throw new UnsupportedOperationException("Goal Counting does not support "+c.getClass());
        }
    }
}

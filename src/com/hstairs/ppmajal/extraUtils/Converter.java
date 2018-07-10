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
package com.hstairs.ppmajal.extraUtils;

import com.hstairs.ppmajal.conditions.AndCond;
import com.hstairs.ppmajal.conditions.Predicate;
import com.hstairs.ppmajal.expressions.NumEffect;
import com.hstairs.ppmajal.expressions.NumFluent;
import com.hstairs.ppmajal.expressions.PDDLNumber;
import com.hstairs.ppmajal.problem.GroundAction;
import com.hstairs.ppmajal.problem.PDDLState;
import com.hstairs.ppmajal.problem.PddlProblem;

/**
 *
 * @author enrico
 */
public class Converter {
    
    static public GroundAction createInitAction(PddlProblem p, PDDLState s) {
        GroundAction a = new GroundAction("InitAction");

        AndCond addList = new AndCond();
        AndCond numericEffects = new AndCond();

        for (Predicate pred : p.getPredicatesInvolvedInInit()) {
            addList.addConditions(pred);
        }
        for (Object o : p.getNumFluentsInvolvedInInit()) {
            NumFluent f = (NumFluent) o;

            NumEffect b = new NumEffect("assign");
            b.setFluentAffected(f);

            b.setRight(new PDDLNumber(s.fluentValue(f)));
            numericEffects.addExpression(b);
        }
        a.setAddList(addList);
        a.setNumericEffects(numericEffects);

        return a;

    }
}

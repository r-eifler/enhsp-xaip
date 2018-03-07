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
package conditions;

import expressions.NumFluent;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import problem.RelState;
import problem.PDDLState;
import problem.State;

/**
 *
 * @author enrico
 */
public interface PostCondition {

    /**
     * Applies this post condition to the specified state and stores the result
     * in the specified map.
     *
     * @param s the current state to which the post condition is applied.
     * @param modifications a map that associates every variable whose value is
     * assigned by the post condition with its new value (boolean or float).
     */
    public abstract void apply(State s, Map modifications);

    /**
     * Applies this post condition to the specified rel state and stores the
     * result in the specified map.
     *
     * @param s the current state to which the post condition is applied.
     * @param modifications a map that associates every variable whose value is
     * assigned by the post condition with its new value (boolean or float).
     */
    public abstract void apply(RelState s, Map modifications);

    /**
     * Returns a string representation of this condition in PDDL format.
     *
     * @param typeInformation <tt>true</tt>
     * if the type of the object should be printed as well.
     * @return a string representation in PDDL format of this condition.
     */
    public abstract String pddlPrint(boolean typeInformation);

    /**
     * Prints this condition in PDDL format in the specified string builder.
     *
     * @param typeInformation <tt>true</tt>
     * if the type of the object should be printed as well.
     * @param bui the string builder where this condition is printed.
     */
    public abstract void pddlPrint(boolean typeInformation, StringBuilder bui);

    public abstract HashMap<Object, Object> apply(PDDLState s);

    public abstract HashMap<Object, Object> apply(RelState s);

    public abstract Object clone();

    public abstract String pddlPrintWithExtraObject();

    public abstract Condition achieve(Predicate p);

    public abstract Condition delete(Predicate p);

    public abstract Set<NumFluent> affectedNumericFluents();

}

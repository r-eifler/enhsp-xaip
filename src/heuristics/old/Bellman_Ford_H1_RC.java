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
package heuristics.old;

import conditions.Conditions;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import problem.GroundAction;
//import gurobi.*;

/**
 *
 * @author enrico
 */
public class Bellman_Ford_H1_RC extends Bellman_Ford_H1 {

    public Bellman_Ford_H1_RC(Conditions G, Set<GroundAction> A) {
        super(G, A);
        try {
            this.add_redundant_constraints();
        } catch (Exception ex) {
            Logger.getLogger(Bellman_Ford_H1_RC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

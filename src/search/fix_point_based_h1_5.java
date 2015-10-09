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
 */
/**
 * *******************************************************************
 * Description: Part of the PPMaJaL library
 *
 * Author: Enrico Scala 2013 Contact: enricos83@gmail.com
 *
 ********************************************************************
 */
package search;

import conditions.AndCond;
import conditions.Comparison;
import conditions.Conditions;
import conditions.Predicate;
import expressions.NormExpression;
import expressions.NumEffect;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import problem.GroundAction;
import problem.RelState;
import problem.State;
//import gurobi.*;

/**
 *
 * @author enrico
 */
public class fix_point_based_h1_5 extends fix_point_based_h1 {

    private Integer counter;
    private HashMap<Conditions, LinkedHashSet<GroundAction>> poss_contributors;
    private HashMap<Conditions, Boolean> is_complex;
    private boolean greedy;

    public fix_point_based_h1_5(Conditions G, Set<GroundAction> A) {
        super(G, A);
        try {
            this.add_redundant_constraints();
        } catch (Exception ex) {
            Logger.getLogger(fix_point_based_h1_5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void add_redundant_constraints() throws Exception {
        for (GroundAction a : A) {
            if (a.getPreconditions() != null) {
                compute_redundant_constraint((Set<Conditions>) a.getPreconditions().sons);
            }
        }
        compute_redundant_constraint((Set<Conditions>) G.sons);
    }

    private void compute_redundant_constraint(Set<Conditions> set) throws Exception {
        LinkedHashSet temp = new LinkedHashSet();

        ArrayList<Conditions> set_as_array = new ArrayList(set);

        for (int i = 0; i < set_as_array.size(); i++) {
            for (int j = i + 1; j < set_as_array.size(); j++) {
                Conditions c_1 = set_as_array.get(i);
                Conditions c_2 = set_as_array.get(j);
                if ((c_1 instanceof Comparison) && (c_2 instanceof Comparison)) {
                    Comparison a1 = (Comparison) c_1;
                    Comparison a2 = (Comparison) c_2;
                    NormExpression lhs_a1 = (NormExpression) a1.getLeft();
                    NormExpression lhs_a2 = (NormExpression) a2.getLeft();
                    NormExpression expr = lhs_a1.sum_copy(lhs_a2);
                    String new_comparator = ">=";
                    if (a1.getComparator().equals(">") && a2.getComparator().equals(">")) {
                        new_comparator = ">";
                    }
                    Comparison newC = new Comparison(new_comparator);
                    newC.setLeft(expr);
                    newC.setRight(new NormExpression(new Float(0.0)));
                    temp.add(newC);
                }
            }
        }

        set.addAll(temp);
    }
}

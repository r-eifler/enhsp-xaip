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
package problem;

import conditions.AndCond;
import conditions.Conditions;
import domain.ParametersAsTerms;
import domain.PddlDomain;
import domain.SchemaGlobalConstraint;
import expressions.NumEffect;
import java.util.HashMap;

/**
 *
 * @author enrico
 */
public class GlobalConstraint extends SchemaGlobalConstraint{

    public ParametersAsTerms grn_parameters;
    private boolean normalized;
    private boolean reacheable;
    public GlobalConstraint(String name) {
        super(name);
    }

    boolean simplifyModelWithControllableVariablesSem(PddlDomain domain, PddlSCProblem problem) {
        
      
        HashMap abstractInvariantFluents = domain.generateAbstractInvariantFluents();

        GlobalConstraint constr = this;
        //a.normalizeAndCopy();

        Conditions con = constr.condition;
        con.setFreeVarSemantic(true);
        //System.out.println(con);
        //con.normalize();
        //System.out.println(con);
        con = con.weakEval(problem.getInit(), abstractInvariantFluents);
 
        if (con == null || con.isUnsatisfiable()){
//            if (con == null)
//                System.out.println("A precondition is never satisfiable; pruning"+a.toEcoString());
            return false;
        }

        //System.out.println(a.toPDDL());
//        System.out.println(constr);
        constr.normalize();
//        System.out.println(constr);
//        if (a.isUnsatisfiable())
//            return false;
        //System.out.println(a.toPDDL());
        return true;
    }

    private void normalize() {
        if (normalized) {
            return;
        }
        this.condition.normalize();
        if (this.condition.isUnsatisfiable()) {
            this.setReacheable(false);
        }
        this.normalized = true;
    }

    /**
     * @return the reacheable
     */
    public boolean isReacheable() {
        return reacheable;
    }

    /**
     * @param reacheable the reacheable to set
     */
    public void setReacheable(boolean reacheable) {
        this.reacheable = reacheable;
    }
    
}

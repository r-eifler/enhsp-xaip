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

import conditions.Conditions;
import conditions.NotCond;
import conditions.OrCond;
import conditions.Predicate;
import domain.ParametersAsTerms;
import domain.PddlDomain;
import domain.SchemaGlobalConstraint;
import expressions.NumFluent;
import java.util.Collection;
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

    boolean simplifyModelWithControllableVariablesSem(PddlDomain domain, PddlSCProblem problem) throws Exception {
        
      
        HashMap invariantFluents = problem.getInvariantFluents();
        //add invariantFluents because free variable
        for (NumFluent nf : (Collection<NumFluent>)domain.getFree_functions()){
            invariantFluents.put(nf.getName(),Boolean.FALSE);
        }
        
        GlobalConstraint constr = this;
        //a.normalizeAndCopy();

        Conditions con = constr.condition;
        con.setFreeVarSemantic(true);
        //System.out.println(con);
        //con.normalize();
        //System.out.println(con);
        con = con.weakEval(problem.getInit(), invariantFluents);
 
        
        
        if (con == null || con.isUnsatisfiable()){
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

    public boolean isTautology(State reacheableState) {
        
        //for now tautology is checked for disjunction in which one of the element is always true
        if (this.condition instanceof OrCond){
            OrCond or = (OrCond)this.condition;
            for (Conditions c : (Collection<Conditions>)or.sons){
                if (c instanceof NotCond){
                    NotCond nc = (NotCond)c;
                    Object o = nc.son.iterator().next();
                    if (o instanceof Predicate){
                        Predicate p = (Predicate)o;
                        if (!p.isSatisfied(reacheableState))
                            return true;
                    }
                }
            }
        }
            
        return false;
    }
    
}

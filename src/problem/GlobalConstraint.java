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
import domain.SchemaParameters;
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
    private boolean reachable;
    public GlobalConstraint(String name) {
        super(name);
    }

    @Override
    public Object clone(){
        GlobalConstraint cloned = new GlobalConstraint(this.name);
        cloned.normalized = this.normalized;
        cloned.reachable = this.reachable;
        cloned.condition = this.condition.clone();
        cloned.grn_parameters = (ParametersAsTerms) this.grn_parameters.clone();
        cloned.parameters = (SchemaParameters) this.parameters.clone();
        return cloned;
    }
    
    boolean simplifyModelWithControllableVariablesSem(PddlDomain domain, EPddlProblem problem) throws Exception {
        
      
        HashMap invariantFluents = problem.getVariantFluents();
        //add invariantFluents because free variable
        for (NumFluent nf : (Collection<NumFluent>)domain.get_derived_variables()){
            invariantFluents.put(nf.getName(),Boolean.FALSE);
        }
        
        GlobalConstraint constr = this;
        //a.normalizeAndCopy();

        Conditions con = constr.condition;
        con.setFreeVarSemantic(true);
        //System.out.println(con);
        //con.normalize();
        //System.out.println(con);
        
        //This needs to be fixed. The semantics of global constraints is different
        //from that of the actions. 
        con = con.weakEval(problem.getInit(), invariantFluents);
 
        this.condition = con;
        
        
        //if (con == null || con.isUnsatisfiable()){
        //    return false;
        //}

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
        return reachable;
    }

    /**
     * @param reacheable the reacheable to set
     */
    public void setReacheable(boolean reacheable) {
        this.reachable = reacheable;
    }

    public boolean isTautology(State reacheableState) {
        
        //for now tautology is checked for disjunction in which one of the element is always true
        if (this.condition instanceof OrCond){
            OrCond or = (OrCond)this.condition;
            for (Conditions c : (Collection<Conditions>)or.sons){
                if (c instanceof NotCond){
                    NotCond nc = (NotCond)c;
                    Object o = nc.getSon();
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
    public boolean isTautology(RelState reacheableState) {
        
        //for now tautology is checked for disjunction in which one of the element is always true
        if (this.condition instanceof OrCond){
            OrCond or = (OrCond)this.condition;
            for (Conditions c : (Collection<Conditions>)or.sons){
                if (c instanceof NotCond){
                    NotCond nc = (NotCond)c;
                    Object o = nc.getSon();
                    if (o instanceof Predicate){
                        Predicate p = (Predicate)o;
                        if (!p.can_be_true(reacheableState))
                            return true;
                    }
                }
            }
        }
            
        return false;
    }
    
}

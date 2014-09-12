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
package domain;

import conditions.AndCond;
import conditions.NotCond;

import conditions.PDDLObject;
import conditions.Predicate;
import expressions.NumEffect;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import problem.GroundAction;

/**
 *
 * @author enrico
 */
public class ActionSchema extends GenericActionType {

    private ActionParameters parameters;

    public ActionSchema() {
        super();
        parameters = new ActionParameters();

    }

//
//    public Action ground(ArrayList terms){
//        
//        
//        substitution = new HashMap();
//        
//        
//    }
    /**
     * @return the parameters
     */
    public ActionParameters getParameters() {
        return parameters;
    }

    /**
     * @param parameters the parameters to set
     */
    public void setParameters(ActionParameters parameters) {
        this.parameters = parameters;
    }

    public void addParameter(Variable o) {

        parameters.add(o);

    }

    public GroundAction ground(Map substitution) {
        GroundAction ret = new GroundAction(this.name);
        ActionParametersAsTerms input = new ActionParametersAsTerms();
        for (Object o : parameters) {
            Variable el = (Variable) o;
            PDDLObject t = (PDDLObject) substitution.get(el);
            input.add(t);
        }
        ret.setParameters(input);

        ret.setNumericEffects(this.numericEffects.ground(substitution));
        ret.setAddList(this.addList.ground(substitution));
        ret.setDelList(this.delList.ground(substitution));
        ret.setPreconditions(this.preconditions.ground(substitution));




        return ret;

    }

    public GroundAction ground(ActionParametersAsTerms par) {
        GroundAction ret = new GroundAction(this.name);
        ActionParametersAsTerms input = new ActionParametersAsTerms();
        int i = 0;

        Map substitution = new HashMap();
        for (Object o : parameters) {
            Variable el = (Variable) o;
            substitution.put(el, par.get(i));
            PDDLObject t = (PDDLObject) substitution.get(el);
            i++;
        }
        ret.setParameters(par);

        //System.out.println(this);
        if (numericEffects!= null || !numericEffects.sons.isEmpty())
            ret.setNumericEffects(this.numericEffects.ground(substitution));
        if (addList != null) {
            ret.setAddList(this.addList.ground(substitution));
        }
        if (delList != null) {
            ret.setDelList(this.delList.ground(substitution));
        }
        if (preconditions != null) {
            ret.setPreconditions(this.preconditions.ground(substitution));
        }

        return ret;
    }

    @Override
    public String toString() {
//        String parametri = "";
//        for (Object o : parameters) {
//            parametri = parametri.concat(o.toString()).concat(" ");
//        }
//        return "\n\nAction Name:" + this.name + " Parameters: " + parametri + "\nPre: " + this.preconditions + "\nEffetti positivi: " + this.getAddList() + "\nEffetti negativi: " + this.getDelList() + "\nNumeric Effects:  " + this.getNumericEffects();
//    }

        String ret = "(:action " + this.name + "\n";

        ret += ":parameters " + this.getParameters() + "\n";
        ret += ":precondition " + this.getPreconditions().pddlPrint(false) + "\n";
        ret += ":effect " + this.pddlEffects();

        return ret + ")";
    }

    private String pddlEffects() {
        String ret = "(and ";
        if (this.getAddList() != null) {
            for (Object o : this.getAddList().sons) {
                Predicate p = (Predicate) o;
                ret += p.pddlPrint(false);
            }
        }
        if (this.getDelList() != null) {
            for (Object o : this.getDelList().sons) {
                NotCond p = (NotCond) o;
                ret += p.pddlPrint(false);
            }
        }
        if (this.getNumericEffects() != null) {
            for (Object o : this.getNumericEffects().sons) {
                NumEffect nE = (NumEffect) o;
                ret += nE.pddlPrint(false);

            }
        }

        return ret + ")";
    }

    public Set getAbstractNumericFluentAffected() {
        HashSet anfa = new HashSet();
        for (Object o: this.numericEffects.sons){
            if (o instanceof AndCond){
                AndCond a = (AndCond)o;
                for (Object o1: a.sons){
                    if (o1 instanceof NumEffect){
                        NumEffect ne = (NumEffect)o1;
                        anfa.add(ne.getFluentAffected());
                    }    
                }
                
            }else if (o instanceof NumEffect){
                NumEffect ne = (NumEffect)o;
                anfa.add(ne.getFluentAffected());
            }
        }
        return anfa;
    }
}

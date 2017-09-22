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
package domain;

import conditions.PDDLObject;
import java.util.HashMap;
import java.util.Map;
import problem.GroundEvent;
import problem.PDDLObjects;

/**
 *
 * @author enrico
 */
public class EventSchema extends ActionSchema {

    public GroundEvent ground() {
        GroundEvent ret = new GroundEvent(this.name);
        ParametersAsTerms input = new ParametersAsTerms();

        ret.setParameters(input);
        ret.setPreconditions(preconditions);
        ret.setAddList(addList);
        ret.setDelList(delList);
        ret.setNumericEffects(numericEffects);
        ret.cond_effects = cond_effects;
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

        String ret = "(:event " + this.name + "\n";

        ret += ":parameters " + this.parameters + "\n";
        ret += ":precondition " + this.getPreconditions().pddlPrint(false) + "\n";
        //ret += ":effect " + this.pddlEffectsWithExtraObject();
        ret += ":effect " + this.pddlEffects() + "\n";

        return ret + ")";
    }

    public GroundEvent ground(ParametersAsTerms par, PDDLObjects po) {
        GroundEvent ret = new GroundEvent(this.name);
        int i = 0;

        Map substitution = new HashMap();
        for (Object o : parameters) {
            Variable el = (Variable) o;
            substitution.put(el, par.get(i));
            PDDLObject t = (PDDLObject) substitution.get(el);
            i++;
        }
        ret.setParameters(par);

//        System.out.println(this);
        if (numericEffects != null || !numericEffects.sons.isEmpty()) {
            //System.out.println(this);
            ret.setNumericEffects(this.numericEffects.ground(substitution, po));
        }
        if (addList != null) {
            ret.setAddList(this.addList.ground(substitution, po));
        }
        if (delList != null) {
            ret.setDelList(this.delList.ground(substitution, po));
        }
        if (preconditions != null) {
            ret.setPreconditions(this.preconditions.ground(substitution, po));
        }
        if (cond_effects != null) {
//            System.out.println("DEBUG: Before:"+cond_effects);
            ret.cond_effects = this.cond_effects.ground(substitution, po);
//            System.out.println("DEBUG: after:"+cond_effects);

        }

        return ret;
    }
}

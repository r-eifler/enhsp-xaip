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
package problem;

import conditions.AndCond;
import conditions.ComplexCondition;
import conditions.PDDLObject;
import domain.ParametersAsTerms;
import java.util.HashMap;

/**
 *
 * @author enrico
 */
public class GroundEvent extends GroundAction {

    public GroundEvent(String name) {
        super(name);
    }

    @Override
    public String toPDDL() {

        String ret = "(:event " + this.name + "\n";

        ret += ":parameters ()\n";
        ret += ":precondition " + this.getPreconditions().pddlPrint(false) + "\n";
        ret += ":effect " + this.pddlEffects();

        return ret + ")";

    }

    public String toFileCompliant() {

        String parametri = "";
        for (Object o : getParameters()) {
            PDDLObject obj = (PDDLObject) o;
            parametri = parametri.concat(obj.getName().concat(" "));
        }
        if (time == null) {
            return ";(" + this.name + " " + parametri + ")";
        } else {
            return ";" + String.format("%.5f", time) + ": (" + this.name + " " + parametri + ")";
        }

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        GroundEvent ret = new GroundEvent(name);
        if (this.addList != null) {
            ret.addList = (AndCond) this.addList.clone();
        }
        if (this.delList != null) {
            ret.delList = (AndCond) this.delList.clone();
        }
        ret.normalized = this.normalized;
        if (this.numericEffects != null) {
            ret.numericEffects = (AndCond) this.numericEffects.clone();
        }
        if (this.cond_effects != null) {
            ret.cond_effects = (AndCond) this.cond_effects.clone();
        }

        if (this.numericFluentAffected != null) {
            ret.numericFluentAffected = (HashMap) this.numericFluentAffected.clone();
        }
        if (this.parameters_as_terms != null) {
            ret.parameters_as_terms = (ParametersAsTerms) this.parameters_as_terms.clone();
        }
        if (this.preconditions != null) {
            ret.preconditions = (ComplexCondition) this.preconditions.clone();
        }

        return ret;

    }

}

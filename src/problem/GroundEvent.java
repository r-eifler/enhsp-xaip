
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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem;

import conditions.PDDLObject;
import domain.ParametersAsTerms;
import java.util.HashMap;

/**
 *
 * @author enrico
 */
public class GroundEvent extends GroundAction{

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
            return ";"+String.format("%.5f",time) + ": (" + this.name + " " + parametri + ")";
        }

    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        GroundEvent ret = new GroundEvent(name);
        if (this.addList != null) {
            ret.addList = this.addList.clone();
        }
        if (this.delList != null) {
            ret.delList = this.delList.clone();
        }
        ret.normalized = this.normalized;
        if (this.numericEffects != null) {
            ret.numericEffects = this.numericEffects.clone();
        }
        if (this.cond_effects != null) {
            ret.cond_effects = this.cond_effects.clone();
        }

        if (this.numericFluentAffected != null) {
            ret.numericFluentAffected = (HashMap) this.numericFluentAffected.clone();
        }
        if (this.parameters_as_terms != null) {
            ret.parameters_as_terms = (ParametersAsTerms) this.parameters_as_terms.clone();
        }
        if (this.preconditions != null) {
            ret.preconditions = this.preconditions.clone();
        }
        if (this.interact_with != null) {
            ret.interact_with = (HashMap<Integer, Boolean>) this.interact_with.clone();
        }
        return ret;

    }

}

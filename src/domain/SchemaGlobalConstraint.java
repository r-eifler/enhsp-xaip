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

import conditions.Conditions;
import conditions.PDDLObject;
import java.util.HashMap;
import java.util.Map;
import problem.GlobalConstraint;
import problem.GroundAction;

/**
 *
 * @author enrico
 */
public class SchemaGlobalConstraint {

    public SchemaParameters parameters;
    public Conditions condition;
    public String name;

    public SchemaGlobalConstraint(String name) {
        this.name = name;
        parameters = new SchemaParameters();
    }

    @Override
    public String toString() {
        return "SchemaGlobalConstraint{" + "parameters=" + parameters + ", condition=" + condition + ", name=" + name + '}';
    }

    public GlobalConstraint ground(ParametersAsTerms par) {
        GlobalConstraint ret = new GlobalConstraint(this.name);
        int i = 0;

        Map substitution = new HashMap();
        for (Object o : parameters) {
            Variable el = (Variable) o;
            substitution.put(el, par.get(i));
            i++;
        }
        ret.grn_parameters = par;

        if (this.condition != null) {
            ret.condition = this.condition.ground(substitution);
        }

        return ret;
    }

    public GlobalConstraint ground() {
        GlobalConstraint ret = new GlobalConstraint(this.name);

        ret.grn_parameters = new ParametersAsTerms();
        ret.condition = this.condition;

        return ret;   
    }

}

/*********************************************************************
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 * 
 *********************************************************************/

/*********************************************************************
 * Description: Part of the PPMaJaL library
 *             
 * Author: Enrico Scala 2013
 * Contact: enricos83@gmail.com
 *
 *********************************************************************/ 
package problem;

import conditions.AndCond;
import conditions.Conditions;

import domain.ActionParametersAsTerms;
import domain.GenericActionType;

@Deprecated
public class InstantiatedAction extends GenericActionType {

    protected ActionParametersAsTerms parameters;

    public InstantiatedAction(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String parametri = "";
        for (Object o : getParameters()) {
            parametri = parametri.concat(o.toString()).concat(" ");
        }
        return "\n\nAction Name:" + this.name + " Parameters: " + parametri + "\nPre: " + this.preconditions + "\nEffetti positivi: " + this.getAddList() + "\nEffetti negativi: " + this.getDelList() + "\nNumeric Effects:  " + this.getNumericEffects();

    }

    public String toEcoString() {
        String parametri = "";
        for (Object o : getParameters()) {
            parametri = parametri.concat(o.toString()).concat(" ");
        }
        return "\n\nAction Name:" + this.name + " Parameters: " + parametri;

    }

    /**
     * @return the parameters
     */
    public ActionParametersAsTerms getParameters() {
        return parameters;
    }

    /**
     * @param parameters the parameters to set
     */
    public void setParameters(ActionParametersAsTerms parameters) {
        this.parameters = parameters;
    }

    public State apply(State s) {
        State ret = s;
        AndCond add = (AndCond) addList;
        ret = add.apply(s);
        AndCond del = (AndCond) delList;
        ret = del.apply(s);
        AndCond num = (AndCond) this.getNumericEffects();
        ret = num.apply(s);
        return ret;
    }
}

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
package propositionalFactory;

import conditions.PDDLObject;

import domain.ActionParameters;
import domain.ActionParametersAsTerms;
import domain.ActionSchema;


import domain.Variable;

import java.util.HashSet;

import java.lang.Exception;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

import java.util.List;
import java.util.Set;
import problem.GroundAction;

import problem.PDDLObjects;

public class ActionFactory {

    public ActionFactory() {
        super();
    }

    public Set Substitutions(ActionSchema a, PDDLObjects po) throws Exception {
        HashSet ret = new HashSet();
        Set combo = new HashSet();
        ActionParameters aP = a.getParameters();
        int n_parametri = a.getParameters().size();
        HashMap<PDDLObject, Variable>[] sub = new HashMap[n_parametri];
        int i = 0;


        if (aP.isEmpty()) {
            combo.add(new PDDLObject("null"));
            return combo;
        }


        for (Object el1 : aP) {
            sub[i] = new HashMap();
            //System.out.println("Variable" + el1);
            for (Object el : po) {
                PDDLObject t = (PDDLObject) el;
                Variable v = (Variable) el1;
                if ((v.getType().isAncestorOf(t.getType())) || (t.getType().equals(v.getType()))) {
                    sub[i].put(t, v);
                }
            }
            i++;
        }

        Integer[] sizes = new Integer[n_parametri];
        for (i = 0; i < n_parametri; i++) {
            sizes[i] = sub[i].keySet().size() - 1;
        }

        Integer[] counter = new Integer[n_parametri];
        for (i = 0; i < n_parametri; i++) {
            counter[i] = 0;
        }

        do {
//                System.out.print("Combo: ");
//                for(i=0; i<n_parametri;i++)
//                    System.out.print(counter[i]);
//                 System.out.println("");
////                 System.out.println(sub[0]);
////                 System.out.println(a);
            ActionParametersAsTerms toAdd = new ActionParametersAsTerms();
            for (int z = 0; z < n_parametri; z++) {
                //System.out.println(sub[z]);
                toAdd.add(sub[z].keySet().toArray()[counter[z]]);
            }
            combo.add(toAdd);

        } while (incVettore(counter, n_parametri - 1, sizes));

        return combo;
    }

    public boolean incVettore(Integer[] v, int n, Integer[] max) {

        if (n < 0) {
            return false;
        } else {
            if (v[n] == max[n]) {
                boolean temp = incVettore(v, n - 1, max);
                if (temp) {
                    v[n] = 0;
                    return true;
                } else {
                    return false;
                }
            } else {
                v[n]++;
                return true;
            }
        }
    }

    private List creaCombinazione(PDDLObjects O, ActionParameters aP, int index) {
        List ret = new ArrayList();
        if (index == aP.size() - 1) {
            for (Object el : O) {
                PDDLObject t = (PDDLObject) el;
                Variable v = (Variable) aP.get(index);
                if (t.getType().equals(v.getType())) {
                    ret.add(t);
                }
            }
        } else {
            List ret2 = creaCombinazione(O, aP, index + 1);
            for (Object el : O) {
                PDDLObject t = (PDDLObject) el;
                Variable v = (Variable) aP.get(index);
                if (t.getType().equals(v.getType())) {
                }
            }
        }
        return ret;
    }

    public Set Propositionalize(ActionSchema a, PDDLObjects po) throws Exception {
        Set ret = new LinkedHashSet();

        Set combo = Substitutions(a, po);
        for (Object o : combo) {
            if (o instanceof ActionParametersAsTerms){
                GroundAction toAdd =a.ground((ActionParametersAsTerms) o);
                toAdd.generateAffectedNumFluents();
                ret.add(toAdd);
            }
        }

        return ret;

    }
}

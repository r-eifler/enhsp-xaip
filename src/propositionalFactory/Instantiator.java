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
import domain.ActionSchema;
import domain.ParametersAsTerms;
import domain.ProcessSchema;
import domain.SchemaGlobalConstraint;
import domain.SchemaParameters;
import domain.Variable;

import java.lang.Exception;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import problem.GlobalConstraint;
import problem.GroundAction;
import problem.GroundProcess;
import problem.PDDLObjects;

public class Instantiator {

    public Instantiator() {
        super();
    }

    public Set Substitutions(ActionSchema a, PDDLObjects po) throws Exception {
        HashSet ret = new HashSet();
        Set combo = new HashSet();
        SchemaParameters param = a.getParameters();
        int n_parametri = a.getParameters().size();
        return sub(param,n_parametri,po);

    }
    
    public Set Substitutions(ProcessSchema a, PDDLObjects po) throws Exception {
        HashSet ret = new HashSet();
        Set combo = new HashSet();
        SchemaParameters param = a.getParameters();
        int n_parametri = a.getParameters().size();
        return sub(param,n_parametri,po);

    }

    public Set Substitutions(SchemaGlobalConstraint constr, PDDLObjects po) throws Exception {
        SchemaParameters param = constr.parameters;
        int n_parametri = constr.parameters.size();
        
        return sub(param,n_parametri,po);
        
        
    }

    
    public boolean incVettore(Integer[] v, int n, Integer[] max) {

        if (n < 0) {
            return false;
        } else {
            if (v[n] >= max[n]) {
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

    private List creaCombinazione(PDDLObjects O, SchemaParameters aP, int index) {
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
            if (o instanceof ParametersAsTerms){
                GroundAction toAdd =a.ground((ParametersAsTerms) o);
                toAdd.generateAffectedNumFluents();
                ret.add(toAdd);
            }
        }

        return ret;

    }
    
    public Set Propositionalize(ProcessSchema a, PDDLObjects po) throws Exception {
        Set ret = new LinkedHashSet();

        Set combo = Substitutions(a, po);
        for (Object o : combo) {
            if (o instanceof ParametersAsTerms){
                GroundProcess toAdd =a.ground((ParametersAsTerms) o);
                toAdd.generateAffectedNumFluents();
                ret.add(toAdd);
            }
        }

        return ret;

    }
    
    public Set Propositionalize(SchemaGlobalConstraint constr, PDDLObjects po) throws Exception {
        Set ret = new LinkedHashSet();

        Set combo = Substitutions(constr, po);
        for (Object o : combo) {
            if (o instanceof ParametersAsTerms){
                GlobalConstraint toAdd =constr.ground((ParametersAsTerms) o);
                ret.add(toAdd);
            }
        }

        return ret;

    }

    private Set sub(SchemaParameters param, int n_parametri, PDDLObjects po) {
        HashSet combo = new HashSet();
        ArrayList<PDDLObject>[] sub = new ArrayList[n_parametri];
        
        int i = 0;

        if (po.isEmpty())
            return combo;
        

        if (param.isEmpty()) {
            combo.add(new PDDLObject("null"));
            return combo;
        }


        //for each parameter in the action schema, look for all the possible substitutions.
        for (Object el1 : param) {
            sub[i] = new ArrayList();
            //System.out.println("Variable" + el1);
            boolean at_least_one = false;
            for (Object el : po) {
                PDDLObject t = (PDDLObject) el;
                Variable v = (Variable) el1;
                if ((v.getType().isAncestorOf(t.getType())) || (t.getType().equals(v.getType()))) {
                    sub[i].add(t);
                    at_least_one = true;
                }
            }
            if (!at_least_one)
                return combo;
            //System.out.println("Number of Substitution captured:"+sub[i].keySet().size());
            i++;
            
        }
        
        //This keeps track of the size of each set of objects, for each variable within the action schema
        Integer[] sizes = new Integer[n_parametri];
        for (i = 0; i < n_parametri; i++) {
            sizes[i] = sub[i].size() - 1;
            //System.out.println(sizes[i]);
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
            ParametersAsTerms toAdd = new ParametersAsTerms();
            for (int z = 0; z < n_parametri; z++) {
//                System.out.println("z: "+z);
//                System.out.println("counter[z]: "+counter[z]);
//                System.out.println(sub[z].keySet());
                //if (sub[z].size()<counter[z])
                toAdd.add(sub[z].get(counter[z]));
                //else
                 //   break;
            }
            combo.add(toAdd);

        } while (incVettore(counter, n_parametri-1, sizes));

        return combo;
    }
    
    
}
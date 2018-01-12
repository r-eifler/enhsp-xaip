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
package propositionalFactory;

import conditions.Condition;
import conditions.PDDLObject;
import domain.ActionSchema;
import domain.EventSchema;
import domain.ParametersAsTerms;
import domain.ProcessSchema;
import domain.SchemaGlobalConstraint;
import domain.SchemaParameters;
import domain.Variable;

import java.lang.Exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import problem.GlobalConstraint;
import problem.PDDLGroundAction;
import problem.GroundEvent;
import problem.GroundProcess;
import problem.PDDLObjects;

public class Grounder {

    public Grounder() {
        super();
    }

    public Set Substitutions(ActionSchema a, PDDLObjects po) throws Exception {
        HashSet ret = new HashSet();
        Set combo = new HashSet();
        SchemaParameters param = a.getPar();
        int n_parametri = a.getPar().size();
        return sub(param, n_parametri, po);

    }

    public Set Substitutions(ProcessSchema a, PDDLObjects po) throws Exception {
        HashSet ret = new HashSet();
        Set combo = new HashSet();
        SchemaParameters param = a.getPar();
        int n_parametri = a.getPar().size();
        return sub(param, n_parametri, po);

    }

    public Set Substitutions(SchemaGlobalConstraint constr, PDDLObjects po) throws Exception {
        SchemaParameters param = constr.parameters;
        int n_parametri = constr.parameters.size();

        return sub(param, n_parametri, po);

    }

    public Set Substitutions(SchemaParameters param, PDDLObjects po) throws Exception {
        return sub(param, param.size(), po);

    }

    public static Set substitutions(ArrayList<Variable> input, PDDLObjects po) throws Exception {

        int n_parametri = input.size();

        Set<HashMap<Variable, PDDLObject>> ret = new LinkedHashSet();
        if (n_parametri == 0) {
            ret.add(new HashMap());
            return ret;
        }

        Set<ArrayList<PDDLObject>> sub_ret = sub(input, n_parametri, po);

        for (ArrayList<PDDLObject> ele : sub_ret) {
            int i = 0;

            HashMap<Variable, PDDLObject> substitution = new HashMap();
            for (Variable el : input) {
                substitution.put(el, ele.get(i));
                PDDLObject t = (PDDLObject) substitution.get(el);
                i++;
            }
            ret.add(substitution);

        }
        return ret;

    }

    private static boolean incVettore(Integer[] v, int n, Integer[] max) {

        if (n < 0) {
            return false;
        } else if (v[n] >= max[n]) {
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

    public static Set<HashMap<Variable, PDDLObject>> create_combos_ext(Set<Variable> variables, Set<PDDLObject> objects) {

        //assign integer 
        HashMap<Integer, Variable> int_to_var = new HashMap();
        Integer var_counter = 0;
        for (Variable v : variables) {
            int_to_var.put(var_counter, v);
            var_counter++;
        }

        HashMap<Integer, PDDLObject> int_to_obj = new HashMap();
        Integer obj_counter = 0;
        for (PDDLObject v : objects) {
            int_to_obj.put(obj_counter, v);
            obj_counter++;
        }
        return null;
    }

    public static Set<PDDLObject[]> create_combos(PDDLObject[][] poss, int i) {
        if (i >= poss.length) {
            return new LinkedHashSet();
        }
        if (i == poss.length - 1) {
            Set<PDDLObject[]> ret = new LinkedHashSet();
            for (int k = 0; k < poss[i].length; k++) {
                if (poss[k].length == 0) {
                    return ret;
                }
            }
            for (int k = 0; k < poss[i].length; k++) {
                PDDLObject[] ele = new PDDLObject[poss.length];
                for (int j = 0; j < poss.length - 1; j++) {
                    ele[j] = poss[j][0];
                }
                ele[i] = poss[i][k];
                ret.add(ele);
            }
            return ret;
        } else {
            Set<PDDLObject[]> ret = create_combos(poss, i + 1);
            Set<PDDLObject[]> ret2 = new LinkedHashSet();
            for (int k = 1; k < poss[i].length; k++) {
                for (PDDLObject[] ele : ret) {
                    PDDLObject[] ele2 = ele.clone();
                    ele2[i] = poss[i][k];
                    ret2.add(ele2);
                }
            }
            ret.addAll(ret2);
            return ret;
        }

    }

    public Set Propositionalize(ActionSchema a, PDDLObjects po) throws Exception {
        Set ret = new LinkedHashSet();

        Set combo = Substitutions(a, po);
        if (a.getPar().isEmpty()) {
            combo.add(new ParametersAsTerms());
        }
        for (Object o : combo) {

            if (o instanceof ParametersAsTerms) {
                if (a instanceof EventSchema) {
                    EventSchema b = (EventSchema) a;
                    GroundEvent toAdd = b.ground((ParametersAsTerms) o, po);
                    toAdd.generateAffectedNumFluents();
                    ret.add(toAdd);
                } else {
                    PDDLGroundAction toAdd = a.ground((ParametersAsTerms) o, po);
                    toAdd.generateAffectedNumFluents();
                    ret.add(toAdd);
                }
            }
        }

        return ret;

    }

    public Set Propositionalize(ProcessSchema a, PDDLObjects po) throws Exception {
        Set ret = new LinkedHashSet();

        Set combo = Substitutions(a, po);
        for (Object o : combo) {
            if (o instanceof ParametersAsTerms) {
                GroundProcess toAdd = a.ground((ParametersAsTerms) o, po);
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
            if (o instanceof ParametersAsTerms) {
                GlobalConstraint toAdd = constr.ground((ParametersAsTerms) o, po);
                ret.add(toAdd);
            }
        }

        return ret;

    }
    
    

    public static Set sub(ArrayList param, int n_parametri, PDDLObjects po) {
        HashSet combo = new HashSet();
        ArrayList<PDDLObject>[] sub = new ArrayList[n_parametri];

        int i = 0;

        if (po.isEmpty()) {
            return combo;
        }

        if (param.isEmpty()) {
            //combo.add(new PDDLObject("null"));
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
            if (!at_least_one) {
                return combo;
            }
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

        } while (incVettore(counter, n_parametri - 1, sizes));

        return combo;
    }

    private Set sub(SchemaParameters param, int n_parametri, PDDLObjects po) {
        HashSet combo = new HashSet();
        ArrayList<PDDLObject>[] sub = new ArrayList[n_parametri];

        int i = 0;

        if (po.isEmpty()) {
            return combo;
        }

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
            if (!at_least_one) {
                return combo;
            }
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

        } while (incVettore(counter, n_parametri - 1, sizes));

        return combo;
    }

    public Map obtain_sub_from_instance(SchemaParameters parameters, ParametersAsTerms par) {

        int i = 0;
        Map substitution = new HashMap();
        for (Object o : parameters) {
            Variable el = (Variable) o;
            substitution.put(el, par.get(i));
            i++;
        }
        return substitution;

    }
}

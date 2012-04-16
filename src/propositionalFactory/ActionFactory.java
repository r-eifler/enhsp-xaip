package propositionalFactory;

import conditions.Term;

import domain.ActionParameters;
import domain.ActionSchema;


import domain.Type;
import domain.Variable;

import java.util.HashSet;

import java.lang.Exception;

import java.lang.reflect.Array;

import java.util.ArrayList;
import java.util.BitSet;

import java.util.List;

import problem.InstatiatedAction;
import problem.PlanningObjects;

public class ActionFactory {
    public ActionFactory() {
        super();
    }

    public HashSet Substitution(ActionSchema a, PlanningObjects po) throws Exception {
        HashSet ret = new HashSet();
        ActionParameters aP = a.getParameters();
        Type[] types;
        types = new Type[aP.size()];

        BitSet bt = new BitSet(po.size());


        Type t;
        int i=0;
        for (Object el : aP) {
            Variable v = (Variable)el;
            t = v.getType();
            if (t == null) {
                throw new Exception("Some Object has no declared Type");
            }
            types[i]= t;
            i++;
        }
//        System.out.println("Parametri interessati:" + types.size());
        System.out.println("Unificazione dell'azione " + a.getName() + ":" +
                           creaCombinazione(po, types, aP.size(), aP.size()));
        return ret;
    }

    public List creaCombinazione(PlanningObjects O, Type[] l, int index,int max) {
        List ret = new ArrayList();
        if (index == 1) {
            for (Object el : O) {
                Term t = (Term)el;
                Type l1 = (Type)l[index-1];
                System.out.println("Foglia: Confronto:" + t.getType().getName() + "con : " + l1.getName());

                if (t.getType().equals(l1)) {
                    ret.add(t);
                }
            }
        } else {
            List ret2 = creaCombinazione(O, l, index - 1,max);
            for (Object el : O) {
                Term t = (Term)el;
                Type l1 = (Type)l[index - 1];
                Type tT = (Type)t.getType();
                if (t.getType().equals(l1)) {
                    for (Object el2 : ret2) {
                        //List temp = new ArrayList();
                        //temp.add(el2);
                        //temp.add(t);
                        
                        
                                
                                ret.add(el2);
                        
                            
                        
                    }
                    ret.add(t);
                }
            }
        }

        return ret;
    }
}



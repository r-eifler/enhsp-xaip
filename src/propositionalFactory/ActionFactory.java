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

import java.util.List;
import java.util.Set;

import problem.ProblemObjects;

public class ActionFactory {

    public ActionFactory() {
        super();
    }

    public Set Substitutions(ActionSchema a, ProblemObjects po) throws Exception {
        HashSet ret = new HashSet();
        Set combo = new HashSet();
        ActionParameters aP = a.getParameters();
        int n_parametri = a.getParameters().size();
        HashMap<PDDLObject,Variable>[] sub = new HashMap[n_parametri];
        int i=0;
        for(Object el1: aP){
            sub[i] = new HashMap();
            //System.out.println("Variable" + el1);
            for (Object el : po) {
                PDDLObject t = (PDDLObject) el;
                Variable v = (Variable) el1;
                if (t.getType().equals(v.getType())) {
                    sub[i].put(t,v);
                }
            }
            i++;
        }

        Integer[] sizes = new Integer[n_parametri];
        for(i=0; i<n_parametri;i++){
            sizes[i] = sub[i].keySet().size()-1;
        }
//        for(i=0; i<n_parametri;i++){
//            System.out.println("Size delle mappature" + sizes[i]);
//        }
//        int j = n_parametri-1;
//        boolean jump=false;

        Integer[] counter = new Integer[n_parametri];
        for(i=0; i<n_parametri;i++){
            counter[i]=0;
        }

        do{
//                System.out.print("Combo: ");
//                for(i=0; i<n_parametri;i++)
//                    System.out.print(counter[i]);
//                 System.out.println("");
          
                ActionParametersAsTerms toAdd = new ActionParametersAsTerms();
                for (int z=0;z<n_parametri;z++){
                    toAdd.add(sub[z].keySet().toArray()[counter[z]]);
                }
                combo.add(toAdd);
          
        }while (incVettore(counter,n_parametri-1,sizes));
//        System.out.println("Combinazioni:" + combo);
//        System.out.println("numero delle combinazioni:" + combo.size() );
//        
//        ActionParametersAsTerms ap = (ActionParametersAsTerms)combo.get(0);
//        GroundAction gr = a.ground(ap);
//
//        System.out.println("prova2:"+gr);
//        
//        System.out.println("Grandezza delle mappature:" + sizes);
////
//
//
//
//
//
////        System.out.println("Parametri interessati:" + types.size());
//        System.out.println("numero di unificazioni " + a.getName() + ":"
//                + creaCombinazione(po, aP, 0));
//         
       return combo;
    }

    public boolean incVettore(Integer[] v, int n, Integer[] max){

        if(n<0)
            return false;
        else{
            if (v[n] == max[n]){
                boolean temp = incVettore(v,n-1,max);
                if (temp){
                    v[n]=0;
                    return true;
                }else{
                    return false;
                }
            }else{
                v[n]++;
                return true;
            }
        }
    }
    private List creaCombinazione(ProblemObjects O, ActionParameters aP, int index) {
        List ret = new ArrayList();
        if (index == aP.size()-1) {
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
    
    public Set Propositionalize(ActionSchema a, ProblemObjects po) throws Exception{
        Set ret = new HashSet();
        
        Set combo = Substitutions(a,po);
        for (Object o: combo){
            ret.add(a.ground((ActionParametersAsTerms)o));
        }
        
        return ret;
    
    }
}

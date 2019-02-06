package com.hstairs.ppmajal.problem;

import com.hstairs.ppmajal.conditions.Predicate;
import com.hstairs.ppmajal.expressions.NumFluent;
import com.hstairs.ppmajal.expressions.PDDLNumber;

import java.util.HashMap;

public class MAPPDDLState extends PDDLState {


    final HashMap<String,Boolean> predicateValue;
    final HashMap<String,PDDLNumber> numFluentValue;
    public MAPPDDLState (HashMap<NumFluent, PDDLNumber> numFluentReference, HashMap<Predicate, Boolean> initBoolFluentsValues) {
        numFluentValue = new HashMap<>();
        predicateValue = new HashMap<>();
        for (NumFluent nf :numFluentReference.keySet()){
            numFluentValue.put(nf.toString(),numFluentReference.get(nf));
        }
        for (Predicate p :initBoolFluentsValues.keySet()){
            predicateValue.put(p.toString(),initBoolFluentsValues.get(p));
        }
    }

    @Override
    public double fluentValue (NumFluent f) {
        PDDLNumber pddlNumber = numFluentValue.get(f.toString());
        if (pddlNumber == null)
            return Double.NaN;
        return pddlNumber.getNumber();
    }

    @Override
    public boolean holds (Predicate p) {
        return predicateValue.get(p.toString());
    }
}

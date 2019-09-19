package com.hstairs.ppmajal.transition;

import com.hstairs.ppmajal.conditions.Condition;
import com.hstairs.ppmajal.conditions.NotCond;
import com.hstairs.ppmajal.conditions.PDDLObject;
import com.hstairs.ppmajal.domain.Variable;
import com.hstairs.ppmajal.expressions.NumEffect;
import com.hstairs.ppmajal.problem.PDDLObjects;

import java.util.*;

public class ConditionalEffects<T> {
    private Map<Condition, Collection<T>> actualConditionalEffects;
    private Collection<T> unconditionalEffect;
    public enum VariableType {PREDICATE, NUMFLUENTS};
    final private VariableType  t;
    public ConditionalEffects(VariableType  t1){
        this.t = t1;
    }
    public void add(T element){
        if (unconditionalEffect == null){
            unconditionalEffect = new HashSet<>();
        }
        unconditionalEffect.add(element);
    }
    public void add(Condition c, T element){
        if (actualConditionalEffects == null){
            actualConditionalEffects = new HashMap<>();
        }
        final Collection<T> ts = actualConditionalEffects.get(c);
        if (ts == null){
            actualConditionalEffects.put(c, Collections.singleton(element));
        }else{
            ts.add(element);
        }
    }
    public Collection<T> getEffects(){
        if (unconditionalEffect == null){
            return Collections.EMPTY_SET;
        }
        return unconditionalEffect;
    }
    public Collection<T> getEffects(Condition c){
        if (actualConditionalEffects == null){
            return Collections.EMPTY_SET;
        }
        return actualConditionalEffects.get(c);
    }

    public Iterable<? extends T> getAllAffectedVariables() {
        Collection<T> res = new ArrayList<>();
        for (Collection<T> ele : this.actualConditionalEffects.values()){
            for (T e: ele){
                if (e instanceof NotCond){
                    final Condition son = ((NotCond) e).getSon();
                    res.add((T) son);
                }else {
                    res.add(e);
                }
            }
        }
        return res;
    }
    public ConditionalEffects<T> ground(Map<Variable, PDDLObject> substitution, PDDLObjects po){
        ConditionalEffects res = new ConditionalEffects(this.t);
        final Set<Map.Entry<Condition, Collection<T>>> entries = this.actualConditionalEffects.entrySet();
        for (Map.Entry<Condition,Collection<T>> entry : entries){
            for (T e: entry.getValue()){
                if (e instanceof NumEffect){
                    res.add(entry.getKey().ground(substitution,po),((NumEffect) e).ground(substitution,po));
                }else{
                    res.add(entry.getKey().ground(substitution,po),((Condition) e).ground(substitution,po));
                }
            }
        }
        for (T e: this.unconditionalEffect){
            if (e instanceof NumEffect){
                res.add(((NumEffect) e).ground(substitution,po));
            }else{
                res.add(((Condition) e).ground(substitution,po));
            }
        }
        return res;
    }
}
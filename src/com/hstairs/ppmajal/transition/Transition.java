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
package com.hstairs.ppmajal.transition;

import com.hstairs.ppmajal.conditions.*;

public abstract class Transition {

    protected Float time = null;// It is possible for this action to be timed
    final protected String name;
    final protected ConditionalEffects conditionalPropositionalEffects;
    final protected ConditionalEffects conditionalNumericEffects;
    final protected Condition preconditions;
    final protected Semantics semantics;

    protected Transition(String name, ConditionalEffects conditionalPropositionalEffects, ConditionalEffects conditionalNumericEffects, Condition preconditions, Semantics semantcis) {
        this.name = name;
        this.conditionalPropositionalEffects = conditionalPropositionalEffects;
        this.conditionalNumericEffects = conditionalNumericEffects;
        this.preconditions = preconditions;
        this.semantics = semantcis;
    }

    public String getName() {
        return name;
    }

    public Condition getPreconditions() {
        return preconditions;
    }

    public ConditionalEffects getConditionalNumericEffects() {
        return conditionalNumericEffects;
    }

    public ConditionalEffects getConditionalPropositionalEffects() {
        return conditionalPropositionalEffects;
    }
    public Semantics getSemantics() {
        return semantics;
    }

    public Iterable<? extends Predicate> getPropositionAffected() {
        return this.conditionalPropositionalEffects.getAllAffectedVariables();
    }

    public enum Semantics{ACTION, PROCESS, EVENT}


}


//
//
//    public String getName ( ) {
//        return name;
//    }
//
//
//    @Override
//    public String toString ( ) {
//        return "PDDLGenericAction{" + "name=" + name + ", parameters=" + parameters + ", time=" + time + '}';
//    }
//
//
//    //This can be cached
//    protected Collection<Predicate> getPropositionAffected ( ) {
//        LinkedHashSet ret = new LinkedHashSet();
//        for( Pair<Condition,Terminal> ele : this.conditionalPropositionalEffects){
//            if (ele.getSecond() instanceof Predicate) {
//                ret.add(ele);
//            }
//        }
//        return ret;
//    }
//
//    public HashMap update_invariant_fluents (HashMap invariantFluents) {
//        for (Object nf : this.getNumericFluentAffected()) {
//            invariantFluents.put(nf, Boolean.FALSE);
//        }
//        for (Predicate p : this.getPropositionAffected()) {
//            invariantFluents.put(p, Boolean.FALSE);
//        }
//        return invariantFluents;
//    }
//
//
//    public Collection<NumFluent> getNumericFluentAffected ( ) {
//        this.generateAffectedNumFluents();
//        return this.numericFluentAffected.keySet();
//    }
//
//    public void generateAffectedNumFluents ( ) {
//        if (numericFluentAffected != null) {
//            return;
//        }
//        numericFluentAffected = new Object2BooleanOpenHashMap();
//        for (Pair<Condition, NumEffect> ele : conditionalNumericEffects) {
//            NumEffect e = ele.getSecond();
//            this.numericFluentAffected.put(e.getFluentAffected(), true);
//        }
//    }
//
//    public Collection<? extends NumFluent> getNumFluentsNecessaryForExecution ( ) {
//        Set<NumFluent> ret = new HashSet();
//        for (Pair<Condition, NumEffect> ele : conditionalNumericEffects) {
//            NumEffect e = ele.getSecond();
//            ret.addAll(e.getRight().getInvolvedNumericFluents());
//        }
//        return ret;
//    }
//
//    public void create_effects_by_cases (PostCondition res) {
//        if (res instanceof AndCond) {
//            AndCond pc = (AndCond) res;
//            for (Object o : pc.sons) {
//                if (o instanceof Predicate) {
//                    this.addList.sons.add(o);
//                } else if (o instanceof NotCond) {
//                    this.delList.sons.add(o);
//                } else if (o instanceof NumEffect) {
//                    this.numericEffects.sons.add(o);
//                } else if (o instanceof ConditionalEffect) {
//                    this.conditionalEffects.sons.add(o);
//                } else if (o instanceof ForAll) {
//                    this.forall.sons.add(o);
//                }
//            }
//        } else if (res instanceof Predicate) {
//            this.addList.sons.add(res);
//        } else if (res instanceof NotCond) {
//            this.delList.sons.add(res);
//        } else if (res instanceof NumEffect) {
//            this.numericEffects.sons.add(res);
//        } else if (res instanceof ConditionalEffect) {
//            this.conditionalEffects.sons.add(res);
//        } else if (res instanceof ForAll) {
//            this.forall.sons.add(res);
////            this.forall.sons.add(res);
//        }
//    }
//
//    public Collection<NumFluent> getInvolvedNumFluents ( ) {
//        Collection<NumFluent> ret = this.preconditions.getInvolvedFluents();
//        ret.addAll(this.numericEffects.getInvolvedFluents());
//        return ret;
//    }
//
//    public Collection<Predicate> getInvolvedPredicates ( ) {
//        Collection<Predicate> ret = new LinkedHashSet();
//        if (this.preconditions != null) {
//            ret.addAll(this.preconditions.getInvolvedPredicates());
//        }
//        if (this.addList != null) {
//            ret.addAll(this.addList.getInvolvedPredicates());
//        }
//        if (this.delList != null) {
//            ret.addAll(this.delList.getInvolvedPredicates());
//        }
//        if (this.conditionalEffects != null) {
//            ret.addAll(this.conditionalEffects.getInvolvedPredicates());
//        }
//        return ret;
//    }
//
//    public void unifyVariablesReferences (EPddlProblem p) {
//
//        preconditions = (ComplexCondition) preconditions.unifyVariablesReferences(p);
//        addList = (AndCond) addList.unifyVariablesReferences(p);
//        delList = (AndCond) delList.unifyVariablesReferences(p);
//        numericEffects = (AndCond) numericEffects.unifyVariablesReferences(p);
//        conditionalEffects = (AndCond) conditionalEffects.unifyVariablesReferences(p);
//    }
//
//    @Override
//    public int hashCode ( ) {
//        int hash = 3;
//        hash = 97 * hash + Objects.hashCode(this.name);
//        hash = 97 * hash + Objects.hashCode(this.parameters);
//        hash = 97 * hash + Objects.hashCode(this.time);
//        return hash;
//    }
//
//    @Override
//    public boolean equals (Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Transition other = (Transition) obj;
//        if (!Objects.equals(this.name, other.name)) {
//            return false;
//        }
//        if (!Objects.equals(this.parameters, other.parameters)) {
//            return false;
//        }
//        if (!Objects.equals(this.time, other.time)) {
//            return false;
//        }
//        return true;
//    }
//
//
//}

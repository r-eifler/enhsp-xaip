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
package domain;

import conditions.AndCond;
import conditions.ComplexCondition;
import conditions.ConditionalEffect;
import conditions.Condition;
import conditions.ForAll;
import conditions.NotCond;
import conditions.PostCondition;
import conditions.Predicate;

import expressions.NumEffect;
import expressions.NumFluent;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import problem.EPddlProblem;

public abstract class GenericActionType extends Object {

    protected String name;
    protected AndCond addList;
    protected AndCond delList;
    protected AndCond numericEffects;
    protected ComplexCondition preconditions;
    public AndCond cond_effects;
    protected HashMap<NumFluent, Boolean> numericFluentAffected;
    protected SchemaParameters parameters;
    protected AndCond forall;

    /**
     * @return the addList
     */
    public AndCond getAddList() {
        return addList;
    }

    public SchemaParameters getPar() {
        return parameters;
    }

    /**
     * @return the delList
     */
    public AndCond getDelList() {
        return delList;
    }

    public String getName() {
        return name;
    }

    /**
     * @return the numericEffects
     */
    public AndCond getNumericEffects() {
        return numericEffects;
    }

    /**
     * @return the preconditions
     */
    public ComplexCondition getPreconditions() {
        return preconditions;
    }

    /**
     * @param addList the addList to set
     */
    public void setAddList(AndCond addList) {
        this.addList = addList;
    }

    /**
     * @param delList the delList to set
     */
    public void setDelList(AndCond delList) {
        this.delList = delList;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param numericEffects the numericEffects to set
     */
    public void setNumericEffects(AndCond numericEffects) {
        this.numericEffects = numericEffects;
    }

    /**
     * @param preconditions the preconditions to set
     */
    public void setPreconditions(ComplexCondition preconditions) {
        this.preconditions = preconditions;
    }

    @Override
    public String toString() {
        return "GenericActionType{" + "name=" + name + ", addList=" + addList + ", delList=" + delList + ", numericEffects=" + numericEffects + ", preconditions=" + preconditions + ", cond_effects=" + cond_effects + '}';
    }


   
    /**
     * @return the parameters
     */
    /**
     * @param parameters the parameters to set
     */
    public void setParameters(SchemaParameters parameters) {
        this.parameters = parameters;
    }

    protected void push_not_to_terminals() {
        ComplexCondition c = (ComplexCondition)this.getPreconditions().push_not_to_terminals();
        if (!(c instanceof AndCond)) {
            AndCond and = new AndCond();
            and.addConditions(c);
            this.setPreconditions(and);
        } else {
            this.setPreconditions(c);
        }
        if (this.cond_effects != null) {
            this.cond_effects.push_not_to_terminals();
        }

    }

    protected Collection<Predicate> getPropositionAffected() {
        LinkedHashSet ret = new LinkedHashSet();
        if (this.addList != null) {
            ret.addAll(this.addList.getInvolvedPredicates());
        }
        if (this.cond_effects != null) {
           AndCond temp2 = (AndCond)this.cond_effects;
           for (Condition cEff: (Collection<Condition>)temp2.sons){
               if (cEff instanceof ConditionalEffect){
                    ConditionalEffect conditional = (ConditionalEffect)cEff;
                    Collection<Predicate> temp = ((AndCond)conditional.effect).getInvolvedPredicates();
                    for (Condition c : temp) {
                         if (c instanceof NotCond) {
                             NotCond nc = (NotCond) c;
                             ret.add((Predicate) nc.getSon());
                         }else if (c instanceof Predicate){
                             ret.add(c);
                         }else{
                             throw new RuntimeException("A conditional effect terminal conditions function does not work");
                         }
                     }
               }else{
                    throw new RuntimeException("Needs to fix the conditional effect");
               }
           }
        }
        
        if (this.delList != null ) {
            if (this.delList instanceof ComplexCondition){
                
                for (Condition c : (Collection<Condition>) ((ComplexCondition)this.delList).sons) {
                    if (c instanceof NotCond) {
                        NotCond nc = (NotCond) c;
                        ret.add((Predicate) nc.getSon());
                    }
                }
            }
        }
        return ret;
    }

    public HashMap update_invariant_fluents(HashMap invariantFluents) {
        for (NumFluent nf : this.getNumericFluentAffected().keySet()) {
            invariantFluents.put(nf, Boolean.FALSE);
        }
        for (Predicate p : this.getPropositionAffected()) {
            invariantFluents.put(p, Boolean.FALSE);
        }
        return invariantFluents;
    }

    public HashMap<NumFluent, Boolean> getNumericFluentAffected() {
        this.generateAffectedNumFluents();
        return this.numericFluentAffected;
    }

    public void forcedGenerateAffectedNumFluents() {

        numericFluentAffected = new HashMap();
        AndCond num = (AndCond) this.getNumericEffects();
        if (num != null) {
            for (Object o : num.sons) {
                if (o instanceof NumEffect) {
                    NumEffect e = (NumEffect) o;
                    this.numericFluentAffected.put(e.getFluentAffected(), Boolean.TRUE);
                }
            }
        }
        if (this.cond_effects != null) {
            for (ConditionalEffect c_eff : (Collection<ConditionalEffect>) ((ComplexCondition)this.cond_effects).sons) {
                for (NumFluent nf : c_eff.affectedNumericFluents()) {
                    this.numericFluentAffected.put(nf, Boolean.TRUE);
                }
            }
        }
    }

    public void generateAffectedNumFluents() {
        if (numericFluentAffected != null) {
            return;
        }
        numericFluentAffected = new HashMap();
        AndCond num = (AndCond) this.getNumericEffects();
        if (num != null) {
            for (Object o : num.sons) {
                if (o instanceof NumEffect) {
                    NumEffect e = (NumEffect) o;
                    this.numericFluentAffected.put(e.getFluentAffected(), Boolean.TRUE);
                }
            }
        }

        if (this.cond_effects != null) {
            for (ConditionalEffect c_eff : (Collection<ConditionalEffect>) ((ComplexCondition)this.cond_effects).sons) {
                for (NumFluent nf : c_eff.affectedNumericFluents()) {
                    this.numericFluentAffected.put(nf, Boolean.TRUE);
                }
            }
        }

    }

    public Collection<? extends NumFluent> getNumFluentsNecessaryForExecution() {
        Set<NumFluent> ret = new HashSet();
        for (NumEffect neff : (Collection<NumEffect>) ((ComplexCondition)this.getNumericEffects()).sons) {
            ret.addAll(neff.getRight().rhsFluents());
        }
        return ret;
    }
    
    public void create_effects_by_cases(PostCondition res) {
        if (res instanceof AndCond) {
            AndCond pc = (AndCond) res;
            for (Object o : pc.sons) {
                if (o instanceof Predicate) {
                    this.addList.sons.add(o);
                } else if (o instanceof NotCond) {
                    this.delList.sons.add(o);
                } else if (o instanceof NumEffect) {
                    this.numericEffects.sons.add(o);
                } else if (o instanceof ConditionalEffect) {
                    this.cond_effects.sons.add(o);
                }else if (o instanceof ForAll) {
                    this.forall.sons.add(o);
                }
            }
        } else if (res instanceof Predicate) {
            this.addList.sons.add(res);
        } else if (res instanceof NotCond) {
            this.delList.sons.add(res);
        } else if (res instanceof NumEffect) {
            this.numericEffects.sons.add(res);
        } else if (res instanceof ConditionalEffect) {
            this.cond_effects.sons.add(res);
        }else if (res instanceof ForAll) {
            this.forall.sons.add(res);
//            this.forall.sons.add(res);
        }
    }

    public Collection<NumFluent> getInvolvedNumFluents() {
        Collection<NumFluent> ret = this.preconditions.getInvolvedFluents();
        ret.addAll(this.numericEffects.getInvolvedFluents());
        return ret;
    }

    public Collection<Predicate> getInvolvedPredicates() {
        Collection<Predicate> ret = new LinkedHashSet();
        if (this.preconditions != null) {
            ret.addAll(this.preconditions.getInvolvedPredicates());
        }
        if (this.addList != null) {
            ret.addAll(this.addList.getInvolvedPredicates());
        }
        if (this.delList != null) {
            ret.addAll(this.delList.getInvolvedPredicates());
        }
        if (this.cond_effects != null) {
            ret.addAll(this.cond_effects.getInvolvedPredicates());
        }
        return ret;
    }

    public void unifyVariablesReferences(EPddlProblem p) {

        preconditions = (ComplexCondition) preconditions.unifyVariablesReferences(p);
        addList = (AndCond) addList.unifyVariablesReferences(p);
        delList = (AndCond) delList.unifyVariablesReferences(p);
        numericEffects = (AndCond) numericEffects.unifyVariablesReferences(p);
        cond_effects = (AndCond) cond_effects.unifyVariablesReferences(p);
    }
}

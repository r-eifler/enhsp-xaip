package com.hstairs.ppmajal.transition;

import com.hstairs.ppmajal.conditions.Condition;
import com.hstairs.ppmajal.conditions.ForAll;
import com.hstairs.ppmajal.conditions.Terminal;
import com.hstairs.ppmajal.domain.SchemaParameters;
import com.hstairs.ppmajal.expressions.NumEffect;
import com.hstairs.ppmajal.problem.Printer;
import java.util.Collection;

public class TransitionSchema extends Transition {
    final protected SchemaParameters parameters;
    final protected Collection<ForAll> forallEffects;

    public TransitionSchema(String name, Semantics semantics, SchemaParameters parameters, Condition preconditions, ConditionalEffects conditionalPropositionalEffects, ConditionalEffects conditionalNumericEffects) {
        this(parameters, name, conditionalPropositionalEffects, conditionalNumericEffects,preconditions, semantics, null);        
    }

    public TransitionSchema(SchemaParameters par, String transitionName, ConditionalEffects<Terminal> propEffect, ConditionalEffects<NumEffect> numEffect, Condition precondition, Semantics semantics, Collection<ForAll>  forall) {
        super(transitionName,propEffect,numEffect,precondition,semantics);
        this.forallEffects = forall;
        this.parameters = par;
    }
    public SchemaParameters getParameters() {
        return parameters;
    }

    public Collection<ForAll> getForallEffects() {
        return forallEffects;
    }
    
    @Override
    public String toString(){
        final StringBuilder ret = new StringBuilder("");
        ret.append("(:action ");
        ret.append(name).append(" ");
        ret.append("\n\t:parameters ");
        if (this.parameters == null){
            ret.append("()");
        }else{
            ret.append(this.parameters);
        }
        ret.append("\n\t:precondition ");
        if (this.preconditions == null){
            ret.append("()");
        }else{
            ret.append(this.preconditions);
        }
        ret.append("\n\t:effect ");
        ret.append("(and \n");
        Printer.pddlPrint(ret, this.conditionalNumericEffects);
        Printer.pddlPrint(ret, this.conditionalPropositionalEffects);
        ret.append("\n))");
        return ret.toString();
    }
}

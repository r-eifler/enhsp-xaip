package com.hstairs.ppmajal.transition;

import com.hstairs.ppmajal.conditions.Condition;
import com.hstairs.ppmajal.conditions.ForAll;
import com.hstairs.ppmajal.conditions.Terminal;
import com.hstairs.ppmajal.domain.SchemaParameters;
import com.hstairs.ppmajal.expressions.NumEffect;
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
    
}

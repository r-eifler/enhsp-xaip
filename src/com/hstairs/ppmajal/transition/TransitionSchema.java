package com.hstairs.ppmajal.transition;

import com.hstairs.ppmajal.conditions.Condition;
import com.hstairs.ppmajal.conditions.ForAll;
import com.hstairs.ppmajal.conditions.Terminal;
import com.hstairs.ppmajal.domain.SchemaParameters;
import com.hstairs.ppmajal.expressions.NumEffect;

public class TransitionSchema extends Transition {
    final protected SchemaParameters parameters;
    final protected ForAll forallEffects;

    public TransitionSchema(SchemaParameters parameters, String name, ConditionalEffects conditionalPropositionalEffects, ConditionalEffects conditionalNumericEffects, Condition preconditions, Semantics semantcis) {
        this(parameters, name, conditionalPropositionalEffects, conditionalNumericEffects,preconditions, semantcis, null);        
    }

    public TransitionSchema(SchemaParameters par, String transitionName, ConditionalEffects<Terminal> propEffect, ConditionalEffects<NumEffect> numEffect, Condition precondition, Semantics semantics, ForAll forall) {
        super(transitionName,propEffect,numEffect,precondition,semantics);
        this.forallEffects = forall;
        this.parameters = par;
    }
    public SchemaParameters getParameters() {
        return parameters;
    }

    public ForAll getForallEffects() {
        return forallEffects;
    }
    
}

package com.hstairs.ppmajal.transition;

import com.hstairs.ppmajal.conditions.Condition;
import com.hstairs.ppmajal.domain.SchemaParameters;

public class TransitionSchema extends Transition {
    final protected SchemaParameters parameters;

    public TransitionSchema(SchemaParameters parameters, String name, ConditionalEffects conditionalPropositionalEffects, ConditionalEffects conditionalNumericEffects, Condition preconditions, Semantics semantcis) {
        super(name, conditionalPropositionalEffects, conditionalNumericEffects, preconditions, semantcis);
        this.parameters = parameters;
    }
    public SchemaParameters getParameters() {
        return parameters;
    }

}

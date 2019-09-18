package com.hstairs.ppmajal.transition;

import com.hstairs.ppmajal.conditions.Condition;
import com.hstairs.ppmajal.conditions.PDDLObject;

import java.util.List;

public class TransitionGround extends Transition {
    final protected List<PDDLObject> parameters;

    public TransitionGround(List<PDDLObject> parameters, String name, ConditionalEffects conditionalPropositionalEffects, ConditionalEffects conditionalNumericEffects, Condition preconditions, Semantics semantcis) {
        super(name, conditionalPropositionalEffects, conditionalNumericEffects, preconditions, semantcis);
        this.parameters = parameters;
    }

    public List<PDDLObject> getParameters() {
        return parameters;
    }

}

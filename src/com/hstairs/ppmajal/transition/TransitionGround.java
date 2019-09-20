package com.hstairs.ppmajal.transition;

import com.hstairs.ppmajal.conditions.Condition;
import com.hstairs.ppmajal.conditions.PDDLObject;
import com.hstairs.ppmajal.problem.EPddlProblem;
import com.hstairs.ppmajal.problem.State;

import java.util.List;
import java.util.Objects;

public class TransitionGround extends Transition {
    final protected List<PDDLObject> parameters;

    public TransitionGround(List<PDDLObject> parameters, String name, ConditionalEffects conditionalPropositionalEffects, ConditionalEffects conditionalNumericEffects, Condition preconditions, Semantics semantcis) {
        super(name, conditionalPropositionalEffects, conditionalNumericEffects, preconditions, semantcis);
        this.parameters = parameters;
    }

    public List<PDDLObject> getParameters() {
        return parameters;
    }

    public boolean isApplicable(State s) {
        return (this.preconditions.isSatisfied(s));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 15 * hash + Objects.hashCode(this.name);
        hash = 19 * hash + Objects.hashCode(this.parameters);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TransitionGround other = (TransitionGround) obj;
        if (!Objects.equals(this.parameters, other.parameters)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

 
}

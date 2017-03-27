/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import problem.GroundEvent;

/**
 *
 * @author enrico
 */
public class EventSchema extends ActionSchema{
    
    public GroundEvent ground() {
        GroundEvent ret = new GroundEvent(this.name);
        ParametersAsTerms input = new ParametersAsTerms();

        ret.setParameters(input);
        ret.setPreconditions(preconditions);
        ret.setAddList(addList);
        ret.setDelList(delList);
        ret.setNumericEffects(numericEffects);
        ret.cond_effects = cond_effects;
        return ret;
    }
}

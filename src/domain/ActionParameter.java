package domain;

import conditions.PDDLObject;
import java.util.Map;

/**
 * An <b>action parameter</b> is 
 * either a variable (when the action is not grounded) 
 * or a PDDL Object (i.e., a constant, when the action is grounded).  
 *
 * @author Alban Grastien
 */
public interface ActionParameter {
    
    /**
     * Grounds this action parameter according to the specified map.  
     * Any occurrence of a variable is replaced 
     * with the corresponding PDDL object 
     * (fails if the variable does not appear in the map).  
     * PDDL objects are unchanged.  
     * 
     * @param substitution the map that indicates what the variables 
     * should be replaced with.  
     * @return the grounding of this action parameter.  
     */
    public PDDLObject ground(Map<Variable,PDDLObject> substitution);
    
}

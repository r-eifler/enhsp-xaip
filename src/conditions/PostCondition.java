/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conditions;

import java.util.HashMap;
import java.util.Map;
import problem.RelState;
import problem.State;

/**
 *
 * @author enrico
 */
public interface PostCondition {
    
    public abstract HashMap<Object,Object> apply(State s);
    public abstract HashMap<Object,Object> apply(RelState s);
    public abstract String pddlPrint(boolean type_info);
    public abstract Object clone();
    public abstract String pddlPrintWithExtraObject();

}

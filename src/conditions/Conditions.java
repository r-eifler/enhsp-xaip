 /*********************************************************************
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 * 
 *********************************************************************/

/*********************************************************************
 * Description: Part of the PPMaJaL library
 *             
 * Author: Enrico Scala 2013
 * Contact: enricos83@gmail.com
 *
 *********************************************************************/ 

package conditions;

import expressions.NumFluent;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import problem.GroundAction;
import problem.RelState;
import problem.State;

/**
 *
 * @author enrico
 */
public abstract  class Conditions extends Object {

    public boolean grounded;
    public LinkedHashSet sons; //used by formula conditions as AndCond and OrCond. Each son is another condition involved in the formula
    protected boolean freeVarSemantic = false;
    private boolean unsatisfiable = false;
    private boolean valid = false;
    private int counter;
    public Conditions() {
        //son = new HashSet();
        grounded = false;
        unsatisfiable = false;
    }
    
    public abstract Conditions weakEval(State s, HashMap invF);
    //public abstract void addConditions(Conditions o);

    
    
    /*
        The following regression operation operates under the following assumptions:
            1) Action do not have conflicting effects. 
                a) Conditional effects will never conflict
                b) Add and Delete List will never conflict
            2) Any literals (positive or negative) caused by an action 
               takes part just in one of the conditional effects of the action.
               Add and Del list can be seen as conditional effects with empty
               activation conditions.
    
    */
    public abstract Conditions regress(GroundAction gr);
    
    public abstract Conditions ground(Map substitution);
    public abstract Conditions ground(Map substitution, int c);

    public abstract boolean eval(State s);

    
    public abstract String toSmtVariableString(int k, GroundAction gr, String var);
    
    public abstract boolean isSatisfied(State s);

    public abstract void changeVar(Map substitution);

    public abstract String pddlPrint(boolean typeInformation);
    
    public abstract String pddlPrintWithExtraObject();

    @Override
    public abstract Conditions clone();

    public abstract boolean isSatisfied(RelState aThis);
    
    public abstract void normalize();

    public abstract Conditions unGround(Map asbstractionOf);

    public abstract boolean isUngroundVersionOf(Conditions conditions);

    public abstract String toSmtVariableString(int i);//just for and condition
    
    public abstract Set<NumFluent> getInvolvedFluents();

    /**
     * @return the freeVarSemantic
     */
    public boolean isFreeVarSemantic() {
        return freeVarSemantic;
    }

    /**
     * @param freeVarSemantic the freeVarSemantic to set
     */
    public void setFreeVarSemantic(boolean freeVarSemantic) {
        this.freeVarSemantic = freeVarSemantic;
    }

    /**
     * @return the unsatisfiable
     */
    public boolean isUnsatisfiable() {
        return unsatisfiable;
    }

    /**
     * @param unsatisfiable the unsatisfiable to set
     */
    public void setUnsatisfiable(boolean unsatisfiable) {
        this.unsatisfiable = unsatisfiable;
    }

    /**
     * @return the counter
     */
    public int getCounter() {
        return counter;
    }

    /**
     * @param counter the counter to set
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }

    /**
     * @return the valid
     */
    public boolean isValid() {
        return valid;
    }

    /**
     * @param valid the valid to set
     */
    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public abstract Conditions transform_equality();

    public abstract boolean is_affected_by(GroundAction gr);
        
    public Collection<Predicate> getInvolvedPredicates(){
        Collection ret = new LinkedHashSet();
        if (this instanceof Predicate){
                ret.add(this);
                return ret;
        }else if (this instanceof NotCond){
                NotCond temp = (NotCond)this;
                Conditions temp2 = (Conditions)temp.son.iterator().next();
                ret.addAll(temp2.getInvolvedPredicates());   
                return ret;
        }
        //from here it can only be an AndCond or a Or. Other cases are not considered
        if (this.sons != null){
            for (Conditions c: (Collection<Conditions>)this.sons){
                ret.addAll(c.getInvolvedPredicates());
            }
        }
        return ret;
    }


}

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

package expressions;

import conditions.Conditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import problem.RelState;
import problem.State;

/**
 *
 * @author enrico
 */
public abstract class Expression extends Object {

    public boolean grounded;
    protected boolean freeVarSemantic = false;

    public Expression() {
        grounded = false;
    }

    public abstract Expression ground(Map substitution);
    
    public abstract Expression unGround(Map substitution);


    public abstract PDDLNumber eval(State s);

    //public abstract State apply(State s);
    public abstract ExtendedNormExpression normalize();

    public abstract void changeVar(Map substitution);

    public abstract String pddlPrint(boolean typeInformation);

    public abstract Expression weakEval(State s, HashMap invF);
    @Override
    public abstract Expression clone();

    public abstract PDDLNumbers eval(RelState s);

    public abstract boolean involve(HashMap<NumFluent,Boolean> arrayList);

    public abstract Expression subst(Conditions numeric);

    public abstract Set fluentsInvolved();

    public abstract boolean isUngroundVersionOf(Expression expr);

    public abstract Expression susbtFluentsWithTheirInvariants(int j);

    public abstract Expression susbtFluentsWithTheirInvariants(HashMap<Object, Boolean> invariantFluent, int j);

    public abstract String toSmtVariableString(int i);
    
    

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

    public abstract boolean involve(NumFluent a);
        

  
}

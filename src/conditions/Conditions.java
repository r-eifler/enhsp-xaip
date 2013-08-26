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

import java.util.HashSet;
import java.util.Map;
import problem.RelState;
import problem.State;

/**
 *
 * @author enrico
 */
public abstract class Conditions extends Object {

    public boolean grounded;
    public HashSet sons; //used by formula conditions as AndCond and OrCond. Each son is another condition involved in the formula

    public Conditions() {
        //son = new HashSet();
        grounded = false;
    }
    //public abstract void addConditions(Conditions o);

    public abstract Conditions ground(Map substitution);

    public abstract boolean eval(State s);

    public abstract boolean isSatisfied(State s);

    public abstract void changeVar(Map substitution);

    public abstract String pddlPrint();

    @Override
    public abstract Conditions clone();

    public abstract boolean isSatisfied(RelState aThis);
    
    public abstract void normalize();


}

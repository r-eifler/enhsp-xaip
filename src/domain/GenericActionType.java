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
package domain;

import conditions.AndCond;
import conditions.Conditions;
import conditions.NotCond;
import conditions.Predicate;

import expressions.NumEffect;
import expressions.NumFluent;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class GenericActionType extends Object {

    protected String name;
    protected Conditions addList;
    protected Conditions delList;
    protected Conditions numericEffects;
    protected Conditions preconditions;
    public Conditions cond_effects;
    protected HashMap<NumFluent, Boolean> numericFluentAffected;
    protected SchemaParameters parameters;

    /**
     * @return the addList
     */
    public Conditions getAddList() {
        return addList;
    }

    public SchemaParameters getPar(){
        return parameters;
    }
    /**
     * @return the delList
     */
    public Conditions getDelList() {
        return delList;
    }

    public String getName() {
        return name;
    }

    /**
     * @return the numericEffects
     */
    public Conditions getNumericEffects() {
        return numericEffects;
    }

    /**
     * @return the preconditions
     */
    public Conditions getPreconditions() {
        return preconditions;
    }

    /**
     * @param addList the addList to set
     */
    public void setAddList(Conditions addList) {
        this.addList = addList;
    }

    /**
     * @param delList the delList to set
     */
    public void setDelList(Conditions delList) {
        this.delList = delList;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param numericEffects the numericEffects to set
     */
    public void setNumericEffects(Conditions numericEffects) {
        this.numericEffects = numericEffects;
    }

    /**
     * @param preconditions the preconditions to set
     */
    public void setPreconditions(Conditions preconditions) {
        this.preconditions = preconditions;
    }

    @Override
    public abstract String toString();

    //
    //    public Action ground(ArrayList terms){
    //
    //
    //        substitution = new HashMap();
    //
    //
    //    }
    /**
     * @return the parameters
     */

    /**
     * @param parameters the parameters to set
     */
    public void setParameters(SchemaParameters parameters) {
        this.parameters = parameters;
    }

    protected void push_not_to_terminals() {
        Conditions c = this.getPreconditions().push_not_to_terminals();
        if (! (c instanceof AndCond)){
            AndCond and = new AndCond();
            and.addConditions(c);
            this.setPreconditions(and);
        }else{
            this.setPreconditions(c);
        }
    }

    protected Collection<Predicate> getPropositionAffected() {
        LinkedHashSet ret = new LinkedHashSet();
        if (this.addList != null) {
            ret.addAll(this.addList.getTerminalConditions());
        }
        if (this.delList != null && this.delList.sons != null) {
            for (Conditions c : (Collection<Conditions>)this.delList.sons){
                if (c instanceof NotCond){
                    NotCond nc = (NotCond)c;
                    ret.add((Predicate)nc.getSon());
                }
            }
            //ret.addAll(this.delList.getTerminalConditions());
        }
        return ret;
    }

    public HashMap update_invariant_fluents(HashMap invariantFluents) {
        for (NumFluent nf : this.getNumericFluentAffected().keySet()) {
            invariantFluents.put(nf, Boolean.FALSE);
        }
        for (Predicate p : this.getPropositionAffected()) {
            invariantFluents.put(p, Boolean.FALSE);
        }
        return invariantFluents;
    }

    public HashMap<NumFluent, Boolean> getNumericFluentAffected() {
        this.generateAffectedNumFluents();
        return this.numericFluentAffected;
    }
    
    public void forcedGenerateAffectedNumFluents() {

        numericFluentAffected = new HashMap();
        AndCond num = (AndCond) this.getNumericEffects();
        if (num != null) {
            for (Object o : num.sons) {
                if (o instanceof NumEffect) {
                    NumEffect e = (NumEffect) o;
                    this.numericFluentAffected.put(e.getFluentAffected(), Boolean.TRUE);
                }
            }
        }
    }

    public void generateAffectedNumFluents() {
        if (numericFluentAffected != null) {
            return;
        }
        numericFluentAffected = new HashMap();
        AndCond num = (AndCond) this.getNumericEffects();
        if (num != null) {
            for (Object o : num.sons) {
                if (o instanceof NumEffect) {
                    NumEffect e = (NumEffect) o;
                    this.numericFluentAffected.put(e.getFluentAffected(), Boolean.TRUE);
                }
            }
        }
    }

    public Collection<? extends NumFluent> getNumFluentsNecessaryForExecution() {
        Set<NumFluent> ret = new HashSet();
        for (NumEffect neff : (Collection<NumEffect>) this.getNumericEffects().sons) {
            ret.addAll(neff.getRight().rhsFluents());
        }
        return ret;
    }
}

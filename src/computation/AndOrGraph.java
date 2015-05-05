/**
 * *******************************************************************
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 *
 ********************************************************************
 */

/**
 * *******************************************************************
 * Description: Part of the PPMaJaL library
 *
 * Author: Enrico Scala 2013 Contact: enricos83@gmail.com
 *
 ********************************************************************
 */
package computation;

import conditions.Predicate;
import java.util.HashMap;
import java.util.Set;
import problem.GroundAction;

/**
 *
 * @author enrico
 */
public class AndOrGraph extends Object {
    
    private Set<Predicate> initialNodes;

    private Set<Predicate> factsNodes;
    
    private Set<GroundAction> actionNodes;
    
    private HashMap<Predicate, GroundAction> supporter;

    private HashMap<GroundAction,Predicate> achiever;


    public boolean addAnAction(GroundAction e) {
        return actionNodes.add(e);
    }

    public boolean containsAFact(Object o) {
        return factsNodes.contains(o);
    }

    public boolean addAFact(Predicate e) {
        return factsNodes.add(e);
    }

    public Predicate getAchiever(Object key) {
        return achiever.get(key);
    }

    public Predicate setAchiever(GroundAction key, Predicate value) {
        return achiever.put(key, value);
    }

    public GroundAction getSupporter(Object key) {
        return supporter.get(key);
    }

    public GroundAction setSupporter(Predicate key, GroundAction value) {
        return supporter.put(key, value);
    }
    
    

    
    
    
    /**
     * Get the value of actionNodes
     *
     * @return the value of actionNodes
     */
    public Set<GroundAction> getActionNodes() {
        return actionNodes;
    }

    /**
     * Set the value of actionNodes
     *
     * @param actionNodes new value of actionNodes
     */
    public void setActionNodes(Set<GroundAction> actionNodes) {
        this.actionNodes = actionNodes;
    }


    /**
     * Get the value of factsNodes
     *
     * @return the value of factsNodes
     */
    public Set<Predicate> getFactsNodes() {
        return factsNodes;
    }

    /**
     * Set the value of factsNodes
     *
     * @param factsNodes new value of factsNodes
     */
    public void setFactsNodes(Set<Predicate> factsNodes) {
        this.factsNodes = factsNodes;
    }

    /**
     * Get the value of initialNodes
     *
     * @return the value of initialNodes
     */
    public Set<Predicate> getInitialNodes() {
        return initialNodes;
    }

    /**
     * Set the value of initialNodes
     *
     * @param initialNodes new value of initialNodes
     */
    public void setInitialNodes(Set<Predicate> initialNodes) {
        this.initialNodes = initialNodes;
    }

    
    
}

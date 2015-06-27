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
package problem;

import domain.ActionSchema;
import domain.SchemaGlobalConstraint;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import propositionalFactory.Instantiator;

/**
 *
 * @author enrico
 */
public class PddlSCProblem extends PddlProblem {

    public HashSet globalConstraintSet;
    private boolean globalConstraintGrounded;

    public PddlSCProblem(String problemFile) {
        super(problemFile);
        globalConstraintSet = new LinkedHashSet();
        globalConstraintGrounded = false;

    }

    public PddlSCProblem(String problemFile, PDDLObjects po) {
        super(problemFile, po);
        globalConstraintSet = new LinkedHashSet();
        globalConstraintGrounded = false;

    }

    public void instantiate() {
        try {
            this.generateActions();
            this.generateConstraints();

        } catch (Exception ex) {
            Logger.getLogger(PddlSCProblem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void generateActions() throws Exception {
        long start = System.currentTimeMillis();
        if (this.isValidatedAgainstDomain()) {
            Instantiator af = new Instantiator();
            for (ActionSchema act : (Set<ActionSchema>) linkedDomain.getActionsSchema()) {
//                af.Propositionalize(act, objects);
                if (act.getParameters().size() != 0) {
                    getActions().addAll(af.Propositionalize(act, getObjects()));
                } else {
                    GroundAction gr = act.ground();
                    getActions().add(gr);

                }
            }
            //pruneActions();
        } else {
            System.err.println("Please connect the domain of the problem via validation");
            System.exit(-1);
        }
        Iterator it = getActions().iterator();
        //System.out.println("prova");
        System.out.println(getActions().size());
        while (it.hasNext()) {
            GroundAction act = (GroundAction) it.next();
            boolean keep = true;
            if (isSimplifyActions()) {
                keep = act.simplifyModelWithControllableVariablesSem(linkedDomain, this);
            }
            if (!keep) {
                //System.out.println("Pruning action:"+act.getName());
                it.remove();
            }
        }
        System.out.println(getActions().size());

        setPropositionalTime(System.currentTimeMillis() - start);
        this.setGroundedActions(true);

    }

    public void generateConstraints() throws Exception {
        long start = System.currentTimeMillis();
        if (this.isValidatedAgainstDomain()) {
            Instantiator af = new Instantiator();
            for (SchemaGlobalConstraint constr : (Set<SchemaGlobalConstraint>) linkedDomain.getSchemaGlobalConstraints()) {
//                af.Propositionalize(act, objects);
                if (constr.parameters.size() != 0) {
                    globalConstraintSet.addAll(af.Propositionalize(constr, getObjects()));
                } else {
                    GlobalConstraint gr = constr.ground();
                    globalConstraintSet.add(gr);
                }
            }
            //pruneActions();
        } else {
            System.err.println("Please connect the domain of the problem via validation");
            System.exit(-1);
        }
        
     
        Iterator it = this.globalConstraintSet.iterator();

        while (it.hasNext()) {
            GlobalConstraint constr = (GlobalConstraint) it.next();
            boolean keep = true;

                keep = constr.simplifyModelWithControllableVariablesSem(linkedDomain, this);
            
            if (!keep) {
                //System.out.println("Pruning action:"+act.getName());
                it.remove();
            }
        }
        
        
        setPropositionalTime(this.getPropositionalTime() + (System.currentTimeMillis() - start));
        this.globalConstraintGrounded = true;

    }
}

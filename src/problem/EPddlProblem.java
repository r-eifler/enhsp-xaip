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

import conditions.AndCond;
import conditions.Conditions;
import domain.ActionSchema;
import domain.ProcessSchema;
import domain.SchemaGlobalConstraint;
import expressions.NumFluent;
import java.util.Collection;
import java.util.HashMap;
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
public class EPddlProblem extends PddlProblem {

    public HashSet globalConstraintSet;
    public HashSet processesSet;
    private boolean globalConstraintGrounded;
    private boolean processesGround;
    public AndCond globalConstraints;
    
    private boolean grounding;

    public EPddlProblem(String problemFile) {
        super(problemFile);
        globalConstraintSet = new LinkedHashSet();
        processesSet = new LinkedHashSet();
        globalConstraintGrounded = false;
        processesGround = false;
        grounding = false;

    }

    public EPddlProblem(String problemFile, PDDLObjects po) {
        super(problemFile, po);
        globalConstraintSet = new LinkedHashSet();
        globalConstraintGrounded = false;
        grounding = false;
    }

    public void grounding() {
        try {
            if (grounding)
                return;
            this.generateActionsAndProcesses();
            this.generateConstraints();
            grounding = true;
        } catch (Exception ex) {
            Logger.getLogger(EPddlProblem.class.getName()).log(Level.SEVERE, null, ex);
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
    
    
    public void generateActionsAndProcesses() throws Exception {
        long start = System.currentTimeMillis();
        if (this.isValidatedAgainstDomain()) {
            Instantiator af = new Instantiator();
            for (ActionSchema act : (Set<ActionSchema>) linkedDomain.getActionsSchema()) {
//                af.Propositionalize(act, objects);
                if (!act.getParameters().isEmpty()) {
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
        processesSet = new LinkedHashSet();
        if (this.isValidatedAgainstDomain()) {
            Instantiator af = new Instantiator();
            for (ProcessSchema process : (Set<ProcessSchema>) linkedDomain.getProcessesSchema()) {
//                af.Propositionalize(act, objects);
                if (process.getParameters().size() != 0) {
                    processesSet.addAll(af.Propositionalize(process, getObjects()));
                } else {
                    GroundProcess gr = process.ground();
                    processesSet.add(gr);
                }
            }
            //pruneActions();
        } else {
            System.err.println("Please connect the domain of the problem via validation");
            System.exit(-1);
        }
        
        
        Iterator it = getActions().iterator();
        //System.out.println("prova");
        while (it.hasNext()) {
            GroundAction act = (GroundAction) it.next();
            boolean keep = true;
            if (isSimplifyActions()) {
                keep = act.simplifyModelWithControllableVariablesSem(linkedDomain, this);
            }
            if (!keep) {
//                System.out.println("Pruning action:"+act.getName());
                it.remove();
            }
        }

        
        it = this.processesSet.iterator();
        while (it.hasNext()) {
            GroundProcess process = (GroundProcess) it.next();
            boolean keep = true;

                keep = process.simplifyModelWithControllableVariablesSem(linkedDomain, this);
            
            if (!keep) {
                //System.out.println("Pruning action:"+act.getName());
                it.remove();
            }
        }
        
        setPropositionalTime(this.getPropositionalTime() + (System.currentTimeMillis() - start));
        this.processesGround = true;
        this.setGroundedActions(true);


    }
    
    @Override
    public HashMap getInvariantFluents() throws Exception {
        if (invariantFluents == null) {
            invariantFluents = new HashMap();
            if (this.getActions() == null || this.getActions().isEmpty()) {
                this.generateActionsAndProcesses();
            }
            for (GroundAction gr : (Collection<GroundAction>) this.getActions()) {
                for (NumFluent nf : gr.getNumericFluentAffected().keySet()) {
                    invariantFluents.put(nf, Boolean.FALSE);
                }
            }
            for (GroundProcess pr : (Collection<GroundProcess>) this.processesSet) {
                for (NumFluent nf : pr.getNumericFluentAffected().keySet()) {
                    invariantFluents.put(nf, Boolean.FALSE);
                }
            }
        }
        return invariantFluents;
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
        globalConstraints = new AndCond();

        while (it.hasNext()) {
            GlobalConstraint constr = (GlobalConstraint) it.next();
            boolean keep = true;

                keep = constr.simplifyModelWithControllableVariablesSem(linkedDomain, this);
            
            if (!keep) {
                //System.out.println("Pruning action:"+act.getName());
                it.remove();
            }else{
                globalConstraints.addConditions(constr.condition);
                globalConstraints.normalize();
            }
                
        }
        
        
        
        setPropositionalTime(this.getPropositionalTime() + (System.currentTimeMillis() - start));
        this.globalConstraintGrounded = true;

    }
    
    public void generateProcesses() throws Exception {
        long start = System.currentTimeMillis();
        processesSet = new LinkedHashSet();
        if (this.isValidatedAgainstDomain()) {
            Instantiator af = new Instantiator();
            for (ProcessSchema process : (Set<ProcessSchema>) linkedDomain.getProcessesSchema()) {
//                af.Propositionalize(act, objects);
                if (process.getParameters().size() != 0) {
                    processesSet.addAll(af.Propositionalize(process, getObjects()));
                } else {
                    GroundProcess gr = process.ground();
                    processesSet.add(gr);
                }
            }
            //pruneActions();
        } else {
            System.err.println("Please connect the domain of the problem via validation");
            System.exit(-1);
        }
        
     
        Iterator it = this.processesSet.iterator();
        while (it.hasNext()) {
            GroundProcess process = (GroundProcess) it.next();
            boolean keep = true;

                keep = process.simplifyModelWithControllableVariablesSem(linkedDomain, this);
            
            if (!keep) {
                //System.out.println("Pruning action:"+act.getName());
                it.remove();
            }
        }
        
        
        setPropositionalTime(this.getPropositionalTime() + (System.currentTimeMillis() - start));
        this.processesGround = true;

    }
    
    @Override
    public void transform_numeric_condition() throws Exception {

        for (GroundAction gr : (Collection<GroundAction>) this.actions) {
            if (gr.getPreconditions() != null) {
                gr.setPreconditions(generate_inequalities(gr.getPreconditions()));
            }
        }
        
        for (GroundProcess pr : (Collection<GroundProcess>) this.processesSet) {
            if (pr.getPreconditions() != null) {
                pr.setPreconditions(generate_inequalities(pr.getPreconditions()));
            }
        }
        //globalConstraints.normalize();
        //globalConstraints = (AndCond)globalConstraints.transform_equality();
        
        goals.normalize();
        this.goals = generate_inequalities(goals);
    }
    
    public void normalize_conditions() throws Exception {

        for (GroundAction gr : (Collection<GroundAction>) this.actions) {
            if (gr.getPreconditions() != null) {
                gr.getPreconditions().normalize();
            }
        }
        
        for (GroundProcess pr : (Collection<GroundProcess>) this.processesSet) {
            if (pr.getPreconditions() != null) {
                pr.getPreconditions().normalize();
            }
        }
        //globalConstraints.normalize();
        //globalConstraints = (AndCond)globalConstraints.transform_equality();
        
        goals.normalize();
    }
}

/*
 * Copyright (C) 2010-2017 Enrico Scala. Contact: enricos83@gmail.com.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package com.hstairs.ppmajal.problem;

import com.carrotsearch.hppc.DoubleArrayList;
import com.google.common.collect.Sets;
import com.hstairs.ppmajal.conditions.*;
import com.hstairs.ppmajal.domain.*;
import com.hstairs.ppmajal.expressions.*;
import com.hstairs.ppmajal.extraUtils.Pair;
import com.hstairs.ppmajal.heuristics.Aibr;
import com.hstairs.ppmajal.propositionalFactory.Grounder;
import com.hstairs.ppmajal.search.SearchEngine;
import it.unimi.dsi.fastutil.objects.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author enrico
 */
public class EPddlProblem extends PddlProblem {

    public HashSet<GlobalConstraint> globalConstraintSet;
    private Set<GroundProcess> processesSet;
    private Set<GroundEvent> eventsSet;

    public AndCond globalConstraints;

    private boolean grounding;
    private boolean action_cost_from_metric = true;
    private boolean risky = false;
    private NumFluent time;
    private boolean processesHaveBeenGrounded;
    private boolean globalConstraintGrounded;
    private HashMap<Object, Integer> idOf;
    private int constraintsViolations;
    private int totActionsEventsProcesses;
    private int totEvents;
    private PDDLState pureInit;
    private HashMap<String, Terminal> terminalReference;
    private HashMap<String, NumFluent> numFluentReference;
    protected int nActions;


    public EPddlProblem ( ) {
    }

    public EPddlProblem (String problemFile, PDDLObjects po, Set<Type> types) {

        super(problemFile, po, types);
        globalConstraintSet = new LinkedHashSet();
        eventsSet = new LinkedHashSet();
        globalConstraints = new AndCond();
        grounding = false;
        totActionsEventsProcesses = 0;
        totEvents = 0;
    }


    @Override
    public Object clone ( ) throws CloneNotSupportedException {

        EPddlProblem cloned = new EPddlProblem(this.pddlFilRef, this.objects, this.types);
        cloned.processesSet = new LinkedHashSet();
        for (GroundAction gr : this.actions) {
            cloned.actions.add((GroundAction) gr.clone());
        }
        for (GroundProcess pr : this.getProcessesSet()) {
            cloned.getProcessesSet().add((GroundProcess) pr.clone());
        }
        for (GlobalConstraint constr : this.globalConstraintSet) {
            cloned.globalConstraintSet.add((GlobalConstraint) constr.clone());
        }
        return this;

    }

    public HashMap<String,NumFluent> getNumericFluentReference(){
        if (this.numFluentReference == null){
            numFluentReference = new HashMap<>();
        }
        return this.numFluentReference;
    }

    @Override
    public void generateActions ( ) throws Exception {
        long start = System.currentTimeMillis();
        if (this.isValidatedAgainstDomain()) {
            Grounder af = new Grounder();
            for (ActionSchema act : linkedDomain.getActionsSchema()) {
                getActions().addAll(af.Propositionalize(act, getObjects()));
            }
        } else {
            System.err.println("Please connect the domain of the problem via validation");
            System.exit(-1);
        }

    }

    public void grounding_plus_simplifications ( ) throws Exception {

        //simplification decoupled from the grounding
        this.groundingActionProcessesConstraints();

        this.simplifyAndSetupInit();

        this.transformGoal();

    }

    @Override
    public HashMap getActualFluents ( ) {
        if (staticFluents == null) {
            staticFluents = new HashMap();
            for (GroundAction gr : (Collection<GroundAction>) this.getActions()) {
                staticFluents = gr.update_invariant_fluents(staticFluents);

            }
            if (this.getProcessesSet() != null) {
                for (GroundProcess pr : this.getProcessesSet()) {
                    staticFluents = pr.update_invariant_fluents(staticFluents);

                }
            }
            if (this.getEventsSet() != null) {
                for (GroundEvent ev : this.getEventsSet()) {
                    staticFluents = ev.update_invariant_fluents(staticFluents);

                }
            }
        }
        return staticFluents;
    }

    public void generateProcesses ( ) throws Exception {
        long start = System.currentTimeMillis();
        processesSet = new LinkedHashSet();
        if (this.isValidatedAgainstDomain()) {
            Grounder af = new Grounder();
            for (ProcessSchema process : linkedDomain.getProcessesSchema()) {
//                af.Propositionalize(act, objects);
                if (process.getParameters().size() != 0) {
                    getProcessesSet().addAll(af.Propositionalize(process, getObjects()));
                } else {
                    GroundProcess gr = process.ground();
                    getProcessesSet().add(gr);
                }
            }
            //pruneActions();
        } else {
            System.err.println("Please connect the domain of the problem via validation");
            System.exit(-1);
        }

        setPropositionalTime(this.getPropositionalTime() + (System.currentTimeMillis() - start));
        this.processesHaveBeenGrounded = true;

    }



    public void normalize_conditions ( ) {

        for (GroundAction gr : this.actions) {
            if (gr.getPreconditions() != null) {
                gr.getPreconditions().normalize();
            }
        }

        for (GroundProcess pr : this.getProcessesSet()) {
            if (pr.getPreconditions() != null) {
                pr.getPreconditions().normalize();
            }
        }
        //globalConstraints.normalize();
        //globalConstraints = (AndCond)globalConstraints.transform_equality();

        goals.normalize();
    }

    public void grounding_reachability ( ) throws Exception {
        HashSet<GroundAction> reachable = new LinkedHashSet();
        RelState s = ((PDDLState) this.init).relaxState();
        System.out.println("Intelligent Grounding");
        while (true) {
            HashSet<GroundAction> A_primo = new LinkedHashSet();
            for (ActionSchema a : this.linkedDomain.getActionsSchema()) {
                A_primo.addAll(ground(a, s));
                A_primo.removeAll(reachable);

            }
//            for (ActionSchema a:this.linkedDomain.getProcessesSchema()){
//                A_primo.addAll(ground(a,s));
//                A_primo.removeAll(reachable);
//
//            }
            if (A_primo.isEmpty()) {
                System.out.println("Reachable(" + reachable.size() + "):");
                return;
            }

            reachable.addAll(A_primo);
            for (GroundAction a : reachable) {
                s = a.apply_with_generalized_interval_based_relaxation(s);
            }

        }

    }

    public Set<GroundAction> ground (ActionSchema a, RelState s) throws Exception {

        Set<HashMap<Variable, PDDLObject>> subst = new LinkedHashSet();

        subst = find_substs(a, s);
        Set<GroundAction> ret = new LinkedHashSet();

        for (HashMap<Variable, PDDLObject> ele : subst) {
            GroundAction ground = a.ground(ele, this.getObjects());
            ret.add(ground);
        }
        return ret;
    }

    private Set<HashMap<Variable, PDDLObject>> find_substs (Object a, RelState s) throws Exception {
        Set<HashMap<Variable, PDDLObject>> subst = new HashSet();
        if (a == null) {
            return null;
        }
        if (a instanceof Predicate) {
            Predicate p1 = (Predicate) a;
            for (Predicate p : this.initBoolFluentsValues.keySet()) {

                boolean conflict = false;
                if (p1.isUngroundVersionOf(p)) {
                    HashMap<Variable, PDDLObject> subst_p = new HashMap();

                    for (int i = 0; i < p1.getTerms().size(); i++) {
                        subst_p.put((Variable) p1.getTerms().get(i), (PDDLObject) p.getTerms().get(i));
                    }
                    if (!conflict) {
                        subst.add(subst_p);
                    }
                }
            }
        } else if (a instanceof NumFluent) {
            NumFluent nf = (NumFluent) a;
            for (NumFluent p : this.initNumFluentsValues.keySet()) {
                boolean conflict = false;
                if (nf.isUngroundVersionOf(p)) {
                    HashMap<Variable, PDDLObject> subst_p = new HashMap();

                    for (int i = 0; i < nf.getTerms().size(); i++) {
                        subst_p.put((Variable) nf.getTerms().get(i), (PDDLObject) p.getTerms().get(i));
                    }
                    subst.add(subst_p);
                }
            }
        } else if (a instanceof Comparison) {
            Comparison comp = (Comparison) a;
            //ArrayList<Variable> list_of_vars = comp.getVariablesInvolved();
            for (NumFluent nf : comp.getInvolvedFluents()) {
                if (subst.isEmpty()) {
                    subst = this.find_substs(nf, s);
                } else {
                    subst = intersect(subst, this.find_substs(nf, s));
                }
            }

        } else if (a instanceof NumEffect) {
            NumEffect n_eff = (NumEffect) a;
            //ArrayList<Variable> list_of_vars = comp.getVariablesInvolved();
            if (n_eff.getRight().getInvolvedNumericFluents().isEmpty()) {
                subst.add(new HashMap());
            } else {
                for (NumFluent nf : n_eff.getRight().getInvolvedNumericFluents()) {
                    if (subst.isEmpty()) {
                        subst = this.find_substs(nf, s);
                    } else {
                        subst = intersect(subst, this.find_substs(nf, s));
                    }
                }
            }

        } else if (a instanceof AndCond) {
            AndCond comp = (AndCond) a;
            //ArrayList<Variable> list_of_vars = comp.getVariablesInvolved();
            if (comp.sons.isEmpty()) {
                return null;//universal assignment
            }
            for (Object o : comp.sons) {
                if (subst.isEmpty()) {
                    subst = this.find_substs(o, s);
                } else {
                    subst = intersect(subst, this.find_substs(o, s));
                }
            }

        } else if (a instanceof OrCond) {
            OrCond comp = (OrCond) a;
            //ArrayList<Variable> list_of_vars = comp.getVariablesInvolved();
            if (comp.sons.isEmpty()) {
                return null;//universal assignment
            }
            for (Object o : comp.sons) {
                subst.addAll(this.find_substs(o, s));
            }

        } else if (a instanceof NotCond) {//this is problematique.
            NotCond nc = (NotCond) a;
            subst = Grounder.substitutions(nc.getInvolvedVariables(), objects);
//            for (Object o: nc.son){
            subst.removeAll(this.find_substs(nc.getSon(), s));
//            }
        } else if (a instanceof ActionSchema) {
            ActionSchema gr = (ActionSchema) a;
            if (gr.getPar() == null || gr.getPar().isEmpty()) {
                subst.add(new HashMap());
            } else {
                subst = this.find_substs_effects(gr, s, this.find_substs(gr.getPreconditions(), s));
            }

        }
        return subst;

    }

    //to chech thoroghously!!
    public Set<HashMap<Variable, PDDLObject>> intersect (Set<HashMap<Variable, PDDLObject>> a, Set<HashMap<Variable, PDDLObject>> b) {
        Set<HashMap<Variable, PDDLObject>> ret = new LinkedHashSet();
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        for (HashMap<Variable, PDDLObject> grounding : a) {
            Set<Variable> all_vars = new LinkedHashSet();
            all_vars.addAll(grounding.keySet());
            for (HashMap<Variable, PDDLObject> grounding2 : b) {
                all_vars.addAll(grounding2.keySet());
                boolean conflict = false;
                HashMap<Variable, PDDLObject> t = new HashMap();
                for (Variable v : all_vars) {
                    PDDLObject o1 = grounding.get(v);
                    PDDLObject o2 = grounding2.get(v);
                    if (o1 != null && o2 != null && !o1.equals(o2)) {
                        conflict = true;
                        break;
                    }
                    if (o1 == null) {
                        t.put(v, o2);
                    } else {
                        t.put(v, o1);
                    }
                }
                if (!conflict) {
                    ret.add(t);
                }
            }
        }
        return ret;
    }

    private Set<HashMap<Variable, PDDLObject>> find_substs_effects (ActionSchema gr, RelState s, Set<HashMap<Variable, PDDLObject>> subst) throws Exception {

        /*In this setting here, you have to generate a number of substitutions. Each one of them is a possible grounding of the
        action according to its effect. This has to be intersected with what we have discovered so far, but still it has to be done*/
        //add list
        subst = intersect(subst, Grounder.substitutions(gr.getAddList().getInvolvedVariables(), objects));
        subst = intersect(subst, Grounder.substitutions(gr.getDelList().getInvolvedVariables(), objects));

        subst = intersect(subst, this.find_substs(gr.getNumericEffects(), s));

        subst = intersect(subst, Grounder.substitutions(gr.getNumericEffects().getInvolvedVariables(), objects));

        //the following is a (failed) attempt to optimise the thing
//
//                ArrayList<Variable> alread_assigned = new ArrayList();
//        for (HashMap<Variable,PDDLObject> t : subst){
//            alread_assigned.addAll(t.keySet());
//            if (alread_assigned.size()>= gr.getPar().size())
//                break;
//        }
//        ArrayList<Variable> temp = new ArrayList(gr.getAddList().getInvolvedVariables());
//        temp.retainAll(alread_assigned);
//        subst = intersect(subst,Instantiator.substitutions(temp, objects));
//        temp = new ArrayList(gr.getDelList().getInvolvedVariables());
//        temp.retainAll(alread_assigned);
//        subst = intersect(subst,Instantiator.substitutions(temp, objects));
//
//        subst = intersect(subst,this.find_substs(gr.getNumericEffects(), s));
//
//        temp = new ArrayList(gr.getNumericEffects().getInvolvedVariables());
//        temp.retainAll(alread_assigned);
//        subst = intersect(subst,Instantiator.substitutions(temp, objects));
        return subst;
    }

    private boolean conflicting (PDDLObject get, PDDLObject get0) {
        if (get0.getName().equals("#Universe#")) {
            return false;
        }
        return !get0.equals(get);

    }

    public void transform_constant_effect ( ) throws Exception {

//        HashSet to_readd = new HashSet();
        for (GroundAction gr : this.actions) {
            if (gr.getNumericEffects() != null && !gr.getNumericEffects().sons.isEmpty()) {
                int numberNumericEffects = gr.getNumericEffects().sons.size();
                for (Iterator it = gr.getNumericEffects().sons.iterator(); it.hasNext(); ) {
                    NumEffect neff = (NumEffect) it.next();
                    if (neff.getOperator().equals("assign")) {
                        ExtendedNormExpression right = (ExtendedNormExpression) neff.getRight();
                        if (right.isNumber() && neff.getFluentAffected().eval(init) != null && (numberNumericEffects == 1 || risky)) {//constant effect
                            //Utils.dbg_print(3,neff.toString());
//                            if (numberNumericEffects == 1) {
                            neff.setOperator("increase");
                            neff.setRight(new BinaryOp(neff.getRight(), "-", neff.getFluentAffected(), true).normalize());
                            neff.setPseudo_num_effect(true);
//                            }
                        }
                    }

                }
            }
            gr.normalize();

        }
//        this.actions.addAll(to_readd);
//        to_readd = new HashSet();

        for (GroundEvent gr : this.getEventsSet()) {
            if (gr.getNumericEffects() != null && !gr.getNumericEffects().sons.isEmpty()) {
                int numberNumericEffects = gr.getNumericEffects().sons.size();
                for (Iterator it = gr.getNumericEffects().sons.iterator(); it.hasNext(); ) {
                    NumEffect neff = (NumEffect) it.next();
                    if (neff.getOperator().equals("assign")) {

                        ExtendedNormExpression right = (ExtendedNormExpression) neff.getRight();
                        if (right.isNumber() && neff.getFluentAffected().eval(init) != null && (numberNumericEffects == 1 || risky)) {//constant effect
                            //Utils.dbg_print(3,neff.toString());
//                            if (numberNumericEffects == 1) {
                            neff.setOperator("increase");
                            neff.setRight(new BinaryOp(neff.getRight(), "-", neff.getFluentAffected(), true).normalize());
                            neff.setPseudo_num_effect(true);
//                            } else {
//                                GroundAction gr2 = (GroundAction) gr.clone();
//                                gr2.setNumericEffects(new AndCond());
//                                gr2.setName("pseudo_increase"+gr.getName());
//
//                                NumEffect newEffect = new NumEffect("increase");
//                                newEffect.setRhs(new BinaryOp(neff.getRhs(), "-", neff.getFluentAffected(), true).normalize());
//                                newEffect.setPseudo_num_effect(true);
//                                gr2.getNumericEffects().sons.add(newEffect);
//                                gr2.normalize();
//                                to_readd.add(gr2);
//                                it.remove();
//
//                            }
                        }
                    }

                }
            }
            gr.normalize();

        }
//        this.eventsSet.addAll(to_readd);

    }

    public void generateConstraints ( ) throws Exception {
        if (this.isValidatedAgainstDomain()) {
            Grounder af = new Grounder();
            for (SchemaGlobalConstraint constr : linkedDomain.getSchemaGlobalConstraints()) {
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
        this.globalConstraintGrounded = true;
    }

    public void groundingActionProcessesConstraints ( ) throws Exception {
        long start = System.currentTimeMillis();

        this.groundGoals();
        this.generateActions();
        this.generateProcesses();
        this.generateConstraints();
        this.generateEvents();
        this.setGroundedRepresentation(true);
        this.processesHaveBeenGrounded = true;
        this.globalConstraintGrounded = true;
        this.getActualFluents();
        if (this.metric != null && this.metric.getMetExpr() != null) {
            this.metric.setMetExpr(this.metric.getMetExpr().normalize());
        } else {
            this.metric = null;
        }

        setPropositionalTime(this.getPropositionalTime() + (System.currentTimeMillis() - start));
        syncAllVariables();

    }


    public void set_cost_from_metric ( ) {
        Iterator it = getActions().iterator();

        //System.out.println("prova");
//        System.out.println("DEBUG: Before simplifications, |A|:"+getActions().size());
        while (it.hasNext()) {
            GroundAction act = (GroundAction) it.next();
            if (this.getMetric() != null && isAction_cost_from_metric()) {// &&  !this.getMetric().pddlPrint().contains("total-time")) {
                act.setAction_cost((PDDLState) init, this.getMetric());
            } else {
                act.set_unit_cost((PDDLState) init);
            }
        }

    }

    public void cleanEasyUnreachableTransitions (Iterable toWorkOut){
        Iterator it = toWorkOut.iterator();
        while (it.hasNext()) {
            GroundAction act = (GroundAction) it.next();
            boolean keep = true;
            if (isSimplifyActions()) {
                try {
                    keep = act.simplifyModelWithControllableVariablesSem(linkedDomain, this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (!keep) {
                it.remove();
            }
        }
    }

    protected void removeStaticParts(){
        this.staticFluents = null;//reset this
        removeStaticPart();
        removeUnnecessaryFluents();
    }

    protected void pruningViaReachability (){
        //System.out.println("prova");

        sweepStructuresForUnreachableStatements();
        this.saveInitInit();
        removeStaticParts();
        setActionCosts();
        setProcessEventsCost();

        Aibr aibr = new Aibr(this.goals, actions, processesSet, eventsSet);
        Float setup = aibr.setup(this.makePddlState());
        System.out.println("(After AIBR):"+aibr.reachable.size());
        this.reachableActions = aibr.reachable;
        splitOverActionsEventsProcesses(this.reachableActions);
        sweepStructuresForUnreachableStatements();
    }

    protected void sweepStructuresForUnreachableStatements(){
            this.staticFluents = null;
            //the following just remove actions/processes/events over false and static predicates
            cleanEasyUnreachableTransitions(actions);
            this.staticFluents = null;
            cleanEasyUnreachableTransitions(processesSet);
            this.staticFluents = null;
            cleanEasyUnreachableTransitions(eventsSet);
            this.staticFluents = null;
            cleanIrrelevantConstraints(globalConstraintSet);
            this.processesHaveBeenGrounded = true;
            this.setGroundedRepresentation(true);
            this.globalConstraintGrounded = true;

            goals = (ComplexCondition) goals.weakEval(this, this.getActualFluents());
            goals.normalize();

            if (this.metric != null && this.metric.getMetExpr() != null) {
                this.metric.setMetExpr(this.metric.getMetExpr().weakEval(this, this.getActualFluents()));
                this.metric.setMetExpr(this.metric.getMetExpr().normalize());
            } else {
                this.metric = null;
            }

    }

    protected void pruningViaRelevance (){

            this.reachableActions = keepOnlyRelTransitions(this.reachableActions,this.goals);
            splitOverActionsEventsProcesses(this.reachableActions);
            sweepStructuresForUnreachableStatements();
            removeStaticParts();
            //At this point there should be even less relevant facts that needs to be stored
    }

    /**
     * This method changes the id of each of the GroundAction involved in the problem. In doing so, the
     * method rebuilds the set eventsSet, actions, processesSet and reachableActions. These sets depend on the
     * way the equality method of the GroundAction is constructed. As this changes because of the change of the id, so
     * these sets need to be re-initialised.
     */
    protected void idifyTransitions(){
        int nActions = 0;
        reachableActions = new LinkedHashSet<>();
        ArrayList<GroundAction> union = new ArrayList(Sets.union(eventsSet, Sets.union(actions, processesSet)));
        for (GroundAction gr : union) {
            gr.setId(nActions);
            nActions++;
            reachableActions.add(gr);
        }
        splitOverActionsEventsProcesses(reachableActions);
    }

    public void simplifyAndSetupInit() throws Exception {

        long start = System.currentTimeMillis();
        System.out.println("(Pre Simplification) - |A|+|P|+|E|: "+(getActions().size() + getProcessesSet().size() + getEventsSet().size()));
        System.out.println("(Pre Simplification) - Global Constraints Size: " + this.globalConstraintSet.size());

        pruningViaReachability();

        pruningViaRelevance();

        idifyTransitions();
        // normalize global constraints, once and forall
        globalConstraints.normalize();

        makeInit();

        System.out.println("(After Simplification) - |A|+|P|+|E|: " + (getActions().size() + getProcessesSet().size() + getEventsSet().size()));
        System.out.println("(After Simplification) - Global Constraints Size: " + this.globalConstraints.sons.size());
        long end = System.currentTimeMillis();

        System.out.println("Simplification Time: " + (end - start));

    }

//    private void idifyConditionsAndTransitions (Collection<GroundAction> reachableActions, ComplexCondition goals, AndCond globalConstraints) {
//        HashMap<Integer, GroundAction> actionIds = new HashMap<>();
//        HashMap<Integer, Condition> conditionsIds = new HashMap<>();
//        int actionID = 0;
//        int conditionID = 0;
//        for (GroundAction gr: reachableActions){
//            if (!actionIds.values().contains(gr)){
//                actionIds.put(actionID,gr);
//                Set<Condition> terminalConditions = gr.getPreconditions().getTerminalConditions();
//                Set<Condition> addListTerminalConditions = gr.getAddList().getTerminalConditions();
//                Set<Condition> delListTerminalConditions = gr.getDelList().getTerminalConditions();
//            }
//            //preconditions
//        }
//    }

    private void cleanIrrelevantConstraints (HashSet<GlobalConstraint> globalConstraintSet) {
        Iterator<GlobalConstraint> it = globalConstraintSet.iterator();
        globalConstraints = new AndCond();

        while (it.hasNext()) {
            GlobalConstraint constr = (GlobalConstraint) it.next();
            boolean keep = constr.simplifyModelWithControllableVariablesSem(linkedDomain, this);

            if (!keep) {
                it.remove();
            } else {
                globalConstraints.addConditions(constr.condition);
            }

        }
    }

    private void setProcessEventsCost ( ) {
        for (GroundProcess gp : processesSet){
            gp.setAction_cost(1);
        }
        for (GroundEvent gp : eventsSet){
            gp.setAction_cost(1);
        }
    }

    protected Set<GroundAction> keepOnlyRelTransitions (Set<GroundAction> transitions, Condition necessaryGoals) {
        if (transitions.isEmpty()) {
            return new HashSet();
        }
        LinkedList<Object> goal = new LinkedList<>(necessaryGoals.getTerminalConditions());
        HashSet<Object> seen = new HashSet<>();
        ReferenceSet<GroundAction> transitionsToKeep = new ReferenceLinkedOpenHashSet<>();
        LinkedList<GroundAction> missing = new LinkedList<>(transitions);

        while (!goal.isEmpty()) {
            Object pop = goal.pop();
            if (seen.add(pop)) {
                final ListIterator<GroundAction> it = missing.listIterator();
                while (it.hasNext()) {
                    final GroundAction gr = it.next();
                    boolean keep = false;
                    if (pop instanceof NotCond || pop instanceof Predicate) {
                        if (gr.getAddList() != null && gr.getAddList().sons != null) {
                            keep = gr.getAddList().sons.contains(pop);
                        }
                        if (!keep && gr.getDelList() != null && gr.getDelList().sons != null) {
                            keep = gr.getDelList().sons.contains(pop);
                        }
                    }
                    else if (pop instanceof Comparison) {//this needs optimisation
                        Comparison comp = (Comparison)pop;
                        Set<NumFluent> numericFluentAffected = Sets.newHashSet(gr.getNumericFluentAffected());
                        Set<NumFluent> involvedFluents = Sets.newHashSet(comp.getInvolvedFluents());
                        Sets.SetView<NumFluent> intersection = Sets.intersection(numericFluentAffected, involvedFluents);
                        if (!intersection.isEmpty()) {
                            keep = true;
                        }
                    }
                    else if (pop instanceof Expression){
                        Expression expr = (Expression)pop;
                        Set<NumFluent> numericFluentAffected = Sets.newHashSet(gr.getNumericFluentAffected());
                        Set<NumFluent> involvedFluents = Sets.newHashSet(expr.getInvolvedNumericFluents());
                        Sets.SetView<NumFluent> intersection = Sets.intersection(numericFluentAffected, involvedFluents);
                        if (!intersection.isEmpty()) {
                            keep = true;
                        }
                    }

                    if (keep) {
                        transitionsToKeep.add(gr);
                        it.remove();
                        for (Condition t: gr.getPreconditions().getTerminalConditions()){
                            if (!seen.contains(t)){
                                goal.add(t);
                            }
                        }
                        for (NumEffect neff : gr.getNumericEffectsAsCollection()){
                            if (!(neff.getRight() instanceof PDDLNumber) && !seen.contains(neff.getRight())){
                                goal.add(neff.getRight());
                            }
                        }
                    }
                }
            }
        }

        return transitionsToKeep;

    }

    protected void splitOverActionsEventsProcesses (Iterable<GroundAction> transitionsToKeep) {
        processesSet = new LinkedHashSet<>();
        eventsSet = new LinkedHashSet<>();
        actions = new LinkedHashSet<>();
        for (GroundAction gr: transitionsToKeep){
            if (gr instanceof GroundProcess){
                processesSet.add((GroundProcess) gr);
            }else if (gr instanceof GroundEvent){
                eventsSet.add((GroundEvent) gr);
            }else {
                actions.add(gr);
            }
        }
    }

    public void setDeltaTimeVariable (String delta_t) {
        this.initNumFluentsValues.put(new NumFluent("#t"), new PDDLNumber(Double.parseDouble(delta_t)));
    }

    private void generateEvents ( ) {
        long start = System.currentTimeMillis();
        if (this.isValidatedAgainstDomain()) {
            Grounder af = new Grounder();
            for (EventSchema event_schema : linkedDomain.eventsSchema) {
//                af.Propositionalize(act, objects);
                if (!event_schema.getPar().isEmpty()) {
                    try {
                        this.getEventsSet().addAll(af.Propositionalize(event_schema, getObjects()));
                    } catch (Exception ex) {
                        Logger.getLogger(EPddlProblem.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    GroundEvent event = event_schema.fakeGround();
                    this.getEventsSet().add(event);

                }
            }
            //pruneActions();
        } else {
            System.err.println("Please connect the domain of the problem via validation");
            System.exit(-1);
        }

    }

    private void removeStaticPart ( ) {
        //invariant fluents
        LinkedHashSet<Predicate> predicateToRemove = new LinkedHashSet();
        for (Predicate p : this.initBoolFluentsValues.keySet()) {
            if (this.getActualFluents().get(p) == null) {
                predicateToRemove.add(p);
            }
        }
        LinkedHashSet<NumFluent> numFluentsToRemove = new LinkedHashSet();
        for (NumFluent p : this.initNumFluentsValues.keySet()) {
            if (this.getActualFluents().get(p) == null) {
                numFluentsToRemove.add(p);
            }
        }

        this.initBoolFluentsValues.keySet().removeAll(predicateToRemove);
        this.initNumFluentsValues.keySet().removeAll(numFluentsToRemove);

    }

    private void removeUnnecessaryFluents ( ) {

        Set<NumFluent> involved_fluents = new LinkedHashSet();

        for (ActionSchema a : this.linkedDomain.getActionsSchema()) {
            involved_fluents.addAll(a.getPreconditions().getInvolvedFluents());
            involved_fluents.addAll(a.getNumFluentsNecessaryForExecution());
        }
        for (ProcessSchema a : this.linkedDomain.getProcessesSchema()) {
            involved_fluents.addAll(a.getPreconditions().getInvolvedFluents());
            involved_fluents.addAll(a.getNumFluentsNecessaryForExecution());

        }
        for (EventSchema a : this.linkedDomain.eventsSchema) {
            involved_fluents.addAll(a.getPreconditions().getInvolvedFluents());
            involved_fluents.addAll(a.getNumFluentsNecessaryForExecution());

        }
        for (SchemaGlobalConstraint a : this.linkedDomain.getSchemaGlobalConstraints()) {
            involved_fluents.addAll(a.condition.getInvolvedFluents());
        }
        involved_fluents.addAll(goals.getInvolvedFluents());

        Iterator<NumFluent> it = this.initNumFluentsValues.keySet().iterator();
        while (it.hasNext()) {
            NumFluent nf2 = it.next();
            boolean keep_it = false;
            for (NumFluent nf : involved_fluents) {
                if (nf.getName().equals(nf2.getName())) {
                    keep_it = true;
                    break;
                }
            }
            if (!keep_it) {
                nf2.setHas_to_be_tracked(false);
                it.remove();
            }
        }

    }

    private PDDLState makePddlState(){
        DoubleArrayList numFluents = new DoubleArrayList();
        numFluents.resize(getNumericFluentReference().size());
        for (NumFluent nf : getNumericFluentReference().values()) {
            if (this.getActualFluents().get(nf) != null && nf.has_to_be_tracked()) {
                PDDLNumber number = this.initNumFluentsValues.get(nf);
                if (number == null){
                    numFluents.set(nf.getId(),Double.NaN);
                }else {
                    numFluents.set(nf.getId(),number.getNumber());
                }
            }
        }

        BitSet boolFluents = new BitSet();
        for (Terminal t : getTerminalReference().values()) {
            if (t instanceof Predicate) {
                Predicate p = (Predicate)t;
                if (this.getActualFluents().get(p) != null) {
                    Boolean r = this.initBoolFluentsValues.get(p);
                    if (r == null || !r) {
                        boolFluents.set(p.getId(),false);
                    } else {
                        boolFluents.set(p.getId(),true);
                    }
                }
            }
        }
        return new PDDLState(numFluents,boolFluents);
    }

    protected void makeInit ( ) {
        this.init = makePddlState();
        addTimeFluentToInit();
    }


    private void add_possible_numeric_fluents_from_assignments ( ) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the action_cost_from_metric
     */
    public boolean isAction_cost_from_metric ( ) {
        return action_cost_from_metric;
    }

    /**
     * @param action_cost_from_metric the action_cost_from_metric to set
     */
    public void setAction_cost_from_metric (boolean action_cost_from_metric) {
        this.action_cost_from_metric = action_cost_from_metric;
    }

    private void setActionCosts ( ) {
        Iterator it = getActions().iterator();

        //System.out.println("prova");
//        System.out.println("DEBUG: Before simplifications, |A|:"+getActions().size());
        while (it.hasNext()) {
            GroundAction act = (GroundAction) it.next();
            if (this.getMetric() != null && isAction_cost_from_metric()) {// &&  !this.getMetric().pddlPrint().contains("total-time")) {
                act.setAction_cost((PDDLState) init, this.getMetric());
            } else {
                act.set_unit_cost((PDDLState) init);
            }
        }
    }

    public Boolean goalSatisfied (State s) {
        return s.satisfy(this.getGoals());
    }

    private void groundGoals ( ) {

        this.goals = (ComplexCondition) this.goals.ground(new HashMap(), objects);

    }

    public int getNextTerminalReferenceId ( ) {
        return getTerminalReference().size();
    }


    public Terminal getTerminalReference (String s) {
        if (this.terminalReference == null){
            return null;
        }
        return this.terminalReference.get(s);
    }

    public void putTerminalReference (Terminal t) {
        getTerminalReference().put(t.toString(),t);
    }

    protected HashMap<String,Terminal> getTerminalReference() {
        if (terminalReference == null) {
            terminalReference = new HashMap<>();
        }
        return terminalReference;
    }

    public void syncAllVariables ( ) {

        HashMap<Predicate,Boolean> tempInitBool = new HashMap();
        for (Predicate p : this.initBoolFluentsValues.keySet()) {
            Boolean value = this.initBoolFluentsValues.get(p);
            Predicate newP = (Predicate) p.unifyVariablesReferences(this);
            tempInitBool.put(newP,value);

        }
        initBoolFluentsValues = tempInitBool;
        HashMap<NumFluent,PDDLNumber> tempInitFluent = new HashMap();
        for (NumFluent nf : this.initNumFluentsValues.keySet()) {
            PDDLNumber pddlNumber = initNumFluentsValues.get(nf);
            NumFluent numFluent = (NumFluent)nf.unifyVariablesReferences(this);
            tempInitFluent.put(numFluent, pddlNumber);
            this.numFluentReference.put(nf.toString(), nf);
        }
        this.initNumFluentsValues = tempInitFluent;

        for (PDDLGenericAction act : this.actions) {
            act.unifyVariablesReferences(this);
        }
        for (PDDLGenericAction act : this.getEventsSet()) {
            act.unifyVariablesReferences(this);
        }
        if (this.getProcessesSet() != null) {
            for (PDDLGenericAction act : this.getProcessesSet()) {
                act.unifyVariablesReferences(this);
            }
        }
        goals = (ComplexCondition) goals.unifyVariablesReferences(this);

        Iterator<GlobalConstraint> it = this.globalConstraintSet.iterator();
        while (it.hasNext()) {
            GlobalConstraint gc = it.next();
            gc.condition = gc.condition.unifyVariablesReferences(this);
        }

        globalConstraints = (AndCond) globalConstraints.unifyVariablesReferences(this);
        if (metric != null) {
            metric = metric.unifyVariablesReferences(this);
        }
        if (belief != null) {
            belief = belief.unifyVariablesReferences(this);
        }
    }

    public void addTimeFluentToInit ( ) {
        ((PDDLState) this.init).time = 0d;
    }

    public NumFluent getNumfluentReference (String stringRepresentation) {
        return getNumericFluentReference().get(stringRepresentation);
    }


    private void reduceInit ( ) {
//        System.out.println("|BoolVar| = "+this.init.boolFluents.size());
//        Aibr serviceHeuristic = new Aibr(this.goals, this.actions,this.processesSet,this.eventsSet);
//        serviceHeuristic.setup(this.init);
//        serviceHeuristic.set(true, true);
//        serviceHeuristic.computeEstimate(this.init);
//        Collection<Predicate> predicateToConsider = new HashSet();
//        for (Predicate p : this.predicateReference.values()){
//            if (p.id != null){
//                if (serviceHeuristic.reacheable_state.possBollValues.get(p.id)>0){
//                    predicateToConsider.add(p);
//                }else{
//                    p.id = null;
//                }
//            }
//        }
//        this.init.boolFluents = new ArrayList();
//        for (Predicate p: predicateToConsider){
//            p.id = init.boolFluents.size();
//            init.boolFluents.add(this.initBoolFluentsValues.get(p));
//        }
//        System.out.println("After Reachability |BoolVar| = "+this.init.boolFluents.size());
//        
    }

    @Override
    public ObjectIterator<Pair<State, Object>> getSuccessors (State s) {
//        if (s.getApplicableActions()!=null) {
//            return new stateContainer(s, (Iterable) s.getApplicableActions());
//        }
        return new stateContainer(s, (Collection) getReachableActions());
    }

    public boolean milestoneReached (Float d, Float current_value, State temp) {
        return d < current_value && this.isSafeState(temp);
    }

    private List<GroundEvent> getReacheableEvents ( ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Iterable<GroundAction> getReachableProcesses ( ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private ArrayList<GroundEvent> eventsApplication (State s, float delta1, List<GroundEvent> events) throws CloneNotSupportedException {
        ArrayList<GroundEvent> ret = new ArrayList<>();
        while (true) {
            boolean at_least_one = false;
            for (GroundEvent ev : events) {
                if (ev.isApplicable(s)) {
                    at_least_one = true;
                    s.apply(ev);
                    GroundEvent ev1 = (GroundEvent) ev.clone();
                    ev1.time = delta1;
                    ret.add(ev1);
                }
            }
            if (!at_least_one) {
                return ret;
            }
        }

    }

    private Pair<List<State>, ArrayList<ArrayList<GroundAction>>> advanceTime (float delta, float delta_max, State s) {

        constraintsViolations = 0;
        List<State> states = new LinkedList();
        List<ArrayList<GroundAction>> transitions = new LinkedList();
        try {
            float i = 0.00000f;
            State temp = s.clone();
            ArrayList<GroundAction> waiting_list = new ArrayList<>();
            boolean at_least_one = false;
            while (i < delta_max) {
                State temp_temp = temp.clone();
                waiting_list.addAll(eventsApplication(temp_temp, i, this.getReacheableEvents()));
                i += delta;

                GroundProcess waiting = new GroundProcess("waiting");
                waiting.setNumericEffects(new AndCond());
                waiting.setPreconditions(new AndCond());
                //waiting.add_time_effects(((PDDLState)temp).time, executionDelta);
                waiting.addDelta(delta);
                for (GroundAction act : this.getReachableProcesses()) {
                    if (act instanceof GroundProcess) {
                        GroundProcess gp = (GroundProcess) act;
                        if (gp.isActive(temp_temp)) {
                            //System.out.println(gp.toEcoString());
                            AndCond precondition = (AndCond) waiting.getPreconditions();
                            precondition.addConditions(gp.getPreconditions());
                            gp.getNumericEffectsAsCollection().forEach((eff) -> {
                                waiting.add_numeric_effect(eff);
                            });
                            waiting.setPreconditions(precondition);
                        }
                    }
                }
                waiting_list.add(waiting);

                temp_temp.apply(waiting);
                waiting_list.addAll(eventsApplication(temp_temp, i, this.getReacheableEvents()));

                //the next has to be written better!!!! Spend a bit of time on that!
                boolean valid = temp_temp.satisfy(globalConstraints);//zero crossing?!?!?
                if (!valid) {
                    constraintsViolations++;
                } else {
                    at_least_one = true;
                    if (temp_temp.satisfy(getGoals())) {//very very easy zero crossing for opportunities. This should include also action preconditions
                        states.add(temp_temp);
                        transitions.add(waiting_list);
                    }
                }
                if (!valid || i >= delta_max) {
                    if (i >= delta_max && valid) {
                        temp = temp_temp;
                    } else {
//                        System.out.println("smaller jump here?");
//                        System.out.println("Waiting at this time for:"+i);
                    }
                    if (at_least_one) {
                        states.add(temp);
                        transitions.add(waiting_list);
                    }
                    break;
                } else {
                    temp = temp_temp;
                }
            }
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(SearchEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Pair(states, transitions);
    }

    public Set<GroundEvent> getEventsSet ( ) {
        return eventsSet;
    }

    public Set<GroundProcess> getProcessesSet ( ) {
        return processesSet;
    }

    public State getInitInit ( ) {
        if (this.pureInit == null) {
            this.pureInit = new MAPPDDLState(this.initNumFluentsValues,initBoolFluentsValues);
        }
        return pureInit;
    }

    public State saveInitInit ( ) {
        if (this.pureInit == null) {
            this.pureInit = new MAPPDDLState(this.initNumFluentsValues,initBoolFluentsValues);
        }
        return pureInit;
    }

    public int getNextNumFluentReference ( ) {
        return getNumericFluentReference().size();
    }

    public void putNumFluentReference (NumFluent t) {
        getNumericFluentReference().put(t.toString(),t);
    }


    protected class stateContainer implements ObjectIterator<Pair<State, Object>> {
        protected final State source;
        final private Iterable<Object> actionsSet;
        protected final Iterator<Object> it;
        protected Object current;
        protected State newState;
//        boolean cached;

        public stateContainer (State source, Iterable<Object> actionsSet) {
            this.source = source;
            this.actionsSet = actionsSet;
            //cached = source.getApplicableActions()!=null;
            it = actionsSet.iterator();
        }

        @Override
        public boolean hasNext ( ) {

            while (it.hasNext()) {
                current = it.next();
                if ( ((GroundAction) current).isApplicable(source)) {
                    newState = source.clone();
                    return newState.satisfy(globalConstraints);
                }
            }
            return false;
        }

        @Override
        public Pair<State, Object> next ( ) {
            newState.apply(((GroundAction) current));
            return new Pair(newState, current);
        }
    }


}

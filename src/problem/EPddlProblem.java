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
package problem;

import conditions.AndCond;
import conditions.Comparison;
import conditions.ComplexCondition;
import conditions.NotCond;
import conditions.OrCond;
import conditions.PDDLObject;
import conditions.Predicate;
import domain.ActionSchema;
import domain.EventSchema;
import domain.PDDLGenericAction;
import domain.ProcessSchema;
import domain.SchemaGlobalConstraint;
import domain.Type;
import domain.Variable;
import expressions.BinaryOp;
import expressions.ExtendedNormExpression;
import expressions.NumEffect;
import expressions.NumFluent;
import expressions.PDDLNumber;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import propositionalFactory.Grounder;

/**
 *
 * @author enrico
 */
public class EPddlProblem extends PddlProblem {

    public HashSet<GlobalConstraint> globalConstraintSet;
    public HashSet<GroundProcess> processesSet;
    public HashSet<GroundEvent> eventsSet;

    public AndCond globalConstraints;

    private boolean grounding;
    private boolean action_cost_from_metric = true;
    private boolean risky = true;
    private NumFluent time;
    private boolean processesHaveBeenGrounded;
    private boolean globalConstraintGrounded;

    @Override
    public Object clone() throws CloneNotSupportedException {

        EPddlProblem cloned = new EPddlProblem(this.pddlFilRef, this.objects, this.types);
        cloned.processesSet = new LinkedHashSet();
        for (PDDLGroundAction gr : this.actions) {
            cloned.actions.add((PDDLGroundAction) gr.clone());
        }
        for (GroundProcess pr : this.processesSet) {
            cloned.processesSet.add((GroundProcess) pr.clone());
        }
        for (GlobalConstraint constr : this.globalConstraintSet) {
            cloned.globalConstraintSet.add((GlobalConstraint) constr.clone());
        }
        //cloned.globalConstraints = (AndCond) this.globalConstraints.clone();
        return this;

    }

    public EPddlProblem() {

    }

    public EPddlProblem(String problemFile, PDDLObjects po, Set<Type> types) {
        super(problemFile, po, types);
        globalConstraintSet = new LinkedHashSet();
        eventsSet = new LinkedHashSet();
        globalConstraints = new AndCond();
        grounding = false;
    }

    public void grounding() {
        try {
            if (grounding) {
                return;
            }
            this.grounding_plus_simplifications();
            grounding = true;
        } catch (Exception ex) {
            Logger.getLogger(EPddlProblem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void generateActions() throws Exception {
        long start = System.currentTimeMillis();
        if (this.isValidatedAgainstDomain()) {
            Grounder af = new Grounder();
            for (ActionSchema act : (Set<ActionSchema>) linkedDomain.getActionsSchema()) {
//                af.Propositionalize(act, objects);
                //if (act.getPar().size() != 0) {
                getActions().addAll(af.Propositionalize(act, getObjects()));
                //} else {
                //    GroundAction gr = act.ground();
                //    getActions().add(gr);

                //
            }
            //pruneActions();
        } else {
            System.err.println("Please connect the domain of the problem via validation");
            System.exit(-1);
        }

    }

    public void grounding_plus_simplifications() throws Exception {

        //simplification decoupled from the grounding
        this.grounding_action_processes_constraints();

        this.simplifyAndSetupInit();

        this.transformNumericConditionsInActions();

    }

    @Override
    public HashMap getActualFluents() {
        if (staticFluents == null) {
//            if ((this.getActions() == null || this.getActions().isEmpty()) && (this.processesSet == null || this.processesSet.isEmpty())) {
//                this.grounding_action_processes_constraints();
//            }
            staticFluents = new HashMap();
            for (PDDLGroundAction gr : (Collection<PDDLGroundAction>) this.getActions()) {
                staticFluents = gr.update_invariant_fluents(staticFluents);

            }
            if (this.processesSet != null) {
                for (GroundProcess pr : (Collection<GroundProcess>) this.processesSet) {
                    staticFluents = pr.update_invariant_fluents(staticFluents);

                }
            }
            if (this.eventsSet != null) {
                for (GroundEvent ev : (Collection<GroundEvent>) this.eventsSet) {
                    staticFluents = ev.update_invariant_fluents(staticFluents);

                }
            }
        }
        return staticFluents;
    }

    public void generateProcesses() throws Exception {
        long start = System.currentTimeMillis();
        processesSet = new LinkedHashSet();
        if (this.isValidatedAgainstDomain()) {
            Grounder af = new Grounder();
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

        setPropositionalTime(this.getPropositionalTime() + (System.currentTimeMillis() - start));
        this.processesHaveBeenGrounded = true;

    }

    @Override
    public void transformNumericConditionsInActions() throws Exception {

        for (PDDLGroundAction gr : (Collection<PDDLGroundAction>) this.actions) {
            if (gr.getPreconditions() != null) {
                gr.setPreconditions(generate_inequalities(gr.getPreconditions()));
            }
        }

        for (GroundProcess pr : (Collection<GroundProcess>) this.processesSet) {
            if (pr.getPreconditions() != null) {
                pr.setPreconditions(generate_inequalities(pr.getPreconditions()));
            }
        }

        for (GroundEvent pr : (Collection<GroundEvent>) this.eventsSet) {
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

        for (PDDLGroundAction gr : (Collection<PDDLGroundAction>) this.actions) {
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

    private void unify_objects_names(PDDLState init, Set<PDDLGroundAction> actions, Set<GroundProcess> processesSet) {
        this.predicates_universe = new LinkedHashSet();
        this.num_fluent_universe = new LinkedHashSet();
        for (PDDLGroundAction gr : actions) {
            Collection involved_nf = gr.getInvolvedNumFluents();
            Collection involved_predicates = gr.getInvolvedPredicates();
            add_if_necessary(involved_nf, this.num_fluent_universe);
            add_if_necessary(involved_predicates, this.predicates_universe);
        }

        for (GroundProcess gr : processesSet) {
            Collection involved_nf = gr.getInvolvedNumFluents();
            Collection involved_predicates = gr.getInvolvedPredicates();
            add_if_necessary(involved_nf, this.num_fluent_universe);
            add_if_necessary(involved_predicates, this.predicates_universe);
        }

        for (Predicate p : this.predicates_universe) {
            for (PDDLGroundAction gr : actions) {
                gr.subst_predicate(p);
            }
            for (GroundProcess gr : processesSet) {
                gr.subst_predicate(p);
            }
        }

        for (Predicate p : this.predicates_universe) {
            for (PDDLGroundAction gr : actions) {
                gr.subst_predicate(p);
            }
            for (GroundProcess gr : processesSet) {
                gr.subst_predicate(p);
            }
        }

    }

    private void add_if_necessary(Collection to_be_modified, Collection set) {
        for (Object nf : to_be_modified) {
            Iterator it = set.iterator();
            boolean to_add = true;
            while (it.hasNext()) {
                Object target = it.next();
                if (target.equals(nf)) {
                    to_add = false;
                    break;
                }
            }
            if (to_add) {
                set.add(nf);
            }
        }

    }

    public void grounding_reachability() throws CloneNotSupportedException, Exception {
        HashSet<PDDLGroundAction> reachable = new LinkedHashSet();
        RelState s = this.init.relaxState();
        System.out.println("Intelligent Grounding");
        while (true) {
            HashSet<PDDLGroundAction> A_primo = new LinkedHashSet();
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
            for (PDDLGroundAction a : reachable) {
                s = a.apply_with_generalized_interval_based_relaxation(s);
            }

        }

    }

    public Set<PDDLGroundAction> ground(ActionSchema a, RelState s) throws Exception {

        Set<HashMap<Variable, PDDLObject>> subst = new LinkedHashSet();

        subst = find_substs(a, s);
        Set<PDDLGroundAction> ret = new LinkedHashSet();
        for (HashMap<Variable, PDDLObject> ele : subst) {
            ret.add(a.ground(ele, this.getObjects()));
        }
        return ret;
    }

    private Set<HashMap<Variable, PDDLObject>> find_substs(Object a, RelState s) throws Exception {
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
            if (n_eff.getRight().rhsFluents().isEmpty()) {
                subst.add(new HashMap());
            } else {
                for (NumFluent nf : n_eff.getRight().rhsFluents()) {
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
    public Set<HashMap<Variable, PDDLObject>> intersect(Set<HashMap<Variable, PDDLObject>> a, Set<HashMap<Variable, PDDLObject>> b) {
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

    private Set<HashMap<Variable, PDDLObject>> find_substs_effects(ActionSchema gr, RelState s, Set<HashMap<Variable, PDDLObject>> subst) throws Exception {

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

    private boolean conflicting(PDDLObject get, PDDLObject get0) {
        if (get0.getName().equals("#Universe#")) {
            return false;
        }
        if (get0.equals(get)) {
            return false;
        }
        return true;

    }

    public void transform_constant_effect() throws Exception {

//        HashSet to_readd = new HashSet();
        for (PDDLGroundAction gr : this.actions) {
            if (gr.getNumericEffects() != null && !gr.getNumericEffects().sons.isEmpty()) {
                int number_numericEffects = gr.getNumericEffects().sons.size();
                for (Iterator it = gr.getNumericEffects().sons.iterator(); it.hasNext();) {
                    NumEffect neff = (NumEffect) it.next();
                    if (neff.getOperator().equals("assign")) {
                        ExtendedNormExpression right = (ExtendedNormExpression) neff.getRight();
                        if (right.isNumber() && neff.getFluentAffected().eval(init) != null && (number_numericEffects == 1 || risky)) {//constant effect
                            //Utils.dbg_print(3,neff.toString());
//                            if (number_numericEffects == 1) {
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

        for (GroundEvent gr : this.eventsSet) {
            if (gr.getNumericEffects() != null && !gr.getNumericEffects().sons.isEmpty()) {
                int number_numericEffects = gr.getNumericEffects().sons.size();
                for (Iterator it = gr.getNumericEffects().sons.iterator(); it.hasNext();) {
                    NumEffect neff = (NumEffect) it.next();
                    if (neff.getOperator().equals("assign")) {

                        ExtendedNormExpression right = (ExtendedNormExpression) neff.getRight();
                        if (right.isNumber() && neff.getFluentAffected().eval(init) != null && (number_numericEffects == 1 || risky)) {//constant effect
                            //Utils.dbg_print(3,neff.toString());
//                            if (number_numericEffects == 1) {
                            neff.setOperator("increase");
                            neff.setRight(new BinaryOp(neff.getRight(), "-", neff.getFluentAffected(), true).normalize());
                            neff.setPseudo_num_effect(true);
//                            } else {
//                                GroundAction gr2 = (GroundAction) gr.clone();
//                                gr2.setNumericEffects(new AndCond());
//                                gr2.setName("pseudo_increase"+gr.getName());
//
//                                NumEffect newEffect = new NumEffect("increase");
//                                newEffect.setRight(new BinaryOp(neff.getRight(), "-", neff.getFluentAffected(), true).normalize());
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

    public void generateConstraints() throws Exception {
        if (this.isValidatedAgainstDomain()) {
            Grounder af = new Grounder();
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
        this.globalConstraintGrounded = true;
    }

    public void grounding_action_processes_constraints() throws Exception {
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

    public void set_cost_from_metric() {
        Iterator it = getActions().iterator();

        //System.out.println("prova");
//        System.out.println("DEBUG: Before simplifications, |A|:"+getActions().size());
        while (it.hasNext()) {
            PDDLGroundAction act = (PDDLGroundAction) it.next();
            if (this.getMetric() != null && isAction_cost_from_metric()) {// &&  !this.getMetric().pddlPrint().contains("total-time")) {
                act.setAction_cost(init, this.getMetric());
            } else {
                act.set_unit_cost(init);
            }
        }

    }

    public void simplifyAndSetupInit() throws Exception {
        Iterator it = getActions().iterator();

        //System.out.println("prova");
//        System.out.println("DEBUG: Before simplifications, |A|:"+getActions().size());
        while (it.hasNext()) {
            PDDLGroundAction act = (PDDLGroundAction) it.next();
            boolean keep = true;
            if (isSimplifyActions()) {
                //System.out.println("Simplifying action");
                //keep = act.simplifyModel(linkedDomain, this);
                keep = act.simplifyModelWithControllableVariablesSem(linkedDomain, this);
            }
            if (!keep) {
//                System.out.println("Pruning action:"+act.getName());
                it.remove();
            }
        }
//        System.out.println("DEBUG: After simplifications, |A|:"+getActions().size());

//        System.out.println("DEBUG: Before simplifications, |P|:"+processesSet.size());
        it = this.processesSet.iterator();
        while (it.hasNext()) {
            GroundProcess process = (GroundProcess) it.next();
            boolean keep = true;

            keep = process.simplifyModelWithControllableVariablesSem(linkedDomain, this);

            if (!keep) {
//                System.out.println("Pruning process:"+process.toEcoString());
                it.remove();
            }
            process.setAction_cost(1);
        }

        //Event
        it = this.eventsSet.iterator();
        while (it.hasNext()) {
            GroundEvent event = (GroundEvent) it.next();
            boolean keep = true;

            keep = event.simplifyModelWithControllableVariablesSem(linkedDomain, this);

            if (!keep) {
//                System.out.println("Pruning process:"+process.toEcoString());
                it.remove();
            }
            event.setAction_cost(1);
        }

//        unify_objects_names(this.getInit(),this.actions,this.processesSet);
        this.processesHaveBeenGrounded = true;
        this.setGroundedRepresentation(true);

        it = this.globalConstraintSet.iterator();
        globalConstraints = new AndCond();

        while (it.hasNext()) {
            GlobalConstraint constr = (GlobalConstraint) it.next();
            boolean keep = true;

            keep = constr.simplifyModelWithControllableVariablesSem(linkedDomain, this);

            if (!keep) {
                //System.out.println("Pruning action:"+act.getName());
                it.remove();
            } else {
                globalConstraints.addConditions(constr.condition);
                globalConstraints.normalize();
            }

        }

        this.globalConstraintGrounded = true;
        goals = (ComplexCondition) goals.weakEval(this, staticFluents);
        goals.normalize();

        if (this.metric != null && this.metric.getMetExpr() != null) {
            this.metric.setMetExpr(this.metric.getMetExpr().weakEval(this, staticFluents));
            this.metric.setMetExpr(this.metric.getMetExpr().normalize());
        } else {
            this.metric = null;
        }

        removeStaticPart();
        removeUnnecessaryFluents();
        add_possible_numeric_fluents_from_assignments();
        
        propagate_new_num_fluents_hash();
        set_actions_costs();
        makeInit();
    }

    public void setDeltaTimeVariable(String delta_t) {
        this.initNumFluentsValues.put(new NumFluent("#t"), new PDDLNumber(Double.parseDouble(delta_t)));
    }

    private void generateEvents() {
        long start = System.currentTimeMillis();
        if (this.isValidatedAgainstDomain()) {
            Grounder af = new Grounder();
            for (EventSchema event_schema : (Collection<EventSchema>) linkedDomain.eventsSchema) {
//                af.Propositionalize(act, objects);
                if (!event_schema.getPar().isEmpty()) {
                    try {
                        this.eventsSet.addAll(af.Propositionalize(event_schema, getObjects()));
                    } catch (Exception ex) {
                        Logger.getLogger(EPddlProblem.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    GroundEvent event = event_schema.fakeGround();
                    this.eventsSet.add(event);

                }
            }
            //pruneActions();
        } else {
            System.err.println("Please connect the domain of the problem via validation");
            System.exit(-1);
        }

    }

    private void removeStaticPart() throws Exception {
        //invariant fluents
        LinkedHashSet<Predicate> to_remove = new LinkedHashSet();
        for (Predicate p : this.initBoolFluentsValues.keySet()) {
            if (this.getActualFluents().get((Object) p) == null) {
                to_remove.add(p);
            }
        }
        LinkedHashSet<NumFluent> n_fluents_to_remove = new LinkedHashSet();
        for (NumFluent p : this.initNumFluentsValues.keySet()) {
            if (this.getActualFluents().get((Object) p) == null) {
                n_fluents_to_remove.add(p);
            }
        }
        this.initBoolFluentsValues.keySet().removeAll(to_remove);
        this.initNumFluentsValues.keySet().removeAll(n_fluents_to_remove);

    }

    private void removeUnnecessaryFluents() {

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
//            if (!nf2.getName().equals("time_elapsed")) {
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
//            }
        }

    }

    private void makeInit() {
        this.init.numFluents = new ArrayList();

        for (NumFluent nf : this.numFluentReference.values()) {
            if (this.getActualFluents().get(nf) != null && nf.has_to_be_tracked()) {
                nf.setId(this.init.numFluents.size());
                this.init.numFluents.add(this.initNumFluentsValues.get(nf));
            }
        }
        this.init.boolFluents = new ArrayList();
        for (Predicate p : this.predicateReference.values()) {
            if (this.getActualFluents().get(p) != null) {
                p.id = this.init.boolFluents.size();
                Boolean r = this.initBoolFluentsValues.get(p);
                if (r == null || !r) {
                    this.init.boolFluents.add(false);
                } else {
                    this.init.boolFluents.add(true);
                }
            }
        }
    }
    
    private void propagate_new_num_fluents_hash() {

    }

    private void add_possible_numeric_fluents_from_assignments() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the action_cost_from_metric
     */
    public boolean isAction_cost_from_metric() {
        return action_cost_from_metric;
    }

    /**
     * @param action_cost_from_metric the action_cost_from_metric to set
     */
    public void setAction_cost_from_metric(boolean action_cost_from_metric) {
        this.action_cost_from_metric = action_cost_from_metric;
    }

    private void set_actions_costs() {
        Iterator it = getActions().iterator();

        //System.out.println("prova");
//        System.out.println("DEBUG: Before simplifications, |A|:"+getActions().size());
        while (it.hasNext()) {
            PDDLGroundAction act = (PDDLGroundAction) it.next();
            if (this.getMetric() != null && isAction_cost_from_metric()) {// &&  !this.getMetric().pddlPrint().contains("total-time")) {
                act.setAction_cost(init, this.getMetric());
            } else {
                act.set_unit_cost(init);
            }
        }
    }

    public Boolean goalSatisfied(PDDLState s) {
        return s.satisfy(this.getGoals());
    }

    private void groundGoals() {

        this.goals = (ComplexCondition) this.goals.ground(new HashMap(), objects);

    }

    public void syncAllVariables() {

        for (PDDLGenericAction act : this.actions) {
            act.unifyVariablesReferences(this);
        }
        for (PDDLGenericAction act : this.eventsSet) {
            act.unifyVariablesReferences(this);
        }
        if (this.processesSet != null){
            for (PDDLGenericAction act : this.processesSet) {
                act.unifyVariablesReferences(this);
            }
        }
        goals = (ComplexCondition) goals.unifyVariablesReferences(this);
        globalConstraints = (AndCond) globalConstraints.unifyVariablesReferences(this);
        if (metric != null) {
            metric = metric.unifyVariablesReferences(this);
        }
        if (belief != null){
            belief = belief.unifyVariablesReferences(this);
        }
    }
    
    
    
    public void addTimeFluentToInit() {
        time = new NumFluent("time_elapsed");
        initNumFluentsValues.put(time, new PDDLNumber(new Float(0.0)));
        init.setNumFluent(time, initNumFluentsValues.get(time));
        this.init.time = time;
    }

}

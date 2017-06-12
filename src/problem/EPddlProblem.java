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
import conditions.Comparison;
import conditions.NotCond;
import conditions.NumFluentValue;
import conditions.OrCond;
import conditions.PDDLObject;
import conditions.Predicate;
import domain.ActionSchema;
import domain.EventSchema;
import domain.ProcessSchema;
import domain.SchemaGlobalConstraint;
import domain.Variable;
import expressions.BinaryOp;
import expressions.ExtendedNormExpression;
import expressions.NumEffect;
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

    public HashSet<GlobalConstraint> globalConstraintSet;
    public HashSet<GroundProcess> processesSet;
    public HashSet<GroundEvent> eventsSet;

    private boolean globalConstraintGrounded;
    private boolean processesGround;
    public AndCond globalConstraints;

    private boolean grounding;
    private boolean action_cost_from_metric = true;
    private boolean risky = true;

    @Override
    public Object clone() throws CloneNotSupportedException {
        EPddlProblem cloned = new EPddlProblem(this.pddlFilRef, this.objects);
        cloned.processesSet = new LinkedHashSet();
        for (GroundAction gr : this.actions) {
            cloned.actions.add((GroundAction) gr.clone());
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

    public EPddlProblem(String problemFile) {
        super(problemFile);
        globalConstraintSet = new LinkedHashSet();
        processesSet = new LinkedHashSet();
        eventsSet = new LinkedHashSet();

        globalConstraintGrounded = false;
        processesGround = false;
        grounding = false;

    }

    public EPddlProblem(String problemFile, PDDLObjects po) {
        super(problemFile, po);
        globalConstraintSet = new LinkedHashSet();
        globalConstraintGrounded = false;
        eventsSet = new LinkedHashSet();

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
            Instantiator af = new Instantiator();
            for (ActionSchema act : (Set<ActionSchema>) linkedDomain.getActionsSchema()) {
//                af.Propositionalize(act, objects);
                if (act.getPar().size() != 0) {
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

    }

    public void grounding_plus_simplifications() throws Exception {

        //simplification decoupled from the grounding
        this.grounding_action_processes_constraints();

        this.simplifications_action_processes_constraints();

        this.transform_numeric_condition();

    }

    @Override
    public HashMap getActualFluents() throws Exception {
        if (staticFluents == null) {
//            if ((this.getActions() == null || this.getActions().isEmpty()) && (this.processesSet == null || this.processesSet.isEmpty())) {
//                this.grounding_action_processes_constraints();
//            }
            staticFluents = new HashMap();
            for (GroundAction gr : (Collection<GroundAction>) this.getActions()) {
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

    private void unify_objects_names(State init, Set<GroundAction> actions, Set<GroundProcess> processesSet) {
        this.predicates_universe = new LinkedHashSet();
        this.num_fluent_universe = new LinkedHashSet();
        for (GroundAction gr : actions) {
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
            for (GroundAction gr : actions) {
                gr.subst_predicate(p);
            }
            for (GroundProcess gr : processesSet) {
                gr.subst_predicate(p);
            }
        }

        for (Predicate p : this.predicates_universe) {
            for (GroundAction gr : actions) {
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
        HashSet<GroundAction> reachable = new LinkedHashSet();
        RelState s = this.init.relaxState();
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

    public Set<GroundAction> ground(ActionSchema a, RelState s) throws Exception {

        Set<HashMap<Variable, PDDLObject>> subst = new LinkedHashSet();

        subst = find_substs(a, s);
        Set<GroundAction> ret = new LinkedHashSet();
        for (HashMap<Variable, PDDLObject> ele : subst) {
            ret.add(a.ground(ele));
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
            for (Predicate p : s.getPropositions()) {

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
            for (NumFluent p : s.getNumericFluents()) {
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
            subst = Instantiator.substitutions(nc.getInvolvedVariables(), objects);
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
        subst = intersect(subst, Instantiator.substitutions(gr.getAddList().getInvolvedVariables(), objects));
        subst = intersect(subst, Instantiator.substitutions(gr.getDelList().getInvolvedVariables(), objects));

        subst = intersect(subst, this.find_substs(gr.getNumericEffects(), s));

        subst = intersect(subst, Instantiator.substitutions(gr.getNumericEffects().getInvolvedVariables(), objects));

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
        for (GroundAction gr : this.actions) {
            if (gr.getNumericEffects() != null && !gr.getNumericEffects().sons.isEmpty()) {
                int number_numericEffects = gr.getNumericEffects().sons.size();
                for (Iterator it = gr.getNumericEffects().sons.iterator(); it.hasNext();) {
                    NumEffect neff = (NumEffect) it.next();
                    if (neff.getOperator().equals("assign")) {
                        ExtendedNormExpression right = (ExtendedNormExpression) neff.getRight();
                        if (right.isNumber() && neff.getFluentAffected().eval(init) != null && (number_numericEffects==1 || risky)) {//constant effect
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
                        if (right.isNumber() && neff.getFluentAffected().eval(init) != null && (number_numericEffects==1 || risky)) {//constant effect
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
        this.globalConstraintGrounded = true;
    }

    public void grounding_action_processes_constraints() throws Exception {
        long start = System.currentTimeMillis();
        this.generateActions();
        this.generateProcesses();
        this.generateConstraints();
        this.generateEvents();
        this.setGroundedRepresentation(true);
        this.processesGround = true;
        this.globalConstraintGrounded = true;
        this.getActualFluents();
        if (this.metric != null && this.metric.getMetExpr() != null) {
            this.metric.setMetExpr(this.metric.getMetExpr().normalize());
        } else {
            this.metric = null;
        }

        setPropositionalTime(this.getPropositionalTime() + (System.currentTimeMillis() - start));

    }

    public void simplifications_action_processes_constraints() throws Exception {
        Iterator it = getActions().iterator();
        //System.out.println("prova");
//        System.out.println("DEBUG: Before simplifications, |A|:"+getActions().size());
        while (it.hasNext()) {
            GroundAction act = (GroundAction) it.next();
            boolean keep = true;
            if (isSimplifyActions()) {
                //System.out.println("Simplifying action");
                //keep = act.simplifyModel(linkedDomain, this);
                keep = act.simplifyModelWithControllableVariablesSem(linkedDomain, this);
            }
            if (!keep) {
//                System.out.println("Pruning action:"+act.getName());
                it.remove();
            } else if (this.getMetric() != null && action_cost_from_metric) {// &&  !this.getMetric().pddlPrint().contains("total-time")) {
                act.setAction_cost(init, this.getMetric());
            } else {
                act.setAction_cost(init);
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
        }

//        unify_objects_names(this.getInit(),this.actions,this.processesSet);
        this.processesGround = true;
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
        goals = goals.weakEval(init, staticFluents);
        goals.normalize();
        remove_static_part_of_state();
        remove_num_fluents_not_involved_in_preconditions();

    }

    public void setDeltaTimeVariable(String delta_t) {
        this.getInit().addNumericFluent(new NumFluentValue("#t", Float.parseFloat(delta_t))); //this is the discretisation factor
//          NumFluenew NumFluentValue("time_elapsed", 0);
        this.getInit().addTimeFluent();
    }

    private void generateEvents() {
        long start = System.currentTimeMillis();
        if (this.isValidatedAgainstDomain()) {
            Instantiator af = new Instantiator();
            for (EventSchema event_schema : (Set<EventSchema>) linkedDomain.getEventSchema()) {
//                af.Propositionalize(act, objects);
                if (!event_schema.getPar().isEmpty()) {
                    try {
                        this.eventsSet.addAll(af.Propositionalize(event_schema, getObjects()));
                    } catch (Exception ex) {
                        Logger.getLogger(EPddlProblem.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    GroundEvent event = event_schema.ground();
                    this.eventsSet.add(event);

                }
            }
            //pruneActions();
        } else {
            System.err.println("Please connect the domain of the problem via validation");
            System.exit(-1);
        }

    }

    private void remove_static_part_of_state() throws Exception {
        //invariant fluents
        State s = this.getInit();
        LinkedHashSet<Predicate> to_remove = new LinkedHashSet();
        for (Predicate p : s.getPropositions()) {
            if (this.getActualFluents().get((Object) p) == null) {
//                System.out.println("Proposition to remove"+p);
                to_remove.add(p);
            }
        }
        LinkedHashSet<NumFluent> n_fluents_to_remove = new LinkedHashSet();
        for (NumFluent p : s.getNumericFluents()) {
            if (this.getActualFluents().get((Object) p) == null) {
//                System.out.println("Fluent to remove"+p);
                n_fluents_to_remove.add(p);
            }
        }
//        System.out.println(this.getVariantFluents());
        s.removeNumericFluents(n_fluents_to_remove);
        s.removePropositions(to_remove);

        //cost-related fluents
    }

    private void remove_num_fluents_not_involved_in_preconditions() {

        Set<NumFluent> involved_fluents = new LinkedHashSet();

        for (ActionSchema a : this.linkedDomain.getActionsSchema()) {
            involved_fluents.addAll(a.getPreconditions().getInvolvedFluents());
            involved_fluents.addAll(a.getNumFluentsNecessaryForExecution());
        }
        for (ProcessSchema a : this.linkedDomain.getProcessesSchema()) {
            involved_fluents.addAll(a.getPreconditions().getInvolvedFluents());
            involved_fluents.addAll(a.getNumFluentsNecessaryForExecution());

        }
        for (EventSchema a : this.linkedDomain.getEventSchema()) {
            involved_fluents.addAll(a.getPreconditions().getInvolvedFluents());
            involved_fluents.addAll(a.getNumFluentsNecessaryForExecution());

        }
        for (SchemaGlobalConstraint a : this.linkedDomain.getSchemaGlobalConstraints()) {
            involved_fluents.addAll(a.condition.getInvolvedFluents());
        }
        involved_fluents.addAll(goals.getInvolvedFluents());

        Iterator<NumFluent> it = this.init.numericFs.keySet().iterator();
        while (it.hasNext()) {
            NumFluent nf2 = it.next();
            if (!nf2.getName().equals("time_elapsed")) {

                boolean keep_it = false;
                for (NumFluent nf : involved_fluents) {
                    if (nf.getName().equals(nf2.getName())) {
                        keep_it = true;
                        break;
                    }
                }
                if (!keep_it) {
                    it.remove();
                }
            }
        }

    }

}

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

import com.google.common.collect.Sets;
import com.hstairs.ppmajal.conditions.*;
import com.hstairs.ppmajal.domain.*;
import com.hstairs.ppmajal.transition.ConditionalEffects;
import com.hstairs.ppmajal.transition.Transition;
import com.hstairs.ppmajal.transition.TransitionGround;
import com.hstairs.ppmajal.transition.TransitionSchema;
import com.hstairs.ppmajal.expressions.*;
import com.hstairs.ppmajal.extraUtils.Pair;
import com.hstairs.ppmajal.heuristics.Aibr;
import com.hstairs.ppmajal.propositionalFactory.Grounder;
import com.hstairs.ppmajal.search.SearchEngine;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.ReferenceLinkedOpenHashSet;
import it.unimi.dsi.fastutil.objects.ReferenceSet;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.Set.of;

/**
 * @author enrico
 */
public class EPddlProblem extends PddlProblem {

    public HashSet<GlobalConstraint> globalConstraintSet;
    public AndCond globalConstraints;
    protected int nActions;
    private Set<TransitionGround> processesSet;
    private Set<TransitionGround> eventsSet;
    private boolean grounding;
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
    private boolean smallExpensive = false;
    private int numberOfBooleanVariables;
    private int numberOfNumericVariables;
    private boolean debug;
    private boolean cacheComparison = false;
    static public HashSet<Predicate> booleanFluents;

    public EPddlProblem (String problemFile, PDDLObjects po, Set<Type> types, PddlDomain linked) {
        super(problemFile, po, types, linked);
        globalConstraintSet = new LinkedHashSet();
        eventsSet = new LinkedHashSet();
        globalConstraints = new AndCond();
        grounding = false;
        totActionsEventsProcesses = 0;
        totEvents = 0;
    }

    public EPddlProblem() {
        super();
    }

    public EPddlProblem(AndCond temp, Collection<TransitionGround> reachable) {
        this();
        goals = temp;
        actions = reachable;
    }



    @Override
    public Object clone ( ) throws CloneNotSupportedException {

        EPddlProblem cloned = new EPddlProblem(this.pddlFilRef, this.objects, this.types, linkedDomain);
        cloned.processesSet = new LinkedHashSet();
        for (TransitionGround gr : this.actions) {
            throw new UnsupportedOperationException();
        }
        for (TransitionGround pr : this.getProcessesSet()) {
            throw new UnsupportedOperationException();
        }
        for (GlobalConstraint constr : this.globalConstraintSet) {
            cloned.globalConstraintSet.add((GlobalConstraint) constr.clone());
        }
        return this;

    }

    public HashMap<String, NumFluent> getNumericFluentReference ( ) {
        if (this.numFluentReference == null) {
            numFluentReference = new HashMap<>();
        }
        return this.numFluentReference;
    }

    public void generateTransitions( ){
        long start = System.currentTimeMillis();
            Grounder af = new Grounder(belief == null);
            ArrayList<TransitionSchema> transitions = new ArrayList<>();
            transitions.addAll(linkedDomain.getProcessesSchema());
            transitions.addAll(linkedDomain.getActionsSchema());
            transitions.addAll(linkedDomain.eventsSchema);
            for (TransitionSchema act : transitions) {
                Collection<TransitionGround> propositionalize = af.Propositionalize(act, getObjects(), this, initBoolFluentsValues, linkedDomain);
                switch (act.getSemantics()){
                    case ACTION:
                        getActions().addAll(propositionalize);
                        break;
                    case PROCESS:
                        getEventsSet().addAll(propositionalize);
                        break;
                    case EVENT:
                        getProcessesSet().addAll(propositionalize);
                        break;
                }
            }


    }

    public void groundingSimplication( ) throws Exception {

        //simplification decoupled from the grounding
        this.groundingActionProcessesConstraints();

        this.simplifyAndSetupInit();

        this.transformGoal();

    }

    public HashMap getActualFluents ( ) {
        if (staticFluents == null) {
            staticFluents = new HashMap();
            for (TransitionGround gr : (Collection<TransitionGround>) this.getActions()) {
                staticFluents = gr.updateInvariantFluents(staticFluents);

            }
            if (this.getProcessesSet() != null) {
                for (TransitionGround pr : this.getProcessesSet()) {
                    staticFluents = pr.updateInvariantFluents(staticFluents);

                }
            }
            if (this.getEventsSet() != null) {
                for (TransitionGround ev : this.getEventsSet()) {
                    staticFluents = ev.updateInvariantFluents(staticFluents);

                }
            }
        }
        return staticFluents;
    }

    public void generateProcesses ( ) throws Exception {
        long start = System.currentTimeMillis();
        processesSet = new LinkedHashSet();
            Grounder af = new Grounder();
            for (TransitionSchema process : linkedDomain.getProcessesSchema()) {
//                af.Propositionalize(act, objects);
                if (!process.getParameters().isEmpty()) {
                    getProcessesSet().addAll(af.Propositionalize(process, getObjects(),this));
                }
            }


        setPropositionalTime(this.getPropositionalTime() + (System.currentTimeMillis() - start));
        this.processesHaveBeenGrounded = true;

    }



    public void generateConstraints ( ) throws Exception {
            Grounder af = new Grounder();
            for (SchemaGlobalConstraint constr : linkedDomain.getSchemaGlobalConstraints()) {
//                af.Propositionalize(act, objects);

                if (!constr.parameters.isEmpty()) {
                    globalConstraintSet.addAll(af.Propositionalize(constr, getObjects()));
                } else {
                    GlobalConstraint gr = constr.ground();
                    globalConstraintSet.add(gr);
                }
            }

        this.globalConstraintGrounded = true;
    }

    public void groundingActionProcessesConstraints ( ) throws Exception {
        long start = System.currentTimeMillis();

        this.groundGoals();
        this.generateTransitions();
        this.generateConstraints();
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
        syncAllVariablesAndUpdateCollections(this);

    }



    public void cleanEasyUnreachableTransitions (Iterable toWorkOut) {
        ArrayList arrayList = new ArrayList((Collection) toWorkOut);
        ListIterator it = arrayList.listIterator();
        while (it.hasNext()) {
            TransitionGround act = (TransitionGround) it.next();
            boolean keep = true;
            if (isSimplifyActions()) {
                try {
                    HashMap invariantFluents = this.getActualFluents();
                    Condition preconditions = act.getPreconditions();
                    final Condition condition = preconditions.weakEval(this, invariantFluents);
                    if (condition != null && !condition.isUnsatisfiable()){
                        ConditionalEffects conditionalNumericEffects = act.getConditionalNumericEffects();
                        ConditionalEffects conditionalPropositionalEffects = act.getConditionalPropositionalEffects();
                        it.set(new TransitionGround(act.getParameters(),act.getName(),
                                conditionalPropositionalEffects.weakEval(this,invariantFluents),
                                conditionalNumericEffects.weakEval(this,invariantFluents),
                                condition,
                                act.getSemantics()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (!keep) {
                it.remove();
            }
        }
    }

    protected void removeStaticParts ( ) {
        //this.staticFluents = null;//reset this
        removeStaticPart();
        removeUnnecessaryFluents();
    }

    
    protected void pruningViaReachability() {
        this.pruningViaReachability(true);
    }

    protected void pruningViaReachability(boolean aibrPreprocessing) {
        //System.out.println("prova");
        this.saveInitInit();
        sweepStructuresForUnreachableStatements();
        System.out.println("(After Easy Simplification) - |A|+|P|+|E|: " + (getActions().size() + getProcessesSet().size() + getEventsSet().size()));

        debug = false;
        if (debug){
            System.out.print("This is the universe of numeric fluent:");
            for (NumFluent nf : NumFluent.numFluentsBank.values()){
                System.out.println("ID:"+nf.getId()+"->"+nf);
            }
            System.out.print("This is the universe of propositional fluent:");
            for (Predicate pred : Predicate.predicates.values()){
                System.out.println("ID:"+pred.getId()+"->"+pred);
            }
        }
        
        if (aibrPreprocessing) {
            Aibr aibr = new Aibr(this);
            Float setup = aibr.setup(this.makePddlState());
            System.out.println("(After AIBR):" + aibr.getReachableTransitions().size());
            this.reachableActions = aibr.getReachableTransitions();
        } else {
            this.reachableActions = actions;
            this.reachableActions.addAll(this.getProcessesSet());
            this.reachableActions.addAll(this.getEventsSet());
        }
        splitOverActionsEventsProcesses(this.reachableActions);
        sweepStructuresForUnreachableStatements();

//        this.makePddlState(); //remake init so as to account for only reachable actions
    }

    protected void sweepStructuresForUnreachableStatements ( ) {
        this.staticFluents = null;
        //the following just remove actions/processes/events over false and static predicates
        cleanEasyUnreachableTransitions(actions);
//        this.staticFluents = null;
        cleanEasyUnreachableTransitions(processesSet);
//        this.staticFluents = null;
        cleanEasyUnreachableTransitions(eventsSet);
//        this.staticFluents = null;
        cleanIrrelevantConstraints(globalConstraintSet);
        this.processesHaveBeenGrounded = true;
        this.setGroundedRepresentation(true);
        this.globalConstraintGrounded = true;

        goals = (ComplexCondition) goals.weakEval(this, this.getActualFluents());
        goals = (ComplexCondition) goals.normalize();
        if (goals.isUnsatisfiable()){
            throw new RuntimeException("Goal is not reachable");
        }
        globalConstraints = (AndCond) (ComplexCondition) globalConstraints.weakEval(this, this.getActualFluents());
        globalConstraints = (AndCond) globalConstraints.normalize();
        if (globalConstraints.isUnsatisfiable()){
            throw new RuntimeException("Goal is not reachable");
        }

        if (this.metric != null && this.metric.getMetExpr() != null) {
            this.metric.setMetExpr(this.metric.getMetExpr().weakEval(this, this.getActualFluents()));
            if (this.metric.getMetExpr() == null) {
                this.metric = null;
            } else {
                this.metric.setMetExpr(this.metric.getMetExpr().normalize());
            }
        } else {
            this.metric = null;
        }

    }



        public void simplifyAndSetupInit (boolean simplify, boolean aibrPreprocessing) throws Exception {
       
        long start = System.currentTimeMillis();
        if (simplify) {
            System.out.println("(Pre Simplification) - |A|+|P|+|E|: " + (getActions().size() + getProcessesSet().size() + getEventsSet().size()));
            pruningViaReachability(aibrPreprocessing);
        }
        // normalize global constraints, once and forall
        globalConstraints = (AndCond) globalConstraints.normalize();
        makeInit();
        }

    public void simplifyAndSetupInit (boolean simplify) throws Exception {
        this.simplifyAndSetupInit(simplify, true);
    }

    public void simplifyAndSetupInit ( ) throws Exception {

        this.simplifyAndSetupInit(true);
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


    protected void splitOverActionsEventsProcesses (Iterable<TransitionGround> transitionsToKeep) {
        processesSet = new LinkedHashSet<TransitionGround>();
        eventsSet = new LinkedHashSet<TransitionGround>();
        actions = new LinkedHashSet<TransitionGround>();
        for (TransitionGround gr : transitionsToKeep) {
            switch (gr.getSemantics()){
                case ACTION:
                    actions.add(gr);
                    break;
                case PROCESS:
                    processesSet.add( gr);
                    break;
                case EVENT:
                    eventsSet.add(gr);
                    break;
            }
        }
    }

    public void setDeltaTimeVariable (String delta_t) {
        this.initNumFluentsValues.put(NumFluent.createNumFluent("#t", new ArrayList()), new PDDLNumber(Double.parseDouble(delta_t)));
    }

    private void generateEvents ( ) {
            Grounder af = new Grounder();
            for (TransitionSchema event_schema : linkedDomain.eventsSchema) {
                try {
                    eventsSet.addAll(af.Propositionalize(event_schema, getObjects(),this));
                } catch (Exception e) {
                    e.printStackTrace();
                }

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

        for (Transition a : this.linkedDomain.getActionsSchema()) {
            involved_fluents.addAll(a.getPreconditions().getInvolvedFluents());
            involved_fluents.addAll(a.getNumFluentsNecessaryForExecution());
        }
        for (Transition a : this.linkedDomain.getProcessesSchema()) {
            involved_fluents.addAll(a.getPreconditions().getInvolvedFluents());
            involved_fluents.addAll(a.getNumFluentsNecessaryForExecution());

        }
        for (Transition a : this.linkedDomain.eventsSchema) {
            involved_fluents.addAll(a.getPreconditions().getInvolvedFluents());
            involved_fluents.addAll(a.getNumFluentsNecessaryForExecution());

        }
        for (SchemaGlobalConstraint a : this.linkedDomain.getSchemaGlobalConstraints()) {
            involved_fluents.addAll(a.condition.getInvolvedFluents());
        }
        involved_fluents.addAll(goals.getInvolvedFluents());

        
        if (NumFluent.numFluentsBank != null){
            Iterator<NumFluent> it = this.getNumericFluentReference().values().iterator();
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
                    nf2.needsTrackingInState(false);
                    it.remove();
                }
                else{
                    nf2.needsTrackingInState(true);
                }
            }
        }

    }

    private PDDLState makePddlState ( ) {
        //ensure compactness
        removeStaticPart();
        removeUnnecessaryFluents();
        HashMap<Integer,Double> numFluents = new HashMap();
        numberOfNumericVariables = 0;
        if (NumFluent.numFluentsBank != null){
//        System.out.println(NumFluent.numFluentsBank);
            for (NumFluent nf : NumFluent.numFluentsBank.values()) {
                if (this.getActualFluents().get(nf) != null && nf.has_to_be_tracked()) {
                    PDDLNumber number = this.initNumFluentsValues.get(nf);
                    if (number == null) {
                        numFluents.put(nf.getId(), Double.NaN);
                    } else {
                        numFluents.put(nf.getId(), number.getNumber().doubleValue());
                    }
                    numberOfNumericVariables++;
                }
            }
        }
        
        booleanFluents = new HashSet();
        BitSet boolFluents = new BitSet();
        numberOfBooleanVariables = 0;
        if (Predicate.idToPredicate != null) {
            for (Predicate p : Predicate.idToPredicate.values()) {
                if (this.getActualFluents().get(p) != null) {
                    Boolean r = this.initBoolFluentsValues.get(p);
                    if (r == null || !r) {
                        //boolFluents.set(p.getId(), false);
                    } else {
                        boolFluents.set(p.getId(), true);
                    }
                    numberOfBooleanVariables++;
                    booleanFluents.add(p);
                }

            }
        }
        PDDLState pddlState = null;
        if (cacheComparison){
            pddlState = new PDDLStateWithCache(numFluents,boolFluents);
        }else{
            if (smallExpensive){
                pddlState = new PDDLStateWithInt2Double(numFluents, boolFluents);
            }else{
                pddlState = new PDDLState(numFluents,boolFluents);
            }
        }
        
//        System.out.println(Printer.stringBuilderPddlPrintWithDummyTrue(this, pddlState));
        return pddlState;
        
    }

    protected void makeInit ( ) {
        this.init = makePddlState();
        addTimeFluentToInit();
    }

    public int getNumberOfBooleanVariables() {
        return numberOfBooleanVariables;
    }

    

    private void add_possible_numeric_fluents_from_assignments ( ) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        if (this.terminalReference == null) {
            return null;
        }
        return this.terminalReference.get(s);
    }

    public void putTerminalReference (Terminal t) {
        getTerminalReference().put(t.toString(), t);
    }

    protected HashMap<String, Terminal> getTerminalReference ( ) {
        if (terminalReference == null) {
            terminalReference = new HashMap<>();
        }
        return terminalReference;
    }


    public void syncAllVariablesAndUpdateCollections (EPddlProblem inputProblem) {

        if (inputProblem == null) {
            inputProblem = this;
        }
        HashMap<Predicate, Boolean> tempInitBool = new HashMap();
        for (Predicate p : this.initBoolFluentsValues.keySet()) {
            Boolean value = this.initBoolFluentsValues.get(p);
            Predicate newP = (Predicate) p.unifyVariablesReferences(inputProblem);
            tempInitBool.put(newP, value);

        }
        initBoolFluentsValues = tempInitBool;
        HashMap<NumFluent, PDDLNumber> tempInitFluent = new HashMap();
        for (NumFluent nf : this.initNumFluentsValues.keySet()) {
            PDDLNumber pddlNumber = initNumFluentsValues.get(nf);
            NumFluent numFluent = (NumFluent) nf.unifyVariablesReferences(inputProblem);
            tempInitFluent.put(numFluent, pddlNumber);
            this.getNumericFluentReference().put(nf.toString(), nf);
        }
        this.initNumFluentsValues = tempInitFluent;
        
        goals = (ComplexCondition) goals.unifyVariablesReferences(inputProblem);

        Iterator<GlobalConstraint> it = this.globalConstraintSet.iterator();
        while (it.hasNext()) {
            GlobalConstraint gc = it.next();
            gc.condition = gc.condition.unifyVariablesReferences(inputProblem);
        }

        globalConstraints = (AndCond) globalConstraints.unifyVariablesReferences(inputProblem);
        if (metric != null) {
            metric = metric.unifyVariablesReferences(inputProblem);
        }
        if (belief != null) {
            belief = belief.unifyVariablesReferences(inputProblem);
        }
        if (this.unknonw_predicates != null){
            for (Predicate p: this.unknonw_predicates){
                p = (Predicate) p.unifyVariablesReferences(inputProblem);
            }
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

    public Collection<TransitionGround> getReacheableEvents() {
        return this.reachableEvents;
    }

    public Collection<TransitionGround> getReachableProcesses ( ) {
        return this.reachableProcesses;
    }

    private ArrayList<TransitionGround> eventsApplication (State s, float delta1, Collection<TransitionGround> events) throws CloneNotSupportedException {
        ArrayList<TransitionGround> ret = new ArrayList<>();
        while (true) {
            boolean at_least_one = false;
            for (TransitionGround ev : events) {
                if (ev.isApplicable(s)) {
                    at_least_one = true;
                    s.apply(ev,s.clone());
                    ret.add(ev);
                }
            }
            if (!at_least_one) {
                return ret;
            }
        }

    }
//
//    private Pair<List<State>, ArrayList<ArrayList<GroundAction>>> advanceTime (float delta, float delta_max, State s) {
//
//        constraintsViolations = 0;
//        List<State> states = new LinkedList();
//        List<ArrayList<GroundAction>> transitions = new LinkedList();
//        try {
//            float i = 0.00000f;
//            State temp = s.clone();
//            ArrayList<GroundAction> waiting_list = new ArrayList<>();
//            boolean at_least_one = false;
//            while (i < delta_max) {
//                State temp_temp = temp.clone();
//                waiting_list.addAll(eventsApplication(temp_temp, i, this.getReacheableEvents()));
//                i += delta;
//
//                waiting.setNumericEffects(new AndCond());
//                waiting.setPreconditions(new AndCond());
//                //waiting.add_time_effects(((PDDLState)temp).time, executionDelta);
//                waiting.addDelta(delta);
//                for (GroundAction act : this.getReachableProcesses()) {
//                    if (act instanceof GroundProcess) {
//                        GroundProcess gp = (GroundProcess) act;
//                        if (gp.isActive(temp_temp)) {
//                            //System.out.println(gp.toEcoString());
//                            AndCond precondition = (AndCond) waiting.getPreconditions();
//                            precondition.addConditions(gp.getPreconditions());
//                            gp.getNumericEffectsAsCollection().forEach((eff) -> {
//                                waiting.add_numeric_effect(eff);
//                            });
//                            waiting.setPreconditions(precondition);
//                        }
//                    }
//                }
//                TransitionGround waiting = new TransitionGround("waiting",-1);
//                waiting_list.add(waiting);
//
//                temp_temp.apply(waiting,temp_temp.clone());
//                waiting_list.addAll(eventsApplication(temp_temp, i, this.getReacheableEvents()));
//
//                //the next has to be written better!!!! Spend a bit of time on that!
//                boolean valid = temp_temp.satisfy(globalConstraints);//zero crossing?!?!?
//                if (!valid) {
//                    constraintsViolations++;
//                } else {
//                    at_least_one = true;
//                    if (temp_temp.satisfy(getGoals())) {//very very easy zero crossing for opportunities. This should include also action preconditions
//                        states.add(temp_temp);
//                        transitions.add(waiting_list);
//                    }
//                }
//                if (!valid || i >= delta_max) {
//                    if (i >= delta_max && valid) {
//                        temp = temp_temp;
//                    } else {
////                        System.out.println("smaller jump here?");
////                        System.out.println("Waiting at this time for:"+i);
//                    }
//                    if (at_least_one) {
//                        states.add(temp);
//                        transitions.add(waiting_list);
//                    }
//                    break;
//                } else {
//                    temp = temp_temp;
//                }
//            }
//        } catch (CloneNotSupportedException ex) {
//            Logger.getLogger(SearchEngine.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return new Pair(states, transitions);
//    }

    public Set<TransitionGround> getEventsSet ( ) {
        return eventsSet;
    }

    public Set<TransitionGround> getProcessesSet ( ) {
        return processesSet;
    }

    public State getInitInit ( ) {
        if (this.pureInit == null) {
            this.pureInit = new MAPPDDLState(this.initNumFluentsValues, initBoolFluentsValues);
        }
        return pureInit;
    }

    public State saveInitInit ( ) {
        if (this.pureInit == null) {
            this.pureInit = new MAPPDDLState(this.initNumFluentsValues, initBoolFluentsValues);
        }
        return pureInit;
    }

    public int getNextNumFluentReference ( ) {
        return getNumericFluentReference().size();
    }

    public void putNumFluentReference (NumFluent t) {
        getNumericFluentReference().put(t.toString(), t);
    }

    private Collection<TransitionGround> reachableProcesses;
    private LinkedHashSet<TransitionGround> reachableEvents;
    private HashMap<TransitionGround, TransitionGround> heuristicActionToProblemAction;

    private TransitionGround findTransition(Iterator it, TransitionGround gr) {
        while (it.hasNext()) {
            TransitionGround gr2 = (TransitionGround)it.next();
            
            if (gr.equals(gr2)) {
                heuristicActionToProblemAction.put(gr, gr2);
                return gr2;
            }
        }
        return null;
    }
    
    private TransitionGround getActionFromProblemModel (TransitionGround gr) {

        if (heuristicActionToProblemAction == null) {
            heuristicActionToProblemAction = new HashMap<TransitionGround, TransitionGround>();
        }
        TransitionGround res = heuristicActionToProblemAction.get(gr);
        if (res == null) {
            //look among actions
            Iterator<TransitionGround> it = this.actions.iterator();
            res = (TransitionGround) findTransition(it,gr);
            if (res == null){
                res = findTransition(this.processesSet.iterator(),gr);
            }
            if (res == null){
                res = findTransition(this.eventsSet.iterator(),gr);
            }
        }
        return res;
    }
    
    public void setReachableTransitions (Collection<TransitionGround> actionsToConsider) {
        reachableActions = new LinkedHashSet();
        reachableProcesses = new LinkedHashSet();
        reachableEvents = new LinkedHashSet();
        if (actionsToConsider == actions){
            reachableActions = actions;
            return;
        }
        for (final TransitionGround gr : actionsToConsider) {
            TransitionGround actionFromProblemModel = getActionFromProblemModel(gr);
            if (actionFromProblemModel != null){
                switch (actionFromProblemModel.getSemantics()){
                    case ACTION:
                        reachableActions.add(actionFromProblemModel);
                        break;
                    case PROCESS:
                        reachableProcesses.add((TransitionGround)actionFromProblemModel);
                        break;
                    case EVENT:
                        reachableEvents.add((TransitionGround)actionFromProblemModel);
                        break;
                }
            }
        }
    }

    public void setReachableActions(Collection<TransitionGround> helpfulActions) {
        reachableActions = helpfulActions;
    }

    public int getNumberOfNumericVariables() {
        return numberOfNumericVariables;
    }


    protected class stateContainer implements ObjectIterator<Pair<State, Object>> {
        protected final State source;
        protected final Iterator<Object> it;
        final private Iterable<Object> actionsSet;
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
                if (((TransitionGround) current).isApplicable(source)) {
                    newState = source.clone();
                    newState.apply(((TransitionGround) current),source);
                    if (newState.satisfy(globalConstraints)){
                        return true;
                    }
                }
            }
            return false;
        }

        @Override
        public Pair<State, Object> next ( ) {
            return new Pair(newState, current);
        }
    }


}

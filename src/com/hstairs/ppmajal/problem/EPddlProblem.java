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

import com.hstairs.ppmajal.propositionalFactory.MetricFFGrounder;
import com.google.common.collect.Sets;
import com.hstairs.ppmajal.conditions.*;
import com.hstairs.ppmajal.domain.ParametersAsTerms;
import com.hstairs.ppmajal.domain.PddlDomain;
import com.hstairs.ppmajal.domain.SchemaGlobalConstraint;
import com.hstairs.ppmajal.domain.Type;
import com.hstairs.ppmajal.expressions.BinaryOp;
import com.hstairs.ppmajal.expressions.Expression;
import com.hstairs.ppmajal.expressions.MinusUnary;
import com.hstairs.ppmajal.expressions.MultiOp;
import com.hstairs.ppmajal.expressions.NumEffect;
import com.hstairs.ppmajal.expressions.NumFluent;
import com.hstairs.ppmajal.expressions.PDDLNumber;
import com.hstairs.ppmajal.extraUtils.Utils;
import com.hstairs.ppmajal.parser.PddlLexer;
import com.hstairs.ppmajal.parser.PddlParser;
import com.hstairs.ppmajal.pddl.heuristics.advanced.Aibr;
import com.hstairs.ppmajal.propositionalFactory.ExternalGrounder;
import com.hstairs.ppmajal.propositionalFactory.FDGrounder;
import com.hstairs.ppmajal.propositionalFactory.FDGrounderInstantiate;
import com.hstairs.ppmajal.propositionalFactory.Grounder;
import com.hstairs.ppmajal.search.SearchProblem;
import com.hstairs.ppmajal.transition.ConditionalEffects;
import com.hstairs.ppmajal.transition.Transition;
import com.hstairs.ppmajal.transition.TransitionGround;
import com.hstairs.ppmajal.transition.TransitionSchema;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Writer;
import java.math.BigDecimal;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.jgrapht.alg.util.Pair;

/**
 * @author enrico
 */
public class EPddlProblem implements SearchProblem {

    static public HashSet<Predicate> booleanFluents;

    public PDDLObjects objects;
    public State init;
    private Condition goals;
    public Collection<TransitionGround> actions;
    public Condition belief;
    public Collection<Predicate> unknonw_predicates;
    public Collection<OneOf> one_of_s;
    public Collection<OrCond> or_s;
    public Set<Type> types;
    protected String name;
    protected Integer indexObject;
    protected Integer indexInit;
    protected Integer indexGoals;
    protected Metric metric;
    protected String pddlFilRef;
    protected String domainName;
    protected long propositionalTime;
    protected boolean grounded_representation;
    protected RelState possStates;
    protected boolean simplifyActions;
    private boolean action_cost_from_metric = true;
    protected Set actualFluents;
    //This maps the string representation of a predicate (which uniquely defines it, into an integer)
    private  HashMap<NumFluent, PDDLNumber> initNumFluentsValues;
    private  HashMap<Predicate, Boolean> initBoolFluentsValues;
    final PddlDomain linkedDomain;
    private FactoryConditions fc;


    public HashSet<GlobalConstraint> globalConstraintSet;
    public AndCond globalConstraints;
    private Collection<TransitionGround> processesSet;
    private Collection<TransitionGround> eventsSet;
    private PDDLState pureInit;
    private HashMap<String, Terminal> terminalReference;
    private HashMap<String, NumFluent> numFluentReference;
    private boolean smallExpensive = false;
    private boolean debug;
    private boolean cacheComparison = false;
    private int totNumberOfBoolVariables;
    private int totNumberOfNumVariables;
    final public PrintStream out;
    final private String groundingMethod;
    private long groundingTime;
    private boolean sdac; 
    
    

    public EPddlProblem (PddlDomain domain, String groundingMethod, PrintStream out, boolean sdac){        
        indexInit = 0;
        indexGoals = 0;
        objects = new PDDLObjects();
        metric = new Metric("NO");
        actions = new LinkedHashSet();
        grounded_representation = false;
        simplifyActions = true;
        possStates = null;
        globalConstraintSet = new LinkedHashSet();
        eventsSet = new LinkedHashSet();
        globalConstraints = new AndCond(Collections.EMPTY_SET);   
        this.out = out;
        this.groundingMethod = groundingMethod;
        this.sdac = sdac;
        linkedDomain = domain;
        initBoolFluentsValues = new HashMap();
        initNumFluentsValues = new HashMap();
    }
    
    
    public EPddlProblem(String problemFile, PDDLObjects constants, Set<Type> types, 
            PddlDomain domain, PrintStream out, String groundingMethod, boolean sdac) {
        this(domain, groundingMethod, out, sdac);
        try {
            objects.addAll(constants);
            this.types = types;
            this.parseProblem(problemFile);
        } catch (IOException ex) {
            Logger.getLogger(EPddlProblem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (org.antlr.runtime.RecognitionException ex) {
            Logger.getLogger(EPddlProblem.class.getName()).log(Level.SEVERE, null, ex);
        }        indexObject = 0;
    }
    /**
     * @param goals the goals to set
     */
    public void setGoals(Condition goals) {
        this.goals = goals;
    }
    /**
     * @return the sdac
     */
    public boolean isSdac() {
        return sdac;
    }
    /**
     * @param sdac the sdac to set
     */
    public void setSdac(boolean sdac) {
        this.sdac = sdac;
    }

    public long getGroundingTime() {
        return groundingTime;
    }



    @Override
    public Object clone ( ) throws CloneNotSupportedException {

        //EPddlProblem cloned = new EPddlProblem(this.pddlFilRef, this.objects, this.types, linkedDomain);
        EPddlProblem cloned = new EPddlProblem(pddlFilRef, objects, types, linkedDomain, out, groundingMethod, sdac);
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

    private HashMap<String, NumFluent> getNumericFluentReference ( ) {
        if (this.numFluentReference == null) {
            numFluentReference = new HashMap<>();
        }
        return this.numFluentReference;
    }



    private void generateTransitions() {
        long start = System.currentTimeMillis();
        if (!"internal".equals(groundingMethod) && !"naive".equals(groundingMethod)) {
            System.out.println("Generate Transitions using " + groundingMethod);
            ExternalGrounder mff = null;
            switch (groundingMethod) {
                case "metricff" -> mff = new MetricFFGrounder(this, this.linkedDomain.getPddlFilRef(), this.pddlFilRef);
                case "fd" -> mff = new FDGrounder(this, this.linkedDomain.getPddlFilRef(), this.pddlFilRef);
                case "fdi" -> mff = new FDGrounderInstantiate(this, this.linkedDomain.getPddlFilRef(), this.pddlFilRef);
            }
            groundingTime = System.currentTimeMillis();
            Collection<TransitionGround> doGrounding = mff.doGrounding();
            groundingTime = System.currentTimeMillis()-groundingTime;
            for (var act : doGrounding) {
                switch (act.getSemantics()) {
                    case ACTION -> getActions().add(act);
                    case EVENT -> getEventsSet().add(act);
                    case PROCESS -> getProcessesSet().add(act);
                }
            }
        } else {
            Grounder af = new Grounder(belief == null && !"naive".equals(groundingMethod));
//        Grounder af = new Grounder(false);

            ArrayList<TransitionSchema> transitions = new ArrayList<>();
            transitions.addAll(linkedDomain.getProcessesSchema());
            transitions.addAll(linkedDomain.getActionsSchema());
            transitions.addAll(linkedDomain.getEventsSchema());
            groundingTime = System.currentTimeMillis();

            for (var act : transitions) {
                Collection<TransitionGround> propositionalize = af.Propositionalize(act, getObjects(), this, getInitBoolFluentsValues(), linkedDomain);
                switch (act.getSemantics()) {
                    case ACTION -> getActions().addAll(propositionalize);
                    case EVENT -> getEventsSet().addAll(propositionalize);
                    case PROCESS -> getProcessesSet().addAll(propositionalize);
                }
            }
            groundingTime = System.currentTimeMillis() - groundingTime;
        }

    }

    public void groundingSimplication(boolean aibrPreprocessing) throws Exception {

        this.groundingSimplication(aibrPreprocessing, false);

    }
    public void groundingSimplication(boolean aibrPreprocessing,boolean stopAfterGrounding) throws Exception {

        //simplification decoupled from the grounding
        this.groundingActionProcessesConstraints();
        out.println("Grounding Time: " + this.getGroundingTime());
        if (stopAfterGrounding)
            return;
        this.simplifyAndSetupInit(aibrPreprocessing);

        this.setGoals(generate_inequalities(getGoals()));

    }
    protected Condition generate_inequalities (Condition con) {
        return (Condition) con.transformEquality();
    }
    protected Set getActualFluents ( ) {
        if (actualFluents == null) {
            actualFluents = new LinkedHashSet();
            Sets.SetView<TransitionGround> transitions = Sets.union(Sets.union(new HashSet(this.actions), new HashSet(this.getEventsSet())),new HashSet(this.getProcessesSet()));

            for (TransitionGround gr : transitions) {
                gr.updateInvariantFluents(actualFluents);

            }
        }
//        System.out.println(actualFluents);
        return actualFluents;
    }




    private void generateConstraints ( ) throws Exception {
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
    }
    

    private void groundingActionProcessesConstraints ( ) throws Exception {
        long start = System.currentTimeMillis();

        this.groundGoals();
        this.generateTransitions();
        this.generateConstraints();
        this.setGroundedRepresentation(true);
        this.getActualFluents();
        if (this.metric != null && this.metric.getMetExpr() != null) {
            this.metric.setMetExpr(this.metric.getMetExpr().normalize());
        } else {
            this.metric = null;
        }

        setPropositionalTime(this.getPropositionalTime() + (System.currentTimeMillis() - start));
        syncAllVariablesAndUpdateCollections(this);

    }



    private Iterable cleanEasyUnreachableTransitions (Iterable toWorkOut) {
        ArrayList arrayList = new ArrayList((Collection) toWorkOut);
        Collection<TransitionGround> res = new LinkedHashSet<>();
        ListIterator it = arrayList.listIterator();
        while (it.hasNext()) {
            TransitionGround act = (TransitionGround) it.next();
            boolean keep = true;
            for (final NumEffect effect : act.getAllNumericEffects()) {
                if (true) {
                    if (effect.weakEval(this, this.getActualFluents()) != null) {
                        effect.normalize();
                    } else {
                        keep = false;
                    }
                } else {
                    effect.normalize();

                }
            }
            if (isSimplifyActions() && keep) {
                try {
                    Set invariantFluents = this.getActualFluents();
                    Condition preconditions = act.getPreconditions();
                    final Condition condition = preconditions.weakEval(this, invariantFluents).normalize();
                    if (condition != null && !condition.isUnsatisfiable()){
                        ConditionalEffects conditionalNumericEffects = act.getConditionalNumericEffects();
                        ConditionalEffects conditionalPropositionalEffects = act.getConditionalPropositionalEffects();
                        res.add(new TransitionGround(act.getParameters(),act.getName(),
                                conditionalPropositionalEffects.weakEval(this,invariantFluents),
                                conditionalNumericEffects.weakEval(this,invariantFluents),
                                condition,
                                act.getSemantics()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        }
        return new ArrayList(res);
    }

    protected void easyCleanUp(){
        this.easyCleanUp(false);
    }
    protected void easyCleanUp(boolean aibrPreprocessing) {
        //out.println("prova");
        this.saveInitInit();
        sweepStructuresForUnreachableStatements();

        debug = false;
        if (debug) {
            out.print("This is the universe of numeric fluent:");
            for (NumFluent nf : NumFluent.numFluentsBank.values()) {
                out.println("ID:" + nf.getId() + "->" + nf);
            }
            out.print("This is the universe of propositional fluent:");
            for (Predicate pred : Predicate.getPredicatesDB().values()) {
                out.println("ID:" + pred.getId() + "->" + pred);
            }
        }
        this.makeInit();
//        System.out.println(this.getActualFluents());
//        h1.computeEstimate(this.init);
//        final Collection<TransitionGround> transitions = h1.getTransitions(false);
        if (aibrPreprocessing){
                final Aibr heuristic = new Aibr(this, true);
                final float v = heuristic.computeEstimate(this.init);
                if (v == Float.MAX_VALUE){
                    out.println("Problem Detected as Unsolvable");
                    System.exit(-1);
                }
                final Collection<TransitionGround> transitions = heuristic.getAllTransitions();
                actions = new ArrayList<>();
                processesSet = new ArrayList<>();
                eventsSet = new ArrayList<>();
                for (final TransitionGround t : transitions){
                    switch (t.getSemantics()){
                        case ACTION:
                            actions.add(t);
                            break;
                        case PROCESS:
                            processesSet.add(t);
                            break;
                        case EVENT:
                            eventsSet.add(t);
                            break;
                    }
                }
                sweepStructuresForUnreachableStatements();
        }

//        this.makePddlState(); //remake init so as to account for only reachable actions
    }

    protected void sweepStructuresForUnreachableStatements ( ) {
        this.actualFluents = null;
        //the following just remove actions/processes/events over false and static predicates
        actions = (Collection<TransitionGround>) cleanEasyUnreachableTransitions(actions);
//        this.staticFluents = null;
        processesSet = (Collection<TransitionGround>) cleanEasyUnreachableTransitions(processesSet);
//        this.staticFluents = null;
        eventsSet = (Collection<TransitionGround>) cleanEasyUnreachableTransitions(eventsSet);
//        this.staticFluents = null;
        cleanIrrelevantConstraints(globalConstraintSet);
        this.setGroundedRepresentation(true);

        setGoals((Condition) getGoals().weakEval(this, this.getActualFluents()));
        setGoals((Condition) getGoals().normalize());
        if (getGoals().isUnsatisfiable()){
            throw new RuntimeException("Goal is not reachable");
        }
        globalConstraints = (AndCond) globalConstraints.weakEval(this, this.getActualFluents());
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

    public void simplifyAndSetupInit() throws Exception {
        simplifyAndSetupInit(true);
    }

    public void simplifyAndSetupInit(boolean aibrPreprocessing) throws Exception {

        long start = System.currentTimeMillis();
        out.println("(Pre Simplification) - |A|+|P|+|E|: " + (getActions().size() + getProcessesSet().size() + getEventsSet().size()));
        easyCleanUp(aibrPreprocessing);
        out.println("(After Easy Simplification) - |A|+|P|+|E|: " + (getActions().size() + getProcessesSet().size() + getEventsSet().size()));
        // normalize global constraints, once and forall
        globalConstraints = (AndCond) globalConstraints.normalize();
        makeInit();
        out.println("|F|:" + totNumberOfBoolVariables);
        out.println("|X|:" + totNumberOfNumVariables);

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
        final Collection temp = new HashSet();
        while (it.hasNext()) {
            GlobalConstraint constr = it.next();
            boolean keep = constr.simplifyModelWithControllableVariablesSem(linkedDomain, this);

            if (!keep) {
                it.remove();
            } else {
                temp.add(constr.condition);
            }

        }
        globalConstraints = new AndCond(temp);
    }




    public void setDeltaTimeVariable (String delta_t) {
        this.getInitNumFluentsValues().put(NumFluent.createNumFluent("#t", new ArrayList()), new PDDLNumber(Double.parseDouble(delta_t)));
    }


    private void removeStaticPart ( ) {
        //invariant fluents
        LinkedHashSet<Predicate> predicateToRemove = new LinkedHashSet();
        for (Predicate p : this.getInitBoolFluentsValues().keySet()) {
            if (!this.getActualFluents().contains(p)) {
                predicateToRemove.add(p);
            }
        }
        LinkedHashSet<NumFluent> numFluentsToRemove = new LinkedHashSet();
        for (NumFluent p : this.getInitNumFluentsValues().keySet()) {
            if (!this.getActualFluents().contains(p)) {
                numFluentsToRemove.add(p);
            }
        }

        this.getInitBoolFluentsValues().keySet().removeAll(predicateToRemove);
        this.getInitNumFluentsValues().keySet().removeAll(numFluentsToRemove);

    }

    public Sets.SetView<TransitionGround> getTransitions() {
        return Sets.union(Sets.union(new HashSet(actions), new HashSet<>(getEventsSet())), new HashSet(getProcessesSet()));

    }
    
    private void fixNecessaryFluents ( ) {

        Set<NumFluent> involved_fluents = new LinkedHashSet();

       
        for (Transition a : getTransitions()) {
            involved_fluents.addAll(a.getPreconditions().getInvolvedFluents());
            ConditionalEffects<NumEffect> conditionalNumericEffects = a.getConditionalNumericEffects();
            Map<Condition, Collection> allConditionalEffects = conditionalNumericEffects.getAllConditionalEffects();
            for (final Condition c: allConditionalEffects.keySet()){
                involved_fluents.addAll(c.getInvolvedFluents());
            }
            allConditionalEffects = a.getConditionalPropositionalEffects().getAllConditionalEffects();
            for (final Condition c: allConditionalEffects.keySet()){
                involved_fluents.addAll(c.getInvolvedFluents());
            }
            involved_fluents.addAll(a.getNumFluentsNecessaryForExecution());
        }

        for (SchemaGlobalConstraint a : this.linkedDomain.getSchemaGlobalConstraints()) {
            involved_fluents.addAll(a.condition.getInvolvedFluents());
        }
        involved_fluents.addAll(getGoals().getInvolvedFluents());

        
        if (NumFluent.numFluentsBank != null){
            Iterator<NumFluent> it = NumFluent.numFluentsBank.values().iterator();
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
//                    it.remove();
                }
                else{
                    nf2.needsTrackingInState(true);
                }
            }
        }
    }

    
    public Set getAllFluents(){
        Set res = new HashSet();
        if (NumFluent.numFluentsBank != null){
            for (NumFluent nf : NumFluent.numFluentsBank.values()) {
                if (this.getActualFluents().contains(nf) && nf.has_to_be_tracked()) {
                    res.add(nf);
                }
            }
        }
        booleanFluents = new HashSet();
        if (Predicate.getPredicatesDB() != null) {
            for (Predicate p : Predicate.getPredicatesDB().values()) {
                if (this.getActualFluents().contains(p)) {
                    res.add(p);
                }

            }
        }
        return res;
    }
    
    private PDDLState makePddlState ( ) {
        //ensure compactness
        //removeStaticPart();
        fixNecessaryFluents();
        HashMap<Integer,Double> numFluents = new HashMap();
        totNumberOfNumVariables = 0;
        totNumberOfBoolVariables = 0;
        if (NumFluent.numFluentsBank != null){
            for (NumFluent nf : NumFluent.numFluentsBank.values()) {
                if (this.getActualFluents().contains(nf) && nf.has_to_be_tracked()) {
                    PDDLNumber number = this.getInitNumFluentsValues().get(nf);
                    if (number == null) {
                        numFluents.put(nf.getId(), Double.NaN);
                    } else {
                        numFluents.put(nf.getId(), number.getNumber().doubleValue());
                    }
                    totNumberOfNumVariables++;
                }
            }
        }
        booleanFluents = new HashSet();
        BitSet boolFluents = new BitSet();
        if (Predicate.getPredicatesDB() != null) {
            for (Predicate p : Predicate.getPredicatesDB().values()) {
                if (this.getActualFluents().contains(p)) {
                    Boolean r = this.getInitBoolFluentsValues().get(p);
                    if (r == null || !r) {
                        //boolFluents.set(p.getId(), false);
                    } else {
                        boolFluents.set(p.getId(), true);
                    }
                    booleanFluents.add(p);
                    totNumberOfBoolVariables++;
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

//        out.println(Printer.stringBuilderPddlPrintWithDummyTrue(this, pddlState));
        return pddlState;
        
    }

    protected void makeInit ( ) {
        this.init = makePddlState();
        addTimeFluentToInit();
    }


    public Boolean goalSatisfied (State s) {
        return s.satisfy(this.getGoals());
    }

    private void groundGoals ( ) {
        this.setGoals((Condition) this.getGoals().ground(new HashMap(), objects));
    }


    protected HashMap<String, Terminal> getTerminalReference ( ) {
        if (terminalReference == null) {
            terminalReference = new HashMap<>();
        }
        return terminalReference;
    }


    private void syncAllVariablesAndUpdateCollections (EPddlProblem inputProblem) {

        if (inputProblem == null) {
            inputProblem = this;
        }
        HashMap<Predicate, Boolean> tempInitBool = new HashMap();
        for (Predicate p : this.getInitBoolFluentsValues().keySet()) {
            Boolean value = this.getInitBoolFluentsValues().get(p);
            Predicate newP = (Predicate) p.unifyVariablesReferences(inputProblem);
            tempInitBool.put(newP, value);

        }
        setInitBoolFluentsValues(tempInitBool);
        HashMap<NumFluent, PDDLNumber> tempInitFluent = new HashMap();
        for (NumFluent nf : this.getInitNumFluentsValues().keySet()) {
            PDDLNumber pddlNumber = getInitNumFluentsValues().get(nf);
            NumFluent numFluent = (NumFluent) nf.unifyVariablesReferences(inputProblem);
            tempInitFluent.put(numFluent, pddlNumber);
            this.getNumericFluentReference().put(nf.toString(), nf);
        }
        this.setInitNumFluentsValues(tempInitFluent);

        setGoals((Condition) getGoals().unifyVariablesReferences(inputProblem));

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


    private void addTimeFluentToInit ( ) {
        ((PDDLState) this.init).time = BigDecimal.ZERO;
    }

    public NumFluent getNumfluentReference (String stringRepresentation) {
        return getNumericFluentReference().get(stringRepresentation);
    }

    @Override
    public ObjectIterator<Pair<State, Object>> getSuccessors (State s, Object[] acts) {
        return new stateIterator(s, acts);
    }

    @Override
    public boolean milestoneReached (Float d, Float current_value, State temp) {
        return d < current_value;
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

    public Collection<TransitionGround> getEventsSet ( ) {
        if (eventsSet == null){
            eventsSet = new LinkedHashSet<>();
        }
        return eventsSet;
    }

    public Collection<TransitionGround> getProcessesSet ( ) {
        if (processesSet == null){
            processesSet = new LinkedHashSet<>();
        }
        return processesSet;
    }

    private State saveInitInit ( ) {
        if (this.pureInit == null) {
            this.pureInit = new MAPPDDLState(this.getInitNumFluentsValues(), getInitBoolFluentsValues());
        }
        return pureInit;
    }


    public void putNumFluentReference (NumFluent t) {
        getNumericFluentReference().put(t.toString(), t);
    }

    @Override
    public boolean satisfyGlobalConstraints(State temp) {
        return temp.satisfy(globalConstraints);
    }

    private void groundViaMetricFF() {

        MetricFFGrounder mff = new MetricFFGrounder(this,this.linkedDomain.getPddlFilRef(),this.pddlFilRef);
        mff.doGrounding();

    }

    public TransitionGround getActionsByName(String actionName) {
        for (var v: this.actions){
            final String name1 = v.toString();
            if (actionName.equals(name1)){
                return v;
            }
        }
        return null;
    }

    /**
     * @return the simplifyActions
     */
    public boolean isSimplifyActions() {
        return simplifyActions;
    }

    public PddlDomain getLinkedDomain() {
        return linkedDomain;
    }

    /**
     * Get the value of groundedActions
    /**
     * Set the value of groundedActions
     *
     * @param groundedActions new value of groundedActions
     */
    protected void setGroundedRepresentation(boolean groundedActions) {
        this.grounded_representation = groundedActions;
    }

    /**
     * Get the value of domainName
     *
     * @return the value of domainName
     */
    public String getDomainName() {
        return domainName;
    }

    /**
     * Set the value of domainName
     *
     * @param domainName new value of domainName
     */
    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    /**
     * Get the value of pddlFilRef
     *
     * @return the value of pddlFilRef
     */
    public String getPddlFileReference() {
        return pddlFilRef;
    }

    /**
     * Set the value of pddlFilRef
     *
     * @param pddlFilRef new value of pddlFilRef
     */
    public void setPddlFilRef(String pddlFilRef) {
        this.pddlFilRef = pddlFilRef;
    }

    public void saveProblem(String pddlNewFile) throws IOException {
        pddlFilRef = pddlNewFile;
        String toWrite = "(define (problem " + name + ") " + "(:domain " + this.getDomainName() + ") " + this.getObjects().pddlPrint() + "\n" + Printer.pddlPrint(this, (PDDLState) init) + "\n" + "(:goal " + this.getGoals().pddlPrint(false) + ")\n" + this.metric.pddlPrint() + "\n" + ")";
        Writer file = new BufferedWriter(new FileWriter(pddlNewFile));
        file.write(toWrite);
        file.close();
    }

    public void saveProblemWithObjectInterpretation(String pddlNewFile) throws IOException {
        pddlFilRef = pddlNewFile;
        //        final StringBuilder toWrite = new StringBuilder().append(this.metric.pddlPrint()).append("\n"
        //                + ")");
        //
        Writer file = new BufferedWriter(new FileWriter(pddlNewFile));
        StringBuilder builder = new StringBuilder();
        builder.append(this.getDomainName()).append(")");
        file.write("(define (problem temp)");
        file.write("(:domain ");
        file.write(builder.toString());
        file.write(this.getObjects().pddlPrint());
        file.write(Printer.stringBuilderPddlPrintWithDummyTrue(this, (PDDLState) init).toString());
        file.write("(:goal (forall (?interpr - interpretation)");
        file.write(this.getGoals().pddlPrintWithExtraObject() + ")))");
        file.close();
    }

    /**
     * @param file - the pathfile representing the pddl problem
     * @throws IOException
     * @throws org.antlr.runtime.RecognitionException
     */
    public void parseProblem(String file) throws IOException, RecognitionException {
        pddlFilRef = file;
        ANTLRInputStream in;
        in = new ANTLRInputStream(new FileInputStream(file));
        PddlLexer lexer = new PddlLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PddlParser parser = new PddlParser(tokens);
        PddlParser.pddlDoc_return root = parser.pddlDoc();
        if (parser.invalidGrammar()) {
            System.out.println("Grammar is violated");
        }
        //System.out.println("Problem Parsed, building data structure now");
        CommonTree t = (CommonTree) root.getTree();
        //        System.out.println("tree:" + t.toStringTree());
        //        exploreTree(t);
        this.one_of_s = new LinkedHashSet();
        this.or_s = new LinkedHashSet();
        //        System.out.println(this.objects);
        fc = new FactoryConditions(null, (LinkedHashSet<Type>) types, this.objects);
        if (this.unknonw_predicates == null) {
            this.unknonw_predicates = new LinkedHashSet();
        }
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            //System.out.println(child.getChild(0).getText());
            //            System.out.println(fc.constants);
            switch (child.getType()) {
                case PddlParser.PROBLEM_DOMAIN:
                    this.setDomainName(child.getChild(0).getText());
                    break;
                case PddlParser.PROBLEM_NAME:
                    name = child.getChild(0).getText();
                    break;
                case PddlParser.OBJECTS:
                    addObjects(child);
                    break;
                case PddlParser.INIT:
                    addInitFacts(child);
                    break;
                case PddlParser.FORMULAINIT:
                    Tree andCondition = child.getChild(0).getChild(0);
                    if (child.getChild(0).getChildCount() > 1) {
                        for (int j = 1; j < child.getChild(0).getChildCount(); j++) {
                            this.unknonw_predicates.add((Predicate) addUnknown(child.getChild(0).getChild(j)));
                        }
                    }
                    this.belief = fc.createGoals(andCondition);
                    //                    this.belief = fc.createCondition(child.getChild(0), null);
                    break;
                case PddlParser.GOAL:
                    this.setGoals(null);
                    Condition con = fc.createCondition(child.getChild(0), null);
                    if (!(con instanceof ComplexCondition)) {
                        this.setGoals(new AndCond(Collections.singleton(con)));
                    } else {
                        this.setGoals((ComplexCondition) con);
                    }
                    break;
                case PddlParser.PROBLEM_METRIC:
                    addMetric(child);
                    break;
            }
        }
        this.setGoals((ComplexCondition) this.getGoals().pushNotToTerminals());
        this.setGoals((ComplexCondition) this.getGoals().ground(new HashMap(), this.getObjects()));
        for (PDDLObject object : this.getObjects()) {
            final ArrayList object1 = new ArrayList<>(List.of(object, object));
            this.getInitBoolFluentsValues().put(Predicate.getPredicate("=", object1), true);
        }
        //System.out.println("Total number of Numeric Fluents:"+this.counterNumericFluents);
    }

    protected void addObjects(Tree c) {
        for (int i = 0; i < c.getChildCount(); i++) {
            if (this.linkedDomain != null) {
                String typeName;
                if (c.getChild(i).getChild(0) == null) {
                    typeName = "object";
                } else {
                    typeName = c.getChild(i).getChild(0).getText();
                }
                Type t = linkedDomain.getTypeByName(typeName);
                if (t == null) {
                    System.out.println(c.getChild(i).getChild(0).getText() + " not found");
                    System.exit(-1);
                }
                this.getObjects().add(PDDLObject.createObject(c.getChild(i).getText(), t));
            } else {
                throw new RuntimeException("Need to link the domain first");
            }
        }
    }

    protected Expression createExpression(Tree t) {
        int test = t.getType();
        switch (t.getType()) {
            case PddlParser.BINARY_OP:
                {
                    BinaryOp ret = new BinaryOp();
                    ret.setOperator(t.getChild(0).getText());
                    ret.setLhs(createExpression(t.getChild(1)));
                    ret.setRhs(createExpression(t.getChild(2)));
                    ret.grounded = true;
                    return ret;
                }
            case PddlParser.NUMBER:
                {
                    //Float.
                    PDDLNumber ret = new PDDLNumber(Float.valueOf(t.getText()));
                    return ret;
                }
            case PddlParser.FUNC_HEAD:
                {
                    String name = t.getChild(0).getText();
                    ArrayList variables = new ArrayList();
                    for (int i = 1; i < t.getChildCount(); i++) {
                        variables.add(this.getObjectByName(t.getChild(i).getText()));
                    }
                    return NumFluent.createNumFluent(name, variables, true);
                }
            case PddlParser.UNARY_MINUS:
                return new MinusUnary(createExpression(t.getChild(0)));
            case PddlParser.MULTI_OP:
                {
                    MultiOp ret = new MultiOp(t.getChild(0).getText());
                    for (int i = 1; i < t.getChildCount(); i++) {
                        //System.out.println("Figlio di + o * " + createExpression(t.getChild(i)));
                        ret.addExpression(createExpression(t.getChild(i)));
                    }
                    ret.grounded = true;
                    return ret;
                }
            default:
                break;
        }
        return null;
    }

    protected void addInitFacts(Tree child) {
        this.setInitNumFluentsValues(new HashMap());
        this.setInitBoolFluentsValues(new HashMap());
        for (int i = 0; i < child.getChildCount(); i++) {
            Tree c = child.getChild(i);
            switch (c.getType()) {
                case PddlParser.PRED_INST:
                    getInitBoolFluentsValues().put(fc.buildPredicate(c, null), true);
                    break;
                case PddlParser.INIT_EQ:
                    this.getInitNumFluentsValues().put((NumFluent) createExpression(c.getChild(0)), (PDDLNumber) createExpression(c.getChild(1)));
                    break;
                case PddlParser.UNKNOWN:
                    this.unknonw_predicates.add((Predicate) addUnknown(c));
                    break;
                case PddlParser.ONEOF:
                    this.one_of_s.add((OneOf) fc.createCondition(c, null));
                    break;
                case PddlParser.OR_GD:
                    this.or_s.add((OrCond) fc.createCondition(c, null));
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * A pretty representation for the pddl problem
     */
    public void prettyPrint() {
        System.out.println("\ninit:" + getInit() + "\nObject" + getProblemObjects() + "\nGoals:" + getGoals() + "\n");
//        if (metric.getMetExpr() instanceof MultiOp) {
//            MultiOp temp = (MultiOp) metric.getMetExpr();
//            System.out.println("\n Metric:" + temp.getExpr().size());
//        }
        out.println(initBoolFluentsValues);
        out.println(initNumFluentsValues);
        out.println("Actions: "+actions);
    }

    protected void exploreTree(Tree t) {
        if (t == null) {
            return;
        }
        if (t.getChildCount() == 0) {
            System.out.println("Foglia:" + t.getText() + "Tipo:" + t.getType());
            return;
        }
        System.out.println("Nodo intermedio: " + t.getText() + "Tipo:" + t.getType());
        for (int i = 0; i < t.getChildCount(); i++) {
            exploreTree(t.getChild(i));
        }
        return;
    }

    /**
     * @return the objects - the objects of the pddl problem
     */
    public PDDLObjects getProblemObjects() {
        return getObjects();
    }

    /**
     * @return the init - the initial status of the problem
     */
    public State getInit() {
        return init;
    }

    /**
     * @return the goals - the goal set
     */
    public Condition getGoals() {
        return goals;
    }

    protected void addMetric(Tree t) {
        //System.out.println(t.toStringTree());
        metric = new Metric(t.getChild(0).getText());
        metric.setMetExpr(createExpression(t.getChild(1)));
    }

    /**
     * @return the metric
     */
    public Metric getMetric() {
        return metric;
    }

    public void setMetric(Metric m) {
        this.metric = m;
    }

    /**
     * @param string - the name of the object we want
     * @return the term representing the object
     */
    public PDDLObject getObjectByName(String string) {
        return Utils.getObjectByName(this.objects, string);
    }

    public double getInitFunctionValue(NumFluent f) {
        return ((PDDLState) init).fluentValue(f);
    }

    public NumFluent getNumFluent(String string, ArrayList terms) {
        for (NumFluent fAssign : this.getInitNumFluentsValues().keySet()) {
            if (fAssign.getName().equals(string)) {
                if (fAssign.getTerms().equals(terms)) {
                    return fAssign;
                }
            }
        }
        return null;
    }

    public ArrayList getNumFluents() {
        return new ArrayList(this.getInitNumFluentsValues().keySet());
    }

    /**
     * @return the propositionalTime
     */
    public long getPropositionalTime() {
        return propositionalTime;
    }

    /**
     * @param propositionalTime the propositionalTime to set
     */
    public void setPropositionalTime(long propositionalTime) {
        this.propositionalTime = propositionalTime;
    }

    /**
     * @return the actions
     */
    public Collection getActions() {
        return actions;
    }

    /**
     * @param actions the actions to set
     */
    public void setActions(Set actions) {
        this.actions = actions;
    }

    public void parseProblem(String string, PDDLObjects constants) throws IOException, antlr.RecognitionException, RecognitionException {
        this.getObjects().addAll(constants);
        parseProblem(string);
    }

    /**
     * @return the possStates
     */
    public RelState getPossStates() {
        return possStates;
    }

    /**
     * @param possStates the possStates to set
     */
    public void setPossStates(RelState possStates) {
        this.possStates = possStates;
    }

    public void removeObjects(ParametersAsTerms constantsFound) {
        for (Object c : constantsFound) {
            this.getObjects().remove(c);
        }
    }

    /**
     * @return the objects
     */
    public PDDLObjects getObjects() {
        return objects;
    }

    /**
     * @param objects the objects to set
     */
    public void setObjects(PDDLObjects objects) {
        this.objects = objects;
    }

    private Condition addUnknown(Tree infoAction) {
        if (infoAction == null) {
            return null;
        }
        if (infoAction.getType() == PddlParser.PRED_INST) {
            //estrapola tutti i predicati e ritornali come set di predicati
            //            AndCond and = new AndCond();
            //            and.addConditions();
            return fc.buildPredicate(infoAction, null);
        } else if (infoAction.getType() == PddlParser.UNKNOWN) {
            return addUnknown(infoAction.getChild(0));
        } else {
            System.out.println("Some serious error:" + infoAction);
            return null;
        }
    }

    public Condition getPredicate(Predicate aThis) {
        for (Predicate p : this.getInitBoolFluentsValues().keySet()) {
            if (p.equals(aThis)) {
                return p;
            }
        }
        return aThis;
    }

    public PDDLNumber getNumFluentInitialValue(NumFluent aThis) {
        PDDLNumber nf = this.getInitNumFluentsValues().get(aThis);
        if (nf == null) {
            return null;
        }
        return nf;
    }

    public Iterable<NumFluent> getNumFluentsInvolvedInInit() {
        if (this.getInitNumFluentsValues() == null) {
            return Collections.emptyList();
        }
        return this.getInitNumFluentsValues().keySet();
    }

    public boolean getInitBoolFluentValue(Predicate aThis) {
        Boolean b = this.getInitBoolFluentsValues().get(aThis);
        return b != null && b;
    }

    public Iterable getPredicatesInvolvedInInit() {
        if (this.getInitBoolFluentsValues() == null) {
            return Collections.emptyList();
        }
        return this.getInitBoolFluentsValues().keySet();
    }

    /**
     * @return the initNumFluentsValues
     */
    public HashMap<NumFluent,PDDLNumber> getInitNumFluentsValues() {
        return initNumFluentsValues;
    }

    /**
     * @param initNumFluentsValues the initNumFluentsValues to set
     */
    protected void setInitNumFluentsValues(HashMap<NumFluent, PDDLNumber> initNumFluentsValues) {
        this.initNumFluentsValues = initNumFluentsValues;
    }

    /**
     * @return the initBoolFluentsValues
     */
    public HashMap<Predicate,Boolean> getInitBoolFluentsValues() {
        return initBoolFluentsValues;
    }

    /**
     * @param initBoolFluentsValues the initBoolFluentsValues to set
     */
    protected void setInitBoolFluentsValues(HashMap<Predicate, Boolean> initBoolFluentsValues) {
        this.initBoolFluentsValues = initBoolFluentsValues;
    }


    public void addFactValue(Predicate predicate, boolean b) {
        if (this.initBoolFluentsValues == null){
            initBoolFluentsValues = new HashMap();
        }
        initBoolFluentsValues.put(predicate, b);
    }

    public void addAction(TransitionGround action) {
        this.actions.add(action);
    }




    
    @Override
    public Float gValue(State s, Object act, State temp, float gValue) {
        Metric m = this.getMetric();
        if (act instanceof Transition) {
            TransitionGround gr = (TransitionGround) act;
            if (gr == null) {
                return gValue;
            }
            return getTransitionCost(s, gr,gValue,false,m);
        }else{
            final ImmutablePair<TransitionGround,Integer> res = (ImmutablePair<TransitionGround, Integer>) act;

            return getTransitionCost(s, res.left,gValue,false,m,res.right);
        }
    }
    float getTransitionCost(State s, TransitionGround gr, Float previousG, boolean ignoreCost, Metric m) {
        return this.getTransitionCost(s,gr,previousG,ignoreCost,m,1);
    }
    float getTransitionCost(State s, TransitionGround gr, Float previousG, boolean ignoreCost, Metric m, final int right){
        if (ignoreCost){
            return previousG + 1*right;
        }
        if (m != null){
            return previousG + gr.getActionCost(s,m, isSdac())*right;
        }else{
            return previousG + 1*right;
        }
    }
    protected class stateIterator implements ObjectIterator<Pair<State, Object>> {
        protected final State source;
        final private Object[] actionsSet;
        protected Object current;
        protected State newState;
        private int i;

        public stateIterator (State source, Object[] actionsSet) {
            this.source = source;
            this.actionsSet = actionsSet;
            i=0;
        }

        @Override
        public boolean hasNext ( ) {
            while (i<actionsSet.length) {
                current = actionsSet[i]; i++;
                if (current instanceof TransitionGround) {
                    if (((TransitionGround) current).isApplicable(source)) {
                        newState = source.clone();
                        newState.apply(((TransitionGround) current), source);
                        if (newState.satisfy(globalConstraints)) {
                            return true;
                        }
                    }
                }else if (current instanceof Pair){
                    
                    final Pair<TransitionGround,Integer> tempVar= (Pair<TransitionGround,Integer>)this.current;
                    final int b = applyActionMTimes(tempVar.getFirst(), tempVar.getSecond());
                    if (b > 1) {
                        current = new ImmutablePair(((Pair<TransitionGround, Integer>) this.current).getFirst(),b);
                        return true;
                    }
                }
            }
            return false;
        }

        public int applyActionMTimes(final TransitionGround act, int counter){
            final State prev = source.clone();
            int i=0;
            while (i<counter){
                prev.apply((act), source);
                if (!act.isApplicable(newState) || !newState.satisfy(globalConstraints)){
                    return i;
                }
                newState = prev;
                i++;
            }
            return i;
        }

        @Override
        public Pair<State, Object> next ( ) {
            return new Pair(newState, current);
        }
    }


}

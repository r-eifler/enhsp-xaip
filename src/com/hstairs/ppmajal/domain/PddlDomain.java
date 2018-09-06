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
package com.hstairs.ppmajal.domain;

import com.hstairs.ppmajal.conditions.*;
import com.hstairs.ppmajal.expressions.NumFluent;
import com.hstairs.ppmajal.extraUtils.Utils;
import com.hstairs.ppmajal.parser.PddlLexer;
import com.hstairs.ppmajal.parser.PddlParser;
import com.hstairs.ppmajal.problem.PDDLObjects;
import com.hstairs.ppmajal.problem.PddlProblem;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author enrico
 */
public final class PddlDomain extends Object {

    public final Collection<EventSchema> eventsSchema;
    public final Set<Type> types;
    public final PDDLObjects constants;
    public final Collection functions;
    public final Collection<String> requirements;
    protected final Set<ActionSchema> ActionsSchema;
    private final Set<ProcessSchema> ProcessesSchema;
    private final Collection<NumFluent> derived_variables;
    private String name;
    private PredicateSet predicates;
    private String pddlReferenceFile;
    private HashMap abstractInvariantFluents;
    private LinkedHashSet<SchemaGlobalConstraint> SchemaGlobalConstraints;
    private FactoryConditions fc;

    public PddlDomain (String domainFile) {
        super();
        SchemaGlobalConstraints = new LinkedHashSet();

        types = new LinkedHashSet<>();
        ActionsSchema = new TreeSet<>(new ActionComparator());
        functions = new ArrayList();
        derived_variables = new ArrayList();
        requirements = new ArrayList<>();
        constants = new PDDLObjects();
        ProcessesSchema = new LinkedHashSet();
        eventsSchema = new LinkedHashSet();
        this.parseDomain(domainFile);
    }

    /**
     * @param p - The PddlProblem to validate the consistency for. BETA
     * @return true whether the problem is consistent wrt to the domain.
     * Otherwise false
     */
    public boolean validate (PddlProblem p) {

        for (Object o : p.getProblemObjects()) {
            PDDLObject t = (PDDLObject) o;
            Iterator<Type> it = types.iterator();
            boolean founded = false;
            while (it.hasNext()) {
                Type ele = it.next();
                if (ele.equals(t.getType())) {
                    t.setType(ele);
                    founded = true;
                    break;
                }
            }
            if (!founded) {
                System.out.println("The following object is not valid:" + t);
                System.exit(-1);
            }
        }

        for (NumFluent nf : p.getNumFluentsInvolvedInInit()) {

            for (Object o1 : nf.getTerms()) {
                PDDLObject t = (PDDLObject) o1;
                Iterator<Type> it = types.iterator();
                boolean founded = false;
                while (it.hasNext()) {
                    Type ele = it.next();
                    if (ele.equals(t.getType())) {
                        t.setType(ele);
                        founded = true;
                        break;
                    }
                }
                if (!founded) {
                    System.out.println("The following object is not valid:" + t);
                    System.exit(-1);
                }
            }
        }
        for (Predicate t1 : p.getPredicatesInvolvedInInit()) {
            for (Object o1 : t1.getTerms()) {
                PDDLObject t = (PDDLObject) o1;
                Iterator<Type> it = types.iterator();
                boolean found = false;
                while (it.hasNext()) {
                    Type ele = it.next();
                    if (ele.equals(t.getType())) {
                        t.setType(ele);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("The following object is not valid:" + t);
                    System.exit(-1);
                }
            }
        }


        for (Object o : p.getNumFluentsInvolvedInInit()) {

            if (o instanceof NumFluent) {

                NumFluent nf = (NumFluent) o;
//                System.out.println(nf.getName());
                for (Object o1 : nf.getTerms()) {
                    PDDLObject t = (PDDLObject) o1;
                    Iterator<Type> it = types.iterator();
                    boolean found = false;
                    while (it.hasNext()) {
                        Type ele = it.next();
                        if (t == null) {
                            System.out.println("Type error; Probably you are using an object in a numeric fluent which is not specified..");
                            System.out.println("    It happened when dealing with: " + nf);
                            return false;
                        }
                        if (ele.equals(t.getType())) {
                            t.setType(ele);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("The following object is not valid:" + t);
                        System.exit(-1);
                    }
                }
            } else {
                Predicate t1 = (Predicate) o;
                for (Object o1 : t1.getTerms()) {
                    PDDLObject t = (PDDLObject) o1;
                    Iterator<Type> it = types.iterator();
                    boolean found = false;
                    while (it.hasNext()) {
                        Type ele = it.next();
                        if (ele.equals(t.getType())) {
                            t.setType(ele);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("The following object is not valid:" + t);
                        System.exit(-1);
                    }
                }
            }
        }
        if (p.getGoals().sons != null) {
            for (Object o : p.getGoals().sons) {

                if (o instanceof Predicate) {

                    Predicate t = (Predicate) o;
                    //                if (!predicates.validateInst(t)) {
                    //                    System.out.println("Predicato: " + t + " non valido");
                    //                    System.exit(-1);
                    //
                    //                }
                }
            }
        }
        for (final PDDLObject o : this.getConstants()) {
            p.getProblemObjects().add(o);
        }
        //System.out.println(p.getProblemObjects());

        p.setDomain(this);
        p.setValidatedAgainstDomain(true);

//        p.generate_universe_of_variables(this.getPredicates(),this.getFunctions(),this.derived_variables);
//        System.out.println(p.num_fluent_universe);
//        System.out.println(p.predicates_universe);
        return true;
    }

    /**
     * @param file - the path of the pddl file representing the domain. As
     *             return the object will be fullfilled with the information in the pddl
     *             domain file
     * @throws IOException
     * @throws RecognitionException
     */
    public void parseDomain (String file) {
        try {
            this.setPddlFilRef(file);
            ANTLRInputStream in;
            in = new ANTLRInputStream(new FileInputStream(file));
            PddlLexer lexer = new PddlLexer(in);
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            PddlParser parser = new PddlParser(tokens);
            PddlParser.pddlDoc_return root = parser.pddlDoc();

            if (parser.invalidGrammar()) {
                System.out.println("Some Syntax Error");
                System.exit(-1);
            }

//        fc = new FactoryConditions(this.predicates, (LinkedHashSet<Type>) this.types,this.constants);
            CommonTree t = (CommonTree) root.getTree();
            int i;
            fc = new FactoryConditions(this.predicates, (LinkedHashSet<Type>) this.types, this.constants);
            for (i = 0; i < t.getChildCount(); i++) {
                Tree c = t.getChild(i);
                int type = c.getType();
//            System.out.println("Tipo: " + c.getText());
                switch (type) {
                    case PddlParser.DOMAIN_NAME:
                        setName(c.getChild(0).getText());
                        break;
                    case PddlParser.TYPES:
                        addTypes(c);
                        break;
                    case PddlParser.PREDICATES:
                        this.predicates = (PredicateSet) addPredicates(c);
                        fc = new FactoryConditions(this.predicates, (LinkedHashSet<Type>) this.types, this.constants);

                        break;
                    case PddlParser.ACTION:
                        //fc = new FactoryConditions(this.predicates, (LinkedHashSet<Type>) this.types, this.constants);
                        addActions(c);
                        break;
                    case PddlParser.EVENT:
                        addEvent(c);
                        break;
                    case PddlParser.REQUIREMENTS:
                        addRequirements(c);
                        break;
                    case PddlParser.FUNCTIONS:
                        this.functions.addAll(fc.addFunctions(c));
                        break;
                    case PddlParser.CONSTANTS:
                        addConstants(c);
                        break;
                    case PddlParser.FREE_FUNCTIONS:
                        this.derived_variables.addAll(fc.addFunctions(c));
                        break;
                    case PddlParser.GLOBAL_CONSTRAINT:
                        fc = new FactoryConditions(this.predicates, (LinkedHashSet<Type>) this.types, this.constants);
                        addGlobal_constraint(c);
                        break;
                    case PddlParser.PROCESS:
                        addProcess(c);
                        break;
//                case PddlParser.DOM_CONSTRAINTS:
//                    addGlobalConstraints(c);
//                    break;
                }
            }
            push_not_at_the_terminals();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PddlDomain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PddlDomain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RecognitionException ex) {
            Logger.getLogger(PddlDomain.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * A pretty representation of the domain
     */
    public void prettyPrint ( ) {
        System.out.println("Requirements: " + this.requirements);
        System.out.println("Actions Domain: " + this.ActionsSchema);
        if (this.ProcessesSchema != null) {
            System.out.println("Process Domain: " + this.ProcessesSchema);
        }
        //if (!this.eventsSchema.isEmpty())
        System.out.println("Events Domain: " + this.eventsSchema);
        System.out.println("Predicates: " + this.predicates);
        System.out.println("Functions: " + this.functions);
        System.out.println("Global Constraints: " + this.getSchemaGlobalConstraints());

    }

    /**
     * @return the ActionsSchema- a Set which contains all the action schema of
     * the domain
     */
    public Set<ActionSchema> getActionsSchema ( ) {
        return ActionsSchema;
    }

    /**
     * @return the types declared in the domain
     */
    public Set<Type> getTypes ( ) {
        return types;
    }

    /**
     * @return the predicates definitions
     */
    public PredicateSet getPredicates ( ) {
        return predicates;
    }

    //da migliorare perchè dovrebbe rappresentare una potenziale gerarchica di oggetti!!!
    private void addTypes (Tree c) {
        for (int i = 0; i < c.getChildCount(); i++) {
            Type tip = new Type(c.getChild(i).getText());

            Tree tipo = c.getChild(i);
            if (tipo.getChildCount() > 0) {
                boolean subTypeOfExist = false;
                Type father = new Type(tipo.getChild(0).getText());
                if (father.isObject()) {
                    types.add(father);
                    tip.setSubTypeOf(father);
                    subTypeOfExist = true;
                } else {
                    Iterator<Type> it = types.iterator();
                    while (it.hasNext()) {
                        Type ele = it.next();
                        if (ele.equals(father)) {
                            tip.setSubTypeOf(ele);
                            subTypeOfExist = true;
                            break;
                        }
                    }
                }
                if (subTypeOfExist) {
                    this.types.add(tip);
                } else {
                    System.out.println("Error: " + tip + " has declared father: " + father + " which is not a type neither an object; inferring object");
                    tip.setSubTypeOf(new Type("object"));
                    this.types.add(tip);
                }
            } else {
                this.types.add(tip);
            }
//                
//            
//            this.types.add(tip);

        }
    }

    private void addActions (Tree c) {
        this.addGenericActionSchemas(c, new ActionSchema());
    }

    private Object addPredicates (Tree t) {
        PredicateSet col = new PredicateSet();
        if (t == null) {
            return null;
        } //Assumo che ogni variabile sia tipata: da aggiungere nella grammatica l'impossibilità di avere variabili non tipate
        //in realtà anche per pddl non tipati funziona. Il risultato ritornato è un null che è comunque un risultato accettabile come tipo.
        if (t.getChildCount() == 0) {
            Type unTipo = new Type(t.getText());
            if (types.contains(unTipo)) {
                return unTipo;
            } else {
                return null;
            }
        }
        if (t.getType() == PddlParser.PREDICATES) {//Sono uno dei predicati
            for (int i = 0; i < t.getChildCount(); i++) {
                Tree child = t.getChild(i);
                Predicate p = new Predicate();
                p.setPredicateName(child.getText());
                Variable v;
                for (int j = 0; j < child.getChildCount(); j++) {
                    v = (Variable) addPredicates(child.getChild(j));
                    p.addVariable(v);
                }
                col.add(p);
            }
            return col;
        } else {
            Variable v = new Variable(t.getText());

            v.setType((Type) addPredicates(t.getChild(0)));
            return v;
        }
    }

    private void addRequirements (Tree c) {
        if (c != null) {
            //System.out.println(c.getText());
            for (int i = 0; i < c.getChildCount(); i++) {
                final String req = c.getChild(i).getText();
                this.requirements.add(req);
            }
        }
    }


    //

    /**
     * Returns the action with specified name. Notice that this method is rather
     * inefficient if there are many actions, and that a table that maps names
     * to action schemas could be more effective.
     *
     * @param name the name of the action
     * @return an ActionSchema object (if any) with the name in input this
     * assumes that there is a 1:1 relation between action and name, i.e. we
     * cannot have different actions with the same name
     */
    public ActionSchema getActionByName (String name) {
        for (final ActionSchema el : ActionsSchema) {
            final String elname = el.getName();
            if (elname.equalsIgnoreCase(name)) {
                return el;
            }
        }

        return null;
    }

    /**
     * @return the pddlFilRef
     */
    public String getPddlFilRef ( ) {
        return pddlReferenceFile;
    }

    /**
     * @param pddlFilRef the pddlFilRef to set
     */
    public void setPddlFilRef (String pddlFilRef) {
        this.pddlReferenceFile = pddlFilRef;
    }

    private void addConstants (Tree c) {

        for (int i = 0; i < c.getChildCount(); i++) {
            this.getConstants().add(new PDDLObject(c.getChild(i).getText(), new Type(c.getChild(i).getChild(0).getText())));
//            System.out.println("Aggiungo l'oggetto:" + c.getChild(i).getText());
//            System.out.println("che è di tipo:" + new Type(c.getChild(i).getChild(0).getText()));
        }

    }

    /**
     * @return the constants
     */
    public PDDLObjects getConstants ( ) {
        return constants;
    }

    public void saveDomain (String file) throws IOException {
        PddlDomain domain = this;
        Writer f;

        f = new BufferedWriter(new FileWriter(file));
        ParametersAsTerms constants = new ParametersAsTerms();
        String actions = "\n";

        f.write("(define (domain " + domain.getName() + ")\n");
        if (this.requirements != null) {
            f.write("(:requirements " + Utils.toPDDLSet(requirements) + ")\n");
        }
        if (domain.getTypes() != null) {
            f.write("(:types " + Utils.toPDDLTypesSet(domain.getTypes()) + ")\n");
        }
        if (!domain.getPredicates().isEmpty()) // f.write("(:constants "+constants.pddlPrint()+")\n");
        {
            f.write("(:predicates " + domain.getPredicates().pddlPrint(true) + "\n");
        }
        if (!functions.isEmpty()) {
            f.write("(:functions " + Utils.toPDDLSet(functions) + ")\n");
        }

        if (!domain.getActionsSchema().isEmpty()) {
            f.write(Utils.toPDDLSetWithBreak(domain.getActionsSchema()));
        }

        f.write(actions);
        f.write("\n)");
        f.close();
        f.close();
    }

    /**
     * @return the name
     */
    public String getName ( ) {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName (String name) {
        this.name = name;
    }

    public HashMap generateAbstractInvariantFluents ( ) {
        if (getAbstractInvariantFluents() != null) {
            return getAbstractInvariantFluents();
        }
        abstractInvariantFluents = new HashMap();
        for (final ActionSchema as : this.ActionsSchema) {
            Set s = as.getAbstractNumericFluentAffected();
            for (NumFluent nf : (Set<NumFluent>) s) {
                abstractInvariantFluents.put(nf.getName(), false);
            }
        }
        for (NumFluent nf : this.get_derived_variables()) {
            abstractInvariantFluents.put(nf.getName(), false);
        }

        return abstractInvariantFluents;
    }

    public Type getTypeByName (String text) {
        for (Type t : this.getTypes()) {
            if (t.getName().equals(text)) {
                return t;
            }
        }
        return null;
    }

    public HashMap<Object, Boolean> generateInvariant ( ) {
        HashMap<Object, Boolean> ret = new HashMap();
        for (ActionSchema as : this.getActionsSchema()) {
            Condition prop_effects = as.getAddList();
            if (prop_effects instanceof AndCond) {
                AndCond ac = (AndCond) prop_effects;
                for (Object o : ac.sons) {
                    if (o instanceof Predicate) {
                        Predicate p = (Predicate) o;
                        Predicate pDef = this.getPredicates().findAssociated(p);
                        ret.put(pDef, Boolean.FALSE);
                    }
                }
            } else {
                System.out.println("Support only and cond as prop effects. In case of singleton, please put it under AND");
            }
            prop_effects = as.getDelList();
            if (prop_effects != null) {
                if (prop_effects instanceof AndCond) {
                    AndCond ac = (AndCond) prop_effects;
                    for (Object o : ac.sons) {
                        if (o instanceof NotCond) {
                            NotCond nc = (NotCond) o;
                            //System.out.println(nc);
//                            for (Object o1 : nc.son) {
                            Predicate p = (Predicate) nc.getSon();
                            Predicate pDef = this.getPredicates().findAssociated(p);
                            ret.put(pDef, Boolean.FALSE);
//                            }

                        }
                    }
                } else {
                    System.out.println("Support only AND as prop effects. In case of singleton, please put it under AND also if it is just one proposition");
                }
            }
            Set<NumFluent> anfa = (Set<NumFluent>) as.getAbstractNumericFluentAffected();
            for (NumFluent nf : anfa) {
                ret.put(nf, Boolean.FALSE);
            }
        }
        return ret;
    }


    /**
     * @return the free_functions
     */
    public Collection<NumFluent> get_derived_variables ( ) {
        return derived_variables;
    }


    private void addGlobalConstraints (Tree c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the abstractInvariantFluents
     */
    public HashMap getAbstractInvariantFluents ( ) {
        return abstractInvariantFluents;
    }

    /**
     * @param abstractInvariantFluents the abstractInvariantFluents to set
     */
    public void setAbstractInvariantFluents (HashMap abstractInvariantFluents) {
        this.abstractInvariantFluents = abstractInvariantFluents;
    }

    private void addGlobal_constraint (Tree c) {
        SchemaGlobalConstraint con = new SchemaGlobalConstraint(c.getChild(0).getText());
        //System.out.println("Adding:"+a.getName());
        this.getSchemaGlobalConstraints().add(con);

        for (int i = 1; i < c.getChildCount(); i++) {
            Tree infoConstraint = c.getChild(i);
            int type = infoConstraint.getType();

            switch (type) {
                case (PddlParser.PRECONDITION):

                    Condition condition = fc.createCondition(infoConstraint.getChild(0), con.parameters);
                    if ((condition instanceof Comparison) || (condition instanceof Predicate)) {
                        AndCond and = new AndCond();
                        and.addConditions(condition);
                        con.condition = condition;
                    } else {
                        con.condition = condition;
                    }
                    break;
                case (PddlParser.VARIABLE):
                    if (infoConstraint.getChild(0) == null) {
                        break;
                    }
                    Type t = new Type(infoConstraint.getChild(0).getText());
                    boolean found = false;
                    for (Object o : this.getTypes()) {
                        if (t.equals(o)) {
                            t = (Type) o;
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Type: " + t + " is not specified. Please revise the model");
                        System.exit(-1);
                    } else {
                        con.parameters.add(new Variable(infoConstraint.getText(), t));
                    }
                    break;

            }

        }
    }

    /**
     * @return the SchemaGlobalConstraints
     */
    public LinkedHashSet<SchemaGlobalConstraint> getSchemaGlobalConstraints ( ) {
        return SchemaGlobalConstraints;
    }

    /**
     * @param SchemaGlobalConstraints the SchemaGlobalConstraints to set
     */
    public void setSchemaGlobalConstraints (LinkedHashSet SchemaGlobalConstraints) {
        this.SchemaGlobalConstraints = SchemaGlobalConstraints;
    }

    private void addProcess (Tree c) {
        ProcessSchema a = new ProcessSchema();
        Tree process = c.getChild(0);
        a.setName(process.getText());
//        System.out.println("DEBUG: Adding:"+a.getName());
        this.ProcessesSchema.add(a);

        for (int i = 1; i < c.getChildCount(); i++) {
            Tree infoAction = c.getChild(i);
            int type = infoAction.getType();

            switch (type) {
                case (PddlParser.PRECONDITION):
                    Condition con = fc.createCondition(infoAction.getChild(0), a.getParameters());
                    if ((con instanceof Comparison) || (con instanceof Predicate)) {
                        AndCond and = new AndCond();
                        and.addConditions(con);
                        a.setPreconditions(and);
                    } else if (con != null) {
                        a.setPreconditions((ComplexCondition) con);
                    }
                    break;
                case (PddlParser.VARIABLE):
                    if (infoAction.getChild(0) == null) {
                        break;
                    }
                    Type t = new Type(infoAction.getChild(0).getText());
                    boolean found = false;
                    for (Object o : this.getTypes()) {
                        if (t.equals(o)) {
                            t = (Type) o;
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Type: " + t + " is not specified. Please Fix the Model");
                        System.exit(-1);
                    } else {
                        a.addParameter(new Variable(infoAction.getText(), t));
                    }
                    break;
                case (PddlParser.EFFECT):
                    addEffects(a, infoAction);
//                    System.out.println(a);
                    break;
            }

        }
    }

    /**
     * @return the ProcessesSchema
     */
    public Set<ProcessSchema> getProcessesSchema ( ) {
        return ProcessesSchema;
    }


    //    private Object createConditionalEffect(SchemaParameters parameters, Tree t) {
//        
//        if (t.getType() == PddlParser.AND_EFFECT){
//            for (int j = 0; j < t.getChildCount(); j++) {
//                    if (t.getChild(j).getType() == PddlParser.WHEN_EFFECT){
//                        Tree child = t.getChild(j);
//                        System.out.println(t.getChild(j).toStringTree());
//                    }
//                }
//        }
//        return null;
//    }
    private void addEffects (PDDLGenericAction a, Tree infoAction) {
        //PostCondition res = createPostCondition(a.parameters, infoAction.getChild(0));
        PostCondition res = fc.createPostCondition(a.parameters, infoAction.getChild(0));
        a.create_effects_by_cases(res);
    }

    public void saveDomainWithInterpretationObjects (String file) throws IOException {
        PddlDomain domain = this;
        Writer f;

        f = new BufferedWriter(new FileWriter(file));
        ParametersAsTerms constants = new ParametersAsTerms();

        f.write("(define (domain " + domain.getName() + ")\n");
        if (requirements != null && !requirements.isEmpty()) {
            f.write(";(:requirements " + Utils.toPDDLSet(requirements) + ")\n");
        }
        if (domain.getTypes() != null && !domain.getTypes().isEmpty()) {
            f.write("(:types interpretation " + Utils.toPDDLTypesSet(domain.getTypes()) + ")\n");
        }
        if (!domain.getPredicates().isEmpty()) // f.write("(:constants "+constants.pddlPrint()+")\n");
        {
            f.write("(:predicates (true) " + domain.getPredicates().pddlPrintWithExtraObject(true) + " \n");
        }

        if (!domain.getActionsSchema().isEmpty()) {
            f.write(Utils.toPDDLWithExtraObject(domain.getActionsSchema()));
        }

        f.write("\n)");
        f.close();
        f.close();
    }

    private void push_not_at_the_terminals ( ) {
        for (ActionSchema a : this.ActionsSchema) {
            a.push_not_to_terminals();
        }

        for (ProcessSchema a : this.ProcessesSchema) {
            a.push_not_to_terminals();
        }
        for (EventSchema a : this.eventsSchema) {
            a.push_not_to_terminals();
        }

    }

    private void addEvent (Tree c) {
        this.addGenericActionSchemas(c, new EventSchema());
    }

    private void addGenericActionSchemas (Tree c, ActionSchema a) {

        Tree action = c.getChild(0);
        a.setName(action.getText());
        //System.out.println("Adding:"+a.getName());
        if (a instanceof EventSchema) {
            this.eventsSchema.add((EventSchema) a);

        } else if (a instanceof ActionSchema) {
            this.ActionsSchema.add(a);
        }
        for (int i = 1; i < c.getChildCount(); i++) {
            Tree infoAction = c.getChild(i);
            int type = infoAction.getType();

            switch (type) {
                case (PddlParser.PRECONDITION):

                    Condition con = null;
                    if (a.parameters == null)
                        con = fc.createCondition(infoAction.getChild(0), null);
                    else
                        con = fc.createCondition(infoAction.getChild(0), a.parameters);
                    //con = fc.createCondition(infoAction.getChild(0), a.parameters);

                    if ((con instanceof NotCond) || (con instanceof Comparison) || (con instanceof Predicate) || (con instanceof ForAll)) {
                        AndCond and = new AndCond();
                        and.addConditions(con);
                        a.setPreconditions(and);
                    } else if (con != null) {
                        a.setPreconditions((ComplexCondition) con);
                    }
                    break;
                case (PddlParser.VARIABLE):
                    if (infoAction.getChild(0) == null) {
                        break;
                    }
                    Type t = new Type(infoAction.getChild(0).getText());
                    boolean found = false;
                    for (Object o : this.getTypes()) {
                        if (t.equals(o)) {
                            t = (Type) o;
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Type: " + t + " is not specified. Please Fix the Model");
                        System.exit(-1);
                    } else {
                        a.addParameter(new Variable(infoAction.getText(), t));
                    }
                    break;
                case (PddlParser.EFFECT):
                    addEffects(a, infoAction);
//                    System.out.println(a);
                    break;
            }

        }
    }

    public boolean can_be_abstract_dominant_constraints ( ) {
        Set<Condition> set = new HashSet();
        for (ActionSchema as : this.ActionsSchema) {
            set.addAll(as.getPreconditions().getTerminalConditions());
        }

        for (int i = 0; i < set.toArray().length; i++) {
            for (int j = i + 1; j < set.toArray().length; j++) {
                Condition c1 = (Condition) set.toArray()[i];
                Condition c2 = (Condition) set.toArray()[j];
                if ((c1 instanceof Comparison) && (c2 instanceof Comparison)) {
                    Comparison comp_c1 = (Comparison) c1;
                    Comparison comp_c2 = (Comparison) c2;
                    if (comp_c1.getInvolvedFluents().equals(comp_c2.getInvolvedFluents())) {
                        //System.out.println(comp_c1+" "+comp_c2);
                        return true;
                    }
                }
            }

        }
        return false;
    }

}

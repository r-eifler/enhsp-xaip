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
import com.hstairs.ppmajal.expressions.NumEffect;
import com.hstairs.ppmajal.expressions.NumFluent;
import com.hstairs.ppmajal.extraUtils.Utils;
import com.hstairs.ppmajal.parser.PddlLexer;
import com.hstairs.ppmajal.parser.PddlParser;
import com.hstairs.ppmajal.problem.PDDLObjects;
import com.hstairs.ppmajal.transition.ConditionalEffects;
import com.hstairs.ppmajal.transition.Transition;
import com.hstairs.ppmajal.transition.Transition.Semantics;
import com.hstairs.ppmajal.transition.TransitionSchema;
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

    HashMap<String,Boolean> canBeDynamic;

    public final Collection<TransitionSchema> eventsSchema;
    public final PDDLObjects constants;
    private final Set<TransitionSchema> ProcessesSchema;
    private final Collection<NumFluent> derived_variables;
    public Set<Type> types;
    public Collection functions;
    public Collection<String> requirements;
    protected Collection<TransitionSchema> ActionsSchema;
    private String name;
    private PredicateSet predicates;
    private String pddlReferenceFile;
    private LinkedHashSet<SchemaGlobalConstraint> SchemaGlobalConstraints;
    private FactoryConditions fc;

    public PddlDomain (String domainFile) {
        super();
        SchemaGlobalConstraints = new LinkedHashSet();

        types = new LinkedHashSet<>();

        //Add default dummy type object
        Type t = Type.createType("object","null");
        types.add(t);

        ActionsSchema = new TreeSet<>(new ActionComparator());
        functions = new ArrayList();
        derived_variables = new ArrayList();
        requirements = new ArrayList<>();
        constants = new PDDLObjects();
        ProcessesSchema = new LinkedHashSet();
        eventsSchema = new LinkedHashSet();
        this.parseDomain(domainFile);
    }


    public PddlDomain (Collection<TransitionSchema> eventsSchema, PDDLObjects constants, Set<TransitionSchema> processesSchema, Collection<NumFluent> derived_variables) {
        this.eventsSchema = eventsSchema;
        this.constants = constants;
        ProcessesSchema = processesSchema;
        this.derived_variables = derived_variables;
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
//            System.out.println(this.constants);
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
//                        System.out.println(fc.constants);
                        addTransition(c, Semantics.ACTION);
                        break;
                    case PddlParser.EVENT:
                        addTransition(c, Semantics.EVENT);
                        break;
                    case PddlParser.REQUIREMENTS:
                        addRequirements(c);
                        break;
                    case PddlParser.FUNCTIONS:
                        this.functions.addAll(fc.addFunctions(c));
                        break;
                    case PddlParser.CONSTANTS:
                        addConstants(c);
                        fc.constants = this.constants;
                        break;
                    case PddlParser.FREE_FUNCTIONS:
                        this.derived_variables.addAll(fc.addFunctions(c));
                        break;
                    case PddlParser.GLOBAL_CONSTRAINT:
                        fc = new FactoryConditions(this.predicates, (LinkedHashSet<Type>) this.types, this.constants);
                        addGlobalConstraint(c);
                        break;
                    case PddlParser.PROCESS:
                        addTransition(c, Semantics.PROCESS);
                        break;
//                case PddlParser.DOM_CONSTRAINTS:
//                    addGlobalConstraints(c);
//                    break;
                }
            }
            pushNotAtTheTerminals();
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
    public Collection<TransitionSchema> getActionsSchema ( ) {
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

            Tree tipo = c.getChild(i);
            String father = "object";
            if (tipo.getChildCount() > 0) {
                father = tipo.getChild(0).getText();               
            }
            Type tip = Type.createType(c.getChild(i).getText(),father);
            this.types.add(tip);
        }
    }
    private Object addPredicates (Tree t) {
        PredicateSet col = new PredicateSet();
        if (t == null) {
            return null;
        }
        if (t.getType() == PddlParser.PREDICATES) {//Sono uno dei predicati
            for (int i = 0; i < t.getChildCount(); i++) {
                Tree child = t.getChild(i);
                String name = child.getText();
                ArrayList variables = new ArrayList();
                Variable v;
                for (int j = 0; j < child.getChildCount(); j++) {
                    v = (Variable) addPredicates(child.getChild(j));
                    variables.add(v);
                }
                col.add(Predicate.createPredicate(name, variables));
            }
            return col;
        } else {
            String father = "object";
            if (t.getChildCount() > 0) {
                father = t.getChild(0).getText();
            }
            Variable v = new Variable(t.getText(),Type.createType(father));
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
    public TransitionSchema getActionByName (String name) {
        for (final TransitionSchema el : ActionsSchema) {
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
            if (c.getChild(i).getChildCount() > 0) {
                PDDLObject o = PDDLObject.createObject(c.getChild(i).getText(), Type.createType(c.getChild(i).getChild(0).getText()));
                this.getConstants().add(o);
            } else {
                PDDLObject o = PDDLObject.createObject(c.getChild(i).getText(), Type.createType("object"));
                this.getConstants().add(o);
            }
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
        if (this.constants != null && !this.constants.isEmpty()) {
            f.write(this.constants.pddlPrint("constants") + "\n");
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

    public HashMap<String,Boolean> getDynamicPredicateMap ( ) {
       
        if (canBeDynamic == null) {
            canBeDynamic = new HashMap();
            ArrayList<Transition> all = new ArrayList();
            all.addAll(this.ActionsSchema);
            all.addAll(this.ProcessesSchema);
            all.addAll(this.eventsSchema);
            for (int i = 0; i < all.size(); i++) {
                Set<Condition> terminalConditions = all.get(i).getPreconditions().getTerminalConditions();
                for (int j = 0; j < all.size(); j++) {
                    Transition transition = all.get(j);
                    for (Condition cond : terminalConditions) {
                        Terminal p = null;
                        if (cond instanceof NotCond) {
                            p = (Terminal) ((NotCond) cond).getSon();
                        } else if ((cond instanceof Predicate) || (cond instanceof Comparison)) {
                            p = (Terminal) cond;
                        }
                        if (p != null && p instanceof Predicate) {
                            for (Predicate pred : transition.getPropositionAffected()) {
                                if (pred.getPredicateName().equals(((Predicate) p).getPredicateName())) {
                                    canBeDynamic.put(((Predicate) p).getPredicateName(), true);
                                }
                            }
                        }
//                        if (p != null && p instanceof Comparison) {
//                            for (NumFluent nf : transition.getNumericFluentAffected()) {
//                                for (NumFluent nf2 : p.getInvolvedFluents()) {
//                                    if (nf.getName().equals(nf2.getName())) {
//                                        canBeDynamic.put(p, true);
//                                    }
//                                }
//                            }
//                        }
                    }
                }
            }
        }

        return canBeDynamic;
    }

    public Type getTypeByName(String text) {
        for (Type t : this.getTypes()) {
            if (t.getName().equals(text)) {
                return t;
            }
        }
        return null;
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




    private void addGlobalConstraint (Tree c) {
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
                    Type t = Type.createType(infoConstraint.getChild(0).getText());
                    con.parameters.add(new Variable(infoConstraint.getText(), t));
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

    private void addTransition (Tree c, Semantics semantics) {
        Tree process = c.getChild(0);
//        System.out.println("DEBUG: Adding:"+a.getName());
        String processName = process.getText();
        Condition precondition = null;
        SchemaParameters par = null;
        ConditionalEffects<Terminal> propEffect = new ConditionalEffects<>(ConditionalEffects.VariableType.PROPEFFECT);
        ConditionalEffects<NumEffect> numEffect = new ConditionalEffects<>(ConditionalEffects.VariableType.NUMEFFECT);
        
        for (int i = 1; i < c.getChildCount(); i++) {
            Tree infoAction = c.getChild(i);
            int type = infoAction.getType();
            switch (type) {
                case (PddlParser.PRECONDITION):
                    Condition con = fc.createCondition(infoAction.getChild(0), par);
                    if ((con instanceof Comparison) || (con instanceof Predicate)) {
                        AndCond and = new AndCond();
                        and.addConditions(con);
                        precondition = and;
                    } else if (con != null) {
                        precondition = con;
                    }
                    break;
                case (PddlParser.VARIABLE):
                    if (infoAction.getChild(0) == null) {
                        break;
                    }
                    Type t = Type.createType(infoAction.getChild(0).getText());
                    
                    Variable variable = new Variable(infoAction.getText(), t);
//                        System.out.print(variable);
                    par.add(variable);
                    break;
                case (PddlParser.EFFECT):
                    
                    PostCondition res = fc.createPostCondition(par, infoAction.getChild(0));
                    
                    if (res instanceof AndCond) {
                        AndCond pc = (AndCond) res;
                        for (Object o : pc.sons) {
                            if (o instanceof Predicate) {
                                propEffect.add((Terminal) o);
                            } else if (o instanceof NotCond) {
                                propEffect.add((Terminal) o);
                            } else if (o instanceof NumEffect) {
                                numEffect.add((NumEffect) o);
                            } else if (o instanceof ConditionalEffect) {
                                ConditionalEffect cond = (ConditionalEffect)o;
                                if (cond.effect instanceof NumEffect){
                                    numEffect.add(cond.activation_condition, (NumEffect) cond.effect);
                                }
                            } else if (o instanceof ForAll) {
                                throw new UnsupportedOperationException();
                            }
                        }
                    } else if (res instanceof Predicate) {
                        propEffect.add((Terminal) res);
                    } else if (res instanceof NotCond) {
                        propEffect.add((Terminal) res);
                    } else if (res instanceof NumEffect) {
                        numEffect.add((NumEffect) res);
                    } else if (res instanceof ConditionalEffect) {
                        numEffect.add((NumEffect) res);
                    } else if (res instanceof ForAll) {
                        throw new UnsupportedOperationException();
                    }
            }
            break;

        }

        TransitionSchema transition = new TransitionSchema(par,name,propEffect,numEffect,precondition,semantics);
        switch (semantics) {
            case ACTION:
                this.ActionsSchema.add(transition);
                break;
            case PROCESS:
                this.ProcessesSchema.add(transition);
                break;
            case EVENT:
                this.eventsSchema.add(transition);
                break;
        }

    }




    /**
     * @return the ProcessesSchema
     */
    public Set<TransitionSchema> getProcessesSchema ( ) {
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
            f.write("(:types " + Utils.toPDDLTypesSet(domain.getTypes()) + ")\n");
        }
        if (this.constants != null && !this.constants.isEmpty()) {
            f.write(this.constants.pddlPrint("constants") + "\n");
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

    private void pushNotAtTheTerminals( ) {
        ArrayList listViewOfTransitions = new ArrayList(this.getActionsSchema());
        listViewOfTransitions.addAll(this.getProcessesSchema());
        listViewOfTransitions.addAll(this.eventsSchema);
        ListIterator<TransitionSchema> iterator = listViewOfTransitions.listIterator();

        while(iterator.hasNext()) {
            TransitionSchema next = iterator.next();
            iterator.set(new TransitionSchema(next.getParameters(),next.getName(),
                    next.getConditionalPropositionalEffects(),
                    next.getConditionalNumericEffects(),
                    next.getPreconditions().pushNotToTerminals(),
                    next.getSemantics()));
        }
    }




    public void substituteEqualityConditions ( ) {
        ArrayList listViewOfTransitions = new ArrayList(this.getActionsSchema());
        listViewOfTransitions.addAll(this.getProcessesSchema());
        listViewOfTransitions.addAll(this.eventsSchema);
        ListIterator<TransitionSchema> iterator = listViewOfTransitions.listIterator();

        while(iterator.hasNext()) {
            TransitionSchema next = iterator.next();

            iterator.set(new TransitionSchema(next.getParameters(),next.getName(),
                    next.getConditionalPropositionalEffects(),
                    next.getConditionalNumericEffects(),
                    next.getPreconditions().transformEquality(),
                    next.getSemantics()));
        }
    }


    public PddlDomain clone ( ) {

        PddlDomain res = new PddlDomain(new LinkedHashSet(this.eventsSchema), new PDDLObjects(this.constants), new LinkedHashSet<>(this.getProcessesSchema()), new LinkedHashSet<>(this.derived_variables));
        res.setName(this.name);
        res.requirements = new ArrayList<>(this.requirements);
        res.ActionsSchema = new LinkedHashSet<>();
        for (TransitionSchema as : this.ActionsSchema) {
            throw new UnsupportedOperationException("Cloning of the domain not supported yet");
//            res.ActionsSchema.add(as.clone());
        }
        res.types = new LinkedHashSet<>(this.types);
        res.predicates = new PredicateSet(this.predicates);
        res.functions = new LinkedHashSet(this.functions);
        return res;
    }


}

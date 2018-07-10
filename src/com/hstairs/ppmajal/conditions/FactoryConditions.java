/*
 * Copyright (C) 2017 Enrico Scala.
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
package com.hstairs.ppmajal.conditions;

import com.hstairs.ppmajal.expressions.MinusUnary;
import com.hstairs.ppmajal.expressions.NumEffect;
import com.hstairs.ppmajal.expressions.NumFluent;
import com.hstairs.ppmajal.expressions.Expression;
import com.hstairs.ppmajal.expressions.ComplexFunction;
import com.hstairs.ppmajal.expressions.MultiOp;
import com.hstairs.ppmajal.expressions.PDDLNumber;
import com.hstairs.ppmajal.expressions.TrigonometricFunction;
import com.hstairs.ppmajal.expressions.BinaryOp;
import com.hstairs.ppmajal.domain.PredicateSet;
import com.hstairs.ppmajal.domain.SchemaParameters;
import com.hstairs.ppmajal.domain.Type;
import com.hstairs.ppmajal.domain.Variable;
import java.util.Collection;
import java.util.LinkedHashSet;
import org.antlr.runtime.tree.Tree;
import com.hstairs.ppmajal.parser.PddlParser;
import com.hstairs.ppmajal.problem.PDDLObjects;

/**
 *
 * @author Enrico Scala
 */
public class FactoryConditions  {

    private final PredicateSet predicates;
    private final LinkedHashSet<Type> types;
    private final PDDLObjects constants;

    @Override
    public String toString() {
        return "FactoryConditions{" + "predicates=" + predicates + ", types=" + types + ", constants=" + constants + '}';
    }

    public FactoryConditions(PredicateSet predicates, LinkedHashSet<Type> types, PDDLObjects constants) {
        this.predicates = predicates;
        this.types = types;
        this.constants = constants;
        
    }

    private Variable buildVariable(Tree t, SchemaParameters parTable) {
        Variable a = null;
        //a.setName(t.getChild(0).getText());
        //controllare che la variabile nei predicati sia effettivamente un parametro dell'azione oppure una costante!
        if (t.getType() == PddlParser.NAME) {

            System.out.println("Error in parsing variable terms");
            System.exit(-1);

        } else {

            a = new Variable(t.getText());
            Variable v1 = parTable.containsVariable(a);
            if (v1 == null) {
                System.out.println("BuildPredicate: Variable " + a + " not involved in the action model");
                System.exit(-1);
            }
            a = v1;
        }
        return a;
    }

    public Condition createCondition(Tree tree, SchemaParameters parTable) {
        Condition ret = null;
        if (tree == null) {
            return null;
        }

        switch (tree.getType()) {
            case PddlParser.PRED_HEAD:
                //extract the predicate
                return buildPredicate(tree, parTable);
            case PddlParser.AND_GD:
                AndCond and = new AndCond();
                for (int i = 0; i < tree.getChildCount(); i++) {
                    Condition ret_val = createCondition(tree.getChild(i), parTable);
                    if (ret_val != null) {
                        and.addConditions(ret_val);
                    }
                }
                return and;
            //Crea un and e per ogni figlio di questo nodo invoca creaformula
            //gestendo il valore di ritorno come un attributo di and
            case PddlParser.OR_GD:
                OrCond or = new OrCond();
                for (int i = 0; i < tree.getChildCount(); i++) {
                    Condition ret_val = createCondition(tree.getChild(i), parTable);
                    if (ret_val != null) {
                        or.addConditions(ret_val);
                    }
                }
                return or;
                
            case PddlParser.ONEOF:
                OneOf one_of = new OneOf();
                for (int i = 0; i < tree.getChildCount(); i++) {
                    Condition ret_val = createCondition(tree.getChild(i),parTable);
                    if (ret_val != null) {
                        one_of.sons.add(ret_val);
                    }
                }
                return one_of;
            case PddlParser.NOT_GD:
                Condition cond = null; // TODO: Can it be null or should we throw an error?  
                for (int i = 0; i < tree.getChildCount(); i++) {
                    Condition ret_val = createCondition(tree.getChild(i), parTable);
                    if (ret_val != null) {
                        cond = ret_val;
                    }
                }
                NotCond not = new NotCond(cond);
                return not;
            //Crea un not e per ogni figlio di questo nodo invoca creaformula
            //gestendo il valore di ritorno come un attributo di not
            case PddlParser.COMPARISON_GD:
                //System.out.println("Comparison:" + infoAction.getText());
                Comparison c = new Comparison(tree.getChild(0).getText());
                c.setLeft(createExpression(tree.getChild(1), parTable));
                c.setRight(createExpression(tree.getChild(2), parTable));
                return c;
            //Create an equality structure for comparing Objects
            case PddlParser.EQUALITY_CON:
                PDDLObjectsEquality equality = new PDDLObjectsEquality();

                if (tree.getChild(1).getType() == PddlParser.NAME) {
                    System.out.println("Constant objects in equality comparison are not supported");
                    System.exit(-1);
                } else {
                    equality.setLeftV(buildVariable(tree.getChild(1), parTable));
                }
                if (tree.getChild(1).getType() == PddlParser.NAME) {
                    System.out.println("Constant objects in equality comparison are not supported");
                    System.exit(-1);
                } else {
                    equality.setRightV(buildVariable(tree.getChild(2), parTable));
                }
                return equality;
            case PddlParser.FORALL_GD:
                ForAll forall = createForAll(tree, parTable,false);
                return forall;
            case PddlParser.EXISTS_GD:
                Existential exist = new Existential();
                for (int i = 0; i < tree.getChildCount(); i++) {
                    Tree child = tree.getChild(i);
                    switch (child.getType()) {
                        case PddlParser.VARIABLE:
                            if (child.getChild(0) == null) {
                                break;
                            }
                            Type t = new Type(child.getChild(0).getText());
                            boolean found = false;
                            for (Object o : this.types) {
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
                                exist.addParameter(new Variable(child.getText(), t));
                            }
                            break;
                        default:
                            //at this point I should have collected all the parameters for grounding
                            //the variable into constants
                            SchemaParameters aug_par_table = new SchemaParameters();
                            aug_par_table.addAll(parTable);
                            aug_par_table.addAll(exist.getParameters());
                            Condition ret_val = createCondition(child, aug_par_table);
                            if (ret_val != null) {
                                exist.addConditions(ret_val);
                            }
                            break;

                    }

                }
                return exist;
            case PddlParser.IMPLY_GD:
                System.out.println("Implication not supported yet:" + tree.getText());
                return null;
            //Create an equality structure for comparing Objects
            default:
                break;
        }
        return null;
    }

    public Predicate buildPredicate(Tree t, SchemaParameters parTable) {
        Predicate a = new Predicate();
        a.setPredicateName(t.getChild(0).getText());
        //controllare che la variabile nei predicati sia effettivamente un parametro dell'azione oppure una costante!
        for (int i = 1; i < t.getChildCount(); i++) {
            if (t.getChild(i).getType() == PddlParser.NAME) {
                PDDLObject o = new PDDLObject(t.getChild(i).getText());
                PDDLObject o1 = this.constants.containsTerm(o);
                if (o1 != null) {
                    //a.setGrounded(true);
                    a.addObject(o1);
                } else {
                    System.out.println("Variable " + o + " is not a constant object");
                    System.exit(-1);
                }
            } else {
                Variable v = new Variable(t.getChild(i).getText());

                Variable v1 = parTable.containsVariable(v);
                if (v1 != null) {
                    a.addVariable(v1);
                } else {
                    System.out.println("BuildPredicate: Variable " + v + " not in the action model");
                    System.exit(-1);
                }
            }
        }
        if (predicates != null) {
            if (!predicates.validate(a)) {
                System.out.println("Predicate " + a + " is not valid");
                System.exit(-1);
            }
        }
        return a;
    }

    private Expression createExpression(Tree t, SchemaParameters parTable) {

        switch (t.getType()) {
            case PddlParser.BINARY_OP: {
                BinaryOp ret = new BinaryOp();
                ret.setOperator(t.getChild(0).getText());
                ret.setOne(createExpression(t.getChild(1), parTable));
                ret.setRight(createExpression(t.getChild(2), parTable));

                return ret;
            }
            case PddlParser.SIN: {
                TrigonometricFunction ret = new TrigonometricFunction();
//                System.out.println(t.getChild(1));
                ret.setOperator("sin");
                ret.setArg(createExpression(t.getChild(0), parTable));
                return ret;
            }
            case PddlParser.ABS: {
                ComplexFunction ret = new ComplexFunction();
//                System.out.println(t.getChild(1));
                ret.setOperator("abs");
                ret.setArg(createExpression(t.getChild(0), parTable));
                return ret;
            }
            case PddlParser.COS: {
                TrigonometricFunction ret = new TrigonometricFunction();
//                System.out.println(t.getChild(1));
                ret.setOperator("cos");
                ret.setArg(createExpression(t.getChild(0), parTable));
                return ret;
            }
            case PddlParser.NUMBER: {
                PDDLNumber ret = new PDDLNumber(new Float(t.getText()));
                return ret;
            }
            case PddlParser.FUNC_HEAD: {
                NumFluent ret = new NumFluent(t.getChild(0).getText());
                for (int i = 1; i < t.getChildCount(); i++) {
//                System.out.println("Constant Type:" + PddlParser.CONSTANTS);
//                System.out.println("Name Type:" + PddlParser.NAME);
//                System.out.println("Current Type:" + t.getChild(i).getType());
                    if (t.getChild(i).getType() == PddlParser.NAME) {
                        PDDLObject o = new PDDLObject(t.getChild(i).getText());
                        PDDLObject o1 = this.constants.containsTerm(o);
                        if (o1 != null) {
                            ret.addTerms(o1);
                        } else {

                            System.out.println("NumFluent:Variable " + o + " is not a constant object");
                            System.exit(-1);
                        }
                    } else {
                        Variable v = new Variable(t.getChild(i).getText());
                        //System.out.println(parTable);
                        Variable v1 = parTable.containsVariable(v);

                        if (v1 != null) {
                            ret.addVariable(v1);
                        } else {
//                        System.out.println("t.getType: " + t.getChild(i).getText());
                            System.out.println("NumFluent: Variable " + v + " not involved in the action model");
                            System.exit(-1);
                        }
                    }
                }
                return ret;
            }
            case PddlParser.UNARY_MINUS:
                return new MinusUnary(createExpression(t.getChild(0), parTable));
            case PddlParser.MULTI_OP: {
                MultiOp ret = new MultiOp(t.getChild(0).getText());
                for (int i = 1; i < t.getChildCount(); i++) {
                    //System.out.println("Figlio di + o * " + createExpression(t.getChild(i)));
                    ret.addExpression(createExpression(t.getChild(i), parTable));
                }
                return ret;
            }
            default:
                break;
        }

        return null;

    }

    public ForAll createForAll(Tree infoAction, SchemaParameters parTable, boolean effect) {
        ForAll forall = new ForAll();
        for (int i = 0; i < infoAction.getChildCount(); i++) {
            Tree child = infoAction.getChild(i);
            switch (child.getType()) {
                case PddlParser.VARIABLE:
                    if (child.getChild(0) == null) {
                        break;
                    }
                    Type t = new Type(child.getChild(0).getText());
                    boolean found = false;
//                    System.out.println(types);
                    for (Object o : this.types) {
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
                        forall.addParameter(new Variable(child.getText(), t));
                    }
                    break;
                default:
                    //at this point I should have collected all the parameters for grounding
                    //the variable into constants
                    SchemaParameters aug_par_table = new SchemaParameters();
                    if (parTable != null) {
                        aug_par_table.addAll(parTable);
                    }
                    aug_par_table.addAll(forall.getParameters());
                    Condition ret_val = null;
                    if (effect) {
                        ret_val = (Condition) this.createPostCondition(aug_par_table, child);
                    } else {
                        ret_val = createCondition(child, aug_par_table);
                    }
                    //System.out.println("ret_val for forall condition is:"+ret_val);
                    if (ret_val != null) {
                        forall.addConditions(ret_val);
                    } else {
                        System.out.println("Something fishy here.." + child);
                        System.exit(-1);
                    }
                    break;

            }

        }
        return forall;

    }

    public PostCondition createPostCondition(SchemaParameters parameters, Tree tree) {
        if (tree == null) {
            return new AndCond();
        }
        switch (tree.getType()) {
            case PddlParser.PRED_HEAD:
                //estrapola tutti i predicati e ritornali come set di predicati
                return buildPredicate(tree, parameters);

            case PddlParser.AND_EFFECT:
                AndCond and = new AndCond();
                for (int i = 0; i < tree.getChildCount(); i++) {
                    Object ret_val = createPostCondition(parameters, tree.getChild(i));
                    if (ret_val != null) {
                        and.sons.add(ret_val);
                    }
                }
                return and;
            case PddlParser.NOT_EFFECT:
                Condition ret_val = (Condition) createPostCondition(parameters, tree.getChild(0));
                NotCond not = new NotCond(ret_val);
                return not;
            case PddlParser.ASSIGN_EFFECT:
                NumEffect a = new NumEffect(tree.getChild(0).getText());
//                System.out.println("DEBUG: Working out this effect:"+a);
                a.setFluentAffected((NumFluent) createExpression(tree.getChild(1), parameters));
                a.setRight(createExpression(tree.getChild(2), parameters));
                return a;
            case PddlParser.FORALL_EFFECT:
                ForAll forall = this.createForAll(tree, parameters,true);
                return forall;
            case PddlParser.WHEN_EFFECT:
                Condition lhs = createCondition(tree.getChild(0), parameters);
                PostCondition rhs = this.createPostCondition(parameters, tree.getChild(1));
                return new ConditionalEffect(lhs, rhs);
            default:
                System.out.println("Serious error in parsing:" + tree);
                System.err.println("ADL not fully supported");
                System.exit(-1);
                break;
        }
        return null;

    }
    
     public Condition createGoals(Tree infoAction) {
        if (infoAction == null) {
            return null;
        }
        if (infoAction.getType() == PddlParser.PRED_HEAD) {
            //estrapola tutti i predicati e ritornali come set di predicati
//            AndCond and = new AndCond();
//            and.addConditions();
            return buildPredicate(infoAction,null);
        } else if (infoAction.getType() == PddlParser.AND_GD) {
            AndCond and = new AndCond();
            for (int i = 0; i < infoAction.getChildCount(); i++) {
                Condition ret_val = createGoals(infoAction.getChild(i));
                if (ret_val != null) {
                    and.addConditions(ret_val);
                }
            }
            return and;

        } else if (infoAction.getType() == PddlParser.OR_GD) {
            OrCond or = new OrCond();
            for (int i = 0; i < infoAction.getChildCount(); i++) {
                Condition ret_val = createGoals(infoAction.getChild(i));
                if (ret_val != null) {
                    or.addConditions(ret_val);
                }
            }
            return or;
            //Crea un or e per ogni figlio di questo nodo invoca creaformula
            //gestendo il valore di ritorno come un attributo di or
        } else if (infoAction.getType() == PddlParser.NOT_GD) {
            Condition cond = null; // TODO: Can the condition be null or should we throw an error if that happens?
            for (int i = 0; i < infoAction.getChildCount(); i++) {
                Condition ret_val = createGoals(infoAction.getChild(i));
                if (ret_val != null) {
                    cond = ret_val;
                }
            }
            NotCond not = new NotCond(cond);
            return not;
            //Crea un not e per ogni figlio di questo nodo invoca creaformula
            //gestendo il valore di ritorno come un attributo di not
        } else if (infoAction.getType() == PddlParser.COMPARISON_GD) {
            //System.out.println("Comparison:" + infoAction.getText());
            AndCond ret = new AndCond();
            Comparison c = new Comparison(infoAction.getChild(0).getText());

            c.setLeft(createExpression(infoAction.getChild(1)));
            c.setRight(createExpression(infoAction.getChild(2)));
            ret.addConditions(c);
            return ret;
            //Crea un not e per ogni figlio di questo nodo invoca creaformula
            //gestendo il valore di ritorno come un attributo di not
        } else if (infoAction.getType() == PddlParser.ONEOF) {
            OneOf one_of = new OneOf();
            for (int i = 0; i < infoAction.getChildCount(); i++) {
                Condition ret_val = addOneOf(infoAction.getChild(i));
                if (ret_val != null) {
                    one_of.sons.add(ret_val);
                }
            }
            return one_of;
        }

        return null;
    }

    protected Expression createExpression(Tree t) {

        int test = t.getType();
        switch (t.getType()) {
            case PddlParser.BINARY_OP: {
                BinaryOp ret = new BinaryOp();
                ret.setOperator(t.getChild(0).getText());
                ret.setOne(createExpression(t.getChild(1)));
                ret.setRight(createExpression(t.getChild(2)));
                ret.grounded = true;
                return ret;
            }
            case PddlParser.NUMBER: {
                //Float.
                PDDLNumber ret = new PDDLNumber(Float.valueOf(t.getText()));
                return ret;
            }
            case PddlParser.FUNC_HEAD: {
                NumFluent ret = new NumFluent(t.getChild(0).getText());
                for (int i = 1; i < t.getChildCount(); i++) {
//                System.out.println("Constant Type:" + PddlParser.CONSTANTS);
//                System.out.println("Name Type:" + PddlParser.NAME);
//                System.out.println("Current Type:" + t.getChild(i).getType());
                    if (t.getChild(i).getType() == PddlParser.NAME) {
                        PDDLObject o = new PDDLObject(t.getChild(i).getText());
                        PDDLObject o1 = this.constants.containsTerm(o);
                        if (o1 != null) {
                            ret.addTerms(o1);
                        } else {

                            System.out.println("NumFluent:Variable " + o + " is not a constant object");
                            System.exit(-1);
                        }
                    } else {
                        
                    }
                }
                return ret;
            }
            case PddlParser.UNARY_MINUS:
                return new MinusUnary(createExpression(t.getChild(0)));
            case PddlParser.MULTI_OP: {
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
    
    private Condition addOneOf(Tree infoAction) {
        if (infoAction == null) {
            return null;
        }
        switch (infoAction.getType()) {
            case PddlParser.PRED_HEAD:
                //estrapola tutti i predicati e ritornali come set di predicati
//            AndCond and = new AndCond();
//            and.addConditions();
                return buildPredicate(infoAction,null);
            case PddlParser.AND_GD:
                AndCond and = new AndCond();
                for (int i = 0; i < infoAction.getChildCount(); i++) {
                    Condition ret_val = addOneOf(infoAction.getChild(i));
                    if (ret_val != null) {
                        and.addConditions(ret_val);
                    }
                }
                return and;
            case PddlParser.OR_GD:
                //            System.out.println("Or Condition");
                OrCond or = new OrCond();
                for (int i = 0; i < infoAction.getChildCount(); i++) {
                    Condition ret_val = addOneOf(infoAction.getChild(i));
//                System.out.println(ret_val);
                    if (ret_val != null) {
                        or.addConditions(ret_val);
                    }
                }
                return or;
            //Crea un or e per ogni figlio di questo nodo invoca creaformula
            //gestendo il valore di ritorno come un attributo di or
            case PddlParser.NOT_PRED_INIT:
                Condition cond = null; // TODO: Can the condition be null or should we throw an error?
                for (int i = 0; i < infoAction.getChildCount(); i++) {
                    Condition ret_val = addOneOf(infoAction.getChild(i));
                    if (ret_val != null) {
                        cond = ret_val;
                    }
                }
                NotCond not = new NotCond(cond);
                return not;
            case PddlParser.PRED_INST:
                //estrapola tutti i predicati e ritornali come set di predicati
//            AndCond and = new AndCond();
//            and.addConditions();
                return this.buildPredicate(infoAction,null);
            case PddlParser.ONEOF:
                OneOf one_of = new OneOf();
                for (int i = 0; i < infoAction.getChildCount(); i++) {
                    Condition ret_val = addOneOf(infoAction.getChild(i));
                    if (ret_val != null) {
                        one_of.sons.add(ret_val);
                    }
                }
                return one_of;
            default:
                System.out.println("Oneof Parsing: Some serious error:" + infoAction);
                return null;
        }
    }
    public Collection<NumFluent> addFunctions(Tree c) {
        LinkedHashSet<NumFluent> res = new LinkedHashSet();
        if (c != null) {
            for (int i = 0; i < c.getChildCount(); i++) {

                //System.out.println(c.getChild(i).getText());
                NumFluent ret = new NumFluent(c.getChild(i).getText());
                Tree t = c.getChild(i);
                for (int j = 0; j < t.getChildCount(); j++) {
                    Variable v = new Variable(t.getChild(j).getText());
                    if (t.getChild(j).getChild(0) != null);
                    //System.out.println(t.getChild(j));

                    //System.out.println(t.getChild(j).getChild(0));
                    v.setType(new Type(t.getChild(j).getChild(0).getText()));

                    ret.addVariable(v);
                }
                res.add(ret);
            }
        }
        return res;
    }

}

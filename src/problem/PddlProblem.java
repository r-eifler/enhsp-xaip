/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problem;

import antlr.RecognitionException;

import conditions.AndCond;
import conditions.Assign;
import conditions.Comparator;
import conditions.Conditions;
import conditions.NotCond;
import conditions.OrCond;
import conditions.Predicate;
import conditions.Term;

import domain.Type;

import expressions.BinaryOp;
import expressions.Expression;
import expressions.Function;
import expressions.MinusUnary;
import expressions.MultiOp;
import expressions.Number;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.HashMap;

import java.util.HashSet;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import parser.PddlLexer;
import parser.PddlParser;

/**
 *
 * @author enrico
 */
public class PddlProblem {

    private PlanningObjects object;
    private HashSet init;
    private Conditions goals;
    private String name;
    private Integer indexObject;
    private Integer indexInit;
    private Integer indexGoals;
    private Metric metric;
    public PddlProblem() {

        init = new HashSet();

        indexObject = 0;
        indexInit = 0;
        indexGoals = 0;
        object = new PlanningObjects();
    }

    public void parseProblem(String file) throws IOException, RecognitionException, org.antlr.runtime.RecognitionException {
        ANTLRInputStream in;
        in = new ANTLRInputStream(new FileInputStream(file));
        PddlLexer lexer = new PddlLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PddlParser parser = new PddlParser(tokens);
        PddlParser.pddlDoc_return root = parser.pddlDoc();

        if (parser.invalidGrammar()) {
            System.out.println("General Problem Parsing");
        }
        CommonTree t = (CommonTree) root.getTree();
//        System.out.println("tree:" + t.toStringTree());
//        exploreTree(t);
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            switch (child.getType()) {
                case PddlParser.PROBLEM_NAME:
                    setName(child.getChild(0).getText());
                    break;
                case PddlParser.OBJECTS:
                    addObjects(child);
                    break;
                case PddlParser.INIT:
                    addInitFacts(child);
                    break;
                case PddlParser.GOAL:
                    this.setGoals(createGoals(child.getChild(0)));
                    break;
                case PddlParser.PROBLEM_METRIC:
                    addMetric(child);
                    break;
            }
        }
    }

    private void addObjects(Tree c) {
        for (int i = 0; i < c.getChildCount(); i++) {
            this.object.add(new Term(c.getChild(i).getText(), new Type(c.getChild(i).getChild(0).getText())));
//            System.out.println("Aggiungo l'oggetto:" + c.getChild(i).getText());
//            System.out.println("che è di tipo:" + new Type(c.getChild(i).getChild(0).getText()));
        }
    }

    //Aggiungere controllo su dominio...in qualche modo!
    private Predicate buildInstPredicate(Tree t) {

        //if (t.getType() == PddlParser.PRED_INST) {
            Predicate a = new Predicate(true);
            a.setPredicateName(t.getChild(0).getText());
            a.setGrounded(true);

            for (int i = 1; i < t.getChildCount(); i++) {
                Term v = new Term(t.getChild(i).getText());

                Term t1 = getObject().containsTerm(v);
                if (t1 != null) {
                    a.addTerm(t1);
                } else {
                    System.out.println("La variabile " + v + " non è presente nei parametri");
                    System.exit(-1);
                }
            }
            return a;
        //}
        
        //return null;
    }

    private Conditions createGoals(Tree infoAction) {
        if (infoAction == null) {
            return null;
        }
        if (infoAction.getType() == PddlParser.PRED_HEAD) {
            //estrapola tutti i predicati e ritornali come set di predicati
            return buildInstPredicate(infoAction);
        } else if (infoAction.getType() == PddlParser.AND_GD) {
            AndCond and = new AndCond();
            for (int i = 0; i < infoAction.getChildCount(); i++) {
                Conditions ret_val = createGoals(infoAction.getChild(i));
                if (ret_val != null) {
                    and.addConditions(ret_val);
                }
            }
            return and;

        } else if (infoAction.getType() == PddlParser.OR_GD) {
            OrCond or = new OrCond();
            for (int i = 0; i < infoAction.getChildCount(); i++) {
                Conditions ret_val = createGoals(infoAction.getChild(i));
                if (ret_val != null) {
                    or.addConditions(ret_val);
                } 
            }
            return or;
            //Crea un or e per ogni figlio di questo nodo invoca creaformula
            //gestendo il valore di ritorno come un attributo di or
        } else if (infoAction.getType() == PddlParser.NOT_GD) {
            NotCond not = new NotCond();
            for (int i = 0; i < infoAction.getChildCount(); i++) {
                Conditions ret_val = createGoals(infoAction.getChild(i));
                if (ret_val != null) {
                    not.addConditions(ret_val);
                }
            }
            return not;
            //Crea un not e per ogni figlio di questo nodo invoca creaformula
            //gestendo il valore di ritorno come un attributo di not
        } else if (infoAction.getType() == PddlParser.COMPARISON_GD) {
            System.out.println("Comparison:" + infoAction.getText());

            Comparator c = new Comparator(infoAction.getChild(0).getText());

            c.setFirst(createExpression(infoAction.getChild(1)));
            c.setTwo(createExpression(infoAction.getChild(2)));
            return c;
            //Crea un not e per ogni figlio di questo nodo invoca creaformula
            //gestendo il valore di ritorno come un attributo di not
        }

        return null;
    }

    public  static Expression createExpression(Tree t) {

        if (t.getType() == PddlParser.BINARY_OP) {
            BinaryOp ret = new BinaryOp();
            ret.setOperator(t.getChild(0).getText());
            ret.setOne(createExpression(t.getChild(1)));
            ret.setTwo(createExpression(t.getChild(2)));

            return ret;
        } else if (t.getType() == PddlParser.NUMBER) {
            Number ret = new Number(new Float(t.getText()));
            return ret;
        } else if (t.getType() == PddlParser.FUNC_HEAD) {
            Function ret = new Function(t.getChild(0).getText());
            for (int i = 1; i < t.getChildCount(); i++) {
                ret.addTerm(new Term(t.getChild(i).getText()));
            }
            return ret;
        } else if (t.getType() == PddlParser.UNARY_MINUS) {
            return new MinusUnary(createExpression(t.getChild(0)));
        } else if (t.getType() == PddlParser.MULTI_OP) {
            MultiOp ret = new MultiOp(t.getChild(0).getText());
            for (int i=1; i<t.getChildCount();i++){
                //System.out.println("Figlio di + o * " + createExpression(t.getChild(i)));
                ret.addExpression(createExpression(t.getChild(i)));
            }
            return ret;
        }

        return null;

    }

    private void addInitFacts(Tree child) {
        for (int i = 0; i < child.getChildCount(); i++) {
            Tree c = child.getChild(i);
            if (c.getType() == PddlParser.PRED_INST) {
                init.add(buildInstPredicate(c));
            }else if (c.getType() == PddlParser.INIT_EQ) {
                Assign a = new Assign("=");
                a.setOne((Function)createExpression(c.getChild(0)));
                a.setTwo((Number)createExpression(c.getChild(1)));
                init.add(a);
            }else if (c.getType() == PddlParser.INIT_AT) {
                init.add(buildInstPredicate(c));

            }
            
        }
    }

    public void prettyPrint() {

        System.out.println("\ninit:" + getInit() + "\nObject" + getObject() + "\nGoals:" + getGoals()+ "\n" + this.metric.toString());

        if (metric.getMetExpr() instanceof MultiOp){
            MultiOp temp = (MultiOp)metric.getMetExpr();
            System.out.println("\n metrica ha :" + temp.getExpr().size())    ;
        
        }

    }

    private void exploreTree(Tree t) {
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
     * @return the object
     */
    public PlanningObjects getObject() {
        return object;
    }

    /**
     * @return the init
     */
    public HashSet getInit() {
        return init;
    }

    /**
     * @return the goals
     */
    public Conditions getGoals() {
        return goals;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    private void addMetric(Tree t) {
        
        System.out.println(t.toStringTree());
        metric = new Metric(t.getChild(0).getText());
        metric.setMetExpr(createExpression(t.getChild(1)));

    }

    /**
     * @param object the object to set
     */
    public void setObject(PlanningObjects object) {
        this.object = object;
    }

    /**
     * @param init the init to set
     */
    public void setInit(HashSet init) {
        this.init = init;
    }

    /**
     * @param goals the goals to set
     */
    public void setGoals(Conditions goals) {
        this.goals = goals;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the indexObject
     */
    public Integer getIndexObject() {
        return indexObject;
    }

    /**
     * @param indexObject the indexObject to set
     */
    public void setIndexObject(Integer indexObject) {
        this.indexObject = indexObject;
    }

    /**
     * @return the indexInit
     */
    public Integer getIndexInit() {
        return indexInit;
    }

    /**
     * @param indexInit the indexInit to set
     */
    public void setIndexInit(Integer indexInit) {
        this.indexInit = indexInit;
    }

    /**
     * @return the indexGoals
     */
    public Integer getIndexGoals() {
        return indexGoals;
    }

    /**
     * @param indexGoals the indexGoals to set
     */
    public void setIndexGoals(Integer indexGoals) {
        this.indexGoals = indexGoals;
    }

    /**
     * @return the metric
     */
    public Metric getMetric() {
        return metric;
    }

    /**
     * @param metric the metric to set
     */
    public void setMetric(Metric metric) {
        this.metric = metric;
    }
}

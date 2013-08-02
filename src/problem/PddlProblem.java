/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problem;

import antlr.RecognitionException;

import conditions.AndCond;
import conditions.NumFluentAssigner;
import conditions.Comparison;
import conditions.Conditions;
import conditions.NotCond;
import conditions.OrCond;
import conditions.Predicate;
import conditions.PDDLObject;
import domain.ActionSchema;
import domain.PddlDomain;

import domain.Type;

import expressions.BinaryOp;
import expressions.Expression;
import expressions.NumFluent;
import expressions.MinusUnary;
import expressions.MultiOp;
import expressions.PDDLNumber;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import parser.PddlLexer;
import parser.PddlParser;
import propositionalFactory.ActionFactory;

/**
 *
 * @author enrico
 */
public class PddlProblem {

    private PDDLObjects objects;
    private State init;
    private Conditions goals;
    private String name;
    private Integer indexObject;
    private Integer indexInit;
    private Integer indexGoals;
    private Metric metric;
    protected String pddlFilRef;
    protected String domainName;
    private PddlDomain linkedDomain;
    private Set actions;
    private long propositionalTime;

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
    public String getPddlFilRef() {
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

        String toWrite = "(define (problem " + this.getName() + ") "
                + "(:domain " + this.getDomainName() + ") "
                + this.objects.pddlPrint() + "\n"
                + this.init.pddlPrint() + "\n"
                + "(:goal " + this.getGoals().pddlPrint() + ")\n"
                + this.metric.pddlPrint() + "\n"
                + ")";
        Writer file = new BufferedWriter(new FileWriter(pddlNewFile));
        file.write(toWrite);
        file.close();
    }

    /**
     *
     */
    public PddlProblem() {

        init = new State();

        indexObject = 0;
        indexInit = 0;
        indexGoals = 0;
        objects = new PDDLObjects();
        metric = new Metric("NO");
        linkedDomain = null;
        actions = new HashSet();
    }

    /**
     *
     * @param file - the pathfile representing the pddl problem
     * @throws IOException
     * @throws RecognitionException
     * @throws org.antlr.runtime.RecognitionException
     */
    public void parseProblem(String file) throws IOException, RecognitionException, org.antlr.runtime.RecognitionException {

        pddlFilRef = file;
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
                case PddlParser.PROBLEM_DOMAIN:
                    this.setDomainName(child.getChild(0).getText());
                    break;
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
            this.objects.add(new PDDLObject(c.getChild(i).getText(), new Type(c.getChild(i).getChild(0).getText())));
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
        //System.out.println(a);
        for (int i = 1; i < t.getChildCount(); i++) {


            PDDLObject t1 = (PDDLObject) this.getObjectByName(t.getChild(i).getText());

            if (t1 != null) {
                a.addObject(t1);
            } else {
                System.out.println("Object " + t1 + " does not exist");
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
            //System.out.println("Comparison:" + infoAction.getText());

            Comparison c = new Comparison(infoAction.getChild(0).getText());

            c.setFirst(createExpression(infoAction.getChild(1)));
            c.setTwo(createExpression(infoAction.getChild(2)));
            return c;
            //Crea un not e per ogni figlio di questo nodo invoca creaformula
            //gestendo il valore di ritorno come un attributo di not
        }

        return null;
    }

    private Expression createExpression(Tree t) {

        int test = t.getType();
        if (t.getType() == PddlParser.BINARY_OP) {
            BinaryOp ret = new BinaryOp();
            ret.setOperator(t.getChild(0).getText());
            ret.setOne(createExpression(t.getChild(1)));
            ret.setRight(createExpression(t.getChild(2)));
            ret.grounded = true;
            return ret;
        } else if (t.getType() == PddlParser.NUMBER) {
            PDDLNumber ret = new PDDLNumber(new Float(t.getText()));
            return ret;
        } else if (t.getType() == PddlParser.FUNC_HEAD) {
            NumFluent ret = new NumFluent(t.getChild(0).getText());

            for (int i = 1; i < t.getChildCount(); i++) {
                ret.addTerms(this.getObjectByName(t.getChild(i).getText()));
            }

            ret.grounded = true;
            return ret;
        } else if (t.getType() == PddlParser.UNARY_MINUS) {
            return new MinusUnary(createExpression(t.getChild(0)));
        } else if (t.getType() == PddlParser.MULTI_OP) {
            MultiOp ret = new MultiOp(t.getChild(0).getText());
            for (int i = 1; i < t.getChildCount(); i++) {
                //System.out.println("Figlio di + o * " + createExpression(t.getChild(i)));
                ret.addExpression(createExpression(t.getChild(i)));
            }
            ret.grounded = true;
            return ret;
        }

        return null;

    }

    private void addInitFacts(Tree child) {
        for (int i = 0; i < child.getChildCount(); i++) {
            Tree c = child.getChild(i);
            if (c.getType() == PddlParser.PRED_INST) {
                init.addProposition(buildInstPredicate(c));

            } else if (c.getType() == PddlParser.INIT_EQ) {
                NumFluentAssigner a = new NumFluentAssigner("=");
                a.setNFluent((NumFluent) createExpression(c.getChild(0)));
                a.setTwo((PDDLNumber) createExpression(c.getChild(1)));
                init.addNumericFluent(a);
            } else if (c.getType() == PddlParser.INIT_AT) {
                init.addTimedLiteral(buildInstPredicate(c));

            }

        }
    }

    /**
     * A pretty representation for the pddl problem
     */
    public void prettyPrint() {

        System.out.println("\ninit:" + getInit() + "\nObject" + getProblemObjects() + "\nGoals:" + getGoals() + "\n" + this.metric.toString());

        if (metric.getMetExpr() instanceof MultiOp) {
            MultiOp temp = (MultiOp) metric.getMetExpr();
            System.out.println("\n metrica ha :" + temp.getExpr().size());

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
     * @return the objects - the objects of the pddl problem
     */
    public PDDLObjects getProblemObjects() {
        return objects;
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
    public Conditions getGoals() {
        return goals;
    }

    /**
     * @return the name - the name of the problem
     */
    public String getName() {
        return name;
    }

    private void addMetric(Tree t) {

        System.out.println(t.toStringTree());
        metric = new Metric(t.getChild(0).getText());
        metric.setMetExpr(createExpression(t.getChild(1)));

    }

    private void setObject(PDDLObjects object) {
        this.objects = object;
    }

    public void setInit(State init) {
        this.init = init;
    }

    public void setGoals(Conditions goals) {
        this.goals = goals;
    }

    /**
     * @param name the name to set
     */
    private void setName(String name) {
        this.name = name;
    }

    private Integer getIndexObject() {
        return indexObject;
    }

    /**
     * @param indexObject the indexObject to set
     */
    private void setIndexObject(Integer indexObject) {
        this.indexObject = indexObject;
    }

    /**
     * @return the indexInit
     */
    private Integer getIndexInit() {
        return indexInit;
    }

    /**
     * @param indexInit the indexInit to set
     */
    private void setIndexInit(Integer indexInit) {
        this.indexInit = indexInit;
    }

    /**
     * @return the indexGoals
     */
    private Integer getIndexGoals() {
        return indexGoals;
    }

    /**
     * @param indexGoals the indexGoals to set
     */
    private void setIndexGoals(Integer indexGoals) {
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
    private void setMetric(Metric metric) {
        this.metric = metric;
    }

    /**
     *
     * @param string - the name of the object we want
     * @return the term representing the object
     */
    public PDDLObject getObjectByName(String string) {
        for (Object o : this.objects) {
            PDDLObject el = (PDDLObject) o;
            if (el.getName().equalsIgnoreCase(string)) {
                return el;
            }
        }
        return null;
    }

    public Float getInitFunctionValue(NumFluent f) {

        return init.functionValue(f).getNumber();
    }

    public NumFluent getFunction(String string, ArrayList terms) {
        for (Object o : init.getNumericFluents()) {

            if (o instanceof NumFluentAssigner) {
                NumFluentAssigner ele = (NumFluentAssigner) o;
                NumFluent fAssign = ele.getNFluent();

                if (fAssign.getName().equals(string)) {
                    if (fAssign.getTerms().equals(terms)) {
                        return fAssign;
                    }
                }
            }

        }
        return null;
    }

    public ArrayList getFunctions() {
        ArrayList res = new ArrayList();

        for (Object o : init.getNumericFluents()) {

            if (o instanceof NumFluentAssigner) {
                NumFluentAssigner ele = (NumFluentAssigner) o;
                NumFluent fAssign = ele.getNFluent();
                res.add(fAssign);

            }

        }
        return res;
    }

    public void setDomain(PddlDomain aThis) {
        linkedDomain = aThis;
    }

    public void generateActions() throws Exception {
        long start = System.currentTimeMillis();
        if (this.linkedDomain != null) {
            ActionFactory af = new ActionFactory();
            for (ActionSchema act : (Set<ActionSchema>) linkedDomain.getActionsSchema()) {
//                af.Propositionalize(act, objects);
                getActions().addAll(af.Propositionalize(act, objects));
            }

            //pruneActions();
        } else {
            System.err.println("Please connect the domain of the problem via validation");
            System.exit(-1);
        }
        setPropositionalTime(System.currentTimeMillis() - start);
    }

    public int distance(State sIn, Conditions c) {

        Set level;
        RelState s = sIn.relaxState();
        int distance = 0;
        while (true) {
            if (s.satisfy(c)) {
                return distance;
            } else {
                distance++;
                level = new HashSet();
                for (Iterator it = getActions().iterator(); it.hasNext();) {
                    GroundAction gr = (GroundAction) it.next();
                    if (gr.getPreconditions().isSatisfied(s)) {
                        level.add(gr);
                        it.remove();
                    }
                }
                if (level.isEmpty()) {
                    return Integer.MAX_VALUE;
                }
                for (Object o : level) {
                    GroundAction gr = (GroundAction) o;
                    gr.apply(s);
                }
            }
        }
    }

    public Map distance(State sIn, List c_s) {

        Set level;
        RelState s = sIn.relaxState();

        Map order = new HashMap();
        ArrayList toVisit = new ArrayList();
        toVisit.addAll(c_s);
        int distance = 0;
        while (true) {
            for (Iterator it = toVisit.iterator(); it.hasNext();) {
                Conditions c = (Conditions) it.next();
                if (s.satisfy(c)) {
                    order.put(c, distance);
                    it.remove();
                }

            }
            if (toVisit.isEmpty()) {
                return order;
            } else {
                distance++;
                level = new HashSet();
                for (Iterator it = getActions().iterator(); it.hasNext();) {
                    GroundAction gr = (GroundAction) it.next();
                    if (gr.getPreconditions().isSatisfied(s)) {
                        level.add(gr);
                        it.remove();
                    }
                }
                if (level.isEmpty()) {
                    return order;
                }
                for (Object o : level) {
                    GroundAction gr = (GroundAction) o;
                    gr.apply(s);
                }
            }
        }
    }

    private void pruneActions() {
        boolean finished = false;
        boolean goalReached = false;
        Set level;
        RelState s = this.init.relaxState();
        int prec = 0;
        int distance = 0;
        Set totalActions = new HashSet();
        while (!finished && !goalReached) {
            distance++;
            level = new HashSet();
            for (Iterator it = getActions().iterator(); it.hasNext();) {
                GroundAction gr = (GroundAction) it.next();
                //System.out.println(gr.toEcoString());
                if (gr.getPreconditions().isSatisfied(s)) {
                    totalActions.add(gr);
                    level.add(gr);
                    it.remove();
                }
            }


            for (Object o : level) {
                GroundAction gr = (GroundAction) o;
                gr.apply(s);
            }
            //if (s.satisfy(getGoals()))
            //  goalReached=true;
            System.out.println("Distance: " + distance);
            System.out.println("ApplicableActions: " + level.size());
            if (prec == totalActions.size()) {
                finished = true;
                getActions().clear();
                setActions(totalActions);
            }
            prec = totalActions.size();
        }

    }

    private void pruneActions_old() {
        boolean finished = false;
        boolean goalReached = false;
        int distance = 0;
        Set level;
        RelState s = this.init.relaxState();
        int prec = 0;
        while (!finished && !goalReached) {
            distance++;
            level = new HashSet();
            for (Iterator it = getActions().iterator(); it.hasNext();) {
                GroundAction gr = (GroundAction) it.next();
                //System.out.println(gr.toEcoString());
                if (gr.getPreconditions().isSatisfied(s)) {
                    level.add(gr);
                }
            }
            for (Object o : level) {
                GroundAction gr = (GroundAction) o;
                gr.apply(s);
            }
            //if (s.satisfy(getGoals()))
            //  goalReached=true;
            //System.out.println("Distance: " +distance);
            //System.out.println("ApplicableActions: " +level.size());
            if (prec == level.size()) {
                finished = true;
                getActions().clear();
                setActions(level);
            }
            prec = level.size();
        }
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
    public Set getActions() {
        return actions;
    }

    /**
     * @param actions the actions to set
     */
    public void setActions(Set actions) {
        this.actions = actions;
    }

    public Map computeKernelDistance(ArrayList k) {
        boolean finished = false;
        boolean kernelVisited = false;
        Set level;
        RelState s = this.init.relaxState();
        int prec = 0;
        ArrayList toVisit = new ArrayList();
        toVisit.addAll(k);
        Map order = new HashMap();
        Set totalActions = new HashSet();
        int distance = -1;
        while (!finished && !kernelVisited) {
            distance++;
            level = new HashSet();
            for (Iterator it = getActions().iterator(); it.hasNext();) {
                GroundAction gr = (GroundAction) it.next();
                //System.out.println(gr.toEcoString());
                if (gr.getPreconditions().isSatisfied(s)) {
                    totalActions.add(gr);
                    level.add(gr);
                    it.remove();
                }
            }

            for (Object o : level) {
                GroundAction gr = (GroundAction) o;
                gr.apply(s);
            }
            for (Iterator it = toVisit.iterator(); it.hasNext();) {
                Conditions con = (Conditions) it.next();

                if (s.satisfy(con)) {
                    //System.out.println("Kernel " + con + " raggiunto a livello:" + distance);
                    order.put((k.size() - k.indexOf(con)), distance);
                    it.remove();
                }
            }
            if (toVisit.isEmpty()) {
                kernelVisited = true;

            }
            //  goalReached=true;
            System.out.println("Distance: " + distance);
            System.out.println("ApplicableActions: " + level.size());
            if (prec == totalActions.size()) {
                finished = true;
            } else {
                prec = totalActions.size();
            }
        }
        getActions().clear();
        setActions(totalActions);

        return order;
    }

    public void parseProblem(String string, PDDLObjects constants) throws IOException, RecognitionException, org.antlr.runtime.RecognitionException {
        this.objects.addAll(constants);
        parseProblem(string);
    }
}

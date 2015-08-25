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
package plan;

import conditions.AndCond;
import conditions.Comparison;
import conditions.Conditions;
import conditions.NotCond;
import conditions.NumFluentAssigner;
import conditions.PDDLObject;
import conditions.Predicate;
import domain.ActionSchema;
import domain.ParametersAsTerms;
import domain.PddlDomain;
import domain.Variable;
import expressions.Expression;
import expressions.NumEffect;
import expressions.NumFluent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.DefaultEdge;
import problem.GlobalConstraint;
import problem.GroundAction;
import problem.PddlProblem;
import problem.State;

/**
 *
 * @author enrico
 */
public class SimplePlan extends ArrayList<GroundAction> {

    private PddlDomain pd;
    private PddlProblem pp;
    private HashMap invariantFluents;
    private boolean invariantAnalysis;
    private HashMap rank;
    private int employedMacro;
    private int orderingByJustification = 0;
    private int orderingByStrangeness = 0;
    private int orderingByPropositionalThreatBack = 0;
    private int orderingByNumericThreatBack = 0;
    private int orderingByThreatPropositionForward = 0;
    private int orderingByThreatNumericForward = 0;
    private HashMap<NumFluent, HashSet<NumFluent>> fluentDependencyChain;
    private IdentityHashMap validationStructures;
    private HashMap goalAchiever;
    private ConnectivityInspector<Object, Object> connectedSetBuilder;
    private int debug = 0;

    public SimplePlan(PddlDomain dom) {
        super();
        pd = dom;

        invariantAnalysis = false;
        employedMacro = 0;
    }

    public SimplePlan(PddlDomain dom, PddlProblem prob) {
        super();
        pd = dom;
        pp = prob;
        invariantAnalysis = false;
        employedMacro = 0;
    }

//    @Override
//    public boolean contains(Object o) {
//        GroundAction gr = (GroundAction)o;
//        for (Object)
//        
//        
//        
//    }
    public int distance(SimplePlan a) {
        int d = 0;

        //System.out.println("computing distance");
        //System.out.println(this);
        //System.out.println(a);
        for (Object o : this) {
            if (!a.contains(o)) {
                d++;
            }
        }
        for (Object o : a) {
            if (!this.contains(o)) {
                d++;
            }
        }
        return d;

    }

    public SimplePlan(PddlDomain a, PddlProblem p, boolean performInvariantAnalysis) {
        super();
        pd = a;
        pp = p;
        invariantAnalysis = performInvariantAnalysis;
        employedMacro = 0;
    }

    @Override
    public Object clone() {
        SimplePlan sp = new SimplePlan(pd, pp);
        sp.invariantFluents = (HashMap) this.invariantFluents.clone();
        sp.invariantAnalysis = this.invariantAnalysis;
        for (Object o : this) {
            GroundAction gr = (GroundAction) o;
            try {
                sp.add((GroundAction) gr.clone());
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(SimplePlan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return sp;
    }

    //it will be handled as a mmaction
    public void putAction(String actionName, ParametersAsTerms par){

        ActionSchema action = pd.getActionByName(actionName);
        if (action == null) {
            System.out.println("Action not found in the domain theory!!" + actionName);
        }
        //System.out.println(par);
        GroundAction grAction = action.ground(par);
        grAction.generateAffectedNumFluents();
        //grAction.normalizeAndCopy();
        this.add(grAction);

    }

    //to be done....
    public void parseSolutionWithoutProblem(String solution_file) throws FileNotFoundException, Exception {
        Scanner sc = new Scanner((new File(solution_file)));
        String nameOperator;

        this.removeAll(this);
        while (sc.hasNextLine()) {
            String s1, s2, cntStr = null;

            String temp = sc.nextLine();
            cntStr = sc.findInLine(";");

//            System.out.println(cntStr);
//            System.out.println(s1);
            if (cntStr == null) {
                if (temp.matches("[(][^)]++[)]")) {
                    s1 = temp;
                } else {
                    s1 = sc.findInLine("[(][^)]++[)]");
                }
                //if (!(sc.next().charAt(0) == ';')) &&{
                //System.out.println("Primo carattere:" + );
                if (s1 != null) {
                    ParametersAsTerms pars = new ParametersAsTerms();
                    s2 = s1.substring(1, s1.length() - 1);
                    s1 = "(" + s2.trim().toLowerCase() + ")";
                    //this.add(s1);
                    int nameEndIndex = s1.indexOf(" ");
                    if (nameEndIndex == -1) {
                        nameOperator = s1.substring(1, s1.indexOf(")"));
                    } else {
                        nameOperator = s1.substring(1, nameEndIndex);
                        boolean finish = false;
                        s1 = s1.substring(nameEndIndex + 1);//passo al prossimo carattere dopo lo spazio
                        int objectCounter = 0;
                        do {
                            String par;
                            int parEndIndex = s1.indexOf(" ");//prendo l'indice limite del prossimo parametro
                            if (parEndIndex == -1) {
                                finish = true;
                                par = s1.substring(0, s1.indexOf(")"));
                            } else {
                                par = s1.substring(0, parEndIndex);
                                s1 = s1.substring(parEndIndex + 1);
                            }
                            //System.out.println(par);
                            PDDLObject obj = new PDDLObject(par);
                            //System.out.println(obj);
                            ActionSchema a = this.pd.getActionByName(nameOperator);
                            Variable v = (Variable) a.getParameters().get(objectCounter);
                            obj.setType(v.getType());

                            pars.add(obj);
                            objectCounter++;
                        } while (!finish);
                    }
                    //System.out.println(nameOperator +  pars );
                    this.putAction(nameOperator, pars);

                }
            }
        }
    }

    public void addActionsFromString(String s1) {
        String nameOperator, s2;
        ParametersAsTerms pars = new ParametersAsTerms();
        s2 = s1.substring(s1.indexOf(":")+1, s1.length());        
        s1 = s2.trim().toLowerCase();
        //System.out.println(s1);
        //this.add(s1);
        int nameEndIndex = s1.indexOf(" ");
        if (nameEndIndex == -1) {
            nameOperator = s1.substring(1, s1.indexOf(")"));
            //System.out.println(nameOperator);
        } else {
            nameOperator = s1.substring(1, nameEndIndex);
            //System.out.println(nameOperator);
            boolean finish = false;
            s1 = s1.substring(nameEndIndex + 1);//passo al prossimo carattere dopo lo spazio
            int objectCounter = 0;
            do {
                String par;
                int parEndIndex = s1.indexOf(" ");//prendo l'indice limite del prossimo parametro
                if (parEndIndex == -1) {
                    finish = true;
                    par = s1.substring(0, s1.indexOf(")"));
                } else {
                    par = s1.substring(0, parEndIndex);
                    s1 = s1.substring(parEndIndex + 1);
                }
                //System.out.println(par);
                PDDLObject obj = new PDDLObject(par);
                //System.out.println(nameOperator);
                ActionSchema a = this.pd.getActionByName(nameOperator);
//                System.out.println(a);
//               System.out.println(a.getParameters().size());
//                System.out.println(objectCounter);
                Variable v = (Variable) a.getParameters().get(objectCounter);
                obj.setType(v.getType());

                pars.add(obj);
                objectCounter++;
            } while (!finish);
        }
        //System.out.println(nameOperator +  pars );
        this.putAction(nameOperator, pars);
    }

    //to be done....
    public void parseSolution(String solution_file) throws FileNotFoundException, Exception {
        Scanner sc = new Scanner((new File(solution_file)));
        String nameOperator;

        this.removeAll(this);
        while (sc.hasNextLine()) {
            String s1, s2, cntStr = null;

            String temp = sc.nextLine();
            cntStr = sc.findInLine(";");

//            System.out.println(cntStr);
//            System.out.println(s1);
            if (cntStr == null) {
                if (temp.matches("[(][^)]++[)]")) {
                    s1 = temp;
                } else {
                    s1 = sc.findInLine("[(][^)]++[)]");
                }
                //if (!(sc.next().charAt(0) == ';')) &&{
                //System.out.println("Primo carattere:" + );
                if (s1 != null) {
                ParametersAsTerms pars = new ParametersAsTerms();
                    s2 = s1.substring(1, s1.length() - 1);
                    s1 = "(" + s2.trim().toLowerCase() + ")";
                    //this.add(s1);
                    int nameEndIndex = s1.indexOf(" ");
                    if (nameEndIndex == -1) {
                        nameOperator = s1.substring(1, s1.indexOf(")"));
                    } else {
                        nameOperator = s1.substring(1, nameEndIndex);
                        boolean finish = false;
                        s1 = s1.substring(nameEndIndex + 1);//passo al prossimo carattere dopo lo spazio
                        do {
                            String par;
                            int parEndIndex = s1.indexOf(" ");//prendo l'indice limite del prossimo parametro
                            if (parEndIndex == -1) {
                                finish = true;
                                par = s1.substring(0, s1.indexOf(")"));
                            } else {
                                par = s1.substring(0, parEndIndex);
                                s1 = s1.substring(parEndIndex + 1);
                            }
                            pars.add(pp.getObjectByName(par));
                        } while (!finish);
                    }
                    //System.out.println(nameOperator +  pars );
                    this.putAction(nameOperator, pars);

                }
            }
        }

        if (this.invariantAnalysis){
            setInvariantFluents(this.pd.generateAbstractInvariantFluents());
            this.simplifyActions();
        }
    }

    @Override
    public String toString() {
        String ret_val = "";

        for (Object o : this) {
            if (o instanceof GroundAction) {
                GroundAction a = (GroundAction) o;
                ret_val = ret_val.concat(a.toEcoString() + "\n");

            }
        }
        return ret_val;
    }

    public String printAction(int index) {

        GroundAction a = (GroundAction) this.get(index);

        return a.getNumericEffects().toString();

    }

    public String toDetailedString() {
        String ret_val = "";

        for (Object o : this) {
            if (o instanceof GroundAction) {
                GroundAction a = (GroundAction) o;
                ret_val = ret_val.concat(a.toString());

            }
        }
        return ret_val;
    }

    public boolean propConsistent() {
        return true;
    }

    public void simplifyActions2() {

        //scopro quali sono i fluenti che devo eliminare perche' ci sono scritti
        //i valori nello stato iniziale
        //dopo aver fatto cio' semplifico le variabili nelle azioni del piano
        this.invariantFluents = new HashMap();
        for (Object anAction : this) {
            GroundAction a = (GroundAction) anAction;
            for (Object o2 : a.getNumericFluentAffected().keySet()) {
                invariantFluents.put(o2, false);
            }
        }

        //invariantFluents.put(pp.getFunctions(), true);
        for (Object o3 : pp.getInit().getNumericFluents()) {
            NumFluentAssigner ass = (NumFluentAssigner) o3;
            if (invariantFluents.get(ass.getNFluent()) == null) {
                invariantFluents.put(ass.getNFluent(), true);

            }
        }

        for (Object o : this) {
            GroundAction a = (GroundAction) o;
            //a.normalizeAndCopy();

            Conditions con = a.getPreconditions();
            Conditions eff = a.getNumericEffects();
//                    System.out.println(con);
//                    System.out.println(eff);
            if (con != null) {
                if (con instanceof AndCond) {
                    for (Object o2 : con.sons) {
                        if (o2 instanceof Comparison) {
                            Comparison comp = (Comparison) o2;
                            Expression lValue = comp.getLeft();
                            Expression rValue = comp.getRight();
                            //System.out.println("before" + lValue + rValue);
                            lValue = lValue.weakEval(pp.getInit(), invariantFluents);
                            rValue = rValue.weakEval(pp.getInit(), invariantFluents);
                            comp.setLeft(lValue);
                            comp.setRight(rValue);
                            //System.out.println("after" + lValue + rValue);
                        }
                    }
                } else {
                    if (con instanceof Predicate) {
                    } else {
                        if (con instanceof Comparison) {
                            Comparison comp = (Comparison) con;
                            Expression lValue = comp.getLeft();
                            Expression rValue = comp.getRight();
                            //System.out.println("before" + lValue + rValue);
                            lValue = lValue.weakEval(pp.getInit(), invariantFluents);
                            rValue = rValue.weakEval(pp.getInit(), invariantFluents);
                            comp.setLeft(lValue);
                            comp.setRight(rValue);
                        } else {
                            System.err.println("Conditions of the type: " + con.getClass());
                            throw new UnsupportedOperationException("Not supported yet.");
                        }
                    }
                }
            }

            if (eff != null) {
                if (eff instanceof AndCond) {
                    for (Object o2 : eff.sons) {
                        NumEffect nEff = (NumEffect) o2;
                        //System.out.println(nEff.getRight().getClass());
                        Expression rValue = nEff.getRight();
                        //System.out.println("before" + rValue);
                        rValue = rValue.weakEval(pp.getInit(), invariantFluents);
                        nEff.setRight(rValue);
                        //System.out.println("after" + rValue);

                    }
                } else {
                    throw new UnsupportedOperationException("Not supported yet.");
                }
            }
            //a.normalizeAndCopy();
        }

    }

    public void simplifyActions() throws Exception {

        //scopro quali sono i fluenti che devo eliminare perche' ci sono scritti
        //i valori nello stato iniziale
        //dopo aver fatto cio' semplifico le variabili nelle azioni del piano
        for (Object o : this) {
            
            GroundAction a = (GroundAction) o;
            //a.normalizeAndCopy();
            a.simplifyModel(pd, pp);
          
        }

    }

    public boolean savePlan(String nFile) {
        Writer output = null;
        try {
            output = new BufferedWriter(new FileWriter(nFile));
            for (Object o : this) {
                GroundAction a = (GroundAction) o;
                output.write(a.toFileCompliant() + "\n");
            }
            output.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(SimplePlan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                output.close();
            } catch (IOException ex) {
                Logger.getLogger(SimplePlan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return false;

    }

    /**
     * @return the invariantFluents
     */
    public HashMap getInvariantFluents() {
        return invariantFluents;
    }

    /**
     * @param invariantFluents the invariantFluents to set
     */
    public void setInvariantFluents(HashMap invariantFluents) {
        this.invariantFluents = invariantFluents;
    }

    public boolean savePlan(String tempPlan, int i) {
        Writer output = null;
        try {
            output = new BufferedWriter(new FileWriter(tempPlan));
            for (int j = i; j < this.size(); j++) {
                GroundAction a = (GroundAction) this.get(j);
                output.write(a.toFileCompliant() + "\n");
            }
            output.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(SimplePlan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                output.close();
            } catch (IOException ex) {
                Logger.getLogger(SimplePlan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return false;

    }

    public void printLastPredictedState(int i, State s) throws CloneNotSupportedException {

        State temp = s.clone();
        for (int j = i; j < this.size(); j++) {
            GroundAction action = (GroundAction) this.get(j);

            action.apply(temp);
        }
        System.out.print("S[plan(" + i + ")] ");
        //System.out.println(getPlan().getInvariantFluents());

        for (Object o : temp.getNumericFluents()) {
            NumFluentAssigner ass = (NumFluentAssigner) o;
            if (!(Boolean) this.getInvariantFluents().get(ass.getNFluent())) {
                System.out.print(o);
            }
        }
        System.out.println("");
    }

    public GroundAction generateMacro(int firstActionIndex, int lastActionIndex) throws CloneNotSupportedException, Exception {
        //GroundAction firstAct = (GroundAction) this.get(firstActionIndex);
        if (lastActionIndex > firstActionIndex) {
            GroundAction macroPlan = (GroundAction) this.get(firstActionIndex);
            macroPlan.setIsMacro(true);
            macroPlan.getPrimitives().add(this.get(firstActionIndex));

            long start = System.currentTimeMillis();
            for (int j = firstActionIndex + 1; j <= lastActionIndex; j++) {
                macroPlan = macroPlan.buildMacroInProgression((GroundAction) this.get(j), this.pd, this.pp, false);
            }
            System.out.println("#primitives: " + macroPlan.getPrimitives().size() + " aggregation time:" + (System.currentTimeMillis() - start));
            return macroPlan;
        } else {
            return null;
        }

    }

    public State execute(State init) throws CloneNotSupportedException {
        State temp = init.clone();
        int i=0;
        for (GroundAction gr : (ArrayList<GroundAction>) this) {
            if (gr.isApplicable(temp)) {
                i++;
                temp = gr.apply(temp);
                if (debug >1){
                    System.out.println(gr.getName()+" action has been applied");
                    //System.out.println(temp.pddlPrint());
                }
                //System.out.println("in-at"+ temp.printFluentByName("in-at"));
            } else {
                if (debug > 1){
                    System.out.println(gr.toEcoString() + "is not applicable");
                    System.out.println("Step:"+i);
                    
                    //AndCond c= (AndCond)gr.getPreconditions();
                    System.out.println(temp.pddlPrint());

                    System.out.println(temp.whatIsNotsatisfied((AndCond)gr.getPreconditions()));
                }
                return temp;
            }
        }
        return temp;
    }

    public TreeSet<GroundAction> generateMacrosSuffandPref() throws CloneNotSupportedException, Exception {
        TreeSet<GroundAction> ret = new TreeSet();
        GroundAction macroPlan = new GroundAction();
        //prefix plans computation
        for (int j = 0; j < this.size(); j++) {
            macroPlan = macroPlan.buildMacroInProgression((GroundAction) this.get(j), this.pd, this.pp, false);
            ret.add(macroPlan);
        }
        //suffix plans computation
        macroPlan = new GroundAction();
        //prefix plans computation
        for (int j = this.size() - 2; j > 0; j--) {
            macroPlan = macroPlan.buildMacroInRegression((GroundAction) this.get(j), this.pd, this.pp, false);
            ret.add(macroPlan);
        }
        return ret;
    }

    public TreeSet<GroundAction> generateMacrosSuffPrefInfiss(int minLength) throws CloneNotSupportedException, Exception {
        TreeSet<GroundAction> ret = new TreeSet();
        GroundAction macroPlan = this.get(0);
        //prefix plans computation
        for (int j = 1; j < this.size(); j++) {
            macroPlan = macroPlan.buildMacroInProgression((GroundAction) this.get(j), this.pd, this.pp, false);
            if (macroPlan.getPrimitives().size() >= minLength) {
                ret.add(macroPlan);
            }
        }
        //suffix plans computation
        macroPlan = this.get(this.size() - 1);
        //prefix plans computation
        for (int j = this.size() - 2; j > 0; j--) {
            macroPlan = macroPlan.buildMacroInRegression((GroundAction) this.get(j), this.pd, this.pp, false);
            if (macroPlan.getPrimitives().size() >= minLength) {
                ret.add(macroPlan);
            }
        }

        int middle = this.size() / 2;
        //System.out.println("!!!!!!!!!!  "+middle + " !!!!!!!!!!!!!!");
        GroundAction firstAct = (GroundAction) this.get(middle);
        GroundAction macro = (GroundAction) firstAct.clone();
        macro.simplifyModel(pd, pp);

        long start = System.currentTimeMillis();
        //prefix plans computation
        for (int j = middle + 1; j <= this.size(); j++) {
            GroundAction macroDestra = null;

            if (j < this.size()) {
                macroDestra = macro.buildMacroInProgression((GroundAction) this.get(j), pd, pp, false);
                if (macroDestra.getPrimitives().size() >= minLength) {
                    ret.add(macroDestra);
                }
            }
            int i = (this.size() % 2 == 0) ? this.size() - j : this.size() - j - 1;
            //System.out.println("Aggiungo azioni da:" +middle+","+ j + " e da: "+i);
            if (i >= 0) {
                GroundAction macroSinistra = macro.buildMacroInRegression((GroundAction) this.get(i), pd, pp, false);
                if (macroSinistra.getPrimitives().size() >= minLength) {
                    ret.add(macroSinistra);
                }
                if (macroDestra != null) {
                    GroundAction macroDestraSinistra = macroDestra.buildMacroInRegression((GroundAction) this.get(i), pd, pp, false);
                    //System.out.println("#primitives: "+(j)+" aggregation time:" + (System.currentTimeMillis()-start));
                    if (macroDestraSinistra.getPrimitives().size() >= minLength) {
                        ret.add(macroDestraSinistra);
                    }
                    macro = macroDestraSinistra;
                } else {
                    macro = macroSinistra;
                }
            } else {
                macro = macroDestra;
            }

        }

        return ret;
    }

    public void parseSolutionWithMacro(String solutionString, Map macroToPrimitives) throws FileNotFoundException {
        Scanner sc = new Scanner((new File(solutionString)));
        String nameOperator;
        boolean prima = false;
        this.removeAll(this);
        while (sc.hasNextLine()) {
            String s1, s2, cntStr = null;
            String temp = sc.nextLine();
            cntStr = sc.findInLine(";");

            if (cntStr == null) {
                if (temp.matches("[(][^)]++[)]")) {
                    prima = true;
                    s1 = temp;
                } else {
                    s1 = sc.findInLine("[(][^)]++[)]");
                }

//                else
//                    s1 = sc.findInLine("[(][^)]++[)]");
                //if (!(sc.next().charAt(0) == ';')) &&{
                //System.out.println("Primo carattere:" + );
                if (s1 != null) {
                    ParametersAsTerms pars = new ParametersAsTerms();
                    s2 = s1.substring(1, s1.length() - 1);
                    s1 = "(" + s2.trim().toLowerCase() + ")";
                    //this.add(s1);
                    int nameEndIndex = s1.indexOf(" ");
                    if (nameEndIndex == -1) {
                        nameOperator = s1.substring(1, s1.indexOf(")"));
                    } else {
                        nameOperator = s1.substring(1, nameEndIndex);
                        boolean finish = false;
                        s1 = s1.substring(nameEndIndex + 1);//passo al prossimo carattere dopo lo spazio
                        do {
                            String par;
                            int parEndIndex = s1.indexOf(" ");//prendo l'indice limite del prossimo parametro
                            if (parEndIndex == -1) {
                                finish = true;
                                par = s1.substring(0, s1.indexOf(")"));
                            } else {
                                par = s1.substring(0, parEndIndex);
                                s1 = s1.substring(parEndIndex + 1);
                            }
                            pars.add(pp.getObjectByName(par));
                        } while (!finish);
                    }
                    //System.out.println(nameOperator +  pars );

                    if (nameOperator.contains("macro")) {
                        ArrayList primitives = (ArrayList) macroToPrimitives.get(nameOperator);
                        this.addAll(primitives);
                        setEmployedMacro(getEmployedMacro() + 1);
                    } else {
                        this.putAction(nameOperator, pars);
                    }

                }
            }
        }
    }

    public TreeSet<GroundAction> generateInfissMacros() throws CloneNotSupportedException, Exception {
        TreeSet<GroundAction> ret = new TreeSet();

        int middle = this.size() / 2;
        //System.out.println("!!!!!!!!!!  "+middle + " !!!!!!!!!!!!!!");
        GroundAction firstAct = (GroundAction) this.get(middle);
        GroundAction macro = (GroundAction) firstAct.clone();
        macro.simplifyModel(pd, pp);

        long start = System.currentTimeMillis();
        //prefix plans computation
        for (int j = middle + 1; j <= this.size(); j++) {
            GroundAction macroDestra = null;

            if (j < this.size()) {
                macroDestra = macro.buildMacroInProgression((GroundAction) this.get(j), pd, pp, false);
                ret.add(macroDestra);
            }
            int i = (this.size() % 2 == 0) ? this.size() - j : this.size() - j - 1;
            //System.out.println("Aggiungo azioni da:" +middle+","+ j + " e da: "+i);
            if (i >= 0) {
                GroundAction macroSinistra = macro.buildMacroInRegression((GroundAction) this.get(i), pd, pp, false);
                ret.add(macroSinistra);
                if (macroDestra != null) {
                    GroundAction macroDestraSinistra = macroDestra.buildMacroInRegression((GroundAction) this.get(i), pd, pp, false);
                    //System.out.println("#primitives: "+(j)+" aggregation time:" + (System.currentTimeMillis()-start));
                    ret.add(macroDestraSinistra);
                    macro = macroDestraSinistra;
                } else {
                    macro = macroSinistra;
                }
            } else {
                macro = macroDestra;
            }

        }
        return ret;
    }

    public Set<GroundAction> generateEverySubMacros() throws CloneNotSupportedException, Exception {
        TreeSet<GroundAction> ret = new TreeSet<GroundAction>();
        int n = 10000000;
        for (int i = 0; i < this.size() - 1; i++) {
            GroundAction macro = this.get(i).buildMacroInProgression(this.get(i + 1), pd, pp, false);
            ret.add(macro);
            int rightBound = Math.min(i + 2 + n, this.size());
            for (int j = i + 2; j < rightBound; j++) {
                macro = macro.buildMacroInProgression(this.get(j), pd, pp, false);
                ret.add(macro);
            }
        }
        return ret;
    }

    public Set<GroundAction> generateEverySubMacros(int upperBound) throws CloneNotSupportedException, Exception {
        TreeSet<GroundAction> ret = new TreeSet<GroundAction>();
        int n = 10;
        for (int i = 0; i < this.size() - 1; i++) {
            GroundAction macro = this.get(i).buildMacroInProgression(this.get(i + 1), pd, pp, false);
            addSubCondition(ret, macro, upperBound);
            int rightBound = Math.min(i + 2 + n, this.size());
            for (int j = i + 2; j < rightBound; j++) {
                macro = macro.buildMacroInProgression(this.get(j), pd, pp, false);
                addSubCondition(ret, macro, upperBound);
            }
        }
        return ret;
    }

    private void addSubCondition(TreeSet<GroundAction> ret, GroundAction macro, int upperBound) {
        if (ret.size() >= upperBound) {
            if (macro.getPrevDistanceFromProblem() < ret.last().getPrevDistanceFromProblem()) {
                ret.pollLast();
                ret.add(macro);
            }
        } else {
            ret.add(macro);
        }
    }

    public Set<GroundAction> generateEverySubMacros(int upperBound, int maxLength) throws CloneNotSupportedException, Exception {
        TreeSet<GroundAction> ret = new TreeSet<GroundAction>();

        for (int i = 0; i < this.size() - 1; i++) {
            GroundAction macro = this.get(i).buildMacroInProgression(this.get(i + 1), pd, pp, false);
            addSubCondition(ret, macro, upperBound);
            int rightBound = Math.min(i + 2 + maxLength, this.size());
            for (int j = i + 2; j < rightBound; j++) {
                macro = macro.buildMacroInProgression(this.get(j), pd, pp, false);
                addSubCondition(ret, macro, upperBound);
            }
        }
        return ret;
    }

    public Set generateMacrosSuffPrefInfissUniformely(int maxMacros) throws CloneNotSupportedException, Exception {
        TreeSet<GroundAction> ret = new TreeSet();
        TreeSet<GroundAction> ret1 = new TreeSet();
        TreeSet<GroundAction> ret2 = new TreeSet();
        int middle = this.size() / 2;
        int n = middle;

        GroundAction macroPlan = this.get(0);
        //prefix plans computation
        for (int j = 1; j <= n; j++) {
            macroPlan = macroPlan.buildMacroInProgression((GroundAction) this.get(j), this.pd, this.pp, true);
            addSubCondition(ret, macroPlan, maxMacros / 3);
        }
        //suffix plans computation
        macroPlan = this.get(this.size() - 1);
        //prefix plans computation
        for (int j = this.size() - 2; j > n; j--) {
            macroPlan = macroPlan.buildMacroInRegression((GroundAction) this.get(j), this.pd, this.pp, true);
            addSubCondition(ret1, macroPlan, maxMacros / 3);
        }
        //addSubCondition(ret1,allPlan.buildMacroInProgression(macroPlan, pd, pp),maxMacros/3);

        //System.out.println("!!!!!!!!!!  "+middle + " !!!!!!!!!!!!!!");
        GroundAction firstAct = (GroundAction) this.get(middle);
        GroundAction macro = (GroundAction) firstAct.clone();
        macro.simplifyModel(pd, pp);

        long start = System.currentTimeMillis();
        //prefix plans computation

        int up = (int) (((float) this.size() / 3.0) * 2.0);

        for (int j = middle + 1; j <= up; j++) {
            GroundAction macroDestra = null;

            if (j < this.size()) {
//               System.out.println(macro);
//               System.out.println(this.get(j));
                macroDestra = macro.buildMacroInProgression((GroundAction) this.get(j), pd, pp, true);
                addSubCondition(ret2, macroDestra, maxMacros / 3);
            }
            int i = (this.size() % 2 == 0) ? this.size() - j : this.size() - j - 1;
            //System.out.println("Aggiungo azioni da:" +middle+","+ j + " e da: "+i);
            if (i >= 0) {
                GroundAction macroSinistra = macro.buildMacroInRegression((GroundAction) this.get(i), pd, pp, true);
                addSubCondition(ret2, macroSinistra, maxMacros / 3);
                if (macroDestra != null) {
                    GroundAction macroDestraSinistra = macroDestra.buildMacroInRegression((GroundAction) this.get(i), pd, pp, true);
                    //System.out.println("#primitives: "+(j)+" aggregation time:" + (System.currentTimeMillis()-start));
                    addSubCondition(ret2, macroDestraSinistra, maxMacros / 3);
                    //System.out.println("macrodestrasinitra"+i+","+j);
                    //System.out.println(macroDestraSinistra);
                    macro = macroDestraSinistra;
                } else {
                    //System.out.println("macrosinitra");
                    macro = macroSinistra;
                }
            } else {
                //System.out.println("macrodestra");
                macro = macroDestra;
            }

        }

        HashSet union = new HashSet();
        union.addAll(ret);
        union.addAll(ret1);
        //union.addAll(ret2);

        return union;
    }

    public Set generateMacrosSuffPref(int maxMacros, boolean consideringNumericInformationInDistance) throws CloneNotSupportedException, Exception {
        TreeSet<GroundAction> ret = new TreeSet();
        TreeSet<GroundAction> ret1 = new TreeSet();
        int middle = this.size() / 2;
        int n = middle;

        GroundAction macroPlan = this.get(0);
        //prefix plans computation
        for (int j = 1; j <= n; j++) {
            macroPlan = macroPlan.buildMacroInProgression((GroundAction) this.get(j), this.pd, this.pp, consideringNumericInformationInDistance);
            addSubCondition(ret, macroPlan, maxMacros / 3);
        }
        //suffix plans computation
        macroPlan = this.get(this.size() - 1);
        //prefix plans computation
        for (int j = this.size() - 2; j > n; j--) {
            macroPlan = macroPlan.buildMacroInRegression((GroundAction) this.get(j), this.pd, this.pp, consideringNumericInformationInDistance);
            addSubCondition(ret1, macroPlan, maxMacros / 3);
        }
        //addSubCondition(ret1,allPlan.buildMacroInProgression(macroPlan, pd, pp),maxMacros/3);

        HashSet union = new HashSet();
        union.addAll(ret);
        union.addAll(ret1);

        return union;
    }

    /**
     * @return the macroEmployed
     */
    public int getEmployedMacro() {
        return employedMacro;
    }

    /**
     * @param macroEmployed the macroEmployed to set
     */
    public void setEmployedMacro(int macroEmployed) {
        this.employedMacro = macroEmployed;
    }

    public Float getValueObjectiveFunction(PddlProblem problem) throws CloneNotSupportedException {

        if (problem.getMetric() != null) {
            if (problem.getMetric().getMetExpr() != null) {
                //System.out.println(problem.getMetric().getMetExpr());
                if (problem.getMetric().getMetExpr().eval(this.execute(problem.getInit())) == null)
                    return new Float(this.size());
                return problem.getMetric().getMetExpr().eval(this.execute(problem.getInit())).getNumber();
            } else {
                return new Float(this.size());
            }
        } else {
            return new Float(this.size());
        }
    }

    public DirectedAcyclicGraph buildValidationStructures(State init, Conditions g) throws CloneNotSupportedException, Exception {
        DirectedAcyclicGraph po = new DirectedAcyclicGraph(DefaultEdge.class);
        po.addVertex(-1);
        //DirectedAcyclicGraph po = new DirectedAcyclicGraph();
        validationStructures = new IdentityHashMap();

        //Create a pseudo action for the goal, having null effects but precondition equal to the goal conditions
        GroundAction goal = new GroundAction("goal");
        goal.setPreconditions(g);
        goal.normalize();
        this.add(goal);
        long totalTimeSpentForChainSearch = 0;
        long totalStartingTimeChainSearchEvaluate = 0;
        //create init action from the initial state.
        GroundAction start = init.transformInAction();
        this.add(0, start);
        System.out.print("Building Validation Structure for : ");
        for (int i = 0; i < this.size(); i++) {
            GroundAction a = this.get(i);
            //System.out.println(a);
            if (!(a.getPreconditions() instanceof AndCond)) {
                System.out.println("Only AND conditions are supported");
                System.exit(-1);
            }
            //the following structure will contain all the sufficient actions for the execution of action i
            IdentityHashMap validationStructure = new IdentityHashMap();
            getValidationStructures().put(a, validationStructure);
            //System.out.print(+i+",");
            AndCond conds = (AndCond) a.getPreconditions();
            if (conds != null) {
                for (Object o : conds.sons) {
                    TreeSet<Integer> chain = new TreeSet();
                    Conditions c = (Conditions) o;
                    //Finding the numeric justification. This requires a local search in the space of actions which have been planned to be executed before i
                    //System.out.println("Looking for!:" + c );
//                            System.out.println("Numeric Failure!:" + c + " cannot be achieved?!");

                    if (c instanceof Comparison) {
                        boolean supported = false;
                        double best = -10000000000000.0;
                        boolean emptySS = false;
                        //System.out.println(c);
                        long startingTimeChainSearch = System.currentTimeMillis();
                        while (!supported && !emptySS) {
                            int indexBest = -1;
                            emptySS = true;
                            for (Integer z = 0; z < i; z++) {//find the element that satisfies the comparison. In case such element does not exist, take the ones maximizing the satisfaction of c
                                //System.out.println(z);
                                if (!chain.contains(z)) {//if it has not been selected previously
                                    chain.add(z);//add temporarly for evaluation reason
                                    long startingTimeChainSearchEvaluate = System.currentTimeMillis();
                                    double temp = evaluate(chain, z, i, (Comparison) c);//heuristic measuring how distant the comparison is
                                    totalStartingTimeChainSearchEvaluate += (System.currentTimeMillis() - startingTimeChainSearchEvaluate);
                                    //System.out.println("Temp:"+temp);
                                    if (temp >= 0) {//meaning that it is satisfied
                                        supported = true;
                                        indexBest = z;
                                    } else {//it is not satisfied but let us see if it has improved or not the previous chain set
                                        //System.out.println("Temp:"+temp+" Best:"+best);
                                        if (temp > best || indexBest == -1) {
                                            //System.out.println(temp);
                                            best = temp;
                                            indexBest = z;
                                        }
                                    }
                                    emptySS = false; //the search space has not been emptied yet
                                    chain.remove(z);//remove the temporary selection
                                    if (supported) {
                                        //System.out.println(c);
                                        //System.out.println(chain+" "+indexBest+"-->"+i);
                                        break;//exit in case when c is satisfied by chain
                                    }
                                }
                            }
                            if (!emptySS && indexBest != -1) {//if no improvment have been found then break the loop
                                if (indexBest != -1) {
                                //System.out.println("Selected"+indexBest);

                                    chain.add(indexBest);
                                }
                                //System.out.print("["+chain.size()+"],");
                            } else {
                                //System.out.println(c);
                                //System.out.println("this shouldn't happen");
                            }
                        }
                        totalTimeSpentForChainSearch += (System.currentTimeMillis() - startingTimeChainSearch);

                        if (supported) {
                            validationStructure.put(c, chain);
                            //System.out.println(chain+"-->"+i);
                        } else {

                            chain.add(-1);
                            po.addVertex(i);
                            po.addEdge(-1, i);
                            validationStructure.put(c, chain);
                            //System.out.println("Action: "+a);
                            System.out.println("Numeric Failure!:" + c + " cannot be achieved?!");
                        }
                    } else {
                        //for the propositional case the search is much simpler...
                        boolean supported = false;
                        if (c instanceof Predicate) {
                            Predicate p = (Predicate) c;

                            for (Integer z = 0; z < i; z++) {
                                //for (Integer z = i-1; z >=0 ; z--) {

                                if (this.get(z).achieve(p)) {
                                    //System.out.println("Candidate:" + z);
                                    boolean threat = false;
                                    for (int k = z + 1; k < i; k++) {
                                        //System.out.println(this.get(k));
                                        //System.out.println("checking for"+p);
                                        if (this.get(k).delete(p)) {
                                            //System.out.println("Threat:" + this.get(k));
                                            threat = true;
                                            break;
                                        }
                                    }
                                    if (!threat) {
                                        //System.out.println("Candidate ok");
                                        chain.add(z);
                                        supported = true;
                                        break;
                                    } else {
                                        //System.out.println("Candidate ko");
                                    }

                                }

                            }
                            //if (!supported){
                            if (false) {
                                for (Integer z = 0; z < 1; z++) {

                                    if (this.get(z).achieve(p)) {
                                        //System.out.println("Candidate:" + z);
                                        boolean threat = false;
                                        for (int k = z + 1; k < i; k++) {
                                            //System.out.println(this.get(k));
                                            //System.out.println("checking for"+p);
                                            if (this.get(k).delete(p)) {
                                                //System.out.println("Threat:" + this.get(k));
                                                threat = true;
                                                break;
                                            }
                                        }
                                        if (!threat) {
                                            //System.out.println("Candidate ok");
                                            chain.add(z);
                                            supported = true;
                                            break;
                                        } else {
                                            //System.out.println("Candidate ko");
                                        }

                                    }

                                }
                            }

                            if (supported) {
                                validationStructure.put(c, chain);
                                //System.out.println(chain+"-->"+i);
                            } else {
                                chain.add(-1);
                                po.addVertex(i);
                                validationStructure.put(c, chain);
                                po.addEdge(-1, i);
                                System.out.println("Propositional Failure!:" + c + " cannot be achieved?!");
                                //System.out.println("Failure");
                            }
                        } else if (c instanceof NotCond) {

                        }

                    }

                }
            }
        }

        //achieveGoal = goalAchievers(po);
        System.out.println("\nTIME FOR CHAIN SEARCH: " + totalTimeSpentForChainSearch);
        System.out.println("\nTIME FOR CHAIN SEARCH(Evaluation): " + totalStartingTimeChainSearchEvaluate);

        return po;
    }

    public DirectedAcyclicGraph deorder(State init, Conditions g, boolean computeGoalAchievers) throws CloneNotSupportedException, Exception {

        DirectedAcyclicGraph po = this.buildValidationStructures(init, g);
        if (computeGoalAchievers) {
            setGoalAchiever(this.goalAchievers(this.getValidationStructures()));
        }
        //this provides information on the missing constraint and/or prediction services

        System.out.println("\nValidation Structure Built. Now let us see which are the constraints that can be removed");

        //having found out the validation structure for an action, let us see now which are the ordering constraint that are really necessary
        //these two for emulate the total order inside the plan. 
        for (int i = 0; i < this.size() - 1; i++) {
            po.addVertex(i);//set in the graph representing the pop the action under examination
            for (int j = i + 1; j < this.size(); j++) {
                //int j=i+1;
                boolean preserveOrderConstraint = false;
                String Motivation = "Motivation: ";//Debug
                if (!po.vertexSet().contains(j)) {
                    po.addVertex(j);
                }
//                System.out.print("Ordering bewteen: ");
//                System.out.println(this.get(i));
//                System.out.println(this.get(j));

                //Firstly check if action i belongs to the validation structure of j
                AndCond condsJ = (AndCond) this.get(j).getPreconditions();
                if (condsJ != null) {
                    IdentityHashMap validationStructureForJ = (IdentityHashMap) getValidationStructures().get(this.get(j));
                    for (Object o : condsJ.sons) {
                        TreeSet<Integer> chain = (TreeSet) validationStructureForJ.get(o);
                        if (chain != null) {
                            //System.out.println("chain trovata");
                            if (chain.contains(i)) {
                                preserveOrderConstraint = true;
                                orderingByJustification++;
                                //Motivation += o.toString()+" (nelle giustificazioni)";
                                break;
                            }
                        }
                    }
                }
                //in case there is no justification for <i,j> let's see the implication of removing <i,j>

                if (!preserveOrderConstraint) {
                    //in this case I see if putting j before i can harm the consistency of the plan
                    AndCond conds = (AndCond) this.get(i).getPreconditions();
                    if (conds != null) {
                        IdentityHashMap validationStructure = (IdentityHashMap) getValidationStructures().get(this.get(i));
                        //System.out.println(validationStructure);
                        for (Object o : conds.sons) {
                            TreeSet<Integer> chain = (TreeSet) validationStructure.get(o);
                            //I guess the following is useless cause it is dominated by the check performed above
                            if (chain != null) {
                                //System.out.println("chain trovata");
                                if (chain.contains(j)) {
                                    preserveOrderConstraint = true;
                                    orderingByStrangeness++;
                                    System.out.println("Strange Situations!!");
                                    break;
                                }
                            }
                            if (o instanceof Predicate) {
                                Predicate p = (Predicate) o;
                                if (this.get(j).delete(p)) {
                                    preserveOrderConstraint = true;
                                    orderingByPropositionalThreatBack++;
                                    Motivation += o.toString() + " (minaccia Predicate)";
                                    break;
                                }

                            } else {
                                if (o instanceof Comparison) {
                                    Comparison c = (Comparison) o;
                                    HashSet<NumFluent> toTest = new HashSet(c.getLeft().fluentsInvolved());
                                    toTest.addAll(c.getRight().fluentsInvolved());
                                    if (c.couldBePrevented(computeFluentDependencePlanDependant(toTest), this.get(j))) {
                                        preserveOrderConstraint = true;
                                        orderingByNumericThreatBack++;
                                        Motivation += o.toString() + " (i minaccia la condizione numerico per cui j esiste)";
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                if (!preserveOrderConstraint) {
                    AndCond conds = (AndCond) this.get(i).getPreconditions();
                    for (int k = j + 1; k < this.size(); k++) {
                        IdentityHashMap validationStructure = (IdentityHashMap) getValidationStructures().get(this.get(k));
                        conds = (AndCond) this.get(k).getPreconditions();

                        if (conds != null) {
                            for (Object o : conds.sons) {
                                if (o instanceof Predicate) {
                                    Predicate p = (Predicate) o;
                                    TreeSet<Integer> chain = (TreeSet) validationStructure.get(p);
                                    if (chain != null) {
                                        if (chain.contains(j)) {
                                            if (this.get(i).delete(p)) {
                                                preserveOrderConstraint = true;
                                                orderingByThreatPropositionForward++;
                                                Motivation += o.toString() + " (i minaccia la condizione proposizionale per cui j esiste)";
                                            }
                                            break;
                                        }
                                    } else {
                                        //System.out.println("Add some actions for:"+p);
                                    }
                                } else {
                                    if (o instanceof Comparison) {
                                        Comparison c = (Comparison) o;
                                        TreeSet<Integer> chain = (TreeSet) validationStructure.get(c);
                                        if (chain != null) {
                                            if (chain.contains(j)) {
                                                HashSet<NumFluent> toTest = new HashSet(c.getLeft().fluentsInvolved());
                                                toTest.addAll(c.getRight().fluentsInvolved());
                                                if (c.couldBePrevented(computeFluentDependencePlanDependant(toTest), this.get(i))) {
                                                    preserveOrderConstraint = true;
                                                    orderingByThreatNumericForward++;
                                                    Motivation += o.toString() + " (i minaccia la condizione numerica per cui j esiste)";
                                                }
                                                break;
                                            }
                                        } else {
                                            //System.out.println("Add some actions for:"+c);
                                        }
                                    }
                                }
                            }
                        }

                    }

                }
                if (preserveOrderConstraint) {
                    po.addEdge(i, j);
                    //System.out.println("<" + i + "," + j + ">");
                    //System.out.println(Motivation);
                }
            }
        }

//        for (Object v1 : po.vertexSet()) {
//            for (Object v2 : po.vertexSet()) {
//                for (Object v3 : po.vertexSet()) {
//
//                }
//            }
//        }
//       
//        System.out.println("DEBUG. Ordering preserved for different reasons.of which:\n for VD: " + this.orderingByJustification
//                + "\n for propositional treath backward:" + this.orderingByPropositionalThreatBack
//                + "\n for numeric treath backward:" + this.orderingByNumericThreatBack
//                + "\n for propositional treath forward:" + this.orderingByThreatPropositionForward
//                + "\n for numeric treath forward:" + this.orderingByThreatNumericForward);
        //System.out.println("Flexibility: " + computeFlexibility(po));
        //removeIndirectOrdering(po);
        return po;
    }

    private double evaluate(TreeSet<Integer> chain, Integer z, int i, Comparison c) throws CloneNotSupportedException {

        //System.out.println("Candidate:"+chain);
        State tempInit = new State();
        for (Integer index : chain) {
            tempInit = this.get(index).apply(tempInit);
            if (tempInit == null) {
                return -100000000000000.0;
            }
        }

        Float d = tempInit.distance(c);

        if (false) {
            return d;
        }

        if (d < 0) {
            return d;//this chain does not suffice to satisfy the condition.
        }
        tempInit = new State();

//        System.out.println("Condition under examination: "+c);
//        System.out.println("Candidates:"+chain);
//        System.out.println("Condition Distance "+d);
        for (int j = chain.first(); j < i; j++) {
            //if (c.couldBePrevented(computeFluentDependencePlanDependant(toTest), this.get(j))){
            //System.out.println("Entrando");
            if (chain.contains(j)) {
                this.get(j).apply(tempInit);

                d = tempInit.distance(c);
                    //System.out.println("");

            } //
            else {
                HashSet<NumFluent> toTest = new HashSet(c.getLeft().fluentsInvolved());
                toTest.addAll(c.getRight().fluentsInvolved());
                if (c.isDirectlyOrIndirectlyAffected(computeFluentDependencePlanDependant(toTest), this.get(j))) {

                        //State temp = (State) tempInit.clone();
                    //get(j).apply(temp);
                    State temp = get(j).partialApply(tempInit, toTest);
                        //State temp = tempInit;
                    //get(j).apply(temp);
                    Float t = temp.distance(c);
                    //System.out.println(t);
                    if (t < d) {
                        //                    System.out.println("Considering the implication of"+this.get(j));
                        d = t;

                    }
                    //distances can be not monotonic. So I have to keep trace of the current state
                    tempInit.updateValues(toTest, temp);
                }

            }

//            else {
//                //State temp = (State) tempInit.clone();
//                get(j).apply(tempInit);
//                Float t = tempInit.distance(c);
//
//                if (t < d) {
////                    System.out.println("Considering the implication of"+this.get(j));
//                    d = t;
//                    //tempInit = temp;
//                }
//
//            }
//            System.out.println("Current Distance:"+d);
            //}
        }
        //System.out.println("Distance with negative interactions!:"+d);

        return d;
    }

    private Float computeFlexibility(DirectedAcyclicGraph po) {
        int ret = 0;
        //System.out.println(po);

        DirectedAcyclicGraph po1 = new DirectedAcyclicGraph(DefaultEdge.class);

        for (Object v1 : po.vertexSet()) {
            po1.addVertex(v1);
        }
        for (Object v1 : po.vertexSet()) {
            for (Object v2 : po.vertexSet()) {
                if (po.getEdge(v1, v2) != null) {
                    po1.addEdge(v1, v2);
                }
            }
        }

        for (Object v1 : po1.vertexSet()) {
            for (Object v2 : po1.vertexSet()) {
                for (Object v3 : po1.vertexSet()) {
                    //System.out.println("v1:"+v1+" v2:"+v2+" v1:"+v3);
                    if ((po1.getEdge(v1, v2) != null) && (po1.getEdge(v2, v3) != null)) {
//                        System.out.println("yes");
                        po1.addEdge(v1, v3);
                    }
                }
            }
        }
        //System.out.println(po);

        for (Object v1 : po1.vertexSet()) {
//            System.out.print("in("+v1+") "+po.inDegreeOf(v1));
//            System.out.println(" out("+v1+"):"+po.outDegreeOf(v1));
            for (Object v2 : po1.vertexSet()) {

//                System.out.println("v1:"+v1+" v2:"+v2);
                if ((po1.getEdge(v1, v2) == null) && (po1.getEdge(v2, v1) == null) && (v1 != v2)) {
                    //System.out.println("DEBUG");
                    ret = ret + 1;
                }
            }

        }

        return (float) ret / (float) size();
    }

    private void removeIndirectOrdering(DirectedAcyclicGraph po1) {

        for (Object v1 : po1.vertexSet()) {
            for (Object v2 : po1.vertexSet()) {
                for (Object v3 : po1.vertexSet()) {
                    if (po1.containsEdge(v1, v3) && po1.containsEdge(v1, v2) && po1.containsEdge(v2, v3)) {
                        po1.removeEdge(v1, v3);
                    }

                }
            }

        }

    }

    private HashMap<NumFluent, HashSet<NumFluent>> computeFluentDependencePlanDependant(HashSet<NumFluent> nfSet) {

//         if (fluentDependencyChain==null)
//            fluentDependencyChain = new HashMap();
//         else
//             return fluentDependencyChain;
        fluentDependencyChain = new HashMap();
        for (NumFluent nf : nfSet) {
            for (GroundAction ac : this) {
                if (ac.influence(nf)) {
                    if (fluentDependencyChain.get(nf) != null) {
                        HashSet<NumFluent> cD = fluentDependencyChain.get(nf);

                        cD.addAll(ac.influencedBy(nf));

                    } else {
                        fluentDependencyChain.put(nf, (HashSet<NumFluent>) ac.influencedBy(nf));
                    }
                }
            }
        }
        return fluentDependencyChain;

    }

    public String toStringWithIndex() {
        String ret_val = "";

        for (int i = 0; i < this.size(); i++) {
            ret_val = ret_val.concat(i + "-" + this.get(i).toEcoString() + "\n");
        }

        return ret_val;

    }

    public List generateMacrosFromPop(DirectedAcyclicGraph po, HashMap achieveGoal, boolean missingServicesCut, boolean biconnectivity, boolean goalthreatCut) throws Exception {

        List result = new ArrayList();

        Set<Integer> splittingSet = new HashSet();

        if (missingServicesCut) {
            splittingSet = takeSplittingPointFromMissingServices(po);
        } else {
            po.removeEdge(po.edgesOf(-1));
            po.removeVertex(-1);
        }
        System.out.println("After Missing Services Cut:" + splittingSet.size());
        if (goalthreatCut) {
            splittingSet.addAll(takeSplittingPointFromActionsGoalThreat());
        }
        System.out.println("After Goal Threats Cut:" + splittingSet.size());
        setConnectedSetBuilder(new ConnectivityInspector<Object, Object>(po));

        if (biconnectivity) {
            //Set temp = new HashSet();
            if (this.getConnectedSetBuilder().connectedSets().size() < 4) {
                performBesttCut(po);
            }
            //System.out.println("Rimozioni"+(counter));
            //System.out.println("Connected Components:"+a.connectedSets().size());
        }

        //System.out.println("Splittingset to use:"+splittingSet);
        for (Set s : getConnectedSetBuilder().connectedSets()) {
            TreeSet<Integer> ordered = new TreeSet(s);
            //System.out.println("Trying to Merge"+ordered);
            GroundAction macro = null;
            for (Integer v : ordered) {
                //System.out.println("Appending:"+v);
                if (splittingSet.contains(v)) {
                    //System.out.println("Found an action that should be splitted (if any:"+v);
                    if (macro != null) {
                        if (macro.getName() != null) {
                            //System.out.println("Action Splitting:"+v);
                            //System.out.println(macro);
                            if (macro.getPrimitives().size() >= 2) {
                                result.add(macro);
                            }
                            macro = null;//this way the next macro will start from scratch
                        }
                    }
                }
                //if it is the first action or it is a splittingpoint (consequence of the step above
                if (macro == null) {
                    macro = (GroundAction) this.get(v);
                    macro.setIsMacro(true);
                    macro.getPrimitives().add(this.get(v));
                } else {
                    //append to previous computed action
                    macro = macro.buildMacroInProgression(this.get(v), this.pd, this.pp, false);
                }
                //
                if (achieveGoal != null) {
                    if (achieveGoal.get(v) != null) {
                        //System.out.println("Goal Achiever:"+v);
                        if (macro != null) {
                            if (macro.getName() != null) {
                             //System.out.println("Goal Achiever Splitting:"+v);
                                //System.out.println(macro);
                                if (macro.getPrimitives().size() >= 2) {
                                    result.add(macro);
                                }
                                macro = null;
                            }
                        }
                    }
                }
            }
            if (macro != null) {
                if (macro.getName() != null) {
                    //System.out.println("Merged");
                    if (macro.getPrimitives().size() >= 2) {
                        result.add(macro);
                    }
                }
            }
        }

        System.out.println("Number of Connected Components:" + getConnectedSetBuilder().connectedSets().size());
        System.out.println("Number of Macros Generated:" + result.size());
        return result;
    }

    private void removeLargerProducer(DirectedAcyclicGraph po) {

        Object producer = null;

        int maxProducer = 0;

        for (Object o : po.vertexSet()) {

            if (po.outDegreeOf(o) > maxProducer) {
                producer = o;
                maxProducer = po.outDegreeOf(o);
            }

        }
        if (producer != null) {
            Set s = new HashSet();
            for (Object edge : po.outgoingEdgesOf(producer)) {
                s.add(edge);
            }
            for (Object edge : po.incomingEdgesOf(producer)) {
                s.add(edge);
            }
            po.removeAllEdges(s);
        }

    }

    private void removeLargerAbsorberLargerProducer(DirectedAcyclicGraph po) {
        Object absorber = null;
        Object producer = null;
        int maxAbsorber = 0;
        int maxProducer = 0;

        for (Object o : po.vertexSet()) {
            if (po.inDegreeOf(o) > maxAbsorber) {
                absorber = o;
                maxAbsorber = po.inDegreeOf(o);
            }
            if (po.outDegreeOf(o) > maxProducer) {
                producer = o;
                maxProducer = po.outDegreeOf(o);
            }

        }
        if (absorber != null) {
            Set s = new HashSet();
            for (Object edge : po.incomingEdgesOf(absorber)) {
                s.add(edge);
            }
            po.removeAllEdges(s);
        }
        if (producer != null) {
            Set s = new HashSet();
            for (Object edge : po.outgoingEdgesOf(producer)) {
                s.add(edge);
            }
            po.removeAllEdges(s);
        }

    }

    private Set<Integer> takeSplittingPointFromMissingServices(DirectedAcyclicGraph po) {

        Set<Integer> ret = new HashSet();

        for (Object edge : po.outgoingEdgesOf(-1)) {
            ret.add((Integer) po.getEdgeTarget(edge));
        }

        po.removeEdge(po.edgesOf(-1));
        po.removeVertex(-1);

        return ret;

    }

    public DirectedAcyclicGraph removeInitGoal(DirectedAcyclicGraph po) {
        po.removeEdge(po.edgesOf(0));
        //po.removeEdge(po.edgesOf(po.vertexSet().size() -1));
        po.removeEdge(po.edgesOf(this.size() - 1));

        po.removeVertex(0);
//        po.removeVertex(po.vertexSet().size() - 1);
        po.removeVertex(this.size() - 1);

        return po;

    }

    private GroundAction appendMacro(GroundAction macro, GroundAction get) throws Exception {
                //GroundAction firstAct = (GroundAction) this.get(firstActionIndex);

            //get.normalize();
        if (macro == null) {
            macro = new GroundAction();
        }

        macro = macro.buildMacroInProgression(get, this.pd, this.pp, false);
            //System.out.println(macro);

        return macro;
    }

    private void performBesttCut(DirectedAcyclicGraph po) {

        int best = 0;
        Object bestID = null;
        int size = po.vertexSet().size();

        for (int k = 1; k < size; k++) {

            DirectedAcyclicGraph po1 = (DirectedAcyclicGraph) po.clone();
            Set s = new HashSet();
            for (Object edge : po.outgoingEdgesOf(k)) {
                s.add(edge);
            }
            for (Object edge : po.incomingEdgesOf(k)) {
                s.add(edge);
            }
            po1.removeAllEdges(s);

            this.connectedSetBuilder = new ConnectivityInspector<Object, Object>(po1);
            if (connectedSetBuilder.connectedSets().size() > best) {
                best = connectedSetBuilder.connectedSets().size();
                bestID = k;
                //System.out.println(best);

            }

        }

        System.out.println(bestID);

        Set s = new HashSet();
        for (Object edge : po.outgoingEdgesOf(bestID)) {
            s.add(edge);
        }
        for (Object edge : po.incomingEdgesOf(bestID)) {
            s.add(edge);
        }
        po.removeAllEdges(s);

        return;

    }

    private void performBesttCut2(DirectedAcyclicGraph po) {

        int best = 0;
        Object bestID = null;
        int size = po.vertexSet().size();

        for (int k = 1; k < size; k++) {

            DirectedAcyclicGraph po1 = (DirectedAcyclicGraph) po.clone();
            Set s = new HashSet();
            for (Object edge : po.outgoingEdgesOf(k)) {
                s.add(edge);
            }
            for (Object edge : po.incomingEdgesOf(k)) {
                s.add(edge);
            }
            po1.removeAllEdges(s);

            this.connectedSetBuilder = new ConnectivityInspector<Object, Object>(po1);
            if (connectedSetBuilder.connectedSets().size() > best) {
                best = connectedSetBuilder.connectedSets().size();
                bestID = k;
                System.out.println(best);

            }

        }

        Set s = new HashSet();
        for (int k = 0; k < (Integer) bestID; k++) {
            s.add(k);
        }

        po.removeAllVertices(s);

        return;

    }

    private HashMap goalAchievers(IdentityHashMap vs) {

        HashMap ret = new HashMap();
        int goalIndex = this.size() - 1;
        for (int i = 1; i < this.size() - 1; i++) {
            AndCond condsJ = (AndCond) this.get(goalIndex).getPreconditions();
            if (condsJ != null) {
                IdentityHashMap validationStructureForJ = (IdentityHashMap) vs.get(this.get(goalIndex));
                for (Object o : condsJ.sons) {
                    TreeSet<Integer> chain = (TreeSet) validationStructureForJ.get(o);
                    if (chain != null) {
                        //System.out.println("chain trovata");
                        if (chain.contains(i)) {
                            ret.put(i, true);
                        }
                    }
                }
            }
        }

        return ret;

    }

    /**
     * @return the validationStructures
     */
    public IdentityHashMap getValidationStructures() {
        return validationStructures;
    }

    public List generateMacrosFromPop2(DirectedAcyclicGraph po, HashMap achieveGoal, Set cutpoints, boolean missingServicesCut) throws Exception {

        List result = new ArrayList();

        //System.out.println(po);
        //System.out.println(achieveGoal);
        Set<Integer> splittingSet = cutpoints;
        if (missingServicesCut) {
            cutpoints.addAll(takeSplittingPointFromMissingServices(po));
        } else {
            po.removeEdge(po.edgesOf(-1));
            po.removeVertex(-1);
        }
        this.connectedSetBuilder = new ConnectivityInspector<Object, Object>(po);

        //Set temp = new HashSet();
        //if (a.connectedSets().size()<4)    
        // a =performBesttCut(po,a);
        //System.out.println("Rimozioni"+(counter));
        //System.out.println("Connected Components:"+a.connectedSets().size());
        //System.out.println("Splittingset to use:"+splittingSet);
        for (Set s : connectedSetBuilder.connectedSets()) {
            TreeSet<Integer> ordered = new TreeSet(s);
            //System.out.println("Trying to Merge"+ordered);
            GroundAction macro = null;
            for (Integer v : ordered) {
                //System.out.println("Appending:"+v);
                if (splittingSet.contains(v)) {
                    System.out.println("Found an action that should be splitted (if any:" + v);
                    if (macro != null) {
                        if (macro.getName() != null) {
                            System.out.println("Action Splitting:" + v);
                            //System.out.println(macro);
                            if (macro.getPrimitives().size() >= 2) {
                                result.add(macro);
                            }
                            macro = null;
                        }
                    }
                }
                if (macro == null) {
                    macro = (GroundAction) this.get(v);
                    macro.setIsMacro(true);
                    macro.getPrimitives().add(this.get(v));
                } else {
                    macro = macro.buildMacroInProgression(this.get(v), this.pd, this.pp, false);
                }
                    //System.out.println("#primitives: " + macro.getPrimitives().size());

                    //macro = macro.buildMacroInProgression(this.get(v), pd);
                //macro.normalize();
                if (achieveGoal != null) {
                    if (achieveGoal.get(v) != null) {
                        System.out.println("Goal Achiever:" + v);
                        if (macro != null) {
                            if (macro.getName() != null) {
                                System.out.println("Goal Achiever Splitting:" + v);
                                //System.out.println(macro);
                                if (macro.getPrimitives().size() >= 2) {
                                    result.add(macro);
                                }
                                macro = null;
                            }
                        }
                    }
                }

            }
            if (macro != null) {
                if (macro.getName() != null) {
                    //System.out.println("Merged");
                    if (macro.getPrimitives().size() >= 2) {
                        result.add(macro);
                    }
                }
            }
        }

        System.out.println("Number of Connected Components:" + connectedSetBuilder.connectedSets().size());

        System.out.println("Number of Macros Generated:" + result.size());

        return result;
    }

    /**
     * @return the connectedSetBuilder
     */
    public ConnectivityInspector<Object, Object> getConnectedSetBuilder() {
        return connectedSetBuilder;
    }

    /**
     * @param connectedSetBuilder the connectedSetBuilder to set
     */
    public void setConnectedSetBuilder(ConnectivityInspector<Object, Object> connectedSetBuilder) {
        this.connectedSetBuilder = connectedSetBuilder;
    }

    private void setGoalAchiever(HashMap goalAchievers) {
        this.goalAchiever = goalAchievers;

    }

    public HashMap getGoalAchiever() {
        return this.goalAchiever;
    }

    private Collection<? extends Integer> takeSplittingPointFromActionsGoalThreat() throws CloneNotSupportedException {
        Set ret = new HashSet();
        for (int i = 1; i < this.size() - 1; i++) {
            GroundAction gr = this.get(i);
            if (gr.threatGoalConditions(this.pp.getGoals(), this, i, this.pp.getInit())) {
                ret.add(i);
            }
        }
        return ret;

    }

    public boolean entangledByInit(String name, State init, Conditions con) {
        for (GroundAction gr : this) {
            if (gr.getName().equals(name)) {
                AndCond ac = (AndCond) gr.getPreconditions();
                Conditions instanceOfCon = ac.requireAnInstanceOf(con);
                if (instanceOfCon != null) {
                    if (!instanceOfCon.isSatisfied(init)) {
                        //System.out.println(instanceOfCon+"  is NOT satisfied by Init");
                        return false;
                    } else {
                        //System.out.println(instanceOfCon+"  is  satisfied by Init");
                    }
                } else {
                    System.out.println(con + " has no instance in " + gr.getName());
                    return false;
                }
            }
        }
        return true;
    }

    public int entangledByInitCounter(String name, State init, Conditions con) {

        int numberOfHoldings = 0;

        for (GroundAction gr : this) {
            if (gr.getName().equals(name)) {
                AndCond ac = (AndCond) gr.getPreconditions();
                Conditions instanceOfCon = ac.requireAnInstanceOf(con);
                if (instanceOfCon != null) {
                    if (!instanceOfCon.isSatisfied(init)) {
                        //System.out.println(instanceOfCon+"  is NOT satisfied by Init");
                    } else {
                        numberOfHoldings++;
                    }
                } else {
                    System.out.println(con + " has no instance in " + gr.getName());
                    return -1;
                }
            }
        }
        return numberOfHoldings;
    }

    public boolean entangledByGoal(String name, Conditions goal, Conditions con) {

        for (GroundAction gr : this) {
            if (gr.getName().equals(name)) {
                AndCond ac = (AndCond) gr.getAddList();
                Predicate p = ac.requireAnInstanceOfAndWhichis(con);
                if (p != null) {
                    if (!goal.sons.contains(p)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public int countOccurenceOf(String name) {
        int counter = 0;
        for (GroundAction gr : this) {
            if (gr.getName().equals(name)) {
                counter++;
            }
        }
        return counter;
    }

    public int entangledByGoalCounter(String name, Conditions goal, Conditions con) {
        int counter = 0;

        for (GroundAction gr : this) {
            if (gr.getName().equals(name)) {
                AndCond ac = (AndCond) gr.getAddList();
                Predicate p = ac.requireAnInstanceOfAndWhichis(con);
                if (p != null) {
                    if (!goal.sons.contains(p)) {

                    } else {
                        counter++;
                    }
                } else {
                    System.out.println(con + " has no instance in " + gr.getName());
                    return -1;
                }
            }
        }
        return counter;
    }

    public void addActionsFromPartialOrder(Set actionsOfThePlan) {

    }

    public State execute(State init, HashSet globalConstraintSet) throws CloneNotSupportedException {
        State temp = init.clone();
        int i=0;
        for (GroundAction gr : (ArrayList<GroundAction>) this) {
            for (GlobalConstraint constr: (Collection<GlobalConstraint>)globalConstraintSet){
                    if (!temp.satisfy(constr.condition)){
                        System.out.println("Global Constraint is not satisfied:"+constr.name);
                        return temp;
                    }
                    // MRJ: Meant for debugging
                    //System.out.println(constr.condition.pddlPrint(false));
                      
            } 
            if (gr.isApplicable(temp)) {
                i++;
                // MRJ: Prints the state, meant for debugging
                //System.out.println(temp.pddlPrint());
                temp = gr.apply(temp);

                if (debug >1){
                    System.out.println(gr.getName()+" action has been applied");
                    System.out.println(temp.pddlPrint());
                }
                //System.out.println("in-at"+ temp.printFluentByName("in-at"));
            } else {
                if (debug > 1){
                    System.out.println(gr.toEcoString() + "is not applicable");
                    System.out.println("Step:"+i);
                    
                    //AndCond c= (AndCond)gr.getPreconditions();
                    System.out.println(temp.pddlPrint());

                    System.out.println(temp.whatIsNotsatisfied((AndCond)gr.getPreconditions()));
                }
                return temp;
            }
        }
        return temp;    
    }

    public List generateMacrosFromBlocks(List blocks) throws Exception {
        List result = new ArrayList();

        for (List s : (List<List>)blocks) {
            TreeSet<Integer> ordered = new TreeSet(s);
            //System.out.println("Trying to Merge"+ordered);
            GroundAction macro = null;
//            System.out.println("Building Macro");
            if (s.size()<=1)
                continue;
            for (Integer v : (Collection<Integer>)s) {
                //if it is the first action or it is a splittingpoint (consequence of the step above
//                System.out.print(" "+v);
                if (macro == null) {
                    macro = (GroundAction) this.get(v-1);
                    macro.setIsMacro(true);
                    macro.getPrimitives().add(this.get(v-1));
                    //macro.getPrimitivesWithInteger().add(v-1);
                } else {
                    //append to previous computed action
                    macro = macro.buildMacroInProgression(this.get(v-1), this.pd, this.pp, false);
                }
            }
//            System.out.println("");

            result.add(macro);
        }
        return result;
    }


}

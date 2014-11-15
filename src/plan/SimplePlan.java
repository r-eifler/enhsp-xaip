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
import conditions.NumFluentAssigner;
import conditions.Comparison;
import conditions.Conditions;
import conditions.PDDLObject;
import conditions.Predicate;
import domain.ActionParametersAsTerms;
import domain.ActionSchema;
import domain.PddlDomain;
import domain.Variable;
import expressions.Expression;
import expressions.NumEffect;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    
    public SimplePlan(PddlDomain dom) {
        super();
        pd = dom;
        
        invariantAnalysis = false;
        employedMacro=0;
    }

    public SimplePlan(PddlDomain dom, PddlProblem prob) {
        super();
        pd = dom;
        pp = prob;
        invariantAnalysis = true;
        employedMacro=0;
    }

    public int distance(SimplePlan a) {
        int d = 0;

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

    public SimplePlan(PddlDomain a, PddlProblem p, boolean b) {
        super();
        pd = a;
        pp = p;
        invariantAnalysis = b;
        employedMacro=0;
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
    public void putAction(String actionName, ActionParametersAsTerms par) {



        ActionSchema action = pd.getActionByName(actionName);
        if (action == null) {
            System.out.println("azione non trovata!!" + actionName);
        }
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
                if (temp.matches("[(][^)]++[)]")){
                    s1 = temp;
                }else
                    s1 = sc.findInLine("[(][^)]++[)]");
                //if (!(sc.next().charAt(0) == ';')) &&{
                //System.out.println("Primo carattere:" + );
                if (s1 != null) {
                    ActionParametersAsTerms pars = new ActionParametersAsTerms();
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
                            Variable v = (Variable)a.getParameters().get(objectCounter);
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
                if (temp.matches("[(][^)]++[)]")){
                    s1 = temp;
                }else
                    s1 = sc.findInLine("[(][^)]++[)]");
                //if (!(sc.next().charAt(0) == ';')) &&{
                //System.out.println("Primo carattere:" + );
                if (s1 != null) {
                    ActionParametersAsTerms pars = new ActionParametersAsTerms();
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




        if (invariantAnalysis) {
            this.invariantFluents = new HashMap();
            for (Object anAction : this) {
                GroundAction a = (GroundAction) anAction;
                for (Object o2 : a.getNumericFluentAffected()) {
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
            for (Object o2 : a.getNumericFluentAffected()) {
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
            if (con !=null){
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

            if (eff != null){
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


            Conditions con = a.getPreconditions();
            Conditions eff = a.getNumericEffects();
//                    System.out.println(con);
//                    System.out.println(eff);
            if (con != null){
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

            if (eff != null){
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
                    System.err.println("Effects of the type: " + eff.getClass());

                    throw new UnsupportedOperationException("Not supported yet.");
                }
            
            }
            a.normalize();
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
        if (lastActionIndex > firstActionIndex){
            GroundAction macroPlan = (GroundAction) this.get(firstActionIndex);
            macroPlan.setIsMacro(true);
            macroPlan.getPrimitives().add(this.get(firstActionIndex));

            long start = System.currentTimeMillis();
            for (int j = firstActionIndex + 1; j <= lastActionIndex; j++) {
                macroPlan = macroPlan.buildMacroInProgression((GroundAction) this.get(j),this.pd, this.pp,false);
            }
            System.out.println("#primitives: " + macroPlan.getPrimitives().size() + " aggregation time:" + (System.currentTimeMillis() - start));
            return macroPlan;
        }else{
            return null;
        }
        
    }

    public State execute(State init) {
        try {
            State temp = init.clone();
            for (GroundAction gr : (ArrayList<GroundAction>) this) {
                if (gr.isApplicable(temp)) {
                    temp = gr.apply(temp);
                    //System.out.println(gr.getName()+" action has been applied");
                    //System.out.println("in-at"+ temp.printFluentByName("in-at"));
                } else {
                    System.out.println(gr.toEcoString()+"is not applicable");
                    return temp;
                }
            }
            return temp;
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(SimplePlan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public TreeSet<GroundAction> generateMacrosSuffandPref() throws CloneNotSupportedException, Exception {
        TreeSet<GroundAction> ret = new TreeSet();
        GroundAction macroPlan = new GroundAction();
        //prefix plans computation
        for (int j = 0; j < this.size(); j++) {
            macroPlan = macroPlan.buildMacroInProgression((GroundAction) this.get(j), this.pd, this.pp,false);
            ret.add(macroPlan);
        }
        //suffix plans computation
       macroPlan = new GroundAction();
        //prefix plans computation
        for (int j = this.size() - 2; j > 0; j--) {
            macroPlan = macroPlan.buildMacroInRegression((GroundAction) this.get(j), this.pd, this.pp,false);
            ret.add(macroPlan);
        }
        return ret;
    }
    public TreeSet<GroundAction> generateMacrosSuffPrefInfiss(int minLength) throws CloneNotSupportedException, Exception {
        TreeSet<GroundAction> ret = new TreeSet();
        GroundAction macroPlan = this.get(0);
        //prefix plans computation
        for (int j = 1; j < this.size(); j++) {
            macroPlan = macroPlan.buildMacroInProgression((GroundAction) this.get(j), this.pd, this.pp,false);
            if (macroPlan.getPrimitives().size()>=minLength)
                ret.add(macroPlan);
        }
        //suffix plans computation
       macroPlan = this.get(this.size()-1);
        //prefix plans computation
        for (int j = this.size()-2; j > 0; j--) {
            macroPlan = macroPlan.buildMacroInRegression((GroundAction) this.get(j),this.pd, this.pp,false);
            if (macroPlan.getPrimitives().size()>=minLength)
                ret.add(macroPlan);
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
                macroDestra = macro.buildMacroInProgression((GroundAction) this.get(j), pd, pp,false);
                if (macroDestra.getPrimitives().size()>=minLength)
                    ret.add(macroDestra);
            }
            int i = (this.size() % 2 == 0) ? this.size() - j : this.size() - j - 1;
            //System.out.println("Aggiungo azioni da:" +middle+","+ j + " e da: "+i);
            if (i >= 0) {
                GroundAction macroSinistra = macro.buildMacroInRegression((GroundAction) this.get(i), pd, pp,false);
                if (macroSinistra.getPrimitives().size()>=minLength)
                    ret.add(macroSinistra);
                if (macroDestra != null) {
                    GroundAction macroDestraSinistra = macroDestra.buildMacroInRegression((GroundAction) this.get(i),pd, pp,false);
                    //System.out.println("#primitives: "+(j)+" aggregation time:" + (System.currentTimeMillis()-start));
                    if (macroDestraSinistra.getPrimitives().size()>=minLength)
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
                if (temp.matches("[(][^)]++[)]")){
                    prima = true;
                    s1 = temp;
                }else
                    s1 = sc.findInLine("[(][^)]++[)]");
                
//                else
//                    s1 = sc.findInLine("[(][^)]++[)]");
               
                //if (!(sc.next().charAt(0) == ';')) &&{
                //System.out.println("Primo carattere:" + );
                if (s1 != null) {
                    ActionParametersAsTerms pars = new ActionParametersAsTerms();
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
                            ArrayList primitives = (ArrayList)macroToPrimitives.get(nameOperator);
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
                macroDestra = macro.buildMacroInProgression((GroundAction) this.get(j), pd, pp,false);
                ret.add(macroDestra);
            }
            int i = (this.size() % 2 == 0) ? this.size() - j : this.size() - j - 1;
            //System.out.println("Aggiungo azioni da:" +middle+","+ j + " e da: "+i);
            if (i >= 0) {
                GroundAction macroSinistra = macro.buildMacroInRegression((GroundAction) this.get(i), pd, pp,false);
                ret.add(macroSinistra);
                if (macroDestra != null) {
                    GroundAction macroDestraSinistra = macroDestra.buildMacroInRegression((GroundAction) this.get(i), pd, pp,false);
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
            GroundAction macro = this.get(i).buildMacroInProgression(this.get(i + 1), pd, pp,false);
            ret.add(macro);
            int rightBound = Math.min(i + 2 + n, this.size());
            for (int j = i + 2; j < rightBound; j++) {
                macro = macro.buildMacroInProgression(this.get(j), pd, pp,false);
                ret.add(macro);
            }
        }
        return ret;
    }

    public Set<GroundAction> generateEverySubMacros(int upperBound) throws CloneNotSupportedException, Exception {
        TreeSet<GroundAction> ret = new TreeSet<GroundAction>();
        int n = 10;
        for (int i = 0; i < this.size() - 1; i++) {
            GroundAction macro = this.get(i).buildMacroInProgression(this.get(i + 1), pd, pp,false);
            addSubCondition(ret, macro, upperBound);
            int rightBound = Math.min(i + 2 + n, this.size());
            for (int j = i + 2; j < rightBound; j++) {
                macro = macro.buildMacroInProgression(this.get(j),  pd, pp,false);
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
            GroundAction macro = this.get(i).buildMacroInProgression(this.get(i + 1), pd, pp,false);
            addSubCondition(ret, macro, upperBound);
            int rightBound = Math.min(i + 2 + maxLength, this.size());
            for (int j = i + 2; j < rightBound; j++) {
                macro = macro.buildMacroInProgression(this.get(j),  pd, pp,false);
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
            macroPlan = macroPlan.buildMacroInProgression((GroundAction) this.get(j),  this.pd, this.pp,true);
            addSubCondition(ret,macroPlan,maxMacros/3);
        }
        //suffix plans computation
       macroPlan = this.get(this.size()-1);
        //prefix plans computation
        for (int j = this.size()-2; j > n; j--) {
            macroPlan = macroPlan.buildMacroInRegression((GroundAction) this.get(j), this.pd, this.pp,true);
            addSubCondition(ret1,macroPlan,maxMacros/3);
        }
        //addSubCondition(ret1,allPlan.buildMacroInProgression(macroPlan, pd, pp),maxMacros/3);
        
        //System.out.println("!!!!!!!!!!  "+middle + " !!!!!!!!!!!!!!");
        GroundAction firstAct = (GroundAction) this.get(middle);
        GroundAction macro = (GroundAction) firstAct.clone();
        macro.simplifyModel(pd, pp);

        long start = System.currentTimeMillis();
        //prefix plans computation
        
        int up = (int)(((float)this.size()/3.0)*2.0);
        
        for (int j = middle + 1; j <= up ; j++) {
            GroundAction macroDestra = null;

            if (j < this.size()) {
//               System.out.println(macro);
//               System.out.println(this.get(j));
                macroDestra = macro.buildMacroInProgression((GroundAction) this.get(j), pd, pp,true);
                addSubCondition(ret2,macroDestra,maxMacros/3);
            }
            int i = (this.size() % 2 == 0) ? this.size() - j : this.size() - j - 1;
            //System.out.println("Aggiungo azioni da:" +middle+","+ j + " e da: "+i);
            if (i >= 0) {
                GroundAction macroSinistra = macro.buildMacroInRegression((GroundAction) this.get(i), pd, pp,true);
                addSubCondition(ret2,macroSinistra,maxMacros/3);
                if (macroDestra != null) {
                    GroundAction macroDestraSinistra = macroDestra.buildMacroInRegression((GroundAction) this.get(i), pd, pp,true);
                    //System.out.println("#primitives: "+(j)+" aggregation time:" + (System.currentTimeMillis()-start));
                    addSubCondition(ret2,macroDestraSinistra,maxMacros/3);
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

    public Set generateMacrosSuffPref(int maxMacros,boolean consideringNumericInformationInDistance) throws CloneNotSupportedException, Exception {
        TreeSet<GroundAction> ret = new TreeSet();
        TreeSet<GroundAction> ret1 = new TreeSet();
        int middle = this.size() / 2;
        int n = middle;
        
        GroundAction macroPlan = this.get(0);
        //prefix plans computation
        for (int j = 1; j <= n; j++) {
            macroPlan = macroPlan.buildMacroInProgression((GroundAction) this.get(j),  this.pd, this.pp,consideringNumericInformationInDistance);
            addSubCondition(ret,macroPlan,maxMacros/3);
        }
        //suffix plans computation
       macroPlan = this.get(this.size()-1);
        //prefix plans computation
        for (int j = this.size()-2; j > n; j--) {
            macroPlan = macroPlan.buildMacroInRegression((GroundAction) this.get(j), this.pd, this.pp,consideringNumericInformationInDistance);
            addSubCondition(ret1,macroPlan,maxMacros/3);
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

    public Float getValueObjectiveFunction(PddlProblem problem) {
        
        if (problem.getMetric()!= null){
            if (problem.getMetric().getMetExpr() !=null){
            //System.out.println(problem.getMetric().getMetExpr().eval(this.execute(problem.getInit())));
            
             return problem.getMetric().getMetExpr().eval(this.execute(problem.getInit())).getNumber();
            }else
                 return new Float(this.size());
        }else
            return new Float(this.size());
    }

 
}

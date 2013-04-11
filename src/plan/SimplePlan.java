package plan;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import conditions.AndCond;
import conditions.Assigner;
import conditions.Comparison;
import conditions.Conditions;
import domain.ActionParametersAsTerms;
import domain.ActionSchema;
import domain.PddlDomain;
import expressions.Expression;
import expressions.NormExpression;
import expressions.NumEffect;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import problem.GroundAction;
import problem.PddlProblem;

/**
 *
 * @author enrico
 */
public class SimplePlan extends ArrayList {

    private PddlDomain pd;
    private PddlProblem pp;
    private HashMap invariantFluents;
    private boolean invariantAnalysis;

    public SimplePlan(PddlDomain dom, PddlProblem prob) {
        super();
        pd = dom;
        pp = prob;
        invariantAnalysis = true;
    }

    @Override
    public Object clone() {
        SimplePlan sp = new SimplePlan(pd,pp);
        sp.invariantFluents = (HashMap)this.invariantFluents.clone();
        sp.invariantAnalysis = this.invariantAnalysis;
        for (Object o:this){
            GroundAction gr = (GroundAction)o;
            try {
                sp.add(gr.clone());
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
        //grAction.normalize();
        this.add(grAction);

    }

    //to be done....
    public void parseSolution(String solution_file) throws FileNotFoundException {
        Scanner sc = new Scanner((new File(solution_file)));
        String nameOperator;

        this.removeAll(this);
        while (sc.hasNextLine()) {
            String s1, s2, cntStr = null;

            sc.nextLine();
            cntStr = sc.findInLine(";");

//            System.out.println(cntStr);
//            System.out.println(s1);
            if (cntStr == null) {
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
                Assigner ass = (Assigner) o3;
                if (invariantFluents.get(ass.getOne()) == null) {
                    invariantFluents.put(ass.getOne(), true);

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
                ret_val = ret_val.concat(a.toEcoString());

            }
        }
        return ret_val;
    }

    public String printAction(int index) {

        GroundAction a = (GroundAction) this.get(index);

        return a.getNumeric().toString();

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

    public void simplifyActions() {

        //scopro quali sono i fluenti che devo eliminare perche' ci sono scritti
        //i valori nello stato iniziale
        //dopo aver fatto cio' semplifico le variabili nelle azioni del piano

        for (Object o : this) {
            GroundAction a = (GroundAction) o;
            //a.normalize();


            Conditions con = a.getPreconditions();
            Conditions eff = a.getNumeric();
//                    System.out.println(con);
//                    System.out.println(eff);
            if (con instanceof AndCond) {
                for (Object o2 : con.son) {
                    if (o2 instanceof Comparison) {
                        Comparison comp = (Comparison) o2;
                        Expression lValue = comp.getFirst();
                        Expression rValue = comp.getTwo();
                        //System.out.println("before" + lValue + rValue);
                        lValue = lValue.weakEval(pp.getInit(), invariantFluents);
                        rValue = rValue.weakEval(pp.getInit(), invariantFluents);
                        comp.setFirst(lValue);
                        comp.setTwo(rValue);
                        //System.out.println("after" + lValue + rValue);
                    }
                }
            } else {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            if (eff instanceof AndCond) {
                for (Object o2 : eff.son) {
                    NumEffect nEff = (NumEffect) o2;
                    //System.out.println(nEff.getTwo().getClass());
                    Expression rValue = nEff.getTwo();
                    //System.out.println("before" + rValue);
                    rValue = rValue.weakEval(pp.getInit(), invariantFluents);
                    nEff.setTwo(rValue);
                    //System.out.println("after" + rValue);

                }
            } else {
                throw new UnsupportedOperationException("Not supported yet.");
            }
            a.normalize();
        }




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
}

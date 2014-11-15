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
package problem;

import conditions.AndCond;
import conditions.Comparison;
import conditions.Conditions;
import conditions.NotCond;
import conditions.NumFluentAssigner;
import conditions.PDDLObject;
import conditions.Predicate;
import domain.ActionParametersAsTerms;
import domain.ActionSchema;
import domain.GenericActionType;
import domain.PddlDomain;
import domain.Variable;
import expressions.Expression;
import expressions.NumEffect;
import expressions.NumFluent;
import expressions.PDDLNumber;
import expressions.PDDLNumbers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import plan.SimplePlan;

public class GroundAction extends GenericActionType implements Comparable {

    protected ActionParametersAsTerms parameters;
    public boolean normalized;
    private ArrayList numericFluentAffected;
    private ArrayList primitives;
    private boolean isMacro;
    public int hiddenParametersNumber;
    private Float prevDistanceFromProblem;

    @Override
    public Object clone() throws CloneNotSupportedException {
        GroundAction ret = new GroundAction(name);
        if (this.addList != null) {
            ret.addList = this.addList.clone();
        }
        if (this.delList != null) {
            ret.delList = this.delList.clone();
        }
        ret.normalized = this.normalized;
        if (this.numericEffects!=null)
            ret.numericEffects = this.numericEffects.clone();
        ret.numericFluentAffected = (ArrayList) this.numericFluentAffected.clone();
        ret.parameters = (ActionParametersAsTerms) this.parameters.clone();
        if (this.preconditions != null)
            ret.preconditions = this.preconditions.clone();
        return ret;

    }

    @Override
    public boolean equals(Object obj) {
        GroundAction gr = (GroundAction) obj;
        if ((gr.getName().equalsIgnoreCase(this.getName())) && gr.getParameters().equals(this.getParameters())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.parameters != null ? this.parameters.hashCode() : 0);
        return hash;
    }

    public GroundAction() {
        super();
        this.name = null;
        numericFluentAffected = new ArrayList();
        this.parameters = new ActionParametersAsTerms();
    }

    public GroundAction(String name) {
        super();
        this.name = name;
        numericFluentAffected = new ArrayList();
        this.parameters = new ActionParametersAsTerms();
    }

    @Override
    public String toString() {
        String parametri = "";
        for (Object o : getParameters()) {
            parametri = parametri.concat(o.toString()).concat(" ");
        }
        return "\n\nAction Name:" + this.name + " Parameters: " + parametri + "\nPre: " + this.preconditions + "\nEffetti positivi: " + this.getAddList() + "\nEffetti negativi: " + this.getDelList() + "\nNumeric Effects:  " + this.getNumericEffects();

    }

    public String toEcoString() {
        String parametri = "";
        for (Object o : getParameters()) {
            parametri = parametri.concat(o.toString()).concat(" ");
        }
        return "Action Name:" + this.name + " Parameters: " + parametri;

    }

    public String toFileCompliant() {

        String parametri = "";
        for (Object o : getParameters()) {
            PDDLObject obj = (PDDLObject) o;
            parametri = parametri.concat(obj.getName().concat(" "));
        }
        return "(" + this.name + " " + parametri + ")";

    }

    /**
     * @return the parameters
     */
    public ActionParametersAsTerms getParameters() {
        return parameters;
    }

    /**
     * @param parameters the parameters to set
     */
    public void setParameters(ActionParametersAsTerms parameters) {
        this.parameters = parameters;
    }

    public State apply(State s) {
        ;
//        if (!this.isApplicable(ret)){
//            //System.out.println("Action: " + this + "  is not applicable");
//            return null;
//        }
        
        AndCond del = (AndCond) delList;
        if (del != null) {
            del.apply(s);
        }
        AndCond add = (AndCond) addList;
        if (add != null) {
            add.apply(s);
        }

        AndCond c = (AndCond) this.getNumericEffects();
        if (c != null) {
            ArrayList temporaryMod = new ArrayList();
            HashMap fun2numb = new HashMap();
            for (Object o : c.sons) {
                NumEffect all = (NumEffect) o;
                NumFluent f = all.getFluentAffected();
                PDDLNumber newN = null;

                Float rValue;
                rValue = all.getRight().eval(s).getNumber();
                //System.out.println("Rvalue!!:" + rValue);
                if (all.getOperator().equals("increase")) {
                    newN = new PDDLNumber(s.functionValue(f).getNumber() + rValue);
                } else if (all.getOperator().equals("decrease")) {

//                    System.out.print("Valore di " + f);
//                    System.out.println(" :"+ s.functionValue(f).getNumber()); 
                    newN = new PDDLNumber(s.functionValue(f).getNumber() - rValue);
                } else if (all.getOperator().equals("assign")) {
                    //System.out.println("================ASSIGN===========");
                    newN = new PDDLNumber(rValue);
                }
                temporaryMod.add(f);
                fun2numb.put(f, newN);
            }

            for (Object o : temporaryMod) {
                NumFluent f = (NumFluent) o;
                PDDLNumber n = (PDDLNumber) fun2numb.get(f);

                s.setFunctionValue(f, n);
                //System.out.println(s.printFluentByName("in-at"));
            }

        }
        return s;
    }

    public void generateAffectedNumFluents() {

        AndCond num = (AndCond) this.getNumericEffects();

        if (num != null) {
            for (Object o : num.sons) {
                if (o instanceof NumEffect) {
                    NumEffect e = (NumEffect) o;
                    this.numericFluentAffected.add(e.getFluentAffected());
                }
            }
        }

    }

    public void normalize() throws Exception {


        AndCond temp = new AndCond();
        if (this.preconditions instanceof Predicate) {
            temp.sons.add(this.preconditions);
        } else if (this.preconditions instanceof Comparison) {
            Comparison c = (Comparison) this.preconditions;
            c = c.normalizeAndCopy();
            if (c != null) {
                temp.sons.add(c);
            }
        } else {
            if (this.preconditions != null){
                for (Object o : this.preconditions.sons) {
                    if (o instanceof Comparison) {
                        Comparison c = (Comparison) o;
                        //System.out.println(this);
                        //System.out.println("Normalizing:" +c);
                        c = c.normalizeAndCopy();
                        if (c != null) {
                            temp.sons.add(c);
                        }
                    } else if (o instanceof Predicate) {
                        temp.sons.add(o);
                    } else if (o instanceof NotCond){
                        temp.sons.add(o);
                    }
                }
            }
        }
        this.setPreconditions(temp);
//        for (Object o : this.preconditions.sons) {
//
//            if (o instanceof Comparison) {
//                Comparison c = (Comparison) o;
//                c = c.normalizeAndCopy();
//            }
//        }
        AndCond num = (AndCond) this.getNumericEffects();
        if (num != null) {
            for (Object o : num.sons) {
                if (o instanceof NumEffect) {
                    NumEffect e = (NumEffect) o;
                    e.setRight(e.getRight().normalize());
                }
            }
        }
        this.normalized = true;
    }

    public ArrayList getNumericFluentAffected() {
        return this.numericFluentAffected;
    }

    /**
     * @param numericFluentAffected the numericFluentAffected to set
     */
    public void setNumericFluentAffected(ArrayList numericFluentAffected) {
        this.numericFluentAffected = numericFluentAffected;
    }

    public RelState apply(RelState s) {
        RelState ret = s;
        AndCond add = (AndCond) addList;
        if (add != null) {
            ret = add.apply(s);
        }
        AndCond c = (AndCond) this.getNumericEffects();
        if (c != null) {
            ArrayList temporaryMod = new ArrayList();
            HashMap fun2numb = new HashMap();
            for (Object o : c.sons) {
                NumEffect all = (NumEffect) o;
                //all.apply(s);
                NumFluent f = all.getFluentAffected();


                PDDLNumbers after = new PDDLNumbers();
//                if (f.getName().contains("fuel-used")){
//                    System.out.println("Something affecting Fuel");
//                }

                PDDLNumbers current = s.functionValues(f);

//                if ((current == null) && (!(all.getOperator().equals("assign")))) {
//                    System.out.println(f + "  is not present in the current state");
//                }
                PDDLNumbers eval = all.getRight().eval(s);

//                if (f.getName().contains("fuel-used")){
//                    System.out.println("Before ("+current.inf+","+current.sup+")");
//                
//                }

                if (all.getOperator().equals("increase")) {
                    after.inf = new PDDLNumber(Math.min(current.sum(eval).inf.getNumber(), current.inf.getNumber()));
                    after.sup = new PDDLNumber(Math.max(current.sum(eval).sup.getNumber(), current.sup.getNumber()));
//                    System.out.println(current.sum(eval).inf.getNumber());
                } else if (all.getOperator().equals("decrease")) {
                    after.inf = new PDDLNumber(Math.min(current.subtract(eval).inf.getNumber(), current.inf.getNumber()));
                    after.sup = new PDDLNumber(Math.max(current.subtract(eval).sup.getNumber(), current.sup.getNumber()));

                } else if (all.getOperator().equals("assign")) {
                    if (current == null) {
                        after.inf = new PDDLNumber(eval.inf.getNumber());
                        after.sup = new PDDLNumber(eval.sup.getNumber());
                    } else {
                        after.inf = new PDDLNumber(Math.min(eval.inf.getNumber(), current.inf.getNumber()));
                        after.sup = new PDDLNumber(Math.max(eval.sup.getNumber(), current.sup.getNumber()));
                    }
                }
//                if (f.getName().contains("fuel-used")){
//                    System.out.println("Azione:"+this);
//                    System.out.println("After ("+after.inf+","+after.sup+")");
//                
//                }
                temporaryMod.add(f);
                fun2numb.put(f, after);
            }

            for (Object o : temporaryMod) {
                NumFluent f = (NumFluent) o;
                PDDLNumbers n = (PDDLNumbers) fun2numb.get(f);

                s.setFunctionValues(f, n);

            }

        }
        return ret;
    }

    public boolean isApplicable(RelState current) {
        if (this.getPreconditions() == null) {
            return true;
        }
        
        return this.getPreconditions().isSatisfied(current);
    }


    public boolean isApplicable(State current) {
        if (this.getPreconditions() == null) {
            return true;
        }
        return this.getPreconditions().isSatisfied(current);
    }

        public GroundAction buildMacroInProgression(GroundAction b, PddlDomain pd) throws CloneNotSupportedException, Exception {
        if (this.name == null) {
            return (GroundAction) b.clone();
        }
        GroundAction a = this;
        
        GroundAction ab = new GroundAction(a.name+"_"+b.name);
        if (a.getPrimitives().isEmpty())
            a.getPrimitives().add(a);
        ab.setPrimitives((ArrayList)a.getPrimitives().clone());
        if (b.isMacro){
            ab.getPrimitives().addAll(b.getPrimitives());
        }
            
        ab.getPrimitives().add(b);
        
        
        ab.setParameters((ActionParametersAsTerms) a.getParameters().clone());
        ab.getParameters().addALLNewObjects(b.getParameters());

        ab.setPreconditions(regress(b, a));
        progress(a, b, ab);
        ab.setIsMacro(true);
        //System.out.println("Da dentro l'azione..."+ab);
        //ab.simplifyModel(pd, pp);
        //ab.computeDistance(pd,pp,consideringNumericInformationInDistance);
        return ab;
    }
    
    
    
    public GroundAction buildMacroInProgression(GroundAction b, PddlDomain pd, PddlProblem pp, boolean consideringNumericInformationInDistance) throws CloneNotSupportedException, Exception {
        if (this.name == null) {
            return (GroundAction) b.clone();
        }
        GroundAction a = this;
        
        GroundAction ab = new GroundAction(a.name+"_"+b.name);
        if (a.getPrimitives().isEmpty())
            a.getPrimitives().add(a);
        ab.setPrimitives((ArrayList)a.getPrimitives().clone());
        if (b.isMacro){
            ab.getPrimitives().addAll(b.getPrimitives());
        }
            
        ab.getPrimitives().add(b);
        
        
        ab.setParameters((ActionParametersAsTerms) a.getParameters().clone());
        ab.getParameters().addALLNewObjects(b.getParameters());

        ab.setPreconditions(regress(b, a));
        progress(a, b, ab);
        ab.setIsMacro(true);
        //System.out.println("Da dentro l'azione..."+ab);
        ab.simplifyModel(pd, pp);
        ab.computeDistance(pd,pp,consideringNumericInformationInDistance);
        return ab;
    }

    public Conditions regress(GroundAction b, GroundAction a) {

        /*Propositional Part first*/

        AndCond result = (AndCond) b.getPreconditions().clone();

        /*probably something more efficient can be done here*/
        for (Object o1 : a.getAddList().sons) {
            result.sons.remove(o1);
        }
        for (Object o1 : result.sons) {

            //Numeric part. Substitution of variables
            if (o1 instanceof Comparison) {
                Comparison c = (Comparison) o1;
                c.setLeft(c.getLeft().subst(a.getNumericEffects()));

                c.setRight(c.getRight().subst(a.getNumericEffects()));

            } else if (a.getDelList() != null) {
                if (a.getDelList().sons.contains(o1)) {
                    System.out.println("Error, " + a.name + " cannot be followed by " + b.name);
                    return null;
                }
            }

        }

        result.sons.addAll(a.getPreconditions().sons);

        //AndCond numericCondition = 

        return result;
    }

    public Conditions regress(Conditions cond) {

        /*Propositional Part first*/

        AndCond result = (AndCond) cond;
        

        /*probably something more efficient can be done here*/
        if (this.getAddList() != null){
            for (Object o1 : this.getAddList().sons) {
                result.sons.remove(o1);
            }
        }
        for (Object o1 : result.sons) {

            //Numeric part. Substitution of variables
            if (o1 instanceof Comparison) {
                Comparison c = (Comparison) o1;
                c.setLeft(c.getLeft().subst(this.getNumericEffects()));
                c.setRight(c.getRight().subst(this.getNumericEffects()));

            } else if (this.getDelList() != null) {
                if (this.getDelList().sons.contains(o1)) {
                    System.out.println("Error, " + this.name + " cannot achieve " + cond.toString());
                    return null;
                }
            }

        }

        if (this.getPreconditions() != null)
            result.sons.addAll(this.getPreconditions().sons);

        //AndCond numericCondition = 

        return result;
    }

    private void progress(GroundAction a, GroundAction b, GroundAction ab) {

        /*Starting from what action a achieve*/
        AndCond localAddList = (AndCond) a.addList.clone();

        /*remove those atoms which will be deleted afterwards*/

        localAddList.subtractElements((AndCond) b.getDelList());

        /*atoms achieved by b*/
        localAddList.sons.addAll(b.getAddList().sons);

        /*Starting from what action a deletes*/

        AndCond localDelList = null;
        if (a.delList != null) {
            localDelList = (AndCond) a.delList.clone();
            /*remove those atoms which will be added by b*/
            localDelList.subtractNegation((AndCond) b.getAddList());
        } else {
            localDelList = new AndCond();
        }

        /*add the remaining atoms to be removed because of b*/
        if (b.getDelList() != null) {
            localDelList.sons.addAll(b.getDelList().sons);
        }


        /*update the macro operator model*/
        ab.setAddList(localAddList);
        ab.setDelList(localDelList);

        Conditions numEff = new AndCond();
        if (b.getNumericEffects() != null) {
            for (Object o : b.getNumericEffects().sons) {
                NumEffect nf = (NumEffect) o;
                numEff.sons.add(nf.subst(a.getNumericEffects()));
                ab.numericFluentAffected.add(nf.getFluentAffected());
            }
        }
        if (a.getNumericEffects() != null) {
            for (Object o : a.getNumericEffects().sons) {
                NumEffect nf = (NumEffect) o;
                if (!ab.getNumericFluentAffected().contains(nf.getFluentAffected())) {
                    numEff.sons.add(o);
                    ab.numericFluentAffected.add(nf.getFluentAffected());
                }
            }
        }

        ab.setNumericEffects(numEff);



    }

    public String toPDDL() {


        String ret = "(:action " + this.name + "\n";

        ret += ":parameters ()\n";
        ret += ":precondition " + this.getPreconditions().pddlPrint(false) + "\n";
        ret += ":effect " + this.pddlEffects();

        return ret + ")";




    }
//    
//    (:action debark
// :parameters (?p - person ?a - aircraft ?c - city)
// :precondition (and (in ?p ?a)
//                 (located ?a ?c))
// :effect (and (not (in ?p ?a))
//              (located ?p ?c)
//		(decrease (onboard ?a) 1)))

    private String pddlEffects() {
        String ret = "(and ";
        if (this.getAddList() != null) {
            for (Object o : this.getAddList().sons) {
                Predicate p = (Predicate) o;
                ret += p.pddlPrint(false);
            }
        }
        if (this.getDelList() != null) {
            for (Object o : this.getDelList().sons) {
                NotCond p = (NotCond) o;
                ret += p.pddlPrint(false);
            }
        }
        if (this.getNumericEffects() != null) {
            for (Object o : this.getNumericEffects().sons) {
                NumEffect nE = (NumEffect) o;
                ret += nE.pddlPrint(false);
            }
        }

        return ret + ")";
    }

    public void simplifyModel(PddlDomain domain, PddlProblem problem) throws Exception {


        HashMap invariantFluents = new HashMap();

//        if (!problem.isGroundedActions()){
//            System.err.println("Actions must me grounded for simplifying the models");
//            System.exit(-1);
//        }
//
//        for (Object anAction : problem.getActions()) {
//            GroundAction a = (GroundAction) anAction;
//
//            for (Object o2 : a.getNumericFluentAffected()) {     
//                invariantFluents.put(o2, false);
//            }
//        }
//
        HashMap abstractInvariantFluents = domain.generateAbstractInvariantFluents();
        //invariantFluents.put(pp.getFunctions(), true);

        //For each concrete numeric fluent, I look if there is at least an action modifying its abstraction
        for (Object o3 : problem.getInit().getNumericFluents()) {
            NumFluentAssigner ass = (NumFluentAssigner) o3;
            if (abstractInvariantFluents.get(ass.getNFluent().getName()) == null) {
                invariantFluents.put(ass.getNFluent(), true);
            } else {
                invariantFluents.put(ass.getNFluent(), false);
            }

        }
        GroundAction a = this;
        //a.normalizeAndCopy();


        Conditions con = a.getPreconditions();
        Conditions eff = a.getNumericEffects();
//                    System.out.println(con);
//                    System.out.println(eff);
        if (con instanceof AndCond) {
            for (Object o2 : con.sons) {
                if (o2 instanceof Comparison) {
                    Comparison comp = (Comparison) o2;
                    Expression lValue = comp.getLeft();
                    Expression rValue = comp.getRight();
//                    System.out.println("before" + lValue + rValue);
//                    System.out.println("lvalueClass:" + lValue.getClass());
                    lValue = lValue.weakEval(problem.getInit(), invariantFluents);
                    rValue = rValue.weakEval(problem.getInit(), invariantFluents);
                    comp.setLeft(lValue);
                    comp.setRight(rValue);
//                    System.out.println("after" + lValue + rValue);
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
                    lValue = lValue.weakEval(problem.getInit(), invariantFluents);
                    rValue = rValue.weakEval(problem.getInit(), invariantFluents);
                    comp.setLeft(lValue);
                    comp.setRight(rValue);
                } else {
                    System.err.println("Conditions of the type: " + con.getClass());
                    throw new UnsupportedOperationException("Not supported yet.");
                }
            }
        }

        if (eff instanceof AndCond) {
            for (Object o2 : eff.sons) {
                NumEffect nEff = (NumEffect) o2;
                //System.out.println(nEff.getRight().getClass());
                Expression rValue = nEff.getRight();
                //System.out.println("before" + rValue);
                rValue = rValue.weakEval(problem.getInit(), invariantFluents);
                nEff.setRight(rValue);
                //System.out.println("after" + rValue);

            }
        } else {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        a.normalize();

    }

    public void setPrimitives(ArrayList primitives) {
        setIsMacro(true);
        this.primitives = primitives;
    }

    /**
     * @return the isMacro
     */
    public boolean isIsMacro() {
        return isMacro;
    }

    /**
     * @param isMacro the isMacro to set
     */
    public void setIsMacro(boolean isMacro) {
        this.isMacro = isMacro;
    }

    /**
     * @return the primitives
     */
    public ArrayList getPrimitives() {
        if (primitives == null) {
            primitives = new ArrayList();
        }
        return primitives;
    }

    public Float computeDistance(PddlProblem prob) {
        int missingGoals = 0;
        int destroyingGoals = 0;
        int missingPreconditions = 0;
        int cumulativeComparisonDistance = 0;
        AndCond prec = new AndCond();
        float dist = 0;//this.getPrimitives().size()/2;
        if (this.preconditions instanceof Predicate) {
            prec.addConditions((Predicate) this.preconditions);
        } else if (this.preconditions instanceof Comparison) {
            prec.addConditions((Comparison) this.preconditions);
        } else if (this.preconditions instanceof AndCond) {
            prec = (AndCond) this.preconditions;
        } else {
            System.out.println(this.preconditions.getClass() + " is not supported");
        }

        for (Object o : prec.sons) {
            if (o instanceof Predicate) {
                Predicate p = (Predicate) o;
                if (!p.isSatisfied(prob.getInit())) {
                    missingPreconditions++;
                }
            } else if (o instanceof Comparison) {
                Comparison comp = (Comparison) o;
                cumulativeComparisonDistance += (Math.max(comp.satisfactionDistance(prob.getInit()), 0));
            }
        }
        AndCond goal = new AndCond();
        if (prob.getGoals() instanceof Predicate) {
            goal.addConditions((Predicate) prob.getGoals());
        } else if (prob.getGoals() instanceof Comparison) {
            goal.addConditions((Comparison) prob.getGoals());
        } else if (prob.getGoals() instanceof AndCond) {
            goal = (AndCond) prob.getGoals();
        } else {
            System.out.println(prob.getGoals().getClass() + " is not supported");
        }

        for (Object o : goal.sons) {
            if (o instanceof Predicate) {
                Predicate p = (Predicate) o;
                if (this.addList instanceof Predicate) {
                    if (!p.equals(this.addList)) {
                        missingGoals++;
                    }
                } else if (this.addList instanceof AndCond) {
                    if (!this.addList.sons.contains(o)) {
                        missingGoals++;
                    }
                }
            } else if (o instanceof Comparison) {
                System.out.println("distanza da comparison del goal da fare!");
            }
        }
        if (this.delList instanceof Predicate) {
            if (goal.sons.contains(delList)) {
                destroyingGoals++;
            }
        } else if (delList instanceof AndCond) {
            for (NotCond o : (HashSet<NotCond>) delList.sons) {
                //System.out.println(o);
                if (goal.sons.contains(o.son.iterator().next())) {
                    //System.out.println(o);
                    destroyingGoals++;
                }
            }
        }

        float malus = 0;
        //System.out.println("Primitives:" + this.primitives.size());
//        float rA = (float) this.computeReputedActions();
//        //System.out.println(rA);
//        if (rA / (float) this.primitives.size() < 0.1) {
//            malus = 100*(float) this.primitives.size()/rA;
//        }

        dist = (float) (missingGoals + destroyingGoals + missingPreconditions );

        float a = 0;// 1-this.getParametersFusionNumber()/(float)this.hiddenParametersNumber;


        //System.out.println("Missing Goal!!:" +missingGoals +" Normalizzato" + (float)(prob.getGoals().sons.size()-missingGoals)/(float)prob.getGoals().sons.size());
        this.setPrevDistanceFromProblem((Float) dist + a);
        //this.prevDistanceFromProblem = dist;

        return getPrevDistanceFromProblem();
    }

    public int getParametersFusionNumber() {
        hiddenParametersNumber = 0;
        if (this.isMacro) {

            for (GroundAction gr : (ArrayList<GroundAction>) this.primitives) {
                hiddenParametersNumber += gr.getParameters().size();

            }
        }
        return hiddenParametersNumber - this.getParameters().size();
    }

    public GroundAction buildMacroInRegression(GroundAction a, PddlDomain pd, PddlProblem pp, boolean consideringNumericInformationInDistance) throws CloneNotSupportedException, Exception {
        if (this.name == null) {
            return (GroundAction) a.clone();
        }
        GroundAction b = (GroundAction) this;
        
        
        GroundAction ba = new GroundAction(a.name+"_"+b.name);
        if (b.getPrimitives().isEmpty())
            b.getPrimitives().add(b);
        ba.setPrimitives((ArrayList)b.getPrimitives().clone());
        ba.getPrimitives().add(0,a);

        ba.setParameters((ActionParametersAsTerms) b.getParameters().clone());
        ba.getParameters().addALLNewObjects(a.getParameters());

        ba.setPreconditions(regress(b, a));
        progress(a, b, ba);
        ba.setIsMacro(true);
        ba.simplifyModel(pd, pp);
        ba.computeDistance(pd,pp,consideringNumericInformationInDistance);

        return ba;
    }

    public Float getDistance() {
        return getPrevDistanceFromProblem();
    }

    @Override
    public int compareTo(Object t) {
        GroundAction gr = (GroundAction) t;
        if (this.getPrevDistanceFromProblem().equals(gr.getPrevDistanceFromProblem()))
            return -1;
        
        return this.getPrevDistanceFromProblem().compareTo(gr.getPrevDistanceFromProblem());
    }

    private int computeReputedActions() {
        
        HashSet counter = new HashSet();
        for (Object o : this.primitives) {
            GroundAction a = (GroundAction) o;
            counter.add(a.getName());
        }
        //System.out.println(ret);
        return counter.size();
    }

    /**
     * @return the prevDistanceFromProblem
     */
    public Float getPrevDistanceFromProblem() {
        return prevDistanceFromProblem;
    }

    /**
     * @param prevDistanceFromProblem the prevDistanceFromProblem to set
     */
    public void setPrevDistanceFromProblem(Float prevDistanceFromProblem) {
        this.prevDistanceFromProblem = prevDistanceFromProblem;
    }

    public boolean threatenConditions(Conditions goal, SimplePlan sp, State current) {
        boolean  threatened=false;
        for (Object o : goal.sons) {
            if (o instanceof Predicate) {
                Predicate p = (Predicate) o;
                if (this.addList instanceof Predicate) {
                    if (!p.equals(this.addList)) {
                        threatened = true;
                        
                    }
                } else if (this.addList instanceof AndCond) {
                    if (!this.addList.sons.contains(o)) {
                        threatened = true;
                    }
                }
            } else if (o instanceof Comparison) {
                System.out.println("Minacce su goal comparison da fare!");
            }
        }
        
        return threatened;
        
    }

    public boolean threatGoalConditions(Conditions goal, SimplePlan sp, int j, State current) throws CloneNotSupportedException {
        boolean  threatened=false;
        
        Set threatenedAtoms = new HashSet();
        
        if (this.delList instanceof Predicate) {
            for (Object o: goal.sons){
                if (o.equals(delList))
                    threatenedAtoms.add(o);
            }
        } else if (delList instanceof AndCond) {
            for (NotCond o : (HashSet<NotCond>) delList.sons) {
                //System.out.println(o);
                for (Object o1: goal.sons){
                    //System.out.println(o1);
                    //System.out.println(o.son.iterator().next());
                    Predicate a = (Predicate)o.son.iterator().next();
                    Predicate b = (Predicate)o1;
                    if (a.toString().equalsIgnoreCase(b.toString())){
                        System.out.println("Scoperto!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!<=======================================");
                        System.out.println("Per azione:"+j);
                        threatenedAtoms.add(o1);
                    }
                }
            }
        }
        if (threatenedAtoms.isEmpty())
            return false;
        State end = current.clone();
        for (int i=j;i<sp.size();i++){
            end = sp.get(i).apply(end);
        }
        for (Object o: threatenedAtoms){
            if (!end.containProposition((Predicate)o))
                return true;
                
        }
        
        return false;
    }

    private float computeDistance(PddlDomain pd, PddlProblem prob, boolean consideringNumericInformationInDistance) throws Exception {
        int missingGoals = 0;
        int destroyingGoals = 0;
        int missingPreconditions = 0;
        int cumulativeComparisonDistance = 0;
        AndCond prec = new AndCond();
        
        
        
        //NumericPlanningGraph gr = new NumericPlanningGraph();
        //prob.generateActions();
        //System.out.println("Propositional Time:"+pp.getPropositionalTime());
        
        
        //RelState rel_state = gr.computeStateBound(prob.getInit(),prob.getGoals(),prob.getActions());
        
        float dist = 0;//this.getPrimitives().size()/2;
        if (this.preconditions instanceof Predicate) {
            prec.addConditions((Predicate) this.preconditions);
        } else if (this.preconditions instanceof Comparison) {
            prec.addConditions((Comparison) this.preconditions);
        } else if (this.preconditions instanceof AndCond) {
            prec = (AndCond) this.preconditions;
        } else {
            System.out.println(this.preconditions.getClass() + " is not supported");
        }

        for (Object o : prec.sons) {
            if (o instanceof Predicate) {
                Predicate p = (Predicate) o;
                if (!p.isSatisfied(prob.getInit())) {
                    missingPreconditions++;
                }
            } 
        }
        cumulativeComparisonDistance += prob.getInit().normalizedDist(prec, prob.getPossStates(), "sum");
        AndCond goal = new AndCond();
        if (prob.getGoals() instanceof Predicate) {
            goal.addConditions((Predicate) prob.getGoals());
        } else if (prob.getGoals() instanceof Comparison) {
            goal.addConditions((Comparison) prob.getGoals());
        } else if (prob.getGoals() instanceof AndCond) {
            goal = (AndCond) prob.getGoals();
        } else {
            System.out.println(prob.getGoals().getClass() + " is not supported");
        }

        for (Object o : goal.sons) {
            if (o instanceof Predicate) {
                Predicate p = (Predicate) o;
                if (this.addList instanceof Predicate) {
                    if (!p.equals(this.addList)) {
                        missingGoals++;
                    }
                } else if (this.addList instanceof AndCond) {
                    if (!this.addList.sons.contains(o)) {
                        missingGoals++;
                    }
                }
            } else if (o instanceof Comparison) {
                System.out.println("distanza da comparison del goal da fare!");
            }
        }
        if (this.delList instanceof Predicate) {
            if (goal.sons.contains(delList)) {
                destroyingGoals++;
            }
        } else if (delList instanceof AndCond) {
            for (NotCond o : (HashSet<NotCond>) delList.sons) {
                //System.out.println(o);
                if (goal.sons.contains(o.son.iterator().next())) {
                    //System.out.println(o);
                    destroyingGoals++;
                }
            }
        }

        float malus = 0;
        //System.out.println("Primitives:" + this.primitives.size());
//        float rA = (float) this.computeReputedActions();
//        //System.out.println(rA);
//        if (rA / (float) this.primitives.size() < 0.1) {
//            malus = 100*(float) this.primitives.size()/rA;
//        }

        if (!consideringNumericInformationInDistance){
            cumulativeComparisonDistance = 0;
        }
        dist = (float) (missingGoals + destroyingGoals + missingPreconditions + cumulativeComparisonDistance);

        float a = 0;// 1-this.getParametersFusionNumber()/(float)this.hiddenParametersNumber;


        //System.out.println("Missing Goal!!:" +missingGoals +" Normalizzato" + (float)(prob.getGoals().sons.size()-missingGoals)/(float)prob.getGoals().sons.size());
        this.setPrevDistanceFromProblem((Float) dist + a);
        //this.prevDistanceFromProblem = dist;

        return getPrevDistanceFromProblem();    }

    public Conditions regressAndStoreFatherPointer(Conditions cond) {
        /*Propositional Part first*/

        AndCond result = new AndCond();
        

        /*probably something more efficient can be done here*/
        if (this.getAddList() != null){
            for (Object o1 : cond.sons){
                if (o1 instanceof Predicate){
                    if (!this.getAddList().sons.contains(o1))
                        result.sons.add(o1);
                }
            }

        }
        for (Object o1 : cond.sons) {

            //Numeric part. Substitution of variables
            if (o1 instanceof Comparison) {
                Comparison temp= (Comparison)o1;
                Comparison c = (Comparison)temp.clone();
                c.setLeft(c.getLeft().subst(this.getNumericEffects()));
                c.setRight(c.getRight().subst(this.getNumericEffects()));
                c.fatherFromRegression = temp;
                result.sons.add(c);
            } else if (this.getDelList() != null) {
                if (this.getDelList().sons.contains(o1)) {
                    System.out.println("Error, " + this.name + " cannot achieve " + cond.toString());
                    return null;
                }
            }

        }

        result.sons.addAll(this.getPreconditions().sons);
        
        //AndCond numericCondition = 

        return result;
    }

    
    public ActionSchema unGround() {
        ActionSchema result = new ActionSchema();
        result.setName(this.name);
        
        Map asbstractionOf = this.abstractParameters();
        for (Object o: this.getParameters()){
            PDDLObject obj = (PDDLObject)o;
            result.addParameter((Variable)asbstractionOf.get(obj.getName()));
        }
        //System.out.println("Macro Action: " + result.getName());
        //System.out.println(asbstractionOf);
        result.setPreconditions(preconditions.unGround(asbstractionOf));
        result.setAddList(addList.unGround(asbstractionOf));
        result.setDelList(delList.unGround(asbstractionOf));
        result.setNumericEffects(this.numericEffects.unGround(asbstractionOf));

        
        
        return result;
    }

    private Map abstractParameters() {

        HashMap result = new HashMap();
        for(Object o: this.getParameters()){
            PDDLObject po = (PDDLObject)o;
            Variable absPo = new Variable();
            absPo.setName("?"+po.getName());
            absPo.setType(po.getType());
            result.put(po.getName(), absPo);
        }
        return result;
    }
        
    
    
   


    
}

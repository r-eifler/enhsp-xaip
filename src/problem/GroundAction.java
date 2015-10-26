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
import conditions.PDDLObject;
import conditions.Predicate;
import domain.ParametersAsTerms;
import domain.ActionSchema;
import domain.GenericActionType;
import domain.PddlDomain;
import domain.Variable;
import expressions.Expression;
import expressions.NormExpression;
import expressions.NumEffect;
import expressions.NumFluent;
import expressions.PDDLNumber;
import expressions.PDDLNumbers;
import extraUtils.Pair;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import plan.SimplePlan;
import search.RegressedSearchNode;

public class GroundAction extends GenericActionType implements Comparable {

    protected ParametersAsTerms parameters;
    public boolean normalized;
    private HashMap<NumFluent,Boolean> numericFluentAffected;
    private ArrayList primitives;
    private boolean isMacro;
    public int hiddenParametersNumber;
    private Float prevDistanceFromProblem;
    public Comparison achievedComparison = null;
    public GroundAction generator;
    public HashSet<Conditions> achievedComparisons;
    private boolean reacheable = false;
    private HashMap<NumFluent,Float> coefficientAffected;
    private float action_cost;
    public int counter;
    public HashMap<Integer,Boolean> interact_with;
    private HashMap<Predicate,Boolean> achieve;


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
        if (this.numericEffects != null) {
            ret.numericEffects = this.numericEffects.clone();
        }
        ret.numericFluentAffected = (HashMap) this.numericFluentAffected.clone();
        if (this.parameters != null) {
            ret.parameters = (ParametersAsTerms) this.parameters.clone();
        }
        if (this.preconditions != null) {
            ret.preconditions = this.preconditions.clone();
        }
        if (this.interact_with!= null){
            ret.interact_with = (HashMap<Integer, Boolean>) this.interact_with.clone();
        }
        return ret;

    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        GroundAction gr = (GroundAction) obj;

        return (gr.getName().equalsIgnoreCase(this.getName())) && gr.getParameters().equals(this.getParameters());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (this.parameters != null ? this.parameters.hashCode() : 0);
        hash = 29 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 11 * hash + (this.parameters != null ? this.parameters.hashCode() : 0);
//        return hash;
//    }
//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 37 * hash + (this.parameters != null ? this.parameters.hashCode() : 0);
//        return hash;
//    }
    public GroundAction() {
        super();
        this.name = null;
        numericFluentAffected = null;
        this.parameters = new ParametersAsTerms();
        //numericFluentAffected = new HashMap();
        action_cost = 0;
        interact_with = new HashMap();
        achieve = new HashMap();
    }

    public GroundAction(String name) {
        super();
        this.name = name;
        numericFluentAffected = null;
        this.parameters = new ParametersAsTerms();
        this.preconditions = new AndCond();
        //numericFluentAffected = new HashMap();
        action_cost = 0;
        interact_with = new HashMap();
        achieve = new HashMap();
    }

//    @Override
//    public String toString() {
//        String parametri = "";
//        for (Object o : getParameters()) {
//            parametri = parametri.concat(o.toString()).concat(" ");
//        }
//        return "\n\nAction Name:" + this.name + " Parameters: " + parametri + "\nPre: " + this.preconditions + "\nEffetti positivi: " + this.getAddList() + "\nEffetti negativi: " + this.getDelList() + "\nNumeric Effects:  " + this.getNumericEffects();
//
//    }
    @Override
    public String toString() {
        String parametri = "";
        if (getParameters() != null) {
            for (Object o : getParameters()) {
                parametri = parametri.concat(o.toString()).concat(" ");
            }
        }
        return this.name + " " + parametri;

    }

    public String toEcoString() {
        String parametri = "";
        if (getParameters() != null) {
            for (Object o : getParameters()) {
                parametri = parametri.concat(o.toString()).concat(" ");
            }
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
    public ParametersAsTerms getParameters() {
        return parameters;
    }

    /**
     * @param parameters the parameters to set
     */
    public void setParameters(ParametersAsTerms parameters) {
        this.parameters = parameters;
    }

    public State apply(State s) {

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
                if (all.getRight().eval(s) == null) {
                    newN = null;
                } else {
                    rValue = all.getRight().eval(s).getNumber();
                    //System.out.println("Rvalue!!:" + rValue);
                    if (all.getOperator().equals("increase")) {
                        if (s.functionValue(f) == null) {
                            newN = null;
                        } else {
                            newN = new PDDLNumber(s.functionValue(f).getNumber() + rValue);
                        }
                    } else if (all.getOperator().equals("decrease")) {
                        //                    System.out.print("Valore di " + f);
                        //                    System.out.println(" :"+ s.functionValue(f).getNumber());
                        if (s.functionValue(f) == null) {
                            newN = null;
                        } else {
                            newN = new PDDLNumber(s.functionValue(f).getNumber() - rValue);
                        }
                    } else if (all.getOperator().equals("assign")) {
                        //System.out.println("================ASSIGN===========");
                        newN = new PDDLNumber(rValue);
                    }
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
        
        
        
        if (numericFluentAffected != null) {
            return;
        }

        
        numericFluentAffected = new HashMap();
        AndCond num = (AndCond) this.getNumericEffects();

        if (num != null) {
            for (Object o : num.sons) {
                if (o instanceof NumEffect) {
                    NumEffect e = (NumEffect) o;
                    this.numericFluentAffected.put(e.getFluentAffected(),Boolean.TRUE);
                }
            }
        }

    }

    public void normalize() throws Exception {

        if (normalized) {
            return;
        }

        if (this.getPreconditions() != null){
            this.getPreconditions().normalize();
            if (this.getPreconditions().isUnsatisfiable()) {
                this.setReacheable(true);
            }
        }

        AndCond num = (AndCond) this.getNumericEffects();
        if (num != null) {
            for (Object o : num.sons) {
                if (o instanceof NumEffect) {
                    NumEffect e = (NumEffect) o;
                    //System.out.println(e);
                    e.setRight(e.getRight().normalize());
                }
            }
        }
        this.normalized = true;
    }

    public HashMap<NumFluent,Boolean> getNumericFluentAffected() {
        this.generateAffectedNumFluents();
        return this.numericFluentAffected;
    }

    /**
     * @param numericFluentAffected the numericFluentAffected to set
     */
    public void setNumericFluentAffected(HashMap<NumFluent,Boolean> numericFluentAffected) {
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
                    //System.out.println(current);
                    //System.out.println(current.sum(eval).inf);
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

        if (numericEffectUndefined(current)) {
            return false;
        }

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

        GroundAction ab = new GroundAction(a.name + "_" + b.name);
        if (a.getPrimitives().isEmpty()) {
            a.getPrimitives().add(a);
        }
        ab.setPrimitives((ArrayList) a.getPrimitives().clone());
        if (b.isMacro) {
            ab.getPrimitives().addAll(b.getPrimitives());
        }

        ab.getPrimitives().add(b);
        if (a.getParameters() != null) {
            ab.setParameters((ParametersAsTerms) a.getParameters().clone());
        }
        if (b.getParameters() != null) {
            ab.getParameters().addALLNewObjects(b.getParameters());
        }

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

        GroundAction ab = new GroundAction(a.name + "_" + b.name);
        if (a.getPrimitives().isEmpty()) {
            a.getPrimitives().add(a);
        }
        ab.setPrimitives((ArrayList) a.getPrimitives().clone());
        if (b.isMacro) {
            ab.getPrimitives().addAll(b.getPrimitives());
        }

        ab.getPrimitives().add(b);

        ab.setParameters((ParametersAsTerms) a.getParameters().clone());
        ab.getParameters().addALLNewObjects(b.getParameters());

        //System.out.println(b.pddlEffects());
        //      System.out.println(a.pddlEffects());
        ab.setPreconditions(regress(b, a));
        progress(a, b, ab);
        ab.setIsMacro(true);
//        System.out.println("Da dentro l'azione..."+ab);
        ab.simplifyModel(pd, pp);
        ab.computeDistance(pd, pp, consideringNumericInformationInDistance);

        if (ab.getName() == null) {
            System.out.println(a + " " + b + " created a null action");
        }

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

    public Comparison regressComparison(Comparison cond) {

        Comparison c = (Comparison) cond;
        c.setNormalized(false);
        c.setLeft(c.getLeft().subst(this.getNumericEffects()));
        c.setRight(c.getRight().subst(this.getNumericEffects()));
        return c;
    }

    public Conditions regress(Conditions cond) {

        if (cond instanceof Comparison) {
            Comparison c = (Comparison) cond;
            c.setLeft(c.getLeft().subst(this.getNumericEffects()));
            c.setRight(c.getRight().subst(this.getNumericEffects()));
            return c;//this is an error!!!
        }

        /*Propositional Part first*/
        AndCond result = (AndCond) cond;


        /*probably something more efficient can be done here*/
        if (this.getAddList() != null) {
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

        if (this.getPreconditions() != null) {
            result.sons.addAll(this.getPreconditions().sons);
        }

        //AndCond numericCondition = 
        return result;
    }

    private void progress(GroundAction a, GroundAction b, GroundAction ab) {

        /*Starting from what action a achieve*/
        AndCond localAddList = (AndCond) a.addList.clone();

        /*remove those atoms which will be deleted afterwards*/
        localAddList.subtractElements((AndCond) b.getDelList());

        /*atoms achieved by b*/
        //System.out.println(b);
        //System.out.println(b.getAddList());
        if (b.getAddList()!= null)
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
                ab.addNumericFluentAffected(nf.getFluentAffected());
            }
        }
        if (a.getNumericEffects() != null) {
            for (Object o : a.getNumericEffects().sons) {
                NumEffect nf = (NumEffect) o;
                //nf.getFluentAffected();
                if (ab.getNumericFluentAffected().get(nf.getFluentAffected())==null) {
                    numEff.sons.add(o);
                    ab.addNumericFluentAffected(nf.getFluentAffected());
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
        if (this.getAddList() != null && this.getAddList().sons != null) {

            for (Object o : this.getAddList().sons) {
                Predicate p = (Predicate) o;
                ret += p.pddlPrint(false);
            }
        }
        if (this.getDelList() != null && this.getDelList().sons != null) {
            for (Object o : this.getDelList().sons) {
                NotCond p = (NotCond) o;
                ret += p.pddlPrint(false);
            }
        }
        if (this.getNumericEffects() != null && this.getNumericEffects().sons != null) {
            for (Object o : this.getNumericEffects().sons) {
                NumEffect nE = (NumEffect) o;
                ret += nE.pddlPrint(false);
            }
        }

        return ret + ")";
    }

    public boolean simplifyModel(PddlDomain domain, PddlProblem problem) throws Exception {

        HashMap invariantFluents = problem.getInvariantFluents();
        //add invariantFluents because free variable
        for (NumFluent nf : (Collection<NumFluent>)domain.getFree_functions()){
            invariantFluents.put(nf.getName(),Boolean.FALSE);
        }

        GroundAction a = this;

        Conditions con = a.getPreconditions();
        
        if (con != null){

            con = con.weakEval(problem.getInit(), invariantFluents);

            if (con == null){
                //System.out.println("A precondition is never satisfiable");
                return false;
            }
        }


        Conditions eff = a.getNumericEffects();

        //System.out.println(abstractInvariantFluents);
        eff = eff.weakEval(problem.getInit(), invariantFluents);

        if (eff == null)
            return false;
        //System.out.println(a.toPDDL());
        a.normalize();
//        if (a.isUnsatisfiable())
//            return false;
        //System.out.println(a.toPDDL());
        return true;
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

                //System.out.println("distanza da comparison del goal da fare!");
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

        dist = (float) (missingGoals + destroyingGoals + missingPreconditions);

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

        GroundAction ba = new GroundAction(a.name + "_" + b.name);
        if (b.getPrimitives().isEmpty()) {
            b.getPrimitives().add(b);
        }
        ba.setPrimitives((ArrayList) b.getPrimitives().clone());
        ba.getPrimitives().add(0, a);

        ba.setParameters((ParametersAsTerms) b.getParameters().clone());
        ba.getParameters().addALLNewObjects(a.getParameters());

        ba.setPreconditions(regress(b, a));
        progress(a, b, ba);
        ba.setIsMacro(true);
        ba.simplifyModel(pd, pp);
        ba.computeDistance(pd, pp, consideringNumericInformationInDistance);

        return ba;
    }

    public Float getDistance() {
        return getPrevDistanceFromProblem();
    }

    @Override
    public int compareTo(Object t) {
        GroundAction gr = (GroundAction) t;
        if (this.getPrevDistanceFromProblem().equals(gr.getPrevDistanceFromProblem())) {
            return -1;
        }

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
        boolean threatened = false;
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
        boolean threatened = false;

        Set threatenedAtoms = new HashSet();

        if (this.delList instanceof Predicate) {
            for (Object o : goal.sons) {
                if (o.equals(delList)) {
                    threatenedAtoms.add(o);
                }
            }
        } else if (delList instanceof AndCond) {
            for (NotCond o : (HashSet<NotCond>) delList.sons) {
                //System.out.println(o);
                for (Object o1 : goal.sons) {
                    //System.out.println(o1);
                    //System.out.println(o.son.iterator().next());
                    Predicate a = (Predicate) o.son.iterator().next();
                    Predicate b = (Predicate) o1;
                    if (a.toString().equalsIgnoreCase(b.toString())) {
                        //System.out.println("Scoperto!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!<=======================================");
                        //System.out.println("Per azione:" + j);
                        threatenedAtoms.add(o1);
                    }
                }
            }
        }
        if (threatenedAtoms.isEmpty()) {
            return false;
        }
        State end = current.clone();
        for (int i = j; i < sp.size(); i++) {
            end = sp.get(i).apply(end);
        }
        for (Object o : threatenedAtoms) {
            if (!end.containProposition((Predicate) o)) {
                System.out.println("=================Found a goal threat=============");
                return true;
            }

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
                //System.out.println("distanza da comparison del goal da fare!");
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

        if (!consideringNumericInformationInDistance) {
            cumulativeComparisonDistance = 0;
        }
        dist = (float) (missingGoals + destroyingGoals + missingPreconditions + cumulativeComparisonDistance);

        float a = 0;// 1-this.getParametersFusionNumber()/(float)this.hiddenParametersNumber;

        //System.out.println("Missing Goal!!:" +missingGoals +" Normalizzato" + (float)(prob.getGoals().sons.size()-missingGoals)/(float)prob.getGoals().sons.size());
        this.setPrevDistanceFromProblem((Float) dist + a);
        //this.prevDistanceFromProblem = dist;

        return getPrevDistanceFromProblem();
    }

    public Conditions regressAndStoreFatherPointer(Conditions cond) {
        /*Propositional Part first*/

        AndCond result = new AndCond();


        /*probably something more efficient can be done here*/
        if (this.getAddList() != null) {
            for (Object o1 : cond.sons) {
                if (o1 instanceof Predicate) {
                    if (!this.getAddList().sons.contains(o1)) {
                        result.sons.add(o1);
                    }
                }
            }

        }
        for (Object o1 : cond.sons) {

            //Numeric part. Substitution of variables
            if (o1 instanceof Comparison) {
                Comparison temp = (Comparison) o1;
                Comparison c = (Comparison) temp.clone();
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
        for (Object o : this.getParameters()) {
            PDDLObject obj = (PDDLObject) o;
            result.addParameter((Variable) asbstractionOf.get(obj.getName()));
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
        for (Object o : this.getParameters()) {
            PDDLObject po = (PDDLObject) o;
            Variable absPo = new Variable();
            absPo.setName("?" + po.getName());
            absPo.setType(po.getType());
            result.put(po.getName(), absPo);
        }
        return result;
    }

    public boolean achieve(Predicate p) {
        
        if (this.achieve.get(p) == null){
            AndCond add = (AndCond) this.getAddList();

            if (add == null) {
                this.achieve.put(p, false);
                return false;
            }
            if (add.sons == null) {
                this.achieve.put(p, false);
                return false;
            }
            if (add.sons.contains(p)) {
                this.achieve.put(p, true);
                return true;
            }
            this.achieve.put(p, false);
            return false;
        }

        return this.achieve.get(p);
    }

    public boolean delete(Predicate p) {
        AndCond add = (AndCond) this.getDelList();
        //System.out.println(this.toPDDL());
        //System.out.println(this.getDelList());
        if (add == null) {
            return false;
        }
        if (add.sons == null) {
            return false;
        }
        for (Object o : this.getDelList().sons) {
            NotCond nc = (NotCond) o;
            //System.out.println(nc);

            if (nc.son.contains(p)) {
                return true;
            }
        }
        return false;
    }

    public State transformInState() {
        State ret = new State();
        ret = this.apply(ret);
        return ret;
    }

    public boolean mayInfluence(Comparison aThis) {

        this.generateAffectedNumFluents();
        if (aThis.isNormalized()) {
            return aThis.getLeft().involve(numericFluentAffected) || aThis.getRight().involve(this.numericFluentAffected);
        } else {
            return aThis.getLeft().involve(this.numericFluentAffected) || aThis.getRight().involve(this.numericFluentAffected);
        }

    }

    @Deprecated
    public Pair<Boolean, Integer> improve_k_old(State s_0, Comparison c, int k, HashMap<GroundAction, HashSet<GroundAction>> influence_graph, HashMap<GroundAction, Boolean> visited) throws Exception {
        Pair<Boolean, Integer> ret = new Pair(Boolean.FALSE, 0);
        int res = this.improve_new(s_0, c);
        if (res == 1) {
            ret.setFirst(Boolean.TRUE);
            return ret;
        }
        if (res == -1) {//when it does not influence
            return ret;
        }
        if (!this.effects_might_be_influenced()) {//when it cannot be influenced (the right side is a number)
            return ret;
        }

        //System.out.println("gr:"+this.pddlEffects());
        if (k == 0) {
            ret.setSecond(1);
            return ret;
        }
        if (visited == null) {
            visited = new HashMap();
        }
        visited.put(this, Boolean.TRUE);
        //System.out.println(this);
        for (GroundAction gr : influence_graph.get(this)) {
            if (visited.get(gr) != null) {
                continue;
            }
            Pair<Boolean, Integer> temp = gr.improve_k(s_0, this.regressComparison((Comparison) c.clone()), k - 1, influence_graph, visited);
            if (temp.getFirst()) {
                ret.setFirst(Boolean.TRUE);
                return ret;
            } else {
                if (temp.getSecond() > 0) {
                    ret.setSecond(temp.getSecond() + 1);
                }
            }

        }
        return ret;

    }

    public Pair<Boolean, Integer> improve_k(State s_0, Comparison c, int k, HashMap<GroundAction, HashSet<GroundAction>> influence_graph, HashMap<GroundAction, Boolean> visited) throws Exception {
        Pair<Boolean, Integer> ret = new Pair(Boolean.FALSE, 0);
        ret.setSecond(0);
        int res = this.improve_new(s_0, c);
        if (res == 1) {
            ret.setFirst(Boolean.TRUE);
            return ret;
        }
        if (res == -1) {//when it does not influence
            return ret;
        }
//        if (!this.effects_might_be_influenced()) {//when it cannot be influenced (the right side is a number)
//            return ret;
//        }

        if (res == 2) {
            //check for invariant to be put;
            //System.out.println("To Undefined State");
            ret.setSecond(1);
            return ret;
        }

        //System.out.println("gr:"+this.pddlEffects());
        if (k == 0) {
            ret.setSecond(1);
            return ret;
        }

        visited = new HashMap();

        //System.out.println(this);
        Queue<RegressedSearchNode> q = new ArrayDeque();

        q.add(new RegressedSearchNode(this, 0));

        Comparison current = (Comparison) c.clone();
        while (!q.isEmpty()) {
            RegressedSearchNode node = q.poll();
            if (node.action_cost_to_get_here >= k) {
                ret.setSecond(node.action_cost_to_get_here);
                //System.out.println("limit reached:"+node.action_cost_to_get_here);
                return ret;
            }
            if (visited.get(node.action) == null) {
                visited.put(node.action, Boolean.TRUE);
                if (!this.equals(node.action)) {
                    if (node.action.improve_new(s_0, current) == 1) {
                        ret.setSecond(node.action_cost_to_get_here);
                        //System.out.println("Indirect influence found at cost:"+node.action_cost_to_get_here);
                        return ret;
                    }
                }
                current = node.action.regressComparison((Comparison) current);
                //System.out.println(node.action);
                if (influence_graph.get(node.action) != null) {
                    for (GroundAction gr : influence_graph.get(node.action)) {
                        q.add(new RegressedSearchNode(gr, node.action_cost_to_get_here + 1));
                    }
                }
            }
        }
        return ret;

    }

    public boolean influence(HashMap<NumFluent, HashSet<NumFluent>> dependsOn) {

        for (NumFluent nf : dependsOn.keySet()) {
//            if (numericFluentAffected.contains(nf)) {
//                    return true;
//                }
            for (NumFluent nf1 : dependsOn.get(nf)) {
                if (numericFluentAffected.get(nf1)!=null) {
                    //System.out.println(nf+" <-"+nf1);
                    return true;
                }
            }
        }

        return false;

    }

    public boolean influence(NumFluent nf) {
        if (this.numericFluentAffected == null)
            this.generateAffectedNumFluents();
        
        return numericFluentAffected.get(nf)!=null;
    }

    public Set influencedBy(NumFluent nf) {
        HashSet<NumFluent> ret = new HashSet();
        Conditions c = this.getNumericEffects();
        if (c != null) {
            if (c instanceof AndCond) {
                for (Object o : c.sons) {
                    NumEffect eff = (NumEffect) o;
                    if (eff.getFluentAffected().equals(nf)) {
                        return eff.getRight().fluentsInvolved();
                    }

                }
            }

        }
        return null;
    }

    public State partialApply(State s, HashSet<NumFluent> toTest) {

        State ret = new State();

        for (Object o : toTest) {
            NumFluent f = (NumFluent) o;
            ret.setFunctionValue(f, f.eval(s));
            //System.out.println(s.printFluentByName("in-at"));
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
                if (all.getRight().eval(s) == null) {
                    newN = null;
                } else {
                    rValue = all.getRight().eval(s).getNumber();
                    //System.out.println("Rvalue!!:" + rValue);
                    if (all.getOperator().equals("increase")) {
                        if (s.functionValue(f) == null) {
                            newN = null;
                        } else {
                            newN = new PDDLNumber(s.functionValue(f).getNumber() + rValue);
                        }
                    } else if (all.getOperator().equals("decrease")) {
                        //                    System.out.print("Valore di " + f);
                        //                    System.out.println(" :"+ s.functionValue(f).getNumber());
                        if (s.functionValue(f) == null) {
                            newN = null;
                        } else {
                            newN = new PDDLNumber(s.functionValue(f).getNumber() - rValue);
                        }
                    } else if (all.getOperator().equals("assign")) {
                        //System.out.println("================ASSIGN===========");
                        newN = new PDDLNumber(rValue);
                    }
                }
                temporaryMod.add(f);
                fun2numb.put(f, newN);
            }

            for (Object o : temporaryMod) {
                NumFluent f = (NumFluent) o;
                PDDLNumber n = (PDDLNumber) fun2numb.get(f);

                ret.setFunctionValue(f, n);
                //System.out.println(s.printFluentByName("in-at"));
            }

        }
        return ret;

    }

//    public String toSmtVariableString() {
//        String parametri = "";
//        for (Object o : getParameters()) {
//            parametri = parametri.concat(o.toString()).concat("");
//        }
//        return ("ACTION" + this.name + "" + parametri).replaceAll("\\s+", "");
//    }

    public boolean threat(AndCond andCond) {
        if (this.delList == null) {
            return false;
        }
        if (this.delList.sons == null) {
            return false;
        }
        if (andCond.sons != null) {

            for (Object o : this.delList.sons) {
                NotCond nc = (NotCond) o;
                Predicate p = (Predicate) nc.son.iterator().next();
                for (Object o2 : andCond.sons) {
                    if (o2 instanceof Predicate) {
                        Predicate p1 = (Predicate) o2;
                        if (p1.equals(p)) {
                            //System.out.println("Found: "+p1+p);
                            return true;
                        }
                    }

                }
            }
        }
        return false;
    }
    
//    public HashMap threats(AndCond andCond) {
//        if (this.delList == null) {
//            return false;
//        }
//        if (this.delList.sons == null) {
//            return false;
//        }
//        if (andCond.sons != null) {
//
//            for (Object o : this.delList.sons) {
//                NotCond nc = (NotCond) o;
//                Predicate p = (Predicate) nc.son.iterator().next();
//                for (Object o2 : andCond.sons) {
//                    if (o2 instanceof Predicate) {
//                        Predicate p1 = (Predicate) o2;
//                        if (p1.equals(p)) {
//                            //System.out.println("Found: "+p1+p);
//                            return true;
//                        }
//                    }
//
//                }
//            }
//        }
//        return false;
//    }
//    
    

    public String toSmtVariableString(int i) {
        String parametri = "";
        for (Object o : getParameters()) {
            PDDLObject po = (PDDLObject) o;
            parametri += "@" + po.getName();
            //parametri = parametri.concat(po.getName()).concat("_");
        }
        return ("ACTION" + this.name + parametri + "@-" + i).replaceAll("\\s+", "");
    }
    
    public String toVariableString() {
        String parametri = "";
        for (Object o : getParameters()) {
            PDDLObject po = (PDDLObject) o;
            parametri += "@" + po.getName();
            //parametri = parametri.concat(po.getName()).concat("_");
        }
        return ("ACTION" + this.name + parametri + "@").replaceAll("\\s+", "");
    }
    

    //This function regresses the cond passed as input according to the model of the action. The value of the parameter will be modified. So if you want to generate a new condition please clone before using the function
    public Conditions regressNew(Conditions cond) {

        AndCond result = null;

        /*Propositional Part first*/
        if (cond instanceof AndCond) {
            result = (AndCond) cond;
        } else {
            result = new AndCond();
            result.addConditions(cond);
        }


        /*probably something more efficient can be done here*/
        if (this.getAddList() != null) {
            for (Object o1 : this.getAddList().sons) {
                //System.out.println(result);
                result.sons.remove(o1);
                //System.out.println(result);
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

        //System.out.println(result);
        if (this.getPreconditions() != null) {
            result.sons.addAll(this.getPreconditions().sons);
        }

        //System.out.println(result);
        //AndCond numericCondition = 
        return result;

    }

    public boolean improve(Comparison t1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean improve(State init, Comparison t1) throws Exception {
        if (!this.mayInfluence(t1)) {
            //System.out.println("Does not influence...");
            return false;
        }

        //System.out.println("Trying with:"+this);
        this.normalize();
        Float currentD = init.distance2(t1);
        if (currentD.isNaN()) {
            //System.out.println("The value of the current distance is not defined");
            currentD = Float.MIN_VALUE;
        }
        Comparison regr = this.regressComparison((Comparison) t1.clone());
        regr.normalize();
//        System.out.println("Constraint:"+t1);
//        System.out.println("Regressed Constraint:"+regr);
        Float newDist = init.distance2(regr);
//        System.out.println("newDist:"+newDist);
//        System.out.println("prevDist:"+currentD);
        if (newDist > currentD) {

            return true;
        }
        return false;
    }

    public int improve_new(State init, Comparison t1) throws Exception {
        if (!this.mayInfluence(t1)) {
            //System.out.println("Does not influence...");
            return -1;
        }

//        System.out.println("Trying with:"+this);
        this.normalize();
        Float currentD = init.distance2(t1);

        Comparison regr = this.regressComparison((Comparison) t1.clone());
        regr.normalize();
        if (regr.isUnsatisfiable()) {
            return 0;
        }
//        System.out.println("Constraint:"+t1);
//        System.out.println("Regressed Constraint:"+regr);
        Float newDist = init.distance2(regr);
//        System.out.println("newDist:"+newDist);
//        System.out.println("prevDist:"+currentD);

        if (!newDist.isNaN() && currentD.isNaN()) {
            //System.out.println("The value of the current distance is not defined");
            return 1;
        }

        if (newDist > currentD) {

            return 1;
        }
        if (currentD.isNaN()) {
            //System.out.println("The value of the current distance is not defined");
            return 2;// this is the case in which the state has an undefined value.
        }
        return 0;
    }

    public Comparison improve2(State init, Comparison t1) throws Exception {
        if (!this.mayInfluence(t1)) {
            //System.out.println("Does not influence...");
            return null;
        }

        //System.out.println("Trying with:"+this);
        this.normalize();
        Float currentD = init.distance2(t1);
        if (currentD.isNaN()) {
            //System.out.println("The value of the current distance is not defined");
            currentD = Float.MIN_VALUE;
        }
        Comparison regr = this.regressComparison((Comparison) t1.clone());
        regr.normalize();
//        System.out.println("Constraint:"+t1);
//        System.out.println("Regressed Constraint:"+regr);
        Float newDist = init.distance2(regr);
//        System.out.println("newDist:"+newDist);
//        System.out.println("prevDist:"+currentD);
        if (newDist > currentD) {

            return regr;
        }
        return null;
    }

    private boolean numericEffectUndefined(RelState current) {
        return false;//to do!!!
    }

    public boolean simplifyModelWithControllableVariablesSem(PddlDomain domain, PddlProblem problem) throws Exception {
        
        
        HashMap invariantFluents = problem.getInvariantFluents();
        //add invariantFluents because free variable
        for (NumFluent nf : (Collection<NumFluent>)domain.getFree_functions()){
            invariantFluents.put(nf.getName(),Boolean.FALSE);
        }
        
        GroundAction a = this;
        //a.normalizeAndCopy();

        Conditions con = a.getPreconditions();
        con.setFreeVarSemantic(true);
//        System.out.println(con);
        con = con.weakEval(problem.getInit(), invariantFluents);
 
        if (con == null || con.isUnsatisfiable()){
//            if (con == null)
//                System.out.println("A precondition is never satisfiable; pruning"+a.toEcoString());
            return false;
        }
        
        Conditions eff = a.getNumericEffects();
        eff.setFreeVarSemantic(true);
        eff = eff.weakEval(problem.getInit(), invariantFluents);

        if (eff == null){
//            System.out.println("Pruning because of the effect");
            return false;
        }
        //System.out.println(a.toPDDL());
        a.normalize();
//        if (a.isUnsatisfiable())
//            return false;
        //System.out.println(a.toPDDL());
        return true;
    }

    void simplifyModelWithControllableVariablesSem_old(PddlDomain domain, PddlSCProblem problem) throws Exception {
        HashMap abstractInvariantFluents = domain.generateAbstractInvariantFluents();

        GroundAction a = this;
        //a.normalizeAndCopy();

        Conditions con = a.getPreconditions();
        Conditions eff = a.getNumericEffects();
//                    System.out.println(con);
//                    System.out.println(eff);
        con.setFreeVarSemantic(true);

        con = con.weakEval(problem.getInit(), abstractInvariantFluents);
        if (con == null) {
            this.setName("");
            return;
        }

        if (eff instanceof AndCond) {
            for (Object o2 : eff.sons) {
                NumEffect nEff = (NumEffect) o2;
                //System.out.println(nEff.getRight().getClass());
                Expression rValue = nEff.getRight();
                //System.out.println("before" + rValue);
                rValue = rValue.weakEval(problem.getInit(), abstractInvariantFluents);
                if (rValue == null) {
                    this.setName("");
                    return;
                }
                nEff.setRight(rValue);
                //System.out.println("after" + rValue);

            }
        } else {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        //System.out.println(a.toPDDL());
        a.normalize();
        //System.out.println(a.toPDDL());
    }

    public void addPreconditions(Conditions c) {
        if (this.getPreconditions() != null) {
            if (this.getPreconditions().sons != null) {
                this.getPreconditions().sons.add(c);
            } else {
                this.preconditions.sons = new LinkedHashSet();
                this.getPreconditions().sons.add(c);
            }
        } else {
            this.preconditions = new AndCond();
            this.preconditions.sons = new LinkedHashSet();
            this.getPreconditions().sons.add(c);
        }
    }

    private boolean effects_might_be_influenced() throws Exception {
        boolean ret = true;
        for (Object o : this.getNumericEffects().sons) {
            NumEffect nf = (NumEffect) o;
            //System.out.println("nf:"+nf.getRight().getClass());
            if (nf.getRight() instanceof NormExpression) {
                NormExpression ne = (NormExpression) nf.getRight();
                //System.out.println(ne);
                if (!ne.isNumber()) {
                    return true;
                }
            } else {
                if (!(nf.getRight() instanceof PDDLNumber)) {
                    //System.out.println(nf.getRight());
                    return true;
                }
            }
        }

        return false;
    }
    //this type of influence is on the rhs, that is it reasons on just complex dependencies
    public boolean is_complexly_influenced_by(GroundAction a) {
        for (Object o : this.getNumericEffects().sons) {
            NumEffect nf = (NumEffect) o;
            //System.out.println(nf);
            if (nf.getRight().involve(a.getNumericFluentAffected())) {
                return true;
            }
//            if ((nf.getOperator().equals("increase"))|| (nf.getOperator().equals("increase")) && (a.getNumericFluentAffected().contains(nf.getFluentAffected())))
//                return true;

        }
        return false;
    }

    public void addAchievedComparison(Conditions c_1) {
        if (this.achievedComparisons == null) {
            this.achievedComparisons = new HashSet();
        }
        this.achievedComparisons.add(c_1);
    }

    /**
     * @return the reacheable
     */
    public boolean isReacheable() {
        return reacheable;
    }

    /**
     * @param reacheable the reacheable to set
     */
    public void setReacheable(boolean reacheable) {
        this.reacheable = reacheable;
    }

    public boolean assign_unassigned_fluent(State s) {
        if (this.getNumericEffects() == null) {
            return false;
        }
        boolean some_change = false;
        //for (Conditions c = this.getNumericEffects().sons){
        ArrayList temporaryMod = new ArrayList();
        HashMap fun2numb = new HashMap();
        for (Object o : this.getNumericEffects().sons) {

            NumEffect all = (NumEffect) o;
            PDDLNumber newN;
            NumFluent f = all.getFluentAffected();
            if (s.functionValue(f) == null) {
                if (all.getOperator().equals("assign")) {
                    //System.out.println("================ASSIGN===========");
                    Float rValue = all.getRight().eval(s).getNumber();
                    newN = new PDDLNumber(rValue);
                    temporaryMod.add(f);
                    fun2numb.put(f, newN);
                    some_change = true;
                }

            }
        }
        for (Object o : temporaryMod) {
            NumFluent f = (NumFluent) o;
            PDDLNumber n = (PDDLNumber) fun2numb.get(f);
            s.setFunctionValue(f, n);
            //System.out.println(s.printFluentByName("in-at"));
        }

        return some_change;
    }


    public int getNumberOfExecution(State s_0, Comparison comp) {
        float a1;
        float b;
        
//        if (!this.interact_with(comp)){
//            return Integer.MAX_VALUE;
//        }
        if (!comp.involve(this.getNumericFluentAffected())){
            return Integer.MAX_VALUE;
        }
        

//        if (comp.eval_to_null(s_0)){
//            Comparison reg = this.regressComparison(comp);
//            if (s_0.satisfy(comp)){
//                return 1;
//            }
//        }
        
        a1 = comp.eval_not_affected(s_0,this);
        b = comp.eval_affected(s_0,this);
        if (b<0.0){
//            System.out.println(a1);
//            System.out.println(b);
//            //System.out.println("DEBUG:"+s_0);
//            System.out.println("DEBUG: "+this.toEcoString()+" is considered negative for:"+comp);
            return Integer.MAX_VALUE;//the action contributes negatively
        }

        //Assumption: comparisons are normalized!
        if (comp.getComparator().equals("=")){
            int m1 = (int)(-a1/b);
            if (m1 < 0 || a1%b !=0)
                return Integer.MAX_VALUE;
            else
                return m1;
        }else{//it is >= or >
            float m1 = -a1/b;
            if (m1 >= 0){
                if (comp.getComparator().equals(">"))
                    m1 += 1;
                return (int)Math.ceil(m1);
            }else
                return Integer.MAX_VALUE;
        }
    }
    
    public int getNumberOfExecutionWithoutCache(State s_0, Comparison comp) {
        float a1;
        float b;
        
//        if (!this.interact_with(comp)){
//            return Integer.MAX_VALUE;
//        }
        if (!comp.involve(this.getNumericFluentAffected())){
            return Integer.MAX_VALUE;
        }
        

//        if (comp.eval_to_null(s_0)){
//            Comparison reg = this.regressComparison(comp);
//            if (s_0.satisfy(comp)){
//                return 1;
//            }
//        }
        
        a1 = comp.eval_not_affected(s_0,this);
        b = comp.eval_affected(s_0,this);
        if (b<0.0){
//            System.out.println(a1);
//            System.out.println(b);
//            //System.out.println("DEBUG:"+s_0);
//            System.out.println("DEBUG: "+this.toEcoString()+" is considered negative for:"+comp);
            return Integer.MAX_VALUE;//the action contributes negatively
        }

        //Assumption: comparisons are normalized!
        if (comp.getComparator().equals("=")){
            int m1 = (int)(-a1/b);
            if (m1 < 0 || a1%b !=0)
                return Integer.MAX_VALUE;
            else
                return m1;
        }else{//it is >= or >
            float m1 = -a1/b;
            if (m1 >= 0){
                if (comp.getComparator().equals(">"))
                    m1 += 1;
                return (int)Math.ceil(m1);
            }else
                return Integer.MAX_VALUE;
        }
    }
    
    public int getBoundOnTheNumberOfExecution(State s_0, Comparison comp) {
        float a1;
        float b;
        
        if (!comp.involve(this.getNumericFluentAffected()))
            return Integer.MAX_VALUE;
//        if (comp.eval_to_null(s_0)){
//            Comparison reg = this.regressComparison(comp);
//            if (s_0.satisfy(comp)){
//                return 1;
//            }
//        }
        a1 = comp.eval_not_affected(s_0,this);
        b = comp.eval_affected(s_0,this);
//        System.out.println(a1);
//        System.out.println(b);
        //Assumption: comparisons are normalized!
        if (comp.getComparator().equals("=")){
            int m1 = (int)(-a1/b);
            if (m1 < 0 || a1%b !=0)
                return Integer.MAX_VALUE;
            else
                return m1;
        }else{//it is >= or >
            float m1 = -a1/b;
            if (m1 >= 0){
                if (comp.getComparator().equals(">"))
                    m1 += 1;
                return (int)Math.ceil(m1);
            }else
                return Integer.MAX_VALUE;
        }
    }
    
    

    public Float getCoefficientAffected(NumFluent f) {
        this.generateCoefficeintAffected();
        return this.coefficientAffected.get(f);
    }

    private void generateCoefficeintAffected() {
        
        if (coefficientAffected!=null)
            return;
        if (this.getNumericEffects()==null)
            return;

        coefficientAffected = new HashMap();
        for (Object c : this.getNumericEffects().sons){
            NumEffect nEff = (NumEffect)c;
            NormExpression right = (NormExpression)nEff.getRight();
            if (nEff.getOperator().equals("increase") || nEff.getOperator().equals("decrease"))
                coefficientAffected.put(nEff.getFluentAffected(),1+right.getCoefficient(nEff.getFluentAffected()));
            else
                coefficientAffected.put(nEff.getFluentAffected(),right.getCoefficient(nEff.getFluentAffected()));
        }
               
    }

    public Float getValueOfRightExpApartFromAffected(NumFluent f, State s_0) {
        for (Object c : this.getNumericEffects().sons){
            NumEffect nEff = (NumEffect)c;
            if (nEff.getFluentAffected().equals(f)){
                NormExpression right = (NormExpression)nEff.getRight();
                if (nEff.getOperator().equals("increase")){
                    return right.eval_apart_from_f(f,s_0);
                }else if (nEff.getOperator().equals("decrease")){
                    return right.eval_apart_from_f(f,s_0)*-1.0f;

                }
                return right.eval_apart_from_f(f,s_0);
            }
            
        }
        System.err.println("Some errors occured");
        System.exit(-1);
        return null;
    }

    /**
     * @return the action_cost
     */
    public float getAction_cost() {
        return action_cost;
    }
    
    public void setAction_cost(State s_0){
        if (true){
            action_cost = 1;
            return;
        }
        
        if (action_cost == 0){
            if (this.getNumericEffects() != null){
                AndCond temp = (AndCond)this.getNumericEffects();
                for (NumEffect e: (LinkedHashSet<NumEffect>)temp.sons){
                    if (e.getFluentAffected().getName().equals("total-cost")){
                        action_cost = Math.max(e.getRight().eval(s_0).getNumber(),1);
                        return;
                    }
                }  
            }
            action_cost = 1;
        }
        
    }

    /**
     * @param action_cost the action_cost to set
     */
    public void setAction_cost(float action_cost) {
        this.action_cost = action_cost;
    }

    public NumEffect getAffectorOf(NumFluent f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void addNumericFluentAffected(NumFluent fluentAffected) {
        if (this.numericFluentAffected == null){
            this.numericFluentAffected = new HashMap();
        }
        this.numericFluentAffected.put(fluentAffected,Boolean.TRUE);
    }

    public Comparison regressComparisonMtimes(Comparison comparison) {
        
        AndCond temp = new AndCond();
        if (this.getNumericEffects() != null){
            for (NumEffect ne: (Collection<NumEffect>) this.getNumericEffects().sons){
                NumFluent m = new NumFluent(this.toVariableString());//generate the variable capturin the m repetition
                temp.sons.add(ne.generate_m_times_extension(m));//assuming that m is an integer
            }
        }
        GroundAction grTemp = new GroundAction();
        grTemp.setNumericEffects(temp);
        return grTemp.regressComparison(comparison);
        
    }

    public boolean depends_on(GroundAction ele) {
        if (this.getNumericEffects()==null)
            return false;
        for (NumEffect ne : (Collection<NumEffect>)this.getNumericEffects().sons){
//            if (ne.getOperator().equals("increase") || (ne.getOperator().equals("decrease"))){
//                if (ne.getFluentAffected().involve(ele.numericFluentAffected))
//                    return true;
//            }
            
            ele.generateAffectedNumFluents();
            if (ne.getRight().involve(ele.numericFluentAffected))
                return true;   
        }
        return false;
    }

    private boolean interact_with(Comparison comp) {
        Boolean ret = interact_with.get(comp.getCounter());
        if (ret==null){
            if (comp.involve(this.getNumericFluentAffected())){
                interact_with.put(comp.getCounter(),Boolean.TRUE);
                return true;
            }else{
                interact_with.put(comp.getCounter(),Boolean.FALSE);
                return false;
            }
        }
        return ret;
    } 

}

/*********************************************************************
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 * 
 *********************************************************************/

/*********************************************************************
 * Description: Part of the PPMaJaL library
 *             
 * Author: Enrico Scala 2013
 * Contact: enricos83@gmail.com
 *
 *********************************************************************/ 
package problem;

import conditions.AndCond;
import conditions.Comparison;
import conditions.Conditions;
import conditions.NotCond;
import conditions.PDDLObject;
import conditions.Predicate;

import domain.ActionParametersAsTerms;
import domain.GenericActionType;
import expressions.NumEffect;
import expressions.NumFluent;
import expressions.PDDLNumber;
import expressions.PDDLNumbers;
import java.util.ArrayList;
import java.util.HashMap;

public class GroundAction extends GenericActionType {

    protected ActionParametersAsTerms parameters;
    public boolean normalized;
    private ArrayList numericFluentAffected;

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
        ret.numericEffects = this.numericEffects.clone();
        ret.numericFluentAffected = (ArrayList) this.numericFluentAffected.clone();
        ret.parameters = (ActionParametersAsTerms) this.parameters.clone();
        ret.preconditions = this.preconditions.clone();
        return ret;

    }

    public GroundAction() {
        super();
        this.name = null;
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
        State ret = s;
//        if (!this.isApplicable(ret)){
//            //System.out.println("Action: " + this + "  is not applicable");
//            return null;
//        }
        AndCond add = (AndCond) addList;
        if (add != null) {
            ret = add.apply(s);
        }
        AndCond del = (AndCond) delList;
        if (del != null) {
            ret = del.apply(s);
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

            }

        }
        return ret;
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

    public void normalize() {


        AndCond temp = new AndCond();
        
        

        if (this.preconditions instanceof Predicate) {
            temp.sons.add(this.preconditions);
        } else if (this.preconditions instanceof Comparison) {
                Comparison c = (Comparison) this.preconditions;
                c = c.normalizeAndCopy();
                if (c!= null)
                    temp.sons.add(c);
        } else {
                
            for (Object o : this.preconditions.sons) {
                if (o instanceof Comparison) {
                    Comparison c = (Comparison) o;

                    c = c.normalizeAndCopy();
                    if (c!= null)
                        temp.sons.add(c);
                }else if (o instanceof Predicate){
                    temp.sons.add(o);
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
                PDDLNumbers current = s.functionValues(f);
                if ((current == null) && (!(all.getOperator().equals("assign")))) {
                    System.out.println(f + "  is not present in the current state");
                }
                PDDLNumbers eval = all.getRight().eval(s);


                if (all.getOperator().equals("increase")) {
                    after.inf = new PDDLNumber(Math.min(current.sum(eval).inf.getNumber(), current.inf.getNumber()));
                    after.sup = new PDDLNumber(Math.max(current.sum(eval).sup.getNumber(), current.sup.getNumber()));

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

    public GroundAction macroOperator(GroundAction b) throws CloneNotSupportedException {

        if (this.name == null) {
            return (GroundAction) b.clone();
        }


        GroundAction a = this;
        GroundAction ab = new GroundAction(a.name + "_" + b.name);

        ab.setParameters((ActionParametersAsTerms) a.getParameters().clone());
        ab.getParameters().addALLNewObjects(b.getParameters());

        ab.setPreconditions(regress(b, a));
        progress(a, b, ab);

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
                c.setFirst(c.getFirst().subst(a.getNumericEffects()));
                c.setTwo(c.getTwo().subst(a.getNumericEffects()));

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

        AndCond result = (AndCond)cond;

        /*probably something more efficient can be done here*/
        for (Object o1 : this.getAddList().sons) {
            result.sons.remove(o1);
        }
        for (Object o1 : result.sons) {

            //Numeric part. Substitution of variables
            if (o1 instanceof Comparison) {
                Comparison c = (Comparison) o1;
                c.setFirst(c.getFirst().subst(this.getNumericEffects()));
                c.setTwo(c.getTwo().subst(this.getNumericEffects()));

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
        ret += ":precondition " + this.getPreconditions().pddlPrint() + "\n";
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
        for (Object o : this.getAddList().sons) {
            Predicate p = (Predicate) o;
            ret += p.pddlPrint();
        }
        for (Object o : this.getDelList().sons) {
            NotCond p = (NotCond) o;
            ret += p.pddlPrint();
        }
        for (Object o : this.getNumericEffects().sons) {
            NumEffect nE = (NumEffect) o;
            ret += nE.pddlPrint();

        }

        return ret + ")";
    }
}

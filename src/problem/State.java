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
import conditions.NumFluentValue;
import conditions.Comparison;
import conditions.Conditions;
import conditions.PDDLObject;
import conditions.Predicate;
import expressions.ExtendedAddendum;
import expressions.ExtendedNormExpression;
import expressions.Interval;
import expressions.NumEffect;
import expressions.NumFluent;
import expressions.PDDLNumber;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author enrico
 */
public class State extends Object {

    HashMap propositions;
    HashMap<NumFluent,PDDLNumber> numericFs;
    HashSet timedLiterals;
    private NumFluent time;

    public State() {
        super();
        propositions = new HashMap();
        numericFs = new HashMap();
        
        timedLiterals = new HashSet();
    }

    @Override
    public String toString() {
        return "State{" + "propositions=" + propositions + "numericFs=" + numericFs + "timedLiterals=" + timedLiterals + '}';
    }

    @Override
    public State clone() throws CloneNotSupportedException {
        State ret_val = new State();

        for (NumFluent o : this.numericFs.keySet()) {
            ret_val.numericFs.put(o, this.numericFs.get(o));
        }

        
        for (Predicate o :(Collection<Predicate>) this.propositions.keySet()) {
            //ret_val.addProposition((Predicate) ele.clone());
            ret_val.propositions.put(o, this.propositions.get(o));
//            ret_val.addProposition((Predicate) ele.clone());
        }
        //ret_val.propositions = (HashSet) this.propositions.clone();

        ret_val.timedLiterals = (HashSet) this.timedLiterals.clone();

        return ret_val;
    }

    public Iterable<NumFluent> getNumericFluents() {
        return numericFs.keySet();
    }

    public PDDLNumber functionValue(NumFluent f) {
        return numericFs.get(f);

    }

    public void addProposition(Predicate buildInstPredicate) {
        propositions.put(buildInstPredicate, true);
    }

    public void addNumericFluent(NumFluentValue a) {
        numericFs.put(a.getNFluent(), a.getValue());
    }

    void addTimedLiteral(Predicate buildInstPredicate) {
        timedLiterals.add(buildInstPredicate);
    }

    public Iterable<Predicate> getPropositions() {
        return this.propositions.keySet();

    }

    public boolean is_true(Predicate aThis) {

        Boolean b = (Boolean) propositions.get(aThis);
        if (b != null) {
            return b;
        }
        return false;
    }

    public void setFunctionValue(NumFluent f, PDDLNumber after) {
        this.numericFs.put(f,after);

    }

    public void removeProposition(Predicate aThis) {
        propositions.remove(aThis);
    }
    
     public String pddlPrintWithDummyTrue() {
        String ret = "(:init (true)\n";

        for (Object o : this.getPropositions()) {
            Predicate a = (Predicate) o;
            ret = ret.concat("  (" + a.getPredicateName());
            for (Object o1 : a.getTerms()) {
                PDDLObject obj = (PDDLObject) o1;
                ret = ret.concat(" " + obj.getName());
            }
            ret = ret.concat(")\n");
        }
        for (Object o : this.getNumericFluents()) {
            NumFluentValue a = (NumFluentValue) o;
            ret = ret.concat("  ( = (" + a.getNFluent().getName());
            for (Object o1 : a.getNFluent().getTerms()) {
                PDDLObject obj = (PDDLObject) o1;
                ret = ret.concat(" " + obj.getName());
            }
            ret = ret.concat(") " + a.getValue().pddlPrint(false) + ")\n");
        }

        ret = ret.concat(")");
        return ret;
    }

    public String pddlPrint() {
        String ret = "(:init \n";

        for (Object o : this.getPropositions()) {
            Predicate a = (Predicate) o;
            ret = ret.concat("  (" + a.getPredicateName());
            for (Object o1 : a.getTerms()) {
                PDDLObject obj = (PDDLObject) o1;
                ret = ret.concat(" " + obj.getName());
            }
            ret = ret.concat(")\n");
        }
        for (Object o : this.getNumericFluents()) {
            NumFluentValue a = (NumFluentValue) o;
            ret = ret.concat("  ( = (" + a.getNFluent().getName());
            for (Object o1 : a.getNFluent().getTerms()) {
                PDDLObject obj = (PDDLObject) o1;
                ret = ret.concat(" " + obj.getName());
            }
            ret = ret.concat(") " + a.getValue().pddlPrint(false) + ")\n");
        }

        ret = ret.concat(")");
        return ret;
    }

    public void generateNewProblemFile(String srcPath, String destPath) throws FileNotFoundException, IOException {

        Reader input = new BufferedReader(new FileReader(srcPath));

        Scanner sc = new Scanner(input);
        Writer output = new BufferedWriter(new FileWriter(destPath));
        output.write("\n");
        boolean initskipped = false;
        boolean goalStarted = false;

        while (sc.hasNext()) {
            if ((initskipped) && (goalStarted)) {
                output.write(sc.nextLine());
            } else {
                if (!initskipped) {
                    if ((sc.findInLine(":init") != null)) {
                        initskipped = true;
                        sc.next();
                        output.write("\n" + this.pddlPrint());
                    } else {
                        output.write(sc.nextLine());//prima dello skip
                    }
                } else {
                    if (sc.findInLine(":goal") != null) {
                        goalStarted = true;
                        output.write("\n(:goal " + sc.nextLine());//dopo il goal
                    } else {
                        sc.nextLine();
                    }
                }
            }
        }
        output.close();

    }

    public boolean satisfy(AndCond con) {
        return con.isSatisfied(this);
    }

    public boolean satisfyNumerically(AndCond con) {

        for (Object o : con.sons) {

            if (o instanceof Comparison) {
                Comparison c = (Comparison) o;
                if (!c.isSatisfied(this)) {
                    //System.out.println(c + "is not satisfied in " +this);
                    return false;
                }

            }

        }
        return true;

    }

    public boolean satisfy(Conditions input) {

        
        return input.isSatisfied(this);

    }

    public boolean whatIsNotsatisfied(AndCond con) {

        boolean ret = true;

        for (Object o : con.sons) {

            if (o instanceof Comparison) {
                Comparison c = (Comparison) o;
                if (!c.isSatisfied(this)) {
                    System.out.println(c + "is not satisfied ");
                    ret = false;
                }

            } else if (o instanceof Predicate) {
                if (!this.is_true((Predicate) o)) {
                    System.out.println(o + "is not satisfied");
                    ret = false;
                }

            }

        }
        return ret;

    }

    public RelState relaxState() {
        RelState ret_val = new RelState();

        for (NumFluent o : this.numericFs.keySet()) {

            ret_val.poss_numericFs.put(o, new Interval(this.numericFs.get(o).getNumber()));
        }

        for (Object o : this.propositions.keySet()) {
            Predicate ele = (Predicate) o;
            ret_val.poss_interpretation.put(ele,1);
        }
        //ret_val.propositions = (HashSet) this.propositions.clone();

        ret_val.timedLiterals = (HashSet) this.timedLiterals.clone();

        return ret_val;

    }

    //TO do
    void invariantAnalysis(Set grActions) {

        for (Object o : grActions) {
            GroundAction gr = (GroundAction) o;
            Conditions add = gr.getAddList();
            Conditions del = gr.getDelList();
            Conditions num = gr.getNumericEffects();
        }

    }

    public String printFluentByName(String input) {
        String ret = "";

        for (Object o : this.numericFs.keySet()) {
            NumFluent nf = (NumFluent) o;
            if (nf.getName().equals(input)) {
                ret = ret + this.numericFs.get(nf);

            }

        }
        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final State other = (State) obj;

        
        for (NumFluent nf : this.getNumericFluents()) {
//            if (!ass_init.getTwo().equals(other.functionValue(ass_init.getNFluent()))) {
//                return false;
//            }
//            if (Math.abs(ass_init.getTwo().getNumber() - other.functionValue(ass_init.getNFluent()).getNumber()) > 0.0001) 
//            {
//                return false;
//            }
            if (other.functionValue(nf)==null && this.numericFs.get(nf)==null){
//                System.out.println("Error!!:"+ass_init.getNFluent());
                continue;
            }
            if (!this.numericFs.get(nf).getNumber().equals(other.functionValue(nf).getNumber())) 
            {
                return false;
            }
        }
        for (Object o : this.getPropositions()) {
            Predicate p = (Predicate) o;
            if (this.is_true(p)) {
                if (!other.is_true(p)) {

                    return false;
                }
            }

        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.propositions != null ? this.propositions.hashCode() : 0);
        hash = 89 * hash + (this.numericFs != null ? this.numericFs.hashCode() : 0);
        return hash;
    }



    public String printValueOfTheFluentByName(String input) {
        String ret = "";

        for (Object o : this.numericFs.keySet()) {
            NumFluent nf = (NumFluent) o;
            if (nf.getName().equals(input)) {
                ret += this.numericFs.get(nf).getNumber();

            }

        }
        return ret;
    }

    public AndCond toAndCondition() {
        AndCond ret = new AndCond();

        Iterator it = this.getPropositions().iterator();
        while (it.hasNext()) {
            Predicate p = (Predicate) it.next();
            if (this.is_true(p)) {
                ret.sons.add(p);
            }
        }
        return ret;

    }

    public Set compare(State init) {
        Set diff = new HashSet();
        Iterator it = this.getPropositions().iterator();
        while (it.hasNext()) {
            Predicate p = (Predicate) it.next();
            if (!init.is_true(p)) {
                diff.add(p);
            }

        }
        it = init.getPropositions().iterator();
        while (it.hasNext()) {
            Predicate p = (Predicate) it.next();
            if (!this.is_true(p)) {
                diff.add(p);
            }

        }
        return diff;
    }

    public boolean removeNumericFluent(NumFluentValue f) {
        this.numericFs.remove(f);
        return true;
    }

    public Float distance(AndCond firstKernelCondition) {

        Float total = new Float(0.0);
        for (Object o : firstKernelCondition.sons) {
            if (o instanceof Comparison) {
                Comparison comp = (Comparison) o;
                if ((comp.getRight() instanceof ExtendedNormExpression) && (comp.getLeft() instanceof ExtendedNormExpression)) {
                    ExtendedNormExpression lExpr = (ExtendedNormExpression) comp.getLeft();
                    Float num = new Float(0.0);
                    Float den = new Float(0.0);
                    for (ExtendedAddendum a : lExpr.summations) {
                        if (a.f == null) {
                            num += a.n.getNumber();
                        } else {
                            PDDLNumber evaluation = (PDDLNumber) a.f.eval(this);
                            //System.out.println("Evaluation of " + a.f +" "+evaluation);
                            num += a.n.getNumber() * evaluation.getNumber();
                            //System.out.println("Coefficient: " + a.n );
                            //System.out.println(num);
                            den += new Float(Math.pow(a.n.getNumber(), 2));
                        }
                    }
                    //System.out.println("Comparison under process: " + comp);
                    //System.out.println("Num: " + num +" Den: "+den);
                    //System.out.println("Dist: " +  new Float(1.0)/ ( new Float(Math.abs(num))/(new Float(Math.pow(den,0.5)))));

                    /*Contribution of each comparison*/
                    total += new Float(1.0) / (new Float(Math.abs(num)) / (new Float(Math.pow(den, 0.5))));

                } else {
                    System.out.println("Comparison must be normalized for computing the euclidean distance");
                    System.exit(-1);
                }
            }

        }
        return total;

    }

    public Float normalizedRisk(Conditions conditions, RelState numericFleuntsBoundaries, String distStrategy, boolean preprocessMaxs) {
        Float total = new Float(0.0);

        String threateningConstraint = new String();
        if (conditions instanceof AndCond) {
            for (Object o : conditions.sons) {
                if (o instanceof Comparison) {
                    Comparison comp = (Comparison) o;

                    if ((comp.getRight() instanceof ExtendedNormExpression) && (comp.getLeft() instanceof ExtendedNormExpression)) {
                        ExtendedNormExpression lExpr = (ExtendedNormExpression) comp.getLeft();
                        Float num = new Float(0.0);
                        Float den = new Float(0.0);
                        //Float den = new Float(0.0);
                        //checking for collapsed constraints (6>4)
                        boolean collapsed = true;
                        for (ExtendedAddendum a : lExpr.summations) {
                            if (a.f == null) {
                                num += a.n.getNumber();
                            } else {
                                PDDLNumber evaluation = (PDDLNumber) a.f.eval(this);
                                //System.out.println("Evaluation of " + a.f +" "+evaluation);
                                num += a.n.getNumber() * evaluation.getNumber();
                                den += (float) Math.pow(a.n.getNumber(), 2);
                                //System.out.println("Coefficient: " + a.n );
                                //System.out.println(num);
                                //den += new Float(Math.pow(a.n.getNumber(),2));
                                collapsed = false;
                            }
                        }
                        //System.out.println("Comparison under process: " + comp);
                        //System.out.println("Num: " + num +" Den: "+den);
                        //System.out.println("Dist: " +  new Float(1.0)/ ( new Float(Math.abs(num))/(new Float(Math.pow(den,0.5)))));

                        /*Contribution of each comparison*/
                        Float dist = Math.abs(num);///(float)Math.sqrt((double)den);
                        num = new Float(0.0);
                        Float maxDist = new Float(0.0);

                        if (comp.maxDist == null) {
                            for (ExtendedAddendum a : lExpr.summations) {
                                if (a.f == null) {
                                    num += Math.abs(a.n.getNumber());
                                } else {
                                    num += Math.max(Math.abs(a.n.getNumber() * numericFleuntsBoundaries.functionInfValue(a.f).getNumber()), Math.abs(a.n.getNumber() * numericFleuntsBoundaries.functionSupValue(a.f).getNumber()));
                                }
                            }
                            if (preprocessMaxs) {

                                //System.out.println("A bug somewhere...exiting ("+comp.pddlPrint(true)+")");
                                //System.exit(-1);
                            }
                            maxDist = Math.abs(num);
                        } else {
                            //System.out.println("UNO ALMENO L'HA TROVATO");
                            maxDist = comp.maxDist;
                        }

                        //System.out.println("Distance: "+dist);
                        //System.out.println("Max Distance: "+maxDist);
                        if (distStrategy.equals("sum")) {
                            total += maxDist / dist;
                            //total += (float)1 - (float)(dist/Math.max(maxDist,dist));
                        } else if (distStrategy.equals("max")) {
                            if ((comp.getComparator().equals(">=") || comp.getComparator().equals("<="))) {
                                //System.out.println("Constraints Adjusted");
                                dist = dist + (float) 0.00000000001;
                            }
                            if (!collapsed) {
                                threateningConstraint = comp.toString();
                                total = Math.max((float) 1 - (float) (dist / maxDist), total);
                            } else {
                                //System.out.println(comp + "============================================= Collapsed!!!!!");

                            }

                        }

                    } else {
                        System.out.println("Comparison must be normalized for computing the euclidean distance");
                        System.exit(-1);
                    }
                }

            }
        }

        //System.out.println("the responsible for the risk is: "+threateningConstraint);
        return total;

    }

    public Float normalizedDist(Conditions conditions, RelState numericFleuntsBoundaries, String distStrategy) {
        Float total = new Float(0.0);

        if (conditions instanceof AndCond) {
            for (Object o : conditions.sons) {
                if (o instanceof Comparison) {
                    Comparison comp = (Comparison) o;

                    if (distStrategy.equals("sum")) {
                        total += comp.getDistance(this, numericFleuntsBoundaries);

                    } else if (distStrategy.equals("max")) {
                        total = Math.max(comp.getDistance(this, numericFleuntsBoundaries), total);
                        //System.out.println("Distance: "+dist);
                    } else if (distStrategy.equals("min")) {
                        total = Math.max(comp.getDistance(this, numericFleuntsBoundaries), total);
                        //System.out.println("Distance: "+dist);
                    }

                }
            }
        } else {
            if (conditions instanceof Comparison) {
                Comparison comp = (Comparison) conditions;

                if (distStrategy.equals("sum")) {
                    total += comp.getDistance(this, numericFleuntsBoundaries);

                } else if (distStrategy.equals("max")) {
                    total = Math.max(comp.getDistance(this, numericFleuntsBoundaries), total);
                    //System.out.println("Distance: "+dist);
                }

            }

        }
        return total;

    }

    public Float normalizedRiskViaPlanBounds(AndCond conditions, String distStrategy) {
        Float total = new Float(0.0);

        String threateningConstraint = new String();
        if (conditions instanceof AndCond) {
            for (Object o : conditions.sons) {
                if (o instanceof Comparison) {
                    Comparison comp = (Comparison) o;

                    if ((comp.getRight() instanceof ExtendedNormExpression) && (comp.getLeft() instanceof ExtendedNormExpression)) {
                        ExtendedNormExpression lExpr = (ExtendedNormExpression) comp.getLeft();
                        Float num = new Float(0.0);
                        Float den = new Float(0.0);
                        //Float den = new Float(0.0);
                        //checking for collapsed constraints (6>4)
                        boolean collapsed = true;
                        for (ExtendedAddendum a : lExpr.summations) {
                            if (a.f == null) {
                                num += a.n.getNumber();
                            } else {
                                PDDLNumber evaluation = (PDDLNumber) a.f.eval(this);
                                //System.out.println("Evaluation of " + a.f +" "+evaluation);
                                num += a.n.getNumber() * evaluation.getNumber();
                                den += (float) Math.pow(a.n.getNumber(), 2);
                                //System.out.println("Coefficient: " + a.n );
                                //System.out.println(num);
                                //den += new Float(Math.pow(a.n.getNumber(),2));
                                collapsed = false;
                            }
                        }
                        //System.out.println("Comparison under process: " + comp);
                        //System.out.println("Num: " + num +" Den: "+den);
                        //System.out.println("Dist: " +  new Float(1.0)/ ( new Float(Math.abs(num))/(new Float(Math.pow(den,0.5)))));

                        /*Contribution of each comparison*/
                        Float dist = Math.abs(num);///(float)Math.sqrt((double)den);
                        num = new Float(0.0);
                        Float maxDist = new Float(0.0);

                        //System.out.println("UNO ALMENO L'HA TROVATO");
                        maxDist = comp.maxDist;

                        //System.out.println("Distance: "+dist);
                        //System.out.println("Max Distance: "+maxDist);
                        if (distStrategy.equals("sum")) {
                            total += maxDist / dist;
                            //total += (float)1 - (float)(dist/Math.max(maxDist,dist));
                        } else if (distStrategy.equals("max")) {
                            if ((comp.getComparator().equals(">=") || comp.getComparator().equals("<="))) {
                                //System.out.println("Constraints Adjusted");
                                dist = dist + (float) 0.00000000001;
                            }
                            if (!collapsed) {
                                threateningConstraint = comp.toString();
                                //System.out.println(maxDist);
                                total = Math.max((float) 1 - (float) (dist / maxDist), total);
                            } else {
                                //System.out.println(comp + "============================================= Collapsed!!!!!");

                            }

                        }

                    } else {
                        System.out.println("Comparison must be normalized for computing the euclidean distance");
                        System.exit(-1);
                    }
                }

            }
        }

        //System.out.println("the responsible for the risk is: "+threateningConstraint);
        return total;
    }

    public Float distance(Conditions c) {
        Comparison comp = (Comparison) c;
        if ((comp.getRight() instanceof ExtendedNormExpression) && (comp.getLeft() instanceof ExtendedNormExpression)) {
            ExtendedNormExpression lExpr = (ExtendedNormExpression) comp.getLeft();
            Float num = new Float(0.0);
            Float den = new Float(0.0);
            for (ExtendedAddendum a : lExpr.summations) {
                if (a.f == null) {
                    num += a.n.getNumber();
                } else {
                    if (a.f.eval(this) == null) {
                        //System.out.println("Eccolo");
                        return (float) -1000000000000.0;
                    }
                    PDDLNumber evaluation = (PDDLNumber) a.f.eval(this);
                    //System.out.println("Evaluation of " + a.f +" "+evaluation);
                    //if (evaluation.getNumber() != 0){
                    num += a.n.getNumber() * evaluation.getNumber();
                    //System.out.println("Coefficient: " + a.n );
                    //System.out.println(num);
                    den += new Float(Math.pow(a.n.getNumber(), 2));
                    //}
                }
            }
            //System.out.println("Comparison under process: " + comp);
            //System.out.println("Dist: " +  new Float(1.0)/ ( new Float(Math.abs(num))/(new Float(Math.pow(den,0.5)))));

            /*Contribution of each comparison*/
            if (num == 0.0) {
                return new Float(0.0);
            }
            if (this.satisfy(c)) {
                //System.out.println("Num: " + 1.0*num +" Den: "+den);
                //System.out.println("Seems to be satisfied...");
                return new Float(1.0) * (new Float(Math.abs(num)) / (new Float(Math.pow(den, 0.5))));
            } else {
                //System.out.println("not satisfied");
                //System.out.println("Num: " + (-1.0)*num +" Den: "+den);
                Float ret = new Float(-1.0) * (new Float(Math.abs(num)) / (new Float(Math.pow(den, 0.5))));
                if (ret == Float.NaN) {
                    System.out.println("Errors in checking the result of the division");
                }
                if (ret == 0.0) {
                    ret = (float) -0.000000000001;//this is our epsilon
                }
                return ret;
            }

        } else {
            System.out.println("Comparison must be normalized for computing the euclidean distance");
            System.exit(-1);
        }
        return null;
    }

    public Float distance2(Conditions c) {
        Comparison comp = (Comparison) c;
        if ((comp.getRight() instanceof ExtendedNormExpression) && (comp.getLeft() instanceof ExtendedNormExpression)) {
            ExtendedNormExpression lExpr = (ExtendedNormExpression) comp.getLeft();
            Float num = new Float(0.0);
            Float den = new Float(1.0);
            for (ExtendedAddendum a : lExpr.summations) {
                if (a.f == null) {
                    num += a.n.getNumber();
                } else {
                    if (a.f.eval(this) == null) {
                        //System.out.println("Eccolo");
                        return Float.NaN;//optimistic assumption
                    }
                    PDDLNumber evaluation = (PDDLNumber) a.f.eval(this);
                    //System.out.println("Evaluation of " + a.f +" "+evaluation);
                    //if (evaluation.getNumber() != 0){
                    num += a.n.getNumber() * evaluation.getNumber();
                                //System.out.println("Coefficient: " + a.n );
                    //System.out.println(num);
                    //den += new Float(Math.pow(a.n.getNumber(), 2));
                    //}
                }
            }
            //System.out.println("Comparison under process: " + comp);
            //System.out.println("Dist: " +  new Float(1.0)/ ( new Float(Math.abs(num))/(new Float(Math.pow(den,0.5)))));

            /*Contribution of each comparison*/
            if (num == 0.0) {
                if (this.satisfy(c)) {
                    return new Float(0.00000001);
                } else {
                    return new Float(-0.00000001);
                }
            }
            if (this.satisfy(c)) {
                //System.out.println("Num: " + 1.0*num +" Den: "+den);
                //System.out.println("Seems to be satisfied...");
                return new Float(1.0) * (new Float(Math.abs(num)) / (new Float(Math.pow(den, 0.5))));
            } else {
                //System.out.println("not satisfied");
                //System.out.println("Num: " + (-1.0)*num +" Den: "+den);
                Float ret = new Float(-1.0) * (new Float(Math.abs(num)) / (new Float(Math.pow(den, 0.5))));
                if (ret == Float.NaN) {
                    System.out.println("Errors in checking the result of the division");
                }
                if (ret == 0.0) {
                    ret = (float) -0.000000000001;//this is our epsilon
                }
                return ret;
            }

        } else {
            System.out.println("Comparison must be normalized for computing the euclidean distance");
            System.exit(-1);
        }
        return null;
    }

    public GroundAction transformInAction() {
        GroundAction a = new GroundAction("InitAction");

        AndCond addList = new AndCond();
        AndCond numericEffects = new AndCond();

        for (Object o : this.propositions.keySet()) {
            Predicate p = (Predicate) o;
            addList.addConditions(p);
        }
        for (Object o : this.numericFs.keySet()) {
            NumFluent f = (NumFluent) o;

            NumEffect b = new NumEffect("assign");
            b.setFluentAffected(f);

            b.setRight( numericFs.get(f));
            numericEffects.addExpression(b);
        }
        a.setAddList(addList);
        a.setNumericEffects(numericEffects);

        return a;

    }

    public void updateValues(HashSet<NumFluent> toUpdate, State temp) {
        for (NumFluent n : toUpdate) {
            this.setFunctionValue(n, temp.functionValue(n));
        }
    }

    public void addTimeFluent() {
        this.time = new NumFluent("time_elapsed");
        numericFs.put(this.time, new PDDLNumber(new Float(0.0)));
    }

    /**
     * @return the time
     */
    public NumFluent getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(NumFluent time) {
        this.time = time;
    }

    void increase_time_by_epsilon() {
        Float new_value  = this.numericFs.get(time).getNumber()+0.1f;
        this.numericFs.put(time, new PDDLNumber(new_value));
    }

    public Collection<Predicate> getPropositionsAsSet() {
        return new LinkedHashSet(this.propositions.keySet());
    }

}

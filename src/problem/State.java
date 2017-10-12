/* 
 * Copyright (C) 2010-2017 Enrico Scala. Contact: enricos83@gmail.com.
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
package problem;

import conditions.AndCond;
import conditions.NumFluentValue;
import conditions.Comparison;
import conditions.Condition;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author enrico
 */
public class State extends AbstractState {

    HashMap propositions;
    private HashMap<NumFluent, PDDLNumber> num_fluents_initial_values;
    public ArrayList<PDDLNumber> current_fluent_values;
    HashSet timedLiterals;
    private NumFluent time;
    protected Integer hash;

    public State() {
        super();
        propositions = new HashMap();
        num_fluents_initial_values = new HashMap();
        timedLiterals = new HashSet();
        this.current_fluent_values = new ArrayList();
    }

    @Override
    public String toString() {
        return "State{" + "propositions=" + propositions + "numericFs=" + getNum_fluents_value() + "timedLiterals=" + timedLiterals + '}';
    }

    @Override
    public State clone() throws CloneNotSupportedException {
        State ret_val = new State();

        ret_val.num_fluents_initial_values = this.getNum_fluents_value();

        ret_val.propositions = (HashMap) this.propositions.clone();

//        for (Predicate o :(Collection<Predicate>) this.propositions.keySet()) {
//            //ret_val.addProposition((Predicate) ele.clone());
//            ret_val.propositions.put(o, this.propositions.get(o));
////            ret_val.addProposition((Predicate) ele.clone());
//        }
        //ret_val.propositions = (HashSet) this.propositions.clone();
        ret_val.timedLiterals = (HashSet) this.timedLiterals.clone();
        ret_val.time = this.time;
        ret_val.current_fluent_values = (ArrayList<PDDLNumber>) this.current_fluent_values.clone();
        return ret_val;
    }

    public Iterable<NumFluent> getNumericFluents() {
        return getNum_fluents_value().keySet();
    }

    public PDDLNumber static_function_value(NumFluent f) {
        return getNum_fluents_value().get(f);

    }

    public PDDLNumber functionValue(NumFluent f) {
        if (f.getId() == null) {
            return null;
        }
        if (f.getId() == null || f.getId() >= this.current_fluent_values.size()) {
            System.out.println("Error here: " + f + "this is probably when comparing " + f.getId());
            return null;
        }
        return this.current_fluent_values.get(f.getId());

    }

    public void addProposition(Predicate buildInstPredicate) {
        propositions.put(buildInstPredicate, true);
    }

    public void addNumericFluent(NumFluentValue a) {
        getNum_fluents_value().put(a.getNFluent(), a.getValue());
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

        if (f.getId() == null) {
            System.out.println("This is a bug. Look into State Class to fix it");
            System.out.println("Fluent " + f + " is not in the state");
            System.exit(-1);
        } else {
            this.current_fluent_values.set(f.getId(), after);
        }

    }

    public void removeProposition(Predicate aThis) {
        propositions.remove(aThis);
    }

    public StringBuilder stringBuilderPddlPrintWithDummyTrue() {
        final StringBuilder ret = new StringBuilder("(:init (true)\n");

        for (Object o : this.getPropositions()) {
            Predicate a = (Predicate) o;
            ret.append("  (" + a.getPredicateName());
            for (Object o1 : a.getTerms()) {
                PDDLObject obj = (PDDLObject) o1;
                ret.append(" " + obj.getName());
            }
            ret.append(")\n");
        }
        for (Object o : this.getNumericFluents()) {
            NumFluentValue a = (NumFluentValue) o;
            ret.append("  ( = (" + a.getNFluent().getName());
            for (Object o1 : a.getNFluent().getTerms()) {
                PDDLObject obj = (PDDLObject) o1;
                ret.append(" " + obj.getName());
            }
            ret.append(") " + a.getValue().pddlPrint(false) + ")\n");
        }

        ret.append(")");
        return ret;
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
        for (NumFluent o : this.getNumericFluents()) {

            ret = ret.concat("  ( = (" + o.getName());
            for (Object o1 : o.getTerms()) {
                PDDLObject obj = (PDDLObject) o1;
                ret = ret.concat(" " + obj.getName());
            }
            ret = ret.concat(") " + this.functionValue(o).pddlPrint(false) + ")\n");
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
            } else if (!initskipped) {
                if ((sc.findInLine(":init") != null)) {
                    initskipped = true;
                    sc.next();
                    output.write("\n" + this.pddlPrint());
                } else {
                    output.write(sc.nextLine());//prima dello skip
                }
            } else if (sc.findInLine(":goal") != null) {
                goalStarted = true;
                output.write("\n(:goal " + sc.nextLine());//dopo il goal
            } else {
                sc.nextLine();
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
    
    public void apply(GroundAction gr){
        gr.apply(this);
    }
            

    public boolean satisfy(Condition input) {

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

        for (NumFluent o : this.getNum_fluents_value().keySet()) {
            //System.out.println(o);

            //System.out.println(this.numericFs.get(o));
            if (this.functionValue(o) != null) {
                ret_val.poss_numericFs.put(o, new Interval(this.functionValue(o).getNumber()));
            }
        }

        for (Object o : this.propositions.keySet()) {
            Predicate ele = (Predicate) o;
            ret_val.poss_interpretation.put(ele, 1);
        }
        //ret_val.propositions = (HashSet) this.propositions.clone();

        ret_val.timedLiterals = (HashSet) this.timedLiterals.clone();

        return ret_val;

    }

    //TO do
    void invariantAnalysis(Set grActions) {

        for (Object o : grActions) {
            GroundAction gr = (GroundAction) o;
            Condition add = gr.getAddList();
            Condition del = gr.getDelList();
            Condition num = gr.getNumericEffects();
        }

    }

    public String printFluentByName(String input) {
        String ret = "";

        for (Object o : this.getNum_fluents_value().keySet()) {
            NumFluent nf = (NumFluent) o;
            if (nf.getName().equals(input)) {
                ret = ret + this.functionValue(nf);

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

//        System.out.println("Checking equality!!!");
        for (NumFluent nf : this.getNumericFluents()) {
            if (nf.getId() == null) {
                continue;
            }
            if (!nf.has_to_be_tracked()) {
                continue;
            }

            if (nf.getName().equals("time_elapsed")) {//if they have different time elapsed doesn't matter at this stage{
//                System.out.println("Time comparison");
                continue;
            } else {
//                System.out.println(nf);
            }

            if (other.functionValue(nf) == null && this.functionValue(nf) == null) {
//                System.out.println("Error!!:"+ass_init.getNFluent());
                continue;
            }
            if (other.functionValue(nf) == null) {
//                System.out.println(nf);
//                System.out.println("(other is null)These two are different?a:"+this+"\nb:"+obj);
                return false;
            }
            if (this.functionValue(nf) == null) {
//                System.out.println(nf);
//                System.out.println("(this is null) These two are different?a:"+this+"\nb:"+obj);
                return false;
            }

            if (!functionValue(nf).getNumber().equals(other.functionValue(nf).getNumber())) {
//                System.out.println(nf);
//                System.out.println("These two are different?a:"+this+"\nb:"+obj);
                return false;
            }
        }
        for (Object o : this.getPropositions()) {
            Predicate p = (Predicate) o;
            if (this.is_true(p)) {
                if (!other.is_true(p)) {
//                    System.out.println("These two are different?a:"+this+"\nb:"+obj);
                    return false;
                }
            }

        }
//        System.out.println("These two are the same?a:"+this+"\nb:"+obj);

        return true;
    }

//    @Override
//    public int hashCode() {
//        int hash = 5;
//        if (!this.propositions.keySet().isEmpty())
//            hash = 19 * hash + Objects.hashCode(this.propositions);
//        if (!this.numericFs.keySet().isEmpty())
//            hash = 19 * hash + Objects.hashCode(this.numericFs);
//        return hash;
//    }
    @Override
    public int hashCode() {
        if (hash == null) {
            hash = 5;
            hash = 19 * hash + Objects.hashCode(this.propositions);
            int hash2 = 0;
//            for (Entry<NumFluent,PDDLNumber> nf : this.getNum_fluents_value().entrySet()){
//            
//                if (nf.getKey().has_to_be_tracked() && !nf.getKey().getName().equals("time_elapsed")){
//                    //hash2+=nf.hashCode();
//                    hash2+=nf.hashCode();
//                }
//            }
            hash2 += this.current_fluent_values.hashCode();
            hash = 19 * hash + hash2;
        }
        return hash;
    }

    public String printValueOfTheFluentByName(String input) {
        String ret = "";

        for (Object o : this.getNum_fluents_value().keySet()) {
            NumFluent nf = (NumFluent) o;
            if (nf.getName().equals(input)) {
                ret += this.functionValue(nf).getNumber();

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

//    public boolean removeNumericFluent(NumFluentValue f) {
//        this.numericFs.remove(f);
//        return true;
//    }
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

    public Float normalizedRisk(Condition conditions, RelState numericFleuntsBoundaries, String distStrategy, boolean preprocessMaxs) {
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

    public Float normalizedDist(Condition conditions, RelState numericFleuntsBoundaries, String distStrategy) {
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
        } else if (conditions instanceof Comparison) {
            Comparison comp = (Comparison) conditions;

            if (distStrategy.equals("sum")) {
                total += comp.getDistance(this, numericFleuntsBoundaries);

            } else if (distStrategy.equals("max")) {
                total = Math.max(comp.getDistance(this, numericFleuntsBoundaries), total);
                //System.out.println("Distance: "+dist);
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

    public Float distance(Condition c) {
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

    public Float distance2(Condition c) {
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
        for (Object o : this.getNum_fluents_value().keySet()) {
            NumFluent f = (NumFluent) o;

            NumEffect b = new NumEffect("assign");
            b.setFluentAffected(f);

            b.setRight(this.functionValue(f));
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
        getNum_fluents_value().put(this.time, new PDDLNumber(new Float(0.0)));
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
        Float new_value = this.functionValue(time).getNumber() + 0.1f;
        this.setFunctionValue(time, new PDDLNumber(new_value));
    }

    public Collection<Predicate> getPropositionsAsSet() {
        return new LinkedHashSet(this.propositions.keySet());
    }

    public NumFluent findCorrespondenceIfAny(NumFluent nf) {
        for (NumFluent f2 : this.getNumericFluents()) {
            if (f2.equals(nf)) {
                return f2;
            }
        }
        return nf;
    }

    public NumFluent getNumericFluent(NumFluent nf) {
        for (NumFluent f2 : this.getNumericFluents()) {
//            System.out.println(f2);
//            System.out.println(nf);
            if (f2.equals(nf)) {
                return f2;
            }
        }
        return null;
    }

    public Condition getProposition(Predicate aThis) {
        for (Predicate p : this.getPropositions()) {
            if (p.equals(aThis)) {
                return p;
            }
        }
        return aThis;
    }

    void addTime(NumFluentValue numFluentValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void removeNumericFluents(LinkedHashSet<NumFluent> n_fluents_to_remove) {
        for (NumFluent nf : n_fluents_to_remove) {
            if (!nf.getName().equals("time_elapsed")) {
                this.getNum_fluents_value().remove(nf);
            }
        }
    }

    void removePropositions(LinkedHashSet<Predicate> to_remove) {
        for (Predicate p : to_remove) {
//            System.out.println("Trying to remove p:"+p);
//            System.out.println("from:"+this.propositions);

            this.propositions.remove(p);
//            System.out.println("result:"+this.propositions);
        }
    }

    public void consolidate_propositions(RelState rs) {
        Iterator<Predicate> it = this.propositions.keySet().iterator();
//        System.out.println("Consolidation");
        while (it.hasNext()) {
            Predicate p = it.next();
            if (rs.poss_interpretation.get(p) == 0) {
                this.propositions.put(p, Boolean.FALSE);
            }
        }
    }

    /**
     * @return the num_fluents_value
     */
    public HashMap<NumFluent, PDDLNumber> getNum_fluents_value() {
        return num_fluents_initial_values;
    }

}

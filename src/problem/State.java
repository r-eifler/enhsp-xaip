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
import conditions.NumFluentAssigner;
import conditions.Comparison;
import conditions.Conditions;
import conditions.PDDLObject;
import conditions.Predicate;
import expressions.Addendum;
import expressions.NormExpression;
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author enrico
 */
public class State extends Object {

    HashMap propositions;
    HashMap numericFs;
    HashSet timedLiterals;

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

        for (Object o : this.numericFs.values()) {
            NumFluentAssigner ele = (NumFluentAssigner) o;
            NumFluentAssigner newA = new NumFluentAssigner("=");
            newA.setNFluent(ele.getNFluent());
            PDDLNumber newN = new PDDLNumber(ele.getTwo().getNumber());
            newA.setTwo(newN);
            ret_val.addNumericFluent(newA);
        }

        for (Object o : this.propositions.keySet()) {
            Predicate ele = (Predicate) o;
            ret_val.addProposition((Predicate) ele.clone());
        }
        //ret_val.propositions = (HashSet) this.propositions.clone();

        ret_val.timedLiterals = (HashSet) this.timedLiterals.clone();

        return ret_val;
    }

    public Iterable<Object> getNumericFluents() {
        return numericFs.values();
    }

    public PDDLNumber functionValue(NumFluent f) {

        NumFluentAssigner a = (NumFluentAssigner) numericFs.get(f);

        if (a != null) {
            return a.getTwo();
        }

        System.out.println(f + " is not expressed in " + this);
        return null;
    }

    public void addProposition(Predicate buildInstPredicate) {
        propositions.put(buildInstPredicate, true);
    }

    public void addNumericFluent(NumFluentAssigner a) {
        numericFs.put(a.getNFluent(), a);
    }

    void addTimedLiteral(Predicate buildInstPredicate) {
        timedLiterals.add(buildInstPredicate);
    }

    public Iterable<Object> getPropositions() {
        return this.propositions.keySet();

    }

    public boolean containProposition(Predicate aThis) {

        Boolean b = (Boolean) propositions.get(aThis);
        if (b != null) {
            return b;
        }
        return false;
    }

    public void setFunctionValue(NumFluent f, PDDLNumber after) {
        NumFluentAssigner a = (NumFluentAssigner) this.numericFs.get(f);
        
        if (a != null) {
            a.setTwo(after);
        }else{
            NumFluentAssigner b = new NumFluentAssigner("=");
            b.setNFluent(f);
            b.setTwo(after);
            this.addNumericFluent(b);
        }
    }

    public void removeProposition(Predicate aThis) {
        propositions.remove(aThis);
    }

    public String pddlPrint() {
        String ret = "(:init\n";

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
            NumFluentAssigner a = (NumFluentAssigner) o;
            ret = ret.concat("  ( = (" + a.getNFluent().getName());
            for (Object o1 : a.getNFluent().getTerms()) {
                PDDLObject obj = (PDDLObject) o1;
                ret = ret.concat(" " + obj.getName());
            }
            ret = ret.concat(") " + a.getTwo().getNumber() + ")\n");
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

        for (Object o : con.sons) {

            if (o instanceof Comparison) {
                Comparison c = (Comparison) o;
                if (!c.isSatisfied(this)) {
                    //System.out.println(c + "is not satisfied in " +this);
                    return false;
                }

            } else if (o instanceof Predicate) {
                if (!this.containProposition((Predicate) o)) {
                    //System.out.println(o + "is not contained in " +this); 
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
                if (!this.containProposition((Predicate) o)) {
                    System.out.println(o + "is not satisfied");
                    ret = false;
                }

            }

        }
        return true;

    }

    public RelState relaxState() {
        RelState ret_val = new RelState();

        for (Object o : this.numericFs.values()) {
            NumFluentAssigner ele = (NumFluentAssigner) o;
            NumFluentAssigner newA = new NumFluentAssigner("=");
            newA.setNFluent(ele.getNFluent());
            PDDLNumber newN = new PDDLNumber(ele.getTwo().getNumber());
            newA.setTwo(newN);
            if (ele.getNFlunetValueUpperBound() != null) {
                PDDLNumber newSup = new PDDLNumber(ele.getNFlunetValueUpperBound().getNumber());
                newA.setNFlunetValueUpperBound(newSup);
            } else {
                newA.setNFlunetValueUpperBound(newN);
            }
            ret_val.addNumericFluent(newA);
        }

        for (Object o : this.propositions.keySet()) {
            Predicate ele = (Predicate) o;
            ret_val.addProposition((Predicate) ele.clone());
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
    public String printValueOfTheFluentByName(String input) {
        String ret = "";

        for (Object o : this.numericFs.keySet()) {
            NumFluent nf = (NumFluent) o;
            if (nf.getName().equals(input)) {
                NumFluentAssigner a = (NumFluentAssigner)this.numericFs.get(nf);
                ret += a.getTwo().getNumber();
                
            }

        }
        return ret;
    }

    public AndCond toAndCondition() {
        AndCond ret = new AndCond();

        Iterator it = this.getPropositions().iterator();
        while (it.hasNext()) {
            Predicate p = (Predicate) it.next();
            if (this.containProposition(p)) {
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
            if (!init.containProposition(p)) {
                diff.add(p);
            }

        }
        it = init.getPropositions().iterator();
        while (it.hasNext()) {
            Predicate p = (Predicate) it.next();
            if (!this.containProposition(p)) {
                diff.add(p);
            }

        }
        return diff;
    }

    public boolean removeNumericFluent(NumFluentAssigner f) {
        this.numericFs.remove(f);
        return true;
    }

    public Float distance(AndCond firstKernelCondition) {

        Float total = new Float(0.0);
        for (Object o : firstKernelCondition.sons) {
            if (o instanceof Comparison) {
                Comparison comp = (Comparison) o;
                if ((comp.getRight() instanceof NormExpression) && (comp.getLeft() instanceof NormExpression)) {
                    NormExpression lExpr = (NormExpression) comp.getLeft();
                    Float num = new Float(0.0);
                    Float den = new Float(0.0);
                    for (Addendum a : lExpr.summations) {
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

        if (conditions instanceof AndCond) {
            for (Object o : conditions.sons) {
                if (o instanceof Comparison) {
                    Comparison comp = (Comparison) o;

                    if ((comp.getRight() instanceof NormExpression) && (comp.getLeft() instanceof NormExpression)) {
                        NormExpression lExpr = (NormExpression) comp.getLeft();
                        Float num = new Float(0.0);
                        Float den = new Float(0.0);
                        //Float den = new Float(0.0);
                        //checking for collapsed constraints (6>4)
                        boolean collapsed = true;
                        for (Addendum a : lExpr.summations) {
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
                        
                        if (comp.maxDist == null){
                            for (Addendum a : lExpr.summations) {
                                if (a.f == null) {
                                    num += Math.abs(a.n.getNumber());
                                } else {
                                    num += Math.max(Math.abs(a.n.getNumber() * numericFleuntsBoundaries.functionInfValue(a.f).getNumber()), Math.abs(a.n.getNumber() * numericFleuntsBoundaries.functionSupValue(a.f).getNumber()));
                                }
                            }
                            if (preprocessMaxs){
                                
                                //System.out.println("A bug somewhere...exiting ("+comp.pddlPrint(true)+")");
                                //System.exit(-1);
                            }
                            maxDist = Math.abs(num);
                        }else{
                            //System.out.println("UNO ALMENO L'HA TROVATO");
                            maxDist = comp.maxDist;
                        }

                        //System.out.println("Distance: "+dist);
                        //System.out.println("Max Distance: "+maxDist);
                        if (distStrategy.equals("sum")) {
                            total += maxDist / dist;
                            //total += (float)1 - (float)(dist/Math.max(maxDist,dist));
                        } else if (distStrategy.equals("max")) {
                            if ((comp.getComparator().equals(">=") || comp.getComparator().equals("<=") )){
                                //System.out.println("Constraints Adjusted");
                                dist = dist+(float)0.00000000001;
                            }
                            if (!collapsed){
                                total = Math.max((float)1 - (float)(dist/maxDist), total);
                            }else{
                                System.out.println(comp + "============================================= Collapsed!!!!!");

                            }
                            
                               
                        }

                    } else {
                        System.out.println("Comparison must be normalized for computing the euclidean distance");
                        System.exit(-1);
                    }
                }

            }
        }
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
            if (conditions instanceof Comparison){
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

}

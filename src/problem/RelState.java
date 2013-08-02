/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problem;

import conditions.Assigner;
import conditions.PDDLObject;
import conditions.Predicate;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author enrico
 */
public class State extends Object {

    HashSet propositions;
    HashSet numericFs;
    HashSet timedLiterals;

    public State() {
        super();
        propositions = new HashSet();
        numericFs = new HashSet();
        timedLiterals = new HashSet();
    }

    @Override
    public String toString() {
        return "State{" + "propositions=" + propositions + "numericFs=" + numericFs + "timedLiterals=" + timedLiterals + '}';
    }

    @Override
    public State clone() throws CloneNotSupportedException {
        State ret_val = new State();

        for (Object o : this.numericFs) {
            Assigner ele = (Assigner) o;
            Assigner newA = new Assigner("=");
            newA.setOne(ele.getOne());
            PDDLNumber newN = new PDDLNumber(ele.getTwo().getNumber());
            newA.setTwo(newN);
            ret_val.addNumericFluent(newA);
        }

//        for (Object o: this.propositions){
//            Predicate ele = (Predicate)o;
//            ret_val.addProposition((Predicate) ele.clone());
//        }
        ret_val.propositions = (HashSet) this.propositions.clone();

        ret_val.timedLiterals = (HashSet) this.timedLiterals.clone();

        return ret_val;
    }

    public Iterable<Object> getNumericFluents() {
        return numericFs;
    }

    public PDDLNumber functionValue(NumFluent f) {
        for (Object o : numericFs) {
            if (o instanceof Assigner) {
                Assigner a = (Assigner) o;
                if (a.getOne().equals(f)) {
                    return a.getTwo().eval(this);
                }
            }
        }
        return null;
    }

    public void addProposition(Predicate buildInstPredicate) {
        propositions.add(buildInstPredicate);
    }

    public void addNumericFluent(Assigner a) {


        numericFs.add(a);
    }

    void addTimedLiteral(Predicate buildInstPredicate) {
        timedLiterals.add(buildInstPredicate);
    }

    public Iterable<Object> getPropositions() {
        return this.propositions;
    }

    public boolean containProposition(Predicate aThis) {
        return this.propositions.contains(aThis);
    }

    public void setFunctionValue(NumFluent f, PDDLNumber after) {
        for (Object o : numericFs) {
            if (o instanceof Assigner) {
                Assigner a = (Assigner) o;
                if (a.getOne().equals(f)) {
                    a.setTwo(after);
                }
            }
        }
        return;
    }

    public void removeProposition(Predicate aThis) {
        for (Iterator i = propositions.iterator(); i.hasNext();) {
            Predicate p = (Predicate) i.next();
            if (p.equals(aThis)) {
                i.remove();
                return;
            }
        }
        System.out.println(aThis + "non trovato");
    }
    
    public String pddlPrint(){
        String ret = "(:init\n";
        
        for (Object o: this.getPropositions()){
            Predicate a = (Predicate)o;
            ret = ret.concat("  ("+a.getPredicateName());
            for (Object o1: a.getTerms()){
                PDDLObject obj = (PDDLObject)o1;
                ret  = ret.concat(" "+obj.getName());
            }
            ret = ret.concat(")\n");
        }
        for (Object o: this.getNumericFluents()){
            Assigner a = (Assigner)o;
            ret = ret.concat("  ( = ("+a.getOne().getName());
            for (Object o1: a.getOne().getTerms()){
                PDDLObject obj = (PDDLObject)o1;
                ret =  ret.concat(" "+obj.getName());
            }
            ret = ret.concat(") "+a.getTwo().getNumber()+")\n");
        }
    
        ret = ret.concat(")");
        return ret;
    }
    public void generateNewProblemFile(String srcPath, String destPath) throws FileNotFoundException, IOException{
        
        
        Reader input = new BufferedReader(new FileReader(srcPath));
        
        Scanner sc = new Scanner(input);
        Writer output = new BufferedWriter(new FileWriter(destPath));
        output.write("\n");
        boolean initskipped = false;
        boolean goalStarted = false;
        
        while(sc.hasNext()){    
            if ((initskipped)&&(goalStarted)){
                output.write(sc.nextLine());
            }else{
                if (!initskipped){
                    if ((sc.findInLine(":init") != null)){
                        initskipped=true;
                        sc.next();
                        output.write("\n" + this.pddlPrint());
                    }else{
                        output.write(sc.nextLine());//prima dello skip
                    }
                }else{
                    if (sc.findInLine(":goal")!=null){
                        goalStarted = true;
                        output.write("\n(:goal "+ sc.nextLine());//dopo il goal
                    }else
                        sc.nextLine();
                }   
            }
        }
        output.close();
        
        
    }
}

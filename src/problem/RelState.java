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

import conditions.Comparison;
import conditions.NumFluentAssigner;
import conditions.Conditions;
import conditions.Predicate;
import expressions.Expression;
import expressions.NumFluent;
import expressions.PDDLNumber;
import expressions.PDDLNumbers;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author enrico
 */
public class RelState extends Object {

    HashMap poss_propositions;
    HashMap poss_numericFs;
    HashSet timedLiterals;///to do

    public RelState() {
        super();
        poss_propositions = new HashMap();
        poss_numericFs = new HashMap();
        timedLiterals = new HashSet();
    }

    @Override
    public String toString() {
        return "State{" + "propositions=" + poss_propositions + "numericFs=" + poss_numericFs + "timedLiterals=" + timedLiterals + '}';
    }

    @Override
    public RelState clone() throws CloneNotSupportedException {
        RelState ret_val = new RelState();

        for (Object o : this.poss_numericFs.values()) {
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


        for (Object o : this.poss_propositions.keySet()) {
            Predicate ele = (Predicate) o;
            ret_val.addProposition((Predicate) ele.clone());
        }
        //ret_val.propositions = (HashSet) this.propositions.clone();

        ret_val.timedLiterals = (HashSet) this.timedLiterals.clone();

        return ret_val;
    }

    public Iterable<Object> getNumericFluents() {
        return poss_numericFs.values();
    }

    public PDDLNumber functionInfValue(NumFluent f) {
        NumFluentAssigner a = (NumFluentAssigner) this.poss_numericFs.get(f);
        if (a != null) {
            return a.getTwo();
        }
        return null;
    }

    public PDDLNumbers functionValues(NumFluent f) {

        NumFluentAssigner a = (NumFluentAssigner) this.poss_numericFs.get(f);
        if (a != null) {
            PDDLNumbers ret_val = new PDDLNumbers();
            ret_val.inf = a.getTwo();
            ret_val.sup = a.getNFlunetValueUpperBound();
            return ret_val;
        }
        return null;
    }

    public PDDLNumber functionSupValue(NumFluent f) {
        NumFluentAssigner a = (NumFluentAssigner) this.poss_numericFs.get(f);
        if (a != null) {
            return a.getNFlunetValueUpperBound();
        }
        return null;
    }

    public void addProposition(Predicate buildInstPredicate) {
        poss_propositions.put(buildInstPredicate, true);
    }

    public void addNumericFluent(NumFluentAssigner a) {

        poss_numericFs.put(a.getNFluent(), a);

//        poss_numericFs.add(a);
    }

    void addTimedLiteral(Predicate buildInstPredicate) {
        timedLiterals.add(buildInstPredicate);
    }

    public Iterable<Object> getPropositions() {
        return this.poss_propositions.keySet();
    }

    public boolean containProposition(Predicate aThis) {

        Object o = this.poss_propositions.get(aThis);
        if (o == null) {
            return false;
        }
        if (o instanceof Boolean) {
            Boolean b = (Boolean) o;
            if (b == true) {
                return true;
            }
        }
        return false;
    }

    public void setFunctionInfValue(NumFluent f, PDDLNumber after) {
        NumFluentAssigner a = (NumFluentAssigner) this.poss_numericFs.get(f);
        if (a != null) {
            a.setTwo(after);
        }

    }

    public void setFunctionSupValue(NumFluent f, PDDLNumber after) {
        NumFluentAssigner a = (NumFluentAssigner) this.poss_numericFs.get(f);
        if (a != null) {
            a.setNFlunetValueUpperBound(after);
        }

    }

    public void removeProposition(Predicate aThis) {
        this.poss_propositions.put(aThis, false);
//        
//        for (Iterator i = poss_propositions.iterator(); i.hasNext();) {
//            Predicate p = (Predicate) i.next();
//            if (p.equals(aThis)) {
//                i.remove();
//                return;
//  
//            }
//        }
//        System.out.println(aThis + "non trovato");
    }

//    public String pddlPrint(){
//        String ret = "(:init\n";
//        
//        for (Object o: this.getPropositions()){
//            Predicate a = (Predicate)o;
//            ret = ret.concat("  ("+a.getPredicateName());
//            for (Object o1: a.getTerms()){
//                PDDLObject obj = (PDDLObject)o1;
//                ret  = ret.concat(" "+obj.getName());
//            }
//            ret = ret.concat(")\n");
//        }
//        for (Object o: this.getNumericFluents()){
//            NumFluentAssigner a = (NumFluentAssigner)o;
//            ret = ret.concat("  ( = ("+a.getOne().getName());
//            for (Object o1: a.getOne().getTerms()){
//                PDDLObject obj = (PDDLObject)o1;
//                ret =  ret.concat(" "+obj.getName());
//            }
//            ret = ret.concat(") "+a.getTwo().getNumber()+")\n");
//        }
//    
//        ret = ret.concat(")");
//        return ret;
//    }
//    public void generateNewProblemFile(String srcPath, String destPath) throws FileNotFoundException, IOException{
//        
//        
//        Reader input = new BufferedReader(new FileReader(srcPath));
//        
//        Scanner sc = new Scanner(input);
//        Writer output = new BufferedWriter(new FileWriter(destPath));
//        output.write("\n");
//        boolean initskipped = false;
//        boolean goalStarted = false;
//        
//        while(sc.hasNext()){    
//            if ((initskipped)&&(goalStarted)){
//                output.write(sc.nextLine());
//            }else{
//                if (!initskipped){
//                    if ((sc.findInLine(":init") != null)){
//                        initskipped=true;
//                        sc.next();
//                        output.write("\n" + this.pddlPrint());
//                    }else{
//                        output.write(sc.nextLine());//prima dello skip
//                    }
//                }else{
//                    if (sc.findInLine(":goal")!=null){
//                        goalStarted = true;
//                        output.write("\n(:goal "+ sc.nextLine());//dopo il goal
//                    }else
//                        sc.nextLine();
//                }   
//            }
//        }
//        output.close();
//        
//        
//    }
    public boolean satisfy(Conditions con) {

        if (con == null){
            System.out.println(this);
            System.out.println("something wrong");
        }
        return con.isSatisfied(this);


    }

    public void setFunctionValues(NumFluent f, PDDLNumbers after) {
        NumFluentAssigner a = (NumFluentAssigner) this.poss_numericFs.get(f);
        if (a != null) {
            if (a.getNFluent().equals(f)) {
                a.setTwo(after.inf);
                a.setNFlunetValueUpperBound(after.sup);
            }
        }
    }

    public float satisfaction_distance(Comparison comparison) {
        if (this.satisfy(comparison))
            return 0;
        RelState s = this;
        Expression left = comparison.getLeft();
        Expression right = comparison.getRight();
        PDDLNumbers lv = left.eval(s);
        PDDLNumbers rv = right.eval(s);
        if ((lv == null) || (rv == null)) {
            return Float.MAX_VALUE;
        }
        if ((lv.inf == null) || (lv.sup == null) || (rv.inf == null) || (rv.sup == null)) {
            return Float.MAX_VALUE;//negation by failure.
        }
        if (comparison.getComparator().equals("<")) {
            return lv.inf.getNumber() - rv.sup.getNumber()+ Float.MIN_VALUE;
        } else if (comparison.getComparator().equals("<=")) {
            return lv.inf.getNumber() - rv.sup.getNumber();
        } else if (comparison.getComparator().equals(">")) {
            return  rv.inf.getNumber() - lv.sup.getNumber()+ Float.MIN_VALUE;
        } else if (comparison.getComparator().equals(">=")) {
            return rv.inf.getNumber() - lv.sup.getNumber();
        } else if (comparison.getComparator().equals("=")) {
            if (!((lv.inf.getNumber() > rv.sup.getNumber()) || (rv.inf.getNumber() > lv.sup.getNumber()))) {
                return -Float.MIN_VALUE;
            } else {
                if (lv.inf.getNumber() > lv.inf.getNumber()){
                    return lv.inf.getNumber() - lv.inf.getNumber();
                } else{
                    return rv.inf.getNumber() -lv.sup.getNumber();
                }
                

            }
        } else {
            System.out.println(comparison.getComparator() + "  is not supported");
        }

        return Float.MAX_VALUE;
    }
}

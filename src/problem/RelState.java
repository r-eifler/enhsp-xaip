/**
 * *******************************************************************
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
 ********************************************************************
 */
/**
 * *******************************************************************
 * Description: Part of the PPMaJaL library
 *
 * Author: Enrico Scala 2013
 * Contact: enricos83@gmail.com
 *
 ********************************************************************
 */
package problem;

import conditions.Comparison;
import conditions.NumFluentValue;
import conditions.Conditions;
import conditions.Predicate;
import expressions.Expression;
import expressions.NumFluent;
import expressions.PDDLNumber;
import expressions.Interval;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author enrico
 */
public class RelState extends Object {

    public HashMap<Predicate, Integer> poss_interpretation;//0 is negative, 1 positive, 2 both
    public HashMap<NumFluent,Interval> poss_numericFs;
    HashSet timedLiterals;///to do

    public RelState() {
        super();
        poss_interpretation = new HashMap();

        poss_numericFs = new HashMap();
        timedLiterals = new HashSet();
    }

    @Override
    public String toString() {
        return "State{" + "propositions=" + poss_interpretation + "numericFs=" + poss_numericFs + "timedLiterals=" + timedLiterals + '}';
    }

    @Override
    public RelState clone() {
        RelState ret_val = new RelState();
        
        for (NumFluent nf : this.poss_numericFs.keySet()){
            ret_val.poss_numericFs.put(nf, this.poss_numericFs.get(nf));
        }
        for (Predicate ele : this.poss_interpretation.keySet()) {
//            this.poss_interpretation.get(ele);
            ret_val.poss_interpretation.put( ele, this.poss_interpretation.get(ele));
        }

        //ret_val.propositions = (HashSet) this.propositions.clone();
        ret_val.timedLiterals = (HashSet) this.timedLiterals.clone();

        return ret_val;
    }

    public Iterable<NumFluent> getNumericFluents() {
        return poss_numericFs.keySet();
    }

    public PDDLNumber functionInfValue(NumFluent f) {
        Interval n = this.poss_numericFs.get(f);
        if (n != null) {
            return n.getInf();
        }
        return null;
    }

    public Interval functionValues(NumFluent f) {

        Interval a = this.poss_numericFs.get(f);
        if (a != null) {
            return a;
        } else {
            Interval ret_val = new Interval(Float.NaN);
            return ret_val;
        }
    }

    public PDDLNumber functionSupValue(NumFluent f) {
        Interval a =  this.poss_numericFs.get(f);
        if (a != null) {
            return a.getSup();
        }
        return null;
    }

    public void make_positive(Predicate p) {
        Integer inter = poss_interpretation.get(p);
        if (inter == null) {//if was negative by default
            poss_interpretation.put(p, 2);
        } else if (inter == 0) {//if was said to be negative
            poss_interpretation.put(p, 2);
        }//otherwise it was already fine
    }



    void addTimedLiteral(Predicate buildInstPredicate) {
        timedLiterals.add(buildInstPredicate);
    }

    public Iterable<Predicate> getPropositions() {
        return this.poss_interpretation.keySet();
    }

    public boolean can_be_true(Predicate aThis) {

        Integer o = this.poss_interpretation.get(aThis);
        if (o == null) {
            return false;
        }
        return o >= 1;
    }
    public boolean can_be_false(Predicate aThis) {

        Integer o = this.poss_interpretation.get(aThis);
        if (o == null) {
            return true;
        }
        return o == 0 || o == 2;
    }

    public void setFunctionInfValue(NumFluent f, PDDLNumber after) {
        Interval a =  this.poss_numericFs.get(f);
        if (a != null) {
            a.setInf(after);
        }

    }

    public void setFunctionSupValue(NumFluent f, PDDLNumber after) {
        Interval a =  this.poss_numericFs.get(f);
        if (a != null) {
            a.setSup(after);
        }

    }

    public void make_negative(Predicate p) {
        Integer inter = poss_interpretation.get(p);
        if (inter == null) {//if was negative by default
        } else if (inter == 1) {//if was said to be positive it will also be negative
            poss_interpretation.put(p, 2);
        }//otherwise all good (inter == 2)
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

        if (con == null) {
            System.out.println(this);
            System.out.println("something wrong");
            System.exit(-1);
        }
        return con.can_be_true(this);

    }

    public void setFunctionValues(NumFluent f, Interval after) {
        this.poss_numericFs.put(f,after);

    }

    public float satisfaction_distance(Comparison comparison) {
        if (this.satisfy(comparison)) {
            return 0;
        }
        RelState s = this;
        Expression left = comparison.getLeft();
        Expression right = comparison.getRight();
        Interval lv = left.eval(s);
        Interval rv = right.eval(s);
        if ((lv == null) || (rv == null)) {
            return Float.MAX_VALUE;
        }
        if ((lv.getInf() == null) || (lv.getSup() == null) || (rv.getInf() == null) || (rv.getSup() == null)) {
            return Float.MAX_VALUE;//negation by failure.
        }
        if (comparison.getComparator().equals("<")) {
            return lv.getInf().getNumber() - rv.getSup().getNumber() + Float.MIN_VALUE;
        } else if (comparison.getComparator().equals("<=")) {
            return lv.getInf().getNumber() - rv.getSup().getNumber();
        } else if (comparison.getComparator().equals(">")) {
            return rv.getInf().getNumber() - lv.getSup().getNumber() + Float.MIN_VALUE;
        } else if (comparison.getComparator().equals(">=")) {
            return rv.getInf().getNumber() - lv.getSup().getNumber();
        } else if (comparison.getComparator().equals("=")) {
            if (!((lv.getInf().getNumber() > rv.getSup().getNumber()) || (rv.getInf().getNumber() > lv.getSup().getNumber()))) {
                return -Float.MIN_VALUE;
            } else if (lv.getInf().getNumber() > lv.getInf().getNumber()) {
                return lv.getInf().getNumber() - lv.getInf().getNumber();
            } else {
                return rv.getInf().getNumber() - lv.getSup().getNumber();
            }
        } else {
            System.out.println(comparison.getComparator() + "  is not supported");
        }

        return Float.MAX_VALUE;
    }

    public void update_values(HashMap subst) {
        for (Object o : subst.keySet()) {
            if (o instanceof NumFluent) {
                NumFluent nf = (NumFluent) o;
                if (nf.is_has_to_be_tracked()) {
                    this.setFunctionValues(nf, (Interval) subst.get(o));
                }
            } else {
                this.poss_interpretation.put((Predicate) o, (Integer) subst.get(o));
            }
        }
    }

    void addNumericFluent(NumFluentValue newA) {
       this.poss_numericFs.put(newA.getNFluent(), new Interval(newA.getValue().getNumber()));
    }
}

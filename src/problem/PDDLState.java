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
import conditions.Predicate;
import expressions.Interval;
import expressions.NumFluent;
import expressions.PDDLNumber;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author enrico
 */
public class PDDLState  {

    public ArrayList<PDDLNumber> numFluents;
    public ArrayList<Boolean> boolFluents;
    public NumFluent time;

    public PDDLState() {
        super();
        this.numFluents = new ArrayList();
        this.boolFluents = new ArrayList();

    }

    public PDDLState(ArrayList<PDDLNumber> numFluents, ArrayList<Boolean> propFluents) {
        this.numFluents = (ArrayList<PDDLNumber>) numFluents.clone();
        this.boolFluents = (ArrayList<Boolean>) propFluents.clone();
    }

    @Override
    public String toString() {
        return "State{" + "currNumFluentsValues=" + numFluents + ", currPredValues=" + boolFluents + ", time=" + time + '}';
    }

    

    @Override
    public PDDLState clone() throws CloneNotSupportedException {
        PDDLState ret_val = new PDDLState(this.numFluents,this.boolFluents);
        ret_val.time = this.time;
        return ret_val;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.numFluents);
        hash = 41 * hash + Objects.hashCode(this.boolFluents);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PDDLState other = (PDDLState) obj;
        if (!Objects.equals(this.numFluents, other.numFluents)) {
            return false;
        }
        if (!Objects.equals(this.boolFluents, other.boolFluents)) {
            return false;
        }
        return true;
    }



    public PDDLNumber fluentValue(NumFluent f) {
        if (f.getId() == null) {
            throw new RuntimeException("Numeric Fluent "+f+" hasn't been assigned with a unique id");
        }
        return this.numFluents.get(f.getId());

    }

    
    public void populateBoolFloatMap(EPddlProblem p){
        
//        System.out.println("Put numeric information into memory!");
        numFluents = new ArrayList();
        for (Entry<NumFluent,PDDLNumber> numFluentValue : p.initNumFluentsValues.entrySet()) {
            NumFluent nf = numFluentValue.getKey();
            nf.id = this.numFluents.size();
            this.numFluents.add(numFluentValue.getValue());
        }
        boolFluents = new ArrayList();
        for (Entry<Predicate,Boolean> boolFluentValue : p.initBoolFluentsValues.entrySet()) {
                Predicate pred = boolFluentValue.getKey();
                pred.id = this.boolFluents.size();
                boolFluents.add(boolFluentValue.getValue());
        }
    }

    public boolean holds(Predicate p) {
        return (p.id != null && (this.boolFluents.get(p.id)));
    }

    public void setNumFluent(NumFluent f, PDDLNumber after) {
        if (f.getId() == null) {
            f.id = this.numFluents.size(); //This should handle the case where numFluent wasn't initialised
            this.numFluents.add(after);
        } else {
            this.numFluents.set(f.getId(), after);
        }
    }
    public void setPropFluent(Predicate f, Boolean after) {
        if (f.id == null) {
            f.id = this.numFluents.size(); //This should handle the case where propFluent wasn't initialised
            this.boolFluents.add(after);
        } else {
            this.boolFluents.set(f.id, after);
        }
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
    
    public void apply(PDDLGroundAction gr){
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
                if (!this.holds((Predicate) o)) {
                    System.out.println(o + "is not satisfied");
                    ret = false;
                }

            }

        }
        return ret;

    }

    public RelState relaxState() {
        RelState ret_val = new RelState(); 
        for (int i = 0; i<this.numFluents.size() ; i++){      
            PDDLNumber n = this.numFluents.get(i) ;
            if (n == null){
                ret_val.possNumValues.add(new Interval(Float.NaN));
            }else
                ret_val.possNumValues.add(new Interval(this.numFluents.get(i).getNumber()));
            
        }
        for (int i = 0; i<this.boolFluents.size() ; i++){
            if (this.boolFluents.get(i))
                ret_val.possBollValues.add(1);
            else
                ret_val.possBollValues.add(0);
        }

        return ret_val;

    }

    public void updateValues(HashSet<NumFluent> toUpdate, PDDLState temp) {
        for (NumFluent n : toUpdate) {
            this.setNumFluent(n, temp.fluentValue(n));
        }
    }

    void increase_time_by_epsilon() {
        Float new_value = this.fluentValue(time).getNumber() + 0.1f;
        this.setNumFluent(time, new PDDLNumber(new_value));
    }


}

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

import com.carrotsearch.hppc.DoubleArrayList;
import conditions.AndCond;
import conditions.Comparison;
import conditions.Condition;
import conditions.Predicate;
import expressions.Interval;
import expressions.NumFluent;
import expressions.PDDLNumber;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

/**
 *
 * @author enrico
 */
public class PDDLState extends State  {

    public DoubleArrayList numFluents;
    public boolean[] boolFluents;
    public double time;

    public PDDLState() {
        super();
        
    }

    public PDDLState(ArrayList<PDDLNumber> initialNumFluents, ArrayList<Boolean> initialPropFluents) {
        this.numFluents = new DoubleArrayList(initialNumFluents.size());
        for (int i=0;i<initialNumFluents.size();i++){
            if (initialNumFluents.get(i)==null){
                this.numFluents.add(Double.NaN);
            }else
                this.numFluents.add(initialNumFluents.get(i).getNumber().doubleValue());
        }
        this.boolFluents = new boolean[initialPropFluents.size()];
        for (int i=0;i<initialPropFluents.size();i++){
            if (initialPropFluents.get(i)==null){
                this.boolFluents[i] = false;
            }else
                this.boolFluents[i] = initialPropFluents.get(i);
        }
        time = -1;

    }
    
    public PDDLState(DoubleArrayList numFluents, boolean[] propFluents) {
        this.numFluents = numFluents.clone();
        this.boolFluents = Arrays.copyOf(propFluents, propFluents.length);
        time = -1;
    }
    

    @Override
    public String toString() {
        return "State{" + "currNumFluentsValues=" + numFluents + ", currPredValues=" + boolFluents + ", time=" + time + '}';
    }

    

    @Override
    public PDDLState clone() {
        PDDLState ret_val = new PDDLState(this.numFluents,this.boolFluents);
        ret_val.time = this.time;
        return ret_val;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        this.numFluents.hashCode();
        hash = 59 * hash + this.numFluents.hashCode();
        hash = 59 * hash + Arrays.hashCode(this.boolFluents);
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
        return Arrays.equals(this.boolFluents, other.boolFluents);
    }

 







    public Double fluentValue(NumFluent f) {
        if (f.getId() == null) {
            throw new RuntimeException("Numeric Fluent "+f+" hasn't been assigned with a unique id ");
//            System.out.println("Numeric Fluent "+f+" hasn't been assigned with a unique id "+ "Current mapping is" + this.idOf);
//            return null;
        }
        return this.numFluents.get(f.getId());

    }


    public boolean holds(Predicate p) {
        return (p.id != null && (this.boolFluents[p.id]));
    }

    public void setNumFluent(NumFluent f, Double after) {
        if (f.getId() == null) {
            throw new RuntimeException("This shouldn't happen and is a bug. Numeric fluent wasn't on the table");
//            f.id = this.numFluents.size(); //This should handle the case where numFluent wasn't initialised
//            this.numFluents.add(after);
        } else {
            this.numFluents.set(f.getId(),after);
        }
    }
    public void setPropFluent(Predicate f, Boolean after) {
        if (f.id == null) {
            throw new RuntimeException("This shouldn't happen and is a bug. Predicate fluent wasn't on the table");
//            f.id = this.numFluents.size(); //This should handle the case where propFluent wasn't initialised
//            this.boolFluents.add(after);
        } else {
            this.boolFluents[f.id] =  after;
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
            Double n = this.numFluents.get(i) ;
            if (n == null){
                ret_val.possNumValues.add(new Interval(Float.NaN));
            }else
                ret_val.possNumValues.add(new Interval(new Float(this.numFluents.get(i))));
            
        }
        for (int i = 0; i<this.boolFluents.length ; i++){
            if (this.boolFluents[i])
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
        time+=0.1f;
    }


}

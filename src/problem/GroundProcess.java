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
import domain.ParametersAsTerms;
import expressions.ExtendedNormExpression;
import expressions.NumEffect;
import expressions.NumFluent;
import expressions.PDDLNumber;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GroundProcess extends GroundAction implements Comparable {

    public GroundProcess(String name) {
        super(name);
    }

    public boolean isActive(State s){
        return this.isApplicable(s);
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        GroundProcess ret = new GroundProcess(name);
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
        
        if (this.numericFluentAffected!=null)
            ret.numericFluentAffected = (HashMap) this.numericFluentAffected.clone();
        if (this.parameters != null) {
            ret.parameters = (ParametersAsTerms) this.parameters.clone();
        }
        if (this.preconditions != null) {
            ret.preconditions = this.preconditions.clone();
        }
        if (this.interact_with != null) {
            ret.interact_with = (HashMap<Integer, Boolean>) this.interact_with.clone();
        }
        return ret;

    }
    
    public State apply(State s_in, int time){
        
        State s=null;
        try {
            s = s_in.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(GroundProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            }

        }
        return s;

    }

    public void add_numeric_effect(NumEffect eff) {

        Iterator<NumEffect> it =  this.numericEffects.sons.iterator();
        while(it.hasNext()){
            NumEffect int_eff = it.next();
            if (int_eff.getFluentAffected().equals(eff.getFluentAffected())){
                if (eff.getOperator().equals(int_eff.getOperator())){
                    try {
                        ExtendedNormExpression expr = (ExtendedNormExpression) int_eff.getRight();
                        expr.sum((ExtendedNormExpression) eff.getRight());
                    } catch (Exception ex) {
                        Logger.getLogger(GroundProcess.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    if (int_eff.getOperator().equals("increase")){
                        try {
                            ExtendedNormExpression expr = (ExtendedNormExpression) int_eff.getRight();
                            expr.minus((ExtendedNormExpression) eff.getRight());
                        } catch (Exception ex) {
                            Logger.getLogger(GroundProcess.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        try {
                            ExtendedNormExpression expr = (ExtendedNormExpression) int_eff.getRight();
                            expr.minus((ExtendedNormExpression) eff.getRight());
                            int_eff.setOperator("increase");
                            //expr.mult(new PDDLNumber(-1));
                        } catch (Exception ex) {
                            Logger.getLogger(GroundProcess.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                return;
            }
        }
        this.numericEffects.sons.add(eff);
        
    
    }

    public void add_time_effects(float delta) {
        NumEffect time = new NumEffect("increase");
        time.setFluentAffected(new NumFluent("time_elapsed"));
        time.setRight(new PDDLNumber(delta));
        time.getRight().normalize();
        this.numericEffects.sons.add(time);
    }



}

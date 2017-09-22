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
package expressions;

import conditions.Conditions;
import conditions.PDDLObject;
import domain.Variable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import problem.PDDLObjects;
import problem.RelState;
import problem.State;

/**
 *
 * @author enrico
 */
public class PDDLNumber extends Expression {

    private Float number;

    public PDDLNumber() {
        super();
        grounded = true;
    }

    public PDDLNumber(Float n) {
        grounded = true;
        number = n;

    }

    public PDDLNumber(float number) {

        grounded = true;
        this.number = number;

    }

    public PDDLNumber(int number) {

        grounded = true;
        this.number = new Float(number);

    }

    @Override
    public String toString() {

        return " " + String.format("%.6f", this.getNumber()) + " ";
    }

    @Override
    public Expression ground(Map<Variable, PDDLObject> substitution, PDDLObjects po) {
        return new PDDLNumber(getNumber());
    }

    @Override
    public Expression unGround(Map substitution) {
        return new PDDLNumber(getNumber());
    }

    /**
     * @return the number
     */
    public Float getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(Float number) {
        this.number = number;
    }

    @Override
    public PDDLNumber eval(State s) {
        return this;
    }

    @Override
    public ExtendedNormExpression normalize() {
        ExtendedAddendum a = new ExtendedAddendum();
        a.n = this;
        a.f = null;
        ExtendedNormExpression ret = new ExtendedNormExpression();
        ret.summations.add(a);
        return ret;

    }

    @Override
    public void changeVar(Map<Variable, PDDLObject> substitution) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Expression weakEval(State s, HashMap invF) {
        return this;
    }

    @Override
    public Expression clone() {
        //return new PDDLNumber(this.getNumber());
        return this;
    }

    @Override
    public Interval eval(RelState s) {
        return new Interval(this.getNumber());
    }

    @Override
    public boolean involve(HashMap<NumFluent, Boolean> arrayList) {
        return false;
    }

    @Override
    public Expression subst(Conditions numeric) {
        return this;
    }

    @Override
    public Set rhsFluents() {
        return new HashSet(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isUngroundVersionOf(Expression expr) {
        if (expr instanceof PDDLNumber) {
            PDDLNumber num = (PDDLNumber) expr;
            if (this.getNumber().equals(num.getNumber())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Expression susbtFluentsWithTheirInvariants(int j) {
        return this;
    }

    @Override
    public Expression susbtFluentsWithTheirInvariants(HashMap<Object, Boolean> invariantFluent, int j) {
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.number != null ? this.number.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PDDLNumber other = (PDDLNumber) obj;
        if (this.number != other.number && (this.number == null || !this.number.equals(other.number))) {
            return false;
        }
        return true;
    }

    @Override
    public String toSmtVariableString(int i) {
//        System.out.println("Variable sign:");
        if (this.getNumber() < 0f) {
//            System.out.println("negative");
            return "(- " + String.format("%.2f", this.getNumber() * -1f) + ") ";
        } else {
            return " " + String.format("%.2f", this.getNumber()).replace("-", "") + " ";
        }

    }

    @Override
    public boolean involve(NumFluent a) {
        return false;
    }

    public boolean less(int i) {
        return this.number < i;
    }

    public boolean greater(int i) {
        return this.number > i;
    }

    @Override
    public void pddlPrint(boolean typeInformation, StringBuilder bui) {
        bui.append(this.toString());
    }
}

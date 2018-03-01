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

import conditions.Comparison;
import conditions.NumFluentValue;
import conditions.Condition;
import conditions.Predicate;
import expressions.Expression;
import expressions.NumFluent;
import expressions.PDDLNumber;
import expressions.Interval;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author enrico
 */
public class RelState extends Object {

    public ArrayList<Integer> possBollValues;//0 is negative, 1 positive, 2 both
    public ArrayList<Interval> possNumValues;

    public RelState() {
        super();
        possBollValues = new ArrayList();
        possNumValues = new ArrayList();
    }



    @Override
    public RelState clone() {
        RelState ret_val = new RelState();
        ret_val.possBollValues = (ArrayList)this.possBollValues.clone();
        ret_val.possNumValues = (ArrayList)this.possNumValues.clone();
        return ret_val;
    }


    public PDDLNumber functionInfValue(NumFluent f) {
        Interval n = this.possNumValues.get(f.id);
        if (n != null) {
            return n.getInf();
        }
        return null;
    }

    public Interval functionValues(NumFluent f) {

        Interval a = this.possNumValues.get(f.id);
        if (a != null) {
            return a;
        } else {
            Interval ret_val = new Interval(Float.NaN);
            return ret_val;
        }
    }

    public PDDLNumber functionSupValue(NumFluent f) {
        Interval a = this.possNumValues.get(f.id);
        if (a != null) {
            return a.getSup();
        }
        return null;
    }

    public void makePositive(Predicate p) {
        Integer inter = possBollValues.get(p.id);
        if (inter == null) {//if was negative by default
            possBollValues.set(p.id, 2);
        } else if (inter == 0) {//if was said to be negative
            possBollValues.set(p.id, 2);
        }//otherwise it was already fine
    }



    public boolean canBeTrue(Predicate aThis) {

        Integer o = this.possBollValues.get(aThis.id);
        if (o == null) {
            return false;
        }
        return o >= 1;
    }

    public boolean canBeFalse(Predicate aThis) {

        Integer o = this.possBollValues.get(aThis.id);
        if (o == null) {
            return true;
        }
        return o == 0 || o == 2;
    }

    public void setFunctionInfValue(NumFluent f, PDDLNumber after) {
        Interval a = this.possNumValues.get(f.id);
        if (a != null) {
            a.setInf(after);
        }

    }

    public void setFunctionSupValue(NumFluent f, PDDLNumber after) {
        Interval a = this.possNumValues.get(f.id);
        if (a != null) {
            a.setSup(after);
        }

    }

    public void makeNegative(Predicate p) {
        Integer inter = possBollValues.get(p.id);
        if (inter == null) {//if was negative by default
        } else if (inter == 1) {//if was said to be positive it will also be negative
            possBollValues.set(p.id, 2);
        }//otherwise all good (inter == 2)
    }

    public boolean satisfy(Condition con) {

        if (con == null) {
            System.out.println(this);
            System.out.println("something wrong");
            System.exit(-1);
        }
        return con.can_be_true(this);

    }

    public void setFunctionValues(NumFluent f, Interval after) {
        this.possNumValues.set(f.id, after);

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
        for (final Object o : subst.keySet()) {
            if (o instanceof NumFluent) {
                NumFluent nf = (NumFluent) o;
                if (nf.has_to_be_tracked()) {
                    this.setFunctionValues(nf, (Interval) subst.get(o));
                }
            } else {
                this.possBollValues.set(((Predicate) o).id, (Integer) subst.get(o));
            }
        }
    }

    void addNumericFluent(NumFluentValue newA) {
        this.possNumValues.set(newA.getNFluent().id, new Interval(newA.getValue().getNumber()));
    }
}

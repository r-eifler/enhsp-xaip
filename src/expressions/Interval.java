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
package expressions;

/**
 *
 * @author Enrico Scala
 */
public class Interval {

    public PDDLNumber inf;
    public PDDLNumber sup;
    public boolean is_not_a_number;

    public Interval() {
        super();
        is_not_a_number = false;
        inf = new PDDLNumber();
        sup = new PDDLNumber();
    }

    public Interval(Float i) {
        if (i.isNaN()) {
            is_not_a_number = true;
            inf = new PDDLNumber(Float.NaN);
            sup = new PDDLNumber(Float.NaN);
        }
        inf = new PDDLNumber(i);
        sup = new PDDLNumber(i);
    }

    public void set_open_interval() {

        inf.setNumber(-Float.MAX_VALUE);
        sup.setNumber(Float.MAX_VALUE);

    }

    public Interval sum(Interval b) {
        Interval ret_val = new Interval();
        if (this.is_not_a_number || b.is_not_a_number) {
            return new Interval(Float.NaN);
        }
//        System.out.println(b);
//        System.out.println("Summing ("+this.inf+","+this.sup+")"+" with ("+b.inf+","+b.sup+")");
//        System.out.println("Before ("+this.inf+","+this.sup+")");
        if (b.inf.getNumber() == -Float.MAX_VALUE || b.inf.getNumber() == Float.MAX_VALUE) {
            ret_val.inf = new PDDLNumber(b.inf.getNumber());
        } else {
            ret_val.inf = new PDDLNumber(inf.getNumber() + b.inf.getNumber());
        }
        if (b.sup.getNumber() == -Float.MAX_VALUE || b.sup.getNumber() == Float.MAX_VALUE) {
            ret_val.sup = new PDDLNumber(b.sup.getNumber());
        } else {
            ret_val.sup = new PDDLNumber(sup.getNumber() + b.sup.getNumber());
        }
//        System.out.println("After ("+ret_val.inf+","+ret_val.sup+")");
        return ret_val;
    }

    public Interval subtract(Interval b) {
        Interval ret_val = new Interval();
        ret_val.inf = new PDDLNumber(inf.getNumber() - b.sup.getNumber());
        ret_val.sup = new PDDLNumber(sup.getNumber() - b.inf.getNumber());

        return ret_val;
    }

    public Interval mult(Float a) {
        if (this.is_not_a_number) {
            return new Interval(Float.NaN);
        }
        Interval ret_val = new Interval();

        if (a < 0) {
            ret_val.inf = new PDDLNumber(sup.getNumber() * a);
            ret_val.sup = new PDDLNumber(inf.getNumber() * a);

        } else {
            ret_val.inf = new PDDLNumber(inf.getNumber() * a);
            ret_val.sup = new PDDLNumber(sup.getNumber() * a);
        }

        return ret_val;
    }

    public Interval mult(Interval b) {
        Interval ret_val = new Interval();
        //System.out.println("Moltiplicazione: " + this.inf +" * "+b.inf);
        Float ac = inf.getNumber() * b.inf.getNumber();
        Float ad = inf.getNumber() * b.sup.getNumber();
        Float bc = sup.getNumber() * b.inf.getNumber();
        Float bd = sup.getNumber() * b.sup.getNumber();
        ret_val.inf = new PDDLNumber(Math.min(ac, Math.min(ad, Math.min(bc, bd))));
        ret_val.sup = new PDDLNumber(Math.max(ac, Math.max(ad, Math.max(bc, bd))));
        return ret_val;

    }

    public boolean contain_zero() {
        if (inf.getNumber() <= 0 && sup.getNumber() >= 0) {
            return true;
        }
        return false;
    }

    public Interval div(Interval b) {
        Interval ret_val = new Interval();
        Float ac = new Float(inf.getNumber()) / new Float(b.inf.getNumber());
        Float ad = new Float(inf.getNumber()) / new Float(b.sup.getNumber());
        Float bc = new Float(sup.getNumber()) / new Float(b.inf.getNumber());
        Float bd = new Float(sup.getNumber()) / new Float(b.sup.getNumber());
        ret_val.inf = new PDDLNumber(Math.min(ac, Math.min(ad, Math.min(bc, bd))));
        ret_val.sup = new PDDLNumber(Math.max(ac, Math.max(ad, Math.max(bc, bd))));

        return ret_val;
    }

    @Override
    public Interval clone() {
        Interval ret_val = new Interval();

        ret_val.inf = new PDDLNumber(this.inf.getNumber());
        ret_val.sup = new PDDLNumber(this.sup.getNumber());
        return ret_val;

    }

    public Interval sum(Float number) {
        Interval ret_val = new Interval();
        ret_val.inf = new PDDLNumber(this.inf.getNumber() + number);
        ret_val.sup = new PDDLNumber(this.sup.getNumber() + number);
        return ret_val;
    }

    public boolean can_be_negative() {
        return this.inf.less(0) || this.sup.less(0);//the second case should not happen
    }

    public boolean can_be_positive() {
        return this.inf.greater(0) || this.sup.greater(0);
    }

    Interval pow(Interval second) {
        Interval ret = new Interval();

        if (second.inf.getNumber() == 0.5f) {//sqrt treatment
//            System.out.println("Debug");
            //both negative
            if (this.inf.getNumber() < 0 && this.sup.getNumber() < 0) {
                ret.inf.setNumber(Float.NaN);
                return ret;
            }
            //the inf is negative
            if (this.inf.getNumber() < 0) {
                ret.inf.setNumber(0.0f);
                ret.sup.setNumber(new Float(Math.pow(this.sup.getNumber(), second.inf.getNumber())));
                return ret;
            }
            //both positive
            ret.inf.setNumber(new Float(Math.pow(this.inf.getNumber(), second.inf.getNumber())));
            ret.sup.setNumber(new Float(Math.pow(this.sup.getNumber(), second.inf.getNumber())));
            return ret;
            
        }else{//higher integral powers
            if (this.inf.getNumber() > 0 || (second.inf.getNumber() % 2 != 0)) {
//            if (this.inf.getNumber() >= 0 ) {

//                System.out.println("debug");
                ret.inf.setNumber((float) Math.pow(this.inf.getNumber(), second.inf.getNumber()));
                ret.sup.setNumber((float) Math.pow(this.sup.getNumber(), second.inf.getNumber()));
            } else if (this.sup.getNumber() < 0) {
                ret.inf.setNumber((float) Math.pow(this.sup.getNumber(), second.inf.getNumber()));
                ret.sup.setNumber((float) Math.pow(this.inf.getNumber(), second.inf.getNumber()));
            } else {
                ret.inf.setNumber(0.0f);
                ret.sup.setNumber(Math.max((float) Math.pow(this.inf.getNumber(), second.inf.getNumber()), (float) Math.pow(this.sup.getNumber(), second.inf.getNumber())));
            }
            return ret;
        }
    }

    @Override
    public String toString() {
        return "(" + this.inf + "," + this.sup + ")";
    }
}

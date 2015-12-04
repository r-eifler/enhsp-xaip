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

package expressions;

/**
 *
 * @author Enrico Scala
 */
public class PDDLNumbers {

    public PDDLNumber inf;
    public PDDLNumber sup;

    public PDDLNumbers() {
        super();
    }

    PDDLNumbers(float i) {
        inf = new PDDLNumber(i);
        sup = new PDDLNumber(i);
    }

    public PDDLNumbers sum(PDDLNumbers b) {
        PDDLNumbers ret_val = new PDDLNumbers();
//        System.out.println(b);
//        System.out.println("Summing ("+this.inf+","+this.sup+")"+" with ("+b.inf+","+b.sup+")");
//        System.out.println("Before ("+this.inf+","+this.sup+")");
        if (b.inf.getNumber()==-Float.MIN_VALUE || b.inf.getNumber() == Float.MAX_VALUE){
            ret_val.inf =new PDDLNumber(b.inf.getNumber());
        }else{
            ret_val.inf = new PDDLNumber(inf.getNumber() + b.inf.getNumber());
        }
        if (b.sup.getNumber()==-Float.MIN_VALUE || b.sup.getNumber() == Float.MAX_VALUE){
            ret_val.sup =new PDDLNumber(b.sup.getNumber());
        }else{
            ret_val.sup = new PDDLNumber(sup.getNumber() + b.sup.getNumber());
        }
//        System.out.println("After ("+ret_val.inf+","+ret_val.sup+")");
        return ret_val;
    }

    public PDDLNumbers subtract(PDDLNumbers b) {
        PDDLNumbers ret_val = new PDDLNumbers();
        ret_val.inf = new PDDLNumber(inf.getNumber() - b.sup.getNumber());
        ret_val.sup = new PDDLNumber(sup.getNumber() - b.inf.getNumber());

        return ret_val;
    }

    public PDDLNumbers mult(Float a) {
        PDDLNumbers ret_val = new PDDLNumbers();

        if (a < 0) {
            ret_val.inf = new PDDLNumber(sup.getNumber() * a);
            ret_val.sup = new PDDLNumber(inf.getNumber() * a);

        } else {
            ret_val.inf = new PDDLNumber(inf.getNumber() * a);
            ret_val.sup = new PDDLNumber(sup.getNumber() * a);
        }

        return ret_val;
    }

    public PDDLNumbers mult(PDDLNumbers b) {
        PDDLNumbers ret_val = new PDDLNumbers();
        //System.out.println("Moltiplicazione: " + this.inf +" * "+b.inf);
        Float ac = inf.getNumber() * b.inf.getNumber();
        Float ad = inf.getNumber() * b.sup.getNumber();
        Float bc = sup.getNumber() * b.inf.getNumber();
        Float bd = sup.getNumber() * b.sup.getNumber();
        ret_val.inf = new PDDLNumber(Math.min(ac, Math.min(ad, Math.min(bc, bd))));
        ret_val.sup = new PDDLNumber(Math.max(ac, Math.max(ad, Math.max(bc, bd))));
        return ret_val;

    }

    public PDDLNumbers div(PDDLNumbers b) {
        PDDLNumbers ret_val = new PDDLNumbers();
        Float ac = new Float(inf.getNumber()) / new Float(b.inf.getNumber());
        Float ad = new Float(inf.getNumber()) / new Float(b.sup.getNumber());
        Float bc = new Float(sup.getNumber()) / new Float(b.inf.getNumber());
        Float bd = new Float(sup.getNumber()) / new Float(b.sup.getNumber());
        ret_val.inf = new PDDLNumber(Math.min(ac, Math.min(ad, Math.min(bc, bd))));
        ret_val.sup = new PDDLNumber(Math.max(ac, Math.max(ad, Math.max(bc, bd))));

        return ret_val;
    }

    public PDDLNumbers clone() {
        PDDLNumbers ret_val = new PDDLNumbers();

        ret_val.inf = new PDDLNumber(this.inf.getNumber());
        ret_val.sup = new PDDLNumber(this.sup.getNumber());
        return ret_val;

    }

    public PDDLNumbers sum(Float number) {
        PDDLNumbers ret_val = new PDDLNumbers();
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
}

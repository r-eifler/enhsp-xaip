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
 * @author enrico
 */
public class Addendum {

    public PDDLNumber n;
    public NumFluent f;

    public Addendum() {
    }

    public Addendum(NumFluent f, PDDLNumber n) {

        this.f = f;
        this.n = n;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Addendum ret = new Addendum();
        if (this.f != null) {
            ret.f = (NumFluent) this.f.clone();
        } else {
            ret.f = null;
        }
        ret.n = (PDDLNumber) this.n.clone();
        return ret;
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Addendum other = (Addendum) obj;
        if (!other.n.equals(this.n))
            return false;
        if (other.f == null && this.f!= null)
            return false;
        if (other.f != null && this.f== null)
            return false;
        if (other.f == null && this.f== null)
            return true;
        
        if (!other.f.equals(this.f))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (this.n != null ? this.n.hashCode() : 0);
        hash = 37 * hash + (this.f != null ? this.f.hashCode() : 0);
        return hash;
    }
    
    public Float scale(Addendum obj){
        if (this.f != obj.f)
            return null;
        Float a = this.n.getNumber();
        Float b = obj.n.getNumber();
        return a/b;
    }

    @Override
    public String toString() {
        return "Addendum{" + "n=" + n + ", f=" + f + '}';
    }
    
    
}

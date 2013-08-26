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
}

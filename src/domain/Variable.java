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

package domain;

/**
 *
 * @author enrico
 */
public class Variable extends Object {

    private String Name;
    private Type type;

    public Variable(String Name, Type type) {
        this.Name = Name;
        this.type = type;
    }

    public Variable(String text) {
        Name = text;

    }

    @Override
    public String toString() {

        return getName();

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.getName() != null ? this.getName().hashCode() : 0);
        hash = 97 * hash + (this.getType() != null ? this.getType().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Variable) {
            Variable o1 = (Variable) o;
            if ((o1.getName() == null ? this.getName() == null : o1.getName().equalsIgnoreCase(this.getName()))) {
                if (o1.getType() == this.getType()) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return false;


    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Type type) {
        this.type = type;
    }
}

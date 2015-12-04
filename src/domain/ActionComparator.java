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
package domain;

//import java.util.Comparator;
import java.util.Comparator;

/**
 *
 * @author enrico
 */
class ActionComparator implements Comparator {

    public ActionComparator() {
    }

    @Override
    public int compare(Object arg0, Object arg1) {
        GenericActionType gr0 = (GenericActionType)arg0;
        GenericActionType gr1 = (GenericActionType)arg1;
        
       return gr0.name.compareTo(gr1.name);
        
    }
    
}
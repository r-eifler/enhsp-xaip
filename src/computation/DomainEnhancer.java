
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

package computation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import problem.GroundAction;

/**
 *
 * @author Enrico Scala
 */
public class DomainEnhancer {
    
    public void addMacroOperator(String domainFile, GroundAction gr) throws CloneNotSupportedException, IOException{
        
        String constants = "(costants: "+gr.getParameters().pddlPrint()+")";
        GroundAction temp = (GroundAction)gr.clone();
        temp.setName("Macro");
        String action = temp.toPDDL(); 
        
        Writer f;
        f = new BufferedWriter(new FileWriter(domainFile));
        //todo!!!
        
        
    }
    
}

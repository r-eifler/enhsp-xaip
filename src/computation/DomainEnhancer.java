/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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


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

import domain.ActionParametersAsTerms;
import domain.PddlDomain;
import extraUtils.Utils;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import plan.SimplePlan;
import problem.GroundAction;

/**
 *
 * @author Enrico Scala
 */
public class DomainEnhancer {
    private String domainEnhancedFileName;
    
    public void addMacroOperator(String domainFile, GroundAction gr) throws CloneNotSupportedException, IOException{
        
        String constants = "(costants: "+gr.getParameters().pddlPrint()+")";
        GroundAction temp = (GroundAction)gr.clone();
        temp.setName("Macro");
        String action = temp.toPDDL(); 
        
        Writer f;
        f = new BufferedWriter(new FileWriter("enh"+domainFile));
//        f.write()
        //todo!!!
        
        
    }

    public void addMacroOperator(PddlDomain domain, GroundAction gr) throws CloneNotSupportedException, IOException {
                
        String constants = "(:constants "+gr.getParameters().pddlPrint()+")\n";
        //GroundAction temp = (GroundAction)gr.clone();
        gr.setName("macro");
        //String action = temp.toPDDL(); 
        
        Writer f;
        setEnhancedDomainFileName(domain.getPddlFilRef()+"enh");
        f = new BufferedWriter(new FileWriter(getDomainEnhancedFileName()));
        
        f.write("(define (domain "+domain.getName()+")\n");
        if (domain.getRequirements()!=null)
            f.write("(:requirements "+Utils.toPDDLSet(domain.getRequirements())+")\n");
        if (domain.getTypes()!=null)
            f.write("(:types "+Utils.toPDDLTypesSet(domain.getTypes())+")\n");
        if (!domain.getPredicates().isEmpty())
        f.write(constants);
            f.write("(:predicates "+domain.getPredicates().pddlPrint(true) +"\n");
        if (!domain.getFunctions().isEmpty())
            f.write("(:functions "+Utils.toPDDLSet(domain.getFunctions()) +")\n");
       
        if (!domain.getActionsSchema().isEmpty()) {
            f.write(Utils.toPDDLSetWithBreak(domain.getActionsSchema()));
        }
        
        f.write(gr.toPDDL());
        f.write("\n)");
        f.close();
    }

    public Map addMacroOperators(PddlDomain domain, List macroOps) throws IOException {
        
        Writer f;
        Map ret = new HashMap();
        setEnhancedDomainFileName(domain.getPddlFilRef()+"enh");

        f = new BufferedWriter(new FileWriter(domain.getPddlFilRef()+"enh"));
        ActionParametersAsTerms constants = new ActionParametersAsTerms();
        String actions = "\n";
        int i=0;
        for (Object o: macroOps){
            
            GroundAction gr = (GroundAction)o;
            constants.addALLNewObjects(gr.getParameters());
            gr.setName("macro"+i);
            ret.put(gr.getName(), gr.getPrimitives());
            
            actions += gr.toPDDL()+"\n";
            i++;
        }
        f.write("(define (domain "+domain.getName()+")\n");
        if (domain.getRequirements()!=null)
            f.write("(:requirements "+Utils.toPDDLSet(domain.getRequirements())+")\n");
        if (domain.getTypes()!=null)
            f.write("(:types "+Utils.toPDDLTypesSet(domain.getTypes())+")\n");
        if (!domain.getPredicates().isEmpty())
        f.write("(:constants "+constants.pddlPrint()+")\n");
            f.write("(:predicates "+domain.getPredicates().pddlPrint(true) +"\n");
        if (!domain.getFunctions().isEmpty())
            f.write("(:functions "+Utils.toPDDLSet(domain.getFunctions()) +")\n");
       
        if (!domain.getActionsSchema().isEmpty()) {
            f.write(Utils.toPDDLSetWithBreak(domain.getActionsSchema()));
        }
        
        f.write(actions);
        f.write("\n)");
        f.close();
        f.close();
        return ret;
    }
    
    public Map addMacroOperators(PddlDomain domain, List macroOps, SimplePlan sp) throws IOException {
        
        Writer f;
        Map ret = new HashMap();
        setEnhancedDomainFileName(domain.getPddlFilRef()+"enh");

        f = new BufferedWriter(new FileWriter(domain.getPddlFilRef()+"enh"));
        ActionParametersAsTerms constants = new ActionParametersAsTerms();
        String actions = "\n";
        int i=0;
        for (Object o: macroOps){
            
            GroundAction gr = (GroundAction)o;
            constants.addALLNewObjects(gr.getParameters());
            int first = sp.indexOf((GroundAction)gr.getPrimitives().get(0));
            int last = sp.indexOf((GroundAction)gr.getPrimitives().get(gr.getPrimitives().size()-1));
            gr.setName("macro_"+first+"-"+last);
            ret.put(gr.getName(), gr.getPrimitives());
            
            actions += gr.toPDDL()+"\n";
            i++;
        }
        f.write("(define (domain "+domain.getName()+")\n");
        if (domain.getRequirements()!=null)
            f.write("(:requirements "+Utils.toPDDLSet(domain.getRequirements())+")\n");
        if (domain.getTypes()!=null)
            f.write("(:types "+Utils.toPDDLTypesSet(domain.getTypes())+")\n");
        if (!domain.getPredicates().isEmpty())
        f.write("(:constants "+constants.pddlPrint()+")\n");
            f.write("(:predicates "+domain.getPredicates().pddlPrint(true) +"\n");
        if (!domain.getFunctions().isEmpty())
            f.write("(:functions "+Utils.toPDDLSet(domain.getFunctions()) +")\n");
       
        if (!domain.getActionsSchema().isEmpty()) {
            f.write(Utils.toPDDLSetWithBreak(domain.getActionsSchema()));
        }
        
        f.write(actions);
        f.write("\n)");
        f.close();
        f.close();
        return ret;
    }

    /**
     * @return the domainEnhancedFileName
     */
    public String getDomainEnhancedFileName() {
        return domainEnhancedFileName;
    }

    /**
     * @param domainEnhancedFileName the domainEnhancedFileName to set
     */
    public void setEnhancedDomainFileName(String domainEnhancedFileName) {
        this.domainEnhancedFileName = domainEnhancedFileName;
    }
    

}

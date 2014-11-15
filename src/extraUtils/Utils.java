/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package extraUtils;

import domain.Type;
import java.io.File;
import java.util.Collection;

/**
 *
 * @author enrico
 */
public class Utils {

    public static String toPDDLSet(Collection c) {
        String ret = "";
        for (Object o : c) {
            ret += " "+o.toString();
        }
        return ret;
    }
    
    
    public static String toPDDLSetWithBreak(Collection c) {
        String ret = "";
        for (Object o : c) {
            ret += o.toString()+"\n";
        }
        return ret;
    }

    public static String toPDDLTypesSet(Collection c) {
        String ret = "";
        for (Object o : c) {
            Type t = (Type)o;
            ret += " "+t.pddlString();
        }
        return ret;
    }
    
    public static void deleteFile(String fileName){
       
        new File(fileName).delete();
    }

}

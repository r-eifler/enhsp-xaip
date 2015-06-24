/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package extraUtils;

import domain.Type;
import java.io.File;
import java.util.Collection;
//import static sun.org.mozilla.javascript.Token.name;

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
    
    public static void remove_file(String name){
        try{

            File file = new File(name);
            file.delete();

            }catch(Exception e){

                    e.printStackTrace();

            }
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
    
    public static String searchParameterValue(String[] args, String par) {

        //System.out.println("Searching option " + par);
        for (int i = 0; i < args.length - 1; i++) {
            if (args[i].equals(par)) {
                String ret = args[++i];
                if (ret == null)
                    return null;
                if (ret.charAt(0)=='-')
                    return null;
                return ret;
            }
        }

        return null;
    }
    
    
    public static boolean searchParameter(String[] args, String par) {

        //System.out.println("Searching option " + par);
        for (int i = 0; i < args.length ; i++) {
            if (args[i].equals(par)) {
                return true;
            }
        }

        return false;
    }
    
//    public static String[] searchParameterValue(String[] args, String par) {
//
//        //System.out.println("Searching option " + par);
//        for (int i = 0; i < args.length - 1; i++) {
//            if (args[i].equals(par)) {
//                String[] ret = new String[100];
//                while(true){
//                    
//                }
//                
//                String ret = args[++i];
//                if (ret == null)
//                    return null;
//                if (ret.charAt(0)=='-')
//                    return null;
//                return ret;
//            }
//        }
//
//        return null;
//    }

}

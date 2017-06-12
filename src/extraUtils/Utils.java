
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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package extraUtils;

import domain.ActionSchema;
import domain.Type;
import java.io.File;
import java.util.Collection;
//import static sun.org.mozilla.javascript.Token.name;

/**
 *
 * @author enrico
 */
public class Utils {

    public static void dbg_print(int debug, String string) {
        if (debug > 0) {
            System.out.print(string);
        }
    }
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
    
     public static String toPDDLWithExtraObject(Collection<ActionSchema> c) {
        String ret = "";
        for (ActionSchema o : c) {
            ret += o.pddlPrintWithExtraObject()+"\n";
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

/**
 * *******************************************************************
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
 ********************************************************************
 */
/**
 * *******************************************************************
 * Description: Part of the PPMaJaL library
 *
 * Author: Enrico Scala 2013
 * Contact: enricos83@gmail.com
 *
 ********************************************************************
 */
package wrapped_planners;

import extraUtils.Utils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import plan.SimplePlan;

public class metricFFWrapper extends planningTool {

    public metricFFWrapper() {
        super();
        option1 = "";       //"-O";
        option2 = "";

        planningExec = "ff";
        this.setTimeout(10000);
        Utils.deleteFile(storedSolutionPath);

//        ArrayList solution;
    }

    @Override
    public String plan() {
        try {
            System.out.println("Planning...");
            this.executePlanning();
            //System.out.println(outputPlanning);
            if (this.isTimeoutFail()) {
                System.out.println("....TIMEOUT");
                return null;
            }
            if (this.outputPlanning.contains("unsolvable") || (this.outputPlanning.contains("goal can be simplified to FALSE"))) {
                this.failed = true;
                System.out.println("....UNSOLVABLE");
                this.findTotalTimeInFile(outputPlanning);
                return null;
            }
            if (!this.outputPlanning.contains("found legal plan")) {
                this.failed = false;
                this.setPlannerError(true);
                System.out.println("....UNKNOWN ERROR!!");
                this.findTotalTimeInFile(outputPlanning);
                return null;
            }

            System.out.println("....SUCCESS");
            putSolutionInFile(this.outputPlanning);
            this.findTotalTimeInFile(outputPlanning);

            return this.storedSolutionPath;
        } catch (IOException ex) {
            Logger.getLogger(metricFFWrapper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String plan(String domainFile, String problemFile) {

        //System.out.println("planning");
        this.setDomainFile(domainFile);
        this.setProblemFile(problemFile);

        return plan();

    }

    private void putSolutionInFile(String s) throws IOException {

        Scanner sc = new Scanner(s);
        boolean atleastanaction = false;
        Writer output = new BufferedWriter(new FileWriter(storedSolutionPath));
        output.write("\n");
        while (sc.hasNextLine()) {
            if (sc.findInLine("[0-9]: ") != null) {
                //System.out.println("("+sc.nextLine()+")");
                output.write("(" + sc.nextLine() + ")\n");
                atleastanaction = true;
            } else {
                sc.nextLine();
            }
        }

        output.close();

    }

    @Override
    public String adapt(String domainFile, String problemFile, String planFile) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void findTotalTimeInFile(String s) {
        Scanner sc = new Scanner(s);

        while (sc.hasNextLine()) {
            String test = sc.findInLine("[0-9]+[.][0-9]+ seconds total time");
            if (test != null) {
                Scanner temp = new Scanner(test);
                this.setTimePlanner((int) (Float.parseFloat(temp.findInLine("[0-9]+[.][0-9]+")) * 1000));
                System.out.println("time" + this.getPlannerTime());
            } else {
                sc.nextLine();
            }
        }
    }

    @Override
    public void changePlannersPath() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

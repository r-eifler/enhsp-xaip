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
package wrapped_planners;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProbeWrapper extends planningTool {
    private String solutionFile;

    public ProbeWrapper() {
        super();
        option1 = "";       //"-O";
        option2 = "";
        planningExec = "probe";
        this.solutionFile="out";
        this.setTimeout(100000);

//        ArrayList solution;
    }

    @Override
    public String plan() {
        
            System.out.println("Planning...");
            this.executePlanning();
            System.out.println(outputPlanning);
            if (this.outputPlanning.contains("unsolvable")){
                this.failed=true;
                System.out.println("....UNSOLVABLE");
                return null;
            }
            if (!this.outputPlanning.contains("SOLUTION 1")){
                this.failed=true;
                System.out.println("....UNKNOWN ERROR");
                return null;
            }
            if (this.isFailed()) {
                System.out.println("....TIMEOUT");
                return null;
            }
            System.out.println("....SUCCESS");
            setTime(this.outputPlanning);
            return this.solutionFile+".1";
         
    }

    @Override
    public void executePlanning() {
        Runtime rt = Runtime.getRuntime();
        outputPlanning = "";
        try {

            Runtime runtime = Runtime.getRuntime();
            System.out.println("Executing: " + planningExec + " -d " + domainFile + " -i " + problemFile + " -o "+ getSolutionFile() + option1 + " " + option2);
            process = runtime.exec(planningExec + " -d " + domainFile + " -i " + problemFile + " -o "+ getSolutionFile() + option1 + " " + option2);
            /* Set up process I/O. */

            Worker worker = new Worker(process);
            worker.start();
            worker.join(getTimeout());

            if (worker.exit != null) {
                BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
                
                String line = null;
                while ((line = input.readLine()) != null) {
                    outputPlanning = outputPlanning.concat(line + "\n");
                    //System.out.println(outputPlanning);
                }
            } else {
                process.destroy();
                failed = true;
                this.setTimeoutFail(true);
                this.setTimePlanner((int) getTimeout());
            }

        } catch (IOException e) {
            System.out.println("Planner eccezione" + e.toString());
        } catch (InterruptedException e) {
            System.out.println("Planner eccezione" + e.toString());
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



    }

    @Override
    public String adapt(String domainFile, String problemFile, String planFile) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @return the solutionFile
     */
    public String getSolutionFile() {
        return solutionFile;
    }

    /**
     * @param solutionFile the solutionFile to set
     */
    public void setSolutionFile(String solutionFile) {
        this.solutionFile = solutionFile;
    }

    private void setTime(String outputPlanning) {
        Scanner sc;
        sc = new Scanner(outputPlanning);

        while (sc.hasNextLine()) {
            String test = sc.findInLine("Time: [0-9]+[.][0-9]+");
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
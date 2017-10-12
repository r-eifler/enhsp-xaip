/* 
 * Copyright (C) 2010-2017 Enrico Scala. Contact: enricos83@gmail.com.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package wrapped_planners;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class planningTool {

    public String outputPlanning;
    Process process;
    public String storedSolutionPath = "sol.pddl";
    protected int plannerTime;
    long timeout;
    protected boolean failed = false;
    private boolean timeoutFail = false;
    private boolean plannerError;
    protected String domain_file_option = " -o ";
    protected String problem_file_option = " -f ";

    /**
     * Get the value of timeoutFail
     *
     * @return the value of timeoutFail
     */
    public boolean isTimeoutFail() {
        return timeoutFail;
    }

    /**
     * Set the value of timeoutFail
     *
     * @param timeoutFail new value of timeoutFail
     */
    public void setTimeoutFail(boolean timeoutFail) {
        this.timeoutFail = timeoutFail;
    }

    public planningTool() {
        timeout = 1000000;
    }

    abstract public String adapt(String domainFile, String problemFile, String planFile);

    abstract public void changePlannersPath();

    public void executePlanning() {
        Runtime rt = Runtime.getRuntime();
        outputPlanning = "";
        try {

            Utility.deleteFile("temp.SOL");
            Runtime runtime = Runtime.getRuntime();

//            System.out.println("This is what I am running");
//            System.out.println("Executing: " + planningExec + domain_file_option + domainFile + problem_file_option + problemFile + " " + option1 + " " + option2);
            process = runtime.exec(planningExec + domain_file_option + domainFile + problem_file_option + problemFile + " " + option1 + " " + option2);
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
                failed = false;
                this.setTimeoutFail(true);
                this.setTimePlanner((int) getTimeout());
            }
            //System.out.println("Time del planner: "+ this.getPlannerTime());

        } catch (IOException e) {
            System.out.println("Planner eccezione" + e.toString());
        } catch (InterruptedException e) {
            System.out.println("Planner eccezione" + e.toString());
        }
    }

    public void setDomainFile(String domainFile) {
        this.domainFile = domainFile;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getPlanningExec() {
        return planningExec;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getDomainFile() {
        return domainFile;
    }

    public void setPlanningExec(String lpgPath) {
        this.planningExec = lpgPath;
    }

    public String getOption1() {
        return option1;
    }

    public void setProblemFile(String problemFile) {
        this.problemFile = problemFile;
    }

    public String getProblemFile() {
        return problemFile;
    }

    public abstract String plan(String domainFile, String problemFile);

    public abstract String plan();
    protected String option1;
    protected String option2;
    protected String planningExec;
    protected String domainFile;
    protected String problemFile;

    /**
     * @return the timePlanner
     */
    public int getPlannerTime() {
        return plannerTime;
    }

    /**
     * @param timePlanner the timePlanner to set
     */
    public void setTimePlanner(int timePlanner) {
        this.plannerTime = timePlanner;
    }

    /**
     * @return the timeout
     */
    public long getTimeout() {
        return timeout;
    }

    /**
     * @param timeout the timeout to set
     */
    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    /**
     * @return the failed
     */
    public boolean isFailed() {
        return failed;
    }

    /**
     * @return the plannerError
     */
    public boolean isPlannerError() {
        return plannerError;
    }

    /**
     * @param plannerError the plannerError to set
     */
    public void setPlannerError(boolean plannerError) {
        this.plannerError = plannerError;
    }

    protected static class Worker extends Thread {

        protected final Process process;
        protected Integer exit;

        protected Worker(Process process) {
            this.process = process;
        }

        @Override
        public void run() {
            try {
                exit = process.waitFor();
            } catch (InterruptedException ignore) {
                return;
            }
        }
    }
}

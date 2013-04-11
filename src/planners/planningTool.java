package planners;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class planningTool {

    public String outputPlanning;
    Process process;
    public String storedSolutionPath;
    private int timePlanner;
    private long timeout;
    private boolean failed = false;
    
    public planningTool(){
        timeout = 1000000;
    }

    public void executePlanning() {
        Runtime rt = Runtime.getRuntime();
        outputPlanning = "";
        try {


            Runtime runtime = Runtime.getRuntime();
            process = runtime.exec(planningExec + " -o " + domainFile + " -f " + problemFile + " " + option1 + " " + option2);
            /* Set up process I/O. */

            Worker worker = new Worker(process);
            worker.start();
            worker.join(getTimeout());
          
            if (worker.exit != null) {
                BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line = null;
                while ((line = input.readLine()) != null) {
                    //System.out.println(line);
                    
                    outputPlanning = outputPlanning.concat(line + "\n");
                }
            }else{
                process.destroy();
                failed = true;
                this.setTimePlanner((int)getTimeout());
            }

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
    public int getTimePlanner() {
        return timePlanner;
    }

    /**
     * @param timePlanner the timePlanner to set
     */
    public void setTimePlanner(int timePlanner) {
        this.timePlanner = timePlanner;
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

    private static class Worker extends Thread {

        private final Process process;
        private Integer exit;

        private Worker(Process process) {
            this.process = process;
        }

        public void run() {
            try {
                exit = process.waitFor();
            } catch (InterruptedException ignore) {
                return;
            }
        }
    }
}

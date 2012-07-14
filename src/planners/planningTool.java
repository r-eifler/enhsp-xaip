package planners;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class planningTool {

    public String outputPlanning;
    Process process;
    public String storedSolutionPath;

    public void executePlanning() {
        Runtime rt = Runtime.getRuntime();
        outputPlanning = "";
        try {
            process = rt.exec(planningExec + " -o " + domainFile + " -f " + problemFile + " " + option1 + " " + option2);

            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));


            String line = null;

            while ((line = input.readLine()) != null) {
                System.out.println(line);
                outputPlanning = outputPlanning.concat(line + "\n");
            }

            int exitVal = process.waitFor();
            
            //System.out.println("Exited with error code " + exitVal);
            //this.putSolutionInFile(outputPlanning);
        } catch (IOException e) {
            System.out.println("Planner eccezione"+e.toString());
        } catch (InterruptedException e) {
            System.out.println("Planner eccezione"+e.toString());
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
    
    
    public abstract String plan(String domainFile,String problemFile);
    public abstract String plan();
    
    
    protected String option1;
    protected String option2;
    protected String planningExec;
    protected String domainFile;
    protected String problemFile;
}

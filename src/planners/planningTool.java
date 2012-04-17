package planners;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class planningTool {
    public void executePlanning() {
        Runtime rt = Runtime.getRuntime();
        try {
            Process pr =
                rt.exec(planningExec + " -o " + domainFile + " -f " + problemFile + " " + option1 + " " + option2);

            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));

            String line = null;

            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }

            int exitVal = pr.waitFor();
            System.out.println("Exited with error code " + exitVal);
        } catch (IOException e) {
        } catch (InterruptedException e) {
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
    protected String option1;
    protected String option2;
    protected String planningExec;
    protected String domainFile;
    protected String problemFile;
}

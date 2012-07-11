package planners;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class metricFFWrapper extends planningTool {
    public metricFFWrapper() {
        super();
        option1 = "-O";
        option2 = "";
        planningExec = "/home/enrico/planner/planners/Metric-FF/ff";
        storedSolutionPath = "sol.pddl";
//        ArrayList solution;
    }

    public String plan() throws IOException{
         this.executePlanning();
         putSolutionInFile(this.outputPlanning);
         return this.storedSolutionPath;
    }
    public String plan(String domainFile,String problemFile) throws IOException{
         this.setDomainFile(domainFile);
         this.setProblemFile(problemFile);
         this.executePlanning();
         putSolutionInFile(this.outputPlanning);
         return this.storedSolutionPath;
    }

    private void putSolutionInFile(String s) throws IOException {
        
        Scanner sc = new Scanner(s);
        Writer output = new BufferedWriter(new FileWriter(storedSolutionPath));
        output.write("\n");
        while(sc.hasNextLine()){    
            if (sc.findInLine("[0-9]: ") != null){
                //System.out.println("("+sc.nextLine()+")");
                output.write("("+sc.nextLine()+")\n");
            }else
                sc.nextLine();
        }
        output.close();
    }
}

package planners;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import plan.SimplePlan;

public class metricFFWrapper extends planningTool {
    public metricFFWrapper() {
        super();
        option1 = "-O";       //"-O";
        option2 = "";
        planningExec = "ff";
        storedSolutionPath = "temp4.pddl";
//        ArrayList solution;
    }

    @Override
    public String plan(){
        try {
            this.executePlanning();
            if (this.isFailed())
                return null;
            putSolutionInFile(this.outputPlanning);
            return this.storedSolutionPath;
        } catch (IOException ex) {
            Logger.getLogger(metricFFWrapper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    @Override
    public String plan(String domainFile,String problemFile){
        try {
            //System.out.println("planning");
            this.setDomainFile(domainFile);
            this.setProblemFile(problemFile);
            this.executePlanning();
            putSolutionInFile(this.outputPlanning);
            return this.storedSolutionPath;
        } catch (IOException ex) {
            Logger.getLogger(metricFFWrapper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
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
        sc = new Scanner(s);
        
        
        while(sc.hasNextLine()){
            String test = sc.findInLine("[0-9]+[.][0-9]+ seconds total time");
            if (test != null){
                Scanner temp = new Scanner(test);
                this.setTimePlanner((int)(Float.parseFloat(temp.findInLine("[0-9]+[.][0-9]+"))*1000));
                System.out.println("time" + this.getTimePlanner());
            }else
                sc.nextLine();
        }
        
        output.close();
    }
    

}

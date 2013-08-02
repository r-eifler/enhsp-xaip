package planners;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class lpgWrapper extends planningTool {

    public lpgWrapper() {
        super();
        option1 = "-quality -timesteps";
        option2 = "-out temp";
        planningExec = "lpg-td-1.0";

    }

    public String adapt(String domainFile, String problemFile, String planFile) {
        try {
            this.planningExec = "lpg-adapt";
            this.option2 = this.option2 + " -input_plan " + planFile;

            //System.out.println("planning");
            this.setDomainFile(domainFile);
            this.setProblemFile(problemFile);
            this.executePlanning();
            System.out.println(this.outputPlanning);
            //putSolutionInFile(this.outputPlanning);
            if (!failed) {
                if (!(new File("temp.SOL").exists())) {
                    failed = true;
                } else {
                    putSolutionInFile2("temp.SOL");
                }
            }
            return this.storedSolutionPath;
        } catch (IOException ex) {
            Logger.getLogger(metricFFWrapper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public String plan() {
        try {
            this.executePlanning();
            if (this.isFailed()) {
                return null;
            }
            if (!failed) {
                if (!(new File("temp.SOL").exists())) {
                    failed = true;
                } else {
                    putSolutionInFile2("temp.SOL");
                }
            }
            return this.storedSolutionPath;
        } catch (IOException ex) {
            Logger.getLogger(metricFFWrapper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String plan(String domainFile, String problemFile) {
        try {
            //System.out.println("planning");
            this.setDomainFile(domainFile);
            this.setProblemFile(problemFile);
            this.executePlanning();
            //System.out.println(this.outputPlanning);
            //putSolutionInFile(this.outputPlanning);
            if (!failed) {
                if (!(new File("temp.SOL").exists())) {
                    failed = true;
                } else {
                    putSolutionInFile2("temp.SOL");
                }
            }
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
        ArrayList a = new ArrayList();
        while (sc.hasNextLine()) {
            String prova;
            prova = sc.findInLine("[0-9]:[\\s][(][a-zA-Z0-9_[-]\\s]*[)]");
            //prova = sc.findInLine("ACTION");
            if (prova != null) {
                output.write(prova + "\n");
                //System.out.println(prova.substring(3));
                //a.add(prova);
            } else {
                String time = sc.findInLine("Total time:[\\s]*[0-9]+[.][0-9]+");
                if (time != null) {
                    Float t = Float.parseFloat(time.substring(time.indexOf(":") + 1));
                    Integer msec = (int) (float) (t * 1000);
                    this.setTimePlanner(msec);
                    System.out.println("time" + this.getTimePlanner());

                }

            }

            sc.nextLine();
        }
        //System.out.println(a.size());
        output.close();
        //System.exit(-1);
    }

    private void putSolutionInFile2(String s) throws IOException {

        Scanner sc = new Scanner(new FileReader(s));
        Writer output = new BufferedWriter(new FileWriter(storedSolutionPath));
        output.write("\n");
        //System.out.println("prova");
        //ArrayList a = new ArrayList();
        while (sc.hasNextLine()) {

            String prova;
            prova = sc.findInLine("[(][a-zA-Z0-9_[-]\\s]*[)]");
            //prova = sc.findInLine("ACTION");
            if (prova != null) {
                output.write(prova + "\n");
                //System.out.println(prova.substring(3));
                //a.add(prova);
            } else {
                String time = sc.findInLine("Time[\\s]*[0-9]+[.][0-9]+");
                if (time != null) {
                    Float t = Float.parseFloat(time.substring(time.indexOf(" ") + 1));
                    Integer msec = (int) (float) (t * 1000);
                    this.setTimePlanner(msec);
                    System.out.println("time" + this.getTimePlanner());

                }

            }

            sc.nextLine();
        }
        //System.out.println(a.size());
        output.close();
        //System.exit(-1);
    }
}

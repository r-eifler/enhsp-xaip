package planners;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class planningTool {

    String outputPlanning;
    Process process;
    public void executePlanning() {
        Runtime rt = Runtime.getRuntime();
        outputPlanning = "";
        try {
           process =
                    rt.exec(planningExec + " -o " + domainFile + " -f " + problemFile + " " + option1 + " " + option2);

            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line = null;

            while ((line = input.readLine()) != null) {
                System.out.println(line);
                outputPlanning = outputPlanning.concat(line);
            }

            int exitVal = process.waitFor();
            System.out.println("Exited with error code " + exitVal);
        } catch (IOException e) {
        } catch (InterruptedException e) {
        }
    }

    
    private static String planningbrutale(String dom, String probl, String planner, String fdOpt) throws IOException {
        String osName = System.getProperty("os.name");
        String sep = System.getProperty("file.separator");							//separatore
        String[] temp = {"ffSolution.soln", "ffPsolution.soln", "sol" + sep + "solution.soln", "sol" + sep + "solution.SOL", "sas_plan"};
        String ret = null;
        String[] arguments = null;


        for (int i = 0; i < 5; i++) {
            if (new File(temp[i]).exists()) {
                new File(temp[i]).delete();
            }
        }
        if (osName.contains("Windows")) {
            if (planner.contains("metric-ff")) {
                planner += ".exe";
                arguments = new String[]{"cmd", "/C", "start", "planners" + sep + planner, "-o", dom, "-f", probl};
                ret = "ffSolution.soln";


            } else if (planner.contains("lpg-td")) {
                planner += "-1.0.exe";
                arguments = new String[]{"cmd", "/C", "start", "planners" + sep + planner, "-o", dom, "-f", probl, "-quality", "-seed 100", "-out", "sol" + sep + "solution"};
                ret = "sol" + sep + "solution.SOL";


            }
        } else if (osName.contains("Linux")) {
            if (planner.equals("metric-ff")) {
                arguments = new String[]{"bash", "-c", "./planners" + sep + planner + " -o " + dom + " -f " + probl};

                ret = "sol" + sep + "solution.soln";


            } else if (planner.equals("lpg-td")) {
                planner += "-1.0";
                arguments = new String[]{"bash", "-c", "./planners" + sep + planner + " -o " + dom + " -f " + probl + " -quality -seed 100 -out ./sol" + sep + "solution"};
                ret = "sol" + sep + "solution.SOL";


            } else if (planner.equals("FD")) {

                arguments = new String[]{"bash", "-c", "./planners" + sep + planner + " " + dom + " " + probl + " " + fdOpt};

                ret = "sas_plan";


            }
        }
        long start = System.currentTimeMillis();
        Process p = Runtime.getRuntime().exec(arguments);


        int waitFor = 0;


        try {
            waitFor = p.waitFor();


        } catch (InterruptedException ex) {
        }



        long time = System.currentTimeMillis();


        long t = System.currentTimeMillis();


        while (!new File(ret).exists() && t - time < 5000) {
            t = System.currentTimeMillis();


        }



        if (planner.equals("metric-ff")) {
            filtraOutputMetric(p);
        }
        if (!new File(ret).exists()) {

            return ret;
        }

        if (planner.equals("lpg-td-1.0")) {
            //System.out.println("ripianificatore usato Lpg-td");
            if (foundSolution(ret)) {
            } else {
                //System.out.println("Planning: non è stata trovata una soluzione");
                new File(ret).delete();
            }
        }



        if (ret.equals("ffSolution.soln")) {
            new File("ffSolution.soln").renameTo(new File("sol" + sep + "solution.soln"));
            ret = "sol" + sep + "solution.soln";
        }

//        if (!new File(ret).exists()) {
//            System.out.println("problem file " + ret + " does not exist");
//            System.exit(0);
//
//
//        }
        return ret;


    }
    
      private static boolean foundSolution(String ret) {
        FileReader a = null;
        boolean res = true;
        try {
            if (new File(ret).exists()) {
                a = new FileReader(ret);

                char[] buffer = new char[10000];
                try {
                    a.read(buffer);
                    String buf = new String(buffer);


                    if (buf.toLowerCase().contains("no solution")) {
                        res = false;
                    }

                } catch (IOException ex) {
                   // Logger.getLogger(planningProblemManager.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                res = false;
            }
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(planningProblemManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                a.close();
            } catch (IOException ex) {
                //Logger.getLogger(planningProblemManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return res;
    }
        private static void filtraOutputMetric(Process p) throws IOException {
        int n = p.getInputStream().read();  //leggo l'output di metric-ff
        String s = "";
        String[] st = null;


        boolean flag = false;


        boolean exit = false;
        Writer output = new BufferedWriter(new FileWriter("sol/solution.soln"));

        /*pulisco l'output d metric-ff e aggiungo delle parentesi
        tonde agli step della soluzione*/

        while (n != -1 && !exit) {
            s += (char) n;

            if ('\n' == n) {
                if (flag == false && s.contains("ff: found legal plan as follows")) {
                    flag = true;

                } else if (flag && s.contains("time spent:")) {
                    exit = true;
                    flag = false;

                } else if (flag && !s.trim().equalsIgnoreCase("\n") && !s.trim().isEmpty()) {
                    if (s.contains("step")) {
                        s = s.replace("step", "    ");

                    }
                    s = s.trim() + ")\n";
                    st = s.split(": ", 2);
                    s = st[0] + ": (" + st[1];
                    //System.out.println(s);
                    output.write(s);
                }
                s = "";
            }
            n = p.getInputStream().read();
        }
        output.close();
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

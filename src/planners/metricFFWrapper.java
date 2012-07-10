package planners;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class metricFFWrapper extends planningTool {
    public metricFFWrapper() {
        super();
        option1 = "-O";
        option2 = "";
        planningExec = "/home/enrico/planner/planners/Metric-FF/ff";
    }
    
    public String putSolutionInFile() throws IOException{
        int n = process.getInputStream().read();  //leggo l'output di metric-ff
        String s = "";
        String[] st = null;


        boolean flag = false;


        boolean exit = false;
        Writer output = new BufferedWriter(new FileWriter("sol.pddl"));

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
            n = process.getInputStream().read();
        }
        output.close();
        
    
        return "sol.pddl";
    }


}

package planners;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lpgWrapper extends planningTool {
    public lpgWrapper() {
        super();
        option1 = "-quality";
        option2 = "-noout";
        planningExec = "/home/enrico/planner/planners/lpg-td-1.0";
    }


}

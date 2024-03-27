import com.hstairs.ppmajal.PDDLProblem.PDDLPlanner;
import com.hstairs.ppmajal.PDDLProblem.PDDLProblem;
import com.hstairs.ppmajal.PDDLProblem.PDDLSolution;
import com.hstairs.ppmajal.domain.PDDLDomain;
import com.hstairs.ppmajal.pddl.heuristics.PDDLHeuristic;
import com.hstairs.ppmajal.search.SearchHeuristic;

import java.math.BigDecimal;

public class GoalConflictAnalysis {

    public static void main(String[] args) throws Exception {

        String domainFile = args[0];
        String problemFile = args[1];

        final PDDLDomain localDomain = new PDDLDomain(domainFile);
        final PDDLProblem problem = new PDDLProblem(problemFile, localDomain.getConstants(),
                localDomain.getTypes(), localDomain, System.out, "internal",
                false, false, new BigDecimal(1.0),new BigDecimal(1.0));

        problem.prepareForSearch(false, false);

        String heuristic = "hrmax";

        PDDLPlanner planner = new PDDLPlanner(
                "GSBnB",
                heuristic,
                "no",
                false,
                false,
                1.0F,
                new BigDecimal(1.0),
                new BigDecimal(1.0),
                "smaller_g",
                false,
                Float.POSITIVE_INFINITY
        );

        SearchHeuristic h = PDDLHeuristic.getHeuristic(heuristic, problem, "no", false, false,
                false);

        PDDLSolution plan = planner.plan(problem, h);
    }
}

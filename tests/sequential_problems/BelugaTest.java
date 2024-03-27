/*
 * Copyright (C) 2018 enrico.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package sequential_problems;


import com.hstairs.ppmajal.PDDLProblem.PDDLPlanner;
import com.hstairs.ppmajal.PDDLProblem.PDDLProblem;
import com.hstairs.ppmajal.PDDLProblem.PDDLSolution;
import com.hstairs.ppmajal.domain.PDDLDomain;
import com.hstairs.ppmajal.extraUtils.PlannerUtils;
import com.hstairs.ppmajal.pddl.heuristics.PDDLHeuristic;
import com.hstairs.ppmajal.search.SearchHeuristic;
import org.junit.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author rebecca
 */
public class BelugaTest {

    public BelugaTest( ) {
    }

    @BeforeClass
    public static void setUpClass ( ) {
    }

    @AfterClass
    public static void tearDownClass ( ) {
    }

    @Before
    public void setUp ( ) {
    }

    @After
    public void tearDown ( ) {
    }

    @Test
    public void hello2 ( ) throws Exception {

//        String domainFile = "unit_test_instances/domain_gardening.pddl";
//        String problemFile = "unit_test_instances/problem_gardening.pddl";

        String domainFile = "unit_test_instances/beluga/domain_numeric_sylvie.pddl";
        String problemFile = "unit_test_instances/beluga/problem_4_3_0.pddl";
//        String problemFile = "unit_test_instances/beluga/problem_6_5_0.pddl";
//        String problemFile = "unit_test_instances/beluga/problem_baby.pddl";

        // normal with three belugas
//        String domainFile = "unit_test_instances/beluga/really_numeric/domain_numeric_v2_complete.pddl";
//        String problemFile = "unit_test_instances/beluga/really_numeric/problem_test_small_exp.pddl";

        // only the first 2 belugas
//        String domainFile = "unit_test_instances/beluga/really_numeric/domain_numeric_v2_complete.pddl";
//        String problemFile = "unit_test_instances/beluga/really_numeric/problem_test_small_exp_only_2_belugas.pddl";

        //number of used trucks
//        String domainFile = "unit_test_instances/beluga/really_numeric/deliverable_example_smaller/domain_numeric_v2_complete_used_trucks.pddl";
//        String problemFile = "unit_test_instances/beluga/really_numeric/deliverable_example_smaller/problem_exp_used_trucks.pddl";

        //jigs on which rack
//        String domainFile = "unit_test_instances/beluga/really_numeric/domain_numeric_v2_complete_jig_on_rack.pddl";
//        String problemFile = "unit_test_instances/beluga/really_numeric/problem_test_small_exp_jigs_on_rack.pddl";

        //num saps per jig
//        String domainFile = "unit_test_instances/beluga/really_numeric/deliverable_example_smaller/domain_numeric_v2_complete_jigs_swapped.pddl";
//        String problemFile = "unit_test_instances/beluga/really_numeric/deliverable_example_smaller/problem_exp_jigs_swapped.pddl";

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

        if (plan.rawPlan() != null) {
            System.out.println("Problem Solved\n");
            System.out.println("Found Plan:");
            System.out.println(plan.rawPlan());
            System.out.println("\nPlan-Length:" + plan.rawPlan().size());
        } else {
            System.out.println("Problem unsolvable");
        }
//        System.out.println("Metric (Search):" + plan.gValueAtTheEnd());
//        System.out.println("Heuristic Time (msec): " + plan.stats().heuristicTime());
//        System.out.println("Search Time (msec): " + plan.stats().searchTime());
//        System.out.println("Expanded Nodes:" + plan.stats().nodesExpanded());
//        System.out.println("States Evaluated:" + plan.stats().nodesEvaluated());
//        System.out.println("Number of Dead-Ends detected:" + plan.stats().deadEnds());
//        System.out.println("Number of Duplicates detected:" + plan.stats().duplicates());
    }
}

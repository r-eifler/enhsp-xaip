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


import com.hstairs.ppmajal.extraUtils.PlannerUtils;
import org.junit.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author enrico
 */
public class NonLinearPlanSizeTest {

    public NonLinearPlanSizeTest ( ) {
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
    public void hello ( ) throws Exception {

        //get pddl description
        List<String> heuristics = Arrays.asList("blind", "aibr", "hadd");
        PlannerUtils temp = new PlannerUtils();
        for (String h : heuristics) {
            assertEquals(7, temp.getPlanSize("unit_test_instances/absolute_value/domain.pddl",
                    "unit_test_instances/absolute_value/sample.pddl", h));
        }

        for (String h : heuristics) {
            if (!"aibr".equals(h)){
                
            
            assertEquals(12, temp.getPlanSize("unit_test_instances/trigonometric_functions/domain.pddl",
                    "unit_test_instances/trigonometric_functions/sample.pddl", h));
            }
        }


    }
}

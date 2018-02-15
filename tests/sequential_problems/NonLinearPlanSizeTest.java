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


import extraUtils.PlanGetResult;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author enrico
 */
public class NonLinearPlanSizeTest {

    public NonLinearPlanSizeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hello() throws Exception {
        
        //get pddl description
        PlanGetResult temp = new PlanGetResult();
        assertEquals(7, temp.getPlanSize("unit_test_instances/absolute_value/domain.pddl", 
                "unit_test_instances/absolute_value/sample.pddl", "blind"));
        temp = new PlanGetResult();
        assertEquals(7, temp.getPlanSize("unit_test_instances/absolute_value/domain.pddl", 
                "unit_test_instances/absolute_value/sample.pddl", "aibr"));
        temp = new PlanGetResult();
        assertEquals(7, temp.getPlanSize("unit_test_instances/absolute_value/domain.pddl", 
                "unit_test_instances/absolute_value/sample.pddl", "hadd"));
        
        assertEquals(7, temp.getPlanSize("unit_test_instances/absolute_value/domain.pddl", 
                "unit_test_instances/absolute_value/sample.pddl", "blind"));
        temp = new PlanGetResult();
        assertEquals(7, temp.getPlanSize("unit_test_instances/absolute_value/domain.pddl", 
                "unit_test_instances/absolute_value/sample.pddl", "aibr"));
        temp = new PlanGetResult();
        assertEquals(7, temp.getPlanSize("unit_test_instances/absolute_value/domain.pddl", 
                "unit_test_instances/absolute_value/sample.pddl", "hadd"));


    }
}

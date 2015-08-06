
/**
 * *******************************************************************
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 *
 ********************************************************************
 */

/**
 * *******************************************************************
 * Description: Part of the PPMaJaL library
 *
 * Author: Enrico Scala 2013 Contact: enricos83@gmail.com
 *
 ********************************************************************
 */
import domain.PddlDomain;
import problem.PddlSCProblem;

public class domainTester {

    /**
     * @param args Call the program by passing domain and problem pddl files
     * @throws Exception Nothing
     */
    public static void main(String[] args) throws Exception {

        //Controlling the input files
        if (args.length < 2) {
            System.out.println("Usage: ... domain problem ...");
            System.exit(-1);
        }

        {
            PddlDomain domain = new PddlDomain();
            domain.parseDomain(args[0]);
            domain.prettyPrint();
            PddlSCProblem problem = new PddlSCProblem(args[1], domain.getConstants());

            domain.validate(problem);
            problem.grounding();
            System.out.println(problem.globalConstraintSet);
            
        }
    }

}

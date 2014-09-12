/*********************************************************************
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 * 
 *********************************************************************/

/*********************************************************************
 * Description: Part of the PPMaJaL library
 *             
 * Author: Enrico Scala 2013
 * Contact: enricos83@gmail.com
 *
 *********************************************************************/ 

package problem;

import expressions.Expression;

/**
 *
 * @author enrico
 */
public class Metric {

    private Expression metExpr;
    private String optimization;

    public Metric(String optimization) {
        this.optimization = optimization;
    }

    /**
     * @return the metExpr
     */
    public Expression getMetExpr() {
        return metExpr;
    }

    /**
     * @param metExpr the metExpr to set
     */
    public void setMetExpr(Expression metExpr) {
        this.metExpr = metExpr;
    }

    /**
     * @return the optimization
     */
    public String getOptimization() {
        return optimization;
    }

    /**
     * @param optimization the optimization to set
     */
    public void setOptimization(String optimization) {
        this.optimization = optimization;
    }

    @Override
    public String toString() {


        return "Metric: " + this.optimization + " " + this.metExpr + " ";


    }

    String pddlPrint() {
        if (!this.optimization.equals("NO")) {
            return "(:metric " + this.optimization + " " + this.metExpr.pddlPrint(false) + ")";
        } else {
            return "";
        }
    }
}

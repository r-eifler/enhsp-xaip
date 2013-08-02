/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
            return "(:metric " + this.optimization + " " + this.metExpr.pddlPrint() + ")";
        } else {
            return "";
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heuristics.operator_counting;

import ilog.concert.IloConstraint;
import ilog.concert.IloException;
import ilog.cplex.IloCplex;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author enrico
 */
public class lp_solver {

    public IloCplex cplex;

    public lp_solver() {
        try {
            cplex = new IloCplex();
            cplex.setOut(null);
        } catch (IloException ex) {
            Logger.getLogger(lp_solver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Float solve(){
        try {
            if (cplex.solve()){
                float ret = (float) cplex.getObjValue();
                return ret;
            }else{
                return Float.MAX_VALUE;//this is a dead-end
            }
            
        } catch (IloException ex) {
            Logger.getLogger(lp_solver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    

}

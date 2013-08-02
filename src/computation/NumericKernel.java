/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package computation;

import conditions.AndCond;
import conditions.Comparison;
import conditions.Conditions;
import expressions.NormExpression;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import plan.SimplePlan;
import problem.GroundAction;

/**
 *
 * @author enrico
 */
public class NumericKernel extends HashMap {

    public NumericKernel() {
        super();
    }

    public void construct(SimplePlan sp, Conditions g) throws CloneNotSupportedException {

        Conditions goal = (Conditions) g.clone();
        //HashMap kerns = new HashMap();
        this.put(sp.size(), goal.clone());

        for (int i = sp.size() - 1; i >= 0; i--) {
            GroundAction a = (GroundAction) sp.get(i);
            goal = a.regress(goal);         

            this.put(i, goal.clone());
        }
        for (Object o: this.values()){
            Conditions con = (Conditions)o;
            con.normalize();
        }

        

    }

    public void construct_old(SimplePlan sp, Conditions g) throws CloneNotSupportedException {

        Conditions goal = (Conditions) g.clone();
        //HashMap kerns = new HashMap();
        this.put(sp.size(), goal.clone());

        for (int i = sp.size() - 1; i >= 0; i--) {
            GroundAction a = (GroundAction) sp.get(i);
            oplus((GroundAction) a, (AndCond) goal);
            this.put(i, goal.clone());
        }

    }

    public AndCond oplus(GroundAction a, AndCond con) {

        //AndCond result = (AndCond)con.clone();
        if (!a.normalized) {
            System.out.println("Action must be normalized");
            return null;
        } else {
            if (!((a.getPreconditions() instanceof AndCond))) {
                System.out.println("Only AND precondition at the moment");
                return null;
            }

            for (Object o1 : a.getAddList().sons) {
                con.sons.remove(o1);
            }

            Iterator it = con.sons.iterator();

            ArrayList toAdd = new ArrayList();
            while (it.hasNext()) {

                Object o = it.next();
                if (o instanceof Comparison) {
                    Comparison c = (Comparison) o;
                    c = c.normalizeAndCopy();
                    if (c != null) {
                        NormExpression left = (NormExpression) c.getFirst();
                        NormExpression right = (NormExpression) c.getTwo();
                        c.setFirst(left.subst(a.getNumericEffects()));
                        c.setTwo(right.subst(a.getNumericEffects()));
                        toAdd.add(c);
                    }
                    it.remove();

                }
            }
            for (Object o : toAdd) {
                con.sons.add(o);
            }

            for (Object o1 : a.getPreconditions().sons) {
                Conditions c = (Conditions) o1;
                con.sons.add(c);
            }
//            if(!verifyConditions(con))
//                System.out.println("Regression of: "+a.toEcoString()+" causes a not satisfiable precondition");


        }
        return con;
    }
}

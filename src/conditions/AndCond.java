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

package conditions;

import expressions.NumEffect;
import expressions.Expression;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import problem.RelState;
import problem.State;

/**
 *
 * @author Enrico Scala
 */
public class AndCond extends Conditions {

    private boolean specialAndForExpression;

    /**
     * Standard Constructor for the AndCond.
     */
    public AndCond() {
        super();
        sons = new HashSet();
    }

    /**
     *
     * @param c a condition to be added
     */
    public void addConditions(Conditions c) {
        sons.add(c);

    }

    /**
     *
     * @return a string representation of the and tree
     */
    public String toString() {
        String ret_val = "And(";
        for (Object o : sons) {
            ret_val = ret_val.concat(o.toString());
        }
        ret_val = ret_val.concat(")");
        return ret_val;
    }

    /**
     *
     * @param the sigma relating the the variable involved with concrete pddlobject
     * @return
     */
    @Override
    public Conditions ground(Map substitution) {
        AndCond ret = new AndCond();

        for (Object o : sons) {

            if (o instanceof NumEffect) {
                NumEffect el = (NumEffect) o;
                ret.sons.add(el.ground(substitution));

            } else {
                Conditions el = (Conditions) o;
                //System.out.println(el);
                ret.sons.add(el.ground(substitution));
            }
        }
        ret.grounded = true;
        return ret;
    }

    /**
     *
     * @param s
     * @return
     */
    @Override
    public boolean eval(State s) {
        for (Object o : this.sons) {
            if (o instanceof Conditions) {
                Conditions c = (Conditions) o;
                if (!c.eval(s)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @return the specialAndForExpression
     */
    public boolean isSpecialAndForExpression() {
        return specialAndForExpression;
    }

    /**
     * @param specialAndForExpression the specialAndForExpression to set
     */
    public void setSpecialAndForExpression(boolean specialAndForExpression) {
        this.specialAndForExpression = specialAndForExpression;
    }

    /**
     *
     * @param e when used with numeric effect
     */
    public void addExpression(Expression e) {
        this.sons.add(e);
    }

    /**
     *
     * @param s 
     * @return
     */
    @Override
    public boolean isSatisfied(State s) {
        for (Object o : this.sons) {
            if (o instanceof Conditions) {
                Conditions c = (Conditions) o;
                if (!c.isSatisfied(s)) {
                    System.out.println(c.toString() + " is not satisfied in " + s);
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *
     * @param s
     * @return
     */
    @Override
    public boolean isSatisfied(RelState s) {
        for (Object o : this.sons) {
            if (o instanceof Conditions) {
                Conditions c = (Conditions) o;
                if (!c.isSatisfied(s)) {
                    //System.out.println(c.pddlPrint() + " is not satisfied in " + s);
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *
     * @param s 
     * @return
     */
    public State apply(State s) {
        
        for (Object o : this.sons) {
            if (o instanceof AndCond) {
                AndCond t = (AndCond) o;
                s = t.apply(s);
            } else if (o instanceof Predicate) {
                Predicate p = (Predicate) o;
                s = p.apply(s);
            } else if (o instanceof NotCond) {
                NotCond n = (NotCond) o;
                s = n.apply(s);
            } else if (o instanceof NumEffect) {
                NumEffect n = (NumEffect) o;
                n.apply(s);
            } else {
                System.out.println("Effect " + this + " is not valid. Please revise your action model");
                System.exit(-1);
            }
        }
        return s;

    }

    /**
     *
     * @param s
     * @return
     */
    
    public State remove(State s) {
        State ret = s;
        for (Object o : this.sons) {
            if (o instanceof AndCond) {
                AndCond t = (AndCond) o;
                ret = t.remove(s);
            } else if (o instanceof Predicate) {
                Predicate p = (Predicate) o;
                ret = p.remove(s);
            } else if (o instanceof NotCond) {
                NotCond n = (NotCond) o;
                ret = n.apply(s);
            }
        }
        return s;
    }

    /**
     *
     * @param substitution
     */
    @Override
    public void changeVar(Map substitution) {
        for (Object o : sons) {
            if (o instanceof NumEffect) {
                NumEffect el = (NumEffect) o;
                el.changeVar(substitution);
            } else {
                Conditions el = (Conditions) o;
                el.changeVar(substitution);
            }
        }

    }

    /**
     *
     * @return
     */
    @Override
    public String pddlPrint(boolean typeInformation) {
        String ret_val = "(and ";
        for (Object o : sons) {
            if (o instanceof Conditions) {
                Conditions c = (Conditions) o;
                ret_val = ret_val.concat(c.pddlPrint(typeInformation));
            } else if (o instanceof Comparison) {
                Comparison comp = (Comparison) o;
                ret_val = ret_val.concat(comp.pddlPrint(typeInformation));
            } else {
                System.out.println("Error in pddlPrint:" + this);
                System.exit(-1);
            }
        }
        ret_val = ret_val.concat(")");
        return ret_val;
    }

    /**
     *
     * @return
     */
    @Override
    public Conditions clone() {
        AndCond ret = new AndCond();
        ret.grounded = this.grounded;
        //ret.sons = (HashSet)this.sons.clone();
        ret.sons = new HashSet();

        for (Object o : this.sons) {
            if (o instanceof AndCond) {
                AndCond a = (AndCond) o;
                ret.sons.add(a.clone());
            } else if (o instanceof NotCond) {
                NotCond a = (NotCond) o;
                ret.sons.add(a.clone());
            } else if (o instanceof OrCond) {
                OrCond a = (OrCond) o;
                ret.sons.add(a.clone());
            } else if (o instanceof Predicate) {
                Predicate a = (Predicate) o;
                ret.sons.add(a.clone());
            } else if (o instanceof Comparison) {
                Comparison a = (Comparison) o;
                ret.sons.add(a.clone());
            } else if (o instanceof NumFluentAssigner) {
                NumFluentAssigner a = (NumFluentAssigner) o;
                ret.sons.add(a.clone());
            }else if (o instanceof NumEffect){
                NumEffect a = (NumEffect)o;
                ret.sons.add(a.clone());
            }
        }

        ret.specialAndForExpression = this.specialAndForExpression;
        return ret;

    }

    /**
     *
     * @param s
     * @return
     */
    public RelState apply(RelState s) {
        RelState ret = s;
        for (Object o : this.sons) {
            if (o instanceof AndCond) {
                AndCond t = (AndCond) o;
                ret = t.apply(s);
            } else if (o instanceof Predicate) {
                Predicate p = (Predicate) o;
                ret = p.apply(s);
            } else if (o instanceof NotCond) {
                NotCond n = (NotCond) o;
                ret = n.apply(s);
            } else if (o instanceof NumEffect) {
                NumEffect n = (NumEffect) o;
                n.apply(s);
            } else {
                System.out.println("Effect " + this + " is not valid. Please revise your action model");
                System.exit(-1);
            }
        }
        return ret;
    }

    RelState remove(RelState s) {
        RelState ret = s;
        for (Object o : this.sons) {
            if (o instanceof AndCond) {
                AndCond t = (AndCond) o;
                ret = t.remove(s);
            } else if (o instanceof Predicate) {
                Predicate p = (Predicate) o;
                ret = p.remove(s);
            } else if (o instanceof NotCond) {
                NotCond n = (NotCond) o;
                ret = n.apply(s);
            }
        }
        return s;
    }

    /**
     *
     * @param s
     * @return
     */
    public Conditions whatisnotSatisfied(RelState s) {
        for (Object o : this.sons) {
            if (o instanceof Conditions) {
                Conditions c = (Conditions) o;
                if (!c.isSatisfied(s)) {
                    //System.out.println(c.pddlPrint() + " is not satisfied in " + s);
                    return c;
                }
            }
        }
        return null;
    }

    /**
     *
     * @param delList
     */
    public void subtractElements(AndCond delList) {
        if (delList == null) {
            return;
        }
        Iterator it2 = delList.sons.iterator();
        while (it2.hasNext()) {
            NotCond nc = (NotCond) it2.next();
            Iterator it = this.sons.iterator();
            while (it.hasNext()) {
                //NotCond nc = (NotCond)it.next();
                //System.out.println("Confronto : " + o.getClass());
                if (it.next().equals(nc.son.iterator().next())) {
                    it.remove();
                }
            }
        }
    }

    /**
     *
     * @param addList
     */
    public void subtractNegation(AndCond addList) {
        if (addList == null) {
            return;
        }
        Iterator it2 = addList.sons.iterator();
        while (it2.hasNext()) {
            Object o = it2.next();
            Iterator it = this.sons.iterator();

            while (it.hasNext()) {
                NotCond nc = (NotCond) it.next();
                //System.out.println("Confronto : " + o.getClass());
                if (o.equals(nc.son.iterator().next())) {
                    it.remove();
                }
            }
        }
    }

    /**
     *
     */
    @Override
    public void normalize() {        
        Iterator it = sons.iterator();
        while(it.hasNext()){
            Object o = it.next();
            if (o instanceof Comparison){
                Comparison comp = (Comparison)o;
                try {
                    comp = comp.normalizeAndCopy();

                } catch (Exception ex) {
                    Logger.getLogger(AndCond.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (comp==null) {
                    it.remove();
                }
            }
        }
        
    }

    public State transformInStateIfPossible() {
        State ret = new State();
        for (Object o: this.sons){
            if (o instanceof Predicate){
                ret.addProposition((Predicate)o);
            }else{
                System.out.println("This AndCond cannot be transformed into a State");
                return null;
            }
        }
        return ret;
    }

    @Override
    public Conditions unGround(Map substitution) {
        AndCond ret = new AndCond();

        for (Object o : sons) {

            if (o instanceof NumEffect) {
                NumEffect el = (NumEffect) o;
                ret.sons.add(el.unGround(substitution));

            } else {
                Conditions el = (Conditions) o;
                //System.out.println(el);
                ret.sons.add(el.unGround(substitution));
            }
        }
        ret.grounded = false;
        return ret;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conditions;

import expressions.NumEffect;
import expressions.Expression;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import problem.RelState;
import problem.State;

/**
 *
 * @author enrico
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

    public void addConditions(Conditions c) {
        sons.add(c);

    }

    public String toString() {
        String ret_val = "And(";
        for (Object o : sons) {
            ret_val = ret_val.concat(o.toString());
        }
        ret_val = ret_val.concat(")");
        return ret_val;
    }

    @Override
    public Conditions ground(Map substitution) {
        AndCond ret = new AndCond();

        for (Object o : sons) {

            if (o instanceof NumEffect) {
                NumEffect el = (NumEffect) o;
                ret.sons.add(el.ground(substitution));

            } else {
                Conditions el = (Conditions) o;
                ret.sons.add(el.ground(substitution));
            }
        }
        ret.grounded = true;
        return ret;
    }

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

    public void addExpression(Expression e) {
        this.sons.add(e);
    }

    @Override
    public boolean isSatisfied(State s) {
        for (Object o : this.sons) {
            if (o instanceof Conditions) {
                Conditions c = (Conditions) o;
                if (!c.isSatisfied(s)) {
                    //System.out.println(c.toString() + " is not satisfied in " + s);
                    return false;
                }
            }
        }
        return true;
    }

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

    public State apply(State s) {
        State ret = s;
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

    @Override
    public String pddlPrint() {
        String ret_val = "(and ";
        for (Object o : sons) {
            if (o instanceof Conditions) {
                Conditions c = (Conditions) o;
                ret_val = ret_val.concat(c.pddlPrint());
            } else if (o instanceof Comparison) {
                Comparison comp = (Comparison) o;
                ret_val = ret_val.concat(comp.pddlPrint());
            } else {
                System.out.println("Error in pddlPrint:" + this);
                System.exit(-1);
            }
        }
        ret_val = ret_val.concat(")");
        return ret_val;
    }

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
            }
        }

        ret.specialAndForExpression = this.specialAndForExpression;
        return ret;

    }

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

    public void subtractElements(AndCond delList) {
        if (delList == null) {
            return;
        }
        Iterator it = this.sons.iterator();
        Iterator it2 = delList.sons.iterator();
        while (it2.hasNext()) {
            NotCond nc = (NotCond) it2.next();
            while (it.hasNext()) {
                //NotCond nc = (NotCond)it.next();
                //System.out.println("Confronto : " + o.getClass());
                if (it.next().equals(nc.son.iterator().next())) {
                    it.remove();
                }
            }
        }
    }

    public void subtractNegation(AndCond addList) {
        if (addList == null) {
            return;
        }
        Iterator it = this.sons.iterator();
        Iterator it2 = addList.sons.iterator();
        while (it2.hasNext()) {
            Object o = it2.next();
            while (it.hasNext()) {
                NotCond nc = (NotCond) it.next();
                //System.out.println("Confronto : " + o.getClass());
                if (o.equals(nc.son.iterator().next())) {
                    it.remove();
                }
            }
        }
    }

    @Override
    public void normalize() {        
        Iterator it = sons.iterator();
        while(it.hasNext()){
            Object o = it.next();
            if (o instanceof Comparison){
                Comparison comp = (Comparison)o;
                comp = comp.normalizeAndCopy();
                if (comp==null) {
                    it.remove();
                }
            }
        }
        
    }
}

package computation;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import conditions.AndCond;
import conditions.Comparison;
import conditions.Conditions;
import conditions.Predicate;
import expressions.NumFluent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import problem.GroundAction;
import problem.RelState;
import problem.State;

/**
 *
 * @author enrico
 */
public class NumericalPlanningGraph {

    public int levels;
    public Vector action_level;
    public Vector rel_state_level;
    public Conditions goal;
    public boolean goal_reached;
    private long cpu_time;
    private long spezzTime;
    private int numberOfActions;
    private long FPCTime;

    public NumericalPlanningGraph() {
        super();
        levels = 0;
        action_level = new Vector();
        rel_state_level = new Vector();
        goal_reached = false;
        spezzTime = 0;
        FPCTime = 0;
    }
//    NumericalPlanningGraph(RelState s, Conditions goal){
//        super();
//        levels=0;
//        action_level = new ArrayList();
//        rel_state_level = new ArrayList();
//        rel_state_level.add(s);
//        this.goal = goal;
//        goal_reached = false;
//    }

    public ArrayList computeRelaxedPlan(State s, Conditions goal, Set actions) throws CloneNotSupportedException {
        ArrayList ret = new ArrayList();

        this.goal = goal;
        RelState current = s.relaxState();
        rel_state_level.add(current.clone());
        ArrayList acts = new ArrayList();
        acts.addAll(actions);
        long start = System.currentTimeMillis();
        ArrayList level = new ArrayList();
        while (true) {
            if (current.satisfy(goal)) {
                goal_reached = true;
                break;//goal reached!
            } else {

                level = new ArrayList();
                for (Iterator it = acts.iterator(); it.hasNext();) {
                    GroundAction gr = (GroundAction) it.next();
                    if (gr.isApplicable(current)) {
                        //if (gr.getPreconditions().isSatisfied(current)) {
                        level.add(gr);
                        it.remove();
                    }
                }
                if (level.isEmpty()) {
                    this.goal_reached = false;
                    numberOfActions = Integer.MAX_VALUE;
                    return ret;//it means that the goal is unreacheable!
                }
                long start2 = System.currentTimeMillis();

                for (Object o : level) {
                    GroundAction gr = (GroundAction) o;
                    gr.apply(current);
                }
                spezzTime += System.currentTimeMillis() - start2;
                this.action_level.add(level);
                this.rel_state_level.add(current.clone());
                levels++;
            }
        }

        this.goal_reached = true;
        System.out.println("Graphplan Building Time:" + (System.currentTimeMillis() - start));
        System.out.println("Spezz Time:" + (spezzTime));
        System.out.println("NumbersOfLevel" + (levels));
        long start2 = System.currentTimeMillis();
        ArrayList ret1 = extractPlan(goal, levels);
        System.out.println("estrazione:" + (System.currentTimeMillis() - start2));
        cpu_time = System.currentTimeMillis() - start;
        if (ret1 == null) {
            numberOfActions = Integer.MAX_VALUE;
            return ret1;
        }
        numberOfActions = ret1.size();

        return ret1;

    }

    public Map computeRelaxedPlans(State s, Map goal, Set actions, int i) throws CloneNotSupportedException {
        Map ret = new HashMap();

        ArrayList<Conditions> kernels = new ArrayList();

        Map rev_goal = new HashMap();
        int r = i;
        while (true) {
            Object o = goal.get(r);

            if (o != null) {
                rev_goal.put(o, r);
                kernels.add((Conditions) o);
                r++;
            } else {
                break;
            }
        }

//        for(Object o: goal.keySet()){
//            if ((Integer)o >=i){
//                rev_goal.put(goal.get(o), o);
//                kernels.add((Conditions)goal.get(o));
//            }
//                
//                
//        }

        Map reached = new HashMap();

        RelState current = s.relaxState();
        rel_state_level.add(current.clone());

        HashSet acts = new HashSet();
        acts.addAll(actions);
        long start = System.currentTimeMillis();
        ArrayList level;
        while (true) {
            for (Iterator it = kernels.iterator(); it.hasNext();) {
                //System.out.println("it:::" + it.next());
                Conditions o = (Conditions) it.next();
                if (current.satisfy(o)) {
                    reached.put(o, true);
                    ArrayList relaxedPlan = extractPlan(o, levels);
                    ret.put(rev_goal.get(o), relaxedPlan.size());
                    if (relaxedPlan.size() <= 1) {
                        //cpu_time = System.currentTimeMillis() - start;
                        return ret;
                    }
                    //System.out.println(ret);
                    it.remove();
                }
            }
            if (kernels.isEmpty()) {
                break;//goal reached!
            } else {
                level = new ArrayList();
                for (Iterator it = acts.iterator(); it.hasNext();) {
                    GroundAction gr = (GroundAction) it.next();
                    if (gr.getPreconditions().isSatisfied(current)) {
                        level.add(gr);
                        it.remove();
                    }
                }
                if (level.isEmpty()) {
                    break;
                }
                long start2 = System.currentTimeMillis();

                for (Object o : level) {
                    GroundAction gr = (GroundAction) o;
                    gr.apply(current);
                }
                //spezzTime += System.currentTimeMillis() - start2;
                this.action_level.add(level);
                this.rel_state_level.add(current.clone());
                levels++;
            }
        }
        cpu_time = System.currentTimeMillis() - start;
        return ret;

    }

    public int computeUntilFixedPoint(State s, Set actions) throws CloneNotSupportedException {

        RelState current = s.relaxState();
        ArrayList acts = new ArrayList(100000);
        acts.addAll(actions);
        long start = System.currentTimeMillis();
        HashSet level = new HashSet(10000);
        numberOfActions = 0;
        while (true) {
            boolean newActions = false;
            for (Iterator it = acts.iterator(); it.hasNext();) {
                GroundAction gr = (GroundAction) it.next();
                if (gr.getPreconditions().isSatisfied(current)) {
                    newActions = true;
                    level.add(gr);
                    this.numberOfActions++;
                    it.remove();
                }
            }
            if (!newActions) {
                break;//it means that the goal is unreacheable!
            }
            long start2 = System.currentTimeMillis();

            for (Object o : level) {
                GroundAction gr = (GroundAction) o;
                //System.out.println(gr.getName());
                gr.apply(current);
            }
            spezzTime += System.currentTimeMillis() - start2;
            levels++;
        }
        FPCTime = System.currentTimeMillis() - start;
        System.out.println("Graphplan Building Time:" + (System.currentTimeMillis() - start));
        System.out.println("NumbersOfLevel" + (levels));
        return numberOfActions;
    }

    private ArrayList extractPlan(Conditions goal, int levels) throws CloneNotSupportedException {
        Conditions AG[] = new Conditions[levels + 1];
        AG[levels] = goal;
        ArrayList rel_plan = new ArrayList();



        for (int t = levels - 1; t >= 0; t--) {
            RelState tem = (RelState) rel_state_level.get(t);
            RelState s = tem.clone();
            AG[t] = new AndCond();
            Map visited = new HashMap();
            //System.out.println("Prima aggiunta proposizioni"+AG[t + 1].isSatisfied(s));
            for (Object o : AG[t + 1].sons) {
                if (o instanceof Predicate) {
                    Predicate p = (Predicate) o;
                    //System.out.println("Livello in esame:" + t);
                    //System.out.println(p.isSatisfied((RelState) this.rel_state_level.get(t )));
                    if ((!((p.isSatisfied((RelState) rel_state_level.get(t)))))) {
                        //if (!((p.isSatisfied(s)))) {
                        if (visited.get(p) == null) {
                            //System.out.println("Searching for the support for:" + p);
                            //GroundAction gr = searchForAndRemove((Collection) this.action_level.get(t), p);
                            GroundAction gr = this.search((Collection) this.action_level.get(t), p);
                            if (gr == null) {
                                System.out.println("Error!! No supporter for " + p + " level " + t);

                                System.out.println(rel_plan);

                                System.out.println("Requisiti livello successivo:" + AG[t + 1]);
                                System.exit(-1);
                            }



                            AG[t].sons.addAll(gr.getPreconditions().sons);
                            //System.out.println("AG[t]" + AG[t]);
                            //AG[t].sons.addAll(gr.getNumeric().sons);
                            //                        if (gr.getName().equalsIgnoreCase("tp")){
                            //                            System.out.println("prima applicazione tp" +s);
                            //                        }

                            for (Object o1 : gr.getAddList().sons) {
                                visited.put(o1, true);
                            }
                            gr.apply(s);
                            //                        if (gr.getName().equalsIgnoreCase("tp-lr")){
                            //                            System.out.println("dopo applicazione tp" +s);
                            //                        }
                            //AG[t].sons.remove(o);
                            rel_plan.add(gr);
                        }

                    } else {
                        AG[t].sons.add(p);
                    }

                }
            }
//            for(Object o:rel_plan){
//                GroundAction gr = (GroundAction)o;
//                gr.apply(s);
//            }

            Iterator it = AG[t + 1].sons.iterator();
            while (it.hasNext()) {
                Object o = it.next();
                if (o instanceof Comparison) {
                    Comparison comp = (Comparison) o;
//                    while(true){
                    for (GroundAction gr : (Collection<GroundAction>) this.action_level.get(t)) {
                        if (comp.isSatisfied(s)) {
                            AG[t].sons.add(comp);
                            break;
                        }
                        gr.generateAffectedNumFluents();
//                            System.out.println("Condizione non soddisfatta:" + comp);
//                            System.out.println("Piano correntemente trovato:");
//                            for (int z = 0; z < rel_plan.length; z++) {
//                               if (rel_plan[z] != null) {
//                                  System.out.println(rel_plan[z]);
//                               }
//                            }
                        if (comp.involve((ArrayList<NumFluent>) gr.getNumericFluentAffected())) {
                            //System.out.println(gr.getNumericFluentAffected());
                            gr.apply(s);
                            AG[t].sons.addAll(gr.getPreconditions().sons);
                            rel_plan.add(gr);
                        }

                    }
                    //!comp.isSatisfied(s)
//                    }
                }
            }

        }


        return rel_plan;

    }

    private ArrayList[] extractPlan_new() throws CloneNotSupportedException {
        Conditions AG;
        AG = this.goal;
        ArrayList rel_plan[] = new ArrayList[levels];

        for (int t = levels - 1; t >= 0; t--) {
            RelState s = (RelState) rel_state_level.get(t);
            //AG[t] = AG[t+1].clone();
            Iterator it = AG.sons.iterator();
            //for (Iterator it=AG.sons.iterator();it.hasNext()){
            while (it.hasNext()) {
                Object o = it.next();
                if (o instanceof Predicate) {
                    Predicate p = (Predicate) o;
                    //System.out.println("Livello in esame:" + t);
                    //System.out.println(p.isSatisfied((RelState) this.rel_state_level.get(t )));
                    if (!((p.isSatisfied((RelState) this.rel_state_level.get(t))))) {
                        //System.out.println("Searching for the support for:" + p);
                        GroundAction gr = searchForAndRemove((HashSet) this.action_level.get(t), p);
                        if (gr == null) {

                            System.out.println("Error!! No supporter for " + p + " level " + t);
                            System.exit(-1);
                        }
                        //AG[t].sons.addAll(gr.getPreconditions().sons);
                        //AG[t].sons.addAll(gr.getNumeric().sons);
                        gr.apply(s);
                        if (rel_plan[t] == null) {
                            rel_plan[t] = new ArrayList();
                        }
                        rel_plan[t].add(gr);
                        //AG.sons.remove(o);
                        it.remove();
                    }

                }

            }
//            while (!AG.isSatisfied(s)) {
////                GroundAction gr = bestSupport((HashSet) this.action_level.get(t), AG, s);
//                AG.sons.addAll(gr.getPreconditions().sons);
//                //AG[t].sons.addAll(gr.getNumeric().sons);
//                gr.apply(s);
//                rel_plan[t].add(gr);
//            }
        }


        return rel_plan;

    }

    private GroundAction searchForAndRemove(Collection get, Predicate p) {
        Iterator it = get.iterator();
        while (it.hasNext()) {
            GroundAction gr = (GroundAction) it.next();
            if (gr.getAddList().sons.contains(p)) {
                it.remove();
                return gr;
            }
        }
        return null;
    }

    private GroundAction bestSupport(HashSet get, Conditions conditions, RelState s) throws CloneNotSupportedException {

        float bestDistance = 0;
        GroundAction ret = null;
//
        AndCond c;
        if (conditions instanceof AndCond) {
            c = (AndCond) conditions;
            for (Object o : c.sons) {
                if (o instanceof Comparison) {
                    Comparison comp = (Comparison) o;
                    bestDistance += comp.satisfactionDistance(s);
                }

            }
            Iterator it = get.iterator();
            while (it.hasNext()) {
                GroundAction gr = (GroundAction) it.next();
//                if (gr.getName().contains("tp"))
//                   System.out.println("tp");
//                if (gr.getName().contains("comm"))
//                   System.out.println("comm");
                Float distance2 = new Float(0);
                RelState s1 = (RelState) s.clone();
                gr.apply(s1);
                for (Object o : c.sons) {
                    if (o instanceof Comparison) {
                        Comparison comp = (Comparison) o;
                        distance2 += comp.satisfactionDistance(s1);
                    }

                }

                if (distance2 < bestDistance) {
//                    System.out.println("Distanza dopo.." + distance2);
                    it.remove();
                    return gr;


                }

            }
////          System.out.println("Comparison:" + comp);
//            System.out.println("Distanza prima.." + distance);
        } else {
            System.out.println("Coniditions not supported");
        }
        return ret;
    }

    /**
     * @return the cpu_time
     */
    public long getCpu_time() {
        return cpu_time;
    }

    /**
     * @return the timeForNumbers
     */
    public long getTimeForNumbers() {
        return spezzTime;
    }

    /**
     * @return the numberOfActions
     */
    public int getNumberOfActions() {
        return numberOfActions;
    }

    private GroundAction search(Collection hashSet, Predicate p) {
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            GroundAction gr = (GroundAction) it.next();
            if (gr.getAddList().sons.contains(p)) {
                return gr;
            }
        }
        return null;
    }
}

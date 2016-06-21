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
package SMTPlanning;

import computation.NumericPlanningGraph;
import conditions.AndCond;
import conditions.Comparison;
import conditions.Conditions;
import conditions.NotCond;
import conditions.NumFluentAssigner;
import conditions.OrCond;
import conditions.PDDLObjectsEquality;
import conditions.Predicate;
import domain.GenericActionType;
import domain.PddlDomain;
import expressions.NumEffect;
import expressions.NumFluent;
import extraUtils.Utils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.TopologicalOrderIterator;
import plan.SimplePlan;
import problem.GlobalConstraint;
import problem.GroundAction;
import problem.EPddlProblem;
import problem.RelState;
import search.Aibr;

/**
 *
 * @author enrico
 */
public class SMTBasedPlanning {

    private boolean repetition_encoding = false;
    private boolean not_homogenous = false;
    private PddlDomain domain;
    private EPddlProblem problem;
    private ArrayList smt2String;
    HashSet SC;
    //private RelState possibleState;
    Collection<Predicate> reacheable_predicates = null;
    private LinkedHashSet actions;
    private HashMap<Predicate, HashSet> predDeleters;
    private HashMap<Predicate, HashSet> predAchievers;
    public SimplePlan extractedPlan;
    private String semantic;
    private HashMap<NumFluent, HashSet> numModifiers;
    private boolean untilFixPoint = true;
    private Set interferences;
    private NumericPlanningGraph np;
    private long overallTime;
    private long overallEcondingTime;
    boolean sat;
    boolean linear_normalization_active = false;

    private HashMap<GroundAction, Boolean> num_rel_actions;

    private int debugInfo;
    private boolean onlyHelpfulActions;
    private boolean ffHeuristic;

    private boolean implicit_goal;
    private int relaxedPlanLength;
    private boolean computeH1;
    private boolean maxHeuristic;
    private int h1Estimate;
    private String name_file_temp;
    private HashSet<NumFluent> contVars;
    private String out_file;

    private String sec_theory;
    private boolean must_remove_file_temp = false;
    private Set<NumFluent> def_num_fluent;
    private HashMap<String, Integer> repetitions;
    private boolean backward_compatibility_switched_constraint = false;
    public HashSet actionsFound;
    public int last_horizon;
    public int max_number_of_repetition = -1;
    public String search_strategy;
    private HashMap<GroundAction, Boolean> eligible;
    private boolean z3solver = true;

    public SMTBasedPlanning(PddlDomain dm, EPddlProblem p) {
        super();
        this.domain = dm;
        this.problem = p;
        extractedPlan = null;
        semantic = "1";
        overallTime = 0;
        overallEcondingTime = 0;
        sat = false;
        debugInfo = 0;
        implicit_goal = false;
        onlyHelpfulActions = false;
        ffHeuristic = false;
        computeH1 = true;
        maxHeuristic = true;
        repetitions = new HashMap();
        last_horizon = 0;
    }

    public SimplePlan solve() throws Exception {
        int i = 1;
        while (i < 100) {
            if (sat(i)) {
                return null;
            } else {
                i = i + 1;
            }
        }
        return null;
    }

    public SimplePlan solve(int minI, int maxI) throws Exception {
        //Instantiation, Reacheability and Taking Switched Constraints
        SimplePlan sp = null;

        //implicit goal means that those goals cannot be achieved by the action execution; so in this case we cannot use the possible unreacheability provided by the graphplan analysis
        if (isImplicit_goal() || (this.getProblem().getInit().getNumericFluents() != null)) {
            int i = Math.max(0, minI);//take the maximum according to the one provided as input and 0
            if (this.isComputeH1()) {//if the heuristic is computed, then use that as first horizon
                i = Math.max(i, this.h1Estimate);
            }
            while (i <= maxI) {//until a given horizon is reached. This ensures termination
                //while (i <= maxI) {
                if (sat(i)) {
                    this.last_horizon = i;
                    sp = this.extractedPlan;
                    break;
                } else {
                    i = i + 1;
                }
            }
            if (i > maxI) {
                if (this.debugInfo > 0) {
                    System.out.println("Goal not reacheable in " + maxI + " steps");
                }
            }
        } else {
            //if (this.debugInfo > 0) {
            System.out.println("Goal not reacheable (Graphplan Analysis)");
            //}
        }

        return sp;
    }

    public boolean init() throws Exception {

        //next is necessary to get the constant from the domain to the problem and to validate types
        grounding();

        //compute_relevance_analysys and new actions
        setActions(new LinkedHashSet(problem.getActions()));

        if (!compute_relevance_analysis(problem.getActions())) {
            return false;
        }

        //Build action interferences
        compute_action_interferencies();
        return true;
    }

    public ArrayList<String> encode(int k) throws Exception {

        //the smt2string encode a list of string to be provided in output in a file. That file can be used by any SMT solver to detect if there is a solution
        //of length k
        smt2String = new ArrayList();
        //smt2String.add("(set-option :produce-unsat-cores true)\n (set-option :produce-models true)\n (set-option :produce-proofs true)\n");
        smt2String.add("\n(set-option :produce-models true)\n");
//        smt2String.add("\n(set-logic AUFNIRA)\n");
        long start = System.currentTimeMillis();
        //for each timestep we keep the value of a propositional variable
        //here we focus on the set of variables that might be reached starting from the initial state
        smt2String.add("; Discrete Variables\n");
        smt2String.addAll(build_propositional_variables_init_state(k));

        //the semantic of the following numeric variables is the one defined in Frankovic et al. ICAPS-14
        smt2String.add("; Continuous Variables\n");



        smt2String.addAll(build_numeric_variables_plus_init_global_constraint(k));

        //Goal condition expresses which has to be true in the final state. The following encodes exactly this.
        AndCond ac = (AndCond) this.problem.getGoals();
        smt2String.add("; Goal\n");
        smt2String.add("(assert " + ac.toSmtVariableString(k) + ")\n");
        smt2String.add(";Time for Propositions: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        smt2String.add(";Number of Actions" + getActions().size());

        smt2String.add("; Actions Variable plus Preconditions and Effects\n");
        smt2String.addAll(build_action_variables(k));
        smt2String.add(";Time for Actions: " + (System.currentTimeMillis() - start));

        smt2String.add("; Frame Axiom\n");
        smt2String.addAll(build_frame_axiom(k));

        //smt2String.add("\n(check-sat)\n(get-info :all-statistics)\n(get-model)");
        if (this.isRepetition_encoding()) {
            //smt2String.add("\n(check-sat-using  (then simplify solve-eqs (par-or smt sat  qfnra-nlsat  )))\n(get-model)");
            smt2String.add("\n(check-sat-using  (then simplify solve-eqs (or-else smt qfnra-nlsat  )))\n(get-model)");

            //smt2String.add("\n(check-sat-using (then simplify solve-eqs aufnira))\n(get-model)");
            //smt2String.add("\n(check-sat-using smt)\n(get-model)");
            //smt2String.add("\n(check-sat)\n(get-model)");
            //smt2String.add("\n(check-sat-using (then simplify solve-eqs (! smt :bv.enable_int2bv  true ) ) )\n(get-info :all-statistics)\n(get-model)");
            //smt2String.add("\n(check-sat-using (then simplify solve-eqs (! smt :arith.ignore_int true :bv.enable_int2bv true :macro_finder true) ) )\n(get-info :all-statistics)\n(get-model)");
            //smt2String.add("\n(check-sat)\n(get-info :all-statistics)\n(get-model)");
        } else {
            smt2String.add("\n(check-sat)\n(get-info :all-statistics)\n(get-model)");
        }
        return smt2String;
    }

    @Deprecated
    public ArrayList<String> encode_deprecated(int k) throws Exception {

        //the smt2string encode a list of string to be provided in output in a file. That file can be used by any SMT solver to detect if there is a solution
        //of length k
        smt2String = new ArrayList();
        smt2String.add("; Discrete Variables\n");
        long start = System.currentTimeMillis();
        //for each timestep we keep the value of a propositional variable
        //here we focus on the set of variables that might be reached starting from the initial state
        for (int i = 0; i <= k; i++) {
            //Variables constructor
            for (Object o : reacheable_predicates) {
                Predicate p = (Predicate) o;
                smt2String.add("(declare-fun " + p.toSmtVariableString(i) + " () Bool)\n");
                //init status constraint
                if (i == 0) {
                    if (problem.getInit().containProposition(p)) {
                        smt2String.add("(assert " + p.toSmtVariableString(i) + ")\n");
                    } else {
                        smt2String.add("(assert (not " + p.toSmtVariableString(i) + "))\n");
                    }
                }
            }
        }
        //the semantic of the following numeric variables is the one defined in Frankovic et al. ICAPS-14
        smt2String.add("; Continuous Variables\n");
        HashMap<String, Boolean> declared = new HashMap();
        for (int i = 0; i <= k; i++) {

            //For each numeric fluent involved in some invariant constraint we build a smt continuous variable, if such a variable does not exist yet
            //SC is a pair (implemented as a 2 elements list. The first element is a set of numeric fluents. The second element is an or condition representing
            //the implication from primary variable to secondary variable.
            for (ArrayList o : (HashSet<ArrayList>) SC) {
                for (Object o1 : (Set) o.get(0)) {
                    NumFluent nf = (NumFluent) o1;
                    if (declared.get(nf.toSmtVariableString(i)) == null || !declared.get(nf.toSmtVariableString(i))) {
                        declared.put(nf.toSmtVariableString(i), Boolean.TRUE);

                        smt2String.add("(declare-fun " + nf.toSmtVariableString(i) + " () " + this.getSec_theory() + ")\n");
                        //System.out.println("(declare-fun " + nf.to_smtlib_with_repetition(i) + " () Real)\n");
                    }
                }
                OrCond or = (OrCond) o.get(1);
                //The OrCond contains the implication. It consists of two elements, the former is the negated left hand of the implication, the second element
                //is the numeric constraint that has to be satisfied whenever the first element is true. The function or.tosmtvariablestring implements such an implication
                //Here there is an assumption that the primary variable formula is expressed as a conjunction of positive literals. 
                //the implication will be added only if the left-hand might be achieved.
                if (or.involveReacheablePredicates(reacheable_predicates)) {
//                    System.out.println("Switched Constraints!!");
                    //System.out.println("SC:"+or);
                    smt2String.add(";SwitchedConstraint\n");
                    smt2String.add("(assert " + or.toSmtVariableString(i) + ")\n");
                }
            }
            //management of free_variables

            for (NumFluent nf : contVars) {
                if (declared.get(nf.toSmtVariableString(i)) == null || !declared.get(nf.toSmtVariableString(i))) {
                    declared.put(nf.toSmtVariableString(i), Boolean.TRUE);
                    smt2String.add("(declare-fun " + nf.toSmtVariableString(i) + " () " + this.getSec_theory() + ")\n");
                }
            }

            //Assumption: numeric fluents in the initial state are constants. The following builds variable for each numeric fluent of interest. There could be in fact numeric fluents
            //not defined in the previous (see above) definitions
            for (Object o : this.problem.getInit().getNumericFluents()) {
                NumFluentAssigner n_ass = (NumFluentAssigner) o;
                NumFluent nf = n_ass.getNFluent();
                if (declared.get(nf.toSmtVariableString(i)) == null || !declared.get(nf.toSmtVariableString(i))) {
                    declared.put(nf.toSmtVariableString(i), Boolean.TRUE);
                    smt2String.add("(declare-fun " + nf.toSmtVariableString(i) + " () " + this.getSec_theory() + ")\n");
                }
                if (i == 0) {
                    smt2String.add("(assert (= " + n_ass.getNFluent().toSmtVariableString(i) + " " + n_ass.getTwo().toSmtVariableString(i + 1) + "))\n");
                }
            }

            //Add also all the numeric fluent that can become true at some point
            for (Object o : this.def_num_fluent) {
                NumFluent nf = (NumFluent) o;
//                NumFluent nf = n_ass.getNFluent();
                if (declared.get(nf.toSmtVariableString(i)) == null || !declared.get(nf.toSmtVariableString(i))) {
                    declared.put(nf.toSmtVariableString(i), Boolean.TRUE);
                    smt2String.add("(declare-fun " + nf.toSmtVariableString(i) + " () " + this.getSec_theory() + ")\n");

                }
                if (i == 0) {
                    if (this.domain.generateAbstractInvariantFluents().get(nf) == null) {
                        if (this.problem.getInit().functionValue(nf) == null) {
                            System.out.println(" Undefined values that can become true at some points are not supported yet");
                            System.exit(-1);
//                          smt2String.add("(assert (= " + nf.to_smtlib_with_repetition(i) + " NULL ))\n");
                        }
                    }
                }
            }

            //something related to the numeric variables that can become defined. 
        }

        //Goal condition expresses which has to be true in the final state. The following encodes exactly this.
        AndCond ac = (AndCond) this.problem.getGoals();
        smt2String.add("; Goal\n");
        smt2String.add("(assert " + ac.toSmtVariableString(k) + ")\n");
        smt2String.add(";Time for Propositions: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        smt2String.add(";Number of Actions" + getActions().size());
        smt2String.add("; Actions Variable plus Preconditions and Effects\n");

        for (int i = 0; i < k; i++) {
            Set actionInTheLevel;
            if (this.isOnlyHelpfulActions()) {
                actionInTheLevel = getActions();
            } else {

                actionInTheLevel = getActions();

            }
            //actionInTheLevel = actions; 
            for (Object o : actionInTheLevel) {
                GroundAction gr = (GroundAction) o;
                //A boolean variable encodes the activation of the action
                smt2String.add("(declare-fun " + gr.toSmtVariableString(i) + " () Int)\n");
                //precondition implications
                smt2String.add("(assert (>= " + gr.toSmtVariableString(i) + " 0))\n");
                smt2String.add("(assert (<= " + gr.toSmtVariableString(i) + " 1))\n");
                smt2String.add("(assert (=> (> " + gr.toSmtVariableString(i) + " 0) " + gr.getPreconditions().toSmtVariableString(i) + " ))\n");
                //effect implications on the primary model
                AndCond add = (AndCond) gr.getAddList();
                if (add != null && !add.sons.isEmpty()) {
                    smt2String.add("(assert (=> (> " + gr.toSmtVariableString(i) + " 0) " + gr.getAddList().toSmtVariableString(i + 1) + " ))\n");
                }
                if (gr.getDelList() != null) {
                    smt2String.add("(assert (=> (> " + gr.toSmtVariableString(i) + " 0) " + gr.getDelList().toSmtVariableString(i + 1) + " ))\n");
                }
                if (gr.getNumericEffects() != null && !gr.getNumericEffects().sons.isEmpty()) {
                    //System.out.println(gr.getNumericEffects().to_smtlib_with_repetition(i));
                    smt2String.add("(assert (=> (> " + gr.toSmtVariableString(i) + " 0) " + gr.getNumericEffects().toSmtVariableString(i) + " ))\n");
                }
            }
            smt2String.add("(assert (or ");
            for (Object o : actionInTheLevel) {
                GroundAction gr = (GroundAction) o;
                smt2String.add(" (>  " + gr.toSmtVariableString(i) + "  0)");
            }
            smt2String.add(" true ))\n");
            //interferencies. The content of this set of relations depends on the semantic adopted
            for (Object o : interferences) {
                GroundAction[] interferring = (GroundAction[]) o;
                //if (i>=np.action_level.size())//this prevents to access to unassigned level. This may happen because the planning graph is actually an understimation of the actual plan length so it could have less level than the one actually needed
                //    smt2String.add("(assert (not (and " + interferring[0].to_smtlib_with_repetition(i) + " " + interferring[1].to_smtlib_with_repetition(i) + ")))\n");
                //else{//here consider just action that belongs to this level
                //Set actionInThisLevel = (Set)np.action_level.get(i);
                if (actionInTheLevel.contains(interferring[0]) && actionInTheLevel.contains(interferring[1])) {
                    smt2String.add("(assert (not (and (> " + interferring[0].toSmtVariableString(i) + " 0) (> " + interferring[1].toSmtVariableString(i) + " 0) )))\n");
                }
                //}
            }
        }
        smt2String.add(";Time for Actions: " + (System.currentTimeMillis() - start));

        smt2String.add("; Frame Axiom\n");
        for (int i = 0; i < k; i++) {
            //frame axiom
            //Propositional Part
            for (Object o : reacheable_predicates) {
                Predicate p = (Predicate) o;
                smt2String.add("(assert (=> (and " + p.toSmtVariableString(i) + " (not " + p.toSmtVariableString(i + 1) + ")) " + predicateModifiers(p, predDeleters, i) + " ))\n");
                smt2String.add("(assert (=> (and " + p.toSmtVariableString(i + 1) + " (not " + p.toSmtVariableString(i) + ")) " + predicateModifiers(p, predAchievers, i) + " ))\n");
            }
            //Numeric fluents frame axioms
            for (Object o : this.problem.getInit().getNumericFluents()) {
                NumFluentAssigner n_ass = (NumFluentAssigner) o;
                NumFluent nf = n_ass.getNFluent();
                smt2String.add("(assert (=> (not " + this.numericFluentModifiers(nf, numModifiers, i) + ") (= " + n_ass.getNFluent().toSmtVariableString(i) + " " + n_ass.getNFluent().toSmtVariableString(i + 1) + ")))\n");
            }
        }

        smt2String.add("\n(check-sat)\n(get-info :all-statistics)\n(get-model)");
        return smt2String;
    }

    /**
     * @return the domain
     */
    public PddlDomain getDomain() {
        return domain;
    }

    /**
     * @param domain the domain to set
     */
    public void setDomain(PddlDomain domain) {
        this.domain = domain;
    }

    /**
     * @return the problem
     */
    public EPddlProblem getProblem() {
        return problem;
    }

    /**
     * @param problem the problem to set
     */
    public void setProblem(EPddlProblem problem) {
        this.problem = problem;
    }

    //return the set of interfering actions. The interference accounts just the primary variables set
    private HashSet computeInterferences(Set actions) {
        HashSet ret = new HashSet();
        for (Object o : actions) {
            for (Object o1 : actions) {
                if (!o.equals(o1)) {
                    GroundAction a = (GroundAction) o;
                    GroundAction b = (GroundAction) o1;
                    if (interference(a, b) || interference(a, b, SC)) {
                        GroundAction[] temp = new GroundAction[2];
                        temp[0] = a;
                        temp[1] = b;
                        ret.add(temp);
                    }
                }
            }
        }
        return ret;
    }

    //return the set of interfering actions. The interference accounts just the primary variables set
    private HashSet computeInterferences_existential(Set actions) {
        HashSet ret = new HashSet();
        for (Object o : actions) {
            for (Object o1 : actions) {
                if (!o.equals(o1)) {
                    GroundAction a = (GroundAction) o;
                    GroundAction b = (GroundAction) o1;
                    if (interference_existential(a, b)) {
                        GroundAction[] temp = new GroundAction[2];
                        temp[0] = a;
                        temp[1] = b;
                        ret.add(temp);
                    }
                }
            }
        }
        return ret;
    }

    //Compute the cartesian product of the actions set
    private HashSet computeExclusivity(Set actions) {
        HashSet ret = new HashSet();
        for (Object o : actions) {
            for (Object o1 : actions) {
                if (!o.equals(o1)) {
                    GroundAction a = (GroundAction) o;
                    GroundAction b = (GroundAction) o1;
                    GroundAction[] temp = new GroundAction[2];
                    temp[0] = a;
                    temp[1] = b;
                    ret.add(temp);
                }
            }
        }
        return ret;
    }

    //return if two actions interfere
    private boolean interference(GroundAction a, GroundAction b) {
        //the following has been removed because should be subsumed by the sat semantic. We cannot have inconsistent effects because this would lead to a contraddiction
//        if (a.threat((AndCond) b.getAddList()) || b.threat((AndCond) a.getAddList())) {
//            //System.out.println("conflicting effects");
//            ret = true;
//        }

        //remove an action that threats the precondition of the other
        if (a.threat((AndCond) b.getPreconditions()) || (b.threat((AndCond) a.getPreconditions()))) {
            //System.out.println("conflicting pre eff");
            return true;
        }
//        if (ret)
//            System.out.println("Action (propositionally) interfering: "+a.getName()+" and "+ b.getName());
// 

        //interferences (strong in this first case) for the numeric case
        Set intersection;
        //check if the intersection between the numeric fluent affected by b and the numeric fluents upon which the precondtion of action is not empty
        if (a.getPreconditions() != null && b.getNumericFluentAffected() != null) {
            if (a.getPreconditions().getInvolvedFluents() != null) {
                intersection = new HashSet(a.getPreconditions().getInvolvedFluents());
                intersection.retainAll(b.getNumericFluentAffected().keySet());
                if (intersection.size() > 0) {
                    return true;
                }
            }
        }
        //the same of before but in the opposite way (b->a ==> a->b)
        if (b.getPreconditions() != null && a.getNumericFluentAffected() != null && b.getPreconditions().getInvolvedFluents() != null) {
            intersection = new HashSet(b.getPreconditions().getInvolvedFluents());
            intersection.retainAll(a.getNumericFluentAffected().keySet());
            if (intersection.size() > 0) {
                return true;
            }
        }
        //conflicting effects. This assure that there will be no actions acting on the same fluent. This actually is a kind of existential semantic, in that it assumes that no cyclic indirect effects occurs.
        if (a.getNumericFluentAffected() != null && b.getNumericFluentAffected() != null) {
            intersection = new HashSet(b.getNumericFluentAffected().keySet());
            intersection.retainAll(a.getNumericFluentAffected().keySet());
            if (intersection.size() > 0) {
                return true;
            }
        }

        if (a.getNumericFluentAffected() != null && b.getNumericFluentAffected() != null) {

            for (NumEffect ef1 : a.getNumericEffectsAsCollection()) {
                for (NumEffect ef2 : b.getNumericEffectsAsCollection()) {
                    if (ef2.getRight().involve(ef1.getFluentAffected()) || (ef1.getRight().involve(ef2.getFluentAffected()))) {
                        return true;
                    }
                }
            }

        }

        return false;
    }

    //return if two actions interfere
    private boolean interference_existential(GroundAction a, GroundAction b) {
        //the following has been removed because should be subsumed by the sat semantic. We cannot have inconsistent effects because this would lead to a contraddiction
//        if (a.threat((AndCond) b.getAddList()) || b.threat((AndCond) a.getAddList())) {
//            //System.out.println("conflicting effects");
//            ret = true;
//        }

        //remove an action that threats the precondition of the other
        if (a.threat((AndCond) b.getPreconditions()) && (b.threat((AndCond) a.getPreconditions()))) {
            //System.out.println("conflicting pre eff");
            return true;
        }
//        if (ret)
//            System.out.println("Action (propositionally) interfering: "+a.getName()+" and "+ b.getName());
// 
        //interferences (strong in this first case) for the numeric case
        Set intersection;
        //check if the intersection between the numeric fluent affected by b and the numeric fluents upon which the precondtion of action is not empty
        if (a.getPreconditions() != null && b.getNumericFluentAffected() != null && a.getPreconditions().getInvolvedFluents() != null) {
            if (a.getPreconditions().getInvolvedFluents() != null) {
                intersection = new HashSet(a.getPreconditions().getInvolvedFluents());
                intersection.retainAll(b.getNumericFluentAffected().keySet());
                if (intersection.size() > 0) {
                    if (b.getPreconditions() != null && a.getNumericFluentAffected() != null && b.getPreconditions().getInvolvedFluents() != null) {
                        intersection = new HashSet(b.getPreconditions().getInvolvedFluents());
                        intersection.retainAll(a.getNumericFluentAffected().keySet());
                        if (intersection.size() > 0) {
                            return true;
                        }
                    }
                }
            }
        }
//        //the same of before but in the opposite way (b->a ==> a->b)
//        if (b.getPreconditions() != null && a.getNumericFluentAffected() != null && b.getPreconditions().getInvolvedFluents() != null) {
//            intersection = new HashSet(b.getPreconditions().getInvolvedFluents());
//            intersection.retainAll(a.getNumericFluentAffected().keySet());
//            if (intersection.size() > 0) {
//                return true;
//            }
//        }
        //conflicting effects. This assure that there will be no actions acting on the same fluent. This actually is a kind of existential semantic!!
//        if (a.getNumericFluentAffected() != null && b.getNumericFluentAffected() != null) {
//            intersection = new HashSet(b.getNumericFluentAffected().keySet());
//            intersection.retainAll(a.getNumericFluentAffected().keySet());
//            if (intersection.size() > 0) {
//                return true;
//            }
//        }

//        if (ret)
//            System.out.println("Action (numerically) interfering: "+a.getName()+" and "+ b.getName());
// 
//        if (!ret)
//            System.out.println("Action not interfering: "+a.getName()+" and "+ b.getName());
        return false;
    }

    private String predicateModifiers(Predicate p, HashMap<Predicate, HashSet> predAchievers, int i) {
        HashSet achievers = predAchievers.get(p);
        String ret = "(or";
        for (Object o : achievers) {
            GroundAction gr = (GroundAction) o;
            if (this.isOnlyHelpfulActions()) {
                if (getActions().contains(gr)) {
//                    if (!this.isRepetition_encoding() || (num_rel_actions.get(o) == Boolean.FALSE && not_homogenous)) {
//                        ret += " " + gr.to_smtlib_with_repetition(i);
//                    } else {
                    ret += " (> " + gr.toSmtVariableString(i) + " 0)";
//                    }
                }
            } else {
//                if (i >= np.action_level.size()) {
//                if (!this.isRepetition_encoding() || (num_rel_actions.get(o) == Boolean.FALSE && not_homogenous)) {
//                    ret += " " + gr.to_smtlib_with_repetition(i);
//                } else {
                ret += " (> " + gr.toSmtVariableString(i) + " 0)";
//                }
//                } else {
//                    Set actionInTheLevel = (Set) np.action_level.get(i);
//                    if (actionInTheLevel.contains(gr)) {
//                        ret += " " + gr.to_smtlib_with_repetition(i);
//                    }
//                }
            }
        }
        ret += ")";
        if (ret.equals("(or)")) {
            return "false";
        }

        return ret;
    }

    private String numericFluentModifiers(NumFluent nf, HashMap<NumFluent, HashSet> numAchievers, int i) {
        HashSet achievers = numAchievers.get(nf);
        if (achievers == null) {
            return "false";
        }
        String ret = "(or";
        for (Object o : achievers) {
            GroundAction gr = (GroundAction) o;
//            if (i >= np.action_level.size()) {
            if (true) {
//                if (!this.isRepetition_encoding() || (num_rel_actions.get(o) == Boolean.FALSE && not_homogenous)) {
//                    ret += " " + gr.to_smtlib_with_repetition(i);
//                } else {
                ret += " (> " + gr.toSmtVariableString(i) + " 0)";
//                }
            } else {//this is when graphplan is activated

                Set actionInTheLevel = new HashSet();
                if (np.action_level.get(i) instanceof ArrayList) {
                    actionInTheLevel.addAll((ArrayList) np.action_level.get(i));
                } else {
                    actionInTheLevel = (Set) np.action_level.get(i);
                }
                if (actionInTheLevel.contains(gr)) {
                    ret += " " + gr.toSmtVariableString(i);
                }
            }
        }
        ret += ")";
        if (ret.equals("(or)")) {
            return "false";
        }

        return ret;
    }

    private void removeInvActions(Set actions) {

        Iterator it = actions.iterator();

        while (it.hasNext()) {
            GenericActionType as = (GenericActionType) it.next();
            //System.out.println(as.getName());
            if (as.getName().contains("_INV_")) {
                //System.out.println(as);
                it.remove();
            }
        }
    }

    private HashSet<ArrayList> getGlobalConstraint(Set actions) {
        HashSet<ArrayList> ret = new HashSet();
        Iterator it = actions.iterator();
        while (it.hasNext()) {
            GlobalConstraint constr = (GlobalConstraint) it.next();
            if (constr.condition instanceof OrCond) {
                OrCond or = (OrCond) constr.condition;
                Set numFluents = or.getInvolvedFluents();
                ArrayList ele = new ArrayList();
                ele.add(numFluents);
                ele.add(or);
                ret.add(ele);
            } else {
                throw new UnsupportedOperationException("For now just or condition");
            }
        }
        return ret;
    }

    //Main procedure to detect if exists a plan of length i
    private boolean sat(int i) throws Exception {

        System.out.print("Current Horizon:" + i);
        long start = System.currentTimeMillis();
        ArrayList<String> smtString = null;
        smtString = this.encode(i);

        //System.out.println("Time for the encoding: " + (System.currentTimeMillis() - start));
        writeSmt2File(smtString);
        this.overallTime += (System.currentTimeMillis() - start);
        this.overallEcondingTime += (System.currentTimeMillis() - start);

        //invoking the solver
        start = System.currentTimeMillis();

        Process process = null;
        if (z3solver){
            process = new ProcessBuilder("z3", "-smt2", name_file_temp).start();
        }else{
           process = new ProcessBuilder("cvc4-1.4-x86_64-linux-opt", "-L","smtlib", name_file_temp).start();
        }
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;

        int j = 0;
        sat = false;

        extractedPlan = new SimplePlan(this.domain);

        //Pop encodes the plan resulting from the sat test, if any
        DirectedAcyclicGraph pop = new DirectedAcyclicGraph(DefaultEdge.class);

        //parsing the outcome. Can be optimized and written in a more elegant way. Statistics should be collected and then provided as output
        ArrayList<String> output = new ArrayList();
        while ((line = br.readLine()) != null) {
            output.add(line + "\n");
//            System.out.println(line);
            if (j == 0) {
                if (line.contains("unsat") || line.contains("unknown")) {
                    sat = false;
                    if (debugInfo > 0) {
                        System.out.println("unsat with " + i);
                    }
                    System.out.print(":Solving-TIME:" + (System.currentTimeMillis() - start));

                    //break;
                } else if (!line.contains("error")) {
                    if (debugInfo > 0) {
                        System.out.println("sat with" + i);
                    }
                    System.out.print(":Solving-TIME:" + (System.currentTimeMillis() - start));
                    sat = true;
                    //break;
                } else if (line.contains("error")) {
                    System.out.println("Error in the encoding");
                    //Utils.remove_file(name_file_temp);
                    System.exit(-1);
                }
            } else {
                if (line.contains("ACTION") && (sat)) {
                    String nextLine = null;
                    if (z3solver)
                        nextLine = br.readLine();
                    else
                        nextLine = line; //line = br.readLine();
                    if (nextLine != null) {
                        if (this.isRepetition_encoding() || true) {
                            Pattern p = null;
                            if (z3solver)
                                p = Pattern.compile(".*([0-9]+)\\)||.*true.*");
                            else
                                p = Pattern.compile(".*Int ([0-9]+)\\)");

                            Matcher m = p.matcher(nextLine);
                            if (!m.matches()) {
                                continue;
                            }
                            float frep = 1.0f;
                            //this is because action repetition can be actually also encoded as a float providing a lower bound on the solution.
//                            frep = Float.parseFloat(m.group());
                            if (!nextLine.contains("true") && z3solver) {
                                frep = Float.parseFloat(nextLine.replace(")", "").replace(" ", ""));
                                //frep = Float.parseFloat(nextLine.replace(")", "").replace(" ", ""));

                            }else{
                                frep = Float.parseFloat(m.group(1));
                            }
                            //System.out.println(frep);
                            int repetition = (int) frep;
                            if (repetition > 0) {
                                //mapping a given action with the number of times such an action has to be repeated
                                repetitions.put(pddlActionString(new String(line)), repetition);
                                pop.addVertex(pddlActionString(new String(line)));
                                output.add(nextLine + "\n");
                            }
                        } else {
                            if (nextLine.contains("true")) {
                                pop.addVertex(pddlActionString(new String(line)));
                            }
                        }
                    }
                } else if (line.contains(":time")) {
                    if (debugInfo > 1) {
                        System.out.println(line);
                    }
                }
            }
            j++;

        }

        System.out.println("");

        this.overallTime += (System.currentTimeMillis() - start);
        if (sat) {
            if (debugInfo > 0) {
                System.out.println("Encoding time:" + this.overallEcondingTime);
            }
            if (debugInfo > 0) {
                System.out.println("Planning time:" + this.overallTime);
            }
        }
        //The next find a topological order ot the pop, and store it in a simple plan representation
        //This is useful when we adopt a parallel semantic

        setEdgesViaOrders(pop);

        TopologicalOrderIterator toi = new TopologicalOrderIterator(pop);

        while (toi.hasNext()) {
            //System.out.println(toi.next());
            String action = (String) toi.next();
            if (action != null) {
                Integer r = repetitions.get(action);
                if (r == null) {
                    r = 1;
                }
                for (int k = 0; k < r; k++) {
                    extractedPlan.addActionsFromString(action);
                }
            }
        }

        actionsFound = new HashSet();
        for (Object o : extractedPlan) {
            actionsFound.add(o);
        }
        if (debugInfo > 1) {
            System.out.println(extractedPlan);
        }
        if (must_remove_file_temp) {
            //System.out.println("Saving z3 model");
            //writeOutToFile(output);
            Utils.remove_file(name_file_temp);
        }
        return sat;

    }

    private String pddlActionString(String line) {

        line = line.substring(line.lastIndexOf("ACTION") + 6, line.indexOf(" ()"));

        String[] ret = line.split("@");

        String parameters = "";
        for (int i = 1; i < ret.length - 1; i++) {
            parameters += " " + ret[i];
        }

        //System.out.println(ret[ret.length - 1].split("-")[1] + ": (" + ret[0] + parameters + ")");
        return ret[ret.length - 1].split("-")[1] + ": (" + ret[0] + parameters + ")";
    }

    /**
     * @return the semantic
     */
    public String getSemantic() {
        return semantic;
    }

    /**
     * @param semantic the semantic to set
     */
    public void setSemantic(String semantic) {
        this.semantic = semantic;
    }

    private void setEdgesViaOrders(DirectedAcyclicGraph po) {

        for (Object o : po.vertexSet()) {
            for (Object o1 : po.vertexSet()) {
                if (!o.equals(o1)) {
                    String a = (String) o;
                    String b = (String) o1;
                    if (Integer.parseInt(a.split(":")[0]) < Integer.parseInt(b.split(":")[0])) {
                        po.addEdge(a, b);
                    }
                }
            }
        }

    }

    public boolean writeSmt2File(ArrayList<String> smtString) {
        long start = System.currentTimeMillis();

        try {
            name_file_temp = "/tmp/temp" + this.problem.getPddlFilRef().replace("/", "");
            BufferedWriter w = new BufferedWriter(new FileWriter(name_file_temp));
            for (int k = 0; k < smtString.size(); k++) {
                w.write(smtString.get(k), 0, smtString.get(k).length());
            }
            w.close();
        } catch (IOException ex) {
            System.err.println("What the hell!" + ex);
            return false;
        }
        //System.out.println("Time for storing in the file: " + (System.currentTimeMillis() - start));
        this.overallTime += (System.currentTimeMillis() - start);
        return true;
    }

    public void printOutcome() {
        if (this.sat) {
            System.out.println("Solved: True");
        } else {
            System.out.println("Solved: False");
        }
        System.out.println("Encoding time: " + this.overallEcondingTime);
        System.out.println("Planning time: " + this.overallTime);
        System.out.println("Plan Steps: " + this.last_horizon);

    }

    /**
     * @return the implicit_goal
     */
    public boolean isImplicit_goal() {
        return implicit_goal;
    }

    /**
     * @param implicit_goal the implicit_goal to set
     */
    public void setImplicit_goal(boolean implicit_goal) {
        this.implicit_goal = implicit_goal;
    }

    /**
     * @return the onlyHelpfulActions
     */
    public boolean isOnlyHelpfulActions() {
        return onlyHelpfulActions;
    }

    /**
     * @param onlyHelpfulActions the onlyHelpfulActions to set
     */
    public void setOnlyHelpfulActions(boolean onlyHelpfulActions) {
        this.onlyHelpfulActions = onlyHelpfulActions;
    }

    /**
     * @return the ffHeuristic
     */
    public boolean isFFHeuristic() {
        return ffHeuristic;
    }

    /**
     * @param ffHeuristic the ffHeuristic to set
     */
    public void setFFHeuristic(boolean ffHeuristic) {
        this.ffHeuristic = ffHeuristic;
    }

    HashMap<Conditions, Integer> h2 = new HashMap();

    /**
     * @return the h1_recursion_memoization
     */
    public boolean isComputeH1() {
        return computeH1;
    }

    /**
     * @param computeH1 the h1_recursion_memoization to set
     */
    public void setComputeH1(boolean computeH1) {
        this.computeH1 = computeH1;
    }

    /**
     * @return the maxHeuristic
     */
    public boolean isMaxHeuristic() {
        return maxHeuristic;
    }

    /**
     * @param maxHeuristic the maxHeuristic to set
     */
    public void setMaxHeuristic(boolean maxHeuristic) {
        this.maxHeuristic = maxHeuristic;
    }

    private HashSet<NumFluent> takeControllableVariables(Set actions) {
        HashSet<NumFluent> ret = new HashSet();
        Iterator it = actions.iterator();
        while (it.hasNext()) {

            GroundAction gr = (GroundAction) it.next();
            if (gr.getName().contains("_CONT_")) {
                gr.generateAffectedNumFluents();
                ret.addAll(gr.getNumericFluentAffected().keySet());
            }
        }
        return ret;
    }

    private void removeContActions(LinkedHashSet actions) {
        Iterator it = actions.iterator();

        while (it.hasNext()) {
            GenericActionType as = (GenericActionType) it.next();
            //System.out.println(as.getName());
            if (as.getName().contains("_CONT_")) {
                //System.out.println(as);
                it.remove();
            }
        }
    }

    private boolean writeOutToFile(ArrayList<String> output) {
        long start = System.currentTimeMillis();

//        System.out.println(output);
        try {
            out_file = this.domain.getPddlFilRef().replace("/", "") + this.problem.getPddlFilRef().replace("/", "") + ".z3out";
            try (BufferedWriter w = new BufferedWriter(new FileWriter(out_file))) {

                for (int k = 0; k < output.size(); k++) {
                    output.set(k, output.get(k).replace("\n   ", " "));
//                output.set(k,output.get(k).replace("    ", "\n"));
//                output.get(k).repl
                    w.write(output.get(k), 0, output.get(k).length());
                }
            }
        } catch (IOException ex) {
            System.err.println("What the hell!" + ex);
            return false;
        }

        //System.out.println("Time for storing in the file: " + (System.currentTimeMillis() - start));
        this.overallTime += (System.currentTimeMillis() - start);
        return true;
    }

    /**
     * @return the sec_theory
     */
    public String getSec_theory() {
        return sec_theory;
    }

    /**
     * @param sec_theory the sec_theory to set
     */
    public void setSec_theory(String sec_theory) {
        this.sec_theory = sec_theory;
    }

    private String add_constraint_for_repetition(GroundAction gr, int i) throws CloneNotSupportedException {
        String ret = "(and ";
        String var = "(- " + gr.toSmtVariableString(i) + " 1)";
        //String var = gr.to_smtlib_with_repetition(i);

        if (gr.getPreconditions() != null) {
            for (Conditions c : (Collection<Conditions>) gr.getPreconditions().sons) {
                ret += " " + c.toSmtVariableString(i, gr, var) + " ";
            }
        }
        for (Object o : SC) {
            if (o instanceof GlobalConstraint) {
                GlobalConstraint gc = (GlobalConstraint) o;
                Conditions temp = generate_m_times_regressed_conditions(gc.condition, gr);
                ret += " " + temp.toSmtVariableString(i) + " ";
                //TO-DO This following should be better, but for some reason doesn't work/ Needs to be checked thouroughly
                //ret += generate_string_m_times_regressed_conditions(gc.condition, gr, i);
            }
        }

        return ret += " true)";
//        return "(and  true)";

    }

    public String generate_string_m_times_regressed_conditions(Conditions c, GroundAction gr, int i) {
        String var = gr.toSmtVariableString(i);
        if (c instanceof OrCond) {
            String middle = "";
            for (Conditions c1 : (Collection<Conditions>) c.sons) {
                if (c1 instanceof Predicate) {
                    continue;
                }
                if (c1 instanceof NotCond) {
                    NotCond nc = (NotCond) c1;
//                    System.out.println("It is a not");
                    
                    if (nc.son != null && !nc.son.isEmpty()) {
//                        System.out.println(nc.son);
                        Object next = nc.son.iterator().next();
                        if (next instanceof Comparison) {
                            throw new UnsupportedOperationException("For action repetition, numeric global constraint have to be represented in positive CNF:"+c1);
                        }else{
                            continue;
                        }
                    }
                }
                if (c1 instanceof Comparison) {
                    Comparison comp = (Comparison) c1;
                    if (comp.involve(gr.getNumericFluentAffected()))
                        middle += "(and " + comp.toSmtVariableString(i) + " " + comp.toSmtVariableString(i, gr, var) + " )";
                } else if (c1 instanceof AndCond) {
//                    System.out.println("It is not a not");
                    throw new UnsupportedOperationException("For action repetition, numeric global constraint have to be represented in positive CNF:"+c1);
                }
            }
            if ("".equals(middle)) {
                return "";
            }
            return "(or " + middle + " )";
        } else if (c instanceof AndCond) {
            String middle = "";
            for (Conditions c1 : (Collection<Conditions>) c.sons) {
                if (c1 instanceof Predicate) {
                    continue;
                }
                if (c1 instanceof NotCond) {
                    NotCond nc = (NotCond) c1;
                    if (nc.son != null && !nc.son.isEmpty()) {
                        if (!(nc.son.iterator().next() instanceof Predicate)) {
                            throw new UnsupportedOperationException("For action repetition, numeric global constraint have to be represented in positive CNF:"+c1);
                        }
                    }
                }
                if (c1 instanceof Comparison) {
                    Comparison comp = (Comparison) c1;
                    if (comp.involve(gr.getNumericFluentAffected()))
                        middle += "(and " + comp.toSmtVariableString(i) + " " + comp.toSmtVariableString(i, gr, var) + " )";
                } else {
                    System.out.println(c1.getClass());
                    throw new UnsupportedOperationException("For action repetition, numeric global constraint have to be represented in positive CNF:"+c1);
                }

            }
            if ("".equals(middle)) {
                return "";
            }
            return "(and " + middle + " )";
        } else if (c instanceof Comparison) {
            Comparison comp = (Comparison) c;
            if (comp.involve(gr.getNumericFluentAffected()))

                return "(and " + comp.toSmtVariableString(i) + " " + comp.toSmtVariableString(i, gr, var) + " )";
            else
                return "";
        } else if (c instanceof Predicate) {
            //do nothing
        } else if (c instanceof NotCond) {
            NotCond nc = (NotCond) c;
            if (nc.son != null && !nc.son.isEmpty()) {
                if (!(nc.son.iterator().next() instanceof Predicate)) {
                    throw new UnsupportedOperationException("For action repetition, numeric global constraint have to be represented in positive CNF:"+c);
                }
            }
        } else {
            throw new UnsupportedOperationException("Numeric global Constraint have to be represented in positive CNF:"+c);
        }
        return null;

    }

    private String add_constraint_for_repetition_bak(GroundAction gr, int i) {
        String ret = "(and ";
        String var = "(- " + gr.toSmtVariableString(i) + " 1)";
        //String var = gr.to_smtlib_with_repetition(i);

        for (Conditions c : (Collection<Conditions>) gr.getPreconditions().sons) {
            if (c instanceof Comparison) {
                Comparison c1 = (Comparison) c;
                if (gr.mayInfluence(c1)) {
                    ret += " " + c1.toSmtVariableString(i, gr, var) + " ";
                }
            }
        }
        return ret += " true)";
//        return "(and  true)";

    }

    private String add_prop_constraint_for_repetition(GroundAction gr, int i) {
        String var = gr.toSmtVariableString(i);
        AndCond and = new AndCond();

        boolean atLeast_one = false;
        if (gr.getPreconditions() != null) {
            for (Conditions c : (Collection<Conditions>) gr.getPreconditions().sons) {
                if (c instanceof Predicate) {
                    and.addConditions(c);
                    atLeast_one = true;
                }
            }
        }
        if (gr.getAddList() != null) {
            for (Conditions c : (Collection<Conditions>) gr.getAddList().sons) {
                if (c instanceof Predicate) {
                    //and.addConditions(c);
                    atLeast_one = true;
                }
            }
        }
        if (gr.getDelList() != null) {
            for (Conditions c : (Collection<Conditions>) gr.getDelList().sons) {
                if (c instanceof NotCond) {
                    and.addConditions(c);
                    atLeast_one = true;
                }
            }
        }

//        System.out.println(and);
//        System.out.println(atLeast_one);
        //and.addConditions(new Predicate("true"));
        if (!atLeast_one || and.sons.isEmpty()) {
//            System.out.println("return null");
            return null;
        }

//        return or.to_smtlib_with_repetition(i);
        return "(=> (>= " + var + " 2) " + and.toSmtVariableString(i) + " )";
    }

    /**
     * @return the repetition_encoding
     */
    public boolean isRepetition_encoding() {
        return repetition_encoding;
    }

    /**
     * @param repetition_encoding the repetition_encoding to set
     */
    public void set_repetition_encoding(boolean repetition_encoding) {
        this.repetition_encoding = repetition_encoding;
    }

    private Set noInterference(LinkedHashSet actions) {
        return new HashSet();
    }

    private void init_ach_mod() {
        predAchievers = new HashMap();
        predDeleters = new HashMap();
        numModifiers = new HashMap();

        for (Object o : reacheable_predicates) {

            HashSet achievers = new HashSet();
            HashSet deleters = new HashSet();
            for (Object o1 : getActions()) {
                GroundAction gr = (GroundAction) o1;

                if (gr.achieve((Predicate) o)) {
                    achievers.add(gr);
                }
                if (gr.delete((Predicate) o)) {
                    deleters.add(gr);
                }

            }
            predAchievers.put((Predicate) o, achievers);
            predDeleters.put((Predicate) o, deleters);
            //System.out.println(predAchievers.get(o).size());
            //System.out.println(predDeleters.get(o).size());
        }
        for (Object o : getProblem().getInit().getNumericFluents()) {
            NumFluentAssigner temp = (NumFluentAssigner) o;
            NumFluent nf = temp.getNFluent();
            HashSet modifiers = new HashSet();
            for (Object o1 : getActions()) {
                GroundAction gr = (GroundAction) o1;
                if (gr.getNumericFluentAffected().get(nf) != null) {
                    modifiers.add(gr);
                }
                numModifiers.put(nf, modifiers);
            }
        }

    }

    private Collection build_propositional_variables_init_state(int k) {
        ArrayList<String> ret = new ArrayList();
        for (int i = 0; i <= k; i++) {
            //Variables constructor
            for (Object o : reacheable_predicates) {
                Predicate p = (Predicate) o;
                ret.add("(declare-const " + p.toSmtVariableString(i) + " Bool)\n");
                //init status constraint
                if (i == 0) {
                    if (problem.getInit().containProposition(p)) {
                        ret.add("(assert " + p.toSmtVariableString(i) + ")\n");
                    } else {
                        ret.add("(assert (not " + p.toSmtVariableString(i) + "))\n");
                    }
                }
            }
        }
        return ret;
    }

    private Collection build_numeric_variables_plus_init_global_constraint(int k) {
        HashMap<String, Boolean> declared = new HashMap();
        ArrayList<String> ret = new ArrayList();

        for (int i = 0; i <= k; i++) {

            //For each numeric fluent involved in some invariant constraint we build a smt continuous variable, if such a variable does not exist yet
            //SC is a pair (implemented as a 2 elements list. The first element is a set of numeric fluents. The second element is an or condition representing
            //the implication from primary variable to secondary variable.
            if (backward_compatibility_switched_constraint) {
                for (ArrayList o : (Collection<ArrayList>) SC) {
                    for (Object o1 : (Set) o.get(0)) {
                        NumFluent nf = (NumFluent) o1;
                        if (declared.get(nf.toSmtVariableString(i)) == null || !declared.get(nf.toSmtVariableString(i))) {
                            declared.put(nf.toSmtVariableString(i), Boolean.TRUE);

                            ret.add("(declare-const " + nf.toSmtVariableString(i) + " " + this.getSec_theory() + ")\n");
                            //System.out.println("(declare-const " + nf.to_smtlib_with_repetition(i) + " () Real)\n");
                        }
                    }
                    OrCond or = (OrCond) o.get(1);
                    //The OrCond contains the implication. It consists of two elements, the former is the negated left hand of the implication, the second element
                    //is the numeric constraint that has to be satisfied whenever the first element is true. The function or.tosmtvariablestring implements such an implication
                    //Here there is an assumption that the primary variable formula is expressed as a conjunction of positive literals. 
                    //the implication will be added only if the left-hand might be achieved.
                    if (or.involveReacheablePredicates(reacheable_predicates)) {
                        //                    System.out.println("Switched Constraints!!");
                        //System.out.println("SC:"+or);
                        ret.add(";SwitchedConstraint\n");
                        ret.add("(assert " + or.toSmtVariableString(i) + ")\n");
                    }
                }
            } else {
                for (Object o : SC) {

                    GlobalConstraint gc;
                    gc = (GlobalConstraint) o;
                    for (Object o1 : (Set) gc.condition.getInvolvedFluents()) {
                        NumFluent nf = (NumFluent) o1;
                        if (declared.get(nf.toSmtVariableString(i)) == null || !declared.get(nf.toSmtVariableString(i))) {
                            declared.put(nf.toSmtVariableString(i), Boolean.TRUE);

                            ret.add("(declare-const " + nf.toSmtVariableString(i) + " " + this.getSec_theory() + ")\n");
                            //System.out.println("(declare-const " + nf.to_smtlib_with_repetition(i) + " () Real)\n");
                        }
                    }
                    ret.add(";;Global Constraint: " + gc.name + "\n");
                    ret.add("(assert " + gc.condition.toSmtVariableString(i) + ")\n");
                }
            }

            //Assumption: numeric fluents in the initial state are constants. The following builds variable for each numeric fluent of interest. There could be in fact numeric fluents
            //not defined in the previous (see above) definitions
            for (Object o : this.problem.getInit().getNumericFluents()) {
                NumFluentAssigner n_ass = (NumFluentAssigner) o;
                NumFluent nf = n_ass.getNFluent();
                if (declared.get(nf.toSmtVariableString(i)) == null || !declared.get(nf.toSmtVariableString(i))) {
                    declared.put(nf.toSmtVariableString(i), Boolean.TRUE);
                    ret.add("(declare-const " + nf.toSmtVariableString(i) + " " + this.getSec_theory() + ")\n");
                }
                if (i == 0) {
                    ret.add("(assert (= " + n_ass.getNFluent().toSmtVariableString(i) + " " + n_ass.getTwo().toSmtVariableString(i + 1) + "))\n");
                }
            }

            //Add also all the numeric fluent that can become true at some point
            for (Object o : this.def_num_fluent) {
                NumFluent nf = (NumFluent) o;
//                NumFluent nf = n_ass.getNFluent();
                if (declared.get(nf.toSmtVariableString(i)) == null || !declared.get(nf.toSmtVariableString(i))) {
                    declared.put(nf.toSmtVariableString(i), Boolean.TRUE);
                    ret.add("(declare-const " + nf.toSmtVariableString(i) + " " + this.getSec_theory() + ")\n");

                }
                if (i == 0) {
                    if (this.domain.generateAbstractInvariantFluents().get(nf) == null) {
                        if (this.problem.getInit().functionValue(nf) == null) {
                            System.out.println(" Undefined values that can become true at some points are not supported yet");
                            System.exit(-1);
//                          smt2String.add("(assert (= " + nf.to_smtlib_with_repetition(i) + " NULL ))\n");
                        }
                    }
                }
            }

            //something related to the numeric variables that can become defined. 
        }
        return ret;

    }

    private Collection build_action_variables(int k) throws CloneNotSupportedException {
        ArrayList<String> ret = new ArrayList();
//        System.out.println("Eligible Rolling Up Actions:"+eligible);

        for (int i = 0; i < k; i++) {
            Set actionInTheLevel = getActions();

            //actionInTheLevel = actions; 
            for (Object o : actionInTheLevel) {
                GroundAction gr = (GroundAction) o;
                if (!this.isRepetition_encoding() || !eligible.get(gr)) {

                    //A boolean variable encodes the activation of the action
                    ret.add("(declare-const " + gr.toSmtVariableString(i) + " Int)\n");
                    ret.add("(assert (or (= " + gr.toSmtVariableString(i) + " 0) (= " + gr.toSmtVariableString(i) + " 1) ))\n");
                    //precondition implications
                    if (gr.getPreconditions() != null && !gr.getPreconditions().sons.isEmpty()) {
                        ret.add("(assert (=> (> " + gr.toSmtVariableString(i) + " 0) " + gr.getPreconditions().toSmtVariableString(i) + " ))\n");
                    }

                    //effect implications on the primary model
                    AndCond add = (AndCond) gr.getAddList();
                    if (add != null && !add.sons.isEmpty()) {
                        ret.add("(assert (=> (> " + gr.toSmtVariableString(i) + " 0) " + gr.getAddList().toSmtVariableString(i + 1) + " ))\n");
                    }
                    if (gr.getDelList() != null && !gr.getDelList().sons.isEmpty()) {
                        ret.add("(assert (=> (> " + gr.toSmtVariableString(i) + " 0) " + gr.getDelList().toSmtVariableString(i + 1) + " ))\n");
                    }
                    if (gr.getNumericEffects() != null && !gr.getNumericEffects().sons.isEmpty()) {
                        //System.out.println(gr.getNumericEffects().to_smtlib_with_repetition(i));
                        ret.add("(assert (=> (> " + gr.toSmtVariableString(i) + " 0) " + gr.getNumericEffects().toSmtVariableString(i) + " ))\n");
                    }
                } else {

                    //A boolean variable encodes the activation of the action
                    ret.add("(declare-const " + gr.toSmtVariableString(i) + "  Int)\n");

                    ret.add("(assert (>= " + gr.toSmtVariableString(i) + " 0))\n");
//                    ret.add("(assert (<= " + gr.to_smtlib_with_repetition(i) + " 100))\n");
                    //if (Objects.equals(num_rel_actions.get(gr), Boolean.FALSE) || threat_disjunctive_global_constraint(gr, SC) {
//                    System.out.println("Eligible("+gr.toEcoString()+eligible.get(gr!eligible.get(gr)));
                    if (Objects.equals(num_rel_actions.get(gr), Boolean.FALSE)) {
//                        System.out.println("Excluded");
                        ret.add("(assert (<= " + gr.toSmtVariableString(i) + " 1))\n");
                        if (gr.getNumericEffects() != null && !gr.getNumericEffects().sons.isEmpty()) {
                            //System.out.println(gr.getNumericEffects().to_smtlib_with_repetition(i));
                            ret.add("(assert (=> (> " + gr.toSmtVariableString(i) + " 0) " + gr.getNumericEffects().toSmtVariableString(i) + " ))\n");
                        }
                    } else {//action repetition constraints
                        ret.add(";repetition constraint\n");
                        //System.out.println("Vediamo cosa creas");

                        ret.add("(assert (=> (> " + gr.toSmtVariableString(i) + " 1) " + add_constraint_for_repetition(gr, i) + " ))\n");

                        String s = add_prop_constraint_for_repetition(gr, i);
                        if (s != null) {
                            ret.add(";prop_constraint\n(assert " + s + ")\n");
                        }
                        if (max_number_of_repetition != -1) {
                            ret.add("(assert (<= " + gr.toSmtVariableString(i) + " " + max_number_of_repetition + "))\n");
                        }
                        if (gr.getNumericEffects() != null && !gr.getNumericEffects().sons.isEmpty()) {
                            for (NumEffect ne : (Collection<NumEffect>) gr.getNumericEffects().sons) {
                                //System.out.println(ne.to_smtlib_with_repetition(i,gr.to_smtlib_with_repetition(i)));
                                ret.add("(assert (=> (> " + gr.toSmtVariableString(i) + " 0) " + ne.to_smtlib_with_repetition(i, gr.toSmtVariableString(i)) + " ))\n");
                            }

                        }
                    }
                    //smt2String.add("(assert (<= " + gr.to_smtlib_with_repetition(i) + " 50))\n");
                    if (gr.getPreconditions() != null && !gr.getPreconditions().sons.isEmpty()) {
                        ret.add(";precondition\n(assert (=> (> " + gr.toSmtVariableString(i) + " 0) " + gr.getPreconditions().toSmtVariableString(i) + " ))\n");
                    }

                    //effect implications on the primary model
                    AndCond add = (AndCond) gr.getAddList();
                    if (add != null && !add.sons.isEmpty()) {
                        ret.add("(assert (=> (> " + gr.toSmtVariableString(i) + " 0) " + gr.getAddList().toSmtVariableString(i + 1) + " ))\n");
                    }
                    if (gr.getDelList() != null && !gr.getDelList().sons.isEmpty()) {
                        ret.add("(assert (=> (> " + gr.toSmtVariableString(i) + " 0) " + gr.getDelList().toSmtVariableString(i + 1) + " ))\n");
                    }

                }
            }

            ret.add("(assert (or ");

            for (Object o : actionInTheLevel) {
                GroundAction gr = (GroundAction) o;
                ret.add(" (>  " + gr.toSmtVariableString(i) + "  0)");
            }

            ret.add(" true ))\n");
            //interferencies. The content of this set of relations depends on the semantic adopted
            for (Object o : interferences) {
                GroundAction[] interferring = (GroundAction[]) o;
                //if (i>=np.action_level.size())//this prevents to access to unassigned level. This may happen because the planning graph is actually an understimation of the actual plan length so it could have less level than the one actually needed
                //    smt2String.add("(assert (not (and " + interferring[0].to_smtlib_with_repetition(i) + " " + interferring[1].to_smtlib_with_repetition(i) + ")))\n");
                //else{//here consider just action that belongs to this level
                //Set actionInThisLevel = (Set)np.action_level.get(i);
                if (actionInTheLevel.contains(interferring[0]) && actionInTheLevel.contains(interferring[1])) {
//                    if (!this.isRepetition_encoding()) {
//                        ret.add("(assert (not (and " + interferring[0].to_smtlib_with_repetition(i) + " " + interferring[1].to_smtlib_with_repetition(i) + ")))\n");
//                    } else {
                    String firstActions = "";
                    String secdonActions = "";
                    if (num_rel_actions.get(interferring[0]) == Boolean.TRUE || !not_homogenous) {
                        firstActions = "(> " + interferring[0].toSmtVariableString(i) + " 0)";
                    } else {
                        firstActions = interferring[0].toSmtVariableString(i);
                    }
                    if (num_rel_actions.get(interferring[1]) == Boolean.TRUE || !not_homogenous) {
                        secdonActions = "(> " + interferring[1].toSmtVariableString(i) + " 0)";
                    } else {
                        secdonActions = interferring[1].toSmtVariableString(i);
                    }
                    ret.add("(assert (not (and " + firstActions + " " + secdonActions + " )))\n");
//                    }
                }
                //}
            }
        }
        return ret;

    }

    private Collection build_frame_axiom(int k) {
        ArrayList<String> ret = new ArrayList();

        for (int i = 0; i < k; i++) {
            //frame axiom
            //Propositional Part
            for (Object o : reacheable_predicates) {
                Predicate p = (Predicate) o;
                ret.add("(assert (=> (and " + p.toSmtVariableString(i) + " (not " + p.toSmtVariableString(i + 1) + ")) " + predicateModifiers(p, predDeleters, i) + " ))\n");
                ret.add("(assert (=> (and " + p.toSmtVariableString(i + 1) + " (not " + p.toSmtVariableString(i) + ")) " + predicateModifiers(p, predAchievers, i) + " ))\n");
            }
            //Numeric fluents frame axioms
            for (Object o : this.problem.getInit().getNumericFluents()) {
                NumFluentAssigner n_ass = (NumFluentAssigner) o;
                NumFluent nf = n_ass.getNFluent();
                ret.add("(assert (=> (not " + this.numericFluentModifiers(nf, numModifiers, i) + ") (= " + n_ass.getNFluent().toSmtVariableString(i) + " " + n_ass.getNFluent().toSmtVariableString(i + 1) + ")))\n");

            }
        }
        return ret;
    }

    AndCond build_frame_for_global_constraint(GroundAction gr, Comparison t1, Conditions t) throws CloneNotSupportedException {

        Comparison t2 = (Comparison) t1;
        Comparison nc = gr.regressComparisonMtimes((Comparison) t2.clone());
        if (linear_normalization_active) {
            nc.normalize();
        }
        AndCond t4 = new AndCond();
        t4.addConditions(t);
        if (t instanceof NotCond) {
            NotCond t3 = new NotCond();
            t3.addConditions(nc);
            if (!nc.equals(t2)) {
                t4.addConditions(t3);
            }
        } else {
            t4.addConditions(nc);
        }

        return t4;

    }

    private Conditions generate_m_times_regressed_conditions(Conditions c, GroundAction gr) throws CloneNotSupportedException {
        if (c instanceof OrCond) {
            OrCond ret = new OrCond();
            for (Conditions c1 : (Collection<Conditions>) c.sons) {
                if (c1 instanceof NotCond) {
                    NotCond t = (NotCond) c1;
                    Object t1 = t.son.iterator().next();
                    if (t1 != null && t1 instanceof Comparison) {
                        ret.addConditions((AndCond) build_frame_for_global_constraint(gr, (Comparison) t1, t));
                    } else {
                        throw new UnsupportedOperationException("Global Constraint have to contain numeric constraint");
                    }
                } else if (c1 instanceof Comparison) {
                    ret.addConditions((AndCond) build_frame_for_global_constraint(gr, (Comparison) c1, c1));
                } else if (c1 instanceof PDDLObjectsEquality) {
                    ret.addConditions(c1);
                } else {
                    throw new UnsupportedOperationException("Global Constraint have to be represented in CNF");
                }
            }
            return ret;
        } else if (c instanceof NotCond) {
            NotCond t = (NotCond) c;
            Object t1 = t.son.iterator().next();
            if (t1 != null && t1 instanceof Comparison) {
                return build_frame_for_global_constraint(gr, (Comparison) t1, t);
            } else {
                throw new UnsupportedOperationException("Global Constraint have to contain numeric constraint");
            }
        } else if (c instanceof AndCond) {
            AndCond ret = new AndCond();
            for (Conditions c1 : (Collection<Conditions>) c.sons) {
                if (c1 instanceof NotCond) {
                    NotCond t = (NotCond) c1;
                    Object t1 = t.son.iterator().next();
                    if (t1 != null && t1 instanceof Comparison) {
                        ret.addConditions((AndCond) build_frame_for_global_constraint(gr, (Comparison) t1, t));
                    } else {
                        throw new UnsupportedOperationException("Global Constraint have to contain numeric constraint");
                    }
                } else if (c1 instanceof Comparison) {
                    ret.addConditions((AndCond) build_frame_for_global_constraint(gr, (Comparison) c1, c1));
                } else if (c1 instanceof PDDLObjectsEquality) {
                    ret.addConditions(c1);
                } else {
                    System.out.println(c1.getClass());
                    throw new UnsupportedOperationException("Global Constraint have to be represented in CNF");
                }
            }
            return ret;
        } else if (c instanceof Comparison) {
            return build_frame_for_global_constraint(gr, (Comparison) c, c);
        } else {
            throw new UnsupportedOperationException("Global Constraint have to be represented in CNF");
        }
    }

    public void compute_action_interferencies() {
        interferences = null;
        if (this.semantic == null || this.semantic.equalsIgnoreCase("1")) {
            System.out.println("1-step semantic: computing action exclusivity");
            interferences = this.computeExclusivity(getActions());
        } else if (this.semantic.equalsIgnoreCase("n")) {
            //System.out.println("Computing action interferces");
            interferences = this.computeInterferences(getActions());
        } else if (this.semantic.equalsIgnoreCase("e")) {
            //System.out.println("Computing action interferces");
            interferences = this.computeInterferences_existential(getActions());
        } else if (this.semantic.equalsIgnoreCase("0")) {
            //System.out.println("Computing action interferces");
            interferences = this.noInterference(getActions());
        } else {
            System.err.println("No semantic defined");
            System.exit(-1);
        }
    }

    /**
     * @return the actions
     */
    public LinkedHashSet getActions() {
        return actions;
    }

    /**
     * @param actions the actions to set
     */
    public void setActions(LinkedHashSet actions) {
        this.actions = actions;
    }

    public boolean compute_relevance_analysis(Set a) {
        //reacheability analysis using metric heuristic

//        for (GroundAction gr : (Collection<GroundAction>) a) {
//            try {
//                gr.simplifyModel(domain, problem);
//                //gr.normalize();
//            } catch (Exception ex) {
//                Logger.getLogger(SMTBasedPlanning.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        Aibr heuristic = new Aibr(problem.getGoals(), a);
        Float ret = heuristic.setup(getProblem().getInit());
        if (ret == Float.MAX_VALUE && domain.getFree_functions().isEmpty()) {
            return false;
        }

        //relevance analysis
        setActions(new LinkedHashSet(heuristic.reachable));

        //these are the actions relevant for the numeric part of the problem. This information is key in determining whether to use 
        //action compression or not.
        num_rel_actions = new HashMap();
        def_num_fluent = new LinkedHashSet();
        eligible = new HashMap();
        for (GroundAction gr : heuristic.reachable) {
            num_rel_actions.put(gr, true);
//            try {
//                gr.simplifyModel(domain, problem);
//            } catch (Exception ex) {
//                Logger.getLogger(SMTBasedPlanning.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            System.out.println(gr.toPDDL());
            if (gr.getNumericFluentAffected() != null && !gr.getNumericFluentAffected().isEmpty()) {
                def_num_fluent.addAll(gr.getNumericFluentAffected().keySet());
            }
            //the third condition can be released in general, but does not work with current SMT solver such as z3. It in fact may imply integral exponents, that when are employed in 
            //expression may lead to check for the satisfiability of undecidable problems
            if ((gr.internal_dependencies_length() > 0) || gr.has_complex_preconditions() || gr.has_exponential_or_nl_effects_asymptotic_effects() || !gr.has_additive_effects()) {
                eligible.put(gr, false);
            } else {
                eligible.put(gr, true);
            }
        }
//        System.out.println(eligible);

        //reacheable predicates
        //This following can be fixed!
        reacheable_predicates = heuristic.reacheable_state.poss_propositions.keySet();
//        def_num_fluent = heuristic.reacheable_state.poss_numericFs.keySet();
//        System.out.println(heuristic.reacheable_state);
        System.out.println("|P|" + reacheable_predicates.size());
        System.out.println("|X|" + def_num_fluent.size());
        RelState reacheableState = heuristic.reacheable_state;
        Iterator it = SC.iterator();
        while (it.hasNext()) {
            GlobalConstraint c = (GlobalConstraint) it.next();
            if (c.isTautology(reacheableState)) {
                it.remove();
            }
//            System.out.println(c.condition.pddlPrint(false));

        }

        //precomputation of the achievers/deleters/modifier. 
        init_ach_mod();

        if (isComputeH1()) {
            System.out.println("H1 computation");
            long start_h1 = System.currentTimeMillis();
            //heuristic.setup(problem.getGoals(), actions);
            heuristic.layers_counter = true;
//            heuristic.set(true,true);
            h1Estimate = heuristic.compute_estimate(problem.getInit()).intValue();
            System.out.println("h1:" + h1Estimate);
            System.out.println("h1 time:" + (System.currentTimeMillis() - start_h1));
        }
        //int h1 = h1_recursion_memoization(problem.getInit(), problem.getGoals(), actions,new HashMap());

//        contVars = this.takeControllableVariables(getProblem().getActions());
//        removeContActions(actions);
        System.out.println("|A|:" + getActions().size());
        return true;
    }

    public void grounding() {
        getProblem().grounding();

        //Getting Global Constraint Constraints from pseudo actions. This has to be done after instantiation
        if (this.backward_compatibility_switched_constraint) {
            SC = getGlobalConstraint(getProblem().globalConstraintSet);
        } else {
            SC = getProblem().globalConstraintSet;
        }
    }

    public SimplePlan solve_multiple_phase(int minPlanLength, int maxPlanLength, SimplePlan sp) throws Exception {
        this.setComputeH1(false);
        ArrayDeque<String> relaxations = new ArrayDeque();
        relaxations.add("0");
        relaxations.add("e");
        if (search_strategy.contains("8") || search_strategy.contains("9")) {
            relaxations.add("N");
        } else {
            relaxations.add("1");
        }

        this.grounding();

        int fh = minPlanLength;
        LinkedHashSet currentActions = (LinkedHashSet) problem.getActions();
        if (sp != null) {
            currentActions = new LinkedHashSet(sp);
        }
        while (true) {
            if (sp != null) {
                if (search_strategy.contains("10")) {// && relaxations.size()==1){
                    currentActions = new LinkedHashSet(sp);
                }
                fh = this.last_horizon;
            }
            String current = relaxations.pop();
            this.setSemantic(current);
            this.compute_relevance_analysis(currentActions);
            this.compute_action_interferencies();
            sp = this.solve(fh, maxPlanLength);
            if (sp != null && relaxations.size() == 0) {
                return sp;
            }
        }
    }

    private boolean interference(GroundAction a, GroundAction b, HashSet SC) {
        HashSet<GlobalConstraint> gc_coll = (HashSet<GlobalConstraint>) SC;

        if ((a.getNumericFluentAffected() == null) || b.getNumericFluentAffected() == null) {
            return false;
        }

        boolean a_interacts = false;
        for (GlobalConstraint gc : gc_coll) {
            for (NumFluent nf : gc.condition.getInvolvedFluents()) {
                if ((a.getNumericFluentAffected().get(nf) != null)) {
                    if (a.getNumericFluentAffected().get(nf)) {
                        a_interacts = true;
                    }
                }
            }
        }
        if (!a_interacts) {
            return false;
        }
        for (GlobalConstraint gc : gc_coll) {
            for (NumFluent nf : gc.condition.getInvolvedFluents()) {
                if ((b.getNumericFluentAffected().get(nf) != null)) {
                    if (b.getNumericFluentAffected().get(nf)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

package com.hstairs.ppmajal.goalConflicts;

import com.hstairs.ppmajal.PDDLProblem.PDDLProblem;
import com.hstairs.ppmajal.conditions.AndCond;
import com.hstairs.ppmajal.conditions.BoolPredicate;
import com.hstairs.ppmajal.conditions.Comparison;
import com.hstairs.ppmajal.problem.State;
import com.hstairs.ppmajal.search.SearchHeuristic;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.ListIterator;

public class MSGS extends GoalSubsets{

    private final PDDLProblem problem;

    private ArrayList<String> boolean_goals_names = new ArrayList<String>();
    private ArrayList<String> comparison_goals_names =  new ArrayList<String>();

    private final ArrayList<BoolPredicate> boolean_goals = new ArrayList<>();
    private final ArrayList<Integer> boolean_goals_id = new ArrayList<>();
    private final ArrayList<Comparison> comparison_goals = new ArrayList<>();
    private final ArrayList<Integer> comparison_goals_id = new ArrayList<>();

    int num_pruned = 0;

    public MSGS(PDDLProblem problem){
        this.problem = problem;

        System.out.println("--------- INIT MSGS ------------");
        int index = 0;
        for(Object o : ((AndCond) problem.getGoals()).sons){
            System.out.println(index + ":  " + o);
            if(o instanceof BoolPredicate){
                boolean_goals.add((BoolPredicate) o);
                boolean_goals_id.add(index);
                boolean_goals_names.add(((BoolPredicate) o).toString());
                index++;
                continue;
            }
            if(o instanceof Comparison){
                comparison_goals.add((Comparison) o);
                comparison_goals_id.add(index);
                comparison_goals_names.add(o.toString());
                index++;
                continue;
            }

        }
        System.out.println("--------- INIT MSGS ------------");
        assert ((AndCond) problem.getGoals()).sons.length == boolean_goals.size() + comparison_goals.size();
    }

    private GoalSubset extract_goal_subset(State s){
        BitSet new_set_boolean = new BitSet(boolean_goals.size());

        for(ListIterator<BoolPredicate> it = boolean_goals.listIterator(); it.hasNext();){
            BoolPredicate bp = it.next();
            new_set_boolean.set(it.nextIndex() - 1, s.satisfy(bp));
//            System.out.println(bp.toString() + " " +  s.satisfy(bp));
        }
        ArrayList<Double> new_list_fluents = new ArrayList<>();
        for(Comparison com : comparison_goals){
//            System.out.println(com.toString() + "    eval = " +  com.variable_eval(s) + " ---> " +  s.satisfy(com));
            new_list_fluents.add(com.variable_eval(s));
        }

        return new GoalSubset(boolean_goals.size(), new_set_boolean, new_list_fluents, true);
    }

    public boolean prune(SearchHeuristic h, float bound,  State s){

        // first check if numeric goal can still be satisfied!
        for(ListIterator<Comparison> it = comparison_goals.listIterator(); it.hasNext();){
            Comparison com = it.next();
            int index = it.nextIndex() - 1;
            if (! com.isSatisfied(s)) {
                num_pruned++;
                return true;
            }
        }

        float[] goal_estimates = h.computeEstimateIndividualGoals(s);
//        System.out.println(goal_estimates.length);
//        for(float f : goal_estimates){
//            System.out.println(f);
//        }

        BitSet new_set_boolean = new BitSet(boolean_goals.size());
        for(ListIterator<BoolPredicate> it = boolean_goals.listIterator(); it.hasNext();){
            BoolPredicate bp = it.next();
            int index = it.nextIndex() - 1;
            boolean reachable = goal_estimates[boolean_goals_id.get(index)] < Float.MAX_VALUE &&  goal_estimates[boolean_goals_id.get(index)] <= bound;
            new_set_boolean.set(index, reachable);
//            System.out.println(bp.toString() + " " +  s.satisfy(bp));
        }
//        System.out.println(new_set_boolean);

        ArrayList<Double> new_list_fluents = new ArrayList<>();
        for(ListIterator<Comparison> it = comparison_goals.listIterator(); it.hasNext();){
            Comparison com = it.next();
            int index = it.nextIndex() - 1;
//            System.out.println(com.toString() + "    eval = " +  com.variable_eval(s) + " ---> " +  s.satisfy(com));
            boolean reachable = goal_estimates[comparison_goals_id.get(index)] < Float.MAX_VALUE &&  goal_estimates[comparison_goals_id.get(index)] <= bound;
            if(reachable){
                // indicates, that this condition can still be satisfied
                new_list_fluents.add(com.variable_eval(s));
            }
            else{
                new_list_fluents.add(null);
            }
        }

        GoalSubset reachable = new GoalSubset(boolean_goals.size(), new_set_boolean, new_list_fluents, true);
        boolean prune = this.containsSuperset(reachable, comparison_goals);
        if(prune)
            num_pruned++;
//        System.out.println("Prune: " + prune);
        return prune;
    }

    public void track(State s){
        this.add_and_subset_maximal(extract_goal_subset(s), comparison_goals);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("\n\n#pruned: ").append(num_pruned);
        s.append("\n--------------- MSGS --------------");
        for(GoalSubset sub : subsets){
            s.append("\n").append(sub.toString(boolean_goals_names, comparison_goals));
        }
        s.append("\n--------------- MUGS --------------");
        GoalSubsets mugs = this.complement().minimalHittingSets(comparison_goals);
        for(GoalSubset sub : mugs.subsets){
            s.append("\n").append(sub.toString(boolean_goals_names, comparison_goals));
        }

        return s.toString();
    }
}

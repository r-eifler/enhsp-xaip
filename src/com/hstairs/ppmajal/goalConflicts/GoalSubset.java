package com.hstairs.ppmajal.goalConflicts;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Vector;

import com.hstairs.ppmajal.conditions.Comparison;

public class GoalSubset {

    private final BitSet booleanGoals;

    // represents the boarder, either <= or >=
    private final List<Double> fluentGoals;

    public GoalSubset(BitSet booleanGoals, List<Double> fluentGoals){
        this.booleanGoals = booleanGoals;
        this.fluentGoals = fluentGoals;
    }

    public boolean is_subset(GoalSubset gs2, List<Comparison> comparisons){

        assert comparisons.size() == fluentGoals.size();

        BitSet and = (BitSet) this.booleanGoals.clone();
        and.and(gs2.booleanGoals);

        boolean booleanGoalsAreSubset = and.equals(this.booleanGoals);

        boolean fluentsAreSubset = true;
        for(int i = 0; i < this.fluentGoals.size(); i++){
            fluentsAreSubset &= comparisons.get(i).dominates(gs2.fluentGoals.get(i), this.fluentGoals.get(i));
        }

        return booleanGoalsAreSubset && fluentsAreSubset;
    }

    @Override
    public String toString(){

        return this.booleanGoals.toString() + " -- " + this.fluentGoals.toString();
    }

    public List<GoalSubset> singletonSubsets() {
        List<GoalSubset> singletons = new ArrayList<>();

        for (int i = 0; i < booleanGoals.length(); i++) {
            if (booleanGoals.get(i)) {
                BitSet singleGoal = new BitSet(booleanGoals.length());
                singleGoal.set(i, true);
                singletons.add(new GoalSubset(singleGoal, new ArrayList<>()));
            }
        }

        for (int i = 0; i < fluentGoals.size(); i++) {
            BitSet singleGoal = new BitSet(booleanGoals.length());
            singleGoal.set(i, true);
            singletons.add(new GoalSubset(singleGoal, new ArrayList<>()));
        }

        return singletons;
    }
//
//    public GoalSubset complement() {
//        BitSet comple = new BitSet(goals.length());
//
//        for (int i = 0; i < goals.length(); i++) {
//            comple.set(i, !goals.get(i));
//        }
//
//        return new GoalSubset(comple);
//    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GoalSubset other))
            return false;

        return this.booleanGoals.equals(other.booleanGoals) && this.fluentGoals.equals(other.fluentGoals);
    }

    @Override
    public final int hashCode() {
        return this.booleanGoals.hashCode() * this.fluentGoals.hashCode();
    }

}

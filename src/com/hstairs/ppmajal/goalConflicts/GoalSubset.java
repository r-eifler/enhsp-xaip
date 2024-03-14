package com.hstairs.ppmajal.goalConflicts;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Vector;

import com.hstairs.ppmajal.conditions.Comparison;

public class GoalSubset {

    private final int numBooleanGoals;
    private final BitSet booleanGoals;

    // represents the boarder, either <= or >=
    private final ArrayList<Double> fluentGoals;
    private final BitSet fluentGoalsPosComparison;

    public GoalSubset(int numBooleanGoals, BitSet booleanGoals, ArrayList<Double> fluentGoals, BitSet fluentGoalsPosComparison){
        this.numBooleanGoals = numBooleanGoals;
        this.booleanGoals = booleanGoals;
        this.fluentGoals = fluentGoals;
        this.fluentGoalsPosComparison = fluentGoalsPosComparison;
    }

    public GoalSubset(int numBooleanGoals, BitSet booleanGoals, ArrayList<Double> fluentGoals, boolean initComp){
        this.numBooleanGoals = numBooleanGoals;
        this.booleanGoals = booleanGoals;
        this.fluentGoals = fluentGoals;
        this.fluentGoalsPosComparison = new BitSet(fluentGoals.size());
        for(int i = 0; i < this.fluentGoals.size(); i++){
            this.fluentGoalsPosComparison.set(i,initComp);
        }
    }

    public boolean is_subset(GoalSubset gs2, ArrayList<Comparison> comparisons){

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

        return this.booleanGoals.toString() + " -- " + this.fluentGoals.toString() + " (" + this.fluentGoalsPosComparison.toString() + ")";
    }

    public List<GoalSubset> singletonSubsets() {
        List<GoalSubset> singletons = new ArrayList<>();

        for (int i = 0; i < this.numBooleanGoals; i++) {
            if (booleanGoals.get(i)) {
                BitSet singleGoal = new BitSet(this.numBooleanGoals);
                boolean initComp = fluentGoalsPosComparison.get(i) && !fluentGoalsPosComparison.isEmpty();
                for (int j = 0; j < this.numBooleanGoals; j++) {
                    singleGoal.set(j, i == j);
                }
                ArrayList<Double> singleFluent = new ArrayList<Double>(fluentGoals.size());
                while(singleFluent.size() < fluentGoals.size()) singleFluent.add(null);
                singletons.add(new GoalSubset(this.numBooleanGoals, singleGoal, singleFluent, initComp));
            }
        }

        for (int i = 0; i < fluentGoals.size(); i++) {
            if(fluentGoals.get(i) != null) {
                ArrayList<Double> singleFluent = new ArrayList<Double>(fluentGoals.size());
                while (singleFluent.size() < fluentGoals.size()) singleFluent.add(null);
                BitSet singleComp = new BitSet(fluentGoals.size());
                singleFluent.set(i, fluentGoals.get(i));
                singleComp.set(i, fluentGoalsPosComparison.get(i));
                singletons.add(new GoalSubset(this.numBooleanGoals, new BitSet(this.numBooleanGoals), singleFluent, singleComp));
            }
        }

        return singletons;
    }

    public GoalSubset setUnion(GoalSubset set, ArrayList<Comparison> comparisons){
        BitSet unionBinaryGoals = new BitSet(this.numBooleanGoals);
        ArrayList<Double> unionFluent = new ArrayList<>(fluentGoals.size());
        while (unionFluent.size() < fluentGoals.size()) unionFluent.add(null);
        BitSet unionFluentComp = new BitSet(fluentGoals.size());

        for (int i = 0; i < this.numBooleanGoals; i++) {
            unionBinaryGoals.set(i, booleanGoals.get(i) || set.booleanGoals.get(i));
        }

        for (int i = 0; i < fluentGoals.size(); i++) {
            assert(this.fluentGoalsPosComparison.get(i) == set.fluentGoalsPosComparison.get(i));
            unionFluentComp.set(i, this.fluentGoalsPosComparison.get(i));
            if(this.fluentGoals.get(i) == null && set.fluentGoals.get(i) == null){
                continue;
            }
            if(this.fluentGoals.get(i) == null){
                unionFluent.set(i, set.fluentGoals.get(i));
                continue;
            }
            if(set.fluentGoals.get(i) == null){
                unionFluent.set(i, this.fluentGoals.get(i));
                continue;
            }
            Double dominant = fluentGoalsPosComparison.get(i) == comparisons.get(i).dominates(set.fluentGoals.get(i), this.fluentGoals.get(i)) ?
                    this.fluentGoals.get(i) : set.fluentGoals.get(i);
            unionFluent.set(i, dominant);
        }

        return new GoalSubset(this.numBooleanGoals, unionBinaryGoals, unionFluent, unionFluentComp);
    }

    public GoalSubset complement() {
        BitSet compleBinaryGoals = new BitSet(this.numBooleanGoals);
        BitSet compleFluent = new BitSet(fluentGoals.size());

        for (int i = 0; i < this.numBooleanGoals; i++) {
            compleBinaryGoals.set(i, ! booleanGoals.get(i));
        }

        for (int i = 0; i < fluentGoals.size(); i++) {
            compleFluent.set(i, ! fluentGoalsPosComparison.get(i));
        }

        return new GoalSubset(this.numBooleanGoals, compleBinaryGoals, (ArrayList<Double>) fluentGoals.clone(), compleFluent);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GoalSubset other))
            return false;

        return this.booleanGoals.equals(other.booleanGoals)
                && this.fluentGoals.equals(other.fluentGoals)
                && this.fluentGoalsPosComparison.equals(other.fluentGoalsPosComparison);
    }

    @Override
    public final int hashCode() {

        return this.booleanGoals.hashCode() * this.fluentGoals.hashCode() * this.fluentGoalsPosComparison.hashCode();
    }

}

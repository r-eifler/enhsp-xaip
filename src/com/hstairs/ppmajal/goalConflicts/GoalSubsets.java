package com.hstairs.ppmajal.goalConflicts;

import com.hstairs.ppmajal.conditions.BoolPredicate;
import com.hstairs.ppmajal.conditions.Comparison;

import java.util.*;

public class GoalSubsets {

    protected Set<GoalSubset> subsets = new HashSet<>();

    public void add(GoalSubset new_set){
        subsets.add(new_set);
    }

    public boolean contains(GoalSubset set){
        return subsets.contains(set);
    }

    public boolean containsSuperset(GoalSubset set, List<Comparison> comparisons){
        for(GoalSubset gs : subsets){
            if(set.is_subset(gs, comparisons)){
                return true;
            }
        }
        return false;
    }


    public void add_and_subset_maximal(GoalSubset new_set, List<Comparison> comparisons){

        boolean can_be_added = true;
        for (Iterator<GoalSubset> it2 = subsets.iterator(); it2.hasNext(); ) {
            GoalSubset compare_next = it2.next();
            if (new_set.is_subset(compare_next, comparisons)) {
                can_be_added = false;
                break;
            }
            if (compare_next.is_subset(new_set, comparisons)) {
                it2.remove();
            }
        }
        if(can_be_added){
            subsets.add(new_set);
            System.out.println("Add new subset: " + new_set.toString());
        }
    }

    public void add_and_subset_minimal(GoalSubset new_set, List<Comparison> comparisons){

        boolean can_be_added = true;
        for (Iterator<GoalSubset> it2 = subsets.iterator(); it2.hasNext(); ) {
            GoalSubset compare_next = it2.next();
            if (compare_next.is_subset(new_set, comparisons)) {
                can_be_added = false;
                break;
            }
            if (new_set.is_subset(compare_next, comparisons)) {
                it2.remove();
            }
        }
        if(can_be_added){
            subsets.add(new_set);
            System.out.println("Add new subset: " + new_set.toString());
        }
    }

    public void make_subset_minimal(List<Comparison> comparisons){
        Set<GoalSubset> new_subsets = new HashSet<>();
        for (GoalSubset add_next : subsets) {
            boolean can_be_added = true;
            for (Iterator<GoalSubset> it2 = new_subsets.iterator(); it2.hasNext(); ) {
                GoalSubset compare_next = it2.next();
                if (compare_next.is_subset(add_next, comparisons)) {
                    can_be_added = false;
                    break;
                }
                if (add_next.is_subset(compare_next, comparisons)) {
                    it2.remove();
                }
            }
            if(can_be_added){
                new_subsets.add(add_next);
            }
        }
        subsets = new_subsets;
    }

//    public GoalSubsets complement() {
//        GoalSubsets complements = new GoalSubsets();
//
//        for (GoalSubset set : subsets) {
//            complements.add(set.complement());
//        }
//
//        return new GoalSubsets(complements);
//    }

    public GoalSubsets minus(GoalSubsets sets) {
        GoalSubsets resSet = new GoalSubsets();

        for (GoalSubset s1 : subsets) {
            if (!sets.contains(s1))
                resSet.add(s1);
        }

        return resSet;
    }

    public GoalSubsets crossProduct(GoalSubsets sets) {
        GoalSubsets productSet = new GoalSubsets();

        for (GoalSubset s1 : subsets) {
            for (GoalSubset s2 : sets.subsets) {
                productSet.add(s1.setUnion(s2));
            }
        }

        return productSet;
    }
//
//    public GoalSubsets minimalHittingSets() {
//        GoalSubsets hittingSet = new GoalSubsets();
//
//        Iterator<GoalSubset> it = subsets.iterator();
//
//        if (it.hasNext()) {
//            for (GoalSubset sing : it.next().singletonSubsets()) {
//                hittingSet.add(sing);
//            }
//
//            while (it.hasNext()) {
//                GoalSubset set = it.next();
//
//                GoalSubsets singletons = new GoalSubsets();
//                for (GoalSubset sing : set.singletonSubsets()) {
//                    singletons.add(sing);
//                }
//
//                hittingSet = hittingSet.crossProduct(singletons);
//                hittingSet.minimizeNonMinimalSubsets();
//            }
//        }
//
//        return hittingSet;
//    }
}

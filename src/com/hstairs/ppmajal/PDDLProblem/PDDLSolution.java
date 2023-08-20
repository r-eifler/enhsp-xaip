package com.hstairs.ppmajal.PDDLProblem;

import com.hstairs.ppmajal.transition.TransitionGround;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.math.BigDecimal;
import java.util.LinkedList;

public record PDDLSolution(LinkedList<ImmutablePair<BigDecimal, TransitionGround>> rawPlan, PDDLState lastState,
                           com.hstairs.ppmajal.search.SearchEngineClass.SearchStats stats, float gValueAtTheEnd){
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hstairs.ppmajal.pddl.heuristics.advanced;

import com.hstairs.ppmajal.problem.State;
import it.unimi.dsi.fastutil.ints.IntSet;

/**
 *
 * @author enrico
 */
abstract class LPInterface {

    protected final LM h;
    public LPInterface(LM h){
        this.h = h;
    }
    abstract public float solve(State s, IntSet lms);
}

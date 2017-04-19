/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heuristics.utils;

import conditions.Conditions;
import java.util.LinkedHashSet;
import problem.GroundAction;

/**
 *
 * @author enrico
 */
    public class achiever_set{
        public Float cost;
        public LinkedHashSet<GroundAction> actions;
        public LinkedHashSet<Conditions> target_cond;
        public achiever_set(){
            actions = new LinkedHashSet();
            target_cond = new LinkedHashSet();
        }
    }
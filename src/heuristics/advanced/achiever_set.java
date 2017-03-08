/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heuristics.advanced;

import java.util.LinkedHashSet;
import problem.GroundAction;

/**
 *
 * @author enrico
 */
    public class achiever_set{
        public Float cost;
        public LinkedHashSet<GroundAction> actions;
        public achiever_set(){
            actions = new LinkedHashSet();
        }
    }
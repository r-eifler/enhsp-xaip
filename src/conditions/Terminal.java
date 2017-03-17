/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conditions;

import java.util.ArrayList;
import problem.RelState;

/**
 *
 * @author enrico
 */
public abstract class Terminal extends Conditions {

    @Override
    public boolean isSatisfied(RelState rs, ArrayList<Integer> dist, int i) {
        int current_dist = dist.get(this.getCounter());
        if (current_dist < i) {
            return true;
        } else {
            if (this.can_be_true(rs)) {
                dist.set(this.getCounter(), i);
                return true;
            }
        }
        return false;
    }
    
}

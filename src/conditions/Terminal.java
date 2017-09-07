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
        } else if (this.can_be_true(rs)) {
            dist.set(this.getCounter(), i);
            return true;
        }
        return false;
    }

    @Override
    public Conditions introduce_red_constraints() {
        return this;
    }

}

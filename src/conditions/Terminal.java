/* 
 * Copyright (C) 2010-2017 Enrico Scala. Contact: enricos83@gmail.com.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
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

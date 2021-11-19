package problemGenerator;

import com.google.common.collect.Lists;
import com.hstairs.ppmajal.domain.PDDLDomain;
import com.hstairs.ppmajal.extraUtils.Utils;
import com.hstairs.ppmajal.problem.PDDLObjects;
import com.hstairs.ppmajal.problem.PDDLProblem;
import com.hstairs.ppmajal.problem.PDDLState;
import com.hstairs.ppmajal.problem.State;
import com.hstairs.ppmajal.transition.TransitionGround;
import enhsp2.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.management.RuntimeErrorException;


/* 
 * Copyright (C) 2015-2017, Enrico Scala, contact: enricos83@gmail.com
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
public class problemGen {

    public static void main(String[] args) throws Exception {

        if (args.length != 4) {
            System.out.println("Pass domain, problem, number of actions to be applied, name of the file where storing the new problem");
            return;
        }
        PDDLDomain d = new PDDLDomain(args[0]);
        PDDLProblem p = new PDDLProblem(args[1],d.constants,d.getTypes(),d,System.out,"internal",false,false,new BigDecimal(1.0),new BigDecimal(1.0));
        int chainLength = Integer.parseInt(args[2]);
        p.groundingActionProcessesConstraints();
        p.makeInit(false);
        State init = p.getInit();
        for (int i = 0; i < chainLength; i++) {
            init = generateNextRandmly(init, p);
            if (init == null){
                throw new RuntimeException("There is no plan of length >="+chainLength);
            }
        }
        
        PDDLObjects pObjs = new PDDLObjects();
        for (var o: p.getObjects()){
            if (!d.constants.contains(o)){
                pObjs.add(o);
            }
        }
        p.setObjects(pObjs);
        
        Utils.saveProblem(p, (PDDLState) init, args[3]);
    }

    public static State generateNextRandmly(State init, PDDLProblem p) {
        ArrayList<TransitionGround> actions = Lists.newArrayList(p.actions);

        Collections.shuffle(Lists.newArrayList(p.actions));

        for (var a : actions) {
            if (a.isApplicable(init)) {
                System.out.println(a);
                init.apply(a, init);
                return init;
            }
        }
        return null;
    }
}

/*
 * Copyright (C) 2017 Enrico Scala.
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
package com.hstairs.ppmajal.conditions;

import com.google.common.collect.Sets;
import com.hstairs.ppmajal.domain.Variable;
import com.hstairs.ppmajal.expressions.NumEffect;
import com.hstairs.ppmajal.expressions.NumFluent;
import com.hstairs.ppmajal.problem.EPddlProblem;
import com.hstairs.ppmajal.problem.PDDLObjects;
import it.unimi.dsi.fastutil.objects.ReferenceLinkedOpenHashSet;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Enrico Scala
 */
public abstract class ComplexCondition extends Condition {
    public ReferenceLinkedOpenHashSet sons; //used by formula conditions as AndCond and OrCond. Each son is another condition involved in the formula

    public ComplexCondition ( ) {
        sons = new ReferenceLinkedOpenHashSet();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.sons);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ComplexCondition other = (ComplexCondition) obj;
        if (!Objects.equals(this.sons, other.sons)) {
            return false;
        }
        return true;
    }


    @Override
    public final Collection<Predicate> getInvolvedPredicates ( ) {
        Collection<Predicate> ret = new LinkedHashSet();
        //from here it can only be an AndCond or a Or. Other cases are not instance of this
        if (this.sons != null) {
            for (Object c : this.sons) {
                if (c instanceof Condition) {
                    ret.addAll(((Condition) c).getInvolvedPredicates());
                }
            }
        }
        return ret;
    }

    public Condition unifyVariablesReferences (EPddlProblem p) {
        ReferenceLinkedOpenHashSet ret = new ReferenceLinkedOpenHashSet();
        for (Object c : this.sons) {
            if (c instanceof NumEffect) {
                NumEffect neff = (NumEffect) c;
                ret.add(neff.unifyVariablesReferences(p));
            } else {
                Condition cond = (Condition) c;
                ret.add(cond.unifyVariablesReferences(p));
            }
        }
        this.sons = ret;
        return this;
    }

    public final void addConditions (Condition c) {
        if ((this instanceof AndCond) && (c instanceof AndCond)) {
            sons.addAll(((AndCond) c).sons);
        } else if ((this instanceof OrCond) && (c instanceof OrCond)) {
            sons.addAll(((OrCond) c).sons);
        } else
            sons.add(c);
    }

//    /**
//     * @param substitution
//     */
//    @Override
//    public void changeVar (Map substitution) {
//        for (Object o : sons) {
//            if (o instanceof NumEffect) {
//                NumEffect el = (NumEffect) o;
//                el.changeVar(substitution);
//            } else {
//                Condition el = (Condition) o;
//                el.changeVar(substitution);
//            }
//        }
//    }

    @Override
    public void extendTerms (Variable v) {
        if (this.sons == null) {
            return;
        }
        for (Condition c : (Collection<Condition>) sons) {
            c.extendTerms(v);
        }
    }

    @Override
    public Set<NumFluent> getInvolvedFluents ( ) {
        Set<NumFluent> ret = new HashSet();
        if (this.sons != null) {
            for (Object o : this.sons) {
                if (o instanceof NumFluent) {
                    ret.add((NumFluent) o);
                } else if (o instanceof Condition) {
                    Condition c = (Condition) o;
                    if (c.getInvolvedFluents() != null) {
                        ret.addAll(c.getInvolvedFluents());
                    }
                } else if (o instanceof NumEffect) {
                    NumEffect c = (NumEffect) o;
                    if (c.getInvolvedFluents() != null) {
                        ret.addAll(c.getInvolvedFluents());
                    }
                } else {
                    System.out.println("Error in getting involved fluents");
                }
            }
        }
        return ret;
    }


    @Override
    public Set<Condition> getTerminalConditions ( ) {
        Set ret;
        if (this.sons == null) {
            return new LinkedHashSet();
        }
        ret = Sets.newLinkedHashSetWithExpectedSize(this.sons.size());
        for (Condition c : (Collection<Condition>) this.sons) {
            ret.addAll(c.getTerminalConditions());
        }
        return ret;
    }


    @Override
    public List<Condition> getTerminalConditionsInArray ( ) {
        ArrayList ret = new ArrayList();
        if (this.sons == null) {
            return Collections.emptyList();
        }
        for (Condition c : (Collection<Condition>) this.sons) {
            ret.addAll(c.getTerminalConditionsInArray());
        }
        return ret;
    }

    @Override
    public Condition ground (Map substitution, int c) {
        Condition ret = this.ground(substitution, null);
        ret.setHeuristicId(c);
        return ret;
    }

    @Override
    public Condition ground (Map<Variable, PDDLObject> substitution, PDDLObjects po) {
        AndCond ret = new AndCond();
        //System.out.println(this.toString());
        for (Object o : sons) {
            final Object groundedO;
            if (o instanceof NumEffect) {
                NumEffect el = (NumEffect) o;
                groundedO = el.ground(substitution, po);
            } else {
                Condition el = (Condition) o;
                //System.out.println(el);
                groundedO = el.ground(substitution, po);
            }
            if (groundedO instanceof AndCond) {
                ret.sons.addAll(((AndCond) groundedO).sons);
            } else {
                ret.sons.add(groundedO);
            }
        }
        ret.grounded = true;
        return ret;
    }


    /**
     * @return the freeVarSemantic
     */
    public boolean isFreeVarSemantic ( ) {
        return freeVarSemantic;
    }

//    /**
//     *
//     * @return 
//     */
//    @Override
//    public Condition normalize ( ) {
//        Iterator it = sons.iterator();
//        Collection<AndCond> toAdd = new LinkedHashSet();
//        while (it.hasNext()) {
//            Object o = it.next();
//            if (o instanceof Comparison) {
//                Comparison comp = (Comparison) o;
//                try {
//                    comp = comp.normalizeAndCopy();
//                } catch (Exception ex) {
//                    Logger.getLogger(AndCond.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                toAdd.add(comp);
//            } else if (o instanceof AndCond) {
//                AndCond temp = (AndCond) o;
//                temp.normalize();
//                toAdd.add(temp);
//                it.remove();
//            } else if (o instanceof NotCond) {
//                NotCond temp = (NotCond) o;
//                temp.normalize();
//            } else if (o instanceof OrCond) {
//                OrCond temp = (OrCond) o;
//                temp.normalize();
//            }
//        }
//        
//        return this;
//    }


    protected void sonHasIncorrectType (Object son) {
        System.out.println("Effect " + son + " is not valid. Its class is" + son.getClass() + ".  Please revise your action model.");
        System.exit(-1);
    }

    @Override
    public void storeInvolvedVariables (Collection<Variable> vars) {
        if (this.sons != null) {
            for (Object o : this.sons) {
                if (o instanceof Condition) {
                    Condition c = (Condition) o;
                    c.storeInvolvedVariables(vars);
                } else if (o instanceof NumEffect) {
                    NumEffect c = (NumEffect) o;
                    if (c.getInvolvedVariables() != null) {
                        c.storeInvolvedVariables(vars);
                    }
                } else {
                    System.out.println("Error in getting involved variables");
                }
            }
        }
    }

    @Override
    public Condition unGround (Map substitution) {
        AndCond ret = new AndCond();
        for (Object o : sons) {
            if (o instanceof NumEffect) {
                NumEffect el = (NumEffect) o;
                ret.sons.add(el.unGround(substitution));
            } else {
                Condition el = (Condition) o;
                //System.out.println(el);
                ret.sons.add(el.unGround(substitution));
            }
        }
        ret.grounded = false;
        return ret;
    }

    @Override
    public boolean involve (Condition c) {
        for (Condition c1 : (Collection<Condition>) this.sons) {
            if (c1.involve(c)) {
                return true;
            }
        }
        return false;
    }


}

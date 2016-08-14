/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heuristics.advanced;

import conditions.Comparison;
import conditions.Conditions;
import conditions.Predicate;
import heuristics.Heuristic;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import problem.GroundAction;
import problem.State;

/**
 *
 * @author enrico
 */
public class landmarks_factory extends Heuristic {

    public HashMap<Conditions, Set<Conditions>> landmark_of;
    public HashMap<GroundAction, Set<Conditions>> action_landmark_of;

    public HashMap<Conditions, Integer> condition_level;
    public HashMap<GroundAction, Integer> action_level;
    public HashMap<Conditions, Integer> dplus;
    private LinkedHashSet<GroundAction> reacheable_at_this_stage;

    public landmarks_factory(Conditions goal, Set<GroundAction> A) {
        super(goal, A);
        this.build_integer_representation();
    }

    public void init_data_structures(State s_0) {
        landmark_of = new HashMap();
        action_landmark_of = new HashMap();
        condition_level = new HashMap();
        action_level = new HashMap();
        dplus = new HashMap();
        reacheable_at_this_stage = new LinkedHashSet();

        all_conditions.stream().forEach((c) -> {
            Set<Conditions> lms = new LinkedHashSet();
            lms.add(c);
            landmark_of.put(c, lms);
        });
        all_conditions.stream().forEach((c) -> {
            if (c.isSatisfied(s_0)) {
                condition_level.put(c, 0);
                dplus.put(c, 0);
            } else {
                condition_level.put(c, Integer.MAX_VALUE);
                dplus.put(c, Integer.MAX_VALUE);
            }
        });
        reachable.stream().forEach((gr) -> {
            if (gr.isApplicable(s_0)) {
                action_level.put(gr, 0);
                this.reacheable_at_this_stage.add(gr);
                if (gr.getPreconditions() != null && !gr.getPreconditions().sons.isEmpty()) {
                    Set<Conditions> lms = new LinkedHashSet();
                    for (Conditions c : (Collection<Conditions>) gr.getPreconditions().sons) {
                        lms.add(c);
                    }
                    action_landmark_of.put(gr, lms);
                } else {
                    action_landmark_of.put(gr, new LinkedHashSet<Conditions>());
                }

            } else {
                action_level.put(gr, Integer.MAX_VALUE);
                action_landmark_of.put(gr, new LinkedHashSet<Conditions>());
            }
        });
    }

    @Override
    public Float setup(State s_0) {
        //generate basic structures for landmarks

        reachable.addAll(A);
        Float ret = compute_estimate(s_0);//reachability analysis
        reachable = new LinkedHashSet();
        reachable.addAll(reacheable_at_this_stage);
        return ret;
    }

    @Override
    public Float compute_estimate(State s_0) {
        this.init_data_structures(s_0);

        boolean update;
        Set<GroundAction> actions_to_consider = new LinkedHashSet();
        actions_to_consider.addAll(reachable);
        do {
            update = false;
            for (Conditions c : all_conditions) {
                int l = condition_level.get(c);
                int old_dplus = dplus.get(c);
                Set<GroundAction> ach_of_conditions = new LinkedHashSet();
                if (c instanceof Predicate) {
                    Predicate p = (Predicate) c;
                    reacheable_at_this_stage.stream().filter((gr) -> (gr.achieve(p))).map((gr) -> {
                        dplus.put(c, Math.min(1, dplus.get(c)));
                        condition_level.put(p, Math.min(action_level.get(gr) + 1, condition_level.get(p)));
                        return gr;
                    }).forEach((gr) -> {
                        ach_of_conditions.add(gr);
                    });
                } else if (c instanceof Comparison) {
                    Comparison cmp = (Comparison) c;
                    reacheable_at_this_stage.stream().forEach((gr) -> {
                        Float repetition_needed = gr.getNumberOfExecutionInt(s_0, cmp);
                        if (repetition_needed != Float.MAX_VALUE) {
                            dplus.put(c, Math.min(repetition_needed.intValue(), dplus.get(c)));
                            condition_level.put(cmp, Math.min((action_level.get(gr) + 1), condition_level.get(cmp)));
                            ach_of_conditions.add(gr);
                        }
                    });
                }
                if (update_landmarks(c, ach_of_conditions) || l != condition_level.get(c) || dplus.get(c) != old_dplus) {
                    update = true;
                }
            }
            if (update) {
                Iterator<GroundAction> it = actions_to_consider.iterator();
                while (it.hasNext()) {
                    GroundAction gr = it.next();
                    if (gr.getPreconditions() != null && !gr.getPreconditions().sons.isEmpty()) {
                        int max = Integer.MIN_VALUE;
                        boolean activated = true;
                        Set<Conditions> candidate = new LinkedHashSet();
                        for (Conditions c : (Collection<Conditions>) gr.getPreconditions().sons) {
                            if (condition_level.get(c) != Integer.MAX_VALUE) {
                                max = Math.max(max, condition_level.get(c));
                                candidate.addAll(landmark_of.get(c));
                            } else {
                                activated = false;
                                break;
                            }
                        }
                        if (activated) {
                            action_level.put(gr, max);
                            reacheable_at_this_stage.add(gr);
                            action_landmark_of.put(gr, candidate);
                            it.remove();
                        }

                    }
                }
            }

        } while (update);

        Set<Conditions> goal_landmark = new LinkedHashSet();
        for (Conditions c : (Collection<Conditions>) this.G.sons) {
            if (condition_level.get(c) == Integer.MAX_VALUE) {
                return Float.MAX_VALUE;
            }
            goal_landmark.addAll(landmark_of.get(c));
        }

        float estimate = 0;
        for (Conditions c : goal_landmark) {
//            if (!c.isSatisfied(s_0)) {
                estimate += dplus.get(c);
//            }
        }

        return estimate;
    }

    private boolean update_landmarks(Conditions c, Set<GroundAction> achievers) {
        if (achievers.isEmpty()) {
            return false;
        }
        Set<Conditions> previous = this.landmark_of.get(c);

        Set<Conditions> intersection = null;
        for (GroundAction gr : achievers) {
            if (intersection == null) {
                intersection = new LinkedHashSet();
                intersection.addAll(action_landmark_of.get(gr));
            } else {
                Set<Conditions> new_set = action_landmark_of.get(gr);
                intersection.retainAll(new_set);
            }
        }
        intersection.add(c);

        if (previous == null || !previous.equals(intersection)) {
            this.landmark_of.put(c, intersection);
            return true;
        } else {
            return false;
        }
    }
}

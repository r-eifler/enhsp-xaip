package com.hstairs.ppmajal.transition;

import com.google.common.collect.Sets;
import com.hstairs.ppmajal.conditions.AndCond;
import com.hstairs.ppmajal.conditions.Condition;
import com.hstairs.ppmajal.conditions.ConditionalEffect;
import com.hstairs.ppmajal.conditions.PDDLObject;
import com.hstairs.ppmajal.conditions.Predicate;
import com.hstairs.ppmajal.expressions.ExtendedAddendum;
import com.hstairs.ppmajal.expressions.ExtendedNormExpression;
import com.hstairs.ppmajal.expressions.NumEffect;
import com.hstairs.ppmajal.expressions.NumFluent;
import com.hstairs.ppmajal.problem.Metric;
import com.hstairs.ppmajal.problem.PDDLState;
import com.hstairs.ppmajal.problem.State;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


public class TransitionGround extends Transition {
    final protected List<PDDLObject> parameters;
    private ArrayList sdac;

    public TransitionGround(List<PDDLObject> parameters, String name, ConditionalEffects conditionalPropositionalEffects, ConditionalEffects conditionalNumericEffects, Condition preconditions, Semantics semantcis) {
        super(name, conditionalPropositionalEffects, conditionalNumericEffects, preconditions, semantcis);
        this.parameters = parameters;
    }

    public TransitionGround(ArrayList<NumEffect> numEffect) {
        this(null,
                "waiting",
                new ConditionalEffects(ConditionalEffects.VariableType.PROPEFFECT),
                new ConditionalEffects(ConditionalEffects.VariableType.NUMEFFECT),
                null, Transition.Semantics.PROCESS);
        this.getConditionalNumericEffects().forceUnconditionalEffect(numEffect);
    }

    public List<PDDLObject> getParameters() {
        return parameters;
    }

    public boolean isApplicable(State s) {
        return (this.preconditions.isSatisfied(s));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 15 * hash + Objects.hashCode(this.name);
        hash = 19 * hash + Objects.hashCode(this.parameters);
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
        final TransitionGround other = (TransitionGround) obj;
        if (!Objects.equals(this.parameters, other.parameters)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder res= new StringBuilder();
        res.append("(").append(name);
        if (this.parameters != null) {
            for (final PDDLObject obj : this.parameters) {
                res.append(" ").append(obj.getName());
            }
        }
        res.append(")");
        return res.toString();
    }
    
    public String toStringAllModel() {
        StringBuilder res= new StringBuilder();
        res.append("(").append(name);
        if (this.parameters != null) {
            for (final PDDLObject obj : this.parameters) {
                res.append(" ").append(obj.getName());
            }
        }
        res.append("Precondition");
        res.append(this.getPreconditions());
        res.append("numeric effect");
        res.append(this.conditionalNumericEffects);
        res.append("propositional effect");
        res.append(this.conditionalPropositionalEffects);
        res.append(")");
        return res.toString();
    }

    private Float getExprImpact(PDDLState s_0, NumEffect nEff, NumFluent f) {
        if (nEff.getFluentAffected().equals(f)) {
            ExtendedNormExpression right = (ExtendedNormExpression) nEff.getRight();
            if (nEff.getOperator().equals("increase")) {
                return right.eval_apart_from_f(f, s_0);
            } else if (nEff.getOperator().equals("decrease")) {
                return right.eval_apart_from_f(f, s_0) * -1.0f;

            }
            return right.eval_apart_from_f(f, s_0);
        } else {
            return 0f;
        }
    }
    
    private List<Pair<Condition, Float>> getSdac(PDDLState init, Metric metric) {
        return getSdac(init,metric,false);
    }
    private List<Pair<Condition, Float>> getSdac(PDDLState init, Metric metric, boolean sdacEnabled) {
        if (this.sdac == null) {
            this.sdac = new ArrayList<>();
            if (metric != null && metric.getMetExpr() != null) {
                if (!sdacEnabled){
                    ExtendedNormExpression expr = (ExtendedNormExpression) metric.getMetExpr();
                    //first numeric effect normal
                    Float exprImpact = 0f;
                    for (NumEffect effNum :  this.getConditionalNumericEffects().getAllEffects()) {
                        for (ExtendedAddendum ad : expr.summations) {
                            if (ad.f != null) {
                                exprImpact += ad.n.floatValue() * this.getExprImpact(init, effNum, ad.f);
                            }
                        }
                    }

                    if ((exprImpact < 0 && metric.getOptimization().equals("maximize"))
                            || (exprImpact > 0 && metric.getOptimization().equals("minimize"))) {
                        Predicate truePredicate = Predicate.createPredicate(Predicate.trueFalse.TRUE);
                        this.sdac.add(Pair.of(truePredicate, exprImpact));
                    }
                }else{
                    final ConditionalEffects<NumEffect> conditionalNumericEffects1 = this.getConditionalNumericEffects();
                    final Map<Condition, Collection<NumEffect>> actualConditionalEffects = conditionalNumericEffects1.getActualConditionalEffects();
                    for (Map.Entry<Condition,Collection<NumEffect>> ele: actualConditionalEffects.entrySet()) {
                        final ExtendedNormExpression expr = (ExtendedNormExpression) metric.getMetExpr();
                        Float exprImpact = 0f;
                        for (NumEffect effNum :  ele.getValue()) {
                            for (ExtendedAddendum ad : expr.summations) {
                                if (ad.f != null) {
                                    exprImpact += ad.n.floatValue() * this.getExprImpact(init, effNum, ad.f);
                                }
                            }
                        }
                        
                        if ((exprImpact < 0 && metric.getOptimization().equals("maximize"))
                                || (exprImpact > 0 && metric.getOptimization().equals("minimize"))) {
                            this.sdac.add(Pair.of(ele.getKey(), exprImpact));
                        }
                    }
                    final ExtendedNormExpression expr = (ExtendedNormExpression) metric.getMetExpr();
                    Float exprImpact = 0f;
                    for (NumEffect effNum :  conditionalNumericEffects1.getUnconditionalEffect()) {
                        for (ExtendedAddendum ad : expr.summations) {
                            if (ad.f != null) {
                                exprImpact += ad.n.floatValue() * this.getExprImpact(init, effNum, ad.f);
                            }
                        }
                    }

                    if ((exprImpact < 0 && metric.getOptimization().equals("maximize"))
                            || (exprImpact > 0 && metric.getOptimization().equals("minimize"))) {
                        this.sdac.add(Pair.of(Predicate.createPredicate(Predicate.trueFalse.TRUE), exprImpact));
                    }
                    
                }
            }
        }
        return this.sdac;
    }
    public Float getActionCost(State s, Metric m){
        return getActionCost(s, m, false);
    }
    public Float getActionCost(State s, Metric m, boolean sdac){
        if (m == null || m.getMetExpr() == null ){
            return 1f;
        }
//        List<Pair<Condition, Float>> sdac1 = this.getSdac((PDDLState) s, m);
//        if (sdac1 == null){
//            return 1f;
//        }

        List<Pair<Condition, Float>> sdac1 = this.getSdac((PDDLState) s, m, sdac);
        float impact = 0f;
        for (Pair<Condition,Float> ele : sdac1){
            if (ele.getLeft().isSatisfied(s)){
                impact+=ele.getRight();
            }
        }
        return impact;
    }


    public static TransitionGround waitingAction() {
       return new TransitionGround(null,null,null,null,null,null);
    }
    public boolean isWaiting(){
        return parameters == null;
    }

    public Map<Condition, Collection> getAllConditionalEffects() {
        final Map<Condition, Collection> allConditionalNumericEffects = this.conditionalNumericEffects.getAllConditionalEffects();
        final Map<Condition, Collection> allConditionaPropositionalEffects = this.conditionalPropositionalEffects.getAllConditionalEffects();

        final Set<Condition> keySet = allConditionaPropositionalEffects.keySet();
        final Set<Condition> keySet1 = allConditionalNumericEffects.keySet();
        final Sets.SetView<Condition> union = Sets.union(keySet, keySet1);
        final Map ret = new HashMap();
        for (final Condition c : union) {
            final Collection ele = new HashSet();
            Collection get = allConditionaPropositionalEffects.get(c);
            if (get != null) {
                ele.addAll(get);
            }
            get = allConditionalNumericEffects.get(c);
            if (get != null) {
                ele.addAll(get);
            }
            ret.put(c, ele);

        }

        return ret;
    }
}

package com.hstairs.ppmajal.transition;

import com.hstairs.ppmajal.conditions.Condition;
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
import java.util.List;
import java.util.Objects;


public class TransitionGround extends Transition {
    final protected List<PDDLObject> parameters;
    private ArrayList sdac;

    public TransitionGround(List<PDDLObject> parameters, String name, ConditionalEffects conditionalPropositionalEffects, ConditionalEffects conditionalNumericEffects, Condition preconditions, Semantics semantcis) {
        super(name, conditionalPropositionalEffects, conditionalNumericEffects, preconditions, semantcis);
        this.parameters = parameters;
    }

    public TransitionGround(ArrayList<NumEffect> numEffect) {
        this(new ArrayList<>(),
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
        if (this.sdac == null) {
            this.sdac = new ArrayList<>();
            if (metric != null && metric.getMetExpr() != null) {

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
//                for (ConditionalEffect cond : (Collection<ConditionalEffect>) this.cond_effects.sons) {
//                    AndCond effect = (AndCond) cond.effect;
//                    exprImpact = 0f;
//                    for (Object innerCondition : (Collection<Object>) effect.sons) {
//                        if (innerCondition instanceof NumEffect) {
//                            NumEffect effNum = (NumEffect) innerCondition;
//                            for (ExtendedAddendum ad : expr.summations) {
//                                if (ad.f != null) {
//                                    exprImpact += ad.n.floatValue() * this.getExprImpact(init, effNum, ad.f);
//                                }
//                            }
//                        }
//                    }
//                    if ((exprImpact < 0 && metric.getOptimization().equals("maximize"))
//                            || (exprImpact > 0 && metric.getOptimization().equals("minimize"))) {
//                        this.sdac.add(Pair.of(cond.activation_condition, exprImpact));
//                    }
//                }

            }
        }
        return this.sdac;
    }
    public Float getActionCost(State s, Metric m){
        if (m == null || m.getMetExpr() == null ){
            return 1f;
        }
//        List<Pair<Condition, Float>> sdac1 = this.getSdac((PDDLState) s, m);
//        if (sdac1 == null){
//            return 1f;
//        }

        List<Pair<Condition, Float>> sdac1 = this.getSdac((PDDLState) s, m);
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
        return parameters==null;
    }
}

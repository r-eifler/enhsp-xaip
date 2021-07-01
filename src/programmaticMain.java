
import com.google.common.collect.Sets;
import com.hstairs.ppmajal.conditions.AndCond;
import com.hstairs.ppmajal.conditions.Comparison;
import static com.hstairs.ppmajal.conditions.Comparison.comparison;
import com.hstairs.ppmajal.conditions.PDDLObject;
import static com.hstairs.ppmajal.conditions.PDDLObject.object;
import com.hstairs.ppmajal.conditions.Predicate;
import com.hstairs.ppmajal.domain.PddlDomain;
import com.hstairs.ppmajal.domain.SchemaParameters;
import com.hstairs.ppmajal.domain.Type;
import com.hstairs.ppmajal.domain.Variable;
import com.hstairs.ppmajal.pddl.heuristics.advanced.H1;
import com.hstairs.ppmajal.problem.EPddlProblem;
import com.hstairs.ppmajal.problem.PDDLSearchEngine;
import com.hstairs.ppmajal.transition.ConditionalEffects;
import static com.hstairs.ppmajal.transition.ConditionalEffects.stripsEffects;
import com.hstairs.ppmajal.transition.Transition;
import static com.hstairs.ppmajal.transition.Transition.Semantics.ACTION;
import com.hstairs.ppmajal.transition.TransitionGround;
import com.hstairs.ppmajal.transition.TransitionSchema;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import org.apache.commons.lang3.tuple.Pair;
import static com.hstairs.ppmajal.conditions.Predicate.BoolFluent;
import static com.hstairs.ppmajal.conditions.Predicate.getPredicate;
import static com.hstairs.ppmajal.domain.Type.type;
import static com.hstairs.ppmajal.domain.Variable.variable;
import com.hstairs.ppmajal.expressions.NumEffect;
import com.hstairs.ppmajal.expressions.NumFluent;
import com.hstairs.ppmajal.expressions.PDDLNumber;
import static com.hstairs.ppmajal.expressions.NumFluent.numericFluent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author enrico
 */
public class programmaticMain {

    public static void fullGroundProblem() throws Exception {
        PddlDomain pddlDomain = new PddlDomain();

        //add predicates
        pddlDomain.addPredicate("a", null);
        pddlDomain.addPredicate("b", null);

        EPddlProblem problem = new EPddlProblem(pddlDomain, "internal", System.out, false);

        //Define transition
        ConditionalEffects<Predicate> effects = new ConditionalEffects<>();
        effects.add(Predicate.getPredicate("a", null));
        TransitionGround action = new TransitionGround(
                "hello", ACTION, null, null,
                effects,
                new ConditionalEffects());
        problem.actions.add(action);
        TransitionGround action2 = new TransitionGround(
                "world", ACTION, null,
                Predicate.getPredicate("a", null),
                stripsEffects(Arrays.asList(Predicate.getPredicate("b", null))),
                new ConditionalEffects());
        problem.actions.add(action2);

        //init
        //goal
        problem.setGoals(new AndCond(Sets.newHashSet(Predicate.getPredicate("b", null))));

        problem.prettyPrint();
        problem.prepareForSearch(true);

        final PDDLSearchEngine searchEngine = new PDDLSearchEngine(problem, new H1(problem)); //manager of the search strategies
        LinkedList<Pair<BigDecimal, Object>> plan = searchEngine.WAStar();
        System.out.println(plan);

    }

    public static void fullSchemaProblem() throws Exception {
        PddlDomain pddlDomain = new PddlDomain();

        //add predicates
        pddlDomain.addPredicate("a", new ArrayList());
        pddlDomain.addPredicate("b", new ArrayList());
        pddlDomain.addType(Type.type("Person"));

        EPddlProblem problem = new EPddlProblem(pddlDomain, "internal", System.out, false);
        problem.objects.add(PDDLObject.object("Enrico", Type.type("Person")));

        //Define Actions
        ConditionalEffects<Predicate> effects = new ConditionalEffects<>();
        effects.add(BoolFluent("a"));
        SchemaParameters par = new SchemaParameters();
        par.add(Variable.variable("x", Type.type("Person")));
        TransitionSchema action = new TransitionSchema("hello", Transition.Semantics.ACTION, par, null,
                effects,
                new ConditionalEffects());
        pddlDomain.addAction(action);
        TransitionSchema action2 = new TransitionSchema("world", ACTION, null,
                BoolFluent("a"),
                stripsEffects(Arrays.asList(BoolFluent("b"))),
                new ConditionalEffects());
        pddlDomain.addAction(action2);

        //init
         /*In this case it is empty, meaning all variables are false by CWA*/
        
        //goal
        problem.setGoals(BoolFluent("b"));

        problem.prepareForSearch(); /* This is very necessary prior to any planning*/

        final PDDLSearchEngine searchEngine = new PDDLSearchEngine(problem, new H1(problem)); //manager of the search strategies
        LinkedList<Pair<BigDecimal, Object>> plan = searchEngine.WAStar();
        System.out.println(plan);

    }

    public static void fullSchemaNumericProblem() throws Exception {
        PddlDomain pddlDomain = new PddlDomain();

        //add predicates
        pddlDomain.addFunction("a", new ArrayList());
        
        pddlDomain.addType(type("Person"));

        EPddlProblem problem = new EPddlProblem(pddlDomain, "internal", System.out, false);
        problem.objects.add(object("Enrico", type("Person")));

        //Define Actions
        ConditionalEffects<NumEffect> effects = new ConditionalEffects<>();
        
        effects.add(new NumEffect("increase",numericFluent("a"),new PDDLNumber(1)));
        
        SchemaParameters par = new SchemaParameters();
        par.add(variable("x", type("Person")));
        
        pddlDomain.addAction(new TransitionSchema("hello", Transition.Semantics.ACTION, par, null,
                new ConditionalEffects(),
                effects));
        

        //init
        problem.addNumValue(numericFluent("a"), 0);
         /*In this case it is empty, meaning all variables are false by CWA*/
        
        //goal
        problem.setGoals(comparison(">=", numericFluent("a"), new PDDLNumber(100),false));

        problem.prepareForSearch(); /* This is very necessary prior to any planning*/

        final PDDLSearchEngine searchEngine = new PDDLSearchEngine(problem, new H1(problem)); //manager of the search strategies
        
        LinkedList<Pair<BigDecimal, Object>> plan = searchEngine.WAStar();
        System.out.println(plan);

    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        fullSchemaProblem();
        fullSchemaNumericProblem();
    }

}

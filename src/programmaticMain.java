
import com.google.common.collect.Sets;
import com.hstairs.ppmajal.conditions.AndCond;
import static com.hstairs.ppmajal.conditions.Comparison.comparison;
import com.hstairs.ppmajal.conditions.PDDLObject;
import static com.hstairs.ppmajal.conditions.PDDLObject.object;
import com.hstairs.ppmajal.conditions.Predicate;
import com.hstairs.ppmajal.domain.PDDLDomain;
import com.hstairs.ppmajal.domain.SchemaParameters;
import com.hstairs.ppmajal.domain.Type;
import com.hstairs.ppmajal.domain.Variable;
import com.hstairs.ppmajal.pddl.heuristics.advanced.H1;
import com.hstairs.ppmajal.problem.PDDLProblem;
import com.hstairs.ppmajal.problem.PDDLSearchEngine;
import com.hstairs.ppmajal.transition.ConditionalEffects;
import static com.hstairs.ppmajal.transition.ConditionalEffects.stripsEffects;
import com.hstairs.ppmajal.transition.Transition;
import static com.hstairs.ppmajal.transition.Transition.Semantics.ACTION;
import com.hstairs.ppmajal.transition.TransitionSchema;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import org.apache.commons.lang3.tuple.Pair;
import static com.hstairs.ppmajal.conditions.Predicate.BoolFluent;
import static com.hstairs.ppmajal.domain.SchemaParameters.createPar;
import static com.hstairs.ppmajal.domain.Type.type;
import static com.hstairs.ppmajal.domain.Variable.variable;
import com.hstairs.ppmajal.expressions.NumEffect;
import static com.hstairs.ppmajal.expressions.NumEffect.easyNumEffect;
import com.hstairs.ppmajal.expressions.PDDLNumber;
import static com.hstairs.ppmajal.expressions.NumFluent.numericFluent;
import static com.hstairs.ppmajal.transition.ConditionalEffects.numEffects;

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
        PDDLDomain pddlDomain = new PDDLDomain();

        //add predicates
        pddlDomain.addPredicate("a", null);
        pddlDomain.addPredicate("b", null);

        PDDLProblem problem = new PDDLProblem(pddlDomain, "internal", System.out, false, false);

        //Define transition
        ConditionalEffects<Predicate> effects = new ConditionalEffects<>();
        effects.add(Predicate.getPredicate("a", null));
        TransitionSchema action = new TransitionSchema(
                "hello", ACTION, null, null,
                effects,
                new ConditionalEffects());
        TransitionSchema action2 = new TransitionSchema(
                "world", ACTION, null,
                Predicate.getPredicate("a", null),
                stripsEffects(Predicate.getPredicate("b", null)),
                new ConditionalEffects());
        pddlDomain.addAction(action);
        pddlDomain.addAction(action2);

        //init
        //problem.addFactValue(Predicate.getPredicate("c",null), true);
        //goal
        problem.setGoals(new AndCond(Sets.newHashSet(Predicate.getPredicate("b", null))));

        problem.prettyPrint();
        pddlDomain.saveDomain("/tmp/d.pddl");
        problem.saveProblem("/tmp/p0.pddl");
        problem.prepareForSearch(true);
        problem.saveProblem("/tmp/p1.pddl");

        final PDDLSearchEngine searchEngine = new PDDLSearchEngine(problem, new H1(problem)); //manager of the search strategies
        LinkedList<Pair<BigDecimal, Object>> plan = searchEngine.WAStar();
        System.out.println(plan);

    }

    public static void fullSchemaProblem() throws Exception {
        PDDLDomain pddlDomain = new PDDLDomain();

        //add predicates
        pddlDomain.addPredicate("a", new ArrayList());
        pddlDomain.addPredicate("b", new ArrayList());
        pddlDomain.addType(Type.type("Person"));

        PDDLProblem problem = new PDDLProblem(pddlDomain, "internal", System.out, false, false);
        problem.getObjects().add(PDDLObject.object("Enrico", Type.type("Person")));

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
                stripsEffects(BoolFluent("b")),
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
        PDDLDomain pddlDomain = new PDDLDomain();

        //add types
        pddlDomain.addType(type("Person"));
        
        //add predicates
        pddlDomain.addFunction("a", new ArrayList());
        

        PDDLProblem problem = new PDDLProblem(pddlDomain, "internal", System.out, false, false);
        problem.getObjects().add(object("Enrico", type("Person")));

        //Define Actions
        ConditionalEffects<NumEffect> effects = new ConditionalEffects<>();
        
        effects.add(new NumEffect("increase",numericFluent("a"),new PDDLNumber(1)));

        pddlDomain.addAction(new TransitionSchema("hello", Transition.Semantics.ACTION, createPar(variable("x", type("Person"))), null,
                new ConditionalEffects(),
                numEffects(easyNumEffect("increase",numericFluent("a"),15))));
       
        //init
        problem.addNumValue(numericFluent("a"), 0);
        
        //goal
        problem.setGoals(comparison(">=", numericFluent("a"), new PDDLNumber(100),false));

        //After this everything is destroyed and need to be recreated (actions, processes, events, facts)
        problem.prepareForSearch(); /* This is very necessary prior to any planning*/
        

        PDDLSearchEngine searchEngine = new PDDLSearchEngine(problem, new H1(problem)); //manager of the search strategies
        
        LinkedList<Pair<BigDecimal, Object>> plan = searchEngine.WAStar();
        System.out.println(plan);
        System.out.println(plan.size());

    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
         fullGroundProblem();
        
    }

}


import com.google.common.collect.Sets;
import com.hstairs.ppmajal.conditions.AndCond;
import com.hstairs.ppmajal.conditions.PDDLObject;
import com.hstairs.ppmajal.conditions.Predicate;
import com.hstairs.ppmajal.domain.PddlDomain;
import com.hstairs.ppmajal.domain.SchemaParameters;
import com.hstairs.ppmajal.domain.Type;
import com.hstairs.ppmajal.domain.Variable;
import com.hstairs.ppmajal.pddl.heuristics.advanced.H1;
import com.hstairs.ppmajal.problem.EPddlProblem;
import com.hstairs.ppmajal.problem.PDDLSearchEngine;
import com.hstairs.ppmajal.transition.ConditionalEffects;
import com.hstairs.ppmajal.transition.Transition;
import com.hstairs.ppmajal.transition.TransitionGround;
import com.hstairs.ppmajal.transition.TransitionSchema;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import org.apache.commons.lang3.tuple.Pair;

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

    
    public static void fullGroundProblem() throws Exception{
        PddlDomain pddlDomain = new PddlDomain();
        
        //add predicates
        pddlDomain.addPredicate("a", null);
        pddlDomain.addPredicate("b", null);
        
        EPddlProblem problem = new EPddlProblem(pddlDomain,"internal",System.out,false);
        
        //Define transition
        ConditionalEffects<Predicate> effects = new ConditionalEffects<>(ConditionalEffects.VariableType.PROPEFFECT);
        effects.add(Predicate.getPredicate("a", null));
        TransitionGround action = new TransitionGround(null, 
                "hello", 
                effects, 
                new ConditionalEffects(ConditionalEffects.VariableType.NUMEFFECT), 
                null, 
                Transition.Semantics.ACTION);
        problem.actions.add(action);
        
        effects = new ConditionalEffects<>(ConditionalEffects.VariableType.PROPEFFECT);
        effects.add(Predicate.getPredicate("b", null));
        TransitionGround action2 = new TransitionGround(null, 
                "world", 
                effects, 
                new ConditionalEffects(ConditionalEffects.VariableType.NUMEFFECT), 
                Predicate.getPredicate("a",null), 
                Transition.Semantics.ACTION);
        problem.actions.add(action2);

        //init
        
        //goal
        problem.setGoals(new AndCond(Sets.newHashSet(Predicate.getPredicate("b",null))));
        
        
        problem.prettyPrint();
        problem.groundingSimplication(true);
        
  
        final PDDLSearchEngine searchEngine = new PDDLSearchEngine(new H1(problem), problem); //manager of the search strategies
        LinkedList<Pair<BigDecimal, Object>> plan = searchEngine.WAStar(problem);
        System.out.println(plan);
        
    }
    
    public static void fullSchemaProblem() throws Exception{
        PddlDomain pddlDomain = new PddlDomain();
        
        //add predicates
        pddlDomain.addPredicate("a", new ArrayList());
        pddlDomain.addPredicate("b", new ArrayList());
        pddlDomain.addType(Type.getType("Person"));
        
        EPddlProblem problem = new EPddlProblem(pddlDomain,"internal",System.out,false);
        problem.objects.add(PDDLObject.createObject("Enrico", Type.getType("Person")));
        
        //Define transition
        ConditionalEffects<Predicate> effects = new ConditionalEffects<>(ConditionalEffects.VariableType.PROPEFFECT);
        effects.add(Predicate.getPredicate("a", new ArrayList()));
        SchemaParameters par = new SchemaParameters();
        par.add(Variable.createVariable("x", Type.getType("Person")));
        TransitionSchema action = new TransitionSchema(par, 
                "hello", 
                effects, 
                new ConditionalEffects(ConditionalEffects.VariableType.NUMEFFECT), 
                null, 
                Transition.Semantics.ACTION);
        pddlDomain.addAction(action);
        
        effects = new ConditionalEffects<>(ConditionalEffects.VariableType.PROPEFFECT);
        effects.add(Predicate.getPredicate("b", new ArrayList()));
        TransitionGround action2 = new TransitionGround(null, 
                "world", 
                effects, 
                new ConditionalEffects(ConditionalEffects.VariableType.NUMEFFECT), 
                Predicate.getPredicate("a",new ArrayList()), 
                Transition.Semantics.ACTION);
        problem.addAction(action2);

        //init
        
        //goal
        problem.setGoals(Predicate.getPredicate("b",new ArrayList()));
        
        
        problem.prettyPrint();
        problem.groundingSimplication(true);
        
  
        final PDDLSearchEngine searchEngine = new PDDLSearchEngine(new H1(problem), problem); //manager of the search strategies
        LinkedList<Pair<BigDecimal, Object>> plan = searchEngine.WAStar(problem);
        System.out.println(plan);
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        fullSchemaProblem();
    }
    
}

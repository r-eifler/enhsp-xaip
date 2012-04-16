

import domain.ActionSchema;
import domain.PddlDomain;
import problem.PddlProblem;

import planners.*;

import propositionalFactory.ActionFactory;

public class Test {
    /**
     * @param args Call the program by passing domain and problem pddl files
     * @throws Exception Nothing
     */
    public static void main(String[] args) throws Exception {


        //Controlling the input files
        if (args.length < 2){
            System.out.println("Usage: ... domain problem");
            System.exit(-1);
        }

        PddlDomain a = new PddlDomain();
        PddlProblem p = new PddlProblem();
        metricFFWrapper metric;
        metric = new metricFFWrapper();;


        a.parseDomain(args[0]);
        p.parseProblem(args[1]);
        a.prettyPrint();
        p.prettyPrint();
        System.out.println("Validazione:..." +a.validate(p));
        ActionFactory factory = new ActionFactory();
        ActionSchema elemento = (ActionSchema)a.getActionsSchema().iterator().next();
        
        factory.Substitution(elemento,p.getObject());
        
        
        /*
        
        if (a.validate(p)){
            metric.setDomainFile(args[0]);
            metric.setProblemFile(args[1]);
            metric.executePlanning();

            }
        
        */
        //PddlDomain a = new PddlDomain(args[0]);
    }
}

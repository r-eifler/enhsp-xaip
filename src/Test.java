

import conditions.Term;
import domain.ActionParametersAsTerms;
import domain.ActionSchema;
import domain.PddlDomain;
import problem.PddlProblem;

import planners.*;

import problem.InstatiatedAction;
import problem.State;


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
        
        a.parseDomain(args[0]);
        p.parseProblem(args[1]);
        a.prettyPrint();
        p.prettyPrint();
        System.out.println("Validazione:..." +a.validate(p));
        
        System.out.println(p.getInit());
        ActionParametersAsTerms par = new ActionParametersAsTerms();
        par.add(p.getObjectByName("C"));
        ActionSchema Load = a.getActionByName("pick-up");
        System.out.println(Load);
        InstatiatedAction load = Load.ground(par);
        System.out.println(load);

        State newState  = load.apply(p.getInit());
        //System.out.println(newState);


        System.out.println(p.getInit());

        
        
        
//        par.add(c); par.add(b);
        

//      
//        System.out.println("Oggetti del dominio" + p.getProblemObjects());
//        Term c  = p.getObjectByName("C");
//        Term b  = p.getObjectByName("b");
//        ActionParametersAsTerms par = new ActionParametersAsTerms();
//        par.add(c); par.add(b);
//        
//        ActionSchema unstack = a.getActionByName("unstack");
//        if (unstack ==null){
//            System.out.println("non ci sono azioni con questo nome");
//
//        }else{
//            InstatiatedAction unstackI = unstack.ground(par);
//
//            System.out.println("unstack non istanziato:" + unstack);
//            System.out.println("unstack istanziato:" + unstackI);
//        }
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

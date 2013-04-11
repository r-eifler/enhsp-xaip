
import domain.ActionParametersAsTerms;
import domain.ActionSchema;
import domain.PddlDomain;
import java.util.HashSet;
import java.util.Set;
import problem.GroundAction;
import problem.PddlProblem;
import problem.State;
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
        
        {
            PddlDomain a = new PddlDomain();
            PddlProblem p = new PddlProblem();

            a.parseDomain(args[0]);
            p.parseProblem(args[1]);
            //a.prettyPrint();
            //p.prettyPrint();
            System.out.println("Validazione:..." +a.validate(p));

            //System.out.println(p.getInit());
            ActionParametersAsTerms par = new ActionParametersAsTerms();
            
            ActionFactory af = new ActionFactory();
            int propActionNumber = 0;
            Set level1 = new HashSet();
            for (Object o : a.getActionsSchema()){
                Set s = af.Propositionalize((ActionSchema)o, p.getProblemObjects());
                for (Object o1: s){
                    GroundAction gr = (GroundAction)o1;
                    //System.out.println(gr.toEcoString());
                    if (gr.getPreconditions().isSatisfied(p.getInit()))
                        level1.add(gr);
                }
                propActionNumber += s.size();
            }
            
            System.out.println("Numero totale di azioni proposizionalizzate" + propActionNumber);
            //System.exit(0);

           
            System.out.println("Numero totale di azioni applicabili nello stato 1: " + level1.size());
            
            for (Object o: level1){
                GroundAction gr = (GroundAction)o;
                State s = gr.apply(p.getInit().clone());
                System.out.println(gr.toEcoString());
                System.out.println("Goal is reached? " + p.getGoals().isSatisfied(s));
            }
            
            
            //System.out.println("Grounding test" + a.getActionByName("fly-slow").ground(par));
            
        }
        
        
//        PddlMMDomain a = new PddlMMDomain();
//        PddlProblem p = new PddlProblem();
//        
//        a.parseDomain(args[0]);
//        p.parseProblem(args[1]);
//        a.prettyPrint();
//        p.prettyPrint();
//        //System.out.println("Validazione:..." +a.validate(p));
//        
//        //System.out.println(p.getInit());
//        ActionParametersAsTerms par = new ActionParametersAsTerms();
//
//        par.add(p.getObjectByName("plane1"));
//        par.add(p.getObjectByName("city1"));
//        par.add(p.getObjectByName("city2"));
//        
//        MMActionSchema action = a.getMMActionSchemaByName("fly");
//        
//        System.out.println(action);
//        MMGroundAction gAct = action.ground(par);
////        
//        
//        System.out.println(gAct);
        
        //System.out.println(newState);


        
        
        
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
//            GroundAction unstackI = unstack.ground(par);
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

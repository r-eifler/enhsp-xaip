


import domain.PddlDomain;
import domain.PddlProblem;

public class Test {
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
        //PddlDomain a = new PddlDomain(args[0]);
    }
}

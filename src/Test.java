
import domain.PddlDomain;
import plan.SimplePlan;
import planners.metricFFWrapper;
import problem.GroundAction;
import problem.PddlProblem;
import problem.State;

public class Test {

    /**
     * @param args Call the program by passing domain and problem pddl files
     * @throws Exception Nothing
     */
    public static void main(String[] args) throws Exception {


        //Controlling the input files
        if (args.length < 2) {
            System.out.println("Usage: ... domain problem plan");
            System.exit(-1);
        }

        {
            PddlDomain a = new PddlDomain();
            PddlProblem p = new PddlProblem();

            a.parseDomain("zenonumeric.pddl");
            //int i = Integer.parseInt(args[1]);
            for (int i = 17; i < 18; i++) {
                p.parseProblem("p" + Integer.toString(i));
                //a.prettyPrint();
                //p.prettyPrint();
                metricFFWrapper ff = new metricFFWrapper();

                SimplePlan sp = new SimplePlan(a, p, false);



                //sp.parseSolution(ff.plan("zenonumeric.pddl", "p" + Integer.toString(i)));
                sp.parseSolution("piano" + Integer.toString(i));

                sp.simplifyActions2();

                System.out.println("Fino a qua non ho normalizzato");

                System.out.println("Testing for Problem and plan number: " + i);

                GroundAction a3 = new GroundAction();

                for (Object o : sp) {
                    GroundAction action = (GroundAction) o;
                    a3 = a3.macroOperator(action);
                }
                //System.out.println(a3.toString());
                a3.normalize();
                //a3  = a3.macroOperator((GroundAction)sp.get(1));
                //System.out.println(sp);
                //System.out.println(a3.toString());

//            System.out.println("a1: " + a1.toString());
//            System.out.println("a0: " + a0.toString());

//             System.out.println("Macro Operation is applicable? " + p.getInit().satisfy(a3.getPreconditions()));

                System.out.println(a3.getParameters().pddlPrint());
                System.out.println(a3.toPDDL());
//             System.out.println("sN:" + sN);
//             System.out.println(sN.satisfy(p.getGoals()));

//             System.out.println("Final State: (relevant fluents)" + sN.printFluentByName("power") + " " + sN.printFluentByName("powerC"));

                System.out.print("Applicable: " + p.getInit().satisfy(a3.getPreconditions()));
                State sN = a3.apply(p.getInit().clone());
                System.out.println(" Reach Final Goals: " + p.getGoals().isSatisfied(sN));
                if (!p.getInit().satisfy(a3.getPreconditions()) || !sN.satisfy(p.getGoals())) {
                    System.err.println("BUGGGG IN PROBLEM AND PLAN NUMBER: " + i);
                }
            }
//            SimplePlan sp =ff.plan(args[0], args[1]);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem;

/**
 *
 * @author enrico
 */
public class GroundEvent extends GroundAction{

    public GroundEvent(String name) {
        super(name);
    }
    
    @Override
    public String toPDDL() {

        String ret = "(:event " + this.name + "\n";

        ret += ":parameters ()\n";
        ret += ":precondition " + this.getPreconditions().pddlPrint(false) + "\n";
        ret += ":effect " + this.pddlEffects();

        return ret + ")";

    }
}

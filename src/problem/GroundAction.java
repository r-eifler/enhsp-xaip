package problem;

import conditions.AndCond;
import conditions.Comparison;

import domain.ActionParametersAsTerms;
import domain.GenericActionType;
import expressions.NumEffect;
import expressions.NumFluent;
import expressions.PDDLNumber;
import java.util.ArrayList;
import java.util.HashMap;

public class GroundAction extends GenericActionType {

    protected ActionParametersAsTerms parameters;
    public boolean normalized;
    private ArrayList numericFluentAffected;

    @Override
    public Object clone() throws CloneNotSupportedException {
        GroundAction ret = new GroundAction(name);
        if (this.addList != null)
            ret.addList = this.addList.clone();
        if (this.delList != null)
            ret.delList = this.delList.clone();
        ret.normalized = this.normalized;
        ret.numeric = this.numeric.clone();
        ret.numericFluentAffected = (ArrayList)this.numericFluentAffected.clone();
        ret.parameters = (ActionParametersAsTerms)this.parameters.clone();
        ret.preconditions = this.preconditions.clone();
        return ret;
               
    }


    public GroundAction(String name) {
        this.name = name;
        numericFluentAffected = new ArrayList();
    }

    @Override
    public String toString() {
        String parametri = "";
        for (Object o : getParameters()) {
            parametri = parametri.concat(o.toString()).concat(" ");
        }
        return "\n\nAction Name:" + this.name + " Parameters: " + parametri + "\nPre: " + this.preconditions + "\nEffetti positivi: " + this.getAddList() + "\nEffetti negativi: " + this.getDelList() + "\nNumeric Effects:  " + this.getNumeric();

    }

    public String toEcoString() {
        String parametri = "";
        for (Object o : getParameters()) {
            parametri = parametri.concat(o.toString()).concat(" ");
        }
        return "\n\nAction Name:" + this.name + " Parameters: " + parametri;

    }

    /**
     * @return the parameters
     */
    public ActionParametersAsTerms getParameters() {
        return parameters;
    }

    /**
     * @param parameters the parameters to set
     */
    public void setParameters(ActionParametersAsTerms parameters) {
        this.parameters = parameters;
    }

    public State apply(State s) {
        State ret = s;
        AndCond add = (AndCond) addList;
        if (add != null) {
            ret = add.apply(s);
        }
        AndCond del = (AndCond) delList;
        if (del != null) {
            ret = del.apply(s);
        }
        AndCond c = (AndCond) this.getNumeric();
        if (c != null) {
            ArrayList temporaryMod = new ArrayList();
            HashMap fun2numb = new HashMap();
            for (Object o : c.son) {
                NumEffect all = (NumEffect) o;
                NumFluent f = all.getOne();
                PDDLNumber newN = null;

                Float rValue;
                rValue = all.getTwo().eval(s).getNumber();
                //System.out.println("Rvalue!!:" + rValue);
                if (all.getOperator().equals("increase")) {
                    newN = new PDDLNumber(s.functionValue(f).getNumber() + rValue);
                } else if (all.getOperator().equals("decrease")) {
                    newN = new PDDLNumber(s.functionValue(f).getNumber() - rValue);
                } else if (all.getOperator().equals("assign")) {
                    //System.out.println("================ASSIGN===========");
                    newN = new PDDLNumber(rValue);
                }
                temporaryMod.add(f);
                fun2numb.put(f, newN);
            }

            for (Object o : temporaryMod) {
                NumFluent f = (NumFluent) o;
                PDDLNumber n = (PDDLNumber) fun2numb.get(f);

                s.setFunctionValue(f, n);

            }
            
        }
        return ret;
    }
    
    public void generateAffectedNumFluents(){
    
            AndCond num = (AndCond) this.getNumeric();

        if (num != null) {
            for (Object o : num.son) {
                if (o instanceof NumEffect) {
                    NumEffect e = (NumEffect) o;
                    this.numericFluentAffected.add(e.getOne());
                }
            }
        }
    
    }

    public void normalize() {


        if (!(this.preconditions instanceof AndCond)) {
            System.out.println("o is expected to be an AndCond but is " + this.preconditions.getClass() + "; Action: " + this);
            throw new UnsupportedOperationException();
        }

        for (Object o : this.preconditions.son) {

            if (o instanceof Comparison) {
                Comparison c = (Comparison) o;
                c = c.normalize();
            }


        }
        AndCond num = (AndCond) this.getNumeric();

        if (num != null) {
            for (Object o : num.son) {
                if (o instanceof NumEffect) {
                    NumEffect e = (NumEffect) o;
                    e.setTwo(e.getTwo().normalize());
                }
            }
        }

        this.normalized = true;
        
        

    }

    public ArrayList getNumericFluentAffected() {
        return this.numericFluentAffected;
    }

    /**
     * @param numericFluentAffected the numericFluentAffected to set
     */
    public void setNumericFluentAffected(ArrayList numericFluentAffected) {
        this.numericFluentAffected = numericFluentAffected;
    }
    
    
}

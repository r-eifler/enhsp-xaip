package com.hstairs.ppmajal.PDDLProblem;

import com.hstairs.ppmajal.domain.PDDLDomain;

import java.io.PrintStream;
import java.math.BigDecimal;

public class PDDLOSPProblem extends PDDLProblem {
    public PDDLOSPProblem(PDDLDomain pddlDomain) {
        super(pddlDomain);
    }

    public PDDLOSPProblem(String arg, PDDLDomain d) {
        super(arg, d);
    }

    public PDDLOSPProblem(PDDLDomain domain, String groundingMethod, PrintStream out, boolean sdac, boolean ignoreMetric) {
        super(domain, groundingMethod, out, sdac, ignoreMetric);
    }

    public PDDLOSPProblem(PDDLDomain domain, String groundingMethod, PrintStream out, boolean sdac, boolean ignoreMetric, BigDecimal planningDelta, BigDecimal executionDelta) {
        super(domain, groundingMethod, out, sdac, ignoreMetric, planningDelta, executionDelta);
    }

}

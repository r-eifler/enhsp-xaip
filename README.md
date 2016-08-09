The following is still temporary..

#What is PPMaJal?

This repository contains the PPMaJal API, which is a planning problem manager library meant to build systems that speak the PDDL language. It supports many features that go way beyond classical planning, such as numeric representations, linear and non-linear constraints, autonomout processes, global constraints and other things.

This API has been used as basis for many projects, all related to Automated Planning, Replanning, Plan Execution, SMT Planning and others that I cannot remember now.

For more information on its applications have a look at some of the papers in [Google Scholar](https://scholar.google.com.au/citations?user=lgfpklAAAAAJ&hl=en)

The most recent advances of the library refers to:

E. Scala, P. Haslum, S. Thiebaux: **Heuristics for Numeric Planning via Subgoaling**, IJCAI 2016
E. Scala, M. Ramirez, P. Haslum, S. Thiebaux: **Numeric Planning with Disjunctive Global Constraints via SMT**, ICAPS 2016
E. Scala, P. Torasso, **Deordering and Numeric Macro Actions for Plan Repair**, IJCAI 2015
E. Scala, P. Haslum, S. Thiebaux, M. Ramirex, **Interval-Based Relaxation for General Numeric Planning**, ECAI 2016



Besides many other things, the API has some self-contained planners such as the ENHSP planner (which stands for Expressive Numeric Heuristic Search Planner).

This planner can be invoked by:

java -jar dist/PPMaJal2.jar -o <domain_file> -f <problem_file> -h <configuration> -s <search-strategy> -gw <weight for the g-values> -hw <weight for the h-values> -break_ties <larger_g, smaller_g, arbitrary>

In particular the -h can be configured with

- 1, to get h_add
- 3, to get h_max
- 112, to get Additive Interval Based Relaxation (as for ECAI 2016 paper)
- exp_gc, experimental version of something which is similar to h^m
- op_counting, experimental version which supports operator counting constraints


The SMT Planner can be downloaded from [Here](https://bitbucket.org/enricode/springroll-smt-hybrid-planner)

##Dependencies

The library depends on a number of other libs and for some of the facilities it also depends on s
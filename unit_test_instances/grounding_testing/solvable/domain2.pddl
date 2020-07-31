

(define 
    (domain testing)
	(:types caccamo -object)
    (:predicates (a ?x ?y -caccamo ) (b ?x ?y -caccamo )  (goal) (goal2) )
    (:functions 
	    (f1 ?x -caccamo)
    )
    (:action first
       :parameters (?x ?y -caccamo)
       :precondition (and (not (> (f1 ?x) 0) ))
       :effect 
                (and 
                    (b ?x ?y)
                    (a ?x ?y)
                    (not(goal))
                )
	
    )
    
    (:action second
       :parameters (?x ?y -caccamo)
       :precondition (and (b ?x ?y) (a ?x ?y))
       :effect 
                (and 
                    (not(goal))
                    ;(increase (f1 ?y) (f1 ?x))
                )
	
    )
) 



(define 
    (domain testing)
	(:types caccamo -object)
    (:predicates (a ?x ?y -caccamo ) (b ?x ?y -caccamo )  (goal) (goal2) )
    (:functions 
	    (f1 ?x -caccamo)
    )
    (:action first
       :parameters (?x ?y -caccamo)
       :precondition (and(not(or (a ?x ?y) (b ?x ?y))))
       :effect 
                (and 
                    (b ?x ?y)
                    ;(not(goal))
                )
	
    )
    
    (:action second
       :parameters (?x ?y -caccamo)
       :precondition (and (b ?x ?y) (a ?x ?y))
       :effect 
                (and 
                    (not(goal))
                )
	
    )
) 

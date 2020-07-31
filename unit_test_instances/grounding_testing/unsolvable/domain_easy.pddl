

(define 
    (domain testing)
	(:types caccamo -object)
        	(:constants c1 -caccamo )

    (:predicates (a ?x ?y -caccamo ) (b ?x ?y -caccamo )  (goal) (goal2) )

    (:functions 
	    (f1 ?x -caccamo)
    )
    (:action first
       :parameters (?x ?y -caccamo)
       :precondition (and 
                            (a c1 ?y)
                            (b ?y ?x)
                     )
       :effect 
                (and         
                    (goal)
                )
	
    )

) 

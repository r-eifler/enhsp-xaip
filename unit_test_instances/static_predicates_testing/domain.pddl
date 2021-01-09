

(define 
    (domain testing)
	(:types caccamo)
    (:predicates (a ?x ?y - caccamo ) (b ?x ?y - caccamo )  (goal) (motherfucker ?x ?y - caccamo) )

    (:action first
       :parameters (?x ?y - caccamo)
       :precondition (and (forall (?z ?h - caccamo) (motherfucker ?z ?h) )  )
       ; :precondition (and (forall (?z ?h - caccamo) (motherfucker ?z ?h) )  )
       :effect 
                (and 
                    (b ?x ?y)
                )
	
    )
    
    (:action second
       :parameters (?x ?y - caccamo)
       :precondition (and (b ?x ?y) (a ?x ?y))
       :effect 
                (and 
                    (not(goal))
                )
	
    )

) 

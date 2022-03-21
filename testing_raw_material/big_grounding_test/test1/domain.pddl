

(define 
    (domain testing)
	(:types caccamo - object)
    (:predicates (x_y ?x ?y - caccamo) (goal) (goal2) )

    (:action action
       :parameters ( ?x ?y ?a ?b ?c ?d - caccamo)
       :precondition (x_y ?x ?y)
       :effect 
                (and 
                    (goal)
                )
	
    )

    (:action action2
       :parameters ( ?x ?y - caccamo)
       :precondition (x_y ?x ?y)
       :effect 
                (and 
                    (goal)
                )
	
    )
    
) 

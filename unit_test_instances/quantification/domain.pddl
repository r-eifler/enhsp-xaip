

(define 
    (domain testing)
    (:types obj -object)
    (:predicates 
                (a ?o -obj)
                (a2 ?o -obj)
                (b)
                (b2)
                (goal)
                (dummy))
    (:action produce_b
       :parameters ()
       :precondition (and (exists 
			            (?o -obj) (a ?o)))
       :effect 
                (and 
                    (b))) 
    (:action produce_b2
       :parameters ()
       :precondition (and(forall 
			            (?o -obj) (a2 ?o) ))
       :effect 
                (and 
                    (b2))) 
    (:action produce_goal
       :parameters ()
        :precondition (and 
			            (b) (b2) )
       :effect 
                (and 
                    (goal)))
) 

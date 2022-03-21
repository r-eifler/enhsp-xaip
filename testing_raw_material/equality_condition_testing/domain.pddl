

(define 
    (domain testing)
    (:predicates (goal))
    (:functions (x) (y))
    (:action decrease_x
       :parameters ()
       :effect 
                    (and 
                        (decrease (x) 1)
                    )
	
    )
    (:action increase_y
       :parameters ()
       :effect 
                    (and 
                        (increase (y) 1)
                    )
	
    )
    (:action produce_goal
       :parameters ()
       :precondition (and
			            (= (x) 10)
                        (= (y) 10)
                    )            
       :effect (and
		            (goal)
               )
    )
) 

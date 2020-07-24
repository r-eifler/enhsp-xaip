

(define 
    (domain testing)
    (:predicates (g1) (b) (c) (d) (g2))
    (:functions (x))
    (:action produce-g1
       :parameters ()
       :precondition (and
			            (c) 
                        (not (b))
                     )
       :effect 
                    (and 
                        (g1)
                        (not (g2))
                    )
	
    )
    (:action delete-b
       :parameters ()
       :precondition ()      
       :effect (and
		            (not (b))
               )
    )
    (:action produce-d
       :parameters ()
       :precondition ()      
       :effect (and
		            (d)
                    (not (c))
               )
    )

    (:action increase-x
       :parameters ()
       :precondition ()      
       :effect (and
		            (increase (x) 1)
               )
    )
) 



(define 
    (domain testing)
    (:predicates (a) (b) (c) (d))
    (:action produce-b
       :parameters ()
       :precondition (and
			            (a)
                     )
       :effect 
                    (and 
                        (b)
                        (d)
                    )
	
    )
    (:action produce-c
       :parameters ()
       :precondition (and
			            (not (b))
                        (d)
                     )
       :effect 
                    (and 
                        (c)
                    )
	
    )

) 

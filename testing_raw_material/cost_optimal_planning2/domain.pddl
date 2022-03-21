(define 
    (domain testing)
    (:predicates (a) (b) (c) (goal))
    (:functions 
    	(total-cost) 
    )
    (:action fast-but-costly
       :parameters ()
       :precondition (and
                        (a)
                     )
       :effect 
              (and 
                 (goal)
                 (increase (total-cost) 10000)))

    (:action enable-the-enabler
       :parameters ()
       :precondition (a)        
       :effect (and
		          (b)
		          (increase (total-cost) 1)))
    (:action enabler
       :parameters ()
       :precondition (and
			            (b))
       :effect (and
		            (c)
		            (increase (total-cost) 1)))
    (:action slow-but-cheap
       :parameters ()
       :precondition (and
			            (c))
       :effect (and
                    (goal)
	                (increase (total-cost) 1)))) 

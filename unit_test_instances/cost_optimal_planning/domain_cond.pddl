(define 
    (domain testing)
    (:predicates (a) (b) (c)(goal))
    (:functions 
	(total-cost) (x) (total-cost2)
    )
    (:action fast-but-costly
       :parameters ()
       :precondition (and
                        (a))
       :effect 
              (and 
                 (goal)
                 (when (a) (and(increase (total-cost) 10)))))
)

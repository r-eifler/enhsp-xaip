(define 
    (domain testing)
    (:functions (g0) (g1) )

    (:action get-g0
;       :parameters ()      :precondition ()
       :effect (and
                    (increase (g0) 1)
	            ))
    (:action get-g1
;       :parameters ()       :precondition ()
       :effect (and
                    (increase (g1) 1)
	            ))
    (:action get-g0-g1
;      :parameters () :precondition ()
       :effect (and
                    (increase (g0) 1)
                    (increase (g1) 1)
	            ))
) 

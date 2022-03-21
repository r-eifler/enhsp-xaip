(define 
    (domain testing)
    (:functions 
        (x)  (v) 
    )

    (:action increase_v
       :parameters ()
       :precondition (> (x) 1)
       :effect (and (increase (v) 1))
    )
) 

(define 
    (domain testing)
    (:functions 
        (x)  (v) (y)
    )

    (:action increase_v
       :parameters ()
       :precondition (and (> (x) 1) (> (y) 1))
       :effect (and (increase (v) 1))
    )
) 

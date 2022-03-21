

(define 
    (domain testing)
    (:predicates (a)(b))
    (:action give_b_with_a
       :parameters ()
       :effect (and 
                   (when (a) (b))
               )
    )


) 

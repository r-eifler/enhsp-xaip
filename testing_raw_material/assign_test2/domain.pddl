

(define 
    (domain testing)
    (:predicates (a) (c) (b) (d) (e) (f) (h) )
    (:functions 
        (x)  
    )


    ;;this tests the numeric part of the problem plus dominated constraints
    (:action a
       :parameters ()
       ;:precondition ()            
       :effect (and (assign (x) 5))
    )
) 

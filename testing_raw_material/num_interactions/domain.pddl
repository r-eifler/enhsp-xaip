;Header and description

(define (domain test_interactions)

(:predicates ;todo: define predicates here 
    (g0) (g1)
)


(:functions ;todo: define numeric functions here
    (x)
    (d)
)

(:action incx
    :effect (and (increase (x) 1))
)

(:action decx
    :effect (and (decrease (x) 1))
)

(:action getG1
    :parameters ()
    :precondition (and (>= (x) 5))
    :effect (and (g0) )
)

(:action getG2
    :parameters ()
    :precondition (and (<= (x) (d)) )
    :effect (and (g1) )
)



;define actions here

)
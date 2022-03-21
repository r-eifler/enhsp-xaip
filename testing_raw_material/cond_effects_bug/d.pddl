;Header and description

(define (domain domain_name)

(:predicates
    (a)
    (b)
)
(:functions ;todo: define numeric functions here
    (x)
    (y)
)
(:action increase_x
    :parameters ()
    :precondition (and )
    :effect (and (when (a) (increase (x) 1)) (when (b) (decrease (y) 1)) )
)

(:action set_a
    :parameters ()
    :precondition (and )
    :effect (and (a) )
)

(:action set_b
    :parameters ()
    :precondition (and )
    :effect (and (b) )
)

;define actions here

)
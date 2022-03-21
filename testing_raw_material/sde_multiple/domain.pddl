;Header and description

(define (domain domain_name)

; un-comment following line if constants are needed
;(:constants )

(:predicates ;todo: define predicates here
    (a)
)


(:functions ;todo: define numeric functions here
    (x)
    (y)
)

;define actions here
(:action inc_y
    :parameters ()
    :precondition (and )
    :effect (and (increase (y) 1))
)
(:action inc_x_set_a
    :parameters ()
    :precondition (and )
    :effect (and (a) (increase (x) (y)))
)



)
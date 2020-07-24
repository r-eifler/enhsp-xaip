;(:;Header and description

(define (domain test)

(:types ;todo: enumerate types and their hierarchy here, e.g. car truck bus - vehicle
    thing - object
    glass - thing
)

; un-comment following line if constants are needed
;(:constants )

(:predicates ;todo: define predicates here
    (held ?x - thing)
    (true)
)


;define actions here
(:action takeit
    :parameters (?x - thing)
    ;:precondition (and )
    :effect (and (held ?x))
)

)
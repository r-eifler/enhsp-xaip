;Header and description

(define (domain nd-test)

; un-comment following line if constants are needed
;(:constants )

(:predicates ;todo: define predicates here
(a)
(b)
)

(:action action_name
    :parameters ()
    :precondition ()
    :effect (and (oneof (and (a) (b)) (b)) )
)



;define actions here

)
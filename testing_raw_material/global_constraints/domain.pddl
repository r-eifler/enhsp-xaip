
(define (domain domain_name)

(:types ;todo: enumerate types and their hierarchy here, e.g. car truck bus - vehicle
  dummy - object
)

; un-comment following line if constants are needed
;(:constants )

(:predicates ;todo: define predicates here
  (true)
  (false)
)


(:functions ;todo: define numeric functions here
  (x ?d - dummy)
)

(:constraint dummy-constraint
    :parameters (?p - dummy)
    :condition (= (*(x ?p) (x ?p)) 0)
)
;define actions here

(:action a
    :parameters ()
    :precondition (and (false) )
    :effect (and (true) )
)


)
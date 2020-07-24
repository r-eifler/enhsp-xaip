

(define 
    (domain testing)
	(:types caccamo - object)
    (:predicates (x_y ?x ?y - caccamo) (goal ?x ?y ?a ?b ?c ?d ?e - caccamo) (goal2) )

    (:action action
       :parameters ( ?x ?y ?a ?b ?c ?d ?e  - caccamo)
       :precondition (and (= ?x ?y) (= ?x ?a) (= ?x ?b)(= ?x ?c) (= ?x ?d) )
       :effect 
                (and 
                    (goal ?x ?y ?a ?b ?c ?d ?e)
                )
	
    )

    
) 

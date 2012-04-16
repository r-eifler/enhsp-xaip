;; Transport sequential
;;

(define (domain transport)
  (:requirements :typing :fluents )
  (:types
        site - object
        robot - object
  )
  (:predicates (joined ?l1 ?l2 -site) (in ?r -robot ?l1 -site) (observed ?l1 -site))

  (:functions (power ?r -robot) (time) (distance ?l1 ?l2 -site) (spentPower ?r -robot)) 

  (:action drive-normal
    :parameters (?r - robot ?l1 ?l2 -site)
    :precondition (and (joined ?l1 ?l2)
		       (in ?r ?l1) 
		   (> (power ?r) (* (distance ?l1 ?l2) 10))
                  )
    :effect (and
        (in ?r ?l2)
        (not(in ?r ?l1))
	(increase (spentPower ?r) (* (distance ?l1 ?l2) 10))
	(increase (time) (* (distance ?l1 ?l2) 10))
 	)
  )
  
  (:action drive-slow
    :parameters (?r - robot ?l1 ?l2 -site)
    :precondition (and (joined ?l1 ?l2)
		       (in ?r ?l1) 
		   (> (power ?r) (* (distance ?l1 ?l2) 8))
                  )
    :effect (and
        (in ?r ?l2)
        (not(in ?r ?l1))
	(increase (spentPower ?r) (* (distance ?l1 ?l2) 8))
	(increase (time) (* (distance ?l1 ?l2) 12))
 	)
  )

  (:action takePicture
    :parameters (?r - robot ?l1 -site)
    :precondition (and (in ?r ?l1) 
                  )
    :effect (and
        (observed ?l1)
 	)
  )
)

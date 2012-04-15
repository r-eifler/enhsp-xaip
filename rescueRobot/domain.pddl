;; Transport sequential
;;

(define (domain transport)
  (:requirements :typing :fluents )
  (:types
        location - object
        robot - object
  )
  (:predicates (road ?l1 ?l2 -location) (in ?r -robot ?l1 -location) (infoSent ?l1 -location))
  (:functions (total-fuel ?l1) (power)) 
  (:action drive-normal
    :parameters (?r - robot ?l1 ?l2 - location)
    :precondition (or
	(and (in ?r ?l1) (not(in ?r ?l1)) (< (total-fuel) 100))
        (in ?r ?l1)
        (road ?l1 ?l2)
      )
    :effect (and
        (not(in ?r ?l1))  
        (in ?r ?l2)
	(increase (total-fuel) 1)
      )
  )
)

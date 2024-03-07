(define (domain beluga)
  (:requirements :strips :typing :fluents :equality)
  (:types
		part side location - object
		rack truck - location
)

  (:constants
		bside - side ; beluga side
		fside - side ; factory side
	)


	; 								[ ] [ ] [ ]
	;		
	; beluga						[ ] [ ] [ ]					factory
	; [ ] [ ] [ ]												[ ] [ ] [ ]		
	; 			B	    			[ ] [ ] [ ]					F		  
	;								B  racks  F
	;	<- on(x,y,B)		on(x,y,B) -> <- on(x,y,F)   		on(x,y,F) -> 


  (:predicates
		(in ?p - part ?l - location)		; the part is at a given location (truck or rack)
		(on ?p1 ?p2 - part ?s - side)		; p1 is on p2 when looking at them from side s
		(empty ?l - location) 			; no part is at this location
		(clear ?p - part ?s - side)		; there is nothing on part p, when looking at it from side s
		(atside ?l - location ?s - side)	; side (beluga/factory) of a location. regular racks are at both sides.
		(not-pline ?r - rack) 	   		; the rack is not a production line
		(not-beluga ?b - rack)			; the rack is not the/a beluga
	)


  (:functions
		(total-cost);
		(size ?p - part)			; size occupied by a part
		(level ?r - rack)			; current occupancy level at a location (total size of the parts at this location)
		(max-level ?r - rack)
		(total-swaps)
		(swap-unstack ?r - rack ?s - side)
		(swap-stack ?r - rack ?s - side)
		(rack-used ?r)
	)

  (:action pickup					; truck t picks up clear part p from side s of rack r (p is the only part on this rack, others is the opposite side to s)
		:parameters (?p - part ?r - rack ?t - truck ?s ?others - side)
		:precondition (and
			(not (= ?s ?others))
			(not-pline ?r)
			(atside ?t ?s)
			(atside ?r ?s)
			(in ?p ?r)
			(empty ?t)
			(clear ?p ?s)
			(clear ?p ?others)
		)
		:effect (and
			(not (in ?p ?r))
			(in ?p ?t)
			(not (empty ?t))
			(empty ?r)
			(not (clear ?p ?s))
			(not (clear ?p ?others))
			(decrease (level ?r) (size ?p))
			(increase (total-cost) 1)
			(increase (total-swaps) (swap-unstack ?r ?s))
		)
	)

  (:action unstack					; truck t stacks clear part p from side s of rack r (p is on nextp, others is the opposite side to s)
		:parameters (?p ?nextp - part ?r - rack ?t - truck ?s ?others - side)
		:precondition (and
			(not (= ?p ?nextp))
			(not (= ?s ?others))
			(not-pline ?r)
			(atside ?t ?s)
			(atside ?r ?s)
			(in ?p ?r)
			(in ?nextp ?r)
			(on ?p ?nextp ?s)
			(on ?nextp ?p ?others)
			(empty ?t)
			(clear ?p ?s)
		)
		:effect (and
			(not (in ?p ?r))
			(in ?p ?t)
			(not (empty ?t))
			(not (on ?p ?nextp ?s))
			(not (on ?nextp ?p ?others))
			(clear ?nextp ?s)
			(not (clear ?p ?s))
			(decrease (level ?r) (size ?p))
			(increase (total-cost) 1)
			(increase (total-swaps) (swap-unstack ?r ?s))
		)
	)

  (:action putdown					; truck t puts down part p on side s of rack r
		:parameters (?p - part ?r - rack ?t - truck ?s - side)
		:precondition (and
			(not-beluga ?r)
			(atside ?t ?s)
			(atside ?r ?s)
			(in ?p ?t)
			(empty ?r)
			(<= (+ (level ?r) (size ?p)) (max-level ?r))
		)
		:effect (and
			(not (in ?p ?t))
			(in ?p ?r)
			(empty ?t)
			(not (empty ?r))
			(clear ?p bside)
			(clear ?p fside)
			(increase (level ?r) (size ?p))
			(increase (total-cost) 1)
			(increase (total-swaps )(swap-stack ?r ?s))
			(assign (rack-used ?r) 1)
		)
	)

  (:action stack					; truck t stacks part p on side s of rack r (p will be put on nextp from side s, others is the opposite side to s)
		:parameters (?p ?nextp - part ?r - rack ?t - truck ?s ?others - side )
		:precondition (and
			(not (= ?s ?others))
			(not-beluga ?r)
			(atside ?t ?s)
			(atside ?r ?s)
			(in ?p ?t)
			(in ?nextp ?r)
			(clear ?nextp ?s)
			(<= (+ (level ?r) (size ?p)) (max-level ?r))
		)
		:effect (and			
			(not (in ?p ?t))
			(in ?p ?r)
			(empty ?t)
			(on ?p ?nextp ?s)
			(on ?nextp ?p ?others)
			(not (clear ?nextp ?s))
			(clear ?p ?s)
			(increase (level ?r) (size ?p))
			(increase (total-cost) 1)
			(increase (total-swaps )(swap-stack ?r ?s))
			(assign (rack-used ?r) 1)
		)
	)

)
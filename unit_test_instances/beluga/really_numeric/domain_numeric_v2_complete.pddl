(define (domain beluga)
  (:requirements :strips :typing :fluents :equality :action-costs)
  (:types
		side location production-line - object
		truck rack jig hanger - location
		beluga - rack
)

  (:constants
		bside - side ; beluga side
		fside - side ; factory side
	)


  (:predicates
		(in ?j - jig ?l - location); the part is at a given location (beluga, truck, rack)
		(empty ?l - location) 				; no part is at this location
		(atside ?l - location ?s - side)			; side (beluga/factory) of a location. regular racks are at both sides.
		(is-phase ?b - beluga)
		(outgoing ?j - jig ?b - beluga)
		(next-arrival ?b1 ?b2 - beluga)
		(part-of ?j - jig ?pl - production-line)
		(on ?j1 ?j2 - jig ?s - side)		; p1 is on p2 when looking at them from side s
		(clear ?j - jig ?s - side)		; there is nothing on part p, when looking at it from side s
  )


  (:functions
		(total-cost);
		(size ?j - jig)			; size occupied by a part
		(level ?r - rack)			; current occupancy level at a location (total size of the parts at this location)
		(max-level ?r - rack)
		(to-process-parts ?b - beluga)
		(load-order ?jt - jig)
		(unload-order ?j - jig)
		(process-order ?j - jig)
		(load-process ?b - beluga)
		(unload-process ?b - beluga)
		(delivery-process ?pl - production-line)
		(empty-size ?j - jig)
		; for explanations
		(total-swaps)
		(swap-unstack-count ?j - jig ?s - side)
		(swap-stack-count ?j - jig ?s - side)
		(rack-in-use ?r - rack)
	)

  (:action unload					
		:parameters (?j - jig ?b - beluga ?t - truck)
		:precondition (and
			(is-phase ?b)
			(in ?j ?b)
			(= (unload-order ?j) (unload-process ?b))
			(empty ?t)
			(atside ?t bside)
		)
		:effect (and
			(not (in ?j ?b))
			(in ?j ?t)
			(not (empty ?t))
			(decrease (unload-process ?b) 1)
			(increase (total-cost) 1)
		)
	)

	(:action load					
		:parameters (?j - jig ?b - beluga ?t - truck)
		:precondition (and
			(is-phase ?b)
			(outgoing ?j ?b)
			(empty ?j)
			(in ?j ?t)
			(= (load-order ?j) (load-process ?b))
			(atside ?t bside)
		)
		:effect (and
			(not (in ?j ?t))
			(in ?j ?b)
			(empty ?t)
			(decrease (load-process ?b) 1)
			(increase (total-cost) 1)
		)
	)

	(:action putdown-onto-rack					
		:parameters (?j - jig ?t - truck ?r - rack ?s - side)
		:precondition (and
			(in ?j ?t)
			(atside ?t ?s)
			(atside ?r ?s)
			(empty ?r)
			(>= (- (max-level ?r) (level ?r)) (size ?j))
		)
		:effect (and
			(in ?j ?r)
			(not (in ?j ?t))
			(empty ?t)
			(not (empty ?r))
			(clear ?j bside)
			(clear ?j fside)
			(increase (level ?r) (size ?j))
			(increase (total-cost) 1)
			(assign (rack-in-use ?r) 1)
			(increase (total-swaps) (swap-stack-count ?j ?s))
		)
	)

	(:action stack-onto-rack					
		:parameters (?j ?nj - jig ?t - truck ?r - rack ?s ?os - side)
		:precondition (and
			(not (= ?s ?os))
			(in ?j ?t)
			(in ?nj ?r)
			(clear ?nj ?s)
			(atside ?t ?s)
			(atside ?r ?s)
			(empty ?r)
			(>= (- (max-level ?r) (level ?r)) (size ?j))
		)
		:effect (and
			(in ?j ?r)
			(not (in ?j ?t))
			(empty ?t)
			(on ?j ?nj ?s)
			(on ?nj ?j ?os)
			(not (clear ?nj ?s))
			(clear ?j ?s)
			(increase (level ?r) (size ?j))
			(increase (total-cost) 1)
			(increase (total-swaps) (swap-stack-count ?j ?s))
		)
	)

	(:action pickup-onto-truck					
		:parameters (?j - jig ?t - truck ?r - rack ?s ?os - side)
		:precondition (and
			(not (= ?s ?os))
			(empty ?t)
			(in ?j ?r)
			(atside ?t ?s)
			(atside ?r ?s)
			(clear ?j ?s)
			(clear ?j ?os)
		)
		:effect (and
			(in ?j ?t)
			(empty ?r)
			(not (in ?j ?r))
			(not (empty ?t))
			(not (clear ?j ?s))
			(not (clear ?j ?os))
			(decrease (level ?r) (size ?j))
			(increase (total-cost) 1)
			; (assign (rack-in-use ?r) 0)
			(increase (total-swaps) (swap-unstack-count ?j ?s))
		)
	)

	(:action unstack-onto-truck					
		:parameters (?j ?nj - jig ?t - truck ?r - rack ?s ?os - side)
		:precondition (and
			(not (= ?j ?nj))
			(not (= ?s ?os))
			(empty ?t)
			(in ?j ?r)
			(in ?nj ?r)
			(atside ?t ?s)
			(atside ?r ?s)
			(on ?j ?nj ?s)
			(on ?nj ?j ?os)
			(clear ?j ?s)
		)
		:effect (and
			(in ?j ?t)
			(not (in ?j ?r))
			(not (empty ?t))
			(not (on ?j ?nj ?s))
			(not (on ?nj ?j ?os))
			(clear ?nj ?s)
			(not (clear ?j ?s))
			(decrease (level ?r) (size ?j))
			(increase (total-cost) 1)
			(increase (total-swaps) (swap-unstack-count ?j ?s))
		)
	)

	(:action beluga-complete					
		:parameters (?b - beluga ?nb - beluga)
		:precondition (and
			(is-phase ?b)
			(<= (to-process-parts ?b) 0)
			(= 0 (unload-process ?b))
			(= 0 (load-process ?b))
			(next-arrival ?b ?nb)
		)
		:effect (and
			(not (is-phase ?b))
			(is-phase ?nb)
			(increase (total-cost) 1)
		)
	)

	(:action deliver-jig-to-hanger				
		:parameters (?j - jig ?t - truck ?h - hanger ?b - beluga ?pl - production-line)
		:precondition (and
			(is-phase ?b)
			(empty ?h)
			(in ?j ?t)
			(atside ?t fside)
			(part-of ?j ?pl)
			(= (process-order ?j) (delivery-process ?pl))
		)
		:effect (and
			(in ?j ?h)
			(not (empty ?h))
			(not (in ?j ?t))
			(empty ?t)
			(empty ?j )
			(assign (size ?j) (empty-size ?j))
			(assign (swap-unstack-count ?j bside) 0)
			(assign (swap-unstack-count ?j fside) 1)
			(assign (swap-stack-count ?j bside) 1)
			(assign (swap-stack-count ?j fside) 0)
			(decrease (delivery-process ?pl) 1)
			(decrease (to-process-parts ?b) 1)
			(increase (total-cost) 1)
		)
	)

	(:action get-jig-from-hanger			
		:parameters (?j - jig ?t - truck ?h - hanger)
		:precondition (and
			(empty ?t)
			(in ?j ?h)
			(atside ?t fside)
		)
		:effect (and
			(in ?j ?t)
			(not (in ?j ?h))
			(not (empty ?t))
			(empty ?h)
			(increase (total-cost) 1)
		)
	)

)
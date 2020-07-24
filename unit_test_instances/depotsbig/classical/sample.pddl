(define (problem depotprob7654) (:domain depot)
(:objects
	depot0 depot1 depot2 - depot
	distributor0 distributor1 distributor2 - distributor
	truck0 truck1 - truck
	pallet0 pallet1 pallet2 pallet3 pallet4 pallet5 - pallet
	crate0 crate1 crate2 crate3 crate4 crate5 - crate
	hoist0 hoist1 hoist2 hoist3 hoist4 hoist5 - hoist)
(:init
	(located pallet0 depot0)
	(clear crate1)
	(located pallet1 depot1)
	(clear crate0)
	(located pallet2 depot2)
	(clear crate4)
	(located pallet3 distributor0)
	(clear crate5)
	(located pallet4 distributor1)
	(clear pallet4)
	(located pallet5 distributor2)
	(clear crate3)
	(located truck0 depot1)
	(located truck1 depot2)

	(located hoist0 depot0)
	(available hoist0)
	(located hoist1 depot1)
	(available hoist1)
	(located hoist2 depot2)
	(available hoist2)
	(located hoist3 distributor0)
	(available hoist3)
	(located hoist4 distributor1)
	(available hoist4)
	(located hoist5 distributor2)
	(available hoist5)
	(located crate0 depot1)
	(on crate0 pallet1)
	(located crate1 depot0)
	(on crate1 pallet0)
	(located crate2 distributor2)
	(on crate2 pallet5)
	(located crate3 distributor2)
	(on crate3 crate2)
	(located crate4 depot2)
	(on crate4 pallet2)
	(located crate5 distributor0)
	(on crate5 pallet3)

)

(:goal (and
		(on crate0 crate4)
		(on crate2 pallet3)
		(on crate3 pallet0)
		(on crate4 pallet5)
	)
)

)
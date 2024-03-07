(define
	(problem beluga-4-3-1-0)
	(:domain beluga)
  (:objects
		t1 - truck
		t2 - truck
		rack1 - rack
		part1 - part
		part2 - part
		plA - rack
		beluga - rack
	)
  (:init
		(empty t1)
		(atside t1 bside)
		(empty t2)
		(atside t2 fside)
		(in part1 beluga)
		(in part2 beluga)
		(clear part1 bside)
		(clear part2 fside)
		(on part1 part2 bside)
		(on part2 part1 fside)

		(not-pline rack1)
		(not-beluga rack1)
		(empty rack1)
		(atside rack1 bside)
		(atside rack1 fside)

		(not-pline beluga)
		(atside beluga bside)
		(= (size part1) 5)
		(= (size part2) 5)

		(= (level rack1) 0)
		(= (max-level rack1) 18)

		(= (level beluga) 16)
		(= (max-level beluga) 16)
		(not-beluga plA)
		(atside plA fside)
		(empty plA)
		(= (level plA) 0)
		(= (max-level plA) 16)
		(= (total-cost) 0)

		(= (total-swaps) 0)
		(= (swap-unstack rack1 fside) 0)
		(= (swap-unstack plA fside) 0)
		(= (swap-unstack plA bside) 0)
		(= (swap-unstack beluga fside) 0)
		(= (swap-unstack beluga bside) 0)

		(= (swap-unstack rack1 bside) 1)
		(= (swap-unstack rack2 bside) 1)
		(= (swap-unstack rack3 bside) 1)


		(= (swap-stack rack1 bside) 0)
		(= (swap-stack plA fside) 0)
		(= (swap-stack plA bside) 0)
		(= (swap-stack beluga fside) 0)
		(= (swap-stack beluga bside) 0)

		(= (swap-stack rack1 fside) 1)
		(= (swap-stack rack2 fside) 1)
		(= (swap-stack rack3 fside) 1)

		(= (rack-used rack1) 0)
		(= (rack-used beluga) 0)
		(= (rack-used plA) 0)

	)
  (:goal (and
  		(<= (total-swaps) 2)
  		(<= (rack-used rack1)  2)
		(on part1 part2 bside)
		(in part2 plA)
		(in part1 plA)
	))
  (:metric minimize (total-cost))
)

;;Setting seed to 1229
(define (problem instance_3_2_1229)

	(:domain sailing)

	(:objects
		b0 b1 b2  - boat
		p0 p1  - person
	)

  (:init
		(= (x b0) 7)
(= (y b0) 0)
(= (x b1) -7)
(= (y b1) 0)
(= (x b2) -2)
(= (y b2) 0)


		(= (d p0) 32)
(= (d p1) 110)


	)

	(:goal
		(and
			(saved p0)
(saved p1)

		)
	)
)


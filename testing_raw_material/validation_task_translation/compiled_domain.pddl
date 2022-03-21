(define (domain grounded-car_linear_mt_sc)
	(:predicates
		(engine_stopped)
		(engine_running)
		(prop-true)
		(event-done--0)
		(event-done--1)
		(event-done--2)
		(event-done--3)
		(event-done--4)
		(event-done--5)
		(event-done--6)
		(event-done--7)
		(event-done--8)
		(prop-false)
	)

	(:functions
		(d)
		(v)
		(a)
		(max_acceleration)
		(min_acceleration)
		(max_speed)
		(novel-time)
		(delta)
	)

	(:action simulate_action-start_car-0
		:parameters()
		:precondition (and
			(event-done--0)
			(=
				(novel-time) 0.0) (engine_stopped)
			(not
				(prop-false)))
		:effect (and

			(not (event-done--0)) (event-done--1) (engine_running)
			(not
				(engine_stopped)))
	)

	(:action simulate_action-accelerate-1
		:parameters()
		:precondition (and
			(event-done--1)
			(=
				(novel-time) 0.0)
			(<
				(a) 2) (engine_running)
			(not
				(prop-false)))
		:effect (and

			(not (event-done--1)) (event-done--2)
			(increase (a) 1.0 ))
	)

	(:action simulate_action-decelerate-2
		:parameters()
		:precondition (and
			(event-done--2)
			(=
				(novel-time) 4.0)
			(>
				(a) -2) (engine_running)
			(not
				(prop-false)))
		:effect (and

			(not (event-done--2)) (event-done--3)
			(decrease (a) 1.0 ))
	)

	(:action simulate_action-accelerate-3
		:parameters()
		:precondition (and
			(event-done--3)
			(=
				(novel-time) 7.0)
			(<
				(a) 2) (engine_running)
			(not
				(prop-false)))
		:effect (and

			(not (event-done--3)) (event-done--4)
			(increase (a) 1.0 ))
	)

	(:action simulate_action-decelerate-4
		:parameters()
		:precondition (and
			(event-done--4)
			(=
				(novel-time) 10.0)
			(>
				(a) -2) (engine_running)
			(not
				(prop-false)))
		:effect (and

			(not (event-done--4)) (event-done--5)
			(decrease (a) 1.0 ))
	)

	(:action simulate_action-decelerate-5
		:parameters()
		:precondition (and
			(event-done--5)
			(=
				(novel-time) 12.0)
			(>
				(a) -2) (engine_running)
			(not
				(prop-false)))
		:effect (and

			(not (event-done--5)) (event-done--6)
			(decrease (a) 1.0 ))
	)

	(:action simulate_action-accelerate-6
		:parameters()
		:precondition (and
			(event-done--6)
			(=
				(novel-time) 13.0)
			(<
				(a) 2) (engine_running)
			(not
				(prop-false)))
		:effect (and

			(not (event-done--6)) (event-done--7)
			(increase (a) 1.0 ))
	)

	(:action simulate_action-stop_car-7
		:parameters()
		:precondition (and
			(event-done--7)
			(=
				(novel-time) 13.0)
			(>
				(v) -0.1)
			(<
				(v) 0.1)
			(=
				(a) 0.0) (engine_running)
			(not
				(prop-false)))
		:effect (and

			(not (event-done--7)) (event-done--8)
			(assign (v) 0.0 ) (engine_stopped)
			(not
				(engine_running)))
	)

	(:process displacement
		:parameters()
		:precondition (and
			(engine_running)
			(not (prop-false))
			(<
				(novel-time) 13.0))
		:effect (and

			(increase (d) (* #t (v)) ))
	)

	(:process moving
		:parameters()
		:precondition (and
			(engine_running)
			(not (prop-false))
			(<
				(novel-time) 13.0))
		:effect (and

			(increase (v) (* #t (a)) ))
	)

	(:process simulate_novel_time
		:parameters()
		:precondition (and

			(<
				(novel-time) 13.0)
			(not (prop-false))
			(<
				(novel-time) 13.0))
		:effect (and

			(increase
				(novel-time)
				(* #t 1)
				))
	)

)
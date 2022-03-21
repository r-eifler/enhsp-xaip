(define (domain grounded-car_linear_mt_sc)
(:predicates
	(engine_stopped)
	(engine_running)
	(pause)
	(done--0)
	(done--1)
	(done--2)
)

(:functions
	(d)
	(v)
	(a)
	(max_acceleration)
	(min_acceleration)
	(max_speed)
	(delta)
	(copy--d)
	(copy--v)
	(copy--a)
	(copy--max_acceleration)
	(copy--min_acceleration)
	(copy--max_speed)
	(copy--delta)
	(total-time)
)

(:action accelerate
 :parameters()
 :precondition 
	(and 
		
			(< 
				(a) 10 ) (engine_running) 
			(not (pause)) )
 :effect 
	(and 
		
			(increase 
				(a) 1.0 ) )
)

(:action stop_car
 :parameters()
 :precondition 
	(and 
		
			(> 
				(v) -0.1 ) 
			(< 
				(v) 0.1 ) 
			(= 
				(a) 0.0 ) (engine_running) 
			(not (pause)) )
 :effect 
	(and 
		
			(assign 
				(v) 0.0 ) (engine_stopped) 
			(not 
				(engine_running) ) )
)

(:action start_car
 :parameters()
 :precondition 
	(and 
		(engine_stopped) 
			(not (pause)) )
 :effect 
	(and 
		(engine_running) 
			(not 
				(engine_stopped) ) )
)

(:action decelerate
 :parameters()
 :precondition 
	(and 
		
			(> 
				(a) -10 ) (engine_running) 
			(not (pause)) )
 :effect 
	(and 
		
			(decrease 
				(a) 1.0 ) )
)

(:action start-simulate-processes
 :parameters()
 :precondition 
	(and 
		
			(not (pause)) )
 :effect 
	(and 
		
			(assign 
				(copy--d) (d) ) 
			(assign 
				(copy--v) (v) ) 
			(assign 
				(copy--a) (a) ) (pause) (done--0) 
			(increase 
				(total-time) (delta) ) )
)

(:action simulate--positive--displacement--0
 :parameters()
 :precondition 
	(and 
		(pause) 
			(and 
				(engine_running) ) (done--0) )
 :effect 
	(and 
		
			(increase 
				(d) 
					(* 
						(delta) (copy--v) ) ) 
			(not (done--0)) (done--1) )
)

(:action simulate--negative--displacement--0
 :parameters()
 :precondition 
	(and 
		(pause) 
			(not 
				(and 
					(engine_running) )) (done--0) )
 :effect 
	(and 
		
			(not (done--0)) (done--1) )
)

(:action simulate--positive--moving--0
 :parameters()
 :precondition 
	(and 
		(pause) 
			(and 
				(engine_running) ) (done--1) )
 :effect 
	(and 
		
			(increase 
				(v) 
					(* 
						(delta) (copy--a) ) ) 
			(not (done--1)) (done--2) )
)

(:action simulate--negative--moving--0
 :parameters()
 :precondition 
	(and 
		(pause) 
			(not 
				(and 
					(engine_running) )) (done--1) )
 :effect 
	(and 
		
			(not (done--1)) (done--2) )
)

(:action end-simulate-processes
 :parameters()
 :precondition 
	(and 
		(pause) (done--2) )
 :effect 
	(and 
		
			(not (pause)) 
			(not (done--2)) )
)

)
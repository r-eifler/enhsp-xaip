(define (problem grounded-instance_8_300_01_100)
(:domain grounded-car_linear_mt_sc)
(:init
	
	
		(= 
			(d) 0.0 ) 
		(= 
			(v) 0.0 ) (engine_stopped) 
		(= 
			(a) 0.0 ) 
		(= 
			(max_acceleration) 10 ) 
		(= 
			(min_acceleration) -10 ) 
		(= 
			(max_speed) 10.0 ) 
		(= 
			(delta) 1 ) 
		(= 
			(copy--d) 0.0 ) 
		(= 
			(copy--v) 0.0 ) 
		(= 
			(copy--a) 0.0 ) 
		(= 
			(copy--max_acceleration) 10 ) 
		(= 
			(copy--min_acceleration) -10 ) 
		(= 
			(copy--max_speed) 10.0 ) 
		(= 
			(copy--delta) 1 ) 
		(= 
			(total-time) 0.0 ) 
)
(:goal
	
	(and 
		
			(>= 
				(d) 29.5 ) 
			(<= 
				(d) 30.5 ) (engine_stopped) )
)
(:metric minimize (total-time))
)
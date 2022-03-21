(define (problem grounded-instance_2_300_01_100)
(:domain grounded-car_linear_mt_sc)
(:init
	
	
		(= 
			(d) 0.0 ) 
		(= 
			(v) 0.0 ) (engine_stopped) 
		(= 
			(a) 0.0 ) 
		(= 
			(max_acceleration) 2 ) 
		(= 
			(min_acceleration) -2 ) 
		(= 
			(max_speed) 10.0 ) (prop-true) (event-done--0) 
		(= 
			(novel-time) 0.0 ) 
)
(:goal
	
	(and 
		
			(>= 
				(d) 29.5 ) 
			(<= 
				(d) 30.5 ) (engine_stopped) (event-done--8) 
			(= 
				(novel-time) 13.0 ) )
)
(:metric minimize (total-time))
)
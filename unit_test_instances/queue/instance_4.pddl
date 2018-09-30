(define
	(problem sample)
	(:domain buffer)
	(:objects uno due tre quattro -index)
	(:init
		(next uno due)
		(next due tre)
		(next tre quattro)
		
		(= (buffer uno) 0)
		(= (buffer due) 0)
		(= (buffer tre) 0)
		(= (buffer quattro) 10)
		
	)
	(:goal
		(= (buffer uno) 10)
	)
)

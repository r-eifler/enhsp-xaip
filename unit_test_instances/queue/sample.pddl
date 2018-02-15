(define
	(problem sample)
	(:domain buffer)
	(:objects uno due -index)
	(:init
		(next uno due)
		(= (buffer uno) 0)
		(= (buffer due) 10)
	)
	(:goal
		(= (buffer uno) 10)
	)
)

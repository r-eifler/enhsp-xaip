;; in this problem we expect to find just one landmark (the goal) but with a counter set to 10
(define 
    (problem instance1)
    (:domain testing)
    (:init
	(= (counter1) 0)

    )
    (:goal 
	    (and
           	(>= (counter1) 10)
	    )
    )
)

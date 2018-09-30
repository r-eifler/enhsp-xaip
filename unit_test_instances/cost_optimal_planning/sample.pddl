
(define 
    (problem instance1)
    (:domain testing)
    (:init
	(a)
	(= (x) 2)
    )
    (:goal 
	    (and
           	(goal)
	    )
    )
    (:metric
        minimize (+ (total-cost)
         (total-cost2))
    )
)

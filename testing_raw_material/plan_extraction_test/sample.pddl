
(define 
    (problem instance1)
    (:domain testing)
    (:init
     (= (g0) 0)
     (= (g1) 0)
    )
    (:goal 
	    (and
           	(>= (g0) 10)
            (>= (g1) 10)
	    )
    )
)

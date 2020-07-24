
(define 
    (problem instance1)
    (:domain testing)
    (:init
	(c)
    (= (x) 0)
    )
    (:goal 
	    (and
           	(g1)
            (not (g2))
            (= (x) 2)
	    )
    )
)

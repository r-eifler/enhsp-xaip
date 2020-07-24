
(define 
    (problem instance1)
    (:domain testing)
    (:init
	(= (x) 20)
    (= (y) 0)
    )
    (:goal 
	    (and
           	(= (x) 0)
            (= (y) 10)
	    )
    )
)

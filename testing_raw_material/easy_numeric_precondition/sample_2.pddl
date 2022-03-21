;; in this problem we expect to find just one landmark (the goal) but with a counter set to 10
(define 
    (problem instance1)
    (:domain testing)
    (:init
        (= (x) 2)
        (= (v) 0)
        (= (y) 2)
    )
    (:goal 
	    (and
           	(= (v) 2)
            ;(>= z 10)
	    )
    )
)

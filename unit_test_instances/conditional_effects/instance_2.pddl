; expected: achiver_pre1 conditional_action1
(define 
    (problem instance1)
    (:domain testing)
    (:init
	(= (counter) 0)
    )
    (:goal 
	    (and
           	(c)
		    (pre1)
            (not (a))
	    )
    )
)

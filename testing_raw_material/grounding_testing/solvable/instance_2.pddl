
(define 
    (problem instance1)
    (:domain testing)
	(:objects c1 -caccamo c2 -caccamo)
    (:init
        (= (f1 c1) 10)
        (= (f1 c2) 0)
        (goal)
    )
    (:goal 
	    (and
           	(not (goal))
           	;(b c1 c2)
	    )
    )
)


(define 
    (problem instance1)
    (:domain testing)
	(:objects c1 -caccamo c2 -caccamo)
    (:init

        (goal)
    )
    (:goal 
	    (and
           	(not (goal))
           	(b c1 c2)
	    )
    )
)

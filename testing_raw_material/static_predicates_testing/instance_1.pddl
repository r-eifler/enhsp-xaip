
(define 
    (problem instance1)
    (:domain testing)
	(:objects c1 - caccamo c2 - caccamo c3 - caccamo c4 - caccamo c5 - caccamo)
    (:init
        (a c1 c2)
        (goal)
    )
    (:goal 
	    (and
           	(not (goal))
           	(b c1 c2)
	    )
    )
)

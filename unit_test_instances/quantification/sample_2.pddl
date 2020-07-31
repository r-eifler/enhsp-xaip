
(define 
    (problem instance1)
    (:domain testing)
    (:objects o1 o2 -obj)
    (:init
        (dummy)
        (a2 o1)
        (a2 o2)
        (a o1)
	)
    (:goal 
	    (and (exists (?o -obj) (a2 ?o ))
           	(goal))))

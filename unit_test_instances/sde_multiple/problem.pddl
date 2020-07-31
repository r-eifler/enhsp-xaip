(define (problem problem_name) (:domain domain_name)
(:objects 
)

(:init
    ;todo: put the initial state's facts and numeric values here
    (=(x)0)
    (=(y)0)
)

(:goal (and
    ;todo: put the goal condition here
    (a)
    (>= (x) 5)
))

;un-comment the following line if metric is needed
;(:metric minimize (???))
)

(define (problem name) (:domain test)
(:objects 
    a - glass
    b - thing
)

(:init
    ;todo: put the initial state's facts and numeric values here
    ;(true)
)

(:goal (and
    ;todo: put the goal condition here
        (held b)
    )
)

;un-comment the following line if metric is needed
;(:metric minimize (???))
)

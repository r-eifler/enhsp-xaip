(define (problem robot_problem_problem)
  (:domain robot_problem)
  (:objects
    l1 l2 - Location
  )
  (:init
    (is_at l1)
    (= (battery_charge) 5)
  )
  (:goal
    (and (is_at l1) (visited l2))
  )
)
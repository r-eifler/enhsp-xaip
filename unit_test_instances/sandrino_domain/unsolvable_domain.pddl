(define (domain robot_problem)
  (:types
    Location
  )
  (:predicates
    (is_at ?p0 - Location)
    (visited ?p0 - Location)
  )
  (:functions
    (battery_charge)
  )
  (:action move
    :parameters ( ?l_from - Location ?l_to - Location)
    :precondition (and (<= 2 (battery_charge)) (is_at ?l_from) (not (is_at ?l_to)))
    :effect (and (is_at ?l_to) (not (is_at ?l_from)) (decrease (battery_charge) 2) (visited ?l_to))
  )
)
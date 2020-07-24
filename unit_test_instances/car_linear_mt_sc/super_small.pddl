;; Enrico Scala (enricos83@gmail.com) and Miquel Ramirez (miquel.ramirez@gmail.com)
(define
  (problem car_max_accel_3)
  (:domain car)

  (:init
  (running)
    (= (d) 0.0)
	(= (v) 0.0)
	(= (a) 0.0)
	(= (up_limit) 2)
	(= (down_limit) -2)
  )

  (:goal
    (and 
	(>= (d) 10 )
	(<= (d) 20 )
	(goal_reached)
	)
  )
)


(define (problem task01)
	(:domain transport)
	(:objects r1 - robot l1 l2 l3 l4 - location)
	(:init 
		;(road l1 l2)
		(road l1 l4)
		(road l4 l2)
		(road l2 l3)
		(road l3 l4)
		(in r1 l1)
		(= (total-fuel) 10)

	)
	(:goal (and (infoSent l2) (infoSent l3)  (< (total-fuel) 100))
	)
	(:metric minimize(+ (power r1) (totol-fuel r) (time) ))

      
)

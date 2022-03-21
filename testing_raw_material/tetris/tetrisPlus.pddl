; Domain: Tetris+
; Author: Mauro Vallati

(define (domain tetris)
  (:types  
	one_square two_straight right_l - pieces
	position 	
	)

  (:predicates
    (clear ?xy - position)
    (connected ?x - position ?y - position )
    (in_use ?p - one_square)
    (at_square ?element - one_square ?xy - position)
    (at_two ?element - two_straight ?xy - position ?xy2 - position)
    (at_right_l ?element - right_l ?xy - position ?xy2 - position ?xy3 - position)
    (moving_square ?element - one_square ?xyi ?xyf - position)
    (moving_from_two ?element - two_straight ?xy - position ?xy2 - position)
    (moving_from_right_l ?element - right_l ?xy - position ?xy2 - position ?xy3 - position)

  )
(:functions 
(timemovement ?p - one_square)
(moving-square)
(moving-two)
(moving-rightl)
)

;; start move a 1 square piece
(:action start_move_square
  :parameters (?xy_initial - position ?xy_final - position ?element - one_square )
  :precondition (and 
		(not (in_use ?element))
		(clear ?xy_final) 
		(at_square ?element ?xy_initial) 
		(connected ?xy_initial ?xy_final)
		(connected ?xy_final ?xy_initial)  
		)
  :effect (and  
		(moving_square ?element ?xy_initial ?xy_final)
		(in_use ?element)
		(assign (timemovement ?element) 0)
		(not (clear ?xy_final))
		)
)



(:process moving_square
  :parameters (?xy_initial ?xy_final - position ?element - one_square )
  :precondition (and 
		(moving_square ?element ?xy_initial ?xy_final)
		(in_use ?element)
		)
  :effect (and
		(increase (timemovement ?element) #t )
		)
)


(:event stop_square
:parameters (?xy_initial ?xy_final - position ?element - one_square )
:precondition (and
		(moving_square ?element ?xy_initial ?xy_final)
		(in_use ?element)
		(> (timemovement ?element) (moving-square))
		)

:effect (and 
		(assign (timemovement ?element) 0)
		(not (in_use ?element))
		(clear ?xy_initial)
		(at_square ?element ?xy_final)
		(not (moving_square ?element ?xy_initial ?xy_final))
		)
)


)

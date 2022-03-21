;; Enrico Scala (enricos83@gmail.com)
;; Follow the comments through the file to fill the missing information in

(define (problem prova)
	(:domain mais)

	(:objects  Carico_scarico0 Traslatore776 Acceleratore15995 - tank
		c1 c2  - cart
		r1  - rack)

  (:init

    ;;position tanks
	(= (x Carico_scarico0) 0)
	(= (x Traslatore776) 776)
	(= (x Acceleratore15995) 15995)

    (= (travel_distance Carico_scarico0 Traslatore776) 2)
    (= (travel_distance Traslatore776 Carico_scarico0) 2)
    (= (travel_distance Carico_scarico0 Acceleratore15995) 28)
    (= (travel_distance Acceleratore15995 Carico_scarico0) 28)
    (= (travel_distance Traslatore776 Acceleratore15995) 27)
    (= (travel_distance Acceleratore15995 Traslatore776) 27)
    
    
 
	(empty Traslatore776)
	(empty Acceleratore15995)


	(is_at r1 Carico_scarico0)
	(= (status r1) 0)


    ;;carts information
    (is_at c1 Carico_scarico0)
    (empty c1)
	(= (x c1) 0)
	(= (min_x c1) 0)
	(= (max_x c1) 18000)
    (= (distance_to_objective c1) 0)

	(is_at c2 Acceleratore15995)
	(empty c2)
	(= (x c2) 15995)
	(= (min_x c2) 500)
	(= (max_x c2) 20000)
	(= (distance_to_objective c2) 0)

	(right c1 c2)

	(= (im_time r1 Carico_scarico0) 3)
	(= (min_tol_im_time r1 Carico_scarico0) 0)
	(= (max_tol_im_time r1 Carico_scarico0) -1)
	(= (im_time r1 Traslatore776) 50)
	(= (min_tol_im_time r1 Traslatore776) 5)
	(= (max_tol_im_time r1 Traslatore776) -5)
	(= (im_time r1 Acceleratore15995) 10)
	(= (min_tol_im_time r1 Acceleratore15995) 5)
	(= (max_tol_im_time r1 Acceleratore15995) -5)
 

	(= (stage r1 Carico_scarico0) 0)
	(= (stage r1 Traslatore776) 1)
	(= (stage r1 Acceleratore15995) 2)
	(prev r1 Carico_scarico0 Traslatore776)
	(prev r1 Carico_scarico0 Acceleratore15995)
    (prev r1 Traslatore776 Acceleratore15995)
	
)
	(:goal
		(and
		    (worked r1 Carico_scarico0)
		    (worked r1 Traslatore776)
		    (worked r1 Acceleratore15995)
			)))


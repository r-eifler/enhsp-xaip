(define 
    (domain mais)
    (:types metric_locatable -object cart tank -metric_locatable rack -object)
    (:predicates
        (empty ?c -cart) ;; this models whether the cart is empty or not
        (empty ?t -tank) ;; this models whether the tank already contains a rack or not
        (holding ?c -cart ?r -rack) ;; this models whether the rack is held by the cart
        (is_at ?r -rack ?t -tank) ;; this models whether the rack is in the tank. Would be nice to have enum variable to represent position of object.
        (is_at ?r -rack ?c -cart) ;; this models whether the rack is in the cart
        (is_at ?c -cart ?t -tank) ;; this models whether a cart is at the same location of a tank
        (right ?c1 ?c2 -cart) ;; this models whether a cart is on the right of another cart. We assume a linear production fabric at the moment
        (worked ?r -rack ?t -tank) ;; says that a rack has been processed and loaded
        (ready ?r -rack ?t -tank) ;; says that a rack is ready to be picked up
        (moving ?c -cart ?from -tank ?to -tank) ;;models whether the cart is moving or not
        (prev ?r -rack ?t1 ?t2 -tank) ;; temporal predicate
    )
    (:functions
        (im_time ?r -rack ?t -tank) ;;this models the immersion time, depends on the recipe
        (min_tol_im_time ?r -rack ?t -tank) ;;this models the minimum immersion time, depends on the recipe
        (max_tol_im_time ?r -rack ?t -tank) ;;this models the minimum immersion time, depends on the recipe
        (x ?r -metric_locatable) ;; position x of a metric_locatable object
        (stage ?r -rack ?t -tank) ;; give information on when the rack can stay in the tank; again depends on the recipe
        (status ?r -rack) ;; give information about current status of the rack. It is incremented every time the rack has been processed and needs to be worked on in the next tank
        (min_x ?r -cart) ;;define range for movement of the cart
        (max_x ?r -cart)
        (distance_to_objective ?c ?from -tank ?to -tank)
        (travel_distance ?c ?from -tank ?to -tank)
        (total-cost)
    )
    
    (:constraint not_crossing
        :parameters (?c1 ?c2 -cart)
        :condition (or (not (right ?c1 ?c2)) (= ?c1 ?c2) (< (x ?c1) (-(x ?c2) 300)))
    )
    
    (:constraint boundaries
        :parameters (?c1 -cart)
        :condition (and (<= (x ?c1) (max_x ?c1)) (>= (x ?c1) (min_x ?c1)) )
    )
   
    (:constraint im_time_boundaries
        :parameters (?r -rack ?t -tank)
        :condition (not (< (im_time ?r ?t) (max_tol_im_time ?r ?t)))
    )


    (:action load
        :parameters (?c -cart  ?r -rack ?l -tank)
        :precondition (and 
                          (is_at ?r ?l)
                          (is_at ?c ?l)
                          ;(= (x ?c) (x ?l))
                          
                          ;;control rules
                              ;;load only you can then unload it. Of course ?l1 has to be different from ?l and has to be at a next stage
                              ;(forall (?l1 -tank) (or (= ?l ?l1) (> (-(stage ?r ?l)1) (stage ?r ?l1)) (< (+(stage ?r ?l)1) (stage ?r ?l1)) (and (>= (x ?l1) (min_x ?c))(<= (x ?l1) (max_x ?c)))))
                              ;;do not violate the order. To be seen whether this pays off
                              (forall (?l1 -tank) (or (= ?l ?l1) (< (stage ?r ?l) (stage ?r ?l1)) (worked ?r ?l1))) 
                          
                          (empty ?c)
                          (ready ?r ?l)
                          (= (stage ?r ?l) (status ?r)))
        :effect (and 
                    (empty ?l)
                    (is_at ?r ?c)
                    (not (is_at ?r ?l))
                    (not (empty ?c))
                    (holding ?c ?r)
                    (worked ?r ?l)
                    (increase (status ?r) 1)))

    (:action unload
        :parameters (?c -cart  ?r -rack ?l -tank)
        :precondition (and 
                          (is_at ?c ?l)
                          (is_at ?r ?c)
                          (holding ?c ?r)
                          (empty ?l)
                          (= (stage ?r ?l) (status ?r)))
        :effect (and
                    (not (is_at ?r ?c))
                    (not (holding ?c ?r))
                    (not (empty ?l))
                    (is_at ?r ?l)
                    (empty ?c)))
                    
    (:process processing_rack
        :parameters (?r -rack ?l -tank)
        :precondition (and 
                          (is_at ?r ?l))
        :effect (decrease (im_time ?r ?l) (* #t 1 )))
    
    (:event rack_is_ready
        :parameters (?r -rack ?l -tank)
        :precondition (and
                          (not (ready ?r ?l)) 
                          (<= (im_time ?r ?l) (min_tol_im_time ?r ?l))
                          (>= (im_time ?r ?l) (max_tol_im_time ?r ?l)))
        :effect (ready ?r ?l))

    (:action move_to_tank 
        :parameters (?c -cart ?from ?to -tank)
        :precondition (and
                          (is_at ?c ?from)
                          (not (= ?from ?to))
                          (not (moving ?c ?from ?to))
                          (>= (x ?to) (min_x ?c))
                          (<= (x ?to) (max_x ?c))
                          (forall (?c1 -cart) (or (= ?c1 ?c) (not (right ?c ?c1)) (> (x ?c1) (x ?to))))
                          )
        :effect (and
                    (moving ?c ?from ?to)
                    (not (is_at ?c ?from))
                    ;(increase (total-cost) (travel_distance ?c ?from ?to))
                    (increase (distance_to_objective ?c ?from ?to) (travel_distance  ?c ?from ?to))))

    (:process moving
        :parameters (?c -cart ?from ?to -tank)
        :precondition (and
                          (not (= ?from ?to))
                          (moving ?c ?from ?to)
                          (> (distance_to_objective ?c ?from ?to) 0))
        :effect (and
                    (decrease (distance_to_objective ?c ?from ?to) (* #t 1 ))))   
                
    (:event arrived
        :parameters (?c -cart ?from -tank ?to -tank)
        :precondition (and
                          (not (= ?from ?to))
                          (not (is_at ?c ?to))
                          (moving ?c ?from ?to)
                          (= (distance_to_objective ?c ?from ?to) 0))
        :effect (and
                    (is_at ?c ?to)
                    (not (moving ?c ?from ?to))
                    (assign (x ?c) (x ?to)))))     
    

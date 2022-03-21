(define (domain domain-tms-2-3-light)
(:requirements :strips :typing)
(:types
   piece - object
   kiln - object
   piecetype1 - piece
   piecetype2 - piece
   piecetype3 - piece
   kiln8 - kiln
   kiln20 - kiln)
(:predicates
   (energy)
   (ready ?k - kiln)
   (baking ?p - piece)
   (treated ?p - piece)
   (baked ?p - piece)
   (structured ?p1 - piece ?p2 - piece)
   (baked-structure ?p1 - piece ?p2 - piece)
   (compiled_treat-ceramic3_started ?p - piecetype3)
   (compiled_make-structure_started ?p1 - piece ?p2 - piece)
   (compiled_bake-structure_started ?p1 - piece ?p2 - piece ?k - kiln)
   (compiled_bake-ceramic1_started ?p - piecetype1 ?k - kiln)
   (compiled_fire-kiln2_started ?k - kiln20)
   (compiled_fire-kiln1_started ?k - kiln8)
   (compiled_bake-ceramic2_started ?p - piecetype2 ?k - kiln)
   (compiled_bake-ceramic3_started ?p - piecetype3 ?k - kiln)
   (compiled_treat-ceramic2_started ?p - piecetype2)
   (compiled_treat-ceramic1_started ?p - piece))
(:constraint fire-kiln2__overall_constraint
   :parameters (?k - kiln20)
   :condition (or (not (compiled_fire-kiln2_started ?k)) (energy)))
(:constraint bake-structure__overall_constraint
   :parameters (?p1 - piece ?p2 - piece ?k - kiln)
   :condition (or (not (compiled_bake-structure_started ?p1 ?p2 ?k)) (ready ?k)))
(:constraint treat-ceramic2__overall_constraint
   :parameters (?p - piecetype2)
   :condition (or (not (compiled_treat-ceramic2_started ?p)) (baking ?p)))
(:constraint bake-ceramic1__overall_constraint
   :parameters (?p - piecetype1 ?k - kiln)
   :condition (or (not (compiled_bake-ceramic1_started ?p ?k)) (ready ?k)))
(:constraint make-structure__overall_constraint
   :parameters (?p1 - piece ?p2 - piece)
   :condition (or (not (compiled_make-structure_started ?p1 ?p2)) (baked ?p1)))
(:constraint fire-kiln1__overall_constraint
   :parameters (?k - kiln8)
   :condition (or (not (compiled_fire-kiln1_started ?k)) (energy)))
(:constraint bake-ceramic3__overall_constraint
   :parameters (?p - piecetype3 ?k - kiln)
   :condition (or (not (compiled_bake-ceramic3_started ?p ?k)) (ready ?k)))
(:constraint treat-ceramic3__overall_constraint
   :parameters (?p - piecetype3)
   :condition (or (not (compiled_treat-ceramic3_started ?p)) (baking ?p)))
(:constraint treat-ceramic1__overall_constraint
   :parameters (?p - piece)
   :condition (or (not (compiled_treat-ceramic1_started ?p)) (baking ?p)))
(:constraint bake-ceramic2__overall_constraint
   :parameters (?p - piecetype2 ?k - kiln)
   :condition (or (not (compiled_bake-ceramic2_started ?p ?k)) (ready ?k)))
(:action compiled_treat-ceramic3_start
   :parameters (?p - piecetype3)
   :precondition (and (not (compiled_treat-ceramic3_started ?p)) (baking ?p))
   :effect (and (compiled_treat-ceramic3_started ?p)))
(:action compiled_treat-ceramic3_end
   :parameters (?p - piecetype3)
   :precondition (and (compiled_treat-ceramic3_started ?p) (baking ?p))
   :effect (and (not (compiled_treat-ceramic3_started ?p)) (treated ?p)))
(:action compiled_make-structure_start
   :parameters (?p1 - piece ?p2 - piece)
   :precondition (and (not (compiled_make-structure_started ?p1 ?p2)) (baked ?p1) (treated ?p1) (baked ?p2) (treated ?p2))
   :effect (and (compiled_make-structure_started ?p1 ?p2)))
(:action compiled_make-structure_end
   :parameters (?p1 - piece ?p2 - piece)
   :precondition (and (compiled_make-structure_started ?p1 ?p2) (baked ?p1) (treated ?p1) (baked ?p2) (treated ?p2))
   :effect (and (not (compiled_make-structure_started ?p1 ?p2)) (structured ?p1 ?p2)))
(:action compiled_bake-structure_start
   :parameters (?p1 - piece ?p2 - piece ?k - kiln)
   :precondition (and (not (compiled_bake-structure_started ?p1 ?p2 ?k)) (ready ?k) (structured ?p1 ?p2))
   :effect (and (compiled_bake-structure_started ?p1 ?p2 ?k) (not (baked-structure ?p1 ?p2))))
(:action compiled_bake-structure_end
   :parameters (?p1 - piece ?p2 - piece ?k - kiln)
   :precondition (and (compiled_bake-structure_started ?p1 ?p2 ?k) (ready ?k) (structured ?p1 ?p2))
   :effect (and (not (compiled_bake-structure_started ?p1 ?p2 ?k)) (baked-structure ?p1 ?p2)))
(:action compiled_bake-ceramic1_start
   :parameters (?p - piecetype1 ?k - kiln)
   :precondition (and (not (compiled_bake-ceramic1_started ?p ?k)) (ready ?k))
   :effect (and (compiled_bake-ceramic1_started ?p ?k) (not (baked ?p)) (baking ?p)))
(:action compiled_bake-ceramic1_end
   :parameters (?p - piecetype1 ?k - kiln)
   :precondition (and (compiled_bake-ceramic1_started ?p ?k) (ready ?k))
   :effect (and (not (compiled_bake-ceramic1_started ?p ?k)) (not (baking ?p)) (baked ?p)))
(:action compiled_fire-kiln2_start
   :parameters (?k - kiln20)
   :precondition (and (not (compiled_fire-kiln2_started ?k)) (energy))
   :effect (and (compiled_fire-kiln2_started ?k) (ready ?k)))
(:action compiled_fire-kiln2_end
   :parameters (?k - kiln20)
   :precondition (and (compiled_fire-kiln2_started ?k) (energy))
   :effect (and (not (compiled_fire-kiln2_started ?k)) (not (ready ?k))))
(:action compiled_fire-kiln1_start
   :parameters (?k - kiln8)
   :precondition (and (not (compiled_fire-kiln1_started ?k)) (energy))
   :effect (and (compiled_fire-kiln1_started ?k) (ready ?k)))
(:action compiled_fire-kiln1_end
   :parameters (?k - kiln8)
   :precondition (and (compiled_fire-kiln1_started ?k) (energy))
   :effect (and (not (compiled_fire-kiln1_started ?k)) (not (ready ?k))))
(:action compiled_bake-ceramic2_start
   :parameters (?p - piecetype2 ?k - kiln)
   :precondition (and (not (compiled_bake-ceramic2_started ?p ?k)) (ready ?k))
   :effect (and (compiled_bake-ceramic2_started ?p ?k) (not (baked ?p)) (baking ?p)))
(:action compiled_bake-ceramic2_end
   :parameters (?p - piecetype2 ?k - kiln)
   :precondition (and (compiled_bake-ceramic2_started ?p ?k) (ready ?k))
   :effect (and (not (compiled_bake-ceramic2_started ?p ?k)) (not (baking ?p)) (baked ?p)))
(:action compiled_bake-ceramic3_start
   :parameters (?p - piecetype3 ?k - kiln)
   :precondition (and (not (compiled_bake-ceramic3_started ?p ?k)) (ready ?k))
   :effect (and (compiled_bake-ceramic3_started ?p ?k) (not (baked ?p)) (baking ?p)))
(:action compiled_bake-ceramic3_end
   :parameters (?p - piecetype3 ?k - kiln)
   :precondition (and (compiled_bake-ceramic3_started ?p ?k) (ready ?k))
   :effect (and (not (compiled_bake-ceramic3_started ?p ?k)) (not (baking ?p)) (baked ?p)))
(:action compiled_treat-ceramic2_start
   :parameters (?p - piecetype2)
   :precondition (and (not (compiled_treat-ceramic2_started ?p)) (baking ?p))
   :effect (and (compiled_treat-ceramic2_started ?p)))
(:action compiled_treat-ceramic2_end
   :parameters (?p - piecetype2)
   :precondition (and (compiled_treat-ceramic2_started ?p) (baking ?p))
   :effect (and (not (compiled_treat-ceramic2_started ?p)) (treated ?p)))
(:action compiled_treat-ceramic1_start
   :parameters (?p - piece)
   :precondition (and (not (compiled_treat-ceramic1_started ?p)) (baking ?p))
   :effect (and (compiled_treat-ceramic1_started ?p)))
(:action compiled_treat-ceramic1_end
   :parameters (?p - piece)
   :precondition (and (compiled_treat-ceramic1_started ?p) (baking ?p))
   :effect (and (not (compiled_treat-ceramic1_started ?p)) (treated ?p)))
)

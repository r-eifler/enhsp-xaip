(define (problem b2) (:domain test)
        (:objects 
           int0  - interpretation 
           int1  - interpretation 
        )
        (:init 
          (a int0)
          (b int1)
        )
        (:goal (forall (?i - interpretation)(and   (a ?i) ))))

(define (domain test)
;(:requirements  :typing)
(:types interpretation  block - object )
(:predicates  (a ?i -interpretation) (b ?i -interpretation) (c) ) 


  (:action set-a-or-b-depending-on-current-value-of-a-b
          :parameters ()
          :effect (and 
                    (c)
                    (forall (?i -interpretation) 
                      (when (b ?i)  (a ?i) )) 
                    
                    (forall (?i -interpretation) 
                      (when (b ?i)  (a ?i) )) 
                    
                  )
  )
)


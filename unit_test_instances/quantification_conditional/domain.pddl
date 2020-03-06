(define (domain test)
;(:requirements  :typing)
(:types interpretation  block - object )
(:predicates  (a ?i -interpretation) (b ?i -interpretation) ) 


(:action set-a-or-b-depending-on-current-value-of-a-b
        :parameters ()
        :effect (and 
                   (forall (?i -interpretation) 
                     (when (b ?i)  (a ?i) )) 
                   ))
)


(define 
	(domain buffer)
	(:types index)
	(:predicates (next ?i ?j -index))
	(:functions (buffer ?i -index))
	
	;; this describes the shift of an object from one position j to the other i only when the latter is empty (encoded with a 0), and incoming is not empty 
	(:event shift
		:parameters (?j ?i -index)
		:precondition (and (next ?i ?j) (= (buffer ?i) 0) (>= (buffer ?j) 1))
		:effect
			(and
            	(assign (buffer ?i) (buffer ?j))
            	(assign (buffer ?j) 0)
            )
            		    
 	)
 	
)

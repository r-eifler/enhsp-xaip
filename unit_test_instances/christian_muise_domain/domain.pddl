(define (domain chains)
    (:predicates
        (open ?ring)
        (connected ?ring1 ?ring2)
        (done ?ring)
        (endphase)
        (endring ?ring)
    )

    (:functions (total-cost) - number)



    (:action split
        :parameters (?ring - object)
        :precondition (and (not (endphase)) (not (open ?ring)))
        :effect (and (open ?ring)
                     (increase (total-cost) 1))
    )
    
    (:action weld
        :parameters (?ring - object)
        :precondition (and (not (endphase)) (open ?ring))
        :effect (and (not (open ?ring))
                     (increase (total-cost) 1))
    )
    
    (:action link
        :parameters (?ring1 ?ring2 - object)
        :precondition (and (not (endphase))
                           (open ?ring2)
                           (not (connected ?ring1 ?ring2))
                           (not (connected ?ring2 ?ring1)))
        :effect (and (connected ?ring1 ?ring2)
                     (connected ?ring2 ?ring1)
                     (increase (total-cost) 0))
    )
    
    (:action unlink
        :parameters (?ring1 ?ring2 - object)
        :precondition (and (not (endphase))
                           (open ?ring2)
                           (connected ?ring1 ?ring2)
                           (connected ?ring2 ?ring1))
        :effect (and (not (connected ?ring1 ?ring2))
                     (not (connected ?ring2 ?ring1))
                     (increase (total-cost) 0))
    )
    
    (:action start_end
        :parameters (?ring - object)
        :precondition (and (not (endphase)) (not (open ?ring)))
        :effect (and
            (done ?ring)
            (endphase)
            (endring ?ring)
            (increase (total-cost) 0)
        )
    )
    
    (:action continue_end
        :parameters (?ring1 ?ring2 - object)
        :precondition (and (done ?ring1)
                           (endring ?ring1)
                           (not (done ?ring2))
                           (endphase)
                           (connected ?ring1 ?ring2)
                           (not (open ?ring2)))
        :effect (and
            (not (endring ?ring1))
            (endring ?ring2)
            (done ?ring2)
            (increase (total-cost) 0)
        )
    )
)
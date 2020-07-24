
 (define (problem p5-of-3)
  (:domain chains)
  (:objects r1 r2 r3 r4 r5 r6 r7 r8 r9 r10 r11 r12 r13 r14 r15 - object)
 
  (:init
  
    (connected r1 r2)
    (connected r2 r1)
    (connected r2 r3)
    (connected r3 r2)
    
    (connected r4 r5)
    (connected r5 r4)
    (connected r5 r6)
    (connected r6 r5)
    
    (connected r7 r8)
    (connected r8 r7)
    (connected r8 r9)
    (connected r9 r8)
    
    (connected r10 r11)
    (connected r11 r10)
    (connected r11 r12)
    (connected r12 r11)
    
    (connected r13 r14)
    (connected r14 r13)
    (connected r14 r15)
    (connected r15 r14)
    
    (= (total-cost) 0)
    
  )
  
  (:goal (and
    (done r1)
    (done r2)
    (done r3)
    (done r4)
    (done r5)
    (done r6)
    (done r7)
    (done r8)
    (done r9)
    (done r10)
    (done r11)
    (done r12)
    (done r13)
    (done r14)
    (done r15)
  ))
  
  (:metric minimize (total-cost))

)
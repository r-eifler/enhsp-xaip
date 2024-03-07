(define
	(problem beluga-6-5-1-0)
	(:domain beluga)
	; 
  (:objects
		t1 - truck
		t2 - truck
		rack1 - rack
		rack2 - rack
		rack3 - rack
		rack4 - rack
		rack5 - rack
		part1 - part
		part2 - part
		part3 - part
		part4 - part
		part5 - part
		part6 - part
		plA - rack
		beluga - rack
	)
	; Beluga arrival order:
	; 0: part6
	; 1: part4
	; 2: part1
	; 3: part3
	; 4: part2
	; 5: part5
  (:init
		(empty t1)
		(atside t1 bside)
		(empty t2)
		(atside t2 fside)
		(in part1 beluga)
		(in part2 beluga)
		(in part3 beluga)
		(in part4 beluga)
		(in part5 beluga)
		(in part6 beluga)
		(clear part6 bside)
		(clear part5 fside)
		(on part6 part4 bside)
		(on part4 part6 fside)
		(on part4 part1 bside)
		(on part1 part4 fside)
		(on part1 part3 bside)
		(on part3 part1 fside)
		(on part3 part2 bside)
		(on part2 part3 fside)
		(on part2 part5 bside)
		(on part5 part2 fside)
		(not-pline rack1)
		(not-beluga rack1)
		(empty rack1)
		(atside rack1 bside)
		(atside rack1 fside)
		(not-pline rack2)
		(not-beluga rack2)
		(empty rack2)
		(atside rack2 bside)
		(atside rack2 fside)
		(not-pline rack3)
		(not-beluga rack3)
		(empty rack3)
		(atside rack3 bside)
		(atside rack3 fside)
		(not-pline rack4)
		(not-beluga rack4)
		(empty rack4)
		(atside rack4 bside)
		(atside rack4 fside)
		(not-pline rack5)
		(not-beluga rack5)
		(empty rack5)
		(atside rack5 bside)
		(atside rack5 fside)
		(not-pline beluga)
		(atside beluga bside)
		(= (size part1) 5)
		(= (size part2) 5)
		(= (size part3) 2)
		(= (size part4) 4)
		(= (size part5) 5)
		(= (size part6) 5)
		(= (level rack1) 0)
		(= (max-level rack1) 14)
		(= (level rack2) 0)
		(= (max-level rack2) 17)
		(= (level rack3) 0)
		(= (max-level rack3) 15)
		(= (level rack4) 0)
		(= (max-level rack4) 19)
		(= (level rack5) 0)
		(= (max-level rack5) 13)
		(= (level beluga) 26)
		(= (max-level beluga) 26)
		(not-beluga plA)
		(atside plA fside)
		(empty plA)
		(= (level plA) 0)
		(= (max-level plA) 26)
		(= (total-cost) 0)

        (= (total-swaps) 0)
        (= (swap-unstack rack1 fside) 0)
        (= (swap-unstack rack2 fside) 0)
        (= (swap-unstack rack3 fside) 0)
        (= (swap-unstack rack4 fside) 0)
        (= (swap-unstack rack5 fside) 0)
        (= (swap-unstack plA fside) 0)
        (= (swap-unstack plA bside) 0)
        (= (swap-unstack beluga fside) 0)
        (= (swap-unstack beluga bside) 0)

        (= (swap-unstack rack1 bside) 1)
        (= (swap-unstack rack2 bside) 1)
        (= (swap-unstack rack3 bside) 1)
        (= (swap-unstack rack4 bside) 1)
        (= (swap-unstack rack5 bside) 1)


        (= (swap-stack rack1 bside) 0)
        (= (swap-stack rack2 bside) 0)
        (= (swap-stack rack3 bside) 0)
        (= (swap-stack rack4 bside) 0)
        (= (swap-stack rack5 bside) 0)
        (= (swap-stack plA fside) 0)
        (= (swap-stack plA bside) 0)
        (= (swap-stack beluga fside) 0)
        (= (swap-stack beluga bside) 0)

        (= (swap-stack rack1 fside) 1)
        (= (swap-stack rack2 fside) 1)
        (= (swap-stack rack3 fside) 1)
        (= (swap-stack rack4 fside) 1)
        (= (swap-stack rack5 fside) 1)

        (= (rack-used rack1) 0)
        (= (rack-used rack2) 0)
        (= (rack-used rack3) 0)
        (= (rack-used rack4) 0)
        (= (rack-used rack5) 0)
        (= (rack-used beluga) 0)
        (= (rack-used plA) 0)
	)
	; delivery order line plA: 
	; 0: part5
	; 1: part3
	; 2: part2
	; 3: part4
	; 4: part1
	; 5: part6
  (:goal (and
        (<= (total-swaps) 2)
        (<= (+ (rack-used rack1) (+ (rack-used rack2) (+ (rack-used rack3) (+ (rack-used rack4) (rack-used rack5))))) 4)
		(on part3 part5 fside)
		(in part5 plA)
		(on part2 part3 fside)
		(in part3 plA)
		(on part4 part2 fside)
		(in part2 plA)
		(on part1 part4 fside)
		(in part4 plA)
		(on part6 part1 fside)
		(in part1 plA)
		(in part6 plA)
	))
  (:metric minimize (total-cost))
)

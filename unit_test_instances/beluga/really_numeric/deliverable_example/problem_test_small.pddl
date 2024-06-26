(define
	(problem beluga-db)
	(:domain beluga)
  (:objects
		bt1 - truck
		ft1 - truck
		ft2 - truck

		rack1 - rack
		rack2 - rack
		rack3 - rack
		; rack4 - rack
		; rack5 - rack

		; jigc - jig-type
		; jigb - jig-type
		; jigt - jig-type
		; jigw - jig-type

		jig0c - jig
		jig0b - jig
		jig0t - jig
		jig0wl - jig
		jig0wr - jig

		jig1c - jig
		jig1b - jig
		jig1t - jig
		jig1wl - jig
		jig1wr - jig

		jig2c - jig
		jig2b - jig
		jig2t - jig
		jig2wl - jig
		jig2wr - jig

		beluga1 - beluga
		beluga2 - beluga
		beluga3 - beluga

		hanger1 - hanger

		plA1 - production-line
	)
  (:init

		; TRUCKS
		(empty bt1)
		(atside bt1 bside)

		(empty ft1)
		(atside ft1 fside)

		(empty ft2)
		(atside ft2 fside)

		(empty hanger1)

		; ARRIVAL SHEDULE
		(is-phase beluga1)
		( = (to-process-parts beluga1) 0)
		(next-arrival beluga1 beluga2)
		( = (to-process-parts beluga2) 0)
		(next-arrival beluga2 beluga3)
		( = (to-process-parts beluga3) 0)

		(= (unload-process beluga1) 2)
		(= (load-process beluga1) 2)

		(= (unload-process beluga2) 3)
		(= (load-process beluga2) 3)

		(= (unload-process beluga3) 2)
		(= (load-process beluga3) 2)
		

		; JIGS
		; airplaine 0 (all empty)
		(empty jig0c)
		(outgoing jig0c beluga2)
		(= (size jig0c) 2)
		(= (empty-size jig0c) 2)
		(= (load-order jig0c) 2)

		(empty jig0b)
		(outgoing jig0b beluga1)
		(= (size jig0b) 2)
		(= (empty-size jig0b) 2)
		(= (load-order jig0b) 2)

		; (empty jig0wl)
		; (outgoing jig0wl beluga2)
		; (= (size jig0wl) 4)
		; (= (empty-size jig0wl) 4)
		; (= (load-order jig0wl) 1)

		; (empty jig0wr)
		; (= (size jig0wr) 4)
		; (= (empty-size jig0wr) 4)

		; (empty jig0t)
		; (= (size jig0t) 1)
		; (= (empty-size jig0t) 1)


		; airplaine 1
		; (in jig1c beluga1)
		; (part-of jig1c plA1)
		; (outgoing jig1c beluga2)
		; (= (size jig1c) 3)
		; (= (empty-size jig1c) 2)
		; (= (unload-order jig1c) 3)
		; (= (load-order jig1c) 3)
		; (= (process-order jig1c) 8)

		(in jig1b beluga1)
		(part-of jig1b plA1)
		(outgoing jig1b beluga1)
		(= (size jig1b) 3)
		(= (empty-size jig1b) 2)
		(= (unload-order jig1b) 2)
		(= (load-order jig1b) 1)
		(= (process-order jig1b) 5)

		(in jig1wl beluga2)
		(part-of jig1wl plA1)
		(outgoing jig1wl beluga3)
		(= (size jig1wl) 6)
		(= (empty-size jig1wl) 4)
		(= (unload-order jig1wl) 2)
		(= (load-order jig1wl) 2)
		(= (process-order jig1wl) 1)

		(in jig1wr beluga3)
		(part-of jig1wr plA1)
		; (outgoing jigw beluga3)
		(= (size jig1wr) 6)
		(= (empty-size jig1wr) 4)
		(= (unload-order jig1wr) 1)
		; (= (load-order jigw) 1)
		(= (process-order jig1wr) 2)

		(in jig1t beluga2)
		(part-of jig1t plA1)
		(outgoing jig1t beluga2)
		(= (size jig1t) 2)
		(= (empty-size jig1t) 1)
		(= (unload-order jig1t) 1)
		(= (load-order jig1t) 1)
		(= (process-order jig1t) 4)


		; airplane 2
		(in jig2c beluga2)
		(part-of jig2c plA1)
		(outgoing jig2c beluga3)
		(= (size jig2c) 3)
		(= (empty-size jig2c) 2)
		(= (unload-order jig2c) 3)
		(= (load-order jig2c) 1)
		(= (process-order jig2c) 3)

		(in jig2b beluga1)
		(part-of jig2b plA1)
		(outgoing jig2b beluga2)
		(= (size jig2b) 3)
		(= (empty-size jig2b) 2)
		(= (unload-order jig2b) 1)
		(= (load-order jig2b) 3)
		(= (process-order jig2b) 6)

		; (in jig2wl beluga2)
		; (part-of jig2wl plA1)
		; ; (outgoing jig2wl beluga3)
		; (= (size jig2wl) 6)
		; (= (empty-size jig2wl) 4)
		; (= (unload-order jig2wl) 2)
		; (= (load-order jig2wl) 2)
		; (= (process-order jig2wl) 3)

		; (in jig2wr beluga3)
		; (part-of jig2wr plA1)
		; ; (outgoing jig2wr beluga3)
		; (= (size jig2wr) 6)
		; (= (empty-size jig2wr) 4)
		; (= (unload-order jig2wr) 1)
		; ; (= (load-order jigw) 1)
		; (= (process-order jig2wr) 1)

		(in jig2t beluga3)
		(part-of jig2t plA1)
		; (outgoing jig2t beluga2)
		(= (size jig2t) 2)
		(= (empty-size jig2t) 1)
		(= (unload-order jig2t) 2)
		; (= (load-order jig2t) 1)
		; (= (process-order jig2t) 7)


		; RACKS
		(atside rack1 bside)
		(atside rack1 fside)
		; (empty rack1)
		(= (level rack1) 4)
		(= (max-level rack1) 10)

		(atside rack2 bside)
		(atside rack2 fside)
		(empty rack2)
		(= (level rack2) 5)
		(= (max-level rack2) 16)

		(atside rack3 bside)
		(atside rack3 fside)
		(empty rack3)
		(= (level rack3) 0)
		(= (max-level rack3) 12)

		; (atside rack4 bside)
		; (atside rack4 fside)
		; ; (empty rack4)
		; (= (level rack4) 4)
		; (= (max-level rack4) 10)

		; (atside rack5 bside)
		; (atside rack5 fside)
		; (empty rack5)
		; (= (level rack5) 0)
		; (= (max-level rack5) 12)

		; init rack
		(in jig0c rack1)
		(in jig0b rack1)
		(clear jig0b bside)
		(clear jig0c fside)
		(on jig0b jig0c bside)
		(on jig0c jig0b fside)

		; (in jig0wl rack2)
		; (in jig0t rack2)
		; (clear jig0wl bside)
		; (clear jig0t fside)
		; (on jig0wl jig0t bside)
		; (on jig0t jig0wl fside)

		; (in jig0wr rack4)
		; (clear jig0wr bside)
		; (clear jig0wr fside)

		;Production Lines
		(= (delivery-process plA1) 6)

		(= (total-cost) 0)


	)
  (:goal (and

		; (empty jig1c)
		; (empty jig1b)
		; (empty jig1t)
		; (empty jig1wl)
		; (empty jig1wr)

		; (empty jig2c)
		; (empty jig2b)
		; (empty jig2t)
		; (empty jig2wl)
		; (empty jig2wr)

		(= (load-process beluga1) 0)
		(= (load-process beluga2) 0)
		(= (load-process beluga3) 0)

		(= (unload-process beluga1) 0)
		(= (unload-process beluga2) 0)
		(= (unload-process beluga3) 0)

		(= (delivery-process plA1) 0)

		; (<= (total-swaps) 8)
        ; (<= (+ (rack-in-use rack1) (+ (rack-in-use rack2) (+ (rack-in-use rack3) (rack-in-use rack4)))) 5)
		
	))
  (:metric minimize (total-cost))
)
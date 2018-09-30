
(set-option :produce-models true)
; Discrete Variables
; Continuous Variables
(declare-const x-0 Real)
;;Global Constraint: bound
(assert (> (+   10.00   (* x-0 (- 1.00) ))   0.00  ))
(assert (= x-0  0.000000 ))
(declare-const v-0 Real)
(assert (= v-0  0.000000 ))
(declare-const x-1 Real)
;;Global Constraint: bound
(assert (> (+   10.00   (* x-1 (- 1.00) ))   0.00  ))
(declare-const v-1 Real)
(declare-const x-2 Real)
;;Global Constraint: bound
(assert (> (+   10.00   (* x-2 (- 1.00) ))   0.00  ))
(declare-const v-2 Real)
(declare-const x-3 Real)
;;Global Constraint: bound
(assert (> (+   10.00   (* x-3 (- 1.00) ))   0.00  ))
(declare-const v-3 Real)
; Goal
(assert (= v-3  100.00 ))
;Time for Propositions: 3;Number of Actions1; Actions Variable plus Preconditions and Effects
(declare-const ACTIONmovement@-0  Int)
(assert (>= ACTIONmovement@-0 0))
;repetition constraint
;(assert (=> (> ACTIONmovement@-0 1) (and  (and(> (+   10.00   (* x-0 (- 1.00) ))   0.00  )(> (+ (+   10.00   (* x-0 (- 1.00) )) (* ACTIONmovement@-0 (- 1.00) ))   0.00  ))  true) ))
(assert (=> (> ACTIONmovement@-0 0) (= v-1 (+ v-0 (* ACTIONmovement@-0   1.00   ))) ))
(assert (=> (> ACTIONmovement@-0 0) (= x-1 (+ x-0 (* ACTIONmovement@-0   1.00   ))) ))
(assert (or  (>  ACTIONmovement@-0  0) true ))
(declare-const ACTIONmovement@-1  Int)
(assert (>= ACTIONmovement@-1 0))
;repetition constraint
;(assert (=> (> ACTIONmovement@-1 1) (and  (and(> (+   10.00   (* x-1 (- 1.00) ))   0.00  )(> (+ (+   10.00   (* x-1 (- 1.00) )) (* ACTIONmovement@-1 (- 1.00) ))   0.00  ))  true) ))
(assert (=> (> ACTIONmovement@-1 0) (= v-2 (+ v-1 (* ACTIONmovement@-1   1.00   ))) ))
(assert (=> (> ACTIONmovement@-1 0) (= x-2 (+ x-1 (* ACTIONmovement@-1   1.00   ))) ))
(assert (or  (>  ACTIONmovement@-1  0) true ))
(declare-const ACTIONmovement@-2  Int)
(assert (>= ACTIONmovement@-2 0))
;repetition constraint
;(assert (=> (> ACTIONmovement@-2 1) (and  (and(> (+   10.00   (* x-2 (- 1.00) ))   0.00  )(> (+ (+   10.00   (* x-2 (- 1.00) )) (* ACTIONmovement@-2 (- 1.00) ))   0.00  ))  true) ))
(assert (=> (> ACTIONmovement@-2 0) (= v-3 (+ v-2 (* ACTIONmovement@-2   1.00   ))) ))
(assert (=> (> ACTIONmovement@-2 0) (= x-3 (+ x-2 (* ACTIONmovement@-2   1.00   ))) ))
(assert (or  (>  ACTIONmovement@-2  0) true ))
;Time for Actions: 37; Frame Axiom
(assert (=> (not (or (> ACTIONmovement@-0 0))) (= x-0 x-1)))
(assert (=> (not (or (> ACTIONmovement@-0 0))) (= v-0 v-1)))
(assert (=> (not (or (> ACTIONmovement@-1 0))) (= x-1 x-2)))
(assert (=> (not (or (> ACTIONmovement@-1 0))) (= v-1 v-2)))
(assert (=> (not (or (> ACTIONmovement@-2 0))) (= x-2 x-3)))
(assert (=> (not (or (> ACTIONmovement@-2 0))) (= v-2 v-3)))

(check-sat-using  (then simplify solve-eqs (or-else smt qfnra-nlsat  )))
(get-model)

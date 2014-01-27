
(deftemplate PROJ
    (slot x (type INTEGER))
        (slot y (type INTEGER))
        )

(bind ?id (assert (PROJ)))
; x = 5

(defrule R1
?id <- (PROJ (x ?x) (y ?y))
=>
    (modify ?id (x 5))
    (printout t "now, x is 5 " crlf)
)

; x = 7

(defrule R2
?id <- (PROJ (x ?x) (y ?y))
=>
    (modify ?id (x 7))
    (printout t "now, x is 7 " crlf)
)

;(run)
(facts)
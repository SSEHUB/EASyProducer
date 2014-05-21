
(deftemplate PROJ
    (slot x (type INTEGER))
        (slot y (type INTEGER))
        )

(bind ?id (assert (PROJ)))
; x = 5



;(run)
(facts)
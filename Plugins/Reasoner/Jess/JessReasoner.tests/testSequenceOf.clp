; project is testSequenceOf.clp

(deftemplate gassenTyp 
	(slot compound_name (type STRING) (default "gassenTyp" ))
	(slot  maxX(type INTEGER))
	(slot  maxY(type INTEGER))
)
(deftemplate hochRegal 
	(slot compound_name (type STRING) (default "hochRegal" ))
	(multislot  seq_var(type ANY))
)
(deftemplate gassenTyp 
	(slot compound_name (type STRING) (default "gassenTyp" ))
	(slot  maxX(type INTEGER))
	(slot  maxY(type INTEGER))
)
(assert (gassenTyp (maxX  5) (maxY  10)))
(assert (hochRegal (seq_var (create$(assert (gassenTyp (maxX  5) (maxY  10)))
(assert (gassenTyp (maxX  15) (maxY  20)))
)))))
(defrule rule_1
?id <- (gassenTyp (IntA ?IntA) )
(test (eq ?IntA 11 ) )
=>
(printout t ?id crlf )

 )

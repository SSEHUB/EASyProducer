

(deftemplate project (slot projectName (type STRING)) )
(defglobal ?*ModelValidator* = 0)

(deffunction incrementor ()
(bind ?*ModelValidator* (+ ?*ModelValidator* 1)))

(deffunction getValidation ()

(return ?*ModelValidator*))

(deftemplate CMP 
	(slot compound_name (type STRING) (default "CMP" ))
	(slot  intA(type INTEGER))
	(slot  realB(type FlOAT))
)
(defglobal ?*compound1*  = nil )
(defglobal ?*compound2*  = nil )
(defrule rule_1
?id <- (CMP (intA $?intA)(realB $?realB)) 
(test (not (eq 15 ) ) )
=>
(printout t (incrementor) crlf)
(printout t ?id " NOT SATISFIED BY 1" crlf )
 )
(defrule rule_2
?id <- (CMP (intA $?intA)(realB $?realB)) 
(test (not (eq 5.0 ) ) )
=>
(printout t (incrementor) crlf)
(printout t ?id " NOT SATISFIED BY 2" crlf )
 )
(bind ?*compound1* (assert (CMP (intA  10) (realB  10.0)))
)
(run)
(bind ?*compound2* (assert (CMP (intA  10) (realB  10.0)))
)
(run)

(assert (project (projectName testCompound) ))

(run) 
(facts) 
(printout t (getValidation) crlf)
(save-facts testCompound_xml )

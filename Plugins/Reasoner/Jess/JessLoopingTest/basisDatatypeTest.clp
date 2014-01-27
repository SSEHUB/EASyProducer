

(deftemplate project (slot projectName (type STRING)) )
(defglobal ?*ModelValidator* = 0)

(deffunction incrementor ()
(bind ?*ModelValidator* (+ ?*ModelValidator* 1)))

(deffunction getValidation ()

(return ?*ModelValidator*))

(defglobal ?*intA*  = nil )
(defrule rule_1
?id <- (project (projectName ?projectName))
(test (not (> ?*intA* 5 ) ) )
=>
(printout t (incrementor) crlf)
(printout t ?id " NOT SATISFIED BY 1" crlf )
 )
(bind ?*intA*  5)
(run)

(assert (project (projectName basisDatatypeTest) ))

(run) 
(facts) 
(printout t (getValidation) crlf)
(save-facts basisDatatypeTest_xml )

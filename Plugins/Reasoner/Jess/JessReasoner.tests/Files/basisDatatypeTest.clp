

(defglobal ?*FiredList* = (new java.util.ArrayList))
(deffunction getList ()
 (return ?*FiredList*))
(deftemplate project (slot projectName (type STRING)) )
(defglobal ?*ModelValidator* = 0)

(deffunction incrementor ()
(bind ?*ModelValidator* (+ ?*ModelValidator* 1)))

(deffunction getValidation ()

(return ?*ModelValidator*))

(defmodule com)
(defglobal ?*intA*  = nil )
(bind ?*intA*  5)

(assert (project (projectName basisDatatypeTest) ))

(defmodule mod2)

(defrule mod2::RULE_1
?id <- (project (projectName ?projectName))(test (neq ?*intA* nil))
(test (not (> ?*intA*  5)  ) )
=>
(printout t (incrementor) crlf)
(printout t ?id " NOT SATISFIED BY 1" crlf )
(?*FiredList* add 1)
 )
(try
(focus mod1)
(run)
	catch 
	(printout t "NO  MODULE mod1 "crlf)
)
(try
(focus mod2)
(run)
	catch 
	(printout t "NO  MODULE mod2 "crlf)
)
(facts com) 
(facts MAIN) 
(printout t (getValidation) crlf)

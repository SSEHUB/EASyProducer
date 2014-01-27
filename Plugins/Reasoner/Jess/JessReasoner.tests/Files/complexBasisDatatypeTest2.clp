

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
(defglobal ?*intB*  = nil )
(defglobal ?*realA*  = nil )
(defglobal ?*realB*  = nil )
(defglobal ?*realC*  = nil )
(defglobal ?*realD*  = nil )
(bind ?*intA*  2)
(bind ?*intB*  5)
(bind ?*realA*  9.0)
(bind ?*realB*  10.5)
(bind ?*realC*  26.0)
(bind ?*realD*  2.0)

(assert (project (projectName complexBasisDatatypeTest2) ))

(defmodule mod2)

(defrule mod2::RULE_1
?id <- (project (projectName ?projectName))(test (neq ?*intA* nil))(test (neq ?*intB* nil))
(test (not (<> ?*intA* ?*intB* )  ) )
=>
(printout t (incrementor) crlf)
(printout t ?id " NOT SATISFIED BY 1" crlf )
(?*FiredList* add 1)
 )

(defrule mod2::RULE_2
?id <- (project (projectName ?projectName))(test (neq ?*intA* nil))
(test (not (< ?*intA*  3)  ) )
=>
(printout t (incrementor) crlf)
(printout t ?id " NOT SATISFIED BY 2" crlf )
(?*FiredList* add 2)
 )

(defrule mod2::RULE_3
?id <- (project (projectName ?projectName))(test (neq ?*intB* nil))
(test (not (> ?*intB*  4)  ) )
=>
(printout t (incrementor) crlf)
(printout t ?id " NOT SATISFIED BY 3" crlf )
(?*FiredList* add 3)
 )

(defrule mod2::RULE_4
?id <- (project (projectName ?projectName))(test (neq ?*intB* nil))(test (neq ?*intA* nil))
(test (not (> (- ?*intB* ?*intA* )  0)  ) )
=>
(printout t (incrementor) crlf)
(printout t ?id " NOT SATISFIED BY 4" crlf )
(?*FiredList* add 4)
 )

(defrule mod2::RULE_5
?id <- (project (projectName ?projectName))(test (neq ?*intA* nil))(test (neq ?*intB* nil))
(test (not (eq (+ ?*intA* ?*intB* )  7)  ) )
=>
(printout t (incrementor) crlf)
(printout t ?id " NOT SATISFIED BY 5" crlf )
(?*FiredList* add 5)
 )

(defrule mod2::RULE_6
?id <- (project (projectName ?projectName))(test (neq ?*realA* nil))(test (neq ?*realB* nil))
(test (not (<> ?*realA* ?*realB* )  ) )
=>
(printout t (incrementor) crlf)
(printout t ?id " NOT SATISFIED BY 6" crlf )
(?*FiredList* add 6)
 )

(defrule mod2::RULE_7
?id <- (project (projectName ?projectName))(test (neq ?*realA* nil))
(test (not (< ?*realA*  9.5)  ) )
=>
(printout t (incrementor) crlf)
(printout t ?id " NOT SATISFIED BY 7" crlf )
(?*FiredList* add 7)
 )

(defrule mod2::RULE_8
?id <- (project (projectName ?projectName))(test (neq ?*realB* nil))
(test (not (> ?*realB*  9.5)  ) )
=>
(printout t (incrementor) crlf)
(printout t ?id " NOT SATISFIED BY 8" crlf )
(?*FiredList* add 8)
 )

(defrule mod2::RULE_9
?id <- (project (projectName ?projectName))(test (neq ?*realC* nil))
(test (not (< ?*realC*  25.0)  ) )
=>
(printout t (incrementor) crlf)
(printout t ?id " NOT SATISFIED BY 9" crlf )
(?*FiredList* add 9)
 )

(defrule mod2::RULE_10
?id <- (project (projectName ?projectName))(test (neq ?*realD* nil))
(test (not (> ?*realD*  0.0)  ) )
=>
(printout t (incrementor) crlf)
(printout t ?id " NOT SATISFIED BY 10" crlf )
(?*FiredList* add 10)
 )

(defrule mod2::RULE_11
?id <- (project (projectName ?projectName))(test (neq ?*realA* nil))(test (neq ?*realB* nil))(test (neq ?*realC* nil))
(test (not (< (- ?*realA* ?*realB* ) ?*realC* )  ) )
=>
(printout t (incrementor) crlf)
(printout t ?id " NOT SATISFIED BY 11" crlf )
(?*FiredList* add 11)
 )

(defrule mod2::RULE_12
?id <- (project (projectName ?projectName))(test (neq ?*realB* nil))(test (neq ?*realA* nil))
(test (not (> (- ?*realB* ?*realA* )  2.0)  ) )
=>
(printout t (incrementor) crlf)
(printout t ?id " NOT SATISFIED BY 12" crlf )
(?*FiredList* add 12)
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

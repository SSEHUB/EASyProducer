

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
(deftemplate CMP 
	(slot compound_name (type STRING) (default "CMP" ))
	(slot  intA(type INTEGER))
	(slot  realB(type FlOAT))
)
(defglobal ?*compound1*  = nil )
(defglobal ?*compound2*  = nil )
(defglobal ?*s*  = nil )
(bind ?*compound1* (assert (com::CMP (intA  10) (realB  10.0)))
)
(bind ?*compound2* (assert (com::CMP (intA  10) (realB  10.0)))
)
(bind ?*s*  nil)

(assert (project (projectName testCompound) ))

(defmodule mod2)

(defrule mod2::RULE_1
?id <- (com::CMP (intA $?intA)(realB $?realB)) 
(test (not (eq (+ )  15)  ) )
=>
(printout t (incrementor) crlf)
(printout t ?id " NOT SATISFIED BY 1" crlf )
(?*FiredList* add 1)
 )

(defrule mod2::RULE_2
?id <- (com::CMP (intA $?intA)(realB $?realB)) 
(test (not (eq (- )  5.0)  ) )
=>
(printout t (incrementor) crlf)
(printout t ?id " NOT SATISFIED BY 2" crlf )
(?*FiredList* add 2)
 )

(defrule mod2::RULE_3
?id <- (com::CMP (intA $?intA)(realB $?realB)) (test (neq ?*s* nil))
(test (not (> ([] ?*s*  2) )  ) )
=>
(printout t (incrementor) crlf)
(printout t ?id " NOT SATISFIED BY 3" crlf )
(?*FiredList* add 3)
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

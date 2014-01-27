

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
(deftemplate compoundSequence 
	(slot compound_name (type STRING) (default "compoundSequence" ))
	(multislot  compounds(type ANY))
)
(defglobal ?*compound1*  = nil )
(defglobal ?*compound2*  = nil )
(bind ?*compound1* (assert (com::CMP (intA  10) (realB  10.0)))
)
(bind ?*compound2* (assert (com::CMP (intA  10) (realB  10.0)))
)

(assert (com::compoundSequence))
(run)
(assert (project (projectName basisSequenceTest) ))

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



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
(deftemplate hochRegal 
	(slot compound_name (type STRING) (default "hochRegal" ))
	(multislot  compounds(type ANY))
)
(defglobal ?*compound1*  = nil )
(defglobal ?*compound2*  = nil )
(bind ?*compound1* (assert (CMP (intA  10) (realB  10.0)))
)
(run)
(bind ?*compound2* (assert (CMP (intA  10) (realB  10.0)))
)
(run)

(assert (hochRegal))
(run)
(assert (project (projectName basisSequenceTest) ))

(run) 
(facts) 
(printout t (getValidation) crlf)
(save-facts basisSequenceTest_xml )

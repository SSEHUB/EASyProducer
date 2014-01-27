

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
(defglobal ?*VariabilityType_workflow* = 0 ?*VariabilityType_service* = 1 ?*VariabilityType_infrastructure* = 2 )
(defglobal ?*BiningTime_compile* = 0 ?*BiningTime_runtime* = 1 )
(defglobal ?*workflowVariability*  = nil )
(defglobal ?*serviceVariability*  = nil )
(defglobal ?*infrastructureVariability*  = nil )
(bind ?*workflowVariability*  0)
(bind ?*serviceVariability*  1)
(bind ?*infrastructureVariability*  2)

(assert (project (projectName General) ))

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

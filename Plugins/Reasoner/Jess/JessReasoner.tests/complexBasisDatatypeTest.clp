

(deftemplate project (slot projectName (type STRING)) )
(defglobal ?*ModelValidator* = 0)

(deffunction incrementor ()
(bind ?*ModelValidator* (+ ?*ModelValidator* 1)))

(deffunction getValidation ()

(return ?*ModelValidator*))

(defglobal ?*intA*  = nil )
(defglobal ?*intB*  = nil )
(defglobal ?*realA*  = nil )
(defglobal ?*realB*  = nil )
(defglobal ?*realC*  = nil )
(defglobal ?*realD*  = nil )
(defrule rule_1
?id <- (project (projectName ?projectName))
(test (not (<> ?*intA* ?*intB*  ) ) )
=>
(printout t (incrementor) crlf)
(printout t ?id " NOT SATISFIED BY 1" crlf )
 )
(defrule rule_2
?id <- (project (projectName ?projectName))
(test (not (bind ?*intA* 3 ) ) )
=>
(printout t (incrementor) crlf)
(printout t ?id " NOT SATISFIED BY 2" crlf )
 )
(defrule rule_3
?id <- (project (projectName ?projectName))
(test (not (> ?*intB* 4 ) ) )
=>
(printout t (incrementor) crlf)
(printout t ?id " NOT SATISFIED BY 3" crlf )
 )
(defrule rule_4
?id <- (project (projectName ?projectName))
(test (not (> 0 ) ) )
=>
(printout t (incrementor) crlf)
(printout t ?id " NOT SATISFIED BY 4" crlf )
 )
(defrule rule_5
?id <- (project (projectName ?projectName))
(test (not (eq 7 ) ) )
=>
(printout t (incrementor) crlf)
(printout t ?id " NOT SATISFIED BY 5" crlf )
 )
(defrule rule_6
?id <- (project (projectName ?projectName))
(test (not (<> ?*realA* ?*realB*  ) ) )
=>
(printout t (incrementor) crlf)
(printout t ?id " NOT SATISFIED BY 6" crlf )
 )
(defrule rule_7
?id <- (project (projectName ?projectName))
(test (not (bind ?*realA* 9.5 ) ) )
=>
(printout t (incrementor) crlf)
(printout t ?id " NOT SATISFIED BY 7" crlf )
 )
(defrule rule_8
?id <- (project (projectName ?projectName))
(test (not (> ?*realB* 9.5 ) ) )
=>
(printout t (incrementor) crlf)
(printout t ?id " NOT SATISFIED BY 8" crlf )
 )
(defrule rule_9
?id <- (project (projectName ?projectName))
(test (not (bind ?*realC* 25.0 ) ) )
=>
(printout t (incrementor) crlf)
(printout t ?id " NOT SATISFIED BY 9" crlf )
 )
(defrule rule_10
?id <- (project (projectName ?projectName))
(test (not (> ?*realD* 0.0 ) ) )
=>
(printout t (incrementor) crlf)
(printout t ?id " NOT SATISFIED BY 10" crlf )
 )
(defrule rule_11
?id <- (project (projectName ?projectName))
(test (not ( ) ) )
=>
(printout t (incrementor) crlf)
(printout t ?id " NOT SATISFIED BY 11" crlf )
 )
(defrule rule_12
?id <- (project (projectName ?projectName))
(test (not (> 2.0 ) ) )
=>
(printout t (incrementor) crlf)
(printout t ?id " NOT SATISFIED BY 12" crlf )
 )
(bind ?*intA*  2)
(run)
(bind ?*intB*  5)
(run)
(bind ?*realA*  9.0)
(run)
(bind ?*realB*  10.5)
(run)
(bind ?*realC*  26.0)
(run)
(bind ?*realD*  2.0)
(run)

(assert (project (projectName complexBasisDatatypeTest) ))

(run) 
(facts) 
(printout t (getValidation) crlf)
(save-facts complexBasisDatatypeTest_xml )

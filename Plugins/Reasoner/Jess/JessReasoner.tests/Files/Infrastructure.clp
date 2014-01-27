

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
(defglobal ?*ScaleType_Bizerba* = 0 ?*ScaleType_MettlerToledo* = 1 ?*ScaleType_Pesa* = 2 )
(defglobal ?*ConnectionType_TcpConnection* = 0 ?*ConnectionType_SerialConnection* = 1 )
(defglobal ?*FlowControl_RTSCTS_IN* = 0 ?*FlowControl_RTSCTS_OUT* = 1 ?*FlowControl_XONXOFF_IN* = 2 ?*FlowControl_XONXOFF_OUT* = 3 )
(defglobal ?*Parity_NONE* = 0 ?*Parity_ODD* = 1 ?*Parity_EVEN* = 2 ?*Parity_MARK* = 3 ?*Parity_SPACE* = 4 )
(deftemplate LightControl 
	(slot compound_name (type STRING) (default "LightControl" ))
	(slot  name(type STRING))
	(slot  connectionType(type INTEGER))
	(slot  noOfXCoordinates(type INTEGER))
	(slot  noOfYCoordinates(type INTEGER))
)
(deftemplate Scale 
	(slot compound_name (type STRING) (default "Scale" ))
	(slot  scaleType(type INTEGER))
	(slot  connectionType(type INTEGER))
	(slot  resolution(type INTEGER))
)
(deftemplate TcpConnection 
	(slot compound_name (type STRING) (default "TcpConnection" ))
	(slot  ipAddress(type INTEGER))
	(slot  port(type INTEGER))
	(slot  timeOut(type INTEGER))
)
(deftemplate SerialConnection 
	(slot compound_name (type STRING) (default "SerialConnection" ))
	(slot  comPort(type STRING))
	(slot  baudRate(type INTEGER))
	(slot  flowControl(type INTEGER))
	(slot  dataBits(type INTEGER))
	(slot  parity(type INTEGER))
	(slot  stopBits(type INTEGER))
	(slot  timeOut(type INTEGER))
)
(defglobal ?*lightControl*  = nil )
(defglobal ?*scale*  = nil )
(bind ?*lightControl*  FALSE)
(bind ?*scale*  nil)

(assert (com::LightControl))
(run)
(assert (com::Scale))
(run)
(assert (com::TcpConnection))
(run)
(assert (com::SerialConnection))
(run)
(assert (project (projectName Infrastructure) ))

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

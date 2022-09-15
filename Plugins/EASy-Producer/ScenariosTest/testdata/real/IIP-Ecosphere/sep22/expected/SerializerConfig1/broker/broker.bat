@echo off
set PORT=8883
if "%~1"=="" goto blank
set PORT=%~1

:blank
java -cp "brokerJars/*" test.de.iip_ecosphere.platform.test.amqp.qpid.TestQpidServer %PORT% %*

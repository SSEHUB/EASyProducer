#!/bin/bash
PORT=8883
if [ $# -gt 0 ]
  then
  PORT=$1
fi
java -cp "brokerJars/*" test.de.iip_ecosphere.platform.test.amqp.qpid.TestQpidServer $PORT $*
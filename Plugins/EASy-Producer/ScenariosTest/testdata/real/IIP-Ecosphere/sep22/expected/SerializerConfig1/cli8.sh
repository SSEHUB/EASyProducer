#!/bin/bash
PID_DIR=/run
java -cp "plJars/*:common/*" -Dio.netty.tryReflectionSetAccessible=true -Dlog4j2.formatMsgNoLookups=true -Diip.pid.dir=$PID_DIR "de.iip_ecosphere.platform.platform.Cli" $*

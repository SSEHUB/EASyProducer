#!/bin/bash
PID_DIR=/run
java -cp "ecsJars/*:common/*" -Dio.netty.tryReflectionSetAccessible=true -Dlog4j2.formatMsgNoLookups=true -Diip.pid.dir=$PID_DIR "de.iip_ecosphere.platform.support.LifecycleHandler\$WaitingStarter" $*

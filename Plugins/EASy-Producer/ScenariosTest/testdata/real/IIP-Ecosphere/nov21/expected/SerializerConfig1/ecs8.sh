#!/bin/bash
PID_DIR=/run
java -cp "ecsJars/*:common/*" -Dio.netty.tryReflectionSetAccessible=true -Diip.pid.dir=$PID_DIR "de.iip_ecosphere.platform.support.LifecycleHandler\$WaitingStarter" $*

#!/bin/bash
PID_DIR=/run
java -cp "ecsJars/*:common/*" -Dio.netty.tryReflectionSetAccessible=true --add-opens java.base/jdk.internal.misc=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED -Diip.pid.dir=$PID_DIR "de.iip_ecosphere.platform.support.LifecycleHandler\$WaitingStarter" $*

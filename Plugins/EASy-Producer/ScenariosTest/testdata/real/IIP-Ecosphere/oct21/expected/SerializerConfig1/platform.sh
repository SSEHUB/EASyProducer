#!/bin/bash
PID_DIR=/run
java -cp "plJars/*" --add-opens java.base/jdk.internal.misc=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED -Dio.netty.tryReflectionSetAccessible=true -Diip.pid.dir=$PID_DIR "de.iip_ecosphere.platform.support.LifecycleHandler\$WaitingStarter" $*

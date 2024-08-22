#!/bin/bash
PID_DIR=/run
java -cp @ecsJars/classpath.ux -Dio.netty.tryReflectionSetAccessible=true -Dlog4j2.formatMsgNoLookups=true -Xmx512M --add-opens java.base/jdk.internal.misc=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED -Diip.pid.dir=$PID_DIR "de.iip_ecosphere.platform.support.LifecycleHandler\$WaitingStarter" $*

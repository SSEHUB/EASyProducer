#!/bin/bash
PID_DIR=/run
java -cp @plJars/classpath.ux -Dio.netty.tryReflectionSetAccessible=true -Dlog4j2.formatMsgNoLookups=true --add-opens java.base/jdk.internal.misc=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED -Diip.pid.dir=$PID_DIR "de.iip_ecosphere.platform.platform.Cli" $*

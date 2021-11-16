#!/bin/bash
PID_DIR=/run
java -cp "plJars/*:common/*" -Dio.netty.tryReflectionSetAccessible=true -Diip.pid.dir=$PID_DIR "de.iip_ecosphere.platform.platform.Cli" $*

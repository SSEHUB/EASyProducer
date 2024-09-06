#!/bin/bash
java -cp @classpath.ux -Dde.uni_hildesheim.sse.easy.logging.level=ERROR net.ssehub.easy.standalone.cmd.CommandLineExecuter $*

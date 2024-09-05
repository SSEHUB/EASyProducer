@echo off
java -cp @classpath.win -Dde.uni_hildesheim.sse.easy.logging.level=ERROR net.ssehub.easy.standalone.cmd.CommandLineExecuter %*

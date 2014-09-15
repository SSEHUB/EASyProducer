@echo off
REM intended to start server in installation directory. 
REM It is assumed that the client jar and the plugin directory is located in the 
REM directory this script is also located in.
REM As alternatives this script may start from the source distribution and will prefer 
REM the jar in the bin directory or the compiled sources if no jar can be found.
REM 
REM if you plan to run SVNControl from another directory, please consult the documentation
REM for the JVM parameters -Dsvncontrol.dir, -Dsvncontrol.classesDir and -Dsvncontrol.pluginDir

SET JAR=.
SET LIB="lib\svnkit\svnkit.jar;lib\svnkit\trilead.jar;lib\svnkit\jna.jar;lib\ganymede\ganymedeServer.jar;lib\aspectjrt.jar;lib\decVarTool-runtime-1.0.jar"
IF NOT EXIST bin\svnControl-server-1.63.jar goto binaryInstall
SET JAR="bin\svnControl-server-1.63.jar"
:binaryInstall
IF NOT EXIST "svnControl-server-1.63.jar" goto start
SET JAR=".;svnControl-server-1.63.jar"
:start

java -classpath %JAR%;%LIB%;plugins server.Server

@echo off
REM intended to start SVNControl client in installation directory. 
REM It is assumed that the client jar and the plugin directory is located in the 
REM directory this script is also located in.
REM As alternatives this script may start from the source distribution and will prefer 
REM the jar in the bin directory or the compiled sources if no jar can be found.
REM 
REM if you plan to run SVNControl from another directory, please consult the documentation
REM for the JVM parameters -Dsvncontrol.dir, -Dsvncontrol.classesDir and -Dsvncontrol.pluginDir

SET JAR=.
SET LIB="lib\svnkit\svnkit.jar;lib\svnkit\trilead.jar;lib\svnkit\jna.jar;lib\ganymede\ganymedeServer.jar;lib\aspectjrt.jar;lib\decVarTool-runtime-1.0.jar"
IF NOT EXIST bin\svnControl-client-1.63.jar goto binaryInstall
SET JAR="bin\svnControl-client-1.63.jar"
goto start
:binaryInstall
IF NOT EXIST "svnControl-client-1.63.jar" goto start
SET JAR="svnControl-client-1.63.jar"
:start
SET NOSSL="false"
java -classpath %JAR%;%LIB%;plugins gui.LoginWindow %NOSSL%

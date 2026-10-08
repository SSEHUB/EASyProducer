@echo off
REM call switch-maven.bat 3.9.7

if "%~1"=="" (
    echo Usage: call %~nx0 ^<version^>
    echo Example: call %~nx0 3.10.0
    exit /b 1
)

set "OLD_MAVEN_HOME=%MAVEN_HOME%"
set "NEW_MAVEN_HOME=C:\localUserFiles\eichelberger\apache-maven-%~1"

if not exist "%NEW_MAVEN_HOME%\bin\mvn.cmd" (
    echo ERROR: Maven not found at "%NEW_MAVEN_HOME%"
    set "OLD_MAVEN_HOME="
    set "NEW_MAVEN_HOME="
    exit /b 1
)

call set "PATH=%%PATH:%OLD_MAVEN_HOME%\bin=%NEW_MAVEN_HOME%\bin%%"
set "MAVEN_HOME=%NEW_MAVEN_HOME%"
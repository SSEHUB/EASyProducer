@echo off

REM install wget into PATH
REM install maven into PATH
REM install GnuPGP, define default secret key (or change script)
REM add your account settings for ossrh into maven setup (use authentication token)
REM copy this script into an empty directory or run it in original directory (tmp directory is in gitignore)
REM adjust release version number
REM run this script
REM goto https://oss.sonatype.org/#welcome, staging repositories, netssehub-...*, "close" for check/deploy, if successful go for "release"

SET LOCALREPO=http://projects.sse.uni-hildesheim.de/qm/maven/net/ssehub/easy
SET EASY_VERSION=1.3.0
SET DIR=.\tmp
SET TARGET=https://oss.sonatype.org/service/local/staging/deploy/maven2
SET REPO=ossrh
SET DEPLOYCMD=mvn gpg:sign-and-deploy-file -Durl=%TARGET% -DrepositoryId=%REPO%
SET EMPTY=""

mkdir tmp
REM deploy the individual artifacts for SPASS-meter
call :DeployArtifact %EMPTY% dependencies %EASY_VERSION% true
call :DeployArtifact %EMPTY% basics %EASY_VERSION% false
call :DeployArtifact %EMPTY% varModel %EASY_VERSION% false
call :DeployArtifact %EMPTY% dslCore %EASY_VERSION% false
call :DeployArtifact %EMPTY% dslCore.ui %EASY_VERSION% false
call :DeployArtifact %EMPTY% instantiatorCore %EASY_VERSION% false
call :DeployArtifact %EMPTY% instantiatorCore-rt %EASY_VERSION% false
call :DeployArtifact %EMPTY% ivml %EASY_VERSION% false
call :DeployArtifact reasoning core %EASY_VERSION% false
call :DeployArtifact reasoning sseReasoner %EASY_VERSION% false
call :DeployArtifact vil expressions %EASY_VERSION% false
call :DeployArtifact vil buildlang %EASY_VERSION% false
call :DeployArtifact vil templateLang %EASY_VERSION% false
call :DeployArtifact vil rtvil %EASY_VERSION% false
call :DeployArtifact %EMPTY% core %EASY_VERSION% false
call :DeployArtifact %EMPTY% core.eclipse %EASY_VERSION% false
call :DeployArtifact instantiation ant %EASY_VERSION% false
call :DeployArtifact instantiation aspectj %EASY_VERSION% false
call :DeployArtifact instantiation java %EASY_VERSION% false
call :DeployArtifact instantiation maven %EASY_VERSION% false
call :DeployArtifact instantiation serializer.xml %EASY_VERSION% false
call :DeployArtifact instantiation velocity %EASY_VERSION% false
call :DeployArtifact instantiation xvcl %EASY_VERSION% false
call :DeployArtifact runtime EASy-Dependencies %EASY_VERSION% true
call :DeployArtifact runtime loader %EASY_VERSION% false
call :DeployArtifact producer CommandLine %EASY_VERSION% false
REM currently no bundled versions as sources/javadoc for Eclipse part are missing
REM call :DeployArtifact runtime EASy %EASY_VERSION% false
REM call :DeployArtifact runtime Eclipse %EASY_VERSION% false
REM call :DeployArtifact runtime loader %EASY_VERSION% false

REM done here, don't go into "sub-program"
goto :end

REM deploy a certain artifact (including classified artifacts)
REM param1: prefix to be added to path
REM param2: name/id of the artifact
REM param3: version of the artifact to deploy
REM param4: deploy only the POM
:DeployArtifact
    setlocal
	SET PREFIX=%1
	SET ARTIFACTNAME=%2
	SET ARTIFACTVERSION=%3
	SET POMONLY=%4
	SET ARTIFACTPREFIX=%ARTIFACTNAME%-%ARTIFACTVERSION%
	IF "%PREFIX%"=="""" (
	    SET URLPREFIX=
		SET LOCALPREFIX=
	) ELSE (
	    SET URLPREFIX=%PREFIX%/
		SET LOCALPREFIX=%PREFIX%-
    )
	SET POM=%ARTIFACTPREFIX%.pom
	SET JAR=%ARTIFACTPREFIX%.jar
	SET SOURCES=%ARTIFACTPREFIX%-sources.jar
	SET JAVADOC=%ARTIFACTPREFIX%-javadoc.jar
    SET URLPREFIX=%LOCALREPO%/%URLPREFIX%%ARTIFACTNAME%/%ARTIFACTVERSION%

	REM download relevant physical artifacts
	wget %URLPREFIX%/%POM% -O %DIR%\%LOCALPREFIX%%POM%
	IF "%POMONLY%"=="false" (
	    wget %URLPREFIX%/%JAR% -O %DIR%\%LOCALPREFIX%%JAR%
	    wget %URLPREFIX%/%SOURCES% -O %DIR%\%LOCALPREFIX%%SOURCES%
	    wget %URLPREFIX%/%JAVADOC% -O %DIR%\%LOCALPREFIX%%JAVADOC%
	)
	REM deploy jar, sources, docs via POM to central
	IF "%POMONLY%"=="false" (
	    call %DEPLOYCMD% -DpomFile=%DIR%\%LOCALPREFIX%%POM% -Dfile=%DIR%\%LOCALPREFIX%%JAR%
	    call %DEPLOYCMD% -DpomFile=%DIR%\%LOCALPREFIX%%POM% -Dfile=%DIR%\%LOCALPREFIX%%SOURCES% -Dclassifier=sources
	    call %DEPLOYCMD% -DpomFile=%DIR%\%LOCALPREFIX%%POM% -Dfile=%DIR%\%LOCALPREFIX%%JAVADOC% -Dclassifier=javadoc
	) ELSE (
			call %DEPLOYCMD% -DpomFile=%DIR%\%LOCALPREFIX%%POM% -Dfile=%DIR%\%LOCALPREFIX%%POM%
	)

	endlocal
	goto :eof
	
:end
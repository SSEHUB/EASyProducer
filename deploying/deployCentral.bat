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
SET EASY_VERSION=1.3.10
SET DIR=.\tmp
SET TARGET=https://oss.sonatype.org/service/local/staging/deploy/maven2
SET REPO=ossrh
SET DEPLOYCMD=mvn gpg:sign-and-deploy-file -Durl=%TARGET% -DrepositoryId=%REPO%
SET EMPTY=""

mkdir tmp
REM call :DeployArtifact producer/external jlxd-core 1.1 false
REM call :DeployArtifact producer/external jlxd-cli 1.1 false
REM call :DeployArtifact producer/external jlxd-cli-boot 1.1 true
REM call :DeployArtifact producer/external jlxd-ui 1.1 false
REM deploy the individual artifacts for SPASS-meter
call :DeployArtifact %EMPTY% dependencies %EASY_VERSION% true
call :DeployArtifact net.ssehub.easy basics %EASY_VERSION% false
call :DeployArtifact net.ssehub.easy varModel %EASY_VERSION% false
call :DeployArtifact net.ssehub.easy dslCore %EASY_VERSION% false
call :DeployArtifact net.ssehub.easy dslCore.ui %EASY_VERSION% false
call :DeployArtifact net.ssehub.easy reasoning.core %EASY_VERSION% false
call :DeployArtifact net.ssehub.easy reasoning.sseReasoner %EASY_VERSION% false
call :DeployArtifact de.uni_hildesheim.sse ivml %EASY_VERSION% false
call :DeployArtifact de.uni_hildesheim.sse ivml.ide %EASY_VERSION% false
call :DeployArtifact de.uni_hildesheim.sse ivml.ui %EASY_VERSION% false
call :DeployArtifact de.uni-hildesheim.sse ivml.ui.comments %EASY_VERSION% false
call :DeployArtifact net.ssehub.easy integration.common %EASY_VERSION% false
call :DeployArtifact net.ssehub.easy integration.common.impl %EASY_VERSION% false
call :DeployArtifact net.ssehub.easy integration.common.eclipse %EASY_VERSION% false
call :DeployArtifact de.uni-hildesheim.sse.easy instantiatorCore.rt %EASY_VERSION% false
call :DeployArtifact net.ssehub.easy instantiation.xvcl %EASY_VERSION% false
call :DeployArtifact net.ssehub.easy instantiation.core %EASY_VERSION% false
call :DeployArtifact de.uni_hildesheim.sse vil.buildlang %EASY_VERSION% false
call :DeployArtifact de.uni_hildesheim.sse vil.buildlang.ide %EASY_VERSION% false
call :DeployArtifact de.uni_hildesheim.sse vil.buildlang.ui %EASY_VERSION% false
call :DeployArtifact de.uni_hildesheim.sse vil.expressions %EASY_VERSION% false
call :DeployArtifact de.uni_hildesheim.sse vil.expressions.ide %EASY_VERSION% false
call :DeployArtifact de.uni_hildesheim.sse vil.expressions.ui %EASY_VERSION% false
call :DeployArtifact de.uni_hildesheim.sse vil.rt %EASY_VERSION% false
call :DeployArtifact de.uni_hildesheim.sse vil.rt.ide %EASY_VERSION% false
call :DeployArtifact de.uni_hildesheim.sse vil.rt.ui %EASY_VERSION% false
call :DeployArtifact de.uni_hildesheim.sse vil.templateLang %EASY_VERSION% false
call :DeployArtifact de.uni_hildesheim.sse vil.templateLang.ide %EASY_VERSION% false
call :DeployArtifact de.uni_hildesheim.sse vil.templateLang.ui %EASY_VERSION% false
call :DeployArtifact net.ssehub.easy instantiation.velocity %EASY_VERSION% false
call :DeployArtifact net.ssehub.easy instantiation.ant %EASY_VERSION% false
call :DeployArtifact net.ssehub.easy instantiation.aspectj %EASY_VERSION% false
call :DeployArtifact net.ssehub.easy instantiation.docker %EASY_VERSION% false
call :DeployArtifact net.ssehub.easy instantiation.java %EASY_VERSION% false
call :DeployArtifact net.ssehub.easy instantiation.lxc %EASY_VERSION% false
call :DeployArtifact net.ssehub.easy instantiation.maven %EASY_VERSION% false
call :DeployArtifact net.ssehub.easy instantiation.python %EASY_VERSION% false
call :DeployArtifact net.ssehub.easy instantiation.serializer.xml %EASY_VERSION% false
call :DeployArtifact net.ssehub.easy instantiation.json %EASY_VERSION% false
call :DeployArtifact net.ssehub.easy instantiation.yaml %EASY_VERSION% false
call :DeployArtifact net.ssehub.easy producer.help %EASY_VERSION% false
call :DeployArtifact net.ssehub.easy producer.eclipse %EASY_VERSION% false
call :DeployArtifact net.ssehub.easy producer.core %EASY_VERSION% false
call :DeployArtifact net.ssehub.easy producer.examples %EASY_VERSION% false
call :DeployArtifact net.ssehub.easy producer.ui %EASY_VERSION% false
call :DeployArtifact net.ssehub.easy loader %EASY_VERSION% false
call :DeployArtifact %EMPTY% CommandLine %EASY_VERSION% false
SET LOCALREPO=%LOCALREPO%/runtime
call :DeployArtifact %EMPTY% EASy-dependencies %EASY_VERSION% true
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
	    SET URLPREFIX=%ARTIFACTNAME%/
		SET LOCALPREFIX=
	) ELSE (
	    SET URLPREFIX=%PREFIX%.%ARTIFACTNAME%
		REM SET TMPPRE=%PREFIX:/=-%
		REM SET LOCALPREFIX=%TMPPRE%-
		SET LOCALPREFIX=%PREFIX%.%ARTIFACTNAME%-
		SET ARTIFACTPREFIX=%PREFIX%.%ARTIFACTPREFIX%
    )
	SET POM=%ARTIFACTPREFIX%.pom
	SET JAR=%ARTIFACTPREFIX%.jar
	SET SOURCES=%ARTIFACTPREFIX%-sources.jar
	SET JAVADOC=%ARTIFACTPREFIX%-javadoc.jar
    SET P2ART=%ARTIFACTPREFIX%-p2artifacts.xml
    SET P2META=%ARTIFACTPREFIX%-p2metadata.xml
    SET URLPREFIX=%LOCALREPO%/%URLPREFIX%%ARTIFACTNAME%/%ARTIFACTVERSION%

	REM download relevant physical artifacts
	wget %URLPREFIX%/%POM% -O %DIR%\%LOCALPREFIX%%POM%

    SET CLASSIFIERS=
    SET FILES=
	if "%POMONLY%"=="false" goto dodownload
    if "%POMONLY%"=="cmd" goto dodownload
	goto doDeploy

	:dodownload
	SET CLASSIFIERS=,sources,javadoc
    SET FILES=%DIR%\%LOCALPREFIX%%JAR%,%DIR%\%LOCALPREFIX%%SOURCES%,%DIR%\%LOCALPREFIX%%JAVADOC%
	wget %URLPREFIX%/%JAR% -O %DIR%\%LOCALPREFIX%%JAR%
	wget %URLPREFIX%/%SOURCES% -O %DIR%\%LOCALPREFIX%%SOURCES%
	wget %URLPREFIX%/%JAVADOC% -O %DIR%\%LOCALPREFIX%%JAVADOC%
	IF "%POMONLY%"=="false" (
        SET CLASSIFIERS=%CLASSIFIERS%,p2artifacts,p2metadata
        SET FILES=%FILES%,%DIR%\%LOCALPREFIX%%P2ART%,%DIR%\%LOCALPREFIX%%P2META%
        wget %URLPREFIX%/%JAVADOC% -O %DIR%\%LOCALPREFIX%%P2ART%
        wget %URLPREFIX%/%JAVADOC% -O %DIR%\%LOCALPREFIX%%P2META%
	)
	
	:doDeploy
	REM deploy jar, sources, docs via POM to central
	IF "%POMONLY%"=="false" (
        echo %DEPLOYCMD% -DpomFile=%DIR%\%LOCALPREFIX%%POM% -Dfiles=%FILES% -Dclassifiers=%CLASSIFIERS%
	    REM call %DEPLOYCMD% -DpomFile=%DIR%\%LOCALPREFIX%%POM% -Dfiles=%FILES% -Dclassifiers=%CLASSIFIERS%
	) ELSE (
	    echo %DEPLOYCMD% -DpomFile=%DIR%\%LOCALPREFIX%%POM% -Dfile=%DIR%\%LOCALPREFIX%%POM% -DgeneratePom=false -Dpackaging=pom
	    REM call %DEPLOYCMD% -DpomFile=%DIR%\%LOCALPREFIX%%POM% -Dfile=%DIR%\%LOCALPREFIX%%POM% -DgeneratePom=false -Dpackaging=pom
	)

	endlocal
	goto :eof
	
:end
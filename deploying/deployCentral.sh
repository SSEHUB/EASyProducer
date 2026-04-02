#!/bin/bash

# Pre-requisites:
# 1. install wget into PATH
# 2. install maven into PATH
# 3. install GnuPGP, define default secret key (or change script)
# 4. add your account settings for ossrh into maven setup (use authentication token)
# 5. copy this script into an empty directory or run it in original directory
# 6. adjust release version number
# 7. run this script
# 8. goto https://oss.sonatype.org/#welcome, staging repositories, netssehub-...*, 
#    "close" for check/deploy, if successful go for "release"

# --- Variables ---
LOCALREPO="http://projects.sse.uni-hildesheim.de/qm/maven/net/ssehub/easy"
EASY_VERSION="1.3.10"
DIR="./tmp"
TARGET="https://oss.sonatype.org/service/local/staging/deploy/maven2"
REPO="ossrh"
# Note: Maven command parts are kept separate for easier execution in Bash
DEPLOYCMD="mvn gpg:sign-and-deploy-file -Durl=$TARGET -DrepositoryId=$REPO"
EMPTY=""

# Create tmp directory
mkdir -p "$DIR"

# --- Function Definition ---
# param1: prefix to be added to path ($1)
# param2: name/id of the artifact ($2)
# param3: version of the artifact to deploy ($3)
# param4: deploy only the POM ($4)
DeployArtifact() {
    local PREFIX="$1"
    local ARTIFACTNAME="$2"
    local ARTIFACTVERSION="$3"
    local POMONLY="$4"
    
    local ARTIFACTPREFIX="${ARTIFACTNAME}-${ARTIFACTVERSION}"
    local URL_PATH_PREFIX=""
    local LOCAL_FILE_PREFIX=""

    if [ -z "$PREFIX" ]; then
        URL_PATH_PREFIX="net/ssehub/easy/"
        LOCAL_FILE_PREFIX="net/ssehub/easy/"
    else
        URL_PATH_PREFIX="net/ssehub/easy/${PREFIX}/"
        LOCAL_FILE_PREFIX="net/ssehub/easy/${PREFIX}-"
    fi

    local POM="${ARTIFACTPREFIX}.pom"
    local JAR="${ARTIFACTPREFIX}.jar"
    local SOURCES="${ARTIFACTPREFIX}-sources.jar"
    local JAVADOC="${ARTIFACTPREFIX}-javadoc.jar"
    local P2ART="${ARTIFACTPREFIX}-p2artifacts.xml"
    local P2META="${ARTIFACTPREFIX}-p2metadata.xml"
    
    local FULL_URL_PREFIX="${LOCALREPO}/${URL_PATH_PREFIX}${ARTIFACTNAME}/${ARTIFACTVERSION}"

    # Download relevant physical artifacts
    wget "${FULL_URL_PREFIX}/${POM}" -O "${DIR}/${LOCAL_FILE_PREFIX}${POM}"
    
    if [ "$POMONLY" = "false" ]; then
        wget "${FULL_URL_PREFIX}/${JAR}" -O "${DIR}/${LOCAL_FILE_PREFIX}${JAR}"
        wget "${FULL_URL_PREFIX}/${SOURCES}" -O "${DIR}/${LOCAL_FILE_PREFIX}${SOURCES}"
        wget "${FULL_URL_PREFIX}/${JAVADOC}" -O "${DIR}/${LOCAL_FILE_PREFIX}${JAVADOC}"
        wget "${FULL_URL_PREFIX}/${P2ART}" -O "${DIR}/${LOCAL_FILE_PREFIX}${P2ART}"
        wget "${FULL_URL_PREFIX}/${P2META}" -O "${DIR}/${LOCAL_FILE_PREFIX}${P2META}"
    fi

    # Deploy via Maven
    if [ "$POMONLY" = "false" ]; then
        $DEPLOYCMD -DpomFile="${DIR}/${LOCAL_FILE_PREFIX}${POM}" -Dfile="${DIR}/${LOCAL_FILE_PREFIX}${JAR}"
        $DEPLOYCMD -DpomFile="${DIR}/${LOCAL_FILE_PREFIX}${POM}" -Dfile="${DIR}/${LOCAL_FILE_PREFIX}${SOURCES}" -Dclassifier=sources
        $DEPLOYCMD -DpomFile="${DIR}/${LOCAL_FILE_PREFIX}${POM}" -Dfile="${DIR}/${LOCAL_FILE_PREFIX}${JAVADOC}" -Dclassifier=javadoc
        $DEPLOYCMD -DpomFile="${DIR}/${LOCAL_FILE_PREFIX}${POM}" -Dfile="${DIR}/${LOCAL_FILE_PREFIX}${P2ART}" -Dclassifier=p2artifacts
        $DEPLOYCMD -DpomFile="${DIR}/${LOCAL_FILE_PREFIX}${POM}" -Dfile="${DIR}/${LOCAL_FILE_PREFIX}${P2META}" -Dclassifier=p2metadata
    else
        echo "Executing: $DEPLOYCMD -DpomFile=${DIR}/${LOCAL_FILE_PREFIX}${POM} -Dfile=${DIR}/${LOCAL_FILE_PREFIX}${POM} -DgeneratePom=false -Dpackaging=pom"
        $DEPLOYCMD -DpomFile="${DIR}/${LOCAL_FILE_PREFIX}${POM}" -Dfile="${DIR}/${LOCAL_FILE_PREFIX}${POM}" -DgeneratePom=false -Dpackaging=pom
    fi
}

# --- Artifact Deployment ---

# deploy the individual artifacts for SPASS-meter
DeployArtifact "" "dependencies" "$EASY_VERSION" true
DeployArtifact "net.ssehub.easy" "basics" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "varModel" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "dslCore" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "dslCore.ui" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "reasoning.core" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "reasoning.sseReasoner" "$EASY_VERSION" false
DeployArtifact "de.uni_hildesheim.sse" "ivml" "$EASY_VERSION" false
DeployArtifact "de.uni_hildesheim.sse" "ivml.ide" "$EASY_VERSION" false
DeployArtifact "de.uni_hildesheim.sse" "ivml.ui" "$EASY_VERSION" false
DeployArtifact "de.uni_hildesheim.sse" "ivml.ui.comments" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "integration.common" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "integration.common.impl" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "integration.common.eclipse" "$EASY_VERSION" false
DeployArtifact "de.uni-hildesheim.sse.easy" "instantiatorCore.rt" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "instantiation.xvcl" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "instantiation.core" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "vil.buildlang" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "vil.buildlang.ide" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "vil.buildlang.ui" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "vil.expressions" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "vil.expressions.ide" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "vil.expressions.ui" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "vil.rt" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "vil.rt.ide" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "vil.rt.ui" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "vil.templatelang" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "vil.templatelang.ide" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "vil.templatelang.ui" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "instantiation.velocity" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "instantiation.ant" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "instantiation.aspectj" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "instantiation.docker" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "instantiation.java" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "instantiation.lxc" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "instantiation.maven" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "instantiation.python" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "instantiation.serializer.xml" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "instantiation.json" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "instantiation.yaml" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "producer.help" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "producer.eclipse" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "producer.core" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "producer.examples" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "producer.ui" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy.runtime" "EASy-dependencies" "$EASY_VERSION" true
DeployArtifact "net.ssehub.easy" "loader" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "CommandLine" "$EASY_VERSION" false

echo "Deployment process finished."
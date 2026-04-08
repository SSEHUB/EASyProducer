#!/usr/bin/bash

# Pre-requisites:
# 1. install wget into PATH
# 2. install curl into PATH
# 3. install GnuPGP, define default secret key (or change script)
# 4. add your account settings to settings.sh as USER=... and PASSWORD=...
# 5. copy this script into an empty directory
# 6. adjust release version number
# 7. run this script
# 8. goto https://central.sonatype.org and release the artifacts

source settings.sh
BEARER=$(printf "${USER}:${PASSWORD}" | base64)

# --- Variables ---
NAMESPACEPATH="net/ssehub/easy"
LOCALREPO="http://projects.sse.uni-hildesheim.de/qm/maven/${NAMESPACEPATH}"
EASY_VERSION="1.3.10"
BASEDIR="./tmp"
DIR="${BASEDIR}/${NAMESPACEPATH}"
TARGET="https://central.sonatype.com/api/v1/publisher"
REPO="central.deploy"
# Note: Maven command parts are kept separate for easier execution in Bash
SIGNCMD="gpg --armor --detach-sign --yes"
DEPLOYCMD="mvn -X deploy:deploy-file -Durl=$TARGET -DrepositoryId=$REPO"
EMPTY=""

SCRIPTDIR_ABS=$(realpath .)
BASEDIR_ABS=$(realpath ${BASEDIR})
# Create tmp directory
mkdir -p "$DIR"

# --- Function Definition ---
DownloadArtifact() {
   local URL="$1"
   local FILE="$2"

   wget ${URL} -O ${FILE}
   if [[ "$URL" == *.pom ]]; then
       #is it a POM
       LINE=$(awk '/<license>/{print NR; exit}' ${FILE})
       #does it have the license, author, SCM stuff included; if yes, parent pom and leave it, if no insert it -> central
       if [[ -z "${LINE}" ]]; then
           #if no license, include it before closing tag
           echo "INSERTING insert.xml into ${FILE}"
           LINE=$(awk '/<\/project>/{line=NR} END{print line}' ${FILE})
           sed -i "${LINE}e cat ${SCRIPTDIR_ABS}/insert.xml" ${FILE}
       fi
   fi
   $SIGNCMD ${FILE}
   md5sum ${FILE} | awk '{print $1}' > ${FILE}.md5
   sha1sum ${FILE} | awk '{print $1}' > ${FILE}.sha1
}

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
    local ADIR="${DIR}"

    if [ -z "$PREFIX" ]; then
        URL_PATH_PREFIX="${ARTIFACTNAME}/"
        LOCAL_FILE_PREFIX=""
        ADIR="${ADIR}/${ARTIFACTNAME}"
    else
        URL_PATH_PREFIX="${PREFIX}.${ARTIFACTNAME}/"
        LOCAL_FILE_PREFIX=""
        ARTIFACTPREFIX="${PREFIX}.${ARTIFACTPREFIX}"
        ADIR="${ADIR}/${PREFIX}.${ARTIFACTNAME}"
    fi
    ADIR="${ADIR}/${ARTIFACTVERSION}"
    mkdir -p "${ADIR}"

    local POM="${ARTIFACTPREFIX}.pom"
    local JAR="${ARTIFACTPREFIX}.jar"
    local SOURCES="${ARTIFACTPREFIX}-sources.jar"
    local JAVADOC="${ARTIFACTPREFIX}-javadoc.jar"
    local P2ART="${ARTIFACTPREFIX}-p2artifacts.xml"
    local P2META="${ARTIFACTPREFIX}-p2metadata.xml"
    local FULL_URL_PREFIX="${LOCALREPO}/${URL_PATH_PREFIX}${ARTIFACTVERSION}"

    # Download relevant physical artifacts
    DownloadArtifact "${FULL_URL_PREFIX}/${POM}" "${ADIR}/${LOCAL_FILE_PREFIX}${POM}"

    if [[ "$POMONLY" = "false" || "$POMONLY" = "cmd" ]]; then
        DownloadArtifact "${FULL_URL_PREFIX}/${JAR}" "${ADIR}/${LOCAL_FILE_PREFIX}${JAR}"
        DownloadArtifact "${FULL_URL_PREFIX}/${SOURCES}" "${ADIR}/${LOCAL_FILE_PREFIX}${SOURCES}"
        DownloadArtifact "${FULL_URL_PREFIX}/${JAVADOC}" "${ADIR}/${LOCAL_FILE_PREFIX}${JAVADOC}"
        if [ "$POMONLY" = "false" ]; then
            DownloadArtifact "${FULL_URL_PREFIX}/${P2ART}" "${ADIR}/${LOCAL_FILE_PREFIX}${P2ART}"
            DownloadArtifact "${FULL_URL_PREFIX}/${P2META}" "${ADIR}/${LOCAL_FILE_PREFIX}${P2META}"
        fi
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
DeployArtifact "de.uni-hildesheim.sse" "ivml.ui.comments" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "integration.common" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "integration.common.impl" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "integration.common.eclipse" "$EASY_VERSION" false
DeployArtifact "de.uni-hildesheim.sse.easy" "instantiatorCore.rt" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "instantiation.xvcl" "$EASY_VERSION" false
DeployArtifact "net.ssehub.easy" "instantiation.core" "$EASY_VERSION" false
DeployArtifact "de.uni_hildesheim.sse" "vil.buildlang" "$EASY_VERSION" false
DeployArtifact "de.uni_hildesheim.sse" "vil.buildlang.ide" "$EASY_VERSION" false
DeployArtifact "de.uni_hildesheim.sse" "vil.buildlang.ui" "$EASY_VERSION" false
DeployArtifact "de.uni_hildesheim.sse" "vil.expressions" "$EASY_VERSION" false
DeployArtifact "de.uni_hildesheim.sse" "vil.expressions.ide" "$EASY_VERSION" false
DeployArtifact "de.uni_hildesheim.sse" "vil.expressions.ui" "$EASY_VERSION" false
DeployArtifact "de.uni_hildesheim.sse" "vil.rt" "$EASY_VERSION" false
DeployArtifact "de.uni_hildesheim.sse" "vil.rt.ide" "$EASY_VERSION" false
DeployArtifact "de.uni_hildesheim.sse" "vil.rt.ui" "$EASY_VERSION" false
DeployArtifact "de.uni_hildesheim.sse" "vil.templatelang" "$EASY_VERSION" false
DeployArtifact "de.uni_hildesheim.sse" "vil.templatelang.ide" "$EASY_VERSION" false
DeployArtifact "de.uni_hildesheim.sse" "vil.templatelang.ui" "$EASY_VERSION" false
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
DeployArtifact "net.ssehub.easy" "loader" "$EASY_VERSION" false
DeployArtifact "" "CommandLine" "$EASY_VERSION" cmd
DIR="${DIR}/runtime"
LOCALREPO="${LOCALREPO}/runtime"
DeployArtifact "" "EASy-dependencies" "$EASY_VERSION" true

SCRIPT_DIR=$PWD
cd $BASEDIR
rm -f ${SCRIPT_DIR}/easy.zip
zip -r ${SCRIPT_DIR}/easy.zip .
cd $SCRIPT_DIR

curl --request POST --verbose --header "Authorization: Bearer ${BEARER}" --form bundle=@easy.zip "https://central.sonatype.com/api/v1/publisher/upload?publishingType=USER_MANAGED&name=easy"

echo -e "\n\nDeployment process finished."

package au.com.jcloud.lxd.service;

import java.io.IOException;
import java.util.Map;

import au.com.jcloud.lxd.bean.ImageConfig;
import au.com.jcloud.lxd.bean.LxdServerCredential;
import au.com.jcloud.lxd.enums.LxdCall;
import au.com.jcloud.lxd.enums.RemoteServer;

/**
 * Created by david.vittor on 21/08/17.
 */
public interface ILxdApiService {

	public static final String CURL_URL_BASE_REMOTE = "curl -s -k ${KEYPATHCERT} ${KEYPATHKEY} https://${HOSTANDPORT}";
//	public static final String CURL_URL_BASE_LOCAL = "curl -s --unix-socket /var/lib/lxd/unix.socket a";
	public static final String CURL_URL_BASE_LOCAL = "curl -s --unix-socket /var/snap/lxd/common/lxd/unix.socket a";

	// Get commands
	public static final String URL_GET_SERVERINFO = "/1.0";
	public static final String URL_GET_CONTAINER = "/1.0/containers";
	public static final String URL_GET_IMAGE = "/1.0/images";
	public static final String URL_GET_IMAGEALIAS = URL_GET_IMAGE + "/aliases";
	public static final String URL_GET_CERTIFICATE = "/1.0/certificates";
	public static final String URL_GET_NETWORK = "/1.0/networks";
	public static final String URL_GET_OPERATION = "/1.0/operations";
	public static final String URL_GET_PROFILE = "/1.0/profiles";
	public static final String URL_GET_STATE = "/1.0/containers/${ID}/state";
	public static final String URL_GET_LOGS = "/1.0/containers/${ID}/logs";
	public static final String URL_GET_SNAPSHOTS = "/1.0/containers/${ID}/snapshots";
	public static final String URL_GET_FILE = "/1.0/containers/${ID}/files?path=${PATH}";

	// Post Commands
	public static final String URL_PUT_CONTAINER_STATE = URL_GET_STATE + " -X PUT -d '{\"action\": \"${ACTION}\", ${TIMEOUT} \"force\": ${FORCE}, \"stateful\": ${STATEFUL} }'";
	public static final String URL_POST_CONTAINER_CREATE_REMOTE = URL_GET_CONTAINER + " -X POST -d '{\"name\": \"${ID}\", ${EPHEMERAL} ${ARCHITECTURE} ${CONFIG} ${PROFILES} \"source\": {\"type\": \"image\", \"protocol\": \"${PROTOCOL}\", \"server\": \"${SERVERURL}\", \"alias\": \"${ALIAS}\"}}'";
	public static final String URL_POST_CONTAINER_CREATE_LOCAL = URL_GET_CONTAINER + " -X POST -d '{\"name\": \"${ID}\", ${EPHEMERAL} ${ARCHITECTURE} ${CONFIG} ${PROFILES} \"source\": {\"type\": \"image\", \"fingerprint\": \"${ALIAS}\"}}'";
	public static final String URL_POST_CONTAINER_COPY = URL_GET_CONTAINER + " -X POST -d '{\"name\": \"${ID}\", ${EPHEMERAL} ${ARCHITECTURE} ${CONFIG} ${PROFILES} \"source\": {\"type\": \"copy\", \"container_only\": \"${CONTAINERONLY}\", \"source\": \"${CONTAINER}\"}}'";
	public static final String URL_POST_CONTAINER_DELETE = URL_GET_CONTAINER + "/${ID} -X DELETE";
	public static final String URL_POST_CONTAINER_RENAME = URL_GET_CONTAINER + "/${ID} -X POST -d '{ \"name\": \"${NEWNAME}\" }'";
	public static final String URL_POST_CONTAINER_FILES = URL_GET_CONTAINER + "/${ID}/files?path=${PATH} -X POST";
	public static final String URL_POST_CONTAINER_EXEC = URL_GET_CONTAINER + "/${ID}/exec -X POST -d '{ \"command\": [\"${CMD}\"], \"environment\": {${ENV}}, \"wait-for-websocket\": ${WAIT}, \"interactive\": false }'";
//	public static final String URL_POST_SNAPSHOT_CREATE = URL_GET_SNAPSHOTS + " -X POST -d '{\"name\": \"${SNAPNAME}\", \"stateful\": \"${STATEFUL}\"}'";
	public static final String URL_POST_SNAPSHOT_CREATE = URL_GET_SNAPSHOTS + " -X POST -d '{\"name\": \"${SNAPNAME}\"}'";
	public static final String URL_POST_SNAPSHOT_DELETE = URL_GET_SNAPSHOTS + "/${SNAPNAME} -X DELETE";
	public static final String URL_POST_SNAPSHOT_RENAME = URL_GET_SNAPSHOTS + "/${SNAPNAME} -X POST -d '{ \"name\": \"${NEWNAME}\" }'";
	public static final String URL_POST_IMAGE_DELETE = URL_GET_IMAGE + "/${ID} -X DELETE";
	public static final String URL_POST_IMAGEALIAS_CREATE = URL_GET_IMAGEALIAS + " -X POST -d '{ \"description\": \"${DESCRIPTION}\", \"target\": \"${FINGERPRINT}\", \"name\": \"${NEWNAME}\" }'";
	public static final String URL_POST_IMAGEALIAS_DELETE = URL_GET_IMAGEALIAS + "/${ID} -X DELETE";
	public static final String URL_POST_IMAGEALIAS_RENAME = URL_GET_IMAGEALIAS + "/${ID} -X POST -d '{ \"name\": \"${NEWNAME}\", \"description\": \"${DESCRIPTION}\" }'";
	public static final String URL_POST_PROFILE_DELETE = URL_GET_PROFILE + "/${ID} -X DELETE";
	public static final String URL_POST_NETWORK_DELETE = URL_GET_NETWORK + "/${ID} -X DELETE";

	/**
	 * Set the linuxCliService used by this lxdApiService
	 */
	void setLinuxCliService(ILinuxCliService linuxCliService);

	/**
	 * Execute the curl command to get a single "LXD Object" e.g. Container, Image, Profile, etc
	 */
	<T> T executeCurlGetCmd(LxdServerCredential credential, LxdCall lxdCall, String id) throws IOException, InterruptedException;

	/**
	 * Execute the curl command to get a single "LXD Object" e.g. Container, Image, Profile, etc
	 */
	<T> T executeCurlGetCmd(LxdServerCredential credential, LxdCall lxdCall, String id, String containerName, String... additionalParams) throws IOException, InterruptedException;

	/**
	 * Execute the base curl command to get a list of "LXD Objects" e.g. Containers, Images, Profiles, etc
	 * 
	 * @param credential the remote server credentials, or null for local
	 * @param lxdCall the type of operation to perform
	 */
	<T> Map<String, T> executeCurlGetListCmd(LxdServerCredential credential, LxdCall lxdCall) throws IOException, InterruptedException;

	/**
	 * Execute the base curl command to get a list of "LXD Objects" e.g. Containers, Images, Profiles, etc
	 * 
	 * @param credential the remote server credentials, or null for local
	 * @param lxdCall the type of operation to perform
	 */
	<T> Map<String, T> executeCurlGetListCmd(LxdServerCredential credential, LxdCall lxdCall, String containerName) throws IOException, InterruptedException;

	/**
	 * Execute the curl command to start, stop, create or delete a container
	 * 
	 * @param credential the remote server credentials, or null for local
	 * @param lxdCall the type of operation to perform
	 * @param containerName the name of the container
	 * @param additionalParams any additional parameters
	 */
	void executeCurlPostOrPutCmd(LxdServerCredential credential, LxdCall lxdCall, String containerName, String... additionalParams) throws IOException, InterruptedException;

	/**
	 * Execute the curl command to start, stop, create or delete a container
	 * 
	 * @param credential the remote server credentials, or null for local
	 * @param lxdCall the type of operation to perform
	 * @param containerName the name of the container
	 * @param commandAndArgs the command and arguments to execute on the container
	 * @param env optional additional environment variables
	 * @param waitForSocket waitForSocket connection, defaults to false
	 */
	void executeCurlPostOrPutCmdForExec(LxdServerCredential credential, LxdCall lxdCall, String containerName, String[] commandAndArgs, String env, Boolean waitForSocket) throws IOException, InterruptedException;

	/**
	 * Execute the curl command to create or delete a snapshot for a container
	 * 
	 * @param credential the remote server credentials, or null for local
	 * @param lxdCall the type of operation to perform
	 * @param containerName the name of the container
	 * @param snapshotName the name of the snapshot
	 * @param additionalParams any additional parameters
	 */
	void executeCurlPostOrPutCmdForSnapshot(LxdServerCredential credential, LxdCall lxdCall, String containerName, String snapshotName, String... additionalParams) throws IOException, InterruptedException;

	/**
	 * Execute the curl command to start, stop, create or delete a container
	 * 
	 * @param credential the remote server credentials, or null for local
	 * @param lxdCall the type of operation to perform
	 */
	void executeCurlPostCmdToCreateNewContainerFromImage(LxdServerCredential credential, LxdCall lxdCall, RemoteServer remoteServer, String containerName, String imageAlias) throws IOException, InterruptedException;

	/**
	 * Execute the curl command to start, stop, create or delete a container
	 * 
	 * @param credential the remote server credentials, or null for local
	 * @param lxdCall the type of operation to perform
	 */
	void executeCurlPostCmdToCreateNewContainerFromImage(LxdServerCredential credential, LxdCall lxdCall, RemoteServer remoteServer, String containerName, String imageAlias, ImageConfig imageConfig) throws IOException, InterruptedException;

	/**
	 * Execute the curl command to copy a container
	 * 
	 * @param credential the remote server credentials, or null for local
	 * @param existingContainerName the name of the existing container to be copied
	 * @param newContainerName the name of the new container
	 * @param containerOnly whether to copy snapshots also, default is true
	 */
	void executeCurlPostCmdToCopyContainer(LxdServerCredential credential, String existingContainerName, String newContainerName, Boolean containerOnly) throws IOException, InterruptedException;

	/**
	 * Perform a replace all on the url replacing ${ID}.
	 * 
	 * @param url the url string
	 * @param id the id replacement value
	 * @return the parameterised url
	 */
	String getParameterisedUrl(String url, String id);

	/**
	 * The default base url is {@link #CURL_URL_BASE_LOCAL}, but if remoteHostAndPort is
	 * provided will use the base url {@link #CURL_URL_BASE_REMOTE}
	 * 
	 * @param remoteHostAndPort format should be <host>:<port>, if no port provided will default to 8443
	 * @param keypath the path to the remote key
	 * @return return the base url for curl calls
	 */
	String getBaseUrl(LxdServerCredential credential);
}

package au.com.jcloud.lxd.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import au.com.jcloud.lxd.bean.ImageConfig;
import au.com.jcloud.lxd.bean.LxdServerCredential;
import au.com.jcloud.lxd.enums.LxdCall;
import au.com.jcloud.lxd.enums.RemoteServer;
import au.com.jcloud.lxd.model.StatusCode;
import au.com.jcloud.lxd.model.response.AbstractResponse;
import au.com.jcloud.lxd.model.response.ListOperationResponse;
import au.com.jcloud.lxd.model.response.ListResponse;
import au.com.jcloud.lxd.service.ILinuxCliService;
import au.com.jcloud.lxd.service.ILxdApiService;

/**
 * Created by david.vittor on 12/07/16.
 */
@Named
public class LxdApiServiceImpl implements ILxdApiService {

	public static final Logger LOG = Logger.getLogger(LxdApiServiceImpl.class);

	private ILinuxCliService linuxCliService;

	/**
	 * Execute the curl command to get a single "LXD Object" e.g. Container, Image,
	 * Profile, etc
	 */
	@Override
	public <T> T executeCurlGetCmd(LxdServerCredential credential, LxdCall lxdCall, String id)
			throws IOException, InterruptedException {
		return executeCurlGetCmd(credential, lxdCall, id, null);
	}

	/**
	 * Execute the curl command to get a single "LXD Object" e.g. Container, Image,
	 * Profile, etc
	 */
	@Override
	public <T> T executeCurlGetCmd(LxdServerCredential credential, LxdCall lxdCall, String id, String containerName,
			String... additionalParams) throws IOException, InterruptedException {
		String url = getBaseUrl(credential) + lxdCall.getCommand();
		if (containerName != null) {
			url = getParameterisedUrl(url, containerName);
		}
		if (lxdCall.equals(LxdCall.GET_FILE) && additionalParams.length > 0) {
			url = url.replace("${PATH}", additionalParams[0]);
			return (T) linuxCliService.executeLinuxCmd(url);
		}
		if (lxdCall.equals(LxdCall.GET_STATE)) {
			url = getParameterisedUrl(url, id);
		}
		else {
			if (StringUtils.isNotBlank(id)) {
				url += "/" + id;
			}
		}
		LOG.debug("url=" + url);
		AbstractResponse response = linuxCliService.executeLinuxCmdWithResultJsonObject(url, lxdCall.getClassType());
		if (response != null) {
			LOG.debug("statusCode=" + response.getStatusCode());
			if (StatusCode.SUCCESS.equals(StatusCode.parse(response.getStatusCode()))) {
				return (T) response.getMetadata();
			}
		}
		return null;
	}

	/**
	 * Execute the base curl command to get a list of "LXD Objects" e.g. Containers,
	 * Images, Profiles, etc
	 * 
	 * @param remoteHostAndPort
	 *            see {@link #getBaseUrl(String, String)}
	 * @param lxdCall
	 *            the type of operation to perform
	 */
	@Override
	public <T> Map<String, T> executeCurlGetListCmd(LxdServerCredential credential, LxdCall lxdCall)
			throws IOException, InterruptedException {
		return executeCurlGetListCmd(credential, lxdCall, null);
	}

	/**
	 * Execute the base curl command to get a list of "LXD Objects" e.g. Containers,
	 * Images, Profiles, etc
	 * 
	 * @param remoteHostAndPort
	 *            see {@link #getBaseUrl(String, String)}
	 * @param keypath the path to the key for the remoteHostAndPort
	 * @param lxdCall
	 *            the type of operation to perform
	 */
	@Override
	public <T> Map<String, T> executeCurlGetListCmd(LxdServerCredential credential, LxdCall lxdCall, String containerName)
			throws IOException, InterruptedException {
		Class responseClassType = ListResponse.class;
		if (lxdCall.equals(LxdCall.GET_OPERATION)) {
			responseClassType = ListOperationResponse.class;
		}
		String url = getBaseUrl(credential) + lxdCall.getCommand();
		url = getParameterisedUrl(url, containerName);
		LOG.debug("url=" + url);
		AbstractResponse response = (AbstractResponse) linuxCliService.executeLinuxCmdWithResultJsonObject(url, responseClassType);
		Map<String, T> results = new HashMap<String, T>();
		if (response != null) {
			LOG.debug("statusCode=" + response.getStatusCode());
			if (StatusCode.SUCCESS.equals(StatusCode.parse(response.getStatusCode()))) {
				List<String> stringNames = new ArrayList<String>();
				if (lxdCall.equals(LxdCall.GET_OPERATION)) {
					Map<String, List<String>> responses = (Map<String, List<String>>) response.getMetadata();
					// TODO: Differentiate success, running and failure
					for (List<String> values : responses.values()) {
						stringNames.addAll(values);
					}
				}
				else {
					stringNames = (List<String>) response.getMetadata();
					if (stringNames == null) {
						stringNames = new ArrayList<String>();
					}
				}
				for (String stringName : stringNames) {
					int index = stringName.lastIndexOf("/");
					String id = stringName.substring(index + 1);
					T instance = executeCurlGetCmd(credential, lxdCall, id, containerName);
					if (instance != null) {
						results.put(id, instance);
					}
				}
			}
			else {
				LOG.warn("Invalid Response! response=" + response + " url=" + url);
			}
		}
		return results;
	}

	/**
	 * Execute the curl command to start, stop, create or delete a container
	 * 
	 * @param remoteHostAndPort
	 *            see {@link #getBaseUrl(String)}
	 * @param lxdCall
	 *            the type of operation to perform
	 */
	@Override
	public void executeCurlPostOrPutCmd(LxdServerCredential credential, LxdCall lxdCall, String containerName, String... additionalParams)
			throws IOException, InterruptedException {

		if (lxdCall == null || (!lxdCall.equals(LxdCall.PUT_CONTAINER_STATE)
				&& !lxdCall.equals(LxdCall.POST_CONTAINER_CREATE_LOCAL) 
				&& !lxdCall.equals(LxdCall.POST_CONTAINER_CREATE_REMOTE)
				&& !lxdCall.equals(LxdCall.POST_CONTAINER_DELETE)
				&& !lxdCall.equals(LxdCall.POST_IMAGEALIAS_CREATE)
				&& !lxdCall.equals(LxdCall.POST_IMAGEALIAS_DELETE)
				&& !lxdCall.equals(LxdCall.POST_IMAGE_DELETE) 
				&& !lxdCall.equals(LxdCall.POST_CONTAINER_RENAME))) {
			throw new IOException("This call is not implemented! " + lxdCall);
		}

		String url = getBaseUrl(credential) + lxdCall.getCommand();
		url = getParameterisedUrl(url, containerName);
		if ((lxdCall.equals(LxdCall.POST_CONTAINER_RENAME)) && additionalParams.length > 0) {
			url = url.replace("${NEWNAME}", additionalParams[0]);
		}
		else if ((lxdCall.equals(LxdCall.POST_IMAGEALIAS_CREATE)) && additionalParams.length > 0) {
			url = url.replace("${NEWNAME}", containerName);
			url = url.replace("${FINGERPRINT}", additionalParams[0]);
			if (additionalParams.length > 1) {
				url = url.replace("${DESCRIPTION}", additionalParams[1]);
			}
			url = url.replace("${DESCRIPTION}", StringUtils.EMPTY);
		}
		else if (lxdCall.equals(LxdCall.PUT_CONTAINER_STATE) && additionalParams.length > 0) {
			url = url.replace("${ACTION}", additionalParams[0]);
			boolean force = false;
			boolean stateful = false;
			String timeout = "";
			if (additionalParams.length > 1) {
				force = Boolean.parseBoolean(additionalParams[1]);
			}
			url = url.replace("${FORCE}", String.valueOf(force));
			if (additionalParams.length > 2) {
				stateful = Boolean.parseBoolean(additionalParams[2]);
			}
			url = url.replace("${STATEFUL}", String.valueOf(stateful));
			if (StringUtils.isNotBlank(timeout)) {
				url = url.replace("${TIMEOUT}", "\"timeout\": "+timeout+", ");
			}
			url = url.replace("${TIMEOUT}", StringUtils.EMPTY);
		}

		LOG.debug("url=" + url);
		AbstractResponse response = linuxCliService.executeLinuxCmdWithResultJsonObject(url, lxdCall.getClassType());
		LOG.info("repsonse=" + response);
		if (response != null) {
			LOG.debug("statusCode=" + response.getStatusCode());
			if (StatusCode.OPERATION_CREATED.equals(StatusCode.parse(response.getStatusCode()))) {
				return;
			}
		}
	}

	@Override
	public void executeCurlPostOrPutCmdForExec(LxdServerCredential credential, LxdCall lxdCall,
			String containerName, String[] commandAndArgs, String env, Boolean waitForSocket) throws IOException, InterruptedException {

		if (lxdCall == null || !lxdCall.equals(LxdCall.POST_CONTAINER_EXEC)) {
			throw new IOException("This call is not implemented! " + lxdCall);
		}

		String url = getBaseUrl(credential) + lxdCall.getCommand();
		url = getParameterisedUrl(url, containerName);
		url = url.replace("${CMD}", StringUtils.join(commandAndArgs, ","));
		url = url.replace("${ENV}", env != null ? env : StringUtils.EMPTY);
		url = url.replace("${WAIT}", waitForSocket != null ? waitForSocket.toString() : Boolean.FALSE.toString());
		LOG.debug("url=" + url);
		AbstractResponse response = linuxCliService.executeLinuxCmdWithResultJsonObject(url, lxdCall.getClassType());
		LOG.info("repsonse=" + response);
		if (response != null) {
			LOG.debug("statusCode=" + response.getStatusCode());
			if (StatusCode.OPERATION_CREATED.equals(StatusCode.parse(response.getStatusCode()))) {
				return;
			}
		}
	}

	@Override
	public void executeCurlPostOrPutCmdForSnapshot(LxdServerCredential credential, LxdCall lxdCall,
			String containerName, String snapshotName, String... additionalParams) throws IOException, InterruptedException {

		if (lxdCall == null || (!lxdCall.equals(LxdCall.POST_SNAPSHOT_CREATE) && !lxdCall.equals(LxdCall.POST_SNAPSHOT_DELETE) &&
				!lxdCall.equals(LxdCall.POST_SNAPSHOT_RENAME))) {
			throw new IOException("This call is not implemented! " + lxdCall);
		}

		String url = getBaseUrl(credential) + lxdCall.getCommand();
		url = getParameterisedUrl(url, containerName);
		url = url.replace("${SNAPNAME}", snapshotName);
//		For boolean as expected from curl you cant pass into url
//		url = url.replace("${STATEFUL}", stateful);
		if (lxdCall.equals(LxdCall.POST_SNAPSHOT_RENAME) && additionalParams.length > 0) {
			url = url.replace("${NEWNAME}", additionalParams[0]);
		}
		LOG.debug("url=" + url);
		AbstractResponse response = linuxCliService.executeLinuxCmdWithResultJsonObject(url, lxdCall.getClassType());
		LOG.info("repsonse=" + response);
		if (response != null) {
			LOG.debug("statusCode=" + response.getStatusCode());
			if (StatusCode.OPERATION_CREATED.equals(StatusCode.parse(response.getStatusCode()))) {
				return;
			}
		}
	}

	/**
	 * Execute the curl command to start, stop, create or delete a container
	 * 
	 * @param remoteHostAndPort
	 *            see {@link #getBaseUrl(String)}
	 * @param lxdCall
	 *            the type of operation to perform
	 */
	@Override
	public void executeCurlPostCmdToCreateNewContainerFromImage(LxdServerCredential credential, LxdCall lxdCall, RemoteServer remoteServer,
			String containerName, String imageAlias) throws IOException, InterruptedException {
		executeCurlPostCmdToCreateNewContainerFromImage(credential, lxdCall, remoteServer, containerName, imageAlias, null);
	}

	@Override
	public void executeCurlPostCmdToCreateNewContainerFromImage(LxdServerCredential credential, LxdCall lxdCall, RemoteServer remoteServer, String containerName, String imageAlias, ImageConfig imageConfig)
			throws IOException, InterruptedException {
		if (remoteServer == null) {
			throw new IOException("Cannot create a container without a remoteServer.");
		}
		String url = getBaseUrl(credential) + lxdCall.getCommand();
		url = getParameterisedUrl(url, containerName);
		url = url.replace("${ALIAS}", imageAlias);
		url = url.replace("${PROTOCOL}", remoteServer.getProtocol());
		url = url.replace("${SERVERURL}", remoteServer.getUrl());
		if (imageConfig != null) {
			Boolean ephemeral = imageConfig.getEphemeral();
			if (ephemeral != null) {
				url = url.replace("${EPHEMERAL}", "\"ephemeral\": " + String.valueOf(ephemeral) + ", ");
			}
			String architecture = imageConfig.getArchitecture();
			if (StringUtils.isNotBlank(architecture)) {
				url = url.replace("${ARCHITECTURE}", "\"architecture\": \"" + architecture + "\", ");
			}
			Collection<String> profiles = imageConfig.getProfiles();
			if (profiles != null && !profiles.isEmpty()) {
				StringBuilder profileValue = new StringBuilder();
				for (String profile : profiles) {
					if (profileValue.length() > 0) {
						profileValue.append(",");
					}
					profileValue.append("\"").append(profile).append("\"");
				}
				url = url.replace("${PROFILES}", "\"profile\": [" + profileValue.toString() + "], ");
			}
			String config = imageConfig.getConfig();
			if (StringUtils.isNotBlank(config)) {
				url = url.replace("${CONFIG}", "\"config\": \"" + config + "\", ");
			}
		}
		url = url.replace("${CONFIG}", StringUtils.EMPTY);
		url = url.replace("${PROFILES}", StringUtils.EMPTY);
		url = url.replace("${EPHEMERAL}", StringUtils.EMPTY);
		url = url.replace("${ARCHITECTURE}", StringUtils.EMPTY);
		
		LOG.debug("url=" + url);
		AbstractResponse response = linuxCliService.executeLinuxCmdWithResultJsonObject(url, lxdCall.getClassType());
		LOG.info("repsonse=" + response);
		if (response != null) {
			LOG.debug("statusCode=" + response.getStatusCode());
			if (StatusCode.OPERATION_CREATED.equals(StatusCode.parse(response.getStatusCode()))) {
				return;
			}
		}
	}

	@Override
	public void executeCurlPostCmdToCopyContainer(LxdServerCredential credential, String existingContainerName,
			String newContainerName, Boolean containerOnly) throws IOException, InterruptedException {

		LxdCall lxdCall = LxdCall.POST_CONTAINER_COPY;
		String url = getBaseUrl(credential) + lxdCall.getCommand();
		url = getParameterisedUrl(url, newContainerName);
		url = url.replace("${CONTAINERONLY}", containerOnly == null ? Boolean.TRUE.toString() : containerOnly.toString().toLowerCase());
		url = url.replace("${CONTAINER}", existingContainerName);

		LOG.debug("url=" + url);
		AbstractResponse response = linuxCliService.executeLinuxCmdWithResultJsonObject(url, lxdCall.getClassType());
		LOG.info("repsonse=" + response);
		if (response != null) {
			LOG.debug("statusCode=" + response.getStatusCode());
			if (StatusCode.OPERATION_CREATED.equals(StatusCode.parse(response.getStatusCode()))) {
				return;
			}
		}
	}

	/**
	 * Perform a replace all on the url replacing ${ID}.
	 * 
	 * @param url
	 *            the url string
	 * @param id
	 *            the id replacement value
	 * @return the parameterised url
	 */
	@Override
	public String getParameterisedUrl(String url, String id) {
		url = url.replace("${ID}", id != null ? id : StringUtils.EMPTY);
		return url;
	}

	/**
	 * The default base url is {@link #CURL_URL_BASE_LOCAL}, but if
	 * remoteHostAndPort is provided will use the base url
	 * {@link #CURL_URL_BASE_REMOTE}
	 * 
	 * @param remoteHostAndPort
	 *            format should be <host>:<port>, if no port provided will default
	 *            to 8443
	 * @param keypath format "~/path/cert.crt|~/path/cert.key", pipe separated certificate and key to be used for the remoteHostAndPort
	 * 
	 * @return return the base url for curl calls
	 */
	@Override
	public String getBaseUrl(LxdServerCredential credential) {
		String url = CURL_URL_BASE_LOCAL;
		if (credential != null && StringUtils.isNotBlank(credential.getRemoteHostAndPort())) {
			String remoteHostAndPort = credential.getRemoteHostAndPort();
			if (!remoteHostAndPort.contains(":")) {
				remoteHostAndPort += ":8443";
			}
			url = CURL_URL_BASE_REMOTE.replace("${HOSTANDPORT}", remoteHostAndPort);
			if (StringUtils.isNotBlank(credential.getRemoteCert())) {
				url = url.replace("${KEYPATHCERT}", "--cert " + credential.getRemoteCert());
			}
			else {
				url = url.replace("${KEYPATHCERT}", StringUtils.EMPTY);
			}
			if (StringUtils.isNotBlank(credential.getRemoteKey())) {
				url = url.replace("${KEYPATHKEY}", "--key " + credential.getRemoteKey());
			}
			else {
				url = url.replace("${KEYPATHKEY}", StringUtils.EMPTY);
			}

		}
		return url;
	}

	@Override
	@Inject
	public void setLinuxCliService(ILinuxCliService linuxCliService) {
		this.linuxCliService = linuxCliService;
	}
}

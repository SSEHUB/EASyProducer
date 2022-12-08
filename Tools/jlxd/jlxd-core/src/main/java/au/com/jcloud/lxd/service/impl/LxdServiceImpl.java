package au.com.jcloud.lxd.service.impl;

import static au.com.jcloud.lxd.LxdConstants.COLON;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import au.com.jcloud.lxd.bean.ImageConfig;
import au.com.jcloud.lxd.bean.LxdServerCredential;
import au.com.jcloud.lxd.enums.ContainerStateAction;
import au.com.jcloud.lxd.enums.LxdCall;
import au.com.jcloud.lxd.enums.RemoteServer;
import au.com.jcloud.lxd.model.Certificate;
import au.com.jcloud.lxd.model.Container;
import au.com.jcloud.lxd.model.Image;
import au.com.jcloud.lxd.model.ImageAlias;
import au.com.jcloud.lxd.model.Network;
import au.com.jcloud.lxd.model.Operation;
import au.com.jcloud.lxd.model.Profile;
import au.com.jcloud.lxd.model.ServerInfo;
import au.com.jcloud.lxd.model.Snapshot;
import au.com.jcloud.lxd.model.State;
import au.com.jcloud.lxd.service.ILxdApiService;
import au.com.jcloud.lxd.service.ILxdService;

/**
 * Created by david.vittor on 12/07/16.
 */
@Named
public class LxdServiceImpl implements ILxdService {

	private static final Logger LOG = Logger.getLogger(LxdServiceImpl.class);

	protected LxdServerCredential credential;

	protected ILxdApiService lxdApiService;

	@Override
	public ILxdService clone() throws CloneNotSupportedException {
		LxdServiceImpl newService = new LxdServiceImpl();
		newService.setLxdApiService(lxdApiService);
		return newService;
	}

	// ** ServerInfo **//
	@Override
	public ServerInfo loadServerInfo() throws IOException, InterruptedException {
		ServerInfo serverInfo = lxdApiService.executeCurlGetCmd(credential, LxdCall.GET_SERVERINFO, null);
		return serverInfo;
	}

	// ** Containers **//
	@Override
	public Map<String, Container> loadContainerMap() throws IOException, InterruptedException {
		Map<String, Container> containers = lxdApiService.executeCurlGetListCmd(credential, LxdCall.GET_CONTAINER);
		return containers;
	}

	@Override
	public Container loadContainer(String name) throws IOException, InterruptedException {
		Container container = lxdApiService.executeCurlGetCmd(credential, LxdCall.GET_CONTAINER, name);
		return container;
	}

	@Override
	public State loadContainerState(String name) throws IOException, InterruptedException {
		Container container = loadContainer(name);
		if (container != null) {
			State state = lxdApiService.executeCurlGetCmd(credential, LxdCall.GET_STATE, name);
			return state;
		}
		return null;
	}

	// ** Images **//
	@Override
	public Map<String, Image> loadImageMap() throws IOException, InterruptedException {
		Map<String, Image> images = lxdApiService.executeCurlGetListCmd(credential, LxdCall.GET_IMAGE);
		Map<String, Image> imageAliasMap = new HashMap<>();
		for (Image image : images.values()) {
			LOG.debug("image=" + image);
			// Add all aliases to the map
			for (ImageAlias alias : image.getAliases()) {
				LOG.debug("alias=" + alias.getName());
				imageAliasMap.put(alias.getName(), image);
			}
			// Add fingerprint to the map
			if (image.getFingerprint() != null && image.getFingerprint().length() > 12) {
				imageAliasMap.put(image.getFingerprint().substring(0, 12), image);
			}
		}
		images.putAll(imageAliasMap);
		return images;
	}

	@Override
	public Image loadImage(String nameOrId) throws IOException, InterruptedException {
		Image image = lxdApiService.executeCurlGetCmd(credential, LxdCall.GET_IMAGE, nameOrId);
		return image;
	}

	@Override
	public void deleteImage(String imageNameOrId) throws IOException, InterruptedException {
		Image image = loadImage(imageNameOrId);
		if (image == null) {
			throw new IllegalArgumentException("Cannot find image with name or id: " + imageNameOrId);
		}
		lxdApiService.executeCurlPostOrPutCmd(credential, LxdCall.POST_IMAGE_DELETE, image.getFingerprint());
	}

	// ** Container operations **//
	@Override
	public void changeContainerState(String name, ContainerStateAction action, boolean force, boolean stateful, String timeout) throws IOException, InterruptedException {
		State state = loadContainerState(name);
		if (state == null) {
			throw new IllegalArgumentException("container: " + name + " has state null");
		}
		if (state.isRunning() && action.equals(ContainerStateAction.START)) {
			throw new IllegalArgumentException("container: " + name + " has is already running");
		}
		else if (!state.isRunning() && (action.equals(ContainerStateAction.STOP) || action.equals(ContainerStateAction.FREEZE) || action.equals(ContainerStateAction.RESTART))) {
			throw new IllegalArgumentException("container: " + name + " is not running");
		}
		else if (!state.isFrozen() && action.equals(ContainerStateAction.UNFREEZE)) {
			throw new IllegalArgumentException("container: " + name + " is not frozen");
		}
		lxdApiService.executeCurlPostOrPutCmd(credential, LxdCall.PUT_CONTAINER_STATE, name, action.name().toLowerCase(), String.valueOf(force), String.valueOf(stateful), timeout);
	}
	
	@Override
	public void startContainer(String name) throws IOException, InterruptedException {
		changeContainerState(name, ContainerStateAction.START, false, false, null);
	}

	@Override
	public void stopContainer(String name) throws IOException, InterruptedException {
		changeContainerState(name, ContainerStateAction.STOP, true, false, null);
	}
	

	@Override
	public void createContainer(String newContainerName, String imageAlias) throws IOException, InterruptedException {
		createContainer(newContainerName, imageAlias, null);
	}

	@Override
	public void createContainer(String newContainerName, String imageAlias, ImageConfig imageConfig) throws IOException, InterruptedException {
		if (StringUtils.isBlank(imageAlias)) {
			throw new IllegalArgumentException("Cannot create container where imageAlias is blank");
		}
		if (StringUtils.isBlank(newContainerName)) {
			throw new IllegalArgumentException("Cannot create container where newContainerName is blank");
		}
		if (!imageAlias.contains(COLON)) {
			Image image = loadImage(imageAlias);
			if (image == null) {
				throw new IOException("Could not find local image with alias: " + imageAlias);
			}
			lxdApiService.executeCurlPostCmdToCreateNewContainerFromImage(credential, LxdCall.POST_CONTAINER_CREATE_LOCAL, RemoteServer.LOCAL, newContainerName, image.getFingerprint(), imageConfig);
		}
		else {
			boolean found = false;
			for (RemoteServer remoteServer : RemoteServer.values()) {
				if (remoteServer != RemoteServer.LOCAL && imageAlias.startsWith(remoteServer.getName() + COLON)) {
					imageAlias = imageAlias.substring((remoteServer.getName() + COLON).length());
					lxdApiService.executeCurlPostCmdToCreateNewContainerFromImage(credential, LxdCall.POST_CONTAINER_CREATE_REMOTE, remoteServer, newContainerName, imageAlias, imageConfig);
					System.out.println(remoteServer.getUrl());
					found = true;
					break;
				}
			}
			if (!found) {
				throw new IOException("Could not find remote image server: " + imageAlias);
			}
		}
	}

	@Override
	public void deleteContainer(String name) throws IOException, InterruptedException {
		State state = loadContainerState(name);
		if (state == null) {
			throw new IllegalArgumentException("Cannot find a valid state for container name: " + name);
		}

		if (!state.isStopped()) {
			throw new IOException("Cannot delete a container that is not stopped. Container=" + name + " status=" + state);
		}
		lxdApiService.executeCurlPostOrPutCmd(credential, LxdCall.POST_CONTAINER_DELETE, name);
	}

	@Override
	public void renameContainer(String name, String newContainerName) throws IOException, InterruptedException {
		if (StringUtils.isBlank(name)) {
			throw new IllegalArgumentException("Cannot rename container where name is blank");
		}
		if (StringUtils.isBlank(newContainerName)) {
			throw new IllegalArgumentException("Cannot rename container where newContainerName is blank");
		}
		lxdApiService.executeCurlPostOrPutCmd(credential, LxdCall.POST_CONTAINER_RENAME, name, newContainerName);
		Container container = loadContainerMap().remove(name);
		if (container != null) {
			loadContainerMap().put(newContainerName, container);
		}
	}

	@Override
	public void copyContainer(String name, String newContainerName, Boolean containerOnly) throws IOException, InterruptedException {
		if (StringUtils.isBlank(name)) {
			throw new IllegalArgumentException("Cannot copy container where name is blank");
		}
		if (StringUtils.isBlank(newContainerName)) {
			throw new IllegalArgumentException("Cannot copy container where newContainerName is blank");
		}

		Container container = loadContainer(name);
		if (container == null) {
			throw new IOException("Could not find existing container with name: " + name);
		}
		lxdApiService.executeCurlPostCmdToCopyContainer(credential, name, newContainerName, containerOnly);
	}

	@Override
	public void execOnContainer(String name, String[] commandAndArgs, String env, Boolean waitForSocket)
			throws IOException, InterruptedException {
		if (StringUtils.isBlank(name)) {
			throw new IllegalArgumentException("Cannot execute command where containerName is blank");
		}
		if (commandAndArgs == null || commandAndArgs.length == 0) {
			throw new IllegalArgumentException("Cannot execute empty command on container: " + name);
		}

		Container container = loadContainer(name);
		if (container == null) {
			throw new IOException("Could not find container with name: " + name);
		}
		lxdApiService.executeCurlPostOrPutCmdForExec(credential, LxdCall.POST_CONTAINER_EXEC, name, commandAndArgs, env, waitForSocket);
	}

	// ** Operations **//
	@Override
	public Map<String, Operation> loadOperationMap() throws IOException, InterruptedException {
		Map<String, Operation> opertaions = lxdApiService.executeCurlGetListCmd(credential, LxdCall.GET_OPERATION);
		return opertaions;
	}

	@Override
	public Operation loadOperation(String name) throws IOException, InterruptedException {
		Operation opertaion = lxdApiService.executeCurlGetCmd(credential, LxdCall.GET_OPERATION, name);
		return opertaion;
	}

	// ** Networks **//
	@Override
	public Map<String, Network> loadNetworkMap() throws IOException, InterruptedException {
		Map<String, Network> networks = lxdApiService.executeCurlGetListCmd(credential, LxdCall.GET_NETWORK);
		return networks;
	}

	@Override
	public Network loadNetwork(String name) throws IOException, InterruptedException {
		Network network = lxdApiService.executeCurlGetCmd(credential, LxdCall.GET_IMAGE, name);
		return network;
	}

	@Override
	public List<Container> loadContainersUsedByNetwork(Network network) throws IOException, InterruptedException {
		List<Container> usedByContainers = new ArrayList<Container>();
		String[] usedByArray = network.getMetadata().getUsedBy();
		for (String usedByString : usedByArray) {
			String containerName = usedByString.substring(usedByString.lastIndexOf("/"));
			Container container = loadContainer(containerName);
			usedByContainers.add(container);
		}
		return usedByContainers;
	}

	@Override
	public void deleteNetwork(String name) throws IOException, InterruptedException {
		if (StringUtils.isBlank(name)) {
			throw new IllegalArgumentException("Cannot delete a network with an empty name");
		}
		Network network = loadNetwork(name);
		if (network == null) {
			throw new IllegalArgumentException("Cannot find a network with name: " + name);
		}
		lxdApiService.executeCurlPostOrPutCmd(credential, LxdCall.POST_NETWORK_DELETE, name);
	}

	// ** Profiles **//
	@Override
	public Map<String, Profile> loadProfileMap() throws IOException, InterruptedException {
		Map<String, Profile> profiles = lxdApiService.executeCurlGetListCmd(credential, LxdCall.GET_PROFILE);
		return profiles;
	}

	@Override
	public Profile loadProfile(String name) throws IOException, InterruptedException {
		Profile profile = lxdApiService.executeCurlGetCmd(credential, LxdCall.GET_PROFILE, name);
		return profile;
	}

	@Override
	public void deleteProfile(String name) throws IOException, InterruptedException {
		if (StringUtils.isBlank(name)) {
			throw new IllegalArgumentException("Cannot delete a profile with an empty name");
		}
		Profile profile = loadProfile(name);
		if (profile == null) {
			throw new IllegalArgumentException("Cannot find a profile with name: " + name);
		}
		lxdApiService.executeCurlPostOrPutCmd(credential, LxdCall.POST_PROFILE_DELETE, name);
	}

	// ** Certificates **//
	@Override
	public Map<String, Certificate> loadCertificateMap() throws IOException, InterruptedException {
		Map<String, Certificate> certificates = lxdApiService.executeCurlGetListCmd(credential, LxdCall.GET_CERTIFICATE);
		return certificates;
	}

	@Override
	public Certificate loadCertificate(String name) throws IOException, InterruptedException {
		Certificate certificate = lxdApiService.executeCurlGetCmd(credential, LxdCall.GET_IMAGE, name);
		return certificate;
	}

	// ** Snapshots **//
	@Override
	public Map<String, Snapshot> loadSnapshotMap(Container container) throws IOException, InterruptedException {
		Map<String, Snapshot> snapshots = lxdApiService.executeCurlGetListCmd(credential, LxdCall.GET_SNAPSHOTS,
				container.getName());
		return snapshots;
	}

	@Override
	public Snapshot loadSnapshot(String containerName, String snapshotName) throws IOException, InterruptedException {
		Snapshot snapshot = lxdApiService.executeCurlGetCmd(credential, LxdCall.GET_SNAPSHOTS, snapshotName, containerName);
		return snapshot;
	}

	@Override
	public void renameSnapshot(String containerName, String snapshotName, String newSnapshotName)
			throws IOException, InterruptedException {
		if (StringUtils.isBlank(containerName)) {
			throw new IllegalArgumentException("Cannot rename snapshot where containerName is blank");
		}
		if (StringUtils.isBlank(snapshotName)) {
			throw new IllegalArgumentException("Cannot rename snapshot where snapshotName is blank");
		}
		if (StringUtils.isBlank(newSnapshotName)) {
			throw new IllegalArgumentException("Cannot rename snapshot where newSnapshotName is blank");
		}
		lxdApiService.executeCurlPostOrPutCmdForSnapshot(credential, LxdCall.POST_CONTAINER_RENAME, containerName, snapshotName,  newSnapshotName);
	}

	@Override
	public void createSnapshot(String containerName, String snapshotName) throws IOException, InterruptedException {
		lxdApiService.executeCurlPostOrPutCmdForSnapshot(credential, LxdCall.POST_SNAPSHOT_CREATE, containerName, snapshotName);
	}

	@Override
	public void deleteSnapshot(String containerName, String snapshotName) throws IOException, InterruptedException {
		lxdApiService.executeCurlPostOrPutCmdForSnapshot(credential, LxdCall.POST_SNAPSHOT_DELETE, containerName, snapshotName);
	}

	// ** Image Aliases **//
	@Override
	public Map<String, ImageAlias> loadImageAliasMap() throws IOException, InterruptedException {
		Map<String, ImageAlias> aliases = lxdApiService.executeCurlGetListCmd(credential, LxdCall.GET_IMAGEALIAS);
		return aliases;
	}

	@Override
	public ImageAlias loadImageAlias(String name) throws IOException, InterruptedException {
		ImageAlias imageAlias = lxdApiService.executeCurlGetCmd(credential, LxdCall.GET_IMAGEALIAS, name);
		return imageAlias;
	}

	@Override
	public void createImageAlias(String aliasName, String targetFingerprint) throws IOException, InterruptedException {
		lxdApiService.executeCurlPostOrPutCmd(credential, LxdCall.POST_IMAGEALIAS_CREATE, aliasName, targetFingerprint);
	}

	@Override
	public void deleteImageAlias(String aliasName) throws IOException, InterruptedException {
		lxdApiService.executeCurlPostOrPutCmd(credential, LxdCall.POST_IMAGEALIAS_DELETE, aliasName);
	}

	@Override
	public void renameImageAlias(String aliasName, String newAliasName) throws IOException, InterruptedException {
		lxdApiService.executeCurlPostOrPutCmd(credential, LxdCall.POST_IMAGEALIAS_RENAME, aliasName, newAliasName);
	}

	// ** File Ops **//
	@Override
	public String loadFile(String containerName, String filepath) throws IOException, InterruptedException {
		String response = lxdApiService.executeCurlGetCmd(credential, LxdCall.GET_FILE, null, containerName, filepath);
		return response;
	}

	@Override
	@Inject
	public void setLxdApiService(ILxdApiService lxdApiService) {
		this.lxdApiService = lxdApiService;
	}

	@Override
	public LxdServerCredential getLxdServerCredential() {
		return credential;
	}

	@Override
	public void setLxdServerCredential(LxdServerCredential credentials) {
		this.credential = credentials;
	}
}

package au.com.jcloud.lxd.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import org.apache.log4j.Logger;

import au.com.jcloud.lxd.bean.ImageConfig;
import au.com.jcloud.lxd.model.Certificate;
import au.com.jcloud.lxd.model.Container;
import au.com.jcloud.lxd.model.Image;
import au.com.jcloud.lxd.model.ImageAlias;
import au.com.jcloud.lxd.model.Network;
import au.com.jcloud.lxd.model.Operation;
import au.com.jcloud.lxd.model.Profile;
import au.com.jcloud.lxd.model.Snapshot;
import au.com.jcloud.lxd.model.State;
import au.com.jcloud.lxd.service.ICachingLxdService;

/**
 * Created by david.vittor on 12/07/16.
 */
@Named
public class CachingLxdServiceImpl extends LxdServiceImpl implements ICachingLxdService {

	private static final Logger LOG = Logger.getLogger(CachingLxdServiceImpl.class);

	private Map<String, Container> containerMap;
	private Map<String, Image> imageMap;
	private Map<String, Operation> operationMap;
	private Map<String, Network> networkMap;
	private Map<String, Profile> profileMap;
	private Map<String, Certificate> certificateMap;
	private Map<String, ImageAlias> imageAliasMap;
	private Map<String, Map<String, Snapshot>> snapshotCache;

	@Override
	public ICachingLxdService clone() throws CloneNotSupportedException {
		CachingLxdServiceImpl newService = new CachingLxdServiceImpl();
		newService.setLxdApiService(lxdApiService);
		return newService;
	}

	// ** Containers **//
	@Override
	public Map<String, Container> getContainerMap() {
		if (containerMap != null && !containerMap.isEmpty()) {
			return containerMap;
		}
		reloadContainerCache();
		return containerMap;
	}

	@Override
	public Container getContainer(String name) {
		Container container = getContainerMap().get(name);
		return container;
	}

	@Override
	public State getContainerState(String name) {
		State state = getContainer(name).getState();
		return state;
	}

	@Override
	public void reloadContainerCache() {
		try {
			containerMap = super.loadContainerMap();
			// Populate container states
			for (Container container : containerMap.values()) {
				container.setState(super.loadContainerState(container.getName()));
			}
		} catch (Exception e) {
			LOG.error(e, e);
			containerMap = new HashMap<>();
		}
	}

	// ** Images **//
	@Override
	public Map<String, Image> getImageMap() {
		if (imageMap != null && !imageMap.isEmpty()) {
			return imageMap;
		}
		reloadImageCache();
		return imageMap;
	}

	@Override
	public Image getImage(String name) {
		Image image = getImageMap().get(name);
		return image;
	}

	@Override
	public void reloadImageCache() {
		try {
			imageMap = super.loadImageMap();
		} catch (Exception e) {
			LOG.error(e, e);
			imageMap = new HashMap<>();
		}
	}

	// ** Container operations **//
	@Override
	public void startContainer(String name) throws IOException, InterruptedException {
		super.startContainer(name);
		reloadContainerCache();
	}

	@Override
	public void stopContainer(String name) throws IOException, InterruptedException {
		super.stopContainer(name);
		reloadContainerCache();
	}

	@Override
	public void createContainer(String newContainerName, String imageAlias, ImageConfig imageConfig) throws IOException, InterruptedException {
		super.createContainer(newContainerName, imageAlias, imageConfig);
		reloadContainerCache();
	}

	@Override
	public void deleteContainer(String name) throws IOException, InterruptedException {
		super.deleteContainer(name);
		reloadContainerCache();
	}

	@Override
	public void renameContainer(String name, String newContainerName) throws IOException, InterruptedException {
		super.renameContainer(name, newContainerName);
		reloadContainerCache();
	}

	@Override
	public void copyContainer(String name, String newContainerName, Boolean containerOnly) throws IOException, InterruptedException {
		super.copyContainer(name, newContainerName, containerOnly);
		reloadContainerCache();
	}

	// ** Operations **//
	@Override
	public Map<String, Operation> getOperationMap() {
		if (operationMap != null && !operationMap.isEmpty()) {
			return operationMap;
		}
		reloadOperationCache();
		return operationMap;
	}

	@Override
	public Operation getOperation(String name) {
		Operation operation = getOperationMap().get(name);
		return operation;
	}

	@Override
	public void reloadOperationCache() {
		try {
			operationMap = super.loadOperationMap();
		} catch (Exception e) {
			LOG.error(e, e);
			operationMap = new HashMap<>();
		}
	}

	// ** Networks **//
	@Override
	public Map<String, Network> getNetworkMap() {
		if (networkMap != null && !networkMap.isEmpty()) {
			return networkMap;
		}
		reloadNetworkCache();
		return networkMap;
	}

	@Override
	public Network getNetwork(String name) {
		Network network = getNetworkMap().get(name);
		return network;
	}

	@Override
	public void reloadNetworkCache() {
		try {
			networkMap = super.loadNetworkMap();
		} catch (Exception e) {
			LOG.error(e, e);
			networkMap = new HashMap<>();
		}
	}

	// ** Profiles **//
	@Override
	public Map<String, Profile> getProfileMap() {
		if (profileMap != null && !profileMap.isEmpty()) {
			return profileMap;
		}
		reloadProfileCache();
		return profileMap;
	}

	@Override
	public Profile getProfile(String name) {
		Profile profile = getProfileMap().get(name);
		return profile;
	}

	@Override
	public void reloadProfileCache() {
		try {
			profileMap = super.loadProfileMap();
		} catch (Exception e) {
			LOG.error(e, e);
			profileMap = new HashMap<>();
		}
	}

	@Override
	public void deleteProfile(String name) throws IOException, InterruptedException {
		super.deleteProfile(name);
		reloadProfileCache();
	}

	// ** Certificates **//
	@Override
	public Map<String, Certificate> getCertificateMap() {
		if (certificateMap != null && !certificateMap.isEmpty()) {
			return certificateMap;
		}
		reloadCertificateCache();
		return certificateMap;
	}

	@Override
	public Certificate getCertificate(String name) {
		Certificate certificate = getCertificateMap().get(name);
		return certificate;
	}

	@Override
	public void reloadCertificateCache() {
		try {
			certificateMap = super.loadCertificateMap();
		} catch (Exception e) {
			LOG.error(e, e);
			certificateMap = new HashMap<>();
		}
	}

	// ** Snapshots **//
	@Override
	public Map<String, Snapshot> getSnapshotMap(Container container) {
		if (snapshotCache != null && !snapshotCache.isEmpty()) {
			snapshotCache = new HashMap<String, Map<String, Snapshot>>();
		}
		Map<String, Snapshot> snapshotMap = snapshotCache.get(container.getName());
		if (snapshotMap != null && !snapshotMap.isEmpty()) {
			return snapshotMap;
		}
		try {
			snapshotMap = super.loadSnapshotMap(container);
		} catch (Exception e) {
			LOG.error(e, e);
			snapshotMap = new HashMap<>();
		}
		snapshotCache.put(container.getName(), snapshotMap);
		return snapshotMap;
	}

	@Override
	public Snapshot getSnapshot(String containerName, String snapshotName) {
		Container container = new Container();
		container.setName(containerName);
		Snapshot snapshot = getSnapshotMap(container).get(snapshotName);
		return snapshot;
	}

	// ** Image Aliases **//
	@Override
	public Map<String, ImageAlias> getImageAliasMap() {
		if (imageAliasMap != null && !imageAliasMap.isEmpty()) {
			return imageAliasMap;
		}
		reloadImageAliasCache();
		return imageAliasMap;
	}

	@Override
	public ImageAlias getImageAlias(String name) {
		ImageAlias imageAlias = getImageAliasMap().get(name);
		return imageAlias;
	}

	@Override
	public void createImageAlias(String aliasName, String targetFingerprint) throws IOException, InterruptedException {
		super.createImageAlias(aliasName, targetFingerprint);
		reloadImageAliasCache();
		reloadImageCache();
	}

	@Override
	public void deleteImageAlias(String aliasName) throws IOException, InterruptedException {
		super.deleteImageAlias(aliasName);
		reloadImageAliasCache();
		reloadImageCache();
	}

	@Override
	public void renameImageAlias(String aliasName, String newAliasName) throws IOException, InterruptedException {
		super.renameImageAlias(aliasName, newAliasName);
		reloadImageAliasCache();
		reloadImageCache();
	}

	@Override
	public void reloadImageAliasCache() {
		try {
			imageAliasMap = super.loadImageAliasMap();
		} catch (Exception e) {
			LOG.error(e, e);
			imageAliasMap = new HashMap<>();
		}
	}
}

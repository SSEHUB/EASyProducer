package au.com.jcloud.lxd.service;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import au.com.jcloud.lxd.bean.ImageConfig;
import au.com.jcloud.lxd.bean.LxdServerCredential;
import au.com.jcloud.lxd.enums.ContainerStateAction;
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

/**
 * Created by david.vittor on 12/07/16.
 */
public interface ILxdService {

	// Clone
	ILxdService clone() throws CloneNotSupportedException;

	// Dependencies
	void setLxdApiService(ILxdApiService lxdApiService);

	// LxdServerCredential
	LxdServerCredential getLxdServerCredential();

	void setLxdServerCredential(LxdServerCredential credentials);

	// ServerInfo
	ServerInfo loadServerInfo() throws IOException, InterruptedException;

	// Containers
	Map<String, Container> loadContainerMap() throws IOException, InterruptedException;

	Container loadContainer(String name) throws IOException, InterruptedException;

	State loadContainerState(String name) throws IOException, InterruptedException;

	// Images
	Map<String, Image> loadImageMap() throws IOException, InterruptedException;

	Image loadImage(String nameOrId) throws IOException, InterruptedException;

	void deleteImage(String nameOrId) throws IOException, InterruptedException;

	// Container operations
	void changeContainerState(String name, ContainerStateAction action, boolean force, boolean stateful, String timeout) throws IOException, InterruptedException;
	
	void startContainer(String name) throws IOException, InterruptedException;

	void stopContainer(String name) throws IOException, InterruptedException;

	void deleteContainer(String name) throws IOException, InterruptedException;

	void createContainer(String newContainerName, String imageAlias) throws IOException, InterruptedException;

	void createContainer(String newContainerName, String imageAlias, ImageConfig imageConfig) throws IOException, InterruptedException;

	void renameContainer(String name, String newContainerName) throws IOException, InterruptedException;

	void copyContainer(String name, String newContainerName, Boolean containerOnly) throws IOException, InterruptedException;

	void execOnContainer(String name, String[] commandAndArgs, String env, Boolean waitForSocket) throws IOException, InterruptedException;

	// Operations
	Map<String, Operation> loadOperationMap() throws IOException, InterruptedException;

	Operation loadOperation(String name) throws IOException, InterruptedException;

	// Networks
	Map<String, Network> loadNetworkMap() throws IOException, InterruptedException;

	Network loadNetwork(String name) throws IOException, InterruptedException;

	Collection<Container> loadContainersUsedByNetwork(Network network) throws IOException, InterruptedException;

	void deleteNetwork(String name) throws IOException, InterruptedException;

	// Profiles
	Map<String, Profile> loadProfileMap() throws IOException, InterruptedException;

	Profile loadProfile(String name) throws IOException, InterruptedException;

	void deleteProfile(String name) throws IOException, InterruptedException;

	// Certificates
	Map<String, Certificate> loadCertificateMap() throws IOException, InterruptedException;

	Certificate loadCertificate(String name) throws IOException, InterruptedException;

	// Snapshots
	Map<String, Snapshot> loadSnapshotMap(Container container) throws IOException, InterruptedException;

	Snapshot loadSnapshot(String containerName, String snapshotName) throws IOException, InterruptedException;

	void renameSnapshot(String containerName, String snapshotName, String newSnapshotName) throws IOException, InterruptedException;

	void createSnapshot(String containerName ,String snapshotName) throws IOException, InterruptedException;

	void deleteSnapshot(String containerName, String snapshotName) throws IOException, InterruptedException;

	// Image Aliases
	Map<String, ImageAlias> loadImageAliasMap() throws IOException, InterruptedException;

	ImageAlias loadImageAlias(String name) throws IOException, InterruptedException;

	void createImageAlias(String aliasName, String targetFingerprint) throws IOException, InterruptedException;

	void deleteImageAlias(String aliasName) throws IOException, InterruptedException;

	void renameImageAlias(String aliasName, String newAliasName) throws IOException, InterruptedException;

	// File Ops
	String loadFile(String containerName, String filepath) throws IOException, InterruptedException;
}

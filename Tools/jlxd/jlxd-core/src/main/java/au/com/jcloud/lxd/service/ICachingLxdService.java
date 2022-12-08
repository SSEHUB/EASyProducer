package au.com.jcloud.lxd.service;

import java.util.Map;

import au.com.jcloud.lxd.model.Certificate;
import au.com.jcloud.lxd.model.Container;
import au.com.jcloud.lxd.model.Image;
import au.com.jcloud.lxd.model.ImageAlias;
import au.com.jcloud.lxd.model.Network;
import au.com.jcloud.lxd.model.Operation;
import au.com.jcloud.lxd.model.Profile;
import au.com.jcloud.lxd.model.Snapshot;
import au.com.jcloud.lxd.model.State;

/**
 * Created by david.vittor on 10/09/17.
 */
public interface ICachingLxdService extends ILxdService {

	// Containers
	void reloadContainerCache();

	Map<String, Container> getContainerMap();

	Container getContainer(String name);

	State getContainerState(String name);

	// Images
	void reloadImageCache();

	Map<String, Image> getImageMap();

	Image getImage(String nameOrId);

	// Operations
	Map<String, Operation> getOperationMap();

	Operation getOperation(String name);
	
	void reloadOperationCache();

	// Networks
	void reloadNetworkCache();

	Map<String, Network> getNetworkMap();

	Network getNetwork(String name);

	// Profiles
	void reloadProfileCache();

	Map<String, Profile> getProfileMap();

	Profile getProfile(String name);

	// Certificates
	void reloadCertificateCache();

	Map<String, Certificate> getCertificateMap();

	Certificate getCertificate(String name);

	// Snapshots
	Map<String, Snapshot> getSnapshotMap(Container container);

	Snapshot getSnapshot(String containerName, String snapshotName);

	// Image Aliases
	void reloadImageAliasCache();

	Map<String, ImageAlias> getImageAliasMap();

	ImageAlias getImageAlias(String name);
}

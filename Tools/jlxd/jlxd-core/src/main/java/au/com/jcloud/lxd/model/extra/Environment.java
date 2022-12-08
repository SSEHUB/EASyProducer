package au.com.jcloud.lxd.model.extra;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * "environment": {
 * "addresses": [
 * "192.168.54.140:8443",
 * "10.212.54.1:8443",
 * "[2001:470:b368:4242::1]:8443"
 * ],
 * "architectures": [
 * "x86_64",
 * "i686"
 * ],
 * "certificate": "BIG PEM BLOB",
 * "driver": "lxc",
 * "driver_version": "2.0.0",
 * "kernel": "Linux",
 * "kernel_architecture": "x86_64",
 * "kernel_version": "4.4.0-18-generic",
 * "server": "lxd",
 * "server_pid": 26227,
 * "server_version": "2.0.0",
 * "storage": "zfs",
 * "storage_version": "5"
 * }
 */
public class Environment {

	private List<String> addresses;
	private List<String> architectures;
	private String certificate;
	private String driver;
	@SerializedName("driver_version")
	private String driverVersion;
	private String kernel;
	@SerializedName("kernel_architecture")
	private String kernelArchitecture;
	@SerializedName("kernel_version")
	private String kernelVersion;
	private String server;
	@SerializedName("server_pid")
	private Integer serverPid;
	@SerializedName("server_version")
	private String serverVersion;
	private String storage;
	@SerializedName("storage_version")
	private String storageVersion;

	@Override
	public String toString() {
		return "Environment [addresses=" + addresses + ", architectures=" + architectures + ", certificate=" + certificate + ", driver=" + driver + ", driverVersion=" + driverVersion + ", kernel=" + kernel + ", kernelArchitecture=" + kernelArchitecture + ", kernelVersion=" + kernelVersion
				+ ", server=" + server + ", serverPid=" + serverPid + ", serverVersion=" + serverVersion + ", storage=" + storage + ", storageVersion=" + storageVersion + "]";
	}

	public List<String> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
	}

	public List<String> getArchitectures() {
		return architectures;
	}

	public void setArchitectures(List<String> architectures) {
		this.architectures = architectures;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getDriverVersion() {
		return driverVersion;
	}

	public void setDriverVersion(String driverVersion) {
		this.driverVersion = driverVersion;
	}

	public String getKernel() {
		return kernel;
	}

	public void setKernel(String kernel) {
		this.kernel = kernel;
	}

	public String getKernelArchitecture() {
		return kernelArchitecture;
	}

	public void setKernelArchitecture(String kernelArchitecture) {
		this.kernelArchitecture = kernelArchitecture;
	}

	public String getKernelVersion() {
		return kernelVersion;
	}

	public void setKernelVersion(String kernelVersion) {
		this.kernelVersion = kernelVersion;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public Integer getServerPid() {
		return serverPid;
	}

	public void setServerPid(Integer serverPid) {
		this.serverPid = serverPid;
	}

	public String getServerVersion() {
		return serverVersion;
	}

	public void setServerVersion(String serverVersion) {
		this.serverVersion = serverVersion;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getStorageVersion() {
		return storageVersion;
	}

	public void setStorageVersion(String storageVersion) {
		this.storageVersion = storageVersion;
	}
}

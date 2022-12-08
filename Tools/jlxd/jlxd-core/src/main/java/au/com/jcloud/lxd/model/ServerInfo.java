package au.com.jcloud.lxd.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import au.com.jcloud.lxd.model.extra.Environment;
import au.com.jcloud.lxd.model.extra.ServerConfig;

/**
 * Created by david.vittor on 19/03/17.
 *
 * {
 * "type": "sync",
 * "status": "Success",
 * "status_code": 200,
 * "metadata": {
 * "api_extensions": [],
 * "api_status": "stable",
 * "api_version": "1.0",
 * "auth": "trusted",
 * "config": {
 * "core.https_address": "[::]:8443",
 * "core.trust_password": true,
 * "storage.zfs_pool_name": "encrypted/lxd"
 * },
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
 * },
 * "public": false
 * }
 */
public class ServerInfo {

	private String name;
	@SerializedName("api_extensions")
	private List<String> apiExtensions;
	@SerializedName("api_status")
	private String apiStatus;
	@SerializedName("api_version")
	private String apiVersion;
	private String auth;
	private ServerConfig config;
	private Environment environment;
	@SerializedName("public")
	private boolean isPublic;

	@Override
	public String toString() {
		return "ServerInfo{" +
				"name='" + name + '\'' +
				", apiExtensions='" + apiExtensions + '\'' +
				", apiStatus='" + apiStatus + '\'' +
				", apiVersion='" + apiVersion + '\'' +
				", auth=" + auth +
				", config=" + config +
				", environment=" + environment +
				", public='" + isPublic + '\'' +
				'}';
	}

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public ServerConfig getConfig() {
		return config;
	}

	public void setConfig(ServerConfig config) {
		this.config = config;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public List<String> getApiExtensions() {
		return apiExtensions;
	}

	public void setApiExtensions(List<String> apiExtensions) {
		this.apiExtensions = apiExtensions;
	}

	public String getApiStatus() {
		return apiStatus;
	}

	public void setApiStatus(String apiStatus) {
		this.apiStatus = apiStatus;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

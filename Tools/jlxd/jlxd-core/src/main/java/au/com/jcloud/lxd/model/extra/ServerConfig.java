package au.com.jcloud.lxd.model.extra;

import com.google.gson.annotations.SerializedName;

/**
 * "config": {
 * "core.https_address": "[::]:8443",
 * "core.trust_password": true,
 * "storage.zfs_pool_name": "encrypted/lxd"
 * }
 */
public class ServerConfig {
	@SerializedName("core.https_address")
	private String httpsAddress;
	@SerializedName("core.trust_password")
	private Boolean trustPassword;
	@SerializedName("storage.zfs_pool_name")
	private String zfsPoolName;

	@Override
	public String toString() {
		return "ServerConfig [httpsAddress=" + httpsAddress + ", trustPassword=" + trustPassword + ", zfsPoolName=" + zfsPoolName + "]";
	}

	public String getHttpsAddress() {
		return httpsAddress;
	}

	public void setHttpsAddress(String httpsAddress) {
		this.httpsAddress = httpsAddress;
	}

	public Boolean getTrustPassword() {
		return trustPassword;
	}

	public void setTrustPassword(Boolean trustPassword) {
		this.trustPassword = trustPassword;
	}

	public String getZfsPoolName() {
		return zfsPoolName;
	}

	public void setZfsPoolName(String zfsPoolName) {
		this.zfsPoolName = zfsPoolName;
	}

}

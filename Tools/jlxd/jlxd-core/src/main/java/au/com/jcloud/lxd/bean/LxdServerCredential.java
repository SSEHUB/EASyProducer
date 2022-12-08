package au.com.jcloud.lxd.bean;

import au.com.jcloud.lxd.LxdConstants;

public class LxdServerCredential {

	private String remoteHostAndPort;
	private String remoteCert;
	private String remoteKey;

	public LxdServerCredential() {
	}

	public LxdServerCredential(String remoteHostAndPort) {
		this.remoteHostAndPort = remoteHostAndPort;
		this.remoteCert = LxdConstants.DEFAULT_FILEPATH_REMOTE_CERT;
		this.remoteKey = LxdConstants.DEFAULT_FILEPATH_REMOTE_KEY;
	}

	public LxdServerCredential(String remoteHostAndPort, String remoteCert, String remoteKey) {
		this.remoteHostAndPort = remoteHostAndPort;
		this.remoteCert = remoteCert;
		this.remoteKey = remoteKey;
	}

	@Override
	public String toString() {
		return "LxdServerCredential [remoteHostAndPort=" + remoteHostAndPort + ", remoteCert=" + remoteCert + ", remoteKey="
				+ remoteKey + "]";
	}

	public String getRemoteHostAndPort() {
		return remoteHostAndPort;
	}

	public void setRemoteHostAndPort(String remoteHostAndPort) {
		this.remoteHostAndPort = remoteHostAndPort;
	}

	public String getRemoteCert() {
		return remoteCert;
	}

	public void setRemoteCert(String remoteCert) {
		this.remoteCert = remoteCert;
	}

	public String getRemoteKey() {
		return remoteKey;
	}

	public void setRemoteKey(String remoteKey) {
		this.remoteKey = remoteKey;
	}
}

package au.com.jcloud.lxd.model.response;

import au.com.jcloud.lxd.model.ServerInfo;

/**
 * Created by david.vittor on 19/03/17.
 */
public class ServerInfoResponse extends AbstractResponse {
	private ServerInfo metadata;

	@Override
	public ServerInfo getMetadata() {
		return metadata;
	}

	public void setMetadata(ServerInfo metadata) {
		this.metadata = metadata;
	}
}

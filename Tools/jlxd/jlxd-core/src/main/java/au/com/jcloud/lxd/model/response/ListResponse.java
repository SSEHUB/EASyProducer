package au.com.jcloud.lxd.model.response;

import java.util.List;

/**
 * Created by david.vittor on 12/07/16.
 */
public class ListResponse extends AbstractResponse {
	private List<String> metadata;

	@Override
	public List<String> getMetadata() {
		return metadata;
	}

	public void setMetadata(List<String> metadata) {
		this.metadata = metadata;
	}

}

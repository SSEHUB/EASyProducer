package au.com.jcloud.lxd.model.response;

import java.util.List;
import java.util.Map;

/**
 * Created by david.vittor on 12/07/16.
 */
public class ListOperationResponse extends AbstractResponse {
	private Map<String,List<String>> metadata;

	@Override
	public Map<String,List<String>> getMetadata() {
		return metadata;
	}

	public void setMetadata(Map<String,List<String>> metadata) {
		this.metadata = metadata;
	}

}

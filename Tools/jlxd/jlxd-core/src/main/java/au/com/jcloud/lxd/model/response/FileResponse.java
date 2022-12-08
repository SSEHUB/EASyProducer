package au.com.jcloud.lxd.model.response;

/**
 * Created by david.vittor on 19/03/17.
 */
public class FileResponse extends AbstractResponse {
	private String metadata;

	@Override
	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}
}

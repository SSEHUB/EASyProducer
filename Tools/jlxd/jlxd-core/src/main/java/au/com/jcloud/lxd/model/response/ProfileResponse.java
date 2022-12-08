package au.com.jcloud.lxd.model.response;

import au.com.jcloud.lxd.model.Profile;

/**
 * Created by david on 29/07/16.
 */
public class ProfileResponse extends AbstractResponse {
    private Profile metadata;

    @Override
    public Profile getMetadata() {
        return metadata;
    }

    public void setMetadata(Profile metadata) {
        this.metadata = metadata;
    }
}

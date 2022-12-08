package au.com.jcloud.lxd.model.response;

import au.com.jcloud.lxd.model.Network;

/**
 * Created by david on 29/07/16.
 */
public class NetworkResponse extends AbstractResponse {
    private Network metadata;

    @Override
    public Network getMetadata() {
        return metadata;
    }

    public void setMetadata(Network metadata) {
        this.metadata = metadata;
    }
}

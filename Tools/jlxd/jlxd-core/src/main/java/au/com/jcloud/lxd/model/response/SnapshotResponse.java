package au.com.jcloud.lxd.model.response;

import au.com.jcloud.lxd.model.Snapshot;

/**
 * Created by david.vittor on 31/07/16.
 */
public class SnapshotResponse extends AbstractResponse {
    private Snapshot metadata;

    @Override
    public Snapshot getMetadata() {
        return metadata;
    }

    public void setMetadata(Snapshot metadata) {
        this.metadata = metadata;
    }
}

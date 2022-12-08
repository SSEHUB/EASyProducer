package au.com.jcloud.lxd.model.response;

import au.com.jcloud.lxd.model.ImageAlias;

/**
 * Created by david.vittor on 31/07/16.
 */
public class ImageAliasResponse extends AbstractResponse {
    private ImageAlias metadata;

    public ImageAlias getMetadata() {
        return metadata;
    }

    public void setMetadata(ImageAlias metadata) {
        this.metadata = metadata;
    }
}

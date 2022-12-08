package au.com.jcloud.lxd.model.response;

import au.com.jcloud.lxd.model.Certificate;
import au.com.jcloud.lxd.model.Profile;

/**
 * Created by david on 29/07/16.
 */
public class CertificateResponse extends AbstractResponse {
    private Certificate metadata;

    @Override
    public Certificate getMetadata() {
        return metadata;
    }

    public void setMetadata(Certificate metadata) {
        this.metadata = metadata;
    }
}

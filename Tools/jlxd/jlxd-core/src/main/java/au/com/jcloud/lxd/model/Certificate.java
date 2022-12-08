package au.com.jcloud.lxd.model;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Created by david.vitor on 29/07/16.
 *
 {
 "type": "sync",
 "status": "Success",
 "status_code": 200,
 "metadata": {
 "certificate": "-----BEGIN CERTIFICATE-----\nABC...XYZ\n-----END CERTIFICATE-----\n",
 "fingerprint": "5739bc631fb49b0f1274c906d09053c4894841dde007e8003141ae2aa76ef235",
 "type": "client"
 }
 }
 */
public class Certificate {
    private String type;
    private String status;
    @SerializedName("status_code")
    private String statusCode;
    private CertificateMetaData metadata;

    public class CertificateMetaData {
        private String type;
        private String fingerprint;
        private String certificate;

        @Override
        public String toString() {
            return "CertificateMetaData{" +
                    "type='" + type + '\'' +
                    ", fingerprint='" + fingerprint + '\'' +
                    ", certificate='" + certificate + '\'' +
                    '}';
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getFingerprint() {
            return fingerprint;
        }

        public void setFingerprint(String fingerprint) {
            this.fingerprint = fingerprint;
        }

        public String getCertificate() {
            return certificate;
        }

        public void setCertificate(String certificate) {
            this.certificate = certificate;
        }
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", metadata=" + metadata +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public CertificateMetaData getMetadata() {
        return metadata;
    }

    public void setMetadata(CertificateMetaData metadata) {
        this.metadata = metadata;
    }

}

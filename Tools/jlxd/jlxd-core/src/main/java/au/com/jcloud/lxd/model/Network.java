package au.com.jcloud.lxd.model;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by david.vittor on 29/07/16.
 *
 {
 "type": "sync",
 "status": "Success",
 "status_code": 200,
 "metadata": {
 "name": "lxdbr0",
 "type": "bridge",
 "used_by": [
 "/1.0/containers/alpine",
 "/1.0/containers/confluence",
 "/1.0/containers/jenkins",
 "/1.0/containers/jira",
 "/1.0/containers/jspwiki"
 ]
 }
 }
 */
public class Network {
    private String type;
    private String status;
    @SerializedName("status_code")
    private String statusCode;
    private NetworkMetaData metadata;

    public class NetworkMetaData {
        private String name;
        private String type;
        @SerializedName("used_by")
        private String[] usedBy;

        @Override
        public String toString() {
            return "NetworkMetaData{" +
                    "name='" + name + '\'' +
                    ", type='" + type + '\'' +
                    ", usedBy=" + Arrays.toString(usedBy) +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String[] getUsedBy() {
            return usedBy;
        }

        public void setUsedBy(String[] usedBy) {
            this.usedBy = usedBy;
        }
    }

    @Override
    public String toString() {
        return "Network{" +
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

    public NetworkMetaData getMetadata() {
        return metadata;
    }

    public void setMetadata(NetworkMetaData metadata) {
        this.metadata = metadata;
    }
}

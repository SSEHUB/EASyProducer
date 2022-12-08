package au.com.jcloud.lxd.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by david.vittor on 12/07/16.
 *
 * {
 "type": "async",
 "status": "Operation created",
 "status_code": 100,
 "metadata": {
 "id": "0bee7044-1ede-4100-87eb-d92d078cb1e5",
 "class": "task",
 "created_at": "2016-07-12T22:22:55.340469175+10:00",
 "updated_at": "2016-07-12T22:22:55.340469175+10:00",
 "status": "Running",
 "status_code": 103,
 "resources": {
 "containers": [
 "/1.0/containers/www"
 ]
 },
 "metadata": null,
 "may_cancel": false,
 "err": ""
 },
 "operation": "/1.0/operations/0bee7044-1ede-4100-87eb-d92d078cb1e5"
 }
 */
public class Operation {
    private String id;
    @SerializedName("class")
    private String classType;
    @SerializedName("created_at")
    private String createdDate;
    @SerializedName("updated_at")
    private String updatedDate;
    private String status;
    @SerializedName("status_code")
    private String statusCode;
    private Object resources;
    private Object metadata;

    @Override
    public String toString() {
        return "Operation{" +
                "id='" + id + '\'' +
                ", classType='" + classType + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", updatedDate='" + updatedDate + '\'' +
                ", status='" + status + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", resources='" + resources + '\'' +
                ", metadata='" + metadata + '\'' +
                ", mayCancel='" + mayCancel + '\'' +
                ", err='" + err + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
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

    public Object getResources() {
        return resources;
    }

    public void setResources(Object resources) {
        this.resources = resources;
    }

    public Object getMetadata() {
        return metadata;
    }

    public void setMetadata(Object metadata) {
        this.metadata = metadata;
    }

    public String getMayCancel() {
        return mayCancel;
    }

    public void setMayCancel(String mayCancel) {
        this.mayCancel = mayCancel;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }

    private String mayCancel;
    private String err;


}

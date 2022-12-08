package au.com.jcloud.lxd.model.response;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.annotations.SerializedName;

/**
 * Created by david.vittor on 12/07/16.
 */
public abstract class AbstractResponse {
	private String type;
	private String error;
	@SerializedName("error_code")
	private String errorCode;
	private String status;
	@SerializedName("status_code")
	private String statusCode;

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + ": type=" + type;
		if (StringUtils.isNotBlank(statusCode)) {
			result +=  ", status=" + status + ", statusCode=" + statusCode + ", metadata=" + getMetadata();
		}
		if (StringUtils.isNotBlank(errorCode)) {
			result += ", error=" + error + ", errorCode=" + errorCode;
		}
		return result;
	}

	public abstract Object getMetadata();

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

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}

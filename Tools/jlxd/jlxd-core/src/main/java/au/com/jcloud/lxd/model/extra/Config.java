package au.com.jcloud.lxd.model.extra;

import com.google.gson.annotations.SerializedName;

/**
 * Created by david.vittor on 12/07/16.
 */
public class Config {
	@SerializedName("volatile.base_image")
	private String baseImage;
	@SerializedName("volatile.eth0.hwaddr")
	private String macAddress;
	@SerializedName("volatile.last_state.idmap")
	private String idMap;

	@Override
	public String toString() {
		return "baseImage=" + baseImage + " macAddress=" + macAddress;
	}

	public String getBaseImage() {
		return baseImage;
	}

	public void setBaseImage(String baseImage) {
		this.baseImage = baseImage;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getIdMap() {
		return idMap;
	}

	public void setIdMap(String idMap) {
		this.idMap = idMap;
	}
}

package au.com.jcloud.lxd.bean;

import java.util.Collection;

public class ImageConfig {
	private Boolean ephemeral;
	private String architecture;
	private Collection<String> profiles;
	private String config;

	public ImageConfig() {
	}

	public ImageConfig(Boolean ephemeral, String architecture, Collection<String> profiles, String config) {
		this.ephemeral = ephemeral;
		this.architecture = architecture;
		this.profiles = profiles;
		this.config = config;
	}

	@Override
	public String toString() {
		return "ImageConfig [ephemeral=" + ephemeral + ", architecture=" + architecture + ", profiles=" + profiles + ", config=" + config + "]";
	}

	public Boolean getEphemeral() {
		return ephemeral;
	}

	public void setEphemeral(Boolean ephemeral) {
		this.ephemeral = ephemeral;
	}

	public String getArchitecture() {
		return architecture;
	}

	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}

	public Collection<String> getProfiles() {
		return profiles;
	}

	public void setProfiles(Collection<String> profiles) {
		this.profiles = profiles;
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}
}

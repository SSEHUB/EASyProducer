package au.com.jcloud.lxd.model;

import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Created by david.vittor on 11/07/16.
 */
public class Image {
	private List<ImageAlias> aliases;
	private String fingerprint;
	private boolean publicImage;
	private String description;
	private String architecture;
	private String size;
	private Date createdDate;
	private Date uploadedDate;
	private Date expiresDate;
	private Properties properties;
	private boolean autoupdate;

	public static final String DELIM = "\\|";
	public static final String DATEFORMAT = "xxx"; // TODO

	@Override
	public String toString() {
		return "aliases=" + aliases + " fingerprint=" + fingerprint + " public=" + publicImage + " desc=" + description + " arch=" + architecture + " size=" + size + " uploadedDate=" + uploadedDate;
	}

	public List<ImageAlias> getAliases() {
		return aliases;
	}

	public void setAliases(List<ImageAlias> aliases) {
		this.aliases = aliases;
	}

	public String getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}

	public boolean isPublicImage() {
		return publicImage;
	}

	public void setPublicImage(boolean publicImage) {
		this.publicImage = publicImage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getArchitecture() {
		return architecture;
	}

	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUploadedDate() {
		return uploadedDate;
	}

	public void setUploadedDate(Date uploadedDate) {
		this.uploadedDate = uploadedDate;
	}

	public Date getExpiresDate() {
		return expiresDate;
	}

	public void setExpiresDate(Date expiresDate) {
		this.expiresDate = expiresDate;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public boolean isAutoupdate() {
		return autoupdate;
	}

	public void setAutoupdate(boolean autoupdate) {
		this.autoupdate = autoupdate;
	}
}


package au.com.jcloud.jlxd.ui.bean;

import org.hibernate.validator.constraints.NotBlank;

import au.com.jcloud.lxd.bean.ImageConfig;

public class AddContainerInput extends ImageConfig {

	@NotBlank(message = "new container name can't empty!")
	private String name;

	@NotBlank(message = "imageAlias can't empty!")
	private String imageAlias;

	@Override
	public String toString() {
		return "AddContainerData [name=" + name + ", imageOrAlias=" + imageAlias + " super=" + super.toString() + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageAlias() {
		return imageAlias;
	}

	public void setImageAlias(String imageAlias) {
		this.imageAlias = imageAlias;
	}

}

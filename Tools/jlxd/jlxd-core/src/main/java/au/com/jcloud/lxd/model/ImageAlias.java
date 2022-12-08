package au.com.jcloud.lxd.model;

/**
 * Created by david.vittor on 31/07/16.
 *
 {
 "name": "test",
 "description": "my description",
 "target": "c9b6e738fae75286d52f497415463a8ecc61bbcb046536f220d797b0e500a41f"
 }
 */
public class ImageAlias {
    private String name;
    private String description;
    private String target;

    public ImageAlias name(String name) {
    	this.name = name;
    	return this;
    }
    
    public ImageAlias description(String description) {
    	this.description = description;
    	return this;
    }
    
    public ImageAlias target(String target) {
    	this.target = target;
    	return this;
    }
    @Override
    public String toString() {
        return name + "(" + description + ")";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}

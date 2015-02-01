package data;

import java.io.Serializable;

public class Symbol implements Serializable{
	private String fullname;
	private String shortname;
	private String extension;
	 
	public Symbol(String fullname, String shortname, String extension) {
		super();
		this.fullname = fullname;
		this.shortname = shortname;
		this.extension = extension;
	}
	
	public String getFullname() {
		return fullname;
	}
	
	public String getShortname() {
		return shortname;
	}
	
	public String getExtension() {
		return extension;
	}

    @Override 
	public String toString(){
		return fullname+shortname+extension;
	}

	 
	 
 
}

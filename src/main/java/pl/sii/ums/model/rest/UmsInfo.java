package pl.sii.ums.model.rest;

import lombok.Getter;
import lombok.Setter;

public class UmsInfo {
	
	public UmsInfo() {}
	public UmsInfo(String name, String description, String aboutCompany) {
		this.name = name;
		this.description = description;
		this.aboutCompany = aboutCompany;
	}

	@Getter 
	@Setter
	private String name;

	@Getter 
	@Setter
	private String description;

	@Getter 
	@Setter
	private String aboutCompany;
	
	public String toString() {
		return "name = " + name + " description = " + description + " aboutCompany = " + aboutCompany;
	}
}

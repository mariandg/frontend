package pl.sii.ums.model.rest;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class TimeShitAnnotation {
	
//	public TimeShitAnnotation(String name, double hours) {
//		this.name = name;
//		this.hours = hours;
//	}
	
	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private double hours;
	
	
}

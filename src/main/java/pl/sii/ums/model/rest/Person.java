package pl.sii.ums.model.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
	
	public Person(){}
	public Person(String name, String surname, int age, long pesel){
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.pesel = pesel;
	}
	
	@Getter 
	@Setter
	private String name;

	@Getter 
	@Setter
	private String surname;

	@Getter 
	@Setter
	private int age;

	@Getter 
	@Setter
	private long pesel;

	@Getter 
	@Setter
	private int positionId;
	
	public String toString() {
		return "name = " + name + " surname = " + surname + " age = " + age + " pesel = " + pesel;
	}
}

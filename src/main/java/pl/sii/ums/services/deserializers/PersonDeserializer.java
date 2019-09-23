package pl.sii.ums.services.deserializers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import pl.sii.ums.model.rest.Person;

public class PersonDeserializer extends StdDeserializer<List<Person>>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1649889169699477858L;

	public PersonDeserializer() {
		this(null);
	}
	
	protected PersonDeserializer(Class<List<Person>> vc) {
		super(vc);
	}

	@Override
	public List<Person> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		JsonNode node = p.getCodec().readTree(p);
		List<Person> persons = new ArrayList<Person>();
		String name = "";
		String surname = "";
		int age;
		long pesel;
		for(int i = 0 ; i < node.size(); i++) {
			name = node.get(i).get("name").asText();
			surname = node.get(i).get("surname").asText();
			age = node.get(i).get("age").asInt();
			pesel = node.get(i).get("pesel").asLong();
			persons.add(new Person(name,surname,age,pesel));
		}
		return persons;
	}

}

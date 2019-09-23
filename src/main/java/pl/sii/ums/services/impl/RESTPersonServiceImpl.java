package pl.sii.ums.services.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import pl.sii.ums.model.rest.Person;
import pl.sii.ums.services.RESTService;
import pl.sii.ums.services.deserializers.PersonDeserializer;

@Component
public class RESTPersonServiceImpl implements RESTService{

	@Value("${sii.ums.backend.host}")
	private String backendHost;
	
	private String personsJSON;
	
	private RestTemplate restTemplate = new RestTemplate();

	private SimpleModule module = new SimpleModule();
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public List<Person> getListObjects() {
		
		List<Person> persons = null;		
		personsJSON = restTemplate.getForObject(backendHost + "/persons/all", String.class);
		
		module.addDeserializer(List.class, new PersonDeserializer());
		mapper.registerModule(module);
		
		try {
			persons = mapper.readValue(personsJSON, List.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return persons;
	}

	public Person getSingleObject(long personId) {
		
		Person person = null;
		personsJSON = restTemplate.getForObject(backendHost + "/persons/"+personId, String.class);
		
		module.addDeserializer(List.class, new PersonDeserializer());
		mapper.registerModule(module);
		
		try {
			person = mapper.readValue(personsJSON, Person.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return person;
	}

}

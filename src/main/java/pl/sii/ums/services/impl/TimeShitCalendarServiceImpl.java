package pl.sii.ums.services.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.sii.ums.model.rest.TimeShitCalendar;

@Component
public class TimeShitCalendarServiceImpl {

	@Value("${sii.ums.backend.host}")
	private String backendHost;

	private String timeShitCalendarJSON;

	private RestTemplate restTemplate = new RestTemplate();

	private ObjectMapper mapper = new ObjectMapper();
	
	public TimeShitCalendar getCalendar(int yearNr, int monthNr) {
		
		TimeShitCalendar timeShitCalendar = null;		
		
		timeShitCalendarJSON = restTemplate.getForObject(backendHost + "/timeshitcalendar/year/"+yearNr+"/month/"+monthNr, String.class);
		
		try {
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			System.out.println(timeShitCalendarJSON);
			timeShitCalendar = mapper.readValue(timeShitCalendarJSON, TimeShitCalendar.class);
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
		return timeShitCalendar;
	}
}

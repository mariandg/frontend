package pl.sii.ums.services.impl;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sii.ums.model.rest.UmsInfo;

@Component
public class UmsInfoServiceImpl{

	@Value("${sii.ums.backend.host}")
	private String backendHost;

	private String umsInfoJSON;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	private ObjectMapper mapper = new ObjectMapper();
	
	public UmsInfo getInformationAboutPortal() {
		
		UmsInfo umsInfo = null;		
		
		umsInfoJSON = restTemplate.getForObject(backendHost + "/ums/info", String.class);
		
		try {
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			umsInfo = mapper.readValue(umsInfoJSON, UmsInfo.class);
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
		return umsInfo;
	}
}

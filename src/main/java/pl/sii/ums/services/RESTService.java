package pl.sii.ums.services;

import java.util.List;

public interface RESTService {
	
	public Object getSingleObject(long objectId);
	
	public List<?> getListObjects();
	
}

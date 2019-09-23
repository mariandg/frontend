package pl.sii.ums;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pl.sii.ums.services.impl.RESTPersonServiceImpl;

@SpringBootApplication
public class UserManagementSystemApplication {

	public static void main(String[] args) {
//		RESTPersonServiceImpl service = new RESTPersonServiceImpl();
//		service.getObject();
		SpringApplication.run(UserManagementSystemApplication.class, args);
	}

}

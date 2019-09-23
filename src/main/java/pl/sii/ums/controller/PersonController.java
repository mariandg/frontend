package pl.sii.ums.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import pl.sii.ums.services.impl.RESTPersonServiceImpl;

@Controller
public class PersonController {
	
	@Autowired
	RESTPersonServiceImpl persons;
	
	@GetMapping("/persons/all")
	public String getAllPersons(Model model) {
		model.addAttribute("persons", persons.getListObjects());
		return "persons";
	}
	
	@GetMapping("/persons/{id}")
	public String getPersonById(@PathVariable(value = "id") Long personId, Model model) {
		model.addAttribute("person", persons.getSingleObject(personId));
		return "person";
	}
}

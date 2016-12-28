package com.java2.web.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java2.web.dtos.PersonDto;
import com.java2.web.services.PersonService;

@RestController
@RequestMapping(path = "/users") // 告诉那个路径
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping(path = "getUsers", method = RequestMethod.GET)
	public List<PersonDto> getPersons() {
		return personService.getPersons();
	}
	
	@RequestMapping(path = "postUser", method = RequestMethod.POST)
	public void addPerson(@RequestBody PersonDto person) {
		personService.addPerson(person);
	}
	
	@RequestMapping(path = "deleteUser/{id}", method = RequestMethod.DELETE)
	public void deletePerson(@PathVariable Integer id) {
		personService.deletePerson(id);
	}
	
	@RequestMapping(path = "updateUser", method = RequestMethod.PUT)
	public void uptatePerson(@RequestBody PersonDto person) {
		personService.updatePerson(person);
	}
	
	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
}

package com.java2.web.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java2.web.dtos.PersonDto;
import com.java2.web.exception.MyException;
import com.java2.web.services.PersonService;

@RestController
@RequestMapping(path = "/users") // 告诉那个路径
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<PersonDto> getPersons() {
		return personService.getPersons();
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public PersonDto getPersonById(@PathVariable Integer id) {
		
		
		return personService.getPersonById(id);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public PersonDto addPerson(@RequestBody PersonDto person) {
		return personService.addPerson(person);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void deletePerson(@PathVariable Integer id) {
		personService.deletePerson(id);
	}
	
	@RequestMapping(path = "", method = RequestMethod.PUT)
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

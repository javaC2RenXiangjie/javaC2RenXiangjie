package com.java2.web.services;

import java.util.List;

import com.java2.web.dtos.PersonDto;

public interface PersonService {

	public List<PersonDto> getPersons();
	
	public void addPerson(PersonDto person);
	
	public void deletePerson(Integer id);
	
	public void updatePerson(PersonDto person);
}
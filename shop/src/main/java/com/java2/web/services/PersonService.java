package com.java2.web.services;

import java.util.List;

import com.java2.web.dtos.PersonDto;

public interface PersonService {

	public List<PersonDto> getPersons();
	
	public PersonDto getPersonById(Integer id);
	
	public int addPerson(PersonDto person);
	
	public void deletePerson(Integer id);
	
	public void updatePerson(PersonDto person);

	public boolean isUserCreaditialValid(String userName, String password);
}

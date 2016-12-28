package com.java2.web.repositories;

import java.util.List;

import com.java2.web.entities.PersonEntity;

public interface IPersonRepository {

	public List<PersonEntity> getPersons();

	public PersonEntity getPersonById(Integer id);
	
	public void addPerson( PersonEntity person);
	
	public void deletePerson(Integer id);
	
	public void updatePerson(PersonEntity person);
	
}

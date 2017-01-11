package com.java2.web.repositories;

import java.util.List;

import com.java2.web.entities.PersonEntity;

public interface IPersonRepository {

	public int addPerson(PersonEntity person);

	public void deletePerson(Integer id);

	public int updatePerson(PersonEntity person);

	public PersonEntity getPersonById(Integer id);
	
	public List<PersonEntity> getPersons();
	
	
}

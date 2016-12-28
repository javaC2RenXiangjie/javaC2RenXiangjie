package com.java2.web.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java2.web.dtos.PersonDto;
import com.java2.web.entities.PersonEntity;
import com.java2.web.repositories.IPersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private IPersonRepository iPersonRepository;
	
	public IPersonRepository getiPersonRepository() {
		return iPersonRepository;
	}

	public void setiPersonRepository(IPersonRepository iPersonRepository) {
		this.iPersonRepository = iPersonRepository;
	}

	@Override
	public List<PersonDto> getPersons() {
		List<PersonEntity> personEntity = iPersonRepository.getPersons();
		List<PersonDto> personDto = new ArrayList<PersonDto>();
		for(PersonEntity persEnt: personEntity) {
			PersonDto per = new PersonDto();
			per.setId(persEnt.getId());
			per.setName(persEnt.getName());
			per.setSex(persEnt.getSex());
			personDto.add(per);
		}
		return personDto;
	}
	
	@Transactional
	@Override
	public void addPerson(PersonDto person) {
		PersonEntity personEntity = new PersonEntity();
		personEntity.setName(person.getName());
		personEntity.setSex(person.getSex());
		iPersonRepository.addPerson(personEntity);
	}
	
	@Transactional
	@Override
	public void deletePerson(Integer id) {
		iPersonRepository.deletePerson(id);
	}

	@Transactional
	@Override
	public void updatePerson(PersonDto person) {
		PersonEntity personEntity = iPersonRepository.getPersonById(person.getId());
		personEntity.setName(person.getName());
		personEntity.setSex(person.getSex());
		personEntity.setId(person.getId());
		iPersonRepository.updatePerson(personEntity);
	}
	
}

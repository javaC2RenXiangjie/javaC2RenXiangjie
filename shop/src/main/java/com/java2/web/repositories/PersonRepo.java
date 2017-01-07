package com.java2.web.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.java2.web.entities.PersonEntity;

@Repository
public class PersonRepo implements IPersonRepository{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<PersonEntity> getPersons(){
		return em.createQuery("from PersonEntity",PersonEntity.class).getResultList();
	}
	
	@Override
	public void addPerson(PersonEntity person) {
		em.persist(person);
	}

	@Override
	public void deletePerson(Integer id) {
		em.remove(em.find(PersonEntity.class, id));
	}

	@Override
	public PersonEntity getPersonById(Integer id){
		return em.find(PersonEntity.class, id);
	}

	@Override
	public void updatePerson(PersonEntity person) {
		em.merge(person);
	}
}

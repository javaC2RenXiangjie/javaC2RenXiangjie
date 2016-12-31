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
	
	public List<PersonEntity> getPersons(){
		return em.createQuery("from PersonEntity",PersonEntity.class).getResultList();
	}
	
	public void addPerson( PersonEntity person) {
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
		PersonEntity per = em.find(PersonEntity.class, person.getId());
		per.setName(person.getName());
		per.setSex(person.getSex());
		em.merge(per);
	}
}

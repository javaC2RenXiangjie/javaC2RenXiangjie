package com.java2.web.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.java2.web.entities.AddressEntity;

@Repository
public class AddresssRepo implements IAddressRepository{

	@PersistenceContext
	EntityManager em;
	@Override
	public void deletePersonAddressById(Integer id) {
		em.remove(em.find(AddressEntity.class, id));
	}

	@Override
	public void updatePersonAddress(AddressEntity address) {
		AddressEntity add = em.find(AddressEntity.class , address.getId());
		add.setCountry(address.getCountry());
		add.setCity(address.getCity());
		add.setStreet(address.getStreet());
		em.merge(add);
	}

	@Override
	public void postPersonAddress(AddressEntity addresss) {
		em.persist(addresss);
	}

}

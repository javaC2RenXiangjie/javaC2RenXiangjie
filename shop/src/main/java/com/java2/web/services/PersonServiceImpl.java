package com.java2.web.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java2.web.dtos.AddressDto;
import com.java2.web.dtos.PersonDto;
import com.java2.web.entities.AddressEntity;
import com.java2.web.entities.PersonEntity;
import com.java2.web.repositories.IPersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	IPersonRepository iPersonRepository;

	@Override
	public List<PersonDto> getPersons() {
		List<PersonEntity> personEntity = iPersonRepository.getPersons();
		List<PersonDto> personDto = new ArrayList<PersonDto>();
		for(PersonEntity persEnt: personEntity) {
			PersonDto per = new PersonDto();
			per.setId(persEnt.getId());
			per.setName(persEnt.getName());
			per.setSex(persEnt.getSex());
			List<AddressDto> addresses = new ArrayList<AddressDto>();
			for(int i = 0; i < persEnt.getAddressEntity().size(); i++) {
				AddressDto address = new AddressDto();
				address.setId(persEnt.getAddressEntity().get(i).getId());
				address.setCountry(persEnt.getAddressEntity().get(i).getCountry());
				address.setCity(persEnt.getAddressEntity().get(i).getCity());
				address.setStreet(persEnt.getAddressEntity().get(i).getStreet());
//				address.setPesonId(persEnt.getAddressEntity().get(i));
				addresses.add(address);
			}
			per.setAddresses(addresses);
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
		for(AddressDto ad : person.getAddresses()) {
			AddressEntity ae = new AddressEntity();
			ae.setId(ad.getId());
			ae.setCountry(ad.getCountry());
			ae.setCity(ad.getCity());
			ae.setStreet(ad.getStreet());
		}
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
		PersonEntity personEntity = new PersonEntity();
		personEntity.setName(person.getName());
		personEntity.setSex(person.getSex());
		personEntity.setId(person.getId());
		for(AddressDto ad : person.getAddresses()) {
			AddressEntity ae = new AddressEntity();
			ae.setId(ad.getId());
			ae.setCountry(ad.getCountry());
			ae.setCity(ad.getCity());
			ae.setStreet(ad.getStreet());
			ae.setPerson(personEntity);
			personEntity.getAddressEntity().add(ae);
		}		
		iPersonRepository.updatePerson(personEntity);
	}

	@Override
	public boolean isUserCreaditialValid(String userName, String password) {

		
		
		
		
		
		
		return false;
	}
	
	
}

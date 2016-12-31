package com.java2.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java2.web.dtos.AddressDto;
import com.java2.web.entities.AddressEntity;
import com.java2.web.repositories.IAddressRepository;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private IAddressRepository iAddressRepository;
	public IAddressRepository getiAddressRepository() {
		return iAddressRepository;
	}
	
	public void setiAddressRepository(IAddressRepository iAddressRepository) {
		this.iAddressRepository = iAddressRepository;
	}
	
	@Transactional
	@Override
	public void postPersonAddress(AddressDto address) {
		AddressEntity addressEn = new AddressEntity();
		addressEn.setCountry(address.getCountry());
		addressEn.setCity(address.getCity());
		addressEn.setStreet(address.getStreet());
		iAddressRepository.postPersonAddress(addressEn);
	}

	@Transactional
	@Override
	public void deletePersonAddressById(Integer id) {
		iAddressRepository.deletePersonAddressById(id);
	}

	@Transactional
	@Override
	public void updatePersonAddress(AddressDto address) {
		AddressEntity addressEn = new AddressEntity();
		addressEn.setId(address.getId());
		addressEn.setCountry(address.getCountry());
		addressEn.setCity(address.getCity());
		addressEn.setStreet(address.getStreet());
		iAddressRepository.updatePersonAddress(addressEn);
	}


	
}

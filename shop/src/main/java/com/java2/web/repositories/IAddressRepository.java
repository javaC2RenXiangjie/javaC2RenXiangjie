package com.java2.web.repositories;

import com.java2.web.entities.AddressEntity;

public interface IAddressRepository {

	public void deletePersonAddressById(Integer id);
	
	public void updatePersonAddress(AddressEntity address);
	
	public void postPersonAddress(AddressEntity address);
}

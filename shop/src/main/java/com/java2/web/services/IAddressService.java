package com.java2.web.services;

import com.java2.web.dtos.AddressDto;

public interface IAddressService {

	public void deletePersonAddressById(Integer id);
	
	public void updatePersonAddress(AddressDto address);
	
	public void postPersonAddress(AddressDto address);
}

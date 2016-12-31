package com.java2.web.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java2.web.dtos.AddressDto;
import com.java2.web.services.IAddressService;

@RestController
@RequestMapping(path = "/users/address")
public class AdresssController {

	@Autowired
	private IAddressService addressService;

	@RequestMapping(path = "" , method = RequestMethod.POST)
	public void postPersonAddress(@RequestBody AddressDto address) {
		addressService.postPersonAddress(address);
	}

	@RequestMapping(path = "/{id}" , method = RequestMethod.DELETE)
	public void deletePersonAddressById(@RequestBody Integer id) {
		addressService.deletePersonAddressById(id);
	}
	
	@RequestMapping(path = "/{id}" , method = RequestMethod.PUT)
	public void updatePersonAddress(@RequestBody AddressDto address) {
		addressService.updatePersonAddress(address);
	}
	
	public IAddressService getAddressService() {
		return addressService;
	}

	public void setAddressService(IAddressService addressService) {
		this.addressService = addressService;
	}
	
}

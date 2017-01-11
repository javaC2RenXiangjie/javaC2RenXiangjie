package com.java2.web.dtos;

import java.util.ArrayList;
import java.util.List;

public class PersonDto {

	private Integer id;
	private String name;
	private String sex;
	private List<AddressDto> addresses = new ArrayList<AddressDto>();
	public List<AddressDto> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<AddressDto> addresses) {
		this.addresses = addresses;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}

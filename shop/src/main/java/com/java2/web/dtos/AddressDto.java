package com.java2.web.dtos;

public class AddressDto {

	private Integer id;
	private String country;
	private String city;
	private String street;
	private Integer pesonId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Integer getPesonId() {
		return pesonId;
	}
	public void setPesonId(Integer pesonId) {
		this.pesonId = pesonId;
	}
	
}

package com.java2.web.dtos;

import java.util.List;

public class ProductionDto {

	private Integer id;
	private String name;
	private String description;
	private double originPrice;
	private double price;
	private List<CategoryDto> categoryDto;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getOriginPrice() {
		return originPrice;
	}
	public void setOriginPrice(double originPrice) {
		this.originPrice = originPrice;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public List<CategoryDto> getCategoryDto() {
		return categoryDto;
	}
	public void setCategoryDto(List<CategoryDto> categoryDto) {
		this.categoryDto = categoryDto;
	}
	
}

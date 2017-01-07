package com.java2.web.dtos;

import java.util.ArrayList;
import java.util.List;

public class CategoryDto {

	private Integer id;
	private String name;
	private List<ProductionDto> productionDto = new ArrayList<ProductionDto>();
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
	public List<ProductionDto> getProductionDto() {
		return productionDto;
	}
	public void setProductionDto(List<ProductionDto> productionDto) {
		this.productionDto = productionDto;
	}
}

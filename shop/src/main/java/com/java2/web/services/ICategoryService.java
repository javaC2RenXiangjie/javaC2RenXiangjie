package com.java2.web.services;

import java.util.List;

import com.java2.web.dtos.CategoryDto;

public interface ICategoryService {

	public void addCategory(CategoryDto categoryDto);
	
	public void deleteCategoryById(Integer id);
	
	public void updateCategory(CategoryDto categoryDto);
	
	public List<CategoryDto> getAllCategories();
}
